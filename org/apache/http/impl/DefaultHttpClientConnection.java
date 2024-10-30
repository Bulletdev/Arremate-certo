/*    */ package org.apache.http.impl;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.net.Socket;
/*    */ import org.apache.http.params.HttpParams;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ @Deprecated
/*    */ public class DefaultHttpClientConnection
/*    */   extends SocketHttpClientConnection
/*    */ {
/*    */   public void bind(Socket paramSocket, HttpParams paramHttpParams) throws IOException {
/* 55 */     Args.notNull(paramSocket, "Socket");
/* 56 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 57 */     assertNotOpen();
/* 58 */     paramSocket.setTcpNoDelay(paramHttpParams.getBooleanParameter("http.tcp.nodelay", true));
/* 59 */     paramSocket.setSoTimeout(paramHttpParams.getIntParameter("http.socket.timeout", 0));
/* 60 */     paramSocket.setKeepAlive(paramHttpParams.getBooleanParameter("http.socket.keepalive", false));
/* 61 */     int i = paramHttpParams.getIntParameter("http.socket.linger", -1);
/* 62 */     if (i >= 0) {
/* 63 */       paramSocket.setSoLinger((i > 0), i);
/*    */     }
/* 65 */     super.bind(paramSocket, paramHttpParams);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\DefaultHttpClientConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */