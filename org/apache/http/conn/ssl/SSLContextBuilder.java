/*     */ package org.apache.http.conn.ssl;
/*     */ 
/*     */ import java.net.Socket;
/*     */ import java.security.KeyManagementException;
/*     */ import java.security.KeyStore;
/*     */ import java.security.KeyStoreException;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.security.Principal;
/*     */ import java.security.PrivateKey;
/*     */ import java.security.SecureRandom;
/*     */ import java.security.UnrecoverableKeyException;
/*     */ import java.security.cert.CertificateException;
/*     */ import java.security.cert.X509Certificate;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import javax.net.ssl.KeyManager;
/*     */ import javax.net.ssl.KeyManagerFactory;
/*     */ import javax.net.ssl.SSLContext;
/*     */ import javax.net.ssl.TrustManager;
/*     */ import javax.net.ssl.TrustManagerFactory;
/*     */ import javax.net.ssl.X509KeyManager;
/*     */ import javax.net.ssl.X509TrustManager;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class SSLContextBuilder
/*     */ {
/*     */   static final String TLS = "TLS";
/*     */   static final String SSL = "SSL";
/*     */   private String protocol;
/*  75 */   private final Set<KeyManager> keymanagers = new LinkedHashSet<KeyManager>();
/*  76 */   private final Set<TrustManager> trustmanagers = new LinkedHashSet<TrustManager>();
/*     */   private SecureRandom secureRandom;
/*     */   
/*     */   public SSLContextBuilder useTLS() {
/*  80 */     this.protocol = "TLS";
/*  81 */     return this;
/*     */   }
/*     */   
/*     */   public SSLContextBuilder useSSL() {
/*  85 */     this.protocol = "SSL";
/*  86 */     return this;
/*     */   }
/*     */   
/*     */   public SSLContextBuilder useProtocol(String paramString) {
/*  90 */     this.protocol = paramString;
/*  91 */     return this;
/*     */   }
/*     */   
/*     */   public SSLContextBuilder setSecureRandom(SecureRandom paramSecureRandom) {
/*  95 */     this.secureRandom = paramSecureRandom;
/*  96 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SSLContextBuilder loadTrustMaterial(KeyStore paramKeyStore, TrustStrategy paramTrustStrategy) throws NoSuchAlgorithmException, KeyStoreException {
/* 102 */     TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
/*     */     
/* 104 */     trustManagerFactory.init(paramKeyStore);
/* 105 */     TrustManager[] arrayOfTrustManager = trustManagerFactory.getTrustManagers();
/* 106 */     if (arrayOfTrustManager != null) {
/* 107 */       if (paramTrustStrategy != null) {
/* 108 */         for (byte b = 0; b < arrayOfTrustManager.length; b++) {
/* 109 */           TrustManager trustManager = arrayOfTrustManager[b];
/* 110 */           if (trustManager instanceof X509TrustManager) {
/* 111 */             arrayOfTrustManager[b] = new TrustManagerDelegate((X509TrustManager)trustManager, paramTrustStrategy);
/*     */           }
/*     */         } 
/*     */       }
/*     */       
/* 116 */       Collections.addAll(this.trustmanagers, arrayOfTrustManager);
/*     */     } 
/* 118 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public SSLContextBuilder loadTrustMaterial(KeyStore paramKeyStore) throws NoSuchAlgorithmException, KeyStoreException {
/* 123 */     return loadTrustMaterial(paramKeyStore, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SSLContextBuilder loadKeyMaterial(KeyStore paramKeyStore, char[] paramArrayOfchar) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException {
/* 130 */     loadKeyMaterial(paramKeyStore, paramArrayOfchar, null);
/* 131 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SSLContextBuilder loadKeyMaterial(KeyStore paramKeyStore, char[] paramArrayOfchar, PrivateKeyStrategy paramPrivateKeyStrategy) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException {
/* 139 */     KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
/*     */     
/* 141 */     keyManagerFactory.init(paramKeyStore, paramArrayOfchar);
/* 142 */     KeyManager[] arrayOfKeyManager = keyManagerFactory.getKeyManagers();
/* 143 */     if (arrayOfKeyManager != null) {
/* 144 */       if (paramPrivateKeyStrategy != null) {
/* 145 */         for (byte b = 0; b < arrayOfKeyManager.length; b++) {
/* 146 */           KeyManager keyManager = arrayOfKeyManager[b];
/* 147 */           if (keyManager instanceof X509KeyManager) {
/* 148 */             arrayOfKeyManager[b] = new KeyManagerDelegate((X509KeyManager)keyManager, paramPrivateKeyStrategy);
/*     */           }
/*     */         } 
/*     */       }
/*     */       
/* 153 */       Collections.addAll(this.keymanagers, arrayOfKeyManager);
/*     */     } 
/* 155 */     return this;
/*     */   }
/*     */   
/*     */   public SSLContext build() throws NoSuchAlgorithmException, KeyManagementException {
/* 159 */     SSLContext sSLContext = SSLContext.getInstance((this.protocol != null) ? this.protocol : "TLS");
/*     */     
/* 161 */     sSLContext.init(!this.keymanagers.isEmpty() ? this.keymanagers.<KeyManager>toArray(new KeyManager[this.keymanagers.size()]) : null, !this.trustmanagers.isEmpty() ? this.trustmanagers.<TrustManager>toArray(new TrustManager[this.trustmanagers.size()]) : null, this.secureRandom);
/*     */ 
/*     */ 
/*     */     
/* 165 */     return sSLContext;
/*     */   }
/*     */   
/*     */   static class TrustManagerDelegate
/*     */     implements X509TrustManager
/*     */   {
/*     */     private final X509TrustManager trustManager;
/*     */     private final TrustStrategy trustStrategy;
/*     */     
/*     */     TrustManagerDelegate(X509TrustManager param1X509TrustManager, TrustStrategy param1TrustStrategy) {
/* 175 */       this.trustManager = param1X509TrustManager;
/* 176 */       this.trustStrategy = param1TrustStrategy;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void checkClientTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) throws CertificateException {
/* 182 */       this.trustManager.checkClientTrusted(param1ArrayOfX509Certificate, param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void checkServerTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) throws CertificateException {
/* 188 */       if (!this.trustStrategy.isTrusted(param1ArrayOfX509Certificate, param1String)) {
/* 189 */         this.trustManager.checkServerTrusted(param1ArrayOfX509Certificate, param1String);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public X509Certificate[] getAcceptedIssuers() {
/* 195 */       return this.trustManager.getAcceptedIssuers();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class KeyManagerDelegate
/*     */     implements X509KeyManager
/*     */   {
/*     */     private final X509KeyManager keyManager;
/*     */     private final PrivateKeyStrategy aliasStrategy;
/*     */     
/*     */     KeyManagerDelegate(X509KeyManager param1X509KeyManager, PrivateKeyStrategy param1PrivateKeyStrategy) {
/* 207 */       this.keyManager = param1X509KeyManager;
/* 208 */       this.aliasStrategy = param1PrivateKeyStrategy;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String[] getClientAliases(String param1String, Principal[] param1ArrayOfPrincipal) {
/* 214 */       return this.keyManager.getClientAliases(param1String, param1ArrayOfPrincipal);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String chooseClientAlias(String[] param1ArrayOfString, Principal[] param1ArrayOfPrincipal, Socket param1Socket) {
/* 220 */       HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 221 */       for (String str : param1ArrayOfString) {
/* 222 */         String[] arrayOfString = this.keyManager.getClientAliases(str, param1ArrayOfPrincipal);
/* 223 */         if (arrayOfString != null) {
/* 224 */           for (String str1 : arrayOfString) {
/* 225 */             hashMap.put(str1, new PrivateKeyDetails(str, this.keyManager.getCertificateChain(str1)));
/*     */           }
/*     */         }
/*     */       } 
/*     */       
/* 230 */       return this.aliasStrategy.chooseAlias((Map)hashMap, param1Socket);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String[] getServerAliases(String param1String, Principal[] param1ArrayOfPrincipal) {
/* 236 */       return this.keyManager.getServerAliases(param1String, param1ArrayOfPrincipal);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String chooseServerAlias(String param1String, Principal[] param1ArrayOfPrincipal, Socket param1Socket) {
/* 242 */       HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 243 */       String[] arrayOfString = this.keyManager.getServerAliases(param1String, param1ArrayOfPrincipal);
/* 244 */       if (arrayOfString != null) {
/* 245 */         for (String str : arrayOfString) {
/* 246 */           hashMap.put(str, new PrivateKeyDetails(param1String, this.keyManager.getCertificateChain(str)));
/*     */         }
/*     */       }
/*     */       
/* 250 */       return this.aliasStrategy.chooseAlias((Map)hashMap, param1Socket);
/*     */     }
/*     */ 
/*     */     
/*     */     public X509Certificate[] getCertificateChain(String param1String) {
/* 255 */       return this.keyManager.getCertificateChain(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     public PrivateKey getPrivateKey(String param1String) {
/* 260 */       return this.keyManager.getPrivateKey(param1String);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\conn\ssl\SSLContextBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */