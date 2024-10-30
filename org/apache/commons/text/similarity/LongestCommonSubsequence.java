/*     */ package org.apache.commons.text.similarity;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LongestCommonSubsequence
/*     */   implements SimilarityScore<Integer>
/*     */ {
/*     */   public Integer apply(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/*  58 */     if (paramCharSequence1 == null || paramCharSequence2 == null) {
/*  59 */       throw new IllegalArgumentException("Inputs must not be null");
/*     */     }
/*  61 */     return Integer.valueOf(longestCommonSubsequence(paramCharSequence1, paramCharSequence2).length());
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
/*     */   @Deprecated
/*     */   public CharSequence logestCommonSubsequence(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/*  91 */     return longestCommonSubsequence(paramCharSequence1, paramCharSequence2);
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
/*     */   public CharSequence longestCommonSubsequence(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 120 */     if (paramCharSequence1 == null || paramCharSequence2 == null) {
/* 121 */       throw new IllegalArgumentException("Inputs must not be null");
/*     */     }
/* 123 */     StringBuilder stringBuilder = new StringBuilder(Math.max(paramCharSequence1.length(), paramCharSequence2.length()));
/* 124 */     int[][] arrayOfInt = longestCommonSubstringLengthArray(paramCharSequence1, paramCharSequence2);
/* 125 */     int i = paramCharSequence1.length() - 1;
/* 126 */     int j = paramCharSequence2.length() - 1;
/* 127 */     int k = arrayOfInt[paramCharSequence1.length()][paramCharSequence2.length()] - 1;
/* 128 */     while (k >= 0) {
/* 129 */       if (paramCharSequence1.charAt(i) == paramCharSequence2.charAt(j)) {
/* 130 */         stringBuilder.append(paramCharSequence1.charAt(i));
/* 131 */         i--;
/* 132 */         j--;
/* 133 */         k--; continue;
/* 134 */       }  if (arrayOfInt[i + 1][j] < arrayOfInt[i][j + 1]) {
/* 135 */         i--; continue;
/*     */       } 
/* 137 */       j--;
/*     */     } 
/*     */     
/* 140 */     return stringBuilder.reverse().toString();
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
/*     */   public int[][] longestCommonSubstringLengthArray(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 154 */     int[][] arrayOfInt = new int[paramCharSequence1.length() + 1][paramCharSequence2.length() + 1];
/* 155 */     for (byte b = 0; b < paramCharSequence1.length(); b++) {
/* 156 */       for (byte b1 = 0; b1 < paramCharSequence2.length(); b1++) {
/* 157 */         if (b == 0) {
/* 158 */           arrayOfInt[b][b1] = 0;
/*     */         }
/* 160 */         if (b1 == 0) {
/* 161 */           arrayOfInt[b][b1] = 0;
/*     */         }
/* 163 */         if (paramCharSequence1.charAt(b) == paramCharSequence2.charAt(b1)) {
/* 164 */           arrayOfInt[b + 1][b1 + 1] = arrayOfInt[b][b1] + 1;
/*     */         } else {
/* 166 */           arrayOfInt[b + 1][b1 + 1] = Math.max(arrayOfInt[b + 1][b1], arrayOfInt[b][b1 + 1]);
/*     */         } 
/*     */       } 
/*     */     } 
/* 170 */     return arrayOfInt;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\similarity\LongestCommonSubsequence.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */