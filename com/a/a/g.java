/*     */ package com.a.a;
/*     */ 
/*     */ import com.a.c.d;
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
/*     */ public class g
/*     */   extends RuntimeException
/*     */ {
/*  52 */   private String iY = null;
/*  53 */   private int gD = -1;
/*  54 */   private int gE = -1;
/*  55 */   private d a = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public g(String paramString) {
/*  61 */     this.iY = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public g(String paramString, int paramInt) {
/*  69 */     this.iY = paramString;
/*  70 */     this.gD = paramInt;
/*  71 */     this.gE = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public g(String paramString, int paramInt1, int paramInt2) {
/*  78 */     this.iY = paramString;
/*  79 */     this.gD = paramInt1;
/*  80 */     this.gE = paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public g(String paramString, int paramInt1, int paramInt2, d paramd) {
/*  87 */     this.iY = paramString;
/*  88 */     this.gD = paramInt1;
/*  89 */     this.gE = paramInt2;
/*  90 */     this.a = paramd;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int aF() {
/*  98 */     return this.gD;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int aG() {
/* 106 */     return this.gE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/* 113 */     return this.iY;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public d a() {
/* 121 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 128 */     String str = "";
/* 129 */     if (this.a != null) {
/* 130 */       str = "\n" + this.a.toString();
/*     */     }
/* 132 */     if (this.gD == -1 && this.gE == -1) {
/* 133 */       return this.iY + str;
/*     */     }
/* 135 */     if (this.gD == this.gE) {
/* 136 */       return this.iY + " : [" + this.gE + "]" + str;
/*     */     }
/* 138 */     return this.iY + " : [" + this.gD + ", " + this.gE + "]" + str;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\a\a\g.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */