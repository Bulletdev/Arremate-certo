/*    */ package ch.qos.logback.core.net.ssl;
/*    */ 
/*    */ import ch.qos.logback.core.joran.spi.DefaultNestedComponentRegistry;
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
/*    */ public class SSLNestedComponentRegistryRules
/*    */ {
/*    */   public static void addDefaultNestedComponentRegistryRules(DefaultNestedComponentRegistry paramDefaultNestedComponentRegistry) {
/* 27 */     paramDefaultNestedComponentRegistry.add(SSLComponent.class, "ssl", SSLConfiguration.class);
/* 28 */     paramDefaultNestedComponentRegistry.add(SSLConfiguration.class, "parameters", SSLParametersConfiguration.class);
/* 29 */     paramDefaultNestedComponentRegistry.add(SSLConfiguration.class, "keyStore", KeyStoreFactoryBean.class);
/* 30 */     paramDefaultNestedComponentRegistry.add(SSLConfiguration.class, "trustStore", KeyStoreFactoryBean.class);
/* 31 */     paramDefaultNestedComponentRegistry.add(SSLConfiguration.class, "keyManagerFactory", KeyManagerFactoryFactoryBean.class);
/* 32 */     paramDefaultNestedComponentRegistry.add(SSLConfiguration.class, "trustManagerFactory", TrustManagerFactoryFactoryBean.class);
/* 33 */     paramDefaultNestedComponentRegistry.add(SSLConfiguration.class, "secureRandom", SecureRandomFactoryBean.class);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\net\ssl\SSLNestedComponentRegistryRules.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */