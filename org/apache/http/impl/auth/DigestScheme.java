/*     */ package org.apache.http.impl.auth;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.charset.Charset;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.SecureRandom;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Formatter;
/*     */ import java.util.HashSet;
/*     */ import java.util.Locale;
/*     */ import java.util.StringTokenizer;
/*     */ import org.apache.http.Consts;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.HttpEntityEnclosingRequest;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.apache.http.auth.AuthenticationException;
/*     */ import org.apache.http.auth.ChallengeState;
/*     */ import org.apache.http.auth.Credentials;
/*     */ import org.apache.http.auth.MalformedChallengeException;
/*     */ import org.apache.http.message.BasicHeaderValueFormatter;
/*     */ import org.apache.http.message.BasicNameValuePair;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DigestScheme
/*     */   extends RFC2617Scheme
/*     */ {
/*     */   private static final long serialVersionUID = 3883908186234566916L;
/*  84 */   private static final char[] HEXADECIMAL = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
/*     */   
/*     */   private boolean complete;
/*     */   
/*     */   private static final int QOP_UNKNOWN = -1;
/*     */   
/*     */   private static final int QOP_MISSING = 0;
/*     */   
/*     */   private static final int QOP_AUTH_INT = 1;
/*     */   
/*     */   private static final int QOP_AUTH = 2;
/*     */   
/*     */   private String lastNonce;
/*     */   
/*     */   private long nounceCount;
/*     */   
/*     */   private String cnonce;
/*     */   
/*     */   private String a1;
/*     */   
/*     */   private String a2;
/*     */   
/*     */   public DigestScheme(Charset paramCharset) {
/* 107 */     super(paramCharset);
/* 108 */     this.complete = false;
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
/*     */   public DigestScheme(ChallengeState paramChallengeState) {
/* 121 */     super(paramChallengeState);
/*     */   }
/*     */   
/*     */   public DigestScheme() {
/* 125 */     this(Consts.ASCII);
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
/* 139 */     super.processChallenge(paramHeader);
/* 140 */     this.complete = true;
/* 141 */     if (getParameters().isEmpty()) {
/* 142 */       throw new MalformedChallengeException("Authentication challenge is empty");
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
/*     */   public boolean isComplete() {
/* 154 */     String str = getParameter("stale");
/* 155 */     return "true".equalsIgnoreCase(str) ? false : this.complete;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSchemeName() {
/* 165 */     return "digest";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isConnectionBased() {
/* 175 */     return false;
/*     */   }
/*     */   
/*     */   public void overrideParamter(String paramString1, String paramString2) {
/* 179 */     getParameters().put(paramString1, paramString2);
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
/* 190 */     return authenticate(paramCredentials, paramHttpRequest, (HttpContext)new BasicHttpContext());
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
/*     */ 
/*     */   
/*     */   public Header authenticate(Credentials paramCredentials, HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws AuthenticationException {
/* 213 */     Args.notNull(paramCredentials, "Credentials");
/* 214 */     Args.notNull(paramHttpRequest, "HTTP request");
/* 215 */     if (getParameter("realm") == null) {
/* 216 */       throw new AuthenticationException("missing realm in challenge");
/*     */     }
/* 218 */     if (getParameter("nonce") == null) {
/* 219 */       throw new AuthenticationException("missing nonce in challenge");
/*     */     }
/*     */     
/* 222 */     getParameters().put("methodname", paramHttpRequest.getRequestLine().getMethod());
/* 223 */     getParameters().put("uri", paramHttpRequest.getRequestLine().getUri());
/* 224 */     String str = getParameter("charset");
/* 225 */     if (str == null) {
/* 226 */       getParameters().put("charset", getCredentialsCharset(paramHttpRequest));
/*     */     }
/* 228 */     return createDigestHeader(paramCredentials, paramHttpRequest);
/*     */   }
/*     */ 
/*     */   
/*     */   private static MessageDigest createMessageDigest(String paramString) throws UnsupportedDigestAlgorithmException {
/*     */     try {
/* 234 */       return MessageDigest.getInstance(paramString);
/* 235 */     } catch (Exception exception) {
/* 236 */       throw new UnsupportedDigestAlgorithmException("Unsupported algorithm in HTTP Digest authentication: " + paramString);
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
/*     */   
/*     */   private Header createDigestHeader(Credentials paramCredentials, HttpRequest paramHttpRequest) throws AuthenticationException {
/*     */     MessageDigest messageDigest;
/* 252 */     String str15, str1 = getParameter("uri");
/* 253 */     String str2 = getParameter("realm");
/* 254 */     String str3 = getParameter("nonce");
/* 255 */     String str4 = getParameter("opaque");
/* 256 */     String str5 = getParameter("methodname");
/* 257 */     String str6 = getParameter("algorithm");
/*     */     
/* 259 */     if (str6 == null) {
/* 260 */       str6 = "MD5";
/*     */     }
/*     */     
/* 263 */     HashSet<String> hashSet = new HashSet(8);
/* 264 */     byte b = -1;
/* 265 */     String str7 = getParameter("qop");
/* 266 */     if (str7 != null) {
/* 267 */       StringTokenizer stringTokenizer = new StringTokenizer(str7, ",");
/* 268 */       while (stringTokenizer.hasMoreTokens()) {
/* 269 */         String str = stringTokenizer.nextToken().trim();
/* 270 */         hashSet.add(str.toLowerCase(Locale.ROOT));
/*     */       } 
/* 272 */       if (paramHttpRequest instanceof HttpEntityEnclosingRequest && hashSet.contains("auth-int")) {
/* 273 */         b = 1;
/* 274 */       } else if (hashSet.contains("auth")) {
/* 275 */         b = 2;
/*     */       } 
/*     */     } else {
/* 278 */       b = 0;
/*     */     } 
/*     */     
/* 281 */     if (b == -1) {
/* 282 */       throw new AuthenticationException("None of the qop methods is supported: " + str7);
/*     */     }
/*     */     
/* 285 */     String str8 = getParameter("charset");
/* 286 */     if (str8 == null) {
/* 287 */       str8 = "ISO-8859-1";
/*     */     }
/*     */     
/* 290 */     String str9 = str6;
/* 291 */     if (str9.equalsIgnoreCase("MD5-sess")) {
/* 292 */       str9 = "MD5";
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 297 */       messageDigest = createMessageDigest(str9);
/* 298 */     } catch (UnsupportedDigestAlgorithmException unsupportedDigestAlgorithmException) {
/* 299 */       throw new AuthenticationException("Unsuppported digest algorithm: " + str9);
/*     */     } 
/*     */     
/* 302 */     String str10 = paramCredentials.getUserPrincipal().getName();
/* 303 */     String str11 = paramCredentials.getPassword();
/*     */     
/* 305 */     if (str3.equals(this.lastNonce)) {
/* 306 */       this.nounceCount++;
/*     */     } else {
/* 308 */       this.nounceCount = 1L;
/* 309 */       this.cnonce = null;
/* 310 */       this.lastNonce = str3;
/*     */     } 
/* 312 */     StringBuilder stringBuilder = new StringBuilder(256);
/* 313 */     Formatter formatter = new Formatter(stringBuilder, Locale.US);
/* 314 */     formatter.format("%08x", new Object[] { Long.valueOf(this.nounceCount) });
/* 315 */     formatter.close();
/* 316 */     String str12 = stringBuilder.toString();
/*     */     
/* 318 */     if (this.cnonce == null) {
/* 319 */       this.cnonce = createCnonce();
/*     */     }
/*     */     
/* 322 */     this.a1 = null;
/* 323 */     this.a2 = null;
/*     */     
/* 325 */     if (str6.equalsIgnoreCase("MD5-sess")) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 331 */       stringBuilder.setLength(0);
/* 332 */       stringBuilder.append(str10).append(':').append(str2).append(':').append(str11);
/* 333 */       String str = encode(messageDigest.digest(EncodingUtils.getBytes(stringBuilder.toString(), str8)));
/* 334 */       stringBuilder.setLength(0);
/* 335 */       stringBuilder.append(str).append(':').append(str3).append(':').append(this.cnonce);
/* 336 */       this.a1 = stringBuilder.toString();
/*     */     } else {
/*     */       
/* 339 */       stringBuilder.setLength(0);
/* 340 */       stringBuilder.append(str10).append(':').append(str2).append(':').append(str11);
/* 341 */       this.a1 = stringBuilder.toString();
/*     */     } 
/*     */     
/* 344 */     String str13 = encode(messageDigest.digest(EncodingUtils.getBytes(this.a1, str8)));
/*     */     
/* 346 */     if (b == 2) {
/*     */       
/* 348 */       this.a2 = str5 + ':' + str1;
/* 349 */     } else if (b == 1) {
/*     */       
/* 351 */       HttpEntity httpEntity = null;
/* 352 */       if (paramHttpRequest instanceof HttpEntityEnclosingRequest) {
/* 353 */         httpEntity = ((HttpEntityEnclosingRequest)paramHttpRequest).getEntity();
/*     */       }
/* 355 */       if (httpEntity != null && !httpEntity.isRepeatable()) {
/*     */         
/* 357 */         if (hashSet.contains("auth")) {
/* 358 */           b = 2;
/* 359 */           this.a2 = str5 + ':' + str1;
/*     */         } else {
/* 361 */           throw new AuthenticationException("Qop auth-int cannot be used with a non-repeatable entity");
/*     */         } 
/*     */       } else {
/*     */         
/* 365 */         HttpEntityDigester httpEntityDigester = new HttpEntityDigester(messageDigest);
/*     */         try {
/* 367 */           if (httpEntity != null) {
/* 368 */             httpEntity.writeTo(httpEntityDigester);
/*     */           }
/* 370 */           httpEntityDigester.close();
/* 371 */         } catch (IOException iOException) {
/* 372 */           throw new AuthenticationException("I/O error reading entity content", iOException);
/*     */         } 
/* 374 */         this.a2 = str5 + ':' + str1 + ':' + encode(httpEntityDigester.getDigest());
/*     */       } 
/*     */     } else {
/* 377 */       this.a2 = str5 + ':' + str1;
/*     */     } 
/*     */     
/* 380 */     String str14 = encode(messageDigest.digest(EncodingUtils.getBytes(this.a2, str8)));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 385 */     if (b == 0) {
/* 386 */       stringBuilder.setLength(0);
/* 387 */       stringBuilder.append(str13).append(':').append(str3).append(':').append(str14);
/* 388 */       str15 = stringBuilder.toString();
/*     */     } else {
/* 390 */       stringBuilder.setLength(0);
/* 391 */       stringBuilder.append(str13).append(':').append(str3).append(':').append(str12).append(':').append(this.cnonce).append(':').append((b == 1) ? "auth-int" : "auth").append(':').append(str14);
/*     */ 
/*     */       
/* 394 */       str15 = stringBuilder.toString();
/*     */     } 
/*     */     
/* 397 */     String str16 = encode(messageDigest.digest(EncodingUtils.getAsciiBytes(str15)));
/*     */     
/* 399 */     CharArrayBuffer charArrayBuffer = new CharArrayBuffer(128);
/* 400 */     if (isProxy()) {
/* 401 */       charArrayBuffer.append("Proxy-Authorization");
/*     */     } else {
/* 403 */       charArrayBuffer.append("Authorization");
/*     */     } 
/* 405 */     charArrayBuffer.append(": Digest ");
/*     */     
/* 407 */     ArrayList<BasicNameValuePair> arrayList = new ArrayList(20);
/* 408 */     arrayList.add(new BasicNameValuePair("username", str10));
/* 409 */     arrayList.add(new BasicNameValuePair("realm", str2));
/* 410 */     arrayList.add(new BasicNameValuePair("nonce", str3));
/* 411 */     arrayList.add(new BasicNameValuePair("uri", str1));
/* 412 */     arrayList.add(new BasicNameValuePair("response", str16));
/*     */     
/* 414 */     if (b != 0) {
/* 415 */       arrayList.add(new BasicNameValuePair("qop", (b == 1) ? "auth-int" : "auth"));
/* 416 */       arrayList.add(new BasicNameValuePair("nc", str12));
/* 417 */       arrayList.add(new BasicNameValuePair("cnonce", this.cnonce));
/*     */     } 
/*     */     
/* 420 */     arrayList.add(new BasicNameValuePair("algorithm", str6));
/* 421 */     if (str4 != null) {
/* 422 */       arrayList.add(new BasicNameValuePair("opaque", str4));
/*     */     }
/*     */     
/* 425 */     for (byte b1 = 0; b1 < arrayList.size(); b1++) {
/* 426 */       BasicNameValuePair basicNameValuePair = arrayList.get(b1);
/* 427 */       if (b1 > 0) {
/* 428 */         charArrayBuffer.append(", ");
/*     */       }
/* 430 */       String str = basicNameValuePair.getName();
/* 431 */       boolean bool = ("nc".equals(str) || "qop".equals(str) || "algorithm".equals(str)) ? true : false;
/*     */       
/* 433 */       BasicHeaderValueFormatter.INSTANCE.formatNameValuePair(charArrayBuffer, (NameValuePair)basicNameValuePair, !bool);
/*     */     } 
/* 435 */     return (Header)new BufferedHeader(charArrayBuffer);
/*     */   }
/*     */   
/*     */   String getCnonce() {
/* 439 */     return this.cnonce;
/*     */   }
/*     */   
/*     */   String getA1() {
/* 443 */     return this.a1;
/*     */   }
/*     */   
/*     */   String getA2() {
/* 447 */     return this.a2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static String encode(byte[] paramArrayOfbyte) {
/* 458 */     int i = paramArrayOfbyte.length;
/* 459 */     char[] arrayOfChar = new char[i * 2];
/* 460 */     for (byte b = 0; b < i; b++) {
/* 461 */       int j = paramArrayOfbyte[b] & 0xF;
/* 462 */       int k = (paramArrayOfbyte[b] & 0xF0) >> 4;
/* 463 */       arrayOfChar[b * 2] = HEXADECIMAL[k];
/* 464 */       arrayOfChar[b * 2 + 1] = HEXADECIMAL[j];
/*     */     } 
/*     */     
/* 467 */     return new String(arrayOfChar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String createCnonce() {
/* 477 */     SecureRandom secureRandom = new SecureRandom();
/* 478 */     byte[] arrayOfByte = new byte[8];
/* 479 */     secureRandom.nextBytes(arrayOfByte);
/* 480 */     return encode(arrayOfByte);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 485 */     StringBuilder stringBuilder = new StringBuilder();
/* 486 */     stringBuilder.append("DIGEST [complete=").append(this.complete).append(", nonce=").append(this.lastNonce).append(", nc=").append(this.nounceCount).append("]");
/*     */ 
/*     */ 
/*     */     
/* 490 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\auth\DigestScheme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */