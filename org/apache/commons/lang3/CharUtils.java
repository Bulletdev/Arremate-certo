/*     */ package org.apache.commons.lang3;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CharUtils
/*     */ {
/*  31 */   private static final String[] CHAR_STRING_ARRAY = new String[128];
/*     */   
/*  33 */   private static final char[] HEX_DIGITS = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final char LF = '\n';
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final char CR = '\r';
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final char NUL = '\000';
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*  61 */     for (char c = Character.MIN_VALUE; c < CHAR_STRING_ARRAY.length; c = (char)(c + 1)) {
/*  62 */       CHAR_STRING_ARRAY[c] = String.valueOf(c);
/*     */     }
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
/*     */   @Deprecated
/*     */   public static Character toCharacterObject(char paramChar) {
/*  95 */     return Character.valueOf(paramChar);
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
/*     */   public static Character toCharacterObject(String paramString) {
/* 116 */     if (StringUtils.isEmpty(paramString)) {
/* 117 */       return null;
/*     */     }
/* 119 */     return Character.valueOf(paramString.charAt(0));
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
/*     */   public static char toChar(Character paramCharacter) {
/* 137 */     Validate.notNull(paramCharacter, "The Character must not be null", new Object[0]);
/* 138 */     return paramCharacter.charValue();
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
/*     */   public static char toChar(Character paramCharacter, char paramChar) {
/* 155 */     if (paramCharacter == null) {
/* 156 */       return paramChar;
/*     */     }
/* 158 */     return paramCharacter.charValue();
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
/*     */   public static char toChar(String paramString) {
/* 179 */     Validate.notEmpty(paramString, "The String must not be empty", new Object[0]);
/* 180 */     return paramString.charAt(0);
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
/*     */   public static char toChar(String paramString, char paramChar) {
/* 199 */     if (StringUtils.isEmpty(paramString)) {
/* 200 */       return paramChar;
/*     */     }
/* 202 */     return paramString.charAt(0);
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
/*     */   public static int toIntValue(char paramChar) {
/* 222 */     if (!isAsciiNumeric(paramChar)) {
/* 223 */       throw new IllegalArgumentException("The character " + paramChar + " is not in the range '0' - '9'");
/*     */     }
/* 225 */     return paramChar - 48;
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
/*     */   public static int toIntValue(char paramChar, int paramInt) {
/* 244 */     if (!isAsciiNumeric(paramChar)) {
/* 245 */       return paramInt;
/*     */     }
/* 247 */     return paramChar - 48;
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
/*     */   public static int toIntValue(Character paramCharacter) {
/* 268 */     Validate.notNull(paramCharacter, "The character must not be null", new Object[0]);
/* 269 */     return toIntValue(paramCharacter.charValue());
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
/*     */   public static int toIntValue(Character paramCharacter, int paramInt) {
/* 289 */     if (paramCharacter == null) {
/* 290 */       return paramInt;
/*     */     }
/* 292 */     return toIntValue(paramCharacter.charValue(), paramInt);
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
/*     */   public static String toString(char paramChar) {
/* 311 */     if (paramChar < '') {
/* 312 */       return CHAR_STRING_ARRAY[paramChar];
/*     */     }
/* 314 */     return new String(new char[] { paramChar });
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
/*     */   public static String toString(Character paramCharacter) {
/* 335 */     if (paramCharacter == null) {
/* 336 */       return null;
/*     */     }
/* 338 */     return toString(paramCharacter.charValue());
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
/*     */   public static String unicodeEscaped(char paramChar) {
/* 356 */     return "\\u" + HEX_DIGITS[paramChar >> 12 & 0xF] + HEX_DIGITS[paramChar >> 8 & 0xF] + HEX_DIGITS[paramChar >> 4 & 0xF] + HEX_DIGITS[paramChar & 0xF];
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
/*     */   public static String unicodeEscaped(Character paramCharacter) {
/* 380 */     if (paramCharacter == null) {
/* 381 */       return null;
/*     */     }
/* 383 */     return unicodeEscaped(paramCharacter.charValue());
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
/*     */   public static boolean isAscii(char paramChar) {
/* 403 */     return (paramChar < '');
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
/*     */   public static boolean isAsciiPrintable(char paramChar) {
/* 422 */     return (paramChar >= ' ' && paramChar < '');
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
/*     */   public static boolean isAsciiControl(char paramChar) {
/* 441 */     return (paramChar < ' ' || paramChar == '');
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
/*     */   public static boolean isAsciiAlpha(char paramChar) {
/* 460 */     return (isAsciiAlphaUpper(paramChar) || isAsciiAlphaLower(paramChar));
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
/*     */   public static boolean isAsciiAlphaUpper(char paramChar) {
/* 479 */     return (paramChar >= 'A' && paramChar <= 'Z');
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
/*     */   public static boolean isAsciiAlphaLower(char paramChar) {
/* 498 */     return (paramChar >= 'a' && paramChar <= 'z');
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
/*     */   public static boolean isAsciiNumeric(char paramChar) {
/* 517 */     return (paramChar >= '0' && paramChar <= '9');
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
/*     */   public static boolean isAsciiAlphanumeric(char paramChar) {
/* 536 */     return (isAsciiAlpha(paramChar) || isAsciiNumeric(paramChar));
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
/*     */   public static int compare(char paramChar1, char paramChar2) {
/* 550 */     return paramChar1 - paramChar2;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\CharUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */