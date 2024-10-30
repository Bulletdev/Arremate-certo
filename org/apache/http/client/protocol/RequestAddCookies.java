/*     */ package org.apache.http.client.protocol;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpRequestInterceptor;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.client.CookieStore;
/*     */ import org.apache.http.client.config.RequestConfig;
/*     */ import org.apache.http.client.methods.HttpUriRequest;
/*     */ import org.apache.http.config.Lookup;
/*     */ import org.apache.http.conn.routing.RouteInfo;
/*     */ import org.apache.http.cookie.Cookie;
/*     */ import org.apache.http.cookie.CookieOrigin;
/*     */ import org.apache.http.cookie.CookieSpec;
/*     */ import org.apache.http.cookie.CookieSpecProvider;
/*     */ import org.apache.http.protocol.HttpContext;
/*     */ import org.apache.http.util.Args;
/*     */ import org.apache.http.util.TextUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class RequestAddCookies
/*     */   implements HttpRequestInterceptor
/*     */ {
/*  70 */   private final Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws HttpException, IOException {
/*  79 */     Args.notNull(paramHttpRequest, "HTTP request");
/*  80 */     Args.notNull(paramHttpContext, "HTTP context");
/*     */     
/*  82 */     String str1 = paramHttpRequest.getRequestLine().getMethod();
/*  83 */     if (str1.equalsIgnoreCase("CONNECT")) {
/*     */       return;
/*     */     }
/*     */     
/*  87 */     HttpClientContext httpClientContext = HttpClientContext.adapt(paramHttpContext);
/*     */ 
/*     */     
/*  90 */     CookieStore cookieStore = httpClientContext.getCookieStore();
/*  91 */     if (cookieStore == null) {
/*  92 */       this.log.debug("Cookie store not specified in HTTP context");
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*  97 */     Lookup<CookieSpecProvider> lookup = httpClientContext.getCookieSpecRegistry();
/*  98 */     if (lookup == null) {
/*  99 */       this.log.debug("CookieSpec registry not specified in HTTP context");
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 104 */     HttpHost httpHost = httpClientContext.getTargetHost();
/* 105 */     if (httpHost == null) {
/* 106 */       this.log.debug("Target host not set in the context");
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 111 */     RouteInfo routeInfo = httpClientContext.getHttpRoute();
/* 112 */     if (routeInfo == null) {
/* 113 */       this.log.debug("Connection route not set in the context");
/*     */       
/*     */       return;
/*     */     } 
/* 117 */     RequestConfig requestConfig = httpClientContext.getRequestConfig();
/* 118 */     String str2 = requestConfig.getCookieSpec();
/* 119 */     if (str2 == null) {
/* 120 */       str2 = "default";
/*     */     }
/* 122 */     if (this.log.isDebugEnabled()) {
/* 123 */       this.log.debug("CookieSpec selected: " + str2);
/*     */     }
/*     */     
/* 126 */     URI uRI = null;
/* 127 */     if (paramHttpRequest instanceof HttpUriRequest) {
/* 128 */       uRI = ((HttpUriRequest)paramHttpRequest).getURI();
/*     */     } else {
/*     */       try {
/* 131 */         uRI = new URI(paramHttpRequest.getRequestLine().getUri());
/* 132 */       } catch (URISyntaxException uRISyntaxException) {}
/*     */     } 
/*     */     
/* 135 */     String str3 = (uRI != null) ? uRI.getPath() : null;
/* 136 */     String str4 = httpHost.getHostName();
/* 137 */     int i = httpHost.getPort();
/* 138 */     if (i < 0) {
/* 139 */       i = routeInfo.getTargetHost().getPort();
/*     */     }
/*     */     
/* 142 */     CookieOrigin cookieOrigin = new CookieOrigin(str4, (i >= 0) ? i : 0, !TextUtils.isEmpty(str3) ? str3 : "/", routeInfo.isSecure());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 149 */     CookieSpecProvider cookieSpecProvider = (CookieSpecProvider)lookup.lookup(str2);
/* 150 */     if (cookieSpecProvider == null) {
/* 151 */       if (this.log.isDebugEnabled()) {
/* 152 */         this.log.debug("Unsupported cookie policy: " + str2);
/*     */       }
/*     */       
/*     */       return;
/*     */     } 
/* 157 */     CookieSpec cookieSpec = cookieSpecProvider.create((HttpContext)httpClientContext);
/*     */     
/* 159 */     List list = cookieStore.getCookies();
/*     */     
/* 161 */     ArrayList<Cookie> arrayList = new ArrayList();
/* 162 */     Date date = new Date();
/* 163 */     boolean bool = false;
/* 164 */     for (Cookie cookie : list) {
/* 165 */       if (!cookie.isExpired(date)) {
/* 166 */         if (cookieSpec.match(cookie, cookieOrigin)) {
/* 167 */           if (this.log.isDebugEnabled()) {
/* 168 */             this.log.debug("Cookie " + cookie + " match " + cookieOrigin);
/*     */           }
/* 170 */           arrayList.add(cookie);
/*     */         }  continue;
/*     */       } 
/* 173 */       if (this.log.isDebugEnabled()) {
/* 174 */         this.log.debug("Cookie " + cookie + " expired");
/*     */       }
/* 176 */       bool = true;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 182 */     if (bool) {
/* 183 */       cookieStore.clearExpired(date);
/*     */     }
/*     */     
/* 186 */     if (!arrayList.isEmpty()) {
/* 187 */       List list1 = cookieSpec.formatCookies(arrayList);
/* 188 */       for (Header header : list1) {
/* 189 */         paramHttpRequest.addHeader(header);
/*     */       }
/*     */     } 
/*     */     
/* 193 */     int j = cookieSpec.getVersion();
/* 194 */     if (j > 0) {
/* 195 */       Header header = cookieSpec.getVersionHeader();
/* 196 */       if (header != null)
/*     */       {
/* 198 */         paramHttpRequest.addHeader(header);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 204 */     paramHttpContext.setAttribute("http.cookie-spec", cookieSpec);
/* 205 */     paramHttpContext.setAttribute("http.cookie-origin", cookieOrigin);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\protocol\RequestAddCookies.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */