/*     */ package org.apache.http.impl.cookie;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import org.apache.http.conn.util.PublicSuffixMatcher;
/*     */ import org.apache.http.cookie.Cookie;
/*     */ import org.apache.http.cookie.CookieAttributeHandler;
/*     */ import org.apache.http.cookie.CookieOrigin;
/*     */ import org.apache.http.cookie.MalformedCookieException;
/*     */ import org.apache.http.cookie.SetCookie;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class PublicSuffixFilter
/*     */   implements CookieAttributeHandler
/*     */ {
/*     */   private final CookieAttributeHandler wrapped;
/*     */   private Collection<String> exceptions;
/*     */   private Collection<String> suffixes;
/*     */   private PublicSuffixMatcher matcher;
/*     */   
/*     */   public PublicSuffixFilter(CookieAttributeHandler paramCookieAttributeHandler) {
/*  58 */     this.wrapped = paramCookieAttributeHandler;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPublicSuffixes(Collection<String> paramCollection) {
/*  68 */     this.suffixes = paramCollection;
/*  69 */     this.matcher = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExceptions(Collection<String> paramCollection) {
/*  78 */     this.exceptions = paramCollection;
/*  79 */     this.matcher = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean match(Cookie paramCookie, CookieOrigin paramCookieOrigin) {
/*  87 */     if (isForPublicSuffix(paramCookie)) {
/*  88 */       return false;
/*     */     }
/*  90 */     return this.wrapped.match(paramCookie, paramCookieOrigin);
/*     */   }
/*     */ 
/*     */   
/*     */   public void parse(SetCookie paramSetCookie, String paramString) throws MalformedCookieException {
/*  95 */     this.wrapped.parse(paramSetCookie, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public void validate(Cookie paramCookie, CookieOrigin paramCookieOrigin) throws MalformedCookieException {
/* 100 */     this.wrapped.validate(paramCookie, paramCookieOrigin);
/*     */   }
/*     */   
/*     */   private boolean isForPublicSuffix(Cookie paramCookie) {
/* 104 */     if (this.matcher == null) {
/* 105 */       this.matcher = new PublicSuffixMatcher(this.suffixes, this.exceptions);
/*     */     }
/* 107 */     return this.matcher.matches(paramCookie.getDomain());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\cookie\PublicSuffixFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */