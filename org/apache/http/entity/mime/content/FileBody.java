/*     */ package org.apache.http.entity.mime.content;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import org.apache.http.entity.ContentType;
/*     */ import org.apache.http.util.Args;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FileBody
/*     */   extends AbstractContentBody
/*     */ {
/*     */   private final File file;
/*     */   private final String filename;
/*     */   
/*     */   @Deprecated
/*     */   public FileBody(File paramFile, String paramString1, String paramString2, String paramString3) {
/*  63 */     this(paramFile, ContentType.create(paramString2, paramString3), paramString1);
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
/*     */   @Deprecated
/*     */   public FileBody(File paramFile, String paramString1, String paramString2) {
/*  76 */     this(paramFile, null, paramString1, paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public FileBody(File paramFile, String paramString) {
/*  85 */     this(paramFile, ContentType.create(paramString), (String)null);
/*     */   }
/*     */   
/*     */   public FileBody(File paramFile) {
/*  89 */     this(paramFile, ContentType.DEFAULT_BINARY, (paramFile != null) ? paramFile.getName() : null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FileBody(File paramFile, ContentType paramContentType, String paramString) {
/*  96 */     super(paramContentType);
/*  97 */     Args.notNull(paramFile, "File");
/*  98 */     this.file = paramFile;
/*  99 */     this.filename = (paramString == null) ? paramFile.getName() : paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FileBody(File paramFile, ContentType paramContentType) {
/* 106 */     this(paramFile, paramContentType, (paramFile != null) ? paramFile.getName() : null);
/*     */   }
/*     */   
/*     */   public InputStream getInputStream() throws IOException {
/* 110 */     return new FileInputStream(this.file);
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeTo(OutputStream paramOutputStream) throws IOException {
/* 115 */     Args.notNull(paramOutputStream, "Output stream");
/* 116 */     FileInputStream fileInputStream = new FileInputStream(this.file);
/*     */     try {
/* 118 */       byte[] arrayOfByte = new byte[4096];
/*     */       int i;
/* 120 */       while ((i = fileInputStream.read(arrayOfByte)) != -1) {
/* 121 */         paramOutputStream.write(arrayOfByte, 0, i);
/*     */       }
/* 123 */       paramOutputStream.flush();
/*     */     } finally {
/* 125 */       fileInputStream.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTransferEncoding() {
/* 131 */     return "binary";
/*     */   }
/*     */ 
/*     */   
/*     */   public long getContentLength() {
/* 136 */     return this.file.length();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getFilename() {
/* 141 */     return this.filename;
/*     */   }
/*     */   
/*     */   public File getFile() {
/* 145 */     return this.file;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\entity\mime\content\FileBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */