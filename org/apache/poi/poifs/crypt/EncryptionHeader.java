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
/*     */ public abstract class EncryptionHeader
/*     */ {
/*  25 */   public static final int ALGORITHM_RC4 = CipherAlgorithm.rc4.ecmaId;
/*  26 */   public static final int ALGORITHM_AES_128 = CipherAlgorithm.aes128.ecmaId;
/*  27 */   public static final int ALGORITHM_AES_192 = CipherAlgorithm.aes192.ecmaId;
/*  28 */   public static final int ALGORITHM_AES_256 = CipherAlgorithm.aes256.ecmaId;
/*     */   
/*  30 */   public static final int HASH_NONE = HashAlgorithm.none.ecmaId;
/*  31 */   public static final int HASH_SHA1 = HashAlgorithm.sha1.ecmaId;
/*  32 */   public static final int HASH_SHA256 = HashAlgorithm.sha256.ecmaId;
/*  33 */   public static final int HASH_SHA384 = HashAlgorithm.sha384.ecmaId;
/*  34 */   public static final int HASH_SHA512 = HashAlgorithm.sha512.ecmaId;
/*     */   
/*  36 */   public static final int PROVIDER_RC4 = CipherProvider.rc4.ecmaId;
/*  37 */   public static final int PROVIDER_AES = CipherProvider.aes.ecmaId;
/*     */   
/*  39 */   public static final int MODE_ECB = ChainingMode.ecb.ecmaId;
/*  40 */   public static final int MODE_CBC = ChainingMode.cbc.ecmaId;
/*  41 */   public static final int MODE_CFB = ChainingMode.cfb.ecmaId;
/*     */   
/*     */   private int flags;
/*     */   
/*     */   private int sizeExtra;
/*     */   
/*     */   private CipherAlgorithm cipherAlgorithm;
/*     */   private HashAlgorithm hashAlgorithm;
/*     */   private int keyBits;
/*     */   private int blockSize;
/*     */   private CipherProvider providerType;
/*     */   private ChainingMode chainingMode;
/*     */   private byte[] keySalt;
/*     */   private String cspName;
/*     */   
/*     */   public ChainingMode getChainingMode() {
/*  57 */     return this.chainingMode;
/*     */   }
/*     */   
/*     */   protected void setChainingMode(ChainingMode paramChainingMode) {
/*  61 */     this.chainingMode = paramChainingMode;
/*     */   }
/*     */   
/*     */   public int getFlags() {
/*  65 */     return this.flags;
/*     */   }
/*     */   
/*     */   protected void setFlags(int paramInt) {
/*  69 */     this.flags = paramInt;
/*     */   }
/*     */   
/*     */   public int getSizeExtra() {
/*  73 */     return this.sizeExtra;
/*     */   }
/*     */   
/*     */   protected void setSizeExtra(int paramInt) {
/*  77 */     this.sizeExtra = paramInt;
/*     */   }
/*     */   
/*     */   public CipherAlgorithm getCipherAlgorithm() {
/*  81 */     return this.cipherAlgorithm;
/*     */   }
/*     */   
/*     */   protected void setCipherAlgorithm(CipherAlgorithm paramCipherAlgorithm) {
/*  85 */     this.cipherAlgorithm = paramCipherAlgorithm;
/*     */   }
/*     */   
/*     */   public HashAlgorithm getHashAlgorithmEx() {
/*  89 */     return this.hashAlgorithm;
/*     */   }
/*     */   
/*     */   protected void setHashAlgorithm(HashAlgorithm paramHashAlgorithm) {
/*  93 */     this.hashAlgorithm = paramHashAlgorithm;
/*     */   }
/*     */   
/*     */   public int getKeySize() {
/*  97 */     return this.keyBits;
/*     */   }
/*     */   
/*     */   protected void setKeySize(int paramInt) {
/* 101 */     this.keyBits = paramInt;
/*     */   }
/*     */   
/*     */   public int getBlockSize() {
/* 105 */     return this.blockSize;
/*     */   }
/*     */   
/*     */   protected void setBlockSize(int paramInt) {
/* 109 */     this.blockSize = paramInt;
/*     */   }
/*     */   
/*     */   public byte[] getKeySalt() {
/* 113 */     return this.keySalt;
/*     */   }
/*     */   
/*     */   protected void setKeySalt(byte[] paramArrayOfbyte) {
/* 117 */     this.keySalt = (paramArrayOfbyte == null) ? null : (byte[])paramArrayOfbyte.clone();
/*     */   }
/*     */   
/*     */   public CipherProvider getCipherProvider() {
/* 121 */     return this.providerType;
/*     */   }
/*     */   
/*     */   protected void setCipherProvider(CipherProvider paramCipherProvider) {
/* 125 */     this.providerType = paramCipherProvider;
/*     */   }
/*     */   
/*     */   public String getCspName() {
/* 129 */     return this.cspName;
/*     */   }
/*     */   
/*     */   protected void setCspName(String paramString) {
/* 133 */     this.cspName = paramString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\EncryptionHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */