/*     */ package org.apache.http.impl.execchain;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.Locale;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HeaderIterator;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.ProtocolVersion;
/*     */ import org.apache.http.StatusLine;
/*     */ import org.apache.http.client.methods.CloseableHttpResponse;
/*     */ import org.apache.http.params.HttpParams;
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
/*     */ class HttpResponseProxy
/*     */   implements CloseableHttpResponse
/*     */ {
/*     */   private final HttpResponse original;
/*     */   private final ConnectionHolder connHolder;
/*     */   
/*     */   public HttpResponseProxy(HttpResponse paramHttpResponse, ConnectionHolder paramConnectionHolder) {
/*  54 */     this.original = paramHttpResponse;
/*  55 */     this.connHolder = paramConnectionHolder;
/*  56 */     ResponseEntityProxy.enchance(paramHttpResponse, paramConnectionHolder);
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/*  61 */     if (this.connHolder != null) {
/*  62 */       this.connHolder.close();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public StatusLine getStatusLine() {
/*  68 */     return this.original.getStatusLine();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setStatusLine(StatusLine paramStatusLine) {
/*  73 */     this.original.setStatusLine(paramStatusLine);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setStatusLine(ProtocolVersion paramProtocolVersion, int paramInt) {
/*  78 */     this.original.setStatusLine(paramProtocolVersion, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setStatusLine(ProtocolVersion paramProtocolVersion, int paramInt, String paramString) {
/*  83 */     this.original.setStatusLine(paramProtocolVersion, paramInt, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setStatusCode(int paramInt) throws IllegalStateException {
/*  88 */     this.original.setStatusCode(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setReasonPhrase(String paramString) throws IllegalStateException {
/*  93 */     this.original.setReasonPhrase(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpEntity getEntity() {
/*  98 */     return this.original.getEntity();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setEntity(HttpEntity paramHttpEntity) {
/* 103 */     this.original.setEntity(paramHttpEntity);
/*     */   }
/*     */ 
/*     */   
/*     */   public Locale getLocale() {
/* 108 */     return this.original.getLocale();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLocale(Locale paramLocale) {
/* 113 */     this.original.setLocale(paramLocale);
/*     */   }
/*     */ 
/*     */   
/*     */   public ProtocolVersion getProtocolVersion() {
/* 118 */     return this.original.getProtocolVersion();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsHeader(String paramString) {
/* 123 */     return this.original.containsHeader(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public Header[] getHeaders(String paramString) {
/* 128 */     return this.original.getHeaders(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public Header getFirstHeader(String paramString) {
/* 133 */     return this.original.getFirstHeader(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public Header getLastHeader(String paramString) {
/* 138 */     return this.original.getLastHeader(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public Header[] getAllHeaders() {
/* 143 */     return this.original.getAllHeaders();
/*     */   }
/*     */ 
/*     */   
/*     */   public void addHeader(Header paramHeader) {
/* 148 */     this.original.addHeader(paramHeader);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addHeader(String paramString1, String paramString2) {
/* 153 */     this.original.addHeader(paramString1, paramString2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setHeader(Header paramHeader) {
/* 158 */     this.original.setHeader(paramHeader);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setHeader(String paramString1, String paramString2) {
/* 163 */     this.original.setHeader(paramString1, paramString2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setHeaders(Header[] paramArrayOfHeader) {
/* 168 */     this.original.setHeaders(paramArrayOfHeader);
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeHeader(Header paramHeader) {
/* 173 */     this.original.removeHeader(paramHeader);
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeHeaders(String paramString) {
/* 178 */     this.original.removeHeaders(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public HeaderIterator headerIterator() {
/* 183 */     return this.original.headerIterator();
/*     */   }
/*     */ 
/*     */   
/*     */   public HeaderIterator headerIterator(String paramString) {
/* 188 */     return this.original.headerIterator(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpParams getParams() {
/* 193 */     return this.original.getParams();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setParams(HttpParams paramHttpParams) {
/* 198 */     this.original.setParams(paramHttpParams);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 203 */     StringBuilder stringBuilder = new StringBuilder("HttpResponseProxy{");
/* 204 */     stringBuilder.append(this.original);
/* 205 */     stringBuilder.append('}');
/* 206 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\execchain\HttpResponseProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */