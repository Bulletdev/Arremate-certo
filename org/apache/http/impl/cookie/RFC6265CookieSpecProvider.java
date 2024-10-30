/*     */ package org.apache.http.impl.cookie;
/*     */ 
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.conn.util.PublicSuffixMatcher;
/*     */ import org.apache.http.cookie.CommonCookieAttributeHandler;
/*     */ import org.apache.http.cookie.Cookie;
/*     */ import org.apache.http.cookie.CookieOrigin;
/*     */ import org.apache.http.cookie.CookieSpec;
/*     */ import org.apache.http.cookie.CookieSpecProvider;
/*     */ import org.apache.http.cookie.MalformedCookieException;
/*     */ import org.apache.http.protocol.HttpContext;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class RFC6265CookieSpecProvider
/*     */   implements CookieSpecProvider
/*     */ {
/*     */   private final CompatibilityLevel compatibilityLevel;
/*     */   private final PublicSuffixMatcher publicSuffixMatcher;
/*     */   private volatile CookieSpec cookieSpec;
/*     */   
/*     */   public enum CompatibilityLevel
/*     */   {
/*  51 */     STRICT,
/*  52 */     RELAXED,
/*  53 */     IE_MEDIUM_SECURITY;
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
/*     */   public RFC6265CookieSpecProvider(CompatibilityLevel paramCompatibilityLevel, PublicSuffixMatcher paramPublicSuffixMatcher) {
/*  65 */     this.compatibilityLevel = (paramCompatibilityLevel != null) ? paramCompatibilityLevel : CompatibilityLevel.RELAXED;
/*  66 */     this.publicSuffixMatcher = paramPublicSuffixMatcher;
/*     */   }
/*     */   
/*     */   public RFC6265CookieSpecProvider(PublicSuffixMatcher paramPublicSuffixMatcher) {
/*  70 */     this(CompatibilityLevel.RELAXED, paramPublicSuffixMatcher);
/*     */   }
/*     */   
/*     */   public RFC6265CookieSpecProvider() {
/*  74 */     this(CompatibilityLevel.RELAXED, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public CookieSpec create(HttpContext paramHttpContext) {
/*  79 */     if (this.cookieSpec == null) {
/*  80 */       synchronized (this) {
/*  81 */         if (this.cookieSpec == null) {
/*  82 */           switch (this.compatibilityLevel) {
/*     */             case STRICT:
/*  84 */               this.cookieSpec = new RFC6265StrictSpec(new CommonCookieAttributeHandler[] { new BasicPathHandler(), PublicSuffixDomainFilter.decorate(new BasicDomainHandler(), this.publicSuffixMatcher), new BasicMaxAgeHandler(), new BasicSecureHandler(), new BasicExpiresHandler(RFC6265StrictSpec.DATE_PATTERNS) });
/*     */               break;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             case IE_MEDIUM_SECURITY:
/*  93 */               this.cookieSpec = new RFC6265LaxSpec(new CommonCookieAttributeHandler[] { new BasicPathHandler() { public void validate(Cookie param1Cookie, CookieOrigin param1CookieOrigin) throws MalformedCookieException {} }, PublicSuffixDomainFilter.decorate(new BasicDomainHandler(), this.publicSuffixMatcher), new BasicMaxAgeHandler(), new BasicSecureHandler(), new BasicExpiresHandler(RFC6265StrictSpec.DATE_PATTERNS) });
/*     */               break;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             default:
/* 109 */               this.cookieSpec = new RFC6265LaxSpec(new CommonCookieAttributeHandler[] { new BasicPathHandler(), PublicSuffixDomainFilter.decorate(new BasicDomainHandler(), this.publicSuffixMatcher), new LaxMaxAgeHandler(), new BasicSecureHandler(), new LaxExpiresHandler() });
/*     */               break;
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         }
/*     */       } 
/*     */     }
/* 120 */     return this.cookieSpec;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\cookie\RFC6265CookieSpecProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */