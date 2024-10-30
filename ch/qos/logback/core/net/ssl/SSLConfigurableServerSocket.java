/*    */ package ch.qos.logback.core.net.ssl;
/*    */ 
/*    */ import javax.net.ssl.SSLServerSocket;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSLConfigurableServerSocket
/*    */   implements SSLConfigurable
/*    */ {
/*    */   private final SSLServerSocket delegate;
/*    */   
/*    */   public SSLConfigurableServerSocket(SSLServerSocket paramSSLServerSocket) {
/* 29 */     this.delegate = paramSSLServerSocket;
/*    */   }
/*    */   
/*    */   public String[] getDefaultProtocols() {
/* 33 */     return this.delegate.getEnabledProtocols();
/*    */   }
/*    */   
/*    */   public String[] getSupportedProtocols() {
/* 37 */     return this.delegate.getSupportedProtocols();
/*    */   }
/*    */   
/*    */   public void setEnabledProtocols(String[] paramArrayOfString) {
/* 41 */     this.delegate.setEnabledProtocols(paramArrayOfString);
/*    */   }
/*    */   
/*    */   public String[] getDefaultCipherSuites() {
/* 45 */     return this.delegate.getEnabledCipherSuites();
/*    */   }
/*    */   
/*    */   public String[] getSupportedCipherSuites() {
/* 49 */     return this.delegate.getSupportedCipherSuites();
/*    */   }
/*    */   
/*    */   public void setEnabledCipherSuites(String[] paramArrayOfString) {
/* 53 */     this.delegate.setEnabledCipherSuites(paramArrayOfString);
/*    */   }
/*    */   
/*    */   public void setNeedClientAuth(boolean paramBoolean) {
/* 57 */     this.delegate.setNeedClientAuth(paramBoolean);
/*    */   }
/*    */   
/*    */   public void setWantClientAuth(boolean paramBoolean) {
/* 61 */     this.delegate.setWantClientAuth(paramBoolean);
/*    */   }
/*    */   
/*    */   public void setHostnameVerification(boolean paramBoolean) {}
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\net\ssl\SSLConfigurableServerSocket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */