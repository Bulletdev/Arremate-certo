/*     */ package com.google.a.m;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import java.math.BigInteger;
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @a
/*     */ @b
/*     */ public final class x
/*     */ {
/*     */   public static final long MAX_VALUE = -1L;
/*     */   
/*     */   private static long i(long paramLong) {
/*  64 */     return paramLong ^ Long.MIN_VALUE;
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
/*     */   public static int compare(long paramLong1, long paramLong2) {
/*  79 */     return m.compare(i(paramLong1), i(paramLong2));
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
/*     */   public static long min(long... paramVarArgs) {
/*  91 */     D.checkArgument((paramVarArgs.length > 0));
/*  92 */     long l = i(paramVarArgs[0]);
/*  93 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/*  94 */       long l1 = i(paramVarArgs[b]);
/*  95 */       if (l1 < l) {
/*  96 */         l = l1;
/*     */       }
/*     */     } 
/*  99 */     return i(l);
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
/*     */   public static long max(long... paramVarArgs) {
/* 111 */     D.checkArgument((paramVarArgs.length > 0));
/* 112 */     long l = i(paramVarArgs[0]);
/* 113 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 114 */       long l1 = i(paramVarArgs[b]);
/* 115 */       if (l1 > l) {
/* 116 */         l = l1;
/*     */       }
/*     */     } 
/* 119 */     return i(l);
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
/*     */   public static String a(String paramString, long... paramVarArgs) {
/* 131 */     D.checkNotNull(paramString);
/* 132 */     if (paramVarArgs.length == 0) {
/* 133 */       return "";
/*     */     }
/*     */ 
/*     */     
/* 137 */     StringBuilder stringBuilder = new StringBuilder(paramVarArgs.length * 5);
/* 138 */     stringBuilder.append(toString(paramVarArgs[0]));
/* 139 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 140 */       stringBuilder.append(paramString).append(toString(paramVarArgs[b]));
/*     */     }
/* 142 */     return stringBuilder.toString();
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
/*     */   public static Comparator<long[]> g() {
/* 157 */     return (Comparator<long[]>)a.a;
/*     */   }
/*     */   
/*     */   enum a implements Comparator<long[]> {
/* 161 */     a;
/*     */ 
/*     */     
/*     */     public int compare(long[] param1ArrayOflong1, long[] param1ArrayOflong2) {
/* 165 */       int i = Math.min(param1ArrayOflong1.length, param1ArrayOflong2.length);
/* 166 */       for (byte b = 0; b < i; b++) {
/* 167 */         if (param1ArrayOflong1[b] != param1ArrayOflong2[b]) {
/* 168 */           return x.compare(param1ArrayOflong1[b], param1ArrayOflong2[b]);
/*     */         }
/*     */       } 
/* 171 */       return param1ArrayOflong1.length - param1ArrayOflong2.length;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 176 */       return "UnsignedLongs.lexicographicalComparator()";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void c(long[] paramArrayOflong) {
/* 186 */     D.checkNotNull(paramArrayOflong);
/* 187 */     b(paramArrayOflong, 0, paramArrayOflong.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void b(long[] paramArrayOflong, int paramInt1, int paramInt2) {
/* 197 */     D.checkNotNull(paramArrayOflong);
/* 198 */     D.a(paramInt1, paramInt2, paramArrayOflong.length); int i;
/* 199 */     for (i = paramInt1; i < paramInt2; i++) {
/* 200 */       paramArrayOflong[i] = i(paramArrayOflong[i]);
/*     */     }
/* 202 */     Arrays.sort(paramArrayOflong, paramInt1, paramInt2);
/* 203 */     for (i = paramInt1; i < paramInt2; i++) {
/* 204 */       paramArrayOflong[i] = i(paramArrayOflong[i]);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void b(long[] paramArrayOflong) {
/* 215 */     D.checkNotNull(paramArrayOflong);
/* 216 */     a(paramArrayOflong, 0, paramArrayOflong.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(long[] paramArrayOflong, int paramInt1, int paramInt2) {
/* 226 */     D.checkNotNull(paramArrayOflong);
/* 227 */     D.a(paramInt1, paramInt2, paramArrayOflong.length); int i;
/* 228 */     for (i = paramInt1; i < paramInt2; i++) {
/* 229 */       paramArrayOflong[i] = paramArrayOflong[i] ^ Long.MAX_VALUE;
/*     */     }
/* 231 */     Arrays.sort(paramArrayOflong, paramInt1, paramInt2);
/* 232 */     for (i = paramInt1; i < paramInt2; i++) {
/* 233 */       paramArrayOflong[i] = paramArrayOflong[i] ^ Long.MAX_VALUE;
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
/*     */   public static long m(long paramLong1, long paramLong2) {
/* 248 */     if (paramLong2 < 0L) {
/* 249 */       if (compare(paramLong1, paramLong2) < 0) {
/* 250 */         return 0L;
/*     */       }
/* 252 */       return 1L;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 257 */     if (paramLong1 >= 0L) {
/* 258 */       return paramLong1 / paramLong2;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 267 */     long l1 = (paramLong1 >>> 1L) / paramLong2 << 1L;
/* 268 */     long l2 = paramLong1 - l1 * paramLong2;
/* 269 */     return l1 + ((compare(l2, paramLong2) >= 0) ? 1L : 0L);
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
/*     */   public static long n(long paramLong1, long paramLong2) {
/* 284 */     if (paramLong2 < 0L) {
/* 285 */       if (compare(paramLong1, paramLong2) < 0) {
/* 286 */         return paramLong1;
/*     */       }
/* 288 */       return paramLong1 - paramLong2;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 293 */     if (paramLong1 >= 0L) {
/* 294 */       return paramLong1 % paramLong2;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 303 */     long l1 = (paramLong1 >>> 1L) / paramLong2 << 1L;
/* 304 */     long l2 = paramLong1 - l1 * paramLong2;
/* 305 */     return l2 - ((compare(l2, paramLong2) >= 0) ? paramLong2 : 0L);
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
/*     */   @com.google.b.a.a
/*     */   public static long c(String paramString) {
/* 320 */     return a(paramString, 10);
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
/*     */   @com.google.b.a.a
/*     */   public static long a(String paramString, int paramInt) {
/* 338 */     D.checkNotNull(paramString);
/* 339 */     if (paramString.length() == 0) {
/* 340 */       throw new NumberFormatException("empty string");
/*     */     }
/* 342 */     if (paramInt < 2 || paramInt > 36) {
/* 343 */       throw new NumberFormatException((new StringBuilder(26)).append("illegal radix: ").append(paramInt).toString());
/*     */     }
/*     */     
/* 346 */     int i = b.ac[paramInt] - 1;
/* 347 */     long l = 0L;
/* 348 */     for (byte b = 0; b < paramString.length(); b++) {
/* 349 */       int j = Character.digit(paramString.charAt(b), paramInt);
/* 350 */       if (j == -1) {
/* 351 */         throw new NumberFormatException(paramString);
/*     */       }
/* 353 */       if (b > i && b.a(l, j, paramInt)) {
/* 354 */         String.valueOf(paramString); throw new NumberFormatException((String.valueOf(paramString).length() != 0) ? "Too large for unsigned long: ".concat(String.valueOf(paramString)) : new String("Too large for unsigned long: "));
/*     */       } 
/* 356 */       l = l * paramInt + j;
/*     */     } 
/*     */     
/* 359 */     return l;
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
/*     */   @com.google.b.a.a
/*     */   public static long d(String paramString) {
/* 380 */     n n = n.a(paramString);
/*     */     
/*     */     try {
/* 383 */       return a(n.iQ, n.gm);
/* 384 */     } catch (NumberFormatException numberFormatException1) {
/* 385 */       String.valueOf(paramString); NumberFormatException numberFormatException2 = new NumberFormatException((String.valueOf(paramString).length() != 0) ? "Error parsing value: ".concat(String.valueOf(paramString)) : new String("Error parsing value: "));
/*     */       
/* 387 */       numberFormatException2.initCause(numberFormatException1);
/* 388 */       throw numberFormatException2;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class b
/*     */   {
/* 400 */     static final long[] h = new long[37];
/* 401 */     static final int[] ab = new int[37];
/* 402 */     static final int[] ac = new int[37];
/*     */     
/*     */     static {
/* 405 */       BigInteger bigInteger = new BigInteger("10000000000000000", 16);
/* 406 */       for (byte b1 = 2; b1 <= 36; b1++) {
/* 407 */         h[b1] = x.m(-1L, b1);
/* 408 */         ab[b1] = (int)x.n(-1L, b1);
/* 409 */         ac[b1] = bigInteger.toString(b1).length() - 1;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     static boolean a(long param1Long, int param1Int1, int param1Int2) {
/* 420 */       if (param1Long >= 0L) {
/* 421 */         if (param1Long < h[param1Int2]) {
/* 422 */           return false;
/*     */         }
/* 424 */         if (param1Long > h[param1Int2]) {
/* 425 */           return true;
/*     */         }
/*     */         
/* 428 */         return (param1Int1 > ab[param1Int2]);
/*     */       } 
/*     */ 
/*     */       
/* 432 */       return true;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String toString(long paramLong) {
/* 442 */     return a(paramLong, 10);
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
/*     */   public static String a(long paramLong, int paramInt) {
/* 457 */     D.a((paramInt >= 2 && paramInt <= 36), "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", paramInt);
/*     */ 
/*     */ 
/*     */     
/* 461 */     if (paramLong == 0L)
/*     */     {
/* 463 */       return "0"; } 
/* 464 */     if (paramLong > 0L) {
/* 465 */       return Long.toString(paramLong, paramInt);
/*     */     }
/* 467 */     char[] arrayOfChar = new char[64];
/* 468 */     int i = arrayOfChar.length;
/* 469 */     if ((paramInt & paramInt - 1) == 0) {
/*     */       
/* 471 */       int j = Integer.numberOfTrailingZeros(paramInt);
/* 472 */       int k = paramInt - 1;
/*     */       do {
/* 474 */         arrayOfChar[--i] = Character.forDigit((int)paramLong & k, paramInt);
/* 475 */         paramLong >>>= j;
/* 476 */       } while (paramLong != 0L);
/*     */     } else {
/*     */       long l1;
/*     */ 
/*     */       
/* 481 */       if ((paramInt & 0x1) == 0) {
/*     */         
/* 483 */         l1 = (paramLong >>> 1L) / (paramInt >>> 1);
/*     */       } else {
/* 485 */         l1 = m(paramLong, paramInt);
/*     */       } 
/* 487 */       long l2 = paramLong - l1 * paramInt;
/* 488 */       arrayOfChar[--i] = Character.forDigit((int)l2, paramInt);
/* 489 */       paramLong = l1;
/*     */       
/* 491 */       while (paramLong > 0L) {
/* 492 */         arrayOfChar[--i] = Character.forDigit((int)(paramLong % paramInt), paramInt);
/* 493 */         paramLong /= paramInt;
/*     */       } 
/*     */     } 
/*     */     
/* 497 */     return new String(arrayOfChar, i, arrayOfChar.length - i);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\m\x.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */