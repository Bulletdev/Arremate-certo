/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import org.apache.poi.ss.formula.TwoDEval;
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.MissingArgEval;
/*     */ import org.apache.poi.ss.formula.eval.NumberEval;
/*     */ import org.apache.poi.ss.formula.eval.ValueEval;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Count
/*     */   implements Function
/*     */ {
/*     */   private final CountUtils.I_MatchPredicate _predicate;
/*     */   
/*     */   public Count() {
/*  43 */     this._predicate = defaultPredicate;
/*     */   }
/*     */   
/*     */   private Count(CountUtils.I_MatchPredicate paramI_MatchPredicate) {
/*  47 */     this._predicate = paramI_MatchPredicate;
/*     */   }
/*     */   
/*     */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, int paramInt1, int paramInt2) {
/*  51 */     int i = paramArrayOfValueEval.length;
/*  52 */     if (i < 1)
/*     */     {
/*  54 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */     }
/*     */     
/*  57 */     if (i > 30)
/*     */     {
/*  59 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */     }
/*     */     
/*  62 */     int j = 0;
/*     */     
/*  64 */     for (byte b = 0; b < i; b++) {
/*  65 */       j += CountUtils.countArg(paramArrayOfValueEval[b], this._predicate);
/*     */     }
/*     */     
/*  68 */     return (ValueEval)new NumberEval(j);
/*     */   }
/*     */   
/*  71 */   private static final CountUtils.I_MatchPredicate defaultPredicate = new CountUtils.I_MatchPredicate()
/*     */     {
/*     */       public boolean matches(ValueEval param1ValueEval)
/*     */       {
/*  75 */         if (param1ValueEval instanceof NumberEval)
/*     */         {
/*  77 */           return true;
/*     */         }
/*  79 */         if (param1ValueEval == MissingArgEval.instance)
/*     */         {
/*  81 */           return true;
/*     */         }
/*     */ 
/*     */         
/*  85 */         return false;
/*     */       }
/*     */     };
/*     */   
/*  89 */   private static final CountUtils.I_MatchPredicate subtotalPredicate = new CountUtils.I_MatchAreaPredicate() {
/*     */       public boolean matches(ValueEval param1ValueEval) {
/*  91 */         return Count.defaultPredicate.matches(param1ValueEval);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean matches(TwoDEval param1TwoDEval, int param1Int1, int param1Int2) {
/*  98 */         return !param1TwoDEval.isSubTotal(param1Int1, param1Int2);
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Count subtotalInstance() {
/* 112 */     return new Count(subtotalPredicate);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Count.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */