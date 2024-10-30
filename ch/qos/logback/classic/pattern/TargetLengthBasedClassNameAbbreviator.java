/*     */ package ch.qos.logback.classic.pattern;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TargetLengthBasedClassNameAbbreviator
/*     */   implements Abbreviator
/*     */ {
/*     */   final int targetLength;
/*     */   
/*     */   public TargetLengthBasedClassNameAbbreviator(int paramInt) {
/*  24 */     this.targetLength = paramInt;
/*     */   }
/*     */   
/*     */   public String abbreviate(String paramString) {
/*  28 */     StringBuilder stringBuilder = new StringBuilder(this.targetLength);
/*  29 */     if (paramString == null) {
/*  30 */       throw new IllegalArgumentException("Class name may not be null");
/*     */     }
/*     */     
/*  33 */     int i = paramString.length();
/*  34 */     if (i < this.targetLength) {
/*  35 */       return paramString;
/*     */     }
/*     */     
/*  38 */     int[] arrayOfInt1 = new int[16];
/*     */ 
/*     */     
/*  41 */     int[] arrayOfInt2 = new int[17];
/*     */     
/*  43 */     int j = computeDotIndexes(paramString, arrayOfInt1);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  48 */     if (j == 0) {
/*  49 */       return paramString;
/*     */     }
/*     */     
/*  52 */     computeLengthArray(paramString, arrayOfInt1, arrayOfInt2, j);
/*     */     
/*  54 */     for (byte b = 0; b <= j; b++) {
/*  55 */       if (b == 0) {
/*  56 */         stringBuilder.append(paramString.substring(0, arrayOfInt2[b] - 1));
/*     */       } else {
/*  58 */         stringBuilder.append(paramString.substring(arrayOfInt1[b - 1], arrayOfInt1[b - 1] + arrayOfInt2[b]));
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  63 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   static int computeDotIndexes(String paramString, int[] paramArrayOfint) {
/*  67 */     byte b = 0;
/*  68 */     int i = 0;
/*     */ 
/*     */     
/*     */     while (true) {
/*  72 */       i = paramString.indexOf('.', i);
/*  73 */       if (i != -1 && b < 16) {
/*  74 */         paramArrayOfint[b] = i;
/*  75 */         b++;
/*  76 */         i++;
/*     */         continue;
/*     */       } 
/*     */       break;
/*     */     } 
/*  81 */     return b;
/*     */   }
/*     */   
/*     */   void computeLengthArray(String paramString, int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt) {
/*  85 */     int i = paramString.length() - this.targetLength;
/*     */ 
/*     */     
/*     */     int j;
/*     */ 
/*     */     
/*  91 */     for (j = 0; j < paramInt; j++) {
/*  92 */       int m = -1;
/*  93 */       if (j > 0) {
/*  94 */         m = paramArrayOfint1[j - 1];
/*     */       }
/*  96 */       int n = paramArrayOfint1[j] - m - 1;
/*     */ 
/*     */       
/*  99 */       int k = (n < 1) ? n : 1;
/*     */ 
/*     */       
/* 102 */       if (i > 0) {
/* 103 */         k = (n < 1) ? n : 1;
/*     */       } else {
/* 105 */         k = n;
/*     */       } 
/* 107 */       i -= n - k;
/* 108 */       paramArrayOfint2[j] = k + 1;
/*     */     } 
/*     */     
/* 111 */     j = paramInt - 1;
/* 112 */     paramArrayOfint2[paramInt] = paramString.length() - paramArrayOfint1[j];
/*     */   }
/*     */   
/*     */   static void printArray(String paramString, int[] paramArrayOfint) {
/* 116 */     System.out.print(paramString);
/* 117 */     for (byte b = 0; b < paramArrayOfint.length; b++) {
/* 118 */       if (b == 0) {
/* 119 */         System.out.print(paramArrayOfint[b]);
/*     */       } else {
/* 121 */         System.out.print(", " + paramArrayOfint[b]);
/*     */       } 
/*     */     } 
/* 124 */     System.out.println();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\pattern\TargetLengthBasedClassNameAbbreviator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */