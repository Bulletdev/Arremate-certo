/*     */ package org.apache.poi.sl.usermodel;
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
/*     */ public final class Insets2D
/*     */   implements Cloneable
/*     */ {
/*     */   public double top;
/*     */   public double left;
/*     */   public double bottom;
/*     */   public double right;
/*     */   
/*     */   public Insets2D(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
/*  63 */     this.top = paramDouble1;
/*  64 */     this.left = paramDouble2;
/*  65 */     this.bottom = paramDouble3;
/*  66 */     this.right = paramDouble4;
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
/*     */   public void set(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
/*  79 */     this.top = paramDouble1;
/*  80 */     this.left = paramDouble2;
/*  81 */     this.bottom = paramDouble3;
/*  82 */     this.right = paramDouble4;
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
/*     */   public boolean equals(Object paramObject) {
/*  95 */     if (paramObject instanceof Insets2D) {
/*  96 */       Insets2D insets2D = (Insets2D)paramObject;
/*  97 */       return (this.top == insets2D.top && this.left == insets2D.left && this.bottom == insets2D.bottom && this.right == insets2D.right);
/*     */     } 
/*     */     
/* 100 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 109 */     double d1 = this.left + this.bottom;
/* 110 */     double d2 = this.right + this.top;
/* 111 */     double d3 = d1 * (d1 + 1.0D) / 2.0D + this.left;
/* 112 */     double d4 = d2 * (d2 + 1.0D) / 2.0D + this.top;
/* 113 */     double d5 = d3 + d4;
/* 114 */     return (int)(d5 * (d5 + 1.0D) / 2.0D + d4);
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
/*     */   public String toString() {
/* 127 */     return getClass().getName() + "[top=" + this.top + ",left=" + this.left + ",bottom=" + this.bottom + ",right=" + this.right + "]";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Insets2D clone() {
/* 136 */     return new Insets2D(this.top, this.left, this.bottom, this.right);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\Insets2D.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */