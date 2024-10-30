/*    */ package org.apache.poi.ss.formula.eval;
/*    */ 
/*    */ import org.apache.poi.ss.formula.ptg.Ptg;
/*    */ import org.apache.poi.ss.formula.ptg.StringPtg;
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
/*    */ public final class StringEval
/*    */   implements StringValueEval
/*    */ {
/* 28 */   public static final StringEval EMPTY_INSTANCE = new StringEval("");
/*    */   
/*    */   private final String _value;
/*    */   
/*    */   public StringEval(Ptg paramPtg) {
/* 33 */     this(((StringPtg)paramPtg).getValue());
/*    */   }
/*    */   
/*    */   public StringEval(String paramString) {
/* 37 */     if (paramString == null) {
/* 38 */       throw new IllegalArgumentException("value must not be null");
/*    */     }
/* 40 */     this._value = paramString;
/*    */   }
/*    */   
/*    */   public String getStringValue() {
/* 44 */     return this._value;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 48 */     StringBuilder stringBuilder = new StringBuilder(64);
/* 49 */     stringBuilder.append(getClass().getName()).append(" [");
/* 50 */     stringBuilder.append(this._value);
/* 51 */     stringBuilder.append("]");
/* 52 */     return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\eval\StringEval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */