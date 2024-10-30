/*    */ package org.h2.store.fs;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.OutputStream;
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
/*    */ public class FileChannelOutputStream
/*    */   extends OutputStream
/*    */ {
/*    */   private final FileChannel channel;
/* 19 */   private final byte[] buffer = new byte[] { 0 };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public FileChannelOutputStream(FileChannel paramFileChannel, boolean paramBoolean) throws IOException {
/* 29 */     this.channel = paramFileChannel;
/* 30 */     if (paramBoolean) {
/* 31 */       paramFileChannel.position(paramFileChannel.size());
/*    */     } else {
/* 33 */       paramFileChannel.position(0L);
/* 34 */       paramFileChannel.truncate(0L);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(int paramInt) throws IOException {
/* 40 */     this.buffer[0] = (byte)paramInt;
/* 41 */     FileUtils.writeFully(this.channel, ByteBuffer.wrap(this.buffer));
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(byte[] paramArrayOfbyte) throws IOException {
/* 46 */     FileUtils.writeFully(this.channel, ByteBuffer.wrap(paramArrayOfbyte));
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 51 */     FileUtils.writeFully(this.channel, ByteBuffer.wrap(paramArrayOfbyte, paramInt1, paramInt2));
/*    */   }
/*    */ 
/*    */   
/*    */   public void close() throws IOException {
/* 56 */     this.channel.close();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\fs\FileChannelOutputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */