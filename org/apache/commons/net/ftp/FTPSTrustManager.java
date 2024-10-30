/*    */ package org.apache.commons.net.ftp;
/*    */ 
/*    */ import java.security.cert.CertificateException;
/*    */ import java.security.cert.X509Certificate;
/*    */ import javax.net.ssl.X509TrustManager;
/*    */ import org.apache.commons.net.util.NetConstants;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Deprecated
/*    */ public class FTPSTrustManager
/*    */   implements X509TrustManager
/*    */ {
/*    */   public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {}
/*    */   
/*    */   public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) throws CertificateException {
/* 48 */     for (X509Certificate x509Certificate : paramArrayOfX509Certificate)
/*    */     {
/* 50 */       x509Certificate.checkValidity();
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public X509Certificate[] getAcceptedIssuers() {
/* 57 */     return NetConstants.EMPTY_X509_CERTIFICATE_ARRAY;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ftp\FTPSTrustManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */