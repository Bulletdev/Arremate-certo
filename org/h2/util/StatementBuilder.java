/*     */ package org.h2.util;
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
/*     */ public class StatementBuilder
/*     */ {
/*  32 */   private final StringBuilder builder = new StringBuilder();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int index;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StatementBuilder() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StatementBuilder(String paramString) {
/*  48 */     this.builder.append(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StatementBuilder append(String paramString) {
/*  58 */     this.builder.append(paramString);
/*  59 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StatementBuilder append(char paramChar) {
/*  69 */     this.builder.append(paramChar);
/*  70 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StatementBuilder append(long paramLong) {
/*  80 */     this.builder.append(paramLong);
/*  81 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StatementBuilder resetCount() {
/*  90 */     this.index = 0;
/*  91 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void appendOnlyFirst(String paramString) {
/* 100 */     if (this.index == 0) {
/* 101 */       this.builder.append(paramString);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void appendExceptFirst(String paramString) {
/* 111 */     if (this.index++ > 0) {
/* 112 */       this.builder.append(paramString);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 118 */     return this.builder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int length() {
/* 127 */     return this.builder.length();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\StatementBuilder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */