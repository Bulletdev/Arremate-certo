/*     */ package org.apache.http.impl.client;
/*     */ 
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import java.util.Arrays;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.ProtocolException;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.client.CircularRedirectException;
/*     */ import org.apache.http.client.RedirectStrategy;
/*     */ import org.apache.http.client.config.RequestConfig;
/*     */ import org.apache.http.client.methods.HttpGet;
/*     */ import org.apache.http.client.methods.HttpHead;
/*     */ import org.apache.http.client.methods.HttpUriRequest;
/*     */ import org.apache.http.client.methods.RequestBuilder;
/*     */ import org.apache.http.client.protocol.HttpClientContext;
/*     */ import org.apache.http.client.utils.URIUtils;
/*     */ import org.apache.http.protocol.HttpContext;
/*     */ import org.apache.http.util.Args;
/*     */ import org.apache.http.util.Asserts;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class DefaultRedirectStrategy
/*     */   implements RedirectStrategy
/*     */ {
/*  75 */   private final Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */   
/*     */   public static final int SC_PERMANENT_REDIRECT = 308;
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static final String REDIRECT_LOCATIONS = "http.protocol.redirect-locations";
/*     */ 
/*     */   
/*  85 */   public static final DefaultRedirectStrategy INSTANCE = new DefaultRedirectStrategy();
/*     */   
/*     */   private final String[] redirectMethods;
/*     */   
/*     */   public DefaultRedirectStrategy() {
/*  90 */     this(new String[] { "GET", "HEAD" });
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
/*     */   public DefaultRedirectStrategy(String[] paramArrayOfString) {
/* 104 */     String[] arrayOfString = (String[])paramArrayOfString.clone();
/* 105 */     Arrays.sort((Object[])arrayOfString);
/* 106 */     this.redirectMethods = arrayOfString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRedirected(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse, HttpContext paramHttpContext) throws ProtocolException {
/* 114 */     Args.notNull(paramHttpRequest, "HTTP request");
/* 115 */     Args.notNull(paramHttpResponse, "HTTP response");
/*     */     
/* 117 */     int i = paramHttpResponse.getStatusLine().getStatusCode();
/* 118 */     String str = paramHttpRequest.getRequestLine().getMethod();
/* 119 */     Header header = paramHttpResponse.getFirstHeader("location");
/* 120 */     switch (i) {
/*     */       case 302:
/* 122 */         return (isRedirectable(str) && header != null);
/*     */       case 301:
/*     */       case 307:
/*     */       case 308:
/* 126 */         return isRedirectable(str);
/*     */       case 303:
/* 128 */         return true;
/*     */     } 
/* 130 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URI getLocationURI(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse, HttpContext paramHttpContext) throws ProtocolException {
/* 138 */     Args.notNull(paramHttpRequest, "HTTP request");
/* 139 */     Args.notNull(paramHttpResponse, "HTTP response");
/* 140 */     Args.notNull(paramHttpContext, "HTTP context");
/*     */     
/* 142 */     HttpClientContext httpClientContext = HttpClientContext.adapt(paramHttpContext);
/*     */ 
/*     */     
/* 145 */     Header header = paramHttpResponse.getFirstHeader("location");
/* 146 */     if (header == null)
/*     */     {
/* 148 */       throw new ProtocolException("Received redirect response " + paramHttpResponse.getStatusLine() + " but no location header");
/*     */     }
/*     */ 
/*     */     
/* 152 */     String str = header.getValue();
/* 153 */     if (this.log.isDebugEnabled()) {
/* 154 */       this.log.debug("Redirect requested to location '" + str + "'");
/*     */     }
/*     */     
/* 157 */     RequestConfig requestConfig = httpClientContext.getRequestConfig();
/*     */     
/* 159 */     URI uRI = createLocationURI(str);
/*     */     
/*     */     try {
/* 162 */       if (requestConfig.isNormalizeUri()) {
/* 163 */         uRI = URIUtils.normalizeSyntax(uRI);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 168 */       if (!uRI.isAbsolute()) {
/* 169 */         if (!requestConfig.isRelativeRedirectsAllowed()) {
/* 170 */           throw new ProtocolException("Relative redirect location '" + uRI + "' not allowed");
/*     */         }
/*     */ 
/*     */         
/* 174 */         HttpHost httpHost = httpClientContext.getTargetHost();
/* 175 */         Asserts.notNull(httpHost, "Target host");
/* 176 */         URI uRI1 = new URI(paramHttpRequest.getRequestLine().getUri());
/* 177 */         URI uRI2 = URIUtils.rewriteURI(uRI1, httpHost, requestConfig.isNormalizeUri() ? URIUtils.NORMALIZE : URIUtils.NO_FLAGS);
/*     */         
/* 179 */         uRI = URIUtils.resolve(uRI2, uRI);
/*     */       } 
/* 181 */     } catch (URISyntaxException uRISyntaxException) {
/* 182 */       throw new ProtocolException(uRISyntaxException.getMessage(), uRISyntaxException);
/*     */     } 
/*     */     
/* 185 */     RedirectLocations redirectLocations = (RedirectLocations)httpClientContext.getAttribute("http.protocol.redirect-locations");
/*     */     
/* 187 */     if (redirectLocations == null) {
/* 188 */       redirectLocations = new RedirectLocations();
/* 189 */       paramHttpContext.setAttribute("http.protocol.redirect-locations", redirectLocations);
/*     */     } 
/* 191 */     if (!requestConfig.isCircularRedirectsAllowed() && 
/* 192 */       redirectLocations.contains(uRI)) {
/* 193 */       throw new CircularRedirectException("Circular redirect to '" + uRI + "'");
/*     */     }
/*     */     
/* 196 */     redirectLocations.add(uRI);
/* 197 */     return uRI;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected URI createLocationURI(String paramString) throws ProtocolException {
/*     */     try {
/* 205 */       return new URI(paramString);
/* 206 */     } catch (URISyntaxException uRISyntaxException) {
/* 207 */       throw new ProtocolException("Invalid redirect URI: " + paramString, uRISyntaxException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isRedirectable(String paramString) {
/* 215 */     return (Arrays.binarySearch((Object[])this.redirectMethods, paramString) >= 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpUriRequest getRedirect(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse, HttpContext paramHttpContext) throws ProtocolException {
/* 223 */     URI uRI = getLocationURI(paramHttpRequest, paramHttpResponse, paramHttpContext);
/* 224 */     String str = paramHttpRequest.getRequestLine().getMethod();
/* 225 */     if (str.equalsIgnoreCase("HEAD"))
/* 226 */       return (HttpUriRequest)new HttpHead(uRI); 
/* 227 */     if (str.equalsIgnoreCase("GET")) {
/* 228 */       return (HttpUriRequest)new HttpGet(uRI);
/*     */     }
/* 230 */     int i = paramHttpResponse.getStatusLine().getStatusCode();
/* 231 */     return (i == 307 || i == 308) ? RequestBuilder.copy(paramHttpRequest).setUri(uRI).build() : (HttpUriRequest)new HttpGet(uRI);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\DefaultRedirectStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */