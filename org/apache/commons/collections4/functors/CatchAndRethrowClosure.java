/*    */ package org.apache.commons.collections4.functors;
/*    */ 
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
/*    */ public abstract class CatchAndRethrowClosure<E>
/*    */   implements Closure<E>
/*    */ {
/*    */   public void execute(E paramE) {
/*    */     try {
/* 60 */       executeAndThrow(paramE);
/* 61 */     } catch (RuntimeException runtimeException) {
/* 62 */       throw runtimeException;
/* 63 */     } catch (Throwable throwable) {
/* 64 */       throw new FunctorException(throwable);
/*    */     } 
/*    */   }
/*    */   
/*    */   protected abstract void executeAndThrow(E paramE) throws Throwable;
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\CatchAndRethrowClosure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */