/*     */ package org.apache.poi.poifs.crypt.standard;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.security.GeneralSecurityException;
/*     */ import java.security.MessageDigest;
/*     */ import java.util.Arrays;
/*     */ import javax.crypto.Cipher;
/*     */ import javax.crypto.CipherInputStream;
/*     */ import javax.crypto.SecretKey;
/*     */ import javax.crypto.spec.SecretKeySpec;
/*     */ import org.apache.poi.EncryptedDocumentException;
/*     */ import org.apache.poi.poifs.crypt.ChainingMode;
/*     */ import org.apache.poi.poifs.crypt.CryptoFunctions;
/*     */ import org.apache.poi.poifs.crypt.Decryptor;
/*     */ import org.apache.poi.poifs.crypt.EncryptionHeader;
/*     */ import org.apache.poi.poifs.crypt.EncryptionInfoBuilder;
/*     */ import org.apache.poi.poifs.crypt.EncryptionVerifier;
/*     */ import org.apache.poi.poifs.crypt.HashAlgorithm;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryNode;
/*     */ import org.apache.poi.poifs.filesystem.DocumentInputStream;
/*     */ import org.apache.poi.util.BoundedInputStream;
/*     */ import org.apache.poi.util.LittleEndian;
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
/*     */ public class StandardDecryptor
/*     */   extends Decryptor
/*     */ {
/*  48 */   private long _length = -1L;
/*     */   
/*     */   protected StandardDecryptor(EncryptionInfoBuilder paramEncryptionInfoBuilder) {
/*  51 */     super(paramEncryptionInfoBuilder);
/*     */   }
/*     */   
/*     */   public boolean verifyPassword(String paramString) {
/*  55 */     EncryptionVerifier encryptionVerifier = this.builder.getVerifier();
/*  56 */     SecretKey secretKey = generateSecretKey(paramString, encryptionVerifier, getKeySizeInBytes());
/*  57 */     Cipher cipher = getCipher(secretKey);
/*     */     
/*     */     try {
/*  60 */       byte[] arrayOfByte1 = encryptionVerifier.getEncryptedVerifier();
/*  61 */       byte[] arrayOfByte2 = cipher.doFinal(arrayOfByte1);
/*  62 */       setVerifier(arrayOfByte2);
/*  63 */       MessageDigest messageDigest = CryptoFunctions.getMessageDigest(encryptionVerifier.getHashAlgorithm());
/*  64 */       byte[] arrayOfByte3 = messageDigest.digest(arrayOfByte2);
/*  65 */       byte[] arrayOfByte4 = encryptionVerifier.getEncryptedVerifierHash();
/*  66 */       byte[] arrayOfByte5 = cipher.doFinal(arrayOfByte4);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  71 */       byte[] arrayOfByte6 = Arrays.copyOf(arrayOfByte5, arrayOfByte3.length);
/*     */       
/*  73 */       if (Arrays.equals(arrayOfByte3, arrayOfByte6)) {
/*  74 */         setSecretKey(secretKey);
/*  75 */         return true;
/*     */       } 
/*  77 */       return false;
/*     */     }
/*  79 */     catch (GeneralSecurityException generalSecurityException) {
/*  80 */       throw new EncryptedDocumentException(generalSecurityException);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected static SecretKey generateSecretKey(String paramString, EncryptionVerifier paramEncryptionVerifier, int paramInt) {
/*  85 */     HashAlgorithm hashAlgorithm = paramEncryptionVerifier.getHashAlgorithm();
/*     */     
/*  87 */     byte[] arrayOfByte1 = CryptoFunctions.hashPassword(paramString, hashAlgorithm, paramEncryptionVerifier.getSalt(), paramEncryptionVerifier.getSpinCount());
/*     */     
/*  89 */     byte[] arrayOfByte2 = new byte[4];
/*  90 */     LittleEndian.putInt(arrayOfByte2, 0, 0);
/*     */     
/*  92 */     byte[] arrayOfByte3 = CryptoFunctions.generateKey(arrayOfByte1, hashAlgorithm, arrayOfByte2, hashAlgorithm.hashSize);
/*  93 */     byte[] arrayOfByte4 = fillAndXor(arrayOfByte3, (byte)54);
/*  94 */     byte[] arrayOfByte5 = fillAndXor(arrayOfByte3, (byte)92);
/*     */     
/*  96 */     byte[] arrayOfByte6 = new byte[arrayOfByte4.length + arrayOfByte5.length];
/*  97 */     System.arraycopy(arrayOfByte4, 0, arrayOfByte6, 0, arrayOfByte4.length);
/*  98 */     System.arraycopy(arrayOfByte5, 0, arrayOfByte6, arrayOfByte4.length, arrayOfByte5.length);
/*     */     
/* 100 */     byte[] arrayOfByte7 = Arrays.copyOf(arrayOfByte6, paramInt);
/*     */     
/* 102 */     return new SecretKeySpec(arrayOfByte7, (paramEncryptionVerifier.getCipherAlgorithm()).jceId);
/*     */   }
/*     */ 
/*     */   
/*     */   protected static byte[] fillAndXor(byte[] paramArrayOfbyte, byte paramByte) {
/* 107 */     byte[] arrayOfByte = new byte[64];
/* 108 */     Arrays.fill(arrayOfByte, paramByte);
/*     */     
/* 110 */     for (byte b = 0; b < paramArrayOfbyte.length; b++) {
/* 111 */       arrayOfByte[b] = (byte)(arrayOfByte[b] ^ paramArrayOfbyte[b]);
/*     */     }
/*     */     
/* 114 */     MessageDigest messageDigest = CryptoFunctions.getMessageDigest(HashAlgorithm.sha1);
/* 115 */     return messageDigest.digest(arrayOfByte);
/*     */   }
/*     */   
/*     */   private Cipher getCipher(SecretKey paramSecretKey) {
/* 119 */     EncryptionHeader encryptionHeader = this.builder.getHeader();
/* 120 */     ChainingMode chainingMode = encryptionHeader.getChainingMode();
/* 121 */     assert chainingMode == ChainingMode.ecb;
/* 122 */     return CryptoFunctions.getCipher(paramSecretKey, encryptionHeader.getCipherAlgorithm(), chainingMode, null, 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream getDataStream(DirectoryNode paramDirectoryNode) throws IOException {
/* 127 */     DocumentInputStream documentInputStream = paramDirectoryNode.createDocumentInputStream("EncryptedPackage");
/*     */     
/* 129 */     this._length = documentInputStream.readLong();
/*     */     
/* 131 */     if (getSecretKey() == null) {
/* 132 */       verifyPassword((String)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 137 */     int i = (this.builder.getHeader().getCipherAlgorithm()).blockSize;
/* 138 */     long l = (this._length / i + 1L) * i;
/* 139 */     Cipher cipher = getCipher(getSecretKey());
/*     */     
/* 141 */     BoundedInputStream boundedInputStream = new BoundedInputStream((InputStream)documentInputStream, l);
/* 142 */     return (InputStream)new BoundedInputStream(new CipherInputStream((InputStream)boundedInputStream, cipher), this._length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getLength() {
/* 149 */     if (this._length == -1L) throw new IllegalStateException("Decryptor.getDataStream() was not called"); 
/* 150 */     return this._length;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\standard\StandardDecryptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */