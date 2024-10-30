/*     */ package org.h2.util;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.sql.Date;
/*     */ import java.sql.Timestamp;
/*     */ import java.text.DecimalFormat;
/*     */ import java.text.DecimalFormatSymbols;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Arrays;
/*     */ import java.util.Calendar;
/*     */ import java.util.Currency;
/*     */ import java.util.Date;
/*     */ import java.util.GregorianCalendar;
/*     */ import java.util.Locale;
/*     */ import java.util.TimeZone;
/*     */ import org.h2.message.DbException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ToChar
/*     */ {
/*     */   private static final long JULIAN_EPOCH;
/*     */   
/*     */   static {
/*  35 */     GregorianCalendar gregorianCalendar = new GregorianCalendar(Locale.ENGLISH);
/*  36 */     gregorianCalendar.setGregorianChange(new Date(Long.MAX_VALUE));
/*  37 */     gregorianCalendar.clear();
/*  38 */     gregorianCalendar.set(4713, 0, 1, 0, 0, 0);
/*  39 */     gregorianCalendar.set(0, 0);
/*  40 */     JULIAN_EPOCH = gregorianCalendar.getTimeInMillis();
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
/*     */   public static String toChar(BigDecimal paramBigDecimal, String paramString1, String paramString2) {
/*     */     Integer integer;
/* 129 */     String str1 = (paramString1 != null) ? paramString1.toUpperCase() : null;
/* 130 */     if (str1 == null || str1.equals("TM") || str1.equals("TM9")) {
/* 131 */       String str = paramBigDecimal.toPlainString();
/* 132 */       return str.startsWith("0.") ? str.substring(1) : str;
/* 133 */     }  if (str1.equals("TME")) {
/* 134 */       int i2 = paramBigDecimal.precision() - paramBigDecimal.scale() - 1;
/* 135 */       paramBigDecimal = paramBigDecimal.movePointLeft(i2);
/* 136 */       return paramBigDecimal.toPlainString() + "E" + ((i2 < 0) ? 45 : 43) + ((Math.abs(i2) < 10) ? "0" : "") + Math.abs(i2);
/*     */     } 
/* 138 */     if (str1.equals("RN")) {
/* 139 */       boolean bool5 = paramString1.startsWith("r");
/* 140 */       String str = StringUtils.pad(toRomanNumeral(paramBigDecimal.intValue()), 15, " ", false);
/* 141 */       return bool5 ? str.toLowerCase() : str;
/* 142 */     }  if (str1.equals("FMRN")) {
/* 143 */       boolean bool5 = (paramString1.charAt(2) == 'r') ? true : false;
/* 144 */       String str = toRomanNumeral(paramBigDecimal.intValue());
/* 145 */       return bool5 ? str.toLowerCase() : str;
/* 146 */     }  if (str1.endsWith("X")) {
/* 147 */       return toHex(paramBigDecimal, paramString1);
/*     */     }
/*     */     
/* 150 */     String str2 = paramString1;
/* 151 */     DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance();
/* 152 */     char c1 = decimalFormatSymbols.getGroupingSeparator();
/* 153 */     char c2 = decimalFormatSymbols.getDecimalSeparator();
/*     */     
/* 155 */     boolean bool1 = str1.startsWith("S");
/* 156 */     if (bool1) {
/* 157 */       paramString1 = paramString1.substring(1);
/*     */     }
/*     */     
/* 160 */     boolean bool2 = str1.endsWith("S");
/* 161 */     if (bool2) {
/* 162 */       paramString1 = paramString1.substring(0, paramString1.length() - 1);
/*     */     }
/*     */     
/* 165 */     boolean bool3 = str1.endsWith("MI");
/* 166 */     if (bool3) {
/* 167 */       paramString1 = paramString1.substring(0, paramString1.length() - 2);
/*     */     }
/*     */     
/* 170 */     boolean bool4 = str1.endsWith("PR");
/* 171 */     if (bool4) {
/* 172 */       paramString1 = paramString1.substring(0, paramString1.length() - 2);
/*     */     }
/*     */     
/* 175 */     int i = str1.indexOf("V");
/* 176 */     if (i >= 0) {
/* 177 */       byte b1 = 0;
/* 178 */       for (int i2 = i + 1; i2 < paramString1.length(); i2++) {
/* 179 */         char c = paramString1.charAt(i2);
/* 180 */         if (c == '0' || c == '9') {
/* 181 */           b1++;
/*     */         }
/*     */       } 
/* 184 */       paramBigDecimal = paramBigDecimal.movePointRight(b1);
/* 185 */       paramString1 = paramString1.substring(0, i) + paramString1.substring(i + 1);
/*     */     } 
/*     */ 
/*     */     
/* 189 */     if (paramString1.endsWith("EEEE")) {
/* 190 */       integer = Integer.valueOf(paramBigDecimal.precision() - paramBigDecimal.scale() - 1);
/* 191 */       paramBigDecimal = paramBigDecimal.movePointLeft(integer.intValue());
/* 192 */       paramString1 = paramString1.substring(0, paramString1.length() - 4);
/*     */     } else {
/* 194 */       integer = null;
/*     */     } 
/*     */     
/* 197 */     byte b = 1;
/* 198 */     boolean bool = !str1.startsWith("FM") ? true : false;
/* 199 */     if (!bool) {
/* 200 */       paramString1 = paramString1.substring(2);
/*     */     }
/*     */ 
/*     */     
/* 204 */     paramString1 = paramString1.replaceAll("[Bb]", "");
/*     */ 
/*     */ 
/*     */     
/* 208 */     int j = findDecimalSeparator(paramString1);
/* 209 */     int k = calculateScale(paramString1, j);
/* 210 */     if (k < paramBigDecimal.scale()) {
/* 211 */       paramBigDecimal = paramBigDecimal.setScale(k, 4);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 216 */     for (int m = paramString1.indexOf('0'); m >= 0 && m < j; m++) {
/* 217 */       if (paramString1.charAt(m) == '9') {
/* 218 */         paramString1 = paramString1.substring(0, m) + "0" + paramString1.substring(m + 1);
/*     */       }
/*     */     } 
/*     */     
/* 222 */     StringBuilder stringBuilder = new StringBuilder();
/* 223 */     String str3 = ((paramBigDecimal.abs().compareTo(BigDecimal.ONE) < 0) ? zeroesAfterDecimalSeparator(paramBigDecimal) : "") + paramBigDecimal.unscaledValue().abs().toString();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 229 */     int n = j - 1;
/* 230 */     int i1 = str3.length() - paramBigDecimal.scale() - 1;
/* 231 */     for (; n >= 0; n--) {
/* 232 */       char c = paramString1.charAt(n);
/* 233 */       b++;
/* 234 */       if (c == '9' || c == '0') {
/* 235 */         if (i1 >= 0) {
/* 236 */           char c3 = str3.charAt(i1);
/* 237 */           stringBuilder.insert(0, c3);
/* 238 */           i1--;
/* 239 */         } else if (c == '0' && integer == null) {
/* 240 */           stringBuilder.insert(0, '0');
/*     */         } 
/* 242 */       } else if (c == ',') {
/*     */         
/* 244 */         if (i1 >= 0 || (n > 0 && paramString1.charAt(n - 1) == '0')) {
/* 245 */           stringBuilder.insert(0, c);
/*     */         }
/* 247 */       } else if (c == 'G' || c == 'g') {
/*     */         
/* 249 */         if (i1 >= 0 || (n > 0 && paramString1.charAt(n - 1) == '0')) {
/* 250 */           stringBuilder.insert(0, c1);
/*     */         }
/* 252 */       } else if (c == 'C' || c == 'c') {
/* 253 */         Currency currency = Currency.getInstance(Locale.getDefault());
/* 254 */         stringBuilder.insert(0, currency.getCurrencyCode());
/* 255 */         b += 6;
/* 256 */       } else if (c == 'L' || c == 'l' || c == 'U' || c == 'u') {
/* 257 */         Currency currency = Currency.getInstance(Locale.getDefault());
/* 258 */         stringBuilder.insert(0, currency.getSymbol());
/* 259 */         b += 9;
/* 260 */       } else if (c == '$') {
/* 261 */         Currency currency = Currency.getInstance(Locale.getDefault());
/* 262 */         String str = currency.getSymbol();
/* 263 */         stringBuilder.insert(0, str);
/*     */       } else {
/* 265 */         throw DbException.get(90010, str2);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 272 */     if (i1 >= 0) {
/* 273 */       return StringUtils.pad("", paramString1.length() + 1, "#", true);
/*     */     }
/*     */     
/* 276 */     if (j < paramString1.length()) {
/*     */ 
/*     */       
/* 279 */       b++;
/* 280 */       char c = paramString1.charAt(j);
/* 281 */       if (c == 'd' || c == 'D') {
/* 282 */         stringBuilder.append(c2);
/*     */       } else {
/* 284 */         stringBuilder.append(c);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 289 */       n = j + 1;
/* 290 */       i1 = str3.length() - paramBigDecimal.scale();
/* 291 */       for (; n < paramString1.length(); n++) {
/* 292 */         char c3 = paramString1.charAt(n);
/* 293 */         b++;
/* 294 */         if (c3 == '9' || c3 == '0') {
/* 295 */           if (i1 < str3.length()) {
/* 296 */             char c4 = str3.charAt(i1);
/* 297 */             stringBuilder.append(c4);
/* 298 */             i1++;
/*     */           }
/* 300 */           else if (c3 == '0' || bool) {
/* 301 */             stringBuilder.append('0');
/*     */           } 
/*     */         } else {
/*     */           
/* 305 */           throw DbException.get(90010, str2);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 311 */     addSign(stringBuilder, paramBigDecimal.signum(), bool1, bool2, bool3, bool4, bool);
/*     */ 
/*     */     
/* 314 */     if (integer != null) {
/* 315 */       stringBuilder.append('E');
/* 316 */       stringBuilder.append((integer.intValue() < 0) ? 45 : 43);
/* 317 */       stringBuilder.append((Math.abs(integer.intValue()) < 10) ? "0" : "");
/* 318 */       stringBuilder.append(Math.abs(integer.intValue()));
/*     */     } 
/*     */     
/* 321 */     if (bool) {
/* 322 */       if (integer != null) {
/* 323 */         stringBuilder.insert(0, ' ');
/*     */       } else {
/* 325 */         while (stringBuilder.length() < b) {
/* 326 */           stringBuilder.insert(0, ' ');
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 331 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private static String zeroesAfterDecimalSeparator(BigDecimal paramBigDecimal) {
/* 335 */     String str = paramBigDecimal.toString();
/* 336 */     int i = str.indexOf('.');
/* 337 */     if (i < 0) {
/* 338 */       return "";
/*     */     }
/* 340 */     int j = i + 1;
/* 341 */     boolean bool = true;
/* 342 */     for (; j < str.length(); j++) {
/* 343 */       if (str.charAt(j) != '0') {
/* 344 */         bool = false;
/*     */         break;
/*     */       } 
/*     */     } 
/* 348 */     char[] arrayOfChar = new char[bool ? (str.length() - i - 1) : (j - 1 - i)];
/* 349 */     Arrays.fill(arrayOfChar, '0');
/* 350 */     return String.valueOf(arrayOfChar);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void addSign(StringBuilder paramStringBuilder, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5) {
/* 356 */     if (paramBoolean4) {
/* 357 */       if (paramInt < 0) {
/* 358 */         paramStringBuilder.insert(0, '<');
/* 359 */         paramStringBuilder.append('>');
/* 360 */       } else if (paramBoolean5) {
/* 361 */         paramStringBuilder.insert(0, ' ');
/* 362 */         paramStringBuilder.append(' ');
/*     */       } 
/*     */     } else {
/*     */       String str;
/* 366 */       if (paramInt == 0) {
/* 367 */         str = "";
/* 368 */       } else if (paramInt < 0) {
/* 369 */         str = "-";
/*     */       }
/* 371 */       else if (paramBoolean1 || paramBoolean2) {
/* 372 */         str = "+";
/* 373 */       } else if (paramBoolean5) {
/* 374 */         str = " ";
/*     */       } else {
/* 376 */         str = "";
/*     */       } 
/*     */       
/* 379 */       if (paramBoolean3 || paramBoolean2) {
/* 380 */         paramStringBuilder.append(str);
/*     */       } else {
/* 382 */         paramStringBuilder.insert(0, str);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private static int findDecimalSeparator(String paramString) {
/* 388 */     int i = paramString.indexOf('.');
/* 389 */     if (i == -1) {
/* 390 */       i = paramString.indexOf('D');
/* 391 */       if (i == -1) {
/* 392 */         i = paramString.indexOf('d');
/* 393 */         if (i == -1) {
/* 394 */           i = paramString.length();
/*     */         }
/*     */       } 
/*     */     } 
/* 398 */     return i;
/*     */   }
/*     */   
/*     */   private static int calculateScale(String paramString, int paramInt) {
/* 402 */     byte b = 0;
/* 403 */     for (int i = paramInt; i < paramString.length(); i++) {
/* 404 */       char c = paramString.charAt(i);
/* 405 */       if (c == '0' || c == '9') {
/* 406 */         b++;
/*     */       }
/*     */     } 
/* 409 */     return b;
/*     */   }
/*     */   
/*     */   private static String toRomanNumeral(int paramInt) {
/* 413 */     int[] arrayOfInt = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
/*     */     
/* 415 */     String[] arrayOfString = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
/*     */     
/* 417 */     StringBuilder stringBuilder = new StringBuilder();
/* 418 */     for (byte b = 0; b < arrayOfInt.length; b++) {
/* 419 */       int i = arrayOfInt[b];
/* 420 */       String str = arrayOfString[b];
/* 421 */       while (paramInt >= i) {
/* 422 */         stringBuilder.append(str);
/* 423 */         paramInt -= i;
/*     */       } 
/*     */     } 
/* 426 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   private static String toHex(BigDecimal paramBigDecimal, String paramString) {
/* 431 */     boolean bool1 = !paramString.toUpperCase().startsWith("FM") ? true : false;
/* 432 */     boolean bool2 = !paramString.contains("x") ? true : false;
/* 433 */     boolean bool = paramString.startsWith("0");
/* 434 */     byte b = 0; int i;
/* 435 */     for (i = 0; i < paramString.length(); i++) {
/* 436 */       char c = paramString.charAt(i);
/* 437 */       if (c == '0' || c == 'X' || c == 'x') {
/* 438 */         b++;
/*     */       }
/*     */     } 
/*     */     
/* 442 */     i = paramBigDecimal.setScale(0, 4).intValue();
/* 443 */     String str = Integer.toHexString(i);
/* 444 */     if (b < str.length()) {
/* 445 */       str = StringUtils.pad("", b + 1, "#", true);
/*     */     } else {
/* 447 */       if (bool2) {
/* 448 */         str = str.toUpperCase();
/*     */       }
/* 450 */       if (bool) {
/* 451 */         str = StringUtils.pad(str, b, "0", false);
/*     */       }
/* 453 */       if (bool1) {
/* 454 */         str = StringUtils.pad(str, paramString.length() + 1, " ", false);
/*     */       }
/*     */     } 
/*     */     
/* 458 */     return str;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String toChar(Timestamp paramTimestamp, String paramString1, String paramString2) {
/* 600 */     if (paramString1 == null) {
/* 601 */       paramString1 = "DD-MON-YY HH.MI.SS.FF PM";
/*     */     }
/*     */     
/* 604 */     GregorianCalendar gregorianCalendar = new GregorianCalendar(Locale.ENGLISH);
/* 605 */     gregorianCalendar.setTimeInMillis(paramTimestamp.getTime());
/* 606 */     StringBuilder stringBuilder = new StringBuilder();
/* 607 */     boolean bool = true;
/*     */     
/* 609 */     for (int i = 0; i < paramString1.length(); ) {
/*     */       Capitalization capitalization;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 615 */       if ((capitalization = containsAt(paramString1, i, new String[] { "A.D.", "B.C." })) != null) {
/* 616 */         String str = (gregorianCalendar.get(0) == 1) ? "A.D." : "B.C.";
/* 617 */         stringBuilder.append(capitalization.apply(str));
/* 618 */         i += 4; continue;
/* 619 */       }  if ((capitalization = containsAt(paramString1, i, new String[] { "AD", "BC" })) != null) {
/* 620 */         String str = (gregorianCalendar.get(0) == 1) ? "AD" : "BC";
/* 621 */         stringBuilder.append(capitalization.apply(str));
/* 622 */         i += 2;
/*     */         
/*     */         continue;
/*     */       } 
/* 626 */       if ((capitalization = containsAt(paramString1, i, new String[] { "A.M.", "P.M." })) != null) {
/* 627 */         String str = (gregorianCalendar.get(9) == 0) ? "A.M." : "P.M.";
/* 628 */         stringBuilder.append(capitalization.apply(str));
/* 629 */         i += 4; continue;
/* 630 */       }  if ((capitalization = containsAt(paramString1, i, new String[] { "AM", "PM" })) != null) {
/* 631 */         String str = (gregorianCalendar.get(9) == 0) ? "AM" : "PM";
/* 632 */         stringBuilder.append(capitalization.apply(str));
/* 633 */         i += 2;
/*     */         
/*     */         continue;
/*     */       } 
/* 637 */       if ((capitalization = containsAt(paramString1, i, new String[] { "DL" })) != null) {
/* 638 */         stringBuilder.append((new SimpleDateFormat("EEEE, MMMM d, yyyy")).format(paramTimestamp));
/* 639 */         i += 2; continue;
/* 640 */       }  if ((capitalization = containsAt(paramString1, i, new String[] { "DS" })) != null) {
/* 641 */         stringBuilder.append((new SimpleDateFormat("MM/dd/yyyy")).format(paramTimestamp));
/* 642 */         i += 2; continue;
/* 643 */       }  if ((capitalization = containsAt(paramString1, i, new String[] { "TS" })) != null) {
/* 644 */         stringBuilder.append((new SimpleDateFormat("h:mm:ss aa")).format(paramTimestamp));
/* 645 */         i += 2;
/*     */         
/*     */         continue;
/*     */       } 
/* 649 */       if ((capitalization = containsAt(paramString1, i, new String[] { "DDD" })) != null) {
/* 650 */         stringBuilder.append(gregorianCalendar.get(6));
/* 651 */         i += 3; continue;
/* 652 */       }  if ((capitalization = containsAt(paramString1, i, new String[] { "DD" })) != null) {
/* 653 */         stringBuilder.append(String.format("%02d", new Object[] { Integer.valueOf(gregorianCalendar.get(5)) }));
/*     */         
/* 655 */         i += 2; continue;
/* 656 */       }  if ((capitalization = containsAt(paramString1, i, new String[] { "DY" })) != null) {
/* 657 */         String str = (new SimpleDateFormat("EEE")).format(paramTimestamp).toUpperCase();
/* 658 */         stringBuilder.append(capitalization.apply(str));
/* 659 */         i += 2; continue;
/* 660 */       }  if ((capitalization = containsAt(paramString1, i, new String[] { "DAY" })) != null) {
/* 661 */         String str = (new SimpleDateFormat("EEEE")).format(paramTimestamp);
/* 662 */         if (bool) {
/* 663 */           str = StringUtils.pad(str, "Wednesday".length(), " ", true);
/*     */         }
/* 665 */         stringBuilder.append(capitalization.apply(str));
/* 666 */         i += 3; continue;
/* 667 */       }  if ((capitalization = containsAt(paramString1, i, new String[] { "D" })) != null) {
/* 668 */         stringBuilder.append(gregorianCalendar.get(7));
/* 669 */         i++; continue;
/* 670 */       }  if ((capitalization = containsAt(paramString1, i, new String[] { "J" })) != null) {
/* 671 */         long l1 = paramTimestamp.getTime() - JULIAN_EPOCH;
/* 672 */         long l2 = (long)Math.floor((l1 / 86400000L));
/* 673 */         stringBuilder.append(l2);
/* 674 */         i++;
/*     */         
/*     */         continue;
/*     */       } 
/* 678 */       if ((capitalization = containsAt(paramString1, i, new String[] { "HH24" })) != null) {
/* 679 */         stringBuilder.append((new DecimalFormat("00")).format(gregorianCalendar.get(11)));
/* 680 */         i += 4; continue;
/* 681 */       }  if ((capitalization = containsAt(paramString1, i, new String[] { "HH12" })) != null) {
/* 682 */         stringBuilder.append((new DecimalFormat("00")).format(gregorianCalendar.get(10)));
/* 683 */         i += 4; continue;
/* 684 */       }  if ((capitalization = containsAt(paramString1, i, new String[] { "HH" })) != null) {
/* 685 */         stringBuilder.append((new DecimalFormat("00")).format(gregorianCalendar.get(10)));
/* 686 */         i += 2;
/*     */         
/*     */         continue;
/*     */       } 
/* 690 */       if ((capitalization = containsAt(paramString1, i, new String[] { "MI" })) != null) {
/* 691 */         stringBuilder.append((new DecimalFormat("00")).format(gregorianCalendar.get(12)));
/* 692 */         i += 2;
/*     */         
/*     */         continue;
/*     */       } 
/* 696 */       if ((capitalization = containsAt(paramString1, i, new String[] { "SSSSS" })) != null) {
/* 697 */         int j = gregorianCalendar.get(11) * 60 * 60;
/* 698 */         j += gregorianCalendar.get(12) * 60;
/* 699 */         j += gregorianCalendar.get(13);
/* 700 */         stringBuilder.append(j);
/* 701 */         i += 5; continue;
/* 702 */       }  if ((capitalization = containsAt(paramString1, i, new String[] { "SS" })) != null) {
/* 703 */         stringBuilder.append((new DecimalFormat("00")).format(gregorianCalendar.get(13)));
/* 704 */         i += 2;
/*     */         
/*     */         continue;
/*     */       } 
/* 708 */       if ((capitalization = containsAt(paramString1, i, new String[] { "FF1", "FF2", "FF3", "FF4", "FF5", "FF6", "FF7", "FF8", "FF9" })) != null) {
/*     */         
/* 710 */         int j = Integer.parseInt(paramString1.substring(i + 2, i + 3));
/* 711 */         int k = (int)(gregorianCalendar.get(14) * Math.pow(10.0D, (j - 3)));
/* 712 */         stringBuilder.append(k);
/* 713 */         i += 3; continue;
/* 714 */       }  if ((capitalization = containsAt(paramString1, i, new String[] { "FF" })) != null) {
/* 715 */         stringBuilder.append(gregorianCalendar.get(14) * 1000);
/* 716 */         i += 2;
/*     */         
/*     */         continue;
/*     */       } 
/* 720 */       if ((capitalization = containsAt(paramString1, i, new String[] { "TZR" })) != null) {
/* 721 */         TimeZone timeZone = TimeZone.getDefault();
/* 722 */         stringBuilder.append(timeZone.getID());
/* 723 */         i += 3; continue;
/* 724 */       }  if ((capitalization = containsAt(paramString1, i, new String[] { "TZD" })) != null) {
/* 725 */         TimeZone timeZone = TimeZone.getDefault();
/* 726 */         boolean bool1 = timeZone.inDaylightTime(new Date());
/* 727 */         stringBuilder.append(timeZone.getDisplayName(bool1, 0));
/* 728 */         i += 3;
/*     */         
/*     */         continue;
/*     */       } 
/* 732 */       if ((capitalization = containsAt(paramString1, i, new String[] { "IW", "WW" })) != null) {
/* 733 */         stringBuilder.append(gregorianCalendar.get(3));
/* 734 */         i += 2; continue;
/* 735 */       }  if ((capitalization = containsAt(paramString1, i, new String[] { "W" })) != null) {
/* 736 */         int j = (int)(1.0D + Math.floor((gregorianCalendar.get(5) / 7)));
/* 737 */         stringBuilder.append(j);
/* 738 */         i++;
/*     */         
/*     */         continue;
/*     */       } 
/* 742 */       if ((capitalization = containsAt(paramString1, i, new String[] { "Y,YYY" })) != null) {
/* 743 */         stringBuilder.append((new DecimalFormat("#,###")).format(getYear(gregorianCalendar)));
/* 744 */         i += 5; continue;
/* 745 */       }  if ((capitalization = containsAt(paramString1, i, new String[] { "SYYYY" })) != null) {
/* 746 */         if (gregorianCalendar.get(0) == 0) {
/* 747 */           stringBuilder.append('-');
/*     */         }
/* 749 */         stringBuilder.append((new DecimalFormat("0000")).format(getYear(gregorianCalendar)));
/* 750 */         i += 5; continue;
/* 751 */       }  if ((capitalization = containsAt(paramString1, i, new String[] { "YYYY", "IYYY", "RRRR" })) != null) {
/* 752 */         stringBuilder.append((new DecimalFormat("0000")).format(getYear(gregorianCalendar)));
/* 753 */         i += 4; continue;
/* 754 */       }  if ((capitalization = containsAt(paramString1, i, new String[] { "YYY", "IYY" })) != null) {
/* 755 */         stringBuilder.append((new DecimalFormat("000")).format((getYear(gregorianCalendar) % 1000)));
/* 756 */         i += 3; continue;
/* 757 */       }  if ((capitalization = containsAt(paramString1, i, new String[] { "YY", "IY", "RR" })) != null) {
/* 758 */         stringBuilder.append((new DecimalFormat("00")).format((getYear(gregorianCalendar) % 100)));
/* 759 */         i += 2; continue;
/* 760 */       }  if ((capitalization = containsAt(paramString1, i, new String[] { "I", "Y" })) != null) {
/* 761 */         stringBuilder.append(getYear(gregorianCalendar) % 10);
/* 762 */         i++;
/*     */         
/*     */         continue;
/*     */       } 
/* 766 */       if ((capitalization = containsAt(paramString1, i, new String[] { "MONTH" })) != null) {
/* 767 */         String str = (new SimpleDateFormat("MMMM")).format(paramTimestamp);
/* 768 */         if (bool) {
/* 769 */           str = StringUtils.pad(str, "September".length(), " ", true);
/*     */         }
/* 771 */         stringBuilder.append(capitalization.apply(str));
/* 772 */         i += 5; continue;
/* 773 */       }  if ((capitalization = containsAt(paramString1, i, new String[] { "MON" })) != null) {
/* 774 */         String str = (new SimpleDateFormat("MMM")).format(paramTimestamp);
/* 775 */         stringBuilder.append(capitalization.apply(str));
/* 776 */         i += 3; continue;
/* 777 */       }  if ((capitalization = containsAt(paramString1, i, new String[] { "MM" })) != null) {
/* 778 */         stringBuilder.append(String.format("%02d", new Object[] { Integer.valueOf(gregorianCalendar.get(2) + 1) }));
/* 779 */         i += 2; continue;
/* 780 */       }  if ((capitalization = containsAt(paramString1, i, new String[] { "RM" })) != null) {
/* 781 */         int j = gregorianCalendar.get(2) + 1;
/* 782 */         stringBuilder.append(capitalization.apply(toRomanNumeral(j)));
/* 783 */         i += 2; continue;
/* 784 */       }  if ((capitalization = containsAt(paramString1, i, new String[] { "Q" })) != null) {
/* 785 */         int j = (int)(1.0D + Math.floor((gregorianCalendar.get(2) / 3)));
/* 786 */         stringBuilder.append(j);
/* 787 */         i++;
/*     */         
/*     */         continue;
/*     */       } 
/* 791 */       if ((capitalization = containsAt(paramString1, i, new String[] { "X" })) != null) {
/* 792 */         char c = DecimalFormatSymbols.getInstance().getDecimalSeparator();
/* 793 */         stringBuilder.append(c);
/* 794 */         i++;
/*     */         
/*     */         continue;
/*     */       } 
/* 798 */       if ((capitalization = containsAt(paramString1, i, new String[] { "FM" })) != null) {
/* 799 */         bool = !bool ? true : false;
/* 800 */         i += 2; continue;
/* 801 */       }  if ((capitalization = containsAt(paramString1, i, new String[] { "FX" })) != null) {
/* 802 */         i += 2;
/*     */         
/*     */         continue;
/*     */       } 
/* 806 */       if ((capitalization = containsAt(paramString1, i, new String[] { "\"" })) != null) {
/* 807 */         for (; ++i < paramString1.length(); i++) {
/* 808 */           char c = paramString1.charAt(i);
/* 809 */           if (c != '"') {
/* 810 */             stringBuilder.append(c);
/*     */           } else {
/* 812 */             i++; break;
/*     */           } 
/*     */         }  continue;
/*     */       } 
/* 816 */       if (paramString1.charAt(i) == '-' || paramString1.charAt(i) == '/' || paramString1.charAt(i) == ',' || paramString1.charAt(i) == '.' || paramString1.charAt(i) == ';' || paramString1.charAt(i) == ':' || paramString1.charAt(i) == ' ') {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 823 */         stringBuilder.append(paramString1.charAt(i));
/* 824 */         i++;
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/* 829 */       throw DbException.get(90010, paramString1);
/*     */     } 
/*     */ 
/*     */     
/* 833 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private static int getYear(Calendar paramCalendar) {
/* 837 */     int i = paramCalendar.get(1);
/* 838 */     if (paramCalendar.get(0) == 0) {
/* 839 */       i--;
/*     */     }
/* 841 */     return i;
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
/*     */   private static Capitalization containsAt(String paramString, int paramInt, String... paramVarArgs) {
/* 860 */     for (String str : paramVarArgs) {
/* 861 */       if (paramInt + str.length() <= paramString.length()) {
/* 862 */         boolean bool = true;
/* 863 */         Boolean bool1 = null;
/* 864 */         Boolean bool2 = null;
/* 865 */         for (byte b = 0; b < str.length(); b++) {
/* 866 */           char c1 = paramString.charAt(paramInt + b);
/* 867 */           char c2 = str.charAt(b);
/* 868 */           if (c1 != c2 && Character.toUpperCase(c1) != Character.toUpperCase(c2)) {
/* 869 */             bool = false; break;
/*     */           } 
/* 871 */           if (Character.isLetter(c1)) {
/* 872 */             if (bool1 == null) {
/* 873 */               bool1 = Boolean.valueOf(Character.isUpperCase(c1));
/* 874 */             } else if (bool2 == null) {
/* 875 */               bool2 = Boolean.valueOf(Character.isUpperCase(c1));
/*     */             } 
/*     */           }
/*     */         } 
/* 879 */         if (bool) {
/* 880 */           return Capitalization.toCapitalization(bool1, bool2);
/*     */         }
/*     */       } 
/*     */     } 
/* 884 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private enum Capitalization
/*     */   {
/* 893 */     UPPERCASE,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 898 */     LOWERCASE,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 904 */     CAPITALIZE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static Capitalization toCapitalization(Boolean param1Boolean1, Boolean param1Boolean2) {
/* 916 */       if (param1Boolean1 == null)
/* 917 */         return CAPITALIZE; 
/* 918 */       if (param1Boolean2 == null)
/* 919 */         return param1Boolean1.booleanValue() ? UPPERCASE : LOWERCASE; 
/* 920 */       if (param1Boolean1.booleanValue()) {
/* 921 */         return param1Boolean2.booleanValue() ? UPPERCASE : CAPITALIZE;
/*     */       }
/* 923 */       return LOWERCASE;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String apply(String param1String) {
/* 934 */       if (param1String == null || param1String.isEmpty()) {
/* 935 */         return param1String;
/*     */       }
/* 937 */       switch (this) {
/*     */         case UPPERCASE:
/* 939 */           return param1String.toUpperCase();
/*     */         case LOWERCASE:
/* 941 */           return param1String.toLowerCase();
/*     */         case CAPITALIZE:
/* 943 */           return Character.toUpperCase(param1String.charAt(0)) + ((param1String.length() > 1) ? param1String.toLowerCase().substring(1) : "");
/*     */       } 
/*     */       
/* 946 */       throw new IllegalArgumentException("Unknown capitalization strategy: " + this);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\ToChar.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */