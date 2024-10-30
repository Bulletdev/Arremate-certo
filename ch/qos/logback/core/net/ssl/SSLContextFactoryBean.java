/*     */ package ch.qos.logback.core.net.ssl;
/*     */ 
/*     */ import ch.qos.logback.core.spi.ContextAware;
/*     */ import java.security.KeyManagementException;
/*     */ import java.security.KeyStore;
/*     */ import java.security.KeyStoreException;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.security.NoSuchProviderException;
/*     */ import java.security.SecureRandom;
/*     */ import java.security.UnrecoverableKeyException;
/*     */ import java.security.cert.CertificateException;
/*     */ import javax.net.ssl.KeyManager;
/*     */ import javax.net.ssl.KeyManagerFactory;
/*     */ import javax.net.ssl.SSLContext;
/*     */ import javax.net.ssl.TrustManager;
/*     */ import javax.net.ssl.TrustManagerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSLContextFactoryBean
/*     */ {
/*     */   private static final String JSSE_KEY_STORE_PROPERTY = "javax.net.ssl.keyStore";
/*     */   private static final String JSSE_TRUST_STORE_PROPERTY = "javax.net.ssl.trustStore";
/*     */   private KeyStoreFactoryBean keyStore;
/*     */   private KeyStoreFactoryBean trustStore;
/*     */   private SecureRandomFactoryBean secureRandom;
/*     */   private KeyManagerFactoryFactoryBean keyManagerFactory;
/*     */   private TrustManagerFactoryFactoryBean trustManagerFactory;
/*     */   private String protocol;
/*     */   private String provider;
/*     */   
/*     */   public SSLContext createContext(ContextAware paramContextAware) throws NoSuchProviderException, NoSuchAlgorithmException, KeyManagementException, UnrecoverableKeyException, KeyStoreException, CertificateException {
/*  77 */     SSLContext sSLContext = (getProvider() != null) ? SSLContext.getInstance(getProtocol(), getProvider()) : SSLContext.getInstance(getProtocol());
/*     */     
/*  79 */     paramContextAware.addInfo("SSL protocol '" + sSLContext.getProtocol() + "' provider '" + sSLContext.getProvider() + "'");
/*     */     
/*  81 */     KeyManager[] arrayOfKeyManager = createKeyManagers(paramContextAware);
/*  82 */     TrustManager[] arrayOfTrustManager = createTrustManagers(paramContextAware);
/*  83 */     SecureRandom secureRandom = createSecureRandom(paramContextAware);
/*  84 */     sSLContext.init(arrayOfKeyManager, arrayOfTrustManager, secureRandom);
/*  85 */     return sSLContext;
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
/*     */   private KeyManager[] createKeyManagers(ContextAware paramContextAware) throws NoSuchProviderException, NoSuchAlgorithmException, UnrecoverableKeyException, KeyStoreException {
/* 103 */     if (getKeyStore() == null) {
/* 104 */       return null;
/*     */     }
/* 106 */     KeyStore keyStore = getKeyStore().createKeyStore();
/* 107 */     paramContextAware.addInfo("key store of type '" + keyStore.getType() + "' provider '" + keyStore.getProvider() + "': " + getKeyStore().getLocation());
/*     */     
/* 109 */     KeyManagerFactory keyManagerFactory = getKeyManagerFactory().createKeyManagerFactory();
/* 110 */     paramContextAware.addInfo("key manager algorithm '" + keyManagerFactory.getAlgorithm() + "' provider '" + keyManagerFactory.getProvider() + "'");
/*     */     
/* 112 */     char[] arrayOfChar = getKeyStore().getPassword().toCharArray();
/* 113 */     keyManagerFactory.init(keyStore, arrayOfChar);
/* 114 */     return keyManagerFactory.getKeyManagers();
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
/*     */   private TrustManager[] createTrustManagers(ContextAware paramContextAware) throws NoSuchProviderException, NoSuchAlgorithmException, KeyStoreException {
/* 132 */     if (getTrustStore() == null) {
/* 133 */       return null;
/*     */     }
/* 135 */     KeyStore keyStore = getTrustStore().createKeyStore();
/* 136 */     paramContextAware.addInfo("trust store of type '" + keyStore.getType() + "' provider '" + keyStore.getProvider() + "': " + getTrustStore().getLocation());
/*     */     
/* 138 */     TrustManagerFactory trustManagerFactory = getTrustManagerFactory().createTrustManagerFactory();
/* 139 */     paramContextAware.addInfo("trust manager algorithm '" + trustManagerFactory.getAlgorithm() + "' provider '" + trustManagerFactory.getProvider() + "'");
/*     */     
/* 141 */     trustManagerFactory.init(keyStore);
/* 142 */     return trustManagerFactory.getTrustManagers();
/*     */   }
/*     */ 
/*     */   
/*     */   private SecureRandom createSecureRandom(ContextAware paramContextAware) throws NoSuchProviderException, NoSuchAlgorithmException {
/* 147 */     SecureRandom secureRandom = getSecureRandom().createSecureRandom();
/* 148 */     paramContextAware.addInfo("secure random algorithm '" + secureRandom.getAlgorithm() + "' provider '" + secureRandom.getProvider() + "'");
/*     */     
/* 150 */     return secureRandom;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public KeyStoreFactoryBean getKeyStore() {
/* 159 */     if (this.keyStore == null) {
/* 160 */       this.keyStore = keyStoreFromSystemProperties("javax.net.ssl.keyStore");
/*     */     }
/* 162 */     return this.keyStore;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKeyStore(KeyStoreFactoryBean paramKeyStoreFactoryBean) {
/* 170 */     this.keyStore = paramKeyStoreFactoryBean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public KeyStoreFactoryBean getTrustStore() {
/* 179 */     if (this.trustStore == null) {
/* 180 */       this.trustStore = keyStoreFromSystemProperties("javax.net.ssl.trustStore");
/*     */     }
/* 182 */     return this.trustStore;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTrustStore(KeyStoreFactoryBean paramKeyStoreFactoryBean) {
/* 190 */     this.trustStore = paramKeyStoreFactoryBean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private KeyStoreFactoryBean keyStoreFromSystemProperties(String paramString) {
/* 200 */     if (System.getProperty(paramString) == null)
/* 201 */       return null; 
/* 202 */     KeyStoreFactoryBean keyStoreFactoryBean = new KeyStoreFactoryBean();
/* 203 */     keyStoreFactoryBean.setLocation(locationFromSystemProperty(paramString));
/* 204 */     keyStoreFactoryBean.setProvider(System.getProperty(paramString + "Provider"));
/* 205 */     keyStoreFactoryBean.setPassword(System.getProperty(paramString + "Password"));
/* 206 */     keyStoreFactoryBean.setType(System.getProperty(paramString + "Type"));
/* 207 */     return keyStoreFactoryBean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String locationFromSystemProperty(String paramString) {
/* 217 */     String str = System.getProperty(paramString);
/* 218 */     if (str != null && !str.startsWith("file:")) {
/* 219 */       str = "file:" + str;
/*     */     }
/* 221 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SecureRandomFactoryBean getSecureRandom() {
/* 230 */     if (this.secureRandom == null) {
/* 231 */       return new SecureRandomFactoryBean();
/*     */     }
/* 233 */     return this.secureRandom;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSecureRandom(SecureRandomFactoryBean paramSecureRandomFactoryBean) {
/* 241 */     this.secureRandom = paramSecureRandomFactoryBean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public KeyManagerFactoryFactoryBean getKeyManagerFactory() {
/* 250 */     if (this.keyManagerFactory == null) {
/* 251 */       return new KeyManagerFactoryFactoryBean();
/*     */     }
/* 253 */     return this.keyManagerFactory;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKeyManagerFactory(KeyManagerFactoryFactoryBean paramKeyManagerFactoryFactoryBean) {
/* 261 */     this.keyManagerFactory = paramKeyManagerFactoryFactoryBean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TrustManagerFactoryFactoryBean getTrustManagerFactory() {
/* 270 */     if (this.trustManagerFactory == null) {
/* 271 */       return new TrustManagerFactoryFactoryBean();
/*     */     }
/* 273 */     return this.trustManagerFactory;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTrustManagerFactory(TrustManagerFactoryFactoryBean paramTrustManagerFactoryFactoryBean) {
/* 281 */     this.trustManagerFactory = paramTrustManagerFactoryFactoryBean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getProtocol() {
/* 291 */     if (this.protocol == null) {
/* 292 */       return "SSL";
/*     */     }
/* 294 */     return this.protocol;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProtocol(String paramString) {
/* 304 */     this.protocol = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getProvider() {
/* 312 */     return this.provider;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProvider(String paramString) {
/* 321 */     this.provider = paramString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\net\ssl\SSLContextFactoryBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */