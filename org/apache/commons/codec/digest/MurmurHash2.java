/*     */ package org.apache.commons.codec.digest;
/*     */ 
/*     */ import org.apache.commons.codec.binary.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class MurmurHash2
/*     */ {
/*     */   private static final int M32 = 1540483477;
/*     */   private static final int R32 = 24;
/*     */   private static final long M64 = -4132994306676758123L;
/*     */   private static final int R64 = 47;
/*     */   
/*     */   public static int hash32(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  75 */     int i = paramInt2 ^ paramInt1;
/*     */ 
/*     */     
/*  78 */     int j = paramInt1 >> 2;
/*     */     
/*     */     int k;
/*  81 */     for (k = 0; k < j; k++) {
/*  82 */       int m = k << 2;
/*  83 */       int n = getLittleEndianInt(paramArrayOfbyte, m);
/*  84 */       n *= 1540483477;
/*  85 */       n ^= n >>> 24;
/*  86 */       n *= 1540483477;
/*  87 */       i *= 1540483477;
/*  88 */       i ^= n;
/*     */     } 
/*     */ 
/*     */     
/*  92 */     k = j << 2;
/*  93 */     switch (paramInt1 - k) {
/*     */       case 3:
/*  95 */         i ^= (paramArrayOfbyte[k + 2] & 0xFF) << 16;
/*     */       case 2:
/*  97 */         i ^= (paramArrayOfbyte[k + 1] & 0xFF) << 8;
/*     */       case 1:
/*  99 */         i ^= paramArrayOfbyte[k] & 0xFF;
/* 100 */         i *= 1540483477;
/*     */         break;
/*     */     } 
/*     */ 
/*     */     
/* 105 */     i ^= i >>> 13;
/* 106 */     i *= 1540483477;
/* 107 */     i ^= i >>> 15;
/*     */     
/* 109 */     return i;
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
/*     */   public static int hash32(byte[] paramArrayOfbyte, int paramInt) {
/* 127 */     return hash32(paramArrayOfbyte, paramInt, -1756908916);
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
/*     */   public static int hash32(String paramString) {
/* 149 */     byte[] arrayOfByte = StringUtils.getBytesUtf8(paramString);
/* 150 */     return hash32(arrayOfByte, arrayOfByte.length);
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
/*     */   public static int hash32(String paramString, int paramInt1, int paramInt2) {
/* 171 */     return hash32(paramString.substring(paramInt1, paramInt1 + paramInt2));
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
/*     */   public static long hash64(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 183 */     long l = paramInt2 & 0xFFFFFFFFL ^ paramInt1 * -4132994306676758123L;
/*     */     
/* 185 */     int i = paramInt1 >> 3;
/*     */     
/*     */     int j;
/* 188 */     for (j = 0; j < i; j++) {
/* 189 */       int k = j << 3;
/* 190 */       long l1 = getLittleEndianLong(paramArrayOfbyte, k);
/*     */       
/* 192 */       l1 *= -4132994306676758123L;
/* 193 */       l1 ^= l1 >>> 47L;
/* 194 */       l1 *= -4132994306676758123L;
/*     */       
/* 196 */       l ^= l1;
/* 197 */       l *= -4132994306676758123L;
/*     */     } 
/*     */     
/* 200 */     j = i << 3;
/* 201 */     switch (paramInt1 - j) {
/*     */       case 7:
/* 203 */         l ^= (paramArrayOfbyte[j + 6] & 0xFFL) << 48L;
/*     */       case 6:
/* 205 */         l ^= (paramArrayOfbyte[j + 5] & 0xFFL) << 40L;
/*     */       case 5:
/* 207 */         l ^= (paramArrayOfbyte[j + 4] & 0xFFL) << 32L;
/*     */       case 4:
/* 209 */         l ^= (paramArrayOfbyte[j + 3] & 0xFFL) << 24L;
/*     */       case 3:
/* 211 */         l ^= (paramArrayOfbyte[j + 2] & 0xFFL) << 16L;
/*     */       case 2:
/* 213 */         l ^= (paramArrayOfbyte[j + 1] & 0xFFL) << 8L;
/*     */       case 1:
/* 215 */         l ^= paramArrayOfbyte[j] & 0xFFL;
/* 216 */         l *= -4132994306676758123L;
/*     */         break;
/*     */     } 
/* 219 */     l ^= l >>> 47L;
/* 220 */     l *= -4132994306676758123L;
/* 221 */     l ^= l >>> 47L;
/*     */     
/* 223 */     return l;
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
/*     */   public static long hash64(byte[] paramArrayOfbyte, int paramInt) {
/* 241 */     return hash64(paramArrayOfbyte, paramInt, -512093083);
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
/*     */   public static long hash64(String paramString) {
/* 263 */     byte[] arrayOfByte = StringUtils.getBytesUtf8(paramString);
/* 264 */     return hash64(arrayOfByte, arrayOfByte.length);
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
/*     */   public static long hash64(String paramString, int paramInt1, int paramInt2) {
/* 285 */     return hash64(paramString.substring(paramInt1, paramInt1 + paramInt2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int getLittleEndianInt(byte[] paramArrayOfbyte, int paramInt) {
/* 296 */     return paramArrayOfbyte[paramInt] & 0xFF | (paramArrayOfbyte[paramInt + 1] & 0xFF) << 8 | (paramArrayOfbyte[paramInt + 2] & 0xFF) << 16 | (paramArrayOfbyte[paramInt + 3] & 0xFF) << 24;
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
/*     */   private static long getLittleEndianLong(byte[] paramArrayOfbyte, int paramInt) {
/* 310 */     return paramArrayOfbyte[paramInt] & 0xFFL | (paramArrayOfbyte[paramInt + 1] & 0xFFL) << 8L | (paramArrayOfbyte[paramInt + 2] & 0xFFL) << 16L | (paramArrayOfbyte[paramInt + 3] & 0xFFL) << 24L | (paramArrayOfbyte[paramInt + 4] & 0xFFL) << 32L | (paramArrayOfbyte[paramInt + 5] & 0xFFL) << 40L | (paramArrayOfbyte[paramInt + 6] & 0xFFL) << 48L | (paramArrayOfbyte[paramInt + 7] & 0xFFL) << 56L;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\digest\MurmurHash2.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */