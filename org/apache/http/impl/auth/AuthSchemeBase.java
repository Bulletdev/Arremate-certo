/*     */ package org.apache.http.impl.auth;
/*     */ 
/*     */ import java.util.Locale;
/*     */ import org.apache.http.FormattedHeader;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.auth.AuthenticationException;
/*     */ import org.apache.http.auth.ChallengeState;
/*     */ import org.apache.http.auth.ContextAwareAuthScheme;
/*     */ import org.apache.http.auth.Credentials;
/*     */ import org.apache.http.auth.MalformedChallengeException;
/*     */ import org.apache.http.protocol.HTTP;
/*     */ import org.apache.http.protocol.HttpContext;
/*     */ import org.apache.http.util.Args;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AuthSchemeBase
/*     */   implements ContextAwareAuthScheme
/*     */ {
/*     */   protected ChallengeState challengeState;
/*     */   
/*     */   @Deprecated
/*     */   public AuthSchemeBase(ChallengeState paramChallengeState) {
/*  70 */     this.challengeState = paramChallengeState;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AuthSchemeBase() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void processChallenge(Header paramHeader) throws MalformedChallengeException {
/*     */     CharArrayBuffer charArrayBuffer;
/*     */     byte b1;
/*  89 */     Args.notNull(paramHeader, "Header");
/*  90 */     String str1 = paramHeader.getName();
/*  91 */     if (str1.equalsIgnoreCase("WWW-Authenticate")) {
/*  92 */       this.challengeState = ChallengeState.TARGET;
/*  93 */     } else if (str1.equalsIgnoreCase("Proxy-Authenticate")) {
/*  94 */       this.challengeState = ChallengeState.PROXY;
/*     */     } else {
/*  96 */       throw new MalformedChallengeException("Unexpected header name: " + str1);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 101 */     if (paramHeader instanceof FormattedHeader) {
/* 102 */       charArrayBuffer = ((FormattedHeader)paramHeader).getBuffer();
/* 103 */       b1 = ((FormattedHeader)paramHeader).getValuePos();
/*     */     } else {
/* 105 */       String str = paramHeader.getValue();
/* 106 */       if (str == null) {
/* 107 */         throw new MalformedChallengeException("Header value is null");
/*     */       }
/* 109 */       charArrayBuffer = new CharArrayBuffer(str.length());
/* 110 */       charArrayBuffer.append(str);
/* 111 */       b1 = 0;
/*     */     } 
/* 113 */     while (b1 < charArrayBuffer.length() && HTTP.isWhitespace(charArrayBuffer.charAt(b1))) {
/* 114 */       b1++;
/*     */     }
/* 116 */     byte b2 = b1;
/* 117 */     while (b1 < charArrayBuffer.length() && !HTTP.isWhitespace(charArrayBuffer.charAt(b1))) {
/* 118 */       b1++;
/*     */     }
/* 120 */     byte b3 = b1;
/* 121 */     String str2 = charArrayBuffer.substring(b2, b3);
/* 122 */     if (!str2.equalsIgnoreCase(getSchemeName())) {
/* 123 */       throw new MalformedChallengeException("Invalid scheme identifier: " + str2);
/*     */     }
/*     */     
/* 126 */     parseChallenge(charArrayBuffer, b1, charArrayBuffer.length());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Header authenticate(Credentials paramCredentials, HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws AuthenticationException {
/* 136 */     return authenticate(paramCredentials, paramHttpRequest);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void parseChallenge(CharArrayBuffer paramCharArrayBuffer, int paramInt1, int paramInt2) throws MalformedChallengeException;
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isProxy() {
/* 147 */     return (this.challengeState != null && this.challengeState == ChallengeState.PROXY);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ChallengeState getChallengeState() {
/* 156 */     return this.challengeState;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 161 */     String str = getSchemeName();
/* 162 */     return (str != null) ? str.toUpperCase(Locale.ROOT) : super.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\auth\AuthSchemeBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */