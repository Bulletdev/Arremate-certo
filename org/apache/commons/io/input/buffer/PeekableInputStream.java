/*    */ package org.apache.commons.io.input.buffer;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.util.Objects;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PeekableInputStream
/*    */   extends CircularBufferInputStream
/*    */ {
/*    */   public PeekableInputStream(InputStream paramInputStream, int paramInt) {
/* 40 */     super(paramInputStream, paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public PeekableInputStream(InputStream paramInputStream) {
/* 50 */     super(paramInputStream);
/*    */   }
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
/*    */   public boolean peek(byte[] paramArrayOfbyte) throws IOException {
/* 63 */     Objects.requireNonNull(paramArrayOfbyte, "Buffer");
/* 64 */     if (paramArrayOfbyte.length > this.bufferSize) {
/* 65 */       throw new IllegalArgumentException("Peek request size of " + paramArrayOfbyte.length + " bytes exceeds buffer size of " + this.bufferSize + " bytes");
/*    */     }
/*    */     
/* 68 */     if (this.buffer.getCurrentNumberOfBytes() < paramArrayOfbyte.length) {
/* 69 */       fillBuffer();
/*    */     }
/* 71 */     return this.buffer.peek(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*    */   }
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
/*    */   public boolean peek(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 85 */     Objects.requireNonNull(paramArrayOfbyte, "Buffer");
/* 86 */     if (paramArrayOfbyte.length > this.bufferSize) {
/* 87 */       throw new IllegalArgumentException("Peek request size of " + paramArrayOfbyte.length + " bytes exceeds buffer size of " + this.bufferSize + " bytes");
/*    */     }
/*    */     
/* 90 */     if (this.buffer.getCurrentNumberOfBytes() < paramArrayOfbyte.length) {
/* 91 */       fillBuffer();
/*    */     }
/* 93 */     return this.buffer.peek(paramArrayOfbyte, paramInt1, paramInt2);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\input\buffer\PeekableInputStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */