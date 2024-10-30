/*     */ package org.apache.poi.poifs.crypt.standard;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.apache.poi.EncryptedDocumentException;
/*     */ import org.apache.poi.poifs.crypt.ChainingMode;
/*     */ import org.apache.poi.poifs.crypt.CipherAlgorithm;
/*     */ import org.apache.poi.poifs.crypt.Decryptor;
/*     */ import org.apache.poi.poifs.crypt.EncryptionHeader;
/*     */ import org.apache.poi.poifs.crypt.EncryptionInfo;
/*     */ import org.apache.poi.poifs.crypt.EncryptionInfoBuilder;
/*     */ import org.apache.poi.poifs.crypt.EncryptionVerifier;
/*     */ import org.apache.poi.poifs.crypt.Encryptor;
/*     */ import org.apache.poi.poifs.crypt.HashAlgorithm;
/*     */ import org.apache.poi.util.LittleEndianInput;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StandardEncryptionInfoBuilder
/*     */   implements EncryptionInfoBuilder
/*     */ {
/*     */   EncryptionInfo info;
/*     */   StandardEncryptionHeader header;
/*     */   StandardEncryptionVerifier verifier;
/*     */   StandardDecryptor decryptor;
/*     */   StandardEncryptor encryptor;
/*     */   
/*     */   public void initialize(EncryptionInfo paramEncryptionInfo, LittleEndianInput paramLittleEndianInput) throws IOException {
/*  41 */     this.info = paramEncryptionInfo;
/*     */     
/*  43 */     paramLittleEndianInput.readInt();
/*  44 */     this.header = new StandardEncryptionHeader(paramLittleEndianInput);
/*  45 */     this.verifier = new StandardEncryptionVerifier(paramLittleEndianInput, this.header);
/*     */     
/*  47 */     if (paramEncryptionInfo.getVersionMinor() == 2 && (paramEncryptionInfo.getVersionMajor() == 3 || paramEncryptionInfo.getVersionMajor() == 4)) {
/*  48 */       this.decryptor = new StandardDecryptor(this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize(EncryptionInfo paramEncryptionInfo, CipherAlgorithm paramCipherAlgorithm, HashAlgorithm paramHashAlgorithm, int paramInt1, int paramInt2, ChainingMode paramChainingMode) {
/*  56 */     this.info = paramEncryptionInfo;
/*     */     
/*  58 */     if (paramCipherAlgorithm == null) {
/*  59 */       paramCipherAlgorithm = CipherAlgorithm.aes128;
/*     */     }
/*  61 */     if (paramCipherAlgorithm != CipherAlgorithm.aes128 && paramCipherAlgorithm != CipherAlgorithm.aes192 && paramCipherAlgorithm != CipherAlgorithm.aes256)
/*     */     {
/*     */       
/*  64 */       throw new EncryptedDocumentException("Standard encryption only supports AES128/192/256.");
/*     */     }
/*     */     
/*  67 */     if (paramHashAlgorithm == null) {
/*  68 */       paramHashAlgorithm = HashAlgorithm.sha1;
/*     */     }
/*  70 */     if (paramHashAlgorithm != HashAlgorithm.sha1) {
/*  71 */       throw new EncryptedDocumentException("Standard encryption only supports SHA-1.");
/*     */     }
/*  73 */     if (paramChainingMode == null) {
/*  74 */       paramChainingMode = ChainingMode.ecb;
/*     */     }
/*  76 */     if (paramChainingMode != ChainingMode.ecb) {
/*  77 */       throw new EncryptedDocumentException("Standard encryption only supports ECB chaining.");
/*     */     }
/*  79 */     if (paramInt1 == -1) {
/*  80 */       paramInt1 = paramCipherAlgorithm.defaultKeySize;
/*     */     }
/*  82 */     if (paramInt2 == -1) {
/*  83 */       paramInt2 = paramCipherAlgorithm.blockSize;
/*     */     }
/*  85 */     int i = 0;
/*  86 */     for (int j : paramCipherAlgorithm.allowedKeySize) {
/*  87 */       i |= (j == paramInt1) ? 1 : 0;
/*     */     }
/*  89 */     if (i == 0) {
/*  90 */       throw new EncryptedDocumentException("KeySize " + paramInt1 + " not allowed for Cipher " + paramCipherAlgorithm.toString());
/*     */     }
/*  92 */     this.header = new StandardEncryptionHeader(paramCipherAlgorithm, paramHashAlgorithm, paramInt1, paramInt2, paramChainingMode);
/*  93 */     this.verifier = new StandardEncryptionVerifier(paramCipherAlgorithm, paramHashAlgorithm, paramInt1, paramInt2, paramChainingMode);
/*  94 */     this.decryptor = new StandardDecryptor(this);
/*  95 */     this.encryptor = new StandardEncryptor(this);
/*     */   }
/*     */   
/*     */   public StandardEncryptionHeader getHeader() {
/*  99 */     return this.header;
/*     */   }
/*     */   
/*     */   public StandardEncryptionVerifier getVerifier() {
/* 103 */     return this.verifier;
/*     */   }
/*     */   
/*     */   public StandardDecryptor getDecryptor() {
/* 107 */     return this.decryptor;
/*     */   }
/*     */   
/*     */   public StandardEncryptor getEncryptor() {
/* 111 */     return this.encryptor;
/*     */   }
/*     */   
/*     */   public EncryptionInfo getEncryptionInfo() {
/* 115 */     return this.info;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\standard\StandardEncryptionInfoBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */