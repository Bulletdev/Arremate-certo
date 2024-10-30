/*    */ package com.a.c;
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
/*    */ public final class j
/*    */ {
/* 41 */   private static double[][] a = new double[][] { { 1.0D } };
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
/*    */   public static synchronized double a(int paramInt1, int paramInt2) {
/* 55 */     if (paramInt1 < 0 || paramInt2 < 0 || paramInt2 > paramInt1) return 0.0D;
/*    */     
/* 57 */     if (paramInt1 >= a.length) {
/* 58 */       int i = 2 * a.length;
/* 59 */       double[][] arrayOfDouble = (double[][])null;
/* 60 */       if (paramInt1 > i) {
/* 61 */         arrayOfDouble = new double[paramInt1 + 1][];
/*    */       } else {
/* 63 */         arrayOfDouble = new double[i + 1][];
/*    */       }  int k;
/* 65 */       for (k = 0; k < a.length; k++) {
/* 66 */         arrayOfDouble[k] = a[k];
/*    */       }
/* 68 */       for (k = a.length; k < arrayOfDouble.length; k++) {
/* 69 */         arrayOfDouble[k] = new double[k / 2 + 1];
/*    */         
/* 71 */         arrayOfDouble[k][0] = 1.0D;
/*    */         
/* 73 */         for (byte b = 1; b < (arrayOfDouble[k]).length; b++) {
/* 74 */           double d = arrayOfDouble[k - 1][b - 1];
/* 75 */           if (b < (arrayOfDouble[k - 1]).length) {
/* 76 */             d += arrayOfDouble[k - 1][b];
/*    */           } else {
/* 78 */             d = 2.0D * d;
/*    */           } 
/* 80 */           arrayOfDouble[k][b] = d;
/*    */         } 
/*    */       } 
/* 83 */       a = arrayOfDouble;
/*    */     } 
/*    */     
/* 86 */     if (2 * paramInt2 > paramInt1) {
/* 87 */       paramInt2 = paramInt1 - paramInt2;
/*    */     }
/* 89 */     return a[paramInt1][paramInt2];
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static synchronized void reset() {
/* 96 */     a = new double[][] { { 1.0D } };
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\a\c\j.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */