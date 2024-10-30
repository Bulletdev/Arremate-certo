/*     */ package org.apache.commons.text.similarity;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LevenshteinDistance
/*     */   implements EditDistance<Integer>
/*     */ {
/*  41 */   private static final LevenshteinDistance DEFAULT_INSTANCE = new LevenshteinDistance();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Integer threshold;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LevenshteinDistance() {
/*  57 */     this(null);
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
/*     */   public LevenshteinDistance(Integer paramInteger) {
/*  71 */     if (paramInteger != null && paramInteger.intValue() < 0) {
/*  72 */       throw new IllegalArgumentException("Threshold must not be negative");
/*     */     }
/*  74 */     this.threshold = paramInteger;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer apply(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 111 */     if (this.threshold != null) {
/* 112 */       return Integer.valueOf(limitedCompare(paramCharSequence1, paramCharSequence2, this.threshold.intValue()));
/*     */     }
/* 114 */     return Integer.valueOf(unlimitedCompare(paramCharSequence1, paramCharSequence2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static LevenshteinDistance getDefaultInstance() {
/* 123 */     return DEFAULT_INSTANCE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getThreshold() {
/* 132 */     return this.threshold;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int limitedCompare(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt) {
/* 167 */     if (paramCharSequence1 == null || paramCharSequence2 == null) {
/* 168 */       throw new IllegalArgumentException("CharSequences must not be null");
/*     */     }
/* 170 */     if (paramInt < 0) {
/* 171 */       throw new IllegalArgumentException("Threshold must not be negative");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 224 */     int i = paramCharSequence1.length();
/* 225 */     int j = paramCharSequence2.length();
/*     */ 
/*     */ 
/*     */     
/* 229 */     if (i == 0)
/* 230 */       return (j <= paramInt) ? j : -1; 
/* 231 */     if (j == 0) {
/* 232 */       return (i <= paramInt) ? i : -1;
/*     */     }
/*     */     
/* 235 */     if (i > j) {
/*     */       
/* 237 */       CharSequence charSequence = paramCharSequence1;
/* 238 */       paramCharSequence1 = paramCharSequence2;
/* 239 */       paramCharSequence2 = charSequence;
/* 240 */       i = j;
/* 241 */       j = paramCharSequence2.length();
/*     */     } 
/*     */ 
/*     */     
/* 245 */     if (j - i > paramInt) {
/* 246 */       return -1;
/*     */     }
/*     */     
/* 249 */     int[] arrayOfInt1 = new int[i + 1];
/* 250 */     int[] arrayOfInt2 = new int[i + 1];
/*     */ 
/*     */ 
/*     */     
/* 254 */     int k = Math.min(i, paramInt) + 1; byte b;
/* 255 */     for (b = 0; b < k; b++) {
/* 256 */       arrayOfInt1[b] = b;
/*     */     }
/*     */ 
/*     */     
/* 260 */     Arrays.fill(arrayOfInt1, k, arrayOfInt1.length, 2147483647);
/* 261 */     Arrays.fill(arrayOfInt2, 2147483647);
/*     */ 
/*     */     
/* 264 */     for (b = 1; b <= j; b++) {
/* 265 */       char c = paramCharSequence2.charAt(b - 1);
/* 266 */       arrayOfInt2[0] = b;
/*     */ 
/*     */       
/* 269 */       int m = Math.max(1, b - paramInt);
/* 270 */       int n = (b > Integer.MAX_VALUE - paramInt) ? i : Math.min(i, b + paramInt);
/*     */ 
/*     */ 
/*     */       
/* 274 */       if (m > 1) {
/* 275 */         arrayOfInt2[m - 1] = Integer.MAX_VALUE;
/*     */       }
/*     */ 
/*     */       
/* 279 */       for (int i1 = m; i1 <= n; i1++) {
/* 280 */         if (paramCharSequence1.charAt(i1 - 1) == c) {
/*     */           
/* 282 */           arrayOfInt2[i1] = arrayOfInt1[i1 - 1];
/*     */         }
/*     */         else {
/*     */           
/* 286 */           arrayOfInt2[i1] = 1 + Math.min(Math.min(arrayOfInt2[i1 - 1], arrayOfInt1[i1]), arrayOfInt1[i1 - 1]);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 291 */       int[] arrayOfInt = arrayOfInt1;
/* 292 */       arrayOfInt1 = arrayOfInt2;
/* 293 */       arrayOfInt2 = arrayOfInt;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 299 */     if (arrayOfInt1[i] <= paramInt) {
/* 300 */       return arrayOfInt1[i];
/*     */     }
/* 302 */     return -1;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int unlimitedCompare(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 336 */     if (paramCharSequence1 == null || paramCharSequence2 == null) {
/* 337 */       throw new IllegalArgumentException("CharSequences must not be null");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 345 */     int i = paramCharSequence1.length();
/* 346 */     int j = paramCharSequence2.length();
/*     */     
/* 348 */     if (i == 0)
/* 349 */       return j; 
/* 350 */     if (j == 0) {
/* 351 */       return i;
/*     */     }
/*     */     
/* 354 */     if (i > j) {
/*     */       
/* 356 */       CharSequence charSequence = paramCharSequence1;
/* 357 */       paramCharSequence1 = paramCharSequence2;
/* 358 */       paramCharSequence2 = charSequence;
/* 359 */       i = j;
/* 360 */       j = paramCharSequence2.length();
/*     */     } 
/*     */     
/* 363 */     int[] arrayOfInt = new int[i + 1];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     byte b1;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 374 */     for (b1 = 0; b1 <= i; b1++) {
/* 375 */       arrayOfInt[b1] = b1;
/*     */     }
/*     */     
/* 378 */     for (byte b2 = 1; b2 <= j; b2++) {
/* 379 */       int k = arrayOfInt[0];
/* 380 */       char c = paramCharSequence2.charAt(b2 - 1);
/* 381 */       arrayOfInt[0] = b2;
/*     */       
/* 383 */       for (b1 = 1; b1 <= i; b1++) {
/* 384 */         int m = arrayOfInt[b1];
/* 385 */         byte b = (paramCharSequence1.charAt(b1 - 1) == c) ? 0 : 1;
/*     */         
/* 387 */         arrayOfInt[b1] = Math.min(Math.min(arrayOfInt[b1 - 1] + 1, arrayOfInt[b1] + 1), k + b);
/* 388 */         k = m;
/*     */       } 
/*     */     } 
/*     */     
/* 392 */     return arrayOfInt[i];
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\similarity\LevenshteinDistance.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */