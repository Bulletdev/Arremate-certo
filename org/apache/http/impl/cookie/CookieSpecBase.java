/*     */ package org.apache.http.impl.cookie;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import org.apache.http.HeaderElement;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.cookie.CommonCookieAttributeHandler;
/*     */ import org.apache.http.cookie.Cookie;
/*     */ import org.apache.http.cookie.CookieAttributeHandler;
/*     */ import org.apache.http.cookie.CookieOrigin;
/*     */ import org.apache.http.cookie.MalformedCookieException;
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
/*     */ @Contract(threading = ThreadingBehavior.SAFE)
/*     */ public abstract class CookieSpecBase
/*     */   extends AbstractCookieSpec
/*     */ {
/*     */   public CookieSpecBase() {}
/*     */   
/*     */   protected CookieSpecBase(HashMap<String, CookieAttributeHandler> paramHashMap) {
/*  62 */     super(paramHashMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected CookieSpecBase(CommonCookieAttributeHandler... paramVarArgs) {
/*  69 */     super(paramVarArgs);
/*     */   }
/*     */   
/*     */   protected static String getDefaultPath(CookieOrigin paramCookieOrigin) {
/*  73 */     String str = paramCookieOrigin.getPath();
/*  74 */     int i = str.lastIndexOf('/');
/*  75 */     if (i >= 0) {
/*  76 */       if (i == 0)
/*     */       {
/*  78 */         i = 1;
/*     */       }
/*  80 */       str = str.substring(0, i);
/*     */     } 
/*  82 */     return str;
/*     */   }
/*     */   
/*     */   protected static String getDefaultDomain(CookieOrigin paramCookieOrigin) {
/*  86 */     return paramCookieOrigin.getHost();
/*     */   }
/*     */ 
/*     */   
/*     */   protected List<Cookie> parse(HeaderElement[] paramArrayOfHeaderElement, CookieOrigin paramCookieOrigin) throws MalformedCookieException {
/*  91 */     ArrayList<BasicClientCookie> arrayList = new ArrayList(paramArrayOfHeaderElement.length);
/*  92 */     for (HeaderElement headerElement : paramArrayOfHeaderElement) {
/*  93 */       String str1 = headerElement.getName();
/*  94 */       String str2 = headerElement.getValue();
/*  95 */       if (str1 != null && !str1.isEmpty()) {
/*     */ 
/*     */ 
/*     */         
/*  99 */         BasicClientCookie basicClientCookie = new BasicClientCookie(str1, str2);
/* 100 */         basicClientCookie.setPath(getDefaultPath(paramCookieOrigin));
/* 101 */         basicClientCookie.setDomain(getDefaultDomain(paramCookieOrigin));
/*     */ 
/*     */         
/* 104 */         NameValuePair[] arrayOfNameValuePair = headerElement.getParameters();
/* 105 */         for (int i = arrayOfNameValuePair.length - 1; i >= 0; i--) {
/* 106 */           NameValuePair nameValuePair = arrayOfNameValuePair[i];
/* 107 */           String str = nameValuePair.getName().toLowerCase(Locale.ROOT);
/*     */           
/* 109 */           basicClientCookie.setAttribute(str, nameValuePair.getValue());
/*     */           
/* 111 */           CookieAttributeHandler cookieAttributeHandler = findAttribHandler(str);
/* 112 */           if (cookieAttributeHandler != null) {
/* 113 */             cookieAttributeHandler.parse(basicClientCookie, nameValuePair.getValue());
/*     */           }
/*     */         } 
/* 116 */         arrayList.add(basicClientCookie);
/*     */       } 
/* 118 */     }  return (List)arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void validate(Cookie paramCookie, CookieOrigin paramCookieOrigin) throws MalformedCookieException {
/* 124 */     Args.notNull(paramCookie, "Cookie");
/* 125 */     Args.notNull(paramCookieOrigin, "Cookie origin");
/* 126 */     for (CookieAttributeHandler cookieAttributeHandler : getAttribHandlers()) {
/* 127 */       cookieAttributeHandler.validate(paramCookie, paramCookieOrigin);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean match(Cookie paramCookie, CookieOrigin paramCookieOrigin) {
/* 133 */     Args.notNull(paramCookie, "Cookie");
/* 134 */     Args.notNull(paramCookieOrigin, "Cookie origin");
/* 135 */     for (CookieAttributeHandler cookieAttributeHandler : getAttribHandlers()) {
/* 136 */       if (!cookieAttributeHandler.match(paramCookie, paramCookieOrigin)) {
/* 137 */         return false;
/*     */       }
/*     */     } 
/* 140 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\cookie\CookieSpecBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */