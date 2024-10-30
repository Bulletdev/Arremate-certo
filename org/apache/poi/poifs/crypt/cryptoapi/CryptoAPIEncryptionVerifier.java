/*    */ package org.apache.poi.poifs.crypt.cryptoapi;
/*    */ 
/*    */ import org.apache.poi.poifs.crypt.ChainingMode;
/*    */ import org.apache.poi.poifs.crypt.CipherAlgorithm;
/*    */ import org.apache.poi.poifs.crypt.HashAlgorithm;
/*    */ import org.apache.poi.poifs.crypt.standard.StandardEncryptionVerifier;
/*    */ import org.apache.poi.util.LittleEndianInput;
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
/*    */ public class CryptoAPIEncryptionVerifier
/*    */   extends StandardEncryptionVerifier
/*    */ {
/*    */   protected CryptoAPIEncryptionVerifier(LittleEndianInput paramLittleEndianInput, CryptoAPIEncryptionHeader paramCryptoAPIEncryptionHeader) {
/* 30 */     super(paramLittleEndianInput, paramCryptoAPIEncryptionHeader);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected CryptoAPIEncryptionVerifier(CipherAlgorithm paramCipherAlgorithm, HashAlgorithm paramHashAlgorithm, int paramInt1, int paramInt2, ChainingMode paramChainingMode) {
/* 36 */     super(paramCipherAlgorithm, paramHashAlgorithm, paramInt1, paramInt2, paramChainingMode);
/*    */   }
/*    */   
/*    */   protected void setSalt(byte[] paramArrayOfbyte) {
/* 40 */     super.setSalt(paramArrayOfbyte);
/*    */   }
/*    */   
/*    */   protected void setEncryptedVerifier(byte[] paramArrayOfbyte) {
/* 44 */     super.setEncryptedVerifier(paramArrayOfbyte);
/*    */   }
/*    */   
/*    */   protected void setEncryptedVerifierHash(byte[] paramArrayOfbyte) {
/* 48 */     super.setEncryptedVerifierHash(paramArrayOfbyte);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\cryptoapi\CryptoAPIEncryptionVerifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */