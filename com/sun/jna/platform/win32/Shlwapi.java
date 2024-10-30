/*    */ package com.sun.jna.platform.win32;
/*    */ 
/*    */ import com.sun.jna.Native;
/*    */ import com.sun.jna.Pointer;
/*    */ import com.sun.jna.ptr.PointerByReference;
/*    */ import com.sun.jna.win32.StdCallLibrary;
/*    */ import com.sun.jna.win32.W32APIOptions;
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
/*    */ public interface Shlwapi
/*    */   extends StdCallLibrary
/*    */ {
/* 38 */   public static final Shlwapi INSTANCE = (Shlwapi)Native.load("Shlwapi", Shlwapi.class, W32APIOptions.DEFAULT_OPTIONS);
/*    */   
/*    */   WinNT.HRESULT StrRetToStr(ShTypes.STRRET paramSTRRET, Pointer paramPointer, PointerByReference paramPointerByReference);
/*    */   
/*    */   boolean PathIsUNC(String paramString);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\Shlwapi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */