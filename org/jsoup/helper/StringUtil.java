/*     */ package org.jsoup.helper;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class StringUtil
/*     */ {
/*  11 */   private static final String[] padding = new String[] { "", " ", "  ", "   ", "    ", "     ", "      ", "       ", "        ", "         ", "          " };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String join(Collection paramCollection, String paramString) {
/*  20 */     return join(paramCollection.iterator(), paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String join(Iterator<E> paramIterator, String paramString) {
/*  30 */     if (!paramIterator.hasNext()) {
/*  31 */       return "";
/*     */     }
/*  33 */     String str = paramIterator.next().toString();
/*  34 */     if (!paramIterator.hasNext()) {
/*  35 */       return str;
/*     */     }
/*  37 */     StringBuilder stringBuilder = (new StringBuilder(64)).append(str);
/*  38 */     while (paramIterator.hasNext()) {
/*  39 */       stringBuilder.append(paramString);
/*  40 */       stringBuilder.append(paramIterator.next());
/*     */     } 
/*  42 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String padding(int paramInt) {
/*  51 */     if (paramInt < 0) {
/*  52 */       throw new IllegalArgumentException("width must be > 0");
/*     */     }
/*  54 */     if (paramInt < padding.length) {
/*  55 */       return padding[paramInt];
/*     */     }
/*  57 */     char[] arrayOfChar = new char[paramInt];
/*  58 */     for (byte b = 0; b < paramInt; b++)
/*  59 */       arrayOfChar[b] = ' '; 
/*  60 */     return String.valueOf(arrayOfChar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isBlank(String paramString) {
/*  69 */     if (paramString == null || paramString.length() == 0) {
/*  70 */       return true;
/*     */     }
/*  72 */     int i = paramString.length();
/*  73 */     for (byte b = 0; b < i; b++) {
/*  74 */       if (!isWhitespace(paramString.codePointAt(b)))
/*  75 */         return false; 
/*     */     } 
/*  77 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isNumeric(String paramString) {
/*  86 */     if (paramString == null || paramString.length() == 0) {
/*  87 */       return false;
/*     */     }
/*  89 */     int i = paramString.length();
/*  90 */     for (byte b = 0; b < i; b++) {
/*  91 */       if (!Character.isDigit(paramString.codePointAt(b)))
/*  92 */         return false; 
/*     */     } 
/*  94 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isWhitespace(int paramInt) {
/* 103 */     return (paramInt == 32 || paramInt == 9 || paramInt == 10 || paramInt == 12 || paramInt == 13);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String normaliseWhitespace(String paramString) {
/* 113 */     StringBuilder stringBuilder = new StringBuilder(paramString.length());
/* 114 */     appendNormalisedWhitespace(stringBuilder, paramString, false);
/* 115 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void appendNormalisedWhitespace(StringBuilder paramStringBuilder, String paramString, boolean paramBoolean) {
/* 126 */     boolean bool1 = false;
/* 127 */     boolean bool2 = false;
/*     */     
/* 129 */     int i = paramString.length();
/*     */     int j;
/* 131 */     for (j = 0; j < i; j += Character.charCount(k)) {
/* 132 */       int k = paramString.codePointAt(j);
/* 133 */       if (isWhitespace(k)) {
/* 134 */         if ((!paramBoolean || bool2) && !bool1) {
/*     */           
/* 136 */           paramStringBuilder.append(' ');
/* 137 */           bool1 = true;
/*     */         } 
/*     */       } else {
/* 140 */         paramStringBuilder.appendCodePoint(k);
/* 141 */         bool1 = false;
/* 142 */         bool2 = true;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static boolean in(String paramString, String... paramVarArgs) {
/* 148 */     for (String str : paramVarArgs) {
/* 149 */       if (str.equals(paramString))
/* 150 */         return true; 
/*     */     } 
/* 152 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\helper\StringUtil.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */