/*    */ package ch.qos.logback.classic.util;
/*    */ 
/*    */ import ch.qos.logback.classic.LoggerContext;
/*    */ import ch.qos.logback.classic.selector.ContextJNDISelector;
/*    */ import ch.qos.logback.classic.selector.ContextSelector;
/*    */ import ch.qos.logback.classic.selector.DefaultContextSelector;
/*    */ import ch.qos.logback.core.util.Loader;
/*    */ import ch.qos.logback.core.util.OptionHelper;
/*    */ import java.lang.reflect.Constructor;
/*    */ import java.lang.reflect.InvocationTargetException;
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
/*    */ public class ContextSelectorStaticBinder
/*    */ {
/* 35 */   static ContextSelectorStaticBinder singleton = new ContextSelectorStaticBinder();
/*    */   
/*    */   ContextSelector contextSelector;
/*    */   Object key;
/*    */   
/*    */   public static ContextSelectorStaticBinder getSingleton() {
/* 41 */     return singleton;
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
/*    */   
/*    */   public void init(LoggerContext paramLoggerContext, Object paramObject) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
/* 56 */     if (this.key == null) {
/* 57 */       this.key = paramObject;
/* 58 */     } else if (this.key != paramObject) {
/* 59 */       throw new IllegalAccessException("Only certain classes can access this method.");
/*    */     } 
/*    */     
/* 62 */     String str = OptionHelper.getSystemProperty("logback.ContextSelector");
/* 63 */     if (str == null) {
/* 64 */       this.contextSelector = (ContextSelector)new DefaultContextSelector(paramLoggerContext);
/* 65 */     } else if (str.equals("JNDI")) {
/*    */       
/* 67 */       this.contextSelector = (ContextSelector)new ContextJNDISelector(paramLoggerContext);
/*    */     } else {
/* 69 */       this.contextSelector = dynamicalContextSelector(paramLoggerContext, str);
/*    */     } 
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   static ContextSelector dynamicalContextSelector(LoggerContext paramLoggerContext, String paramString) throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
/* 91 */     Class clazz = Loader.loadClass(paramString);
/* 92 */     Constructor<ContextSelector> constructor = clazz.getConstructor(new Class[] { LoggerContext.class });
/* 93 */     return constructor.newInstance(new Object[] { paramLoggerContext });
/*    */   }
/*    */   
/*    */   public ContextSelector getContextSelector() {
/* 97 */     return this.contextSelector;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classi\\util\ContextSelectorStaticBinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */