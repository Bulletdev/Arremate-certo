/*     */ package com.sun.jna.platform;
/*     */ 
/*     */ import com.sun.jna.platform.win32.W32FileMonitor;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.EventObject;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ public abstract class FileMonitor
/*     */ {
/*     */   public static final int FILE_CREATED = 1;
/*     */   public static final int FILE_DELETED = 2;
/*     */   public static final int FILE_MODIFIED = 4;
/*     */   public static final int FILE_ACCESSED = 8;
/*     */   public static final int FILE_NAME_CHANGED_OLD = 16;
/*     */   public static final int FILE_NAME_CHANGED_NEW = 32;
/*     */   public static final int FILE_RENAMED = 48;
/*     */   public static final int FILE_SIZE_CHANGED = 64;
/*     */   public static final int FILE_ATTRIBUTES_CHANGED = 128;
/*     */   public static final int FILE_SECURITY_CHANGED = 256;
/*     */   public static final int FILE_ANY = 511;
/*     */   
/*     */   public static interface FileListener
/*     */   {
/*     */     void fileChanged(FileMonitor.FileEvent param1FileEvent);
/*     */   }
/*     */   
/*     */   public class FileEvent
/*     */     extends EventObject
/*     */   {
/*     */     private final File file;
/*     */     private final int type;
/*     */     
/*     */     public FileEvent(File param1File, int param1Int) {
/*  66 */       super(FileMonitor.this);
/*  67 */       this.file = param1File;
/*  68 */       this.type = param1Int;
/*     */     }
/*  70 */     public File getFile() { return this.file; } public int getType() {
/*  71 */       return this.type;
/*     */     } public String toString() {
/*  73 */       return "FileEvent: " + this.file + ":" + this.type;
/*     */     }
/*     */   }
/*     */   
/*  77 */   private final Map<File, Integer> watched = new HashMap<File, Integer>();
/*  78 */   private List<FileListener> listeners = new ArrayList<FileListener>();
/*     */   protected abstract void watch(File paramFile, int paramInt, boolean paramBoolean) throws IOException;
/*     */   protected abstract void unwatch(File paramFile);
/*     */   
/*     */   public abstract void dispose();
/*     */   
/*     */   public void addWatch(File paramFile) throws IOException {
/*  85 */     addWatch(paramFile, 511);
/*     */   }
/*     */   
/*     */   public void addWatch(File paramFile, int paramInt) throws IOException {
/*  89 */     addWatch(paramFile, paramInt, paramFile.isDirectory());
/*     */   }
/*     */   
/*     */   public void addWatch(File paramFile, int paramInt, boolean paramBoolean) throws IOException {
/*  93 */     this.watched.put(paramFile, Integer.valueOf(paramInt));
/*  94 */     watch(paramFile, paramInt, paramBoolean);
/*     */   }
/*     */   
/*     */   public void removeWatch(File paramFile) {
/*  98 */     if (this.watched.remove(paramFile) != null) {
/*  99 */       unwatch(paramFile);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void notify(FileEvent paramFileEvent) {
/* 104 */     for (FileListener fileListener : this.listeners) {
/* 105 */       fileListener.fileChanged(paramFileEvent);
/*     */     }
/*     */   }
/*     */   
/*     */   public synchronized void addFileListener(FileListener paramFileListener) {
/* 110 */     ArrayList<FileListener> arrayList = new ArrayList<FileListener>(this.listeners);
/* 111 */     arrayList.add(paramFileListener);
/* 112 */     this.listeners = arrayList;
/*     */   }
/*     */   
/*     */   public synchronized void removeFileListener(FileListener paramFileListener) {
/* 116 */     ArrayList<FileListener> arrayList = new ArrayList<FileListener>(this.listeners);
/* 117 */     arrayList.remove(paramFileListener);
/* 118 */     this.listeners = arrayList;
/*     */   }
/*     */   
/*     */   protected void finalize() {
/* 122 */     for (File file : this.watched.keySet()) {
/* 123 */       removeWatch(file);
/*     */     }
/*     */     
/* 126 */     dispose();
/*     */   }
/*     */   
/*     */   private static class Holder {
/*     */     public static final FileMonitor INSTANCE;
/*     */     
/*     */     static {
/* 133 */       String str = System.getProperty("os.name");
/* 134 */       if (str.startsWith("Windows")) {
/* 135 */         INSTANCE = (FileMonitor)new W32FileMonitor();
/*     */       } else {
/*     */         
/* 138 */         throw new Error("FileMonitor not implemented for " + str);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static FileMonitor getInstance() {
/* 144 */     return Holder.INSTANCE;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\FileMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */