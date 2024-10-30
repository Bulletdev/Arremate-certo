/*     */ package org.passay.a;
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
/*     */ public class d
/*     */   implements a
/*     */ {
/*     */   public static final int jk = 1;
/*     */   public static final int jl = 8;
/*     */   public static final int jm = 20;
/*     */   public static final double aq = 4.0D;
/*     */   public static final double ar = 2.0D;
/*     */   public static final double as = 1.5D;
/*  34 */   public static final int[] aq = new int[] { 0, 0, 0, 4, 5, 6, 6, 6, 5, 5, 4, 4, 3, 3, 2, 2, 1, 1, 0 };
/*     */ 
/*     */ 
/*     */   
/*  38 */   public static final int[] ar = new int[] { 0, 0, 0, 2, 3, 3, 5, 6 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean dw;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean dx;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int jj;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public d(boolean paramBoolean1, boolean paramBoolean2, int paramInt) {
/*  61 */     this.dw = paramBoolean1;
/*  62 */     this.dx = paramBoolean2;
/*  63 */     this.jj = paramInt;
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
/*     */   public double U() {
/*  79 */     double d1 = 0.0D;
/*  80 */     if (this.jj > 0) {
/*  81 */       d1 += 4.0D;
/*  82 */       if (this.jj > 8) {
/*  83 */         d1 += 14.0D;
/*  84 */         if (this.jj > 20) {
/*     */           
/*  86 */           d1 += 18.0D + (this.jj - 20);
/*     */         } else {
/*     */           
/*  89 */           d1 += (this.jj - 8) * 1.5D;
/*     */         } 
/*     */       } else {
/*  92 */         d1 += (this.jj - 1) * 2.0D;
/*     */       } 
/*  94 */       if (this.dx) {
/*  95 */         d1 += ar[(this.jj > ar.length) ? (ar.length - 1) : (this.jj - 1)];
/*     */       }
/*     */ 
/*     */       
/*  99 */       if (this.dw) {
/* 100 */         d1 += aq[(this.jj > aq.length) ? (aq.length - 1) : (this.jj - 1)];
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 105 */     return d1;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\a\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */