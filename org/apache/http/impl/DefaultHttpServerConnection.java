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
/*    */ @Deprecated
/*    */ public class DefaultHttpServerConnection
/*    */   extends SocketHttpServerConnection
/*    */ {
/*    */   public void bind(Socket paramSocket, HttpParams paramHttpParams) throws IOException {
/* 53 */     Args.notNull(paramSocket, "Socket");
/* 54 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 55 */     assertNotOpen();
/* 56 */     paramSocket.setTcpNoDelay(paramHttpParams.getBooleanParameter("http.tcp.nodelay", true));
/* 57 */     paramSocket.setSoTimeout(paramHttpParams.getIntParameter("http.socket.timeout", 0));
/* 58 */     paramSocket.setKeepAlive(paramHttpParams.getBooleanParameter("http.socket.keepalive", false));
/* 59 */     int i = paramHttpParams.getIntParameter("http.socket.linger", -1);
/* 60 */     if (i >= 0) {
/* 61 */       paramSocket.setSoLinger((i > 0), i);
/*    */     }
/* 63 */     if (i >= 0) {
/* 64 */       paramSocket.setSoLinger((i > 0), i);
/*    */     }
/* 66 */     super.bind(paramSocket, paramHttpParams);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\DefaultHttpServerConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */