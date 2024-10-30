/*    */ package org.apache.http.conn;
/*    */ 
/*    */ import java.net.InetAddress;
/*    */ import java.net.InetSocketAddress;
/*    */ import org.apache.http.HttpHost;
/*    */ import org.apache.http.util.Args;
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
/*    */ @Deprecated
/*    */ public class HttpInetSocketAddress
/*    */   extends InetSocketAddress
/*    */ {
/*    */   private static final long serialVersionUID = -6650701828361907957L;
/*    */   private final HttpHost httphost;
/*    */   
/*    */   public HttpInetSocketAddress(HttpHost paramHttpHost, InetAddress paramInetAddress, int paramInt) {
/* 51 */     super(paramInetAddress, paramInt);
/* 52 */     Args.notNull(paramHttpHost, "HTTP host");
/* 53 */     this.httphost = paramHttpHost;
/*    */   }
/*    */   
/*    */   public HttpHost getHttpHost() {
/* 57 */     return this.httphost;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 62 */     return this.httphost.getHostName() + ":" + getPort();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\conn\HttpInetSocketAddress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */