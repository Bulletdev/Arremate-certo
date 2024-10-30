/*    */ package ch.qos.logback.core.joran.spi;
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
/*    */ public class NoAutoStartUtil
/*    */ {
/*    */   public static boolean notMarkedWithNoAutoStart(Object paramObject) {
/* 26 */     if (paramObject == null) {
/* 27 */       return false;
/*    */     }
/* 29 */     Class<?> clazz = paramObject.getClass();
/* 30 */     NoAutoStart noAutoStart = clazz.<NoAutoStart>getAnnotation(NoAutoStart.class);
/* 31 */     return (noAutoStart == null);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\spi\NoAutoStartUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */