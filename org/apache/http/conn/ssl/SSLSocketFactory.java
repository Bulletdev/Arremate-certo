/*     */ package org.apache.http.conn.ssl;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.net.InetAddress;
/*     */ import java.net.InetSocketAddress;
/*     */ import java.net.Socket;
/*     */ import java.net.SocketTimeoutException;
/*     */ import java.net.UnknownHostException;
/*     */ import java.security.KeyManagementException;
/*     */ import java.security.KeyStore;
/*     */ import java.security.KeyStoreException;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.security.SecureRandom;
/*     */ import java.security.UnrecoverableKeyException;
/*     */ import javax.net.SocketFactory;
/*     */ import javax.net.ssl.SSLContext;
/*     */ import javax.net.ssl.SSLSocket;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.conn.ConnectTimeoutException;
/*     */ import org.apache.http.conn.HttpInetSocketAddress;
/*     */ import org.apache.http.conn.scheme.HostNameResolver;
/*     */ import org.apache.http.conn.scheme.LayeredSchemeSocketFactory;
/*     */ import org.apache.http.conn.scheme.LayeredSocketFactory;
/*     */ import org.apache.http.conn.scheme.SchemeLayeredSocketFactory;
/*     */ import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
/*     */ import org.apache.http.params.HttpConnectionParams;
/*     */ import org.apache.http.params.HttpParams;
/*     */ import org.apache.http.protocol.HttpContext;
/*     */ import org.apache.http.util.Args;
/*     */ import org.apache.http.util.Asserts;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ @Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
/*     */ public class SSLSocketFactory
/*     */   implements LayeredSchemeSocketFactory, LayeredSocketFactory, SchemeLayeredSocketFactory, LayeredConnectionSocketFactory
/*     */ {
/*     */   public static final String TLS = "TLS";
/*     */   public static final String SSL = "SSL";
/*     */   public static final String SSLV2 = "SSLv2";
/* 154 */   public static final X509HostnameVerifier ALLOW_ALL_HOSTNAME_VERIFIER = new AllowAllHostnameVerifier();
/*     */ 
/*     */   
/* 157 */   public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();
/*     */ 
/*     */   
/* 160 */   public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();
/*     */   
/*     */   private final javax.net.ssl.SSLSocketFactory socketfactory;
/*     */   
/*     */   private final HostNameResolver nameResolver;
/*     */   
/*     */   private volatile X509HostnameVerifier hostnameVerifier;
/*     */   private final String[] supportedProtocols;
/*     */   private final String[] supportedCipherSuites;
/*     */   
/*     */   public static SSLSocketFactory getSocketFactory() throws SSLInitializationException {
/* 171 */     return new SSLSocketFactory(SSLContexts.createDefault(), BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static String[] split(String paramString) {
/* 177 */     if (TextUtils.isBlank(paramString)) {
/* 178 */       return null;
/*     */     }
/* 180 */     return paramString.split(" *, *");
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
/*     */   public static SSLSocketFactory getSystemSocketFactory() throws SSLInitializationException {
/* 193 */     return new SSLSocketFactory((javax.net.ssl.SSLSocketFactory)javax.net.ssl.SSLSocketFactory.getDefault(), split(System.getProperty("https.protocols")), split(System.getProperty("https.cipherSuites")), BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
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
/*     */   public SSLSocketFactory(String paramString1, KeyStore paramKeyStore1, String paramString2, KeyStore paramKeyStore2, SecureRandom paramSecureRandom, HostNameResolver paramHostNameResolver) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
/* 215 */     this(SSLContexts.custom().useProtocol(paramString1).setSecureRandom(paramSecureRandom).loadKeyMaterial(paramKeyStore1, (paramString2 != null) ? paramString2.toCharArray() : null).loadTrustMaterial(paramKeyStore2).build(), paramHostNameResolver);
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
/*     */   public SSLSocketFactory(String paramString1, KeyStore paramKeyStore1, String paramString2, KeyStore paramKeyStore2, SecureRandom paramSecureRandom, TrustStrategy paramTrustStrategy, X509HostnameVerifier paramX509HostnameVerifier) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
/* 236 */     this(SSLContexts.custom().useProtocol(paramString1).setSecureRandom(paramSecureRandom).loadKeyMaterial(paramKeyStore1, (paramString2 != null) ? paramString2.toCharArray() : null).loadTrustMaterial(paramKeyStore2, paramTrustStrategy).build(), paramX509HostnameVerifier);
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
/*     */   public SSLSocketFactory(String paramString1, KeyStore paramKeyStore1, String paramString2, KeyStore paramKeyStore2, SecureRandom paramSecureRandom, X509HostnameVerifier paramX509HostnameVerifier) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
/* 256 */     this(SSLContexts.custom().useProtocol(paramString1).setSecureRandom(paramSecureRandom).loadKeyMaterial(paramKeyStore1, (paramString2 != null) ? paramString2.toCharArray() : null).loadTrustMaterial(paramKeyStore2).build(), paramX509HostnameVerifier);
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
/*     */   public SSLSocketFactory(KeyStore paramKeyStore1, String paramString, KeyStore paramKeyStore2) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
/* 270 */     this(SSLContexts.custom().loadKeyMaterial(paramKeyStore1, (paramString != null) ? paramString.toCharArray() : null).loadTrustMaterial(paramKeyStore2).build(), BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SSLSocketFactory(KeyStore paramKeyStore, String paramString) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
/* 281 */     this(SSLContexts.custom().loadKeyMaterial(paramKeyStore, (paramString != null) ? paramString.toCharArray() : null).build(), BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SSLSocketFactory(KeyStore paramKeyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
/* 290 */     this(SSLContexts.custom().loadTrustMaterial(paramKeyStore).build(), BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
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
/*     */   public SSLSocketFactory(TrustStrategy paramTrustStrategy, X509HostnameVerifier paramX509HostnameVerifier) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
/* 303 */     this(SSLContexts.custom().loadTrustMaterial(null, paramTrustStrategy).build(), paramX509HostnameVerifier);
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
/*     */   public SSLSocketFactory(TrustStrategy paramTrustStrategy) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
/* 315 */     this(SSLContexts.custom().loadTrustMaterial(null, paramTrustStrategy).build(), BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SSLSocketFactory(SSLContext paramSSLContext) {
/* 322 */     this(paramSSLContext, BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SSLSocketFactory(SSLContext paramSSLContext, HostNameResolver paramHostNameResolver) {
/* 328 */     this.socketfactory = paramSSLContext.getSocketFactory();
/* 329 */     this.hostnameVerifier = BROWSER_COMPATIBLE_HOSTNAME_VERIFIER;
/* 330 */     this.nameResolver = paramHostNameResolver;
/* 331 */     this.supportedProtocols = null;
/* 332 */     this.supportedCipherSuites = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SSLSocketFactory(SSLContext paramSSLContext, X509HostnameVerifier paramX509HostnameVerifier) {
/* 340 */     this(((SSLContext)Args.notNull(paramSSLContext, "SSL context")).getSocketFactory(), (String[])null, (String[])null, paramX509HostnameVerifier);
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
/*     */   public SSLSocketFactory(SSLContext paramSSLContext, String[] paramArrayOfString1, String[] paramArrayOfString2, X509HostnameVerifier paramX509HostnameVerifier) {
/* 352 */     this(((SSLContext)Args.notNull(paramSSLContext, "SSL context")).getSocketFactory(), paramArrayOfString1, paramArrayOfString2, paramX509HostnameVerifier);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SSLSocketFactory(javax.net.ssl.SSLSocketFactory paramSSLSocketFactory, X509HostnameVerifier paramX509HostnameVerifier) {
/* 362 */     this(paramSSLSocketFactory, (String[])null, (String[])null, paramX509HostnameVerifier);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SSLSocketFactory(javax.net.ssl.SSLSocketFactory paramSSLSocketFactory, String[] paramArrayOfString1, String[] paramArrayOfString2, X509HostnameVerifier paramX509HostnameVerifier) {
/* 373 */     this.socketfactory = (javax.net.ssl.SSLSocketFactory)Args.notNull(paramSSLSocketFactory, "SSL socket factory");
/* 374 */     this.supportedProtocols = paramArrayOfString1;
/* 375 */     this.supportedCipherSuites = paramArrayOfString2;
/* 376 */     this.hostnameVerifier = (paramX509HostnameVerifier != null) ? paramX509HostnameVerifier : BROWSER_COMPATIBLE_HOSTNAME_VERIFIER;
/* 377 */     this.nameResolver = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Socket createSocket(HttpParams paramHttpParams) throws IOException {
/* 387 */     return createSocket((HttpContext)null);
/*     */   }
/*     */ 
/*     */   
/*     */   public Socket createSocket() throws IOException {
/* 392 */     return createSocket((HttpContext)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Socket connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2, HttpParams paramHttpParams) throws IOException, UnknownHostException, ConnectTimeoutException {
/*     */     HttpHost httpHost;
/* 404 */     Args.notNull(paramInetSocketAddress1, "Remote address");
/* 405 */     Args.notNull(paramHttpParams, "HTTP parameters");
/*     */     
/* 407 */     if (paramInetSocketAddress1 instanceof HttpInetSocketAddress) {
/* 408 */       httpHost = ((HttpInetSocketAddress)paramInetSocketAddress1).getHttpHost();
/*     */     } else {
/* 410 */       httpHost = new HttpHost(paramInetSocketAddress1.getHostName(), paramInetSocketAddress1.getPort(), "https");
/*     */     } 
/* 412 */     int i = HttpConnectionParams.getSoTimeout(paramHttpParams);
/* 413 */     int j = HttpConnectionParams.getConnectionTimeout(paramHttpParams);
/* 414 */     paramSocket.setSoTimeout(i);
/* 415 */     return connectSocket(j, paramSocket, httpHost, paramInetSocketAddress1, paramInetSocketAddress2, (HttpContext)null);
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
/*     */   public boolean isSecure(Socket paramSocket) throws IllegalArgumentException {
/* 435 */     Args.notNull(paramSocket, "Socket");
/* 436 */     Asserts.check(paramSocket instanceof SSLSocket, "Socket not created by this factory");
/* 437 */     Asserts.check(!paramSocket.isClosed(), "Socket is closed");
/* 438 */     return true;
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
/*     */   public Socket createLayeredSocket(Socket paramSocket, String paramString, int paramInt, HttpParams paramHttpParams) throws IOException, UnknownHostException {
/* 450 */     return createLayeredSocket(paramSocket, paramString, paramInt, (HttpContext)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Socket createLayeredSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean) throws IOException, UnknownHostException {
/* 459 */     return createLayeredSocket(paramSocket, paramString, paramInt, (HttpContext)null);
/*     */   }
/*     */   
/*     */   public void setHostnameVerifier(X509HostnameVerifier paramX509HostnameVerifier) {
/* 463 */     Args.notNull(paramX509HostnameVerifier, "Hostname verifier");
/* 464 */     this.hostnameVerifier = paramX509HostnameVerifier;
/*     */   }
/*     */   
/*     */   public X509HostnameVerifier getHostnameVerifier() {
/* 468 */     return this.hostnameVerifier;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Socket connectSocket(Socket paramSocket, String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2, HttpParams paramHttpParams) throws IOException, UnknownHostException, ConnectTimeoutException {
/*     */     InetAddress inetAddress;
/* 478 */     if (this.nameResolver != null) {
/* 479 */       inetAddress = this.nameResolver.resolve(paramString);
/*     */     } else {
/* 481 */       inetAddress = InetAddress.getByName(paramString);
/*     */     } 
/* 483 */     InetSocketAddress inetSocketAddress = null;
/* 484 */     if (paramInetAddress != null || paramInt2 > 0) {
/* 485 */       inetSocketAddress = new InetSocketAddress(paramInetAddress, (paramInt2 > 0) ? paramInt2 : 0);
/*     */     }
/* 487 */     HttpInetSocketAddress httpInetSocketAddress = new HttpInetSocketAddress(new HttpHost(paramString, paramInt1), inetAddress, paramInt1);
/*     */     
/* 489 */     return connectSocket(paramSocket, (InetSocketAddress)httpInetSocketAddress, inetSocketAddress, paramHttpParams);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean) throws IOException, UnknownHostException {
/* 497 */     return createLayeredSocket(paramSocket, paramString, paramInt, paramBoolean);
/*     */   }
/*     */ 
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
/*     */   private void internalPrepareSocket(SSLSocket paramSSLSocket) throws IOException {
/* 514 */     if (this.supportedProtocols != null) {
/* 515 */       paramSSLSocket.setEnabledProtocols(this.supportedProtocols);
/*     */     }
/* 517 */     if (this.supportedCipherSuites != null) {
/* 518 */       paramSSLSocket.setEnabledCipherSuites(this.supportedCipherSuites);
/*     */     }
/* 520 */     prepareSocket(paramSSLSocket);
/*     */   }
/*     */ 
/*     */   
/*     */   public Socket createSocket(HttpContext paramHttpContext) throws IOException {
/* 525 */     return SocketFactory.getDefault().createSocket();
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
/* 536 */     Args.notNull(paramHttpHost, "HTTP host");
/* 537 */     Args.notNull(paramInetSocketAddress1, "Remote address");
/* 538 */     Socket socket = (paramSocket != null) ? paramSocket : createSocket(paramHttpContext);
/* 539 */     if (paramInetSocketAddress2 != null) {
/* 540 */       socket.bind(paramInetSocketAddress2);
/*     */     }
/*     */     try {
/* 543 */       socket.connect(paramInetSocketAddress1, paramInt);
/* 544 */     } catch (SocketTimeoutException socketTimeoutException) {
/* 545 */       throw new ConnectTimeoutException("Connect to " + paramInetSocketAddress1 + " timed out");
/*     */     } 
/*     */     
/* 548 */     if (socket instanceof SSLSocket) {
/* 549 */       SSLSocket sSLSocket = (SSLSocket)socket;
/* 550 */       sSLSocket.startHandshake();
/* 551 */       verifyHostname(sSLSocket, paramHttpHost.getHostName());
/* 552 */       return socket;
/*     */     } 
/* 554 */     return createLayeredSocket(socket, paramHttpHost.getHostName(), paramInetSocketAddress1.getPort(), paramHttpContext);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Socket createLayeredSocket(Socket paramSocket, String paramString, int paramInt, HttpContext paramHttpContext) throws IOException {
/* 564 */     SSLSocket sSLSocket = (SSLSocket)this.socketfactory.createSocket(paramSocket, paramString, paramInt, true);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 569 */     internalPrepareSocket(sSLSocket);
/* 570 */     sSLSocket.startHandshake();
/* 571 */     verifyHostname(sSLSocket, paramString);
/* 572 */     return sSLSocket;
/*     */   }
/*     */   
/*     */   private void verifyHostname(SSLSocket paramSSLSocket, String paramString) throws IOException {
/*     */     try {
/* 577 */       this.hostnameVerifier.verify(paramString, paramSSLSocket);
/*     */     }
/* 579 */     catch (IOException iOException) {
/*     */       
/* 581 */       try { paramSSLSocket.close(); } catch (Exception exception) {}
/* 582 */       throw iOException;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\conn\ssl\SSLSocketFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */