/*    */ package org.apache.poi.poifs.crypt.cryptoapi;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import org.apache.poi.EncryptedDocumentException;
/*    */ import org.apache.poi.poifs.crypt.ChainingMode;
/*    */ import org.apache.poi.poifs.crypt.CipherAlgorithm;
/*    */ import org.apache.poi.poifs.crypt.CipherProvider;
/*    */ import org.apache.poi.poifs.crypt.HashAlgorithm;
/*    */ import org.apache.poi.poifs.crypt.standard.StandardEncryptionHeader;
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
/*    */ public class CryptoAPIEncryptionHeader
/*    */   extends StandardEncryptionHeader
/*    */ {
/*    */   public CryptoAPIEncryptionHeader(LittleEndianInput paramLittleEndianInput) throws IOException {
/* 33 */     super(paramLittleEndianInput);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected CryptoAPIEncryptionHeader(CipherAlgorithm paramCipherAlgorithm, HashAlgorithm paramHashAlgorithm, int paramInt1, int paramInt2, ChainingMode paramChainingMode) {
/* 39 */     super(paramCipherAlgorithm, paramHashAlgorithm, paramInt1, paramInt2, paramChainingMode);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setKeySize(int paramInt) {
/* 45 */     boolean bool = false;
/* 46 */     for (int i : (getCipherAlgorithm()).allowedKeySize) {
/* 47 */       if (i == paramInt) {
/* 48 */         bool = true;
/*    */         break;
/*    */       } 
/*    */     } 
/* 52 */     if (!bool) {
/* 53 */       throw new EncryptedDocumentException("invalid keysize " + paramInt + " for cipher algorithm " + getCipherAlgorithm());
/*    */     }
/* 55 */     super.setKeySize(paramInt);
/* 56 */     if (paramInt > 40) {
/* 57 */       setCspName("Microsoft Enhanced Cryptographic Provider v1.0");
/*    */     } else {
/* 59 */       setCspName(CipherProvider.rc4.cipherProviderName);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\cryptoapi\CryptoAPIEncryptionHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */