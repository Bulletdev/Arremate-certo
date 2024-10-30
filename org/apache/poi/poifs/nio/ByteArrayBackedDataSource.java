/*    */ package org.apache.poi.poifs.nio;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.OutputStream;
/*    */ import java.nio.ByteBuffer;
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
/*    */ public class ByteArrayBackedDataSource
/*    */   extends DataSource
/*    */ {
/*    */   private byte[] buffer;
/*    */   private long size;
/*    */   
/*    */   public ByteArrayBackedDataSource(byte[] paramArrayOfbyte, int paramInt) {
/* 32 */     this.buffer = paramArrayOfbyte;
/* 33 */     this.size = paramInt;
/*    */   }
/*    */   public ByteArrayBackedDataSource(byte[] paramArrayOfbyte) {
/* 36 */     this(paramArrayOfbyte, paramArrayOfbyte.length);
/*    */   }
/*    */ 
/*    */   
/*    */   public ByteBuffer read(int paramInt, long paramLong) {
/* 41 */     if (paramLong >= this.size) {
/* 42 */       throw new IndexOutOfBoundsException("Unable to read " + paramInt + " bytes from " + paramLong + " in stream of length " + this.size);
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 48 */     int i = (int)Math.min(paramInt, this.size - paramLong);
/* 49 */     return ByteBuffer.wrap(this.buffer, (int)paramLong, i);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void write(ByteBuffer paramByteBuffer, long paramLong) {
/* 55 */     long l = paramLong + paramByteBuffer.capacity();
/* 56 */     if (l > this.buffer.length) {
/* 57 */       extend(l);
/*    */     }
/*    */ 
/*    */     
/* 61 */     paramByteBuffer.get(this.buffer, (int)paramLong, paramByteBuffer.capacity());
/*    */ 
/*    */     
/* 64 */     if (l > this.size) {
/* 65 */       this.size = l;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   private void extend(long paramLong) {
/* 71 */     long l = paramLong - this.buffer.length;
/* 72 */     if (l < this.buffer.length * 0.25D) {
/* 73 */       l = (long)(this.buffer.length * 0.25D);
/*    */     }
/* 75 */     if (l < 4096L) {
/* 76 */       l = 4096L;
/*    */     }
/*    */     
/* 79 */     byte[] arrayOfByte = new byte[(int)(l + this.buffer.length)];
/* 80 */     System.arraycopy(this.buffer, 0, arrayOfByte, 0, (int)this.size);
/* 81 */     this.buffer = arrayOfByte;
/*    */   }
/*    */ 
/*    */   
/*    */   public void copyTo(OutputStream paramOutputStream) throws IOException {
/* 86 */     paramOutputStream.write(this.buffer, 0, (int)this.size);
/*    */   }
/*    */ 
/*    */   
/*    */   public long size() {
/* 91 */     return this.size;
/*    */   }
/*    */ 
/*    */   
/*    */   public void close() {
/* 96 */     this.buffer = null;
/* 97 */     this.size = -1L;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\nio\ByteArrayBackedDataSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */