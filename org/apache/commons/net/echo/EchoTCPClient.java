/*    */ package org.apache.commons.net.echo;
/*    */ 
/*    */ import java.io.InputStream;
/*    */ import org.apache.commons.net.discard.DiscardTCPClient;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class EchoTCPClient
/*    */   extends DiscardTCPClient
/*    */ {
/*    */   public static final int DEFAULT_PORT = 7;
/*    */   
/*    */   public EchoTCPClient() {
/* 52 */     setDefaultPort(7);
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
/*    */   public InputStream getInputStream() {
/* 67 */     return this._input_;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\echo\EchoTCPClient.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */