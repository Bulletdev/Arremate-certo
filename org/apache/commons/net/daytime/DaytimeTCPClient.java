/*    */ package org.apache.commons.net.daytime;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStreamReader;
/*    */ import org.apache.commons.net.SocketClient;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class DaytimeTCPClient
/*    */   extends SocketClient
/*    */ {
/*    */   public static final int DEFAULT_PORT = 13;
/* 44 */   private final char[] buffer = new char[64];
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public DaytimeTCPClient() {
/* 52 */     setDefaultPort(13);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getTime() throws IOException {
/* 71 */     StringBuilder stringBuilder = new StringBuilder(this.buffer.length);
/*    */ 
/*    */     
/* 74 */     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this._input_, getCharset()));
/*    */ 
/*    */     
/*    */     while (true) {
/* 78 */       int i = bufferedReader.read(this.buffer, 0, this.buffer.length);
/* 79 */       if (i <= 0) {
/*    */         break;
/*    */       }
/* 82 */       stringBuilder.append(this.buffer, 0, i);
/*    */     } 
/*    */     
/* 85 */     return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\daytime\DaytimeTCPClient.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */