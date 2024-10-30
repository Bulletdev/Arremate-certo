/*    */ package org.apache.poi.ss.formula.functions;
/*    */ 
/*    */ import org.apache.poi.ss.formula.ThreeDEval;
/*    */ import org.apache.poi.ss.formula.eval.BlankEval;
/*    */ import org.apache.poi.ss.formula.eval.NumberEval;
/*    */ import org.apache.poi.ss.formula.eval.RefEval;
/*    */ import org.apache.poi.ss.formula.eval.StringEval;
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
/*    */ public final class Countblank
/*    */   extends Fixed1ArgFunction
/*    */ {
/*    */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval) {
/*    */     double d;
/* 40 */     if (paramValueEval instanceof RefEval) {
/* 41 */       d = CountUtils.countMatchingCellsInRef((RefEval)paramValueEval, predicate);
/* 42 */     } else if (paramValueEval instanceof ThreeDEval) {
/* 43 */       d = CountUtils.countMatchingCellsInArea((ThreeDEval)paramValueEval, predicate);
/*    */     } else {
/* 45 */       throw new IllegalArgumentException("Bad range arg type (" + paramValueEval.getClass().getName() + ")");
/*    */     } 
/* 47 */     return (ValueEval)new NumberEval(d);
/*    */   }
/*    */   
/* 50 */   private static final CountUtils.I_MatchPredicate predicate = new CountUtils.I_MatchPredicate()
/*    */     {
/*    */       public boolean matches(ValueEval param1ValueEval)
/*    */       {
/* 54 */         return (param1ValueEval == BlankEval.instance || (param1ValueEval instanceof StringEval && "".equals(((StringEval)param1ValueEval).getStringValue())));
/*    */       }
/*    */     };
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Countblank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */