/*     */ package org.apache.commons.codec.digest;
/*     */ 
/*     */ import java.util.zip.Checksum;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XXHash32
/*     */   implements Checksum
/*     */ {
/*     */   private static final int BUF_SIZE = 16;
/*     */   private static final int ROTATE_BITS = 13;
/*     */   private static final int PRIME1 = -1640531535;
/*     */   private static final int PRIME2 = -2048144777;
/*     */   private static final int PRIME3 = -1028477379;
/*     */   private static final int PRIME4 = 668265263;
/*     */   private static final int PRIME5 = 374761393;
/*  49 */   private final byte[] oneByte = new byte[1];
/*  50 */   private final int[] state = new int[4];
/*     */ 
/*     */   
/*  53 */   private final byte[] buffer = new byte[16];
/*     */   
/*     */   private final int seed;
/*     */   
/*     */   private int totalLen;
/*     */   
/*     */   private int pos;
/*     */   
/*     */   private boolean stateUpdated;
/*     */ 
/*     */   
/*     */   public XXHash32() {
/*  65 */     this(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XXHash32(int paramInt) {
/*  73 */     this.seed = paramInt;
/*  74 */     initializeState();
/*     */   }
/*     */ 
/*     */   
/*     */   public void reset() {
/*  79 */     initializeState();
/*  80 */     this.totalLen = 0;
/*  81 */     this.pos = 0;
/*  82 */     this.stateUpdated = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(int paramInt) {
/*  87 */     this.oneByte[0] = (byte)(paramInt & 0xFF);
/*  88 */     update(this.oneByte, 0, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  93 */     if (paramInt2 <= 0) {
/*     */       return;
/*     */     }
/*  96 */     this.totalLen += paramInt2;
/*     */     
/*  98 */     int i = paramInt1 + paramInt2;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 103 */     if (this.pos + paramInt2 - 16 < 0) {
/* 104 */       System.arraycopy(paramArrayOfbyte, paramInt1, this.buffer, this.pos, paramInt2);
/* 105 */       this.pos += paramInt2;
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 110 */     if (this.pos > 0) {
/* 111 */       int k = 16 - this.pos;
/* 112 */       System.arraycopy(paramArrayOfbyte, paramInt1, this.buffer, this.pos, k);
/* 113 */       process(this.buffer, 0);
/* 114 */       paramInt1 += k;
/*     */     } 
/*     */     
/* 117 */     int j = i - 16;
/* 118 */     while (paramInt1 <= j) {
/* 119 */       process(paramArrayOfbyte, paramInt1);
/* 120 */       paramInt1 += 16;
/*     */     } 
/*     */ 
/*     */     
/* 124 */     if (paramInt1 < i) {
/* 125 */       this.pos = i - paramInt1;
/* 126 */       System.arraycopy(paramArrayOfbyte, paramInt1, this.buffer, 0, this.pos);
/*     */     } else {
/* 128 */       this.pos = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public long getValue() {
/*     */     int i;
/* 135 */     if (this.stateUpdated) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 141 */       i = Integer.rotateLeft(this.state[0], 1) + Integer.rotateLeft(this.state[1], 7) + Integer.rotateLeft(this.state[2], 12) + Integer.rotateLeft(this.state[3], 18);
/*     */     } else {
/*     */       
/* 144 */       i = this.state[2] + 374761393;
/*     */     } 
/* 146 */     i += this.totalLen;
/*     */     
/* 148 */     byte b = 0;
/* 149 */     int j = this.pos - 4;
/* 150 */     for (; b <= j; b += 4) {
/* 151 */       i = Integer.rotateLeft(i + getInt(this.buffer, b) * -1028477379, 17) * 668265263;
/*     */     }
/* 153 */     while (b < this.pos) {
/* 154 */       i = Integer.rotateLeft(i + (this.buffer[b++] & 0xFF) * 374761393, 11) * -1640531535;
/*     */     }
/*     */     
/* 157 */     i ^= i >>> 15;
/* 158 */     i *= -2048144777;
/* 159 */     i ^= i >>> 13;
/* 160 */     i *= -1028477379;
/* 161 */     i ^= i >>> 16;
/* 162 */     return i & 0xFFFFFFFFL;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int getInt(byte[] paramArrayOfbyte, int paramInt) {
/* 173 */     return paramArrayOfbyte[paramInt] & 0xFF | (paramArrayOfbyte[paramInt + 1] & 0xFF) << 8 | (paramArrayOfbyte[paramInt + 2] & 0xFF) << 16 | (paramArrayOfbyte[paramInt + 3] & 0xFF) << 24;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void initializeState() {
/* 180 */     this.state[0] = this.seed + -1640531535 + -2048144777;
/* 181 */     this.state[1] = this.seed + -2048144777;
/* 182 */     this.state[2] = this.seed;
/* 183 */     this.state[3] = this.seed - -1640531535;
/*     */   }
/*     */ 
/*     */   
/*     */   private void process(byte[] paramArrayOfbyte, int paramInt) {
/* 188 */     int i = this.state[0];
/* 189 */     int j = this.state[1];
/* 190 */     int k = this.state[2];
/* 191 */     int m = this.state[3];
/*     */     
/* 193 */     i = Integer.rotateLeft(i + getInt(paramArrayOfbyte, paramInt) * -2048144777, 13) * -1640531535;
/* 194 */     j = Integer.rotateLeft(j + getInt(paramArrayOfbyte, paramInt + 4) * -2048144777, 13) * -1640531535;
/* 195 */     k = Integer.rotateLeft(k + getInt(paramArrayOfbyte, paramInt + 8) * -2048144777, 13) * -1640531535;
/* 196 */     m = Integer.rotateLeft(m + getInt(paramArrayOfbyte, paramInt + 12) * -2048144777, 13) * -1640531535;
/*     */     
/* 198 */     this.state[0] = i;
/* 199 */     this.state[1] = j;
/* 200 */     this.state[2] = k;
/* 201 */     this.state[3] = m;
/*     */     
/* 203 */     this.stateUpdated = true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\digest\XXHash32.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */