/*     */ package org.apache.http.impl.cookie;
/*     */ 
/*     */ import java.util.Locale;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.conn.util.InetAddressUtils;
/*     */ import org.apache.http.cookie.ClientCookie;
/*     */ import org.apache.http.cookie.CommonCookieAttributeHandler;
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
/*     */ public class BasicDomainHandler
/*     */   implements CommonCookieAttributeHandler
/*     */ {
/*     */   public void parse(SetCookie paramSetCookie, String paramString) throws MalformedCookieException {
/*  58 */     Args.notNull(paramSetCookie, "Cookie");
/*  59 */     if (TextUtils.isBlank(paramString)) {
/*  60 */       throw new MalformedCookieException("Blank or null value for domain attribute");
/*     */     }
/*     */     
/*  63 */     if (paramString.endsWith(".")) {
/*     */       return;
/*     */     }
/*  66 */     String str = paramString;
/*  67 */     if (str.startsWith(".")) {
/*  68 */       str = str.substring(1);
/*     */     }
/*  70 */     str = str.toLowerCase(Locale.ROOT);
/*  71 */     paramSetCookie.setDomain(str);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void validate(Cookie paramCookie, CookieOrigin paramCookieOrigin) throws MalformedCookieException {
/*  77 */     Args.notNull(paramCookie, "Cookie");
/*  78 */     Args.notNull(paramCookieOrigin, "Cookie origin");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  84 */     String str1 = paramCookieOrigin.getHost();
/*  85 */     String str2 = paramCookie.getDomain();
/*  86 */     if (str2 == null) {
/*  87 */       throw new CookieRestrictionViolationException("Cookie 'domain' may not be null");
/*     */     }
/*  89 */     if (!str1.equals(str2) && !domainMatch(str2, str1)) {
/*  90 */       throw new CookieRestrictionViolationException("Illegal 'domain' attribute \"" + str2 + "\". Domain of origin: \"" + str1 + "\"");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static boolean domainMatch(String paramString1, String paramString2) {
/*  96 */     if (InetAddressUtils.isIPv4Address(paramString2) || InetAddressUtils.isIPv6Address(paramString2)) {
/*  97 */       return false;
/*     */     }
/*  99 */     String str = paramString1.startsWith(".") ? paramString1.substring(1) : paramString1;
/* 100 */     if (paramString2.endsWith(str)) {
/* 101 */       int i = paramString2.length() - str.length();
/*     */       
/* 103 */       if (i == 0) {
/* 104 */         return true;
/*     */       }
/* 106 */       if (i > 1 && paramString2.charAt(i - 1) == '.') {
/* 107 */         return true;
/*     */       }
/*     */     } 
/* 110 */     return false;
/*     */   }
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
/* 122 */     if (str2.startsWith(".")) {
/* 123 */       str2 = str2.substring(1);
/*     */     }
/* 125 */     str2 = str2.toLowerCase(Locale.ROOT);
/* 126 */     if (str1.equals(str2)) {
/* 127 */       return true;
/*     */     }
/* 129 */     if (paramCookie instanceof ClientCookie && (
/* 130 */       (ClientCookie)paramCookie).containsAttribute("domain")) {
/* 131 */       return domainMatch(str2, str1);
/*     */     }
/*     */     
/* 134 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAttributeName() {
/* 139 */     return "domain";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\cookie\BasicDomainHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */