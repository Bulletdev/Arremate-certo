/*    */ package com.google.a.h;
/*    */ 
/*    */ import com.google.a.b.D;
/*    */ import com.google.b.a.j;
/*    */ import java.nio.ByteBuffer;
/*    */ import java.nio.charset.Charset;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @j
/*    */ abstract class c
/*    */   implements o
/*    */ {
/*    */   public <T> n a(T paramT, l<? super T> paraml) {
/* 33 */     return a().<T>a(paramT, paraml).a();
/*    */   }
/*    */ 
/*    */   
/*    */   public n a(CharSequence paramCharSequence) {
/* 38 */     int i = paramCharSequence.length();
/* 39 */     return c(i * 2).a(paramCharSequence).a();
/*    */   }
/*    */ 
/*    */   
/*    */   public n a(CharSequence paramCharSequence, Charset paramCharset) {
/* 44 */     return a().a(paramCharSequence, paramCharset).a();
/*    */   }
/*    */ 
/*    */   
/*    */   public n a(int paramInt) {
/* 49 */     return c(4).b(paramInt).a();
/*    */   }
/*    */ 
/*    */   
/*    */   public n a(long paramLong) {
/* 54 */     return c(8).a(paramLong).a();
/*    */   }
/*    */ 
/*    */   
/*    */   public n a(byte[] paramArrayOfbyte) {
/* 59 */     return a(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*    */   }
/*    */ 
/*    */   
/*    */   public n a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 64 */     D.a(paramInt1, paramInt1 + paramInt2, paramArrayOfbyte.length);
/* 65 */     return c(paramInt2).a(paramArrayOfbyte, paramInt1, paramInt2).a();
/*    */   }
/*    */ 
/*    */   
/*    */   public n a(ByteBuffer paramByteBuffer) {
/* 70 */     return c(paramByteBuffer.remaining()).a(paramByteBuffer).a();
/*    */   }
/*    */ 
/*    */   
/*    */   public p c(int paramInt) {
/* 75 */     D.a((paramInt >= 0), "expectedInputSize must be >= 0 but was %s", paramInt);
/*    */     
/* 77 */     return a();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\h\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */