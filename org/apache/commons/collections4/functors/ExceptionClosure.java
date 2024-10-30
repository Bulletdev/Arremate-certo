/*    */ package org.apache.commons.collections4.functors;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import org.apache.commons.collections4.Closure;
/*    */ import org.apache.commons.collections4.FunctorException;
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
/*    */ public final class ExceptionClosure<E>
/*    */   implements Serializable, Closure<E>
/*    */ {
/*    */   private static final long serialVersionUID = 7179106032121985545L;
/* 37 */   public static final Closure INSTANCE = new ExceptionClosure();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static <E> Closure<E> exceptionClosure() {
/* 48 */     return INSTANCE;
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
/*    */   public void execute(E paramE) {
/* 65 */     throw new FunctorException("ExceptionClosure invoked");
/*    */   }
/*    */   
/*    */   private Object readResolve() {
/* 69 */     return INSTANCE;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\ExceptionClosure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */