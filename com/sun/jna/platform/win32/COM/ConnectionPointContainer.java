/*    */ package com.sun.jna.platform.win32.COM;
/*    */ 
/*    */ import com.sun.jna.Pointer;
/*    */ import com.sun.jna.platform.win32.Guid;
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
/*    */ public class ConnectionPointContainer
/*    */   extends Unknown
/*    */   implements IConnectionPointContainer
/*    */ {
/*    */   public ConnectionPointContainer(Pointer paramPointer) {
/* 35 */     super(paramPointer);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public WinNT.HRESULT EnumConnectionPoints() {
/* 42 */     byte b = 3;
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 47 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public WinNT.HRESULT FindConnectionPoint(Guid.REFIID paramREFIID, PointerByReference paramPointerByReference) {
/* 56 */     byte b = 4;
/* 57 */     return (WinNT.HRESULT)_invokeNativeObject(4, new Object[] {
/* 58 */           getPointer(), paramREFIID, paramPointerByReference }, WinNT.HRESULT.class);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\ConnectionPointContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */