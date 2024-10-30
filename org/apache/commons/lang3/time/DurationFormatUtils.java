/*     */ package org.apache.commons.lang3.time;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.TimeZone;
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
/*     */ public class DurationFormatUtils
/*     */ {
/*     */   public static final String ISO_EXTENDED_FORMAT_PATTERN = "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.SSS'S'";
/*     */   
/*     */   public static String formatDurationHMS(long paramLong) {
/*  83 */     return formatDuration(paramLong, "HH:mm:ss.SSS");
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
/*     */   public static String formatDurationISO(long paramLong) {
/*  99 */     return formatDuration(paramLong, "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.SSS'S'", false);
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
/*     */   public static String formatDuration(long paramLong, String paramString) {
/* 114 */     return formatDuration(paramLong, paramString, true);
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
/*     */   public static String formatDuration(long paramLong, String paramString, boolean paramBoolean) {
/* 131 */     Validate.inclusiveBetween(0L, Long.MAX_VALUE, paramLong, "durationMillis must not be negative");
/*     */     
/* 133 */     Token[] arrayOfToken = lexx(paramString);
/*     */     
/* 135 */     long l1 = 0L;
/* 136 */     long l2 = 0L;
/* 137 */     long l3 = 0L;
/* 138 */     long l4 = 0L;
/* 139 */     long l5 = paramLong;
/*     */     
/* 141 */     if (Token.containsTokenWithValue(arrayOfToken, d)) {
/* 142 */       l1 = l5 / 86400000L;
/* 143 */       l5 -= l1 * 86400000L;
/*     */     } 
/* 145 */     if (Token.containsTokenWithValue(arrayOfToken, H)) {
/* 146 */       l2 = l5 / 3600000L;
/* 147 */       l5 -= l2 * 3600000L;
/*     */     } 
/* 149 */     if (Token.containsTokenWithValue(arrayOfToken, m)) {
/* 150 */       l3 = l5 / 60000L;
/* 151 */       l5 -= l3 * 60000L;
/*     */     } 
/* 153 */     if (Token.containsTokenWithValue(arrayOfToken, s)) {
/* 154 */       l4 = l5 / 1000L;
/* 155 */       l5 -= l4 * 1000L;
/*     */     } 
/*     */     
/* 158 */     return format(arrayOfToken, 0L, 0L, l1, l2, l3, l4, l5, paramBoolean);
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
/*     */   public static String formatDurationWords(long paramLong, boolean paramBoolean1, boolean paramBoolean2) {
/* 181 */     String str = formatDuration(paramLong, "d' days 'H' hours 'm' minutes 's' seconds'");
/* 182 */     if (paramBoolean1) {
/*     */       
/* 184 */       str = " " + str;
/* 185 */       String str1 = StringUtils.replaceOnce(str, " 0 days", "");
/* 186 */       if (str1.length() != str.length()) {
/* 187 */         str = str1;
/* 188 */         str1 = StringUtils.replaceOnce(str, " 0 hours", "");
/* 189 */         if (str1.length() != str.length()) {
/* 190 */           str = str1;
/* 191 */           str1 = StringUtils.replaceOnce(str, " 0 minutes", "");
/* 192 */           str = str1;
/* 193 */           if (str1.length() != str.length()) {
/* 194 */             str = StringUtils.replaceOnce(str1, " 0 seconds", "");
/*     */           }
/*     */         } 
/*     */       } 
/* 198 */       if (!str.isEmpty())
/*     */       {
/* 200 */         str = str.substring(1);
/*     */       }
/*     */     } 
/* 203 */     if (paramBoolean2) {
/* 204 */       String str1 = StringUtils.replaceOnce(str, " 0 seconds", "");
/* 205 */       if (str1.length() != str.length()) {
/* 206 */         str = str1;
/* 207 */         str1 = StringUtils.replaceOnce(str, " 0 minutes", "");
/* 208 */         if (str1.length() != str.length()) {
/* 209 */           str = str1;
/* 210 */           str1 = StringUtils.replaceOnce(str, " 0 hours", "");
/* 211 */           if (str1.length() != str.length()) {
/* 212 */             str = StringUtils.replaceOnce(str1, " 0 days", "");
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 218 */     str = " " + str;
/* 219 */     str = StringUtils.replaceOnce(str, " 1 seconds", " 1 second");
/* 220 */     str = StringUtils.replaceOnce(str, " 1 minutes", " 1 minute");
/* 221 */     str = StringUtils.replaceOnce(str, " 1 hours", " 1 hour");
/* 222 */     str = StringUtils.replaceOnce(str, " 1 days", " 1 day");
/* 223 */     return str.trim();
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
/*     */   public static String formatPeriodISO(long paramLong1, long paramLong2) {
/* 238 */     return formatPeriod(paramLong1, paramLong2, "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.SSS'S'", false, TimeZone.getDefault());
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
/*     */   public static String formatPeriod(long paramLong1, long paramLong2, String paramString) {
/* 252 */     return formatPeriod(paramLong1, paramLong2, paramString, true, TimeZone.getDefault());
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
/*     */   public static String formatPeriod(long paramLong1, long paramLong2, String paramString, boolean paramBoolean, TimeZone paramTimeZone) {
/* 281 */     Validate.isTrue((paramLong1 <= paramLong2), "startMillis must not be greater than endMillis", new Object[0]);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 290 */     Token[] arrayOfToken = lexx(paramString);
/*     */ 
/*     */ 
/*     */     
/* 294 */     Calendar calendar1 = Calendar.getInstance(paramTimeZone);
/* 295 */     calendar1.setTime(new Date(paramLong1));
/* 296 */     Calendar calendar2 = Calendar.getInstance(paramTimeZone);
/* 297 */     calendar2.setTime(new Date(paramLong2));
/*     */ 
/*     */     
/* 300 */     int i = calendar2.get(14) - calendar1.get(14);
/* 301 */     int j = calendar2.get(13) - calendar1.get(13);
/* 302 */     int k = calendar2.get(12) - calendar1.get(12);
/* 303 */     int m = calendar2.get(11) - calendar1.get(11);
/* 304 */     int n = calendar2.get(5) - calendar1.get(5);
/* 305 */     int i1 = calendar2.get(2) - calendar1.get(2);
/* 306 */     int i2 = calendar2.get(1) - calendar1.get(1);
/*     */ 
/*     */     
/* 309 */     while (i < 0) {
/* 310 */       i += 1000;
/* 311 */       j--;
/*     */     } 
/* 313 */     while (j < 0) {
/* 314 */       j += 60;
/* 315 */       k--;
/*     */     } 
/* 317 */     while (k < 0) {
/* 318 */       k += 60;
/* 319 */       m--;
/*     */     } 
/* 321 */     while (m < 0) {
/* 322 */       m += 24;
/* 323 */       n--;
/*     */     } 
/*     */     
/* 326 */     if (Token.containsTokenWithValue(arrayOfToken, M)) {
/* 327 */       while (n < 0) {
/* 328 */         n += calendar1.getActualMaximum(5);
/* 329 */         i1--;
/* 330 */         calendar1.add(2, 1);
/*     */       } 
/*     */       
/* 333 */       while (i1 < 0) {
/* 334 */         i1 += 12;
/* 335 */         i2--;
/*     */       } 
/*     */       
/* 338 */       if (!Token.containsTokenWithValue(arrayOfToken, y) && i2 != 0) {
/* 339 */         while (i2 != 0) {
/* 340 */           i1 += 12 * i2;
/* 341 */           i2 = 0;
/*     */         }
/*     */       
/*     */       }
/*     */     } else {
/*     */       
/* 347 */       if (!Token.containsTokenWithValue(arrayOfToken, y)) {
/* 348 */         int i3 = calendar2.get(1);
/* 349 */         if (i1 < 0)
/*     */         {
/* 351 */           i3--;
/*     */         }
/*     */         
/* 354 */         while (calendar1.get(1) != i3) {
/* 355 */           n += calendar1.getActualMaximum(6) - calendar1.get(6);
/*     */ 
/*     */           
/* 358 */           if (calendar1 instanceof java.util.GregorianCalendar && calendar1
/* 359 */             .get(2) == 1 && calendar1
/* 360 */             .get(5) == 29) {
/* 361 */             n++;
/*     */           }
/*     */           
/* 364 */           calendar1.add(1, 1);
/*     */           
/* 366 */           n += calendar1.get(6);
/*     */         } 
/*     */         
/* 369 */         i2 = 0;
/*     */       } 
/*     */       
/* 372 */       while (calendar1.get(2) != calendar2.get(2)) {
/* 373 */         n += calendar1.getActualMaximum(5);
/* 374 */         calendar1.add(2, 1);
/*     */       } 
/*     */       
/* 377 */       i1 = 0;
/*     */       
/* 379 */       while (n < 0) {
/* 380 */         n += calendar1.getActualMaximum(5);
/* 381 */         i1--;
/* 382 */         calendar1.add(2, 1);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 391 */     if (!Token.containsTokenWithValue(arrayOfToken, d)) {
/* 392 */       m += 24 * n;
/* 393 */       n = 0;
/*     */     } 
/* 395 */     if (!Token.containsTokenWithValue(arrayOfToken, H)) {
/* 396 */       k += 60 * m;
/* 397 */       m = 0;
/*     */     } 
/* 399 */     if (!Token.containsTokenWithValue(arrayOfToken, m)) {
/* 400 */       j += 60 * k;
/* 401 */       k = 0;
/*     */     } 
/* 403 */     if (!Token.containsTokenWithValue(arrayOfToken, s)) {
/* 404 */       i += 1000 * j;
/* 405 */       j = 0;
/*     */     } 
/*     */     
/* 408 */     return format(arrayOfToken, i2, i1, n, m, k, j, i, paramBoolean);
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
/*     */   static String format(Token[] paramArrayOfToken, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, boolean paramBoolean) {
/* 428 */     StringBuilder stringBuilder = new StringBuilder();
/* 429 */     boolean bool = false;
/* 430 */     for (Token token : paramArrayOfToken) {
/* 431 */       Object object = token.getValue();
/* 432 */       int i = token.getCount();
/* 433 */       if (object instanceof StringBuilder) {
/* 434 */         stringBuilder.append(object.toString());
/*     */       }
/* 436 */       else if (object.equals(y)) {
/* 437 */         stringBuilder.append(paddedValue(paramLong1, paramBoolean, i));
/* 438 */         bool = false;
/* 439 */       } else if (object.equals(M)) {
/* 440 */         stringBuilder.append(paddedValue(paramLong2, paramBoolean, i));
/* 441 */         bool = false;
/* 442 */       } else if (object.equals(d)) {
/* 443 */         stringBuilder.append(paddedValue(paramLong3, paramBoolean, i));
/* 444 */         bool = false;
/* 445 */       } else if (object.equals(H)) {
/* 446 */         stringBuilder.append(paddedValue(paramLong4, paramBoolean, i));
/* 447 */         bool = false;
/* 448 */       } else if (object.equals(m)) {
/* 449 */         stringBuilder.append(paddedValue(paramLong5, paramBoolean, i));
/* 450 */         bool = false;
/* 451 */       } else if (object.equals(s)) {
/* 452 */         stringBuilder.append(paddedValue(paramLong6, paramBoolean, i));
/* 453 */         bool = true;
/* 454 */       } else if (object.equals(S)) {
/* 455 */         if (bool) {
/*     */           
/* 457 */           boolean bool1 = paramBoolean ? Math.max(3, i) : true;
/* 458 */           stringBuilder.append(paddedValue(paramLong7, true, bool1));
/*     */         } else {
/* 460 */           stringBuilder.append(paddedValue(paramLong7, paramBoolean, i));
/*     */         } 
/* 462 */         bool = false;
/*     */       } 
/*     */     } 
/*     */     
/* 466 */     return stringBuilder.toString();
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
/*     */   private static String paddedValue(long paramLong, boolean paramBoolean, int paramInt) {
/* 479 */     String str = Long.toString(paramLong);
/* 480 */     return paramBoolean ? StringUtils.leftPad(str, paramInt, '0') : str;
/*     */   }
/*     */   
/* 483 */   static final Object y = "y";
/* 484 */   static final Object M = "M";
/* 485 */   static final Object d = "d";
/* 486 */   static final Object H = "H";
/* 487 */   static final Object m = "m";
/* 488 */   static final Object s = "s";
/* 489 */   static final Object S = "S";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Token[] lexx(String paramString) {
/* 498 */     ArrayList<Token> arrayList = new ArrayList(paramString.length());
/*     */     
/* 500 */     boolean bool = false;
/*     */ 
/*     */     
/* 503 */     StringBuilder stringBuilder = null;
/* 504 */     Token token = null;
/* 505 */     for (byte b = 0; b < paramString.length(); b++) {
/* 506 */       char c = paramString.charAt(b);
/* 507 */       if (bool && c != '\'') {
/* 508 */         stringBuilder.append(c);
/*     */       } else {
/*     */         
/* 511 */         Object object = null;
/* 512 */         switch (c) {
/*     */           
/*     */           case '\'':
/* 515 */             if (bool) {
/* 516 */               stringBuilder = null;
/* 517 */               bool = false; break;
/*     */             } 
/* 519 */             stringBuilder = new StringBuilder();
/* 520 */             arrayList.add(new Token(stringBuilder));
/* 521 */             bool = true;
/*     */             break;
/*     */           
/*     */           case 'y':
/* 525 */             object = y;
/*     */             break;
/*     */           case 'M':
/* 528 */             object = M;
/*     */             break;
/*     */           case 'd':
/* 531 */             object = d;
/*     */             break;
/*     */           case 'H':
/* 534 */             object = H;
/*     */             break;
/*     */           case 'm':
/* 537 */             object = m;
/*     */             break;
/*     */           case 's':
/* 540 */             object = s;
/*     */             break;
/*     */           case 'S':
/* 543 */             object = S;
/*     */             break;
/*     */           default:
/* 546 */             if (stringBuilder == null) {
/* 547 */               stringBuilder = new StringBuilder();
/* 548 */               arrayList.add(new Token(stringBuilder));
/*     */             } 
/* 550 */             stringBuilder.append(c);
/*     */             break;
/*     */         } 
/* 553 */         if (object != null) {
/* 554 */           if (token != null && token.getValue().equals(object)) {
/* 555 */             token.increment();
/*     */           } else {
/* 557 */             Token token1 = new Token(object);
/* 558 */             arrayList.add(token1);
/* 559 */             token = token1;
/*     */           } 
/* 561 */           stringBuilder = null;
/*     */         } 
/*     */       } 
/* 564 */     }  if (bool) {
/* 565 */       throw new IllegalArgumentException("Unmatched quote in format: " + paramString);
/*     */     }
/* 567 */     return arrayList.<Token>toArray(new Token[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class Token
/*     */   {
/*     */     private final Object value;
/*     */ 
/*     */ 
/*     */     
/*     */     private int count;
/*     */ 
/*     */ 
/*     */     
/*     */     static boolean containsTokenWithValue(Token[] param1ArrayOfToken, Object param1Object) {
/* 584 */       for (Token token : param1ArrayOfToken) {
/* 585 */         if (token.getValue() == param1Object) {
/* 586 */           return true;
/*     */         }
/*     */       } 
/* 589 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Token(Object param1Object) {
/* 601 */       this.value = param1Object;
/* 602 */       this.count = 1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Token(Object param1Object, int param1Int) {
/* 613 */       this.value = param1Object;
/* 614 */       this.count = param1Int;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void increment() {
/* 621 */       this.count++;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int getCount() {
/* 630 */       return this.count;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Object getValue() {
/* 639 */       return this.value;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 650 */       if (param1Object instanceof Token) {
/* 651 */         Token token = (Token)param1Object;
/* 652 */         if (this.value.getClass() != token.value.getClass()) {
/* 653 */           return false;
/*     */         }
/* 655 */         if (this.count != token.count) {
/* 656 */           return false;
/*     */         }
/* 658 */         if (this.value instanceof StringBuilder)
/* 659 */           return this.value.toString().equals(token.value.toString()); 
/* 660 */         if (this.value instanceof Number) {
/* 661 */           return this.value.equals(token.value);
/*     */         }
/* 663 */         return (this.value == token.value);
/*     */       } 
/*     */       
/* 666 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 678 */       return this.value.hashCode();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 688 */       return StringUtils.repeat(this.value.toString(), this.count);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\time\DurationFormatUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */