/*     */ package org.apache.poi.poifs.nio;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.io.RandomAccessFile;
/*     */ import java.lang.reflect.Method;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.channels.Channels;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.nio.channels.WritableByteChannel;
/*     */ import java.security.AccessController;
/*     */ import java.security.PrivilegedAction;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.poi.util.IOUtils;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.apache.poi.util.SuppressForbidden;
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
/*     */ public class FileBackedDataSource
/*     */   extends DataSource
/*     */ {
/*  44 */   private static final POILogger logger = POILogFactory.getLogger(FileBackedDataSource.class);
/*     */ 
/*     */ 
/*     */   
/*     */   private FileChannel channel;
/*     */ 
/*     */   
/*     */   private boolean writable;
/*     */ 
/*     */   
/*     */   private RandomAccessFile srcFile;
/*     */ 
/*     */   
/*  57 */   private List<ByteBuffer> buffersToClean = new ArrayList<ByteBuffer>();
/*     */   
/*     */   public FileBackedDataSource(File paramFile) throws FileNotFoundException {
/*  60 */     this(newSrcFile(paramFile, "r"), true);
/*     */   }
/*     */   
/*     */   public FileBackedDataSource(File paramFile, boolean paramBoolean) throws FileNotFoundException {
/*  64 */     this(newSrcFile(paramFile, paramBoolean ? "r" : "rw"), paramBoolean);
/*     */   }
/*     */   
/*     */   public FileBackedDataSource(RandomAccessFile paramRandomAccessFile, boolean paramBoolean) {
/*  68 */     this(paramRandomAccessFile.getChannel(), paramBoolean);
/*  69 */     this.srcFile = paramRandomAccessFile;
/*     */   }
/*     */   
/*     */   public FileBackedDataSource(FileChannel paramFileChannel, boolean paramBoolean) {
/*  73 */     this.channel = paramFileChannel;
/*  74 */     this.writable = !paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean isWriteable() {
/*  78 */     return this.writable;
/*     */   }
/*     */   
/*     */   public FileChannel getChannel() {
/*  82 */     return this.channel;
/*     */   }
/*     */   
/*     */   public ByteBuffer read(int paramInt, long paramLong) throws IOException {
/*     */     ByteBuffer byteBuffer;
/*  87 */     if (paramLong >= size()) {
/*  88 */       throw new IndexOutOfBoundsException("Position " + paramLong + " past the end of the file");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  93 */     int i = -1;
/*  94 */     if (this.writable) {
/*  95 */       byteBuffer = this.channel.map(FileChannel.MapMode.READ_WRITE, paramLong, paramInt);
/*  96 */       i = 0;
/*     */       
/*  98 */       this.buffersToClean.add(byteBuffer);
/*     */     } else {
/*     */       
/* 101 */       this.channel.position(paramLong);
/* 102 */       byteBuffer = ByteBuffer.allocate(paramInt);
/* 103 */       i = IOUtils.readFully(this.channel, byteBuffer);
/*     */     } 
/*     */ 
/*     */     
/* 107 */     if (i == -1) {
/* 108 */       throw new IndexOutOfBoundsException("Position " + paramLong + " past the end of the file");
/*     */     }
/*     */ 
/*     */     
/* 112 */     byteBuffer.position(0);
/*     */ 
/*     */     
/* 115 */     return byteBuffer;
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(ByteBuffer paramByteBuffer, long paramLong) throws IOException {
/* 120 */     this.channel.write(paramByteBuffer, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void copyTo(OutputStream paramOutputStream) throws IOException {
/* 126 */     WritableByteChannel writableByteChannel = Channels.newChannel(paramOutputStream);
/*     */     
/* 128 */     this.channel.transferTo(0L, this.channel.size(), writableByteChannel);
/*     */   }
/*     */ 
/*     */   
/*     */   public long size() throws IOException {
/* 133 */     return this.channel.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 140 */     for (ByteBuffer byteBuffer : this.buffersToClean) {
/* 141 */       unmap(byteBuffer);
/*     */     }
/* 143 */     this.buffersToClean.clear();
/*     */     
/* 145 */     if (this.srcFile != null) {
/*     */       
/* 147 */       this.srcFile.close();
/*     */     } else {
/* 149 */       this.channel.close();
/*     */     } 
/*     */   }
/*     */   
/*     */   private static RandomAccessFile newSrcFile(File paramFile, String paramString) throws FileNotFoundException {
/* 154 */     if (!paramFile.exists()) {
/* 155 */       throw new FileNotFoundException(paramFile.toString());
/*     */     }
/* 157 */     return new RandomAccessFile(paramFile, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void unmap(final ByteBuffer buffer) {
/* 165 */     if (buffer.getClass().getName().endsWith("HeapByteBuffer")) {
/*     */       return;
/*     */     }
/*     */     
/* 169 */     AccessController.doPrivileged(new PrivilegedAction<Void>()
/*     */         {
/*     */           @SuppressForbidden("Java 9 Jigsaw whitelists access to sun.misc.Cleaner, so setAccessible works")
/*     */           public Void run() {
/*     */             try {
/* 174 */               Method method = buffer.getClass().getMethod("cleaner", new Class[0]);
/* 175 */               method.setAccessible(true);
/* 176 */               Object object = method.invoke(buffer, new Object[0]);
/* 177 */               if (object != null) {
/* 178 */                 object.getClass().getMethod("clean", new Class[0]).invoke(object, new Object[0]);
/*     */               }
/* 180 */             } catch (Exception exception) {
/* 181 */               FileBackedDataSource.logger.log(5, new Object[] { "Unable to unmap memory mapped ByteBuffer.", exception });
/*     */             } 
/* 183 */             return null;
/*     */           }
/*     */         });
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\nio\FileBackedDataSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */