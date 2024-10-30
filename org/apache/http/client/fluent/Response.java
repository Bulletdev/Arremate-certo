/*     */ package org.apache.http.client.fluent;
/*     */ 
/*     */ import java.io.Closeable;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.StatusLine;
/*     */ import org.apache.http.client.ClientProtocolException;
/*     */ import org.apache.http.client.HttpResponseException;
/*     */ import org.apache.http.client.ResponseHandler;
/*     */ import org.apache.http.entity.ByteArrayEntity;
/*     */ import org.apache.http.entity.ContentType;
/*     */ import org.apache.http.util.EntityUtils;
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
/*     */ public class Response
/*     */ {
/*     */   private final HttpResponse response;
/*     */   private boolean consumed;
/*     */   
/*     */   Response(HttpResponse paramHttpResponse) {
/*  52 */     this.response = paramHttpResponse;
/*     */   }
/*     */   
/*     */   private void assertNotConsumed() {
/*  56 */     if (this.consumed) {
/*  57 */       throw new IllegalStateException("Response content has been already consumed");
/*     */     }
/*     */   }
/*     */   
/*     */   private void dispose() {
/*  62 */     if (this.consumed) {
/*     */       return;
/*     */     }
/*     */     
/*  66 */     try { HttpEntity httpEntity = this.response.getEntity();
/*  67 */       InputStream inputStream = httpEntity.getContent();
/*  68 */       if (inputStream != null) {
/*  69 */         inputStream.close();
/*     */       } }
/*  71 */     catch (Exception exception) {  }
/*     */     finally
/*  73 */     { this.consumed = true; }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void discardContent() {
/*  81 */     dispose();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T handleResponse(ResponseHandler<T> paramResponseHandler) throws ClientProtocolException, IOException {
/*  89 */     assertNotConsumed();
/*     */     try {
/*  91 */       return (T)paramResponseHandler.handleResponse(this.response);
/*     */     } finally {
/*  93 */       dispose();
/*     */     } 
/*     */   }
/*     */   
/*     */   public Content returnContent() throws ClientProtocolException, IOException {
/*  98 */     return handleResponse((ResponseHandler<Content>)new ContentResponseHandler());
/*     */   }
/*     */   
/*     */   public HttpResponse returnResponse() throws IOException {
/* 102 */     assertNotConsumed();
/*     */     try {
/* 104 */       HttpEntity httpEntity = this.response.getEntity();
/* 105 */       if (httpEntity != null) {
/* 106 */         ByteArrayEntity byteArrayEntity = new ByteArrayEntity(EntityUtils.toByteArray(httpEntity));
/*     */         
/* 108 */         ContentType contentType = ContentType.getOrDefault(httpEntity);
/* 109 */         byteArrayEntity.setContentType(contentType.toString());
/* 110 */         this.response.setEntity((HttpEntity)byteArrayEntity);
/*     */       } 
/* 112 */       return this.response;
/*     */     } finally {
/* 114 */       this.consumed = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void saveContent(File paramFile) throws IOException {
/* 119 */     assertNotConsumed();
/*     */     try {
/* 121 */       StatusLine statusLine = this.response.getStatusLine();
/* 122 */       if (statusLine.getStatusCode() >= 300) {
/* 123 */         throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
/*     */       }
/*     */       
/* 126 */       FileOutputStream fileOutputStream = new FileOutputStream(paramFile);
/*     */       try {
/* 128 */         HttpEntity httpEntity = this.response.getEntity();
/* 129 */         if (httpEntity != null) {
/* 130 */           httpEntity.writeTo(fileOutputStream);
/*     */         }
/*     */       } finally {
/* 133 */         fileOutputStream.close();
/*     */       } 
/*     */     } finally {
/* 136 */       this.consumed = true;
/* 137 */       if (this.response instanceof Closeable)
/* 138 */         ((Closeable)this.response).close(); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\fluent\Response.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */