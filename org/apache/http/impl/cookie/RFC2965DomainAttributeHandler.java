/*     */ package org.apache.http.impl.cookie;
/*     */ 
/*     */ import java.util.Locale;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.cookie.ClientCookie;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class RFC2965DomainAttributeHandler
/*     */   implements CommonCookieAttributeHandler
/*     */ {
/*     */   public void parse(SetCookie paramSetCookie, String paramString) throws MalformedCookieException {
/*  62 */     Args.notNull(paramSetCookie, "Cookie");
/*  63 */     if (paramString == null) {
/*  64 */       throw new MalformedCookieException("Missing value for domain attribute");
/*     */     }
/*     */     
/*  67 */     if (paramString.trim().isEmpty()) {
/*  68 */       throw new MalformedCookieException("Blank value for domain attribute");
/*     */     }
/*     */     
/*  71 */     String str = paramString;
/*  72 */     str = str.toLowerCase(Locale.ROOT);
/*  73 */     if (!paramString.startsWith("."))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  79 */       str = '.' + str;
/*     */     }
/*  81 */     paramSetCookie.setDomain(str);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean domainMatch(String paramString1, String paramString2) {
/* 101 */     return (paramString1.equals(paramString2) || (paramString2.startsWith(".") && paramString1.endsWith(paramString2)));
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
/*     */   public void validate(Cookie paramCookie, CookieOrigin paramCookieOrigin) throws MalformedCookieException {
/* 113 */     Args.notNull(paramCookie, "Cookie");
/* 114 */     Args.notNull(paramCookieOrigin, "Cookie origin");
/* 115 */     String str1 = paramCookieOrigin.getHost().toLowerCase(Locale.ROOT);
/* 116 */     if (paramCookie.getDomain() == null) {
/* 117 */       throw new CookieRestrictionViolationException("Invalid cookie state: domain not specified");
/*     */     }
/*     */     
/* 120 */     String str2 = paramCookie.getDomain().toLowerCase(Locale.ROOT);
/*     */     
/* 122 */     if (paramCookie instanceof ClientCookie && ((ClientCookie)paramCookie).containsAttribute("domain")) {
/*     */ 
/*     */       
/* 125 */       if (!str2.startsWith(".")) {
/* 126 */         throw new CookieRestrictionViolationException("Domain attribute \"" + paramCookie.getDomain() + "\" violates RFC 2109: domain must start with a dot");
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 132 */       int i = str2.indexOf('.', 1);
/* 133 */       if ((i < 0 || i == str2.length() - 1) && !str2.equals(".local"))
/*     */       {
/* 135 */         throw new CookieRestrictionViolationException("Domain attribute \"" + paramCookie.getDomain() + "\" violates RFC 2965: the value contains no embedded dots " + "and the value is not .local");
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 142 */       if (!domainMatch(str1, str2)) {
/* 143 */         throw new CookieRestrictionViolationException("Domain attribute \"" + paramCookie.getDomain() + "\" violates RFC 2965: effective host name does not " + "domain-match domain attribute.");
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 150 */       String str = str1.substring(0, str1.length() - str2.length());
/*     */       
/* 152 */       if (str.indexOf('.') != -1) {
/* 153 */         throw new CookieRestrictionViolationException("Domain attribute \"" + paramCookie.getDomain() + "\" violates RFC 2965: " + "effective host minus domain may not contain any dots");
/*     */ 
/*     */       
/*     */       }
/*     */ 
/*     */     
/*     */     }
/* 160 */     else if (!paramCookie.getDomain().equals(str1)) {
/* 161 */       throw new CookieRestrictionViolationException("Illegal domain attribute: \"" + paramCookie.getDomain() + "\"." + "Domain of origin: \"" + str1 + "\"");
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
/*     */   public boolean match(Cookie paramCookie, CookieOrigin paramCookieOrigin) {
/* 174 */     Args.notNull(paramCookie, "Cookie");
/* 175 */     Args.notNull(paramCookieOrigin, "Cookie origin");
/* 176 */     String str1 = paramCookieOrigin.getHost().toLowerCase(Locale.ROOT);
/* 177 */     String str2 = paramCookie.getDomain();
/*     */ 
/*     */ 
/*     */     
/* 181 */     if (!domainMatch(str1, str2)) {
/* 182 */       return false;
/*     */     }
/*     */     
/* 185 */     String str3 = str1.substring(0, str1.length() - str2.length());
/*     */     
/* 187 */     return (str3.indexOf('.') == -1);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAttributeName() {
/* 192 */     return "domain";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\cookie\RFC2965DomainAttributeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */