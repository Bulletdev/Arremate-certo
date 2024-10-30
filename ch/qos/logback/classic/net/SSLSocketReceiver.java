/*    */ package ch.qos.logback.classic.net;
/*    */ 
/*    */ import ch.qos.logback.core.net.ssl.ConfigurableSSLSocketFactory;
/*    */ import ch.qos.logback.core.net.ssl.SSLComponent;
/*    */ import ch.qos.logback.core.net.ssl.SSLConfiguration;
/*    */ import ch.qos.logback.core.net.ssl.SSLParametersConfiguration;
/*    */ import ch.qos.logback.core.spi.ContextAware;
/*    */ import javax.net.SocketFactory;
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
/*    */ public class SSLSocketReceiver
/*    */   extends SocketReceiver
/*    */   implements SSLComponent
/*    */ {
/*    */   private SSLConfiguration ssl;
/*    */   private SocketFactory socketFactory;
/*    */   
/*    */   protected SocketFactory getSocketFactory() {
/* 41 */     return this.socketFactory;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean shouldStart() {
/*    */     try {
/* 50 */       SSLContext sSLContext = getSsl().createContext((ContextAware)this);
/* 51 */       SSLParametersConfiguration sSLParametersConfiguration = getSsl().getParameters();
/* 52 */       sSLParametersConfiguration.setContext(getContext());
/* 53 */       this.socketFactory = (SocketFactory)new ConfigurableSSLSocketFactory(sSLParametersConfiguration, sSLContext.getSocketFactory());
/* 54 */       return super.shouldStart();
/* 55 */     } catch (Exception exception) {
/* 56 */       addError(exception.getMessage(), exception);
/* 57 */       return false;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public SSLConfiguration getSsl() {
/* 67 */     if (this.ssl == null) {
/* 68 */       this.ssl = new SSLConfiguration();
/*    */     }
/* 70 */     return this.ssl;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setSsl(SSLConfiguration paramSSLConfiguration) {
/* 78 */     this.ssl = paramSSLConfiguration;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\net\SSLSocketReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */