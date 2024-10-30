/*    */ package org.apache.http.impl.execchain;
/*    */ 
/*    */ import java.io.InterruptedIOException;
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
/*    */ 
/*    */ 
/*    */ public class RequestAbortedException
/*    */   extends InterruptedIOException
/*    */ {
/*    */   private static final long serialVersionUID = 4973849966012490112L;
/*    */   
/*    */   public RequestAbortedException(String paramString) {
/* 42 */     super(paramString);
/*    */   }
/*    */   
/*    */   public RequestAbortedException(String paramString, Throwable paramThrowable) {
/* 46 */     super(paramString);
/* 47 */     if (paramThrowable != null)
/* 48 */       initCause(paramThrowable); 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\execchain\RequestAbortedException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */