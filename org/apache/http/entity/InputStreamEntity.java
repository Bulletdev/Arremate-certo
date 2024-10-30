/*     */ package org.apache.http.entity;
/*     */ 
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
/*     */ 
/*     */ public class InputStreamEntity
/*     */   extends AbstractHttpEntity
/*     */ {
/*     */   private final InputStream content;
/*     */   private final long length;
/*     */   
/*     */   public InputStreamEntity(InputStream paramInputStream) {
/*  56 */     this(paramInputStream, -1L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStreamEntity(InputStream paramInputStream, long paramLong) {
/*  67 */     this(paramInputStream, paramLong, null);
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
/*     */   public InputStreamEntity(InputStream paramInputStream, ContentType paramContentType) {
/*  80 */     this(paramInputStream, -1L, paramContentType);
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
/*     */   public InputStreamEntity(InputStream paramInputStream, long paramLong, ContentType paramContentType) {
/*  92 */     this.content = (InputStream)Args.notNull(paramInputStream, "Source input stream");
/*  93 */     this.length = paramLong;
/*  94 */     if (paramContentType != null) {
/*  95 */       setContentType(paramContentType.toString());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isRepeatable() {
/* 101 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getContentLength() {
/* 109 */     return this.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream getContent() throws IOException {
/* 114 */     return this.content;
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
/*     */   public void writeTo(OutputStream paramOutputStream) throws IOException {
/* 126 */     Args.notNull(paramOutputStream, "Output stream");
/* 127 */     InputStream inputStream = this.content;
/*     */     try {
/* 129 */       byte[] arrayOfByte = new byte[4096];
/*     */       
/* 131 */       if (this.length < 0L) {
/*     */         int i;
/* 133 */         while ((i = inputStream.read(arrayOfByte)) != -1) {
/* 134 */           paramOutputStream.write(arrayOfByte, 0, i);
/*     */         }
/*     */       } else {
/*     */         
/* 138 */         long l = this.length;
/* 139 */         while (l > 0L) {
/* 140 */           int i = inputStream.read(arrayOfByte, 0, (int)Math.min(4096L, l));
/* 141 */           if (i == -1) {
/*     */             break;
/*     */           }
/* 144 */           paramOutputStream.write(arrayOfByte, 0, i);
/* 145 */           l -= i;
/*     */         } 
/*     */       } 
/*     */     } finally {
/* 149 */       inputStream.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isStreaming() {
/* 155 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\entity\InputStreamEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */