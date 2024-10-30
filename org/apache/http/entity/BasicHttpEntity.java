/*     */ package org.apache.http.entity;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import org.apache.http.impl.io.EmptyInputStream;
/*     */ import org.apache.http.util.Args;
/*     */ import org.apache.http.util.Asserts;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BasicHttpEntity
/*     */   extends AbstractHttpEntity
/*     */ {
/*     */   private InputStream content;
/*  56 */   private long length = -1L;
/*     */ 
/*     */ 
/*     */   
/*     */   public long getContentLength() {
/*  61 */     return this.length;
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
/*     */   public InputStream getContent() throws IllegalStateException {
/*  75 */     Asserts.check((this.content != null), "Content has not been provided");
/*  76 */     return this.content;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRepeatable() {
/*  86 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setContentLength(long paramLong) {
/*  96 */     this.length = paramLong;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setContent(InputStream paramInputStream) {
/* 106 */     this.content = paramInputStream;
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeTo(OutputStream paramOutputStream) throws IOException {
/* 111 */     Args.notNull(paramOutputStream, "Output stream");
/* 112 */     InputStream inputStream = getContent();
/*     */     
/*     */     try {
/* 115 */       byte[] arrayOfByte = new byte[4096]; int i;
/* 116 */       while ((i = inputStream.read(arrayOfByte)) != -1) {
/* 117 */         paramOutputStream.write(arrayOfByte, 0, i);
/*     */       }
/*     */     } finally {
/* 120 */       inputStream.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isStreaming() {
/* 126 */     return (this.content != null && this.content != EmptyInputStream.INSTANCE);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\entity\BasicHttpEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */