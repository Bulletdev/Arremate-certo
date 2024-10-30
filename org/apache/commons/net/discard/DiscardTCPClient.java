/*    */ package org.apache.commons.net.discard;
/*    */ 
/*    */ import java.io.OutputStream;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DiscardTCPClient
/*    */   extends SocketClient
/*    */ {
/*    */   public static final int DEFAULT_PORT = 9;
/*    */   
/*    */   public DiscardTCPClient() {
/* 49 */     setDefaultPort(9);
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
/*    */   public OutputStream getOutputStream() {
/* 63 */     return this._output_;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\discard\DiscardTCPClient.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */