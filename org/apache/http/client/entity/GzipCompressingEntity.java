/*     */ package org.apache.http.client.entity;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.zip.GZIPOutputStream;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.entity.HttpEntityWrapper;
/*     */ import org.apache.http.message.BasicHeader;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GzipCompressingEntity
/*     */   extends HttpEntityWrapper
/*     */ {
/*     */   private static final String GZIP_CODEC = "gzip";
/*     */   
/*     */   public GzipCompressingEntity(HttpEntity paramHttpEntity) {
/*  79 */     super(paramHttpEntity);
/*     */   }
/*     */ 
/*     */   
/*     */   public Header getContentEncoding() {
/*  84 */     return (Header)new BasicHeader("Content-Encoding", "gzip");
/*     */   }
/*     */ 
/*     */   
/*     */   public long getContentLength() {
/*  89 */     return -1L;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isChunked() {
/*  95 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream getContent() throws IOException {
/* 100 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeTo(OutputStream paramOutputStream) throws IOException {
/* 105 */     Args.notNull(paramOutputStream, "Output stream");
/* 106 */     GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(paramOutputStream);
/* 107 */     this.wrappedEntity.writeTo(gZIPOutputStream);
/*     */ 
/*     */     
/* 110 */     gZIPOutputStream.close();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\entity\GzipCompressingEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */