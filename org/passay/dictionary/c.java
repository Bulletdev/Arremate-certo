/*     */ package org.passay.dictionary;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import org.passay.dictionary.a.a;
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
/*     */ public class c
/*     */   extends b
/*     */ {
/*     */   protected String[] q;
/*     */   
/*     */   public c(String[] paramArrayOfString) {
/*  29 */     this(paramArrayOfString, true);
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
/*     */   public c(String[] paramArrayOfString, boolean paramBoolean) {
/*  43 */     this(paramArrayOfString, paramBoolean, (a)null);
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
/*     */   public c(String[] paramArrayOfString, boolean paramBoolean, a parama) {
/*  59 */     if (paramArrayOfString == null) {
/*  60 */       throw new IllegalArgumentException("Array cannot be null.");
/*     */     }
/*  62 */     if (paramBoolean) {
/*  63 */       this.comparator = l.m;
/*     */     } else {
/*  65 */       this.comparator = l.n;
/*     */     } 
/*  67 */     if (parama != null) {
/*  68 */       parama.a(paramArrayOfString, this.comparator);
/*     */     }
/*  70 */     for (byte b1 = 0; b1 < paramArrayOfString.length; b1++) {
/*  71 */       if (paramArrayOfString[b1] == null) {
/*  72 */         throw new IllegalArgumentException(Arrays.toString(paramArrayOfString) + " cannot contain null entry at index " + b1);
/*     */       }
/*  74 */       if (b1 > 0 && this.comparator.compare(paramArrayOfString[b1], paramArrayOfString[b1 - 1]) < 0) {
/*  75 */         throw new IllegalArgumentException(
/*  76 */             Arrays.toString(paramArrayOfString) + " sorted by " + parama + " is not correct for " + this.comparator + " at index " + b1);
/*     */       }
/*     */     } 
/*  79 */     this.q = paramArrayOfString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String get(int paramInt) {
/*  86 */     bz(paramInt);
/*  87 */     return this.q[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/*  94 */     return this.q.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 101 */     return String.format("%s@%h::size=%s", new Object[] { getClass().getName(), Integer.valueOf(hashCode()), Integer.valueOf(this.q.length) });
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\dictionary\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */