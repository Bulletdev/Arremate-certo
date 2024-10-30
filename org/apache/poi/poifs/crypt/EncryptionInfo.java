/*     */ package org.apache.poi.poifs.crypt;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.apache.poi.EncryptedDocumentException;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryNode;
/*     */ import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
/*     */ import org.apache.poi.poifs.filesystem.OPOIFSFileSystem;
/*     */ import org.apache.poi.poifs.filesystem.POIFSFileSystem;
/*     */ import org.apache.poi.util.BitField;
/*     */ import org.apache.poi.util.BitFieldFactory;
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
/*     */ public class EncryptionInfo
/*     */ {
/*     */   private final int versionMajor;
/*     */   private final int versionMinor;
/*     */   private final int encryptionFlags;
/*     */   private final EncryptionHeader header;
/*     */   private final EncryptionVerifier verifier;
/*     */   private final Decryptor decryptor;
/*     */   private final Encryptor encryptor;
/*  51 */   public static final BitField flagCryptoAPI = BitFieldFactory.getInstance(4);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  57 */   public static final BitField flagDocProps = BitFieldFactory.getInstance(8);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  63 */   public static final BitField flagExternal = BitFieldFactory.getInstance(16);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  69 */   public static final BitField flagAES = BitFieldFactory.getInstance(32);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EncryptionInfo(POIFSFileSystem paramPOIFSFileSystem) throws IOException {
/*  76 */     this(paramPOIFSFileSystem.getRoot());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EncryptionInfo(OPOIFSFileSystem paramOPOIFSFileSystem) throws IOException {
/*  82 */     this(paramOPOIFSFileSystem.getRoot());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EncryptionInfo(NPOIFSFileSystem paramNPOIFSFileSystem) throws IOException {
/*  88 */     this(paramNPOIFSFileSystem.getRoot());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EncryptionInfo(DirectoryNode paramDirectoryNode) throws IOException {
/*  94 */     this((LittleEndianInput)paramDirectoryNode.createDocumentInputStream("EncryptionInfo"), false);
/*     */   }
/*     */   public EncryptionInfo(LittleEndianInput paramLittleEndianInput, boolean paramBoolean) throws IOException {
/*     */     EncryptionMode encryptionMode;
/*     */     EncryptionInfoBuilder encryptionInfoBuilder;
/*  99 */     this.versionMajor = paramLittleEndianInput.readShort();
/* 100 */     this.versionMinor = paramLittleEndianInput.readShort();
/*     */     
/* 102 */     if (!paramBoolean && this.versionMajor == EncryptionMode.binaryRC4.versionMajor && this.versionMinor == EncryptionMode.binaryRC4.versionMinor) {
/*     */ 
/*     */       
/* 105 */       encryptionMode = EncryptionMode.binaryRC4;
/* 106 */       this.encryptionFlags = -1;
/* 107 */     } else if (!paramBoolean && this.versionMajor == EncryptionMode.agile.versionMajor && this.versionMinor == EncryptionMode.agile.versionMinor) {
/*     */ 
/*     */       
/* 110 */       encryptionMode = EncryptionMode.agile;
/* 111 */       this.encryptionFlags = paramLittleEndianInput.readInt();
/* 112 */     } else if (!paramBoolean && 2 <= this.versionMajor && this.versionMajor <= 4 && this.versionMinor == EncryptionMode.standard.versionMinor) {
/*     */ 
/*     */       
/* 115 */       encryptionMode = EncryptionMode.standard;
/* 116 */       this.encryptionFlags = paramLittleEndianInput.readInt();
/* 117 */     } else if (paramBoolean && 2 <= this.versionMajor && this.versionMajor <= 4 && this.versionMinor == EncryptionMode.cryptoAPI.versionMinor) {
/*     */ 
/*     */       
/* 120 */       encryptionMode = EncryptionMode.cryptoAPI;
/* 121 */       this.encryptionFlags = paramLittleEndianInput.readInt();
/*     */     } else {
/* 123 */       this.encryptionFlags = paramLittleEndianInput.readInt();
/* 124 */       throw new EncryptedDocumentException("Unknown encryption: version major: " + this.versionMajor + " / version minor: " + this.versionMinor + " / fCrypto: " + flagCryptoAPI.isSet(this.encryptionFlags) + " / fExternal: " + flagExternal.isSet(this.encryptionFlags) + " / fDocProps: " + flagDocProps.isSet(this.encryptionFlags) + " / fAES: " + flagAES.isSet(this.encryptionFlags));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 135 */       encryptionInfoBuilder = getBuilder(encryptionMode);
/* 136 */     } catch (Exception exception) {
/* 137 */       throw new IOException(exception);
/*     */     } 
/*     */     
/* 140 */     encryptionInfoBuilder.initialize(this, paramLittleEndianInput);
/* 141 */     this.header = encryptionInfoBuilder.getHeader();
/* 142 */     this.verifier = encryptionInfoBuilder.getVerifier();
/* 143 */     this.decryptor = encryptionInfoBuilder.getDecryptor();
/* 144 */     this.encryptor = encryptionInfoBuilder.getEncryptor();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EncryptionInfo(EncryptionMode paramEncryptionMode) {
/* 153 */     this(paramEncryptionMode, null, null, -1, -1, null);
/*     */   }
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
/*     */   public EncryptionInfo(EncryptionMode paramEncryptionMode, CipherAlgorithm paramCipherAlgorithm, HashAlgorithm paramHashAlgorithm, int paramInt1, int paramInt2, ChainingMode paramChainingMode) {
/*     */     EncryptionInfoBuilder encryptionInfoBuilder;
/* 178 */     this.versionMajor = paramEncryptionMode.versionMajor;
/* 179 */     this.versionMinor = paramEncryptionMode.versionMinor;
/* 180 */     this.encryptionFlags = paramEncryptionMode.encryptionFlags;
/*     */ 
/*     */     
/*     */     try {
/* 184 */       encryptionInfoBuilder = getBuilder(paramEncryptionMode);
/* 185 */     } catch (Exception exception) {
/* 186 */       throw new EncryptedDocumentException(exception);
/*     */     } 
/*     */     
/* 189 */     encryptionInfoBuilder.initialize(this, paramCipherAlgorithm, paramHashAlgorithm, paramInt1, paramInt2, paramChainingMode);
/*     */     
/* 191 */     this.header = encryptionInfoBuilder.getHeader();
/* 192 */     this.verifier = encryptionInfoBuilder.getVerifier();
/* 193 */     this.decryptor = encryptionInfoBuilder.getDecryptor();
/* 194 */     this.encryptor = encryptionInfoBuilder.getEncryptor();
/*     */   }
/*     */ 
/*     */   
/*     */   protected static EncryptionInfoBuilder getBuilder(EncryptionMode paramEncryptionMode) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
/* 199 */     ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
/*     */     
/* 201 */     return (EncryptionInfoBuilder)classLoader.loadClass(paramEncryptionMode.builder).newInstance();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getVersionMajor() {
/* 206 */     return this.versionMajor;
/*     */   }
/*     */   
/*     */   public int getVersionMinor() {
/* 210 */     return this.versionMinor;
/*     */   }
/*     */   
/*     */   public int getEncryptionFlags() {
/* 214 */     return this.encryptionFlags;
/*     */   }
/*     */   
/*     */   public EncryptionHeader getHeader() {
/* 218 */     return this.header;
/*     */   }
/*     */   
/*     */   public EncryptionVerifier getVerifier() {
/* 222 */     return this.verifier;
/*     */   }
/*     */   
/*     */   public Decryptor getDecryptor() {
/* 226 */     return this.decryptor;
/*     */   }
/*     */   
/*     */   public Encryptor getEncryptor() {
/* 230 */     return this.encryptor;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\EncryptionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */