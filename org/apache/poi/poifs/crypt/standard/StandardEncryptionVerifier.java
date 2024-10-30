/*     */ package org.apache.poi.poifs.crypt.standard;
/*     */ 
/*     */ import org.apache.poi.EncryptedDocumentException;
/*     */ import org.apache.poi.poifs.crypt.ChainingMode;
/*     */ import org.apache.poi.poifs.crypt.CipherAlgorithm;
/*     */ import org.apache.poi.poifs.crypt.EncryptionVerifier;
/*     */ import org.apache.poi.poifs.crypt.HashAlgorithm;
/*     */ import org.apache.poi.util.LittleEndianByteArrayOutputStream;
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
/*     */ 
/*     */ public class StandardEncryptionVerifier
/*     */   extends EncryptionVerifier
/*     */   implements EncryptionRecord
/*     */ {
/*     */   private static final int SPIN_COUNT = 50000;
/*     */   private final int verifierHashSize;
/*     */   
/*     */   protected StandardEncryptionVerifier(LittleEndianInput paramLittleEndianInput, StandardEncryptionHeader paramStandardEncryptionHeader) {
/*  35 */     int i = paramLittleEndianInput.readInt();
/*     */     
/*  37 */     if (i != 16) {
/*  38 */       throw new RuntimeException("Salt size != 16 !?");
/*     */     }
/*     */     
/*  41 */     byte[] arrayOfByte1 = new byte[16];
/*  42 */     paramLittleEndianInput.readFully(arrayOfByte1);
/*  43 */     setSalt(arrayOfByte1);
/*     */     
/*  45 */     byte[] arrayOfByte2 = new byte[16];
/*  46 */     paramLittleEndianInput.readFully(arrayOfByte2);
/*  47 */     setEncryptedVerifier(arrayOfByte2);
/*     */     
/*  49 */     this.verifierHashSize = paramLittleEndianInput.readInt();
/*     */     
/*  51 */     byte[] arrayOfByte3 = new byte[(paramStandardEncryptionHeader.getCipherAlgorithm()).encryptedVerifierHashLength];
/*  52 */     paramLittleEndianInput.readFully(arrayOfByte3);
/*  53 */     setEncryptedVerifierHash(arrayOfByte3);
/*     */     
/*  55 */     setSpinCount(50000);
/*  56 */     setCipherAlgorithm(paramStandardEncryptionHeader.getCipherAlgorithm());
/*  57 */     setChainingMode(paramStandardEncryptionHeader.getChainingMode());
/*  58 */     setEncryptedKey(null);
/*  59 */     setHashAlgorithm(paramStandardEncryptionHeader.getHashAlgorithmEx());
/*     */   }
/*     */   
/*     */   protected StandardEncryptionVerifier(CipherAlgorithm paramCipherAlgorithm, HashAlgorithm paramHashAlgorithm, int paramInt1, int paramInt2, ChainingMode paramChainingMode) {
/*  63 */     setCipherAlgorithm(paramCipherAlgorithm);
/*  64 */     setHashAlgorithm(paramHashAlgorithm);
/*  65 */     setChainingMode(paramChainingMode);
/*  66 */     setSpinCount(50000);
/*  67 */     this.verifierHashSize = paramHashAlgorithm.hashSize;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void setSalt(byte[] paramArrayOfbyte) {
/*  72 */     if (paramArrayOfbyte == null || paramArrayOfbyte.length != 16) {
/*  73 */       throw new EncryptedDocumentException("invalid verifier salt");
/*     */     }
/*  75 */     super.setSalt(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void setEncryptedVerifier(byte[] paramArrayOfbyte) {
/*  80 */     super.setEncryptedVerifier(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void setEncryptedVerifierHash(byte[] paramArrayOfbyte) {
/*  85 */     super.setEncryptedVerifierHash(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(LittleEndianByteArrayOutputStream paramLittleEndianByteArrayOutputStream) {
/*  90 */     byte[] arrayOfByte1 = getSalt();
/*  91 */     assert arrayOfByte1.length == 16;
/*  92 */     paramLittleEndianByteArrayOutputStream.writeInt(arrayOfByte1.length);
/*  93 */     paramLittleEndianByteArrayOutputStream.write(arrayOfByte1);
/*     */ 
/*     */     
/*  96 */     byte[] arrayOfByte2 = getEncryptedVerifier();
/*  97 */     assert arrayOfByte2.length == 16;
/*  98 */     paramLittleEndianByteArrayOutputStream.write(arrayOfByte2);
/*     */ 
/*     */ 
/*     */     
/* 102 */     paramLittleEndianByteArrayOutputStream.writeInt(20);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 110 */     byte[] arrayOfByte3 = getEncryptedVerifierHash();
/* 111 */     assert arrayOfByte3.length == (getCipherAlgorithm()).encryptedVerifierHashLength;
/* 112 */     paramLittleEndianByteArrayOutputStream.write(arrayOfByte3);
/*     */   }
/*     */   
/*     */   protected int getVerifierHashSize() {
/* 116 */     return this.verifierHashSize;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\standard\StandardEncryptionVerifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */