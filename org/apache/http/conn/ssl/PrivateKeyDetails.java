/*    */ package org.apache.http.conn.ssl;
/*    */ 
/*    */ import java.security.cert.X509Certificate;
/*    */ import java.util.Arrays;
/*    */ import org.apache.http.util.Args;
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
/*    */ public final class PrivateKeyDetails
/*    */ {
/*    */   private final String type;
/*    */   private final X509Certificate[] certChain;
/*    */   
/*    */   public PrivateKeyDetails(String paramString, X509Certificate[] paramArrayOfX509Certificate) {
/* 49 */     this.type = (String)Args.notNull(paramString, "Private key type");
/* 50 */     this.certChain = paramArrayOfX509Certificate;
/*    */   }
/*    */   
/*    */   public String getType() {
/* 54 */     return this.type;
/*    */   }
/*    */   
/*    */   public X509Certificate[] getCertChain() {
/* 58 */     return this.certChain;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 63 */     return this.type + ':' + Arrays.toString((Object[])this.certChain);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\conn\ssl\PrivateKeyDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */