/*     */ package org.apache.http.client.methods;
/*     */ 
/*     */ import java.net.URI;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.HttpEntityEnclosingRequest;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.ProtocolVersion;
/*     */ import org.apache.http.RequestLine;
/*     */ import org.apache.http.message.AbstractHttpMessage;
/*     */ import org.apache.http.message.BasicRequestLine;
/*     */ import org.apache.http.params.HttpParams;
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
/*     */ public class HttpRequestWrapper
/*     */   extends AbstractHttpMessage
/*     */   implements HttpUriRequest
/*     */ {
/*     */   private final HttpRequest original;
/*     */   private final HttpHost target;
/*     */   private final String method;
/*     */   private RequestLine requestLine;
/*     */   private ProtocolVersion version;
/*     */   private URI uri;
/*     */   
/*     */   private HttpRequestWrapper(HttpRequest paramHttpRequest, HttpHost paramHttpHost) {
/*  63 */     this.original = (HttpRequest)Args.notNull(paramHttpRequest, "HTTP request");
/*  64 */     this.target = paramHttpHost;
/*  65 */     this.version = this.original.getRequestLine().getProtocolVersion();
/*  66 */     this.method = this.original.getRequestLine().getMethod();
/*  67 */     if (paramHttpRequest instanceof HttpUriRequest) {
/*  68 */       this.uri = ((HttpUriRequest)paramHttpRequest).getURI();
/*     */     } else {
/*  70 */       this.uri = null;
/*     */     } 
/*  72 */     setHeaders(paramHttpRequest.getAllHeaders());
/*     */   }
/*     */ 
/*     */   
/*     */   public ProtocolVersion getProtocolVersion() {
/*  77 */     return (this.version != null) ? this.version : this.original.getProtocolVersion();
/*     */   }
/*     */   
/*     */   public void setProtocolVersion(ProtocolVersion paramProtocolVersion) {
/*  81 */     this.version = paramProtocolVersion;
/*  82 */     this.requestLine = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public URI getURI() {
/*  87 */     return this.uri;
/*     */   }
/*     */   
/*     */   public void setURI(URI paramURI) {
/*  91 */     this.uri = paramURI;
/*  92 */     this.requestLine = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getMethod() {
/*  97 */     return this.method;
/*     */   }
/*     */ 
/*     */   
/*     */   public void abort() throws UnsupportedOperationException {
/* 102 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isAborted() {
/* 107 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public RequestLine getRequestLine() {
/* 112 */     if (this.requestLine == null) {
/*     */       String str;
/* 114 */       if (this.uri != null) {
/* 115 */         str = this.uri.toASCIIString();
/*     */       } else {
/* 117 */         str = this.original.getRequestLine().getUri();
/*     */       } 
/* 119 */       if (str == null || str.isEmpty()) {
/* 120 */         str = "/";
/*     */       }
/* 122 */       this.requestLine = (RequestLine)new BasicRequestLine(this.method, str, getProtocolVersion());
/*     */     } 
/* 124 */     return this.requestLine;
/*     */   }
/*     */   
/*     */   public HttpRequest getOriginal() {
/* 128 */     return this.original;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpHost getTarget() {
/* 135 */     return this.target;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 140 */     return getRequestLine() + " " + this.headergroup;
/*     */   }
/*     */   
/*     */   static class HttpEntityEnclosingRequestWrapper
/*     */     extends HttpRequestWrapper
/*     */     implements HttpEntityEnclosingRequest {
/*     */     private HttpEntity entity;
/*     */     
/*     */     HttpEntityEnclosingRequestWrapper(HttpEntityEnclosingRequest param1HttpEntityEnclosingRequest, HttpHost param1HttpHost) {
/* 149 */       super((HttpRequest)param1HttpEntityEnclosingRequest, param1HttpHost);
/* 150 */       this.entity = param1HttpEntityEnclosingRequest.getEntity();
/*     */     }
/*     */ 
/*     */     
/*     */     public HttpEntity getEntity() {
/* 155 */       return this.entity;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setEntity(HttpEntity param1HttpEntity) {
/* 160 */       this.entity = param1HttpEntity;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean expectContinue() {
/* 165 */       Header header = getFirstHeader("Expect");
/* 166 */       return (header != null && "100-continue".equalsIgnoreCase(header.getValue()));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static HttpRequestWrapper wrap(HttpRequest paramHttpRequest) {
/* 178 */     return wrap(paramHttpRequest, (HttpHost)null);
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
/*     */   public static HttpRequestWrapper wrap(HttpRequest paramHttpRequest, HttpHost paramHttpHost) {
/* 191 */     Args.notNull(paramHttpRequest, "HTTP request");
/* 192 */     return (paramHttpRequest instanceof HttpEntityEnclosingRequest) ? new HttpEntityEnclosingRequestWrapper((HttpEntityEnclosingRequest)paramHttpRequest, paramHttpHost) : new HttpRequestWrapper(paramHttpRequest, paramHttpHost);
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
/*     */   @Deprecated
/*     */   public HttpParams getParams() {
/* 205 */     if (this.params == null) {
/* 206 */       this.params = this.original.getParams().copy();
/*     */     }
/* 208 */     return this.params;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\methods\HttpRequestWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */