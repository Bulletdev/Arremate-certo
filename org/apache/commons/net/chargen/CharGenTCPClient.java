/*    */ package org.apache.commons.net.chargen;
/*    */ 
/*    */ import java.io.InputStream;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class CharGenTCPClient
/*    */   extends SocketClient
/*    */ {
/*    */   public static final int SYSTAT_PORT = 11;
/*    */   public static final int NETSTAT_PORT = 15;
/*    */   public static final int QUOTE_OF_DAY_PORT = 17;
/*    */   public static final int CHARGEN_PORT = 19;
/*    */   public static final int DEFAULT_PORT = 19;
/*    */   
/*    */   public CharGenTCPClient() {
/* 64 */     setDefaultPort(19);
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
/*    */   public InputStream getInputStream() {
/* 78 */     return this._input_;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\chargen\CharGenTCPClient.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */