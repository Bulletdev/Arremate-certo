/*     */ package org.apache.commons.net.util;
/*     */ 
/*     */ import java.security.GeneralSecurityException;
/*     */ import java.security.KeyStore;
/*     */ import java.security.cert.CertificateException;
/*     */ import java.security.cert.X509Certificate;
/*     */ import javax.net.ssl.TrustManagerFactory;
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
/*     */ public final class TrustManagerUtils
/*     */ {
/*     */   private static class TrustManager
/*     */     implements X509TrustManager
/*     */   {
/*     */     private final boolean checkServerValidity;
/*     */     
/*     */     TrustManager(boolean param1Boolean) {
/*  40 */       this.checkServerValidity = param1Boolean;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void checkClientTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void checkServerTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) throws CertificateException {
/*  55 */       if (this.checkServerValidity) {
/*  56 */         for (X509Certificate x509Certificate : param1ArrayOfX509Certificate)
/*     */         {
/*  58 */           x509Certificate.checkValidity();
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public X509Certificate[] getAcceptedIssuers() {
/*  69 */       return NetConstants.EMPTY_X509_CERTIFICATE_ARRAY;
/*     */     }
/*     */   }
/*     */   
/*  73 */   private static final X509TrustManager ACCEPT_ALL = new TrustManager(false);
/*     */   
/*  75 */   private static final X509TrustManager CHECK_SERVER_VALIDITY = new TrustManager(true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static X509TrustManager getAcceptAllTrustManager() {
/*  83 */     return ACCEPT_ALL;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static X509TrustManager getValidateServerCertificateTrustManager() {
/*  93 */     return CHECK_SERVER_VALIDITY;
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
/*     */   public static X509TrustManager getDefaultTrustManager(KeyStore paramKeyStore) throws GeneralSecurityException {
/* 108 */     String str = TrustManagerFactory.getDefaultAlgorithm();
/* 109 */     TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(str);
/* 110 */     trustManagerFactory.init(paramKeyStore);
/* 111 */     return (X509TrustManager)trustManagerFactory.getTrustManagers()[0];
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\ne\\util\TrustManagerUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */