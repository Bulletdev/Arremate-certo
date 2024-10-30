/*     */ package org.apache.commons.io.output;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import org.apache.commons.io.FileUtils;
/*     */ import org.apache.commons.io.IOUtils;
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
/*     */ public class DeferredFileOutputStream
/*     */   extends ThresholdingOutputStream
/*     */ {
/*     */   private ByteArrayOutputStream memoryOutputStream;
/*     */   private OutputStream currentOutputStream;
/*     */   private File outputFile;
/*     */   private final String prefix;
/*     */   private final String suffix;
/*     */   private final File directory;
/*     */   private boolean closed = false;
/*     */   
/*     */   public DeferredFileOutputStream(int paramInt, File paramFile) {
/* 100 */     this(paramInt, paramFile, null, null, null, 1024);
/*     */   }
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
/*     */   public DeferredFileOutputStream(int paramInt1, int paramInt2, File paramFile) {
/* 115 */     this(paramInt1, paramFile, null, null, null, paramInt2);
/* 116 */     if (paramInt2 < 0) {
/* 117 */       throw new IllegalArgumentException("Initial buffer size must be atleast 0.");
/*     */     }
/*     */   }
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
/*     */   public DeferredFileOutputStream(int paramInt, String paramString1, String paramString2, File paramFile) {
/* 135 */     this(paramInt, null, paramString1, paramString2, paramFile, 1024);
/* 136 */     if (paramString1 == null) {
/* 137 */       throw new IllegalArgumentException("Temporary file prefix is missing");
/*     */     }
/*     */   }
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
/*     */   public DeferredFileOutputStream(int paramInt1, int paramInt2, String paramString1, String paramString2, File paramFile) {
/* 156 */     this(paramInt1, null, paramString1, paramString2, paramFile, paramInt2);
/* 157 */     if (paramString1 == null) {
/* 158 */       throw new IllegalArgumentException("Temporary file prefix is missing");
/*     */     }
/* 160 */     if (paramInt2 < 0) {
/* 161 */       throw new IllegalArgumentException("Initial buffer size must be atleast 0.");
/*     */     }
/*     */   }
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
/*     */   private DeferredFileOutputStream(int paramInt1, File paramFile1, String paramString1, String paramString2, File paramFile2, int paramInt2) {
/* 178 */     super(paramInt1);
/* 179 */     this.outputFile = paramFile1;
/* 180 */     this.prefix = paramString1;
/* 181 */     this.suffix = paramString2;
/* 182 */     this.directory = paramFile2;
/*     */     
/* 184 */     this.memoryOutputStream = new ByteArrayOutputStream(paramInt2);
/* 185 */     this.currentOutputStream = this.memoryOutputStream;
/*     */   }
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
/*     */   protected OutputStream getStream() throws IOException {
/* 203 */     return this.currentOutputStream;
/*     */   }
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
/*     */   protected void thresholdReached() throws IOException {
/* 218 */     if (this.prefix != null) {
/* 219 */       this.outputFile = File.createTempFile(this.prefix, this.suffix, this.directory);
/*     */     }
/* 221 */     FileUtils.forceMkdirParent(this.outputFile);
/* 222 */     FileOutputStream fileOutputStream = new FileOutputStream(this.outputFile);
/*     */     try {
/* 224 */       this.memoryOutputStream.writeTo(fileOutputStream);
/* 225 */     } catch (IOException iOException) {
/* 226 */       fileOutputStream.close();
/* 227 */       throw iOException;
/*     */     } 
/* 229 */     this.currentOutputStream = fileOutputStream;
/* 230 */     this.memoryOutputStream = null;
/*     */   }
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
/*     */   public boolean isInMemory() {
/* 246 */     return !isThresholdExceeded();
/*     */   }
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
/*     */   public byte[] getData() {
/* 260 */     if (this.memoryOutputStream != null)
/*     */     {
/* 262 */       return this.memoryOutputStream.toByteArray();
/*     */     }
/* 264 */     return null;
/*     */   }
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
/*     */   public File getFile() {
/* 284 */     return this.outputFile;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 296 */     super.close();
/* 297 */     this.closed = true;
/*     */   }
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
/*     */   public void writeTo(OutputStream paramOutputStream) throws IOException {
/* 313 */     if (!this.closed) {
/* 314 */       throw new IOException("Stream not closed");
/*     */     }
/*     */     
/* 317 */     if (isInMemory()) {
/* 318 */       this.memoryOutputStream.writeTo(paramOutputStream);
/*     */     } else {
/* 320 */       try (FileInputStream null = new FileInputStream(this.outputFile)) {
/* 321 */         IOUtils.copy(fileInputStream, paramOutputStream);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\output\DeferredFileOutputStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */