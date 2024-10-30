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
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class DefaultCookieSpecProvider
/*     */   implements CookieSpecProvider
/*     */ {
/*     */   private final CompatibilityLevel compatibilityLevel;
/*     */   private final PublicSuffixMatcher publicSuffixMatcher;
/*     */   private final String[] datepatterns;
/*     */   private final boolean oneHeader;
/*     */   private volatile CookieSpec cookieSpec;
/*     */   
/*     */   public enum CompatibilityLevel
/*     */   {
/*  51 */     DEFAULT,
/*  52 */     IE_MEDIUM_SECURITY;
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
/*     */ 
/*     */   
/*     */   public DefaultCookieSpecProvider(CompatibilityLevel paramCompatibilityLevel, PublicSuffixMatcher paramPublicSuffixMatcher, String[] paramArrayOfString, boolean paramBoolean) {
/*  68 */     this.compatibilityLevel = (paramCompatibilityLevel != null) ? paramCompatibilityLevel : CompatibilityLevel.DEFAULT;
/*  69 */     this.publicSuffixMatcher = paramPublicSuffixMatcher;
/*  70 */     this.datepatterns = paramArrayOfString;
/*  71 */     this.oneHeader = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultCookieSpecProvider(CompatibilityLevel paramCompatibilityLevel, PublicSuffixMatcher paramPublicSuffixMatcher) {
/*  77 */     this(paramCompatibilityLevel, paramPublicSuffixMatcher, null, false);
/*     */   }
/*     */   
/*     */   public DefaultCookieSpecProvider(PublicSuffixMatcher paramPublicSuffixMatcher) {
/*  81 */     this(CompatibilityLevel.DEFAULT, paramPublicSuffixMatcher, null, false);
/*     */   }
/*     */   
/*     */   public DefaultCookieSpecProvider() {
/*  85 */     this(CompatibilityLevel.DEFAULT, null, null, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public CookieSpec create(HttpContext paramHttpContext) {
/*  90 */     if (this.cookieSpec == null) {
/*  91 */       synchronized (this) {
/*  92 */         if (this.cookieSpec == null) {
/*  93 */           RFC2965Spec rFC2965Spec = new RFC2965Spec(this.oneHeader, new CommonCookieAttributeHandler[] { new RFC2965VersionAttributeHandler(), new BasicPathHandler(), PublicSuffixDomainFilter.decorate(new RFC2965DomainAttributeHandler(), this.publicSuffixMatcher), new RFC2965PortAttributeHandler(), new BasicMaxAgeHandler(), new BasicSecureHandler(), new BasicCommentHandler(), new RFC2965CommentUrlAttributeHandler(), new RFC2965DiscardAttributeHandler() });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 104 */           RFC2109Spec rFC2109Spec = new RFC2109Spec(this.oneHeader, new CommonCookieAttributeHandler[] { new RFC2109VersionHandler(), new BasicPathHandler(), PublicSuffixDomainFilter.decorate(new RFC2109DomainHandler(), this.publicSuffixMatcher), new BasicMaxAgeHandler(), new BasicSecureHandler(), new BasicCommentHandler() });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 112 */           (new CommonCookieAttributeHandler[5])[0] = PublicSuffixDomainFilter.decorate(new BasicDomainHandler(), this.publicSuffixMatcher); (new CommonCookieAttributeHandler[5])[1] = (this.compatibilityLevel == CompatibilityLevel.IE_MEDIUM_SECURITY) ? new BasicPathHandler() { public void validate(Cookie param1Cookie, CookieOrigin param1CookieOrigin) throws MalformedCookieException {} } : new BasicPathHandler(); (new CommonCookieAttributeHandler[5])[2] = new BasicSecureHandler(); (new CommonCookieAttributeHandler[5])[3] = new BasicCommentHandler(); (new String[1])[0] = "EEE, dd-MMM-yy HH:mm:ss z"; NetscapeDraftSpec netscapeDraftSpec = new NetscapeDraftSpec(new CommonCookieAttributeHandler[] { null, null, null, null, new BasicExpiresHandler((this.datepatterns != null) ? (String[])this.datepatterns.clone() : new String[1]) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 128 */           this.cookieSpec = new DefaultCookieSpec(rFC2965Spec, rFC2109Spec, netscapeDraftSpec);
/*     */         } 
/*     */       } 
/*     */     }
/* 132 */     return this.cookieSpec;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\cookie\DefaultCookieSpecProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */