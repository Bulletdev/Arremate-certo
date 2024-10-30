/*      */ package org.apache.commons.io;
/*      */ 
/*      */ import java.io.File;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayDeque;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Objects;
/*      */ import java.util.regex.Matcher;
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
/*      */ public class FilenameUtils
/*      */ {
/*   90 */   private static final String[] EMPTY_STRING_ARRAY = new String[0];
/*      */ 
/*      */ 
/*      */   
/*      */   private static final String EMPTY_STRING = "";
/*      */ 
/*      */ 
/*      */   
/*      */   private static final int NOT_FOUND = -1;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final char EXTENSION_SEPARATOR = '.';
/*      */ 
/*      */ 
/*      */   
/*  106 */   public static final String EXTENSION_SEPARATOR_STR = Character.toString('.');
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final char UNIX_SEPARATOR = '/';
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final char WINDOWS_SEPARATOR = '\\';
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  121 */   private static final char SYSTEM_SEPARATOR = File.separatorChar;
/*      */ 
/*      */   
/*      */   private static final char OTHER_SEPARATOR;
/*      */ 
/*      */   
/*      */   static {
/*  128 */     if (isSystemWindows()) {
/*  129 */       OTHER_SEPARATOR = '/';
/*      */     } else {
/*  131 */       OTHER_SEPARATOR = '\\';
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
/*      */   static boolean isSystemWindows() {
/*  149 */     return (SYSTEM_SEPARATOR == '\\');
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean isSeparator(char paramChar) {
/*  160 */     return (paramChar == '/' || paramChar == '\\');
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
/*      */   public static String normalize(String paramString) {
/*  205 */     return doNormalize(paramString, SYSTEM_SEPARATOR, true);
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
/*      */   public static String normalize(String paramString, boolean paramBoolean) {
/*  252 */     byte b = paramBoolean ? 47 : 92;
/*  253 */     return doNormalize(paramString, b, true);
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
/*      */   public static String normalizeNoEndSeparator(String paramString) {
/*  299 */     return doNormalize(paramString, SYSTEM_SEPARATOR, false);
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
/*      */   public static String normalizeNoEndSeparator(String paramString, boolean paramBoolean) {
/*  346 */     byte b = paramBoolean ? 47 : 92;
/*  347 */     return doNormalize(paramString, b, false);
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
/*      */   private static String doNormalize(String paramString, char paramChar, boolean paramBoolean) {
/*  359 */     if (paramString == null) {
/*  360 */       return null;
/*      */     }
/*      */     
/*  363 */     failIfNullBytePresent(paramString);
/*      */     
/*  365 */     int i = paramString.length();
/*  366 */     if (i == 0) {
/*  367 */       return paramString;
/*      */     }
/*  369 */     int j = getPrefixLength(paramString);
/*  370 */     if (j < 0) {
/*  371 */       return null;
/*      */     }
/*      */     
/*  374 */     char[] arrayOfChar = new char[i + 2];
/*  375 */     paramString.getChars(0, paramString.length(), arrayOfChar, 0);
/*      */ 
/*      */     
/*  378 */     char c = (paramChar == SYSTEM_SEPARATOR) ? OTHER_SEPARATOR : SYSTEM_SEPARATOR; byte b;
/*  379 */     for (b = 0; b < arrayOfChar.length; b++) {
/*  380 */       if (arrayOfChar[b] == c) {
/*  381 */         arrayOfChar[b] = paramChar;
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  386 */     b = 1;
/*  387 */     if (arrayOfChar[i - 1] != paramChar) {
/*  388 */       arrayOfChar[i++] = paramChar;
/*  389 */       b = 0;
/*      */     } 
/*      */     
/*      */     int k;
/*  393 */     for (k = j + 1; k < i; k++) {
/*  394 */       if (arrayOfChar[k] == paramChar && arrayOfChar[k - 1] == paramChar) {
/*  395 */         System.arraycopy(arrayOfChar, k, arrayOfChar, k - 1, i - k);
/*  396 */         i--;
/*  397 */         k--;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  402 */     for (k = j + 1; k < i; k++) {
/*  403 */       if (arrayOfChar[k] == paramChar && arrayOfChar[k - 1] == '.' && (k == j + 1 || arrayOfChar[k - 2] == paramChar)) {
/*      */         
/*  405 */         if (k == i - 1) {
/*  406 */           b = 1;
/*      */         }
/*  408 */         System.arraycopy(arrayOfChar, k + 1, arrayOfChar, k - 1, i - k);
/*  409 */         i -= 2;
/*  410 */         k--;
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  416 */     for (k = j + 2; k < i; k++) {
/*  417 */       if (arrayOfChar[k] == paramChar && arrayOfChar[k - 1] == '.' && arrayOfChar[k - 2] == '.' && (k == j + 2 || arrayOfChar[k - 3] == paramChar)) {
/*      */         
/*  419 */         if (k == j + 2) {
/*  420 */           return null;
/*      */         }
/*  422 */         if (k == i - 1) {
/*  423 */           b = 1;
/*      */         }
/*      */         
/*  426 */         int m = k - 4; while (true) { if (m >= j) {
/*  427 */             if (arrayOfChar[m] == paramChar) {
/*      */               
/*  429 */               System.arraycopy(arrayOfChar, k + 1, arrayOfChar, m + 1, i - k);
/*  430 */               i -= k - m;
/*  431 */               k = m + 1; break;
/*      */             } 
/*      */             m--;
/*      */             continue;
/*      */           } 
/*  436 */           System.arraycopy(arrayOfChar, k + 1, arrayOfChar, j, i - k);
/*  437 */           i -= k + 1 - j;
/*  438 */           k = j + 1; break; }
/*      */       
/*      */       } 
/*      */     } 
/*  442 */     if (i <= 0) {
/*  443 */       return "";
/*      */     }
/*  445 */     if (i <= j) {
/*  446 */       return new String(arrayOfChar, 0, i);
/*      */     }
/*  448 */     if (b != 0 && paramBoolean) {
/*  449 */       return new String(arrayOfChar, 0, i);
/*      */     }
/*  451 */     return new String(arrayOfChar, 0, i - 1);
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
/*      */   public static String concat(String paramString1, String paramString2) {
/*  496 */     int i = getPrefixLength(paramString2);
/*  497 */     if (i < 0) {
/*  498 */       return null;
/*      */     }
/*  500 */     if (i > 0) {
/*  501 */       return normalize(paramString2);
/*      */     }
/*  503 */     if (paramString1 == null) {
/*  504 */       return null;
/*      */     }
/*  506 */     int j = paramString1.length();
/*  507 */     if (j == 0) {
/*  508 */       return normalize(paramString2);
/*      */     }
/*  510 */     char c = paramString1.charAt(j - 1);
/*  511 */     if (isSeparator(c)) {
/*  512 */       return normalize(paramString1 + paramString2);
/*      */     }
/*  514 */     return normalize(paramString1 + '/' + paramString2);
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
/*      */   public static boolean directoryContains(String paramString1, String paramString2) throws IOException {
/*  544 */     if (paramString1 == null) {
/*  545 */       throw new IllegalArgumentException("Directory must not be null");
/*      */     }
/*      */     
/*  548 */     if (paramString2 == null) {
/*  549 */       return false;
/*      */     }
/*      */     
/*  552 */     if (IOCase.SYSTEM.checkEquals(paramString1, paramString2)) {
/*  553 */       return false;
/*      */     }
/*      */     
/*  556 */     return IOCase.SYSTEM.checkStartsWith(paramString2, paramString1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String separatorsToUnix(String paramString) {
/*  567 */     if (paramString == null || paramString.indexOf('\\') == -1) {
/*  568 */       return paramString;
/*      */     }
/*  570 */     return paramString.replace('\\', '/');
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String separatorsToWindows(String paramString) {
/*  580 */     if (paramString == null || paramString.indexOf('/') == -1) {
/*  581 */       return paramString;
/*      */     }
/*  583 */     return paramString.replace('/', '\\');
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String separatorsToSystem(String paramString) {
/*  593 */     if (paramString == null) {
/*  594 */       return null;
/*      */     }
/*  596 */     return isSystemWindows() ? separatorsToWindows(paramString) : separatorsToUnix(paramString);
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
/*      */   public static int getPrefixLength(String paramString) {
/*  639 */     if (paramString == null) {
/*  640 */       return -1;
/*      */     }
/*  642 */     int i = paramString.length();
/*  643 */     if (i == 0) {
/*  644 */       return 0;
/*      */     }
/*  646 */     char c1 = paramString.charAt(0);
/*  647 */     if (c1 == ':') {
/*  648 */       return -1;
/*      */     }
/*  650 */     if (i == 1) {
/*  651 */       if (c1 == '~') {
/*  652 */         return 2;
/*      */       }
/*  654 */       return isSeparator(c1) ? 1 : 0;
/*      */     } 
/*  656 */     if (c1 == '~') {
/*  657 */       int j = paramString.indexOf('/', 1);
/*  658 */       int k = paramString.indexOf('\\', 1);
/*  659 */       if (j == -1 && k == -1) {
/*  660 */         return i + 1;
/*      */       }
/*  662 */       j = (j == -1) ? k : j;
/*  663 */       k = (k == -1) ? j : k;
/*  664 */       return Math.min(j, k) + 1;
/*      */     } 
/*  666 */     char c2 = paramString.charAt(1);
/*  667 */     if (c2 == ':') {
/*  668 */       c1 = Character.toUpperCase(c1);
/*  669 */       if (c1 >= 'A' && c1 <= 'Z') {
/*  670 */         if (i == 2 || !isSeparator(paramString.charAt(2))) {
/*  671 */           return 2;
/*      */         }
/*  673 */         return 3;
/*  674 */       }  if (c1 == '/') {
/*  675 */         return 1;
/*      */       }
/*  677 */       return -1;
/*      */     } 
/*  679 */     if (isSeparator(c1) && isSeparator(c2)) {
/*  680 */       int j = paramString.indexOf('/', 2);
/*  681 */       int k = paramString.indexOf('\\', 2);
/*  682 */       if ((j == -1 && k == -1) || j == 2 || k == 2) {
/*  683 */         return -1;
/*      */       }
/*  685 */       j = (j == -1) ? k : j;
/*  686 */       k = (k == -1) ? j : k;
/*  687 */       int m = Math.min(j, k) + 1;
/*  688 */       String str = paramString.substring(2, m - 1);
/*  689 */       return isValidHostName(str) ? m : -1;
/*      */     } 
/*  691 */     return isSeparator(c1) ? 1 : 0;
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
/*      */   public static int indexOfLastSeparator(String paramString) {
/*  708 */     if (paramString == null) {
/*  709 */       return -1;
/*      */     }
/*  711 */     int i = paramString.lastIndexOf('/');
/*  712 */     int j = paramString.lastIndexOf('\\');
/*  713 */     return Math.max(i, j);
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
/*      */   public static int indexOfExtension(String paramString) throws IllegalArgumentException {
/*  739 */     if (paramString == null) {
/*  740 */       return -1;
/*      */     }
/*  742 */     if (isSystemWindows()) {
/*      */       
/*  744 */       int k = paramString.indexOf(':', getAdsCriticalOffset(paramString));
/*  745 */       if (k != -1) {
/*  746 */         throw new IllegalArgumentException("NTFS ADS separator (':') in file name is forbidden.");
/*      */       }
/*      */     } 
/*  749 */     int i = paramString.lastIndexOf('.');
/*  750 */     int j = indexOfLastSeparator(paramString);
/*  751 */     return (j > i) ? -1 : i;
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
/*      */   public static String getPrefix(String paramString) {
/*  785 */     if (paramString == null) {
/*  786 */       return null;
/*      */     }
/*  788 */     int i = getPrefixLength(paramString);
/*  789 */     if (i < 0) {
/*  790 */       return null;
/*      */     }
/*  792 */     if (i > paramString.length()) {
/*  793 */       failIfNullBytePresent(paramString + '/');
/*  794 */       return paramString + '/';
/*      */     } 
/*  796 */     String str = paramString.substring(0, i);
/*  797 */     failIfNullBytePresent(str);
/*  798 */     return str;
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
/*      */   public static String getPath(String paramString) {
/*  825 */     return doGetPath(paramString, 1);
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
/*      */   public static String getPathNoEndSeparator(String paramString) {
/*  853 */     return doGetPath(paramString, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String doGetPath(String paramString, int paramInt) {
/*  864 */     if (paramString == null) {
/*  865 */       return null;
/*      */     }
/*  867 */     int i = getPrefixLength(paramString);
/*  868 */     if (i < 0) {
/*  869 */       return null;
/*      */     }
/*  871 */     int j = indexOfLastSeparator(paramString);
/*  872 */     int k = j + paramInt;
/*  873 */     if (i >= paramString.length() || j < 0 || i >= k) {
/*  874 */       return "";
/*      */     }
/*  876 */     String str = paramString.substring(i, k);
/*  877 */     failIfNullBytePresent(str);
/*  878 */     return str;
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
/*      */   public static String getFullPath(String paramString) {
/*  907 */     return doGetFullPath(paramString, true);
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
/*      */   public static String getFullPathNoEndSeparator(String paramString) {
/*  937 */     return doGetFullPath(paramString, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String doGetFullPath(String paramString, boolean paramBoolean) {
/*  948 */     if (paramString == null) {
/*  949 */       return null;
/*      */     }
/*  951 */     int i = getPrefixLength(paramString);
/*  952 */     if (i < 0) {
/*  953 */       return null;
/*      */     }
/*  955 */     if (i >= paramString.length()) {
/*  956 */       if (paramBoolean) {
/*  957 */         return getPrefix(paramString);
/*      */       }
/*  959 */       return paramString;
/*      */     } 
/*  961 */     int j = indexOfLastSeparator(paramString);
/*  962 */     if (j < 0) {
/*  963 */       return paramString.substring(0, i);
/*      */     }
/*  965 */     int k = j + (paramBoolean ? 1 : 0);
/*  966 */     if (k == 0) {
/*  967 */       k++;
/*      */     }
/*  969 */     return paramString.substring(0, k);
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
/*      */   public static String getName(String paramString) {
/*  991 */     if (paramString == null) {
/*  992 */       return null;
/*      */     }
/*  994 */     failIfNullBytePresent(paramString);
/*  995 */     int i = indexOfLastSeparator(paramString);
/*  996 */     return paramString.substring(i + 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void failIfNullBytePresent(String paramString) {
/* 1006 */     int i = paramString.length();
/* 1007 */     for (byte b = 0; b < i; b++) {
/* 1008 */       if (paramString.charAt(b) == '\000') {
/* 1009 */         throw new IllegalArgumentException("Null byte present in file/path name. There are no known legitimate use cases for such data, but several injection attacks may use it");
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
/*      */   public static String getBaseName(String paramString) {
/* 1034 */     return removeExtension(getName(paramString));
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
/*      */   public static String getExtension(String paramString) throws IllegalArgumentException {
/* 1066 */     if (paramString == null) {
/* 1067 */       return null;
/*      */     }
/* 1069 */     int i = indexOfExtension(paramString);
/* 1070 */     if (i == -1) {
/* 1071 */       return "";
/*      */     }
/* 1073 */     return paramString.substring(i + 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int getAdsCriticalOffset(String paramString) {
/* 1084 */     int i = paramString.lastIndexOf(SYSTEM_SEPARATOR);
/* 1085 */     int j = paramString.lastIndexOf(OTHER_SEPARATOR);
/* 1086 */     if (i == -1) {
/* 1087 */       if (j == -1) {
/* 1088 */         return 0;
/*      */       }
/* 1090 */       return j + 1;
/*      */     } 
/* 1092 */     if (j == -1) {
/* 1093 */       return i + 1;
/*      */     }
/* 1095 */     return Math.max(i, j) + 1;
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
/*      */   public static String removeExtension(String paramString) {
/* 1117 */     if (paramString == null) {
/* 1118 */       return null;
/*      */     }
/* 1120 */     failIfNullBytePresent(paramString);
/*      */     
/* 1122 */     int i = indexOfExtension(paramString);
/* 1123 */     if (i == -1) {
/* 1124 */       return paramString;
/*      */     }
/* 1126 */     return paramString.substring(0, i);
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
/*      */   public static boolean equals(String paramString1, String paramString2) {
/* 1142 */     return equals(paramString1, paramString2, false, IOCase.SENSITIVE);
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
/*      */   public static boolean equalsOnSystem(String paramString1, String paramString2) {
/* 1157 */     return equals(paramString1, paramString2, false, IOCase.SYSTEM);
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
/*      */   public static boolean equalsNormalized(String paramString1, String paramString2) {
/* 1173 */     return equals(paramString1, paramString2, true, IOCase.SENSITIVE);
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
/*      */   public static boolean equalsNormalizedOnSystem(String paramString1, String paramString2) {
/* 1190 */     return equals(paramString1, paramString2, true, IOCase.SYSTEM);
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
/*      */   public static boolean equals(String paramString1, String paramString2, boolean paramBoolean, IOCase paramIOCase) {
/* 1208 */     if (paramString1 == null || paramString2 == null) {
/* 1209 */       return (paramString1 == null && paramString2 == null);
/*      */     }
/* 1211 */     if (paramBoolean) {
/* 1212 */       paramString1 = normalize(paramString1);
/* 1213 */       paramString2 = normalize(paramString2);
/* 1214 */       Objects.requireNonNull(paramString1, "Error normalizing one or both of the file names");
/* 1215 */       Objects.requireNonNull(paramString2, "Error normalizing one or both of the file names");
/*      */     } 
/* 1217 */     if (paramIOCase == null) {
/* 1218 */       paramIOCase = IOCase.SENSITIVE;
/*      */     }
/* 1220 */     return paramIOCase.checkEquals(paramString1, paramString2);
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
/*      */   public static boolean isExtension(String paramString1, String paramString2) {
/* 1237 */     if (paramString1 == null) {
/* 1238 */       return false;
/*      */     }
/* 1240 */     failIfNullBytePresent(paramString1);
/*      */     
/* 1242 */     if (paramString2 == null || paramString2.isEmpty()) {
/* 1243 */       return (indexOfExtension(paramString1) == -1);
/*      */     }
/* 1245 */     String str = getExtension(paramString1);
/* 1246 */     return str.equals(paramString2);
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
/*      */   public static boolean isExtension(String paramString, String... paramVarArgs) {
/* 1262 */     if (paramString == null) {
/* 1263 */       return false;
/*      */     }
/* 1265 */     failIfNullBytePresent(paramString);
/*      */     
/* 1267 */     if (paramVarArgs == null || paramVarArgs.length == 0) {
/* 1268 */       return (indexOfExtension(paramString) == -1);
/*      */     }
/* 1270 */     String str = getExtension(paramString);
/* 1271 */     for (String str1 : paramVarArgs) {
/* 1272 */       if (str.equals(str1)) {
/* 1273 */         return true;
/*      */       }
/*      */     } 
/* 1276 */     return false;
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
/*      */   public static boolean isExtension(String paramString, Collection<String> paramCollection) {
/* 1292 */     if (paramString == null) {
/* 1293 */       return false;
/*      */     }
/* 1295 */     failIfNullBytePresent(paramString);
/*      */     
/* 1297 */     if (paramCollection == null || paramCollection.isEmpty()) {
/* 1298 */       return (indexOfExtension(paramString) == -1);
/*      */     }
/* 1300 */     String str = getExtension(paramString);
/* 1301 */     for (String str1 : paramCollection) {
/* 1302 */       if (str.equals(str1)) {
/* 1303 */         return true;
/*      */       }
/*      */     } 
/* 1306 */     return false;
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
/*      */   public static boolean wildcardMatch(String paramString1, String paramString2) {
/* 1333 */     return wildcardMatch(paramString1, paramString2, IOCase.SENSITIVE);
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
/*      */   public static boolean wildcardMatchOnSystem(String paramString1, String paramString2) {
/* 1359 */     return wildcardMatch(paramString1, paramString2, IOCase.SYSTEM);
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
/*      */   public static boolean wildcardMatch(String paramString1, String paramString2, IOCase paramIOCase) {
/* 1377 */     if (paramString1 == null && paramString2 == null) {
/* 1378 */       return true;
/*      */     }
/* 1380 */     if (paramString1 == null || paramString2 == null) {
/* 1381 */       return false;
/*      */     }
/* 1383 */     if (paramIOCase == null) {
/* 1384 */       paramIOCase = IOCase.SENSITIVE;
/*      */     }
/* 1386 */     String[] arrayOfString = splitOnTokens(paramString2);
/* 1387 */     boolean bool = false;
/* 1388 */     int i = 0;
/* 1389 */     int j = 0;
/* 1390 */     ArrayDeque<int[]> arrayDeque = new ArrayDeque(arrayOfString.length);
/*      */ 
/*      */     
/*      */     do {
/* 1394 */       if (!arrayDeque.isEmpty()) {
/* 1395 */         int[] arrayOfInt = arrayDeque.pop();
/* 1396 */         j = arrayOfInt[0];
/* 1397 */         i = arrayOfInt[1];
/* 1398 */         bool = true;
/*      */       } 
/*      */ 
/*      */       
/* 1402 */       while (j < arrayOfString.length) {
/*      */         
/* 1404 */         if (arrayOfString[j].equals("?")) {
/*      */           
/* 1406 */           i++;
/* 1407 */           if (i > paramString1.length()) {
/*      */             break;
/*      */           }
/* 1410 */           bool = false;
/*      */         }
/* 1412 */         else if (arrayOfString[j].equals("*")) {
/*      */           
/* 1414 */           bool = true;
/* 1415 */           if (j == arrayOfString.length - 1) {
/* 1416 */             i = paramString1.length();
/*      */           }
/*      */         }
/*      */         else {
/*      */           
/* 1421 */           if (bool) {
/*      */             
/* 1423 */             i = paramIOCase.checkIndexOf(paramString1, i, arrayOfString[j]);
/* 1424 */             if (i == -1) {
/*      */               break;
/*      */             }
/*      */             
/* 1428 */             int k = paramIOCase.checkIndexOf(paramString1, i + 1, arrayOfString[j]);
/* 1429 */             if (k >= 0) {
/* 1430 */               arrayDeque.push(new int[] { j, k });
/*      */             
/*      */             }
/*      */           }
/* 1434 */           else if (!paramIOCase.checkRegionMatches(paramString1, i, arrayOfString[j])) {
/*      */             break;
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1441 */           i += arrayOfString[j].length();
/* 1442 */           bool = false;
/*      */         } 
/*      */         
/* 1445 */         j++;
/*      */       } 
/*      */ 
/*      */       
/* 1449 */       if (j == arrayOfString.length && i == paramString1.length()) {
/* 1450 */         return true;
/*      */       }
/*      */     }
/* 1453 */     while (!arrayDeque.isEmpty());
/*      */     
/* 1455 */     return false;
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
/*      */   static String[] splitOnTokens(String paramString) {
/* 1470 */     if (paramString.indexOf('?') == -1 && paramString.indexOf('*') == -1) {
/* 1471 */       return new String[] { paramString };
/*      */     }
/*      */     
/* 1474 */     char[] arrayOfChar = paramString.toCharArray();
/* 1475 */     ArrayList<String> arrayList = new ArrayList();
/* 1476 */     StringBuilder stringBuilder = new StringBuilder();
/* 1477 */     char c = Character.MIN_VALUE;
/* 1478 */     for (char c1 : arrayOfChar) {
/* 1479 */       if (c1 == '?' || c1 == '*') {
/* 1480 */         if (stringBuilder.length() != 0) {
/* 1481 */           arrayList.add(stringBuilder.toString());
/* 1482 */           stringBuilder.setLength(0);
/*      */         } 
/* 1484 */         if (c1 == '?') {
/* 1485 */           arrayList.add("?");
/* 1486 */         } else if (c != '*') {
/* 1487 */           arrayList.add("*");
/*      */         } 
/*      */       } else {
/* 1490 */         stringBuilder.append(c1);
/*      */       } 
/* 1492 */       c = c1;
/*      */     } 
/* 1494 */     if (stringBuilder.length() != 0) {
/* 1495 */       arrayList.add(stringBuilder.toString());
/*      */     }
/*      */     
/* 1498 */     return arrayList.<String>toArray(EMPTY_STRING_ARRAY);
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
/*      */   private static boolean isValidHostName(String paramString) {
/* 1514 */     return (isIPv6Address(paramString) || isRFC3986HostName(paramString));
/*      */   }
/*      */ 
/*      */   
/* 1518 */   private static final Pattern IPV4_PATTERN = Pattern.compile("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$");
/*      */   
/*      */   private static final int IPV4_MAX_OCTET_VALUE = 255;
/*      */   
/*      */   private static final int IPV6_MAX_HEX_GROUPS = 8;
/*      */   
/*      */   private static final int IPV6_MAX_HEX_DIGITS_PER_GROUP = 4;
/*      */   private static final int MAX_UNSIGNED_SHORT = 65535;
/*      */   private static final int BASE_16 = 16;
/*      */   
/*      */   private static boolean isIPv4Address(String paramString) {
/* 1529 */     Matcher matcher = IPV4_PATTERN.matcher(paramString);
/* 1530 */     if (!matcher.matches() || matcher.groupCount() != 4) {
/* 1531 */       return false;
/*      */     }
/*      */ 
/*      */     
/* 1535 */     for (byte b = 1; b <= 4; b++) {
/* 1536 */       String str = matcher.group(b);
/* 1537 */       int i = Integer.parseInt(str);
/* 1538 */       if (i > 255) {
/* 1539 */         return false;
/*      */       }
/*      */       
/* 1542 */       if (str.length() > 1 && str.startsWith("0")) {
/* 1543 */         return false;
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1548 */     return true;
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
/*      */   private static boolean isIPv6Address(String paramString) {
/* 1564 */     boolean bool = paramString.contains("::");
/* 1565 */     if (bool && paramString.indexOf("::") != paramString.lastIndexOf("::")) {
/* 1566 */       return false;
/*      */     }
/* 1568 */     if ((paramString.startsWith(":") && !paramString.startsWith("::")) || (paramString
/* 1569 */       .endsWith(":") && !paramString.endsWith("::"))) {
/* 1570 */       return false;
/*      */     }
/* 1572 */     String[] arrayOfString = paramString.split(":");
/* 1573 */     if (bool) {
/* 1574 */       ArrayList<String> arrayList = new ArrayList(Arrays.asList((Object[])arrayOfString));
/* 1575 */       if (paramString.endsWith("::")) {
/*      */         
/* 1577 */         arrayList.add("");
/* 1578 */       } else if (paramString.startsWith("::") && !arrayList.isEmpty()) {
/* 1579 */         arrayList.remove(0);
/*      */       } 
/* 1581 */       arrayOfString = arrayList.<String>toArray(EMPTY_STRING_ARRAY);
/*      */     } 
/* 1583 */     if (arrayOfString.length > 8) {
/* 1584 */       return false;
/*      */     }
/* 1586 */     byte b1 = 0;
/* 1587 */     byte b2 = 0;
/* 1588 */     byte b3 = 0; while (true) { if (b3 < arrayOfString.length)
/* 1589 */       { String str = arrayOfString[b3];
/* 1590 */         if (str.length() == 0)
/* 1591 */         { b2++;
/* 1592 */           if (b2 > 1) {
/* 1593 */             return false;
/*      */           } }
/*      */         else
/* 1596 */         { b2 = 0;
/*      */           
/* 1598 */           if (b3 == arrayOfString.length - 1 && str.contains("."))
/* 1599 */           { if (!isIPv4Address(str)) {
/* 1600 */               return false;
/*      */             }
/* 1602 */             b1 += true; }
/*      */           else
/*      */           
/* 1605 */           { if (str.length() > 4) {
/* 1606 */               return false;
/*      */             }
/* 1608 */             int i = 0;
/*      */             try {
/* 1610 */               i = Integer.parseInt(str, 16);
/* 1611 */             } catch (NumberFormatException numberFormatException) {
/* 1612 */               return false;
/*      */             } 
/* 1614 */             if (i < 0 || i > 65535) {
/* 1615 */               return false;
/*      */             }
/*      */             
/* 1618 */             b1++; }  b3++; }  } else { break; }  b1++; }
/*      */     
/* 1620 */     return (b1 <= 8 && (b1 >= 8 || bool));
/*      */   }
/*      */   
/* 1623 */   private static final Pattern REG_NAME_PART_PATTERN = Pattern.compile("^[a-zA-Z0-9][a-zA-Z0-9-]*$");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean isRFC3986HostName(String paramString) {
/* 1634 */     String[] arrayOfString = paramString.split("\\.", -1);
/* 1635 */     for (byte b = 0; b < arrayOfString.length; b++) {
/* 1636 */       if (arrayOfString[b].length() == 0)
/*      */       {
/* 1638 */         return (b == arrayOfString.length - 1);
/*      */       }
/* 1640 */       if (!REG_NAME_PART_PATTERN.matcher(arrayOfString[b]).matches()) {
/* 1641 */         return false;
/*      */       }
/*      */     } 
/* 1644 */     return true;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\FilenameUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */