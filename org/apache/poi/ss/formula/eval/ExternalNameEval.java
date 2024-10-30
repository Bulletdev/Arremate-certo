/*    */ package org.apache.poi.ss.formula.eval;
/*    */ 
/*    */ import org.apache.poi.ss.formula.EvaluationName;
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
/*    */ public final class ExternalNameEval
/*    */   implements ValueEval
/*    */ {
/*    */   private final EvaluationName _name;
/*    */   
/*    */   public ExternalNameEval(EvaluationName paramEvaluationName) {
/* 29 */     this._name = paramEvaluationName;
/*    */   }
/*    */   
/*    */   public EvaluationName getName() {
/* 33 */     return this._name;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 37 */     StringBuffer stringBuffer = new StringBuffer(64);
/* 38 */     stringBuffer.append(getClass().getName()).append(" [");
/* 39 */     stringBuffer.append(this._name.getNameText());
/* 40 */     stringBuffer.append("]");
/* 41 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\eval\ExternalNameEval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */