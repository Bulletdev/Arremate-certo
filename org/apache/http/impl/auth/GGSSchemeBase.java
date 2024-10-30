/*     */ package org.apache.http.impl.auth;
/*     */ 
/*     */ import java.net.InetAddress;
/*     */ import java.net.UnknownHostException;
/*     */ import org.apache.commons.codec.binary.Base64;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.auth.AuthenticationException;
/*     */ import org.apache.http.auth.Credentials;
/*     */ import org.apache.http.auth.InvalidCredentialsException;
/*     */ import org.apache.http.auth.KerberosCredentials;
/*     */ import org.apache.http.auth.MalformedChallengeException;
/*     */ import org.apache.http.conn.routing.HttpRoute;
/*     */ import org.apache.http.message.BufferedHeader;
/*     */ import org.apache.http.protocol.HttpContext;
/*     */ import org.apache.http.util.Args;
/*     */ import org.apache.http.util.CharArrayBuffer;
/*     */ import org.ietf.jgss.GSSContext;
/*     */ import org.ietf.jgss.GSSCredential;
/*     */ import org.ietf.jgss.GSSException;
/*     */ import org.ietf.jgss.GSSManager;
/*     */ import org.ietf.jgss.GSSName;
/*     */ import org.ietf.jgss.Oid;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class GGSSchemeBase
/*     */   extends AuthSchemeBase
/*     */ {
/*     */   enum State
/*     */   {
/*  63 */     UNINITIATED,
/*  64 */     CHALLENGE_RECEIVED,
/*  65 */     TOKEN_GENERATED,
/*  66 */     FAILED;
/*     */   }
/*     */   
/*  69 */   private final Log log = LogFactory.getLog(getClass());
/*     */   
/*     */   private final Base64 base64codec;
/*     */   
/*     */   private final boolean stripPort;
/*     */   
/*     */   private final boolean useCanonicalHostname;
/*     */   
/*     */   private State state;
/*     */   
/*     */   private byte[] token;
/*     */ 
/*     */   
/*     */   GGSSchemeBase(boolean paramBoolean1, boolean paramBoolean2) {
/*  83 */     this.base64codec = new Base64(0);
/*  84 */     this.stripPort = paramBoolean1;
/*  85 */     this.useCanonicalHostname = paramBoolean2;
/*  86 */     this.state = State.UNINITIATED;
/*     */   }
/*     */   
/*     */   GGSSchemeBase(boolean paramBoolean) {
/*  90 */     this(paramBoolean, true);
/*     */   }
/*     */   
/*     */   GGSSchemeBase() {
/*  94 */     this(true, true);
/*     */   }
/*     */   
/*     */   protected GSSManager getManager() {
/*  98 */     return GSSManager.getInstance();
/*     */   }
/*     */ 
/*     */   
/*     */   protected byte[] generateGSSToken(byte[] paramArrayOfbyte, Oid paramOid, String paramString) throws GSSException {
/* 103 */     return generateGSSToken(paramArrayOfbyte, paramOid, paramString, (Credentials)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected byte[] generateGSSToken(byte[] paramArrayOfbyte, Oid paramOid, String paramString, Credentials paramCredentials) throws GSSException {
/*     */     GSSCredential gSSCredential;
/* 112 */     GSSManager gSSManager = getManager();
/* 113 */     GSSName gSSName = gSSManager.createName("HTTP@" + paramString, GSSName.NT_HOSTBASED_SERVICE);
/*     */ 
/*     */     
/* 116 */     if (paramCredentials instanceof KerberosCredentials) {
/* 117 */       gSSCredential = ((KerberosCredentials)paramCredentials).getGSSCredential();
/*     */     } else {
/* 119 */       gSSCredential = null;
/*     */     } 
/*     */     
/* 122 */     GSSContext gSSContext = createGSSContext(gSSManager, paramOid, gSSName, gSSCredential);
/* 123 */     return (paramArrayOfbyte != null) ? gSSContext.initSecContext(paramArrayOfbyte, 0, paramArrayOfbyte.length) : gSSContext.initSecContext(new byte[0], 0, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   GSSContext createGSSContext(GSSManager paramGSSManager, Oid paramOid, GSSName paramGSSName, GSSCredential paramGSSCredential) throws GSSException {
/* 133 */     GSSContext gSSContext = paramGSSManager.createContext(paramGSSName.canonicalize(paramOid), paramOid, paramGSSCredential, 0);
/*     */     
/* 135 */     gSSContext.requestMutualAuth(true);
/* 136 */     return gSSContext;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected byte[] generateToken(byte[] paramArrayOfbyte, String paramString) throws GSSException {
/* 143 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected byte[] generateToken(byte[] paramArrayOfbyte, String paramString, Credentials paramCredentials) throws GSSException {
/* 153 */     return generateToken(paramArrayOfbyte, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isComplete() {
/* 158 */     return (this.state == State.TOKEN_GENERATED || this.state == State.FAILED);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public Header authenticate(Credentials paramCredentials, HttpRequest paramHttpRequest) throws AuthenticationException {
/* 170 */     return authenticate(paramCredentials, paramHttpRequest, (HttpContext)null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Header authenticate(Credentials paramCredentials, HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws AuthenticationException {
/*     */     String str;
/*     */     CharArrayBuffer charArrayBuffer;
/* 178 */     Args.notNull(paramHttpRequest, "HTTP request");
/* 179 */     switch (this.state) {
/*     */       case UNINITIATED:
/* 181 */         throw new AuthenticationException(getSchemeName() + " authentication has not been initiated");
/*     */       case FAILED:
/* 183 */         throw new AuthenticationException(getSchemeName() + " authentication has failed");
/*     */       case CHALLENGE_RECEIVED:
/*     */         try {
/* 186 */           HttpHost httpHost; String str1; HttpRoute httpRoute = (HttpRoute)paramHttpContext.getAttribute("http.route");
/* 187 */           if (httpRoute == null) {
/* 188 */             throw new AuthenticationException("Connection route is not available");
/*     */           }
/*     */           
/* 191 */           if (isProxy()) {
/* 192 */             httpHost = httpRoute.getProxyHost();
/* 193 */             if (httpHost == null) {
/* 194 */               httpHost = httpRoute.getTargetHost();
/*     */             }
/*     */           } else {
/* 197 */             httpHost = httpRoute.getTargetHost();
/*     */           } 
/*     */           
/* 200 */           String str2 = httpHost.getHostName();
/*     */           
/* 202 */           if (this.useCanonicalHostname) {
/*     */             
/*     */             try {
/*     */ 
/*     */ 
/*     */               
/* 208 */               str2 = resolveCanonicalHostname(str2);
/* 209 */             } catch (UnknownHostException unknownHostException) {}
/*     */           }
/*     */           
/* 212 */           if (this.stripPort) {
/* 213 */             str1 = str2;
/*     */           } else {
/* 215 */             str1 = str2 + ":" + httpHost.getPort();
/*     */           } 
/*     */           
/* 218 */           if (this.log.isDebugEnabled()) {
/* 219 */             this.log.debug("init " + str1);
/*     */           }
/* 221 */           this.token = generateToken(this.token, str1, paramCredentials);
/* 222 */           this.state = State.TOKEN_GENERATED;
/* 223 */         } catch (GSSException gSSException) {
/* 224 */           this.state = State.FAILED;
/* 225 */           if (gSSException.getMajor() == 9 || gSSException.getMajor() == 8)
/*     */           {
/* 227 */             throw new InvalidCredentialsException(gSSException.getMessage(), gSSException);
/*     */           }
/* 229 */           if (gSSException.getMajor() == 13) {
/* 230 */             throw new InvalidCredentialsException(gSSException.getMessage(), gSSException);
/*     */           }
/* 232 */           if (gSSException.getMajor() == 10 || gSSException.getMajor() == 19 || gSSException.getMajor() == 20)
/*     */           {
/*     */             
/* 235 */             throw new AuthenticationException(gSSException.getMessage(), gSSException);
/*     */           }
/*     */           
/* 238 */           throw new AuthenticationException(gSSException.getMessage());
/*     */         } 
/*     */       case TOKEN_GENERATED:
/* 241 */         str = new String(this.base64codec.encode(this.token));
/* 242 */         if (this.log.isDebugEnabled()) {
/* 243 */           this.log.debug("Sending response '" + str + "' back to the auth server");
/*     */         }
/* 245 */         charArrayBuffer = new CharArrayBuffer(32);
/* 246 */         if (isProxy()) {
/* 247 */           charArrayBuffer.append("Proxy-Authorization");
/*     */         } else {
/* 249 */           charArrayBuffer.append("Authorization");
/*     */         } 
/* 251 */         charArrayBuffer.append(": Negotiate ");
/* 252 */         charArrayBuffer.append(str);
/* 253 */         return (Header)new BufferedHeader(charArrayBuffer);
/*     */     } 
/* 255 */     throw new IllegalStateException("Illegal state: " + this.state);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void parseChallenge(CharArrayBuffer paramCharArrayBuffer, int paramInt1, int paramInt2) throws MalformedChallengeException {
/* 263 */     String str = paramCharArrayBuffer.substringTrimmed(paramInt1, paramInt2);
/* 264 */     if (this.log.isDebugEnabled()) {
/* 265 */       this.log.debug("Received challenge '" + str + "' from the auth server");
/*     */     }
/* 267 */     if (this.state == State.UNINITIATED) {
/* 268 */       this.token = Base64.decodeBase64(str.getBytes());
/* 269 */       this.state = State.CHALLENGE_RECEIVED;
/*     */     } else {
/* 271 */       this.log.debug("Authentication already attempted");
/* 272 */       this.state = State.FAILED;
/*     */     } 
/*     */   }
/*     */   
/*     */   private String resolveCanonicalHostname(String paramString) throws UnknownHostException {
/* 277 */     InetAddress inetAddress = InetAddress.getByName(paramString);
/* 278 */     String str = inetAddress.getCanonicalHostName();
/* 279 */     if (inetAddress.getHostAddress().contentEquals(str)) {
/* 280 */       return paramString;
/*     */     }
/* 282 */     return str;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\auth\GGSSchemeBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */