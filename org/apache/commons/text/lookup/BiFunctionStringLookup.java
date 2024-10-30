/*     */ package org.apache.commons.text.lookup;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import java.util.function.BiFunction;
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
/*     */ final class BiFunctionStringLookup<P, R>
/*     */   implements BiStringLookup<P>
/*     */ {
/*     */   private final BiFunction<String, P, R> biFunction;
/*     */   
/*     */   static <U, T> BiFunctionStringLookup<U, T> on(BiFunction<String, U, T> paramBiFunction) {
/*  41 */     return new BiFunctionStringLookup<>(paramBiFunction);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static <U, T> BiFunctionStringLookup<U, T> on(Map<String, T> paramMap) {
/*  52 */     return on((paramString, paramObject) -> paramMap.get(paramString));
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
/*     */   private BiFunctionStringLookup(BiFunction<String, P, R> paramBiFunction) {
/*  66 */     this.biFunction = paramBiFunction;
/*     */   }
/*     */ 
/*     */   
/*     */   public String lookup(String paramString) {
/*  71 */     return lookup(paramString, null);
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
/*     */   public String lookup(String paramString, P paramP) {
/*     */     R r;
/*  86 */     if (this.biFunction == null) {
/*  87 */       return null;
/*     */     }
/*     */     
/*     */     try {
/*  91 */       r = this.biFunction.apply(paramString, paramP);
/*  92 */     } catch (SecurityException|NullPointerException|IllegalArgumentException securityException) {
/*     */ 
/*     */       
/*  95 */       return null;
/*     */     } 
/*  97 */     return Objects.toString(r, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 102 */     return super.toString() + " [function=" + this.biFunction + "]";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\lookup\BiFunctionStringLookup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */