/*    */ package com.a.c.a;
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
/*    */ 
/*    */ 
/*    */ public class v
/*    */   implements q
/*    */ {
/*    */   public double a(double[] paramArrayOfdouble, int paramInt) {
/* 45 */     if (paramInt == 0) {
/* 46 */       return Double.MIN_VALUE;
/*    */     }
/* 48 */     double d = Double.MAX_VALUE;
/*    */     
/* 50 */     for (byte b = 0; b < paramInt; b++) {
/* 51 */       if (paramArrayOfdouble[b] < d)
/* 52 */         d = paramArrayOfdouble[b]; 
/* 53 */     }  return d;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean t(int paramInt) {
/* 60 */     return (paramInt >= 0);
/*    */   }
/*    */   
/*    */   public String toString() {
/* 64 */     return "min(x1, x2, ..., xn)";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\a\c\a\v.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */