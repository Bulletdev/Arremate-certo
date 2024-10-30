/*     */ package org.apache.http.pool;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
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
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class PoolStats
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -2807686144795228544L;
/*     */   private final int leased;
/*     */   private final int pending;
/*     */   private final int available;
/*     */   private final int max;
/*     */   
/*     */   public PoolStats(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  54 */     this.leased = paramInt1;
/*  55 */     this.pending = paramInt2;
/*  56 */     this.available = paramInt3;
/*  57 */     this.max = paramInt4;
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
/*     */   public int getLeased() {
/*  70 */     return this.leased;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPending() {
/*  80 */     return this.pending;
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
/*     */   public int getAvailable() {
/*  92 */     return this.available;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMax() {
/* 101 */     return this.max;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 106 */     StringBuilder stringBuilder = new StringBuilder();
/* 107 */     stringBuilder.append("[leased: ");
/* 108 */     stringBuilder.append(this.leased);
/* 109 */     stringBuilder.append("; pending: ");
/* 110 */     stringBuilder.append(this.pending);
/* 111 */     stringBuilder.append("; available: ");
/* 112 */     stringBuilder.append(this.available);
/* 113 */     stringBuilder.append("; max: ");
/* 114 */     stringBuilder.append(this.max);
/* 115 */     stringBuilder.append("]");
/* 116 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\pool\PoolStats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */