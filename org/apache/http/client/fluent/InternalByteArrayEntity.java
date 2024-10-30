/*     */ package org.apache.http.client.fluent;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import org.apache.http.entity.AbstractHttpEntity;
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
/*     */ class InternalByteArrayEntity
/*     */   extends AbstractHttpEntity
/*     */   implements Cloneable
/*     */ {
/*     */   private final byte[] b;
/*     */   private final int off;
/*     */   private final int len;
/*     */   
/*     */   public InternalByteArrayEntity(byte[] paramArrayOfbyte, ContentType paramContentType) {
/*  46 */     Args.notNull(paramArrayOfbyte, "Source byte array");
/*  47 */     this.b = paramArrayOfbyte;
/*  48 */     this.off = 0;
/*  49 */     this.len = this.b.length;
/*  50 */     if (paramContentType != null) {
/*  51 */       setContentType(paramContentType.toString());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public InternalByteArrayEntity(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, ContentType paramContentType) {
/*  57 */     Args.notNull(paramArrayOfbyte, "Source byte array");
/*  58 */     if (paramInt1 < 0 || paramInt1 > paramArrayOfbyte.length || paramInt2 < 0 || paramInt1 + paramInt2 < 0 || paramInt1 + paramInt2 > paramArrayOfbyte.length)
/*     */     {
/*  60 */       throw new IndexOutOfBoundsException("off: " + paramInt1 + " len: " + paramInt2 + " b.length: " + paramArrayOfbyte.length);
/*     */     }
/*  62 */     this.b = paramArrayOfbyte;
/*  63 */     this.off = paramInt1;
/*  64 */     this.len = paramInt2;
/*  65 */     if (paramContentType != null) {
/*  66 */       setContentType(paramContentType.toString());
/*     */     }
/*     */   }
/*     */   
/*     */   public InternalByteArrayEntity(byte[] paramArrayOfbyte) {
/*  71 */     this(paramArrayOfbyte, (ContentType)null);
/*     */   }
/*     */   
/*     */   public InternalByteArrayEntity(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  75 */     this(paramArrayOfbyte, paramInt1, paramInt2, (ContentType)null);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isRepeatable() {
/*  80 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getContentLength() {
/*  85 */     return this.len;
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream getContent() {
/*  90 */     return new ByteArrayInputStream(this.b, this.off, this.len);
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeTo(OutputStream paramOutputStream) throws IOException {
/*  95 */     Args.notNull(paramOutputStream, "Output stream");
/*  96 */     paramOutputStream.write(this.b, this.off, this.len);
/*  97 */     paramOutputStream.flush();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isStreaming() {
/* 102 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\fluent\InternalByteArrayEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */