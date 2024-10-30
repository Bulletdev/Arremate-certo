/*    */ package org.apache.http.protocol;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.net.InetAddress;
/*    */ import org.apache.http.HttpConnection;
/*    */ import org.apache.http.HttpException;
/*    */ import org.apache.http.HttpHost;
/*    */ import org.apache.http.HttpInetConnection;
/*    */ import org.apache.http.HttpRequest;
/*    */ import org.apache.http.HttpRequestInterceptor;
/*    */ import org.apache.http.HttpVersion;
/*    */ import org.apache.http.ProtocolException;
/*    */ import org.apache.http.ProtocolVersion;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*    */ public class RequestTargetHost
/*    */   implements HttpRequestInterceptor
/*    */ {
/*    */   public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws HttpException, IOException {
/* 62 */     Args.notNull(paramHttpRequest, "HTTP request");
/*    */     
/* 64 */     HttpCoreContext httpCoreContext = HttpCoreContext.adapt(paramHttpContext);
/*    */     
/* 66 */     ProtocolVersion protocolVersion = paramHttpRequest.getRequestLine().getProtocolVersion();
/* 67 */     String str = paramHttpRequest.getRequestLine().getMethod();
/* 68 */     if (str.equalsIgnoreCase("CONNECT") && protocolVersion.lessEquals((ProtocolVersion)HttpVersion.HTTP_1_0)) {
/*    */       return;
/*    */     }
/*    */     
/* 72 */     if (!paramHttpRequest.containsHeader("Host")) {
/* 73 */       HttpHost httpHost = httpCoreContext.getTargetHost();
/* 74 */       if (httpHost == null) {
/* 75 */         HttpConnection httpConnection = httpCoreContext.getConnection();
/* 76 */         if (httpConnection instanceof HttpInetConnection) {
/*    */ 
/*    */           
/* 79 */           InetAddress inetAddress = ((HttpInetConnection)httpConnection).getRemoteAddress();
/* 80 */           int i = ((HttpInetConnection)httpConnection).getRemotePort();
/* 81 */           if (inetAddress != null) {
/* 82 */             httpHost = new HttpHost(inetAddress.getHostName(), i);
/*    */           }
/*    */         } 
/* 85 */         if (httpHost == null) {
/* 86 */           if (protocolVersion.lessEquals((ProtocolVersion)HttpVersion.HTTP_1_0)) {
/*    */             return;
/*    */           }
/* 89 */           throw new ProtocolException("Target host missing");
/*    */         } 
/*    */       } 
/* 92 */       paramHttpRequest.addHeader("Host", httpHost.toHostString());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\protocol\RequestTargetHost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */