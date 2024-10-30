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
/*    */ class HttpBrowserCompatibleMultipart
/*    */   extends AbstractMultipartForm
/*    */ {
/*    */   private final List<FormBodyPart> parts;
/*    */   
/*    */   public HttpBrowserCompatibleMultipart(Charset paramCharset, String paramString, List<FormBodyPart> paramList) {
/* 49 */     super(paramCharset, paramString);
/* 50 */     this.parts = paramList;
/*    */   }
/*    */ 
/*    */   
/*    */   public List<FormBodyPart> getBodyParts() {
/* 55 */     return this.parts;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void formatMultipartHeader(FormBodyPart paramFormBodyPart, OutputStream paramOutputStream) throws IOException {
/* 67 */     Header header = paramFormBodyPart.getHeader();
/* 68 */     MinimalField minimalField = header.getField("Content-Disposition");
/* 69 */     writeField(minimalField, this.charset, paramOutputStream);
/* 70 */     String str = paramFormBodyPart.getBody().getFilename();
/* 71 */     if (str != null) {
/* 72 */       MinimalField minimalField1 = header.getField("Content-Type");
/* 73 */       writeField(minimalField1, this.charset, paramOutputStream);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\entity\mime\HttpBrowserCompatibleMultipart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */