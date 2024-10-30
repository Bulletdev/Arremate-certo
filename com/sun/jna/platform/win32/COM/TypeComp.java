/*     */ package com.sun.jna.platform.win32.COM;
/*     */ 
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.Structure;
/*     */ import com.sun.jna.WString;
/*     */ import com.sun.jna.platform.win32.OaIdl;
/*     */ import com.sun.jna.platform.win32.WinDef;
/*     */ import com.sun.jna.platform.win32.WinNT;
/*     */ import com.sun.jna.ptr.PointerByReference;
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
/*     */ public class TypeComp
/*     */   extends Unknown
/*     */ {
/*     */   public static class ByReference
/*     */     extends TypeComp
/*     */     implements Structure.ByReference {}
/*     */   
/*     */   public TypeComp() {}
/*     */   
/*     */   public TypeComp(Pointer paramPointer) {
/*  61 */     super(paramPointer);
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
/*     */   public WinNT.HRESULT Bind(WString paramWString, WinDef.ULONG paramULONG, WinDef.WORD paramWORD, PointerByReference paramPointerByReference, OaIdl.DESCKIND.ByReference paramByReference, OaIdl.BINDPTR.ByReference paramByReference1) {
/*  90 */     return (WinNT.HRESULT)_invokeNativeObject(3, new Object[] {
/*  91 */           getPointer(), paramWString, paramULONG, paramWORD, paramPointerByReference, paramByReference, paramByReference1 }, WinNT.HRESULT.class);
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
/*     */   public WinNT.HRESULT BindType(WString paramWString, WinDef.ULONG paramULONG, PointerByReference paramPointerByReference1, PointerByReference paramPointerByReference2) {
/* 115 */     return (WinNT.HRESULT)_invokeNativeObject(4, new Object[] {
/* 116 */           getPointer(), paramWString, paramULONG, paramPointerByReference1, paramPointerByReference2 }, WinNT.HRESULT.class);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\TypeComp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */