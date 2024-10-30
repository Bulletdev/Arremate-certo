/*    */ package com.a.a;
/*    */ 
/*    */ import java.awt.geom.AffineTransform;
/*    */ import java.awt.geom.PathIterator;
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
/*    */ class s
/*    */   implements PathIterator
/*    */ {
/*    */   private final int gO;
/*    */   private final int gP;
/*    */   private final AffineTransform a;
/*    */   private final r a;
/*    */   private final int gN;
/* 43 */   private int n = 0;
/*    */   
/*    */   s(r paramr, AffineTransform paramAffineTransform) {
/* 46 */     this.a = paramr;
/* 47 */     int[] arrayOfInt = paramr.c();
/* 48 */     this.gO = arrayOfInt[0];
/* 49 */     this.gP = arrayOfInt[1];
/* 50 */     this.a = (r)paramAffineTransform;
/* 51 */     this.gN = paramr.getWindingRule();
/*    */   }
/*    */   
/*    */   public int getWindingRule() {
/* 55 */     return this.gN;
/*    */   }
/*    */   
/*    */   public boolean isDone() {
/* 59 */     return (this.n >= this.a.aO());
/*    */   }
/*    */   
/*    */   public void next() {
/* 63 */     this.n++;
/*    */   }
/*    */   
/*    */   public int currentSegment(float[] paramArrayOffloat) {
/* 67 */     double[] arrayOfDouble = this.a.a(this.n);
/* 68 */     paramArrayOffloat[0] = (float)arrayOfDouble[this.gO];
/* 69 */     paramArrayOffloat[1] = (float)arrayOfDouble[this.gP];
/*    */     
/* 71 */     if (this.n > 0 && arrayOfDouble == this.a.a(0)) {
/* 72 */       return 4;
/*    */     }
/* 74 */     if (this.a != null) {
/* 75 */       this.a.transform(paramArrayOffloat, 0, paramArrayOffloat, 0, 1);
/*    */     }
/* 77 */     if (this.a.g(this.n) == l.as) {
/* 78 */       return 0;
/*    */     }
/* 80 */     return 1;
/*    */   }
/*    */   
/*    */   public int currentSegment(double[] paramArrayOfdouble) {
/* 84 */     double[] arrayOfDouble = this.a.a(this.n);
/* 85 */     paramArrayOfdouble[0] = arrayOfDouble[this.gO];
/* 86 */     paramArrayOfdouble[1] = arrayOfDouble[this.gP];
/*    */     
/* 88 */     if (this.n > 0 && arrayOfDouble == this.a.a(0)) {
/* 89 */       return 4;
/*    */     }
/* 91 */     if (this.a != null) {
/* 92 */       this.a.transform(paramArrayOfdouble, 0, paramArrayOfdouble, 0, 1);
/*    */     }
/*    */     
/* 95 */     if (this.a.g(this.n) == l.as) {
/* 96 */       return 0;
/*    */     }
/* 98 */     return 1;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\a\a\s.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */