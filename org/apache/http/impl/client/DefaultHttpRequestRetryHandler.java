/*     */ package org.apache.http.impl.client;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InterruptedIOException;
/*     */ import java.net.ConnectException;
/*     */ import java.net.NoRouteToHostException;
/*     */ import java.net.UnknownHostException;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import javax.net.ssl.SSLException;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.client.HttpRequestRetryHandler;
/*     */ import org.apache.http.client.methods.HttpUriRequest;
/*     */ import org.apache.http.client.protocol.HttpClientContext;
/*     */ import org.apache.http.protocol.HttpContext;
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
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class DefaultHttpRequestRetryHandler
/*     */   implements HttpRequestRetryHandler
/*     */ {
/*  60 */   public static final DefaultHttpRequestRetryHandler INSTANCE = new DefaultHttpRequestRetryHandler();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int retryCount;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean requestSentRetryEnabled;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Set<Class<? extends IOException>> nonRetriableClasses;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected DefaultHttpRequestRetryHandler(int paramInt, boolean paramBoolean, Collection<Class<? extends IOException>> paramCollection) {
/*  83 */     this.retryCount = paramInt;
/*  84 */     this.requestSentRetryEnabled = paramBoolean;
/*  85 */     this.nonRetriableClasses = new HashSet<Class<? extends IOException>>();
/*  86 */     this.nonRetriableClasses.addAll(paramCollection);
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
/*     */   
/*     */   public DefaultHttpRequestRetryHandler(int paramInt, boolean paramBoolean) {
/* 103 */     this(paramInt, paramBoolean, Arrays.asList((Class<? extends IOException>[])new Class[] { InterruptedIOException.class, UnknownHostException.class, ConnectException.class, NoRouteToHostException.class, SSLException.class }));
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
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultHttpRequestRetryHandler() {
/* 122 */     this(3, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean retryRequest(IOException paramIOException, int paramInt, HttpContext paramHttpContext) {
/* 133 */     Args.notNull(paramIOException, "Exception parameter");
/* 134 */     Args.notNull(paramHttpContext, "HTTP context");
/* 135 */     if (paramInt > this.retryCount)
/*     */     {
/* 137 */       return false;
/*     */     }
/* 139 */     if (this.nonRetriableClasses.contains(paramIOException.getClass())) {
/* 140 */       return false;
/*     */     }
/* 142 */     for (Class<? extends IOException> clazz : this.nonRetriableClasses) {
/* 143 */       if (clazz.isInstance(paramIOException)) {
/* 144 */         return false;
/*     */       }
/*     */     } 
/* 147 */     HttpClientContext httpClientContext = HttpClientContext.adapt(paramHttpContext);
/* 148 */     HttpRequest httpRequest = httpClientContext.getRequest();
/*     */     
/* 150 */     if (requestIsAborted(httpRequest)) {
/* 151 */       return false;
/*     */     }
/*     */     
/* 154 */     if (handleAsIdempotent(httpRequest))
/*     */     {
/* 156 */       return true;
/*     */     }
/*     */     
/* 159 */     if (!httpClientContext.isRequestSent() || this.requestSentRetryEnabled)
/*     */     {
/*     */       
/* 162 */       return true;
/*     */     }
/*     */     
/* 165 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRequestSentRetryEnabled() {
/* 173 */     return this.requestSentRetryEnabled;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRetryCount() {
/* 180 */     return this.retryCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean handleAsIdempotent(HttpRequest paramHttpRequest) {
/* 187 */     return !(paramHttpRequest instanceof org.apache.http.HttpEntityEnclosingRequest);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected boolean requestIsAborted(HttpRequest paramHttpRequest) {
/* 197 */     HttpRequest httpRequest = paramHttpRequest;
/* 198 */     if (paramHttpRequest instanceof RequestWrapper) {
/* 199 */       httpRequest = ((RequestWrapper)paramHttpRequest).getOriginal();
/*     */     }
/* 201 */     return (httpRequest instanceof HttpUriRequest && ((HttpUriRequest)httpRequest).isAborted());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\DefaultHttpRequestRetryHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */