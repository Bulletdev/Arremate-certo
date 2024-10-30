/*     */ package com.google.a.k;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.a.d;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.m.k;
/*     */ import java.math.RoundingMode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @b(cl = true)
/*     */ public final class e
/*     */ {
/*     */   @d
/*     */   static final int fY = 1073741824;
/*     */   @d
/*     */   static final int fZ = -1257966797;
/*     */   
/*     */   @a
/*     */   public static int L(int paramInt) {
/*  67 */     h.a("x", paramInt);
/*  68 */     if (paramInt > 1073741824) {
/*  69 */       throw new ArithmeticException((new StringBuilder(58)).append("ceilingPowerOfTwo(").append(paramInt).append(") not representable as an int").toString());
/*     */     }
/*  71 */     return 1 << -Integer.numberOfLeadingZeros(paramInt - 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   public static int M(int paramInt) {
/*  83 */     h.a("x", paramInt);
/*  84 */     return Integer.highestOneBit(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean p(int paramInt) {
/*  94 */     return ((paramInt > 0)) & (((paramInt & paramInt - 1) == 0));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @d
/*     */   static int n(int paramInt1, int paramInt2) {
/* 106 */     return (paramInt1 - paramInt2 ^ 0xFFFFFFFF ^ 0xFFFFFFFF) >>> 31;
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
/*     */   public static int a(int paramInt, RoundingMode paramRoundingMode) {
/*     */     int i, j, k;
/* 119 */     h.a("x", paramInt);
/* 120 */     switch (null.S[paramRoundingMode.ordinal()]) {
/*     */       case 1:
/* 122 */         h.af(p(paramInt));
/*     */       
/*     */       case 2:
/*     */       case 3:
/* 126 */         return 31 - Integer.numberOfLeadingZeros(paramInt);
/*     */       
/*     */       case 4:
/*     */       case 5:
/* 130 */         return 32 - Integer.numberOfLeadingZeros(paramInt - 1);
/*     */ 
/*     */       
/*     */       case 6:
/*     */       case 7:
/*     */       case 8:
/* 136 */         i = Integer.numberOfLeadingZeros(paramInt);
/* 137 */         j = -1257966797 >>> i;
/*     */         
/* 139 */         k = 31 - i;
/* 140 */         return k + n(j, paramInt);
/*     */     } 
/*     */     
/* 143 */     throw new AssertionError();
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
/*     */   @c
/*     */   public static int b(int paramInt, RoundingMode paramRoundingMode) {
/* 160 */     h.a("x", paramInt);
/* 161 */     int i = N(paramInt);
/* 162 */     int j = U[i];
/* 163 */     switch (null.S[paramRoundingMode.ordinal()]) {
/*     */       case 1:
/* 165 */         h.af((paramInt == j));
/*     */       
/*     */       case 2:
/*     */       case 3:
/* 169 */         return i;
/*     */       case 4:
/*     */       case 5:
/* 172 */         return i + n(j, paramInt);
/*     */       
/*     */       case 6:
/*     */       case 7:
/*     */       case 8:
/* 177 */         return i + n(V[i], paramInt);
/*     */     } 
/* 179 */     throw new AssertionError();
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
/*     */   private static int N(int paramInt) {
/* 191 */     byte b = c[Integer.numberOfLeadingZeros(paramInt)];
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 196 */     return b - n(paramInt, U[b]);
/*     */   }
/*     */ 
/*     */   
/*     */   @d
/* 201 */   static final byte[] c = new byte[] { 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0 };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @d
/* 207 */   static final int[] U = new int[] { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000 };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @d
/* 213 */   static final int[] V = new int[] { 3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @d
/*     */   static final int ga = 46340;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @c
/*     */   public static int o(int paramInt1, int paramInt2) {
/* 228 */     h.b("exponent", paramInt2);
/* 229 */     switch (paramInt1) {
/*     */       case 0:
/* 231 */         return (paramInt2 == 0) ? 1 : 0;
/*     */       case 1:
/* 233 */         return 1;
/*     */       case -1:
/* 235 */         return ((paramInt2 & 0x1) == 0) ? 1 : -1;
/*     */       case 2:
/* 237 */         return (paramInt2 < 32) ? (1 << paramInt2) : 0;
/*     */       case -2:
/* 239 */         if (paramInt2 < 32) {
/* 240 */           return ((paramInt2 & 0x1) == 0) ? (1 << paramInt2) : -(1 << paramInt2);
/*     */         }
/* 242 */         return 0;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 247 */     for (int i = 1;; paramInt2 >>= 1) {
/* 248 */       switch (paramInt2) {
/*     */         case 0:
/* 250 */           return i;
/*     */         case 1:
/* 252 */           return paramInt1 * i;
/*     */       } 
/* 254 */       i *= ((paramInt2 & 0x1) == 0) ? 1 : paramInt1;
/* 255 */       paramInt1 *= paramInt1;
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
/*     */   @c
/*     */   public static int c(int paramInt, RoundingMode paramRoundingMode) {
/*     */     int j;
/* 270 */     h.b("x", paramInt);
/* 271 */     int i = O(paramInt);
/* 272 */     switch (null.S[paramRoundingMode.ordinal()]) {
/*     */       case 1:
/* 274 */         h.af((i * i == paramInt));
/*     */       case 2:
/*     */       case 3:
/* 277 */         return i;
/*     */       case 4:
/*     */       case 5:
/* 280 */         return i + n(i * i, paramInt);
/*     */       case 6:
/*     */       case 7:
/*     */       case 8:
/* 284 */         j = i * i + i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 296 */         return i + n(j, paramInt);
/*     */     } 
/* 298 */     throw new AssertionError();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int O(int paramInt) {
/* 305 */     return (int)Math.sqrt(paramInt);
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
/*     */   public static int a(int paramInt1, int paramInt2, RoundingMode paramRoundingMode) {
/*     */     // Byte code:
/*     */     //   0: aload_2
/*     */     //   1: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   4: pop
/*     */     //   5: iload_1
/*     */     //   6: ifne -> 19
/*     */     //   9: new java/lang/ArithmeticException
/*     */     //   12: dup
/*     */     //   13: ldc '/ by zero'
/*     */     //   15: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   18: athrow
/*     */     //   19: iload_0
/*     */     //   20: iload_1
/*     */     //   21: idiv
/*     */     //   22: istore_3
/*     */     //   23: iload_0
/*     */     //   24: iload_1
/*     */     //   25: iload_3
/*     */     //   26: imul
/*     */     //   27: isub
/*     */     //   28: istore #4
/*     */     //   30: iload #4
/*     */     //   32: ifne -> 37
/*     */     //   35: iload_3
/*     */     //   36: ireturn
/*     */     //   37: iconst_1
/*     */     //   38: iload_0
/*     */     //   39: iload_1
/*     */     //   40: ixor
/*     */     //   41: bipush #31
/*     */     //   43: ishr
/*     */     //   44: ior
/*     */     //   45: istore #5
/*     */     //   47: getstatic com/google/a/k/e$1.S : [I
/*     */     //   50: aload_2
/*     */     //   51: invokevirtual ordinal : ()I
/*     */     //   54: iaload
/*     */     //   55: tableswitch default -> 238, 1 -> 100, 2 -> 113, 3 -> 140, 4 -> 119, 5 -> 125, 6 -> 155, 7 -> 155, 8 -> 155
/*     */     //   100: iload #4
/*     */     //   102: ifne -> 109
/*     */     //   105: iconst_1
/*     */     //   106: goto -> 110
/*     */     //   109: iconst_0
/*     */     //   110: invokestatic af : (Z)V
/*     */     //   113: iconst_0
/*     */     //   114: istore #6
/*     */     //   116: goto -> 246
/*     */     //   119: iconst_1
/*     */     //   120: istore #6
/*     */     //   122: goto -> 246
/*     */     //   125: iload #5
/*     */     //   127: ifle -> 134
/*     */     //   130: iconst_1
/*     */     //   131: goto -> 135
/*     */     //   134: iconst_0
/*     */     //   135: istore #6
/*     */     //   137: goto -> 246
/*     */     //   140: iload #5
/*     */     //   142: ifge -> 149
/*     */     //   145: iconst_1
/*     */     //   146: goto -> 150
/*     */     //   149: iconst_0
/*     */     //   150: istore #6
/*     */     //   152: goto -> 246
/*     */     //   155: iload #4
/*     */     //   157: invokestatic abs : (I)I
/*     */     //   160: istore #7
/*     */     //   162: iload #7
/*     */     //   164: iload_1
/*     */     //   165: invokestatic abs : (I)I
/*     */     //   168: iload #7
/*     */     //   170: isub
/*     */     //   171: isub
/*     */     //   172: istore #8
/*     */     //   174: iload #8
/*     */     //   176: ifne -> 223
/*     */     //   179: aload_2
/*     */     //   180: getstatic java/math/RoundingMode.HALF_UP : Ljava/math/RoundingMode;
/*     */     //   183: if_acmpeq -> 213
/*     */     //   186: aload_2
/*     */     //   187: getstatic java/math/RoundingMode.HALF_EVEN : Ljava/math/RoundingMode;
/*     */     //   190: if_acmpne -> 197
/*     */     //   193: iconst_1
/*     */     //   194: goto -> 198
/*     */     //   197: iconst_0
/*     */     //   198: iload_3
/*     */     //   199: iconst_1
/*     */     //   200: iand
/*     */     //   201: ifeq -> 208
/*     */     //   204: iconst_1
/*     */     //   205: goto -> 209
/*     */     //   208: iconst_0
/*     */     //   209: iand
/*     */     //   210: ifeq -> 217
/*     */     //   213: iconst_1
/*     */     //   214: goto -> 218
/*     */     //   217: iconst_0
/*     */     //   218: istore #6
/*     */     //   220: goto -> 246
/*     */     //   223: iload #8
/*     */     //   225: ifle -> 232
/*     */     //   228: iconst_1
/*     */     //   229: goto -> 233
/*     */     //   232: iconst_0
/*     */     //   233: istore #6
/*     */     //   235: goto -> 246
/*     */     //   238: new java/lang/AssertionError
/*     */     //   241: dup
/*     */     //   242: invokespecial <init> : ()V
/*     */     //   245: athrow
/*     */     //   246: iload #6
/*     */     //   248: ifeq -> 258
/*     */     //   251: iload_3
/*     */     //   252: iload #5
/*     */     //   254: iadd
/*     */     //   255: goto -> 259
/*     */     //   258: iload_3
/*     */     //   259: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #317	-> 0
/*     */     //   #318	-> 5
/*     */     //   #319	-> 9
/*     */     //   #321	-> 19
/*     */     //   #322	-> 23
/*     */     //   #324	-> 30
/*     */     //   #325	-> 35
/*     */     //   #335	-> 37
/*     */     //   #337	-> 47
/*     */     //   #339	-> 100
/*     */     //   #342	-> 113
/*     */     //   #343	-> 116
/*     */     //   #345	-> 119
/*     */     //   #346	-> 122
/*     */     //   #348	-> 125
/*     */     //   #349	-> 137
/*     */     //   #351	-> 140
/*     */     //   #352	-> 152
/*     */     //   #356	-> 155
/*     */     //   #357	-> 162
/*     */     //   #360	-> 174
/*     */     //   #361	-> 179
/*     */     //   #363	-> 223
/*     */     //   #365	-> 235
/*     */     //   #367	-> 238
/*     */     //   #369	-> 246
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
/*     */   public static int p(int paramInt1, int paramInt2) {
/* 391 */     if (paramInt2 <= 0) {
/* 392 */       throw new ArithmeticException((new StringBuilder(31)).append("Modulus ").append(paramInt2).append(" must be > 0").toString());
/*     */     }
/* 394 */     int i = paramInt1 % paramInt2;
/* 395 */     return (i >= 0) ? i : (i + paramInt2);
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
/*     */   public static int q(int paramInt1, int paramInt2) {
/* 410 */     h.b("a", paramInt1);
/* 411 */     h.b("b", paramInt2);
/* 412 */     if (paramInt1 == 0)
/*     */     {
/*     */       
/* 415 */       return paramInt2; } 
/* 416 */     if (paramInt2 == 0) {
/* 417 */       return paramInt1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 423 */     int i = Integer.numberOfTrailingZeros(paramInt1);
/* 424 */     paramInt1 >>= i;
/* 425 */     int j = Integer.numberOfTrailingZeros(paramInt2);
/* 426 */     paramInt2 >>= j;
/* 427 */     while (paramInt1 != paramInt2) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 435 */       int k = paramInt1 - paramInt2;
/*     */       
/* 437 */       int m = k & k >> 31;
/*     */ 
/*     */       
/* 440 */       paramInt1 = k - m - m;
/*     */ 
/*     */       
/* 443 */       paramInt2 += m;
/* 444 */       paramInt1 >>= Integer.numberOfTrailingZeros(paramInt1);
/*     */     } 
/* 446 */     return paramInt1 << Math.min(i, j);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int r(int paramInt1, int paramInt2) {
/* 455 */     long l = paramInt1 + paramInt2;
/* 456 */     h.d((l == (int)l), "checkedAdd", paramInt1, paramInt2);
/* 457 */     return (int)l;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int s(int paramInt1, int paramInt2) {
/* 466 */     long l = paramInt1 - paramInt2;
/* 467 */     h.d((l == (int)l), "checkedSubtract", paramInt1, paramInt2);
/* 468 */     return (int)l;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int t(int paramInt1, int paramInt2) {
/* 477 */     long l = paramInt1 * paramInt2;
/* 478 */     h.d((l == (int)l), "checkedMultiply", paramInt1, paramInt2);
/* 479 */     return (int)l;
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
/*     */   public static int u(int paramInt1, int paramInt2) {
/* 491 */     h.b("exponent", paramInt2);
/* 492 */     switch (paramInt1) {
/*     */       case 0:
/* 494 */         return (paramInt2 == 0) ? 1 : 0;
/*     */       case 1:
/* 496 */         return 1;
/*     */       case -1:
/* 498 */         return ((paramInt2 & 0x1) == 0) ? 1 : -1;
/*     */       case 2:
/* 500 */         h.d((paramInt2 < 31), "checkedPow", paramInt1, paramInt2);
/* 501 */         return 1 << paramInt2;
/*     */       case -2:
/* 503 */         h.d((paramInt2 < 32), "checkedPow", paramInt1, paramInt2);
/* 504 */         return ((paramInt2 & 0x1) == 0) ? (1 << paramInt2) : (-1 << paramInt2);
/*     */     } 
/*     */ 
/*     */     
/* 508 */     int i = 1;
/*     */     while (true) {
/* 510 */       switch (paramInt2) {
/*     */         case 0:
/* 512 */           return i;
/*     */         case 1:
/* 514 */           return t(i, paramInt1);
/*     */       } 
/* 516 */       if ((paramInt2 & 0x1) != 0) {
/* 517 */         i = t(i, paramInt1);
/*     */       }
/* 519 */       paramInt2 >>= 1;
/* 520 */       if (paramInt2 > 0) {
/* 521 */         h.d(((-46340 <= paramInt1)) & ((paramInt1 <= 46340)), "checkedPow", paramInt1, paramInt2);
/* 522 */         paramInt1 *= paramInt1;
/*     */       } 
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
/*     */   @a
/*     */   public static int v(int paramInt1, int paramInt2) {
/* 536 */     return k.e(paramInt1 + paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   public static int w(int paramInt1, int paramInt2) {
/* 547 */     return k.e(paramInt1 - paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   public static int x(int paramInt1, int paramInt2) {
/* 558 */     return k.e(paramInt1 * paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   public static int y(int paramInt1, int paramInt2) {
/* 569 */     h.b("exponent", paramInt2);
/* 570 */     switch (paramInt1) {
/*     */       case 0:
/* 572 */         return (paramInt2 == 0) ? 1 : 0;
/*     */       case 1:
/* 574 */         return 1;
/*     */       case -1:
/* 576 */         return ((paramInt2 & 0x1) == 0) ? 1 : -1;
/*     */       case 2:
/* 578 */         if (paramInt2 >= 31) {
/* 579 */           return Integer.MAX_VALUE;
/*     */         }
/* 581 */         return 1 << paramInt2;
/*     */       case -2:
/* 583 */         if (paramInt2 >= 32) {
/* 584 */           return Integer.MAX_VALUE + (paramInt2 & 0x1);
/*     */         }
/* 586 */         return ((paramInt2 & 0x1) == 0) ? (1 << paramInt2) : (-1 << paramInt2);
/*     */     } 
/*     */ 
/*     */     
/* 590 */     int i = 1;
/*     */     
/* 592 */     int j = Integer.MAX_VALUE + (paramInt1 >>> 31 & paramInt2 & 0x1);
/*     */     while (true) {
/* 594 */       switch (paramInt2) {
/*     */         case 0:
/* 596 */           return i;
/*     */         case 1:
/* 598 */           return x(i, paramInt1);
/*     */       } 
/* 600 */       if ((paramInt2 & 0x1) != 0) {
/* 601 */         i = x(i, paramInt1);
/*     */       }
/* 603 */       paramInt2 >>= 1;
/* 604 */       if (paramInt2 > 0) {
/* 605 */         if ((((-46340 > paramInt1) ? 1 : 0) | ((paramInt1 > 46340) ? 1 : 0)) != 0) {
/* 606 */           return j;
/*     */         }
/* 608 */         paramInt1 *= paramInt1;
/*     */       } 
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
/*     */   public static int P(int paramInt) {
/* 623 */     h.b("n", paramInt);
/* 624 */     return (paramInt < W.length) ? W[paramInt] : Integer.MAX_VALUE;
/*     */   }
/*     */   
/* 627 */   private static final int[] W = new int[] { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int z(int paramInt1, int paramInt2) {
/* 650 */     h.b("n", paramInt1);
/* 651 */     h.b("k", paramInt2);
/* 652 */     D.a((paramInt2 <= paramInt1), "k (%s) > n (%s)", paramInt2, paramInt1);
/* 653 */     if (paramInt2 > paramInt1 >> 1) {
/* 654 */       paramInt2 = paramInt1 - paramInt2;
/*     */     }
/* 656 */     if (paramInt2 >= X.length || paramInt1 > X[paramInt2]) {
/* 657 */       return Integer.MAX_VALUE;
/*     */     }
/* 659 */     switch (paramInt2) {
/*     */       case 0:
/* 661 */         return 1;
/*     */       case 1:
/* 663 */         return paramInt1;
/*     */     } 
/* 665 */     long l = 1L;
/* 666 */     for (byte b = 0; b < paramInt2; b++) {
/* 667 */       l *= (paramInt1 - b);
/* 668 */       l /= (b + 1);
/*     */     } 
/* 670 */     return (int)l;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @d
/* 676 */   static int[] X = new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int A(int paramInt1, int paramInt2) {
/* 706 */     return (paramInt1 & paramInt2) + ((paramInt1 ^ paramInt2) >> 1);
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
/*     */   @c
/*     */   @a
/*     */   public static boolean q(int paramInt) {
/* 724 */     return g.h(paramInt);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\k\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */