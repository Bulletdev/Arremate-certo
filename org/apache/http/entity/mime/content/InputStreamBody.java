/*     */ package org.apache.http.entity.mime.content;
/*     */ 
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
/*     */ public class InputStreamBody
/*     */   extends AbstractContentBody
/*     */ {
/*     */   private final InputStream in;
/*     */   private final String filename;
/*     */   
/*     */   @Deprecated
/*     */   public InputStreamBody(InputStream paramInputStream, String paramString1, String paramString2) {
/*  58 */     this(paramInputStream, ContentType.create(paramString1), paramString2);
/*     */   }
/*     */   
/*     */   public InputStreamBody(InputStream paramInputStream, String paramString) {
/*  62 */     this(paramInputStream, ContentType.DEFAULT_BINARY, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStreamBody(InputStream paramInputStream, ContentType paramContentType, String paramString) {
/*  69 */     super(paramContentType);
/*  70 */     Args.notNull(paramInputStream, "Input stream");
/*  71 */     this.in = paramInputStream;
/*  72 */     this.filename = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStreamBody(InputStream paramInputStream, ContentType paramContentType) {
/*  79 */     this(paramInputStream, paramContentType, (String)null);
/*     */   }
/*     */   
/*     */   public InputStream getInputStream() {
/*  83 */     return this.in;
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeTo(OutputStream paramOutputStream) throws IOException {
/*  88 */     Args.notNull(paramOutputStream, "Output stream");
/*     */     try {
/*  90 */       byte[] arrayOfByte = new byte[4096];
/*     */       int i;
/*  92 */       while ((i = this.in.read(arrayOfByte)) != -1) {
/*  93 */         paramOutputStream.write(arrayOfByte, 0, i);
/*     */       }
/*  95 */       paramOutputStream.flush();
/*     */     } finally {
/*  97 */       this.in.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTransferEncoding() {
/* 103 */     return "binary";
/*     */   }
/*     */ 
/*     */   
/*     */   public long getContentLength() {
/* 108 */     return -1L;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getFilename() {
/* 113 */     return this.filename;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\entity\mime\content\InputStreamBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */