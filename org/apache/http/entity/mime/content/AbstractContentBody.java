/*    */ package org.apache.http.entity.mime.content;
/*    */ 
/*    */ import java.nio.charset.Charset;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AbstractContentBody
/*    */   implements ContentBody
/*    */ {
/*    */   private final ContentType contentType;
/*    */   
/*    */   public AbstractContentBody(ContentType paramContentType) {
/* 48 */     Args.notNull(paramContentType, "Content type");
/* 49 */     this.contentType = paramContentType;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   public AbstractContentBody(String paramString) {
/* 57 */     this(ContentType.parse(paramString));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ContentType getContentType() {
/* 64 */     return this.contentType;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getMimeType() {
/* 69 */     return this.contentType.getMimeType();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getMediaType() {
/* 74 */     String str = this.contentType.getMimeType();
/* 75 */     int i = str.indexOf('/');
/* 76 */     if (i != -1) {
/* 77 */       return str.substring(0, i);
/*    */     }
/* 79 */     return str;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getSubType() {
/* 85 */     String str = this.contentType.getMimeType();
/* 86 */     int i = str.indexOf('/');
/* 87 */     if (i != -1) {
/* 88 */       return str.substring(i + 1);
/*    */     }
/* 90 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getCharset() {
/* 96 */     Charset charset = this.contentType.getCharset();
/* 97 */     return (charset != null) ? charset.name() : null;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\entity\mime\content\AbstractContentBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */