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
/*     */ public final class FinanceLib
/*     */ {
/*     */   public static double fv(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, boolean paramBoolean) {
/*  77 */     double d = 0.0D;
/*  78 */     if (paramDouble1 == 0.0D) {
/*  79 */       d = -1.0D * (paramDouble4 + paramDouble2 * paramDouble3);
/*     */     } else {
/*     */       
/*  82 */       double d1 = paramDouble1 + 1.0D;
/*  83 */       d = (1.0D - Math.pow(d1, paramDouble2)) * (paramBoolean ? d1 : 1.0D) * paramDouble3 / paramDouble1 - paramDouble4 * Math.pow(d1, paramDouble2);
/*     */     } 
/*     */ 
/*     */     
/*  87 */     return d;
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
/*     */   public static double pv(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, boolean paramBoolean) {
/* 102 */     double d = 0.0D;
/* 103 */     if (paramDouble1 == 0.0D) {
/* 104 */       d = -1.0D * (paramDouble2 * paramDouble3 + paramDouble4);
/*     */     } else {
/*     */       
/* 107 */       double d1 = paramDouble1 + 1.0D;
/* 108 */       d = ((1.0D - Math.pow(d1, paramDouble2)) / paramDouble1 * (paramBoolean ? d1 : 1.0D) * paramDouble3 - paramDouble4) / Math.pow(d1, paramDouble2);
/*     */     } 
/*     */ 
/*     */     
/* 112 */     return d;
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
/*     */   public static double npv(double paramDouble, double[] paramArrayOfdouble) {
/* 125 */     double d1 = 0.0D;
/* 126 */     double d2 = paramDouble + 1.0D;
/* 127 */     double d3 = d2; byte b; int i;
/* 128 */     for (b = 0, i = paramArrayOfdouble.length; b < i; b++) {
/* 129 */       d1 += paramArrayOfdouble[b] / d3;
/* 130 */       d3 *= d2;
/*     */     } 
/* 132 */     return d1;
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
/*     */   public static double pmt(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, boolean paramBoolean) {
/* 144 */     double d = 0.0D;
/* 145 */     if (paramDouble1 == 0.0D) {
/* 146 */       d = -1.0D * (paramDouble4 + paramDouble3) / paramDouble2;
/*     */     } else {
/*     */       
/* 149 */       double d1 = paramDouble1 + 1.0D;
/* 150 */       d = (paramDouble4 + paramDouble3 * Math.pow(d1, paramDouble2)) * paramDouble1 / (paramBoolean ? d1 : 1.0D) * (1.0D - Math.pow(d1, paramDouble2));
/*     */     } 
/*     */ 
/*     */     
/* 154 */     return d;
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
/*     */   public static double nper(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, boolean paramBoolean) {
/* 166 */     double d = 0.0D;
/* 167 */     if (paramDouble1 == 0.0D) {
/* 168 */       d = -1.0D * (paramDouble4 + paramDouble3) / paramDouble2;
/*     */     } else {
/* 170 */       double d1 = paramDouble1 + 1.0D;
/* 171 */       double d2 = (paramBoolean ? d1 : 1.0D) * paramDouble2 / paramDouble1;
/* 172 */       double d3 = (d2 - paramDouble4 < 0.0D) ? Math.log(paramDouble4 - d2) : Math.log(d2 - paramDouble4);
/*     */ 
/*     */       
/* 175 */       double d4 = (d2 - paramDouble4 < 0.0D) ? Math.log(-paramDouble3 - d2) : Math.log(paramDouble3 + d2);
/*     */ 
/*     */       
/* 178 */       double d5 = Math.log(d1);
/* 179 */       d = (d3 - d4) / d5;
/*     */     } 
/* 181 */     return d;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\FinanceLib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */