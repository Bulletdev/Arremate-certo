/*     */ package org.apache.http.entity.mime;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.apache.http.entity.ContentType;
/*     */ import org.apache.http.entity.mime.content.AbstractContentBody;
/*     */ import org.apache.http.entity.mime.content.ContentBody;
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
/*     */ public class FormBodyPartBuilder
/*     */ {
/*     */   private String name;
/*     */   private ContentBody body;
/*     */   private final Header header;
/*     */   
/*     */   public static FormBodyPartBuilder create(String paramString, ContentBody paramContentBody) {
/*  50 */     return new FormBodyPartBuilder(paramString, paramContentBody);
/*     */   }
/*     */   
/*     */   public static FormBodyPartBuilder create() {
/*  54 */     return new FormBodyPartBuilder();
/*     */   }
/*     */   
/*     */   FormBodyPartBuilder(String paramString, ContentBody paramContentBody) {
/*  58 */     this();
/*  59 */     this.name = paramString;
/*  60 */     this.body = paramContentBody;
/*     */   }
/*     */   
/*     */   FormBodyPartBuilder() {
/*  64 */     this.header = new Header();
/*     */   }
/*     */   
/*     */   public FormBodyPartBuilder setName(String paramString) {
/*  68 */     this.name = paramString;
/*  69 */     return this;
/*     */   }
/*     */   
/*     */   public FormBodyPartBuilder setBody(ContentBody paramContentBody) {
/*  73 */     this.body = paramContentBody;
/*  74 */     return this;
/*     */   }
/*     */   
/*     */   public FormBodyPartBuilder addField(String paramString1, String paramString2) {
/*  78 */     Args.notNull(paramString1, "Field name");
/*  79 */     this.header.addField(new MinimalField(paramString1, paramString2));
/*  80 */     return this;
/*     */   }
/*     */   
/*     */   public FormBodyPartBuilder setField(String paramString1, String paramString2) {
/*  84 */     Args.notNull(paramString1, "Field name");
/*  85 */     this.header.setField(new MinimalField(paramString1, paramString2));
/*  86 */     return this;
/*     */   }
/*     */   
/*     */   public FormBodyPartBuilder removeFields(String paramString) {
/*  90 */     Args.notNull(paramString, "Field name");
/*  91 */     this.header.removeFields(paramString);
/*  92 */     return this;
/*     */   }
/*     */   
/*     */   public FormBodyPart build() {
/*  96 */     Asserts.notBlank(this.name, "Name");
/*  97 */     Asserts.notNull(this.body, "Content body");
/*  98 */     Header header = new Header();
/*  99 */     List<MinimalField> list = this.header.getFields();
/* 100 */     for (MinimalField minimalField : list) {
/* 101 */       header.addField(minimalField);
/*     */     }
/* 103 */     if (header.getField("Content-Disposition") == null) {
/* 104 */       StringBuilder stringBuilder = new StringBuilder();
/* 105 */       stringBuilder.append("form-data; name=\"");
/* 106 */       stringBuilder.append(encodeForHeader(this.name));
/* 107 */       stringBuilder.append("\"");
/* 108 */       if (this.body.getFilename() != null) {
/* 109 */         stringBuilder.append("; filename=\"");
/* 110 */         stringBuilder.append(encodeForHeader(this.body.getFilename()));
/* 111 */         stringBuilder.append("\"");
/*     */       } 
/* 113 */       header.addField(new MinimalField("Content-Disposition", stringBuilder.toString()));
/*     */     } 
/* 115 */     if (header.getField("Content-Type") == null) {
/*     */       ContentType contentType;
/* 117 */       if (this.body instanceof AbstractContentBody) {
/* 118 */         contentType = ((AbstractContentBody)this.body).getContentType();
/*     */       } else {
/* 120 */         contentType = null;
/*     */       } 
/* 122 */       if (contentType != null) {
/* 123 */         header.addField(new MinimalField("Content-Type", contentType.toString()));
/*     */       } else {
/* 125 */         StringBuilder stringBuilder = new StringBuilder();
/* 126 */         stringBuilder.append(this.body.getMimeType());
/* 127 */         if (this.body.getCharset() != null) {
/* 128 */           stringBuilder.append("; charset=");
/* 129 */           stringBuilder.append(this.body.getCharset());
/*     */         } 
/* 131 */         header.addField(new MinimalField("Content-Type", stringBuilder.toString()));
/*     */       } 
/*     */     } 
/* 134 */     if (header.getField("Content-Transfer-Encoding") == null)
/*     */     {
/* 136 */       header.addField(new MinimalField("Content-Transfer-Encoding", this.body.getTransferEncoding()));
/*     */     }
/* 138 */     return new FormBodyPart(this.name, this.body, header);
/*     */   }
/*     */   
/*     */   private static String encodeForHeader(String paramString) {
/* 142 */     if (paramString == null) {
/* 143 */       return null;
/*     */     }
/* 145 */     StringBuilder stringBuilder = new StringBuilder();
/* 146 */     for (byte b = 0; b < paramString.length(); b++) {
/* 147 */       char c = paramString.charAt(b);
/* 148 */       if (c == '"' || c == '\\' || c == '\r') {
/* 149 */         stringBuilder.append("\\");
/*     */       }
/* 151 */       stringBuilder.append(c);
/*     */     } 
/* 153 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\entity\mime\FormBodyPartBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */