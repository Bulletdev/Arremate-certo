/*    */ package com.sun.jna.platform.win32.COM;
/*    */ 
/*    */ import com.sun.jna.Pointer;
/*    */ import com.sun.jna.platform.win32.Guid;
/*    */ import com.sun.jna.platform.win32.Variant;
/*    */ import com.sun.jna.platform.win32.WinNT;
/*    */ import com.sun.jna.ptr.IntByReference;
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
/*    */ public class EnumVariant
/*    */   extends Unknown
/*    */   implements IEnumVariant
/*    */ {
/* 36 */   public static final Guid.IID IID = new Guid.IID("{00020404-0000-0000-C000-000000000046}");
/* 37 */   public static final Guid.REFIID REFIID = new Guid.REFIID(IID);
/*    */ 
/*    */   
/*    */   public EnumVariant() {}
/*    */   
/*    */   public EnumVariant(Pointer paramPointer) {
/* 43 */     setPointer(paramPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public Variant.VARIANT[] Next(int paramInt) {
/* 48 */     Variant.VARIANT[] arrayOfVARIANT1 = new Variant.VARIANT[paramInt];
/* 49 */     IntByReference intByReference = new IntByReference();
/* 50 */     WinNT.HRESULT hRESULT = (WinNT.HRESULT)_invokeNativeObject(3, new Object[] { getPointer(), Integer.valueOf(arrayOfVARIANT1.length), arrayOfVARIANT1, intByReference }, WinNT.HRESULT.class);
/* 51 */     COMUtils.checkRC(hRESULT);
/* 52 */     Variant.VARIANT[] arrayOfVARIANT2 = new Variant.VARIANT[intByReference.getValue()];
/* 53 */     System.arraycopy(arrayOfVARIANT1, 0, arrayOfVARIANT2, 0, intByReference.getValue());
/* 54 */     return arrayOfVARIANT2;
/*    */   }
/*    */ 
/*    */   
/*    */   public void Skip(int paramInt) {
/* 59 */     WinNT.HRESULT hRESULT = (WinNT.HRESULT)_invokeNativeObject(4, new Object[] { getPointer(), Integer.valueOf(paramInt) }, WinNT.HRESULT.class);
/* 60 */     COMUtils.checkRC(hRESULT);
/*    */   }
/*    */ 
/*    */   
/*    */   public void Reset() {
/* 65 */     WinNT.HRESULT hRESULT = (WinNT.HRESULT)_invokeNativeObject(5, new Object[] { getPointer() }, WinNT.HRESULT.class);
/* 66 */     COMUtils.checkRC(hRESULT);
/*    */   }
/*    */ 
/*    */   
/*    */   public EnumVariant Clone() {
/* 71 */     PointerByReference pointerByReference = new PointerByReference();
/* 72 */     WinNT.HRESULT hRESULT = (WinNT.HRESULT)_invokeNativeObject(6, new Object[] { getPointer(), pointerByReference }, WinNT.HRESULT.class);
/* 73 */     COMUtils.checkRC(hRESULT);
/* 74 */     return new EnumVariant(pointerByReference.getValue());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\EnumVariant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */