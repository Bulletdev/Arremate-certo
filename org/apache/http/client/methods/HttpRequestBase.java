/*     */ package org.apache.http.client.methods;
/*     */ 
/*     */ import java.net.URI;
/*     */ import org.apache.http.ProtocolVersion;
/*     */ import org.apache.http.RequestLine;
/*     */ import org.apache.http.client.config.RequestConfig;
/*     */ import org.apache.http.message.BasicRequestLine;
/*     */ import org.apache.http.params.HttpProtocolParams;
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
/*     */ public abstract class HttpRequestBase
/*     */   extends AbstractExecutionAwareRequest
/*     */   implements Configurable, HttpUriRequest
/*     */ {
/*     */   private ProtocolVersion version;
/*     */   private URI uri;
/*     */   private RequestConfig config;
/*     */   
/*     */   public abstract String getMethod();
/*     */   
/*     */   public void setProtocolVersion(ProtocolVersion paramProtocolVersion) {
/*  58 */     this.version = paramProtocolVersion;
/*     */   }
/*     */ 
/*     */   
/*     */   public ProtocolVersion getProtocolVersion() {
/*  63 */     return (this.version != null) ? this.version : HttpProtocolParams.getVersion(getParams());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URI getURI() {
/*  74 */     return this.uri;
/*     */   }
/*     */ 
/*     */   
/*     */   public RequestLine getRequestLine() {
/*  79 */     String str1 = getMethod();
/*  80 */     ProtocolVersion protocolVersion = getProtocolVersion();
/*  81 */     URI uRI = getURI();
/*  82 */     String str2 = null;
/*  83 */     if (uRI != null) {
/*  84 */       str2 = uRI.toASCIIString();
/*     */     }
/*  86 */     if (str2 == null || str2.isEmpty()) {
/*  87 */       str2 = "/";
/*     */     }
/*  89 */     return (RequestLine)new BasicRequestLine(str1, str2, protocolVersion);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RequestConfig getConfig() {
/*  95 */     return this.config;
/*     */   }
/*     */   
/*     */   public void setConfig(RequestConfig paramRequestConfig) {
/*  99 */     this.config = paramRequestConfig;
/*     */   }
/*     */   
/*     */   public void setURI(URI paramURI) {
/* 103 */     this.uri = paramURI;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void started() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void releaseConnection() {
/* 119 */     reset();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 124 */     return getMethod() + " " + getURI() + " " + getProtocolVersion();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\methods\HttpRequestBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */