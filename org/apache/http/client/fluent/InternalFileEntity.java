/*    */ package org.apache.http.client.fluent;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
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
/*    */ class InternalFileEntity
/*    */   extends AbstractHttpEntity
/*    */   implements Cloneable
/*    */ {
/*    */   private final File file;
/*    */   
/*    */   public InternalFileEntity(File paramFile, ContentType paramContentType) {
/* 46 */     this.file = (File)Args.notNull(paramFile, "File");
/* 47 */     if (paramContentType != null) {
/* 48 */       setContentType(paramContentType.toString());
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isRepeatable() {
/* 54 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public long getContentLength() {
/* 59 */     return this.file.length();
/*    */   }
/*    */ 
/*    */   
/*    */   public InputStream getContent() throws IOException {
/* 64 */     return new FileInputStream(this.file);
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeTo(OutputStream paramOutputStream) throws IOException {
/* 69 */     Args.notNull(paramOutputStream, "Output stream");
/* 70 */     FileInputStream fileInputStream = new FileInputStream(this.file);
/*    */     try {
/* 72 */       byte[] arrayOfByte = new byte[4096];
/*    */       int i;
/* 74 */       while ((i = fileInputStream.read(arrayOfByte)) != -1) {
/* 75 */         paramOutputStream.write(arrayOfByte, 0, i);
/*    */       }
/* 77 */       paramOutputStream.flush();
/*    */     } finally {
/* 79 */       fileInputStream.close();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isStreaming() {
/* 85 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\fluent\InternalFileEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */