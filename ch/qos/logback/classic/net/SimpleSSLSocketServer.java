/*    */ package ch.qos.logback.classic.net;
/*    */ 
/*    */ import ch.qos.logback.classic.LoggerContext;
/*    */ import ch.qos.logback.core.Context;
/*    */ import ch.qos.logback.core.net.ssl.ConfigurableSSLServerSocketFactory;
/*    */ import ch.qos.logback.core.net.ssl.SSLParametersConfiguration;
/*    */ import java.security.NoSuchAlgorithmException;
/*    */ import javax.net.ServerSocketFactory;
/*    */ import javax.net.ssl.SSLContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SimpleSSLSocketServer
/*    */   extends SimpleSocketServer
/*    */ {
/*    */   private final ServerSocketFactory socketFactory;
/*    */   
/*    */   public static void main(String[] paramArrayOfString) throws Exception {
/* 62 */     doMain((Class)SimpleSSLSocketServer.class, paramArrayOfString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public SimpleSSLSocketServer(LoggerContext paramLoggerContext, int paramInt) throws NoSuchAlgorithmException {
/* 73 */     this(paramLoggerContext, paramInt, SSLContext.getDefault());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public SimpleSSLSocketServer(LoggerContext paramLoggerContext, int paramInt, SSLContext paramSSLContext) {
/* 83 */     super(paramLoggerContext, paramInt);
/* 84 */     if (paramSSLContext == null) {
/* 85 */       throw new NullPointerException("SSL context required");
/*    */     }
/* 87 */     SSLParametersConfiguration sSLParametersConfiguration = new SSLParametersConfiguration();
/*    */     
/* 89 */     sSLParametersConfiguration.setContext((Context)paramLoggerContext);
/* 90 */     this.socketFactory = (ServerSocketFactory)new ConfigurableSSLServerSocketFactory(sSLParametersConfiguration, paramSSLContext.getServerSocketFactory());
/*    */   }
/*    */ 
/*    */   
/*    */   protected ServerSocketFactory getServerSocketFactory() {
/* 95 */     return this.socketFactory;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\net\SimpleSSLSocketServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */