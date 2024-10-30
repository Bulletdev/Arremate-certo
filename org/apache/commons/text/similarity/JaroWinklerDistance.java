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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JaroWinklerDistance
/*     */   implements EditDistance<Double>
/*     */ {
/*     */   @Deprecated
/*     */   public static final int INDEX_NOT_FOUND = -1;
/*     */   
/*     */   public Double apply(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/*  70 */     if (paramCharSequence1 == null || paramCharSequence2 == null) {
/*  71 */       throw new IllegalArgumentException("CharSequences must not be null");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  79 */     double d1 = 0.1D;
/*  80 */     int[] arrayOfInt = matches(paramCharSequence1, paramCharSequence2);
/*  81 */     double d2 = arrayOfInt[0];
/*  82 */     if (d2 == 0.0D) {
/*  83 */       return Double.valueOf(0.0D);
/*     */     }
/*  85 */     double d3 = (d2 / paramCharSequence1.length() + d2 / paramCharSequence2.length() + (d2 - arrayOfInt[1] / 2.0D) / d2) / 3.0D;
/*  86 */     double d4 = (d3 < 0.7D) ? d3 : (d3 + 0.1D * arrayOfInt[2] * (1.0D - d3));
/*  87 */     return Double.valueOf(d4);
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
/*     */   @Deprecated
/*     */   protected static int[] matches(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/*     */     CharSequence charSequence1, charSequence2;
/* 103 */     if (paramCharSequence1.length() > paramCharSequence2.length()) {
/* 104 */       charSequence1 = paramCharSequence1;
/* 105 */       charSequence2 = paramCharSequence2;
/*     */     } else {
/* 107 */       charSequence1 = paramCharSequence2;
/* 108 */       charSequence2 = paramCharSequence1;
/*     */     } 
/* 110 */     int i = Math.max(charSequence1.length() / 2 - 1, 0);
/* 111 */     int[] arrayOfInt = new int[charSequence2.length()];
/* 112 */     Arrays.fill(arrayOfInt, -1);
/* 113 */     boolean[] arrayOfBoolean = new boolean[charSequence1.length()];
/* 114 */     byte b1 = 0;
/* 115 */     for (byte b2 = 0; b2 < charSequence2.length(); b2++) {
/* 116 */       char c = charSequence2.charAt(b2);
/* 117 */       for (int j = Math.max(b2 - i, 0), k = Math.min(b2 + i + 1, charSequence1.length()); j < k; j++) {
/* 118 */         if (!arrayOfBoolean[j] && c == charSequence1.charAt(j)) {
/* 119 */           arrayOfInt[b2] = j;
/* 120 */           arrayOfBoolean[j] = true;
/* 121 */           b1++;
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 126 */     char[] arrayOfChar1 = new char[b1];
/* 127 */     char[] arrayOfChar2 = new char[b1]; byte b3, b4;
/* 128 */     for (b3 = 0, b4 = 0; b3 < charSequence2.length(); b3++) {
/* 129 */       if (arrayOfInt[b3] != -1) {
/* 130 */         arrayOfChar1[b4] = charSequence2.charAt(b3);
/* 131 */         b4++;
/*     */       } 
/*     */     } 
/* 134 */     for (b3 = 0, b4 = 0; b3 < charSequence1.length(); b3++) {
/* 135 */       if (arrayOfBoolean[b3]) {
/* 136 */         arrayOfChar2[b4] = charSequence1.charAt(b3);
/* 137 */         b4++;
/*     */       } 
/*     */     } 
/* 140 */     b3 = 0;
/* 141 */     for (b4 = 0; b4 < arrayOfChar1.length; b4++) {
/* 142 */       if (arrayOfChar1[b4] != arrayOfChar2[b4]) {
/* 143 */         b3++;
/*     */       }
/*     */     } 
/* 146 */     b4 = 0;
/* 147 */     for (byte b5 = 0; b5 < Math.min(4, charSequence2.length()) && 
/* 148 */       paramCharSequence1.charAt(b5) == paramCharSequence2.charAt(b5); b5++) {
/* 149 */       b4++;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 154 */     return new int[] { b1, b3, b4 };
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\similarity\JaroWinklerDistance.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */