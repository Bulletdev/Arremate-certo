/*     */ package org.apache.http.impl.auth;
/*     */ 
/*     */ import java.nio.charset.Charset;
/*     */ import org.apache.commons.codec.binary.Base64;
/*     */ import org.apache.http.Consts;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.auth.AuthenticationException;
/*     */ import org.apache.http.auth.ChallengeState;
/*     */ import org.apache.http.auth.Credentials;
/*     */ import org.apache.http.auth.MalformedChallengeException;
/*     */ import org.apache.http.message.BufferedHeader;
/*     */ import org.apache.http.protocol.BasicHttpContext;
/*     */ import org.apache.http.protocol.HttpContext;
/*     */ import org.apache.http.util.Args;
/*     */ import org.apache.http.util.CharArrayBuffer;
/*     */ import org.apache.http.util.EncodingUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BasicScheme
/*     */   extends RFC2617Scheme
/*     */ {
/*     */   private static final long serialVersionUID = -1931571557597830536L;
/*     */   private boolean complete;
/*     */   
/*     */   public BasicScheme(Charset paramCharset) {
/*  63 */     super(paramCharset);
/*  64 */     this.complete = false;
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
/*     */   @Deprecated
/*     */   public BasicScheme(ChallengeState paramChallengeState) {
/*  77 */     super(paramChallengeState);
/*     */   }
/*     */   
/*     */   public BasicScheme() {
/*  81 */     this(Consts.ASCII);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSchemeName() {
/*  91 */     return "basic";
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
/*     */   public void processChallenge(Header paramHeader) throws MalformedChallengeException {
/* 105 */     super.processChallenge(paramHeader);
/* 106 */     this.complete = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isComplete() {
/* 117 */     return this.complete;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isConnectionBased() {
/* 127 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public Header authenticate(Credentials paramCredentials, HttpRequest paramHttpRequest) throws AuthenticationException {
/* 138 */     return authenticate(paramCredentials, paramHttpRequest, (HttpContext)new BasicHttpContext());
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
/*     */   
/*     */   public Header authenticate(Credentials paramCredentials, HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws AuthenticationException {
/* 159 */     Args.notNull(paramCredentials, "Credentials");
/* 160 */     Args.notNull(paramHttpRequest, "HTTP request");
/* 161 */     StringBuilder stringBuilder = new StringBuilder();
/* 162 */     stringBuilder.append(paramCredentials.getUserPrincipal().getName());
/* 163 */     stringBuilder.append(":");
/* 164 */     stringBuilder.append((paramCredentials.getPassword() == null) ? "null" : paramCredentials.getPassword());
/*     */     
/* 166 */     Base64 base64 = new Base64(0);
/* 167 */     byte[] arrayOfByte = base64.encode(EncodingUtils.getBytes(stringBuilder.toString(), getCredentialsCharset(paramHttpRequest)));
/*     */ 
/*     */     
/* 170 */     CharArrayBuffer charArrayBuffer = new CharArrayBuffer(32);
/* 171 */     if (isProxy()) {
/* 172 */       charArrayBuffer.append("Proxy-Authorization");
/*     */     } else {
/* 174 */       charArrayBuffer.append("Authorization");
/*     */     } 
/* 176 */     charArrayBuffer.append(": Basic ");
/* 177 */     charArrayBuffer.append(arrayOfByte, 0, arrayOfByte.length);
/*     */     
/* 179 */     return (Header)new BufferedHeader(charArrayBuffer);
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
/*     */   @Deprecated
/*     */   public static Header authenticate(Credentials paramCredentials, String paramString, boolean paramBoolean) {
/* 198 */     Args.notNull(paramCredentials, "Credentials");
/* 199 */     Args.notNull(paramString, "charset");
/*     */     
/* 201 */     StringBuilder stringBuilder = new StringBuilder();
/* 202 */     stringBuilder.append(paramCredentials.getUserPrincipal().getName());
/* 203 */     stringBuilder.append(":");
/* 204 */     stringBuilder.append((paramCredentials.getPassword() == null) ? "null" : paramCredentials.getPassword());
/*     */     
/* 206 */     byte[] arrayOfByte = Base64.encodeBase64(EncodingUtils.getBytes(stringBuilder.toString(), paramString), false);
/*     */ 
/*     */     
/* 209 */     CharArrayBuffer charArrayBuffer = new CharArrayBuffer(32);
/* 210 */     if (paramBoolean) {
/* 211 */       charArrayBuffer.append("Proxy-Authorization");
/*     */     } else {
/* 213 */       charArrayBuffer.append("Authorization");
/*     */     } 
/* 215 */     charArrayBuffer.append(": Basic ");
/* 216 */     charArrayBuffer.append(arrayOfByte, 0, arrayOfByte.length);
/*     */     
/* 218 */     return (Header)new BufferedHeader(charArrayBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 223 */     StringBuilder stringBuilder = new StringBuilder();
/* 224 */     stringBuilder.append("BASIC [complete=").append(this.complete).append("]");
/*     */     
/* 226 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\auth\BasicScheme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */