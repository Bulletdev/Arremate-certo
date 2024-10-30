/*    */ package com.sun.jna.platform.win32;
/*    */ 
/*    */ import com.sun.jna.ptr.IntByReference;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class NtDllUtil
/*    */ {
/*    */   public static String getKeyName(WinReg.HKEY paramHKEY) {
/* 43 */     IntByReference intByReference = new IntByReference();
/* 44 */     int i = NtDll.INSTANCE.ZwQueryKey(paramHKEY, 0, null, 0, intByReference);
/*    */     
/* 46 */     if (i != -1073741789 || intByReference.getValue() <= 0) {
/* 47 */       throw new Win32Exception(i);
/*    */     }
/*    */     
/* 50 */     Wdm.KEY_BASIC_INFORMATION kEY_BASIC_INFORMATION = new Wdm.KEY_BASIC_INFORMATION(intByReference.getValue());
/* 51 */     i = NtDll.INSTANCE.ZwQueryKey(paramHKEY, 0, kEY_BASIC_INFORMATION, intByReference
/* 52 */         .getValue(), intByReference);
/* 53 */     if (i != 0) {
/* 54 */       throw new Win32Exception(i);
/*    */     }
/* 56 */     return kEY_BASIC_INFORMATION.getName();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\NtDllUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */