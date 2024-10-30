/*    */ package org.h2.util;
/*    */ 
/*    */ import org.h2.Driver;
/*    */ import org.osgi.framework.BundleActivator;
/*    */ import org.osgi.framework.BundleContext;
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
/*    */ public class DbDriverActivator
/*    */   implements BundleActivator
/*    */ {
/*    */   private static final String DATASOURCE_FACTORY_CLASS = "org.osgi.service.jdbc.DataSourceFactory";
/*    */   
/*    */   public void start(BundleContext paramBundleContext) {
/* 29 */     Driver driver = Driver.load();
/*    */     try {
/* 31 */       JdbcUtils.loadUserClass("org.osgi.service.jdbc.DataSourceFactory");
/* 32 */     } catch (Exception exception) {
/*    */       return;
/*    */     } 
/*    */ 
/*    */     
/* 37 */     OsgiDataSourceFactory.registerService(paramBundleContext, driver);
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
/*    */   public void stop(BundleContext paramBundleContext) {
/* 49 */     Driver.unload();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\DbDriverActivator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */