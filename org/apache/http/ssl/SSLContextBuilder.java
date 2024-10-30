/*     */ package org.apache.http.ssl;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.Socket;
/*     */ import java.net.URL;
/*     */ import java.security.KeyManagementException;
/*     */ import java.security.KeyStore;
/*     */ import java.security.KeyStoreException;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.security.Principal;
/*     */ import java.security.PrivateKey;
/*     */ import java.security.Provider;
/*     */ import java.security.SecureRandom;
/*     */ import java.security.Security;
/*     */ import java.security.UnrecoverableKeyException;
/*     */ import java.security.cert.CertificateException;
/*     */ import java.security.cert.X509Certificate;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import javax.net.ssl.KeyManager;
/*     */ import javax.net.ssl.KeyManagerFactory;
/*     */ import javax.net.ssl.SSLContext;
/*     */ import javax.net.ssl.SSLEngine;
/*     */ import javax.net.ssl.TrustManager;
/*     */ import javax.net.ssl.TrustManagerFactory;
/*     */ import javax.net.ssl.X509ExtendedKeyManager;
/*     */ import javax.net.ssl.X509TrustManager;
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
/*     */ public class SSLContextBuilder
/*     */ {
/*     */   static final String TLS = "TLS";
/*     */   private String protocol;
/*     */   private final Set<KeyManager> keyManagers;
/*  86 */   private String keyManagerFactoryAlgorithm = KeyManagerFactory.getDefaultAlgorithm();
/*  87 */   private String keyStoreType = KeyStore.getDefaultType();
/*     */   private final Set<TrustManager> trustManagers;
/*  89 */   private String trustManagerFactoryAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
/*     */   private SecureRandom secureRandom;
/*     */   private Provider provider;
/*     */   
/*     */   public static SSLContextBuilder create() {
/*  94 */     return new SSLContextBuilder();
/*     */   }
/*     */ 
/*     */   
/*     */   public SSLContextBuilder() {
/*  99 */     this.keyManagers = new LinkedHashSet<KeyManager>();
/* 100 */     this.trustManagers = new LinkedHashSet<TrustManager>();
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
/*     */   @Deprecated
/*     */   public SSLContextBuilder useProtocol(String paramString) {
/* 120 */     this.protocol = paramString;
/* 121 */     return this;
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
/*     */   public SSLContextBuilder setProtocol(String paramString) {
/* 140 */     this.protocol = paramString;
/* 141 */     return this;
/*     */   }
/*     */   
/*     */   public SSLContextBuilder setSecureRandom(SecureRandom paramSecureRandom) {
/* 145 */     this.secureRandom = paramSecureRandom;
/* 146 */     return this;
/*     */   }
/*     */   
/*     */   public SSLContextBuilder setProvider(Provider paramProvider) {
/* 150 */     this.provider = paramProvider;
/* 151 */     return this;
/*     */   }
/*     */   
/*     */   public SSLContextBuilder setProvider(String paramString) {
/* 155 */     this.provider = Security.getProvider(paramString);
/* 156 */     return this;
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
/*     */   public SSLContextBuilder setKeyStoreType(String paramString) {
/* 175 */     this.keyStoreType = paramString;
/* 176 */     return this;
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
/*     */   public SSLContextBuilder setKeyManagerFactoryAlgorithm(String paramString) {
/* 195 */     this.keyManagerFactoryAlgorithm = paramString;
/* 196 */     return this;
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
/*     */   public SSLContextBuilder setTrustManagerFactoryAlgorithm(String paramString) {
/* 215 */     this.trustManagerFactoryAlgorithm = paramString;
/* 216 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SSLContextBuilder loadTrustMaterial(KeyStore paramKeyStore, TrustStrategy paramTrustStrategy) throws NoSuchAlgorithmException, KeyStoreException {
/* 222 */     TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance((this.trustManagerFactoryAlgorithm == null) ? TrustManagerFactory.getDefaultAlgorithm() : this.trustManagerFactoryAlgorithm);
/*     */ 
/*     */     
/* 225 */     trustManagerFactory.init(paramKeyStore);
/* 226 */     TrustManager[] arrayOfTrustManager = trustManagerFactory.getTrustManagers();
/* 227 */     if (arrayOfTrustManager != null) {
/* 228 */       if (paramTrustStrategy != null) {
/* 229 */         for (byte b = 0; b < arrayOfTrustManager.length; b++) {
/* 230 */           TrustManager trustManager = arrayOfTrustManager[b];
/* 231 */           if (trustManager instanceof X509TrustManager) {
/* 232 */             arrayOfTrustManager[b] = new TrustManagerDelegate((X509TrustManager)trustManager, paramTrustStrategy);
/*     */           }
/*     */         } 
/*     */       }
/* 236 */       Collections.addAll(this.trustManagers, arrayOfTrustManager);
/*     */     } 
/* 238 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public SSLContextBuilder loadTrustMaterial(TrustStrategy paramTrustStrategy) throws NoSuchAlgorithmException, KeyStoreException {
/* 243 */     return loadTrustMaterial((KeyStore)null, paramTrustStrategy);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SSLContextBuilder loadTrustMaterial(File paramFile, char[] paramArrayOfchar, TrustStrategy paramTrustStrategy) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
/* 250 */     Args.notNull(paramFile, "Truststore file");
/* 251 */     KeyStore keyStore = KeyStore.getInstance(this.keyStoreType);
/* 252 */     FileInputStream fileInputStream = new FileInputStream(paramFile);
/*     */     try {
/* 254 */       keyStore.load(fileInputStream, paramArrayOfchar);
/*     */     } finally {
/* 256 */       fileInputStream.close();
/*     */     } 
/* 258 */     return loadTrustMaterial(keyStore, paramTrustStrategy);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SSLContextBuilder loadTrustMaterial(File paramFile, char[] paramArrayOfchar) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
/* 264 */     return loadTrustMaterial(paramFile, paramArrayOfchar, (TrustStrategy)null);
/*     */   }
/*     */ 
/*     */   
/*     */   public SSLContextBuilder loadTrustMaterial(File paramFile) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
/* 269 */     return loadTrustMaterial(paramFile, (char[])null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SSLContextBuilder loadTrustMaterial(URL paramURL, char[] paramArrayOfchar, TrustStrategy paramTrustStrategy) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
/* 276 */     Args.notNull(paramURL, "Truststore URL");
/* 277 */     KeyStore keyStore = KeyStore.getInstance(this.keyStoreType);
/* 278 */     InputStream inputStream = paramURL.openStream();
/*     */     try {
/* 280 */       keyStore.load(inputStream, paramArrayOfchar);
/*     */     } finally {
/* 282 */       inputStream.close();
/*     */     } 
/* 284 */     return loadTrustMaterial(keyStore, paramTrustStrategy);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SSLContextBuilder loadTrustMaterial(URL paramURL, char[] paramArrayOfchar) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
/* 290 */     return loadTrustMaterial(paramURL, paramArrayOfchar, (TrustStrategy)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SSLContextBuilder loadKeyMaterial(KeyStore paramKeyStore, char[] paramArrayOfchar, PrivateKeyStrategy paramPrivateKeyStrategy) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException {
/* 298 */     KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance((this.keyManagerFactoryAlgorithm == null) ? KeyManagerFactory.getDefaultAlgorithm() : this.keyManagerFactoryAlgorithm);
/*     */ 
/*     */     
/* 301 */     keyManagerFactory.init(paramKeyStore, paramArrayOfchar);
/* 302 */     KeyManager[] arrayOfKeyManager = keyManagerFactory.getKeyManagers();
/* 303 */     if (arrayOfKeyManager != null) {
/* 304 */       if (paramPrivateKeyStrategy != null) {
/* 305 */         for (byte b = 0; b < arrayOfKeyManager.length; b++) {
/* 306 */           KeyManager keyManager = arrayOfKeyManager[b];
/* 307 */           if (keyManager instanceof X509ExtendedKeyManager) {
/* 308 */             arrayOfKeyManager[b] = new KeyManagerDelegate((X509ExtendedKeyManager)keyManager, paramPrivateKeyStrategy);
/*     */           }
/*     */         } 
/*     */       }
/* 312 */       Collections.addAll(this.keyManagers, arrayOfKeyManager);
/*     */     } 
/* 314 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SSLContextBuilder loadKeyMaterial(KeyStore paramKeyStore, char[] paramArrayOfchar) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException {
/* 320 */     return loadKeyMaterial(paramKeyStore, paramArrayOfchar, (PrivateKeyStrategy)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SSLContextBuilder loadKeyMaterial(File paramFile, char[] paramArrayOfchar1, char[] paramArrayOfchar2, PrivateKeyStrategy paramPrivateKeyStrategy) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException {
/* 328 */     Args.notNull(paramFile, "Keystore file");
/* 329 */     KeyStore keyStore = KeyStore.getInstance(this.keyStoreType);
/* 330 */     FileInputStream fileInputStream = new FileInputStream(paramFile);
/*     */     try {
/* 332 */       keyStore.load(fileInputStream, paramArrayOfchar1);
/*     */     } finally {
/* 334 */       fileInputStream.close();
/*     */     } 
/* 336 */     return loadKeyMaterial(keyStore, paramArrayOfchar2, paramPrivateKeyStrategy);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SSLContextBuilder loadKeyMaterial(File paramFile, char[] paramArrayOfchar1, char[] paramArrayOfchar2) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException {
/* 343 */     return loadKeyMaterial(paramFile, paramArrayOfchar1, paramArrayOfchar2, (PrivateKeyStrategy)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SSLContextBuilder loadKeyMaterial(URL paramURL, char[] paramArrayOfchar1, char[] paramArrayOfchar2, PrivateKeyStrategy paramPrivateKeyStrategy) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException {
/* 351 */     Args.notNull(paramURL, "Keystore URL");
/* 352 */     KeyStore keyStore = KeyStore.getInstance(this.keyStoreType);
/* 353 */     InputStream inputStream = paramURL.openStream();
/*     */     try {
/* 355 */       keyStore.load(inputStream, paramArrayOfchar1);
/*     */     } finally {
/* 357 */       inputStream.close();
/*     */     } 
/* 359 */     return loadKeyMaterial(keyStore, paramArrayOfchar2, paramPrivateKeyStrategy);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SSLContextBuilder loadKeyMaterial(URL paramURL, char[] paramArrayOfchar1, char[] paramArrayOfchar2) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException {
/* 366 */     return loadKeyMaterial(paramURL, paramArrayOfchar1, paramArrayOfchar2, (PrivateKeyStrategy)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void initSSLContext(SSLContext paramSSLContext, Collection<KeyManager> paramCollection, Collection<TrustManager> paramCollection1, SecureRandom paramSecureRandom) throws KeyManagementException {
/* 374 */     paramSSLContext.init(!paramCollection.isEmpty() ? paramCollection.<KeyManager>toArray(new KeyManager[paramCollection.size()]) : null, !paramCollection1.isEmpty() ? paramCollection1.<TrustManager>toArray(new TrustManager[paramCollection1.size()]) : null, paramSecureRandom);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SSLContext build() throws NoSuchAlgorithmException, KeyManagementException {
/*     */     SSLContext sSLContext;
/* 382 */     String str = (this.protocol != null) ? this.protocol : "TLS";
/* 383 */     if (this.provider != null) {
/* 384 */       sSLContext = SSLContext.getInstance(str, this.provider);
/*     */     } else {
/* 386 */       sSLContext = SSLContext.getInstance(str);
/*     */     } 
/* 388 */     initSSLContext(sSLContext, this.keyManagers, this.trustManagers, this.secureRandom);
/* 389 */     return sSLContext;
/*     */   }
/*     */   
/*     */   static class TrustManagerDelegate
/*     */     implements X509TrustManager
/*     */   {
/*     */     private final X509TrustManager trustManager;
/*     */     private final TrustStrategy trustStrategy;
/*     */     
/*     */     TrustManagerDelegate(X509TrustManager param1X509TrustManager, TrustStrategy param1TrustStrategy) {
/* 399 */       this.trustManager = param1X509TrustManager;
/* 400 */       this.trustStrategy = param1TrustStrategy;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void checkClientTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) throws CertificateException {
/* 406 */       this.trustManager.checkClientTrusted(param1ArrayOfX509Certificate, param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void checkServerTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) throws CertificateException {
/* 412 */       if (!this.trustStrategy.isTrusted(param1ArrayOfX509Certificate, param1String)) {
/* 413 */         this.trustManager.checkServerTrusted(param1ArrayOfX509Certificate, param1String);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public X509Certificate[] getAcceptedIssuers() {
/* 419 */       return this.trustManager.getAcceptedIssuers();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class KeyManagerDelegate
/*     */     extends X509ExtendedKeyManager
/*     */   {
/*     */     private final X509ExtendedKeyManager keyManager;
/*     */     private final PrivateKeyStrategy aliasStrategy;
/*     */     
/*     */     KeyManagerDelegate(X509ExtendedKeyManager param1X509ExtendedKeyManager, PrivateKeyStrategy param1PrivateKeyStrategy) {
/* 431 */       this.keyManager = param1X509ExtendedKeyManager;
/* 432 */       this.aliasStrategy = param1PrivateKeyStrategy;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String[] getClientAliases(String param1String, Principal[] param1ArrayOfPrincipal) {
/* 438 */       return this.keyManager.getClientAliases(param1String, param1ArrayOfPrincipal);
/*     */     }
/*     */ 
/*     */     
/*     */     public Map<String, PrivateKeyDetails> getClientAliasMap(String[] param1ArrayOfString, Principal[] param1ArrayOfPrincipal) {
/* 443 */       HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 444 */       for (String str : param1ArrayOfString) {
/* 445 */         String[] arrayOfString = this.keyManager.getClientAliases(str, param1ArrayOfPrincipal);
/* 446 */         if (arrayOfString != null) {
/* 447 */           for (String str1 : arrayOfString) {
/* 448 */             hashMap.put(str1, new PrivateKeyDetails(str, this.keyManager.getCertificateChain(str1)));
/*     */           }
/*     */         }
/*     */       } 
/*     */       
/* 453 */       return (Map)hashMap;
/*     */     }
/*     */ 
/*     */     
/*     */     public Map<String, PrivateKeyDetails> getServerAliasMap(String param1String, Principal[] param1ArrayOfPrincipal) {
/* 458 */       HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 459 */       String[] arrayOfString = this.keyManager.getServerAliases(param1String, param1ArrayOfPrincipal);
/* 460 */       if (arrayOfString != null) {
/* 461 */         for (String str : arrayOfString) {
/* 462 */           hashMap.put(str, new PrivateKeyDetails(param1String, this.keyManager.getCertificateChain(str)));
/*     */         }
/*     */       }
/*     */       
/* 466 */       return (Map)hashMap;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String chooseClientAlias(String[] param1ArrayOfString, Principal[] param1ArrayOfPrincipal, Socket param1Socket) {
/* 472 */       Map<String, PrivateKeyDetails> map = getClientAliasMap(param1ArrayOfString, param1ArrayOfPrincipal);
/* 473 */       return this.aliasStrategy.chooseAlias(map, param1Socket);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String[] getServerAliases(String param1String, Principal[] param1ArrayOfPrincipal) {
/* 479 */       return this.keyManager.getServerAliases(param1String, param1ArrayOfPrincipal);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String chooseServerAlias(String param1String, Principal[] param1ArrayOfPrincipal, Socket param1Socket) {
/* 485 */       Map<String, PrivateKeyDetails> map = getServerAliasMap(param1String, param1ArrayOfPrincipal);
/* 486 */       return this.aliasStrategy.chooseAlias(map, param1Socket);
/*     */     }
/*     */ 
/*     */     
/*     */     public X509Certificate[] getCertificateChain(String param1String) {
/* 491 */       return this.keyManager.getCertificateChain(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     public PrivateKey getPrivateKey(String param1String) {
/* 496 */       return this.keyManager.getPrivateKey(param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String chooseEngineClientAlias(String[] param1ArrayOfString, Principal[] param1ArrayOfPrincipal, SSLEngine param1SSLEngine) {
/* 502 */       Map<String, PrivateKeyDetails> map = getClientAliasMap(param1ArrayOfString, param1ArrayOfPrincipal);
/* 503 */       return this.aliasStrategy.chooseAlias(map, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String chooseEngineServerAlias(String param1String, Principal[] param1ArrayOfPrincipal, SSLEngine param1SSLEngine) {
/* 509 */       Map<String, PrivateKeyDetails> map = getServerAliasMap(param1String, param1ArrayOfPrincipal);
/* 510 */       return this.aliasStrategy.chooseAlias(map, null);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 517 */     return "[provider=" + this.provider + ", protocol=" + this.protocol + ", keyStoreType=" + this.keyStoreType + ", keyManagerFactoryAlgorithm=" + this.keyManagerFactoryAlgorithm + ", keyManagers=" + this.keyManagers + ", trustManagerFactoryAlgorithm=" + this.trustManagerFactoryAlgorithm + ", trustManagers=" + this.trustManagers + ", secureRandom=" + this.secureRandom + "]";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\ssl\SSLContextBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */