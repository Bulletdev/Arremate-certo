/*    */ package com.google.gson.stream;
/*    */ 
/*    */ import java.io.IOException;
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
/*    */ public final class MalformedJsonException
/*    */   extends IOException
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public MalformedJsonException(String paramString) {
/* 29 */     super(paramString);
/*    */   }
/*    */   
/*    */   public MalformedJsonException(String paramString, Throwable paramThrowable) {
/* 33 */     super(paramString);
/*    */ 
/*    */     
/* 36 */     initCause(paramThrowable);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public MalformedJsonException(Throwable paramThrowable) {
/* 42 */     initCause(paramThrowable);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\stream\MalformedJsonException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */