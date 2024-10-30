/*    */ package org.apache.http.impl.io;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Deprecated
/*    */ public class SocketOutputBuffer
/*    */   extends AbstractSessionOutputBuffer
/*    */ {
/*    */   public SocketOutputBuffer(Socket paramSocket, int paramInt, HttpParams paramHttpParams) throws IOException {
/* 62 */     Args.notNull(paramSocket, "Socket");
/* 63 */     int i = paramInt;
/* 64 */     if (i < 0) {
/* 65 */       i = paramSocket.getSendBufferSize();
/*    */     }
/* 67 */     if (i < 1024) {
/* 68 */       i = 1024;
/*    */     }
/* 70 */     init(paramSocket.getOutputStream(), i, paramHttpParams);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\io\SocketOutputBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */