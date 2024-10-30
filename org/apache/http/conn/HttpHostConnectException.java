/*    */ package org.apache.http.conn;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.net.ConnectException;
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
/*    */ public class HttpHostConnectException
/*    */   extends ConnectException
/*    */ {
/*    */   private static final long serialVersionUID = -3194482710275220224L;
/*    */   private final HttpHost host;
/*    */   
/*    */   @Deprecated
/*    */   public HttpHostConnectException(HttpHost paramHttpHost, ConnectException paramConnectException) {
/* 54 */     this(paramConnectException, paramHttpHost, (InetAddress[])null);
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
/*    */   public HttpHostConnectException(IOException paramIOException, HttpHost paramHttpHost, InetAddress... paramVarArgs) {
/* 66 */     super("Connect to " + ((paramHttpHost != null) ? paramHttpHost.toHostString() : "remote host") + ((paramVarArgs != null && paramVarArgs.length > 0) ? (" " + Arrays.<InetAddress>asList(paramVarArgs)) : "") + ((paramIOException != null && paramIOException.getMessage() != null) ? (" failed: " + paramIOException.getMessage()) : " refused"));
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 72 */     this.host = paramHttpHost;
/* 73 */     initCause(paramIOException);
/*    */   }
/*    */   
/*    */   public HttpHost getHost() {
/* 77 */     return this.host;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\conn\HttpHostConnectException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */