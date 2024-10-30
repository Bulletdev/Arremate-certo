/*    */ package org.apache.poi.poifs.crypt;
/*    */ 
/*    */ import org.apache.poi.EncryptedDocumentException;
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
/*    */ public enum CipherProvider
/*    */ {
/* 23 */   rc4("RC4", 1, "Microsoft Base Cryptographic Provider v1.0"),
/* 24 */   aes("AES", 24, "Microsoft Enhanced RSA and AES Cryptographic Provider");
/*    */   
/*    */   public static CipherProvider fromEcmaId(int paramInt) {
/* 27 */     for (CipherProvider cipherProvider : values()) {
/* 28 */       if (cipherProvider.ecmaId == paramInt) return cipherProvider; 
/*    */     } 
/* 30 */     throw new EncryptedDocumentException("cipher provider not found");
/*    */   }
/*    */   public final String jceId;
/*    */   public final int ecmaId;
/*    */   public final String cipherProviderName;
/*    */   
/*    */   CipherProvider(String paramString1, int paramInt1, String paramString2) {
/* 37 */     this.jceId = paramString1;
/* 38 */     this.ecmaId = paramInt1;
/* 39 */     this.cipherProviderName = paramString2;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\CipherProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */