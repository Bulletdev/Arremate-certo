/*      */ package org.apache.commons.codec.digest;
/*      */ 
/*      */ import org.apache.commons.codec.binary.StringUtils;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class MurmurHash3
/*      */ {
/*      */   @Deprecated
/*      */   public static final long NULL_HASHCODE = 2862933555777941757L;
/*      */   public static final int DEFAULT_SEED = 104729;
/*      */   static final int LONG_BYTES = 8;
/*      */   static final int INTEGER_BYTES = 4;
/*      */   static final int SHORT_BYTES = 2;
/*      */   private static final int C1_32 = -862048943;
/*      */   private static final int C2_32 = 461845907;
/*      */   private static final int R1_32 = 15;
/*      */   private static final int R2_32 = 13;
/*      */   private static final int M_32 = 5;
/*      */   private static final int N_32 = -430675100;
/*      */   private static final long C1 = -8663945395140668459L;
/*      */   private static final long C2 = 5545529020109919103L;
/*      */   private static final int R1 = 31;
/*      */   private static final int R2 = 27;
/*      */   private static final int R3 = 33;
/*      */   private static final int M = 5;
/*      */   private static final int N1 = 1390208809;
/*      */   private static final int N2 = 944331445;
/*      */   
/*      */   public static int hash32(long paramLong1, long paramLong2) {
/*  124 */     return hash32(paramLong1, paramLong2, 104729);
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
/*      */   public static int hash32(long paramLong1, long paramLong2, int paramInt) {
/*  146 */     int i = paramInt;
/*  147 */     long l1 = Long.reverseBytes(paramLong1);
/*  148 */     long l2 = Long.reverseBytes(paramLong2);
/*      */     
/*  150 */     i = mix32((int)l1, i);
/*  151 */     i = mix32((int)(l1 >>> 32L), i);
/*  152 */     i = mix32((int)l2, i);
/*  153 */     i = mix32((int)(l2 >>> 32L), i);
/*      */     
/*  155 */     i ^= 0x10;
/*  156 */     return fmix32(i);
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
/*      */   public static int hash32(long paramLong) {
/*  176 */     return hash32(paramLong, 104729);
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
/*      */   public static int hash32(long paramLong, int paramInt) {
/*  196 */     int i = paramInt;
/*  197 */     long l = Long.reverseBytes(paramLong);
/*      */     
/*  199 */     i = mix32((int)l, i);
/*  200 */     i = mix32((int)(l >>> 32L), i);
/*      */     
/*  202 */     i ^= 0x8;
/*  203 */     return fmix32(i);
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
/*      */   @Deprecated
/*      */   public static int hash32(byte[] paramArrayOfbyte) {
/*  227 */     return hash32(paramArrayOfbyte, 0, paramArrayOfbyte.length, 104729);
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
/*      */   @Deprecated
/*      */   public static int hash32(String paramString) {
/*  257 */     byte[] arrayOfByte = StringUtils.getBytesUtf8(paramString);
/*  258 */     return hash32(arrayOfByte, 0, arrayOfByte.length, 104729);
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
/*      */   @Deprecated
/*      */   public static int hash32(byte[] paramArrayOfbyte, int paramInt) {
/*  283 */     return hash32(paramArrayOfbyte, paramInt, 104729);
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
/*      */   @Deprecated
/*      */   public static int hash32(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  308 */     return hash32(paramArrayOfbyte, 0, paramInt1, paramInt2);
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
/*      */   @Deprecated
/*      */   public static int hash32(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
/*  330 */     int i = paramInt3;
/*  331 */     int j = paramInt2 >> 2;
/*      */     
/*      */     int k;
/*  334 */     for (k = 0; k < j; k++) {
/*  335 */       int n = paramInt1 + (k << 2);
/*  336 */       int i1 = getLittleEndianInt(paramArrayOfbyte, n);
/*  337 */       i = mix32(i1, i);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  344 */     k = paramInt1 + (j << 2);
/*  345 */     int m = 0;
/*  346 */     switch (paramInt1 + paramInt2 - k) {
/*      */       case 3:
/*  348 */         m ^= paramArrayOfbyte[k + 2] << 16;
/*      */       case 2:
/*  350 */         m ^= paramArrayOfbyte[k + 1] << 8;
/*      */       case 1:
/*  352 */         m ^= paramArrayOfbyte[k];
/*      */ 
/*      */         
/*  355 */         m *= -862048943;
/*  356 */         m = Integer.rotateLeft(m, 15);
/*  357 */         m *= 461845907;
/*  358 */         i ^= m;
/*      */         break;
/*      */     } 
/*  361 */     i ^= paramInt2;
/*  362 */     return fmix32(i);
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
/*      */   public static int hash32x86(byte[] paramArrayOfbyte) {
/*  381 */     return hash32x86(paramArrayOfbyte, 0, paramArrayOfbyte.length, 0);
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
/*      */   public static int hash32x86(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
/*  398 */     int i = paramInt3;
/*  399 */     int j = paramInt2 >> 2;
/*      */     
/*      */     int k;
/*  402 */     for (k = 0; k < j; k++) {
/*  403 */       int n = paramInt1 + (k << 2);
/*  404 */       int i1 = getLittleEndianInt(paramArrayOfbyte, n);
/*  405 */       i = mix32(i1, i);
/*      */     } 
/*      */ 
/*      */     
/*  409 */     k = paramInt1 + (j << 2);
/*  410 */     int m = 0;
/*  411 */     switch (paramInt1 + paramInt2 - k) {
/*      */       case 3:
/*  413 */         m ^= (paramArrayOfbyte[k + 2] & 0xFF) << 16;
/*      */       case 2:
/*  415 */         m ^= (paramArrayOfbyte[k + 1] & 0xFF) << 8;
/*      */       case 1:
/*  417 */         m ^= paramArrayOfbyte[k] & 0xFF;
/*      */ 
/*      */         
/*  420 */         m *= -862048943;
/*  421 */         m = Integer.rotateLeft(m, 15);
/*  422 */         m *= 461845907;
/*  423 */         i ^= m;
/*      */         break;
/*      */     } 
/*  426 */     i ^= paramInt2;
/*  427 */     return fmix32(i);
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
/*      */   @Deprecated
/*      */   public static long hash64(long paramLong) {
/*  461 */     long l1 = 104729L;
/*  462 */     long l2 = Long.reverseBytes(paramLong);
/*  463 */     byte b = 8;
/*      */     
/*  465 */     l2 *= -8663945395140668459L;
/*  466 */     l2 = Long.rotateLeft(l2, 31);
/*  467 */     l2 *= 5545529020109919103L;
/*  468 */     l1 ^= l2;
/*  469 */     l1 = Long.rotateLeft(l1, 27) * 5L + 1390208809L;
/*      */     
/*  471 */     l1 ^= 0x8L;
/*  472 */     l1 = fmix64(l1);
/*  473 */     return l1;
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
/*      */   @Deprecated
/*      */   public static long hash64(int paramInt) {
/*  507 */     long l1 = Integer.reverseBytes(paramInt) & 0xFFFFFFFFL;
/*  508 */     byte b = 4;
/*  509 */     long l2 = 104729L;
/*  510 */     l1 *= -8663945395140668459L;
/*  511 */     l1 = Long.rotateLeft(l1, 31);
/*  512 */     l1 *= 5545529020109919103L;
/*  513 */     l2 ^= l1;
/*      */     
/*  515 */     l2 ^= 0x4L;
/*  516 */     l2 = fmix64(l2);
/*  517 */     return l2;
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
/*      */   @Deprecated
/*      */   public static long hash64(short paramShort) {
/*  551 */     long l1 = 104729L;
/*  552 */     long l2 = 0L;
/*  553 */     l2 ^= (paramShort & 0xFFL) << 8L;
/*  554 */     l2 ^= ((paramShort & 0xFF00) >> 8) & 0xFFL;
/*  555 */     l2 *= -8663945395140668459L;
/*  556 */     l2 = Long.rotateLeft(l2, 31);
/*  557 */     l2 *= 5545529020109919103L;
/*  558 */     l1 ^= l2;
/*      */ 
/*      */     
/*  561 */     l1 ^= 0x2L;
/*  562 */     l1 = fmix64(l1);
/*  563 */     return l1;
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
/*      */   @Deprecated
/*      */   public static long hash64(byte[] paramArrayOfbyte) {
/*  595 */     return hash64(paramArrayOfbyte, 0, paramArrayOfbyte.length, 104729);
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
/*      */   @Deprecated
/*      */   public static long hash64(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  628 */     return hash64(paramArrayOfbyte, paramInt1, paramInt2, 104729);
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
/*      */   @Deprecated
/*      */   public static long hash64(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
/*  664 */     long l1 = paramInt3;
/*  665 */     int i = paramInt2 >> 3;
/*      */ 
/*      */     
/*  668 */     for (byte b = 0; b < i; b++) {
/*  669 */       int k = paramInt1 + (b << 3);
/*  670 */       long l = getLittleEndianLong(paramArrayOfbyte, k);
/*      */ 
/*      */       
/*  673 */       l *= -8663945395140668459L;
/*  674 */       l = Long.rotateLeft(l, 31);
/*  675 */       l *= 5545529020109919103L;
/*  676 */       l1 ^= l;
/*  677 */       l1 = Long.rotateLeft(l1, 27) * 5L + 1390208809L;
/*      */     } 
/*      */ 
/*      */     
/*  681 */     long l2 = 0L;
/*  682 */     int j = paramInt1 + (i << 3);
/*  683 */     switch (paramInt1 + paramInt2 - j) {
/*      */       case 7:
/*  685 */         l2 ^= (paramArrayOfbyte[j + 6] & 0xFFL) << 48L;
/*      */       case 6:
/*  687 */         l2 ^= (paramArrayOfbyte[j + 5] & 0xFFL) << 40L;
/*      */       case 5:
/*  689 */         l2 ^= (paramArrayOfbyte[j + 4] & 0xFFL) << 32L;
/*      */       case 4:
/*  691 */         l2 ^= (paramArrayOfbyte[j + 3] & 0xFFL) << 24L;
/*      */       case 3:
/*  693 */         l2 ^= (paramArrayOfbyte[j + 2] & 0xFFL) << 16L;
/*      */       case 2:
/*  695 */         l2 ^= (paramArrayOfbyte[j + 1] & 0xFFL) << 8L;
/*      */       case 1:
/*  697 */         l2 ^= paramArrayOfbyte[j] & 0xFFL;
/*  698 */         l2 *= -8663945395140668459L;
/*  699 */         l2 = Long.rotateLeft(l2, 31);
/*  700 */         l2 *= 5545529020109919103L;
/*  701 */         l1 ^= l2;
/*      */         break;
/*      */     } 
/*      */     
/*  705 */     l1 ^= paramInt2;
/*  706 */     l1 = fmix64(l1);
/*      */     
/*  708 */     return l1;
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
/*      */   public static long[] hash128(byte[] paramArrayOfbyte) {
/*  729 */     return hash128(paramArrayOfbyte, 0, paramArrayOfbyte.length, 104729);
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
/*      */   public static long[] hash128x64(byte[] paramArrayOfbyte) {
/*  748 */     return hash128x64(paramArrayOfbyte, 0, paramArrayOfbyte.length, 0);
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
/*      */   @Deprecated
/*      */   public static long[] hash128(String paramString) {
/*  777 */     byte[] arrayOfByte = StringUtils.getBytesUtf8(paramString);
/*  778 */     return hash128(arrayOfByte, 0, arrayOfByte.length, 104729);
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
/*      */   @Deprecated
/*      */   public static long[] hash128(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
/*  805 */     return hash128x64Internal(paramArrayOfbyte, paramInt1, paramInt2, paramInt3);
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
/*      */   public static long[] hash128x64(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
/*  823 */     return hash128x64Internal(paramArrayOfbyte, paramInt1, paramInt2, paramInt3 & 0xFFFFFFFFL);
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
/*      */   private static long[] hash128x64Internal(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, long paramLong) {
/*  839 */     long l1 = paramLong;
/*  840 */     long l2 = paramLong;
/*  841 */     int i = paramInt2 >> 4;
/*      */ 
/*      */     
/*  844 */     for (byte b = 0; b < i; b++) {
/*  845 */       int k = paramInt1 + (b << 4);
/*  846 */       long l5 = getLittleEndianLong(paramArrayOfbyte, k);
/*  847 */       long l6 = getLittleEndianLong(paramArrayOfbyte, k + 8);
/*      */ 
/*      */       
/*  850 */       l5 *= -8663945395140668459L;
/*  851 */       l5 = Long.rotateLeft(l5, 31);
/*  852 */       l5 *= 5545529020109919103L;
/*  853 */       l1 ^= l5;
/*  854 */       l1 = Long.rotateLeft(l1, 27);
/*  855 */       l1 += l2;
/*  856 */       l1 = l1 * 5L + 1390208809L;
/*      */ 
/*      */       
/*  859 */       l6 *= 5545529020109919103L;
/*  860 */       l6 = Long.rotateLeft(l6, 33);
/*  861 */       l6 *= -8663945395140668459L;
/*  862 */       l2 ^= l6;
/*  863 */       l2 = Long.rotateLeft(l2, 31);
/*  864 */       l2 += l1;
/*  865 */       l2 = l2 * 5L + 944331445L;
/*      */     } 
/*      */ 
/*      */     
/*  869 */     long l3 = 0L;
/*  870 */     long l4 = 0L;
/*  871 */     int j = paramInt1 + (i << 4);
/*  872 */     switch (paramInt1 + paramInt2 - j) {
/*      */       case 15:
/*  874 */         l4 ^= (paramArrayOfbyte[j + 14] & 0xFFL) << 48L;
/*      */       case 14:
/*  876 */         l4 ^= (paramArrayOfbyte[j + 13] & 0xFFL) << 40L;
/*      */       case 13:
/*  878 */         l4 ^= (paramArrayOfbyte[j + 12] & 0xFFL) << 32L;
/*      */       case 12:
/*  880 */         l4 ^= (paramArrayOfbyte[j + 11] & 0xFFL) << 24L;
/*      */       case 11:
/*  882 */         l4 ^= (paramArrayOfbyte[j + 10] & 0xFFL) << 16L;
/*      */       case 10:
/*  884 */         l4 ^= (paramArrayOfbyte[j + 9] & 0xFFL) << 8L;
/*      */       case 9:
/*  886 */         l4 ^= (paramArrayOfbyte[j + 8] & 0xFF);
/*  887 */         l4 *= 5545529020109919103L;
/*  888 */         l4 = Long.rotateLeft(l4, 33);
/*  889 */         l4 *= -8663945395140668459L;
/*  890 */         l2 ^= l4;
/*      */       
/*      */       case 8:
/*  893 */         l3 ^= (paramArrayOfbyte[j + 7] & 0xFFL) << 56L;
/*      */       case 7:
/*  895 */         l3 ^= (paramArrayOfbyte[j + 6] & 0xFFL) << 48L;
/*      */       case 6:
/*  897 */         l3 ^= (paramArrayOfbyte[j + 5] & 0xFFL) << 40L;
/*      */       case 5:
/*  899 */         l3 ^= (paramArrayOfbyte[j + 4] & 0xFFL) << 32L;
/*      */       case 4:
/*  901 */         l3 ^= (paramArrayOfbyte[j + 3] & 0xFFL) << 24L;
/*      */       case 3:
/*  903 */         l3 ^= (paramArrayOfbyte[j + 2] & 0xFFL) << 16L;
/*      */       case 2:
/*  905 */         l3 ^= (paramArrayOfbyte[j + 1] & 0xFFL) << 8L;
/*      */       case 1:
/*  907 */         l3 ^= (paramArrayOfbyte[j] & 0xFF);
/*  908 */         l3 *= -8663945395140668459L;
/*  909 */         l3 = Long.rotateLeft(l3, 31);
/*  910 */         l3 *= 5545529020109919103L;
/*  911 */         l1 ^= l3;
/*      */         break;
/*      */     } 
/*      */     
/*  915 */     l1 ^= paramInt2;
/*  916 */     l2 ^= paramInt2;
/*      */     
/*  918 */     l1 += l2;
/*  919 */     l2 += l1;
/*      */     
/*  921 */     l1 = fmix64(l1);
/*  922 */     l2 = fmix64(l2);
/*      */     
/*  924 */     l1 += l2;
/*  925 */     l2 += l1;
/*      */     
/*  927 */     return new long[] { l1, l2 };
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static long getLittleEndianLong(byte[] paramArrayOfbyte, int paramInt) {
/*  938 */     return paramArrayOfbyte[paramInt] & 0xFFL | (paramArrayOfbyte[paramInt + 1] & 0xFFL) << 8L | (paramArrayOfbyte[paramInt + 2] & 0xFFL) << 16L | (paramArrayOfbyte[paramInt + 3] & 0xFFL) << 24L | (paramArrayOfbyte[paramInt + 4] & 0xFFL) << 32L | (paramArrayOfbyte[paramInt + 5] & 0xFFL) << 40L | (paramArrayOfbyte[paramInt + 6] & 0xFFL) << 48L | (paramArrayOfbyte[paramInt + 7] & 0xFFL) << 56L;
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
/*      */   private static int getLittleEndianInt(byte[] paramArrayOfbyte, int paramInt) {
/*  956 */     return paramArrayOfbyte[paramInt] & 0xFF | (paramArrayOfbyte[paramInt + 1] & 0xFF) << 8 | (paramArrayOfbyte[paramInt + 2] & 0xFF) << 16 | (paramArrayOfbyte[paramInt + 3] & 0xFF) << 24;
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
/*      */   private static int mix32(int paramInt1, int paramInt2) {
/*  970 */     paramInt1 *= -862048943;
/*  971 */     paramInt1 = Integer.rotateLeft(paramInt1, 15);
/*  972 */     paramInt1 *= 461845907;
/*  973 */     paramInt2 ^= paramInt1;
/*  974 */     return Integer.rotateLeft(paramInt2, 13) * 5 + -430675100;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int fmix32(int paramInt) {
/*  984 */     paramInt ^= paramInt >>> 16;
/*  985 */     paramInt *= -2048144789;
/*  986 */     paramInt ^= paramInt >>> 13;
/*  987 */     paramInt *= -1028477387;
/*  988 */     paramInt ^= paramInt >>> 16;
/*  989 */     return paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static long fmix64(long paramLong) {
/*  999 */     paramLong ^= paramLong >>> 33L;
/* 1000 */     paramLong *= -49064778989728563L;
/* 1001 */     paramLong ^= paramLong >>> 33L;
/* 1002 */     paramLong *= -4265267296055464877L;
/* 1003 */     paramLong ^= paramLong >>> 33L;
/* 1004 */     return paramLong;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class IncrementalHash32x86
/*      */   {
/*      */     private static final int BLOCK_SIZE = 4;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1022 */     private final byte[] unprocessed = new byte[3];
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private int unprocessedLength;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private int totalLen;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private int hash;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final void start(int param1Int) {
/* 1043 */       this.unprocessedLength = this.totalLen = 0;
/* 1044 */       this.hash = param1Int;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final void add(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
/*      */       int i, j;
/* 1055 */       if (param1Int2 <= 0) {
/*      */         return;
/*      */       }
/*      */       
/* 1059 */       this.totalLen += param1Int2;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1073 */       if (this.unprocessedLength + param1Int2 - 4 < 0) {
/*      */         
/* 1075 */         System.arraycopy(param1ArrayOfbyte, param1Int1, this.unprocessed, this.unprocessedLength, param1Int2);
/* 1076 */         this.unprocessedLength += param1Int2;
/*      */ 
/*      */         
/*      */         return;
/*      */       } 
/*      */ 
/*      */       
/* 1083 */       if (this.unprocessedLength > 0) {
/* 1084 */         int n = -1;
/* 1085 */         switch (this.unprocessedLength) {
/*      */           case 1:
/* 1087 */             n = orBytes(this.unprocessed[0], param1ArrayOfbyte[param1Int1], param1ArrayOfbyte[param1Int1 + 1], param1ArrayOfbyte[param1Int1 + 2]);
/*      */             break;
/*      */           case 2:
/* 1090 */             n = orBytes(this.unprocessed[0], this.unprocessed[1], param1ArrayOfbyte[param1Int1], param1ArrayOfbyte[param1Int1 + 1]);
/*      */             break;
/*      */           case 3:
/* 1093 */             n = orBytes(this.unprocessed[0], this.unprocessed[1], this.unprocessed[2], param1ArrayOfbyte[param1Int1]);
/*      */             break;
/*      */           default:
/* 1096 */             throw new IllegalStateException("Unprocessed length should be 1, 2, or 3: " + this.unprocessedLength);
/*      */         } 
/* 1098 */         this.hash = MurmurHash3.mix32(n, this.hash);
/*      */         
/* 1100 */         int i1 = 4 - this.unprocessedLength;
/* 1101 */         i = param1Int1 + i1;
/* 1102 */         j = param1Int2 - i1;
/*      */       } else {
/* 1104 */         i = param1Int1;
/* 1105 */         j = param1Int2;
/*      */       } 
/*      */ 
/*      */       
/* 1109 */       int k = j >> 2;
/*      */       int m;
/* 1111 */       for (m = 0; m < k; m++) {
/* 1112 */         int n = i + (m << 2);
/* 1113 */         int i1 = MurmurHash3.getLittleEndianInt(param1ArrayOfbyte, n);
/* 1114 */         this.hash = MurmurHash3.mix32(i1, this.hash);
/*      */       } 
/*      */ 
/*      */       
/* 1118 */       m = k << 2;
/* 1119 */       this.unprocessedLength = j - m;
/* 1120 */       if (this.unprocessedLength != 0) {
/* 1121 */         System.arraycopy(param1ArrayOfbyte, i + m, this.unprocessed, 0, this.unprocessedLength);
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final int end() {
/* 1133 */       return finalise(this.hash, this.unprocessedLength, this.unprocessed, this.totalLen);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     int finalise(int param1Int1, int param1Int2, byte[] param1ArrayOfbyte, int param1Int3) {
/* 1147 */       int i = param1Int1;
/* 1148 */       int j = 0;
/* 1149 */       switch (param1Int2) {
/*      */         case 3:
/* 1151 */           j ^= (param1ArrayOfbyte[2] & 0xFF) << 16;
/*      */         case 2:
/* 1153 */           j ^= (param1ArrayOfbyte[1] & 0xFF) << 8;
/*      */         case 1:
/* 1155 */           j ^= param1ArrayOfbyte[0] & 0xFF;
/*      */ 
/*      */           
/* 1158 */           j *= -862048943;
/* 1159 */           j = Integer.rotateLeft(j, 15);
/* 1160 */           j *= 461845907;
/* 1161 */           i ^= j;
/*      */           break;
/*      */       } 
/*      */       
/* 1165 */       i ^= param1Int3;
/* 1166 */       return MurmurHash3.fmix32(i);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static int orBytes(byte param1Byte1, byte param1Byte2, byte param1Byte3, byte param1Byte4) {
/* 1181 */       return param1Byte1 & 0xFF | (param1Byte2 & 0xFF) << 8 | (param1Byte3 & 0xFF) << 16 | (param1Byte4 & 0xFF) << 24;
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
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static class IncrementalHash32
/*      */     extends IncrementalHash32x86
/*      */   {
/*      */     @Deprecated
/*      */     int finalise(int param1Int1, int param1Int2, byte[] param1ArrayOfbyte, int param1Int3) {
/* 1213 */       int i = param1Int1;
/*      */ 
/*      */ 
/*      */       
/* 1217 */       int j = 0;
/* 1218 */       switch (param1Int2) {
/*      */         case 3:
/* 1220 */           j ^= param1ArrayOfbyte[2] << 16;
/*      */         case 2:
/* 1222 */           j ^= param1ArrayOfbyte[1] << 8;
/*      */         case 1:
/* 1224 */           j ^= param1ArrayOfbyte[0];
/*      */ 
/*      */           
/* 1227 */           j *= -862048943;
/* 1228 */           j = Integer.rotateLeft(j, 15);
/* 1229 */           j *= 461845907;
/* 1230 */           i ^= j;
/*      */           break;
/*      */       } 
/*      */       
/* 1234 */       i ^= param1Int3;
/* 1235 */       return MurmurHash3.fmix32(i);
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\digest\MurmurHash3.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */