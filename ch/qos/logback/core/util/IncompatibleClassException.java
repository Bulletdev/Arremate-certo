/*    */ package ch.qos.logback.core.util;
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
/*    */ public class IncompatibleClassException
/*    */   extends Exception
/*    */ {
/*    */   private static final long serialVersionUID = -5823372159561159549L;
/*    */   Class<?> requestedClass;
/*    */   Class<?> obtainedClass;
/*    */   
/*    */   IncompatibleClassException(Class<?> paramClass1, Class<?> paramClass2) {
/* 25 */     this.requestedClass = paramClass1;
/* 26 */     this.obtainedClass = paramClass2;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\cor\\util\IncompatibleClassException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */