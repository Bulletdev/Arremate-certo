/*    */ package org.apache.http.ssl;
/*    */ 
/*    */ import java.security.KeyManagementException;
/*    */ import java.security.NoSuchAlgorithmException;
/*    */ import javax.net.ssl.SSLContext;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSLContexts
/*    */ {
/*    */   public static SSLContext createDefault() throws SSLInitializationException {
/*    */     try {
/* 51 */       SSLContext sSLContext = SSLContext.getInstance("TLS");
/* 52 */       sSLContext.init(null, null, null);
/* 53 */       return sSLContext;
/* 54 */     } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
/* 55 */       throw new SSLInitializationException(noSuchAlgorithmException.getMessage(), noSuchAlgorithmException);
/* 56 */     } catch (KeyManagementException keyManagementException) {
/* 57 */       throw new SSLInitializationException(keyManagementException.getMessage(), keyManagementException);
/*    */     } 
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
/*    */   public static SSLContext createSystemDefault() throws SSLInitializationException {
/*    */     try {
/* 72 */       return SSLContext.getDefault();
/* 73 */     } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
/* 74 */       return createDefault();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static SSLContextBuilder custom() {
/* 84 */     return SSLContextBuilder.create();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\ssl\SSLContexts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */