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
/*     */ @a
/*     */ abstract class a
/*     */   extends d
/*     */ {
/*  36 */   private final ByteBuffer a = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(byte[] paramArrayOfbyte) {
/*  43 */     update(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  48 */     for (int i = paramInt1; i < paramInt1 + paramInt2; i++) {
/*  49 */       a(paramArrayOfbyte[i]);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void a(ByteBuffer paramByteBuffer) {
/*  55 */     if (paramByteBuffer.hasArray()) {
/*  56 */       update(paramByteBuffer.array(), paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramByteBuffer.remaining());
/*  57 */       u.b(paramByteBuffer, paramByteBuffer.limit());
/*     */     } else {
/*  59 */       for (int i = paramByteBuffer.remaining(); i > 0; i--) {
/*  60 */         a(paramByteBuffer.get());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private p a(int paramInt) {
/*     */     try {
/*  68 */       update(this.a.array(), 0, paramInt);
/*     */     } finally {
/*  70 */       u.a(this.a);
/*     */     } 
/*  72 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public p a(byte paramByte) {
/*  77 */     a(paramByte);
/*  78 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public p a(byte[] paramArrayOfbyte) {
/*  83 */     D.checkNotNull(paramArrayOfbyte);
/*  84 */     update(paramArrayOfbyte);
/*  85 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public p a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  90 */     D.a(paramInt1, paramInt1 + paramInt2, paramArrayOfbyte.length);
/*  91 */     update(paramArrayOfbyte, paramInt1, paramInt2);
/*  92 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public p a(ByteBuffer paramByteBuffer) {
/*  97 */     a(paramByteBuffer);
/*  98 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public p a(short paramShort) {
/* 103 */     this.a.putShort(paramShort);
/* 104 */     return a(2);
/*     */   }
/*     */ 
/*     */   
/*     */   public p b(int paramInt) {
/* 109 */     this.a.putInt(paramInt);
/* 110 */     return a(4);
/*     */   }
/*     */ 
/*     */   
/*     */   public p a(long paramLong) {
/* 115 */     this.a.putLong(paramLong);
/* 116 */     return a(8);
/*     */   }
/*     */ 
/*     */   
/*     */   public p a(char paramChar) {
/* 121 */     this.a.putChar(paramChar);
/* 122 */     return a(2);
/*     */   }
/*     */   
/*     */   protected abstract void a(byte paramByte);
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\h\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */