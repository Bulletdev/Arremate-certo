/*     */ package org.apache.http.entity;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
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
/*     */ public class FileEntity
/*     */   extends AbstractHttpEntity
/*     */   implements Cloneable
/*     */ {
/*     */   protected final File file;
/*     */   
/*     */   @Deprecated
/*     */   public FileEntity(File paramFile, String paramString) {
/*  58 */     this.file = (File)Args.notNull(paramFile, "File");
/*  59 */     setContentType(paramString);
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
/*     */   public FileEntity(File paramFile, ContentType paramContentType) {
/*  72 */     this.file = (File)Args.notNull(paramFile, "File");
/*  73 */     if (paramContentType != null) {
/*  74 */       setContentType(paramContentType.toString());
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
/*     */   public FileEntity(File paramFile) {
/*  87 */     this.file = (File)Args.notNull(paramFile, "File");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isRepeatable() {
/*  92 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getContentLength() {
/*  97 */     return this.file.length();
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream getContent() throws IOException {
/* 102 */     return new FileInputStream(this.file);
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeTo(OutputStream paramOutputStream) throws IOException {
/* 107 */     Args.notNull(paramOutputStream, "Output stream");
/* 108 */     FileInputStream fileInputStream = new FileInputStream(this.file);
/*     */     try {
/* 110 */       byte[] arrayOfByte = new byte[4096];
/*     */       int i;
/* 112 */       while ((i = fileInputStream.read(arrayOfByte)) != -1) {
/* 113 */         paramOutputStream.write(arrayOfByte, 0, i);
/*     */       }
/* 115 */       paramOutputStream.flush();
/*     */     } finally {
/* 117 */       fileInputStream.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isStreaming() {
/* 128 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object clone() throws CloneNotSupportedException {
/* 135 */     return super.clone();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\entity\FileEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */