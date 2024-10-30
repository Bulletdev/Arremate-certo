/*    */ package org.apache.http.conn.scheme;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.net.InetAddress;
/*    */ import java.net.InetSocketAddress;
/*    */ import java.net.Socket;
/*    */ import java.net.UnknownHostException;
/*    */ import org.apache.http.conn.ConnectTimeoutException;
/*    */ import org.apache.http.params.BasicHttpParams;
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
/*    */ class SocketFactoryAdaptor
/*    */   implements SocketFactory
/*    */ {
/*    */   private final SchemeSocketFactory factory;
/*    */   
/*    */   SocketFactoryAdaptor(SchemeSocketFactory paramSchemeSocketFactory) {
/* 50 */     this.factory = paramSchemeSocketFactory;
/*    */   }
/*    */ 
/*    */   
/*    */   public Socket createSocket() throws IOException {
/* 55 */     BasicHttpParams basicHttpParams = new BasicHttpParams();
/* 56 */     return this.factory.createSocket((HttpParams)basicHttpParams);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Socket connectSocket(Socket paramSocket, String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2, HttpParams paramHttpParams) throws IOException, UnknownHostException, ConnectTimeoutException {
/* 65 */     InetSocketAddress inetSocketAddress1 = null;
/* 66 */     if (paramInetAddress != null || paramInt2 > 0) {
/* 67 */       inetSocketAddress1 = new InetSocketAddress(paramInetAddress, (paramInt2 > 0) ? paramInt2 : 0);
/*    */     }
/* 69 */     InetAddress inetAddress = InetAddress.getByName(paramString);
/* 70 */     InetSocketAddress inetSocketAddress2 = new InetSocketAddress(inetAddress, paramInt1);
/* 71 */     return this.factory.connectSocket(paramSocket, inetSocketAddress2, inetSocketAddress1, paramHttpParams);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isSecure(Socket paramSocket) throws IllegalArgumentException {
/* 76 */     return this.factory.isSecure(paramSocket);
/*    */   }
/*    */   
/*    */   public SchemeSocketFactory getFactory() {
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
/* 91 */     return (paramObject instanceof SocketFactoryAdaptor) ? this.factory.equals(((SocketFactoryAdaptor)paramObject).factory) : this.factory.equals(paramObject);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 98 */     return this.factory.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\conn\scheme\SocketFactoryAdaptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */