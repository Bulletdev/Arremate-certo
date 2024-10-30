/*    */ package ch.qos.logback.core.net.ssl;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.net.InetAddress;
/*    */ import java.net.Socket;
/*    */ import java.net.UnknownHostException;
/*    */ import javax.net.SocketFactory;
/*    */ import javax.net.ssl.SSLSocket;
/*    */ import javax.net.ssl.SSLSocketFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ConfigurableSSLSocketFactory
/*    */   extends SocketFactory
/*    */ {
/*    */   private final SSLParametersConfiguration parameters;
/*    */   private final SSLSocketFactory delegate;
/*    */   
/*    */   public ConfigurableSSLSocketFactory(SSLParametersConfiguration paramSSLParametersConfiguration, SSLSocketFactory paramSSLSocketFactory) {
/* 50 */     this.parameters = paramSSLParametersConfiguration;
/* 51 */     this.delegate = paramSSLSocketFactory;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2) throws IOException {
/* 59 */     SSLSocket sSLSocket = (SSLSocket)this.delegate.createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2);
/* 60 */     this.parameters.configure(new SSLConfigurableSocket(sSLSocket));
/* 61 */     return sSLSocket;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Socket createSocket(InetAddress paramInetAddress, int paramInt) throws IOException {
/* 69 */     SSLSocket sSLSocket = (SSLSocket)this.delegate.createSocket(paramInetAddress, paramInt);
/* 70 */     this.parameters.configure(new SSLConfigurableSocket(sSLSocket));
/* 71 */     return sSLSocket;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2) throws IOException, UnknownHostException {
/* 79 */     SSLSocket sSLSocket = (SSLSocket)this.delegate.createSocket(paramString, paramInt1, paramInetAddress, paramInt2);
/* 80 */     this.parameters.configure(new SSLConfigurableSocket(sSLSocket));
/* 81 */     return sSLSocket;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Socket createSocket(String paramString, int paramInt) throws IOException, UnknownHostException {
/* 89 */     SSLSocket sSLSocket = (SSLSocket)this.delegate.createSocket(paramString, paramInt);
/* 90 */     this.parameters.configure(new SSLConfigurableSocket(sSLSocket));
/* 91 */     return sSLSocket;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\net\ssl\ConfigurableSSLSocketFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */