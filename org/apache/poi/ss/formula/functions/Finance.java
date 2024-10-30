/*     */ package org.apache.poi.ss.formula.functions;
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
/*     */ public class Finance
/*     */ {
/*     */   public static double pmt(double paramDouble1, int paramInt1, double paramDouble2, double paramDouble3, int paramInt2) {
/*  43 */     return -paramDouble1 * (paramDouble2 * Math.pow(1.0D + paramDouble1, paramInt1) + paramDouble3) / (1.0D + paramDouble1 * paramInt2) * (Math.pow(1.0D + paramDouble1, paramInt1) - 1.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double pmt(double paramDouble1, int paramInt, double paramDouble2, double paramDouble3) {
/*  54 */     return pmt(paramDouble1, paramInt, paramDouble2, paramDouble3, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double pmt(double paramDouble1, int paramInt, double paramDouble2) {
/*  63 */     return pmt(paramDouble1, paramInt, paramDouble2, 0.0D);
/*     */   }
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
/*     */   public static double ipmt(double paramDouble1, int paramInt1, int paramInt2, double paramDouble2, double paramDouble3, int paramInt3) {
/*  91 */     double d = fv(paramDouble1, paramInt1 - 1, pmt(paramDouble1, paramInt2, paramDouble2, paramDouble3, paramInt3), paramDouble2, paramInt3) * paramDouble1;
/*  92 */     if (paramInt3 == 1) d /= 1.0D + paramDouble1; 
/*  93 */     return d;
/*     */   }
/*     */   
/*     */   public static double ipmt(double paramDouble1, int paramInt1, int paramInt2, double paramDouble2, double paramDouble3) {
/*  97 */     return ipmt(paramDouble1, paramInt1, paramInt2, paramDouble2, paramDouble3, 0);
/*     */   }
/*     */   
/*     */   public static double ipmt(double paramDouble1, int paramInt1, int paramInt2, double paramDouble2) {
/* 101 */     return ipmt(paramDouble1, paramInt1, paramInt2, paramDouble2, 0.0D);
/*     */   }
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
/*     */   public static double ppmt(double paramDouble1, int paramInt1, int paramInt2, double paramDouble2, double paramDouble3, int paramInt3) {
/* 127 */     return pmt(paramDouble1, paramInt2, paramDouble2, paramDouble3, paramInt3) - ipmt(paramDouble1, paramInt1, paramInt2, paramDouble2, paramDouble3, paramInt3);
/*     */   }
/*     */   
/*     */   public static double ppmt(double paramDouble1, int paramInt1, int paramInt2, double paramDouble2, double paramDouble3) {
/* 131 */     return pmt(paramDouble1, paramInt2, paramDouble2, paramDouble3) - ipmt(paramDouble1, paramInt1, paramInt2, paramDouble2, paramDouble3);
/*     */   }
/*     */   
/*     */   public static double ppmt(double paramDouble1, int paramInt1, int paramInt2, double paramDouble2) {
/* 135 */     return pmt(paramDouble1, paramInt2, paramDouble2) - ipmt(paramDouble1, paramInt1, paramInt2, paramDouble2);
/*     */   }
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
/*     */   public static double fv(double paramDouble1, int paramInt1, double paramDouble2, double paramDouble3, int paramInt2) {
/* 156 */     return -(paramDouble3 * Math.pow(1.0D + paramDouble1, paramInt1) + paramDouble2 * (1.0D + paramDouble1 * paramInt2) * (Math.pow(1.0D + paramDouble1, paramInt1) - 1.0D) / paramDouble1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double fv(double paramDouble1, int paramInt, double paramDouble2, double paramDouble3) {
/* 166 */     return fv(paramDouble1, paramInt, paramDouble2, paramDouble3, 0);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Finance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */