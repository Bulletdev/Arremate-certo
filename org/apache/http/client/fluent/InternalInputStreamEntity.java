/*    */ package org.apache.http.client.fluent;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.OutputStream;
/*    */ import org.apache.http.entity.AbstractHttpEntity;
/*    */ import org.apache.http.entity.ContentType;
/*    */ import org.apache.http.util.Args;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class InternalInputStreamEntity
/*    */   extends AbstractHttpEntity
/*    */ {
/*    */   private final InputStream content;
/*    */   private final long length;
/*    */   
/*    */   public InternalInputStreamEntity(InputStream paramInputStream, long paramLong, ContentType paramContentType) {
/* 45 */     this.content = (InputStream)Args.notNull(paramInputStream, "Source input stream");
/* 46 */     this.length = paramLong;
/* 47 */     if (paramContentType != null) {
/* 48 */       setContentType(paramContentType.toString());
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isRepeatable() {
/* 54 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public long getContentLength() {
/* 59 */     return this.length;
/*    */   }
/*    */ 
/*    */   
/*    */   public InputStream getContent() throws IOException {
/* 64 */     return this.content;
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeTo(OutputStream paramOutputStream) throws IOException {
/* 69 */     Args.notNull(paramOutputStream, "Output stream");
/* 70 */     InputStream inputStream = this.content;
/*    */     try {
/* 72 */       byte[] arrayOfByte = new byte[4096];
/*    */       
/* 74 */       if (this.length < 0L) {
/*    */         int i;
/* 76 */         while ((i = inputStream.read(arrayOfByte)) != -1) {
/* 77 */           paramOutputStream.write(arrayOfByte, 0, i);
/*    */         }
/*    */       } else {
/*    */         
/* 81 */         long l = this.length;
/* 82 */         while (l > 0L) {
/* 83 */           int i = inputStream.read(arrayOfByte, 0, (int)Math.min(4096L, l));
/* 84 */           if (i == -1) {
/*    */             break;
/*    */           }
/* 87 */           paramOutputStream.write(arrayOfByte, 0, i);
/* 88 */           l -= i;
/*    */         } 
/*    */       } 
/*    */     } finally {
/* 92 */       inputStream.close();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isStreaming() {
/* 98 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\fluent\InternalInputStreamEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */