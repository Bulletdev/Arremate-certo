/*      */ package org.apache.commons.lang3;
/*      */ 
/*      */ import java.util.UUID;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Conversion
/*      */ {
/*   66 */   private static final boolean[] TTTT = new boolean[] { true, true, true, true };
/*   67 */   private static final boolean[] FTTT = new boolean[] { false, true, true, true };
/*   68 */   private static final boolean[] TFTT = new boolean[] { true, false, true, true };
/*   69 */   private static final boolean[] FFTT = new boolean[] { false, false, true, true };
/*   70 */   private static final boolean[] TTFT = new boolean[] { true, true, false, true };
/*   71 */   private static final boolean[] FTFT = new boolean[] { false, true, false, true };
/*   72 */   private static final boolean[] TFFT = new boolean[] { true, false, false, true };
/*   73 */   private static final boolean[] FFFT = new boolean[] { false, false, false, true };
/*   74 */   private static final boolean[] TTTF = new boolean[] { true, true, true, false };
/*   75 */   private static final boolean[] FTTF = new boolean[] { false, true, true, false };
/*   76 */   private static final boolean[] TFTF = new boolean[] { true, false, true, false };
/*   77 */   private static final boolean[] FFTF = new boolean[] { false, false, true, false };
/*   78 */   private static final boolean[] TTFF = new boolean[] { true, true, false, false };
/*   79 */   private static final boolean[] FTFF = new boolean[] { false, true, false, false };
/*   80 */   private static final boolean[] TFFF = new boolean[] { true, false, false, false };
/*   81 */   private static final boolean[] FFFF = new boolean[] { false, false, false, false };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int hexDigitToInt(char paramChar) {
/*   96 */     int i = Character.digit(paramChar, 16);
/*   97 */     if (i < 0) {
/*   98 */       throw new IllegalArgumentException("Cannot interpret '" + paramChar + "' as a hexadecimal digit");
/*      */     }
/*  100 */     return i;
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
/*      */   public static int hexDigitMsb0ToInt(char paramChar) {
/*  116 */     switch (paramChar) {
/*      */       case '0':
/*  118 */         return 0;
/*      */       case '1':
/*  120 */         return 8;
/*      */       case '2':
/*  122 */         return 4;
/*      */       case '3':
/*  124 */         return 12;
/*      */       case '4':
/*  126 */         return 2;
/*      */       case '5':
/*  128 */         return 10;
/*      */       case '6':
/*  130 */         return 6;
/*      */       case '7':
/*  132 */         return 14;
/*      */       case '8':
/*  134 */         return 1;
/*      */       case '9':
/*  136 */         return 9;
/*      */       case 'A':
/*      */       case 'a':
/*  139 */         return 5;
/*      */       case 'B':
/*      */       case 'b':
/*  142 */         return 13;
/*      */       case 'C':
/*      */       case 'c':
/*  145 */         return 3;
/*      */       case 'D':
/*      */       case 'd':
/*  148 */         return 11;
/*      */       case 'E':
/*      */       case 'e':
/*  151 */         return 7;
/*      */       case 'F':
/*      */       case 'f':
/*  154 */         return 15;
/*      */     } 
/*  156 */     throw new IllegalArgumentException("Cannot interpret '" + paramChar + "' as a hexadecimal digit");
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
/*      */   public static boolean[] hexDigitToBinary(char paramChar) {
/*  174 */     switch (paramChar) {
/*      */       case '0':
/*  176 */         return (boolean[])FFFF.clone();
/*      */       case '1':
/*  178 */         return (boolean[])TFFF.clone();
/*      */       case '2':
/*  180 */         return (boolean[])FTFF.clone();
/*      */       case '3':
/*  182 */         return (boolean[])TTFF.clone();
/*      */       case '4':
/*  184 */         return (boolean[])FFTF.clone();
/*      */       case '5':
/*  186 */         return (boolean[])TFTF.clone();
/*      */       case '6':
/*  188 */         return (boolean[])FTTF.clone();
/*      */       case '7':
/*  190 */         return (boolean[])TTTF.clone();
/*      */       case '8':
/*  192 */         return (boolean[])FFFT.clone();
/*      */       case '9':
/*  194 */         return (boolean[])TFFT.clone();
/*      */       case 'A':
/*      */       case 'a':
/*  197 */         return (boolean[])FTFT.clone();
/*      */       case 'B':
/*      */       case 'b':
/*  200 */         return (boolean[])TTFT.clone();
/*      */       case 'C':
/*      */       case 'c':
/*  203 */         return (boolean[])FFTT.clone();
/*      */       case 'D':
/*      */       case 'd':
/*  206 */         return (boolean[])TFTT.clone();
/*      */       case 'E':
/*      */       case 'e':
/*  209 */         return (boolean[])FTTT.clone();
/*      */       case 'F':
/*      */       case 'f':
/*  212 */         return (boolean[])TTTT.clone();
/*      */     } 
/*  214 */     throw new IllegalArgumentException("Cannot interpret '" + paramChar + "' as a hexadecimal digit");
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
/*      */   public static boolean[] hexDigitMsb0ToBinary(char paramChar) {
/*  232 */     switch (paramChar) {
/*      */       case '0':
/*  234 */         return (boolean[])FFFF.clone();
/*      */       case '1':
/*  236 */         return (boolean[])FFFT.clone();
/*      */       case '2':
/*  238 */         return (boolean[])FFTF.clone();
/*      */       case '3':
/*  240 */         return (boolean[])FFTT.clone();
/*      */       case '4':
/*  242 */         return (boolean[])FTFF.clone();
/*      */       case '5':
/*  244 */         return (boolean[])FTFT.clone();
/*      */       case '6':
/*  246 */         return (boolean[])FTTF.clone();
/*      */       case '7':
/*  248 */         return (boolean[])FTTT.clone();
/*      */       case '8':
/*  250 */         return (boolean[])TFFF.clone();
/*      */       case '9':
/*  252 */         return (boolean[])TFFT.clone();
/*      */       case 'A':
/*      */       case 'a':
/*  255 */         return (boolean[])TFTF.clone();
/*      */       case 'B':
/*      */       case 'b':
/*  258 */         return (boolean[])TFTT.clone();
/*      */       case 'C':
/*      */       case 'c':
/*  261 */         return (boolean[])TTFF.clone();
/*      */       case 'D':
/*      */       case 'd':
/*  264 */         return (boolean[])TTFT.clone();
/*      */       case 'E':
/*      */       case 'e':
/*  267 */         return (boolean[])TTTF.clone();
/*      */       case 'F':
/*      */       case 'f':
/*  270 */         return (boolean[])TTTT.clone();
/*      */     } 
/*  272 */     throw new IllegalArgumentException("Cannot interpret '" + paramChar + "' as a hexadecimal digit");
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
/*      */   public static char binaryToHexDigit(boolean[] paramArrayOfboolean) {
/*  291 */     return binaryToHexDigit(paramArrayOfboolean, 0);
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
/*      */   public static char binaryToHexDigit(boolean[] paramArrayOfboolean, int paramInt) {
/*  310 */     if (paramArrayOfboolean.length == 0) {
/*  311 */       throw new IllegalArgumentException("Cannot convert an empty array.");
/*      */     }
/*  313 */     if (paramArrayOfboolean.length > paramInt + 3 && paramArrayOfboolean[paramInt + 3]) {
/*  314 */       if (paramArrayOfboolean[paramInt + 2]) {
/*  315 */         if (paramArrayOfboolean[paramInt + 1]) {
/*  316 */           return paramArrayOfboolean[paramInt] ? 'f' : 'e';
/*      */         }
/*  318 */         return paramArrayOfboolean[paramInt] ? 'd' : 'c';
/*      */       } 
/*  320 */       if (paramArrayOfboolean[paramInt + 1]) {
/*  321 */         return paramArrayOfboolean[paramInt] ? 'b' : 'a';
/*      */       }
/*  323 */       return paramArrayOfboolean[paramInt] ? '9' : '8';
/*      */     } 
/*  325 */     if (paramArrayOfboolean.length > paramInt + 2 && paramArrayOfboolean[paramInt + 2]) {
/*  326 */       if (paramArrayOfboolean[paramInt + 1]) {
/*  327 */         return paramArrayOfboolean[paramInt] ? '7' : '6';
/*      */       }
/*  329 */       return paramArrayOfboolean[paramInt] ? '5' : '4';
/*      */     } 
/*  331 */     if (paramArrayOfboolean.length > paramInt + 1 && paramArrayOfboolean[paramInt + 1]) {
/*  332 */       return paramArrayOfboolean[paramInt] ? '3' : '2';
/*      */     }
/*  334 */     return paramArrayOfboolean[paramInt] ? '1' : '0';
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
/*      */   public static char binaryToHexDigitMsb0_4bits(boolean[] paramArrayOfboolean) {
/*  353 */     return binaryToHexDigitMsb0_4bits(paramArrayOfboolean, 0);
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
/*      */   public static char binaryToHexDigitMsb0_4bits(boolean[] paramArrayOfboolean, int paramInt) {
/*  374 */     if (paramArrayOfboolean.length > 8) {
/*  375 */       throw new IllegalArgumentException("src.length>8: src.length=" + paramArrayOfboolean.length);
/*      */     }
/*  377 */     if (paramArrayOfboolean.length - paramInt < 4) {
/*  378 */       throw new IllegalArgumentException("src.length-srcPos<4: src.length=" + paramArrayOfboolean.length + ", srcPos=" + paramInt);
/*      */     }
/*  380 */     if (paramArrayOfboolean[paramInt + 3]) {
/*  381 */       if (paramArrayOfboolean[paramInt + 2]) {
/*  382 */         if (paramArrayOfboolean[paramInt + 1]) {
/*  383 */           return paramArrayOfboolean[paramInt] ? 'f' : '7';
/*      */         }
/*  385 */         return paramArrayOfboolean[paramInt] ? 'b' : '3';
/*      */       } 
/*  387 */       if (paramArrayOfboolean[paramInt + 1]) {
/*  388 */         return paramArrayOfboolean[paramInt] ? 'd' : '5';
/*      */       }
/*  390 */       return paramArrayOfboolean[paramInt] ? '9' : '1';
/*      */     } 
/*  392 */     if (paramArrayOfboolean[paramInt + 2]) {
/*  393 */       if (paramArrayOfboolean[paramInt + 1]) {
/*  394 */         return paramArrayOfboolean[paramInt] ? 'e' : '6';
/*      */       }
/*  396 */       return paramArrayOfboolean[paramInt] ? 'a' : '2';
/*      */     } 
/*  398 */     if (paramArrayOfboolean[paramInt + 1]) {
/*  399 */       return paramArrayOfboolean[paramInt] ? 'c' : '4';
/*      */     }
/*  401 */     return paramArrayOfboolean[paramInt] ? '8' : '0';
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
/*      */   public static char binaryBeMsb0ToHexDigit(boolean[] paramArrayOfboolean) {
/*  420 */     return binaryBeMsb0ToHexDigit(paramArrayOfboolean, 0);
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
/*      */   public static char binaryBeMsb0ToHexDigit(boolean[] paramArrayOfboolean, int paramInt) {
/*  440 */     if (paramArrayOfboolean.length == 0) {
/*  441 */       throw new IllegalArgumentException("Cannot convert an empty array.");
/*      */     }
/*  443 */     int i = paramArrayOfboolean.length - 1 - paramInt;
/*  444 */     int j = Math.min(4, i + 1);
/*  445 */     boolean[] arrayOfBoolean = new boolean[4];
/*  446 */     System.arraycopy(paramArrayOfboolean, i + 1 - j, arrayOfBoolean, 4 - j, j);
/*  447 */     paramArrayOfboolean = arrayOfBoolean;
/*  448 */     paramInt = 0;
/*  449 */     if (paramArrayOfboolean[paramInt]) {
/*  450 */       if (paramArrayOfboolean.length > paramInt + 1 && paramArrayOfboolean[paramInt + 1]) {
/*  451 */         if (paramArrayOfboolean.length > paramInt + 2 && paramArrayOfboolean[paramInt + 2]) {
/*  452 */           return (paramArrayOfboolean.length > paramInt + 3 && paramArrayOfboolean[paramInt + 3]) ? 'f' : 'e';
/*      */         }
/*  454 */         return (paramArrayOfboolean.length > paramInt + 3 && paramArrayOfboolean[paramInt + 3]) ? 'd' : 'c';
/*      */       } 
/*  456 */       if (paramArrayOfboolean.length > paramInt + 2 && paramArrayOfboolean[paramInt + 2]) {
/*  457 */         return (paramArrayOfboolean.length > paramInt + 3 && paramArrayOfboolean[paramInt + 3]) ? 'b' : 'a';
/*      */       }
/*  459 */       return (paramArrayOfboolean.length > paramInt + 3 && paramArrayOfboolean[paramInt + 3]) ? '9' : '8';
/*      */     } 
/*  461 */     if (paramArrayOfboolean.length > paramInt + 1 && paramArrayOfboolean[paramInt + 1]) {
/*  462 */       if (paramArrayOfboolean.length > paramInt + 2 && paramArrayOfboolean[paramInt + 2]) {
/*  463 */         return (paramArrayOfboolean.length > paramInt + 3 && paramArrayOfboolean[paramInt + 3]) ? '7' : '6';
/*      */       }
/*  465 */       return (paramArrayOfboolean.length > paramInt + 3 && paramArrayOfboolean[paramInt + 3]) ? '5' : '4';
/*      */     } 
/*  467 */     if (paramArrayOfboolean.length > paramInt + 2 && paramArrayOfboolean[paramInt + 2]) {
/*  468 */       return (paramArrayOfboolean.length > paramInt + 3 && paramArrayOfboolean[paramInt + 3]) ? '3' : '2';
/*      */     }
/*  470 */     return (paramArrayOfboolean.length > paramInt + 3 && paramArrayOfboolean[paramInt + 3]) ? '1' : '0';
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
/*      */   public static char intToHexDigit(int paramInt) {
/*  492 */     char c = Character.forDigit(paramInt, 16);
/*  493 */     if (c == '\000') {
/*  494 */       throw new IllegalArgumentException("nibble value not between 0 and 15: " + paramInt);
/*      */     }
/*  496 */     return c;
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
/*      */   public static char intToHexDigitMsb0(int paramInt) {
/*  518 */     switch (paramInt) {
/*      */       case 0:
/*  520 */         return '0';
/*      */       case 1:
/*  522 */         return '8';
/*      */       case 2:
/*  524 */         return '4';
/*      */       case 3:
/*  526 */         return 'c';
/*      */       case 4:
/*  528 */         return '2';
/*      */       case 5:
/*  530 */         return 'a';
/*      */       case 6:
/*  532 */         return '6';
/*      */       case 7:
/*  534 */         return 'e';
/*      */       case 8:
/*  536 */         return '1';
/*      */       case 9:
/*  538 */         return '9';
/*      */       case 10:
/*  540 */         return '5';
/*      */       case 11:
/*  542 */         return 'd';
/*      */       case 12:
/*  544 */         return '3';
/*      */       case 13:
/*  546 */         return 'b';
/*      */       case 14:
/*  548 */         return '7';
/*      */       case 15:
/*  550 */         return 'f';
/*      */     } 
/*  552 */     throw new IllegalArgumentException("nibble value not between 0 and 15: " + paramInt);
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
/*      */   public static long intArrayToLong(int[] paramArrayOfint, int paramInt1, long paramLong, int paramInt2, int paramInt3) {
/*  575 */     if ((paramArrayOfint.length == 0 && paramInt1 == 0) || 0 == paramInt3) {
/*  576 */       return paramLong;
/*      */     }
/*  578 */     if ((paramInt3 - 1) * 32 + paramInt2 >= 64) {
/*  579 */       throw new IllegalArgumentException("(nInts-1)*32+dstPos is greater or equal to than 64");
/*      */     }
/*  581 */     long l = paramLong;
/*  582 */     for (byte b = 0; b < paramInt3; b++) {
/*  583 */       int i = b * 32 + paramInt2;
/*  584 */       long l1 = (0xFFFFFFFFL & paramArrayOfint[b + paramInt1]) << i;
/*  585 */       long l2 = 4294967295L << i;
/*  586 */       l = l & (l2 ^ 0xFFFFFFFFFFFFFFFFL) | l1;
/*      */     } 
/*  588 */     return l;
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
/*      */   public static long shortArrayToLong(short[] paramArrayOfshort, int paramInt1, long paramLong, int paramInt2, int paramInt3) {
/*  610 */     if ((paramArrayOfshort.length == 0 && paramInt1 == 0) || 0 == paramInt3) {
/*  611 */       return paramLong;
/*      */     }
/*  613 */     if ((paramInt3 - 1) * 16 + paramInt2 >= 64) {
/*  614 */       throw new IllegalArgumentException("(nShorts-1)*16+dstPos is greater or equal to than 64");
/*      */     }
/*  616 */     long l = paramLong;
/*  617 */     for (byte b = 0; b < paramInt3; b++) {
/*  618 */       int i = b * 16 + paramInt2;
/*  619 */       long l1 = (0xFFFFL & paramArrayOfshort[b + paramInt1]) << i;
/*  620 */       long l2 = 65535L << i;
/*  621 */       l = l & (l2 ^ 0xFFFFFFFFFFFFFFFFL) | l1;
/*      */     } 
/*  623 */     return l;
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
/*      */   public static int shortArrayToInt(short[] paramArrayOfshort, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  645 */     if ((paramArrayOfshort.length == 0 && paramInt1 == 0) || 0 == paramInt4) {
/*  646 */       return paramInt2;
/*      */     }
/*  648 */     if ((paramInt4 - 1) * 16 + paramInt3 >= 32) {
/*  649 */       throw new IllegalArgumentException("(nShorts-1)*16+dstPos is greater or equal to than 32");
/*      */     }
/*  651 */     int i = paramInt2;
/*  652 */     for (byte b = 0; b < paramInt4; b++) {
/*  653 */       int j = b * 16 + paramInt3;
/*  654 */       int k = (0xFFFF & paramArrayOfshort[b + paramInt1]) << j;
/*  655 */       int m = 65535 << j;
/*  656 */       i = i & (m ^ 0xFFFFFFFF) | k;
/*      */     } 
/*  658 */     return i;
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
/*      */   public static long byteArrayToLong(byte[] paramArrayOfbyte, int paramInt1, long paramLong, int paramInt2, int paramInt3) {
/*  680 */     if ((paramArrayOfbyte.length == 0 && paramInt1 == 0) || 0 == paramInt3) {
/*  681 */       return paramLong;
/*      */     }
/*  683 */     if ((paramInt3 - 1) * 8 + paramInt2 >= 64) {
/*  684 */       throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greater or equal to than 64");
/*      */     }
/*  686 */     long l = paramLong;
/*  687 */     for (byte b = 0; b < paramInt3; b++) {
/*  688 */       int i = b * 8 + paramInt2;
/*  689 */       long l1 = (0xFFL & paramArrayOfbyte[b + paramInt1]) << i;
/*  690 */       long l2 = 255L << i;
/*  691 */       l = l & (l2 ^ 0xFFFFFFFFFFFFFFFFL) | l1;
/*      */     } 
/*  693 */     return l;
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
/*      */   public static int byteArrayToInt(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  715 */     if ((paramArrayOfbyte.length == 0 && paramInt1 == 0) || 0 == paramInt4) {
/*  716 */       return paramInt2;
/*      */     }
/*  718 */     if ((paramInt4 - 1) * 8 + paramInt3 >= 32) {
/*  719 */       throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greater or equal to than 32");
/*      */     }
/*  721 */     int i = paramInt2;
/*  722 */     for (byte b = 0; b < paramInt4; b++) {
/*  723 */       int j = b * 8 + paramInt3;
/*  724 */       int k = (0xFF & paramArrayOfbyte[b + paramInt1]) << j;
/*  725 */       int m = 255 << j;
/*  726 */       i = i & (m ^ 0xFFFFFFFF) | k;
/*      */     } 
/*  728 */     return i;
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
/*      */   public static short byteArrayToShort(byte[] paramArrayOfbyte, int paramInt1, short paramShort, int paramInt2, int paramInt3) {
/*  750 */     if ((paramArrayOfbyte.length == 0 && paramInt1 == 0) || 0 == paramInt3) {
/*  751 */       return paramShort;
/*      */     }
/*  753 */     if ((paramInt3 - 1) * 8 + paramInt2 >= 16) {
/*  754 */       throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greater or equal to than 16");
/*      */     }
/*  756 */     short s = paramShort;
/*  757 */     for (byte b = 0; b < paramInt3; b++) {
/*  758 */       int i = b * 8 + paramInt2;
/*  759 */       int j = (0xFF & paramArrayOfbyte[b + paramInt1]) << i;
/*  760 */       int k = 255 << i;
/*  761 */       s = (short)(s & (k ^ 0xFFFFFFFF) | j);
/*      */     } 
/*  763 */     return s;
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
/*      */   public static long hexToLong(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3) {
/*  783 */     if (0 == paramInt3) {
/*  784 */       return paramLong;
/*      */     }
/*  786 */     if ((paramInt3 - 1) * 4 + paramInt2 >= 64) {
/*  787 */       throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greater or equal to than 64");
/*      */     }
/*  789 */     long l = paramLong;
/*  790 */     for (byte b = 0; b < paramInt3; b++) {
/*  791 */       int i = b * 4 + paramInt2;
/*  792 */       long l1 = (0xFL & hexDigitToInt(paramString.charAt(b + paramInt1))) << i;
/*  793 */       long l2 = 15L << i;
/*  794 */       l = l & (l2 ^ 0xFFFFFFFFFFFFFFFFL) | l1;
/*      */     } 
/*  796 */     return l;
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
/*      */   public static int hexToInt(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  815 */     if (0 == paramInt4) {
/*  816 */       return paramInt2;
/*      */     }
/*  818 */     if ((paramInt4 - 1) * 4 + paramInt3 >= 32) {
/*  819 */       throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greater or equal to than 32");
/*      */     }
/*  821 */     int i = paramInt2;
/*  822 */     for (byte b = 0; b < paramInt4; b++) {
/*  823 */       int j = b * 4 + paramInt3;
/*  824 */       int k = (0xF & hexDigitToInt(paramString.charAt(b + paramInt1))) << j;
/*  825 */       int m = 15 << j;
/*  826 */       i = i & (m ^ 0xFFFFFFFF) | k;
/*      */     } 
/*  828 */     return i;
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
/*      */   public static short hexToShort(String paramString, int paramInt1, short paramShort, int paramInt2, int paramInt3) {
/*  848 */     if (0 == paramInt3) {
/*  849 */       return paramShort;
/*      */     }
/*  851 */     if ((paramInt3 - 1) * 4 + paramInt2 >= 16) {
/*  852 */       throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greater or equal to than 16");
/*      */     }
/*  854 */     short s = paramShort;
/*  855 */     for (byte b = 0; b < paramInt3; b++) {
/*  856 */       int i = b * 4 + paramInt2;
/*  857 */       int j = (0xF & hexDigitToInt(paramString.charAt(b + paramInt1))) << i;
/*  858 */       int k = 15 << i;
/*  859 */       s = (short)(s & (k ^ 0xFFFFFFFF) | j);
/*      */     } 
/*  861 */     return s;
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
/*      */   public static byte hexToByte(String paramString, int paramInt1, byte paramByte, int paramInt2, int paramInt3) {
/*  881 */     if (0 == paramInt3) {
/*  882 */       return paramByte;
/*      */     }
/*  884 */     if ((paramInt3 - 1) * 4 + paramInt2 >= 8) {
/*  885 */       throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greater or equal to than 8");
/*      */     }
/*  887 */     byte b = paramByte;
/*  888 */     for (byte b1 = 0; b1 < paramInt3; b1++) {
/*  889 */       int i = b1 * 4 + paramInt2;
/*  890 */       int j = (0xF & hexDigitToInt(paramString.charAt(b1 + paramInt1))) << i;
/*  891 */       int k = 15 << i;
/*  892 */       b = (byte)(b & (k ^ 0xFFFFFFFF) | j);
/*      */     } 
/*  894 */     return b;
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
/*      */   public static long binaryToLong(boolean[] paramArrayOfboolean, int paramInt1, long paramLong, int paramInt2, int paramInt3) {
/*  916 */     if ((paramArrayOfboolean.length == 0 && paramInt1 == 0) || 0 == paramInt3) {
/*  917 */       return paramLong;
/*      */     }
/*  919 */     if (paramInt3 - 1 + paramInt2 >= 64) {
/*  920 */       throw new IllegalArgumentException("nBools-1+dstPos is greater or equal to than 64");
/*      */     }
/*  922 */     long l = paramLong;
/*  923 */     for (byte b = 0; b < paramInt3; b++) {
/*  924 */       int i = b + paramInt2;
/*  925 */       long l1 = (paramArrayOfboolean[b + paramInt1] ? 1L : 0L) << i;
/*  926 */       long l2 = 1L << i;
/*  927 */       l = l & (l2 ^ 0xFFFFFFFFFFFFFFFFL) | l1;
/*      */     } 
/*  929 */     return l;
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
/*      */   public static int binaryToInt(boolean[] paramArrayOfboolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  951 */     if ((paramArrayOfboolean.length == 0 && paramInt1 == 0) || 0 == paramInt4) {
/*  952 */       return paramInt2;
/*      */     }
/*  954 */     if (paramInt4 - 1 + paramInt3 >= 32) {
/*  955 */       throw new IllegalArgumentException("nBools-1+dstPos is greater or equal to than 32");
/*      */     }
/*  957 */     int i = paramInt2;
/*  958 */     for (byte b = 0; b < paramInt4; b++) {
/*  959 */       int j = b + paramInt3;
/*  960 */       int k = (paramArrayOfboolean[b + paramInt1] ? 1 : 0) << j;
/*  961 */       int m = 1 << j;
/*  962 */       i = i & (m ^ 0xFFFFFFFF) | k;
/*      */     } 
/*  964 */     return i;
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
/*      */   public static short binaryToShort(boolean[] paramArrayOfboolean, int paramInt1, short paramShort, int paramInt2, int paramInt3) {
/*  986 */     if ((paramArrayOfboolean.length == 0 && paramInt1 == 0) || 0 == paramInt3) {
/*  987 */       return paramShort;
/*      */     }
/*  989 */     if (paramInt3 - 1 + paramInt2 >= 16) {
/*  990 */       throw new IllegalArgumentException("nBools-1+dstPos is greater or equal to than 16");
/*      */     }
/*  992 */     short s = paramShort;
/*  993 */     for (byte b = 0; b < paramInt3; b++) {
/*  994 */       int i = b + paramInt2;
/*  995 */       int j = (paramArrayOfboolean[b + paramInt1] ? 1 : 0) << i;
/*  996 */       int k = 1 << i;
/*  997 */       s = (short)(s & (k ^ 0xFFFFFFFF) | j);
/*      */     } 
/*  999 */     return s;
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
/*      */   public static byte binaryToByte(boolean[] paramArrayOfboolean, int paramInt1, byte paramByte, int paramInt2, int paramInt3) {
/* 1021 */     if ((paramArrayOfboolean.length == 0 && paramInt1 == 0) || 0 == paramInt3) {
/* 1022 */       return paramByte;
/*      */     }
/* 1024 */     if (paramInt3 - 1 + paramInt2 >= 8) {
/* 1025 */       throw new IllegalArgumentException("nBools-1+dstPos is greater or equal to than 8");
/*      */     }
/* 1027 */     byte b = paramByte;
/* 1028 */     for (byte b1 = 0; b1 < paramInt3; b1++) {
/* 1029 */       int i = b1 + paramInt2;
/* 1030 */       int j = (paramArrayOfboolean[b1 + paramInt1] ? 1 : 0) << i;
/* 1031 */       int k = 1 << i;
/* 1032 */       b = (byte)(b & (k ^ 0xFFFFFFFF) | j);
/*      */     } 
/* 1034 */     return b;
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
/*      */   public static int[] longToIntArray(long paramLong, int paramInt1, int[] paramArrayOfint, int paramInt2, int paramInt3) {
/* 1056 */     if (0 == paramInt3) {
/* 1057 */       return paramArrayOfint;
/*      */     }
/* 1059 */     if ((paramInt3 - 1) * 32 + paramInt1 >= 64) {
/* 1060 */       throw new IllegalArgumentException("(nInts-1)*32+srcPos is greater or equal to than 64");
/*      */     }
/* 1062 */     for (byte b = 0; b < paramInt3; b++) {
/* 1063 */       int i = b * 32 + paramInt1;
/* 1064 */       paramArrayOfint[paramInt2 + b] = (int)(0xFFFFFFFFFFFFFFFFL & paramLong >> i);
/*      */     } 
/* 1066 */     return paramArrayOfint;
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
/*      */   public static short[] longToShortArray(long paramLong, int paramInt1, short[] paramArrayOfshort, int paramInt2, int paramInt3) {
/* 1088 */     if (0 == paramInt3) {
/* 1089 */       return paramArrayOfshort;
/*      */     }
/* 1091 */     if ((paramInt3 - 1) * 16 + paramInt1 >= 64) {
/* 1092 */       throw new IllegalArgumentException("(nShorts-1)*16+srcPos is greater or equal to than 64");
/*      */     }
/* 1094 */     for (byte b = 0; b < paramInt3; b++) {
/* 1095 */       int i = b * 16 + paramInt1;
/* 1096 */       paramArrayOfshort[paramInt2 + b] = (short)(int)(0xFFFFL & paramLong >> i);
/*      */     } 
/* 1098 */     return paramArrayOfshort;
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
/*      */   public static short[] intToShortArray(int paramInt1, int paramInt2, short[] paramArrayOfshort, int paramInt3, int paramInt4) {
/* 1120 */     if (0 == paramInt4) {
/* 1121 */       return paramArrayOfshort;
/*      */     }
/* 1123 */     if ((paramInt4 - 1) * 16 + paramInt2 >= 32) {
/* 1124 */       throw new IllegalArgumentException("(nShorts-1)*16+srcPos is greater or equal to than 32");
/*      */     }
/* 1126 */     for (byte b = 0; b < paramInt4; b++) {
/* 1127 */       int i = b * 16 + paramInt2;
/* 1128 */       paramArrayOfshort[paramInt3 + b] = (short)(0xFFFF & paramInt1 >> i);
/*      */     } 
/* 1130 */     return paramArrayOfshort;
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
/*      */   public static byte[] longToByteArray(long paramLong, int paramInt1, byte[] paramArrayOfbyte, int paramInt2, int paramInt3) {
/* 1152 */     if (0 == paramInt3) {
/* 1153 */       return paramArrayOfbyte;
/*      */     }
/* 1155 */     if ((paramInt3 - 1) * 8 + paramInt1 >= 64) {
/* 1156 */       throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greater or equal to than 64");
/*      */     }
/* 1158 */     for (byte b = 0; b < paramInt3; b++) {
/* 1159 */       int i = b * 8 + paramInt1;
/* 1160 */       paramArrayOfbyte[paramInt2 + b] = (byte)(int)(0xFFL & paramLong >> i);
/*      */     } 
/* 1162 */     return paramArrayOfbyte;
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
/*      */   public static byte[] intToByteArray(int paramInt1, int paramInt2, byte[] paramArrayOfbyte, int paramInt3, int paramInt4) {
/* 1184 */     if (0 == paramInt4) {
/* 1185 */       return paramArrayOfbyte;
/*      */     }
/* 1187 */     if ((paramInt4 - 1) * 8 + paramInt2 >= 32) {
/* 1188 */       throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greater or equal to than 32");
/*      */     }
/* 1190 */     for (byte b = 0; b < paramInt4; b++) {
/* 1191 */       int i = b * 8 + paramInt2;
/* 1192 */       paramArrayOfbyte[paramInt3 + b] = (byte)(0xFF & paramInt1 >> i);
/*      */     } 
/* 1194 */     return paramArrayOfbyte;
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
/*      */   public static byte[] shortToByteArray(short paramShort, int paramInt1, byte[] paramArrayOfbyte, int paramInt2, int paramInt3) {
/* 1216 */     if (0 == paramInt3) {
/* 1217 */       return paramArrayOfbyte;
/*      */     }
/* 1219 */     if ((paramInt3 - 1) * 8 + paramInt1 >= 16) {
/* 1220 */       throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greater or equal to than 16");
/*      */     }
/* 1222 */     for (byte b = 0; b < paramInt3; b++) {
/* 1223 */       int i = b * 8 + paramInt1;
/* 1224 */       paramArrayOfbyte[paramInt2 + b] = (byte)(0xFF & paramShort >> i);
/*      */     } 
/* 1226 */     return paramArrayOfbyte;
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
/*      */   public static String longToHex(long paramLong, int paramInt1, String paramString, int paramInt2, int paramInt3) {
/* 1247 */     if (0 == paramInt3) {
/* 1248 */       return paramString;
/*      */     }
/* 1250 */     if ((paramInt3 - 1) * 4 + paramInt1 >= 64) {
/* 1251 */       throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greater or equal to than 64");
/*      */     }
/* 1253 */     StringBuilder stringBuilder = new StringBuilder(paramString);
/* 1254 */     int i = stringBuilder.length();
/* 1255 */     for (byte b = 0; b < paramInt3; b++) {
/* 1256 */       int j = b * 4 + paramInt1;
/* 1257 */       int k = (int)(0xFL & paramLong >> j);
/* 1258 */       if (paramInt2 + b == i) {
/* 1259 */         i++;
/* 1260 */         stringBuilder.append(intToHexDigit(k));
/*      */       } else {
/* 1262 */         stringBuilder.setCharAt(paramInt2 + b, intToHexDigit(k));
/*      */       } 
/*      */     } 
/* 1265 */     return stringBuilder.toString();
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
/*      */   public static String intToHex(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4) {
/* 1286 */     if (0 == paramInt4) {
/* 1287 */       return paramString;
/*      */     }
/* 1289 */     if ((paramInt4 - 1) * 4 + paramInt2 >= 32) {
/* 1290 */       throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greater or equal to than 32");
/*      */     }
/* 1292 */     StringBuilder stringBuilder = new StringBuilder(paramString);
/* 1293 */     int i = stringBuilder.length();
/* 1294 */     for (byte b = 0; b < paramInt4; b++) {
/* 1295 */       int j = b * 4 + paramInt2;
/* 1296 */       int k = 0xF & paramInt1 >> j;
/* 1297 */       if (paramInt3 + b == i) {
/* 1298 */         i++;
/* 1299 */         stringBuilder.append(intToHexDigit(k));
/*      */       } else {
/* 1301 */         stringBuilder.setCharAt(paramInt3 + b, intToHexDigit(k));
/*      */       } 
/*      */     } 
/* 1304 */     return stringBuilder.toString();
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
/*      */   public static String shortToHex(short paramShort, int paramInt1, String paramString, int paramInt2, int paramInt3) {
/* 1325 */     if (0 == paramInt3) {
/* 1326 */       return paramString;
/*      */     }
/* 1328 */     if ((paramInt3 - 1) * 4 + paramInt1 >= 16) {
/* 1329 */       throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greater or equal to than 16");
/*      */     }
/* 1331 */     StringBuilder stringBuilder = new StringBuilder(paramString);
/* 1332 */     int i = stringBuilder.length();
/* 1333 */     for (byte b = 0; b < paramInt3; b++) {
/* 1334 */       int j = b * 4 + paramInt1;
/* 1335 */       int k = 0xF & paramShort >> j;
/* 1336 */       if (paramInt2 + b == i) {
/* 1337 */         i++;
/* 1338 */         stringBuilder.append(intToHexDigit(k));
/*      */       } else {
/* 1340 */         stringBuilder.setCharAt(paramInt2 + b, intToHexDigit(k));
/*      */       } 
/*      */     } 
/* 1343 */     return stringBuilder.toString();
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
/*      */   public static String byteToHex(byte paramByte, int paramInt1, String paramString, int paramInt2, int paramInt3) {
/* 1364 */     if (0 == paramInt3) {
/* 1365 */       return paramString;
/*      */     }
/* 1367 */     if ((paramInt3 - 1) * 4 + paramInt1 >= 8) {
/* 1368 */       throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greater or equal to than 8");
/*      */     }
/* 1370 */     StringBuilder stringBuilder = new StringBuilder(paramString);
/* 1371 */     int i = stringBuilder.length();
/* 1372 */     for (byte b = 0; b < paramInt3; b++) {
/* 1373 */       int j = b * 4 + paramInt1;
/* 1374 */       int k = 0xF & paramByte >> j;
/* 1375 */       if (paramInt2 + b == i) {
/* 1376 */         i++;
/* 1377 */         stringBuilder.append(intToHexDigit(k));
/*      */       } else {
/* 1379 */         stringBuilder.setCharAt(paramInt2 + b, intToHexDigit(k));
/*      */       } 
/*      */     } 
/* 1382 */     return stringBuilder.toString();
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
/*      */   public static boolean[] longToBinary(long paramLong, int paramInt1, boolean[] paramArrayOfboolean, int paramInt2, int paramInt3) {
/* 1404 */     if (0 == paramInt3) {
/* 1405 */       return paramArrayOfboolean;
/*      */     }
/* 1407 */     if (paramInt3 - 1 + paramInt1 >= 64) {
/* 1408 */       throw new IllegalArgumentException("nBools-1+srcPos is greater or equal to than 64");
/*      */     }
/* 1410 */     for (byte b = 0; b < paramInt3; b++) {
/* 1411 */       int i = b + paramInt1;
/* 1412 */       paramArrayOfboolean[paramInt2 + b] = ((0x1L & paramLong >> i) != 0L);
/*      */     } 
/* 1414 */     return paramArrayOfboolean;
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
/*      */   public static boolean[] intToBinary(int paramInt1, int paramInt2, boolean[] paramArrayOfboolean, int paramInt3, int paramInt4) {
/* 1436 */     if (0 == paramInt4) {
/* 1437 */       return paramArrayOfboolean;
/*      */     }
/* 1439 */     if (paramInt4 - 1 + paramInt2 >= 32) {
/* 1440 */       throw new IllegalArgumentException("nBools-1+srcPos is greater or equal to than 32");
/*      */     }
/* 1442 */     for (byte b = 0; b < paramInt4; b++) {
/* 1443 */       int i = b + paramInt2;
/* 1444 */       paramArrayOfboolean[paramInt3 + b] = ((0x1 & paramInt1 >> i) != 0);
/*      */     } 
/* 1446 */     return paramArrayOfboolean;
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
/*      */   public static boolean[] shortToBinary(short paramShort, int paramInt1, boolean[] paramArrayOfboolean, int paramInt2, int paramInt3) {
/* 1468 */     if (0 == paramInt3) {
/* 1469 */       return paramArrayOfboolean;
/*      */     }
/* 1471 */     if (paramInt3 - 1 + paramInt1 >= 16) {
/* 1472 */       throw new IllegalArgumentException("nBools-1+srcPos is greater or equal to than 16");
/*      */     }
/* 1474 */     assert paramInt3 - 1 < 16 - paramInt1;
/* 1475 */     for (byte b = 0; b < paramInt3; b++) {
/* 1476 */       int i = b + paramInt1;
/* 1477 */       paramArrayOfboolean[paramInt2 + b] = ((0x1 & paramShort >> i) != 0);
/*      */     } 
/* 1479 */     return paramArrayOfboolean;
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
/*      */   public static boolean[] byteToBinary(byte paramByte, int paramInt1, boolean[] paramArrayOfboolean, int paramInt2, int paramInt3) {
/* 1501 */     if (0 == paramInt3) {
/* 1502 */       return paramArrayOfboolean;
/*      */     }
/* 1504 */     if (paramInt3 - 1 + paramInt1 >= 8) {
/* 1505 */       throw new IllegalArgumentException("nBools-1+srcPos is greater or equal to than 8");
/*      */     }
/* 1507 */     for (byte b = 0; b < paramInt3; b++) {
/* 1508 */       int i = b + paramInt1;
/* 1509 */       paramArrayOfboolean[paramInt2 + b] = ((0x1 & paramByte >> i) != 0);
/*      */     } 
/* 1511 */     return paramArrayOfboolean;
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
/*      */   public static byte[] uuidToByteArray(UUID paramUUID, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 1531 */     if (0 == paramInt2) {
/* 1532 */       return paramArrayOfbyte;
/*      */     }
/* 1534 */     if (paramInt2 > 16) {
/* 1535 */       throw new IllegalArgumentException("nBytes is greater than 16");
/*      */     }
/* 1537 */     longToByteArray(paramUUID.getMostSignificantBits(), 0, paramArrayOfbyte, paramInt1, Math.min(paramInt2, 8));
/* 1538 */     if (paramInt2 >= 8) {
/* 1539 */       longToByteArray(paramUUID.getLeastSignificantBits(), 0, paramArrayOfbyte, paramInt1 + 8, paramInt2 - 8);
/*      */     }
/* 1541 */     return paramArrayOfbyte;
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
/*      */   public static UUID byteArrayToUuid(byte[] paramArrayOfbyte, int paramInt) {
/* 1558 */     if (paramArrayOfbyte.length - paramInt < 16) {
/* 1559 */       throw new IllegalArgumentException("Need at least 16 bytes for UUID");
/*      */     }
/* 1561 */     return new UUID(byteArrayToLong(paramArrayOfbyte, paramInt, 0L, 0, 8), byteArrayToLong(paramArrayOfbyte, paramInt + 8, 0L, 0, 8));
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\Conversion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */