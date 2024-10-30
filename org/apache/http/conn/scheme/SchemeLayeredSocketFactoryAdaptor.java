/*    */ package org.apache.http.conn.scheme;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.net.Socket;
/*    */ import java.net.UnknownHostException;
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
/*    */ @Deprecated
/*    */ class SchemeLayeredSocketFactoryAdaptor
/*    */   extends SchemeSocketFactoryAdaptor
/*    */   implements SchemeLayeredSocketFactory
/*    */ {
/*    */   private final LayeredSocketFactory factory;
/*    */   
/*    */   SchemeLayeredSocketFactoryAdaptor(LayeredSocketFactory paramLayeredSocketFactory) {
/* 46 */     super(paramLayeredSocketFactory);
/* 47 */     this.factory = paramLayeredSocketFactory;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Socket createLayeredSocket(Socket paramSocket, String paramString, int paramInt, HttpParams paramHttpParams) throws IOException, UnknownHostException {
/* 55 */     return this.factory.createSocket(paramSocket, paramString, paramInt, true);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\conn\scheme\SchemeLayeredSocketFactoryAdaptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */