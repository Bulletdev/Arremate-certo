/*     */ package org.apache.http.impl.cookie;
/*     */ 
/*     */ import java.util.Locale;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.cookie.CommonCookieAttributeHandler;
/*     */ import org.apache.http.cookie.Cookie;
/*     */ import org.apache.http.cookie.CookieOrigin;
/*     */ import org.apache.http.cookie.CookieRestrictionViolationException;
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
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class RFC2109DomainHandler
/*     */   implements CommonCookieAttributeHandler
/*     */ {
/*     */   public void parse(SetCookie paramSetCookie, String paramString) throws MalformedCookieException {
/*  56 */     Args.notNull(paramSetCookie, "Cookie");
/*  57 */     if (paramString == null) {
/*  58 */       throw new MalformedCookieException("Missing value for domain attribute");
/*     */     }
/*  60 */     if (paramString.trim().isEmpty()) {
/*  61 */       throw new MalformedCookieException("Blank value for domain attribute");
/*     */     }
/*  63 */     paramSetCookie.setDomain(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void validate(Cookie paramCookie, CookieOrigin paramCookieOrigin) throws MalformedCookieException {
/*  69 */     Args.notNull(paramCookie, "Cookie");
/*  70 */     Args.notNull(paramCookieOrigin, "Cookie origin");
/*  71 */     String str1 = paramCookieOrigin.getHost();
/*  72 */     String str2 = paramCookie.getDomain();
/*  73 */     if (str2 == null) {
/*  74 */       throw new CookieRestrictionViolationException("Cookie domain may not be null");
/*     */     }
/*  76 */     if (!str2.equals(str1)) {
/*  77 */       int i = str2.indexOf('.');
/*  78 */       if (i == -1) {
/*  79 */         throw new CookieRestrictionViolationException("Domain attribute \"" + str2 + "\" does not match the host \"" + str1 + "\"");
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  85 */       if (!str2.startsWith(".")) {
/*  86 */         throw new CookieRestrictionViolationException("Domain attribute \"" + str2 + "\" violates RFC 2109: domain must start with a dot");
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*  91 */       i = str2.indexOf('.', 1);
/*  92 */       if (i < 0 || i == str2.length() - 1) {
/*  93 */         throw new CookieRestrictionViolationException("Domain attribute \"" + str2 + "\" violates RFC 2109: domain must contain an embedded dot");
/*     */       }
/*     */ 
/*     */       
/*  97 */       str1 = str1.toLowerCase(Locale.ROOT);
/*  98 */       if (!str1.endsWith(str2)) {
/*  99 */         throw new CookieRestrictionViolationException("Illegal domain attribute \"" + str2 + "\". Domain of origin: \"" + str1 + "\"");
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 104 */       String str = str1.substring(0, str1.length() - str2.length());
/* 105 */       if (str.indexOf('.') != -1) {
/* 106 */         throw new CookieRestrictionViolationException("Domain attribute \"" + str2 + "\" violates RFC 2109: host minus domain may not contain any dots");
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean match(Cookie paramCookie, CookieOrigin paramCookieOrigin) {
/* 115 */     Args.notNull(paramCookie, "Cookie");
/* 116 */     Args.notNull(paramCookieOrigin, "Cookie origin");
/* 117 */     String str1 = paramCookieOrigin.getHost();
/* 118 */     String str2 = paramCookie.getDomain();
/* 119 */     if (str2 == null) {
/* 120 */       return false;
/*     */     }
/* 122 */     return (str1.equals(str2) || (str2.startsWith(".") && str1.endsWith(str2)));
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAttributeName() {
/* 127 */     return "domain";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\cookie\RFC2109DomainHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */