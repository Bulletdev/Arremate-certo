/*     */ package org.c.a.b.r;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class n
/*     */ {
/*  29 */   private static final char[] j = new char[] { ' ', '\t', '\n', '\f', '\r' };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String k(String paramString, int paramInt) {
/*  46 */     return c(paramString, paramInt, ' ');
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
/*     */   public static String c(String paramString, int paramInt, char paramChar) {
/*     */     StringBuilder stringBuilder;
/*  59 */     if (paramString == null) {
/*  60 */       stringBuilder = new StringBuilder();
/*     */     } else {
/*  62 */       stringBuilder = new StringBuilder(paramString);
/*     */     } 
/*     */     
/*  65 */     if (stringBuilder.length() > paramInt) {
/*  66 */       return stringBuilder.substring(0, paramInt);
/*     */     }
/*     */     
/*  69 */     while (stringBuilder.length() < paramInt) {
/*  70 */       stringBuilder.append(paramChar);
/*     */     }
/*  72 */     return stringBuilder.toString();
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
/*     */   public static String d(String paramString, int paramInt, char paramChar) {
/*  84 */     if (paramString == null) {
/*  85 */       paramString = "";
/*     */     }
/*  87 */     if (paramString.length() > paramInt) {
/*  88 */       return paramString.substring(0, paramInt);
/*     */     }
/*  90 */     return leftPad(paramString, paramInt, paramChar);
/*     */   }
/*     */   
/*     */   public static String leftPad(String paramString, int paramInt, char paramChar) {
/*  94 */     StringBuilder stringBuilder = new StringBuilder(paramString);
/*  95 */     while (stringBuilder.length() < paramInt) {
/*  96 */       stringBuilder.insert(0, paramChar);
/*     */     }
/*  98 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String bg(String paramString) {
/* 108 */     StringBuilder stringBuilder = new StringBuilder();
/* 109 */     char c = Character.MIN_VALUE;
/* 110 */     for (byte b = 0; b < paramString.length(); b++) {
/* 111 */       char c1 = paramString.charAt(b);
/* 112 */       boolean bool = false;
/* 113 */       for (char c2 : j) {
/* 114 */         if (c1 == c2) {
/* 115 */           if (c != ' ') {
/* 116 */             stringBuilder.append(' ');
/*     */           }
/* 118 */           c = ' ';
/* 119 */           bool = true;
/*     */           break;
/*     */         } 
/*     */       } 
/* 123 */       if (!bool) {
/* 124 */         stringBuilder.append(c1);
/* 125 */         c = c1;
/*     */       } 
/*     */     } 
/* 128 */     return stringBuilder.toString();
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
/*     */   public static String left(String paramString, int paramInt) {
/* 140 */     if (paramString == null) {
/* 141 */       return null;
/*     */     }
/*     */     
/* 144 */     if (paramString.length() < paramInt) {
/* 145 */       return paramString;
/*     */     }
/*     */     
/* 148 */     return paramString.substring(0, paramInt);
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
/*     */   public static String replaceAll(String paramString1, String paramString2, String paramString3) {
/* 160 */     return paramString1.replaceAll(Pattern.quote(paramString2), Matcher.quoteReplacement(paramString3));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean W(String paramString) {
/* 170 */     return (paramString != null && paramString.length() > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String a(Object[] paramArrayOfObject) {
/* 180 */     return d(",", paramArrayOfObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String d(String paramString, Object[] paramArrayOfObject) {
/* 191 */     if (paramArrayOfObject == null) {
/* 192 */       return null;
/*     */     }
/*     */     
/* 195 */     StringBuilder stringBuilder = new StringBuilder();
/* 196 */     for (byte b = 0; b < paramArrayOfObject.length; b++) {
/* 197 */       if (b > 0) {
/* 198 */         stringBuilder.append(paramString);
/*     */       }
/* 200 */       stringBuilder.append(paramArrayOfObject[b]);
/*     */     } 
/* 202 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean X(String paramString) {
/* 212 */     return (paramString != null && paramString.trim().length() > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String[] a(String paramString1, String paramString2) {
/* 223 */     if (paramString1 == null) {
/* 224 */       return null;
/*     */     }
/* 226 */     List<String> list = f(paramString1, paramString2);
/* 227 */     return list.<String>toArray(new String[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<String> f(String paramString1, String paramString2) {
/* 238 */     if (paramString1 == null) {
/* 239 */       return null;
/*     */     }
/* 241 */     ArrayList<String> arrayList = new ArrayList(paramString1.length() / 5);
/* 242 */     char[] arrayOfChar = paramString2.toCharArray();
/* 243 */     int i = 0;
/* 244 */     int j = 0;
/* 245 */     for (byte b = 0; b < paramString1.length(); b++) {
/* 246 */       char c = paramString1.charAt(b);
/* 247 */       boolean bool = false;
/* 248 */       for (char c1 : arrayOfChar) {
/* 249 */         if (c == c1) {
/* 250 */           arrayList.add(paramString1.substring(i, j));
/* 251 */           i = b + 1;
/* 252 */           j = i;
/* 253 */           bool = true;
/*     */           break;
/*     */         } 
/*     */       } 
/* 257 */       if (!bool) {
/* 258 */         if (b == i && c == ' ') {
/* 259 */           i++;
/* 260 */           j++;
/*     */         } 
/* 262 */         if (b >= i && c != ' ') {
/* 263 */           j = b + 1;
/*     */         }
/*     */       } 
/*     */     } 
/* 267 */     if (i < j) {
/* 268 */       arrayList.add(paramString1.substring(i, j));
/*     */     }
/* 270 */     return arrayList;
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
/*     */   public static List<String> a(String paramString, char paramChar1, char paramChar2) {
/* 282 */     if (paramString == null) {
/* 283 */       return null;
/*     */     }
/* 285 */     ArrayList<String> arrayList = new ArrayList(paramString.length() / 5);
/* 286 */     int i = 0;
/* 287 */     int j = 0;
/* 288 */     boolean bool = false;
/* 289 */     for (byte b = 0; b < paramString.length(); b++) {
/* 290 */       char c = paramString.charAt(b);
/* 291 */       if (c == paramChar2) {
/* 292 */         bool = !bool ? true : false;
/* 293 */         a(arrayList, paramString, i, j);
/* 294 */         i = b + 1;
/* 295 */         j = i;
/* 296 */       } else if (!bool && c == paramChar1) {
/* 297 */         a(arrayList, paramString, i, j);
/* 298 */         i = b + 1;
/* 299 */         j = i;
/* 300 */       } else if (b == i && c == ' ') {
/* 301 */         i++;
/* 302 */         j++;
/* 303 */       } else if (b >= i && c != ' ') {
/* 304 */         j = b + 1;
/*     */       } 
/*     */     } 
/* 307 */     a(arrayList, paramString, i, j);
/* 308 */     return arrayList;
/*     */   }
/*     */   
/*     */   private static void a(List<String> paramList, String paramString, int paramInt1, int paramInt2) {
/* 312 */     if (paramInt1 < paramInt2) {
/* 313 */       paramList.add(paramString.substring(paramInt1, paramInt2));
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
/*     */   public static int c(String paramString1, String paramString2) {
/* 325 */     if (paramString1 == null || paramString2 == null || paramString1.length() == 0 || paramString2.length() == 0) {
/* 326 */       return 0;
/*     */     }
/* 328 */     byte b = 0;
/* 329 */     int i = 0;
/*     */     int j;
/* 331 */     while ((j = paramString1.indexOf(paramString2, i)) != -1) {
/* 332 */       b++;
/* 333 */       i = j + paramString2.length();
/*     */     } 
/* 335 */     return b;
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
/*     */   public static String replace(String paramString1, String paramString2, String paramString3) {
/* 348 */     if (!W(paramString1) || !W(paramString2) || paramString3 == null) {
/* 349 */       return paramString1;
/*     */     }
/* 351 */     StringBuilder stringBuilder = new StringBuilder();
/* 352 */     int i = 0;
/* 353 */     int j = paramString1.indexOf(paramString2);
/*     */     
/* 355 */     int k = paramString2.length();
/* 356 */     while (j >= 0) {
/* 357 */       stringBuilder.append(paramString1, i, j);
/* 358 */       stringBuilder.append(paramString3);
/* 359 */       i = j + k;
/* 360 */       j = paramString1.indexOf(paramString2, i);
/*     */     } 
/* 362 */     stringBuilder.append(paramString1.substring(i));
/*     */     
/* 364 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String b(Collection<?> paramCollection) {
/* 375 */     return a(paramCollection, ", ");
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
/*     */   public static String a(Collection<?> paramCollection, String paramString) {
/* 387 */     if (paramCollection == null) {
/* 388 */       return "";
/*     */     }
/* 390 */     StringBuilder stringBuilder = new StringBuilder();
/* 391 */     Iterator<?> iterator = paramCollection.iterator();
/* 392 */     while (iterator.hasNext()) {
/* 393 */       stringBuilder.append(iterator.next());
/* 394 */       if (iterator.hasNext()) {
/* 395 */         stringBuilder.append(paramString);
/*     */       }
/*     */     } 
/* 398 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String bh(String paramString) {
/* 409 */     if (!W(paramString)) {
/* 410 */       return paramString;
/*     */     }
/* 412 */     StringBuilder stringBuilder = new StringBuilder(paramString);
/* 413 */     while (stringBuilder.length() > 0 && Character.isWhitespace(stringBuilder.charAt(0))) {
/* 414 */       stringBuilder.deleteCharAt(0);
/*     */     }
/* 416 */     return stringBuilder.toString();
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
/*     */   public static String a(String paramString, char paramChar) {
/* 428 */     StringBuilder stringBuilder = new StringBuilder(paramString);
/* 429 */     while (stringBuilder.length() > 0 && paramChar == stringBuilder.charAt(0)) {
/* 430 */       stringBuilder.deleteCharAt(0);
/*     */     }
/* 432 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String bi(String paramString) {
/* 443 */     if (!W(paramString)) {
/* 444 */       return paramString;
/*     */     }
/* 446 */     StringBuilder stringBuilder = new StringBuilder(paramString);
/* 447 */     while (stringBuilder.length() > 0 && Character.isWhitespace(stringBuilder.charAt(stringBuilder.length() - 1))) {
/* 448 */       stringBuilder.deleteCharAt(stringBuilder.length() - 1);
/*     */     }
/* 450 */     return stringBuilder.toString();
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
/*     */   public static boolean b(String paramString1, String paramString2, String... paramVarArgs) {
/* 462 */     if (W(paramString2) && !paramString1.startsWith(paramString2)) {
/* 463 */       return false;
/*     */     }
/* 465 */     for (String str : paramVarArgs) {
/* 466 */       if (paramString1.endsWith(str) && paramString1.length() > (paramString2 + str).length()) {
/* 467 */         return true;
/*     */       }
/*     */     } 
/* 470 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String bj(String paramString) {
/* 480 */     if (!W(paramString)) {
/* 481 */       return paramString;
/*     */     }
/* 483 */     StringBuilder stringBuilder = new StringBuilder(paramString);
/* 484 */     while (stringBuilder.length() > 0 && e(stringBuilder.charAt(stringBuilder.length() - 1))) {
/* 485 */       stringBuilder.deleteCharAt(stringBuilder.length() - 1);
/*     */     }
/* 487 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean e(char paramChar) {
/* 497 */     return ('\n' == paramChar || '\r' == paramChar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String wrap(String paramString, int paramInt) {
/* 508 */     if (paramString.length() < paramInt) {
/* 509 */       return paramString;
/*     */     }
/*     */     
/* 512 */     StringBuilder stringBuilder = new StringBuilder();
/* 513 */     int i = 0; int j;
/* 514 */     for (j = paramInt; j < paramString.length(); j += paramInt) {
/* 515 */       stringBuilder.append(paramString, i, j).append("\n");
/* 516 */       i = j;
/*     */     } 
/* 518 */     stringBuilder.append(paramString.substring(i));
/* 519 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String l(String paramString, int paramInt) {
/* 530 */     if (paramString.length() < paramInt) {
/* 531 */       return paramString;
/*     */     }
/*     */     
/* 534 */     StringBuilder stringBuilder = new StringBuilder();
/* 535 */     int i = 0;
/* 536 */     int j = paramInt;
/* 537 */     while (j < paramString.length()) {
/* 538 */       if (Character.isWhitespace(paramString.charAt(j))) {
/* 539 */         j++;
/*     */         
/*     */         continue;
/*     */       } 
/* 543 */       String str = paramString.substring(i, j);
/* 544 */       int k = str.lastIndexOf(' ');
/* 545 */       if (k > 0) {
/* 546 */         j = k + 1;
/*     */       }
/*     */       
/* 549 */       stringBuilder.append(paramString.substring(i, j).trim()).append("\n");
/* 550 */       i = j;
/* 551 */       j += paramInt;
/*     */     } 
/* 553 */     stringBuilder.append(paramString.substring(i));
/* 554 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\r\n.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */