/*     */ package org.h2.mvstore;
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
/*     */ public class WriteBuffer
/*     */ {
/*     */   private static final int MAX_REUSE_CAPACITY = 4194304;
/*     */   private static final int MIN_GROW = 1048576;
/*     */   private ByteBuffer reuse;
/*     */   private ByteBuffer buff;
/*     */   
/*     */   public WriteBuffer(int paramInt) {
/*  37 */     this.reuse = ByteBuffer.allocate(paramInt);
/*  38 */     this.buff = this.reuse;
/*     */   }
/*     */   
/*     */   public WriteBuffer() {
/*  42 */     this(1048576);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WriteBuffer putVarInt(int paramInt) {
/*  52 */     DataUtils.writeVarInt(ensureCapacity(5), paramInt);
/*  53 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WriteBuffer putVarLong(long paramLong) {
/*  63 */     DataUtils.writeVarLong(ensureCapacity(10), paramLong);
/*  64 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WriteBuffer putStringData(String paramString, int paramInt) {
/*  75 */     ByteBuffer byteBuffer = ensureCapacity(3 * paramInt);
/*  76 */     DataUtils.writeStringData(byteBuffer, paramString, paramInt);
/*  77 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WriteBuffer put(byte paramByte) {
/*  87 */     ensureCapacity(1).put(paramByte);
/*  88 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WriteBuffer putChar(char paramChar) {
/*  98 */     ensureCapacity(2).putChar(paramChar);
/*  99 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WriteBuffer putShort(short paramShort) {
/* 109 */     ensureCapacity(2).putShort(paramShort);
/* 110 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WriteBuffer putInt(int paramInt) {
/* 120 */     ensureCapacity(4).putInt(paramInt);
/* 121 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WriteBuffer putLong(long paramLong) {
/* 131 */     ensureCapacity(8).putLong(paramLong);
/* 132 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WriteBuffer putFloat(float paramFloat) {
/* 142 */     ensureCapacity(4).putFloat(paramFloat);
/* 143 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WriteBuffer putDouble(double paramDouble) {
/* 153 */     ensureCapacity(8).putDouble(paramDouble);
/* 154 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WriteBuffer put(byte[] paramArrayOfbyte) {
/* 164 */     ensureCapacity(paramArrayOfbyte.length).put(paramArrayOfbyte);
/* 165 */     return this;
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
/*     */   public WriteBuffer put(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 177 */     ensureCapacity(paramInt2).put(paramArrayOfbyte, paramInt1, paramInt2);
/* 178 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WriteBuffer put(ByteBuffer paramByteBuffer) {
/* 188 */     ensureCapacity(this.buff.remaining()).put(paramByteBuffer);
/* 189 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WriteBuffer limit(int paramInt) {
/* 199 */     ensureCapacity(paramInt - this.buff.position()).limit(paramInt);
/* 200 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int capacity() {
/* 209 */     return this.buff.capacity();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WriteBuffer position(int paramInt) {
/* 219 */     this.buff.position(paramInt);
/* 220 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int limit() {
/* 229 */     return this.buff.limit();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int position() {
/* 238 */     return this.buff.position();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WriteBuffer get(byte[] paramArrayOfbyte) {
/* 248 */     this.buff.get(paramArrayOfbyte);
/* 249 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WriteBuffer putInt(int paramInt1, int paramInt2) {
/* 260 */     this.buff.putInt(paramInt1, paramInt2);
/* 261 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WriteBuffer putShort(int paramInt, short paramShort) {
/* 272 */     this.buff.putShort(paramInt, paramShort);
/* 273 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WriteBuffer clear() {
/* 282 */     if (this.buff.limit() > 4194304) {
/* 283 */       this.buff = this.reuse;
/* 284 */     } else if (this.buff != this.reuse) {
/* 285 */       this.reuse = this.buff;
/*     */     } 
/* 287 */     this.buff.clear();
/* 288 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteBuffer getBuffer() {
/* 297 */     return this.buff;
/*     */   }
/*     */   
/*     */   private ByteBuffer ensureCapacity(int paramInt) {
/* 301 */     if (this.buff.remaining() < paramInt) {
/* 302 */       grow(paramInt);
/*     */     }
/* 304 */     return this.buff;
/*     */   }
/*     */   
/*     */   private void grow(int paramInt) {
/* 308 */     ByteBuffer byteBuffer = this.buff;
/* 309 */     int i = paramInt - byteBuffer.remaining();
/*     */     
/* 311 */     long l = Math.max(i, 1048576);
/*     */     
/* 313 */     l = Math.max((byteBuffer.capacity() / 2), l);
/*     */     
/* 315 */     int j = (int)Math.min(2147483647L, byteBuffer.capacity() + l);
/* 316 */     if (j < i) {
/* 317 */       throw new OutOfMemoryError("Capacity: " + j + " needed: " + i);
/*     */     }
/*     */     try {
/* 320 */       this.buff = ByteBuffer.allocate(j);
/* 321 */     } catch (OutOfMemoryError outOfMemoryError) {
/* 322 */       throw new OutOfMemoryError("Capacity: " + j);
/*     */     } 
/* 324 */     byteBuffer.flip();
/* 325 */     this.buff.put(byteBuffer);
/* 326 */     if (j <= 4194304)
/* 327 */       this.reuse = this.buff; 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\mvstore\WriteBuffer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */