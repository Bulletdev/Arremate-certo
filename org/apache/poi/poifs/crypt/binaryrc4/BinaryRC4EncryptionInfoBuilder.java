/*    */ package org.apache.poi.poifs.crypt.binaryrc4;
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
/*    */ public class BinaryRC4EncryptionInfoBuilder
/*    */   implements EncryptionInfoBuilder
/*    */ {
/*    */   EncryptionInfo info;
/*    */   BinaryRC4EncryptionHeader header;
/*    */   BinaryRC4EncryptionVerifier verifier;
/*    */   BinaryRC4Decryptor decryptor;
/*    */   BinaryRC4Encryptor encryptor;
/*    */   
/*    */   public void initialize(EncryptionInfo paramEncryptionInfo, LittleEndianInput paramLittleEndianInput) throws IOException {
/* 37 */     this.info = paramEncryptionInfo;
/* 38 */     int i = paramEncryptionInfo.getVersionMajor();
/* 39 */     int j = paramEncryptionInfo.getVersionMinor();
/* 40 */     assert i == 1 && j == 1;
/*    */     
/* 42 */     this.header = new BinaryRC4EncryptionHeader();
/* 43 */     this.verifier = new BinaryRC4EncryptionVerifier(paramLittleEndianInput);
/* 44 */     this.decryptor = new BinaryRC4Decryptor(this);
/* 45 */     this.encryptor = new BinaryRC4Encryptor(this);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void initialize(EncryptionInfo paramEncryptionInfo, CipherAlgorithm paramCipherAlgorithm, HashAlgorithm paramHashAlgorithm, int paramInt1, int paramInt2, ChainingMode paramChainingMode) {
/* 51 */     this.info = paramEncryptionInfo;
/* 52 */     this.header = new BinaryRC4EncryptionHeader();
/* 53 */     this.verifier = new BinaryRC4EncryptionVerifier();
/* 54 */     this.decryptor = new BinaryRC4Decryptor(this);
/* 55 */     this.encryptor = new BinaryRC4Encryptor(this);
/*    */   }
/*    */   
/*    */   public BinaryRC4EncryptionHeader getHeader() {
/* 59 */     return this.header;
/*    */   }
/*    */   
/*    */   public BinaryRC4EncryptionVerifier getVerifier() {
/* 63 */     return this.verifier;
/*    */   }
/*    */   
/*    */   public BinaryRC4Decryptor getDecryptor() {
/* 67 */     return this.decryptor;
/*    */   }
/*    */   
/*    */   public BinaryRC4Encryptor getEncryptor() {
/* 71 */     return this.encryptor;
/*    */   }
/*    */   
/*    */   public EncryptionInfo getEncryptionInfo() {
/* 75 */     return this.info;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\binaryrc4\BinaryRC4EncryptionInfoBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */