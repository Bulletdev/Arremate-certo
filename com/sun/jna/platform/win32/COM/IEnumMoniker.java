/*    */ package com.sun.jna.platform.win32.COM;
/*    */ 
/*    */ import com.sun.jna.platform.win32.Guid;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface IEnumMoniker
/*    */   extends IUnknown
/*    */ {
/* 40 */   public static final Guid.IID IID = new Guid.IID("{00000102-0000-0000-C000-000000000046}");
/*    */   
/*    */   WinNT.HRESULT Clone(PointerByReference paramPointerByReference);
/*    */   
/*    */   WinNT.HRESULT Next(WinDef.ULONG paramULONG, PointerByReference paramPointerByReference, WinDef.ULONGByReference paramULONGByReference);
/*    */   
/*    */   WinNT.HRESULT Reset();
/*    */   
/*    */   WinNT.HRESULT Skip(WinDef.ULONG paramULONG);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\IEnumMoniker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */