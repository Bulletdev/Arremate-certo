/*     */ package com.google.a.h;
/*     */ 
/*     */ import com.google.a.b.D;
/*     */ import com.google.b.a.a;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ abstract class f
/*     */   extends d
/*     */ {
/*     */   private final ByteBuffer buffer;
/*     */   private final int bufferSize;
/*     */   private final int chunkSize;
/*     */   
/*     */   protected f(int paramInt) {
/*  50 */     this(paramInt, paramInt);
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
/*     */   protected f(int paramInt1, int paramInt2) {
/*  64 */     D.checkArgument((paramInt2 % paramInt1 == 0));
/*     */ 
/*     */ 
/*     */     
/*  68 */     this.buffer = ByteBuffer.allocate(paramInt2 + 7).order(ByteOrder.LITTLE_ENDIAN);
/*  69 */     this.bufferSize = paramInt2;
/*  70 */     this.chunkSize = paramInt1;
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
/*     */   protected void d(ByteBuffer paramByteBuffer) {
/*  83 */     u.b(paramByteBuffer, paramByteBuffer.limit());
/*  84 */     u.a(paramByteBuffer, this.chunkSize + 7);
/*  85 */     while (paramByteBuffer.position() < this.chunkSize) {
/*  86 */       paramByteBuffer.putLong(0L);
/*     */     }
/*  88 */     u.a(paramByteBuffer, this.chunkSize);
/*  89 */     u.b(paramByteBuffer);
/*  90 */     c(paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public final p a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  95 */     return b(ByteBuffer.wrap(paramArrayOfbyte, paramInt1, paramInt2).order(ByteOrder.LITTLE_ENDIAN));
/*     */   }
/*     */ 
/*     */   
/*     */   public final p a(ByteBuffer paramByteBuffer) {
/* 100 */     ByteOrder byteOrder = paramByteBuffer.order();
/*     */     try {
/* 102 */       paramByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
/* 103 */       return b(paramByteBuffer);
/*     */     } finally {
/* 105 */       paramByteBuffer.order(byteOrder);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private p b(ByteBuffer paramByteBuffer) {
/* 111 */     if (paramByteBuffer.remaining() <= this.buffer.remaining()) {
/* 112 */       this.buffer.put(paramByteBuffer);
/* 113 */       ft();
/* 114 */       return this;
/*     */     } 
/*     */ 
/*     */     
/* 118 */     int i = this.bufferSize - this.buffer.position();
/* 119 */     for (byte b = 0; b < i; b++) {
/* 120 */       this.buffer.put(paramByteBuffer.get());
/*     */     }
/* 122 */     fu();
/*     */ 
/*     */     
/* 125 */     while (paramByteBuffer.remaining() >= this.chunkSize) {
/* 126 */       c(paramByteBuffer);
/*     */     }
/*     */ 
/*     */     
/* 130 */     this.buffer.put(paramByteBuffer);
/* 131 */     return this;
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
/*     */   public final p a(byte paramByte) {
/* 146 */     this.buffer.put(paramByte);
/* 147 */     ft();
/* 148 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public final p a(short paramShort) {
/* 153 */     this.buffer.putShort(paramShort);
/* 154 */     ft();
/* 155 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public final p a(char paramChar) {
/* 160 */     this.buffer.putChar(paramChar);
/* 161 */     ft();
/* 162 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public final p b(int paramInt) {
/* 167 */     this.buffer.putInt(paramInt);
/* 168 */     ft();
/* 169 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public final p a(long paramLong) {
/* 174 */     this.buffer.putLong(paramLong);
/* 175 */     ft();
/* 176 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public final n a() {
/* 181 */     fu();
/* 182 */     u.b(this.buffer);
/* 183 */     if (this.buffer.remaining() > 0) {
/* 184 */       d(this.buffer);
/* 185 */       u.b(this.buffer, this.buffer.limit());
/*     */     } 
/* 187 */     return b();
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
/*     */   private void ft() {
/* 199 */     if (this.buffer.remaining() < 8)
/*     */     {
/* 201 */       fu();
/*     */     }
/*     */   }
/*     */   
/*     */   private void fu() {
/* 206 */     u.b(this.buffer);
/* 207 */     while (this.buffer.remaining() >= this.chunkSize)
/*     */     {
/*     */       
/* 210 */       c(this.buffer);
/*     */     }
/* 212 */     this.buffer.compact();
/*     */   }
/*     */   
/*     */   protected abstract void c(ByteBuffer paramByteBuffer);
/*     */   
/*     */   protected abstract n b();
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\h\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */