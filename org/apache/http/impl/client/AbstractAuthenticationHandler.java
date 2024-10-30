/*     */ package org.apache.http.impl.client;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.FormattedHeader;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.auth.AuthScheme;
/*     */ import org.apache.http.auth.AuthSchemeRegistry;
/*     */ import org.apache.http.auth.AuthenticationException;
/*     */ import org.apache.http.auth.MalformedChallengeException;
/*     */ import org.apache.http.client.AuthenticationHandler;
/*     */ import org.apache.http.protocol.HTTP;
/*     */ import org.apache.http.protocol.HttpContext;
/*     */ import org.apache.http.util.Asserts;
/*     */ import org.apache.http.util.CharArrayBuffer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public abstract class AbstractAuthenticationHandler
/*     */   implements AuthenticationHandler
/*     */ {
/*  68 */   private final Log log = LogFactory.getLog(getClass());
/*     */   
/*  70 */   private static final List<String> DEFAULT_SCHEME_PRIORITY = Collections.unmodifiableList(Arrays.asList(new String[] { "Negotiate", "NTLM", "Digest", "Basic" }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Map<String, Header> parseChallenges(Header[] paramArrayOfHeader) throws MalformedChallengeException {
/*  84 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>(paramArrayOfHeader.length);
/*  85 */     for (Header header : paramArrayOfHeader) {
/*     */       CharArrayBuffer charArrayBuffer;
/*     */       byte b1;
/*  88 */       if (header instanceof FormattedHeader) {
/*  89 */         charArrayBuffer = ((FormattedHeader)header).getBuffer();
/*  90 */         b1 = ((FormattedHeader)header).getValuePos();
/*     */       } else {
/*  92 */         String str1 = header.getValue();
/*  93 */         if (str1 == null) {
/*  94 */           throw new MalformedChallengeException("Header value is null");
/*     */         }
/*  96 */         charArrayBuffer = new CharArrayBuffer(str1.length());
/*  97 */         charArrayBuffer.append(str1);
/*  98 */         b1 = 0;
/*     */       } 
/* 100 */       while (b1 < charArrayBuffer.length() && HTTP.isWhitespace(charArrayBuffer.charAt(b1))) {
/* 101 */         b1++;
/*     */       }
/* 103 */       byte b2 = b1;
/* 104 */       while (b1 < charArrayBuffer.length() && !HTTP.isWhitespace(charArrayBuffer.charAt(b1))) {
/* 105 */         b1++;
/*     */       }
/* 107 */       byte b3 = b1;
/* 108 */       String str = charArrayBuffer.substring(b2, b3);
/* 109 */       hashMap.put(str.toLowerCase(Locale.ROOT), header);
/*     */     } 
/* 111 */     return (Map)hashMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<String> getAuthPreferences() {
/* 120 */     return DEFAULT_SCHEME_PRIORITY;
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
/*     */   protected List<String> getAuthPreferences(HttpResponse paramHttpResponse, HttpContext paramHttpContext) {
/* 135 */     return getAuthPreferences();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AuthScheme selectScheme(Map<String, Header> paramMap, HttpResponse paramHttpResponse, HttpContext paramHttpContext) throws AuthenticationException {
/* 144 */     AuthSchemeRegistry authSchemeRegistry = (AuthSchemeRegistry)paramHttpContext.getAttribute("http.authscheme-registry");
/*     */     
/* 146 */     Asserts.notNull(authSchemeRegistry, "AuthScheme registry");
/* 147 */     List<String> list = getAuthPreferences(paramHttpResponse, paramHttpContext);
/* 148 */     if (list == null) {
/* 149 */       list = DEFAULT_SCHEME_PRIORITY;
/*     */     }
/*     */     
/* 152 */     if (this.log.isDebugEnabled()) {
/* 153 */       this.log.debug("Authentication schemes in the order of preference: " + list);
/*     */     }
/*     */ 
/*     */     
/* 157 */     AuthScheme authScheme = null;
/* 158 */     for (String str : list) {
/* 159 */       Header header = paramMap.get(str.toLowerCase(Locale.ENGLISH));
/*     */       
/* 161 */       if (header != null) {
/* 162 */         if (this.log.isDebugEnabled()) {
/* 163 */           this.log.debug(str + " authentication scheme selected");
/*     */         }
/*     */         try {
/* 166 */           authScheme = authSchemeRegistry.getAuthScheme(str, paramHttpResponse.getParams());
/*     */           break;
/* 168 */         } catch (IllegalStateException illegalStateException) {
/* 169 */           if (this.log.isWarnEnabled()) {
/* 170 */             this.log.warn("Authentication scheme " + str + " not supported");
/*     */           }
/*     */           continue;
/*     */         } 
/*     */       } 
/* 175 */       if (this.log.isDebugEnabled()) {
/* 176 */         this.log.debug("Challenge for " + str + " authentication scheme not available");
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 181 */     if (authScheme == null)
/*     */     {
/* 183 */       throw new AuthenticationException("Unable to respond to any of these challenges: " + paramMap);
/*     */     }
/*     */ 
/*     */     
/* 187 */     return authScheme;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\AbstractAuthenticationHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */