/*      */ package org.apache.commons.lang3;
/*      */ 
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.nio.charset.Charset;
/*      */ import java.text.Normalizer;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Locale;
/*      */ import java.util.Objects;
/*      */ import java.util.function.Supplier;
/*      */ import java.util.regex.Pattern;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class StringUtils
/*      */ {
/*      */   private static final int STRING_BUILDER_SIZE = 256;
/*      */   public static final String SPACE = " ";
/*      */   public static final String EMPTY = "";
/*      */   public static final String LF = "\n";
/*      */   public static final String CR = "\r";
/*      */   public static final int INDEX_NOT_FOUND = -1;
/*      */   private static final int PAD_LIMIT = 8192;
/*  185 */   private static final Pattern STRIP_ACCENTS_PATTERN = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String abbreviate(String paramString, int paramInt) {
/*  221 */     return abbreviate(paramString, "...", 0, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String abbreviate(String paramString, int paramInt1, int paramInt2) {
/*  260 */     return abbreviate(paramString, "...", paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String abbreviate(String paramString1, String paramString2, int paramInt) {
/*  300 */     return abbreviate(paramString1, paramString2, 0, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String abbreviate(String paramString1, String paramString2, int paramInt1, int paramInt2) {
/*  340 */     if (isNotEmpty(paramString1) && "".equals(paramString2) && paramInt2 > 0)
/*  341 */       return substring(paramString1, 0, paramInt2); 
/*  342 */     if (isAnyEmpty(new CharSequence[] { paramString1, paramString2 })) {
/*  343 */       return paramString1;
/*      */     }
/*  345 */     int i = paramString2.length();
/*  346 */     int j = i + 1;
/*  347 */     int k = i + i + 1;
/*      */     
/*  349 */     if (paramInt2 < j) {
/*  350 */       throw new IllegalArgumentException(String.format("Minimum abbreviation width is %d", new Object[] { Integer.valueOf(j) }));
/*      */     }
/*  352 */     if (paramString1.length() <= paramInt2) {
/*  353 */       return paramString1;
/*      */     }
/*  355 */     if (paramInt1 > paramString1.length()) {
/*  356 */       paramInt1 = paramString1.length();
/*      */     }
/*  358 */     if (paramString1.length() - paramInt1 < paramInt2 - i) {
/*  359 */       paramInt1 = paramString1.length() - paramInt2 - i;
/*      */     }
/*  361 */     if (paramInt1 <= i + 1) {
/*  362 */       return paramString1.substring(0, paramInt2 - i) + paramString2;
/*      */     }
/*  364 */     if (paramInt2 < k) {
/*  365 */       throw new IllegalArgumentException(String.format("Minimum abbreviation width with offset is %d", new Object[] { Integer.valueOf(k) }));
/*      */     }
/*  367 */     if (paramInt1 + paramInt2 - i < paramString1.length()) {
/*  368 */       return paramString2 + abbreviate(paramString1.substring(paramInt1), paramString2, paramInt2 - i);
/*      */     }
/*  370 */     return paramString2 + paramString1.substring(paramString1.length() - paramInt2 - i);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String abbreviateMiddle(String paramString1, String paramString2, int paramInt) {
/*  403 */     if (isAnyEmpty(new CharSequence[] { paramString1, paramString2 }) || paramInt >= paramString1.length() || paramInt < paramString2.length() + 2) {
/*  404 */       return paramString1;
/*      */     }
/*      */     
/*  407 */     int i = paramInt - paramString2.length();
/*  408 */     int j = i / 2 + i % 2;
/*  409 */     int k = paramString1.length() - i / 2;
/*      */     
/*  411 */     return paramString1.substring(0, j) + paramString2 + paramString1
/*      */       
/*  413 */       .substring(k);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String appendIfMissing(String paramString, CharSequence paramCharSequence, boolean paramBoolean, CharSequence... paramVarArgs) {
/*  428 */     if (paramString == null || isEmpty(paramCharSequence) || endsWith(paramString, paramCharSequence, paramBoolean)) {
/*  429 */       return paramString;
/*      */     }
/*  431 */     if (ArrayUtils.isNotEmpty(paramVarArgs)) {
/*  432 */       for (CharSequence charSequence : paramVarArgs) {
/*  433 */         if (endsWith(paramString, charSequence, paramBoolean)) {
/*  434 */           return paramString;
/*      */         }
/*      */       } 
/*      */     }
/*  438 */     return paramString + paramCharSequence.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String appendIfMissing(String paramString, CharSequence paramCharSequence, CharSequence... paramVarArgs) {
/*  476 */     return appendIfMissing(paramString, paramCharSequence, false, paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String appendIfMissingIgnoreCase(String paramString, CharSequence paramCharSequence, CharSequence... paramVarArgs) {
/*  514 */     return appendIfMissing(paramString, paramCharSequence, true, paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String capitalize(String paramString) {
/*  539 */     int i = length(paramString);
/*  540 */     if (i == 0) {
/*  541 */       return paramString;
/*      */     }
/*      */     
/*  544 */     int j = paramString.codePointAt(0);
/*  545 */     int k = Character.toTitleCase(j);
/*  546 */     if (j == k)
/*      */     {
/*  548 */       return paramString;
/*      */     }
/*      */     
/*  551 */     int[] arrayOfInt = new int[i];
/*  552 */     byte b = 0;
/*  553 */     arrayOfInt[b++] = k; int m;
/*  554 */     for (m = Character.charCount(j); m < i; ) {
/*  555 */       int n = paramString.codePointAt(m);
/*  556 */       arrayOfInt[b++] = n;
/*  557 */       m += Character.charCount(n);
/*      */     } 
/*  559 */     return new String(arrayOfInt, 0, b);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String center(String paramString, int paramInt) {
/*  588 */     return center(paramString, paramInt, ' ');
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String center(String paramString, int paramInt, char paramChar) {
/*  616 */     if (paramString == null || paramInt <= 0) {
/*  617 */       return paramString;
/*      */     }
/*  619 */     int i = paramString.length();
/*  620 */     int j = paramInt - i;
/*  621 */     if (j <= 0) {
/*  622 */       return paramString;
/*      */     }
/*  624 */     paramString = leftPad(paramString, i + j / 2, paramChar);
/*  625 */     paramString = rightPad(paramString, paramInt, paramChar);
/*  626 */     return paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String center(String paramString1, int paramInt, String paramString2) {
/*  656 */     if (paramString1 == null || paramInt <= 0) {
/*  657 */       return paramString1;
/*      */     }
/*  659 */     if (isEmpty(paramString2)) {
/*  660 */       paramString2 = " ";
/*      */     }
/*  662 */     int i = paramString1.length();
/*  663 */     int j = paramInt - i;
/*  664 */     if (j <= 0) {
/*  665 */       return paramString1;
/*      */     }
/*  667 */     paramString1 = leftPad(paramString1, i + j / 2, paramString2);
/*  668 */     paramString1 = rightPad(paramString1, paramInt, paramString2);
/*  669 */     return paramString1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String chomp(String paramString) {
/*  700 */     if (isEmpty(paramString)) {
/*  701 */       return paramString;
/*      */     }
/*      */     
/*  704 */     if (paramString.length() == 1) {
/*  705 */       char c1 = paramString.charAt(0);
/*  706 */       if (c1 == '\r' || c1 == '\n') {
/*  707 */         return "";
/*      */       }
/*  709 */       return paramString;
/*      */     } 
/*      */     
/*  712 */     int i = paramString.length() - 1;
/*  713 */     char c = paramString.charAt(i);
/*      */     
/*  715 */     if (c == '\n') {
/*  716 */       if (paramString.charAt(i - 1) == '\r') {
/*  717 */         i--;
/*      */       }
/*  719 */     } else if (c != '\r') {
/*  720 */       i++;
/*      */     } 
/*  722 */     return paramString.substring(0, i);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static String chomp(String paramString1, String paramString2) {
/*  754 */     return removeEnd(paramString1, paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String chop(String paramString) {
/*  783 */     if (paramString == null) {
/*  784 */       return null;
/*      */     }
/*  786 */     int i = paramString.length();
/*  787 */     if (i < 2) {
/*  788 */       return "";
/*      */     }
/*  790 */     int j = i - 1;
/*  791 */     String str = paramString.substring(0, j);
/*  792 */     char c = paramString.charAt(j);
/*  793 */     if (c == '\n' && str.charAt(j - 1) == '\r') {
/*  794 */       return str.substring(0, j - 1);
/*      */     }
/*  796 */     return str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int compare(String paramString1, String paramString2) {
/*  834 */     return compare(paramString1, paramString2, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int compare(String paramString1, String paramString2, boolean paramBoolean) {
/*  872 */     if (paramString1 == paramString2) {
/*  873 */       return 0;
/*      */     }
/*  875 */     if (paramString1 == null) {
/*  876 */       return paramBoolean ? -1 : 1;
/*      */     }
/*  878 */     if (paramString2 == null) {
/*  879 */       return paramBoolean ? 1 : -1;
/*      */     }
/*  881 */     return paramString1.compareTo(paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int compareIgnoreCase(String paramString1, String paramString2) {
/*  922 */     return compareIgnoreCase(paramString1, paramString2, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int compareIgnoreCase(String paramString1, String paramString2, boolean paramBoolean) {
/*  965 */     if (paramString1 == paramString2) {
/*  966 */       return 0;
/*      */     }
/*  968 */     if (paramString1 == null) {
/*  969 */       return paramBoolean ? -1 : 1;
/*      */     }
/*  971 */     if (paramString2 == null) {
/*  972 */       return paramBoolean ? 1 : -1;
/*      */     }
/*  974 */     return paramString1.compareToIgnoreCase(paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean contains(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 1000 */     if (paramCharSequence1 == null || paramCharSequence2 == null) {
/* 1001 */       return false;
/*      */     }
/* 1003 */     return (CharSequenceUtils.indexOf(paramCharSequence1, paramCharSequence2, 0) >= 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean contains(CharSequence paramCharSequence, int paramInt) {
/* 1029 */     if (isEmpty(paramCharSequence)) {
/* 1030 */       return false;
/*      */     }
/* 1032 */     return (CharSequenceUtils.indexOf(paramCharSequence, paramInt, 0) >= 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean containsAny(CharSequence paramCharSequence, char... paramVarArgs) {
/* 1063 */     if (isEmpty(paramCharSequence) || ArrayUtils.isEmpty(paramVarArgs)) {
/* 1064 */       return false;
/*      */     }
/* 1066 */     int i = paramCharSequence.length();
/* 1067 */     int j = paramVarArgs.length;
/* 1068 */     int k = i - 1;
/* 1069 */     int m = j - 1;
/* 1070 */     for (byte b = 0; b < i; b++) {
/* 1071 */       char c = paramCharSequence.charAt(b);
/* 1072 */       for (byte b1 = 0; b1 < j; b1++) {
/* 1073 */         if (paramVarArgs[b1] == c) {
/* 1074 */           if (Character.isHighSurrogate(c)) {
/* 1075 */             if (b1 == m)
/*      */             {
/* 1077 */               return true;
/*      */             }
/* 1079 */             if (b < k && paramVarArgs[b1 + 1] == paramCharSequence.charAt(b + 1)) {
/* 1080 */               return true;
/*      */             }
/*      */           } else {
/*      */             
/* 1084 */             return true;
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/* 1089 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean containsAny(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 1124 */     if (paramCharSequence2 == null) {
/* 1125 */       return false;
/*      */     }
/* 1127 */     return containsAny(paramCharSequence1, CharSequenceUtils.toCharArray(paramCharSequence2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean containsAny(CharSequence paramCharSequence, CharSequence... paramVarArgs) {
/* 1156 */     if (isEmpty(paramCharSequence) || ArrayUtils.isEmpty((Object[])paramVarArgs)) {
/* 1157 */       return false;
/*      */     }
/* 1159 */     for (CharSequence charSequence : paramVarArgs) {
/* 1160 */       if (contains(paramCharSequence, charSequence)) {
/* 1161 */         return true;
/*      */       }
/*      */     } 
/* 1164 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean containsIgnoreCase(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 1192 */     if (paramCharSequence1 == null || paramCharSequence2 == null) {
/* 1193 */       return false;
/*      */     }
/* 1195 */     int i = paramCharSequence2.length();
/* 1196 */     int j = paramCharSequence1.length() - i;
/* 1197 */     for (byte b = 0; b <= j; b++) {
/* 1198 */       if (CharSequenceUtils.regionMatches(paramCharSequence1, true, b, paramCharSequence2, 0, i)) {
/* 1199 */         return true;
/*      */       }
/*      */     } 
/* 1202 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean containsNone(CharSequence paramCharSequence, char... paramVarArgs) {
/* 1231 */     if (paramCharSequence == null || paramVarArgs == null) {
/* 1232 */       return true;
/*      */     }
/* 1234 */     int i = paramCharSequence.length();
/* 1235 */     int j = i - 1;
/* 1236 */     int k = paramVarArgs.length;
/* 1237 */     int m = k - 1;
/* 1238 */     for (byte b = 0; b < i; b++) {
/* 1239 */       char c = paramCharSequence.charAt(b);
/* 1240 */       for (byte b1 = 0; b1 < k; b1++) {
/* 1241 */         if (paramVarArgs[b1] == c) {
/* 1242 */           if (Character.isHighSurrogate(c)) {
/* 1243 */             if (b1 == m)
/*      */             {
/* 1245 */               return false;
/*      */             }
/* 1247 */             if (b < j && paramVarArgs[b1 + 1] == paramCharSequence.charAt(b + 1)) {
/* 1248 */               return false;
/*      */             }
/*      */           } else {
/*      */             
/* 1252 */             return false;
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/* 1257 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean containsNone(CharSequence paramCharSequence, String paramString) {
/* 1284 */     if (paramCharSequence == null || paramString == null) {
/* 1285 */       return true;
/*      */     }
/* 1287 */     return containsNone(paramCharSequence, paramString.toCharArray());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean containsOnly(CharSequence paramCharSequence, char... paramVarArgs) {
/* 1316 */     if (paramVarArgs == null || paramCharSequence == null) {
/* 1317 */       return false;
/*      */     }
/* 1319 */     if (paramCharSequence.length() == 0) {
/* 1320 */       return true;
/*      */     }
/* 1322 */     if (paramVarArgs.length == 0) {
/* 1323 */       return false;
/*      */     }
/* 1325 */     return (indexOfAnyBut(paramCharSequence, paramVarArgs) == -1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean containsOnly(CharSequence paramCharSequence, String paramString) {
/* 1352 */     if (paramCharSequence == null || paramString == null) {
/* 1353 */       return false;
/*      */     }
/* 1355 */     return containsOnly(paramCharSequence, paramString.toCharArray());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean containsWhitespace(CharSequence paramCharSequence) {
/* 1370 */     if (isEmpty(paramCharSequence)) {
/* 1371 */       return false;
/*      */     }
/* 1373 */     int i = paramCharSequence.length();
/* 1374 */     for (byte b = 0; b < i; b++) {
/* 1375 */       if (Character.isWhitespace(paramCharSequence.charAt(b))) {
/* 1376 */         return true;
/*      */       }
/*      */     } 
/* 1379 */     return false;
/*      */   }
/*      */   
/*      */   private static void convertRemainingAccentCharacters(StringBuilder paramStringBuilder) {
/* 1383 */     for (byte b = 0; b < paramStringBuilder.length(); b++) {
/* 1384 */       if (paramStringBuilder.charAt(b) == 'Ł') {
/* 1385 */         paramStringBuilder.deleteCharAt(b);
/* 1386 */         paramStringBuilder.insert(b, 'L');
/* 1387 */       } else if (paramStringBuilder.charAt(b) == 'ł') {
/* 1388 */         paramStringBuilder.deleteCharAt(b);
/* 1389 */         paramStringBuilder.insert(b, 'l');
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int countMatches(CharSequence paramCharSequence, char paramChar) {
/* 1414 */     if (isEmpty(paramCharSequence)) {
/* 1415 */       return 0;
/*      */     }
/* 1417 */     byte b1 = 0;
/*      */     
/* 1419 */     for (byte b2 = 0; b2 < paramCharSequence.length(); b2++) {
/* 1420 */       if (paramChar == paramCharSequence.charAt(b2)) {
/* 1421 */         b1++;
/*      */       }
/*      */     } 
/* 1424 */     return b1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int countMatches(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 1450 */     if (isEmpty(paramCharSequence1) || isEmpty(paramCharSequence2)) {
/* 1451 */       return 0;
/*      */     }
/* 1453 */     byte b = 0;
/* 1454 */     int i = 0;
/* 1455 */     while ((i = CharSequenceUtils.indexOf(paramCharSequence1, paramCharSequence2, i)) != -1) {
/* 1456 */       b++;
/* 1457 */       i += paramCharSequence2.length();
/*      */     } 
/* 1459 */     return b;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends CharSequence> T defaultIfBlank(T paramT1, T paramT2) {
/* 1483 */     return isBlank((CharSequence)paramT1) ? paramT2 : paramT1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends CharSequence> T defaultIfEmpty(T paramT1, T paramT2) {
/* 1505 */     return isEmpty((CharSequence)paramT1) ? paramT2 : paramT1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String defaultString(String paramString) {
/* 1525 */     return defaultString(paramString, "");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String defaultString(String paramString1, String paramString2) {
/* 1546 */     return (paramString1 == null) ? paramString2 : paramString1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String deleteWhitespace(String paramString) {
/* 1566 */     if (isEmpty(paramString)) {
/* 1567 */       return paramString;
/*      */     }
/* 1569 */     int i = paramString.length();
/* 1570 */     char[] arrayOfChar = new char[i];
/* 1571 */     byte b1 = 0;
/* 1572 */     for (byte b2 = 0; b2 < i; b2++) {
/* 1573 */       if (!Character.isWhitespace(paramString.charAt(b2))) {
/* 1574 */         arrayOfChar[b1++] = paramString.charAt(b2);
/*      */       }
/*      */     } 
/* 1577 */     if (b1 == i) {
/* 1578 */       return paramString;
/*      */     }
/* 1580 */     return new String(arrayOfChar, 0, b1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String difference(String paramString1, String paramString2) {
/* 1614 */     if (paramString1 == null) {
/* 1615 */       return paramString2;
/*      */     }
/* 1617 */     if (paramString2 == null) {
/* 1618 */       return paramString1;
/*      */     }
/* 1620 */     int i = indexOfDifference(paramString1, paramString2);
/* 1621 */     if (i == -1) {
/* 1622 */       return "";
/*      */     }
/* 1624 */     return paramString2.substring(i);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean endsWith(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 1652 */     return endsWith(paramCharSequence1, paramCharSequence2, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean endsWith(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean) {
/* 1667 */     if (paramCharSequence1 == null || paramCharSequence2 == null) {
/* 1668 */       return (paramCharSequence1 == paramCharSequence2);
/*      */     }
/* 1670 */     if (paramCharSequence2.length() > paramCharSequence1.length()) {
/* 1671 */       return false;
/*      */     }
/* 1673 */     int i = paramCharSequence1.length() - paramCharSequence2.length();
/* 1674 */     return CharSequenceUtils.regionMatches(paramCharSequence1, paramBoolean, i, paramCharSequence2, 0, paramCharSequence2.length());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean endsWithAny(CharSequence paramCharSequence, CharSequence... paramVarArgs) {
/* 1699 */     if (isEmpty(paramCharSequence) || ArrayUtils.isEmpty((Object[])paramVarArgs)) {
/* 1700 */       return false;
/*      */     }
/* 1702 */     for (CharSequence charSequence : paramVarArgs) {
/* 1703 */       if (endsWith(paramCharSequence, charSequence)) {
/* 1704 */         return true;
/*      */       }
/*      */     } 
/* 1707 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean endsWithIgnoreCase(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 1734 */     return endsWith(paramCharSequence1, paramCharSequence2, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean equals(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 1762 */     if (paramCharSequence1 == paramCharSequence2) {
/* 1763 */       return true;
/*      */     }
/* 1765 */     if (paramCharSequence1 == null || paramCharSequence2 == null) {
/* 1766 */       return false;
/*      */     }
/* 1768 */     if (paramCharSequence1.length() != paramCharSequence2.length()) {
/* 1769 */       return false;
/*      */     }
/* 1771 */     if (paramCharSequence1 instanceof String && paramCharSequence2 instanceof String) {
/* 1772 */       return paramCharSequence1.equals(paramCharSequence2);
/*      */     }
/*      */     
/* 1775 */     int i = paramCharSequence1.length();
/* 1776 */     for (byte b = 0; b < i; b++) {
/* 1777 */       if (paramCharSequence1.charAt(b) != paramCharSequence2.charAt(b)) {
/* 1778 */         return false;
/*      */       }
/*      */     } 
/* 1781 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean equalsAny(CharSequence paramCharSequence, CharSequence... paramVarArgs) {
/* 1804 */     if (ArrayUtils.isNotEmpty(paramVarArgs)) {
/* 1805 */       for (CharSequence charSequence : paramVarArgs) {
/* 1806 */         if (equals(paramCharSequence, charSequence)) {
/* 1807 */           return true;
/*      */         }
/*      */       } 
/*      */     }
/* 1811 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean equalsAnyIgnoreCase(CharSequence paramCharSequence, CharSequence... paramVarArgs) {
/* 1834 */     if (ArrayUtils.isNotEmpty(paramVarArgs)) {
/* 1835 */       for (CharSequence charSequence : paramVarArgs) {
/* 1836 */         if (equalsIgnoreCase(paramCharSequence, charSequence)) {
/* 1837 */           return true;
/*      */         }
/*      */       } 
/*      */     }
/* 1841 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean equalsIgnoreCase(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 1866 */     if (paramCharSequence1 == paramCharSequence2) {
/* 1867 */       return true;
/*      */     }
/* 1869 */     if (paramCharSequence1 == null || paramCharSequence2 == null) {
/* 1870 */       return false;
/*      */     }
/* 1872 */     if (paramCharSequence1.length() != paramCharSequence2.length()) {
/* 1873 */       return false;
/*      */     }
/* 1875 */     return CharSequenceUtils.regionMatches(paramCharSequence1, true, 0, paramCharSequence2, 0, paramCharSequence1.length());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SafeVarargs
/*      */   public static <T extends CharSequence> T firstNonBlank(T... paramVarArgs) {
/* 1905 */     if (paramVarArgs != null) {
/* 1906 */       for (T t : paramVarArgs) {
/* 1907 */         if (isNotBlank((CharSequence)t)) {
/* 1908 */           return t;
/*      */         }
/*      */       } 
/*      */     }
/* 1912 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SafeVarargs
/*      */   public static <T extends CharSequence> T firstNonEmpty(T... paramVarArgs) {
/* 1940 */     if (paramVarArgs != null) {
/* 1941 */       for (T t : paramVarArgs) {
/* 1942 */         if (isNotEmpty((CharSequence)t)) {
/* 1943 */           return t;
/*      */         }
/*      */       } 
/*      */     }
/* 1947 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] getBytes(String paramString, Charset paramCharset) {
/* 1960 */     return (paramString == null) ? ArrayUtils.EMPTY_BYTE_ARRAY : paramString.getBytes(Charsets.toCharset(paramCharset));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] getBytes(String paramString1, String paramString2) throws UnsupportedEncodingException {
/* 1974 */     return (paramString1 == null) ? ArrayUtils.EMPTY_BYTE_ARRAY : paramString1.getBytes(Charsets.toCharsetName(paramString2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getCommonPrefix(String... paramVarArgs) {
/* 2011 */     if (ArrayUtils.isEmpty((Object[])paramVarArgs)) {
/* 2012 */       return "";
/*      */     }
/* 2014 */     int i = indexOfDifference((CharSequence[])paramVarArgs);
/* 2015 */     if (i == -1) {
/*      */       
/* 2017 */       if (paramVarArgs[0] == null) {
/* 2018 */         return "";
/*      */       }
/* 2020 */       return paramVarArgs[0];
/* 2021 */     }  if (i == 0)
/*      */     {
/* 2023 */       return "";
/*      */     }
/*      */     
/* 2026 */     return paramVarArgs[0].substring(0, i);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getDigits(String paramString) {
/* 2053 */     if (isEmpty(paramString)) {
/* 2054 */       return paramString;
/*      */     }
/* 2056 */     int i = paramString.length();
/* 2057 */     StringBuilder stringBuilder = new StringBuilder(i);
/* 2058 */     for (byte b = 0; b < i; b++) {
/* 2059 */       char c = paramString.charAt(b);
/* 2060 */       if (Character.isDigit(c)) {
/* 2061 */         stringBuilder.append(c);
/*      */       }
/*      */     } 
/* 2064 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static int getFuzzyDistance(CharSequence paramCharSequence1, CharSequence paramCharSequence2, Locale paramLocale) {
/* 2098 */     if (paramCharSequence1 == null || paramCharSequence2 == null)
/* 2099 */       throw new IllegalArgumentException("Strings must not be null"); 
/* 2100 */     if (paramLocale == null) {
/* 2101 */       throw new IllegalArgumentException("Locale must not be null");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2108 */     String str1 = paramCharSequence1.toString().toLowerCase(paramLocale);
/* 2109 */     String str2 = paramCharSequence2.toString().toLowerCase(paramLocale);
/*      */ 
/*      */     
/* 2112 */     byte b1 = 0;
/*      */ 
/*      */ 
/*      */     
/* 2116 */     byte b2 = 0;
/*      */ 
/*      */     
/* 2119 */     int i = Integer.MIN_VALUE;
/*      */     
/* 2121 */     for (byte b3 = 0; b3 < str2.length(); b3++) {
/* 2122 */       char c = str2.charAt(b3);
/*      */       
/* 2124 */       boolean bool = false;
/* 2125 */       for (; b2 < str1.length() && !bool; b2++) {
/* 2126 */         char c1 = str1.charAt(b2);
/*      */         
/* 2128 */         if (c == c1) {
/*      */           
/* 2130 */           b1++;
/*      */ 
/*      */ 
/*      */           
/* 2134 */           if (i + 1 == b2) {
/* 2135 */             b1 += 2;
/*      */           }
/*      */           
/* 2138 */           i = b2;
/*      */ 
/*      */ 
/*      */           
/* 2142 */           bool = true;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 2147 */     return b1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends CharSequence> T getIfBlank(T paramT, Supplier<T> paramSupplier) {
/* 2176 */     return isBlank((CharSequence)paramT) ? ((paramSupplier == null) ? null : paramSupplier.get()) : paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends CharSequence> T getIfEmpty(T paramT, Supplier<T> paramSupplier) {
/* 2204 */     return isEmpty((CharSequence)paramT) ? ((paramSupplier == null) ? null : paramSupplier.get()) : paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static double getJaroWinklerDistance(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 2244 */     double d1 = 0.1D;
/*      */     
/* 2246 */     if (paramCharSequence1 == null || paramCharSequence2 == null) {
/* 2247 */       throw new IllegalArgumentException("Strings must not be null");
/*      */     }
/*      */     
/* 2250 */     int[] arrayOfInt = matches(paramCharSequence1, paramCharSequence2);
/* 2251 */     double d2 = arrayOfInt[0];
/* 2252 */     if (d2 == 0.0D) {
/* 2253 */       return 0.0D;
/*      */     }
/* 2255 */     double d3 = (d2 / paramCharSequence1.length() + d2 / paramCharSequence2.length() + (d2 - arrayOfInt[1]) / d2) / 3.0D;
/* 2256 */     double d4 = (d3 < 0.7D) ? d3 : (d3 + Math.min(0.1D, 1.0D / arrayOfInt[3]) * arrayOfInt[2] * (1.0D - d3));
/* 2257 */     return Math.round(d4 * 100.0D) / 100.0D;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static int getLevenshteinDistance(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 2299 */     if (paramCharSequence1 == null || paramCharSequence2 == null) {
/* 2300 */       throw new IllegalArgumentException("Strings must not be null");
/*      */     }
/*      */     
/* 2303 */     int i = paramCharSequence1.length();
/* 2304 */     int j = paramCharSequence2.length();
/*      */     
/* 2306 */     if (i == 0)
/* 2307 */       return j; 
/* 2308 */     if (j == 0) {
/* 2309 */       return i;
/*      */     }
/*      */     
/* 2312 */     if (i > j) {
/*      */       
/* 2314 */       CharSequence charSequence = paramCharSequence1;
/* 2315 */       paramCharSequence1 = paramCharSequence2;
/* 2316 */       paramCharSequence2 = charSequence;
/* 2317 */       i = j;
/* 2318 */       j = paramCharSequence2.length();
/*      */     } 
/*      */     
/* 2321 */     int[] arrayOfInt = new int[i + 1];
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     byte b1;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2331 */     for (b1 = 0; b1 <= i; b1++) {
/* 2332 */       arrayOfInt[b1] = b1;
/*      */     }
/*      */     
/* 2335 */     for (byte b2 = 1; b2 <= j; b2++) {
/* 2336 */       int k = arrayOfInt[0];
/* 2337 */       char c = paramCharSequence2.charAt(b2 - 1);
/* 2338 */       arrayOfInt[0] = b2;
/*      */       
/* 2340 */       for (b1 = 1; b1 <= i; b1++) {
/* 2341 */         int m = arrayOfInt[b1];
/* 2342 */         byte b = (paramCharSequence1.charAt(b1 - 1) == c) ? 0 : 1;
/*      */         
/* 2344 */         arrayOfInt[b1] = Math.min(Math.min(arrayOfInt[b1 - 1] + 1, arrayOfInt[b1] + 1), k + b);
/* 2345 */         k = m;
/*      */       } 
/*      */     } 
/*      */     
/* 2349 */     return arrayOfInt[i];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static int getLevenshteinDistance(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt) {
/* 2389 */     if (paramCharSequence1 == null || paramCharSequence2 == null) {
/* 2390 */       throw new IllegalArgumentException("Strings must not be null");
/*      */     }
/* 2392 */     if (paramInt < 0) {
/* 2393 */       throw new IllegalArgumentException("Threshold must not be negative");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2440 */     int i = paramCharSequence1.length();
/* 2441 */     int j = paramCharSequence2.length();
/*      */ 
/*      */     
/* 2444 */     if (i == 0)
/* 2445 */       return (j <= paramInt) ? j : -1; 
/* 2446 */     if (j == 0)
/* 2447 */       return (i <= paramInt) ? i : -1; 
/* 2448 */     if (Math.abs(i - j) > paramInt)
/*      */     {
/* 2450 */       return -1;
/*      */     }
/*      */     
/* 2453 */     if (i > j) {
/*      */       
/* 2455 */       CharSequence charSequence = paramCharSequence1;
/* 2456 */       paramCharSequence1 = paramCharSequence2;
/* 2457 */       paramCharSequence2 = charSequence;
/* 2458 */       i = j;
/* 2459 */       j = paramCharSequence2.length();
/*      */     } 
/*      */     
/* 2462 */     int[] arrayOfInt1 = new int[i + 1];
/* 2463 */     int[] arrayOfInt2 = new int[i + 1];
/*      */ 
/*      */ 
/*      */     
/* 2467 */     int k = Math.min(i, paramInt) + 1; byte b;
/* 2468 */     for (b = 0; b < k; b++) {
/* 2469 */       arrayOfInt1[b] = b;
/*      */     }
/*      */ 
/*      */     
/* 2473 */     Arrays.fill(arrayOfInt1, k, arrayOfInt1.length, 2147483647);
/* 2474 */     Arrays.fill(arrayOfInt2, 2147483647);
/*      */ 
/*      */     
/* 2477 */     for (b = 1; b <= j; b++) {
/* 2478 */       char c = paramCharSequence2.charAt(b - 1);
/* 2479 */       arrayOfInt2[0] = b;
/*      */ 
/*      */       
/* 2482 */       int m = Math.max(1, b - paramInt);
/* 2483 */       int n = (b > Integer.MAX_VALUE - paramInt) ? i : Math.min(i, b + paramInt);
/*      */ 
/*      */       
/* 2486 */       if (m > n) {
/* 2487 */         return -1;
/*      */       }
/*      */ 
/*      */       
/* 2491 */       if (m > 1) {
/* 2492 */         arrayOfInt2[m - 1] = Integer.MAX_VALUE;
/*      */       }
/*      */ 
/*      */       
/* 2496 */       for (int i1 = m; i1 <= n; i1++) {
/* 2497 */         if (paramCharSequence1.charAt(i1 - 1) == c) {
/*      */           
/* 2499 */           arrayOfInt2[i1] = arrayOfInt1[i1 - 1];
/*      */         } else {
/*      */           
/* 2502 */           arrayOfInt2[i1] = 1 + Math.min(Math.min(arrayOfInt2[i1 - 1], arrayOfInt1[i1]), arrayOfInt1[i1 - 1]);
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/* 2507 */       int[] arrayOfInt = arrayOfInt1;
/* 2508 */       arrayOfInt1 = arrayOfInt2;
/* 2509 */       arrayOfInt2 = arrayOfInt;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 2514 */     if (arrayOfInt1[i] <= paramInt) {
/* 2515 */       return arrayOfInt1[i];
/*      */     }
/* 2517 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int indexOf(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 2545 */     if (paramCharSequence1 == null || paramCharSequence2 == null) {
/* 2546 */       return -1;
/*      */     }
/* 2548 */     return CharSequenceUtils.indexOf(paramCharSequence1, paramCharSequence2, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int indexOf(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt) {
/* 2585 */     if (paramCharSequence1 == null || paramCharSequence2 == null) {
/* 2586 */       return -1;
/*      */     }
/* 2588 */     return CharSequenceUtils.indexOf(paramCharSequence1, paramCharSequence2, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int indexOf(CharSequence paramCharSequence, int paramInt) {
/* 2631 */     if (isEmpty(paramCharSequence)) {
/* 2632 */       return -1;
/*      */     }
/* 2634 */     return CharSequenceUtils.indexOf(paramCharSequence, paramInt, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int indexOf(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 2691 */     if (isEmpty(paramCharSequence)) {
/* 2692 */       return -1;
/*      */     }
/* 2694 */     return CharSequenceUtils.indexOf(paramCharSequence, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int indexOfAny(CharSequence paramCharSequence, char... paramVarArgs) {
/* 2723 */     if (isEmpty(paramCharSequence) || ArrayUtils.isEmpty(paramVarArgs)) {
/* 2724 */       return -1;
/*      */     }
/* 2726 */     int i = paramCharSequence.length();
/* 2727 */     int j = i - 1;
/* 2728 */     int k = paramVarArgs.length;
/* 2729 */     int m = k - 1;
/* 2730 */     for (byte b = 0; b < i; b++) {
/* 2731 */       char c = paramCharSequence.charAt(b);
/* 2732 */       for (byte b1 = 0; b1 < k; b1++) {
/* 2733 */         if (paramVarArgs[b1] == c) {
/* 2734 */           if (b < j && b1 < m && Character.isHighSurrogate(c)) {
/*      */             
/* 2736 */             if (paramVarArgs[b1 + 1] == paramCharSequence.charAt(b + 1)) {
/* 2737 */               return b;
/*      */             }
/*      */           } else {
/* 2740 */             return b;
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/* 2745 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int indexOfAny(CharSequence paramCharSequence, CharSequence... paramVarArgs) {
/* 2778 */     if (paramCharSequence == null || paramVarArgs == null) {
/* 2779 */       return -1;
/*      */     }
/*      */ 
/*      */     
/* 2783 */     int i = Integer.MAX_VALUE;
/*      */     
/* 2785 */     int j = 0;
/* 2786 */     for (CharSequence charSequence : paramVarArgs) {
/* 2787 */       if (charSequence != null) {
/*      */ 
/*      */         
/* 2790 */         j = CharSequenceUtils.indexOf(paramCharSequence, charSequence, 0);
/* 2791 */         if (j != -1)
/*      */         {
/*      */ 
/*      */           
/* 2795 */           if (j < i)
/* 2796 */             i = j; 
/*      */         }
/*      */       } 
/*      */     } 
/* 2800 */     return (i == Integer.MAX_VALUE) ? -1 : i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int indexOfAny(CharSequence paramCharSequence, String paramString) {
/* 2827 */     if (isEmpty(paramCharSequence) || isEmpty(paramString)) {
/* 2828 */       return -1;
/*      */     }
/* 2830 */     return indexOfAny(paramCharSequence, paramString.toCharArray());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int indexOfAnyBut(CharSequence paramCharSequence, char... paramVarArgs) {
/* 2860 */     if (isEmpty(paramCharSequence) || ArrayUtils.isEmpty(paramVarArgs)) {
/* 2861 */       return -1;
/*      */     }
/* 2863 */     int i = paramCharSequence.length();
/* 2864 */     int j = i - 1;
/* 2865 */     int k = paramVarArgs.length;
/* 2866 */     int m = k - 1;
/*      */     
/* 2868 */     for (byte b = 0; b < i; b++) {
/* 2869 */       char c = paramCharSequence.charAt(b);
/* 2870 */       byte b1 = 0; while (true) { if (b1 < k) {
/* 2871 */           if (paramVarArgs[b1] == c && (
/* 2872 */             b >= j || b1 >= m || !Character.isHighSurrogate(c) || 
/* 2873 */             paramVarArgs[b1 + 1] == paramCharSequence.charAt(b + 1))) {
/*      */             break;
/*      */           }
/*      */           
/*      */           b1++;
/*      */           
/*      */           continue;
/*      */         } 
/* 2881 */         return b; }
/*      */     
/* 2883 */     }  return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int indexOfAnyBut(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 2910 */     if (isEmpty(paramCharSequence1) || isEmpty(paramCharSequence2)) {
/* 2911 */       return -1;
/*      */     }
/* 2913 */     int i = paramCharSequence1.length();
/* 2914 */     for (byte b = 0; b < i; b++) {
/* 2915 */       char c = paramCharSequence1.charAt(b);
/* 2916 */       boolean bool = (CharSequenceUtils.indexOf(paramCharSequence2, c, 0) >= 0) ? true : false;
/* 2917 */       if (b + 1 < i && Character.isHighSurrogate(c)) {
/* 2918 */         char c1 = paramCharSequence1.charAt(b + 1);
/* 2919 */         if (bool && CharSequenceUtils.indexOf(paramCharSequence2, c1, 0) < 0) {
/* 2920 */           return b;
/*      */         }
/*      */       }
/* 2923 */       else if (!bool) {
/* 2924 */         return b;
/*      */       } 
/*      */     } 
/*      */     
/* 2928 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int indexOfDifference(CharSequence... paramVarArgs) {
/* 2964 */     if (ArrayUtils.getLength(paramVarArgs) <= 1) {
/* 2965 */       return -1;
/*      */     }
/* 2967 */     boolean bool1 = false;
/* 2968 */     boolean bool2 = true;
/* 2969 */     int i = paramVarArgs.length;
/* 2970 */     int j = Integer.MAX_VALUE;
/* 2971 */     int k = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2976 */     for (CharSequence charSequence : paramVarArgs) {
/* 2977 */       if (charSequence == null) {
/* 2978 */         bool1 = true;
/* 2979 */         j = 0;
/*      */       } else {
/* 2981 */         bool2 = false;
/* 2982 */         j = Math.min(charSequence.length(), j);
/* 2983 */         k = Math.max(charSequence.length(), k);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 2988 */     if (bool2 || (k == 0 && !bool1)) {
/* 2989 */       return -1;
/*      */     }
/*      */ 
/*      */     
/* 2993 */     if (j == 0) {
/* 2994 */       return 0;
/*      */     }
/*      */ 
/*      */     
/* 2998 */     byte b = -1;
/* 2999 */     for (byte b1 = 0; b1 < j; b1++) {
/* 3000 */       char c = paramVarArgs[0].charAt(b1);
/* 3001 */       for (byte b2 = 1; b2 < i; b2++) {
/* 3002 */         if (paramVarArgs[b2].charAt(b1) != c) {
/* 3003 */           b = b1;
/*      */           break;
/*      */         } 
/*      */       } 
/* 3007 */       if (b != -1) {
/*      */         break;
/*      */       }
/*      */     } 
/*      */     
/* 3012 */     if (b == -1 && j != k)
/*      */     {
/*      */ 
/*      */       
/* 3016 */       return j;
/*      */     }
/* 3018 */     return b;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int indexOfDifference(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 3047 */     if (paramCharSequence1 == paramCharSequence2) {
/* 3048 */       return -1;
/*      */     }
/* 3050 */     if (paramCharSequence1 == null || paramCharSequence2 == null) {
/* 3051 */       return 0;
/*      */     }
/*      */     byte b;
/* 3054 */     for (b = 0; b < paramCharSequence1.length() && b < paramCharSequence2.length() && 
/* 3055 */       paramCharSequence1.charAt(b) == paramCharSequence2.charAt(b); b++);
/*      */ 
/*      */ 
/*      */     
/* 3059 */     if (b < paramCharSequence2.length() || b < paramCharSequence1.length()) {
/* 3060 */       return b;
/*      */     }
/* 3062 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int indexOfIgnoreCase(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 3091 */     return indexOfIgnoreCase(paramCharSequence1, paramCharSequence2, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int indexOfIgnoreCase(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt) {
/* 3127 */     if (paramCharSequence1 == null || paramCharSequence2 == null) {
/* 3128 */       return -1;
/*      */     }
/* 3130 */     if (paramInt < 0) {
/* 3131 */       paramInt = 0;
/*      */     }
/* 3133 */     int i = paramCharSequence1.length() - paramCharSequence2.length() + 1;
/* 3134 */     if (paramInt > i) {
/* 3135 */       return -1;
/*      */     }
/* 3137 */     if (paramCharSequence2.length() == 0) {
/* 3138 */       return paramInt;
/*      */     }
/* 3140 */     for (int j = paramInt; j < i; j++) {
/* 3141 */       if (CharSequenceUtils.regionMatches(paramCharSequence1, true, j, paramCharSequence2, 0, paramCharSequence2.length())) {
/* 3142 */         return j;
/*      */       }
/*      */     } 
/* 3145 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isAllBlank(CharSequence... paramVarArgs) {
/* 3170 */     if (ArrayUtils.isEmpty((Object[])paramVarArgs)) {
/* 3171 */       return true;
/*      */     }
/* 3173 */     for (CharSequence charSequence : paramVarArgs) {
/* 3174 */       if (isNotBlank(charSequence)) {
/* 3175 */         return false;
/*      */       }
/*      */     } 
/* 3178 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isAllEmpty(CharSequence... paramVarArgs) {
/* 3201 */     if (ArrayUtils.isEmpty((Object[])paramVarArgs)) {
/* 3202 */       return true;
/*      */     }
/* 3204 */     for (CharSequence charSequence : paramVarArgs) {
/* 3205 */       if (isNotEmpty(charSequence)) {
/* 3206 */         return false;
/*      */       }
/*      */     } 
/* 3209 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isAllLowerCase(CharSequence paramCharSequence) {
/* 3235 */     if (isEmpty(paramCharSequence)) {
/* 3236 */       return false;
/*      */     }
/* 3238 */     int i = paramCharSequence.length();
/* 3239 */     for (byte b = 0; b < i; b++) {
/* 3240 */       if (!Character.isLowerCase(paramCharSequence.charAt(b))) {
/* 3241 */         return false;
/*      */       }
/*      */     } 
/* 3244 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isAllUpperCase(CharSequence paramCharSequence) {
/* 3270 */     if (isEmpty(paramCharSequence)) {
/* 3271 */       return false;
/*      */     }
/* 3273 */     int i = paramCharSequence.length();
/* 3274 */     for (byte b = 0; b < i; b++) {
/* 3275 */       if (!Character.isUpperCase(paramCharSequence.charAt(b))) {
/* 3276 */         return false;
/*      */       }
/*      */     } 
/* 3279 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isAlpha(CharSequence paramCharSequence) {
/* 3305 */     if (isEmpty(paramCharSequence)) {
/* 3306 */       return false;
/*      */     }
/* 3308 */     int i = paramCharSequence.length();
/* 3309 */     for (byte b = 0; b < i; b++) {
/* 3310 */       if (!Character.isLetter(paramCharSequence.charAt(b))) {
/* 3311 */         return false;
/*      */       }
/*      */     } 
/* 3314 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isAlphanumeric(CharSequence paramCharSequence) {
/* 3340 */     if (isEmpty(paramCharSequence)) {
/* 3341 */       return false;
/*      */     }
/* 3343 */     int i = paramCharSequence.length();
/* 3344 */     for (byte b = 0; b < i; b++) {
/* 3345 */       if (!Character.isLetterOrDigit(paramCharSequence.charAt(b))) {
/* 3346 */         return false;
/*      */       }
/*      */     } 
/* 3349 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isAlphanumericSpace(CharSequence paramCharSequence) {
/* 3375 */     if (paramCharSequence == null) {
/* 3376 */       return false;
/*      */     }
/* 3378 */     int i = paramCharSequence.length();
/* 3379 */     for (byte b = 0; b < i; b++) {
/* 3380 */       if (!Character.isLetterOrDigit(paramCharSequence.charAt(b)) && paramCharSequence.charAt(b) != ' ') {
/* 3381 */         return false;
/*      */       }
/*      */     } 
/* 3384 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isAlphaSpace(CharSequence paramCharSequence) {
/* 3410 */     if (paramCharSequence == null) {
/* 3411 */       return false;
/*      */     }
/* 3413 */     int i = paramCharSequence.length();
/* 3414 */     for (byte b = 0; b < i; b++) {
/* 3415 */       if (!Character.isLetter(paramCharSequence.charAt(b)) && paramCharSequence.charAt(b) != ' ') {
/* 3416 */         return false;
/*      */       }
/*      */     } 
/* 3419 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isAnyBlank(CharSequence... paramVarArgs) {
/* 3446 */     if (ArrayUtils.isEmpty((Object[])paramVarArgs)) {
/* 3447 */       return false;
/*      */     }
/* 3449 */     for (CharSequence charSequence : paramVarArgs) {
/* 3450 */       if (isBlank(charSequence)) {
/* 3451 */         return true;
/*      */       }
/*      */     } 
/* 3454 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isAnyEmpty(CharSequence... paramVarArgs) {
/* 3478 */     if (ArrayUtils.isEmpty((Object[])paramVarArgs)) {
/* 3479 */       return false;
/*      */     }
/* 3481 */     for (CharSequence charSequence : paramVarArgs) {
/* 3482 */       if (isEmpty(charSequence)) {
/* 3483 */         return true;
/*      */       }
/*      */     } 
/* 3486 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isAsciiPrintable(CharSequence paramCharSequence) {
/* 3516 */     if (paramCharSequence == null) {
/* 3517 */       return false;
/*      */     }
/* 3519 */     int i = paramCharSequence.length();
/* 3520 */     for (byte b = 0; b < i; b++) {
/* 3521 */       if (!CharUtils.isAsciiPrintable(paramCharSequence.charAt(b))) {
/* 3522 */         return false;
/*      */       }
/*      */     } 
/* 3525 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isBlank(CharSequence paramCharSequence) {
/* 3550 */     int i = length(paramCharSequence);
/* 3551 */     if (i == 0) {
/* 3552 */       return true;
/*      */     }
/* 3554 */     for (byte b = 0; b < i; b++) {
/* 3555 */       if (!Character.isWhitespace(paramCharSequence.charAt(b))) {
/* 3556 */         return false;
/*      */       }
/*      */     } 
/* 3559 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isEmpty(CharSequence paramCharSequence) {
/* 3584 */     return (paramCharSequence == null || paramCharSequence.length() == 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isMixedCase(CharSequence paramCharSequence) {
/* 3610 */     if (isEmpty(paramCharSequence) || paramCharSequence.length() == 1) {
/* 3611 */       return false;
/*      */     }
/* 3613 */     boolean bool1 = false;
/* 3614 */     boolean bool2 = false;
/* 3615 */     int i = paramCharSequence.length();
/* 3616 */     for (byte b = 0; b < i; b++) {
/* 3617 */       if (bool1 && bool2)
/* 3618 */         return true; 
/* 3619 */       if (Character.isUpperCase(paramCharSequence.charAt(b))) {
/* 3620 */         bool1 = true;
/* 3621 */       } else if (Character.isLowerCase(paramCharSequence.charAt(b))) {
/* 3622 */         bool2 = true;
/*      */       } 
/*      */     } 
/* 3625 */     return (bool1 && bool2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isNoneBlank(CharSequence... paramVarArgs) {
/* 3652 */     return !isAnyBlank(paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isNoneEmpty(CharSequence... paramVarArgs) {
/* 3676 */     return !isAnyEmpty(paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isNotBlank(CharSequence paramCharSequence) {
/* 3699 */     return !isBlank(paramCharSequence);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isNotEmpty(CharSequence paramCharSequence) {
/* 3718 */     return !isEmpty(paramCharSequence);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isNumeric(CharSequence paramCharSequence) {
/* 3753 */     if (isEmpty(paramCharSequence)) {
/* 3754 */       return false;
/*      */     }
/* 3756 */     int i = paramCharSequence.length();
/* 3757 */     for (byte b = 0; b < i; b++) {
/* 3758 */       if (!Character.isDigit(paramCharSequence.charAt(b))) {
/* 3759 */         return false;
/*      */       }
/*      */     } 
/* 3762 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isNumericSpace(CharSequence paramCharSequence) {
/* 3792 */     if (paramCharSequence == null) {
/* 3793 */       return false;
/*      */     }
/* 3795 */     int i = paramCharSequence.length();
/* 3796 */     for (byte b = 0; b < i; b++) {
/* 3797 */       if (!Character.isDigit(paramCharSequence.charAt(b)) && paramCharSequence.charAt(b) != ' ') {
/* 3798 */         return false;
/*      */       }
/*      */     } 
/* 3801 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isWhitespace(CharSequence paramCharSequence) {
/* 3827 */     if (paramCharSequence == null) {
/* 3828 */       return false;
/*      */     }
/* 3830 */     int i = paramCharSequence.length();
/* 3831 */     for (byte b = 0; b < i; b++) {
/* 3832 */       if (!Character.isWhitespace(paramCharSequence.charAt(b))) {
/* 3833 */         return false;
/*      */       }
/*      */     } 
/* 3836 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String join(byte[] paramArrayOfbyte, char paramChar) {
/* 3865 */     if (paramArrayOfbyte == null) {
/* 3866 */       return null;
/*      */     }
/* 3868 */     return join(paramArrayOfbyte, paramChar, 0, paramArrayOfbyte.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String join(byte[] paramArrayOfbyte, char paramChar, int paramInt1, int paramInt2) {
/* 3903 */     if (paramArrayOfbyte == null) {
/* 3904 */       return null;
/*      */     }
/* 3906 */     int i = paramInt2 - paramInt1;
/* 3907 */     if (i <= 0) {
/* 3908 */       return "";
/*      */     }
/* 3910 */     StringBuilder stringBuilder = newStringBuilder(i);
/* 3911 */     stringBuilder.append(paramArrayOfbyte[paramInt1]);
/* 3912 */     for (int j = paramInt1 + 1; j < paramInt2; j++) {
/* 3913 */       stringBuilder.append(paramChar);
/* 3914 */       stringBuilder.append(paramArrayOfbyte[j]);
/*      */     } 
/* 3916 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String join(char[] paramArrayOfchar, char paramChar) {
/* 3945 */     if (paramArrayOfchar == null) {
/* 3946 */       return null;
/*      */     }
/* 3948 */     return join(paramArrayOfchar, paramChar, 0, paramArrayOfchar.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String join(char[] paramArrayOfchar, char paramChar, int paramInt1, int paramInt2) {
/* 3983 */     if (paramArrayOfchar == null) {
/* 3984 */       return null;
/*      */     }
/* 3986 */     int i = paramInt2 - paramInt1;
/* 3987 */     if (i <= 0) {
/* 3988 */       return "";
/*      */     }
/* 3990 */     StringBuilder stringBuilder = newStringBuilder(i);
/* 3991 */     stringBuilder.append(paramArrayOfchar[paramInt1]);
/* 3992 */     for (int j = paramInt1 + 1; j < paramInt2; j++) {
/* 3993 */       stringBuilder.append(paramChar);
/* 3994 */       stringBuilder.append(paramArrayOfchar[j]);
/*      */     } 
/* 3996 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String join(double[] paramArrayOfdouble, char paramChar) {
/* 4025 */     if (paramArrayOfdouble == null) {
/* 4026 */       return null;
/*      */     }
/* 4028 */     return join(paramArrayOfdouble, paramChar, 0, paramArrayOfdouble.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String join(double[] paramArrayOfdouble, char paramChar, int paramInt1, int paramInt2) {
/* 4063 */     if (paramArrayOfdouble == null) {
/* 4064 */       return null;
/*      */     }
/* 4066 */     int i = paramInt2 - paramInt1;
/* 4067 */     if (i <= 0) {
/* 4068 */       return "";
/*      */     }
/* 4070 */     StringBuilder stringBuilder = newStringBuilder(i);
/* 4071 */     stringBuilder.append(paramArrayOfdouble[paramInt1]);
/* 4072 */     for (int j = paramInt1 + 1; j < paramInt2; j++) {
/* 4073 */       stringBuilder.append(paramChar);
/* 4074 */       stringBuilder.append(paramArrayOfdouble[j]);
/*      */     } 
/* 4076 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String join(float[] paramArrayOffloat, char paramChar) {
/* 4105 */     if (paramArrayOffloat == null) {
/* 4106 */       return null;
/*      */     }
/* 4108 */     return join(paramArrayOffloat, paramChar, 0, paramArrayOffloat.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String join(float[] paramArrayOffloat, char paramChar, int paramInt1, int paramInt2) {
/* 4143 */     if (paramArrayOffloat == null) {
/* 4144 */       return null;
/*      */     }
/* 4146 */     int i = paramInt2 - paramInt1;
/* 4147 */     if (i <= 0) {
/* 4148 */       return "";
/*      */     }
/* 4150 */     StringBuilder stringBuilder = newStringBuilder(i);
/* 4151 */     stringBuilder.append(paramArrayOffloat[paramInt1]);
/* 4152 */     for (int j = paramInt1 + 1; j < paramInt2; j++) {
/* 4153 */       stringBuilder.append(paramChar);
/* 4154 */       stringBuilder.append(paramArrayOffloat[j]);
/*      */     } 
/* 4156 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String join(int[] paramArrayOfint, char paramChar) {
/* 4185 */     if (paramArrayOfint == null) {
/* 4186 */       return null;
/*      */     }
/* 4188 */     return join(paramArrayOfint, paramChar, 0, paramArrayOfint.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String join(int[] paramArrayOfint, char paramChar, int paramInt1, int paramInt2) {
/* 4223 */     if (paramArrayOfint == null) {
/* 4224 */       return null;
/*      */     }
/* 4226 */     int i = paramInt2 - paramInt1;
/* 4227 */     if (i <= 0) {
/* 4228 */       return "";
/*      */     }
/* 4230 */     StringBuilder stringBuilder = newStringBuilder(i);
/* 4231 */     stringBuilder.append(paramArrayOfint[paramInt1]);
/* 4232 */     for (int j = paramInt1 + 1; j < paramInt2; j++) {
/* 4233 */       stringBuilder.append(paramChar);
/* 4234 */       stringBuilder.append(paramArrayOfint[j]);
/*      */     } 
/* 4236 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String join(Iterable<?> paramIterable, char paramChar) {
/* 4254 */     if (paramIterable == null) {
/* 4255 */       return null;
/*      */     }
/* 4257 */     return join(paramIterable.iterator(), paramChar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String join(Iterable<?> paramIterable, String paramString) {
/* 4275 */     if (paramIterable == null) {
/* 4276 */       return null;
/*      */     }
/* 4278 */     return join(paramIterable.iterator(), paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String join(Iterator<?> paramIterator, char paramChar) {
/* 4298 */     if (paramIterator == null) {
/* 4299 */       return null;
/*      */     }
/* 4301 */     if (!paramIterator.hasNext()) {
/* 4302 */       return "";
/*      */     }
/* 4304 */     Object object = paramIterator.next();
/* 4305 */     if (!paramIterator.hasNext()) {
/* 4306 */       return Objects.toString(object, "");
/*      */     }
/*      */ 
/*      */     
/* 4310 */     StringBuilder stringBuilder = new StringBuilder(256);
/* 4311 */     if (object != null) {
/* 4312 */       stringBuilder.append(object);
/*      */     }
/*      */     
/* 4315 */     while (paramIterator.hasNext()) {
/* 4316 */       stringBuilder.append(paramChar);
/* 4317 */       Object object1 = paramIterator.next();
/* 4318 */       if (object1 != null) {
/* 4319 */         stringBuilder.append(object1);
/*      */       }
/*      */     } 
/*      */     
/* 4323 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String join(Iterator<?> paramIterator, String paramString) {
/* 4342 */     if (paramIterator == null) {
/* 4343 */       return null;
/*      */     }
/* 4345 */     if (!paramIterator.hasNext()) {
/* 4346 */       return "";
/*      */     }
/* 4348 */     Object object = paramIterator.next();
/* 4349 */     if (!paramIterator.hasNext()) {
/* 4350 */       return Objects.toString(object, "");
/*      */     }
/*      */ 
/*      */     
/* 4354 */     StringBuilder stringBuilder = new StringBuilder(256);
/* 4355 */     if (object != null) {
/* 4356 */       stringBuilder.append(object);
/*      */     }
/*      */     
/* 4359 */     while (paramIterator.hasNext()) {
/* 4360 */       if (paramString != null) {
/* 4361 */         stringBuilder.append(paramString);
/*      */       }
/* 4363 */       Object object1 = paramIterator.next();
/* 4364 */       if (object1 != null) {
/* 4365 */         stringBuilder.append(object1);
/*      */       }
/*      */     } 
/* 4368 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String join(List<?> paramList, char paramChar, int paramInt1, int paramInt2) {
/* 4398 */     if (paramList == null) {
/* 4399 */       return null;
/*      */     }
/* 4401 */     int i = paramInt2 - paramInt1;
/* 4402 */     if (i <= 0) {
/* 4403 */       return "";
/*      */     }
/* 4405 */     List<?> list = paramList.subList(paramInt1, paramInt2);
/* 4406 */     return join(list.iterator(), paramChar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String join(List<?> paramList, String paramString, int paramInt1, int paramInt2) {
/* 4436 */     if (paramList == null) {
/* 4437 */       return null;
/*      */     }
/* 4439 */     int i = paramInt2 - paramInt1;
/* 4440 */     if (i <= 0) {
/* 4441 */       return "";
/*      */     }
/* 4443 */     List<?> list = paramList.subList(paramInt1, paramInt2);
/* 4444 */     return join(list.iterator(), paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String join(long[] paramArrayOflong, char paramChar) {
/* 4474 */     if (paramArrayOflong == null) {
/* 4475 */       return null;
/*      */     }
/* 4477 */     return join(paramArrayOflong, paramChar, 0, paramArrayOflong.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String join(long[] paramArrayOflong, char paramChar, int paramInt1, int paramInt2) {
/* 4512 */     if (paramArrayOflong == null) {
/* 4513 */       return null;
/*      */     }
/* 4515 */     int i = paramInt2 - paramInt1;
/* 4516 */     if (i <= 0) {
/* 4517 */       return "";
/*      */     }
/* 4519 */     StringBuilder stringBuilder = newStringBuilder(i);
/* 4520 */     stringBuilder.append(paramArrayOflong[paramInt1]);
/* 4521 */     for (int j = paramInt1 + 1; j < paramInt2; j++) {
/* 4522 */       stringBuilder.append(paramChar);
/* 4523 */       stringBuilder.append(paramArrayOflong[j]);
/*      */     } 
/* 4525 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String join(Object[] paramArrayOfObject, char paramChar) {
/* 4551 */     if (paramArrayOfObject == null) {
/* 4552 */       return null;
/*      */     }
/* 4554 */     return join(paramArrayOfObject, paramChar, 0, paramArrayOfObject.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String join(Object[] paramArrayOfObject, char paramChar, int paramInt1, int paramInt2) {
/* 4584 */     if (paramArrayOfObject == null) {
/* 4585 */       return null;
/*      */     }
/* 4587 */     int i = paramInt2 - paramInt1;
/* 4588 */     if (i <= 0) {
/* 4589 */       return "";
/*      */     }
/* 4591 */     StringBuilder stringBuilder = newStringBuilder(i);
/* 4592 */     if (paramArrayOfObject[paramInt1] != null) {
/* 4593 */       stringBuilder.append(paramArrayOfObject[paramInt1]);
/*      */     }
/* 4595 */     for (int j = paramInt1 + 1; j < paramInt2; j++) {
/* 4596 */       stringBuilder.append(paramChar);
/* 4597 */       if (paramArrayOfObject[j] != null) {
/* 4598 */         stringBuilder.append(paramArrayOfObject[j]);
/*      */       }
/*      */     } 
/* 4601 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String join(Object[] paramArrayOfObject, String paramString) {
/* 4628 */     if (paramArrayOfObject == null) {
/* 4629 */       return null;
/*      */     }
/* 4631 */     return join(paramArrayOfObject, paramString, 0, paramArrayOfObject.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String join(Object[] paramArrayOfObject, String paramString, int paramInt1, int paramInt2) {
/* 4670 */     if (paramArrayOfObject == null) {
/* 4671 */       return null;
/*      */     }
/* 4673 */     if (paramString == null) {
/* 4674 */       paramString = "";
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 4679 */     int i = paramInt2 - paramInt1;
/* 4680 */     if (i <= 0) {
/* 4681 */       return "";
/*      */     }
/*      */     
/* 4684 */     StringBuilder stringBuilder = newStringBuilder(i);
/*      */     
/* 4686 */     if (paramArrayOfObject[paramInt1] != null) {
/* 4687 */       stringBuilder.append(paramArrayOfObject[paramInt1]);
/*      */     }
/*      */     
/* 4690 */     for (int j = paramInt1 + 1; j < paramInt2; j++) {
/* 4691 */       stringBuilder.append(paramString);
/*      */       
/* 4693 */       if (paramArrayOfObject[j] != null) {
/* 4694 */         stringBuilder.append(paramArrayOfObject[j]);
/*      */       }
/*      */     } 
/* 4697 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String join(short[] paramArrayOfshort, char paramChar) {
/* 4726 */     if (paramArrayOfshort == null) {
/* 4727 */       return null;
/*      */     }
/* 4729 */     return join(paramArrayOfshort, paramChar, 0, paramArrayOfshort.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String join(short[] paramArrayOfshort, char paramChar, int paramInt1, int paramInt2) {
/* 4764 */     if (paramArrayOfshort == null) {
/* 4765 */       return null;
/*      */     }
/* 4767 */     int i = paramInt2 - paramInt1;
/* 4768 */     if (i <= 0) {
/* 4769 */       return "";
/*      */     }
/* 4771 */     StringBuilder stringBuilder = newStringBuilder(i);
/* 4772 */     stringBuilder.append(paramArrayOfshort[paramInt1]);
/* 4773 */     for (int j = paramInt1 + 1; j < paramInt2; j++) {
/* 4774 */       stringBuilder.append(paramChar);
/* 4775 */       stringBuilder.append(paramArrayOfshort[j]);
/*      */     } 
/* 4777 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SafeVarargs
/*      */   public static <T> String join(T... paramVarArgs) {
/* 4807 */     return join((Object[])paramVarArgs, (String)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String joinWith(String paramString, Object... paramVarArgs) {
/* 4831 */     if (paramVarArgs == null) {
/* 4832 */       throw new IllegalArgumentException("Object varargs must not be null");
/*      */     }
/*      */     
/* 4835 */     String str = defaultString(paramString);
/*      */     
/* 4837 */     StringBuilder stringBuilder = new StringBuilder();
/*      */     
/* 4839 */     Iterator iterator = Arrays.<Object>asList(paramVarArgs).iterator();
/* 4840 */     while (iterator.hasNext()) {
/* 4841 */       String str1 = Objects.toString(iterator.next(), "");
/* 4842 */       stringBuilder.append(str1);
/*      */       
/* 4844 */       if (iterator.hasNext()) {
/* 4845 */         stringBuilder.append(str);
/*      */       }
/*      */     } 
/*      */     
/* 4849 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int lastIndexOf(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 4876 */     if (paramCharSequence1 == null || paramCharSequence2 == null) {
/* 4877 */       return -1;
/*      */     }
/* 4879 */     return CharSequenceUtils.lastIndexOf(paramCharSequence1, paramCharSequence2, paramCharSequence1.length());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int lastIndexOf(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt) {
/* 4918 */     if (paramCharSequence1 == null || paramCharSequence2 == null) {
/* 4919 */       return -1;
/*      */     }
/* 4921 */     return CharSequenceUtils.lastIndexOf(paramCharSequence1, paramCharSequence2, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int lastIndexOf(CharSequence paramCharSequence, int paramInt) {
/* 4961 */     if (isEmpty(paramCharSequence)) {
/* 4962 */       return -1;
/*      */     }
/* 4964 */     return CharSequenceUtils.lastIndexOf(paramCharSequence, paramInt, paramCharSequence.length());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int lastIndexOf(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 5012 */     if (isEmpty(paramCharSequence)) {
/* 5013 */       return -1;
/*      */     }
/* 5015 */     return CharSequenceUtils.lastIndexOf(paramCharSequence, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int lastIndexOfAny(CharSequence paramCharSequence, CharSequence... paramVarArgs) {
/* 5045 */     if (paramCharSequence == null || paramVarArgs == null) {
/* 5046 */       return -1;
/*      */     }
/* 5048 */     int i = -1;
/* 5049 */     int j = 0;
/* 5050 */     for (CharSequence charSequence : paramVarArgs) {
/* 5051 */       if (charSequence != null) {
/*      */ 
/*      */         
/* 5054 */         j = CharSequenceUtils.lastIndexOf(paramCharSequence, charSequence, paramCharSequence.length());
/* 5055 */         if (j > i)
/* 5056 */           i = j; 
/*      */       } 
/*      */     } 
/* 5059 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int lastIndexOfIgnoreCase(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 5086 */     if (paramCharSequence1 == null || paramCharSequence2 == null) {
/* 5087 */       return -1;
/*      */     }
/* 5089 */     return lastIndexOfIgnoreCase(paramCharSequence1, paramCharSequence2, paramCharSequence1.length());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int lastIndexOfIgnoreCase(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt) {
/* 5125 */     if (paramCharSequence1 == null || paramCharSequence2 == null) {
/* 5126 */       return -1;
/*      */     }
/* 5128 */     if (paramInt > paramCharSequence1.length() - paramCharSequence2.length()) {
/* 5129 */       paramInt = paramCharSequence1.length() - paramCharSequence2.length();
/*      */     }
/* 5131 */     if (paramInt < 0) {
/* 5132 */       return -1;
/*      */     }
/* 5134 */     if (paramCharSequence2.length() == 0) {
/* 5135 */       return paramInt;
/*      */     }
/*      */     
/* 5138 */     for (int i = paramInt; i >= 0; i--) {
/* 5139 */       if (CharSequenceUtils.regionMatches(paramCharSequence1, true, i, paramCharSequence2, 0, paramCharSequence2.length())) {
/* 5140 */         return i;
/*      */       }
/*      */     } 
/* 5143 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int lastOrdinalIndexOf(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt) {
/* 5181 */     return ordinalIndexOf(paramCharSequence1, paramCharSequence2, paramInt, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String left(String paramString, int paramInt) {
/* 5207 */     if (paramString == null) {
/* 5208 */       return null;
/*      */     }
/* 5210 */     if (paramInt < 0) {
/* 5211 */       return "";
/*      */     }
/* 5213 */     if (paramString.length() <= paramInt) {
/* 5214 */       return paramString;
/*      */     }
/* 5216 */     return paramString.substring(0, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String leftPad(String paramString, int paramInt) {
/* 5239 */     return leftPad(paramString, paramInt, ' ');
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String leftPad(String paramString, int paramInt, char paramChar) {
/* 5264 */     if (paramString == null) {
/* 5265 */       return null;
/*      */     }
/* 5267 */     int i = paramInt - paramString.length();
/* 5268 */     if (i <= 0) {
/* 5269 */       return paramString;
/*      */     }
/* 5271 */     if (i > 8192) {
/* 5272 */       return leftPad(paramString, paramInt, String.valueOf(paramChar));
/*      */     }
/* 5274 */     return repeat(paramChar, i).concat(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String leftPad(String paramString1, int paramInt, String paramString2) {
/* 5301 */     if (paramString1 == null) {
/* 5302 */       return null;
/*      */     }
/* 5304 */     if (isEmpty(paramString2)) {
/* 5305 */       paramString2 = " ";
/*      */     }
/* 5307 */     int i = paramString2.length();
/* 5308 */     int j = paramString1.length();
/* 5309 */     int k = paramInt - j;
/* 5310 */     if (k <= 0) {
/* 5311 */       return paramString1;
/*      */     }
/* 5313 */     if (i == 1 && k <= 8192) {
/* 5314 */       return leftPad(paramString1, paramInt, paramString2.charAt(0));
/*      */     }
/*      */     
/* 5317 */     if (k == i)
/* 5318 */       return paramString2.concat(paramString1); 
/* 5319 */     if (k < i) {
/* 5320 */       return paramString2.substring(0, k).concat(paramString1);
/*      */     }
/* 5322 */     char[] arrayOfChar1 = new char[k];
/* 5323 */     char[] arrayOfChar2 = paramString2.toCharArray();
/* 5324 */     for (byte b = 0; b < k; b++) {
/* 5325 */       arrayOfChar1[b] = arrayOfChar2[b % i];
/*      */     }
/* 5327 */     return (new String(arrayOfChar1)).concat(paramString1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int length(CharSequence paramCharSequence) {
/* 5343 */     return (paramCharSequence == null) ? 0 : paramCharSequence.length();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String lowerCase(String paramString) {
/* 5366 */     if (paramString == null) {
/* 5367 */       return null;
/*      */     }
/* 5369 */     return paramString.toLowerCase();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String lowerCase(String paramString, Locale paramLocale) {
/* 5389 */     if (paramString == null) {
/* 5390 */       return null;
/*      */     }
/* 5392 */     return paramString.toLowerCase(paramLocale);
/*      */   }
/*      */   
/*      */   private static int[] matches(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/*      */     CharSequence charSequence1, charSequence2;
/* 5397 */     if (paramCharSequence1.length() > paramCharSequence2.length()) {
/* 5398 */       charSequence1 = paramCharSequence1;
/* 5399 */       charSequence2 = paramCharSequence2;
/*      */     } else {
/* 5401 */       charSequence1 = paramCharSequence2;
/* 5402 */       charSequence2 = paramCharSequence1;
/*      */     } 
/* 5404 */     int i = Math.max(charSequence1.length() / 2 - 1, 0);
/* 5405 */     int[] arrayOfInt = new int[charSequence2.length()];
/* 5406 */     Arrays.fill(arrayOfInt, -1);
/* 5407 */     boolean[] arrayOfBoolean = new boolean[charSequence1.length()];
/* 5408 */     byte b1 = 0;
/* 5409 */     for (byte b2 = 0; b2 < charSequence2.length(); b2++) {
/* 5410 */       char c = charSequence2.charAt(b2);
/* 5411 */       for (int j = Math.max(b2 - i, 0), k = Math.min(b2 + i + 1, charSequence1.length()); j < k; j++) {
/* 5412 */         if (!arrayOfBoolean[j] && c == charSequence1.charAt(j)) {
/* 5413 */           arrayOfInt[b2] = j;
/* 5414 */           arrayOfBoolean[j] = true;
/* 5415 */           b1++;
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     } 
/* 5420 */     char[] arrayOfChar1 = new char[b1];
/* 5421 */     char[] arrayOfChar2 = new char[b1]; byte b3, b4;
/* 5422 */     for (b3 = 0, b4 = 0; b3 < charSequence2.length(); b3++) {
/* 5423 */       if (arrayOfInt[b3] != -1) {
/* 5424 */         arrayOfChar1[b4] = charSequence2.charAt(b3);
/* 5425 */         b4++;
/*      */       } 
/*      */     } 
/* 5428 */     for (b3 = 0, b4 = 0; b3 < charSequence1.length(); b3++) {
/* 5429 */       if (arrayOfBoolean[b3]) {
/* 5430 */         arrayOfChar2[b4] = charSequence1.charAt(b3);
/* 5431 */         b4++;
/*      */       } 
/*      */     } 
/* 5434 */     b3 = 0;
/* 5435 */     for (b4 = 0; b4 < arrayOfChar1.length; b4++) {
/* 5436 */       if (arrayOfChar1[b4] != arrayOfChar2[b4]) {
/* 5437 */         b3++;
/*      */       }
/*      */     } 
/* 5440 */     b4 = 0;
/* 5441 */     for (byte b5 = 0; b5 < charSequence2.length() && 
/* 5442 */       paramCharSequence1.charAt(b5) == paramCharSequence2.charAt(b5); b5++) {
/* 5443 */       b4++;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 5448 */     return new int[] { b1, b3 / 2, b4, charSequence1.length() };
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String mid(String paramString, int paramInt1, int paramInt2) {
/* 5477 */     if (paramString == null) {
/* 5478 */       return null;
/*      */     }
/* 5480 */     if (paramInt2 < 0 || paramInt1 > paramString.length()) {
/* 5481 */       return "";
/*      */     }
/* 5483 */     if (paramInt1 < 0) {
/* 5484 */       paramInt1 = 0;
/*      */     }
/* 5486 */     if (paramString.length() <= paramInt1 + paramInt2) {
/* 5487 */       return paramString.substring(paramInt1);
/*      */     }
/* 5489 */     return paramString.substring(paramInt1, paramInt1 + paramInt2);
/*      */   }
/*      */   
/*      */   private static StringBuilder newStringBuilder(int paramInt) {
/* 5493 */     return new StringBuilder(paramInt * 16);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String normalizeSpace(String paramString) {
/* 5540 */     if (isEmpty(paramString)) {
/* 5541 */       return paramString;
/*      */     }
/* 5543 */     int i = paramString.length();
/* 5544 */     char[] arrayOfChar = new char[i];
/* 5545 */     byte b1 = 0;
/* 5546 */     byte b2 = 0;
/* 5547 */     boolean bool = true;
/* 5548 */     for (byte b3 = 0; b3 < i; b3++) {
/* 5549 */       char c = paramString.charAt(b3);
/* 5550 */       boolean bool1 = Character.isWhitespace(c);
/* 5551 */       if (bool1) {
/* 5552 */         if (!b2 && !bool) {
/* 5553 */           arrayOfChar[b1++] = " ".charAt(0);
/*      */         }
/* 5555 */         b2++;
/*      */       } else {
/* 5557 */         bool = false;
/* 5558 */         arrayOfChar[b1++] = (c == ' ') ? ' ' : c;
/* 5559 */         b2 = 0;
/*      */       } 
/*      */     } 
/* 5562 */     if (bool) {
/* 5563 */       return "";
/*      */     }
/* 5565 */     return (new String(arrayOfChar, 0, b1 - ((b2 > 0) ? 1 : 0))).trim();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int ordinalIndexOf(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt) {
/* 5619 */     return ordinalIndexOf(paramCharSequence1, paramCharSequence2, paramInt, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int ordinalIndexOf(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt, boolean paramBoolean) {
/* 5638 */     if (paramCharSequence1 == null || paramCharSequence2 == null || paramInt <= 0) {
/* 5639 */       return -1;
/*      */     }
/* 5641 */     if (paramCharSequence2.length() == 0) {
/* 5642 */       return paramBoolean ? paramCharSequence1.length() : 0;
/*      */     }
/* 5644 */     byte b = 0;
/*      */ 
/*      */     
/* 5647 */     int i = paramBoolean ? paramCharSequence1.length() : -1;
/*      */     while (true) {
/* 5649 */       if (paramBoolean) {
/* 5650 */         i = CharSequenceUtils.lastIndexOf(paramCharSequence1, paramCharSequence2, i - 1);
/*      */       } else {
/* 5652 */         i = CharSequenceUtils.indexOf(paramCharSequence1, paramCharSequence2, i + 1);
/*      */       } 
/* 5654 */       if (i < 0) {
/* 5655 */         return i;
/*      */       }
/* 5657 */       b++;
/* 5658 */       if (b >= paramInt) {
/* 5659 */         return i;
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String overlay(String paramString1, String paramString2, int paramInt1, int paramInt2) {
/* 5694 */     if (paramString1 == null) {
/* 5695 */       return null;
/*      */     }
/* 5697 */     if (paramString2 == null) {
/* 5698 */       paramString2 = "";
/*      */     }
/* 5700 */     int i = paramString1.length();
/* 5701 */     if (paramInt1 < 0) {
/* 5702 */       paramInt1 = 0;
/*      */     }
/* 5704 */     if (paramInt1 > i) {
/* 5705 */       paramInt1 = i;
/*      */     }
/* 5707 */     if (paramInt2 < 0) {
/* 5708 */       paramInt2 = 0;
/*      */     }
/* 5710 */     if (paramInt2 > i) {
/* 5711 */       paramInt2 = i;
/*      */     }
/* 5713 */     if (paramInt1 > paramInt2) {
/* 5714 */       int j = paramInt1;
/* 5715 */       paramInt1 = paramInt2;
/* 5716 */       paramInt2 = j;
/*      */     } 
/* 5718 */     return paramString1.substring(0, paramInt1) + paramString2 + paramString1
/*      */       
/* 5720 */       .substring(paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String prependIfMissing(String paramString, CharSequence paramCharSequence, boolean paramBoolean, CharSequence... paramVarArgs) {
/* 5735 */     if (paramString == null || isEmpty(paramCharSequence) || startsWith(paramString, paramCharSequence, paramBoolean)) {
/* 5736 */       return paramString;
/*      */     }
/* 5738 */     if (ArrayUtils.isNotEmpty(paramVarArgs)) {
/* 5739 */       for (CharSequence charSequence : paramVarArgs) {
/* 5740 */         if (startsWith(paramString, charSequence, paramBoolean)) {
/* 5741 */           return paramString;
/*      */         }
/*      */       } 
/*      */     }
/* 5745 */     return paramCharSequence.toString() + paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String prependIfMissing(String paramString, CharSequence paramCharSequence, CharSequence... paramVarArgs) {
/* 5783 */     return prependIfMissing(paramString, paramCharSequence, false, paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String prependIfMissingIgnoreCase(String paramString, CharSequence paramCharSequence, CharSequence... paramVarArgs) {
/* 5821 */     return prependIfMissing(paramString, paramCharSequence, true, paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String remove(String paramString, char paramChar) {
/* 5844 */     if (isEmpty(paramString) || paramString.indexOf(paramChar) == -1) {
/* 5845 */       return paramString;
/*      */     }
/* 5847 */     char[] arrayOfChar = paramString.toCharArray();
/* 5848 */     byte b1 = 0;
/* 5849 */     for (byte b2 = 0; b2 < arrayOfChar.length; b2++) {
/* 5850 */       if (arrayOfChar[b2] != paramChar) {
/* 5851 */         arrayOfChar[b1++] = arrayOfChar[b2];
/*      */       }
/*      */     } 
/* 5854 */     return new String(arrayOfChar, 0, b1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String remove(String paramString1, String paramString2) {
/* 5881 */     if (isEmpty(paramString1) || isEmpty(paramString2)) {
/* 5882 */       return paramString1;
/*      */     }
/* 5884 */     return replace(paramString1, paramString2, "", -1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static String removeAll(String paramString1, String paramString2) {
/* 5934 */     return RegExUtils.removeAll(paramString1, paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String removeEnd(String paramString1, String paramString2) {
/* 5962 */     if (isEmpty(paramString1) || isEmpty(paramString2)) {
/* 5963 */       return paramString1;
/*      */     }
/* 5965 */     if (paramString1.endsWith(paramString2)) {
/* 5966 */       return paramString1.substring(0, paramString1.length() - paramString2.length());
/*      */     }
/* 5968 */     return paramString1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String removeEndIgnoreCase(String paramString1, String paramString2) {
/* 5998 */     if (isEmpty(paramString1) || isEmpty(paramString2)) {
/* 5999 */       return paramString1;
/*      */     }
/* 6001 */     if (endsWithIgnoreCase(paramString1, paramString2)) {
/* 6002 */       return paramString1.substring(0, paramString1.length() - paramString2.length());
/*      */     }
/* 6004 */     return paramString1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static String removeFirst(String paramString1, String paramString2) {
/* 6053 */     return replaceFirst(paramString1, paramString2, "");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String removeIgnoreCase(String paramString1, String paramString2) {
/* 6090 */     if (isEmpty(paramString1) || isEmpty(paramString2)) {
/* 6091 */       return paramString1;
/*      */     }
/* 6093 */     return replaceIgnoreCase(paramString1, paramString2, "", -1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static String removePattern(String paramString1, String paramString2) {
/* 6130 */     return RegExUtils.removePattern(paramString1, paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String removeStart(String paramString1, String paramString2) {
/* 6160 */     if (isEmpty(paramString1) || isEmpty(paramString2)) {
/* 6161 */       return paramString1;
/*      */     }
/* 6163 */     if (paramString1.startsWith(paramString2)) {
/* 6164 */       return paramString1.substring(paramString2.length());
/*      */     }
/* 6166 */     return paramString1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String removeStartIgnoreCase(String paramString1, String paramString2) {
/* 6195 */     if (isEmpty(paramString1) || isEmpty(paramString2)) {
/* 6196 */       return paramString1;
/*      */     }
/* 6198 */     if (startsWithIgnoreCase(paramString1, paramString2)) {
/* 6199 */       return paramString1.substring(paramString2.length());
/*      */     }
/* 6201 */     return paramString1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String repeat(char paramChar, int paramInt) {
/* 6227 */     if (paramInt <= 0) {
/* 6228 */       return "";
/*      */     }
/* 6230 */     char[] arrayOfChar = new char[paramInt];
/* 6231 */     for (int i = paramInt - 1; i >= 0; i--) {
/* 6232 */       arrayOfChar[i] = paramChar;
/*      */     }
/* 6234 */     return new String(arrayOfChar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String repeat(String paramString, int paramInt) {
/*      */     char c1, c2, arrayOfChar[];
/*      */     int k;
/* 6260 */     if (paramString == null) {
/* 6261 */       return null;
/*      */     }
/* 6263 */     if (paramInt <= 0) {
/* 6264 */       return "";
/*      */     }
/* 6266 */     int i = paramString.length();
/* 6267 */     if (paramInt == 1 || i == 0) {
/* 6268 */       return paramString;
/*      */     }
/* 6270 */     if (i == 1 && paramInt <= 8192) {
/* 6271 */       return repeat(paramString.charAt(0), paramInt);
/*      */     }
/*      */     
/* 6274 */     int j = i * paramInt;
/* 6275 */     switch (i) {
/*      */       case 1:
/* 6277 */         return repeat(paramString.charAt(0), paramInt);
/*      */       case 2:
/* 6279 */         c1 = paramString.charAt(0);
/* 6280 */         c2 = paramString.charAt(1);
/* 6281 */         arrayOfChar = new char[j];
/* 6282 */         for (k = paramInt * 2 - 2; k >= 0; k--, k--) {
/* 6283 */           arrayOfChar[k] = c1;
/* 6284 */           arrayOfChar[k + 1] = c2;
/*      */         } 
/* 6286 */         return new String(arrayOfChar);
/*      */     } 
/* 6288 */     StringBuilder stringBuilder = new StringBuilder(j);
/* 6289 */     for (byte b = 0; b < paramInt; b++) {
/* 6290 */       stringBuilder.append(paramString);
/*      */     }
/* 6292 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String repeat(String paramString1, String paramString2, int paramInt) {
/* 6320 */     if (paramString1 == null || paramString2 == null) {
/* 6321 */       return repeat(paramString1, paramInt);
/*      */     }
/*      */     
/* 6324 */     String str = repeat(paramString1 + paramString2, paramInt);
/* 6325 */     return removeEnd(str, paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String replace(String paramString1, String paramString2, String paramString3) {
/* 6352 */     return replace(paramString1, paramString2, paramString3, -1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String replace(String paramString1, String paramString2, String paramString3, int paramInt) {
/* 6384 */     return replace(paramString1, paramString2, paramString3, paramInt, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String replace(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean) {
/* 6419 */     if (isEmpty(paramString1) || isEmpty(paramString2) || paramString3 == null || paramInt == 0) {
/* 6420 */       return paramString1;
/*      */     }
/* 6422 */     if (paramBoolean) {
/* 6423 */       paramString2 = paramString2.toLowerCase();
/*      */     }
/* 6425 */     int i = 0;
/* 6426 */     int j = paramBoolean ? indexOfIgnoreCase(paramString1, paramString2, i) : indexOf(paramString1, paramString2, i);
/* 6427 */     if (j == -1) {
/* 6428 */       return paramString1;
/*      */     }
/* 6430 */     int k = paramString2.length();
/* 6431 */     int m = Math.max(paramString3.length() - k, 0);
/* 6432 */     m *= (paramInt < 0) ? 16 : Math.min(paramInt, 64);
/* 6433 */     StringBuilder stringBuilder = new StringBuilder(paramString1.length() + m);
/* 6434 */     while (j != -1) {
/* 6435 */       stringBuilder.append(paramString1, i, j).append(paramString3);
/* 6436 */       i = j + k;
/* 6437 */       if (--paramInt == 0) {
/*      */         break;
/*      */       }
/* 6440 */       j = paramBoolean ? indexOfIgnoreCase(paramString1, paramString2, i) : indexOf(paramString1, paramString2, i);
/*      */     } 
/* 6442 */     stringBuilder.append(paramString1, i, paramString1.length());
/* 6443 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static String replaceAll(String paramString1, String paramString2, String paramString3) {
/* 6498 */     return RegExUtils.replaceAll(paramString1, paramString2, paramString3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String replaceChars(String paramString, char paramChar1, char paramChar2) {
/* 6524 */     if (paramString == null) {
/* 6525 */       return null;
/*      */     }
/* 6527 */     return paramString.replace(paramChar1, paramChar2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String replaceChars(String paramString1, String paramString2, String paramString3) {
/* 6567 */     if (isEmpty(paramString1) || isEmpty(paramString2)) {
/* 6568 */       return paramString1;
/*      */     }
/* 6570 */     if (paramString3 == null) {
/* 6571 */       paramString3 = "";
/*      */     }
/* 6573 */     boolean bool = false;
/* 6574 */     int i = paramString3.length();
/* 6575 */     int j = paramString1.length();
/* 6576 */     StringBuilder stringBuilder = new StringBuilder(j);
/* 6577 */     for (byte b = 0; b < j; b++) {
/* 6578 */       char c = paramString1.charAt(b);
/* 6579 */       int k = paramString2.indexOf(c);
/* 6580 */       if (k >= 0) {
/* 6581 */         bool = true;
/* 6582 */         if (k < i) {
/* 6583 */           stringBuilder.append(paramString3.charAt(k));
/*      */         }
/*      */       } else {
/* 6586 */         stringBuilder.append(c);
/*      */       } 
/*      */     } 
/* 6589 */     if (bool) {
/* 6590 */       return stringBuilder.toString();
/*      */     }
/* 6592 */     return paramString1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String replaceEach(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2) {
/* 6635 */     return replaceEach(paramString, paramArrayOfString1, paramArrayOfString2, false, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String replaceEach(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2, boolean paramBoolean, int paramInt) {
/* 6695 */     if (paramInt < 0) {
/* 6696 */       HashSet hashSet = new HashSet(Arrays.asList((Object[])paramArrayOfString1));
/* 6697 */       HashSet<?> hashSet1 = new HashSet(Arrays.asList((Object[])paramArrayOfString2));
/* 6698 */       hashSet.retainAll(hashSet1);
/* 6699 */       if (hashSet.size() > 0) {
/* 6700 */         throw new IllegalStateException("Aborting to protect against StackOverflowError - output of one loop is the input of another");
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 6705 */     if (isEmpty(paramString) || ArrayUtils.isEmpty((Object[])paramArrayOfString1) || ArrayUtils.isEmpty((Object[])paramArrayOfString2) || (ArrayUtils.isNotEmpty(paramArrayOfString1) && paramInt == -1)) {
/* 6706 */       return paramString;
/*      */     }
/*      */     
/* 6709 */     int i = paramArrayOfString1.length;
/* 6710 */     int j = paramArrayOfString2.length;
/*      */ 
/*      */     
/* 6713 */     if (i != j) {
/* 6714 */       throw new IllegalArgumentException("Search and Replace array lengths don't match: " + i + " vs " + j);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 6721 */     boolean[] arrayOfBoolean = new boolean[i];
/*      */ 
/*      */     
/* 6724 */     int k = -1;
/* 6725 */     int m = -1;
/* 6726 */     int n = -1;
/*      */     
/*      */     int i1;
/*      */     
/* 6730 */     for (i1 = 0; i1 < i; i1++) {
/* 6731 */       if (!arrayOfBoolean[i1] && !isEmpty(paramArrayOfString1[i1]) && paramArrayOfString2[i1] != null) {
/*      */ 
/*      */         
/* 6734 */         n = paramString.indexOf(paramArrayOfString1[i1]);
/*      */ 
/*      */         
/* 6737 */         if (n == -1) {
/* 6738 */           arrayOfBoolean[i1] = true;
/*      */         }
/* 6740 */         else if (k == -1 || n < k) {
/* 6741 */           k = n;
/* 6742 */           m = i1;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 6749 */     if (k == -1) {
/* 6750 */       return paramString;
/*      */     }
/*      */     
/* 6753 */     i1 = 0;
/*      */ 
/*      */     
/* 6756 */     int i2 = 0;
/*      */ 
/*      */     
/* 6759 */     for (byte b = 0; b < paramArrayOfString1.length; b++) {
/* 6760 */       if (paramArrayOfString1[b] != null && paramArrayOfString2[b] != null) {
/*      */ 
/*      */         
/* 6763 */         int i5 = paramArrayOfString2[b].length() - paramArrayOfString1[b].length();
/* 6764 */         if (i5 > 0) {
/* 6765 */           i2 += 3 * i5;
/*      */         }
/*      */       } 
/*      */     } 
/* 6769 */     i2 = Math.min(i2, paramString.length() / 5);
/*      */     
/* 6771 */     StringBuilder stringBuilder = new StringBuilder(paramString.length() + i2);
/*      */     
/* 6773 */     while (k != -1) {
/*      */       int i5;
/* 6775 */       for (i5 = i1; i5 < k; i5++) {
/* 6776 */         stringBuilder.append(paramString.charAt(i5));
/*      */       }
/* 6778 */       stringBuilder.append(paramArrayOfString2[m]);
/*      */       
/* 6780 */       i1 = k + paramArrayOfString1[m].length();
/*      */       
/* 6782 */       k = -1;
/* 6783 */       m = -1;
/* 6784 */       n = -1;
/*      */ 
/*      */       
/* 6787 */       for (i5 = 0; i5 < i; i5++) {
/* 6788 */         if (!arrayOfBoolean[i5] && paramArrayOfString1[i5] != null && 
/* 6789 */           !paramArrayOfString1[i5].isEmpty() && paramArrayOfString2[i5] != null) {
/*      */ 
/*      */           
/* 6792 */           n = paramString.indexOf(paramArrayOfString1[i5], i1);
/*      */ 
/*      */           
/* 6795 */           if (n == -1) {
/* 6796 */             arrayOfBoolean[i5] = true;
/*      */           }
/* 6798 */           else if (k == -1 || n < k) {
/* 6799 */             k = n;
/* 6800 */             m = i5;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 6807 */     int i3 = paramString.length();
/* 6808 */     for (int i4 = i1; i4 < i3; i4++) {
/* 6809 */       stringBuilder.append(paramString.charAt(i4));
/*      */     }
/* 6811 */     String str = stringBuilder.toString();
/* 6812 */     if (!paramBoolean) {
/* 6813 */       return str;
/*      */     }
/*      */     
/* 6816 */     return replaceEach(str, paramArrayOfString1, paramArrayOfString2, paramBoolean, paramInt - 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String replaceEachRepeatedly(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2) {
/* 6864 */     boolean bool = (paramArrayOfString1 == null) ? false : paramArrayOfString1.length;
/* 6865 */     return replaceEach(paramString, paramArrayOfString1, paramArrayOfString2, true, bool);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static String replaceFirst(String paramString1, String paramString2, String paramString3) {
/* 6918 */     return RegExUtils.replaceFirst(paramString1, paramString2, paramString3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String replaceIgnoreCase(String paramString1, String paramString2, String paramString3) {
/* 6946 */     return replaceIgnoreCase(paramString1, paramString2, paramString3, -1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String replaceIgnoreCase(String paramString1, String paramString2, String paramString3, int paramInt) {
/* 6979 */     return replace(paramString1, paramString2, paramString3, paramInt, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String replaceOnce(String paramString1, String paramString2, String paramString3) {
/* 7008 */     return replace(paramString1, paramString2, paramString3, 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String replaceOnceIgnoreCase(String paramString1, String paramString2, String paramString3) {
/* 7037 */     return replaceIgnoreCase(paramString1, paramString2, paramString3, 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static String replacePattern(String paramString1, String paramString2, String paramString3) {
/* 7083 */     return RegExUtils.replacePattern(paramString1, paramString2, paramString3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String reverse(String paramString) {
/* 7103 */     if (paramString == null) {
/* 7104 */       return null;
/*      */     }
/* 7106 */     return (new StringBuilder(paramString)).reverse().toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String reverseDelimited(String paramString, char paramChar) {
/* 7129 */     if (paramString == null) {
/* 7130 */       return null;
/*      */     }
/*      */ 
/*      */     
/* 7134 */     String[] arrayOfString = split(paramString, paramChar);
/* 7135 */     ArrayUtils.reverse((Object[])arrayOfString);
/* 7136 */     return join((Object[])arrayOfString, paramChar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String right(String paramString, int paramInt) {
/* 7160 */     if (paramString == null) {
/* 7161 */       return null;
/*      */     }
/* 7163 */     if (paramInt < 0) {
/* 7164 */       return "";
/*      */     }
/* 7166 */     if (paramString.length() <= paramInt) {
/* 7167 */       return paramString;
/*      */     }
/* 7169 */     return paramString.substring(paramString.length() - paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String rightPad(String paramString, int paramInt) {
/* 7192 */     return rightPad(paramString, paramInt, ' ');
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String rightPad(String paramString, int paramInt, char paramChar) {
/* 7217 */     if (paramString == null) {
/* 7218 */       return null;
/*      */     }
/* 7220 */     int i = paramInt - paramString.length();
/* 7221 */     if (i <= 0) {
/* 7222 */       return paramString;
/*      */     }
/* 7224 */     if (i > 8192) {
/* 7225 */       return rightPad(paramString, paramInt, String.valueOf(paramChar));
/*      */     }
/* 7227 */     return paramString.concat(repeat(paramChar, i));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String rightPad(String paramString1, int paramInt, String paramString2) {
/* 7254 */     if (paramString1 == null) {
/* 7255 */       return null;
/*      */     }
/* 7257 */     if (isEmpty(paramString2)) {
/* 7258 */       paramString2 = " ";
/*      */     }
/* 7260 */     int i = paramString2.length();
/* 7261 */     int j = paramString1.length();
/* 7262 */     int k = paramInt - j;
/* 7263 */     if (k <= 0) {
/* 7264 */       return paramString1;
/*      */     }
/* 7266 */     if (i == 1 && k <= 8192) {
/* 7267 */       return rightPad(paramString1, paramInt, paramString2.charAt(0));
/*      */     }
/*      */     
/* 7270 */     if (k == i)
/* 7271 */       return paramString1.concat(paramString2); 
/* 7272 */     if (k < i) {
/* 7273 */       return paramString1.concat(paramString2.substring(0, k));
/*      */     }
/* 7275 */     char[] arrayOfChar1 = new char[k];
/* 7276 */     char[] arrayOfChar2 = paramString2.toCharArray();
/* 7277 */     for (byte b = 0; b < k; b++) {
/* 7278 */       arrayOfChar1[b] = arrayOfChar2[b % i];
/*      */     }
/* 7280 */     return paramString1.concat(new String(arrayOfChar1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String rotate(String paramString, int paramInt) {
/* 7313 */     if (paramString == null) {
/* 7314 */       return null;
/*      */     }
/*      */     
/* 7317 */     int i = paramString.length();
/* 7318 */     if (paramInt == 0 || i == 0 || paramInt % i == 0) {
/* 7319 */       return paramString;
/*      */     }
/*      */     
/* 7322 */     StringBuilder stringBuilder = new StringBuilder(i);
/* 7323 */     int j = -(paramInt % i);
/* 7324 */     stringBuilder.append(substring(paramString, j));
/* 7325 */     stringBuilder.append(substring(paramString, 0, j));
/* 7326 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] split(String paramString) {
/* 7354 */     return split(paramString, null, -1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] split(String paramString, char paramChar) {
/* 7382 */     return splitWorker(paramString, paramChar, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] split(String paramString1, String paramString2) {
/* 7411 */     return splitWorker(paramString1, paramString2, -1, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] split(String paramString1, String paramString2, int paramInt) {
/* 7445 */     return splitWorker(paramString1, paramString2, paramInt, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] splitByCharacterType(String paramString) {
/* 7468 */     return splitByCharacterType(paramString, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String[] splitByCharacterType(String paramString, boolean paramBoolean) {
/* 7486 */     if (paramString == null) {
/* 7487 */       return null;
/*      */     }
/* 7489 */     if (paramString.isEmpty()) {
/* 7490 */       return ArrayUtils.EMPTY_STRING_ARRAY;
/*      */     }
/* 7492 */     char[] arrayOfChar = paramString.toCharArray();
/* 7493 */     ArrayList<String> arrayList = new ArrayList();
/* 7494 */     int i = 0;
/* 7495 */     int j = Character.getType(arrayOfChar[i]);
/* 7496 */     for (int k = i + 1; k < arrayOfChar.length; k++) {
/* 7497 */       int m = Character.getType(arrayOfChar[k]);
/* 7498 */       if (m != j) {
/*      */ 
/*      */         
/* 7501 */         if (paramBoolean && m == 2 && j == 1) {
/* 7502 */           int n = k - 1;
/* 7503 */           if (n != i) {
/* 7504 */             arrayList.add(new String(arrayOfChar, i, n - i));
/* 7505 */             i = n;
/*      */           } 
/*      */         } else {
/* 7508 */           arrayList.add(new String(arrayOfChar, i, k - i));
/* 7509 */           i = k;
/*      */         } 
/* 7511 */         j = m;
/*      */       } 
/* 7513 */     }  arrayList.add(new String(arrayOfChar, i, arrayOfChar.length - i));
/* 7514 */     return arrayList.<String>toArray(ArrayUtils.EMPTY_STRING_ARRAY);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] splitByCharacterTypeCamelCase(String paramString) {
/* 7542 */     return splitByCharacterType(paramString, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] splitByWholeSeparator(String paramString1, String paramString2) {
/* 7569 */     return splitByWholeSeparatorWorker(paramString1, paramString2, -1, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] splitByWholeSeparator(String paramString1, String paramString2, int paramInt) {
/* 7600 */     return splitByWholeSeparatorWorker(paramString1, paramString2, paramInt, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] splitByWholeSeparatorPreserveAllTokens(String paramString1, String paramString2) {
/* 7629 */     return splitByWholeSeparatorWorker(paramString1, paramString2, -1, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] splitByWholeSeparatorPreserveAllTokens(String paramString1, String paramString2, int paramInt) {
/* 7662 */     return splitByWholeSeparatorWorker(paramString1, paramString2, paramInt, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String[] splitByWholeSeparatorWorker(String paramString1, String paramString2, int paramInt, boolean paramBoolean) {
/* 7681 */     if (paramString1 == null) {
/* 7682 */       return null;
/*      */     }
/*      */     
/* 7685 */     int i = paramString1.length();
/*      */     
/* 7687 */     if (i == 0) {
/* 7688 */       return ArrayUtils.EMPTY_STRING_ARRAY;
/*      */     }
/*      */     
/* 7691 */     if (paramString2 == null || "".equals(paramString2))
/*      */     {
/* 7693 */       return splitWorker(paramString1, null, paramInt, paramBoolean);
/*      */     }
/*      */     
/* 7696 */     int j = paramString2.length();
/*      */     
/* 7698 */     ArrayList<String> arrayList = new ArrayList();
/* 7699 */     byte b = 0;
/* 7700 */     int k = 0;
/* 7701 */     int m = 0;
/* 7702 */     while (m < i) {
/* 7703 */       m = paramString1.indexOf(paramString2, k);
/*      */       
/* 7705 */       if (m > -1) {
/* 7706 */         if (m > k) {
/* 7707 */           b++;
/*      */           
/* 7709 */           if (b == paramInt) {
/* 7710 */             m = i;
/* 7711 */             arrayList.add(paramString1.substring(k));
/*      */             
/*      */             continue;
/*      */           } 
/* 7715 */           arrayList.add(paramString1.substring(k, m));
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 7720 */           k = m + j;
/*      */           
/*      */           continue;
/*      */         } 
/* 7724 */         if (paramBoolean) {
/* 7725 */           b++;
/* 7726 */           if (b == paramInt) {
/* 7727 */             m = i;
/* 7728 */             arrayList.add(paramString1.substring(k));
/*      */           } else {
/* 7730 */             arrayList.add("");
/*      */           } 
/*      */         } 
/* 7733 */         k = m + j;
/*      */         
/*      */         continue;
/*      */       } 
/* 7737 */       arrayList.add(paramString1.substring(k));
/* 7738 */       m = i;
/*      */     } 
/*      */ 
/*      */     
/* 7742 */     return arrayList.<String>toArray(ArrayUtils.EMPTY_STRING_ARRAY);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] splitPreserveAllTokens(String paramString) {
/* 7771 */     return splitWorker(paramString, null, -1, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] splitPreserveAllTokens(String paramString, char paramChar) {
/* 7807 */     return splitWorker(paramString, paramChar, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] splitPreserveAllTokens(String paramString1, String paramString2) {
/* 7844 */     return splitWorker(paramString1, paramString2, -1, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] splitPreserveAllTokens(String paramString1, String paramString2, int paramInt) {
/* 7884 */     return splitWorker(paramString1, paramString2, paramInt, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String[] splitWorker(String paramString, char paramChar, boolean paramBoolean) {
/* 7902 */     if (paramString == null) {
/* 7903 */       return null;
/*      */     }
/* 7905 */     int i = paramString.length();
/* 7906 */     if (i == 0) {
/* 7907 */       return ArrayUtils.EMPTY_STRING_ARRAY;
/*      */     }
/* 7909 */     ArrayList<String> arrayList = new ArrayList();
/* 7910 */     byte b1 = 0, b2 = 0;
/* 7911 */     boolean bool1 = false;
/* 7912 */     boolean bool2 = false;
/* 7913 */     while (b1 < i) {
/* 7914 */       if (paramString.charAt(b1) == paramChar) {
/* 7915 */         if (bool1 || paramBoolean) {
/* 7916 */           arrayList.add(paramString.substring(b2, b1));
/* 7917 */           bool1 = false;
/* 7918 */           bool2 = true;
/*      */         } 
/* 7920 */         b2 = ++b1;
/*      */         continue;
/*      */       } 
/* 7923 */       bool2 = false;
/* 7924 */       bool1 = true;
/* 7925 */       b1++;
/*      */     } 
/* 7927 */     if (bool1 || (paramBoolean && bool2)) {
/* 7928 */       arrayList.add(paramString.substring(b2, b1));
/*      */     }
/* 7930 */     return arrayList.<String>toArray(ArrayUtils.EMPTY_STRING_ARRAY);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String[] splitWorker(String paramString1, String paramString2, int paramInt, boolean paramBoolean) {
/* 7952 */     if (paramString1 == null) {
/* 7953 */       return null;
/*      */     }
/* 7955 */     int i = paramString1.length();
/* 7956 */     if (i == 0) {
/* 7957 */       return ArrayUtils.EMPTY_STRING_ARRAY;
/*      */     }
/* 7959 */     ArrayList<String> arrayList = new ArrayList();
/* 7960 */     byte b = 1;
/* 7961 */     int j = 0, k = 0;
/* 7962 */     boolean bool1 = false;
/* 7963 */     boolean bool2 = false;
/* 7964 */     if (paramString2 == null) {
/*      */       
/* 7966 */       while (j < i) {
/* 7967 */         if (Character.isWhitespace(paramString1.charAt(j))) {
/* 7968 */           if (bool1 || paramBoolean) {
/* 7969 */             bool2 = true;
/* 7970 */             if (b++ == paramInt) {
/* 7971 */               j = i;
/* 7972 */               bool2 = false;
/*      */             } 
/* 7974 */             arrayList.add(paramString1.substring(k, j));
/* 7975 */             bool1 = false;
/*      */           } 
/* 7977 */           k = ++j;
/*      */           continue;
/*      */         } 
/* 7980 */         bool2 = false;
/* 7981 */         bool1 = true;
/* 7982 */         j++;
/*      */       } 
/* 7984 */     } else if (paramString2.length() == 1) {
/*      */       
/* 7986 */       char c = paramString2.charAt(0);
/* 7987 */       while (j < i) {
/* 7988 */         if (paramString1.charAt(j) == c) {
/* 7989 */           if (bool1 || paramBoolean) {
/* 7990 */             bool2 = true;
/* 7991 */             if (b++ == paramInt) {
/* 7992 */               j = i;
/* 7993 */               bool2 = false;
/*      */             } 
/* 7995 */             arrayList.add(paramString1.substring(k, j));
/* 7996 */             bool1 = false;
/*      */           } 
/* 7998 */           k = ++j;
/*      */           continue;
/*      */         } 
/* 8001 */         bool2 = false;
/* 8002 */         bool1 = true;
/* 8003 */         j++;
/*      */       } 
/*      */     } else {
/*      */       
/* 8007 */       while (j < i) {
/* 8008 */         if (paramString2.indexOf(paramString1.charAt(j)) >= 0) {
/* 8009 */           if (bool1 || paramBoolean) {
/* 8010 */             bool2 = true;
/* 8011 */             if (b++ == paramInt) {
/* 8012 */               j = i;
/* 8013 */               bool2 = false;
/*      */             } 
/* 8015 */             arrayList.add(paramString1.substring(k, j));
/* 8016 */             bool1 = false;
/*      */           } 
/* 8018 */           k = ++j;
/*      */           continue;
/*      */         } 
/* 8021 */         bool2 = false;
/* 8022 */         bool1 = true;
/* 8023 */         j++;
/*      */       } 
/*      */     } 
/* 8026 */     if (bool1 || (paramBoolean && bool2)) {
/* 8027 */       arrayList.add(paramString1.substring(k, j));
/*      */     }
/* 8029 */     return arrayList.<String>toArray(ArrayUtils.EMPTY_STRING_ARRAY);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean startsWith(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 8055 */     return startsWith(paramCharSequence1, paramCharSequence2, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean startsWith(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean) {
/* 8070 */     if (paramCharSequence1 == null || paramCharSequence2 == null) {
/* 8071 */       return (paramCharSequence1 == paramCharSequence2);
/*      */     }
/* 8073 */     if (paramCharSequence2.length() > paramCharSequence1.length()) {
/* 8074 */       return false;
/*      */     }
/* 8076 */     return CharSequenceUtils.regionMatches(paramCharSequence1, paramBoolean, 0, paramCharSequence2, 0, paramCharSequence2.length());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean startsWithAny(CharSequence paramCharSequence, CharSequence... paramVarArgs) {
/* 8102 */     if (isEmpty(paramCharSequence) || ArrayUtils.isEmpty((Object[])paramVarArgs)) {
/* 8103 */       return false;
/*      */     }
/* 8105 */     for (CharSequence charSequence : paramVarArgs) {
/* 8106 */       if (startsWith(paramCharSequence, charSequence)) {
/* 8107 */         return true;
/*      */       }
/*      */     } 
/* 8110 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean startsWithIgnoreCase(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 8136 */     return startsWith(paramCharSequence1, paramCharSequence2, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String strip(String paramString) {
/* 8164 */     return strip(paramString, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String strip(String paramString1, String paramString2) {
/* 8194 */     if (isEmpty(paramString1)) {
/* 8195 */       return paramString1;
/*      */     }
/* 8197 */     paramString1 = stripStart(paramString1, paramString2);
/* 8198 */     return stripEnd(paramString1, paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String stripAccents(String paramString) {
/* 8220 */     if (paramString == null) {
/* 8221 */       return null;
/*      */     }
/* 8223 */     StringBuilder stringBuilder = new StringBuilder(Normalizer.normalize(paramString, Normalizer.Form.NFD));
/* 8224 */     convertRemainingAccentCharacters(stringBuilder);
/*      */     
/* 8226 */     return STRIP_ACCENTS_PATTERN.matcher(stringBuilder).replaceAll("");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] stripAll(String... paramVarArgs) {
/* 8251 */     return stripAll(paramVarArgs, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] stripAll(String[] paramArrayOfString, String paramString) {
/* 8280 */     int i = ArrayUtils.getLength(paramArrayOfString);
/* 8281 */     if (i == 0) {
/* 8282 */       return paramArrayOfString;
/*      */     }
/* 8284 */     String[] arrayOfString = new String[i];
/* 8285 */     for (byte b = 0; b < i; b++) {
/* 8286 */       arrayOfString[b] = strip(paramArrayOfString[b], paramString);
/*      */     }
/* 8288 */     return arrayOfString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String stripEnd(String paramString1, String paramString2) {
/* 8317 */     int i = length(paramString1);
/* 8318 */     if (i == 0) {
/* 8319 */       return paramString1;
/*      */     }
/*      */     
/* 8322 */     if (paramString2 == null) {
/* 8323 */       while (i != 0 && Character.isWhitespace(paramString1.charAt(i - 1)))
/* 8324 */         i--; 
/*      */     } else {
/* 8326 */       if (paramString2.isEmpty()) {
/* 8327 */         return paramString1;
/*      */       }
/* 8329 */       while (i != 0 && paramString2.indexOf(paramString1.charAt(i - 1)) != -1) {
/* 8330 */         i--;
/*      */       }
/*      */     } 
/* 8333 */     return paramString1.substring(0, i);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String stripStart(String paramString1, String paramString2) {
/* 8361 */     int i = length(paramString1);
/* 8362 */     if (i == 0) {
/* 8363 */       return paramString1;
/*      */     }
/* 8365 */     int j = 0;
/* 8366 */     if (paramString2 == null) {
/* 8367 */       while (j != i && Character.isWhitespace(paramString1.charAt(j)))
/* 8368 */         j++; 
/*      */     } else {
/* 8370 */       if (paramString2.isEmpty()) {
/* 8371 */         return paramString1;
/*      */       }
/* 8373 */       while (j != i && paramString2.indexOf(paramString1.charAt(j)) != -1) {
/* 8374 */         j++;
/*      */       }
/*      */     } 
/* 8377 */     return paramString1.substring(j);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String stripToEmpty(String paramString) {
/* 8403 */     return (paramString == null) ? "" : strip(paramString, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String stripToNull(String paramString) {
/* 8430 */     if (paramString == null) {
/* 8431 */       return null;
/*      */     }
/* 8433 */     paramString = strip(paramString, null);
/* 8434 */     return paramString.isEmpty() ? null : paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String substring(String paramString, int paramInt) {
/* 8464 */     if (paramString == null) {
/* 8465 */       return null;
/*      */     }
/*      */ 
/*      */     
/* 8469 */     if (paramInt < 0) {
/* 8470 */       paramInt = paramString.length() + paramInt;
/*      */     }
/*      */     
/* 8473 */     if (paramInt < 0) {
/* 8474 */       paramInt = 0;
/*      */     }
/* 8476 */     if (paramInt > paramString.length()) {
/* 8477 */       return "";
/*      */     }
/*      */     
/* 8480 */     return paramString.substring(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String substring(String paramString, int paramInt1, int paramInt2) {
/* 8519 */     if (paramString == null) {
/* 8520 */       return null;
/*      */     }
/*      */ 
/*      */     
/* 8524 */     if (paramInt2 < 0) {
/* 8525 */       paramInt2 = paramString.length() + paramInt2;
/*      */     }
/* 8527 */     if (paramInt1 < 0) {
/* 8528 */       paramInt1 = paramString.length() + paramInt1;
/*      */     }
/*      */ 
/*      */     
/* 8532 */     if (paramInt2 > paramString.length()) {
/* 8533 */       paramInt2 = paramString.length();
/*      */     }
/*      */ 
/*      */     
/* 8537 */     if (paramInt1 > paramInt2) {
/* 8538 */       return "";
/*      */     }
/*      */     
/* 8541 */     if (paramInt1 < 0) {
/* 8542 */       paramInt1 = 0;
/*      */     }
/* 8544 */     if (paramInt2 < 0) {
/* 8545 */       paramInt2 = 0;
/*      */     }
/*      */     
/* 8548 */     return paramString.substring(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String substringAfter(String paramString, int paramInt) {
/* 8577 */     if (isEmpty(paramString)) {
/* 8578 */       return paramString;
/*      */     }
/* 8580 */     int i = paramString.indexOf(paramInt);
/* 8581 */     if (i == -1) {
/* 8582 */       return "";
/*      */     }
/* 8584 */     return paramString.substring(i + 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String substringAfter(String paramString1, String paramString2) {
/* 8616 */     if (isEmpty(paramString1)) {
/* 8617 */       return paramString1;
/*      */     }
/* 8619 */     if (paramString2 == null) {
/* 8620 */       return "";
/*      */     }
/* 8622 */     int i = paramString1.indexOf(paramString2);
/* 8623 */     if (i == -1) {
/* 8624 */       return "";
/*      */     }
/* 8626 */     return paramString1.substring(i + paramString2.length());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String substringAfterLast(String paramString, int paramInt) {
/* 8659 */     if (isEmpty(paramString)) {
/* 8660 */       return paramString;
/*      */     }
/* 8662 */     int i = paramString.lastIndexOf(paramInt);
/* 8663 */     if (i == -1 || i == paramString.length() - 1) {
/* 8664 */       return "";
/*      */     }
/* 8666 */     return paramString.substring(i + 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String substringAfterLast(String paramString1, String paramString2) {
/* 8699 */     if (isEmpty(paramString1)) {
/* 8700 */       return paramString1;
/*      */     }
/* 8702 */     if (isEmpty(paramString2)) {
/* 8703 */       return "";
/*      */     }
/* 8705 */     int i = paramString1.lastIndexOf(paramString2);
/* 8706 */     if (i == -1 || i == paramString1.length() - paramString2.length()) {
/* 8707 */       return "";
/*      */     }
/* 8709 */     return paramString1.substring(i + paramString2.length());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String substringBefore(String paramString1, String paramString2) {
/* 8742 */     if (isEmpty(paramString1) || paramString2 == null) {
/* 8743 */       return paramString1;
/*      */     }
/* 8745 */     if (paramString2.isEmpty()) {
/* 8746 */       return "";
/*      */     }
/* 8748 */     int i = paramString1.indexOf(paramString2);
/* 8749 */     if (i == -1) {
/* 8750 */       return paramString1;
/*      */     }
/* 8752 */     return paramString1.substring(0, i);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String substringBeforeLast(String paramString1, String paramString2) {
/* 8783 */     if (isEmpty(paramString1) || isEmpty(paramString2)) {
/* 8784 */       return paramString1;
/*      */     }
/* 8786 */     int i = paramString1.lastIndexOf(paramString2);
/* 8787 */     if (i == -1) {
/* 8788 */       return paramString1;
/*      */     }
/* 8790 */     return paramString1.substring(0, i);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String substringBetween(String paramString1, String paramString2) {
/* 8817 */     return substringBetween(paramString1, paramString2, paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String substringBetween(String paramString1, String paramString2, String paramString3) {
/* 8851 */     if (!ObjectUtils.allNotNull(new Object[] { paramString1, paramString2, paramString3 })) {
/* 8852 */       return null;
/*      */     }
/* 8854 */     int i = paramString1.indexOf(paramString2);
/* 8855 */     if (i != -1) {
/* 8856 */       int j = paramString1.indexOf(paramString3, i + paramString2.length());
/* 8857 */       if (j != -1) {
/* 8858 */         return paramString1.substring(i + paramString2.length(), j);
/*      */       }
/*      */     } 
/* 8861 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] substringsBetween(String paramString1, String paramString2, String paramString3) {
/* 8887 */     if (paramString1 == null || isEmpty(paramString2) || isEmpty(paramString3)) {
/* 8888 */       return null;
/*      */     }
/* 8890 */     int i = paramString1.length();
/* 8891 */     if (i == 0) {
/* 8892 */       return ArrayUtils.EMPTY_STRING_ARRAY;
/*      */     }
/* 8894 */     int j = paramString3.length();
/* 8895 */     int k = paramString2.length();
/* 8896 */     ArrayList<String> arrayList = new ArrayList();
/* 8897 */     int m = 0;
/* 8898 */     while (m < i - j) {
/* 8899 */       int n = paramString1.indexOf(paramString2, m);
/* 8900 */       if (n < 0) {
/*      */         break;
/*      */       }
/* 8903 */       n += k;
/* 8904 */       int i1 = paramString1.indexOf(paramString3, n);
/* 8905 */       if (i1 < 0) {
/*      */         break;
/*      */       }
/* 8908 */       arrayList.add(paramString1.substring(n, i1));
/* 8909 */       m = i1 + j;
/*      */     } 
/* 8911 */     if (arrayList.isEmpty()) {
/* 8912 */       return null;
/*      */     }
/* 8914 */     return arrayList.<String>toArray(ArrayUtils.EMPTY_STRING_ARRAY);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String swapCase(String paramString) {
/* 8945 */     if (isEmpty(paramString)) {
/* 8946 */       return paramString;
/*      */     }
/*      */     
/* 8949 */     int i = paramString.length();
/* 8950 */     int[] arrayOfInt = new int[i];
/* 8951 */     byte b = 0; int j;
/* 8952 */     for (j = 0; j < i; ) {
/* 8953 */       int m, k = paramString.codePointAt(j);
/*      */       
/* 8955 */       if (Character.isUpperCase(k) || Character.isTitleCase(k)) {
/* 8956 */         m = Character.toLowerCase(k);
/* 8957 */       } else if (Character.isLowerCase(k)) {
/* 8958 */         m = Character.toUpperCase(k);
/*      */       } else {
/* 8960 */         m = k;
/*      */       } 
/* 8962 */       arrayOfInt[b++] = m;
/* 8963 */       j += Character.charCount(m);
/*      */     } 
/* 8965 */     return new String(arrayOfInt, 0, b);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int[] toCodePoints(CharSequence paramCharSequence) {
/* 8985 */     if (paramCharSequence == null) {
/* 8986 */       return null;
/*      */     }
/* 8988 */     if (paramCharSequence.length() == 0) {
/* 8989 */       return ArrayUtils.EMPTY_INT_ARRAY;
/*      */     }
/*      */     
/* 8992 */     String str = paramCharSequence.toString();
/* 8993 */     int[] arrayOfInt = new int[str.codePointCount(0, str.length())];
/* 8994 */     int i = 0;
/* 8995 */     for (byte b = 0; b < arrayOfInt.length; b++) {
/* 8996 */       arrayOfInt[b] = str.codePointAt(i);
/* 8997 */       i += Character.charCount(arrayOfInt[b]);
/*      */     } 
/* 8999 */     return arrayOfInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String toEncodedString(byte[] paramArrayOfbyte, Charset paramCharset) {
/* 9016 */     return new String(paramArrayOfbyte, Charsets.toCharset(paramCharset));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String toRootLowerCase(String paramString) {
/* 9027 */     return (paramString == null) ? null : paramString.toLowerCase(Locale.ROOT);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String toRootUpperCase(String paramString) {
/* 9038 */     return (paramString == null) ? null : paramString.toUpperCase(Locale.ROOT);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static String toString(byte[] paramArrayOfbyte, String paramString) throws UnsupportedEncodingException {
/* 9058 */     return (paramString != null) ? new String(paramArrayOfbyte, paramString) : new String(paramArrayOfbyte, Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String trim(String paramString) {
/* 9087 */     return (paramString == null) ? null : paramString.trim();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String trimToEmpty(String paramString) {
/* 9112 */     return (paramString == null) ? "" : paramString.trim();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String trimToNull(String paramString) {
/* 9138 */     String str = trim(paramString);
/* 9139 */     return isEmpty(str) ? null : str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String truncate(String paramString, int paramInt) {
/* 9175 */     return truncate(paramString, 0, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String truncate(String paramString, int paramInt1, int paramInt2) {
/* 9239 */     if (paramInt1 < 0) {
/* 9240 */       throw new IllegalArgumentException("offset cannot be negative");
/*      */     }
/* 9242 */     if (paramInt2 < 0) {
/* 9243 */       throw new IllegalArgumentException("maxWith cannot be negative");
/*      */     }
/* 9245 */     if (paramString == null) {
/* 9246 */       return null;
/*      */     }
/* 9248 */     if (paramInt1 > paramString.length()) {
/* 9249 */       return "";
/*      */     }
/* 9251 */     if (paramString.length() > paramInt2) {
/* 9252 */       int i = Math.min(paramInt1 + paramInt2, paramString.length());
/* 9253 */       return paramString.substring(paramInt1, i);
/*      */     } 
/* 9255 */     return paramString.substring(paramInt1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String uncapitalize(String paramString) {
/* 9280 */     int i = length(paramString);
/* 9281 */     if (i == 0) {
/* 9282 */       return paramString;
/*      */     }
/*      */     
/* 9285 */     int j = paramString.codePointAt(0);
/* 9286 */     int k = Character.toLowerCase(j);
/* 9287 */     if (j == k)
/*      */     {
/* 9289 */       return paramString;
/*      */     }
/*      */     
/* 9292 */     int[] arrayOfInt = new int[i];
/* 9293 */     byte b = 0;
/* 9294 */     arrayOfInt[b++] = k; int m;
/* 9295 */     for (m = Character.charCount(j); m < i; ) {
/* 9296 */       int n = paramString.codePointAt(m);
/* 9297 */       arrayOfInt[b++] = n;
/* 9298 */       m += Character.charCount(n);
/*      */     } 
/* 9300 */     return new String(arrayOfInt, 0, b);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String unwrap(String paramString, char paramChar) {
/* 9330 */     if (isEmpty(paramString) || paramChar == '\000' || paramString.length() == 1) {
/* 9331 */       return paramString;
/*      */     }
/*      */     
/* 9334 */     if (paramString.charAt(0) == paramChar && paramString.charAt(paramString.length() - 1) == paramChar) {
/* 9335 */       boolean bool = false;
/* 9336 */       int i = paramString.length() - 1;
/*      */       
/* 9338 */       return paramString.substring(1, i);
/*      */     } 
/*      */     
/* 9341 */     return paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String unwrap(String paramString1, String paramString2) {
/* 9372 */     if (isEmpty(paramString1) || isEmpty(paramString2) || paramString1.length() == 1) {
/* 9373 */       return paramString1;
/*      */     }
/*      */     
/* 9376 */     if (startsWith(paramString1, paramString2) && endsWith(paramString1, paramString2)) {
/* 9377 */       int i = paramString1.indexOf(paramString2);
/* 9378 */       int j = paramString1.lastIndexOf(paramString2);
/* 9379 */       int k = paramString2.length();
/*      */       
/* 9381 */       if (i != -1 && j != -1) {
/* 9382 */         return paramString1.substring(i + k, j);
/*      */       }
/*      */     } 
/*      */     
/* 9386 */     return paramString1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String upperCase(String paramString) {
/* 9411 */     if (paramString == null) {
/* 9412 */       return null;
/*      */     }
/* 9414 */     return paramString.toUpperCase();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String upperCase(String paramString, Locale paramLocale) {
/* 9434 */     if (paramString == null) {
/* 9435 */       return null;
/*      */     }
/* 9437 */     return paramString.toUpperCase(paramLocale);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String valueOf(char[] paramArrayOfchar) {
/* 9449 */     return (paramArrayOfchar == null) ? null : String.valueOf(paramArrayOfchar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String wrap(String paramString, char paramChar) {
/* 9475 */     if (isEmpty(paramString) || paramChar == '\000') {
/* 9476 */       return paramString;
/*      */     }
/*      */     
/* 9479 */     return paramChar + paramString + paramChar;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String wrap(String paramString1, String paramString2) {
/* 9513 */     if (isEmpty(paramString1) || isEmpty(paramString2)) {
/* 9514 */       return paramString1;
/*      */     }
/*      */     
/* 9517 */     return paramString2.concat(paramString1).concat(paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String wrapIfMissing(String paramString, char paramChar) {
/* 9548 */     if (isEmpty(paramString) || paramChar == '\000') {
/* 9549 */       return paramString;
/*      */     }
/* 9551 */     boolean bool1 = (paramString.charAt(0) != paramChar) ? true : false;
/* 9552 */     boolean bool2 = (paramString.charAt(paramString.length() - 1) != paramChar) ? true : false;
/* 9553 */     if (!bool1 && !bool2) {
/* 9554 */       return paramString;
/*      */     }
/*      */     
/* 9557 */     StringBuilder stringBuilder = new StringBuilder(paramString.length() + 2);
/* 9558 */     if (bool1) {
/* 9559 */       stringBuilder.append(paramChar);
/*      */     }
/* 9561 */     stringBuilder.append(paramString);
/* 9562 */     if (bool2) {
/* 9563 */       stringBuilder.append(paramChar);
/*      */     }
/* 9565 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String wrapIfMissing(String paramString1, String paramString2) {
/* 9600 */     if (isEmpty(paramString1) || isEmpty(paramString2)) {
/* 9601 */       return paramString1;
/*      */     }
/*      */     
/* 9604 */     boolean bool1 = !paramString1.startsWith(paramString2) ? true : false;
/* 9605 */     boolean bool2 = !paramString1.endsWith(paramString2) ? true : false;
/* 9606 */     if (!bool1 && !bool2) {
/* 9607 */       return paramString1;
/*      */     }
/*      */     
/* 9610 */     StringBuilder stringBuilder = new StringBuilder(paramString1.length() + paramString2.length() + paramString2.length());
/* 9611 */     if (bool1) {
/* 9612 */       stringBuilder.append(paramString2);
/*      */     }
/* 9614 */     stringBuilder.append(paramString1);
/* 9615 */     if (bool2) {
/* 9616 */       stringBuilder.append(paramString2);
/*      */     }
/* 9618 */     return stringBuilder.toString();
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\StringUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */