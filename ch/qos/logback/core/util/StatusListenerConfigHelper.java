/*    */ package ch.qos.logback.core.util;
/*    */ 
/*    */ import ch.qos.logback.core.Context;
/*    */ import ch.qos.logback.core.spi.ContextAware;
/*    */ import ch.qos.logback.core.spi.LifeCycle;
/*    */ import ch.qos.logback.core.status.OnConsoleStatusListener;
/*    */ import ch.qos.logback.core.status.StatusListener;
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
/*    */ public class StatusListenerConfigHelper
/*    */ {
/*    */   public static void installIfAsked(Context paramContext) {
/* 26 */     String str = OptionHelper.getSystemProperty("logback.statusListenerClass");
/* 27 */     if (!OptionHelper.isEmpty(str))
/* 28 */       addStatusListener(paramContext, str); 
/*    */   }
/*    */   
/*    */   private static void addStatusListener(Context paramContext, String paramString) {
/*    */     StatusListener statusListener;
/* 33 */     OnConsoleStatusListener onConsoleStatusListener = null;
/* 34 */     if ("SYSOUT".equalsIgnoreCase(paramString)) {
/* 35 */       onConsoleStatusListener = new OnConsoleStatusListener();
/*    */     } else {
/* 37 */       statusListener = createListenerPerClassName(paramContext, paramString);
/*    */     } 
/* 39 */     initAndAddListener(paramContext, statusListener);
/*    */   }
/*    */   
/*    */   private static void initAndAddListener(Context paramContext, StatusListener paramStatusListener) {
/* 43 */     if (paramStatusListener != null) {
/* 44 */       if (paramStatusListener instanceof ContextAware) {
/* 45 */         ((ContextAware)paramStatusListener).setContext(paramContext);
/*    */       }
/* 47 */       boolean bool = paramContext.getStatusManager().add(paramStatusListener);
/* 48 */       if (bool && paramStatusListener instanceof LifeCycle) {
/* 49 */         ((LifeCycle)paramStatusListener).start();
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   private static StatusListener createListenerPerClassName(Context paramContext, String paramString) {
/*    */     try {
/* 56 */       return (StatusListener)OptionHelper.instantiateByClassName(paramString, StatusListener.class, paramContext);
/* 57 */     } catch (Exception exception) {
/*    */       
/* 59 */       exception.printStackTrace();
/* 60 */       return null;
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
/*    */   public static void addOnConsoleListenerInstance(Context paramContext, OnConsoleStatusListener paramOnConsoleStatusListener) {
/* 72 */     paramOnConsoleStatusListener.setContext(paramContext);
/* 73 */     boolean bool = paramContext.getStatusManager().add((StatusListener)paramOnConsoleStatusListener);
/* 74 */     if (bool)
/* 75 */       paramOnConsoleStatusListener.start(); 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\cor\\util\StatusListenerConfigHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */