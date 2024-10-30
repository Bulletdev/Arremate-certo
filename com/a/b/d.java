/*    */ package com.a.b;
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
/*    */ public class d
/*    */ {
/*    */   static class a
/*    */     implements b
/*    */   {
/*    */     double[] i;
/*    */     
/*    */     public a(double param1Double1, double param1Double2) {
/* 41 */       this.i = new double[] { param1Double1, param1Double2 };
/*    */     }
/*    */ 
/*    */     
/*    */     public double getX() {
/* 46 */       return this.i[0];
/*    */     }
/*    */ 
/*    */     
/*    */     public double getY() {
/* 51 */       return this.i[1];
/*    */     }
/*    */ 
/*    */     
/*    */     public void f(double[] param1ArrayOfdouble) {
/* 56 */       this.i[0] = param1ArrayOfdouble[0];
/* 57 */       this.i[1] = param1ArrayOfdouble[1];
/*    */     }
/*    */ 
/*    */     
/*    */     public void d(double param1Double1, double param1Double2) {
/* 62 */       this.i[0] = param1Double1;
/* 63 */       this.i[1] = param1Double2;
/*    */     }
/*    */ 
/*    */     
/*    */     public double[] b() {
/* 68 */       return this.i;
/*    */     }
/*    */   }
/*    */   
/*    */   public static b a(double paramDouble1, double paramDouble2) {
/* 73 */     return new a(paramDouble1, paramDouble2);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\a\b\d.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */