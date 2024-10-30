/*     */ package com.a.c;
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
/*     */ public class o
/*     */ {
/*     */   private boolean caseSensitive = true;
/*  46 */   private String[] b = new String[2];
/*  47 */   private double[] h = new double[2];
/*  48 */   private int gR = 0;
/*     */   
/*     */   public o() {
/*  51 */     this(true);
/*     */   }
/*     */   
/*     */   public o(boolean paramBoolean) {
/*  55 */     this.caseSensitive = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getValue(String paramString) {
/*  64 */     for (byte b = 0; b < this.gR; b++) {
/*  65 */       if ((this.caseSensitive && this.b[b].equals(paramString)) || (!this.caseSensitive && this.b[b].equalsIgnoreCase(paramString)))
/*  66 */         return this.h[b]; 
/*     */     } 
/*  68 */     throw new RuntimeException("variable value has not been set: " + paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(String paramString, double paramDouble) {
/*  77 */     if (paramString == null) {
/*  78 */       throw new IllegalArgumentException("varName cannot be null");
/*     */     }
/*  80 */     for (byte b = 0; b < this.gR; b++) {
/*  81 */       if ((this.caseSensitive && this.b[b].equals(paramString)) || (!this.caseSensitive && this.b[b].equalsIgnoreCase(paramString))) {
/*  82 */         this.h[b] = paramDouble;
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*  87 */     if (this.gR == this.b.length) {
/*  88 */       String[] arrayOfString = new String[2 * this.gR];
/*  89 */       double[] arrayOfDouble = new double[arrayOfString.length];
/*     */       
/*  91 */       for (byte b1 = 0; b1 < this.gR; b1++) {
/*  92 */         arrayOfString[b1] = this.b[b1];
/*  93 */         arrayOfDouble[b1] = this.h[b1];
/*     */       } 
/*     */       
/*  96 */       this.b = arrayOfString;
/*  97 */       this.h = arrayOfDouble;
/*     */     } 
/*     */     
/* 100 */     this.b[this.gR] = paramString;
/* 101 */     this.h[this.gR] = paramDouble;
/* 102 */     this.gR++;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCaseSensitive() {
/* 109 */     return this.caseSensitive;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] getVariableNames() {
/* 116 */     String[] arrayOfString = new String[this.gR];
/*     */     
/* 118 */     for (byte b = 0; b < arrayOfString.length; b++) {
/* 119 */       arrayOfString[b] = this.b[b];
/*     */     }
/* 121 */     return arrayOfString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double[] c() {
/* 129 */     double[] arrayOfDouble = new double[this.gR];
/*     */     
/* 131 */     for (byte b = 0; b < arrayOfDouble.length; b++) {
/* 132 */       arrayOfDouble[b] = this.h[b];
/*     */     }
/* 134 */     return arrayOfDouble;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(String paramString) {
/* 141 */     for (byte b = 0; b < this.gR; b++) {
/* 142 */       if ((this.caseSensitive && this.b[b].equals(paramString)) || (!this.caseSensitive && this.b[b].equalsIgnoreCase(paramString))) {
/* 143 */         for (int i = b + 1; i < this.gR; i++) {
/* 144 */           this.b[i - 1] = this.b[i];
/* 145 */           this.h[i - 1] = this.h[i];
/*     */         } 
/* 147 */         this.gR--;
/* 148 */         this.b[this.gR] = null;
/* 149 */         this.h[this.gR] = 0.0D;
/*     */         break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\a\c\o.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */