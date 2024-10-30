/*    */ package org.apache.http.util;
/*    */ 
/*    */ import java.lang.reflect.Method;
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
/*    */ @Deprecated
/*    */ public final class ExceptionUtils
/*    */ {
/* 43 */   private static final Method INIT_CAUSE_METHOD = getInitCauseMethod();
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
/*    */   private static Method getInitCauseMethod() {
/*    */     try {
/* 56 */       Class[] arrayOfClass = { Throwable.class };
/* 57 */       return Throwable.class.getMethod("initCause", arrayOfClass);
/* 58 */     } catch (NoSuchMethodException noSuchMethodException) {
/* 59 */       return null;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void initCause(Throwable paramThrowable1, Throwable paramThrowable2) {
/* 70 */     if (INIT_CAUSE_METHOD != null)
/*    */       try {
/* 72 */         INIT_CAUSE_METHOD.invoke(paramThrowable1, new Object[] { paramThrowable2 });
/* 73 */       } catch (Exception exception) {} 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\htt\\util\ExceptionUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */