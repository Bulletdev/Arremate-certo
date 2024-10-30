/*     */ package org.apache.commons.text;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.apache.commons.lang3.ArrayUtils;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.commons.lang3.Validate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WordUtils
/*     */ {
/*     */   public static String wrap(String paramString, int paramInt) {
/* 106 */     return wrap(paramString, paramInt, null, false);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String wrap(String paramString1, int paramInt, String paramString2, boolean paramBoolean) {
/* 188 */     return wrap(paramString1, paramInt, paramString2, paramBoolean, " ");
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String wrap(String paramString1, int paramInt, String paramString2, boolean paramBoolean, String paramString3) {
/* 288 */     if (paramString1 == null) {
/* 289 */       return null;
/*     */     }
/* 291 */     if (paramString2 == null) {
/* 292 */       paramString2 = System.lineSeparator();
/*     */     }
/* 294 */     if (paramInt < 1) {
/* 295 */       paramInt = 1;
/*     */     }
/* 297 */     if (StringUtils.isBlank(paramString3)) {
/* 298 */       paramString3 = " ";
/*     */     }
/* 300 */     Pattern pattern = Pattern.compile(paramString3);
/* 301 */     int i = paramString1.length();
/* 302 */     int j = 0;
/* 303 */     StringBuilder stringBuilder = new StringBuilder(i + 32);
/* 304 */     int k = -1;
/*     */     
/* 306 */     while (j < i) {
/* 307 */       int m = -1;
/* 308 */       Matcher matcher = pattern.matcher(paramString1.substring(j, 
/* 309 */             Math.min((int)Math.min(2147483647L, (j + paramInt) + 1L), i)));
/* 310 */       if (matcher.find()) {
/* 311 */         if (matcher.start() == 0) {
/* 312 */           k = matcher.end() - matcher.start();
/* 313 */           if (k != 0) {
/* 314 */             j += matcher.end();
/*     */             continue;
/*     */           } 
/* 317 */           j++;
/*     */         } 
/* 319 */         m = matcher.start() + j;
/*     */       } 
/*     */ 
/*     */       
/* 323 */       if (i - j <= paramInt) {
/*     */         break;
/*     */       }
/*     */       
/* 327 */       while (matcher.find()) {
/* 328 */         m = matcher.start() + j;
/*     */       }
/*     */       
/* 331 */       if (m >= j) {
/*     */         
/* 333 */         stringBuilder.append(paramString1, j, m);
/* 334 */         stringBuilder.append(paramString2);
/* 335 */         j = m + 1;
/*     */         
/*     */         continue;
/*     */       } 
/* 339 */       if (paramBoolean) {
/* 340 */         if (k == 0) {
/* 341 */           j--;
/*     */         }
/*     */         
/* 344 */         stringBuilder.append(paramString1, j, paramInt + j);
/* 345 */         stringBuilder.append(paramString2);
/* 346 */         j += paramInt;
/* 347 */         k = -1;
/*     */         continue;
/*     */       } 
/* 350 */       matcher = pattern.matcher(paramString1.substring(j + paramInt));
/* 351 */       if (matcher.find()) {
/* 352 */         k = matcher.end() - matcher.start();
/* 353 */         m = matcher.start() + j + paramInt;
/*     */       } 
/*     */       
/* 356 */       if (m >= 0) {
/* 357 */         if (k == 0 && j != 0) {
/* 358 */           j--;
/*     */         }
/* 360 */         stringBuilder.append(paramString1, j, m);
/* 361 */         stringBuilder.append(paramString2);
/* 362 */         j = m + 1; continue;
/*     */       } 
/* 364 */       if (k == 0 && j != 0) {
/* 365 */         j--;
/*     */       }
/* 367 */       stringBuilder.append(paramString1, j, paramString1.length());
/* 368 */       j = i;
/* 369 */       k = -1;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 375 */     if (k == 0 && j < i) {
/* 376 */       j--;
/*     */     }
/*     */ 
/*     */     
/* 380 */     stringBuilder.append(paramString1, j, paramString1.length());
/*     */     
/* 382 */     return stringBuilder.toString();
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
/*     */   public static String capitalize(String paramString) {
/* 410 */     return capitalize(paramString, null);
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
/*     */   public static String capitalize(String paramString, char... paramVarArgs) {
/* 443 */     if (StringUtils.isEmpty(paramString)) {
/* 444 */       return paramString;
/*     */     }
/* 446 */     Set<Integer> set = generateDelimiterSet(paramVarArgs);
/* 447 */     int i = paramString.length();
/* 448 */     int[] arrayOfInt = new int[i];
/* 449 */     byte b = 0;
/*     */     
/* 451 */     boolean bool = true; int j;
/* 452 */     for (j = 0; j < i; ) {
/* 453 */       int k = paramString.codePointAt(j);
/*     */       
/* 455 */       if (set.contains(Integer.valueOf(k))) {
/* 456 */         bool = true;
/* 457 */         arrayOfInt[b++] = k;
/* 458 */         j += Character.charCount(k); continue;
/* 459 */       }  if (bool) {
/* 460 */         int m = Character.toTitleCase(k);
/* 461 */         arrayOfInt[b++] = m;
/* 462 */         j += Character.charCount(m);
/* 463 */         bool = false; continue;
/*     */       } 
/* 465 */       arrayOfInt[b++] = k;
/* 466 */       j += Character.charCount(k);
/*     */     } 
/*     */     
/* 469 */     return new String(arrayOfInt, 0, b);
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
/*     */   public static String capitalizeFully(String paramString) {
/* 493 */     return capitalizeFully(paramString, null);
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
/*     */   public static String capitalizeFully(String paramString, char... paramVarArgs) {
/* 522 */     if (StringUtils.isEmpty(paramString)) {
/* 523 */       return paramString;
/*     */     }
/* 525 */     paramString = paramString.toLowerCase();
/* 526 */     return capitalize(paramString, paramVarArgs);
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
/*     */   public static String uncapitalize(String paramString) {
/* 548 */     return uncapitalize(paramString, null);
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
/*     */   public static String uncapitalize(String paramString, char... paramVarArgs) {
/* 577 */     if (StringUtils.isEmpty(paramString)) {
/* 578 */       return paramString;
/*     */     }
/* 580 */     Set<Integer> set = generateDelimiterSet(paramVarArgs);
/* 581 */     int i = paramString.length();
/* 582 */     int[] arrayOfInt = new int[i];
/* 583 */     byte b = 0;
/*     */     
/* 585 */     boolean bool = true; int j;
/* 586 */     for (j = 0; j < i; ) {
/* 587 */       int k = paramString.codePointAt(j);
/*     */       
/* 589 */       if (set.contains(Integer.valueOf(k))) {
/* 590 */         bool = true;
/* 591 */         arrayOfInt[b++] = k;
/* 592 */         j += Character.charCount(k); continue;
/* 593 */       }  if (bool) {
/* 594 */         int m = Character.toLowerCase(k);
/* 595 */         arrayOfInt[b++] = m;
/* 596 */         j += Character.charCount(m);
/* 597 */         bool = false; continue;
/*     */       } 
/* 599 */       arrayOfInt[b++] = k;
/* 600 */       j += Character.charCount(k);
/*     */     } 
/*     */     
/* 603 */     return new String(arrayOfInt, 0, b);
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
/*     */   public static String swapCase(String paramString) {
/* 630 */     if (StringUtils.isEmpty(paramString)) {
/* 631 */       return paramString;
/*     */     }
/* 633 */     int i = paramString.length();
/* 634 */     int[] arrayOfInt = new int[i];
/* 635 */     byte b = 0;
/* 636 */     boolean bool = true; int j;
/* 637 */     for (j = 0; j < i; ) {
/* 638 */       int m, k = paramString.codePointAt(j);
/*     */       
/* 640 */       if (Character.isUpperCase(k) || Character.isTitleCase(k)) {
/* 641 */         m = Character.toLowerCase(k);
/* 642 */         bool = false;
/* 643 */       } else if (Character.isLowerCase(k)) {
/* 644 */         if (bool) {
/* 645 */           m = Character.toTitleCase(k);
/* 646 */           bool = false;
/*     */         } else {
/* 648 */           m = Character.toUpperCase(k);
/*     */         } 
/*     */       } else {
/* 651 */         bool = Character.isWhitespace(k);
/* 652 */         m = k;
/*     */       } 
/* 654 */       arrayOfInt[b++] = m;
/* 655 */       j += Character.charCount(m);
/*     */     } 
/* 657 */     return new String(arrayOfInt, 0, b);
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
/*     */   public static String initials(String paramString) {
/* 682 */     return initials(paramString, null);
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
/*     */   public static String initials(String paramString, char... paramVarArgs) {
/* 711 */     if (StringUtils.isEmpty(paramString)) {
/* 712 */       return paramString;
/*     */     }
/* 714 */     if (paramVarArgs != null && paramVarArgs.length == 0) {
/* 715 */       return "";
/*     */     }
/* 717 */     Set<Integer> set = generateDelimiterSet(paramVarArgs);
/* 718 */     int i = paramString.length();
/* 719 */     int[] arrayOfInt = new int[i / 2 + 1];
/* 720 */     byte b = 0;
/* 721 */     boolean bool = true; int j;
/* 722 */     for (j = 0; j < i; ) {
/* 723 */       int k = paramString.codePointAt(j);
/*     */       
/* 725 */       if (set.contains(Integer.valueOf(k)) || (paramVarArgs == null && Character.isWhitespace(k))) {
/* 726 */         bool = true;
/* 727 */       } else if (bool) {
/* 728 */         arrayOfInt[b++] = k;
/* 729 */         bool = false;
/*     */       } 
/*     */       
/* 732 */       j += Character.charCount(k);
/*     */     } 
/* 734 */     return new String(arrayOfInt, 0, b);
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
/*     */   public static boolean containsAllWords(CharSequence paramCharSequence, CharSequence... paramVarArgs) {
/* 760 */     if (StringUtils.isEmpty(paramCharSequence) || ArrayUtils.isEmpty((Object[])paramVarArgs)) {
/* 761 */       return false;
/*     */     }
/* 763 */     for (CharSequence charSequence : paramVarArgs) {
/* 764 */       if (StringUtils.isBlank(charSequence)) {
/* 765 */         return false;
/*     */       }
/* 767 */       Pattern pattern = Pattern.compile(".*\\b" + charSequence + "\\b.*");
/* 768 */       if (!pattern.matcher(paramCharSequence).matches()) {
/* 769 */         return false;
/*     */       }
/*     */     } 
/* 772 */     return true;
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
/*     */   @Deprecated
/*     */   public static boolean isDelimiter(char paramChar, char[] paramArrayOfchar) {
/* 786 */     if (paramArrayOfchar == null) {
/* 787 */       return Character.isWhitespace(paramChar);
/*     */     }
/* 789 */     for (char c : paramArrayOfchar) {
/* 790 */       if (paramChar == c) {
/* 791 */         return true;
/*     */       }
/*     */     } 
/* 794 */     return false;
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
/*     */   @Deprecated
/*     */   public static boolean isDelimiter(int paramInt, char[] paramArrayOfchar) {
/* 808 */     if (paramArrayOfchar == null) {
/* 809 */       return Character.isWhitespace(paramInt);
/*     */     }
/* 811 */     for (byte b = 0; b < paramArrayOfchar.length; b++) {
/* 812 */       int i = Character.codePointAt(paramArrayOfchar, b);
/* 813 */       if (i == paramInt) {
/* 814 */         return true;
/*     */       }
/*     */     } 
/* 817 */     return false;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String abbreviate(String paramString1, int paramInt1, int paramInt2, String paramString2) {
/* 860 */     Validate.isTrue((paramInt2 >= -1), "upper value cannot be less than -1", new Object[0]);
/* 861 */     Validate.isTrue((paramInt2 >= paramInt1 || paramInt2 == -1), "upper value is less than lower value", new Object[0]);
/*     */     
/* 863 */     if (StringUtils.isEmpty(paramString1)) {
/* 864 */       return paramString1;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 869 */     if (paramInt1 > paramString1.length()) {
/* 870 */       paramInt1 = paramString1.length();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 875 */     if (paramInt2 == -1 || paramInt2 > paramString1.length()) {
/* 876 */       paramInt2 = paramString1.length();
/*     */     }
/*     */     
/* 879 */     StringBuilder stringBuilder = new StringBuilder();
/* 880 */     int i = StringUtils.indexOf(paramString1, " ", paramInt1);
/* 881 */     if (i == -1) {
/* 882 */       stringBuilder.append(paramString1, 0, paramInt2);
/*     */       
/* 884 */       if (paramInt2 != paramString1.length()) {
/* 885 */         stringBuilder.append(StringUtils.defaultString(paramString2));
/*     */       }
/* 887 */     } else if (i > paramInt2) {
/* 888 */       stringBuilder.append(paramString1, 0, paramInt2);
/* 889 */       stringBuilder.append(StringUtils.defaultString(paramString2));
/*     */     } else {
/* 891 */       stringBuilder.append(paramString1, 0, i);
/* 892 */       stringBuilder.append(StringUtils.defaultString(paramString2));
/*     */     } 
/*     */     
/* 895 */     return stringBuilder.toString();
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
/*     */   private static Set<Integer> generateDelimiterSet(char[] paramArrayOfchar) {
/* 909 */     HashSet<Integer> hashSet = new HashSet();
/* 910 */     if (paramArrayOfchar == null || paramArrayOfchar.length == 0) {
/* 911 */       if (paramArrayOfchar == null) {
/* 912 */         hashSet.add(Integer.valueOf(Character.codePointAt(new char[] { ' ' }, 0)));
/*     */       }
/*     */       
/* 915 */       return hashSet;
/*     */     } 
/*     */     
/* 918 */     for (byte b = 0; b < paramArrayOfchar.length; b++) {
/* 919 */       hashSet.add(Integer.valueOf(Character.codePointAt(paramArrayOfchar, b)));
/*     */     }
/* 921 */     return hashSet;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\WordUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */