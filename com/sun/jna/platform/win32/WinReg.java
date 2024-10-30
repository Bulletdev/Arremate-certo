/*    */ package com.sun.jna.platform.win32;
/*    */ 
/*    */ import com.sun.jna.Native;
/*    */ import com.sun.jna.Pointer;
/*    */ import com.sun.jna.ptr.ByReference;
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
/*    */ public interface WinReg
/*    */ {
/*    */   public static class HKEY
/*    */     extends WinNT.HANDLE
/*    */   {
/*    */     public HKEY() {}
/*    */     
/*    */     public HKEY(Pointer param1Pointer) {
/* 42 */       super(param1Pointer); } public HKEY(int param1Int) {
/* 43 */       super(new Pointer(param1Int));
/*    */     } }
/*    */   
/*    */   public static class HKEYByReference extends ByReference {
/*    */     public HKEYByReference() {
/* 48 */       this(null);
/*    */     }
/*    */     
/*    */     public HKEYByReference(WinReg.HKEY param1HKEY) {
/* 52 */       super(Native.POINTER_SIZE);
/* 53 */       setValue(param1HKEY);
/*    */     }
/*    */     
/*    */     public void setValue(WinReg.HKEY param1HKEY) {
/* 57 */       getPointer().setPointer(0L, (param1HKEY != null) ? param1HKEY.getPointer() : null);
/*    */     }
/*    */     
/*    */     public WinReg.HKEY getValue() {
/* 61 */       Pointer pointer = getPointer().getPointer(0L);
/* 62 */       if (pointer == null)
/* 63 */         return null; 
/* 64 */       if (WinBase.INVALID_HANDLE_VALUE.getPointer().equals(pointer))
/* 65 */         return (WinReg.HKEY)WinBase.INVALID_HANDLE_VALUE; 
/* 66 */       WinReg.HKEY hKEY = new WinReg.HKEY();
/* 67 */       hKEY.setPointer(pointer);
/* 68 */       return hKEY;
/*    */     }
/*    */   }
/*    */   
/* 72 */   public static final HKEY HKEY_CLASSES_ROOT = new HKEY(-2147483648);
/* 73 */   public static final HKEY HKEY_CURRENT_USER = new HKEY(-2147483647);
/* 74 */   public static final HKEY HKEY_LOCAL_MACHINE = new HKEY(-2147483646);
/* 75 */   public static final HKEY HKEY_USERS = new HKEY(-2147483645);
/* 76 */   public static final HKEY HKEY_PERFORMANCE_DATA = new HKEY(-2147483644);
/* 77 */   public static final HKEY HKEY_PERFORMANCE_TEXT = new HKEY(-2147483568);
/* 78 */   public static final HKEY HKEY_PERFORMANCE_NLSTEXT = new HKEY(-2147483552);
/* 79 */   public static final HKEY HKEY_CURRENT_CONFIG = new HKEY(-2147483643);
/* 80 */   public static final HKEY HKEY_DYN_DATA = new HKEY(-2147483642);
/* 81 */   public static final HKEY HKEY_CURRENT_USER_LOCAL_SETTINGS = new HKEY(-2147483641);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\WinReg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */