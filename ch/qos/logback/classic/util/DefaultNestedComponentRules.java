/*    */ package ch.qos.logback.classic.util;
/*    */ 
/*    */ import ch.qos.logback.classic.PatternLayout;
/*    */ import ch.qos.logback.classic.boolex.JaninoEventEvaluator;
/*    */ import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
/*    */ import ch.qos.logback.core.AppenderBase;
/*    */ import ch.qos.logback.core.UnsynchronizedAppenderBase;
/*    */ import ch.qos.logback.core.filter.EvaluatorFilter;
/*    */ import ch.qos.logback.core.joran.spi.DefaultNestedComponentRegistry;
/*    */ import ch.qos.logback.core.net.ssl.SSLNestedComponentRegistryRules;
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
/*    */ public class DefaultNestedComponentRules
/*    */ {
/*    */   public static void addDefaultNestedComponentRegistryRules(DefaultNestedComponentRegistry paramDefaultNestedComponentRegistry) {
/* 35 */     paramDefaultNestedComponentRegistry.add(AppenderBase.class, "layout", PatternLayout.class);
/* 36 */     paramDefaultNestedComponentRegistry.add(UnsynchronizedAppenderBase.class, "layout", PatternLayout.class);
/*    */     
/* 38 */     paramDefaultNestedComponentRegistry.add(AppenderBase.class, "encoder", PatternLayoutEncoder.class);
/* 39 */     paramDefaultNestedComponentRegistry.add(UnsynchronizedAppenderBase.class, "encoder", PatternLayoutEncoder.class);
/*    */     
/* 41 */     paramDefaultNestedComponentRegistry.add(EvaluatorFilter.class, "evaluator", JaninoEventEvaluator.class);
/*    */     
/* 43 */     SSLNestedComponentRegistryRules.addDefaultNestedComponentRegistryRules(paramDefaultNestedComponentRegistry);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classi\\util\DefaultNestedComponentRules.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */