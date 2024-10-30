/*     */ package org.apache.http.client.fluent;
/*     */ 
/*     */ import java.net.URI;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import java.util.concurrent.atomic.AtomicReference;
/*     */ import org.apache.http.HttpVersion;
/*     */ import org.apache.http.ProtocolVersion;
/*     */ import org.apache.http.RequestLine;
/*     */ import org.apache.http.client.config.RequestConfig;
/*     */ import org.apache.http.client.methods.Configurable;
/*     */ import org.apache.http.client.methods.HttpExecutionAware;
/*     */ import org.apache.http.client.methods.HttpUriRequest;
/*     */ import org.apache.http.concurrent.Cancellable;
/*     */ import org.apache.http.message.AbstractHttpMessage;
/*     */ import org.apache.http.message.BasicRequestLine;
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
/*     */ class InternalHttpRequest
/*     */   extends AbstractHttpMessage
/*     */   implements Configurable, HttpExecutionAware, HttpUriRequest
/*     */ {
/*     */   private final String method;
/*     */   private ProtocolVersion version;
/*     */   private URI uri;
/*     */   private RequestConfig config;
/*     */   private final AtomicBoolean aborted;
/*     */   private final AtomicReference<Cancellable> cancellableRef;
/*     */   
/*     */   InternalHttpRequest(String paramString, URI paramURI) {
/*  58 */     Args.notBlank(paramString, "Method");
/*  59 */     Args.notNull(paramURI, "Request URI");
/*  60 */     this.method = paramString;
/*  61 */     this.uri = paramURI;
/*  62 */     this.aborted = new AtomicBoolean(false);
/*  63 */     this.cancellableRef = new AtomicReference<Cancellable>(null);
/*     */   }
/*     */   
/*     */   public void setProtocolVersion(ProtocolVersion paramProtocolVersion) {
/*  67 */     this.version = paramProtocolVersion;
/*     */   }
/*     */ 
/*     */   
/*     */   public ProtocolVersion getProtocolVersion() {
/*  72 */     return (this.version != null) ? this.version : (ProtocolVersion)HttpVersion.HTTP_1_1;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getMethod() {
/*  77 */     return this.method;
/*     */   }
/*     */ 
/*     */   
/*     */   public URI getURI() {
/*  82 */     return this.uri;
/*     */   }
/*     */ 
/*     */   
/*     */   public void abort() throws UnsupportedOperationException {
/*  87 */     if (this.aborted.compareAndSet(false, true)) {
/*  88 */       Cancellable cancellable = this.cancellableRef.getAndSet(null);
/*  89 */       if (cancellable != null) {
/*  90 */         cancellable.cancel();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isAborted() {
/*  97 */     return this.aborted.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCancellable(Cancellable paramCancellable) {
/* 102 */     if (!this.aborted.get()) {
/* 103 */       this.cancellableRef.set(paramCancellable);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public RequestLine getRequestLine() {
/* 109 */     ProtocolVersion protocolVersion = getProtocolVersion();
/* 110 */     URI uRI = getURI();
/* 111 */     String str = null;
/* 112 */     if (uRI != null) {
/* 113 */       str = uRI.toASCIIString();
/*     */     }
/* 115 */     if (str == null || str.isEmpty()) {
/* 116 */       str = "/";
/*     */     }
/* 118 */     return (RequestLine)new BasicRequestLine(getMethod(), str, protocolVersion);
/*     */   }
/*     */ 
/*     */   
/*     */   public RequestConfig getConfig() {
/* 123 */     return this.config;
/*     */   }
/*     */   
/*     */   public void setConfig(RequestConfig paramRequestConfig) {
/* 127 */     this.config = paramRequestConfig;
/*     */   }
/*     */   
/*     */   public void setURI(URI paramURI) {
/* 131 */     this.uri = paramURI;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 136 */     return getMethod() + " " + getURI() + " " + getProtocolVersion();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\fluent\InternalHttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */