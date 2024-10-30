/*     */ package org.apache.commons.net.util;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.net.Socket;
/*     */ import java.security.GeneralSecurityException;
/*     */ import java.security.KeyStore;
/*     */ import java.security.KeyStoreException;
/*     */ import java.security.Principal;
/*     */ import java.security.PrivateKey;
/*     */ import java.security.cert.Certificate;
/*     */ import java.security.cert.X509Certificate;
/*     */ import java.util.Enumeration;
/*     */ import javax.net.ssl.KeyManager;
/*     */ import javax.net.ssl.X509ExtendedKeyManager;
/*     */ import org.apache.commons.net.io.Util;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class KeyManagerUtils
/*     */ {
/*  67 */   private static final String DEFAULT_STORE_TYPE = KeyStore.getDefaultType();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static KeyManager createClientKeyManager(KeyStore paramKeyStore, String paramString1, String paramString2) throws GeneralSecurityException {
/*  86 */     ClientKeyStore clientKeyStore = new ClientKeyStore(paramKeyStore, (paramString1 != null) ? paramString1 : findAlias(paramKeyStore), paramString2);
/*  87 */     return new X509KeyManager(clientKeyStore);
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
/*     */   public static KeyManager createClientKeyManager(String paramString1, File paramFile, String paramString2, String paramString3, String paramString4) throws IOException, GeneralSecurityException {
/* 107 */     KeyStore keyStore = loadStore(paramString1, paramFile, paramString2);
/* 108 */     return createClientKeyManager(keyStore, paramString3, paramString4);
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
/*     */   public static KeyManager createClientKeyManager(File paramFile, String paramString1, String paramString2) throws IOException, GeneralSecurityException {
/* 126 */     return createClientKeyManager(DEFAULT_STORE_TYPE, paramFile, paramString1, paramString2, paramString1);
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
/*     */   public static KeyManager createClientKeyManager(File paramFile, String paramString) throws IOException, GeneralSecurityException {
/* 144 */     return createClientKeyManager(DEFAULT_STORE_TYPE, paramFile, paramString, null, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   private static KeyStore loadStore(String paramString1, File paramFile, String paramString2) throws KeyStoreException, IOException, GeneralSecurityException {
/* 149 */     KeyStore keyStore = KeyStore.getInstance(paramString1);
/* 150 */     FileInputStream fileInputStream = null;
/*     */     try {
/* 152 */       fileInputStream = new FileInputStream(paramFile);
/* 153 */       keyStore.load(fileInputStream, paramString2.toCharArray());
/*     */     } finally {
/* 155 */       Util.closeQuietly(fileInputStream);
/*     */     } 
/* 157 */     return keyStore;
/*     */   }
/*     */   
/*     */   private static String findAlias(KeyStore paramKeyStore) throws KeyStoreException {
/* 161 */     Enumeration<String> enumeration = paramKeyStore.aliases();
/* 162 */     while (enumeration.hasMoreElements()) {
/* 163 */       String str = enumeration.nextElement();
/* 164 */       if (paramKeyStore.isKeyEntry(str)) {
/* 165 */         return str;
/*     */       }
/*     */     } 
/* 168 */     throw new KeyStoreException("Cannot find a private key entry");
/*     */   }
/*     */ 
/*     */   
/*     */   private static class ClientKeyStore
/*     */   {
/*     */     private final X509Certificate[] certChain;
/*     */     private final PrivateKey key;
/*     */     private final String keyAlias;
/*     */     
/*     */     ClientKeyStore(KeyStore param1KeyStore, String param1String1, String param1String2) throws GeneralSecurityException {
/* 179 */       this.keyAlias = param1String1;
/* 180 */       this.key = (PrivateKey)param1KeyStore.getKey(this.keyAlias, param1String2.toCharArray());
/* 181 */       Certificate[] arrayOfCertificate = param1KeyStore.getCertificateChain(this.keyAlias);
/* 182 */       X509Certificate[] arrayOfX509Certificate = new X509Certificate[arrayOfCertificate.length];
/* 183 */       for (byte b = 0; b < arrayOfCertificate.length; b++) {
/* 184 */         arrayOfX509Certificate[b] = (X509Certificate)arrayOfCertificate[b];
/*     */       }
/* 186 */       this.certChain = arrayOfX509Certificate;
/*     */     }
/*     */     
/*     */     final X509Certificate[] getCertificateChain() {
/* 190 */       return this.certChain;
/*     */     }
/*     */     
/*     */     final PrivateKey getPrivateKey() {
/* 194 */       return this.key;
/*     */     }
/*     */     
/*     */     final String getAlias() {
/* 198 */       return this.keyAlias;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class X509KeyManager
/*     */     extends X509ExtendedKeyManager {
/*     */     private final KeyManagerUtils.ClientKeyStore keyStore;
/*     */     
/*     */     X509KeyManager(KeyManagerUtils.ClientKeyStore param1ClientKeyStore) {
/* 207 */       this.keyStore = param1ClientKeyStore;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String chooseClientAlias(String[] param1ArrayOfString, Principal[] param1ArrayOfPrincipal, Socket param1Socket) {
/* 214 */       return this.keyStore.getAlias();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public X509Certificate[] getCertificateChain(String param1String) {
/* 220 */       return this.keyStore.getCertificateChain();
/*     */     }
/*     */ 
/*     */     
/*     */     public String[] getClientAliases(String param1String, Principal[] param1ArrayOfPrincipal) {
/* 225 */       return new String[] { this.keyStore.getAlias() };
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public PrivateKey getPrivateKey(String param1String) {
/* 231 */       return this.keyStore.getPrivateKey();
/*     */     }
/*     */ 
/*     */     
/*     */     public String[] getServerAliases(String param1String, Principal[] param1ArrayOfPrincipal) {
/* 236 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public String chooseServerAlias(String param1String, Principal[] param1ArrayOfPrincipal, Socket param1Socket) {
/* 241 */       return null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\ne\\util\KeyManagerUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */