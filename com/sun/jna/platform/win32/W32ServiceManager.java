/*     */ package com.sun.jna.platform.win32;
/*     */ 
/*     */ import com.sun.jna.Memory;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.Structure;
/*     */ import com.sun.jna.ptr.IntByReference;
/*     */ import java.io.Closeable;
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
/*     */ public class W32ServiceManager
/*     */   implements Closeable
/*     */ {
/*  40 */   Winsvc.SC_HANDLE _handle = null;
/*  41 */   String _machineName = null;
/*  42 */   String _databaseName = null;
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
/*     */   public W32ServiceManager() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public W32ServiceManager(int paramInt) {
/*  64 */     open(paramInt);
/*     */   }
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
/*     */   public W32ServiceManager(String paramString1, String paramString2) {
/*  83 */     this._machineName = paramString1;
/*  84 */     this._databaseName = paramString2;
/*     */   }
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
/*     */   public W32ServiceManager(String paramString1, String paramString2, int paramInt) {
/* 105 */     this._machineName = paramString1;
/* 106 */     this._databaseName = paramString2;
/* 107 */     open(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void open(int paramInt) {
/* 116 */     close();
/*     */     
/* 118 */     this._handle = Advapi32.INSTANCE.OpenSCManager(this._machineName, this._databaseName, paramInt);
/*     */ 
/*     */     
/* 121 */     if (this._handle == null) {
/* 122 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/* 131 */     if (this._handle != null) {
/* 132 */       if (!Advapi32.INSTANCE.CloseServiceHandle(this._handle)) {
/* 133 */         throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*     */       }
/* 135 */       this._handle = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public W32Service openService(String paramString, int paramInt) {
/* 148 */     Winsvc.SC_HANDLE sC_HANDLE = Advapi32.INSTANCE.OpenService(this._handle, paramString, paramInt);
/*     */ 
/*     */     
/* 151 */     if (sC_HANDLE == null) {
/* 152 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*     */     }
/*     */     
/* 155 */     return new W32Service(sC_HANDLE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Winsvc.SC_HANDLE getHandle() {
/* 164 */     return this._handle;
/*     */   }
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
/*     */   public Winsvc.ENUM_SERVICE_STATUS_PROCESS[] enumServicesStatusExProcess(int paramInt1, int paramInt2, String paramString) {
/* 221 */     IntByReference intByReference1 = new IntByReference(0);
/* 222 */     IntByReference intByReference2 = new IntByReference(0);
/* 223 */     IntByReference intByReference3 = new IntByReference(0);
/* 224 */     Advapi32.INSTANCE.EnumServicesStatusEx(this._handle, 0, paramInt1, paramInt2, Pointer.NULL, 0, intByReference1, intByReference2, intByReference3, paramString);
/* 225 */     int i = Kernel32.INSTANCE.GetLastError();
/* 226 */     if (i != 234) {
/* 227 */       throw new Win32Exception(i);
/*     */     }
/* 229 */     Memory memory = new Memory(intByReference1.getValue());
/* 230 */     boolean bool = Advapi32.INSTANCE.EnumServicesStatusEx(this._handle, 0, paramInt1, paramInt2, (Pointer)memory, (int)memory.size(), intByReference1, intByReference2, intByReference3, paramString);
/* 231 */     if (!bool) {
/* 232 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*     */     }
/* 234 */     if (intByReference2.getValue() == 0) {
/* 235 */       return new Winsvc.ENUM_SERVICE_STATUS_PROCESS[0];
/*     */     }
/* 237 */     Winsvc.ENUM_SERVICE_STATUS_PROCESS eNUM_SERVICE_STATUS_PROCESS = (Winsvc.ENUM_SERVICE_STATUS_PROCESS)Structure.newInstance(Winsvc.ENUM_SERVICE_STATUS_PROCESS.class, (Pointer)memory);
/* 238 */     eNUM_SERVICE_STATUS_PROCESS.read();
/* 239 */     return (Winsvc.ENUM_SERVICE_STATUS_PROCESS[])eNUM_SERVICE_STATUS_PROCESS.toArray(intByReference2.getValue());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\W32ServiceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */