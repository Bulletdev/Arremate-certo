/*    */ package com.google.a.j;
/*    */ 
/*    */ import com.google.a.a.a;
/*    */ import com.google.a.a.c;
/*    */ import com.google.a.b.D;
/*    */ import java.io.FilterInputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
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
/*    */ @a
/*    */ @c
/*    */ public final class o
/*    */   extends FilterInputStream
/*    */ {
/*    */   private long count;
/* 36 */   private long mark = -1L;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public o(InputStream paramInputStream) {
/* 44 */     super((InputStream)D.checkNotNull(paramInputStream));
/*    */   }
/*    */ 
/*    */   
/*    */   public long getCount() {
/* 49 */     return this.count;
/*    */   }
/*    */ 
/*    */   
/*    */   public int read() throws IOException {
/* 54 */     int i = this.in.read();
/* 55 */     if (i != -1) {
/* 56 */       this.count++;
/*    */     }
/* 58 */     return i;
/*    */   }
/*    */ 
/*    */   
/*    */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 63 */     int i = this.in.read(paramArrayOfbyte, paramInt1, paramInt2);
/* 64 */     if (i != -1) {
/* 65 */       this.count += i;
/*    */     }
/* 67 */     return i;
/*    */   }
/*    */ 
/*    */   
/*    */   public long skip(long paramLong) throws IOException {
/* 72 */     long l = this.in.skip(paramLong);
/* 73 */     this.count += l;
/* 74 */     return l;
/*    */   }
/*    */ 
/*    */   
/*    */   public synchronized void mark(int paramInt) {
/* 79 */     this.in.mark(paramInt);
/* 80 */     this.mark = this.count;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public synchronized void reset() throws IOException {
/* 86 */     if (!this.in.markSupported()) {
/* 87 */       throw new IOException("Mark not supported");
/*    */     }
/* 89 */     if (this.mark == -1L) {
/* 90 */       throw new IOException("Mark not set");
/*    */     }
/*    */     
/* 93 */     this.in.reset();
/* 94 */     this.count = this.mark;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\j\o.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */