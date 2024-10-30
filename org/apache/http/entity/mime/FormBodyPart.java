/*     */ package org.apache.http.entity.mime;
/*     */ 
/*     */ import org.apache.http.entity.ContentType;
/*     */ import org.apache.http.entity.mime.content.AbstractContentBody;
/*     */ import org.apache.http.entity.mime.content.ContentBody;
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
/*     */ public class FormBodyPart
/*     */ {
/*     */   private final String name;
/*     */   private final Header header;
/*     */   private final ContentBody body;
/*     */   
/*     */   FormBodyPart(String paramString, ContentBody paramContentBody, Header paramHeader) {
/*  50 */     Args.notNull(paramString, "Name");
/*  51 */     Args.notNull(paramContentBody, "Body");
/*  52 */     this.name = paramString;
/*  53 */     this.body = paramContentBody;
/*  54 */     this.header = (paramHeader != null) ? paramHeader : new Header();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public FormBodyPart(String paramString, ContentBody paramContentBody) {
/*  63 */     Args.notNull(paramString, "Name");
/*  64 */     Args.notNull(paramContentBody, "Body");
/*  65 */     this.name = paramString;
/*  66 */     this.body = paramContentBody;
/*  67 */     this.header = new Header();
/*     */     
/*  69 */     generateContentDisp(paramContentBody);
/*  70 */     generateContentType(paramContentBody);
/*  71 */     generateTransferEncoding(paramContentBody);
/*     */   }
/*     */   
/*     */   public String getName() {
/*  75 */     return this.name;
/*     */   }
/*     */   
/*     */   public ContentBody getBody() {
/*  79 */     return this.body;
/*     */   }
/*     */   
/*     */   public Header getHeader() {
/*  83 */     return this.header;
/*     */   }
/*     */   
/*     */   public void addField(String paramString1, String paramString2) {
/*  87 */     Args.notNull(paramString1, "Field name");
/*  88 */     this.header.addField(new MinimalField(paramString1, paramString2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected void generateContentDisp(ContentBody paramContentBody) {
/*  96 */     StringBuilder stringBuilder = new StringBuilder();
/*  97 */     stringBuilder.append("form-data; name=\"");
/*  98 */     stringBuilder.append(getName());
/*  99 */     stringBuilder.append("\"");
/* 100 */     if (paramContentBody.getFilename() != null) {
/* 101 */       stringBuilder.append("; filename=\"");
/* 102 */       stringBuilder.append(paramContentBody.getFilename());
/* 103 */       stringBuilder.append("\"");
/*     */     } 
/* 105 */     addField("Content-Disposition", stringBuilder.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected void generateContentType(ContentBody paramContentBody) {
/*     */     ContentType contentType;
/* 114 */     if (paramContentBody instanceof AbstractContentBody) {
/* 115 */       contentType = ((AbstractContentBody)paramContentBody).getContentType();
/*     */     } else {
/* 117 */       contentType = null;
/*     */     } 
/* 119 */     if (contentType != null) {
/* 120 */       addField("Content-Type", contentType.toString());
/*     */     } else {
/* 122 */       StringBuilder stringBuilder = new StringBuilder();
/* 123 */       stringBuilder.append(paramContentBody.getMimeType());
/* 124 */       if (paramContentBody.getCharset() != null) {
/* 125 */         stringBuilder.append("; charset=");
/* 126 */         stringBuilder.append(paramContentBody.getCharset());
/*     */       } 
/* 128 */       addField("Content-Type", stringBuilder.toString());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected void generateTransferEncoding(ContentBody paramContentBody) {
/* 137 */     addField("Content-Transfer-Encoding", paramContentBody.getTransferEncoding());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\entity\mime\FormBodyPart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */