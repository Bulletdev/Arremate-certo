/*    */ package com.sun.jna.platform.win32.COM.util;
/*    */ 
/*    */ import com.sun.jna.platform.win32.COM.IDispatchCallback;
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
/*    */ public abstract class AbstractComEventCallbackListener
/*    */   implements IComEventCallbackListener
/*    */ {
/* 31 */   IDispatchCallback dispatchCallback = null;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setDispatchCallbackListener(IDispatchCallback paramIDispatchCallback) {
/* 37 */     this.dispatchCallback = paramIDispatchCallback;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\CO\\util\AbstractComEventCallbackListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */