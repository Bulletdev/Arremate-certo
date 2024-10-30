/*     */ package org.apache.poi.poifs.crypt.binaryrc4;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.security.GeneralSecurityException;
/*     */ import java.security.MessageDigest;
/*     */ import java.util.Arrays;
/*     */ import javax.crypto.Cipher;
/*     */ import javax.crypto.SecretKey;
/*     */ import javax.crypto.spec.SecretKeySpec;
/*     */ import org.apache.poi.EncryptedDocumentException;
/*     */ import org.apache.poi.poifs.crypt.ChunkedCipherInputStream;
/*     */ import org.apache.poi.poifs.crypt.CryptoFunctions;
/*     */ import org.apache.poi.poifs.crypt.Decryptor;
/*     */ import org.apache.poi.poifs.crypt.EncryptionHeader;
/*     */ import org.apache.poi.poifs.crypt.EncryptionInfoBuilder;
/*     */ import org.apache.poi.poifs.crypt.EncryptionVerifier;
/*     */ import org.apache.poi.poifs.crypt.HashAlgorithm;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryNode;
/*     */ import org.apache.poi.poifs.filesystem.DocumentInputStream;
/*     */ import org.apache.poi.util.LittleEndian;
/*     */ import org.apache.poi.util.LittleEndianInput;
/*     */ import org.apache.poi.util.StringUtil;
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
/*     */ public class BinaryRC4Decryptor
/*     */   extends Decryptor
/*     */ {
/*  38 */   private long _length = -1L;
/*     */   
/*     */   private class BinaryRC4CipherInputStream
/*     */     extends ChunkedCipherInputStream
/*     */   {
/*     */     protected Cipher initCipherForBlock(Cipher param1Cipher, int param1Int) throws GeneralSecurityException {
/*  44 */       return BinaryRC4Decryptor.initCipherForBlock(param1Cipher, param1Int, BinaryRC4Decryptor.this.builder, BinaryRC4Decryptor.this.getSecretKey(), 2);
/*     */     }
/*     */ 
/*     */     
/*     */     public BinaryRC4CipherInputStream(DocumentInputStream param1DocumentInputStream, long param1Long) throws GeneralSecurityException {
/*  49 */       super((LittleEndianInput)param1DocumentInputStream, param1Long, 512);
/*     */     }
/*     */   }
/*     */   
/*     */   protected BinaryRC4Decryptor(BinaryRC4EncryptionInfoBuilder paramBinaryRC4EncryptionInfoBuilder) {
/*  54 */     super(paramBinaryRC4EncryptionInfoBuilder);
/*     */   }
/*     */   
/*     */   public boolean verifyPassword(String paramString) {
/*  58 */     EncryptionVerifier encryptionVerifier = this.builder.getVerifier();
/*  59 */     SecretKey secretKey = generateSecretKey(paramString, encryptionVerifier);
/*     */     try {
/*  61 */       Cipher cipher = initCipherForBlock((Cipher)null, 0, this.builder, secretKey, 2);
/*  62 */       byte[] arrayOfByte1 = encryptionVerifier.getEncryptedVerifier();
/*  63 */       byte[] arrayOfByte2 = new byte[arrayOfByte1.length];
/*  64 */       cipher.update(arrayOfByte1, 0, arrayOfByte1.length, arrayOfByte2);
/*  65 */       setVerifier(arrayOfByte2);
/*  66 */       byte[] arrayOfByte3 = encryptionVerifier.getEncryptedVerifierHash();
/*  67 */       byte[] arrayOfByte4 = cipher.doFinal(arrayOfByte3);
/*  68 */       HashAlgorithm hashAlgorithm = encryptionVerifier.getHashAlgorithm();
/*  69 */       MessageDigest messageDigest = CryptoFunctions.getMessageDigest(hashAlgorithm);
/*  70 */       byte[] arrayOfByte5 = messageDigest.digest(arrayOfByte2);
/*  71 */       if (Arrays.equals(arrayOfByte5, arrayOfByte4)) {
/*  72 */         setSecretKey(secretKey);
/*  73 */         return true;
/*     */       } 
/*  75 */     } catch (GeneralSecurityException generalSecurityException) {
/*  76 */       throw new EncryptedDocumentException(generalSecurityException);
/*     */     } 
/*  78 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected static Cipher initCipherForBlock(Cipher paramCipher, int paramInt1, EncryptionInfoBuilder paramEncryptionInfoBuilder, SecretKey paramSecretKey, int paramInt2) throws GeneralSecurityException {
/*  84 */     EncryptionVerifier encryptionVerifier = paramEncryptionInfoBuilder.getVerifier();
/*  85 */     HashAlgorithm hashAlgorithm = encryptionVerifier.getHashAlgorithm();
/*  86 */     byte[] arrayOfByte1 = new byte[4];
/*  87 */     LittleEndian.putUInt(arrayOfByte1, 0, paramInt1);
/*  88 */     byte[] arrayOfByte2 = CryptoFunctions.generateKey(paramSecretKey.getEncoded(), hashAlgorithm, arrayOfByte1, 16);
/*  89 */     SecretKeySpec secretKeySpec = new SecretKeySpec(arrayOfByte2, paramSecretKey.getAlgorithm());
/*  90 */     if (paramCipher == null) {
/*  91 */       EncryptionHeader encryptionHeader = paramEncryptionInfoBuilder.getHeader();
/*  92 */       paramCipher = CryptoFunctions.getCipher(secretKeySpec, encryptionHeader.getCipherAlgorithm(), null, null, paramInt2);
/*     */     } else {
/*  94 */       paramCipher.init(paramInt2, secretKeySpec);
/*     */     } 
/*  96 */     return paramCipher;
/*     */   }
/*     */ 
/*     */   
/*     */   protected static SecretKey generateSecretKey(String paramString, EncryptionVerifier paramEncryptionVerifier) {
/* 101 */     if (paramString.length() > 255)
/* 102 */       paramString = paramString.substring(0, 255); 
/* 103 */     HashAlgorithm hashAlgorithm = paramEncryptionVerifier.getHashAlgorithm();
/* 104 */     MessageDigest messageDigest = CryptoFunctions.getMessageDigest(hashAlgorithm);
/* 105 */     byte[] arrayOfByte1 = messageDigest.digest(StringUtil.getToUnicodeLE(paramString));
/* 106 */     byte[] arrayOfByte2 = paramEncryptionVerifier.getSalt();
/* 107 */     messageDigest.reset();
/* 108 */     for (byte b = 0; b < 16; b++) {
/* 109 */       messageDigest.update(arrayOfByte1, 0, 5);
/* 110 */       messageDigest.update(arrayOfByte2);
/*     */     } 
/*     */     
/* 113 */     arrayOfByte1 = new byte[5];
/* 114 */     System.arraycopy(messageDigest.digest(), 0, arrayOfByte1, 0, 5);
/* 115 */     return new SecretKeySpec(arrayOfByte1, (paramEncryptionVerifier.getCipherAlgorithm()).jceId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStream getDataStream(DirectoryNode paramDirectoryNode) throws IOException, GeneralSecurityException {
/* 122 */     DocumentInputStream documentInputStream = paramDirectoryNode.createDocumentInputStream("EncryptedPackage");
/* 123 */     this._length = documentInputStream.readLong();
/* 124 */     return (InputStream)new BinaryRC4CipherInputStream(documentInputStream, this._length);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getLength() {
/* 129 */     if (this._length == -1L) {
/* 130 */       throw new IllegalStateException("Decryptor.getDataStream() was not called");
/*     */     }
/*     */     
/* 133 */     return this._length;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\binaryrc4\BinaryRC4Decryptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */