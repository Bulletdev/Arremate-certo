/*    */ package org.apache.http.conn.scheme;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.net.InetAddress;
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
/*    */ class SchemeSocketFactoryAdaptor
/*    */   implements SchemeSocketFactory
/*    */ {
/*    */   private final SocketFactory factory;
/*    */   
/*    */   SchemeSocketFactoryAdaptor(SocketFactory paramSocketFactory) {
/* 49 */     this.factory = paramSocketFactory;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Socket connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2, HttpParams paramHttpParams) throws IOException, UnknownHostException, ConnectTimeoutException {
/* 58 */     String str = paramInetSocketAddress1.getHostName();
/* 59 */     int i = paramInetSocketAddress1.getPort();
/* 60 */     InetAddress inetAddress = null;
/* 61 */     int j = 0;
/* 62 */     if (paramInetSocketAddress2 != null) {
/* 63 */       inetAddress = paramInetSocketAddress2.getAddress();
/* 64 */       j = paramInetSocketAddress2.getPort();
/*    */     } 
/* 66 */     return this.factory.connectSocket(paramSocket, str, i, inetAddress, j, paramHttpParams);
/*    */   }
/*    */ 
/*    */   
/*    */   public Socket createSocket(HttpParams paramHttpParams) throws IOException {
/* 71 */     return this.factory.createSocket();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isSecure(Socket paramSocket) throws IllegalArgumentException {
/* 76 */     return this.factory.isSecure(paramSocket);
/*    */   }
/*    */   
/*    */   public SocketFactory getFactory() {
/* 80 */     return this.factory;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 85 */     if (paramObject == null) {
/* 86 */       return false;
/*    */     }
/* 88 */     if (this == paramObject) {
/* 89 */       return true;
/*    */     }
/* 91 */     return (paramObject instanceof SchemeSocketFactoryAdaptor) ? this.factory.equals(((SchemeSocketFactoryAdaptor)paramObject).factory) : this.factory.equals(paramObject);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 98 */     return this.factory.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\conn\scheme\SchemeSocketFactoryAdaptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */