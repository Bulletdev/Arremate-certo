/*     */ package org.h2.store.fs;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.nio.channels.FileLock;
/*     */ import java.nio.channels.SeekableByteChannel;
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
/*     */ class FileRec
/*     */   extends FileBase
/*     */ {
/*     */   private final FilePathRec rec;
/*     */   private final FileChannel channel;
/*     */   private final String name;
/*     */   
/*     */   FileRec(FilePathRec paramFilePathRec, FileChannel paramFileChannel, String paramString) {
/* 132 */     this.rec = paramFilePathRec;
/* 133 */     this.channel = paramFileChannel;
/* 134 */     this.name = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public void implCloseChannel() throws IOException {
/* 139 */     this.channel.close();
/*     */   }
/*     */ 
/*     */   
/*     */   public long position() throws IOException {
/* 144 */     return this.channel.position();
/*     */   }
/*     */ 
/*     */   
/*     */   public long size() throws IOException {
/* 149 */     return this.channel.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(ByteBuffer paramByteBuffer) throws IOException {
/* 154 */     return this.channel.read(paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(ByteBuffer paramByteBuffer, long paramLong) throws IOException {
/* 159 */     return this.channel.read(paramByteBuffer, paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   public FileChannel position(long paramLong) throws IOException {
/* 164 */     this.channel.position(paramLong);
/* 165 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public FileChannel truncate(long paramLong) throws IOException {
/* 170 */     this.rec.log(7, this.name, null, paramLong);
/* 171 */     this.channel.truncate(paramLong);
/* 172 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void force(boolean paramBoolean) throws IOException {
/* 177 */     this.channel.force(paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public int write(ByteBuffer paramByteBuffer) throws IOException {
/* 182 */     byte[] arrayOfByte = paramByteBuffer.array();
/* 183 */     int i = paramByteBuffer.remaining();
/* 184 */     if (paramByteBuffer.position() != 0 || i != arrayOfByte.length) {
/* 185 */       byte[] arrayOfByte1 = new byte[i];
/* 186 */       System.arraycopy(arrayOfByte, paramByteBuffer.arrayOffset() + paramByteBuffer.position(), arrayOfByte1, 0, i);
/* 187 */       arrayOfByte = arrayOfByte1;
/*     */     } 
/* 189 */     int j = this.channel.write(paramByteBuffer);
/* 190 */     this.rec.log(8, this.name, arrayOfByte, this.channel.position());
/* 191 */     return j;
/*     */   }
/*     */ 
/*     */   
/*     */   public int write(ByteBuffer paramByteBuffer, long paramLong) throws IOException {
/* 196 */     byte[] arrayOfByte = paramByteBuffer.array();
/* 197 */     int i = paramByteBuffer.remaining();
/* 198 */     if (paramByteBuffer.position() != 0 || i != arrayOfByte.length) {
/* 199 */       byte[] arrayOfByte1 = new byte[i];
/* 200 */       System.arraycopy(arrayOfByte, paramByteBuffer.arrayOffset() + paramByteBuffer.position(), arrayOfByte1, 0, i);
/* 201 */       arrayOfByte = arrayOfByte1;
/*     */     } 
/* 203 */     int j = this.channel.write(paramByteBuffer, paramLong);
/* 204 */     this.rec.log(8, this.name, arrayOfByte, paramLong);
/* 205 */     return j;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized FileLock tryLock(long paramLong1, long paramLong2, boolean paramBoolean) throws IOException {
/* 211 */     return this.channel.tryLock(paramLong1, paramLong2, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 216 */     return this.name;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\fs\FileRec.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */