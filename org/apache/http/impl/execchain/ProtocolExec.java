/*     */ package org.apache.http.impl.execchain;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.ProtocolException;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.auth.AuthScope;
/*     */ import org.apache.http.auth.Credentials;
/*     */ import org.apache.http.auth.UsernamePasswordCredentials;
/*     */ import org.apache.http.client.CredentialsProvider;
/*     */ import org.apache.http.client.methods.CloseableHttpResponse;
/*     */ import org.apache.http.client.methods.HttpExecutionAware;
/*     */ import org.apache.http.client.methods.HttpRequestWrapper;
/*     */ import org.apache.http.client.methods.HttpUriRequest;
/*     */ import org.apache.http.client.protocol.HttpClientContext;
/*     */ import org.apache.http.client.utils.URIUtils;
/*     */ import org.apache.http.conn.routing.HttpRoute;
/*     */ import org.apache.http.conn.routing.RouteInfo;
/*     */ import org.apache.http.impl.client.BasicCredentialsProvider;
/*     */ import org.apache.http.params.HttpParams;
/*     */ import org.apache.http.protocol.HttpContext;
/*     */ import org.apache.http.protocol.HttpProcessor;
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
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/*     */ public class ProtocolExec
/*     */   implements ClientExecChain
/*     */ {
/*  77 */   private final Log log = LogFactory.getLog(getClass());
/*     */   
/*     */   private final ClientExecChain requestExecutor;
/*     */   private final HttpProcessor httpProcessor;
/*     */   
/*     */   public ProtocolExec(ClientExecChain paramClientExecChain, HttpProcessor paramHttpProcessor) {
/*  83 */     Args.notNull(paramClientExecChain, "HTTP client request executor");
/*  84 */     Args.notNull(paramHttpProcessor, "HTTP protocol processor");
/*  85 */     this.requestExecutor = paramClientExecChain;
/*  86 */     this.httpProcessor = paramHttpProcessor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void rewriteRequestURI(HttpRequestWrapper paramHttpRequestWrapper, HttpRoute paramHttpRoute, boolean paramBoolean) throws ProtocolException {
/*  93 */     URI uRI = paramHttpRequestWrapper.getURI();
/*  94 */     if (uRI != null) {
/*     */       try {
/*  96 */         paramHttpRequestWrapper.setURI(URIUtils.rewriteURIForRoute(uRI, (RouteInfo)paramHttpRoute, paramBoolean));
/*  97 */       } catch (URISyntaxException uRISyntaxException) {
/*  98 */         throw new ProtocolException("Invalid URI: " + uRI, uRISyntaxException);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CloseableHttpResponse execute(HttpRoute paramHttpRoute, HttpRequestWrapper paramHttpRequestWrapper, HttpClientContext paramHttpClientContext, HttpExecutionAware paramHttpExecutionAware) throws IOException, HttpException {
/* 110 */     Args.notNull(paramHttpRoute, "HTTP route");
/* 111 */     Args.notNull(paramHttpRequestWrapper, "HTTP request");
/* 112 */     Args.notNull(paramHttpClientContext, "HTTP context");
/*     */     
/* 114 */     HttpRequest httpRequest = paramHttpRequestWrapper.getOriginal();
/* 115 */     URI uRI = null;
/* 116 */     if (httpRequest instanceof HttpUriRequest) {
/* 117 */       uRI = ((HttpUriRequest)httpRequest).getURI();
/*     */     } else {
/* 119 */       String str = httpRequest.getRequestLine().getUri();
/*     */       try {
/* 121 */         uRI = URI.create(str);
/* 122 */       } catch (IllegalArgumentException illegalArgumentException) {
/* 123 */         if (this.log.isDebugEnabled()) {
/* 124 */           this.log.debug("Unable to parse '" + str + "' as a valid URI; " + "request URI and Host header may be inconsistent", illegalArgumentException);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 130 */     paramHttpRequestWrapper.setURI(uRI);
/*     */ 
/*     */     
/* 133 */     rewriteRequestURI(paramHttpRequestWrapper, paramHttpRoute, paramHttpClientContext.getRequestConfig().isNormalizeUri());
/*     */     
/* 135 */     HttpParams httpParams = paramHttpRequestWrapper.getParams();
/* 136 */     HttpHost httpHost1 = (HttpHost)httpParams.getParameter("http.virtual-host");
/*     */     
/* 138 */     if (httpHost1 != null && httpHost1.getPort() == -1) {
/* 139 */       int i = paramHttpRoute.getTargetHost().getPort();
/* 140 */       if (i != -1) {
/* 141 */         httpHost1 = new HttpHost(httpHost1.getHostName(), i, httpHost1.getSchemeName());
/*     */       }
/*     */       
/* 144 */       if (this.log.isDebugEnabled()) {
/* 145 */         this.log.debug("Using virtual host" + httpHost1);
/*     */       }
/*     */     } 
/*     */     
/* 149 */     HttpHost httpHost2 = null;
/* 150 */     if (httpHost1 != null) {
/* 151 */       httpHost2 = httpHost1;
/*     */     }
/* 153 */     else if (uRI != null && uRI.isAbsolute() && uRI.getHost() != null) {
/* 154 */       httpHost2 = new HttpHost(uRI.getHost(), uRI.getPort(), uRI.getScheme());
/*     */     } 
/*     */     
/* 157 */     if (httpHost2 == null) {
/* 158 */       httpHost2 = paramHttpRequestWrapper.getTarget();
/*     */     }
/* 160 */     if (httpHost2 == null) {
/* 161 */       httpHost2 = paramHttpRoute.getTargetHost();
/*     */     }
/*     */ 
/*     */     
/* 165 */     if (uRI != null) {
/* 166 */       String str = uRI.getUserInfo();
/* 167 */       if (str != null) {
/* 168 */         BasicCredentialsProvider basicCredentialsProvider; CredentialsProvider credentialsProvider = paramHttpClientContext.getCredentialsProvider();
/* 169 */         if (credentialsProvider == null) {
/* 170 */           basicCredentialsProvider = new BasicCredentialsProvider();
/* 171 */           paramHttpClientContext.setCredentialsProvider((CredentialsProvider)basicCredentialsProvider);
/*     */         } 
/* 173 */         basicCredentialsProvider.setCredentials(new AuthScope(httpHost2), (Credentials)new UsernamePasswordCredentials(str));
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 180 */     paramHttpClientContext.setAttribute("http.target_host", httpHost2);
/* 181 */     paramHttpClientContext.setAttribute("http.route", paramHttpRoute);
/* 182 */     paramHttpClientContext.setAttribute("http.request", paramHttpRequestWrapper);
/*     */     
/* 184 */     this.httpProcessor.process((HttpRequest)paramHttpRequestWrapper, (HttpContext)paramHttpClientContext);
/*     */     
/* 186 */     CloseableHttpResponse closeableHttpResponse = this.requestExecutor.execute(paramHttpRoute, paramHttpRequestWrapper, paramHttpClientContext, paramHttpExecutionAware);
/*     */ 
/*     */     
/*     */     try {
/* 190 */       paramHttpClientContext.setAttribute("http.response", closeableHttpResponse);
/* 191 */       this.httpProcessor.process((HttpResponse)closeableHttpResponse, (HttpContext)paramHttpClientContext);
/* 192 */       return closeableHttpResponse;
/* 193 */     } catch (RuntimeException runtimeException) {
/* 194 */       closeableHttpResponse.close();
/* 195 */       throw runtimeException;
/* 196 */     } catch (IOException iOException) {
/* 197 */       closeableHttpResponse.close();
/* 198 */       throw iOException;
/* 199 */     } catch (HttpException httpException) {
/* 200 */       closeableHttpResponse.close();
/* 201 */       throw httpException;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\execchain\ProtocolExec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */