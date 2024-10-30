/*    */ package org.apache.poi.ss.formula.functions;
/*    */ 
/*    */ import org.apache.poi.ss.formula.eval.NumberEval;
/*    */ import org.apache.poi.ss.formula.eval.NumericValueEval;
/*    */ import org.apache.poi.ss.formula.eval.ValueEval;
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
/*    */ public final class DMin
/*    */   implements IDStarAlgorithm
/*    */ {
/*    */   private ValueEval minimumValue;
/*    */   
/*    */   public boolean processMatch(ValueEval paramValueEval) {
/* 37 */     if (paramValueEval instanceof NumericValueEval) {
/* 38 */       if (this.minimumValue == null) {
/* 39 */         this.minimumValue = paramValueEval;
/*    */       } else {
/* 41 */         double d1 = ((NumericValueEval)paramValueEval).getNumberValue();
/* 42 */         double d2 = ((NumericValueEval)this.minimumValue).getNumberValue();
/* 43 */         if (d1 < d2) {
/* 44 */           this.minimumValue = paramValueEval;
/*    */         }
/*    */       } 
/*    */     }
/*    */     
/* 49 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public ValueEval getResult() {
/* 54 */     if (this.minimumValue == null) {
/* 55 */       return (ValueEval)NumberEval.ZERO;
/*    */     }
/* 57 */     return this.minimumValue;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\DMin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */