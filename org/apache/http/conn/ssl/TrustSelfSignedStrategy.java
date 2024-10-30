/*    */ package org.apache.http.conn.ssl;
/*    */ 
/*    */ import java.security.cert.CertificateException;
/*    */ import java.security.cert.X509Certificate;
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
/*    */ public class TrustSelfSignedStrategy
/*    */   implements TrustStrategy
/*    */ {
/* 40 */   public static final TrustSelfSignedStrategy INSTANCE = new TrustSelfSignedStrategy();
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) throws CertificateException {
/* 45 */     return (paramArrayOfX509Certificate.length == 1);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\conn\ssl\TrustSelfSignedStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */