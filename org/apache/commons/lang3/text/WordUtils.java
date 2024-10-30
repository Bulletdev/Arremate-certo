/*     */ package org.apache.commons.lang3.text;
/*     */ 
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.apache.commons.lang3.ArrayUtils;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ public class WordUtils
/*     */ {
/*     */   public static String wrap(String paramString, int paramInt) {
/* 104 */     return wrap(paramString, paramInt, null, false);
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
/*     */   public static String wrap(String paramString1, int paramInt, String paramString2, boolean paramBoolean) {
/* 181 */     return wrap(paramString1, paramInt, paramString2, paramBoolean, " ");
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
/*     */   public static String wrap(String paramString1, int paramInt, String paramString2, boolean paramBoolean, String paramString3) {
/* 275 */     if (paramString1 == null) {
/* 276 */       return null;
/*     */     }
/* 278 */     if (paramString2 == null) {
/* 279 */       paramString2 = System.lineSeparator();
/*     */     }
/* 281 */     if (paramInt < 1) {
/* 282 */       paramInt = 1;
/*     */     }
/* 284 */     if (StringUtils.isBlank(paramString3)) {
/* 285 */       paramString3 = " ";
/*     */     }
/* 287 */     Pattern pattern = Pattern.compile(paramString3);
/* 288 */     int i = paramString1.length();
/* 289 */     int j = 0;
/* 290 */     StringBuilder stringBuilder = new StringBuilder(i + 32);
/*     */     
/* 292 */     while (j < i) {
/* 293 */       int k = -1;
/* 294 */       Matcher matcher = pattern.matcher(paramString1
/* 295 */           .substring(j, Math.min((int)Math.min(2147483647L, (j + paramInt) + 1L), i)));
/* 296 */       if (matcher.find()) {
/* 297 */         if (matcher.start() == 0) {
/* 298 */           j += matcher.end();
/*     */           continue;
/*     */         } 
/* 301 */         k = matcher.start() + j;
/*     */       } 
/*     */ 
/*     */       
/* 305 */       if (i - j <= paramInt) {
/*     */         break;
/*     */       }
/*     */       
/* 309 */       while (matcher.find()) {
/* 310 */         k = matcher.start() + j;
/*     */       }
/*     */       
/* 313 */       if (k >= j) {
/*     */         
/* 315 */         stringBuilder.append(paramString1, j, k);
/* 316 */         stringBuilder.append(paramString2);
/* 317 */         j = k + 1;
/*     */         
/*     */         continue;
/*     */       } 
/* 321 */       if (paramBoolean) {
/*     */         
/* 323 */         stringBuilder.append(paramString1, j, paramInt + j);
/* 324 */         stringBuilder.append(paramString2);
/* 325 */         j += paramInt;
/*     */         continue;
/*     */       } 
/* 328 */       matcher = pattern.matcher(paramString1.substring(j + paramInt));
/* 329 */       if (matcher.find()) {
/* 330 */         k = matcher.start() + j + paramInt;
/*     */       }
/*     */       
/* 333 */       if (k >= 0) {
/* 334 */         stringBuilder.append(paramString1, j, k);
/* 335 */         stringBuilder.append(paramString2);
/* 336 */         j = k + 1; continue;
/*     */       } 
/* 338 */       stringBuilder.append(paramString1, j, paramString1.length());
/* 339 */       j = i;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 346 */     stringBuilder.append(paramString1, j, paramString1.length());
/*     */     
/* 348 */     return stringBuilder.toString();
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
/* 376 */     return capitalize(paramString, null);
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
/* 409 */     boolean bool1 = (paramVarArgs == null) ? true : paramVarArgs.length;
/* 410 */     if (StringUtils.isEmpty(paramString) || !bool1) {
/* 411 */       return paramString;
/*     */     }
/* 413 */     char[] arrayOfChar = paramString.toCharArray();
/* 414 */     boolean bool2 = true;
/* 415 */     for (byte b = 0; b < arrayOfChar.length; b++) {
/* 416 */       char c = arrayOfChar[b];
/* 417 */       if (isDelimiter(c, paramVarArgs)) {
/* 418 */         bool2 = true;
/* 419 */       } else if (bool2) {
/* 420 */         arrayOfChar[b] = Character.toTitleCase(c);
/* 421 */         bool2 = false;
/*     */       } 
/*     */     } 
/* 424 */     return new String(arrayOfChar);
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
/* 448 */     return capitalizeFully(paramString, null);
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
/*     */   public static String capitalizeFully(String paramString, char... paramVarArgs) {
/* 478 */     boolean bool = (paramVarArgs == null) ? true : paramVarArgs.length;
/* 479 */     if (StringUtils.isEmpty(paramString) || !bool) {
/* 480 */       return paramString;
/*     */     }
/* 482 */     paramString = paramString.toLowerCase();
/* 483 */     return capitalize(paramString, paramVarArgs);
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
/* 505 */     return uncapitalize(paramString, null);
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
/* 534 */     boolean bool1 = (paramVarArgs == null) ? true : paramVarArgs.length;
/* 535 */     if (StringUtils.isEmpty(paramString) || !bool1) {
/* 536 */       return paramString;
/*     */     }
/* 538 */     char[] arrayOfChar = paramString.toCharArray();
/* 539 */     boolean bool2 = true;
/* 540 */     for (byte b = 0; b < arrayOfChar.length; b++) {
/* 541 */       char c = arrayOfChar[b];
/* 542 */       if (isDelimiter(c, paramVarArgs)) {
/* 543 */         bool2 = true;
/* 544 */       } else if (bool2) {
/* 545 */         arrayOfChar[b] = Character.toLowerCase(c);
/* 546 */         bool2 = false;
/*     */       } 
/*     */     } 
/* 549 */     return new String(arrayOfChar);
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
/* 576 */     if (StringUtils.isEmpty(paramString)) {
/* 577 */       return paramString;
/*     */     }
/* 579 */     char[] arrayOfChar = paramString.toCharArray();
/*     */     
/* 581 */     boolean bool = true;
/*     */     
/* 583 */     for (byte b = 0; b < arrayOfChar.length; b++) {
/* 584 */       char c = arrayOfChar[b];
/* 585 */       if (Character.isUpperCase(c) || Character.isTitleCase(c)) {
/* 586 */         arrayOfChar[b] = Character.toLowerCase(c);
/* 587 */         bool = false;
/* 588 */       } else if (Character.isLowerCase(c)) {
/* 589 */         if (bool) {
/* 590 */           arrayOfChar[b] = Character.toTitleCase(c);
/* 591 */           bool = false;
/*     */         } else {
/* 593 */           arrayOfChar[b] = Character.toUpperCase(c);
/*     */         } 
/*     */       } else {
/* 596 */         bool = Character.isWhitespace(c);
/*     */       } 
/*     */     } 
/* 599 */     return new String(arrayOfChar);
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
/*     */   public static String initials(String paramString) {
/* 625 */     return initials(paramString, null);
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
/*     */   public static String initials(String paramString, char... paramVarArgs) {
/* 655 */     if (StringUtils.isEmpty(paramString)) {
/* 656 */       return paramString;
/*     */     }
/* 658 */     if (paramVarArgs != null && paramVarArgs.length == 0) {
/* 659 */       return "";
/*     */     }
/* 661 */     int i = paramString.length();
/* 662 */     char[] arrayOfChar = new char[i / 2 + 1];
/* 663 */     byte b1 = 0;
/* 664 */     boolean bool = true;
/* 665 */     for (byte b2 = 0; b2 < i; b2++) {
/* 666 */       char c = paramString.charAt(b2);
/*     */       
/* 668 */       if (isDelimiter(c, paramVarArgs)) {
/* 669 */         bool = true;
/* 670 */       } else if (bool) {
/* 671 */         arrayOfChar[b1++] = c;
/* 672 */         bool = false;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 677 */     return new String(arrayOfChar, 0, b1);
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
/*     */   public static boolean containsAllWords(CharSequence paramCharSequence, CharSequence... paramVarArgs) {
/* 705 */     if (StringUtils.isEmpty(paramCharSequence) || ArrayUtils.isEmpty((Object[])paramVarArgs)) {
/* 706 */       return false;
/*     */     }
/* 708 */     for (CharSequence charSequence : paramVarArgs) {
/* 709 */       if (StringUtils.isBlank(charSequence)) {
/* 710 */         return false;
/*     */       }
/* 712 */       Pattern pattern = Pattern.compile(".*\\b" + charSequence + "\\b.*");
/* 713 */       if (!pattern.matcher(paramCharSequence).matches()) {
/* 714 */         return false;
/*     */       }
/*     */     } 
/* 717 */     return true;
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
/*     */   private static boolean isDelimiter(char paramChar, char[] paramArrayOfchar) {
/* 729 */     if (paramArrayOfchar == null) {
/* 730 */       return Character.isWhitespace(paramChar);
/*     */     }
/* 732 */     for (char c : paramArrayOfchar) {
/* 733 */       if (paramChar == c) {
/* 734 */         return true;
/*     */       }
/*     */     } 
/* 737 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\text\WordUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */