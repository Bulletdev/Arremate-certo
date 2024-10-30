/*     */ package org.apache.poi.poifs.crypt;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.security.GeneralSecurityException;
/*     */ import javax.crypto.SecretKey;
/*     */ import org.apache.poi.EncryptedDocumentException;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryNode;
/*     */ import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
/*     */ import org.apache.poi.poifs.filesystem.OPOIFSFileSystem;
/*     */ import org.apache.poi.poifs.filesystem.POIFSFileSystem;
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
/*     */ public abstract class Decryptor
/*     */ {
/*     */   public static final String DEFAULT_PASSWORD = "VelvetSweatshop";
/*     */   public static final String DEFAULT_POIFS_ENTRY = "EncryptedPackage";
/*     */   protected final EncryptionInfoBuilder builder;
/*     */   private SecretKey secretKey;
/*     */   private byte[] verifier;
/*     */   private byte[] integrityHmacKey;
/*     */   private byte[] integrityHmacValue;
/*     */   
/*     */   protected Decryptor(EncryptionInfoBuilder paramEncryptionInfoBuilder) {
/*  40 */     this.builder = paramEncryptionInfoBuilder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract InputStream getDataStream(DirectoryNode paramDirectoryNode) throws IOException, GeneralSecurityException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean verifyPassword(String paramString) throws GeneralSecurityException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract long getLength();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Decryptor getInstance(EncryptionInfo paramEncryptionInfo) {
/*  78 */     Decryptor decryptor = paramEncryptionInfo.getDecryptor();
/*  79 */     if (decryptor == null) {
/*  80 */       throw new EncryptedDocumentException("Unsupported version");
/*     */     }
/*  82 */     return decryptor;
/*     */   }
/*     */   
/*     */   public InputStream getDataStream(NPOIFSFileSystem paramNPOIFSFileSystem) throws IOException, GeneralSecurityException {
/*  86 */     return getDataStream(paramNPOIFSFileSystem.getRoot());
/*     */   }
/*     */   public InputStream getDataStream(OPOIFSFileSystem paramOPOIFSFileSystem) throws IOException, GeneralSecurityException {
/*  89 */     return getDataStream(paramOPOIFSFileSystem.getRoot());
/*     */   }
/*     */   public InputStream getDataStream(POIFSFileSystem paramPOIFSFileSystem) throws IOException, GeneralSecurityException {
/*  92 */     return getDataStream(paramPOIFSFileSystem.getRoot());
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] getVerifier() {
/*  97 */     return this.verifier;
/*     */   }
/*     */   
/*     */   public SecretKey getSecretKey() {
/* 101 */     return this.secretKey;
/*     */   }
/*     */   
/*     */   public byte[] getIntegrityHmacKey() {
/* 105 */     return this.integrityHmacKey;
/*     */   }
/*     */   
/*     */   public byte[] getIntegrityHmacValue() {
/* 109 */     return this.integrityHmacValue;
/*     */   }
/*     */   
/*     */   protected void setSecretKey(SecretKey paramSecretKey) {
/* 113 */     this.secretKey = paramSecretKey;
/*     */   }
/*     */   
/*     */   protected void setVerifier(byte[] paramArrayOfbyte) {
/* 117 */     this.verifier = (paramArrayOfbyte == null) ? null : (byte[])paramArrayOfbyte.clone();
/*     */   }
/*     */   
/*     */   protected void setIntegrityHmacKey(byte[] paramArrayOfbyte) {
/* 121 */     this.integrityHmacKey = (paramArrayOfbyte == null) ? null : (byte[])paramArrayOfbyte.clone();
/*     */   }
/*     */   
/*     */   protected void setIntegrityHmacValue(byte[] paramArrayOfbyte) {
/* 125 */     this.integrityHmacValue = (paramArrayOfbyte == null) ? null : (byte[])paramArrayOfbyte.clone();
/*     */   }
/*     */   
/*     */   protected int getBlockSizeInBytes() {
/* 129 */     return this.builder.getHeader().getBlockSize();
/*     */   }
/*     */   
/*     */   protected int getKeySizeInBytes() {
/* 133 */     return this.builder.getHeader().getKeySize() / 8;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\Decryptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */