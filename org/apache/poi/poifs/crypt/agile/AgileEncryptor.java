/*     */ package org.apache.poi.poifs.crypt.agile;
/*     */ 
/*     */ import com.microsoft.schemas.office.x2006.encryption.CTDataIntegrity;
/*     */ import com.microsoft.schemas.office.x2006.encryption.CTEncryption;
/*     */ import com.microsoft.schemas.office.x2006.encryption.CTKeyData;
/*     */ import com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor;
/*     */ import com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptors;
/*     */ import com.microsoft.schemas.office.x2006.encryption.EncryptionDocument;
/*     */ import com.microsoft.schemas.office.x2006.encryption.STCipherAlgorithm;
/*     */ import com.microsoft.schemas.office.x2006.encryption.STCipherChaining;
/*     */ import com.microsoft.schemas.office.x2006.encryption.STHashAlgorithm;
/*     */ import com.microsoft.schemas.office.x2006.keyEncryptor.certificate.CTCertificateKeyEncryptor;
/*     */ import com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.security.GeneralSecurityException;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.SecureRandom;
/*     */ import java.security.cert.CertificateEncodingException;
/*     */ import java.util.HashMap;
/*     */ import javax.crypto.Cipher;
/*     */ import javax.crypto.Mac;
/*     */ import javax.crypto.spec.SecretKeySpec;
/*     */ import org.apache.poi.EncryptedDocumentException;
/*     */ import org.apache.poi.poifs.crypt.ChainingMode;
/*     */ import org.apache.poi.poifs.crypt.ChunkedCipherOutputStream;
/*     */ import org.apache.poi.poifs.crypt.CryptoFunctions;
/*     */ import org.apache.poi.poifs.crypt.DataSpaceMapUtils;
/*     */ import org.apache.poi.poifs.crypt.EncryptionInfo;
/*     */ import org.apache.poi.poifs.crypt.Encryptor;
/*     */ import org.apache.poi.poifs.crypt.HashAlgorithm;
/*     */ import org.apache.poi.poifs.crypt.standard.EncryptionRecord;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryEntry;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryNode;
/*     */ import org.apache.poi.util.LittleEndian;
/*     */ import org.apache.poi.util.LittleEndianByteArrayOutputStream;
/*     */ import org.apache.xmlbeans.XmlOptions;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AgileEncryptor
/*     */   extends Encryptor
/*     */ {
/*     */   private final AgileEncryptionInfoBuilder builder;
/*     */   private byte[] integritySalt;
/*     */   private byte[] pwHash;
/*     */   private final CTKeyEncryptor.Uri.Enum passwordUri;
/*     */   private final CTKeyEncryptor.Uri.Enum certificateUri;
/*     */   
/*     */   protected AgileEncryptor(AgileEncryptionInfoBuilder paramAgileEncryptionInfoBuilder) {
/* 268 */     this.passwordUri = CTKeyEncryptor.Uri.HTTP_SCHEMAS_MICROSOFT_COM_OFFICE_2006_KEY_ENCRYPTOR_PASSWORD;
/*     */     
/* 270 */     this.certificateUri = CTKeyEncryptor.Uri.HTTP_SCHEMAS_MICROSOFT_COM_OFFICE_2006_KEY_ENCRYPTOR_CERTIFICATE; this.builder = paramAgileEncryptionInfoBuilder;
/*     */   }
/*     */   public void confirmPassword(String paramString) { SecureRandom secureRandom = new SecureRandom(); int i = this.builder.getHeader().getBlockSize(); int j = this.builder.getHeader().getKeySize() / 8; int k = (this.builder.getHeader().getHashAlgorithmEx()).hashSize; byte[] arrayOfByte1 = new byte[i]; byte[] arrayOfByte2 = new byte[i]; byte[] arrayOfByte3 = new byte[i]; byte[] arrayOfByte4 = new byte[j]; byte[] arrayOfByte5 = new byte[k]; secureRandom.nextBytes(arrayOfByte1); secureRandom.nextBytes(arrayOfByte2); secureRandom.nextBytes(arrayOfByte3); secureRandom.nextBytes(arrayOfByte4); secureRandom.nextBytes(arrayOfByte5); confirmPassword(paramString, arrayOfByte4, arrayOfByte3, arrayOfByte1, arrayOfByte2, arrayOfByte5); } public void confirmPassword(String paramString, byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, byte[] paramArrayOfbyte3, byte[] paramArrayOfbyte4, byte[] paramArrayOfbyte5) { AgileEncryptionVerifier agileEncryptionVerifier = this.builder.getVerifier(); agileEncryptionVerifier.setSalt(paramArrayOfbyte4); AgileEncryptionHeader agileEncryptionHeader = this.builder.getHeader(); agileEncryptionHeader.setKeySalt(paramArrayOfbyte2); HashAlgorithm hashAlgorithm = agileEncryptionVerifier.getHashAlgorithm(); int i = agileEncryptionHeader.getBlockSize(); this.pwHash = CryptoFunctions.hashPassword(paramString, hashAlgorithm, paramArrayOfbyte4, agileEncryptionVerifier.getSpinCount()); byte[] arrayOfByte1 = AgileDecryptor.hashInput(this.builder, this.pwHash, AgileDecryptor.kVerifierInputBlock, paramArrayOfbyte3, 1); agileEncryptionVerifier.setEncryptedVerifier(arrayOfByte1); MessageDigest messageDigest = CryptoFunctions.getMessageDigest(hashAlgorithm); byte[] arrayOfByte2 = messageDigest.digest(paramArrayOfbyte3); byte[] arrayOfByte3 = AgileDecryptor.hashInput(this.builder, this.pwHash, AgileDecryptor.kHashedVerifierBlock, arrayOfByte2, 1); agileEncryptionVerifier.setEncryptedVerifierHash(arrayOfByte3); byte[] arrayOfByte4 = AgileDecryptor.hashInput(this.builder, this.pwHash, AgileDecryptor.kCryptoKeyBlock, paramArrayOfbyte1, 1); agileEncryptionVerifier.setEncryptedKey(arrayOfByte4); SecretKeySpec secretKeySpec = new SecretKeySpec(paramArrayOfbyte1, (agileEncryptionVerifier.getCipherAlgorithm()).jceId); setSecretKey(secretKeySpec); this.integritySalt = (byte[])paramArrayOfbyte5.clone(); try { byte[] arrayOfByte5 = CryptoFunctions.generateIv(hashAlgorithm, agileEncryptionHeader.getKeySalt(), AgileDecryptor.kIntegrityKeyBlock, agileEncryptionHeader.getBlockSize()); Cipher cipher = CryptoFunctions.getCipher(secretKeySpec, agileEncryptionVerifier.getCipherAlgorithm(), agileEncryptionVerifier.getChainingMode(), arrayOfByte5, 1); byte[] arrayOfByte6 = CryptoFunctions.getBlock0(this.integritySalt, AgileDecryptor.getNextBlockSize(this.integritySalt.length, i)); byte[] arrayOfByte7 = cipher.doFinal(arrayOfByte6); agileEncryptionHeader.setEncryptedHmacKey(arrayOfByte7); cipher = Cipher.getInstance("RSA"); for (AgileEncryptionVerifier.AgileCertificateEntry agileCertificateEntry : agileEncryptionVerifier.getCertificates()) { cipher.init(1, agileCertificateEntry.x509.getPublicKey()); agileCertificateEntry.encryptedKey = cipher.doFinal(getSecretKey().getEncoded()); Mac mac = CryptoFunctions.getMac(hashAlgorithm); mac.init(getSecretKey()); agileCertificateEntry.certVerifier = mac.doFinal(agileCertificateEntry.x509.getEncoded()); }  }
/*     */     catch (GeneralSecurityException generalSecurityException) { throw new EncryptedDocumentException(generalSecurityException); }
/* 274 */      } protected EncryptionDocument createEncryptionDocument() { AgileEncryptionVerifier agileEncryptionVerifier = this.builder.getVerifier();
/* 275 */     AgileEncryptionHeader agileEncryptionHeader = this.builder.getHeader();
/*     */     
/* 277 */     EncryptionDocument encryptionDocument = EncryptionDocument.Factory.newInstance();
/* 278 */     CTEncryption cTEncryption = encryptionDocument.addNewEncryption();
/*     */     
/* 280 */     CTKeyData cTKeyData = cTEncryption.addNewKeyData();
/* 281 */     CTKeyEncryptors cTKeyEncryptors = cTEncryption.addNewKeyEncryptors();
/* 282 */     CTKeyEncryptor cTKeyEncryptor = cTKeyEncryptors.addNewKeyEncryptor();
/* 283 */     cTKeyEncryptor.setUri(this.passwordUri);
/* 284 */     CTPasswordKeyEncryptor cTPasswordKeyEncryptor = cTKeyEncryptor.addNewEncryptedPasswordKey();
/*     */     
/* 286 */     cTPasswordKeyEncryptor.setSpinCount(agileEncryptionVerifier.getSpinCount());
/*     */     
/* 288 */     cTKeyData.setSaltSize(agileEncryptionHeader.getBlockSize());
/* 289 */     cTPasswordKeyEncryptor.setSaltSize(agileEncryptionHeader.getBlockSize());
/*     */     
/* 291 */     cTKeyData.setBlockSize(agileEncryptionHeader.getBlockSize());
/* 292 */     cTPasswordKeyEncryptor.setBlockSize(agileEncryptionHeader.getBlockSize());
/*     */     
/* 294 */     cTKeyData.setKeyBits(agileEncryptionHeader.getKeySize());
/* 295 */     cTPasswordKeyEncryptor.setKeyBits(agileEncryptionHeader.getKeySize());
/*     */     
/* 297 */     HashAlgorithm hashAlgorithm = agileEncryptionHeader.getHashAlgorithmEx();
/* 298 */     cTKeyData.setHashSize(hashAlgorithm.hashSize);
/* 299 */     cTPasswordKeyEncryptor.setHashSize(hashAlgorithm.hashSize);
/*     */     
/* 301 */     STCipherAlgorithm.Enum enum_ = STCipherAlgorithm.Enum.forString((agileEncryptionHeader.getCipherAlgorithm()).xmlId);
/* 302 */     if (enum_ == null) {
/* 303 */       throw new EncryptedDocumentException("CipherAlgorithm " + agileEncryptionHeader.getCipherAlgorithm() + " not supported.");
/*     */     }
/* 305 */     cTKeyData.setCipherAlgorithm(enum_);
/* 306 */     cTPasswordKeyEncryptor.setCipherAlgorithm(enum_);
/*     */     
/* 308 */     switch (agileEncryptionHeader.getChainingMode()) {
/*     */       case cbc:
/* 310 */         cTKeyData.setCipherChaining(STCipherChaining.CHAINING_MODE_CBC);
/* 311 */         cTPasswordKeyEncryptor.setCipherChaining(STCipherChaining.CHAINING_MODE_CBC);
/*     */         break;
/*     */       case cfb:
/* 314 */         cTKeyData.setCipherChaining(STCipherChaining.CHAINING_MODE_CFB);
/* 315 */         cTPasswordKeyEncryptor.setCipherChaining(STCipherChaining.CHAINING_MODE_CFB);
/*     */         break;
/*     */       default:
/* 318 */         throw new EncryptedDocumentException("ChainingMode " + agileEncryptionHeader.getChainingMode() + " not supported.");
/*     */     } 
/*     */     
/* 321 */     STHashAlgorithm.Enum enum_1 = STHashAlgorithm.Enum.forString(hashAlgorithm.ecmaString);
/* 322 */     if (enum_1 == null) {
/* 323 */       throw new EncryptedDocumentException("HashAlgorithm " + hashAlgorithm + " not supported.");
/*     */     }
/* 325 */     cTKeyData.setHashAlgorithm(enum_1);
/* 326 */     cTPasswordKeyEncryptor.setHashAlgorithm(enum_1);
/*     */     
/* 328 */     cTKeyData.setSaltValue(agileEncryptionHeader.getKeySalt());
/* 329 */     cTPasswordKeyEncryptor.setSaltValue(agileEncryptionVerifier.getSalt());
/* 330 */     cTPasswordKeyEncryptor.setEncryptedVerifierHashInput(agileEncryptionVerifier.getEncryptedVerifier());
/* 331 */     cTPasswordKeyEncryptor.setEncryptedVerifierHashValue(agileEncryptionVerifier.getEncryptedVerifierHash());
/* 332 */     cTPasswordKeyEncryptor.setEncryptedKeyValue(agileEncryptionVerifier.getEncryptedKey());
/*     */     
/* 334 */     CTDataIntegrity cTDataIntegrity = cTEncryption.addNewDataIntegrity();
/* 335 */     cTDataIntegrity.setEncryptedHmacKey(agileEncryptionHeader.getEncryptedHmacKey());
/* 336 */     cTDataIntegrity.setEncryptedHmacValue(agileEncryptionHeader.getEncryptedHmacValue());
/*     */     
/* 338 */     for (AgileEncryptionVerifier.AgileCertificateEntry agileCertificateEntry : agileEncryptionVerifier.getCertificates()) {
/* 339 */       cTKeyEncryptor = cTKeyEncryptors.addNewKeyEncryptor();
/* 340 */       cTKeyEncryptor.setUri(this.certificateUri);
/* 341 */       CTCertificateKeyEncryptor cTCertificateKeyEncryptor = cTKeyEncryptor.addNewEncryptedCertificateKey();
/*     */       try {
/* 343 */         cTCertificateKeyEncryptor.setX509Certificate(agileCertificateEntry.x509.getEncoded());
/* 344 */       } catch (CertificateEncodingException certificateEncodingException) {
/* 345 */         throw new EncryptedDocumentException(certificateEncodingException);
/*     */       } 
/* 347 */       cTCertificateKeyEncryptor.setEncryptedKeyValue(agileCertificateEntry.encryptedKey);
/* 348 */       cTCertificateKeyEncryptor.setCertVerifier(agileCertificateEntry.certVerifier);
/*     */     } 
/*     */     
/* 351 */     return encryptionDocument; }
/*     */   public OutputStream getDataStream(DirectoryNode paramDirectoryNode) throws IOException, GeneralSecurityException { return (OutputStream)new AgileCipherOutputStream(paramDirectoryNode); }
/*     */   protected void updateIntegrityHMAC(File paramFile, int paramInt) throws GeneralSecurityException, IOException { AgileEncryptionVerifier agileEncryptionVerifier = this.builder.getVerifier(); HashAlgorithm hashAlgorithm = agileEncryptionVerifier.getHashAlgorithm(); Mac mac = CryptoFunctions.getMac(hashAlgorithm); mac.init(new SecretKeySpec(this.integritySalt, hashAlgorithm.jceHmacId)); byte[] arrayOfByte1 = new byte[1024]; LittleEndian.putLong(arrayOfByte1, 0, paramInt); mac.update(arrayOfByte1, 0, 8); FileInputStream fileInputStream = new FileInputStream(paramFile); try { int j; while ((j = fileInputStream.read(arrayOfByte1)) != -1)
/*     */         mac.update(arrayOfByte1, 0, j);  } finally { fileInputStream.close(); }
/* 355 */      byte[] arrayOfByte2 = mac.doFinal(); AgileEncryptionHeader agileEncryptionHeader = this.builder.getHeader(); int i = agileEncryptionHeader.getBlockSize(); byte[] arrayOfByte3 = CryptoFunctions.generateIv(agileEncryptionHeader.getHashAlgorithmEx(), agileEncryptionHeader.getKeySalt(), AgileDecryptor.kIntegrityValueBlock, i); Cipher cipher = CryptoFunctions.getCipher(getSecretKey(), agileEncryptionHeader.getCipherAlgorithm(), agileEncryptionHeader.getChainingMode(), arrayOfByte3, 1); byte[] arrayOfByte4 = CryptoFunctions.getBlock0(arrayOfByte2, AgileDecryptor.getNextBlockSize(arrayOfByte2.length, i)); byte[] arrayOfByte5 = cipher.doFinal(arrayOfByte4); agileEncryptionHeader.setEncryptedHmacValue(arrayOfByte5); } protected void marshallEncryptionDocument(EncryptionDocument paramEncryptionDocument, LittleEndianByteArrayOutputStream paramLittleEndianByteArrayOutputStream) { XmlOptions xmlOptions = new XmlOptions();
/* 356 */     xmlOptions.setCharacterEncoding("UTF-8");
/* 357 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 358 */     hashMap.put(this.passwordUri.toString(), "p");
/* 359 */     hashMap.put(this.certificateUri.toString(), "c");
/* 360 */     xmlOptions.setUseDefaultNamespace();
/* 361 */     xmlOptions.setSaveSuggestedPrefixes(hashMap);
/* 362 */     xmlOptions.setSaveNamespacesFirst();
/* 363 */     xmlOptions.setSaveAggressiveNamespaces();
/*     */ 
/*     */ 
/*     */     
/* 367 */     xmlOptions.setSaveNoXmlDecl();
/* 368 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*     */     try {
/* 370 */       byteArrayOutputStream.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\r\n".getBytes("UTF-8"));
/* 371 */       paramEncryptionDocument.save(byteArrayOutputStream, xmlOptions);
/* 372 */       paramLittleEndianByteArrayOutputStream.write(byteArrayOutputStream.toByteArray());
/* 373 */     } catch (IOException iOException) {
/* 374 */       throw new EncryptedDocumentException("error marshalling encryption info document", iOException);
/*     */     }  }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void createEncryptionInfoEntry(DirectoryNode paramDirectoryNode, File paramFile) throws IOException, GeneralSecurityException {
/* 380 */     DataSpaceMapUtils.addDefaultDataSpace((DirectoryEntry)paramDirectoryNode);
/*     */     
/* 382 */     final EncryptionInfo info = this.builder.getInfo();
/*     */     
/* 384 */     EncryptionRecord encryptionRecord = new EncryptionRecord()
/*     */       {
/*     */         public void write(LittleEndianByteArrayOutputStream param1LittleEndianByteArrayOutputStream)
/*     */         {
/* 388 */           param1LittleEndianByteArrayOutputStream.writeShort(info.getVersionMajor());
/* 389 */           param1LittleEndianByteArrayOutputStream.writeShort(info.getVersionMinor());
/*     */           
/* 391 */           param1LittleEndianByteArrayOutputStream.writeInt(info.getEncryptionFlags());
/*     */           
/* 393 */           EncryptionDocument encryptionDocument = AgileEncryptor.this.createEncryptionDocument();
/* 394 */           AgileEncryptor.this.marshallEncryptionDocument(encryptionDocument, param1LittleEndianByteArrayOutputStream);
/*     */         }
/*     */       };
/*     */     
/* 398 */     DataSpaceMapUtils.createEncryptionEntry((DirectoryEntry)paramDirectoryNode, "EncryptionInfo", encryptionRecord);
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
/*     */   private class AgileCipherOutputStream
/*     */     extends ChunkedCipherOutputStream
/*     */   {
/*     */     public AgileCipherOutputStream(DirectoryNode param1DirectoryNode) throws IOException, GeneralSecurityException {
/* 419 */       super(param1DirectoryNode, 4096);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected Cipher initCipherForBlock(Cipher param1Cipher, int param1Int, boolean param1Boolean) throws GeneralSecurityException {
/* 425 */       return AgileDecryptor.initCipherForBlock(param1Cipher, param1Int, param1Boolean, AgileEncryptor.this.builder, AgileEncryptor.this.getSecretKey(), 1);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void calculateChecksum(File param1File, int param1Int) throws GeneralSecurityException, IOException {
/* 432 */       AgileEncryptor.this.updateIntegrityHMAC(param1File, param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void createEncryptionInfoEntry(DirectoryNode param1DirectoryNode, File param1File) throws IOException, GeneralSecurityException {
/* 438 */       AgileEncryptor.this.createEncryptionInfoEntry(param1DirectoryNode, param1File);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\agile\AgileEncryptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */