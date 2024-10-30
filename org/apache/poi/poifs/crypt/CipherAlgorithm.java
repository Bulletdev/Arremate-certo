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
/*    */ 
/*    */ 
/*    */ public enum CipherAlgorithm
/*    */ {
/* 25 */   rc4(CipherProvider.rc4, "RC4", 26625, 64, new int[] { 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128 }, -1, 20, "RC4", false),
/*    */   
/* 27 */   aes128(CipherProvider.aes, "AES", 26126, 128, new int[] { 128 }, 16, 32, "AES", false),
/* 28 */   aes192(CipherProvider.aes, "AES", 26127, 192, new int[] { 192 }, 16, 32, "AES", false),
/* 29 */   aes256(CipherProvider.aes, "AES", 26128, 256, new int[] { 256 }, 16, 32, "AES", false),
/* 30 */   rc2(null, "RC2", -1, 128, new int[] { 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128 }, 8, 20, "RC2", false),
/* 31 */   des(null, "DES", -1, 64, new int[] { 64 }, 8, 32, "DES", false),
/*    */   
/* 33 */   des3(null, "DESede", -1, 192, new int[] { 192 }, 8, 32, "3DES", false),
/*    */ 
/*    */   
/* 36 */   des3_112(null, "DESede", -1, 128, new int[] { 128 }, 8, 32, "3DES_112", true),
/*    */   
/* 38 */   rsa(null, "RSA", -1, 1024, new int[] { 1024, 2048, 3072, 4096 }, -1, -1, "", false);
/*    */   
/*    */   public final CipherProvider provider;
/*    */   public final String jceId;
/*    */   public final int ecmaId;
/*    */   public final int defaultKeySize;
/*    */   public final int[] allowedKeySize;
/*    */   public final int blockSize;
/*    */   public final int encryptedVerifierHashLength;
/*    */   public final String xmlId;
/*    */   public final boolean needsBouncyCastle;
/*    */   
/*    */   CipherAlgorithm(CipherProvider paramCipherProvider, String paramString1, int paramInt1, int paramInt2, int[] paramArrayOfint, int paramInt3, int paramInt4, String paramString2, boolean paramBoolean) {
/* 51 */     this.provider = paramCipherProvider;
/* 52 */     this.jceId = paramString1;
/* 53 */     this.ecmaId = paramInt1;
/* 54 */     this.defaultKeySize = paramInt2;
/* 55 */     this.allowedKeySize = (int[])paramArrayOfint.clone();
/* 56 */     this.blockSize = paramInt3;
/* 57 */     this.encryptedVerifierHashLength = paramInt4;
/* 58 */     this.xmlId = paramString2;
/* 59 */     this.needsBouncyCastle = paramBoolean;
/*    */   }
/*    */   
/*    */   public static CipherAlgorithm fromEcmaId(int paramInt) {
/* 63 */     for (CipherAlgorithm cipherAlgorithm : values()) {
/* 64 */       if (cipherAlgorithm.ecmaId == paramInt) return cipherAlgorithm; 
/*    */     } 
/* 66 */     throw new EncryptedDocumentException("cipher algorithm " + paramInt + " not found");
/*    */   }
/*    */   
/*    */   public static CipherAlgorithm fromXmlId(String paramString, int paramInt) {
/* 70 */     for (CipherAlgorithm cipherAlgorithm : values()) {
/* 71 */       if (cipherAlgorithm.xmlId.equals(paramString))
/* 72 */         for (int i : cipherAlgorithm.allowedKeySize) {
/* 73 */           if (i == paramInt) return cipherAlgorithm; 
/*    */         }  
/*    */     } 
/* 76 */     throw new EncryptedDocumentException("cipher algorithm " + paramString + "/" + paramInt + " not found");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\CipherAlgorithm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */