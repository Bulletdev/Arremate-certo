/*     */ package org.h2.security;
/*     */ 
/*     */ import org.h2.util.Utils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Fog
/*     */   implements BlockCipher
/*     */ {
/*     */   private int key;
/*     */   
/*     */   public void encrypt(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  21 */     for (int i = paramInt1; i < paramInt1 + paramInt2; i += 16) {
/*  22 */       encryptBlock(paramArrayOfbyte, paramArrayOfbyte, i);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void decrypt(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  28 */     for (int i = paramInt1; i < paramInt1 + paramInt2; i += 16) {
/*  29 */       decryptBlock(paramArrayOfbyte, paramArrayOfbyte, i);
/*     */     }
/*     */   }
/*     */   
/*     */   private void encryptBlock(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, int paramInt) {
/*  34 */     int i = paramArrayOfbyte1[paramInt] << 24 | (paramArrayOfbyte1[paramInt + 1] & 0xFF) << 16 | (paramArrayOfbyte1[paramInt + 2] & 0xFF) << 8 | paramArrayOfbyte1[paramInt + 3] & 0xFF;
/*     */     
/*  36 */     int j = paramArrayOfbyte1[paramInt + 4] << 24 | (paramArrayOfbyte1[paramInt + 5] & 0xFF) << 16 | (paramArrayOfbyte1[paramInt + 6] & 0xFF) << 8 | paramArrayOfbyte1[paramInt + 7] & 0xFF;
/*     */     
/*  38 */     int k = paramArrayOfbyte1[paramInt + 8] << 24 | (paramArrayOfbyte1[paramInt + 9] & 0xFF) << 16 | (paramArrayOfbyte1[paramInt + 10] & 0xFF) << 8 | paramArrayOfbyte1[paramInt + 11] & 0xFF;
/*     */     
/*  40 */     int m = paramArrayOfbyte1[paramInt + 12] << 24 | (paramArrayOfbyte1[paramInt + 13] & 0xFF) << 16 | (paramArrayOfbyte1[paramInt + 14] & 0xFF) << 8 | paramArrayOfbyte1[paramInt + 15] & 0xFF;
/*     */     
/*  42 */     int n = this.key;
/*  43 */     int i1 = j & 0x1F;
/*  44 */     i ^= n;
/*  45 */     i = i << i1 | i >>> 32 - i1;
/*  46 */     k ^= n;
/*  47 */     k = k << i1 | k >>> 32 - i1;
/*  48 */     i1 = i & 0x1F;
/*  49 */     j ^= n;
/*  50 */     j = j << i1 | j >>> 32 - i1;
/*  51 */     m ^= n;
/*  52 */     m = m << i1 | m >>> 32 - i1;
/*  53 */     paramArrayOfbyte2[paramInt] = (byte)(i >> 24); paramArrayOfbyte2[paramInt + 1] = (byte)(i >> 16);
/*  54 */     paramArrayOfbyte2[paramInt + 2] = (byte)(i >> 8); paramArrayOfbyte2[paramInt + 3] = (byte)i;
/*  55 */     paramArrayOfbyte2[paramInt + 4] = (byte)(j >> 24); paramArrayOfbyte2[paramInt + 5] = (byte)(j >> 16);
/*  56 */     paramArrayOfbyte2[paramInt + 6] = (byte)(j >> 8); paramArrayOfbyte2[paramInt + 7] = (byte)j;
/*  57 */     paramArrayOfbyte2[paramInt + 8] = (byte)(k >> 24); paramArrayOfbyte2[paramInt + 9] = (byte)(k >> 16);
/*  58 */     paramArrayOfbyte2[paramInt + 10] = (byte)(k >> 8); paramArrayOfbyte2[paramInt + 11] = (byte)k;
/*  59 */     paramArrayOfbyte2[paramInt + 12] = (byte)(m >> 24); paramArrayOfbyte2[paramInt + 13] = (byte)(m >> 16);
/*  60 */     paramArrayOfbyte2[paramInt + 14] = (byte)(m >> 8); paramArrayOfbyte2[paramInt + 15] = (byte)m;
/*     */   }
/*     */   
/*     */   private void decryptBlock(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, int paramInt) {
/*  64 */     int i = paramArrayOfbyte1[paramInt] << 24 | (paramArrayOfbyte1[paramInt + 1] & 0xFF) << 16 | (paramArrayOfbyte1[paramInt + 2] & 0xFF) << 8 | paramArrayOfbyte1[paramInt + 3] & 0xFF;
/*     */     
/*  66 */     int j = paramArrayOfbyte1[paramInt + 4] << 24 | (paramArrayOfbyte1[paramInt + 5] & 0xFF) << 16 | (paramArrayOfbyte1[paramInt + 6] & 0xFF) << 8 | paramArrayOfbyte1[paramInt + 7] & 0xFF;
/*     */     
/*  68 */     int k = paramArrayOfbyte1[paramInt + 8] << 24 | (paramArrayOfbyte1[paramInt + 9] & 0xFF) << 16 | (paramArrayOfbyte1[paramInt + 10] & 0xFF) << 8 | paramArrayOfbyte1[paramInt + 11] & 0xFF;
/*     */     
/*  70 */     int m = paramArrayOfbyte1[paramInt + 12] << 24 | (paramArrayOfbyte1[paramInt + 13] & 0xFF) << 16 | (paramArrayOfbyte1[paramInt + 14] & 0xFF) << 8 | paramArrayOfbyte1[paramInt + 15] & 0xFF;
/*     */     
/*  72 */     int n = this.key;
/*  73 */     int i1 = 32 - (i & 0x1F);
/*  74 */     j = j << i1 | j >>> 32 - i1;
/*  75 */     j ^= n;
/*  76 */     m = m << i1 | m >>> 32 - i1;
/*  77 */     m ^= n;
/*  78 */     i1 = 32 - (j & 0x1F);
/*  79 */     i = i << i1 | i >>> 32 - i1;
/*  80 */     i ^= n;
/*  81 */     k = k << i1 | k >>> 32 - i1;
/*  82 */     k ^= n;
/*  83 */     paramArrayOfbyte2[paramInt] = (byte)(i >> 24); paramArrayOfbyte2[paramInt + 1] = (byte)(i >> 16);
/*  84 */     paramArrayOfbyte2[paramInt + 2] = (byte)(i >> 8); paramArrayOfbyte2[paramInt + 3] = (byte)i;
/*  85 */     paramArrayOfbyte2[paramInt + 4] = (byte)(j >> 24); paramArrayOfbyte2[paramInt + 5] = (byte)(j >> 16);
/*  86 */     paramArrayOfbyte2[paramInt + 6] = (byte)(j >> 8); paramArrayOfbyte2[paramInt + 7] = (byte)j;
/*  87 */     paramArrayOfbyte2[paramInt + 8] = (byte)(k >> 24); paramArrayOfbyte2[paramInt + 9] = (byte)(k >> 16);
/*  88 */     paramArrayOfbyte2[paramInt + 10] = (byte)(k >> 8); paramArrayOfbyte2[paramInt + 11] = (byte)k;
/*  89 */     paramArrayOfbyte2[paramInt + 12] = (byte)(m >> 24); paramArrayOfbyte2[paramInt + 13] = (byte)(m >> 16);
/*  90 */     paramArrayOfbyte2[paramInt + 14] = (byte)(m >> 8); paramArrayOfbyte2[paramInt + 15] = (byte)m;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getKeyLength() {
/*  95 */     return 16;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setKey(byte[] paramArrayOfbyte) {
/* 100 */     this.key = (int)Utils.readLong(paramArrayOfbyte, 0);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\security\Fog.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */