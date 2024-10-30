/*    */ package org.h2.compress;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.OutputStream;
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
/*    */ public class LZFOutputStream
/*    */   extends OutputStream
/*    */ {
/*    */   static final int MAGIC = 1211255123;
/*    */   private final OutputStream out;
/* 24 */   private final CompressLZF compress = new CompressLZF();
/*    */   private final byte[] buffer;
/*    */   private int pos;
/*    */   private byte[] outBuffer;
/*    */   
/*    */   public LZFOutputStream(OutputStream paramOutputStream) throws IOException {
/* 30 */     this.out = paramOutputStream;
/* 31 */     int i = 131072;
/* 32 */     this.buffer = new byte[i];
/* 33 */     ensureOutput(i);
/* 34 */     writeInt(1211255123);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void ensureOutput(int paramInt) {
/* 40 */     int i = ((paramInt < 100) ? (paramInt + 100) : paramInt) * 2;
/* 41 */     if (this.outBuffer == null || this.outBuffer.length < i) {
/* 42 */       this.outBuffer = new byte[i];
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(int paramInt) throws IOException {
/* 48 */     if (this.pos >= this.buffer.length) {
/* 49 */       flush();
/*    */     }
/* 51 */     this.buffer[this.pos++] = (byte)paramInt;
/*    */   }
/*    */   
/*    */   private void compressAndWrite(byte[] paramArrayOfbyte, int paramInt) throws IOException {
/* 55 */     if (paramInt > 0) {
/* 56 */       ensureOutput(paramInt);
/* 57 */       int i = this.compress.compress(paramArrayOfbyte, paramInt, this.outBuffer, 0);
/* 58 */       if (i > paramInt) {
/* 59 */         writeInt(-paramInt);
/* 60 */         this.out.write(paramArrayOfbyte, 0, paramInt);
/*    */       } else {
/* 62 */         writeInt(i);
/* 63 */         writeInt(paramInt);
/* 64 */         this.out.write(this.outBuffer, 0, i);
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   private void writeInt(int paramInt) throws IOException {
/* 70 */     this.out.write((byte)(paramInt >> 24));
/* 71 */     this.out.write((byte)(paramInt >> 16));
/* 72 */     this.out.write((byte)(paramInt >> 8));
/* 73 */     this.out.write((byte)paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 78 */     while (paramInt2 > 0) {
/* 79 */       int i = Math.min(this.buffer.length - this.pos, paramInt2);
/* 80 */       System.arraycopy(paramArrayOfbyte, paramInt1, this.buffer, this.pos, i);
/* 81 */       this.pos += i;
/* 82 */       if (this.pos >= this.buffer.length) {
/* 83 */         flush();
/*    */       }
/* 85 */       paramInt1 += i;
/* 86 */       paramInt2 -= i;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void flush() throws IOException {
/* 92 */     compressAndWrite(this.buffer, this.pos);
/* 93 */     this.pos = 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public void close() throws IOException {
/* 98 */     flush();
/* 99 */     this.out.close();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\compress\LZFOutputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */