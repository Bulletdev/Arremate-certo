/*    */ package org.apache.http.conn.socket;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.net.InetSocketAddress;
/*    */ import java.net.Socket;
/*    */ import org.apache.http.HttpHost;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.protocol.HttpContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */ public class PlainConnectionSocketFactory
/*    */   implements ConnectionSocketFactory
/*    */ {
/* 47 */   public static final PlainConnectionSocketFactory INSTANCE = new PlainConnectionSocketFactory();
/*    */   
/*    */   public static PlainConnectionSocketFactory getSocketFactory() {
/* 50 */     return INSTANCE;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Socket createSocket(HttpContext paramHttpContext) throws IOException {
/* 59 */     return new Socket();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Socket connectSocket(int paramInt, Socket paramSocket, HttpHost paramHttpHost, InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2, HttpContext paramHttpContext) throws IOException {
/* 70 */     Socket socket = (paramSocket != null) ? paramSocket : createSocket(paramHttpContext);
/* 71 */     if (paramInetSocketAddress2 != null) {
/* 72 */       socket.bind(paramInetSocketAddress2);
/*    */     }
/*    */     try {
/* 75 */       socket.connect(paramInetSocketAddress1, paramInt);
/* 76 */     } catch (IOException iOException) {
/*    */       try {
/* 78 */         socket.close();
/* 79 */       } catch (IOException iOException1) {}
/*    */       
/* 81 */       throw iOException;
/*    */     } 
/* 83 */     return socket;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\conn\socket\PlainConnectionSocketFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */