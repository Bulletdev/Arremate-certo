/*     */ package org.apache.http.impl;
/*     */ 
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpRequestFactory;
/*     */ import org.apache.http.MethodNotSupportedException;
/*     */ import org.apache.http.RequestLine;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.message.BasicHttpEntityEnclosingRequest;
/*     */ import org.apache.http.message.BasicHttpRequest;
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
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class DefaultHttpRequestFactory
/*     */   implements HttpRequestFactory
/*     */ {
/*  48 */   public static final DefaultHttpRequestFactory INSTANCE = new DefaultHttpRequestFactory();
/*     */   
/*  50 */   private static final String[] RFC2616_COMMON_METHODS = new String[] { "GET" };
/*     */ 
/*     */ 
/*     */   
/*  54 */   private static final String[] RFC2616_ENTITY_ENC_METHODS = new String[] { "POST", "PUT" };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  59 */   private static final String[] RFC2616_SPECIAL_METHODS = new String[] { "HEAD", "OPTIONS", "DELETE", "TRACE", "CONNECT" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  67 */   private static final String[] RFC5789_ENTITY_ENC_METHODS = new String[] { "PATCH" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isOneOf(String[] paramArrayOfString, String paramString) {
/*  76 */     for (String str : paramArrayOfString) {
/*  77 */       if (str.equalsIgnoreCase(paramString)) {
/*  78 */         return true;
/*     */       }
/*     */     } 
/*  81 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpRequest newHttpRequest(RequestLine paramRequestLine) throws MethodNotSupportedException {
/*  87 */     Args.notNull(paramRequestLine, "Request line");
/*  88 */     String str = paramRequestLine.getMethod();
/*  89 */     if (isOneOf(RFC2616_COMMON_METHODS, str))
/*  90 */       return (HttpRequest)new BasicHttpRequest(paramRequestLine); 
/*  91 */     if (isOneOf(RFC2616_ENTITY_ENC_METHODS, str))
/*  92 */       return (HttpRequest)new BasicHttpEntityEnclosingRequest(paramRequestLine); 
/*  93 */     if (isOneOf(RFC2616_SPECIAL_METHODS, str))
/*  94 */       return (HttpRequest)new BasicHttpRequest(paramRequestLine); 
/*  95 */     if (isOneOf(RFC5789_ENTITY_ENC_METHODS, str)) {
/*  96 */       return (HttpRequest)new BasicHttpEntityEnclosingRequest(paramRequestLine);
/*     */     }
/*  98 */     throw new MethodNotSupportedException(str + " method not supported");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpRequest newHttpRequest(String paramString1, String paramString2) throws MethodNotSupportedException {
/* 105 */     if (isOneOf(RFC2616_COMMON_METHODS, paramString1))
/* 106 */       return (HttpRequest)new BasicHttpRequest(paramString1, paramString2); 
/* 107 */     if (isOneOf(RFC2616_ENTITY_ENC_METHODS, paramString1))
/* 108 */       return (HttpRequest)new BasicHttpEntityEnclosingRequest(paramString1, paramString2); 
/* 109 */     if (isOneOf(RFC2616_SPECIAL_METHODS, paramString1))
/* 110 */       return (HttpRequest)new BasicHttpRequest(paramString1, paramString2); 
/* 111 */     if (isOneOf(RFC5789_ENTITY_ENC_METHODS, paramString1)) {
/* 112 */       return (HttpRequest)new BasicHttpEntityEnclosingRequest(paramString1, paramString2);
/*     */     }
/* 114 */     throw new MethodNotSupportedException(paramString1 + " method not supported");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\DefaultHttpRequestFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */