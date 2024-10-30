/*     */ package com.b.a.a;
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
/*     */ class c
/*     */ {
/*     */   private static final int gU = 1024;
/*     */   private ByteBuffer b;
/*     */   private int mLength;
/*     */   
/*     */   public c(int paramInt) {
/*  44 */     this.b = ByteBuffer.allocate(paramInt);
/*  45 */     this.mLength = 0;
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
/*     */   public c(byte[] paramArrayOfbyte) {
/*  58 */     this.b = ByteBuffer.wrap(paramArrayOfbyte);
/*  59 */     this.mLength = paramArrayOfbyte.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int length() {
/*  68 */     return this.mLength;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte a(int paramInt) throws IndexOutOfBoundsException {
/*  77 */     if (paramInt < 0 || this.mLength <= paramInt)
/*     */     {
/*     */       
/*  80 */       throw new IndexOutOfBoundsException(
/*  81 */           String.format("Bad index: index=%d, length=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mLength) }));
/*     */     }
/*     */     
/*  84 */     return this.b.get(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void aR(int paramInt) {
/*  94 */     ByteBuffer byteBuffer = ByteBuffer.allocate(paramInt);
/*     */ 
/*     */     
/*  97 */     int i = this.b.position();
/*  98 */     this.b.position(0);
/*  99 */     byteBuffer.put(this.b);
/* 100 */     byteBuffer.position(i);
/*     */ 
/*     */     
/* 103 */     this.b = byteBuffer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void aS(int paramInt) {
/* 113 */     if (this.b.capacity() < this.mLength + 1)
/*     */     {
/* 115 */       aR(this.mLength + 1024);
/*     */     }
/*     */     
/* 118 */     this.b.put((byte)paramInt);
/* 119 */     this.mLength++;
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
/*     */   public void c(byte[] paramArrayOfbyte) {
/* 132 */     if (this.b.capacity() < this.mLength + paramArrayOfbyte.length)
/*     */     {
/* 134 */       aR(this.mLength + paramArrayOfbyte.length + 1024);
/*     */     }
/*     */     
/* 137 */     this.b.put(paramArrayOfbyte);
/* 138 */     this.mLength += paramArrayOfbyte.length;
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
/*     */   public void d(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 157 */     if (this.b.capacity() < this.mLength + paramInt2)
/*     */     {
/* 159 */       aR(this.mLength + paramInt2 + 1024);
/*     */     }
/*     */     
/* 162 */     this.b.put(paramArrayOfbyte, paramInt1, paramInt2);
/* 163 */     this.mLength += paramInt2;
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
/*     */   public void a(c paramc, int paramInt1, int paramInt2) {
/* 181 */     d(paramc.b.array(), paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] k() {
/* 190 */     return b(0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] b(int paramInt) {
/* 196 */     return a(paramInt, length());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] a(int paramInt1, int paramInt2) {
/* 202 */     int i = paramInt2 - paramInt1;
/*     */     
/* 204 */     if (i < 0 || paramInt1 < 0 || this.mLength < paramInt2)
/*     */     {
/* 206 */       throw new IllegalArgumentException(
/* 207 */           String.format("Bad range: beginIndex=%d, endIndex=%d, length=%d", new Object[] {
/* 208 */               Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.mLength)
/*     */             }));
/*     */     }
/* 211 */     byte[] arrayOfByte = new byte[i];
/*     */     
/* 213 */     if (i != 0)
/*     */     {
/* 215 */       System.arraycopy(this.b.array(), paramInt1, arrayOfByte, 0, i);
/*     */     }
/*     */     
/* 218 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 224 */     this.b.clear();
/* 225 */     this.b.position(0);
/* 226 */     this.mLength = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void aT(int paramInt) {
/* 232 */     if (this.b.capacity() <= paramInt) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 237 */     int i = this.mLength;
/* 238 */     int j = this.mLength - paramInt;
/*     */     
/* 240 */     byte[] arrayOfByte = a(j, i);
/*     */     
/* 242 */     this.b = ByteBuffer.wrap(arrayOfByte);
/* 243 */     this.b.position(arrayOfByte.length);
/* 244 */     this.mLength = arrayOfByte.length;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean w(int paramInt) {
/* 250 */     int i = paramInt / 8;
/* 251 */     int j = paramInt % 8;
/* 252 */     byte b = a(i);
/*     */ 
/*     */     
/* 255 */     return ((b & 1 << j) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int D(int paramInt1, int paramInt2) {
/* 261 */     int i = 0;
/* 262 */     int j = 1;
/*     */ 
/*     */     
/* 265 */     for (byte b = 0; b < paramInt2; b++, j *= 2) {
/*     */ 
/*     */       
/* 268 */       if (w(paramInt1 + b))
/*     */       {
/* 270 */         i += j;
/*     */       }
/*     */     } 
/*     */     
/* 274 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int E(int paramInt1, int paramInt2) {
/* 280 */     int i = 0;
/* 281 */     int j = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 292 */     for (int k = paramInt2 - 1; 0 <= k; k--, j *= 2) {
/*     */ 
/*     */       
/* 295 */       if (w(paramInt1 + k))
/*     */       {
/* 297 */         i += j;
/*     */       }
/*     */     } 
/*     */     
/* 301 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean a(int[] paramArrayOfint) {
/* 307 */     boolean bool = w(paramArrayOfint[0]);
/*     */     
/* 309 */     paramArrayOfint[0] = paramArrayOfint[0] + 1;
/*     */     
/* 311 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int a(int[] paramArrayOfint, int paramInt) {
/* 317 */     int i = D(paramArrayOfint[0], paramInt);
/*     */     
/* 319 */     paramArrayOfint[0] = paramArrayOfint[0] + paramInt;
/*     */     
/* 321 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(int paramInt, boolean paramBoolean) {
/* 327 */     int i = paramInt / 8;
/* 328 */     int j = paramInt % 8;
/* 329 */     int k = a(i);
/*     */     
/* 331 */     if (paramBoolean) {
/*     */       
/* 333 */       k = k | 1 << j;
/*     */     }
/*     */     else {
/*     */       
/* 337 */       k &= 1 << j ^ 0xFFFFFFFF;
/*     */     } 
/*     */     
/* 340 */     this.b.put(i, (byte)k);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearBit(int paramInt) {
/* 346 */     a(paramInt, false);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\b\a\a\c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */