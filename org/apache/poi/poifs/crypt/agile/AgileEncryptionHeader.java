/*     */ package org.apache.poi.poifs.crypt.agile;
/*     */ 
/*     */ import com.microsoft.schemas.office.x2006.encryption.CTDataIntegrity;
/*     */ import com.microsoft.schemas.office.x2006.encryption.CTKeyData;
/*     */ import com.microsoft.schemas.office.x2006.encryption.EncryptionDocument;
/*     */ import org.apache.poi.EncryptedDocumentException;
/*     */ import org.apache.poi.poifs.crypt.ChainingMode;
/*     */ import org.apache.poi.poifs.crypt.CipherAlgorithm;
/*     */ import org.apache.poi.poifs.crypt.EncryptionHeader;
/*     */ import org.apache.poi.poifs.crypt.HashAlgorithm;
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
/*     */ public class AgileEncryptionHeader
/*     */   extends EncryptionHeader
/*     */ {
/*     */   private byte[] encryptedHmacKey;
/*     */   private byte[] encryptedHmacValue;
/*     */   
/*     */   public AgileEncryptionHeader(String paramString) {
/*  34 */     this(AgileEncryptionInfoBuilder.parseDescriptor(paramString));
/*     */   }
/*     */   
/*     */   protected AgileEncryptionHeader(EncryptionDocument paramEncryptionDocument) {
/*     */     CTKeyData cTKeyData;
/*     */     try {
/*  40 */       cTKeyData = paramEncryptionDocument.getEncryption().getKeyData();
/*  41 */       if (cTKeyData == null) {
/*  42 */         throw new NullPointerException("keyData not set");
/*     */       }
/*  44 */     } catch (Exception exception) {
/*  45 */       throw new EncryptedDocumentException("Unable to parse keyData");
/*     */     } 
/*     */     
/*  48 */     setKeySize((int)cTKeyData.getKeyBits());
/*  49 */     setFlags(0);
/*  50 */     setSizeExtra(0);
/*  51 */     setCspName(null);
/*  52 */     setBlockSize(cTKeyData.getBlockSize());
/*     */     
/*  54 */     int i = (int)cTKeyData.getKeyBits();
/*     */     
/*  56 */     CipherAlgorithm cipherAlgorithm = CipherAlgorithm.fromXmlId(cTKeyData.getCipherAlgorithm().toString(), i);
/*  57 */     setCipherAlgorithm(cipherAlgorithm);
/*  58 */     setCipherProvider(cipherAlgorithm.provider);
/*     */     
/*  60 */     switch (cTKeyData.getCipherChaining().intValue()) {
/*     */       case 1:
/*  62 */         setChainingMode(ChainingMode.cbc);
/*     */         break;
/*     */       case 2:
/*  65 */         setChainingMode(ChainingMode.cfb);
/*     */         break;
/*     */       default:
/*  68 */         throw new EncryptedDocumentException("Unsupported chaining mode - " + cTKeyData.getCipherChaining().toString());
/*     */     } 
/*     */     
/*  71 */     int j = cTKeyData.getHashSize();
/*     */     
/*  73 */     HashAlgorithm hashAlgorithm = HashAlgorithm.fromEcmaId(cTKeyData.getHashAlgorithm().toString());
/*  74 */     setHashAlgorithm(hashAlgorithm);
/*     */     
/*  76 */     if ((getHashAlgorithmEx()).hashSize != j) {
/*  77 */       throw new EncryptedDocumentException("Unsupported hash algorithm: " + cTKeyData.getHashAlgorithm() + " @ " + j + " bytes");
/*     */     }
/*     */ 
/*     */     
/*  81 */     int k = cTKeyData.getSaltSize();
/*  82 */     setKeySalt(cTKeyData.getSaltValue());
/*  83 */     if ((getKeySalt()).length != k) {
/*  84 */       throw new EncryptedDocumentException("Invalid salt length");
/*     */     }
/*     */     
/*  87 */     CTDataIntegrity cTDataIntegrity = paramEncryptionDocument.getEncryption().getDataIntegrity();
/*  88 */     setEncryptedHmacKey(cTDataIntegrity.getEncryptedHmacKey());
/*  89 */     setEncryptedHmacValue(cTDataIntegrity.getEncryptedHmacValue());
/*     */   }
/*     */ 
/*     */   
/*     */   public AgileEncryptionHeader(CipherAlgorithm paramCipherAlgorithm, HashAlgorithm paramHashAlgorithm, int paramInt1, int paramInt2, ChainingMode paramChainingMode) {
/*  94 */     setCipherAlgorithm(paramCipherAlgorithm);
/*  95 */     setHashAlgorithm(paramHashAlgorithm);
/*  96 */     setKeySize(paramInt1);
/*  97 */     setBlockSize(paramInt2);
/*  98 */     setChainingMode(paramChainingMode);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void setKeySalt(byte[] paramArrayOfbyte) {
/* 103 */     if (paramArrayOfbyte == null || paramArrayOfbyte.length != getBlockSize()) {
/* 104 */       throw new EncryptedDocumentException("invalid verifier salt");
/*     */     }
/* 106 */     super.setKeySalt(paramArrayOfbyte);
/*     */   }
/*     */   
/*     */   public byte[] getEncryptedHmacKey() {
/* 110 */     return this.encryptedHmacKey;
/*     */   }
/*     */   
/*     */   protected void setEncryptedHmacKey(byte[] paramArrayOfbyte) {
/* 114 */     this.encryptedHmacKey = (paramArrayOfbyte == null) ? null : (byte[])paramArrayOfbyte.clone();
/*     */   }
/*     */   
/*     */   public byte[] getEncryptedHmacValue() {
/* 118 */     return this.encryptedHmacValue;
/*     */   }
/*     */   
/*     */   protected void setEncryptedHmacValue(byte[] paramArrayOfbyte) {
/* 122 */     this.encryptedHmacValue = (paramArrayOfbyte == null) ? null : (byte[])paramArrayOfbyte.clone();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\agile\AgileEncryptionHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */