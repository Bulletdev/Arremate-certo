/*    */ package org.apache.poi.ss.formula.functions;
/*    */ 
/*    */ import org.apache.poi.ss.formula.TwoDEval;
/*    */ import org.apache.poi.ss.formula.eval.BlankEval;
/*    */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*    */ import org.apache.poi.ss.formula.eval.NumberEval;
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
/*    */ 
/*    */ 
/*    */ public final class Counta
/*    */   implements Function
/*    */ {
/*    */   private final CountUtils.I_MatchPredicate _predicate;
/*    */   
/*    */   public Counta() {
/* 41 */     this._predicate = defaultPredicate;
/*    */   }
/*    */   
/*    */   private Counta(CountUtils.I_MatchPredicate paramI_MatchPredicate) {
/* 45 */     this._predicate = paramI_MatchPredicate;
/*    */   }
/*    */   
/*    */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, int paramInt1, int paramInt2) {
/* 49 */     int i = paramArrayOfValueEval.length;
/* 50 */     if (i < 1)
/*    */     {
/* 52 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     }
/*    */     
/* 55 */     if (i > 30)
/*    */     {
/* 57 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     }
/*    */     
/* 60 */     int j = 0;
/*    */     
/* 62 */     for (byte b = 0; b < i; b++) {
/* 63 */       j += CountUtils.countArg(paramArrayOfValueEval[b], this._predicate);
/*    */     }
/*    */     
/* 66 */     return (ValueEval)new NumberEval(j);
/*    */   }
/*    */   
/* 69 */   private static final CountUtils.I_MatchPredicate defaultPredicate = new CountUtils.I_MatchPredicate()
/*    */     {
/*    */ 
/*    */ 
/*    */       
/*    */       public boolean matches(ValueEval param1ValueEval)
/*    */       {
/* 76 */         if (param1ValueEval == BlankEval.instance) {
/* 77 */           return false;
/*    */         }
/*    */         
/* 80 */         return true;
/*    */       }
/*    */     };
/* 83 */   private static final CountUtils.I_MatchPredicate subtotalPredicate = new CountUtils.I_MatchAreaPredicate() {
/*    */       public boolean matches(ValueEval param1ValueEval) {
/* 85 */         return Counta.defaultPredicate.matches(param1ValueEval);
/*    */       }
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       public boolean matches(TwoDEval param1TwoDEval, int param1Int1, int param1Int2) {
/* 92 */         return !param1TwoDEval.isSubTotal(param1Int1, param1Int2);
/*    */       }
/*    */     };
/*    */   
/*    */   public static Counta subtotalInstance() {
/* 97 */     return new Counta(subtotalPredicate);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Counta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */