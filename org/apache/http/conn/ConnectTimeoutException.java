/*    */ package org.apache.http.conn;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.InterruptedIOException;
/*    */ import java.net.InetAddress;
/*    */ import java.util.Arrays;
/*    */ import org.apache.http.HttpHost;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ConnectTimeoutException
/*    */   extends InterruptedIOException
/*    */ {
/*    */   private static final long serialVersionUID = -4816682903149535989L;
/*    */   private final HttpHost host;
/*    */   
/*    */   public ConnectTimeoutException() {
/* 55 */     this.host = null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ConnectTimeoutException(String paramString) {
/* 62 */     super(paramString);
/* 63 */     this.host = null;
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
/*    */   public ConnectTimeoutException(IOException paramIOException, HttpHost paramHttpHost, InetAddress... paramVarArgs) {
/* 75 */     super("Connect to " + ((paramHttpHost != null) ? paramHttpHost.toHostString() : "remote host") + ((paramVarArgs != null && paramVarArgs.length > 0) ? (" " + Arrays.<InetAddress>asList(paramVarArgs)) : "") + ((paramIOException != null && paramIOException.getMessage() != null) ? (" failed: " + paramIOException.getMessage()) : " timed out"));
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 81 */     this.host = paramHttpHost;
/* 82 */     initCause(paramIOException);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public HttpHost getHost() {
/* 89 */     return this.host;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\conn\ConnectTimeoutException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */