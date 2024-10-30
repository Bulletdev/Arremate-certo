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
/*    */ public class u
/*    */   implements q
/*    */ {
/*    */   public double a(double[] paramArrayOfdouble, int paramInt) {
/* 45 */     if (paramInt == 0) {
/* 46 */       return Double.MAX_VALUE;
/*    */     }
/* 48 */     double d = -1.7976931348623157E308D;
/* 49 */     for (byte b = 0; b < paramInt; b++) {
/* 50 */       if (paramArrayOfdouble[b] > d)
/* 51 */         d = paramArrayOfdouble[b]; 
/* 52 */     }  return d;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean t(int paramInt) {
/* 59 */     return (paramInt >= 0);
/*    */   }
/*    */   
/*    */   public String toString() {
/* 63 */     return "max(x1, x2, ..., xn)";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\a\c\\\u.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */