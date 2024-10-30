/*     */ package org.apache.http.impl.cookie;
/*     */ 
/*     */ import java.util.Locale;
/*     */ import java.util.StringTokenizer;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.cookie.Cookie;
/*     */ import org.apache.http.cookie.CookieOrigin;
/*     */ import org.apache.http.cookie.CookieRestrictionViolationException;
/*     */ import org.apache.http.cookie.MalformedCookieException;
/*     */ import org.apache.http.cookie.SetCookie;
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
/*     */ 
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class NetscapeDomainHandler
/*     */   extends BasicDomainHandler
/*     */ {
/*     */   public void parse(SetCookie paramSetCookie, String paramString) throws MalformedCookieException {
/*  56 */     Args.notNull(paramSetCookie, "Cookie");
/*  57 */     if (TextUtils.isBlank(paramString)) {
/*  58 */       throw new MalformedCookieException("Blank or null value for domain attribute");
/*     */     }
/*  60 */     paramSetCookie.setDomain(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void validate(Cookie paramCookie, CookieOrigin paramCookieOrigin) throws MalformedCookieException {
/*  66 */     String str1 = paramCookieOrigin.getHost();
/*  67 */     String str2 = paramCookie.getDomain();
/*  68 */     if (!str1.equals(str2) && !BasicDomainHandler.domainMatch(str2, str1)) {
/*  69 */       throw new CookieRestrictionViolationException("Illegal domain attribute \"" + str2 + "\". Domain of origin: \"" + str1 + "\"");
/*     */     }
/*     */     
/*  72 */     if (str1.contains(".")) {
/*  73 */       int i = (new StringTokenizer(str2, ".")).countTokens();
/*     */       
/*  75 */       if (isSpecialDomain(str2)) {
/*  76 */         if (i < 2) {
/*  77 */           throw new CookieRestrictionViolationException("Domain attribute \"" + str2 + "\" violates the Netscape cookie specification for " + "special domains");
/*     */ 
/*     */         
/*     */         }
/*     */       
/*     */       }
/*  83 */       else if (i < 3) {
/*  84 */         throw new CookieRestrictionViolationException("Domain attribute \"" + str2 + "\" violates the Netscape cookie specification");
/*     */       } 
/*     */     } 
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
/*     */   private static boolean isSpecialDomain(String paramString) {
/*  99 */     String str = paramString.toUpperCase(Locale.ROOT);
/* 100 */     return (str.endsWith(".COM") || str.endsWith(".EDU") || str.endsWith(".NET") || str.endsWith(".GOV") || str.endsWith(".MIL") || str.endsWith(".ORG") || str.endsWith(".INT"));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean match(Cookie paramCookie, CookieOrigin paramCookieOrigin) {
/* 111 */     Args.notNull(paramCookie, "Cookie");
/* 112 */     Args.notNull(paramCookieOrigin, "Cookie origin");
/* 113 */     String str1 = paramCookieOrigin.getHost();
/* 114 */     String str2 = paramCookie.getDomain();
/* 115 */     if (str2 == null) {
/* 116 */       return false;
/*     */     }
/* 118 */     return str1.endsWith(str2);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAttributeName() {
/* 123 */     return "domain";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\cookie\NetscapeDomainHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */