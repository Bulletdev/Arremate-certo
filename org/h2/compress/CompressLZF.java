/*     */ package org.h2.compress;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class CompressLZF
/*     */   implements Compressor
/*     */ {
/*     */   private static final int HASH_SIZE = 16384;
/*     */   private static final int MAX_LITERAL = 32;
/*     */   private static final int MAX_OFF = 8192;
/*     */   private static final int MAX_REF = 264;
/*     */   private int[] cachedHashTable;
/*     */   
/*     */   public void setOptions(String paramString) {}
/*     */   
/*     */   private static int first(byte[] paramArrayOfbyte, int paramInt) {
/* 125 */     return paramArrayOfbyte[paramInt] << 8 | paramArrayOfbyte[paramInt + 1] & 0xFF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int first(ByteBuffer paramByteBuffer, int paramInt) {
/* 133 */     return paramByteBuffer.get(paramInt) << 8 | paramByteBuffer.get(paramInt + 1) & 0xFF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int next(int paramInt1, byte[] paramArrayOfbyte, int paramInt2) {
/* 140 */     return paramInt1 << 8 | paramArrayOfbyte[paramInt2 + 2] & 0xFF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int next(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2) {
/* 147 */     return paramInt1 << 8 | paramByteBuffer.get(paramInt2 + 2) & 0xFF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int hash(int paramInt) {
/* 154 */     return paramInt * 2777 >> 9 & 0x3FFF;
/*     */   }
/*     */ 
/*     */   
/*     */   public int compress(byte[] paramArrayOfbyte1, int paramInt1, byte[] paramArrayOfbyte2, int paramInt2) {
/* 159 */     int i = 0;
/* 160 */     if (this.cachedHashTable == null) {
/* 161 */       this.cachedHashTable = new int[16384];
/*     */     }
/* 163 */     int[] arrayOfInt = this.cachedHashTable;
/* 164 */     byte b = 0;
/* 165 */     paramInt2++;
/* 166 */     int j = first(paramArrayOfbyte1, 0);
/* 167 */     while (i < paramInt1 - 4) {
/* 168 */       byte b1 = paramArrayOfbyte1[i + 2];
/*     */       
/* 170 */       j = (j << 8) + (b1 & 0xFF);
/* 171 */       int k = hash(j);
/* 172 */       int m = arrayOfInt[k];
/* 173 */       arrayOfInt[k] = i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 180 */       if (m < i && m > 0 && (k = i - m - 1) < 8192 && paramArrayOfbyte1[m + 2] == b1 && paramArrayOfbyte1[m + 1] == (byte)(j >> 8) && paramArrayOfbyte1[m] == (byte)(j >> 16)) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 187 */         int n = paramInt1 - i - 2;
/* 188 */         if (n > 264) {
/* 189 */           n = 264;
/*     */         }
/* 191 */         if (!b) {
/*     */ 
/*     */           
/* 194 */           paramInt2--;
/*     */         }
/*     */         else {
/*     */           
/* 198 */           paramArrayOfbyte2[paramInt2 - b - 1] = (byte)(b - 1);
/* 199 */           b = 0;
/*     */         } 
/* 201 */         byte b2 = 3;
/* 202 */         while (b2 < n && paramArrayOfbyte1[m + b2] == paramArrayOfbyte1[i + b2]) {
/* 203 */           b2++;
/*     */         }
/* 205 */         b2 -= 2;
/* 206 */         if (b2 < 7) {
/* 207 */           paramArrayOfbyte2[paramInt2++] = (byte)((k >> 8) + (b2 << 5));
/*     */         } else {
/* 209 */           paramArrayOfbyte2[paramInt2++] = (byte)((k >> 8) + 224);
/* 210 */           paramArrayOfbyte2[paramInt2++] = (byte)(b2 - 7);
/*     */         } 
/* 212 */         paramArrayOfbyte2[paramInt2++] = (byte)k;
/*     */         
/* 214 */         paramInt2++;
/* 215 */         i += b2;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 220 */         j = first(paramArrayOfbyte1, i);
/* 221 */         j = next(j, paramArrayOfbyte1, i);
/* 222 */         arrayOfInt[hash(j)] = i++;
/* 223 */         j = next(j, paramArrayOfbyte1, i);
/* 224 */         arrayOfInt[hash(j)] = i++;
/*     */         continue;
/*     */       } 
/* 227 */       paramArrayOfbyte2[paramInt2++] = paramArrayOfbyte1[i++];
/* 228 */       b++;
/*     */ 
/*     */       
/* 231 */       if (b == 32) {
/* 232 */         paramArrayOfbyte2[paramInt2 - b - 1] = (byte)(b - 1);
/* 233 */         b = 0;
/*     */ 
/*     */         
/* 236 */         paramInt2++;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 241 */     while (i < paramInt1) {
/* 242 */       paramArrayOfbyte2[paramInt2++] = paramArrayOfbyte1[i++];
/* 243 */       b++;
/* 244 */       if (b == 32) {
/* 245 */         paramArrayOfbyte2[paramInt2 - b - 1] = (byte)(b - 1);
/* 246 */         b = 0;
/* 247 */         paramInt2++;
/*     */       } 
/*     */     } 
/*     */     
/* 251 */     paramArrayOfbyte2[paramInt2 - b - 1] = (byte)(b - 1);
/* 252 */     if (b == 0) {
/* 253 */       paramInt2--;
/*     */     }
/* 255 */     return paramInt2;
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
/*     */   public int compress(ByteBuffer paramByteBuffer, int paramInt1, byte[] paramArrayOfbyte, int paramInt2) {
/* 268 */     int i = paramByteBuffer.capacity() - paramInt1;
/* 269 */     if (this.cachedHashTable == null) {
/* 270 */       this.cachedHashTable = new int[16384];
/*     */     }
/* 272 */     int[] arrayOfInt = this.cachedHashTable;
/* 273 */     byte b = 0;
/* 274 */     paramInt2++;
/* 275 */     int j = first(paramByteBuffer, 0);
/* 276 */     while (paramInt1 < i - 4) {
/* 277 */       byte b1 = paramByteBuffer.get(paramInt1 + 2);
/*     */       
/* 279 */       j = (j << 8) + (b1 & 0xFF);
/* 280 */       int k = hash(j);
/* 281 */       int m = arrayOfInt[k];
/* 282 */       arrayOfInt[k] = paramInt1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 289 */       if (m < paramInt1 && m > 0 && (k = paramInt1 - m - 1) < 8192 && paramByteBuffer.get(m + 2) == b1 && paramByteBuffer.get(m + 1) == (byte)(j >> 8) && paramByteBuffer.get(m) == (byte)(j >> 16)) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 296 */         int n = i - paramInt1 - 2;
/* 297 */         if (n > 264) {
/* 298 */           n = 264;
/*     */         }
/* 300 */         if (!b) {
/*     */ 
/*     */           
/* 303 */           paramInt2--;
/*     */         }
/*     */         else {
/*     */           
/* 307 */           paramArrayOfbyte[paramInt2 - b - 1] = (byte)(b - 1);
/* 308 */           b = 0;
/*     */         } 
/* 310 */         byte b2 = 3;
/* 311 */         while (b2 < n && paramByteBuffer.get(m + b2) == paramByteBuffer.get(paramInt1 + b2)) {
/* 312 */           b2++;
/*     */         }
/* 314 */         b2 -= 2;
/* 315 */         if (b2 < 7) {
/* 316 */           paramArrayOfbyte[paramInt2++] = (byte)((k >> 8) + (b2 << 5));
/*     */         } else {
/* 318 */           paramArrayOfbyte[paramInt2++] = (byte)((k >> 8) + 224);
/* 319 */           paramArrayOfbyte[paramInt2++] = (byte)(b2 - 7);
/*     */         } 
/* 321 */         paramArrayOfbyte[paramInt2++] = (byte)k;
/*     */         
/* 323 */         paramInt2++;
/* 324 */         paramInt1 += b2;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 329 */         j = first(paramByteBuffer, paramInt1);
/* 330 */         j = next(j, paramByteBuffer, paramInt1);
/* 331 */         arrayOfInt[hash(j)] = paramInt1++;
/* 332 */         j = next(j, paramByteBuffer, paramInt1);
/* 333 */         arrayOfInt[hash(j)] = paramInt1++;
/*     */         continue;
/*     */       } 
/* 336 */       paramArrayOfbyte[paramInt2++] = paramByteBuffer.get(paramInt1++);
/* 337 */       b++;
/*     */ 
/*     */       
/* 340 */       if (b == 32) {
/* 341 */         paramArrayOfbyte[paramInt2 - b - 1] = (byte)(b - 1);
/* 342 */         b = 0;
/*     */ 
/*     */         
/* 345 */         paramInt2++;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 350 */     while (paramInt1 < i) {
/* 351 */       paramArrayOfbyte[paramInt2++] = paramByteBuffer.get(paramInt1++);
/* 352 */       b++;
/* 353 */       if (b == 32) {
/* 354 */         paramArrayOfbyte[paramInt2 - b - 1] = (byte)(b - 1);
/* 355 */         b = 0;
/* 356 */         paramInt2++;
/*     */       } 
/*     */     } 
/*     */     
/* 360 */     paramArrayOfbyte[paramInt2 - b - 1] = (byte)(b - 1);
/* 361 */     if (b == 0) {
/* 362 */       paramInt2--;
/*     */     }
/* 364 */     return paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void expand(byte[] paramArrayOfbyte1, int paramInt1, int paramInt2, byte[] paramArrayOfbyte2, int paramInt3, int paramInt4) {
/* 371 */     if (paramInt1 < 0 || paramInt3 < 0 || paramInt4 < 0) {
/* 372 */       throw new IllegalArgumentException();
/*     */     }
/*     */     do {
/* 375 */       int i = paramArrayOfbyte1[paramInt1++] & 0xFF;
/* 376 */       if (i < 32) {
/*     */         
/* 378 */         i++;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 383 */         System.arraycopy(paramArrayOfbyte1, paramInt1, paramArrayOfbyte2, paramInt3, i);
/* 384 */         paramInt3 += i;
/* 385 */         paramInt1 += i;
/*     */       }
/*     */       else {
/*     */         
/* 389 */         int j = i >> 5;
/*     */         
/* 391 */         if (j == 7) {
/* 392 */           j += paramArrayOfbyte1[paramInt1++] & 0xFF;
/*     */         }
/*     */ 
/*     */         
/* 396 */         j += 2;
/*     */ 
/*     */ 
/*     */         
/* 400 */         i = -((i & 0x1F) << 8) - 1;
/*     */ 
/*     */         
/* 403 */         i -= paramArrayOfbyte1[paramInt1++] & 0xFF;
/*     */ 
/*     */ 
/*     */         
/* 407 */         i += paramInt3;
/* 408 */         if (paramInt3 + j >= paramArrayOfbyte2.length)
/*     */         {
/* 410 */           throw new ArrayIndexOutOfBoundsException();
/*     */         }
/* 412 */         for (byte b = 0; b < j; b++) {
/* 413 */           paramArrayOfbyte2[paramInt3++] = paramArrayOfbyte2[i++];
/*     */         }
/*     */       } 
/* 416 */     } while (paramInt3 < paramInt4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void expand(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2) {
/*     */     do {
/* 427 */       int i = paramByteBuffer1.get() & 0xFF;
/* 428 */       if (i < 32) {
/*     */         
/* 430 */         i++;
/*     */ 
/*     */         
/* 433 */         for (byte b = 0; b < i; b++) {
/* 434 */           paramByteBuffer2.put(paramByteBuffer1.get());
/*     */         }
/*     */       }
/*     */       else {
/*     */         
/* 439 */         int j = i >> 5;
/*     */         
/* 441 */         if (j == 7) {
/* 442 */           j += paramByteBuffer1.get() & 0xFF;
/*     */         }
/*     */ 
/*     */         
/* 446 */         j += 2;
/*     */ 
/*     */ 
/*     */         
/* 450 */         i = -((i & 0x1F) << 8) - 1;
/*     */ 
/*     */         
/* 453 */         i -= paramByteBuffer1.get() & 0xFF;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 458 */         i += paramByteBuffer2.position();
/* 459 */         for (byte b = 0; b < j; b++) {
/* 460 */           paramByteBuffer2.put(paramByteBuffer2.get(i++));
/*     */         }
/*     */       } 
/* 463 */     } while (paramByteBuffer2.position() < paramByteBuffer2.capacity());
/*     */   }
/*     */ 
/*     */   
/*     */   public int getAlgorithm() {
/* 468 */     return 1;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\compress\CompressLZF.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */