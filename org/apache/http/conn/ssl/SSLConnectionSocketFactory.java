/*     */ package org.apache.http.conn.ssl;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.InetSocketAddress;
/*     */ import java.net.Socket;
/*     */ import java.security.cert.Certificate;
/*     */ import java.security.cert.X509Certificate;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.regex.Pattern;
/*     */ import javax.net.SocketFactory;
/*     */ import javax.net.ssl.HostnameVerifier;
/*     */ import javax.net.ssl.SSLContext;
/*     */ import javax.net.ssl.SSLHandshakeException;
/*     */ import javax.net.ssl.SSLPeerUnverifiedException;
/*     */ import javax.net.ssl.SSLSession;
/*     */ import javax.net.ssl.SSLSocket;
/*     */ import javax.net.ssl.SSLSocketFactory;
/*     */ import javax.security.auth.x500.X500Principal;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
/*     */ import org.apache.http.conn.util.PublicSuffixMatcherLoader;
/*     */ import org.apache.http.protocol.HttpContext;
/*     */ import org.apache.http.ssl.SSLContexts;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Contract(threading = ThreadingBehavior.SAFE)
/*     */ public class SSLConnectionSocketFactory
/*     */   implements LayeredConnectionSocketFactory
/*     */ {
/*     */   public static final String TLS = "TLS";
/*     */   public static final String SSL = "SSL";
/*     */   public static final String SSLV2 = "SSLv2";
/*     */   @Deprecated
/* 151 */   public static final X509HostnameVerifier ALLOW_ALL_HOSTNAME_VERIFIER = AllowAllHostnameVerifier.INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/* 158 */   public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = BrowserCompatHostnameVerifier.INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/* 165 */   public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = StrictHostnameVerifier.INSTANCE;
/*     */ 
/*     */   
/*     */   private static final String WEAK_KEY_EXCHANGES = "^(TLS|SSL)_(NULL|ECDH_anon|DH_anon|DH_anon_EXPORT|DHE_RSA_EXPORT|DHE_DSS_EXPORT|DSS_EXPORT|DH_DSS_EXPORT|DH_RSA_EXPORT|RSA_EXPORT|KRB5_EXPORT)_(.*)";
/*     */ 
/*     */   
/*     */   private static final String WEAK_CIPHERS = "^(TLS|SSL)_(.*)_WITH_(NULL|DES_CBC|DES40_CBC|DES_CBC_40|3DES_EDE_CBC|RC4_128|RC4_40|RC2_CBC_40)_(.*)";
/*     */   
/* 173 */   private static final List<Pattern> WEAK_CIPHER_SUITE_PATTERNS = Collections.unmodifiableList(Arrays.asList(new Pattern[] { Pattern.compile("^(TLS|SSL)_(NULL|ECDH_anon|DH_anon|DH_anon_EXPORT|DHE_RSA_EXPORT|DHE_DSS_EXPORT|DSS_EXPORT|DH_DSS_EXPORT|DH_RSA_EXPORT|RSA_EXPORT|KRB5_EXPORT)_(.*)", 2), Pattern.compile("^(TLS|SSL)_(.*)_WITH_(NULL|DES_CBC|DES40_CBC|DES_CBC_40|3DES_EDE_CBC|RC4_128|RC4_40|RC2_CBC_40)_(.*)", 2) }));
/*     */ 
/*     */ 
/*     */   
/* 177 */   private final Log log = LogFactory.getLog(getClass());
/*     */   
/*     */   private final SSLSocketFactory socketfactory;
/*     */   private final HostnameVerifier hostnameVerifier;
/*     */   
/*     */   public static HostnameVerifier getDefaultHostnameVerifier() {
/* 183 */     return new DefaultHostnameVerifier(PublicSuffixMatcherLoader.getDefault());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private final String[] supportedProtocols;
/*     */   
/*     */   private final String[] supportedCipherSuites;
/*     */ 
/*     */   
/*     */   public static SSLConnectionSocketFactory getSocketFactory() throws SSLInitializationException {
/* 194 */     return new SSLConnectionSocketFactory(SSLContexts.createDefault(), getDefaultHostnameVerifier());
/*     */   }
/*     */   
/*     */   static boolean isWeakCipherSuite(String paramString) {
/* 198 */     for (Pattern pattern : WEAK_CIPHER_SUITE_PATTERNS) {
/* 199 */       if (pattern.matcher(paramString).matches()) {
/* 200 */         return true;
/*     */       }
/*     */     } 
/* 203 */     return false;
/*     */   }
/*     */   
/*     */   private static String[] split(String paramString) {
/* 207 */     if (TextUtils.isBlank(paramString)) {
/* 208 */       return null;
/*     */     }
/* 210 */     return paramString.split(" *, *");
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
/*     */   public static SSLConnectionSocketFactory getSystemSocketFactory() throws SSLInitializationException {
/* 222 */     return new SSLConnectionSocketFactory((SSLSocketFactory)SSLSocketFactory.getDefault(), split(System.getProperty("https.protocols")), split(System.getProperty("https.cipherSuites")), getDefaultHostnameVerifier());
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
/*     */   public SSLConnectionSocketFactory(SSLContext paramSSLContext) {
/* 235 */     this(paramSSLContext, getDefaultHostnameVerifier());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public SSLConnectionSocketFactory(SSLContext paramSSLContext, X509HostnameVerifier paramX509HostnameVerifier) {
/* 245 */     this(((SSLContext)Args.notNull(paramSSLContext, "SSL context")).getSocketFactory(), (String[])null, (String[])null, paramX509HostnameVerifier);
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
/*     */   @Deprecated
/*     */   public SSLConnectionSocketFactory(SSLContext paramSSLContext, String[] paramArrayOfString1, String[] paramArrayOfString2, X509HostnameVerifier paramX509HostnameVerifier) {
/* 259 */     this(((SSLContext)Args.notNull(paramSSLContext, "SSL context")).getSocketFactory(), paramArrayOfString1, paramArrayOfString2, paramX509HostnameVerifier);
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
/*     */   public SSLConnectionSocketFactory(SSLSocketFactory paramSSLSocketFactory, X509HostnameVerifier paramX509HostnameVerifier) {
/* 271 */     this(paramSSLSocketFactory, (String[])null, (String[])null, paramX509HostnameVerifier);
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
/*     */   public SSLConnectionSocketFactory(SSLSocketFactory paramSSLSocketFactory, String[] paramArrayOfString1, String[] paramArrayOfString2, X509HostnameVerifier paramX509HostnameVerifier) {
/* 284 */     this(paramSSLSocketFactory, paramArrayOfString1, paramArrayOfString2, paramX509HostnameVerifier);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SSLConnectionSocketFactory(SSLContext paramSSLContext, HostnameVerifier paramHostnameVerifier) {
/* 292 */     this(((SSLContext)Args.notNull(paramSSLContext, "SSL context")).getSocketFactory(), (String[])null, (String[])null, paramHostnameVerifier);
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
/*     */   public SSLConnectionSocketFactory(SSLContext paramSSLContext, String[] paramArrayOfString1, String[] paramArrayOfString2, HostnameVerifier paramHostnameVerifier) {
/* 304 */     this(((SSLContext)Args.notNull(paramSSLContext, "SSL context")).getSocketFactory(), paramArrayOfString1, paramArrayOfString2, paramHostnameVerifier);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SSLConnectionSocketFactory(SSLSocketFactory paramSSLSocketFactory, HostnameVerifier paramHostnameVerifier) {
/* 314 */     this(paramSSLSocketFactory, (String[])null, (String[])null, paramHostnameVerifier);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SSLConnectionSocketFactory(SSLSocketFactory paramSSLSocketFactory, String[] paramArrayOfString1, String[] paramArrayOfString2, HostnameVerifier paramHostnameVerifier) {
/* 325 */     this.socketfactory = (SSLSocketFactory)Args.notNull(paramSSLSocketFactory, "SSL socket factory");
/* 326 */     this.supportedProtocols = paramArrayOfString1;
/* 327 */     this.supportedCipherSuites = paramArrayOfString2;
/* 328 */     this.hostnameVerifier = (paramHostnameVerifier != null) ? paramHostnameVerifier : getDefaultHostnameVerifier();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void prepareSocket(SSLSocket paramSSLSocket) throws IOException {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Socket createSocket(HttpContext paramHttpContext) throws IOException {
/* 344 */     return SocketFactory.getDefault().createSocket();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Socket connectSocket(int paramInt, Socket paramSocket, HttpHost paramHttpHost, InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2, HttpContext paramHttpContext) throws IOException {
/* 355 */     Args.notNull(paramHttpHost, "HTTP host");
/* 356 */     Args.notNull(paramInetSocketAddress1, "Remote address");
/* 357 */     Socket socket = (paramSocket != null) ? paramSocket : createSocket(paramHttpContext);
/* 358 */     if (paramInetSocketAddress2 != null) {
/* 359 */       socket.bind(paramInetSocketAddress2);
/*     */     }
/*     */     try {
/* 362 */       if (paramInt > 0 && socket.getSoTimeout() == 0) {
/* 363 */         socket.setSoTimeout(paramInt);
/*     */       }
/* 365 */       if (this.log.isDebugEnabled()) {
/* 366 */         this.log.debug("Connecting socket to " + paramInetSocketAddress1 + " with timeout " + paramInt);
/*     */       }
/* 368 */       socket.connect(paramInetSocketAddress1, paramInt);
/* 369 */     } catch (IOException iOException) {
/*     */       try {
/* 371 */         socket.close();
/* 372 */       } catch (IOException iOException1) {}
/*     */       
/* 374 */       throw iOException;
/*     */     } 
/*     */     
/* 377 */     if (socket instanceof SSLSocket) {
/* 378 */       SSLSocket sSLSocket = (SSLSocket)socket;
/* 379 */       this.log.debug("Starting handshake");
/* 380 */       sSLSocket.startHandshake();
/* 381 */       verifyHostname(sSLSocket, paramHttpHost.getHostName());
/* 382 */       return socket;
/*     */     } 
/* 384 */     return createLayeredSocket(socket, paramHttpHost.getHostName(), paramInetSocketAddress1.getPort(), paramHttpContext);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Socket createLayeredSocket(Socket paramSocket, String paramString, int paramInt, HttpContext paramHttpContext) throws IOException {
/* 393 */     SSLSocket sSLSocket = (SSLSocket)this.socketfactory.createSocket(paramSocket, paramString, paramInt, true);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 398 */     if (this.supportedProtocols != null) {
/* 399 */       sSLSocket.setEnabledProtocols(this.supportedProtocols);
/*     */     } else {
/*     */       
/* 402 */       String[] arrayOfString = sSLSocket.getEnabledProtocols();
/* 403 */       ArrayList<String> arrayList = new ArrayList(arrayOfString.length);
/* 404 */       for (String str : arrayOfString) {
/* 405 */         if (!str.startsWith("SSL")) {
/* 406 */           arrayList.add(str);
/*     */         }
/*     */       } 
/* 409 */       if (!arrayList.isEmpty()) {
/* 410 */         sSLSocket.setEnabledProtocols(arrayList.<String>toArray(new String[arrayList.size()]));
/*     */       }
/*     */     } 
/* 413 */     if (this.supportedCipherSuites != null) {
/* 414 */       sSLSocket.setEnabledCipherSuites(this.supportedCipherSuites);
/*     */     } else {
/*     */       
/* 417 */       String[] arrayOfString = sSLSocket.getEnabledCipherSuites();
/* 418 */       ArrayList<String> arrayList = new ArrayList(arrayOfString.length);
/* 419 */       for (String str : arrayOfString) {
/* 420 */         if (!isWeakCipherSuite(str)) {
/* 421 */           arrayList.add(str);
/*     */         }
/*     */       } 
/* 424 */       if (!arrayList.isEmpty()) {
/* 425 */         sSLSocket.setEnabledCipherSuites(arrayList.<String>toArray(new String[arrayList.size()]));
/*     */       }
/*     */     } 
/*     */     
/* 429 */     if (this.log.isDebugEnabled()) {
/* 430 */       this.log.debug("Enabled protocols: " + Arrays.<String>asList(sSLSocket.getEnabledProtocols()));
/* 431 */       this.log.debug("Enabled cipher suites:" + Arrays.<String>asList(sSLSocket.getEnabledCipherSuites()));
/*     */     } 
/*     */     
/* 434 */     prepareSocket(sSLSocket);
/* 435 */     this.log.debug("Starting handshake");
/* 436 */     sSLSocket.startHandshake();
/* 437 */     verifyHostname(sSLSocket, paramString);
/* 438 */     return sSLSocket;
/*     */   }
/*     */   
/*     */   private void verifyHostname(SSLSocket paramSSLSocket, String paramString) throws IOException {
/*     */     try {
/* 443 */       SSLSession sSLSession = paramSSLSocket.getSession();
/* 444 */       if (sSLSession == null) {
/*     */ 
/*     */ 
/*     */         
/* 448 */         InputStream inputStream = paramSSLSocket.getInputStream();
/* 449 */         inputStream.available();
/*     */ 
/*     */         
/* 452 */         sSLSession = paramSSLSocket.getSession();
/* 453 */         if (sSLSession == null) {
/*     */ 
/*     */           
/* 456 */           paramSSLSocket.startHandshake();
/* 457 */           sSLSession = paramSSLSocket.getSession();
/*     */         } 
/*     */       } 
/* 460 */       if (sSLSession == null) {
/* 461 */         throw new SSLHandshakeException("SSL session not available");
/*     */       }
/*     */       
/* 464 */       if (this.log.isDebugEnabled()) {
/* 465 */         this.log.debug("Secure session established");
/* 466 */         this.log.debug(" negotiated protocol: " + sSLSession.getProtocol());
/* 467 */         this.log.debug(" negotiated cipher suite: " + sSLSession.getCipherSuite());
/*     */ 
/*     */         
/*     */         try {
/* 471 */           Certificate[] arrayOfCertificate = sSLSession.getPeerCertificates();
/* 472 */           X509Certificate x509Certificate = (X509Certificate)arrayOfCertificate[0];
/* 473 */           X500Principal x500Principal1 = x509Certificate.getSubjectX500Principal();
/*     */           
/* 475 */           this.log.debug(" peer principal: " + x500Principal1.toString());
/* 476 */           Collection<List<?>> collection1 = x509Certificate.getSubjectAlternativeNames();
/* 477 */           if (collection1 != null) {
/* 478 */             ArrayList<String> arrayList = new ArrayList();
/* 479 */             for (List<String> list : collection1) {
/* 480 */               if (!list.isEmpty()) {
/* 481 */                 arrayList.add(list.get(1));
/*     */               }
/*     */             } 
/* 484 */             this.log.debug(" peer alternative names: " + arrayList);
/*     */           } 
/*     */           
/* 487 */           X500Principal x500Principal2 = x509Certificate.getIssuerX500Principal();
/* 488 */           this.log.debug(" issuer principal: " + x500Principal2.toString());
/* 489 */           Collection<List<?>> collection2 = x509Certificate.getIssuerAlternativeNames();
/* 490 */           if (collection2 != null) {
/* 491 */             ArrayList<String> arrayList = new ArrayList();
/* 492 */             for (List<String> list : collection2) {
/* 493 */               if (!list.isEmpty()) {
/* 494 */                 arrayList.add(list.get(1));
/*     */               }
/*     */             } 
/* 497 */             this.log.debug(" issuer alternative names: " + arrayList);
/*     */           } 
/* 499 */         } catch (Exception exception) {}
/*     */       } 
/*     */ 
/*     */       
/* 503 */       if (!this.hostnameVerifier.verify(paramString, sSLSession)) {
/* 504 */         Certificate[] arrayOfCertificate = sSLSession.getPeerCertificates();
/* 505 */         X509Certificate x509Certificate = (X509Certificate)arrayOfCertificate[0];
/* 506 */         List<SubjectName> list = DefaultHostnameVerifier.getSubjectAltNames(x509Certificate);
/* 507 */         throw new SSLPeerUnverifiedException("Certificate for <" + paramString + "> doesn't match any " + "of the subject alternative names: " + list);
/*     */       }
/*     */     
/*     */     }
/* 511 */     catch (IOException iOException) {
/*     */       
/* 513 */       try { paramSSLSocket.close(); } catch (Exception exception) {}
/* 514 */       throw iOException;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\conn\ssl\SSLConnectionSocketFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */