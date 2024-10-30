/*    */ package com.sun.jna.platform.win32.COM.tlb.imp;
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
/*    */ public class TlbParameterNotFoundException
/*    */   extends RuntimeException
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public TlbParameterNotFoundException() {}
/*    */   
/*    */   public TlbParameterNotFoundException(String paramString) {
/* 34 */     super(paramString);
/*    */   }
/*    */   
/*    */   public TlbParameterNotFoundException(Throwable paramThrowable) {
/* 38 */     super(paramThrowable);
/*    */   }
/*    */   
/*    */   public TlbParameterNotFoundException(String paramString, Throwable paramThrowable) {
/* 42 */     super(paramString, paramThrowable);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\tlb\imp\TlbParameterNotFoundException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */