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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CharSequenceUtils
/*     */ {
/*     */   private static final int NOT_FOUND = -1;
/*     */   static final int TO_STRING_LIMIT = 16;
/*     */   
/*     */   public static CharSequence subSequence(CharSequence paramCharSequence, int paramInt) {
/*  57 */     return (paramCharSequence == null) ? null : paramCharSequence.subSequence(paramInt, paramCharSequence.length());
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
/*     */   static int indexOf(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 100 */     if (paramCharSequence instanceof String) {
/* 101 */       return ((String)paramCharSequence).indexOf(paramInt1, paramInt2);
/*     */     }
/* 103 */     int i = paramCharSequence.length();
/* 104 */     if (paramInt2 < 0) {
/* 105 */       paramInt2 = 0;
/*     */     }
/* 107 */     if (paramInt1 < 65536) {
/* 108 */       for (int j = paramInt2; j < i; j++) {
/* 109 */         if (paramCharSequence.charAt(j) == paramInt1) {
/* 110 */           return j;
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 115 */     if (paramInt1 <= 1114111) {
/* 116 */       char[] arrayOfChar = Character.toChars(paramInt1);
/* 117 */       for (int j = paramInt2; j < i - 1; j++) {
/* 118 */         char c1 = paramCharSequence.charAt(j);
/* 119 */         char c2 = paramCharSequence.charAt(j + 1);
/* 120 */         if (c1 == arrayOfChar[0] && c2 == arrayOfChar[1]) {
/* 121 */           return j;
/*     */         }
/*     */       } 
/*     */     } 
/* 125 */     return -1;
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
/*     */   static int indexOf(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt) {
/* 137 */     if (paramCharSequence1 instanceof String)
/* 138 */       return ((String)paramCharSequence1).indexOf(paramCharSequence2.toString(), paramInt); 
/* 139 */     if (paramCharSequence1 instanceof StringBuilder)
/* 140 */       return ((StringBuilder)paramCharSequence1).indexOf(paramCharSequence2.toString(), paramInt); 
/* 141 */     if (paramCharSequence1 instanceof StringBuffer) {
/* 142 */       return ((StringBuffer)paramCharSequence1).indexOf(paramCharSequence2.toString(), paramInt);
/*     */     }
/* 144 */     return paramCharSequence1.toString().indexOf(paramCharSequence2.toString(), paramInt);
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
/*     */   static int lastIndexOf(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 183 */     if (paramCharSequence instanceof String) {
/* 184 */       return ((String)paramCharSequence).lastIndexOf(paramInt1, paramInt2);
/*     */     }
/* 186 */     int i = paramCharSequence.length();
/* 187 */     if (paramInt2 < 0) {
/* 188 */       return -1;
/*     */     }
/* 190 */     if (paramInt2 >= i) {
/* 191 */       paramInt2 = i - 1;
/*     */     }
/* 193 */     if (paramInt1 < 65536) {
/* 194 */       for (int j = paramInt2; j >= 0; j--) {
/* 195 */         if (paramCharSequence.charAt(j) == paramInt1) {
/* 196 */           return j;
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 202 */     if (paramInt1 <= 1114111) {
/* 203 */       char[] arrayOfChar = Character.toChars(paramInt1);
/*     */       
/* 205 */       if (paramInt2 == i - 1) {
/* 206 */         return -1;
/*     */       }
/* 208 */       for (int j = paramInt2; j >= 0; j--) {
/* 209 */         char c1 = paramCharSequence.charAt(j);
/* 210 */         char c2 = paramCharSequence.charAt(j + 1);
/* 211 */         if (arrayOfChar[0] == c1 && arrayOfChar[1] == c2) {
/* 212 */           return j;
/*     */         }
/*     */       } 
/*     */     } 
/* 216 */     return -1;
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
/*     */   static int lastIndexOf(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt) {
/* 230 */     if (paramCharSequence2 instanceof String) {
/* 231 */       if (paramCharSequence1 instanceof String)
/* 232 */         return ((String)paramCharSequence1).lastIndexOf((String)paramCharSequence2, paramInt); 
/* 233 */       if (paramCharSequence1 instanceof StringBuilder)
/* 234 */         return ((StringBuilder)paramCharSequence1).lastIndexOf((String)paramCharSequence2, paramInt); 
/* 235 */       if (paramCharSequence1 instanceof StringBuffer) {
/* 236 */         return ((StringBuffer)paramCharSequence1).lastIndexOf((String)paramCharSequence2, paramInt);
/*     */       }
/*     */     } 
/*     */     
/* 240 */     int i = paramCharSequence1.length();
/* 241 */     int j = paramCharSequence2.length();
/*     */     
/* 243 */     if (paramInt > i) {
/* 244 */       paramInt = i;
/*     */     }
/*     */     
/* 247 */     if (paramInt < 0 || j < 0 || j > i) {
/* 248 */       return -1;
/*     */     }
/*     */     
/* 251 */     if (j == 0) {
/* 252 */       return paramInt;
/*     */     }
/*     */     
/* 255 */     if (j <= 16) {
/* 256 */       if (paramCharSequence1 instanceof String)
/* 257 */         return ((String)paramCharSequence1).lastIndexOf(paramCharSequence2.toString(), paramInt); 
/* 258 */       if (paramCharSequence1 instanceof StringBuilder)
/* 259 */         return ((StringBuilder)paramCharSequence1).lastIndexOf(paramCharSequence2.toString(), paramInt); 
/* 260 */       if (paramCharSequence1 instanceof StringBuffer) {
/* 261 */         return ((StringBuffer)paramCharSequence1).lastIndexOf(paramCharSequence2.toString(), paramInt);
/*     */       }
/*     */     } 
/*     */     
/* 265 */     if (paramInt + j > i) {
/* 266 */       paramInt = i - j;
/*     */     }
/*     */     
/* 269 */     char c = paramCharSequence2.charAt(0);
/*     */     
/* 271 */     int k = paramInt;
/*     */     while (true) {
/* 273 */       while (paramCharSequence1.charAt(k) != c) {
/* 274 */         k--;
/* 275 */         if (k < 0) {
/* 276 */           return -1;
/*     */         }
/*     */       } 
/* 279 */       if (checkLaterThan1(paramCharSequence1, paramCharSequence2, j, k)) {
/* 280 */         return k;
/*     */       }
/* 282 */       k--;
/* 283 */       if (k < 0)
/* 284 */         return -1; 
/*     */     } 
/*     */   }
/*     */   private static boolean checkLaterThan1(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt1, int paramInt2) {
/*     */     byte b;
/*     */     int i;
/* 290 */     for (b = 1, i = paramInt1 - 1; b <= i; b++, i--) {
/* 291 */       if (paramCharSequence1.charAt(paramInt2 + b) != paramCharSequence2.charAt(b) || paramCharSequence1
/*     */         
/* 293 */         .charAt(paramInt2 + i) != paramCharSequence2.charAt(i))
/*     */       {
/* 295 */         return false;
/*     */       }
/*     */     } 
/* 298 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static char[] toCharArray(CharSequence paramCharSequence) {
/* 309 */     int i = StringUtils.length(paramCharSequence);
/* 310 */     if (i == 0) {
/* 311 */       return ArrayUtils.EMPTY_CHAR_ARRAY;
/*     */     }
/* 313 */     if (paramCharSequence instanceof String) {
/* 314 */       return ((String)paramCharSequence).toCharArray();
/*     */     }
/* 316 */     char[] arrayOfChar = new char[i];
/* 317 */     for (byte b = 0; b < i; b++) {
/* 318 */       arrayOfChar[b] = paramCharSequence.charAt(b);
/*     */     }
/* 320 */     return arrayOfChar;
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
/*     */   static boolean regionMatches(CharSequence paramCharSequence1, boolean paramBoolean, int paramInt1, CharSequence paramCharSequence2, int paramInt2, int paramInt3) {
/* 336 */     if (paramCharSequence1 instanceof String && paramCharSequence2 instanceof String) {
/* 337 */       return ((String)paramCharSequence1).regionMatches(paramBoolean, paramInt1, (String)paramCharSequence2, paramInt2, paramInt3);
/*     */     }
/* 339 */     int i = paramInt1;
/* 340 */     int j = paramInt2;
/* 341 */     int k = paramInt3;
/*     */ 
/*     */     
/* 344 */     int m = paramCharSequence1.length() - paramInt1;
/* 345 */     int n = paramCharSequence2.length() - paramInt2;
/*     */ 
/*     */     
/* 348 */     if (paramInt1 < 0 || paramInt2 < 0 || paramInt3 < 0) {
/* 349 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 353 */     if (m < paramInt3 || n < paramInt3) {
/* 354 */       return false;
/*     */     }
/*     */     
/* 357 */     while (k-- > 0) {
/* 358 */       char c1 = paramCharSequence1.charAt(i++);
/* 359 */       char c2 = paramCharSequence2.charAt(j++);
/*     */       
/* 361 */       if (c1 == c2) {
/*     */         continue;
/*     */       }
/*     */       
/* 365 */       if (!paramBoolean) {
/* 366 */         return false;
/*     */       }
/*     */ 
/*     */       
/* 370 */       char c3 = Character.toUpperCase(c1);
/* 371 */       char c4 = Character.toUpperCase(c2);
/* 372 */       if (c3 != c4 && Character.toLowerCase(c3) != Character.toLowerCase(c4)) {
/* 373 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 377 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\CharSequenceUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */