/*     */ package org.apache.http.client.protocol;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HeaderIterator;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.HttpResponseInterceptor;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.client.CookieStore;
/*     */ import org.apache.http.cookie.Cookie;
/*     */ import org.apache.http.cookie.CookieOrigin;
/*     */ import org.apache.http.cookie.CookieSpec;
/*     */ import org.apache.http.cookie.MalformedCookieException;
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
/*     */ public class ResponseProcessCookies
/*     */   implements HttpResponseInterceptor
/*     */ {
/*  60 */   private final Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void process(HttpResponse paramHttpResponse, HttpContext paramHttpContext) throws HttpException, IOException {
/*  69 */     Args.notNull(paramHttpResponse, "HTTP request");
/*  70 */     Args.notNull(paramHttpContext, "HTTP context");
/*     */     
/*  72 */     HttpClientContext httpClientContext = HttpClientContext.adapt(paramHttpContext);
/*     */ 
/*     */     
/*  75 */     CookieSpec cookieSpec = httpClientContext.getCookieSpec();
/*  76 */     if (cookieSpec == null) {
/*  77 */       this.log.debug("Cookie spec not specified in HTTP context");
/*     */       
/*     */       return;
/*     */     } 
/*  81 */     CookieStore cookieStore = httpClientContext.getCookieStore();
/*  82 */     if (cookieStore == null) {
/*  83 */       this.log.debug("Cookie store not specified in HTTP context");
/*     */       
/*     */       return;
/*     */     } 
/*  87 */     CookieOrigin cookieOrigin = httpClientContext.getCookieOrigin();
/*  88 */     if (cookieOrigin == null) {
/*  89 */       this.log.debug("Cookie origin not specified in HTTP context");
/*     */       return;
/*     */     } 
/*  92 */     HeaderIterator headerIterator = paramHttpResponse.headerIterator("Set-Cookie");
/*  93 */     processCookies(headerIterator, cookieSpec, cookieOrigin, cookieStore);
/*     */ 
/*     */     
/*  96 */     if (cookieSpec.getVersion() > 0) {
/*     */ 
/*     */       
/*  99 */       headerIterator = paramHttpResponse.headerIterator("Set-Cookie2");
/* 100 */       processCookies(headerIterator, cookieSpec, cookieOrigin, cookieStore);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void processCookies(HeaderIterator paramHeaderIterator, CookieSpec paramCookieSpec, CookieOrigin paramCookieOrigin, CookieStore paramCookieStore) {
/* 109 */     while (paramHeaderIterator.hasNext()) {
/* 110 */       Header header = paramHeaderIterator.nextHeader();
/*     */       try {
/* 112 */         List list = paramCookieSpec.parse(header, paramCookieOrigin);
/* 113 */         for (Cookie cookie : list) {
/*     */           try {
/* 115 */             paramCookieSpec.validate(cookie, paramCookieOrigin);
/* 116 */             paramCookieStore.addCookie(cookie);
/*     */             
/* 118 */             if (this.log.isDebugEnabled()) {
/* 119 */               this.log.debug("Cookie accepted [" + formatCooke(cookie) + "]");
/*     */             }
/* 121 */           } catch (MalformedCookieException malformedCookieException) {
/* 122 */             if (this.log.isWarnEnabled()) {
/* 123 */               this.log.warn("Cookie rejected [" + formatCooke(cookie) + "] " + malformedCookieException.getMessage());
/*     */             }
/*     */           }
/*     */         
/*     */         } 
/* 128 */       } catch (MalformedCookieException malformedCookieException) {
/* 129 */         if (this.log.isWarnEnabled()) {
/* 130 */           this.log.warn("Invalid cookie header: \"" + header + "\". " + malformedCookieException.getMessage());
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static String formatCooke(Cookie paramCookie) {
/* 138 */     StringBuilder stringBuilder = new StringBuilder();
/* 139 */     stringBuilder.append(paramCookie.getName());
/* 140 */     stringBuilder.append("=\"");
/* 141 */     String str = paramCookie.getValue();
/* 142 */     if (str != null) {
/* 143 */       if (str.length() > 100) {
/* 144 */         str = str.substring(0, 100) + "...";
/*     */       }
/* 146 */       stringBuilder.append(str);
/*     */     } 
/* 148 */     stringBuilder.append("\"");
/* 149 */     stringBuilder.append(", version:");
/* 150 */     stringBuilder.append(Integer.toString(paramCookie.getVersion()));
/* 151 */     stringBuilder.append(", domain:");
/* 152 */     stringBuilder.append(paramCookie.getDomain());
/* 153 */     stringBuilder.append(", path:");
/* 154 */     stringBuilder.append(paramCookie.getPath());
/* 155 */     stringBuilder.append(", expiry:");
/* 156 */     stringBuilder.append(paramCookie.getExpiryDate());
/* 157 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\protocol\ResponseProcessCookies.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */