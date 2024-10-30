/*     */ package org.apache.http.impl.cookie;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.conn.util.PublicSuffixList;
/*     */ import org.apache.http.conn.util.PublicSuffixMatcher;
/*     */ import org.apache.http.cookie.CommonCookieAttributeHandler;
/*     */ import org.apache.http.cookie.Cookie;
/*     */ import org.apache.http.cookie.CookieOrigin;
/*     */ import org.apache.http.cookie.MalformedCookieException;
/*     */ import org.apache.http.cookie.SetCookie;
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
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/*     */ public class PublicSuffixDomainFilter
/*     */   implements CommonCookieAttributeHandler
/*     */ {
/*     */   private final CommonCookieAttributeHandler handler;
/*     */   private final PublicSuffixMatcher publicSuffixMatcher;
/*     */   private final Map<String, Boolean> localDomainMap;
/*     */   
/*     */   private static Map<String, Boolean> createLocalDomainMap() {
/*  62 */     ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<Object, Object>();
/*  63 */     concurrentHashMap.put(".localhost.", Boolean.TRUE);
/*  64 */     concurrentHashMap.put(".test.", Boolean.TRUE);
/*  65 */     concurrentHashMap.put(".local.", Boolean.TRUE);
/*  66 */     concurrentHashMap.put(".local", Boolean.TRUE);
/*  67 */     concurrentHashMap.put(".localdomain", Boolean.TRUE);
/*  68 */     return (Map)concurrentHashMap;
/*     */   }
/*     */ 
/*     */   
/*     */   public PublicSuffixDomainFilter(CommonCookieAttributeHandler paramCommonCookieAttributeHandler, PublicSuffixMatcher paramPublicSuffixMatcher) {
/*  73 */     this.handler = (CommonCookieAttributeHandler)Args.notNull(paramCommonCookieAttributeHandler, "Cookie handler");
/*  74 */     this.publicSuffixMatcher = (PublicSuffixMatcher)Args.notNull(paramPublicSuffixMatcher, "Public suffix matcher");
/*  75 */     this.localDomainMap = createLocalDomainMap();
/*     */   }
/*     */ 
/*     */   
/*     */   public PublicSuffixDomainFilter(CommonCookieAttributeHandler paramCommonCookieAttributeHandler, PublicSuffixList paramPublicSuffixList) {
/*  80 */     Args.notNull(paramCommonCookieAttributeHandler, "Cookie handler");
/*  81 */     Args.notNull(paramPublicSuffixList, "Public suffix list");
/*  82 */     this.handler = paramCommonCookieAttributeHandler;
/*  83 */     this.publicSuffixMatcher = new PublicSuffixMatcher(paramPublicSuffixList.getRules(), paramPublicSuffixList.getExceptions());
/*  84 */     this.localDomainMap = createLocalDomainMap();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean match(Cookie paramCookie, CookieOrigin paramCookieOrigin) {
/*  92 */     String str = paramCookie.getDomain();
/*  93 */     if (str == null) {
/*  94 */       return false;
/*     */     }
/*  96 */     int i = str.indexOf('.');
/*  97 */     if (i >= 0) {
/*  98 */       String str1 = str.substring(i);
/*  99 */       if (!this.localDomainMap.containsKey(str1) && 
/* 100 */         this.publicSuffixMatcher.matches(str)) {
/* 101 */         return false;
/*     */       
/*     */       }
/*     */     }
/* 105 */     else if (!str.equalsIgnoreCase(paramCookieOrigin.getHost()) && 
/* 106 */       this.publicSuffixMatcher.matches(str)) {
/* 107 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 111 */     return this.handler.match(paramCookie, paramCookieOrigin);
/*     */   }
/*     */ 
/*     */   
/*     */   public void parse(SetCookie paramSetCookie, String paramString) throws MalformedCookieException {
/* 116 */     this.handler.parse(paramSetCookie, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public void validate(Cookie paramCookie, CookieOrigin paramCookieOrigin) throws MalformedCookieException {
/* 121 */     this.handler.validate(paramCookie, paramCookieOrigin);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAttributeName() {
/* 126 */     return this.handler.getAttributeName();
/*     */   }
/*     */ 
/*     */   
/*     */   public static CommonCookieAttributeHandler decorate(CommonCookieAttributeHandler paramCommonCookieAttributeHandler, PublicSuffixMatcher paramPublicSuffixMatcher) {
/* 131 */     Args.notNull(paramCommonCookieAttributeHandler, "Cookie attribute handler");
/* 132 */     return (paramPublicSuffixMatcher != null) ? new PublicSuffixDomainFilter(paramCommonCookieAttributeHandler, paramPublicSuffixMatcher) : paramCommonCookieAttributeHandler;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\cookie\PublicSuffixDomainFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */