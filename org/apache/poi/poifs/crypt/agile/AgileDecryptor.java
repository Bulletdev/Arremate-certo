/*     */ package org.apache.poi.poifs.crypt.agile;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.security.GeneralSecurityException;
/*     */ import java.security.KeyPair;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.cert.X509Certificate;
/*     */ import java.util.Arrays;
/*     */ import javax.crypto.Cipher;
/*     */ import javax.crypto.Mac;
/*     */ import javax.crypto.SecretKey;
/*     */ import javax.crypto.spec.IvParameterSpec;
/*     */ import javax.crypto.spec.RC2ParameterSpec;
/*     */ import javax.crypto.spec.SecretKeySpec;
/*     */ import org.apache.poi.EncryptedDocumentException;
/*     */ import org.apache.poi.poifs.crypt.ChunkedCipherInputStream;
/*     */ import org.apache.poi.poifs.crypt.CipherAlgorithm;
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
/*     */ public class AgileDecryptor
/*     */   extends Decryptor
/*     */ {
/*  60 */   private long _length = -1L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  69 */   protected static final byte[] kVerifierInputBlock = new byte[] { -2, -89, -46, 118, 59, 75, -98, 121 };
/*     */ 
/*     */   
/*  72 */   protected static final byte[] kHashedVerifierBlock = new byte[] { -41, -86, 15, 109, 48, 97, 52, 78 };
/*     */ 
/*     */   
/*  75 */   protected static final byte[] kCryptoKeyBlock = new byte[] { 20, 110, 11, -25, -85, -84, -48, -42 };
/*     */ 
/*     */   
/*  78 */   protected static final byte[] kIntegrityKeyBlock = new byte[] { 95, -78, -83, 1, 12, -71, -31, -10 };
/*     */ 
/*     */   
/*  81 */   protected static final byte[] kIntegrityValueBlock = new byte[] { -96, 103, Byte.MAX_VALUE, 2, -78, 44, -124, 51 };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected AgileDecryptor(AgileEncryptionInfoBuilder paramAgileEncryptionInfoBuilder) {
/*  87 */     super(paramAgileEncryptionInfoBuilder);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean verifyPassword(String paramString) throws GeneralSecurityException {
/*  94 */     AgileEncryptionVerifier agileEncryptionVerifier = (AgileEncryptionVerifier)this.builder.getVerifier();
/*  95 */     AgileEncryptionHeader agileEncryptionHeader = (AgileEncryptionHeader)this.builder.getHeader();
/*  96 */     HashAlgorithm hashAlgorithm = agileEncryptionHeader.getHashAlgorithmEx();
/*  97 */     CipherAlgorithm cipherAlgorithm = agileEncryptionHeader.getCipherAlgorithm();
/*  98 */     int i = agileEncryptionHeader.getBlockSize();
/*  99 */     int j = agileEncryptionHeader.getKeySize() / 8;
/*     */     
/* 101 */     byte[] arrayOfByte1 = CryptoFunctions.hashPassword(paramString, agileEncryptionVerifier.getHashAlgorithm(), agileEncryptionVerifier.getSalt(), agileEncryptionVerifier.getSpinCount());
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
/* 116 */     byte[] arrayOfByte2 = hashInput(this.builder, arrayOfByte1, kVerifierInputBlock, agileEncryptionVerifier.getEncryptedVerifier(), 2);
/* 117 */     setVerifier(arrayOfByte2);
/* 118 */     MessageDigest messageDigest = CryptoFunctions.getMessageDigest(hashAlgorithm);
/* 119 */     byte[] arrayOfByte3 = messageDigest.digest(arrayOfByte2);
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
/* 133 */     byte[] arrayOfByte4 = hashInput(this.builder, arrayOfByte1, kHashedVerifierBlock, agileEncryptionVerifier.getEncryptedVerifierHash(), 2);
/* 134 */     arrayOfByte4 = CryptoFunctions.getBlock0(arrayOfByte4, hashAlgorithm.hashSize);
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
/* 149 */     byte[] arrayOfByte5 = hashInput(this.builder, arrayOfByte1, kCryptoKeyBlock, agileEncryptionVerifier.getEncryptedKey(), 2);
/* 150 */     arrayOfByte5 = CryptoFunctions.getBlock0(arrayOfByte5, j);
/* 151 */     SecretKeySpec secretKeySpec = new SecretKeySpec(arrayOfByte5, (agileEncryptionVerifier.getCipherAlgorithm()).jceId);
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
/* 166 */     byte[] arrayOfByte6 = CryptoFunctions.generateIv(hashAlgorithm, agileEncryptionHeader.getKeySalt(), kIntegrityKeyBlock, i);
/* 167 */     Cipher cipher = CryptoFunctions.getCipher(secretKeySpec, cipherAlgorithm, agileEncryptionVerifier.getChainingMode(), arrayOfByte6, 2);
/* 168 */     byte[] arrayOfByte7 = cipher.doFinal(agileEncryptionHeader.getEncryptedHmacKey());
/* 169 */     arrayOfByte7 = CryptoFunctions.getBlock0(arrayOfByte7, hashAlgorithm.hashSize);
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
/* 180 */     arrayOfByte6 = CryptoFunctions.generateIv(hashAlgorithm, agileEncryptionHeader.getKeySalt(), kIntegrityValueBlock, i);
/* 181 */     cipher = CryptoFunctions.getCipher(secretKeySpec, cipherAlgorithm, agileEncryptionVerifier.getChainingMode(), arrayOfByte6, 2);
/* 182 */     byte[] arrayOfByte8 = cipher.doFinal(agileEncryptionHeader.getEncryptedHmacValue());
/* 183 */     arrayOfByte8 = CryptoFunctions.getBlock0(arrayOfByte8, hashAlgorithm.hashSize);
/*     */     
/* 185 */     if (Arrays.equals(arrayOfByte4, arrayOfByte3)) {
/* 186 */       setSecretKey(secretKeySpec);
/* 187 */       setIntegrityHmacKey(arrayOfByte7);
/* 188 */       setIntegrityHmacValue(arrayOfByte8);
/* 189 */       return true;
/*     */     } 
/* 191 */     return false;
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
/*     */   public boolean verifyPassword(KeyPair paramKeyPair, X509Certificate paramX509Certificate) throws GeneralSecurityException {
/* 207 */     AgileEncryptionVerifier agileEncryptionVerifier = (AgileEncryptionVerifier)this.builder.getVerifier();
/* 208 */     AgileEncryptionHeader agileEncryptionHeader = (AgileEncryptionHeader)this.builder.getHeader();
/* 209 */     HashAlgorithm hashAlgorithm = agileEncryptionHeader.getHashAlgorithmEx();
/* 210 */     CipherAlgorithm cipherAlgorithm = agileEncryptionHeader.getCipherAlgorithm();
/* 211 */     int i = agileEncryptionHeader.getBlockSize();
/*     */     
/* 213 */     AgileEncryptionVerifier.AgileCertificateEntry agileCertificateEntry = null;
/* 214 */     for (AgileEncryptionVerifier.AgileCertificateEntry agileCertificateEntry1 : agileEncryptionVerifier.getCertificates()) {
/* 215 */       if (paramX509Certificate.equals(agileCertificateEntry1.x509)) {
/* 216 */         agileCertificateEntry = agileCertificateEntry1;
/*     */         break;
/*     */       } 
/*     */     } 
/* 220 */     if (agileCertificateEntry == null) return false;
/*     */     
/* 222 */     Cipher cipher = Cipher.getInstance("RSA");
/* 223 */     cipher.init(2, paramKeyPair.getPrivate());
/* 224 */     byte[] arrayOfByte1 = cipher.doFinal(agileCertificateEntry.encryptedKey);
/* 225 */     SecretKeySpec secretKeySpec = new SecretKeySpec(arrayOfByte1, (agileEncryptionVerifier.getCipherAlgorithm()).jceId);
/*     */     
/* 227 */     Mac mac = CryptoFunctions.getMac(hashAlgorithm);
/* 228 */     mac.init(secretKeySpec);
/* 229 */     byte[] arrayOfByte2 = mac.doFinal(agileCertificateEntry.x509.getEncoded());
/*     */     
/* 231 */     byte[] arrayOfByte3 = CryptoFunctions.generateIv(hashAlgorithm, agileEncryptionHeader.getKeySalt(), kIntegrityKeyBlock, i);
/* 232 */     cipher = CryptoFunctions.getCipher(secretKeySpec, cipherAlgorithm, agileEncryptionVerifier.getChainingMode(), arrayOfByte3, 2);
/* 233 */     byte[] arrayOfByte4 = cipher.doFinal(agileEncryptionHeader.getEncryptedHmacKey());
/* 234 */     arrayOfByte4 = CryptoFunctions.getBlock0(arrayOfByte4, hashAlgorithm.hashSize);
/*     */     
/* 236 */     arrayOfByte3 = CryptoFunctions.generateIv(hashAlgorithm, agileEncryptionHeader.getKeySalt(), kIntegrityValueBlock, i);
/* 237 */     cipher = CryptoFunctions.getCipher(secretKeySpec, cipherAlgorithm, agileEncryptionVerifier.getChainingMode(), arrayOfByte3, 2);
/* 238 */     byte[] arrayOfByte5 = cipher.doFinal(agileEncryptionHeader.getEncryptedHmacValue());
/* 239 */     arrayOfByte5 = CryptoFunctions.getBlock0(arrayOfByte5, hashAlgorithm.hashSize);
/*     */ 
/*     */     
/* 242 */     if (Arrays.equals(agileCertificateEntry.certVerifier, arrayOfByte2)) {
/* 243 */       setSecretKey(secretKeySpec);
/* 244 */       setIntegrityHmacKey(arrayOfByte4);
/* 245 */       setIntegrityHmacValue(arrayOfByte5);
/* 246 */       return true;
/*     */     } 
/* 248 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected static int getNextBlockSize(int paramInt1, int paramInt2) {
/*     */     int i;
/* 254 */     for (i = paramInt2; i < paramInt1; i += paramInt2);
/* 255 */     return i;
/*     */   }
/*     */   
/*     */   protected static byte[] hashInput(EncryptionInfoBuilder paramEncryptionInfoBuilder, byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, byte[] paramArrayOfbyte3, int paramInt) {
/* 259 */     EncryptionVerifier encryptionVerifier = paramEncryptionInfoBuilder.getVerifier();
/* 260 */     AgileDecryptor agileDecryptor = (AgileDecryptor)paramEncryptionInfoBuilder.getDecryptor();
/* 261 */     int i = agileDecryptor.getKeySizeInBytes();
/* 262 */     int j = agileDecryptor.getBlockSizeInBytes();
/* 263 */     HashAlgorithm hashAlgorithm = encryptionVerifier.getHashAlgorithm();
/* 264 */     byte[] arrayOfByte1 = encryptionVerifier.getSalt();
/*     */     
/* 266 */     byte[] arrayOfByte2 = CryptoFunctions.generateKey(paramArrayOfbyte1, hashAlgorithm, paramArrayOfbyte2, i);
/* 267 */     SecretKeySpec secretKeySpec = new SecretKeySpec(arrayOfByte2, (encryptionVerifier.getCipherAlgorithm()).jceId);
/* 268 */     byte[] arrayOfByte3 = CryptoFunctions.generateIv(hashAlgorithm, arrayOfByte1, null, j);
/* 269 */     Cipher cipher = CryptoFunctions.getCipher(secretKeySpec, encryptionVerifier.getCipherAlgorithm(), encryptionVerifier.getChainingMode(), arrayOfByte3, paramInt);
/*     */ 
/*     */     
/*     */     try {
/* 273 */       paramArrayOfbyte3 = CryptoFunctions.getBlock0(paramArrayOfbyte3, getNextBlockSize(paramArrayOfbyte3.length, j));
/* 274 */       return cipher.doFinal(paramArrayOfbyte3);
/*     */     }
/* 276 */     catch (GeneralSecurityException generalSecurityException) {
/* 277 */       throw new EncryptedDocumentException(generalSecurityException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream getDataStream(DirectoryNode paramDirectoryNode) throws IOException, GeneralSecurityException {
/* 283 */     DocumentInputStream documentInputStream = paramDirectoryNode.createDocumentInputStream("EncryptedPackage");
/* 284 */     this._length = documentInputStream.readLong();
/* 285 */     return (InputStream)new AgileCipherInputStream(documentInputStream, this._length);
/*     */   }
/*     */   
/*     */   public long getLength() {
/* 289 */     if (this._length == -1L) throw new IllegalStateException("EcmaDecryptor.getDataStream() was not called"); 
/* 290 */     return this._length;
/*     */   }
/*     */ 
/*     */   
/*     */   protected static Cipher initCipherForBlock(Cipher paramCipher, int paramInt1, boolean paramBoolean, EncryptionInfoBuilder paramEncryptionInfoBuilder, SecretKey paramSecretKey, int paramInt2) throws GeneralSecurityException {
/*     */     IvParameterSpec ivParameterSpec;
/* 296 */     EncryptionHeader encryptionHeader = paramEncryptionInfoBuilder.getHeader();
/* 297 */     if (paramCipher == null || paramBoolean) {
/* 298 */       String str = paramBoolean ? "PKCS5Padding" : "NoPadding";
/* 299 */       paramCipher = CryptoFunctions.getCipher(paramSecretKey, encryptionHeader.getCipherAlgorithm(), encryptionHeader.getChainingMode(), encryptionHeader.getKeySalt(), paramInt2, str);
/*     */     } 
/*     */     
/* 302 */     byte[] arrayOfByte1 = new byte[4];
/* 303 */     LittleEndian.putInt(arrayOfByte1, 0, paramInt1);
/* 304 */     byte[] arrayOfByte2 = CryptoFunctions.generateIv(encryptionHeader.getHashAlgorithmEx(), encryptionHeader.getKeySalt(), arrayOfByte1, encryptionHeader.getBlockSize());
/*     */ 
/*     */     
/* 307 */     if (encryptionHeader.getCipherAlgorithm() == CipherAlgorithm.rc2) {
/* 308 */       RC2ParameterSpec rC2ParameterSpec = new RC2ParameterSpec((paramSecretKey.getEncoded()).length * 8, arrayOfByte2);
/*     */     } else {
/* 310 */       ivParameterSpec = new IvParameterSpec(arrayOfByte2);
/*     */     } 
/*     */     
/* 313 */     paramCipher.init(paramInt2, paramSecretKey, ivParameterSpec);
/*     */     
/* 315 */     return paramCipher;
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
/*     */   private class AgileCipherInputStream
/*     */     extends ChunkedCipherInputStream
/*     */   {
/*     */     public AgileCipherInputStream(DocumentInputStream param1DocumentInputStream, long param1Long) throws GeneralSecurityException {
/* 336 */       super((LittleEndianInput)param1DocumentInputStream, param1Long, 4096);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected Cipher initCipherForBlock(Cipher param1Cipher, int param1Int) throws GeneralSecurityException {
/* 344 */       return AgileDecryptor.initCipherForBlock(param1Cipher, param1Int, false, AgileDecryptor.this.builder, AgileDecryptor.this.getSecretKey(), 2);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\agile\AgileDecryptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */