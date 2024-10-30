/*    */ package org.apache.http.conn.scheme;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.net.Socket;
/*    */ import java.net.UnknownHostException;
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
/*    */ class LayeredSocketFactoryAdaptor
/*    */   extends SocketFactoryAdaptor
/*    */   implements LayeredSocketFactory
/*    */ {
/*    */   private final LayeredSchemeSocketFactory factory;
/*    */   
/*    */   LayeredSocketFactoryAdaptor(LayeredSchemeSocketFactory paramLayeredSchemeSocketFactory) {
/* 43 */     super(paramLayeredSchemeSocketFactory);
/* 44 */     this.factory = paramLayeredSchemeSocketFactory;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean) throws IOException, UnknownHostException {
/* 51 */     return this.factory.createLayeredSocket(paramSocket, paramString, paramInt, paramBoolean);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\conn\scheme\LayeredSocketFactoryAdaptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */