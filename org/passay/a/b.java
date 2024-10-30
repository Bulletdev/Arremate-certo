/*    */ package org.passay.a;
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
/*    */ public class b
/*    */   implements a
/*    */ {
/*    */   private final int ji;
/*    */   private final int jj;
/*    */   
/*    */   public b(int paramInt1, int paramInt2) {
/* 30 */     this.ji = paramInt1;
/* 31 */     this.jj = paramInt2;
/*    */   }
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
/*    */   public double U() {
/* 47 */     return c(Math.pow(this.ji, this.jj));
/*    */   }
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
/*    */   public static double c(double paramDouble) {
/* 60 */     return Math.log(paramDouble) / Math.log(2.0D);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */