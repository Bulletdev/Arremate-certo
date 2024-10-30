/*     */ package com.google.a.h;
/*     */ 
/*     */ import com.google.a.b.D;
/*     */ import com.google.b.a.j;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @j
/*     */ abstract class e
/*     */   extends c
/*     */ {
/*     */   public p a() {
/*  36 */     return c(32);
/*     */   }
/*     */ 
/*     */   
/*     */   public p c(int paramInt) {
/*  41 */     D.checkArgument((paramInt >= 0));
/*  42 */     return new a(this, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public n a(int paramInt) {
/*  47 */     return a(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(paramInt).array());
/*     */   }
/*     */ 
/*     */   
/*     */   public n a(long paramLong) {
/*  52 */     return a(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(paramLong).array());
/*     */   }
/*     */ 
/*     */   
/*     */   public n a(CharSequence paramCharSequence) {
/*  57 */     int i = paramCharSequence.length();
/*  58 */     ByteBuffer byteBuffer = ByteBuffer.allocate(i * 2).order(ByteOrder.LITTLE_ENDIAN);
/*  59 */     for (byte b = 0; b < i; b++) {
/*  60 */       byteBuffer.putChar(paramCharSequence.charAt(b));
/*     */     }
/*  62 */     return a(byteBuffer.array());
/*     */   }
/*     */ 
/*     */   
/*     */   public n a(CharSequence paramCharSequence, Charset paramCharset) {
/*  67 */     return a(paramCharSequence.toString().getBytes(paramCharset));
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract n a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2);
/*     */ 
/*     */   
/*     */   public n a(ByteBuffer paramByteBuffer) {
/*  75 */     return c(paramByteBuffer.remaining()).a(paramByteBuffer).a();
/*     */   }
/*     */   
/*     */   private final class a
/*     */     extends d {
/*     */     final e.b a;
/*     */     
/*     */     a(e this$0, int param1Int) {
/*  83 */       this.a = (e)new e.b(param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     public p a(byte param1Byte) {
/*  88 */       this.a.write(param1Byte);
/*  89 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public p a(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
/*  94 */       this.a.write(param1ArrayOfbyte, param1Int1, param1Int2);
/*  95 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public p a(ByteBuffer param1ByteBuffer) {
/* 100 */       this.a.b(param1ByteBuffer);
/* 101 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public n a() {
/* 106 */       return this.a.a(this.a.f(), 0, this.a.length());
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class b
/*     */     extends ByteArrayOutputStream {
/*     */     b(int param1Int) {
/* 113 */       super(param1Int);
/*     */     }
/*     */     
/*     */     void b(ByteBuffer param1ByteBuffer) {
/* 117 */       int i = param1ByteBuffer.remaining();
/* 118 */       if (this.count + i > this.buf.length) {
/* 119 */         this.buf = Arrays.copyOf(this.buf, this.count + i);
/*     */       }
/* 121 */       param1ByteBuffer.get(this.buf, this.count, i);
/* 122 */       this.count += i;
/*     */     }
/*     */     
/*     */     byte[] f() {
/* 126 */       return this.buf;
/*     */     }
/*     */     
/*     */     int length() {
/* 130 */       return this.count;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\h\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */