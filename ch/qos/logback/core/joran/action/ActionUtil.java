/*    */ package ch.qos.logback.core.joran.action;
/*    */ 
/*    */ import ch.qos.logback.core.joran.spi.InterpretationContext;
/*    */ import ch.qos.logback.core.spi.ContextAware;
/*    */ import ch.qos.logback.core.util.ContextUtil;
/*    */ import ch.qos.logback.core.util.OptionHelper;
/*    */ import java.util.Properties;
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
/*    */ public class ActionUtil
/*    */ {
/*    */   public enum Scope
/*    */   {
/* 25 */     LOCAL, CONTEXT, SYSTEM;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Scope stringToScope(String paramString) {
/* 34 */     if (Scope.SYSTEM.toString().equalsIgnoreCase(paramString))
/* 35 */       return Scope.SYSTEM; 
/* 36 */     if (Scope.CONTEXT.toString().equalsIgnoreCase(paramString)) {
/* 37 */       return Scope.CONTEXT;
/*    */     }
/* 39 */     return Scope.LOCAL;
/*    */   }
/*    */   
/*    */   public static void setProperty(InterpretationContext paramInterpretationContext, String paramString1, String paramString2, Scope paramScope) {
/* 43 */     switch (null.p[paramScope.ordinal()]) {
/*    */       case 1:
/* 45 */         paramInterpretationContext.addSubstitutionProperty(paramString1, paramString2);
/*    */         break;
/*    */       case 2:
/* 48 */         paramInterpretationContext.getContext().putProperty(paramString1, paramString2);
/*    */         break;
/*    */       case 3:
/* 51 */         OptionHelper.setSystemProperty((ContextAware)paramInterpretationContext, paramString1, paramString2);
/*    */         break;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void setProperties(InterpretationContext paramInterpretationContext, Properties paramProperties, Scope paramScope) {
/*    */     ContextUtil contextUtil;
/* 60 */     switch (null.p[paramScope.ordinal()]) {
/*    */       case 1:
/* 62 */         paramInterpretationContext.addSubstitutionProperties(paramProperties);
/*    */         break;
/*    */       case 2:
/* 65 */         contextUtil = new ContextUtil(paramInterpretationContext.getContext());
/* 66 */         contextUtil.addProperties(paramProperties);
/*    */         break;
/*    */       case 3:
/* 69 */         OptionHelper.setSystemProperties((ContextAware)paramInterpretationContext, paramProperties);
/*    */         break;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\action\ActionUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */