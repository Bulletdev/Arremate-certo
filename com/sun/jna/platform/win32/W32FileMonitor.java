/*     */ package com.sun.jna.platform.win32;
/*     */ 
/*     */ import com.sun.jna.platform.FileMonitor;
/*     */ import com.sun.jna.ptr.IntByReference;
/*     */ import com.sun.jna.ptr.PointerByReference;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class W32FileMonitor
/*     */   extends FileMonitor
/*     */ {
/*  44 */   private static final Logger LOG = Logger.getLogger(W32FileMonitor.class.getName());
/*     */   private static final int BUFFER_SIZE = 4096;
/*     */   private Thread watcher;
/*     */   private WinNT.HANDLE port;
/*     */   
/*     */   private class FileInfo
/*     */   {
/*     */     public final File file;
/*     */     public final WinNT.HANDLE handle;
/*  53 */     public final WinNT.FILE_NOTIFY_INFORMATION info = new WinNT.FILE_NOTIFY_INFORMATION(4096); public final int notifyMask; public final boolean recursive;
/*  54 */     public final IntByReference infoLength = new IntByReference();
/*  55 */     public final WinBase.OVERLAPPED overlapped = new WinBase.OVERLAPPED();
/*     */     public FileInfo(File param1File, WinNT.HANDLE param1HANDLE, int param1Int, boolean param1Boolean) {
/*  57 */       this.file = param1File;
/*  58 */       this.handle = param1HANDLE;
/*  59 */       this.notifyMask = param1Int;
/*  60 */       this.recursive = param1Boolean;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*  65 */   private final Map<File, FileInfo> fileMap = new HashMap<File, FileInfo>();
/*  66 */   private final Map<WinNT.HANDLE, FileInfo> handleMap = new HashMap<WinNT.HANDLE, FileInfo>(); private boolean disposing = false;
/*     */   private static int watcherThreadID;
/*     */   
/*     */   private void handleChanges(FileInfo paramFileInfo) throws IOException {
/*  70 */     Kernel32 kernel32 = Kernel32.INSTANCE;
/*  71 */     WinNT.FILE_NOTIFY_INFORMATION fILE_NOTIFY_INFORMATION = paramFileInfo.info;
/*     */     
/*  73 */     fILE_NOTIFY_INFORMATION.read();
/*     */     do {
/*  75 */       FileMonitor.FileEvent fileEvent = null;
/*  76 */       File file = new File(paramFileInfo.file, fILE_NOTIFY_INFORMATION.getFilename());
/*  77 */       switch (fILE_NOTIFY_INFORMATION.Action) {
/*     */         case 0:
/*     */           break;
/*     */         case 3:
/*  81 */           fileEvent = new FileMonitor.FileEvent(this, file, 4);
/*     */           break;
/*     */         case 1:
/*  84 */           fileEvent = new FileMonitor.FileEvent(this, file, 1);
/*     */           break;
/*     */         case 2:
/*  87 */           fileEvent = new FileMonitor.FileEvent(this, file, 2);
/*     */           break;
/*     */         case 4:
/*  90 */           fileEvent = new FileMonitor.FileEvent(this, file, 16);
/*     */           break;
/*     */         case 5:
/*  93 */           fileEvent = new FileMonitor.FileEvent(this, file, 32);
/*     */           break;
/*     */         
/*     */         default:
/*  97 */           LOG.log(Level.WARNING, "Unrecognized file action ''{0}''", Integer.valueOf(fILE_NOTIFY_INFORMATION.Action));
/*     */           break;
/*     */       } 
/* 100 */       if (fileEvent != null) {
/* 101 */         notify(fileEvent);
/*     */       }
/*     */       
/* 104 */       fILE_NOTIFY_INFORMATION = fILE_NOTIFY_INFORMATION.next();
/* 105 */     } while (fILE_NOTIFY_INFORMATION != null);
/*     */ 
/*     */     
/* 108 */     if (!paramFileInfo.file.exists()) {
/* 109 */       unwatch(paramFileInfo.file);
/*     */       
/*     */       return;
/*     */     } 
/* 113 */     if (!kernel32.ReadDirectoryChangesW(paramFileInfo.handle, paramFileInfo.info, paramFileInfo.info
/* 114 */         .size(), paramFileInfo.recursive, paramFileInfo.notifyMask, paramFileInfo.infoLength, paramFileInfo.overlapped, null))
/*     */     {
/* 116 */       if (!this.disposing) {
/* 117 */         int i = kernel32.GetLastError();
/* 118 */         throw new IOException("ReadDirectoryChangesW failed on " + paramFileInfo.file + ": '" + 
/*     */             
/* 120 */             Kernel32Util.formatMessageFromLastErrorCode(i) + "' (" + i + ")");
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private FileInfo waitForChange() {
/* 127 */     IntByReference intByReference = new IntByReference();
/* 128 */     BaseTSD.ULONG_PTRByReference uLONG_PTRByReference = new BaseTSD.ULONG_PTRByReference();
/* 129 */     PointerByReference pointerByReference = new PointerByReference();
/* 130 */     if (!Kernel32.INSTANCE.GetQueuedCompletionStatus(this.port, intByReference, uLONG_PTRByReference, pointerByReference, -1)) {
/* 131 */       return null;
/*     */     }
/* 133 */     synchronized (this) {
/* 134 */       return this.handleMap.get(new WinNT.HANDLE(uLONG_PTRByReference.getValue().toPointer()));
/*     */     } 
/*     */   }
/*     */   
/*     */   private int convertMask(int paramInt) {
/* 139 */     int i = 0;
/* 140 */     if ((paramInt & 0x1) != 0) {
/* 141 */       i |= 0x40;
/*     */     }
/* 143 */     if ((paramInt & 0x2) != 0) {
/* 144 */       i |= 0x3;
/*     */     }
/* 146 */     if ((paramInt & 0x4) != 0) {
/* 147 */       i |= 0x10;
/*     */     }
/* 149 */     if ((paramInt & 0x30) != 0) {
/* 150 */       i |= 0x3;
/*     */     }
/* 152 */     if ((paramInt & 0x40) != 0) {
/* 153 */       i |= 0x8;
/*     */     }
/* 155 */     if ((paramInt & 0x8) != 0) {
/* 156 */       i |= 0x20;
/*     */     }
/* 158 */     if ((paramInt & 0x80) != 0) {
/* 159 */       i |= 0x4;
/*     */     }
/* 161 */     if ((paramInt & 0x100) != 0) {
/* 162 */       i |= 0x100;
/*     */     }
/* 164 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected synchronized void watch(File paramFile, int paramInt, boolean paramBoolean) throws IOException {
/* 171 */     File file = paramFile;
/* 172 */     if (!file.isDirectory()) {
/* 173 */       paramBoolean = false;
/* 174 */       file = paramFile.getParentFile();
/*     */     } 
/* 176 */     while (file != null && !file.exists()) {
/* 177 */       paramBoolean = true;
/* 178 */       file = file.getParentFile();
/*     */     } 
/* 180 */     if (file == null) {
/* 181 */       throw new FileNotFoundException("No ancestor found for " + paramFile);
/*     */     }
/* 183 */     Kernel32 kernel32 = Kernel32.INSTANCE;
/* 184 */     byte b = 7;
/*     */     
/* 186 */     int i = 1107296256;
/*     */     
/* 188 */     WinNT.HANDLE hANDLE = kernel32.CreateFile(paramFile.getAbsolutePath(), 1, b, null, 3, i, null);
/*     */ 
/*     */ 
/*     */     
/* 192 */     if (WinBase.INVALID_HANDLE_VALUE.equals(hANDLE)) {
/* 193 */       throw new IOException("Unable to open " + paramFile + " (" + kernel32
/* 194 */           .GetLastError() + ")");
/*     */     }
/* 196 */     int j = convertMask(paramInt);
/* 197 */     FileInfo fileInfo = new FileInfo(paramFile, hANDLE, j, paramBoolean);
/* 198 */     this.fileMap.put(paramFile, fileInfo);
/* 199 */     this.handleMap.put(hANDLE, fileInfo);
/*     */     
/* 201 */     this.port = kernel32.CreateIoCompletionPort(hANDLE, this.port, hANDLE.getPointer(), 0);
/* 202 */     if (WinBase.INVALID_HANDLE_VALUE.equals(this.port)) {
/* 203 */       throw new IOException("Unable to create/use I/O Completion port for " + paramFile + " (" + kernel32
/*     */           
/* 205 */           .GetLastError() + ")");
/*     */     }
/*     */ 
/*     */     
/* 209 */     if (!kernel32.ReadDirectoryChangesW(hANDLE, fileInfo.info, fileInfo.info.size(), paramBoolean, j, fileInfo.infoLength, fileInfo.overlapped, null)) {
/*     */ 
/*     */       
/* 212 */       int k = kernel32.GetLastError();
/* 213 */       throw new IOException("ReadDirectoryChangesW failed on " + fileInfo.file + ", handle " + hANDLE + ": '" + 
/*     */           
/* 215 */           Kernel32Util.formatMessageFromLastErrorCode(k) + "' (" + k + ")");
/*     */     } 
/*     */     
/* 218 */     if (this.watcher == null) {
/* 219 */       this.watcher = new Thread("W32 File Monitor-" + watcherThreadID++)
/*     */         {
/*     */           public void run()
/*     */           {
/*     */             while (true) {
/* 224 */               W32FileMonitor.FileInfo fileInfo = W32FileMonitor.this.waitForChange();
/* 225 */               if (fileInfo == null) {
/* 226 */                 synchronized (W32FileMonitor.this) {
/* 227 */                   if (W32FileMonitor.this.fileMap.isEmpty()) {
/* 228 */                     W32FileMonitor.this.watcher = null;
/*     */                     
/*     */                     break;
/*     */                   } 
/*     */                 } 
/*     */                 continue;
/*     */               } 
/*     */               try {
/* 236 */                 W32FileMonitor.this.handleChanges(fileInfo);
/* 237 */               } catch (IOException iOException) {
/*     */                 
/* 239 */                 iOException.printStackTrace();
/*     */               } 
/*     */             } 
/*     */           }
/*     */         };
/* 244 */       this.watcher.setDaemon(true);
/* 245 */       this.watcher.start();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected synchronized void unwatch(File paramFile) {
/* 251 */     FileInfo fileInfo = this.fileMap.remove(paramFile);
/* 252 */     if (fileInfo != null) {
/* 253 */       this.handleMap.remove(fileInfo.handle);
/* 254 */       Kernel32 kernel32 = Kernel32.INSTANCE;
/*     */       
/* 256 */       kernel32.CloseHandle(fileInfo.handle);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void dispose() {
/* 262 */     this.disposing = true;
/*     */ 
/*     */     
/* 265 */     byte b = 0;
/* 266 */     for (Object[] arrayOfObject = this.fileMap.keySet().toArray(); !this.fileMap.isEmpty();) {
/* 267 */       unwatch((File)arrayOfObject[b++]);
/*     */     }
/*     */     
/* 270 */     Kernel32 kernel32 = Kernel32.INSTANCE;
/* 271 */     kernel32.PostQueuedCompletionStatus(this.port, 0, null, null);
/* 272 */     kernel32.CloseHandle(this.port);
/* 273 */     this.port = null;
/* 274 */     this.watcher = null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\W32FileMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */