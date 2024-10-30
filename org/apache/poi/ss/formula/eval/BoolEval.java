/*    */ package org.apache.poi.ss.formula.eval;
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
/*    */ public final class BoolEval
/*    */   implements NumericValueEval, StringValueEval
/*    */ {
/*    */   private boolean _value;
/* 27 */   public static final BoolEval FALSE = new BoolEval(false);
/*    */   
/* 29 */   public static final BoolEval TRUE = new BoolEval(true);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static final BoolEval valueOf(boolean paramBoolean) {
/* 38 */     return paramBoolean ? TRUE : FALSE;
/*    */   }
/*    */   
/*    */   private BoolEval(boolean paramBoolean) {
/* 42 */     this._value = paramBoolean;
/*    */   }
/*    */   
/*    */   public boolean getBooleanValue() {
/* 46 */     return this._value;
/*    */   }
/*    */   
/*    */   public double getNumberValue() {
/* 50 */     return this._value ? 1.0D : 0.0D;
/*    */   }
/*    */   
/*    */   public String getStringValue() {
/* 54 */     return this._value ? "TRUE" : "FALSE";
/*    */   }
/*    */   
/*    */   public String toString() {
/* 58 */     StringBuilder stringBuilder = new StringBuilder(64);
/* 59 */     stringBuilder.append(getClass().getName()).append(" [");
/* 60 */     stringBuilder.append(getStringValue());
/* 61 */     stringBuilder.append("]");
/* 62 */     return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\eval\BoolEval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */