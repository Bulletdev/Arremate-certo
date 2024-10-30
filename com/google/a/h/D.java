/*     */ package com.google.a.h;
/*     */ 
/*     */ import com.google.a.b.D;
/*     */ import com.google.b.a.a;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.charset.Charset;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ abstract class d
/*     */   implements p
/*     */ {
/*     */   public final p a(boolean paramBoolean) {
/*  32 */     return a(paramBoolean ? 1 : 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public final p a(double paramDouble) {
/*  37 */     return a(Double.doubleToRawLongBits(paramDouble));
/*     */   }
/*     */ 
/*     */   
/*     */   public final p a(float paramFloat) {
/*  42 */     return b(Float.floatToRawIntBits(paramFloat));
/*     */   }
/*     */   public p a(CharSequence paramCharSequence) {
/*     */     byte b;
/*     */     int i;
/*  47 */     for (b = 0, i = paramCharSequence.length(); b < i; b++) {
/*  48 */       a(paramCharSequence.charAt(b));
/*     */     }
/*  50 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public p a(CharSequence paramCharSequence, Charset paramCharset) {
/*  55 */     return a(paramCharSequence.toString().getBytes(paramCharset));
/*     */   }
/*     */ 
/*     */   
/*     */   public p a(byte[] paramArrayOfbyte) {
/*  60 */     return a(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */   
/*     */   public p a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  65 */     D.a(paramInt1, paramInt1 + paramInt2, paramArrayOfbyte.length);
/*  66 */     for (byte b = 0; b < paramInt2; b++) {
/*  67 */       a(paramArrayOfbyte[paramInt1 + b]);
/*     */     }
/*  69 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public p a(ByteBuffer paramByteBuffer) {
/*  74 */     if (paramByteBuffer.hasArray()) {
/*  75 */       a(paramByteBuffer.array(), paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramByteBuffer.remaining());
/*  76 */       u.b(paramByteBuffer, paramByteBuffer.limit());
/*     */     } else {
/*  78 */       for (int i = paramByteBuffer.remaining(); i > 0; i--) {
/*  79 */         a(paramByteBuffer.get());
/*     */       }
/*     */     } 
/*  82 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public p a(short paramShort) {
/*  87 */     a((byte)paramShort);
/*  88 */     a((byte)(paramShort >>> 8));
/*  89 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public p b(int paramInt) {
/*  94 */     a((byte)paramInt);
/*  95 */     a((byte)(paramInt >>> 8));
/*  96 */     a((byte)(paramInt >>> 16));
/*  97 */     a((byte)(paramInt >>> 24));
/*  98 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public p a(long paramLong) {
/* 103 */     for (byte b = 0; b < 64; b += 8) {
/* 104 */       a((byte)(int)(paramLong >>> b));
/*     */     }
/* 106 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public p a(char paramChar) {
/* 111 */     a((byte)paramChar);
/* 112 */     a((byte)(paramChar >>> 8));
/* 113 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public <T> p a(T paramT, l<? super T> paraml) {
/* 118 */     paraml.a(paramT, this);
/* 119 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\h\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */