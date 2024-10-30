/*     */ package org.apache.commons.io.output;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.io.Writer;
/*     */ import java.nio.charset.Charset;
/*     */ import java.nio.charset.CharsetEncoder;
/*     */ import java.util.Objects;
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
/*     */ public class FileWriterWithEncoding
/*     */   extends Writer
/*     */ {
/*     */   private final Writer out;
/*     */   
/*     */   public FileWriterWithEncoding(String paramString1, String paramString2) throws IOException {
/*  67 */     this(new File(paramString1), paramString2, false);
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
/*     */   public FileWriterWithEncoding(String paramString1, String paramString2, boolean paramBoolean) throws IOException {
/*  81 */     this(new File(paramString1), paramString2, paramBoolean);
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
/*     */   public FileWriterWithEncoding(String paramString, Charset paramCharset) throws IOException {
/*  93 */     this(new File(paramString), paramCharset, false);
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
/*     */   public FileWriterWithEncoding(String paramString, Charset paramCharset, boolean paramBoolean) throws IOException {
/* 107 */     this(new File(paramString), paramCharset, paramBoolean);
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
/*     */   public FileWriterWithEncoding(String paramString, CharsetEncoder paramCharsetEncoder) throws IOException {
/* 119 */     this(new File(paramString), paramCharsetEncoder, false);
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
/*     */   public FileWriterWithEncoding(String paramString, CharsetEncoder paramCharsetEncoder, boolean paramBoolean) throws IOException {
/* 133 */     this(new File(paramString), paramCharsetEncoder, paramBoolean);
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
/*     */   public FileWriterWithEncoding(File paramFile, String paramString) throws IOException {
/* 145 */     this(paramFile, paramString, false);
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
/*     */   public FileWriterWithEncoding(File paramFile, String paramString, boolean paramBoolean) throws IOException {
/* 159 */     this.out = initWriter(paramFile, paramString, paramBoolean);
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
/*     */   public FileWriterWithEncoding(File paramFile, Charset paramCharset) throws IOException {
/* 171 */     this(paramFile, paramCharset, false);
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
/*     */   public FileWriterWithEncoding(File paramFile, Charset paramCharset, boolean paramBoolean) throws IOException {
/* 185 */     this.out = initWriter(paramFile, paramCharset, paramBoolean);
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
/*     */   public FileWriterWithEncoding(File paramFile, CharsetEncoder paramCharsetEncoder) throws IOException {
/* 197 */     this(paramFile, paramCharsetEncoder, false);
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
/*     */   public FileWriterWithEncoding(File paramFile, CharsetEncoder paramCharsetEncoder, boolean paramBoolean) throws IOException {
/* 212 */     this.out = initWriter(paramFile, paramCharsetEncoder, paramBoolean);
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
/*     */   private static Writer initWriter(File paramFile, Object paramObject, boolean paramBoolean) throws IOException {
/* 228 */     Objects.requireNonNull(paramFile, "file");
/* 229 */     Objects.requireNonNull(paramObject, "encoding");
/* 230 */     FileOutputStream fileOutputStream = null;
/* 231 */     boolean bool = paramFile.exists();
/*     */     try {
/* 233 */       fileOutputStream = new FileOutputStream(paramFile, paramBoolean);
/* 234 */       if (paramObject instanceof Charset)
/* 235 */         return new OutputStreamWriter(fileOutputStream, (Charset)paramObject); 
/* 236 */       if (paramObject instanceof CharsetEncoder) {
/* 237 */         return new OutputStreamWriter(fileOutputStream, (CharsetEncoder)paramObject);
/*     */       }
/* 239 */       return new OutputStreamWriter(fileOutputStream, (String)paramObject);
/*     */     }
/* 241 */     catch (IOException|RuntimeException iOException) {
/*     */       try {
/* 243 */         IOUtils.close(fileOutputStream);
/* 244 */       } catch (IOException iOException1) {
/* 245 */         iOException.addSuppressed(iOException1);
/*     */       } 
/* 247 */       if (!bool) {
/* 248 */         FileUtils.deleteQuietly(paramFile);
/*     */       }
/* 250 */       throw iOException;
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
/*     */   public void write(int paramInt) throws IOException {
/* 262 */     this.out.write(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(char[] paramArrayOfchar) throws IOException {
/* 272 */     this.out.write(paramArrayOfchar);
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
/*     */   public void write(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
/* 284 */     this.out.write(paramArrayOfchar, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(String paramString) throws IOException {
/* 294 */     this.out.write(paramString);
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
/*     */   public void write(String paramString, int paramInt1, int paramInt2) throws IOException {
/* 306 */     this.out.write(paramString, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void flush() throws IOException {
/* 315 */     this.out.flush();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 324 */     this.out.close();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\output\FileWriterWithEncoding.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */