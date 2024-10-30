/*     */ package org.apache.http.client.entity;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.InputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.apache.http.entity.BasicHttpEntity;
/*     */ import org.apache.http.entity.ByteArrayEntity;
/*     */ import org.apache.http.entity.ContentType;
/*     */ import org.apache.http.entity.FileEntity;
/*     */ import org.apache.http.entity.InputStreamEntity;
/*     */ import org.apache.http.entity.SerializableEntity;
/*     */ import org.apache.http.entity.StringEntity;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityBuilder
/*     */ {
/*     */   private String text;
/*     */   private byte[] binary;
/*     */   private InputStream stream;
/*     */   private List<NameValuePair> parameters;
/*     */   private Serializable serializable;
/*     */   private File file;
/*     */   private ContentType contentType;
/*     */   private String contentEncoding;
/*     */   private boolean chunked;
/*     */   private boolean gzipCompress;
/*     */   
/*     */   public static EntityBuilder create() {
/*  83 */     return new EntityBuilder();
/*     */   }
/*     */   
/*     */   private void clearContent() {
/*  87 */     this.text = null;
/*  88 */     this.binary = null;
/*  89 */     this.stream = null;
/*  90 */     this.parameters = null;
/*  91 */     this.serializable = null;
/*  92 */     this.file = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getText() {
/*  99 */     return this.text;
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
/*     */   
/*     */   public EntityBuilder setText(String paramString) {
/* 114 */     clearContent();
/* 115 */     this.text = paramString;
/* 116 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getBinary() {
/* 124 */     return this.binary;
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
/*     */ 
/*     */   
/*     */   public EntityBuilder setBinary(byte[] paramArrayOfbyte) {
/* 140 */     clearContent();
/* 141 */     this.binary = paramArrayOfbyte;
/* 142 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStream getStream() {
/* 150 */     return this.stream;
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
/*     */ 
/*     */   
/*     */   public EntityBuilder setStream(InputStream paramInputStream) {
/* 166 */     clearContent();
/* 167 */     this.stream = paramInputStream;
/* 168 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<NameValuePair> getParameters() {
/* 177 */     return this.parameters;
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
/*     */   
/*     */   public EntityBuilder setParameters(List<NameValuePair> paramList) {
/* 192 */     clearContent();
/* 193 */     this.parameters = paramList;
/* 194 */     return this;
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
/*     */   public EntityBuilder setParameters(NameValuePair... paramVarArgs) {
/* 208 */     return setParameters(Arrays.asList(paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Serializable getSerializable() {
/* 216 */     return this.serializable;
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
/*     */   
/*     */   public EntityBuilder setSerializable(Serializable paramSerializable) {
/* 231 */     clearContent();
/* 232 */     this.serializable = paramSerializable;
/* 233 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public File getFile() {
/* 241 */     return this.file;
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
/*     */   
/*     */   public EntityBuilder setFile(File paramFile) {
/* 256 */     clearContent();
/* 257 */     this.file = paramFile;
/* 258 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ContentType getContentType() {
/* 265 */     return this.contentType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityBuilder setContentType(ContentType paramContentType) {
/* 272 */     this.contentType = paramContentType;
/* 273 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getContentEncoding() {
/* 280 */     return this.contentEncoding;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityBuilder setContentEncoding(String paramString) {
/* 287 */     this.contentEncoding = paramString;
/* 288 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isChunked() {
/* 295 */     return this.chunked;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityBuilder chunked() {
/* 302 */     this.chunked = true;
/* 303 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isGzipCompress() {
/* 310 */     return this.gzipCompress;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityBuilder gzipCompress() {
/* 317 */     this.gzipCompress = true;
/* 318 */     return this;
/*     */   }
/*     */   
/*     */   private ContentType getContentOrDefault(ContentType paramContentType) {
/* 322 */     return (this.contentType != null) ? this.contentType : paramContentType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpEntity build() {
/*     */     BasicHttpEntity basicHttpEntity;
/* 330 */     if (this.text != null) {
/* 331 */       StringEntity stringEntity = new StringEntity(this.text, getContentOrDefault(ContentType.DEFAULT_TEXT));
/* 332 */     } else if (this.binary != null) {
/* 333 */       ByteArrayEntity byteArrayEntity = new ByteArrayEntity(this.binary, getContentOrDefault(ContentType.DEFAULT_BINARY));
/* 334 */     } else if (this.stream != null) {
/* 335 */       InputStreamEntity inputStreamEntity = new InputStreamEntity(this.stream, -1L, getContentOrDefault(ContentType.DEFAULT_BINARY));
/* 336 */     } else if (this.parameters != null) {
/* 337 */       UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(this.parameters, (this.contentType != null) ? this.contentType.getCharset() : null);
/*     */     }
/* 339 */     else if (this.serializable != null) {
/* 340 */       SerializableEntity serializableEntity = new SerializableEntity(this.serializable);
/* 341 */       serializableEntity.setContentType(ContentType.DEFAULT_BINARY.toString());
/* 342 */     } else if (this.file != null) {
/* 343 */       FileEntity fileEntity = new FileEntity(this.file, getContentOrDefault(ContentType.DEFAULT_BINARY));
/*     */     } else {
/* 345 */       basicHttpEntity = new BasicHttpEntity();
/*     */     } 
/* 347 */     if (basicHttpEntity.getContentType() != null && this.contentType != null) {
/* 348 */       basicHttpEntity.setContentType(this.contentType.toString());
/*     */     }
/* 350 */     basicHttpEntity.setContentEncoding(this.contentEncoding);
/* 351 */     basicHttpEntity.setChunked(this.chunked);
/* 352 */     if (this.gzipCompress) {
/* 353 */       return (HttpEntity)new GzipCompressingEntity((HttpEntity)basicHttpEntity);
/*     */     }
/* 355 */     return (HttpEntity)basicHttpEntity;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\entity\EntityBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */