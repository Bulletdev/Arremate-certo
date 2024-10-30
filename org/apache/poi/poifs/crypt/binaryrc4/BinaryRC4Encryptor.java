/*     */ package org.apache.poi.poifs.crypt.binaryrc4;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.security.GeneralSecurityException;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.SecureRandom;
/*     */ import javax.crypto.Cipher;
/*     */ import javax.crypto.SecretKey;
/*     */ import org.apache.poi.EncryptedDocumentException;
/*     */ import org.apache.poi.poifs.crypt.ChunkedCipherOutputStream;
/*     */ import org.apache.poi.poifs.crypt.CryptoFunctions;
/*     */ import org.apache.poi.poifs.crypt.DataSpaceMapUtils;
/*     */ import org.apache.poi.poifs.crypt.EncryptionInfo;
/*     */ import org.apache.poi.poifs.crypt.Encryptor;
/*     */ import org.apache.poi.poifs.crypt.HashAlgorithm;
/*     */ import org.apache.poi.poifs.crypt.standard.EncryptionRecord;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryEntry;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryNode;
/*     */ import org.apache.poi.util.LittleEndianByteArrayOutputStream;
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
/*     */ public class BinaryRC4Encryptor
/*     */   extends Encryptor
/*     */ {
/*     */   private final BinaryRC4EncryptionInfoBuilder builder;
/*     */   
/*     */   protected class BinaryRC4CipherOutputStream
/*     */     extends ChunkedCipherOutputStream
/*     */   {
/*     */     protected Cipher initCipherForBlock(Cipher param1Cipher, int param1Int, boolean param1Boolean) throws GeneralSecurityException {
/*  49 */       return BinaryRC4Decryptor.initCipherForBlock(param1Cipher, param1Int, BinaryRC4Encryptor.this.builder, BinaryRC4Encryptor.this.getSecretKey(), 1);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void calculateChecksum(File param1File, int param1Int) {}
/*     */ 
/*     */     
/*     */     protected void createEncryptionInfoEntry(DirectoryNode param1DirectoryNode, File param1File) throws IOException, GeneralSecurityException {
/*  57 */       BinaryRC4Encryptor.this.createEncryptionInfoEntry(param1DirectoryNode);
/*     */     }
/*     */ 
/*     */     
/*     */     public BinaryRC4CipherOutputStream(DirectoryNode param1DirectoryNode) throws IOException, GeneralSecurityException {
/*  62 */       super(param1DirectoryNode, 512);
/*     */     }
/*     */   }
/*     */   
/*     */   protected BinaryRC4Encryptor(BinaryRC4EncryptionInfoBuilder paramBinaryRC4EncryptionInfoBuilder) {
/*  67 */     this.builder = paramBinaryRC4EncryptionInfoBuilder;
/*     */   }
/*     */   
/*     */   public void confirmPassword(String paramString) {
/*  71 */     SecureRandom secureRandom = new SecureRandom();
/*  72 */     byte[] arrayOfByte1 = new byte[16];
/*  73 */     byte[] arrayOfByte2 = new byte[16];
/*  74 */     secureRandom.nextBytes(arrayOfByte1);
/*  75 */     secureRandom.nextBytes(arrayOfByte2);
/*  76 */     confirmPassword(paramString, (byte[])null, (byte[])null, arrayOfByte2, arrayOfByte1, (byte[])null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void confirmPassword(String paramString, byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, byte[] paramArrayOfbyte3, byte[] paramArrayOfbyte4, byte[] paramArrayOfbyte5) {
/*  82 */     BinaryRC4EncryptionVerifier binaryRC4EncryptionVerifier = this.builder.getVerifier();
/*  83 */     binaryRC4EncryptionVerifier.setSalt(paramArrayOfbyte4);
/*  84 */     SecretKey secretKey = BinaryRC4Decryptor.generateSecretKey(paramString, binaryRC4EncryptionVerifier);
/*  85 */     setSecretKey(secretKey);
/*     */     try {
/*  87 */       Cipher cipher = BinaryRC4Decryptor.initCipherForBlock(null, 0, this.builder, secretKey, 1);
/*  88 */       byte[] arrayOfByte1 = new byte[16];
/*  89 */       cipher.update(paramArrayOfbyte3, 0, 16, arrayOfByte1);
/*  90 */       binaryRC4EncryptionVerifier.setEncryptedVerifier(arrayOfByte1);
/*  91 */       HashAlgorithm hashAlgorithm = binaryRC4EncryptionVerifier.getHashAlgorithm();
/*     */       
/*  93 */       MessageDigest messageDigest = CryptoFunctions.getMessageDigest(hashAlgorithm);
/*  94 */       byte[] arrayOfByte2 = messageDigest.digest(paramArrayOfbyte3);
/*  95 */       byte[] arrayOfByte3 = cipher.doFinal(arrayOfByte2);
/*  96 */       binaryRC4EncryptionVerifier.setEncryptedVerifierHash(arrayOfByte3);
/*  97 */     } catch (GeneralSecurityException generalSecurityException) {
/*  98 */       throw new EncryptedDocumentException("Password confirmation failed", generalSecurityException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public OutputStream getDataStream(DirectoryNode paramDirectoryNode) throws IOException, GeneralSecurityException {
/* 104 */     return (OutputStream)new BinaryRC4CipherOutputStream(paramDirectoryNode);
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getKeySizeInBytes() {
/* 109 */     return this.builder.getHeader().getKeySize() / 8;
/*     */   }
/*     */   
/*     */   protected void createEncryptionInfoEntry(DirectoryNode paramDirectoryNode) throws IOException {
/* 113 */     DataSpaceMapUtils.addDefaultDataSpace((DirectoryEntry)paramDirectoryNode);
/* 114 */     final EncryptionInfo info = this.builder.getEncryptionInfo();
/* 115 */     final BinaryRC4EncryptionHeader header = this.builder.getHeader();
/* 116 */     final BinaryRC4EncryptionVerifier verifier = this.builder.getVerifier();
/* 117 */     EncryptionRecord encryptionRecord = new EncryptionRecord() {
/*     */         public void write(LittleEndianByteArrayOutputStream param1LittleEndianByteArrayOutputStream) {
/* 119 */           param1LittleEndianByteArrayOutputStream.writeShort(info.getVersionMajor());
/* 120 */           param1LittleEndianByteArrayOutputStream.writeShort(info.getVersionMinor());
/* 121 */           header.write(param1LittleEndianByteArrayOutputStream);
/* 122 */           verifier.write(param1LittleEndianByteArrayOutputStream);
/*     */         }
/*     */       };
/* 125 */     DataSpaceMapUtils.createEncryptionEntry((DirectoryEntry)paramDirectoryNode, "EncryptionInfo", encryptionRecord);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\binaryrc4\BinaryRC4Encryptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */