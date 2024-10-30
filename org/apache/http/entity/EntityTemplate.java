/*    */ package org.apache.http.entity;
/*    */ 
/*    */ import java.io.ByteArrayInputStream;
/*    */ import java.io.ByteArrayOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.OutputStream;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EntityTemplate
/*    */   extends AbstractHttpEntity
/*    */ {
/*    */   private final ContentProducer contentproducer;
/*    */   
/*    */   public EntityTemplate(ContentProducer paramContentProducer) {
/* 50 */     this.contentproducer = (ContentProducer)Args.notNull(paramContentProducer, "Content producer");
/*    */   }
/*    */ 
/*    */   
/*    */   public long getContentLength() {
/* 55 */     return -1L;
/*    */   }
/*    */ 
/*    */   
/*    */   public InputStream getContent() throws IOException {
/* 60 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 61 */     writeTo(byteArrayOutputStream);
/* 62 */     return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isRepeatable() {
/* 67 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeTo(OutputStream paramOutputStream) throws IOException {
/* 72 */     Args.notNull(paramOutputStream, "Output stream");
/* 73 */     this.contentproducer.writeTo(paramOutputStream);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isStreaming() {
/* 78 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\entity\EntityTemplate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */