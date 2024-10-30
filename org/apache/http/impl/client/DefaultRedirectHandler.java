/*     */ package org.apache.http.impl.client;
/*     */ 
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
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
/*     */ import org.apache.http.client.RedirectHandler;
/*     */ import org.apache.http.client.utils.URIUtils;
/*     */ import org.apache.http.params.HttpParams;
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
/*     */ @Deprecated
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class DefaultRedirectHandler
/*     */   implements RedirectHandler
/*     */ {
/*  66 */   private final Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String REDIRECT_LOCATIONS = "http.protocol.redirect-locations";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRedirectRequested(HttpResponse paramHttpResponse, HttpContext paramHttpContext) {
/*     */     HttpRequest httpRequest;
/*     */     String str;
/*  78 */     Args.notNull(paramHttpResponse, "HTTP response");
/*     */     
/*  80 */     int i = paramHttpResponse.getStatusLine().getStatusCode();
/*  81 */     switch (i) {
/*     */       case 301:
/*     */       case 302:
/*     */       case 307:
/*  85 */         httpRequest = (HttpRequest)paramHttpContext.getAttribute("http.request");
/*     */         
/*  87 */         str = httpRequest.getRequestLine().getMethod();
/*  88 */         return (str.equalsIgnoreCase("GET") || str.equalsIgnoreCase("HEAD"));
/*     */       
/*     */       case 303:
/*  91 */         return true;
/*     */     } 
/*  93 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URI getLocationURI(HttpResponse paramHttpResponse, HttpContext paramHttpContext) throws ProtocolException {
/*     */     URI uRI;
/* 101 */     Args.notNull(paramHttpResponse, "HTTP response");
/*     */     
/* 103 */     Header header = paramHttpResponse.getFirstHeader("location");
/* 104 */     if (header == null)
/*     */     {
/* 106 */       throw new ProtocolException("Received redirect response " + paramHttpResponse.getStatusLine() + " but no location header");
/*     */     }
/*     */ 
/*     */     
/* 110 */     String str = header.getValue();
/* 111 */     if (this.log.isDebugEnabled()) {
/* 112 */       this.log.debug("Redirect requested to location '" + str + "'");
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 117 */       uRI = new URI(str);
/* 118 */     } catch (URISyntaxException uRISyntaxException) {
/* 119 */       throw new ProtocolException("Invalid redirect URI: " + str, uRISyntaxException);
/*     */     } 
/*     */     
/* 122 */     HttpParams httpParams = paramHttpResponse.getParams();
/*     */ 
/*     */     
/* 125 */     if (!uRI.isAbsolute()) {
/* 126 */       if (httpParams.isParameterTrue("http.protocol.reject-relative-redirect")) {
/* 127 */         throw new ProtocolException("Relative redirect location '" + uRI + "' not allowed");
/*     */       }
/*     */ 
/*     */       
/* 131 */       HttpHost httpHost = (HttpHost)paramHttpContext.getAttribute("http.target_host");
/*     */       
/* 133 */       Asserts.notNull(httpHost, "Target host");
/*     */       
/* 135 */       HttpRequest httpRequest = (HttpRequest)paramHttpContext.getAttribute("http.request");
/*     */ 
/*     */       
/*     */       try {
/* 139 */         URI uRI1 = new URI(httpRequest.getRequestLine().getUri());
/* 140 */         URI uRI2 = URIUtils.rewriteURI(uRI1, httpHost, URIUtils.DROP_FRAGMENT_AND_NORMALIZE);
/* 141 */         uRI = URIUtils.resolve(uRI2, uRI);
/* 142 */       } catch (URISyntaxException uRISyntaxException) {
/* 143 */         throw new ProtocolException(uRISyntaxException.getMessage(), uRISyntaxException);
/*     */       } 
/*     */     } 
/*     */     
/* 147 */     if (httpParams.isParameterFalse("http.protocol.allow-circular-redirects")) {
/*     */       URI uRI1;
/* 149 */       RedirectLocations redirectLocations = (RedirectLocations)paramHttpContext.getAttribute("http.protocol.redirect-locations");
/*     */ 
/*     */       
/* 152 */       if (redirectLocations == null) {
/* 153 */         redirectLocations = new RedirectLocations();
/* 154 */         paramHttpContext.setAttribute("http.protocol.redirect-locations", redirectLocations);
/*     */       } 
/*     */ 
/*     */       
/* 158 */       if (uRI.getFragment() != null) {
/*     */         try {
/* 160 */           HttpHost httpHost = new HttpHost(uRI.getHost(), uRI.getPort(), uRI.getScheme());
/*     */ 
/*     */ 
/*     */           
/* 164 */           uRI1 = URIUtils.rewriteURI(uRI, httpHost, URIUtils.DROP_FRAGMENT_AND_NORMALIZE);
/* 165 */         } catch (URISyntaxException uRISyntaxException) {
/* 166 */           throw new ProtocolException(uRISyntaxException.getMessage(), uRISyntaxException);
/*     */         } 
/*     */       } else {
/* 169 */         uRI1 = uRI;
/*     */       } 
/*     */       
/* 172 */       if (redirectLocations.contains(uRI1)) {
/* 173 */         throw new CircularRedirectException("Circular redirect to '" + uRI1 + "'");
/*     */       }
/*     */       
/* 176 */       redirectLocations.add(uRI1);
/*     */     } 
/*     */ 
/*     */     
/* 180 */     return uRI;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\DefaultRedirectHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */