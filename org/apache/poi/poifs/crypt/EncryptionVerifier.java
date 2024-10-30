/*     */ package org.apache.poi.poifs.crypt;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class EncryptionVerifier
/*     */ {
/*     */   private byte[] salt;
/*     */   private byte[] encryptedVerifier;
/*     */   private byte[] encryptedVerifierHash;
/*     */   private byte[] encryptedKey;
/*     */   private int spinCount;
/*     */   private CipherAlgorithm cipherAlgorithm;
/*     */   private ChainingMode chainingMode;
/*     */   private HashAlgorithm hashAlgorithm;
/*     */   
/*     */   public byte[] getSalt() {
/*  37 */     return this.salt;
/*     */   }
/*     */   
/*     */   public byte[] getEncryptedVerifier() {
/*  41 */     return this.encryptedVerifier;
/*     */   }
/*     */   
/*     */   public byte[] getEncryptedVerifierHash() {
/*  45 */     return this.encryptedVerifierHash;
/*     */   }
/*     */   
/*     */   public int getSpinCount() {
/*  49 */     return this.spinCount;
/*     */   }
/*     */   
/*     */   public int getCipherMode() {
/*  53 */     return this.chainingMode.ecmaId;
/*     */   }
/*     */   
/*     */   public int getAlgorithm() {
/*  57 */     return this.cipherAlgorithm.ecmaId;
/*     */   }
/*     */   
/*     */   public byte[] getEncryptedKey() {
/*  61 */     return this.encryptedKey;
/*     */   }
/*     */   
/*     */   public CipherAlgorithm getCipherAlgorithm() {
/*  65 */     return this.cipherAlgorithm;
/*     */   }
/*     */   
/*     */   public HashAlgorithm getHashAlgorithm() {
/*  69 */     return this.hashAlgorithm;
/*     */   }
/*     */   
/*     */   public ChainingMode getChainingMode() {
/*  73 */     return this.chainingMode;
/*     */   }
/*     */   
/*     */   protected void setSalt(byte[] paramArrayOfbyte) {
/*  77 */     this.salt = (paramArrayOfbyte == null) ? null : (byte[])paramArrayOfbyte.clone();
/*     */   }
/*     */   
/*     */   protected void setEncryptedVerifier(byte[] paramArrayOfbyte) {
/*  81 */     this.encryptedVerifier = (paramArrayOfbyte == null) ? null : (byte[])paramArrayOfbyte.clone();
/*     */   }
/*     */   
/*     */   protected void setEncryptedVerifierHash(byte[] paramArrayOfbyte) {
/*  85 */     this.encryptedVerifierHash = (paramArrayOfbyte == null) ? null : (byte[])paramArrayOfbyte.clone();
/*     */   }
/*     */   
/*     */   protected void setEncryptedKey(byte[] paramArrayOfbyte) {
/*  89 */     this.encryptedKey = (paramArrayOfbyte == null) ? null : (byte[])paramArrayOfbyte.clone();
/*     */   }
/*     */   
/*     */   protected void setSpinCount(int paramInt) {
/*  93 */     this.spinCount = paramInt;
/*     */   }
/*     */   
/*     */   protected void setCipherAlgorithm(CipherAlgorithm paramCipherAlgorithm) {
/*  97 */     this.cipherAlgorithm = paramCipherAlgorithm;
/*     */   }
/*     */   
/*     */   protected void setChainingMode(ChainingMode paramChainingMode) {
/* 101 */     this.chainingMode = paramChainingMode;
/*     */   }
/*     */   
/*     */   protected void setHashAlgorithm(HashAlgorithm paramHashAlgorithm) {
/* 105 */     this.hashAlgorithm = paramHashAlgorithm;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\EncryptionVerifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */