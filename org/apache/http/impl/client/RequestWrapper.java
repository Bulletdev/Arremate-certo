/*     */ package org.apache.http.impl.client;
/*     */ 
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.ProtocolException;
/*     */ import org.apache.http.ProtocolVersion;
/*     */ import org.apache.http.RequestLine;
/*     */ import org.apache.http.client.methods.HttpUriRequest;
/*     */ import org.apache.http.message.AbstractHttpMessage;
/*     */ import org.apache.http.message.BasicRequestLine;
/*     */ import org.apache.http.params.HttpProtocolParams;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ public class RequestWrapper
/*     */   extends AbstractHttpMessage
/*     */   implements HttpUriRequest
/*     */ {
/*     */   private final HttpRequest original;
/*     */   private URI uri;
/*     */   private String method;
/*     */   private ProtocolVersion version;
/*     */   private int execCount;
/*     */   
/*     */   public RequestWrapper(HttpRequest paramHttpRequest) throws ProtocolException {
/*  68 */     Args.notNull(paramHttpRequest, "HTTP request");
/*  69 */     this.original = paramHttpRequest;
/*  70 */     setParams(paramHttpRequest.getParams());
/*  71 */     setHeaders(paramHttpRequest.getAllHeaders());
/*     */     
/*  73 */     if (paramHttpRequest instanceof HttpUriRequest) {
/*  74 */       this.uri = ((HttpUriRequest)paramHttpRequest).getURI();
/*  75 */       this.method = ((HttpUriRequest)paramHttpRequest).getMethod();
/*  76 */       this.version = null;
/*     */     } else {
/*  78 */       RequestLine requestLine = paramHttpRequest.getRequestLine();
/*     */       try {
/*  80 */         this.uri = new URI(requestLine.getUri());
/*  81 */       } catch (URISyntaxException uRISyntaxException) {
/*  82 */         throw new ProtocolException("Invalid request URI: " + requestLine.getUri(), uRISyntaxException);
/*     */       } 
/*     */       
/*  85 */       this.method = requestLine.getMethod();
/*  86 */       this.version = paramHttpRequest.getProtocolVersion();
/*     */     } 
/*  88 */     this.execCount = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void resetHeaders() {
/*  93 */     this.headergroup.clear();
/*  94 */     setHeaders(this.original.getAllHeaders());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getMethod() {
/*  99 */     return this.method;
/*     */   }
/*     */   
/*     */   public void setMethod(String paramString) {
/* 103 */     Args.notNull(paramString, "Method name");
/* 104 */     this.method = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public ProtocolVersion getProtocolVersion() {
/* 109 */     if (this.version == null) {
/* 110 */       this.version = HttpProtocolParams.getVersion(getParams());
/*     */     }
/* 112 */     return this.version;
/*     */   }
/*     */   
/*     */   public void setProtocolVersion(ProtocolVersion paramProtocolVersion) {
/* 116 */     this.version = paramProtocolVersion;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public URI getURI() {
/* 122 */     return this.uri;
/*     */   }
/*     */   
/*     */   public void setURI(URI paramURI) {
/* 126 */     this.uri = paramURI;
/*     */   }
/*     */ 
/*     */   
/*     */   public RequestLine getRequestLine() {
/* 131 */     ProtocolVersion protocolVersion = getProtocolVersion();
/* 132 */     String str = null;
/* 133 */     if (this.uri != null) {
/* 134 */       str = this.uri.toASCIIString();
/*     */     }
/* 136 */     if (str == null || str.isEmpty()) {
/* 137 */       str = "/";
/*     */     }
/* 139 */     return (RequestLine)new BasicRequestLine(getMethod(), str, protocolVersion);
/*     */   }
/*     */ 
/*     */   
/*     */   public void abort() throws UnsupportedOperationException {
/* 144 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isAborted() {
/* 149 */     return false;
/*     */   }
/*     */   
/*     */   public HttpRequest getOriginal() {
/* 153 */     return this.original;
/*     */   }
/*     */   
/*     */   public boolean isRepeatable() {
/* 157 */     return true;
/*     */   }
/*     */   
/*     */   public int getExecCount() {
/* 161 */     return this.execCount;
/*     */   }
/*     */   
/*     */   public void incrementExecCount() {
/* 165 */     this.execCount++;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\RequestWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */