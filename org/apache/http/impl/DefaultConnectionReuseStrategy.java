/*     */ package org.apache.http.impl;
/*     */ 
/*     */ import org.apache.http.ConnectionReuseStrategy;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HeaderIterator;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.HttpVersion;
/*     */ import org.apache.http.ParseException;
/*     */ import org.apache.http.ProtocolVersion;
/*     */ import org.apache.http.TokenIterator;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.message.BasicTokenIterator;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class DefaultConnectionReuseStrategy
/*     */   implements ConnectionReuseStrategy
/*     */ {
/*  70 */   public static final DefaultConnectionReuseStrategy INSTANCE = new DefaultConnectionReuseStrategy();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean keepAlive(HttpResponse paramHttpResponse, HttpContext paramHttpContext) {
/*  80 */     Args.notNull(paramHttpResponse, "HTTP response");
/*  81 */     Args.notNull(paramHttpContext, "HTTP context");
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  86 */     if (paramHttpResponse.getStatusLine().getStatusCode() == 204) {
/*  87 */       Header header1 = paramHttpResponse.getFirstHeader("Content-Length");
/*  88 */       if (header1 != null) {
/*     */         try {
/*  90 */           int i = Integer.parseInt(header1.getValue());
/*  91 */           if (i > 0) {
/*  92 */             return false;
/*     */           }
/*  94 */         } catch (NumberFormatException numberFormatException) {}
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*  99 */       Header header2 = paramHttpResponse.getFirstHeader("Transfer-Encoding");
/* 100 */       if (header2 != null) {
/* 101 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 105 */     HttpRequest httpRequest = (HttpRequest)paramHttpContext.getAttribute("http.request");
/* 106 */     if (httpRequest != null) {
/*     */       try {
/* 108 */         BasicTokenIterator basicTokenIterator = new BasicTokenIterator(httpRequest.headerIterator("Connection"));
/* 109 */         while (basicTokenIterator.hasNext()) {
/* 110 */           String str = basicTokenIterator.nextToken();
/* 111 */           if ("Close".equalsIgnoreCase(str)) {
/* 112 */             return false;
/*     */           }
/*     */         } 
/* 115 */       } catch (ParseException parseException) {
/*     */         
/* 117 */         return false;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 123 */     ProtocolVersion protocolVersion = paramHttpResponse.getStatusLine().getProtocolVersion();
/* 124 */     Header header = paramHttpResponse.getFirstHeader("Transfer-Encoding");
/* 125 */     if (header != null) {
/* 126 */       if (!"chunked".equalsIgnoreCase(header.getValue())) {
/* 127 */         return false;
/*     */       }
/*     */     }
/* 130 */     else if (canResponseHaveBody(httpRequest, paramHttpResponse)) {
/* 131 */       Header[] arrayOfHeader = paramHttpResponse.getHeaders("Content-Length");
/*     */       
/* 133 */       if (arrayOfHeader.length == 1) {
/* 134 */         Header header1 = arrayOfHeader[0];
/*     */         try {
/* 136 */           long l = Long.parseLong(header1.getValue());
/* 137 */           if (l < 0L) {
/* 138 */             return false;
/*     */           }
/* 140 */         } catch (NumberFormatException numberFormatException) {
/* 141 */           return false;
/*     */         } 
/*     */       } else {
/* 144 */         return false;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 152 */     HeaderIterator headerIterator = paramHttpResponse.headerIterator("Connection");
/* 153 */     if (!headerIterator.hasNext()) {
/* 154 */       headerIterator = paramHttpResponse.headerIterator("Proxy-Connection");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 180 */     if (headerIterator.hasNext()) {
/*     */       try {
/* 182 */         BasicTokenIterator basicTokenIterator = new BasicTokenIterator(headerIterator);
/* 183 */         boolean bool = false;
/* 184 */         while (basicTokenIterator.hasNext()) {
/* 185 */           String str = basicTokenIterator.nextToken();
/* 186 */           if ("Close".equalsIgnoreCase(str))
/* 187 */             return false; 
/* 188 */           if ("Keep-Alive".equalsIgnoreCase(str))
/*     */           {
/* 190 */             bool = true;
/*     */           }
/*     */         } 
/* 193 */         if (bool) {
/* 194 */           return true;
/*     */         
/*     */         }
/*     */       }
/* 198 */       catch (ParseException parseException) {
/*     */         
/* 200 */         return false;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 205 */     return !protocolVersion.lessEquals((ProtocolVersion)HttpVersion.HTTP_1_0);
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
/*     */   protected TokenIterator createTokenIterator(HeaderIterator paramHeaderIterator) {
/* 219 */     return (TokenIterator)new BasicTokenIterator(paramHeaderIterator);
/*     */   }
/*     */   
/*     */   private boolean canResponseHaveBody(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse) {
/* 223 */     if (paramHttpRequest != null && paramHttpRequest.getRequestLine().getMethod().equalsIgnoreCase("HEAD")) {
/* 224 */       return false;
/*     */     }
/* 226 */     int i = paramHttpResponse.getStatusLine().getStatusCode();
/* 227 */     return (i >= 200 && i != 204 && i != 304 && i != 205);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\DefaultConnectionReuseStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */