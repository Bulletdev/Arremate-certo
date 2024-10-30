/*    */ package ch.qos.logback.core.net.ssl;
/*    */ 
/*    */ import javax.net.ssl.SSLParameters;
/*    */ import javax.net.ssl.SSLSocket;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSLConfigurableSocket
/*    */   implements SSLConfigurable
/*    */ {
/*    */   private final SSLSocket delegate;
/*    */   
/*    */   public SSLConfigurableSocket(SSLSocket paramSSLSocket) {
/* 30 */     this.delegate = paramSSLSocket;
/*    */   }
/*    */   
/*    */   public String[] getDefaultProtocols() {
/* 34 */     return this.delegate.getEnabledProtocols();
/*    */   }
/*    */   
/*    */   public String[] getSupportedProtocols() {
/* 38 */     return this.delegate.getSupportedProtocols();
/*    */   }
/*    */   
/*    */   public void setEnabledProtocols(String[] paramArrayOfString) {
/* 42 */     this.delegate.setEnabledProtocols(paramArrayOfString);
/*    */   }
/*    */   
/*    */   public String[] getDefaultCipherSuites() {
/* 46 */     return this.delegate.getEnabledCipherSuites();
/*    */   }
/*    */   
/*    */   public String[] getSupportedCipherSuites() {
/* 50 */     return this.delegate.getSupportedCipherSuites();
/*    */   }
/*    */   
/*    */   public void setEnabledCipherSuites(String[] paramArrayOfString) {
/* 54 */     this.delegate.setEnabledCipherSuites(paramArrayOfString);
/*    */   }
/*    */   
/*    */   public void setNeedClientAuth(boolean paramBoolean) {
/* 58 */     this.delegate.setNeedClientAuth(paramBoolean);
/*    */   }
/*    */   
/*    */   public void setWantClientAuth(boolean paramBoolean) {
/* 62 */     this.delegate.setWantClientAuth(paramBoolean);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setHostnameVerification(boolean paramBoolean) {
/* 67 */     if (!paramBoolean) {
/*    */       return;
/*    */     }
/* 70 */     SSLParameters sSLParameters = this.delegate.getSSLParameters();
/* 71 */     sSLParameters.setEndpointIdentificationAlgorithm("HTTPS");
/* 72 */     this.delegate.setSSLParameters(sSLParameters);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\net\ssl\SSLConfigurableSocket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */