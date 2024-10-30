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
/*     */ public class LevenshteinDetailedDistance
/*     */   implements EditDistance<LevenshteinResults>
/*     */ {
/*  37 */   private static final LevenshteinDetailedDistance DEFAULT_INSTANCE = new LevenshteinDetailedDistance();
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
/*     */   public LevenshteinDetailedDistance() {
/*  52 */     this(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LevenshteinDetailedDistance(Integer paramInteger) {
/*  63 */     if (paramInteger != null && paramInteger.intValue() < 0) {
/*  64 */       throw new IllegalArgumentException("Threshold must not be negative");
/*     */     }
/*  66 */     this.threshold = paramInteger;
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
/*     */   public LevenshteinResults apply(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 103 */     if (this.threshold != null) {
/* 104 */       return limitedCompare(paramCharSequence1, paramCharSequence2, this.threshold.intValue());
/*     */     }
/* 106 */     return unlimitedCompare(paramCharSequence1, paramCharSequence2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static LevenshteinDetailedDistance getDefaultInstance() {
/* 115 */     return DEFAULT_INSTANCE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getThreshold() {
/* 124 */     return this.threshold;
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
/*     */   private static LevenshteinResults limitedCompare(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt) {
/* 161 */     if (paramCharSequence1 == null || paramCharSequence2 == null) {
/* 162 */       throw new IllegalArgumentException("CharSequences must not be null");
/*     */     }
/* 164 */     if (paramInt < 0) {
/* 165 */       throw new IllegalArgumentException("Threshold must not be negative");
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
/* 218 */     int i = paramCharSequence1.length();
/* 219 */     int j = paramCharSequence2.length();
/*     */ 
/*     */     
/* 222 */     if (i == 0)
/* 223 */       return (j <= paramInt) ? new LevenshteinResults(Integer.valueOf(j), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(0)) : new LevenshteinResults(Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)); 
/* 224 */     if (j == 0) {
/* 225 */       return (i <= paramInt) ? new LevenshteinResults(Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(0)) : new LevenshteinResults(Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
/*     */     }
/*     */     
/* 228 */     boolean bool = false;
/* 229 */     if (i > j) {
/*     */       
/* 231 */       CharSequence charSequence = paramCharSequence1;
/* 232 */       paramCharSequence1 = paramCharSequence2;
/* 233 */       paramCharSequence2 = charSequence;
/* 234 */       i = j;
/* 235 */       j = paramCharSequence2.length();
/* 236 */       bool = true;
/*     */     } 
/*     */     
/* 239 */     int[] arrayOfInt1 = new int[i + 1];
/* 240 */     int[] arrayOfInt2 = new int[i + 1];
/*     */     
/* 242 */     int[][] arrayOfInt = new int[j + 1][i + 1];
/*     */     
/*     */     int k;
/* 245 */     for (k = 0; k <= i; k++) {
/* 246 */       arrayOfInt[0][k] = k;
/*     */     }
/* 248 */     for (k = 0; k <= j; k++) {
/* 249 */       arrayOfInt[k][0] = k;
/*     */     }
/*     */ 
/*     */     
/* 253 */     k = Math.min(i, paramInt) + 1; byte b;
/* 254 */     for (b = 0; b < k; b++) {
/* 255 */       arrayOfInt1[b] = b;
/*     */     }
/*     */ 
/*     */     
/* 259 */     Arrays.fill(arrayOfInt1, k, arrayOfInt1.length, 2147483647);
/* 260 */     Arrays.fill(arrayOfInt2, 2147483647);
/*     */ 
/*     */     
/* 263 */     for (b = 1; b <= j; b++) {
/* 264 */       char c = paramCharSequence2.charAt(b - 1);
/* 265 */       arrayOfInt2[0] = b;
/*     */ 
/*     */       
/* 268 */       int m = Math.max(1, b - paramInt);
/* 269 */       int n = (b > Integer.MAX_VALUE - paramInt) ? i : Math.min(i, b + paramInt);
/*     */ 
/*     */ 
/*     */       
/* 273 */       if (m > n) {
/* 274 */         return new LevenshteinResults(Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
/*     */       }
/*     */ 
/*     */       
/* 278 */       if (m > 1) {
/* 279 */         arrayOfInt2[m - 1] = Integer.MAX_VALUE;
/*     */       }
/*     */ 
/*     */       
/* 283 */       for (int i1 = m; i1 <= n; i1++) {
/* 284 */         if (paramCharSequence1.charAt(i1 - 1) == c) {
/*     */           
/* 286 */           arrayOfInt2[i1] = arrayOfInt1[i1 - 1];
/*     */         } else {
/*     */           
/* 289 */           arrayOfInt2[i1] = 1 + Math.min(Math.min(arrayOfInt2[i1 - 1], arrayOfInt1[i1]), arrayOfInt1[i1 - 1]);
/*     */         } 
/* 291 */         arrayOfInt[b][i1] = arrayOfInt2[i1];
/*     */       } 
/*     */ 
/*     */       
/* 295 */       int[] arrayOfInt3 = arrayOfInt1;
/* 296 */       arrayOfInt1 = arrayOfInt2;
/* 297 */       arrayOfInt2 = arrayOfInt3;
/*     */     } 
/*     */ 
/*     */     
/* 301 */     if (arrayOfInt1[i] <= paramInt) {
/* 302 */       return findDetailedResults(paramCharSequence1, paramCharSequence2, arrayOfInt, bool);
/*     */     }
/* 304 */     return new LevenshteinResults(Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
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
/*     */   private static LevenshteinResults unlimitedCompare(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 340 */     if (paramCharSequence1 == null || paramCharSequence2 == null) {
/* 341 */       throw new IllegalArgumentException("CharSequences must not be null");
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
/* 361 */     int i = paramCharSequence1.length();
/* 362 */     int j = paramCharSequence2.length();
/*     */     
/* 364 */     if (i == 0)
/* 365 */       return new LevenshteinResults(Integer.valueOf(j), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(0)); 
/* 366 */     if (j == 0) {
/* 367 */       return new LevenshteinResults(Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(0));
/*     */     }
/* 369 */     boolean bool = false;
/* 370 */     if (i > j) {
/*     */       
/* 372 */       CharSequence charSequence = paramCharSequence1;
/* 373 */       paramCharSequence1 = paramCharSequence2;
/* 374 */       paramCharSequence2 = charSequence;
/* 375 */       i = j;
/* 376 */       j = paramCharSequence2.length();
/* 377 */       bool = true;
/*     */     } 
/*     */     
/* 380 */     int[] arrayOfInt1 = new int[i + 1];
/* 381 */     int[] arrayOfInt2 = new int[i + 1];
/*     */     
/* 383 */     int[][] arrayOfInt = new int[j + 1][i + 1];
/*     */     
/*     */     byte b1;
/* 386 */     for (b1 = 0; b1 <= i; b1++) {
/* 387 */       arrayOfInt[0][b1] = b1;
/*     */     }
/* 389 */     for (b1 = 0; b1 <= j; b1++) {
/* 390 */       arrayOfInt[b1][0] = b1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 400 */     for (b1 = 0; b1 <= i; b1++) {
/* 401 */       arrayOfInt1[b1] = b1;
/*     */     }
/*     */     
/* 404 */     for (byte b2 = 1; b2 <= j; b2++) {
/* 405 */       char c = paramCharSequence2.charAt(b2 - 1);
/* 406 */       arrayOfInt2[0] = b2;
/*     */       
/* 408 */       for (b1 = 1; b1 <= i; b1++) {
/* 409 */         byte b = (paramCharSequence1.charAt(b1 - 1) == c) ? 0 : 1;
/*     */         
/* 411 */         arrayOfInt2[b1] = Math.min(Math.min(arrayOfInt2[b1 - 1] + 1, arrayOfInt1[b1] + 1), arrayOfInt1[b1 - 1] + b);
/*     */         
/* 413 */         arrayOfInt[b2][b1] = arrayOfInt2[b1];
/*     */       } 
/*     */ 
/*     */       
/* 417 */       int[] arrayOfInt3 = arrayOfInt1;
/* 418 */       arrayOfInt1 = arrayOfInt2;
/* 419 */       arrayOfInt2 = arrayOfInt3;
/*     */     } 
/* 421 */     return findDetailedResults(paramCharSequence1, paramCharSequence2, arrayOfInt, bool);
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
/*     */   private static LevenshteinResults findDetailedResults(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int[][] paramArrayOfint, boolean paramBoolean) {
/* 441 */     byte b1 = 0;
/* 442 */     byte b2 = 0;
/* 443 */     byte b3 = 0;
/*     */     
/* 445 */     int i = paramCharSequence2.length();
/* 446 */     int j = paramCharSequence1.length();
/*     */     
/* 448 */     int k = 0;
/* 449 */     int m = 0;
/* 450 */     int n = 0;
/* 451 */     int i1 = 0;
/* 452 */     boolean bool1 = false;
/* 453 */     boolean bool2 = false;
/*     */     
/* 455 */     while (i >= 0 && j >= 0) {
/*     */       
/* 457 */       if (j == 0) {
/* 458 */         k = -1;
/*     */       } else {
/* 460 */         k = paramArrayOfint[i][j - 1];
/*     */       } 
/* 462 */       if (i == 0) {
/* 463 */         m = -1;
/*     */       } else {
/* 465 */         m = paramArrayOfint[i - 1][j];
/*     */       } 
/* 467 */       if (i > 0 && j > 0) {
/* 468 */         n = paramArrayOfint[i - 1][j - 1];
/*     */       } else {
/* 470 */         n = -1;
/*     */       } 
/* 472 */       if (k == -1 && m == -1 && n == -1) {
/*     */         break;
/*     */       }
/* 475 */       i1 = paramArrayOfint[i][j];
/*     */ 
/*     */ 
/*     */       
/* 479 */       if (j > 0 && i > 0 && paramCharSequence1.charAt(j - 1) == paramCharSequence2.charAt(i - 1)) {
/* 480 */         j--;
/* 481 */         i--;
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/* 486 */       bool1 = false;
/* 487 */       bool2 = false;
/* 488 */       if ((i1 - 1 == k && i1 <= n && i1 <= m) || (n == -1 && m == -1)) {
/*     */         
/* 490 */         j--;
/* 491 */         if (paramBoolean) {
/* 492 */           b2++;
/* 493 */           bool2 = true;
/*     */         } else {
/* 495 */           b1++;
/* 496 */           bool1 = true;
/*     */         } 
/* 498 */       } else if ((i1 - 1 == m && i1 <= n && i1 <= k) || (n == -1 && k == -1)) {
/*     */         
/* 500 */         i--;
/* 501 */         if (paramBoolean) {
/* 502 */           b1++;
/* 503 */           bool1 = true;
/*     */         } else {
/* 505 */           b2++;
/* 506 */           bool2 = true;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 511 */       if (!bool2 && !bool1) {
/* 512 */         b3++;
/* 513 */         j--;
/* 514 */         i--;
/*     */       } 
/*     */     } 
/* 517 */     return new LevenshteinResults(Integer.valueOf(b2 + b1 + b3), Integer.valueOf(b2), Integer.valueOf(b1), Integer.valueOf(b3));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\similarity\LevenshteinDetailedDistance.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */