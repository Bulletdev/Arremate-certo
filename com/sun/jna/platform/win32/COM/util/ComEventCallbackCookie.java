/*    */ package com.sun.jna.platform.win32.COM.util;
/*    */ 
/*    */ import com.sun.jna.platform.win32.WinDef;
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
/*    */ public class ComEventCallbackCookie
/*    */   implements IComEventCallbackCookie
/*    */ {
/*    */   WinDef.DWORD value;
/*    */   
/*    */   public ComEventCallbackCookie(WinDef.DWORD paramDWORD) {
/* 31 */     this.value = paramDWORD;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public WinDef.DWORD getValue() {
/* 37 */     return this.value;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\CO\\util\ComEventCallbackCookie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */