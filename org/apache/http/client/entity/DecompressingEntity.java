/*     */ package org.apache.http.client.entity;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.entity.HttpEntityWrapper;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DecompressingEntity
/*     */   extends HttpEntityWrapper
/*     */ {
/*     */   private static final int BUFFER_SIZE = 2048;
/*     */   private final InputStreamFactory inputStreamFactory;
/*     */   private InputStream content;
/*     */   
/*     */   public DecompressingEntity(HttpEntity paramHttpEntity, InputStreamFactory paramInputStreamFactory) {
/*  66 */     super(paramHttpEntity);
/*  67 */     this.inputStreamFactory = paramInputStreamFactory;
/*     */   }
/*     */   
/*     */   private InputStream getDecompressingStream() throws IOException {
/*  71 */     InputStream inputStream = this.wrappedEntity.getContent();
/*  72 */     return new LazyDecompressingInputStream(inputStream, this.inputStreamFactory);
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream getContent() throws IOException {
/*  77 */     if (this.wrappedEntity.isStreaming()) {
/*  78 */       if (this.content == null) {
/*  79 */         this.content = getDecompressingStream();
/*     */       }
/*  81 */       return this.content;
/*     */     } 
/*  83 */     return getDecompressingStream();
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeTo(OutputStream paramOutputStream) throws IOException {
/*  88 */     Args.notNull(paramOutputStream, "Output stream");
/*  89 */     InputStream inputStream = getContent();
/*     */     try {
/*  91 */       byte[] arrayOfByte = new byte[2048];
/*     */       int i;
/*  93 */       while ((i = inputStream.read(arrayOfByte)) != -1) {
/*  94 */         paramOutputStream.write(arrayOfByte, 0, i);
/*     */       }
/*     */     } finally {
/*  97 */       inputStream.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Header getContentEncoding() {
/* 104 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long getContentLength() {
/* 110 */     return -1L;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\entity\DecompressingEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */