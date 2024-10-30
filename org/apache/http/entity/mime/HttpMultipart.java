/*     */ package org.apache.http.entity.mime;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ public class HttpMultipart
/*     */   extends AbstractMultipartForm
/*     */ {
/*     */   private final HttpMultipartMode mode;
/*     */   private final List<FormBodyPart> parts;
/*     */   private final String subType;
/*     */   
/*     */   public HttpMultipart(String paramString1, Charset paramCharset, String paramString2, HttpMultipartMode paramHttpMultipartMode) {
/*  66 */     super(paramCharset, paramString2);
/*  67 */     this.subType = paramString1;
/*  68 */     this.mode = paramHttpMultipartMode;
/*  69 */     this.parts = new ArrayList<FormBodyPart>();
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
/*     */   public HttpMultipart(String paramString1, Charset paramCharset, String paramString2) {
/*  83 */     this(paramString1, paramCharset, paramString2, HttpMultipartMode.STRICT);
/*     */   }
/*     */   
/*     */   public HttpMultipart(String paramString1, String paramString2) {
/*  87 */     this(paramString1, (Charset)null, paramString2);
/*     */   }
/*     */   
/*     */   public HttpMultipartMode getMode() {
/*  91 */     return this.mode;
/*     */   }
/*     */   
/*     */   protected void formatMultipartHeader(FormBodyPart paramFormBodyPart, OutputStream paramOutputStream) throws IOException {
/*     */     MinimalField minimalField;
/*     */     String str;
/*  97 */     Header header = paramFormBodyPart.getHeader();
/*  98 */     switch (this.mode) {
/*     */ 
/*     */       
/*     */       case BROWSER_COMPATIBLE:
/* 102 */         minimalField = header.getField("Content-Disposition");
/* 103 */         writeField(minimalField, this.charset, paramOutputStream);
/* 104 */         str = paramFormBodyPart.getBody().getFilename();
/* 105 */         if (str != null) {
/* 106 */           MinimalField minimalField1 = header.getField("Content-Type");
/* 107 */           writeField(minimalField1, this.charset, paramOutputStream);
/*     */         } 
/*     */         return;
/*     */     } 
/* 111 */     for (MinimalField minimalField1 : header) {
/* 112 */       writeField(minimalField1, paramOutputStream);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<FormBodyPart> getBodyParts() {
/* 119 */     return this.parts;
/*     */   }
/*     */   
/*     */   public void addBodyPart(FormBodyPart paramFormBodyPart) {
/* 123 */     if (paramFormBodyPart == null) {
/*     */       return;
/*     */     }
/* 126 */     this.parts.add(paramFormBodyPart);
/*     */   }
/*     */   
/*     */   public String getSubType() {
/* 130 */     return this.subType;
/*     */   }
/*     */   
/*     */   public Charset getCharset() {
/* 134 */     return this.charset;
/*     */   }
/*     */   
/*     */   public String getBoundary() {
/* 138 */     return this.boundary;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\entity\mime\HttpMultipart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */