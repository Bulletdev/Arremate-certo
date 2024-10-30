/*    */ package org.apache.poi.ss.formula.eval;
/*    */ 
/*    */ import org.apache.poi.ss.formula.ptg.IntPtg;
/*    */ import org.apache.poi.ss.formula.ptg.NumberPtg;
/*    */ import org.apache.poi.ss.formula.ptg.Ptg;
/*    */ import org.apache.poi.ss.util.NumberToTextConverter;
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
/*    */ public final class NumberEval
/*    */   implements NumericValueEval, StringValueEval
/*    */ {
/* 34 */   public static final NumberEval ZERO = new NumberEval(0.0D);
/*    */   
/*    */   private final double _value;
/*    */   private String _stringValue;
/*    */   
/*    */   public NumberEval(Ptg paramPtg) {
/* 40 */     if (paramPtg == null) {
/* 41 */       throw new IllegalArgumentException("ptg must not be null");
/*    */     }
/* 43 */     if (paramPtg instanceof IntPtg) {
/* 44 */       this._value = ((IntPtg)paramPtg).getValue();
/* 45 */     } else if (paramPtg instanceof NumberPtg) {
/* 46 */       this._value = ((NumberPtg)paramPtg).getValue();
/*    */     } else {
/* 48 */       throw new IllegalArgumentException("bad argument type (" + paramPtg.getClass().getName() + ")");
/*    */     } 
/*    */   }
/*    */   
/*    */   public NumberEval(double paramDouble) {
/* 53 */     this._value = paramDouble;
/*    */   }
/*    */   
/*    */   public double getNumberValue() {
/* 57 */     return this._value;
/*    */   }
/*    */   
/*    */   public String getStringValue() {
/* 61 */     if (this._stringValue == null) {
/* 62 */       this._stringValue = NumberToTextConverter.toText(this._value);
/*    */     }
/* 64 */     return this._stringValue;
/*    */   }
/*    */   public final String toString() {
/* 67 */     StringBuffer stringBuffer = new StringBuffer(64);
/* 68 */     stringBuffer.append(getClass().getName()).append(" [");
/* 69 */     stringBuffer.append(getStringValue());
/* 70 */     stringBuffer.append("]");
/* 71 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\eval\NumberEval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */