/*    */ package org.apache.http.entity.mime;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.OutputStream;
/*    */ import java.nio.charset.Charset;
/*    */ import java.util.List;
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
/*    */ 
/*    */ 
/*    */ class HttpRFC6532Multipart
/*    */   extends AbstractMultipartForm
/*    */ {
/*    */   private final List<FormBodyPart> parts;
/*    */   
/*    */   public HttpRFC6532Multipart(Charset paramCharset, String paramString, List<FormBodyPart> paramList) {
/* 50 */     super(paramCharset, paramString);
/* 51 */     this.parts = paramList;
/*    */   }
/*    */ 
/*    */   
/*    */   public List<FormBodyPart> getBodyParts() {
/* 56 */     return this.parts;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void formatMultipartHeader(FormBodyPart paramFormBodyPart, OutputStream paramOutputStream) throws IOException {
/* 65 */     Header header = paramFormBodyPart.getHeader();
/* 66 */     for (MinimalField minimalField : header)
/* 67 */       writeField(minimalField, MIME.UTF8_CHARSET, paramOutputStream); 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\entity\mime\HttpRFC6532Multipart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */