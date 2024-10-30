/*     */ package org.apache.http.impl.cookie;
/*     */ 
/*     */ import java.util.StringTokenizer;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.cookie.ClientCookie;
/*     */ import org.apache.http.cookie.CommonCookieAttributeHandler;
/*     */ import org.apache.http.cookie.Cookie;
/*     */ import org.apache.http.cookie.CookieOrigin;
/*     */ import org.apache.http.cookie.CookieRestrictionViolationException;
/*     */ import org.apache.http.cookie.MalformedCookieException;
/*     */ import org.apache.http.cookie.SetCookie;
/*     */ import org.apache.http.cookie.SetCookie2;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class RFC2965PortAttributeHandler
/*     */   implements CommonCookieAttributeHandler
/*     */ {
/*     */   private static int[] parsePortAttribute(String paramString) throws MalformedCookieException {
/*  67 */     StringTokenizer stringTokenizer = new StringTokenizer(paramString, ",");
/*  68 */     int[] arrayOfInt = new int[stringTokenizer.countTokens()];
/*     */     try {
/*  70 */       byte b = 0;
/*  71 */       while (stringTokenizer.hasMoreTokens()) {
/*  72 */         arrayOfInt[b] = Integer.parseInt(stringTokenizer.nextToken().trim());
/*  73 */         if (arrayOfInt[b] < 0) {
/*  74 */           throw new MalformedCookieException("Invalid Port attribute.");
/*     */         }
/*  76 */         b++;
/*     */       } 
/*  78 */     } catch (NumberFormatException numberFormatException) {
/*  79 */       throw new MalformedCookieException("Invalid Port attribute: " + numberFormatException.getMessage());
/*     */     } 
/*     */     
/*  82 */     return arrayOfInt;
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
/*     */   private static boolean portMatch(int paramInt, int[] paramArrayOfint) {
/*  95 */     boolean bool = false;
/*  96 */     for (int i : paramArrayOfint) {
/*  97 */       if (paramInt == i) {
/*  98 */         bool = true;
/*     */         break;
/*     */       } 
/*     */     } 
/* 102 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void parse(SetCookie paramSetCookie, String paramString) throws MalformedCookieException {
/* 111 */     Args.notNull(paramSetCookie, "Cookie");
/* 112 */     if (paramSetCookie instanceof SetCookie2) {
/* 113 */       SetCookie2 setCookie2 = (SetCookie2)paramSetCookie;
/* 114 */       if (paramString != null && !paramString.trim().isEmpty()) {
/* 115 */         int[] arrayOfInt = parsePortAttribute(paramString);
/* 116 */         setCookie2.setPorts(arrayOfInt);
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
/*     */   public void validate(Cookie paramCookie, CookieOrigin paramCookieOrigin) throws MalformedCookieException {
/* 128 */     Args.notNull(paramCookie, "Cookie");
/* 129 */     Args.notNull(paramCookieOrigin, "Cookie origin");
/* 130 */     int i = paramCookieOrigin.getPort();
/* 131 */     if (paramCookie instanceof ClientCookie && ((ClientCookie)paramCookie).containsAttribute("port"))
/*     */     {
/* 133 */       if (!portMatch(i, paramCookie.getPorts())) {
/* 134 */         throw new CookieRestrictionViolationException("Port attribute violates RFC 2965: Request port not found in cookie's port list.");
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
/*     */   public boolean match(Cookie paramCookie, CookieOrigin paramCookieOrigin) {
/* 148 */     Args.notNull(paramCookie, "Cookie");
/* 149 */     Args.notNull(paramCookieOrigin, "Cookie origin");
/* 150 */     int i = paramCookieOrigin.getPort();
/* 151 */     if (paramCookie instanceof ClientCookie && ((ClientCookie)paramCookie).containsAttribute("port")) {
/*     */       
/* 153 */       if (paramCookie.getPorts() == null)
/*     */       {
/* 155 */         return false;
/*     */       }
/* 157 */       if (!portMatch(i, paramCookie.getPorts())) {
/* 158 */         return false;
/*     */       }
/*     */     } 
/* 161 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAttributeName() {
/* 166 */     return "port";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\cookie\RFC2965PortAttributeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */