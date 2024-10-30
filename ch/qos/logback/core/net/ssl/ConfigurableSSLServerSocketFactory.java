/*    */ package ch.qos.logback.core.net.ssl;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.net.InetAddress;
/*    */ import java.net.ServerSocket;
/*    */ import javax.net.ServerSocketFactory;
/*    */ import javax.net.ssl.SSLServerSocket;
/*    */ import javax.net.ssl.SSLServerSocketFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ConfigurableSSLServerSocketFactory
/*    */   extends ServerSocketFactory
/*    */ {
/*    */   private final SSLParametersConfiguration parameters;
/*    */   private final SSLServerSocketFactory delegate;
/*    */   
/*    */   public ConfigurableSSLServerSocketFactory(SSLParametersConfiguration paramSSLParametersConfiguration, SSLServerSocketFactory paramSSLServerSocketFactory) {
/* 49 */     this.parameters = paramSSLParametersConfiguration;
/* 50 */     this.delegate = paramSSLServerSocketFactory;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ServerSocket createServerSocket(int paramInt1, int paramInt2, InetAddress paramInetAddress) throws IOException {
/* 58 */     SSLServerSocket sSLServerSocket = (SSLServerSocket)this.delegate.createServerSocket(paramInt1, paramInt2, paramInetAddress);
/* 59 */     this.parameters.configure(new SSLConfigurableServerSocket(sSLServerSocket));
/* 60 */     return sSLServerSocket;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ServerSocket createServerSocket(int paramInt1, int paramInt2) throws IOException {
/* 68 */     SSLServerSocket sSLServerSocket = (SSLServerSocket)this.delegate.createServerSocket(paramInt1, paramInt2);
/* 69 */     this.parameters.configure(new SSLConfigurableServerSocket(sSLServerSocket));
/* 70 */     return sSLServerSocket;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ServerSocket createServerSocket(int paramInt) throws IOException {
/* 78 */     SSLServerSocket sSLServerSocket = (SSLServerSocket)this.delegate.createServerSocket(paramInt);
/* 79 */     this.parameters.configure(new SSLConfigurableServerSocket(sSLServerSocket));
/* 80 */     return sSLServerSocket;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\net\ssl\ConfigurableSSLServerSocketFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */