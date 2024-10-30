/*    */ package org.apache.commons.net.util;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.security.GeneralSecurityException;
/*    */ import javax.net.ssl.KeyManager;
/*    */ import javax.net.ssl.SSLContext;
/*    */ import javax.net.ssl.TrustManager;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSLContextUtils
/*    */ {
/*    */   public static SSLContext createSSLContext(String paramString, KeyManager paramKeyManager, TrustManager paramTrustManager) throws IOException {
/* 48 */     (new KeyManager[1])[0] = paramKeyManager; (new TrustManager[1])[0] = paramTrustManager; return createSSLContext(paramString, (paramKeyManager == null) ? null : new KeyManager[1], (paramTrustManager == null) ? null : new TrustManager[1]);
/*    */   }
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
/*    */   public static SSLContext createSSLContext(String paramString, KeyManager[] paramArrayOfKeyManager, TrustManager[] paramArrayOfTrustManager) throws IOException {
/*    */     SSLContext sSLContext;
/*    */     try {
/* 65 */       sSLContext = SSLContext.getInstance(paramString);
/* 66 */       sSLContext.init(paramArrayOfKeyManager, paramArrayOfTrustManager, null);
/* 67 */     } catch (GeneralSecurityException generalSecurityException) {
/* 68 */       IOException iOException = new IOException("Could not initialize SSL context");
/* 69 */       iOException.initCause(generalSecurityException);
/* 70 */       throw iOException;
/*    */     } 
/* 72 */     return sSLContext;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\ne\\util\SSLContextUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */