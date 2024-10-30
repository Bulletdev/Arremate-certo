/*    */ package ch.qos.logback.core.filter;
/*    */ 
/*    */ import ch.qos.logback.core.boolex.EvaluationException;
/*    */ import ch.qos.logback.core.boolex.EventEvaluator;
/*    */ import ch.qos.logback.core.spi.FilterReply;
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
/*    */ public class EvaluatorFilter<E>
/*    */   extends AbstractMatcherFilter<E>
/*    */ {
/*    */   EventEvaluator<E> evaluator;
/*    */   
/*    */   public void start() {
/* 43 */     if (this.evaluator != null) {
/* 44 */       super.start();
/*    */     } else {
/* 46 */       addError("No evaluator set for filter " + getName());
/*    */     } 
/*    */   }
/*    */   
/*    */   public EventEvaluator<E> getEvaluator() {
/* 51 */     return this.evaluator;
/*    */   }
/*    */   
/*    */   public void setEvaluator(EventEvaluator<E> paramEventEvaluator) {
/* 55 */     this.evaluator = paramEventEvaluator;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public FilterReply decide(E paramE) {
/* 61 */     if (!isStarted() || !this.evaluator.isStarted()) {
/* 62 */       return FilterReply.NEUTRAL;
/*    */     }
/*    */     try {
/* 65 */       if (this.evaluator.evaluate(paramE)) {
/* 66 */         return this.onMatch;
/*    */       }
/* 68 */       return this.onMismatch;
/*    */     }
/* 70 */     catch (EvaluationException evaluationException) {
/* 71 */       addError("Evaluator " + this.evaluator.getName() + " threw an exception", (Throwable)evaluationException);
/* 72 */       return FilterReply.NEUTRAL;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\filter\EvaluatorFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */