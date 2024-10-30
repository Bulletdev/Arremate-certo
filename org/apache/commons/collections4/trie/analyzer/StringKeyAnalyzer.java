/*     */ package org.apache.commons.collections4.trie.analyzer;
/*     */ 
/*     */ import org.apache.commons.collections4.trie.KeyAnalyzer;
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
/*     */ public class StringKeyAnalyzer
/*     */   extends KeyAnalyzer<String>
/*     */ {
/*     */   private static final long serialVersionUID = -7032449491269434877L;
/*  32 */   public static final StringKeyAnalyzer INSTANCE = new StringKeyAnalyzer();
/*     */ 
/*     */   
/*     */   public static final int LENGTH = 16;
/*     */ 
/*     */   
/*     */   private static final int MSB = 32768;
/*     */ 
/*     */   
/*     */   private static int mask(int paramInt) {
/*  42 */     return 32768 >>> paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public int bitsPerElement() {
/*  47 */     return 16;
/*     */   }
/*     */ 
/*     */   
/*     */   public int lengthInBits(String paramString) {
/*  52 */     return (paramString != null) ? (paramString.length() * 16) : 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int bitIndex(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, int paramInt4) {
/*  59 */     boolean bool = true;
/*     */     
/*  61 */     if (paramInt1 % 16 != 0 || paramInt3 % 16 != 0 || paramInt2 % 16 != 0 || paramInt4 % 16 != 0)
/*     */     {
/*  63 */       throw new IllegalArgumentException("The offsets and lengths must be at Character boundaries");
/*     */     }
/*     */     
/*  66 */     int i = paramInt1 / 16;
/*  67 */     int j = paramInt3 / 16;
/*     */     
/*  69 */     int k = i + paramInt2 / 16;
/*  70 */     int m = j + paramInt4 / 16;
/*     */     
/*  72 */     int n = Math.max(k, m);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  77 */     char c1 = Character.MIN_VALUE, c2 = Character.MIN_VALUE;
/*  78 */     for (byte b = 0; b < n; b++) {
/*  79 */       int i1 = i + b;
/*  80 */       int i2 = j + b;
/*     */       
/*  82 */       if (i1 >= k) {
/*  83 */         c1 = Character.MIN_VALUE;
/*     */       } else {
/*  85 */         c1 = paramString1.charAt(i1);
/*     */       } 
/*     */       
/*  88 */       if (paramString2 == null || i2 >= m) {
/*  89 */         c2 = Character.MIN_VALUE;
/*     */       } else {
/*  91 */         c2 = paramString2.charAt(i2);
/*     */       } 
/*     */       
/*  94 */       if (c1 != c2) {
/*  95 */         int i3 = c1 ^ c2;
/*  96 */         return b * 16 + Integer.numberOfLeadingZeros(i3) - 16;
/*     */       } 
/*     */       
/*  99 */       if (c1 != '\000') {
/* 100 */         bool = false;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 105 */     if (bool) {
/* 106 */       return -1;
/*     */     }
/*     */ 
/*     */     
/* 110 */     return -2;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isBitSet(String paramString, int paramInt1, int paramInt2) {
/* 115 */     if (paramString == null || paramInt1 >= paramInt2) {
/* 116 */       return false;
/*     */     }
/*     */     
/* 119 */     int i = paramInt1 / 16;
/* 120 */     int j = paramInt1 % 16;
/*     */     
/* 122 */     return ((paramString.charAt(i) & mask(j)) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPrefix(String paramString1, int paramInt1, int paramInt2, String paramString2) {
/* 128 */     if (paramInt1 % 16 != 0 || paramInt2 % 16 != 0) {
/* 129 */       throw new IllegalArgumentException("Cannot determine prefix outside of Character boundaries");
/*     */     }
/*     */ 
/*     */     
/* 133 */     String str = paramString1.substring(paramInt1 / 16, paramInt2 / 16);
/* 134 */     return paramString2.startsWith(str);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\trie\analyzer\StringKeyAnalyzer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */