/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.c;
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
/*     */ @c
/*     */ class bk<K, V>
/*     */   extends be<K, V>
/*     */ {
/*     */   static <K, V> bk<K, V>[] a(int paramInt) {
/*  43 */     return (bk<K, V>[])new bk[paramInt];
/*     */   }
/*     */   
/*     */   bk(K paramK, V paramV) {
/*  47 */     super(paramK, paramV);
/*  48 */     C.a(paramK, paramV);
/*     */   }
/*     */   
/*     */   bk(bk<K, V> parambk) {
/*  52 */     super(parambk.getKey(), parambk.getValue());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   bk<K, V> a() {
/*  58 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   bk<K, V> b() {
/*  63 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isReusable() {
/*  71 */     return true;
/*     */   }
/*     */   
/*     */   static class b<K, V> extends bk<K, V> {
/*     */     private final transient bk<K, V> b;
/*     */     
/*     */     b(K param1K, V param1V, bk<K, V> param1bk) {
/*  78 */       super(param1K, param1V);
/*  79 */       this.b = param1bk;
/*     */     }
/*     */ 
/*     */     
/*     */     final bk<K, V> a() {
/*  84 */       return this.b;
/*     */     }
/*     */ 
/*     */     
/*     */     final boolean isReusable() {
/*  89 */       return false;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static final class a<K, V>
/*     */     extends b<K, V>
/*     */   {
/*     */     private final transient bk<K, V> a;
/*     */ 
/*     */     
/*     */     a(K param1K, V param1V, bk<K, V> param1bk1, bk<K, V> param1bk2) {
/* 102 */       super(param1K, param1V, param1bk1);
/* 103 */       this.a = param1bk2;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     bk<K, V> b() {
/* 109 */       return this.a;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\bk.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */