/*     */ package org.apache.http.impl.execchain;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.net.URI;
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.HttpEntityEnclosingRequest;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.ProtocolException;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.auth.AuthState;
/*     */ import org.apache.http.client.RedirectException;
/*     */ import org.apache.http.client.RedirectStrategy;
/*     */ import org.apache.http.client.config.RequestConfig;
/*     */ import org.apache.http.client.methods.CloseableHttpResponse;
/*     */ import org.apache.http.client.methods.HttpExecutionAware;
/*     */ import org.apache.http.client.methods.HttpRequestWrapper;
/*     */ import org.apache.http.client.methods.HttpUriRequest;
/*     */ import org.apache.http.client.protocol.HttpClientContext;
/*     */ import org.apache.http.client.utils.URIUtils;
/*     */ import org.apache.http.conn.routing.HttpRoute;
/*     */ import org.apache.http.conn.routing.HttpRoutePlanner;
/*     */ import org.apache.http.protocol.HttpContext;
/*     */ import org.apache.http.util.Args;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/*     */ public class RedirectExec
/*     */   implements ClientExecChain
/*     */ {
/*  71 */   private final Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */   
/*     */   private final ClientExecChain requestExecutor;
/*     */   
/*     */   private final RedirectStrategy redirectStrategy;
/*     */   
/*     */   private final HttpRoutePlanner routePlanner;
/*     */ 
/*     */   
/*     */   public RedirectExec(ClientExecChain paramClientExecChain, HttpRoutePlanner paramHttpRoutePlanner, RedirectStrategy paramRedirectStrategy) {
/*  82 */     Args.notNull(paramClientExecChain, "HTTP client request executor");
/*  83 */     Args.notNull(paramHttpRoutePlanner, "HTTP route planner");
/*  84 */     Args.notNull(paramRedirectStrategy, "HTTP redirect strategy");
/*  85 */     this.requestExecutor = paramClientExecChain;
/*  86 */     this.routePlanner = paramHttpRoutePlanner;
/*  87 */     this.redirectStrategy = paramRedirectStrategy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CloseableHttpResponse execute(HttpRoute paramHttpRoute, HttpRequestWrapper paramHttpRequestWrapper, HttpClientContext paramHttpClientContext, HttpExecutionAware paramHttpExecutionAware) throws IOException, HttpException {
/*     */     CloseableHttpResponse closeableHttpResponse;
/*  96 */     Args.notNull(paramHttpRoute, "HTTP route");
/*  97 */     Args.notNull(paramHttpRequestWrapper, "HTTP request");
/*  98 */     Args.notNull(paramHttpClientContext, "HTTP context");
/*     */     
/* 100 */     List list = paramHttpClientContext.getRedirectLocations();
/* 101 */     if (list != null) {
/* 102 */       list.clear();
/*     */     }
/*     */     
/* 105 */     RequestConfig requestConfig = paramHttpClientContext.getRequestConfig();
/* 106 */     byte b1 = (requestConfig.getMaxRedirects() > 0) ? requestConfig.getMaxRedirects() : 50;
/* 107 */     HttpRoute httpRoute = paramHttpRoute;
/* 108 */     HttpRequestWrapper httpRequestWrapper = paramHttpRequestWrapper;
/* 109 */     byte b2 = 0; while (true) {
/* 110 */       closeableHttpResponse = this.requestExecutor.execute(httpRoute, httpRequestWrapper, paramHttpClientContext, paramHttpExecutionAware);
/*     */       
/*     */       try {
/* 113 */         if (requestConfig.isRedirectsEnabled() && this.redirectStrategy.isRedirected(httpRequestWrapper.getOriginal(), (HttpResponse)closeableHttpResponse, (HttpContext)paramHttpClientContext)) {
/*     */           
/* 115 */           if (!RequestEntityProxy.isRepeatable((HttpRequest)httpRequestWrapper)) {
/* 116 */             if (this.log.isDebugEnabled()) {
/* 117 */               this.log.debug("Cannot redirect non-repeatable request");
/*     */             }
/* 119 */             return closeableHttpResponse;
/*     */           } 
/* 121 */           if (b2 >= b1) {
/* 122 */             throw new RedirectException("Maximum redirects (" + b1 + ") exceeded");
/*     */           }
/* 124 */           b2++;
/*     */           
/* 126 */           HttpUriRequest httpUriRequest = this.redirectStrategy.getRedirect(httpRequestWrapper.getOriginal(), (HttpResponse)closeableHttpResponse, (HttpContext)paramHttpClientContext);
/*     */           
/* 128 */           if (!httpUriRequest.headerIterator().hasNext()) {
/* 129 */             HttpRequest httpRequest = paramHttpRequestWrapper.getOriginal();
/* 130 */             httpUriRequest.setHeaders(httpRequest.getAllHeaders());
/*     */           } 
/* 132 */           httpRequestWrapper = HttpRequestWrapper.wrap((HttpRequest)httpUriRequest);
/*     */           
/* 134 */           if (httpRequestWrapper instanceof HttpEntityEnclosingRequest) {
/* 135 */             RequestEntityProxy.enhance((HttpEntityEnclosingRequest)httpRequestWrapper);
/*     */           }
/*     */           
/* 138 */           URI uRI = httpRequestWrapper.getURI();
/* 139 */           HttpHost httpHost = URIUtils.extractHost(uRI);
/* 140 */           if (httpHost == null) {
/* 141 */             throw new ProtocolException("Redirect URI does not specify a valid host name: " + uRI);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/* 146 */           if (!httpRoute.getTargetHost().equals(httpHost)) {
/* 147 */             AuthState authState1 = paramHttpClientContext.getTargetAuthState();
/* 148 */             if (authState1 != null) {
/* 149 */               this.log.debug("Resetting target auth state");
/* 150 */               authState1.reset();
/*     */             } 
/* 152 */             AuthState authState2 = paramHttpClientContext.getProxyAuthState();
/* 153 */             if (authState2 != null && authState2.isConnectionBased()) {
/* 154 */               this.log.debug("Resetting proxy auth state");
/* 155 */               authState2.reset();
/*     */             } 
/*     */           } 
/*     */           
/* 159 */           httpRoute = this.routePlanner.determineRoute(httpHost, (HttpRequest)httpRequestWrapper, (HttpContext)paramHttpClientContext);
/* 160 */           if (this.log.isDebugEnabled()) {
/* 161 */             this.log.debug("Redirecting to '" + uRI + "' via " + httpRoute);
/*     */           }
/* 163 */           EntityUtils.consume(closeableHttpResponse.getEntity());
/* 164 */           closeableHttpResponse.close(); continue;
/*     */         } 
/* 166 */         return closeableHttpResponse;
/*     */       }
/* 168 */       catch (RuntimeException runtimeException) {
/* 169 */         closeableHttpResponse.close();
/* 170 */         throw runtimeException;
/* 171 */       } catch (IOException iOException) {
/* 172 */         closeableHttpResponse.close();
/* 173 */         throw iOException;
/* 174 */       } catch (HttpException httpException) {
/*     */         break;
/*     */       } 
/*     */     }  try {
/* 178 */       EntityUtils.consume(closeableHttpResponse.getEntity());
/* 179 */     } catch (IOException iOException) {
/* 180 */       this.log.debug("I/O error while releasing connection", iOException);
/*     */     } finally {
/* 182 */       closeableHttpResponse.close();
/*     */     } 
/* 184 */     throw httpException;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\execchain\RedirectExec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */