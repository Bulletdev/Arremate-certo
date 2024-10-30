/*    */ package org.apache.http.conn.scheme;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.net.InetSocketAddress;
/*    */ import java.net.Socket;
/*    */ import java.net.UnknownHostException;
/*    */ import org.apache.http.conn.ConnectTimeoutException;
/*    */ import org.apache.http.params.HttpParams;
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
/*    */ class SchemeLayeredSocketFactoryAdaptor2
/*    */   implements SchemeLayeredSocketFactory
/*    */ {
/*    */   private final LayeredSchemeSocketFactory factory;
/*    */   
/*    */   SchemeLayeredSocketFactoryAdaptor2(LayeredSchemeSocketFactory paramLayeredSchemeSocketFactory) {
/* 48 */     this.factory = paramLayeredSchemeSocketFactory;
/*    */   }
/*    */ 
/*    */   
/*    */   public Socket createSocket(HttpParams paramHttpParams) throws IOException {
/* 53 */     return this.factory.createSocket(paramHttpParams);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Socket connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2, HttpParams paramHttpParams) throws IOException, UnknownHostException, ConnectTimeoutException {
/* 62 */     return this.factory.connectSocket(paramSocket, paramInetSocketAddress1, paramInetSocketAddress2, paramHttpParams);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isSecure(Socket paramSocket) throws IllegalArgumentException {
/* 67 */     return this.factory.isSecure(paramSocket);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Socket createLayeredSocket(Socket paramSocket, String paramString, int paramInt, HttpParams paramHttpParams) throws IOException, UnknownHostException {
/* 75 */     return this.factory.createLayeredSocket(paramSocket, paramString, paramInt, true);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\conn\scheme\SchemeLayeredSocketFactoryAdaptor2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */