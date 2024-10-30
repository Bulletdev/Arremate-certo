/*    */ package ch.qos.logback.core.net.server;
/*    */ 
/*    */ import ch.qos.logback.core.net.ssl.ConfigurableSSLServerSocketFactory;
/*    */ import ch.qos.logback.core.net.ssl.SSLComponent;
/*    */ import ch.qos.logback.core.net.ssl.SSLConfiguration;
/*    */ import ch.qos.logback.core.net.ssl.SSLParametersConfiguration;
/*    */ import ch.qos.logback.core.spi.ContextAware;
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
/*    */ public abstract class SSLServerSocketAppenderBase<E>
/*    */   extends AbstractServerSocketAppender<E>
/*    */   implements SSLComponent
/*    */ {
/*    */   private SSLConfiguration ssl;
/*    */   private ServerSocketFactory socketFactory;
/*    */   
/*    */   protected ServerSocketFactory getServerSocketFactory() {
/* 38 */     return this.socketFactory;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void start() {
/*    */     try {
/* 47 */       SSLContext sSLContext = getSsl().createContext((ContextAware)this);
/* 48 */       SSLParametersConfiguration sSLParametersConfiguration = getSsl().getParameters();
/* 49 */       sSLParametersConfiguration.setContext(getContext());
/* 50 */       this.socketFactory = (ServerSocketFactory)new ConfigurableSSLServerSocketFactory(sSLParametersConfiguration, sSLContext.getServerSocketFactory());
/* 51 */       super.start();
/* 52 */     } catch (Exception exception) {
/* 53 */       addError(exception.getMessage(), exception);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public SSLConfiguration getSsl() {
/* 63 */     if (this.ssl == null) {
/* 64 */       this.ssl = new SSLConfiguration();
/*    */     }
/* 66 */     return this.ssl;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setSsl(SSLConfiguration paramSSLConfiguration) {
/* 74 */     this.ssl = paramSSLConfiguration;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\net\server\SSLServerSocketAppenderBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */