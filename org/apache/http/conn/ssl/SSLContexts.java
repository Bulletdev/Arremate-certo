/*    */ package org.apache.http.conn.ssl;
/*    */ 
/*    */ import java.security.KeyManagementException;
/*    */ import java.security.NoSuchAlgorithmException;
/*    */ import javax.net.ssl.SSLContext;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ @Deprecated
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*    */ public class SSLContexts
/*    */ {
/*    */   public static SSLContext createDefault() throws SSLInitializationException {
/*    */     try {
/* 58 */       SSLContext sSLContext = SSLContext.getInstance("TLS");
/* 59 */       sSLContext.init(null, null, null);
/* 60 */       return sSLContext;
/* 61 */     } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
/* 62 */       throw new SSLInitializationException(noSuchAlgorithmException.getMessage(), noSuchAlgorithmException);
/* 63 */     } catch (KeyManagementException keyManagementException) {
/* 64 */       throw new SSLInitializationException(keyManagementException.getMessage(), keyManagementException);
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
/* 79 */       return SSLContext.getDefault();
/* 80 */     } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
/* 81 */       return createDefault();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static SSLContextBuilder custom() {
/* 91 */     return new SSLContextBuilder();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\conn\ssl\SSLContexts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */