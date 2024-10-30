/*    */ package org.apache.poi.poifs.crypt.cryptoapi;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import org.apache.poi.poifs.crypt.ChainingMode;
/*    */ import org.apache.poi.poifs.crypt.CipherAlgorithm;
/*    */ import org.apache.poi.poifs.crypt.Decryptor;
/*    */ import org.apache.poi.poifs.crypt.EncryptionHeader;
/*    */ import org.apache.poi.poifs.crypt.EncryptionInfo;
/*    */ import org.apache.poi.poifs.crypt.EncryptionInfoBuilder;
/*    */ import org.apache.poi.poifs.crypt.EncryptionVerifier;
/*    */ import org.apache.poi.poifs.crypt.Encryptor;
/*    */ import org.apache.poi.poifs.crypt.HashAlgorithm;
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
/*    */ public class CryptoAPIEncryptionInfoBuilder
/*    */   implements EncryptionInfoBuilder
/*    */ {
/*    */   EncryptionInfo info;
/*    */   CryptoAPIEncryptionHeader header;
/*    */   CryptoAPIEncryptionVerifier verifier;
/*    */   CryptoAPIDecryptor decryptor;
/*    */   CryptoAPIEncryptor encryptor;
/*    */   
/*    */   public void initialize(EncryptionInfo paramEncryptionInfo, LittleEndianInput paramLittleEndianInput) throws IOException {
/* 40 */     this.info = paramEncryptionInfo;
/* 41 */     paramLittleEndianInput.readInt();
/* 42 */     this.header = new CryptoAPIEncryptionHeader(paramLittleEndianInput);
/* 43 */     this.verifier = new CryptoAPIEncryptionVerifier(paramLittleEndianInput, this.header);
/* 44 */     this.decryptor = new CryptoAPIDecryptor(this);
/* 45 */     this.encryptor = new CryptoAPIEncryptor(this);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void initialize(EncryptionInfo paramEncryptionInfo, CipherAlgorithm paramCipherAlgorithm, HashAlgorithm paramHashAlgorithm, int paramInt1, int paramInt2, ChainingMode paramChainingMode) {
/* 54 */     this.info = paramEncryptionInfo;
/* 55 */     if (paramCipherAlgorithm == null) paramCipherAlgorithm = CipherAlgorithm.rc4; 
/* 56 */     if (paramHashAlgorithm == null) paramHashAlgorithm = HashAlgorithm.sha1; 
/* 57 */     if (paramInt1 == -1) paramInt1 = 40; 
/* 58 */     assert paramCipherAlgorithm == CipherAlgorithm.rc4 && paramHashAlgorithm == HashAlgorithm.sha1;
/*    */     
/* 60 */     this.header = new CryptoAPIEncryptionHeader(paramCipherAlgorithm, paramHashAlgorithm, paramInt1, paramInt2, paramChainingMode);
/* 61 */     this.verifier = new CryptoAPIEncryptionVerifier(paramCipherAlgorithm, paramHashAlgorithm, paramInt1, paramInt2, paramChainingMode);
/* 62 */     this.decryptor = new CryptoAPIDecryptor(this);
/* 63 */     this.encryptor = new CryptoAPIEncryptor(this);
/*    */   }
/*    */   
/*    */   public CryptoAPIEncryptionHeader getHeader() {
/* 67 */     return this.header;
/*    */   }
/*    */   
/*    */   public CryptoAPIEncryptionVerifier getVerifier() {
/* 71 */     return this.verifier;
/*    */   }
/*    */   
/*    */   public CryptoAPIDecryptor getDecryptor() {
/* 75 */     return this.decryptor;
/*    */   }
/*    */   
/*    */   public CryptoAPIEncryptor getEncryptor() {
/* 79 */     return this.encryptor;
/*    */   }
/*    */   
/*    */   public EncryptionInfo getEncryptionInfo() {
/* 83 */     return this.info;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\cryptoapi\CryptoAPIEncryptionInfoBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */