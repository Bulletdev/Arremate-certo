/*     */ package org.apache.http.entity;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
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
/*     */ public class ByteArrayEntity
/*     */   extends AbstractHttpEntity
/*     */   implements Cloneable
/*     */ {
/*     */   @Deprecated
/*     */   protected final byte[] content;
/*     */   private final byte[] b;
/*     */   private final int off;
/*     */   private final int len;
/*     */   
/*     */   public ByteArrayEntity(byte[] paramArrayOfbyte, ContentType paramContentType) {
/*  57 */     Args.notNull(paramArrayOfbyte, "Source byte array");
/*  58 */     this.content = paramArrayOfbyte;
/*  59 */     this.b = paramArrayOfbyte;
/*  60 */     this.off = 0;
/*  61 */     this.len = this.b.length;
/*  62 */     if (paramContentType != null) {
/*  63 */       setContentType(paramContentType.toString());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteArrayEntity(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, ContentType paramContentType) {
/*  72 */     Args.notNull(paramArrayOfbyte, "Source byte array");
/*  73 */     if (paramInt1 < 0 || paramInt1 > paramArrayOfbyte.length || paramInt2 < 0 || paramInt1 + paramInt2 < 0 || paramInt1 + paramInt2 > paramArrayOfbyte.length)
/*     */     {
/*  75 */       throw new IndexOutOfBoundsException("off: " + paramInt1 + " len: " + paramInt2 + " b.length: " + paramArrayOfbyte.length);
/*     */     }
/*  77 */     this.content = paramArrayOfbyte;
/*  78 */     this.b = paramArrayOfbyte;
/*  79 */     this.off = paramInt1;
/*  80 */     this.len = paramInt2;
/*  81 */     if (paramContentType != null) {
/*  82 */       setContentType(paramContentType.toString());
/*     */     }
/*     */   }
/*     */   
/*     */   public ByteArrayEntity(byte[] paramArrayOfbyte) {
/*  87 */     this(paramArrayOfbyte, (ContentType)null);
/*     */   }
/*     */   
/*     */   public ByteArrayEntity(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  91 */     this(paramArrayOfbyte, paramInt1, paramInt2, (ContentType)null);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isRepeatable() {
/*  96 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getContentLength() {
/* 101 */     return this.len;
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream getContent() {
/* 106 */     return new ByteArrayInputStream(this.b, this.off, this.len);
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeTo(OutputStream paramOutputStream) throws IOException {
/* 111 */     Args.notNull(paramOutputStream, "Output stream");
/* 112 */     paramOutputStream.write(this.b, this.off, this.len);
/* 113 */     paramOutputStream.flush();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isStreaming() {
/* 124 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object clone() throws CloneNotSupportedException {
/* 129 */     return super.clone();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\entity\ByteArrayEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */