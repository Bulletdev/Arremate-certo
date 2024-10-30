/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.EvaluationException;
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
/*     */ public class Mirr
/*     */   extends MultiOperandNumericFunction
/*     */ {
/*     */   public Mirr() {
/*  49 */     super(false, false);
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getMaxNumOperands() {
/*  54 */     return 3;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected double evaluate(double[] paramArrayOfdouble) throws EvaluationException {
/*  60 */     double d1 = paramArrayOfdouble[paramArrayOfdouble.length - 1];
/*  61 */     double d2 = paramArrayOfdouble[paramArrayOfdouble.length - 2];
/*     */     
/*  63 */     double[] arrayOfDouble = new double[paramArrayOfdouble.length - 2];
/*  64 */     System.arraycopy(paramArrayOfdouble, 0, arrayOfDouble, 0, arrayOfDouble.length);
/*     */     
/*  66 */     int i = 1;
/*  67 */     for (double d : arrayOfDouble) {
/*  68 */       i &= (d < 0.0D) ? 1 : 0;
/*     */     }
/*  70 */     if (i != 0) {
/*  71 */       return -1.0D;
/*     */     }
/*     */     
/*  74 */     int j = 1;
/*  75 */     for (double d : arrayOfDouble) {
/*  76 */       j &= (d > 0.0D) ? 1 : 0;
/*     */     }
/*  78 */     if (j != 0) {
/*  79 */       throw new EvaluationException(ErrorEval.DIV_ZERO);
/*     */     }
/*     */     
/*  82 */     return mirr(arrayOfDouble, d1, d2);
/*     */   }
/*     */   
/*     */   private static double mirr(double[] paramArrayOfdouble, double paramDouble1, double paramDouble2) {
/*  86 */     double d1 = 0.0D;
/*  87 */     int i = paramArrayOfdouble.length - 1;
/*  88 */     double d2 = 0.0D;
/*  89 */     double d3 = 0.0D;
/*     */     
/*  91 */     byte b = 0;
/*  92 */     for (double d : paramArrayOfdouble) {
/*  93 */       if (d < 0.0D) {
/*  94 */         d2 += d / Math.pow(1.0D + paramDouble1 + paramDouble2, b++);
/*     */       }
/*     */     } 
/*     */     
/*  98 */     for (double d : paramArrayOfdouble) {
/*  99 */       if (d > 0.0D) {
/* 100 */         d3 += d * Math.pow(1.0D + paramDouble1, (i - b++));
/*     */       }
/*     */     } 
/*     */     
/* 104 */     if (d3 != 0.0D && d2 != 0.0D) {
/* 105 */       d1 = Math.pow(-d3 / d2, 1.0D / i) - 1.0D;
/*     */     }
/* 107 */     return d1;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Mirr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */