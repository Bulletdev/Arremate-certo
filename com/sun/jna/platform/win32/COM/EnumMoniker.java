/*    */ package com.sun.jna.platform.win32.COM;
/*    */ 
/*    */ import com.sun.jna.Pointer;
/*    */ import com.sun.jna.platform.win32.WinDef;
/*    */ import com.sun.jna.platform.win32.WinNT;
/*    */ import com.sun.jna.ptr.PointerByReference;
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
/*    */ public class EnumMoniker
/*    */   extends Unknown
/*    */   implements IEnumMoniker
/*    */ {
/*    */   public EnumMoniker(Pointer paramPointer) {
/* 36 */     super(paramPointer);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public WinNT.HRESULT Next(WinDef.ULONG paramULONG, PointerByReference paramPointerByReference, WinDef.ULONGByReference paramULONGByReference) {
/* 45 */     byte b = 3;
/*    */     
/* 47 */     return (WinNT.HRESULT)_invokeNativeObject(3, new Object[] { getPointer(), paramULONG, paramPointerByReference, paramULONGByReference }, WinNT.HRESULT.class);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public WinNT.HRESULT Skip(WinDef.ULONG paramULONG) {
/* 55 */     byte b = 4;
/*    */     
/* 57 */     return (WinNT.HRESULT)_invokeNativeObject(4, new Object[] { getPointer(), paramULONG }, WinNT.HRESULT.class);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public WinNT.HRESULT Reset() {
/* 65 */     byte b = 5;
/*    */     
/* 67 */     return (WinNT.HRESULT)_invokeNativeObject(5, new Object[] { getPointer() }, WinNT.HRESULT.class);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public WinNT.HRESULT Clone(PointerByReference paramPointerByReference) {
/* 75 */     byte b = 6;
/*    */     
/* 77 */     return (WinNT.HRESULT)_invokeNativeObject(6, new Object[] {
/* 78 */           getPointer(), paramPointerByReference }, WinNT.HRESULT.class);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\EnumMoniker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */