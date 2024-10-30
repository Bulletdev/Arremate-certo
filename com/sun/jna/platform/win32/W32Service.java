/*     */ package com.sun.jna.platform.win32;
/*     */ 
/*     */ import com.sun.jna.Memory;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.Structure;
/*     */ import com.sun.jna.ptr.IntByReference;
/*     */ import java.io.Closeable;
/*     */ import java.util.List;
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
/*     */ public class W32Service
/*     */   implements Closeable
/*     */ {
/*  56 */   Winsvc.SC_HANDLE _handle = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public W32Service(Winsvc.SC_HANDLE paramSC_HANDLE) {
/*  66 */     this._handle = paramSC_HANDLE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/*  74 */     if (this._handle != null) {
/*  75 */       if (!Advapi32.INSTANCE.CloseServiceHandle(this._handle)) {
/*  76 */         throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*     */       }
/*  78 */       this._handle = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void addShutdownPrivilegeToProcess() {
/*  83 */     WinNT.HANDLEByReference hANDLEByReference = new WinNT.HANDLEByReference();
/*  84 */     WinNT.LUID lUID = new WinNT.LUID();
/*  85 */     Advapi32.INSTANCE.OpenProcessToken(Kernel32.INSTANCE.GetCurrentProcess(), 32, hANDLEByReference);
/*     */     
/*  87 */     Advapi32.INSTANCE.LookupPrivilegeValue("", "SeShutdownPrivilege", lUID);
/*  88 */     WinNT.TOKEN_PRIVILEGES tOKEN_PRIVILEGES = new WinNT.TOKEN_PRIVILEGES(1);
/*  89 */     tOKEN_PRIVILEGES.Privileges[0] = new WinNT.LUID_AND_ATTRIBUTES(lUID, new WinDef.DWORD(2L));
/*  90 */     Advapi32.INSTANCE.AdjustTokenPrivileges(hANDLEByReference.getValue(), false, tOKEN_PRIVILEGES, tOKEN_PRIVILEGES.size(), null, new IntByReference());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFailureActions(List<Winsvc.SC_ACTION> paramList, int paramInt, String paramString1, String paramString2) {
/* 101 */     Winsvc.SERVICE_FAILURE_ACTIONS.ByReference byReference = new Winsvc.SERVICE_FAILURE_ACTIONS.ByReference();
/* 102 */     byReference.dwResetPeriod = paramInt;
/* 103 */     byReference.lpRebootMsg = paramString1;
/* 104 */     byReference.lpCommand = paramString2;
/* 105 */     byReference.cActions = paramList.size();
/*     */     
/* 107 */     byReference.lpsaActions = new Winsvc.SC_ACTION.ByReference();
/* 108 */     Winsvc.SC_ACTION[] arrayOfSC_ACTION = (Winsvc.SC_ACTION[])byReference.lpsaActions.toArray(paramList.size());
/* 109 */     boolean bool = false;
/* 110 */     byte b = 0;
/* 111 */     for (Winsvc.SC_ACTION sC_ACTION : paramList) {
/* 112 */       if (!bool && sC_ACTION.type == 2) {
/* 113 */         addShutdownPrivilegeToProcess();
/* 114 */         bool = true;
/*     */       } 
/* 116 */       (arrayOfSC_ACTION[b]).type = sC_ACTION.type;
/* 117 */       (arrayOfSC_ACTION[b]).delay = sC_ACTION.delay;
/* 118 */       b++;
/*     */     } 
/*     */     
/* 121 */     if (!Advapi32.INSTANCE.ChangeServiceConfig2(this._handle, 2, byReference))
/*     */     {
/* 123 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*     */     }
/*     */   }
/*     */   
/*     */   private Pointer queryServiceConfig2(int paramInt) {
/* 128 */     IntByReference intByReference = new IntByReference();
/* 129 */     Advapi32.INSTANCE.QueryServiceConfig2(this._handle, paramInt, Pointer.NULL, 0, intByReference);
/*     */     
/* 131 */     Memory memory = new Memory(intByReference.getValue());
/*     */     
/* 133 */     if (!Advapi32.INSTANCE.QueryServiceConfig2(this._handle, paramInt, (Pointer)memory, intByReference.getValue(), new IntByReference()))
/*     */     {
/* 135 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*     */     }
/*     */     
/* 138 */     return (Pointer)memory;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Winsvc.SERVICE_FAILURE_ACTIONS getFailureActions() {
/* 147 */     Pointer pointer = queryServiceConfig2(2);
/* 148 */     return new Winsvc.SERVICE_FAILURE_ACTIONS(pointer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFailureActionsFlag(boolean paramBoolean) {
/* 158 */     Winsvc.SERVICE_FAILURE_ACTIONS_FLAG sERVICE_FAILURE_ACTIONS_FLAG = new Winsvc.SERVICE_FAILURE_ACTIONS_FLAG();
/* 159 */     sERVICE_FAILURE_ACTIONS_FLAG.fFailureActionsOnNonCrashFailures = paramBoolean ? 1 : 0;
/*     */     
/* 161 */     if (!Advapi32.INSTANCE.ChangeServiceConfig2(this._handle, 4, sERVICE_FAILURE_ACTIONS_FLAG))
/*     */     {
/* 163 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getFailureActionsFlag() {
/* 173 */     Pointer pointer = queryServiceConfig2(4);
/* 174 */     Winsvc.SERVICE_FAILURE_ACTIONS_FLAG sERVICE_FAILURE_ACTIONS_FLAG = new Winsvc.SERVICE_FAILURE_ACTIONS_FLAG(pointer);
/* 175 */     return (sERVICE_FAILURE_ACTIONS_FLAG.fFailureActionsOnNonCrashFailures != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Winsvc.SERVICE_STATUS_PROCESS queryStatus() {
/* 185 */     IntByReference intByReference = new IntByReference();
/*     */     
/* 187 */     Advapi32.INSTANCE.QueryServiceStatusEx(this._handle, 0, null, 0, intByReference);
/*     */ 
/*     */     
/* 190 */     Winsvc.SERVICE_STATUS_PROCESS sERVICE_STATUS_PROCESS = new Winsvc.SERVICE_STATUS_PROCESS(intByReference.getValue());
/* 191 */     if (!Advapi32.INSTANCE.QueryServiceStatusEx(this._handle, 0, sERVICE_STATUS_PROCESS, sERVICE_STATUS_PROCESS
/* 192 */         .size(), intByReference)) {
/* 193 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*     */     }
/*     */     
/* 196 */     return sERVICE_STATUS_PROCESS;
/*     */   }
/*     */   
/*     */   public void startService() {
/* 200 */     waitForNonPendingState();
/*     */     
/* 202 */     if ((queryStatus()).dwCurrentState == 4) {
/*     */       return;
/*     */     }
/* 205 */     if (!Advapi32.INSTANCE.StartService(this._handle, 0, null)) {
/* 206 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*     */     }
/* 208 */     waitForNonPendingState();
/* 209 */     if ((queryStatus()).dwCurrentState != 4) {
/* 210 */       throw new RuntimeException("Unable to start the service");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void stopService() {
/* 218 */     stopService(30000L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void stopService(long paramLong) {
/* 227 */     long l = System.currentTimeMillis();
/* 228 */     waitForNonPendingState();
/*     */     
/* 230 */     if ((queryStatus()).dwCurrentState == 1) {
/*     */       return;
/*     */     }
/* 233 */     Winsvc.SERVICE_STATUS sERVICE_STATUS = new Winsvc.SERVICE_STATUS();
/* 234 */     if (!Advapi32.INSTANCE.ControlService(this._handle, 1, sERVICE_STATUS)) {
/* 235 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 240 */     while (sERVICE_STATUS.dwCurrentState != 1) {
/* 241 */       long l1 = paramLong - System.currentTimeMillis() - l;
/*     */       
/* 243 */       if (l1 < 0L) {
/* 244 */         throw new RuntimeException(String.format("Service stop exceeded timeout time of %d ms", new Object[] { Long.valueOf(paramLong) }));
/*     */       }
/*     */       
/* 247 */       long l2 = Math.min(sanitizeWaitTime(sERVICE_STATUS.dwWaitHint), l1);
/*     */       
/*     */       try {
/* 250 */         Thread.sleep(l2);
/* 251 */       } catch (InterruptedException interruptedException) {
/* 252 */         throw new RuntimeException(interruptedException);
/*     */       } 
/* 254 */       if (!Advapi32.INSTANCE.QueryServiceStatus(this._handle, sERVICE_STATUS)) {
/* 255 */         throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void continueService() {
/* 264 */     waitForNonPendingState();
/*     */     
/* 266 */     if ((queryStatus()).dwCurrentState == 4) {
/*     */       return;
/*     */     }
/* 269 */     if (!Advapi32.INSTANCE.ControlService(this._handle, 3, new Winsvc.SERVICE_STATUS()))
/*     */     {
/* 271 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*     */     }
/* 273 */     waitForNonPendingState();
/* 274 */     if ((queryStatus()).dwCurrentState != 4) {
/* 275 */       throw new RuntimeException("Unable to continue the service");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void pauseService() {
/* 283 */     waitForNonPendingState();
/*     */     
/* 285 */     if ((queryStatus()).dwCurrentState == 7) {
/*     */       return;
/*     */     }
/* 288 */     if (!Advapi32.INSTANCE.ControlService(this._handle, 2, new Winsvc.SERVICE_STATUS()))
/*     */     {
/* 290 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*     */     }
/* 292 */     waitForNonPendingState();
/* 293 */     if ((queryStatus()).dwCurrentState != 7) {
/* 294 */       throw new RuntimeException("Unable to pause the service");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int sanitizeWaitTime(int paramInt) {
/* 303 */     int i = paramInt / 10;
/*     */     
/* 305 */     if (i < 1000) {
/* 306 */       i = 1000;
/* 307 */     } else if (i > 10000) {
/* 308 */       i = 10000;
/*     */     } 
/* 310 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void waitForNonPendingState() {
/* 318 */     Winsvc.SERVICE_STATUS_PROCESS sERVICE_STATUS_PROCESS = queryStatus();
/*     */     
/* 320 */     int i = sERVICE_STATUS_PROCESS.dwCheckPoint;
/* 321 */     int j = Kernel32.INSTANCE.GetTickCount();
/*     */     
/* 323 */     while (isPendingState(sERVICE_STATUS_PROCESS.dwCurrentState)) {
/*     */ 
/*     */       
/* 326 */       if (sERVICE_STATUS_PROCESS.dwCheckPoint != i) {
/* 327 */         i = sERVICE_STATUS_PROCESS.dwCheckPoint;
/* 328 */         j = Kernel32.INSTANCE.GetTickCount();
/*     */       } 
/*     */ 
/*     */       
/* 332 */       if (Kernel32.INSTANCE.GetTickCount() - j > sERVICE_STATUS_PROCESS.dwWaitHint) {
/* 333 */         throw new RuntimeException("Timeout waiting for service to change to a non-pending state.");
/*     */       }
/*     */       
/* 336 */       int k = sanitizeWaitTime(sERVICE_STATUS_PROCESS.dwWaitHint);
/*     */       
/*     */       try {
/* 339 */         Thread.sleep(k);
/* 340 */       } catch (InterruptedException interruptedException) {
/* 341 */         throw new RuntimeException(interruptedException);
/*     */       } 
/*     */       
/* 344 */       sERVICE_STATUS_PROCESS = queryStatus();
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean isPendingState(int paramInt) {
/* 349 */     switch (paramInt) {
/*     */       case 2:
/*     */       case 3:
/*     */       case 5:
/*     */       case 6:
/* 354 */         return true;
/*     */     } 
/* 356 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Winsvc.SC_HANDLE getHandle() {
/* 366 */     return this._handle;
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
/*     */   public Winsvc.ENUM_SERVICE_STATUS[] enumDependentServices(int paramInt) {
/* 394 */     IntByReference intByReference1 = new IntByReference(0);
/* 395 */     IntByReference intByReference2 = new IntByReference(0);
/* 396 */     Advapi32.INSTANCE.EnumDependentServices(this._handle, paramInt, Pointer.NULL, 0, intByReference1, intByReference2);
/* 397 */     int i = Kernel32.INSTANCE.GetLastError();
/* 398 */     if (i != 234) {
/* 399 */       throw new Win32Exception(i);
/*     */     }
/* 401 */     Memory memory = new Memory(intByReference1.getValue());
/* 402 */     boolean bool = Advapi32.INSTANCE.EnumDependentServices(this._handle, paramInt, (Pointer)memory, (int)memory.size(), intByReference1, intByReference2);
/* 403 */     if (!bool) {
/* 404 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*     */     }
/* 406 */     if (intByReference2.getValue() == 0) {
/* 407 */       return new Winsvc.ENUM_SERVICE_STATUS[0];
/*     */     }
/* 409 */     Winsvc.ENUM_SERVICE_STATUS eNUM_SERVICE_STATUS = (Winsvc.ENUM_SERVICE_STATUS)Structure.newInstance(Winsvc.ENUM_SERVICE_STATUS.class, (Pointer)memory);
/* 410 */     eNUM_SERVICE_STATUS.read();
/* 411 */     return (Winsvc.ENUM_SERVICE_STATUS[])eNUM_SERVICE_STATUS.toArray(intByReference2.getValue());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\W32Service.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */