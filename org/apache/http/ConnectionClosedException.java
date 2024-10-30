/*    */ package org.apache.http;
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
/*    */ public class ConnectionClosedException
/*    */   extends IOException
/*    */ {
/*    */   private static final long serialVersionUID = 617550366255636674L;
/*    */   
/*    */   public ConnectionClosedException() {
/* 47 */     super("Connection is closed");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ConnectionClosedException(String paramString) {
/* 56 */     super(HttpException.clean(paramString));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ConnectionClosedException(String paramString, Object... paramVarArgs) {
/* 68 */     super(HttpException.clean(String.format(paramString, paramVarArgs)));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\ConnectionClosedException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */