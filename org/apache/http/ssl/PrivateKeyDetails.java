/*    */ package org.apache.http.ssl;
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
/*    */ public final class PrivateKeyDetails
/*    */ {
/*    */   private final String type;
/*    */   private final X509Certificate[] certChain;
/*    */   
/*    */   public PrivateKeyDetails(String paramString, X509Certificate[] paramArrayOfX509Certificate) {
/* 46 */     this.type = (String)Args.notNull(paramString, "Private key type");
/* 47 */     this.certChain = paramArrayOfX509Certificate;
/*    */   }
/*    */   
/*    */   public String getType() {
/* 51 */     return this.type;
/*    */   }
/*    */   
/*    */   public X509Certificate[] getCertChain() {
/* 55 */     return this.certChain;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 60 */     return this.type + ':' + Arrays.toString((Object[])this.certChain);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\ssl\PrivateKeyDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */