/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import org.apache.poi.ss.formula.ThreeDEval;
/*     */ import org.apache.poi.ss.formula.TwoDEval;
/*     */ import org.apache.poi.ss.formula.eval.RefEval;
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
/*     */ final class CountUtils
/*     */ {
/*     */   public static int countMatchingCellsInArea(ThreeDEval paramThreeDEval, I_MatchPredicate paramI_MatchPredicate) {
/*  50 */     byte b = 0;
/*     */     
/*  52 */     int i = paramThreeDEval.getFirstSheetIndex();
/*  53 */     int j = paramThreeDEval.getLastSheetIndex();
/*  54 */     for (int k = i; k <= j; k++) {
/*  55 */       int m = paramThreeDEval.getHeight();
/*  56 */       int n = paramThreeDEval.getWidth();
/*  57 */       for (byte b1 = 0; b1 < m; b1++) {
/*  58 */         for (byte b2 = 0; b2 < n; b2++) {
/*  59 */           ValueEval valueEval = paramThreeDEval.getValue(k, b1, b2);
/*     */           
/*  61 */           if (paramI_MatchPredicate instanceof I_MatchAreaPredicate) {
/*  62 */             I_MatchAreaPredicate i_MatchAreaPredicate = (I_MatchAreaPredicate)paramI_MatchPredicate;
/*  63 */             if (!i_MatchAreaPredicate.matches((TwoDEval)paramThreeDEval, b1, b2))
/*     */               continue; 
/*     */           } 
/*  66 */           if (paramI_MatchPredicate.matches(valueEval))
/*  67 */             b++; 
/*     */           continue;
/*     */         } 
/*     */       } 
/*     */     } 
/*  72 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int countMatchingCellsInRef(RefEval paramRefEval, I_MatchPredicate paramI_MatchPredicate) {
/*  78 */     byte b = 0;
/*     */     
/*  80 */     int i = paramRefEval.getFirstSheetIndex();
/*  81 */     int j = paramRefEval.getLastSheetIndex();
/*  82 */     for (int k = i; k <= j; k++) {
/*  83 */       ValueEval valueEval = paramRefEval.getInnerValueEval(k);
/*  84 */       if (paramI_MatchPredicate.matches(valueEval)) {
/*  85 */         b++;
/*     */       }
/*     */     } 
/*  88 */     return b;
/*     */   }
/*     */   public static int countArg(ValueEval paramValueEval, I_MatchPredicate paramI_MatchPredicate) {
/*  91 */     if (paramValueEval == null) {
/*  92 */       throw new IllegalArgumentException("eval must not be null");
/*     */     }
/*  94 */     if (paramValueEval instanceof ThreeDEval) {
/*  95 */       return countMatchingCellsInArea((ThreeDEval)paramValueEval, paramI_MatchPredicate);
/*     */     }
/*  97 */     if (paramValueEval instanceof TwoDEval) {
/*  98 */       throw new IllegalArgumentException("Count requires 3D Evals, 2D ones aren't supported");
/*     */     }
/* 100 */     if (paramValueEval instanceof RefEval) {
/* 101 */       return countMatchingCellsInRef((RefEval)paramValueEval, paramI_MatchPredicate);
/*     */     }
/* 103 */     return paramI_MatchPredicate.matches(paramValueEval) ? 1 : 0;
/*     */   }
/*     */   
/*     */   public static interface I_MatchAreaPredicate extends I_MatchPredicate {
/*     */     boolean matches(TwoDEval param1TwoDEval, int param1Int1, int param1Int2);
/*     */   }
/*     */   
/*     */   public static interface I_MatchPredicate {
/*     */     boolean matches(ValueEval param1ValueEval);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\CountUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */