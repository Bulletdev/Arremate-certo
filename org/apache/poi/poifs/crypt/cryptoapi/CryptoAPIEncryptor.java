/*     */ package org.apache.poi.poifs.crypt.cryptoapi;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.security.GeneralSecurityException;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.SecureRandom;
/*     */ import java.util.ArrayList;
/*     */ import javax.crypto.Cipher;
/*     */ import javax.crypto.SecretKey;
/*     */ import org.apache.poi.EncryptedDocumentException;
/*     */ import org.apache.poi.hpsf.DocumentSummaryInformation;
/*     */ import org.apache.poi.hpsf.PropertySetFactory;
/*     */ import org.apache.poi.hpsf.WritingNotSupportedException;
/*     */ import org.apache.poi.poifs.crypt.CryptoFunctions;
/*     */ import org.apache.poi.poifs.crypt.DataSpaceMapUtils;
/*     */ import org.apache.poi.poifs.crypt.EncryptionInfo;
/*     */ import org.apache.poi.poifs.crypt.EncryptionVerifier;
/*     */ import org.apache.poi.poifs.crypt.Encryptor;
/*     */ import org.apache.poi.poifs.crypt.HashAlgorithm;
/*     */ import org.apache.poi.poifs.crypt.standard.EncryptionRecord;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryEntry;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryNode;
/*     */ import org.apache.poi.poifs.filesystem.DocumentInputStream;
/*     */ import org.apache.poi.util.IOUtils;
/*     */ import org.apache.poi.util.LittleEndian;
/*     */ import org.apache.poi.util.LittleEndianByteArrayOutputStream;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CryptoAPIEncryptor
/*     */   extends Encryptor
/*     */ {
/*     */   private final CryptoAPIEncryptionInfoBuilder builder;
/*     */   
/*     */   protected CryptoAPIEncryptor(CryptoAPIEncryptionInfoBuilder paramCryptoAPIEncryptionInfoBuilder) {
/*  57 */     this.builder = paramCryptoAPIEncryptionInfoBuilder;
/*     */   }
/*     */   
/*     */   public void confirmPassword(String paramString) {
/*  61 */     SecureRandom secureRandom = new SecureRandom();
/*  62 */     byte[] arrayOfByte1 = new byte[16];
/*  63 */     byte[] arrayOfByte2 = new byte[16];
/*  64 */     secureRandom.nextBytes(arrayOfByte1);
/*  65 */     secureRandom.nextBytes(arrayOfByte2);
/*  66 */     confirmPassword(paramString, (byte[])null, (byte[])null, arrayOfByte2, arrayOfByte1, (byte[])null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void confirmPassword(String paramString, byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, byte[] paramArrayOfbyte3, byte[] paramArrayOfbyte4, byte[] paramArrayOfbyte5) {
/*  72 */     assert paramArrayOfbyte3 != null && paramArrayOfbyte4 != null;
/*  73 */     CryptoAPIEncryptionVerifier cryptoAPIEncryptionVerifier = this.builder.getVerifier();
/*  74 */     cryptoAPIEncryptionVerifier.setSalt(paramArrayOfbyte4);
/*  75 */     SecretKey secretKey = CryptoAPIDecryptor.generateSecretKey(paramString, (EncryptionVerifier)cryptoAPIEncryptionVerifier);
/*  76 */     setSecretKey(secretKey);
/*     */     try {
/*  78 */       Cipher cipher = initCipherForBlock((Cipher)null, 0);
/*  79 */       byte[] arrayOfByte1 = new byte[paramArrayOfbyte3.length];
/*  80 */       cipher.update(paramArrayOfbyte3, 0, paramArrayOfbyte3.length, arrayOfByte1);
/*  81 */       cryptoAPIEncryptionVerifier.setEncryptedVerifier(arrayOfByte1);
/*  82 */       HashAlgorithm hashAlgorithm = cryptoAPIEncryptionVerifier.getHashAlgorithm();
/*  83 */       MessageDigest messageDigest = CryptoFunctions.getMessageDigest(hashAlgorithm);
/*  84 */       byte[] arrayOfByte2 = messageDigest.digest(paramArrayOfbyte3);
/*  85 */       byte[] arrayOfByte3 = cipher.doFinal(arrayOfByte2);
/*  86 */       cryptoAPIEncryptionVerifier.setEncryptedVerifierHash(arrayOfByte3);
/*  87 */     } catch (GeneralSecurityException generalSecurityException) {
/*  88 */       throw new EncryptedDocumentException("Password confirmation failed", generalSecurityException);
/*     */     } 
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
/*     */   public Cipher initCipherForBlock(Cipher paramCipher, int paramInt) throws GeneralSecurityException {
/* 102 */     return CryptoAPIDecryptor.initCipherForBlock(paramCipher, paramInt, this.builder, getSecretKey(), 1);
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
/*     */   public OutputStream getDataStream(DirectoryNode paramDirectoryNode) throws IOException, GeneralSecurityException {
/* 114 */     CipherByteArrayOutputStream cipherByteArrayOutputStream = new CipherByteArrayOutputStream();
/* 115 */     byte[] arrayOfByte = new byte[8];
/*     */     
/* 117 */     cipherByteArrayOutputStream.write(arrayOfByte, 0, 8);
/* 118 */     String[] arrayOfString = { "\005SummaryInformation", "\005DocumentSummaryInformation" };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 123 */     ArrayList<CryptoAPIDecryptor.StreamDescriptorEntry> arrayList = new ArrayList();
/*     */     
/* 125 */     byte b = 0;
/* 126 */     for (String str : arrayOfString) {
/* 127 */       if (paramDirectoryNode.hasEntry(str)) {
/* 128 */         CryptoAPIDecryptor.StreamDescriptorEntry streamDescriptorEntry = new CryptoAPIDecryptor.StreamDescriptorEntry();
/* 129 */         streamDescriptorEntry.block = b;
/* 130 */         streamDescriptorEntry.streamOffset = cipherByteArrayOutputStream.size();
/* 131 */         streamDescriptorEntry.streamName = str;
/* 132 */         streamDescriptorEntry.flags = CryptoAPIDecryptor.StreamDescriptorEntry.flagStream.setValue(0, 1);
/* 133 */         streamDescriptorEntry.reserved2 = 0;
/*     */         
/* 135 */         cipherByteArrayOutputStream.setBlock(b);
/* 136 */         DocumentInputStream documentInputStream = paramDirectoryNode.createDocumentInputStream(str);
/* 137 */         IOUtils.copy((InputStream)documentInputStream, cipherByteArrayOutputStream);
/* 138 */         documentInputStream.close();
/*     */         
/* 140 */         streamDescriptorEntry.streamSize = cipherByteArrayOutputStream.size() - streamDescriptorEntry.streamOffset;
/* 141 */         arrayList.add(streamDescriptorEntry);
/*     */         
/* 143 */         paramDirectoryNode.getEntry(str).delete();
/*     */         
/* 145 */         b++;
/*     */       } 
/*     */     } 
/* 148 */     int i = cipherByteArrayOutputStream.size();
/*     */     
/* 150 */     cipherByteArrayOutputStream.setBlock(0);
/* 151 */     LittleEndian.putUInt(arrayOfByte, 0, arrayList.size());
/* 152 */     cipherByteArrayOutputStream.write(arrayOfByte, 0, 4);
/*     */     
/* 154 */     for (CryptoAPIDecryptor.StreamDescriptorEntry streamDescriptorEntry : arrayList) {
/* 155 */       LittleEndian.putUInt(arrayOfByte, 0, streamDescriptorEntry.streamOffset);
/* 156 */       cipherByteArrayOutputStream.write(arrayOfByte, 0, 4);
/* 157 */       LittleEndian.putUInt(arrayOfByte, 0, streamDescriptorEntry.streamSize);
/* 158 */       cipherByteArrayOutputStream.write(arrayOfByte, 0, 4);
/* 159 */       LittleEndian.putUShort(arrayOfByte, 0, streamDescriptorEntry.block);
/* 160 */       cipherByteArrayOutputStream.write(arrayOfByte, 0, 2);
/* 161 */       LittleEndian.putUByte(arrayOfByte, 0, (short)streamDescriptorEntry.streamName.length());
/* 162 */       cipherByteArrayOutputStream.write(arrayOfByte, 0, 1);
/* 163 */       LittleEndian.putUByte(arrayOfByte, 0, (short)streamDescriptorEntry.flags);
/* 164 */       cipherByteArrayOutputStream.write(arrayOfByte, 0, 1);
/* 165 */       LittleEndian.putUInt(arrayOfByte, 0, streamDescriptorEntry.reserved2);
/* 166 */       cipherByteArrayOutputStream.write(arrayOfByte, 0, 4);
/* 167 */       byte[] arrayOfByte1 = StringUtil.getToUnicodeLE(streamDescriptorEntry.streamName);
/* 168 */       cipherByteArrayOutputStream.write(arrayOfByte1, 0, arrayOfByte1.length);
/* 169 */       LittleEndian.putShort(arrayOfByte, 0, (short)0);
/* 170 */       cipherByteArrayOutputStream.write(arrayOfByte, 0, 2);
/*     */     } 
/*     */     
/* 173 */     int j = cipherByteArrayOutputStream.size();
/* 174 */     int k = j - i;
/* 175 */     LittleEndian.putUInt(arrayOfByte, 0, i);
/* 176 */     LittleEndian.putUInt(arrayOfByte, 4, k);
/*     */     
/* 178 */     cipherByteArrayOutputStream.reset();
/* 179 */     cipherByteArrayOutputStream.setBlock(0);
/* 180 */     cipherByteArrayOutputStream.write(arrayOfByte, 0, 8);
/* 181 */     cipherByteArrayOutputStream.setSize(j);
/*     */     
/* 183 */     paramDirectoryNode.createDocument("EncryptedSummary", new ByteArrayInputStream(cipherByteArrayOutputStream.getBuf(), 0, j));
/* 184 */     DocumentSummaryInformation documentSummaryInformation = PropertySetFactory.newDocumentSummaryInformation();
/*     */     
/*     */     try {
/* 187 */       documentSummaryInformation.write((DirectoryEntry)paramDirectoryNode, "\005DocumentSummaryInformation");
/* 188 */     } catch (WritingNotSupportedException writingNotSupportedException) {
/* 189 */       throw new IOException(writingNotSupportedException);
/*     */     } 
/*     */     
/* 192 */     return cipherByteArrayOutputStream;
/*     */   }
/*     */   
/*     */   protected int getKeySizeInBytes() {
/* 196 */     return this.builder.getHeader().getKeySize() / 8;
/*     */   }
/*     */   
/*     */   protected void createEncryptionInfoEntry(DirectoryNode paramDirectoryNode) throws IOException {
/* 200 */     DataSpaceMapUtils.addDefaultDataSpace((DirectoryEntry)paramDirectoryNode);
/* 201 */     final EncryptionInfo info = this.builder.getEncryptionInfo();
/* 202 */     final CryptoAPIEncryptionHeader header = this.builder.getHeader();
/* 203 */     final CryptoAPIEncryptionVerifier verifier = this.builder.getVerifier();
/* 204 */     EncryptionRecord encryptionRecord = new EncryptionRecord() {
/*     */         public void write(LittleEndianByteArrayOutputStream param1LittleEndianByteArrayOutputStream) {
/* 206 */           param1LittleEndianByteArrayOutputStream.writeShort(info.getVersionMajor());
/* 207 */           param1LittleEndianByteArrayOutputStream.writeShort(info.getVersionMinor());
/* 208 */           header.write(param1LittleEndianByteArrayOutputStream);
/* 209 */           verifier.write(param1LittleEndianByteArrayOutputStream);
/*     */         }
/*     */       };
/* 212 */     DataSpaceMapUtils.createEncryptionEntry((DirectoryEntry)paramDirectoryNode, "EncryptionInfo", encryptionRecord);
/*     */   }
/*     */   
/*     */   private class CipherByteArrayOutputStream extends ByteArrayOutputStream {
/*     */     Cipher cipher;
/* 217 */     byte[] oneByte = new byte[] { 0 };
/*     */     
/*     */     public CipherByteArrayOutputStream() throws GeneralSecurityException {
/* 220 */       setBlock(0);
/*     */     }
/*     */     
/*     */     public byte[] getBuf() {
/* 224 */       return this.buf;
/*     */     }
/*     */     
/*     */     public void setSize(int param1Int) {
/* 228 */       this.count = param1Int;
/*     */     }
/*     */     
/*     */     public void setBlock(int param1Int) throws GeneralSecurityException {
/* 232 */       this.cipher = CryptoAPIEncryptor.this.initCipherForBlock(this.cipher, param1Int);
/*     */     }
/*     */     
/*     */     public void write(int param1Int) {
/*     */       try {
/* 237 */         this.oneByte[0] = (byte)param1Int;
/* 238 */         this.cipher.update(this.oneByte, 0, 1, this.oneByte, 0);
/* 239 */         write(this.oneByte);
/* 240 */       } catch (Exception exception) {
/* 241 */         throw new EncryptedDocumentException(exception);
/*     */       } 
/*     */     }
/*     */     
/*     */     public void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
/*     */       try {
/* 247 */         this.cipher.update(param1ArrayOfbyte, param1Int1, param1Int2, param1ArrayOfbyte, param1Int1);
/* 248 */         super.write(param1ArrayOfbyte, param1Int1, param1Int2);
/* 249 */       } catch (Exception exception) {
/* 250 */         throw new EncryptedDocumentException(exception);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\cryptoapi\CryptoAPIEncryptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */