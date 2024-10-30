/*    */ package org.h2.store.fs;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.nio.ByteBuffer;
/*    */ import java.nio.channels.FileChannel;
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
/*    */ public class FileChannelInputStream
/*    */   extends InputStream
/*    */ {
/*    */   private final FileChannel channel;
/*    */   private final boolean closeChannel;
/*    */   private ByteBuffer buffer;
/*    */   private long pos;
/*    */   
/*    */   public FileChannelInputStream(FileChannel paramFileChannel, boolean paramBoolean) {
/* 31 */     this.channel = paramFileChannel;
/* 32 */     this.closeChannel = paramBoolean;
/*    */   }
/*    */ 
/*    */   
/*    */   public int read() throws IOException {
/* 37 */     if (this.buffer == null) {
/* 38 */       this.buffer = ByteBuffer.allocate(1);
/*    */     }
/* 40 */     this.buffer.rewind();
/* 41 */     int i = this.channel.read(this.buffer, this.pos++);
/* 42 */     if (i < 0) {
/* 43 */       return -1;
/*    */     }
/* 45 */     return this.buffer.get(0) & 0xFF;
/*    */   }
/*    */ 
/*    */   
/*    */   public int read(byte[] paramArrayOfbyte) throws IOException {
/* 50 */     return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*    */   }
/*    */ 
/*    */   
/*    */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 55 */     ByteBuffer byteBuffer = ByteBuffer.wrap(paramArrayOfbyte, paramInt1, paramInt2);
/* 56 */     int i = this.channel.read(byteBuffer, this.pos);
/* 57 */     if (i == -1) {
/* 58 */       return -1;
/*    */     }
/* 60 */     this.pos += i;
/* 61 */     return i;
/*    */   }
/*    */ 
/*    */   
/*    */   public void close() throws IOException {
/* 66 */     if (this.closeChannel)
/* 67 */       this.channel.close(); 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\fs\FileChannelInputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */