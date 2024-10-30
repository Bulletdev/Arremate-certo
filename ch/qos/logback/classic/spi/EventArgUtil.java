/*    */ package ch.qos.logback.classic.spi;
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
/*    */ public class EventArgUtil
/*    */ {
/*    */   public static final Throwable extractThrowable(Object[] paramArrayOfObject) {
/* 19 */     if (paramArrayOfObject == null || paramArrayOfObject.length == 0) {
/* 20 */       return null;
/*    */     }
/*    */     
/* 23 */     Object object = paramArrayOfObject[paramArrayOfObject.length - 1];
/* 24 */     if (object instanceof Throwable) {
/* 25 */       return (Throwable)object;
/*    */     }
/* 27 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Object[] trimmedCopy(Object[] paramArrayOfObject) {
/* 37 */     if (paramArrayOfObject == null || paramArrayOfObject.length == 0) {
/* 38 */       throw new IllegalStateException("non-sensical empty or null argument array");
/*    */     }
/* 40 */     int i = paramArrayOfObject.length - 1;
/* 41 */     Object[] arrayOfObject = new Object[i];
/* 42 */     System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, i);
/* 43 */     return arrayOfObject;
/*    */   }
/*    */   
/*    */   public static Object[] arrangeArguments(Object[] paramArrayOfObject) {
/* 47 */     return paramArrayOfObject;
/*    */   }
/*    */   
/*    */   public static boolean successfulExtraction(Throwable paramThrowable) {
/* 51 */     return (paramThrowable != null);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\spi\EventArgUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */