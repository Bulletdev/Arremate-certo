/*     */ package org.apache.http.impl.cookie;
/*     */ 
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
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class RFC2965VersionAttributeHandler
/*     */   implements CommonCookieAttributeHandler
/*     */ {
/*     */   public void parse(SetCookie paramSetCookie, String paramString) throws MalformedCookieException {
/*  60 */     Args.notNull(paramSetCookie, "Cookie");
/*  61 */     if (paramString == null) {
/*  62 */       throw new MalformedCookieException("Missing value for version attribute");
/*     */     }
/*     */     
/*  65 */     int i = -1;
/*     */     try {
/*  67 */       i = Integer.parseInt(paramString);
/*  68 */     } catch (NumberFormatException numberFormatException) {
/*  69 */       i = -1;
/*     */     } 
/*  71 */     if (i < 0) {
/*  72 */       throw new MalformedCookieException("Invalid cookie version.");
/*     */     }
/*  74 */     paramSetCookie.setVersion(i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void validate(Cookie paramCookie, CookieOrigin paramCookieOrigin) throws MalformedCookieException {
/*  83 */     Args.notNull(paramCookie, "Cookie");
/*  84 */     if (paramCookie instanceof org.apache.http.cookie.SetCookie2 && 
/*  85 */       paramCookie instanceof ClientCookie && !((ClientCookie)paramCookie).containsAttribute("version"))
/*     */     {
/*  87 */       throw new CookieRestrictionViolationException("Violates RFC 2965. Version attribute is required.");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean match(Cookie paramCookie, CookieOrigin paramCookieOrigin) {
/*  95 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAttributeName() {
/* 100 */     return "version";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\cookie\RFC2965VersionAttributeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */