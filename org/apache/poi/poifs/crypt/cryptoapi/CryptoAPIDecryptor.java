/*     */ package org.apache.poi.poifs.crypt.cryptoapi;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.security.GeneralSecurityException;
/*     */ import java.security.MessageDigest;
/*     */ import java.util.Arrays;
/*     */ import javax.crypto.Cipher;
/*     */ import javax.crypto.SecretKey;
/*     */ import javax.crypto.ShortBufferException;
/*     */ import javax.crypto.spec.SecretKeySpec;
/*     */ import org.apache.poi.EncryptedDocumentException;
/*     */ import org.apache.poi.poifs.crypt.CryptoFunctions;
/*     */ import org.apache.poi.poifs.crypt.Decryptor;
/*     */ import org.apache.poi.poifs.crypt.EncryptionHeader;
/*     */ import org.apache.poi.poifs.crypt.EncryptionInfoBuilder;
/*     */ import org.apache.poi.poifs.crypt.EncryptionVerifier;
/*     */ import org.apache.poi.poifs.crypt.HashAlgorithm;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryNode;
/*     */ import org.apache.poi.poifs.filesystem.DocumentInputStream;
/*     */ import org.apache.poi.poifs.filesystem.DocumentNode;
/*     */ import org.apache.poi.poifs.filesystem.Entry;
/*     */ import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
/*     */ import org.apache.poi.util.BitField;
/*     */ import org.apache.poi.util.BitFieldFactory;
/*     */ import org.apache.poi.util.BoundedInputStream;
/*     */ import org.apache.poi.util.IOUtils;
/*     */ import org.apache.poi.util.LittleEndian;
/*     */ import org.apache.poi.util.LittleEndianInput;
/*     */ import org.apache.poi.util.LittleEndianInputStream;
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
/*     */ public class CryptoAPIDecryptor
/*     */   extends Decryptor
/*     */ {
/*     */   private long _length;
/*     */   
/*     */   private class SeekableByteArrayInputStream
/*     */     extends ByteArrayInputStream
/*     */   {
/*     */     Cipher cipher;
/*  58 */     byte[] oneByte = new byte[] { 0 };
/*     */     
/*     */     public void seek(int param1Int) {
/*  61 */       if (param1Int > this.count) {
/*  62 */         throw new ArrayIndexOutOfBoundsException(param1Int);
/*     */       }
/*     */       
/*  65 */       this.pos = param1Int;
/*  66 */       this.mark = param1Int;
/*     */     }
/*     */     
/*     */     public void setBlock(int param1Int) throws GeneralSecurityException {
/*  70 */       this.cipher = CryptoAPIDecryptor.this.initCipherForBlock(this.cipher, param1Int);
/*     */     }
/*     */     
/*     */     public synchronized int read() {
/*  74 */       int i = super.read();
/*  75 */       if (i == -1) return -1; 
/*  76 */       this.oneByte[0] = (byte)i;
/*     */       try {
/*  78 */         this.cipher.update(this.oneByte, 0, 1, this.oneByte);
/*  79 */       } catch (ShortBufferException shortBufferException) {
/*  80 */         throw new EncryptedDocumentException(shortBufferException);
/*     */       } 
/*  82 */       return this.oneByte[0];
/*     */     }
/*     */     
/*     */     public synchronized int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
/*  86 */       int i = super.read(param1ArrayOfbyte, param1Int1, param1Int2);
/*  87 */       if (i == -1) return -1; 
/*     */       try {
/*  89 */         this.cipher.update(param1ArrayOfbyte, param1Int1, i, param1ArrayOfbyte, param1Int1);
/*  90 */       } catch (ShortBufferException shortBufferException) {
/*  91 */         throw new EncryptedDocumentException(shortBufferException);
/*     */       } 
/*  93 */       return i;
/*     */     }
/*     */ 
/*     */     
/*     */     public SeekableByteArrayInputStream(byte[] param1ArrayOfbyte) throws GeneralSecurityException {
/*  98 */       super(param1ArrayOfbyte);
/*  99 */       this.cipher = CryptoAPIDecryptor.this.initCipherForBlock((Cipher)null, 0);
/*     */     }
/*     */   }
/*     */   
/*     */   static class StreamDescriptorEntry {
/* 104 */     static BitField flagStream = BitFieldFactory.getInstance(1);
/*     */     
/*     */     int streamOffset;
/*     */     int streamSize;
/*     */     int block;
/*     */     int flags;
/*     */     int reserved2;
/*     */     String streamName;
/*     */   }
/*     */   
/*     */   protected CryptoAPIDecryptor(CryptoAPIEncryptionInfoBuilder paramCryptoAPIEncryptionInfoBuilder) {
/* 115 */     super(paramCryptoAPIEncryptionInfoBuilder);
/* 116 */     this._length = -1L;
/*     */   }
/*     */   
/*     */   public boolean verifyPassword(String paramString) {
/* 120 */     EncryptionVerifier encryptionVerifier = this.builder.getVerifier();
/* 121 */     SecretKey secretKey = generateSecretKey(paramString, encryptionVerifier);
/*     */     try {
/* 123 */       Cipher cipher = initCipherForBlock((Cipher)null, 0, this.builder, secretKey, 2);
/* 124 */       byte[] arrayOfByte1 = encryptionVerifier.getEncryptedVerifier();
/* 125 */       byte[] arrayOfByte2 = new byte[arrayOfByte1.length];
/* 126 */       cipher.update(arrayOfByte1, 0, arrayOfByte1.length, arrayOfByte2);
/* 127 */       setVerifier(arrayOfByte2);
/* 128 */       byte[] arrayOfByte3 = encryptionVerifier.getEncryptedVerifierHash();
/* 129 */       byte[] arrayOfByte4 = cipher.doFinal(arrayOfByte3);
/* 130 */       HashAlgorithm hashAlgorithm = encryptionVerifier.getHashAlgorithm();
/* 131 */       MessageDigest messageDigest = CryptoFunctions.getMessageDigest(hashAlgorithm);
/* 132 */       byte[] arrayOfByte5 = messageDigest.digest(arrayOfByte2);
/* 133 */       if (Arrays.equals(arrayOfByte5, arrayOfByte4)) {
/* 134 */         setSecretKey(secretKey);
/* 135 */         return true;
/*     */       } 
/* 137 */     } catch (GeneralSecurityException generalSecurityException) {
/* 138 */       throw new EncryptedDocumentException(generalSecurityException);
/*     */     } 
/* 140 */     return false;
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
/* 153 */     return initCipherForBlock(paramCipher, paramInt, this.builder, getSecretKey(), 2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected static Cipher initCipherForBlock(Cipher paramCipher, int paramInt1, EncryptionInfoBuilder paramEncryptionInfoBuilder, SecretKey paramSecretKey, int paramInt2) throws GeneralSecurityException {
/* 159 */     EncryptionVerifier encryptionVerifier = paramEncryptionInfoBuilder.getVerifier();
/* 160 */     HashAlgorithm hashAlgorithm = encryptionVerifier.getHashAlgorithm();
/* 161 */     byte[] arrayOfByte1 = new byte[4];
/* 162 */     LittleEndian.putUInt(arrayOfByte1, 0, paramInt1);
/* 163 */     MessageDigest messageDigest = CryptoFunctions.getMessageDigest(hashAlgorithm);
/* 164 */     messageDigest.update(paramSecretKey.getEncoded());
/* 165 */     byte[] arrayOfByte2 = messageDigest.digest(arrayOfByte1);
/* 166 */     EncryptionHeader encryptionHeader = paramEncryptionInfoBuilder.getHeader();
/* 167 */     int i = encryptionHeader.getKeySize();
/* 168 */     arrayOfByte2 = CryptoFunctions.getBlock0(arrayOfByte2, i / 8);
/* 169 */     if (i == 40) {
/* 170 */       arrayOfByte2 = CryptoFunctions.getBlock0(arrayOfByte2, 16);
/*     */     }
/* 172 */     SecretKeySpec secretKeySpec = new SecretKeySpec(arrayOfByte2, paramSecretKey.getAlgorithm());
/* 173 */     if (paramCipher == null) {
/* 174 */       paramCipher = CryptoFunctions.getCipher(secretKeySpec, encryptionHeader.getCipherAlgorithm(), null, null, paramInt2);
/*     */     } else {
/* 176 */       paramCipher.init(paramInt2, secretKeySpec);
/*     */     } 
/* 178 */     return paramCipher;
/*     */   }
/*     */   
/*     */   protected static SecretKey generateSecretKey(String paramString, EncryptionVerifier paramEncryptionVerifier) {
/* 182 */     if (paramString.length() > 255) {
/* 183 */       paramString = paramString.substring(0, 255);
/*     */     }
/* 185 */     HashAlgorithm hashAlgorithm = paramEncryptionVerifier.getHashAlgorithm();
/* 186 */     MessageDigest messageDigest = CryptoFunctions.getMessageDigest(hashAlgorithm);
/* 187 */     messageDigest.update(paramEncryptionVerifier.getSalt());
/* 188 */     byte[] arrayOfByte = messageDigest.digest(StringUtil.getToUnicodeLE(paramString));
/* 189 */     return new SecretKeySpec(arrayOfByte, (paramEncryptionVerifier.getCipherAlgorithm()).jceId);
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
/*     */   public InputStream getDataStream(DirectoryNode paramDirectoryNode) throws IOException, GeneralSecurityException {
/* 202 */     NPOIFSFileSystem nPOIFSFileSystem = new NPOIFSFileSystem();
/* 203 */     DocumentNode documentNode = (DocumentNode)paramDirectoryNode.getEntry("EncryptedSummary");
/* 204 */     DocumentInputStream documentInputStream = paramDirectoryNode.createDocumentInputStream((Entry)documentNode);
/* 205 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 206 */     IOUtils.copy((InputStream)documentInputStream, byteArrayOutputStream);
/* 207 */     documentInputStream.close();
/* 208 */     SeekableByteArrayInputStream seekableByteArrayInputStream = new SeekableByteArrayInputStream(byteArrayOutputStream.toByteArray());
/* 209 */     LittleEndianInputStream littleEndianInputStream = new LittleEndianInputStream(seekableByteArrayInputStream);
/* 210 */     int i = (int)littleEndianInputStream.readUInt();
/* 211 */     littleEndianInputStream.readUInt();
/* 212 */     seekableByteArrayInputStream.skip((i - 8));
/* 213 */     seekableByteArrayInputStream.setBlock(0);
/* 214 */     int j = (int)littleEndianInputStream.readUInt();
/* 215 */     StreamDescriptorEntry[] arrayOfStreamDescriptorEntry = new StreamDescriptorEntry[j];
/* 216 */     for (byte b = 0; b < j; b++) {
/* 217 */       StreamDescriptorEntry streamDescriptorEntry = new StreamDescriptorEntry();
/* 218 */       arrayOfStreamDescriptorEntry[b] = streamDescriptorEntry;
/* 219 */       streamDescriptorEntry.streamOffset = (int)littleEndianInputStream.readUInt();
/* 220 */       streamDescriptorEntry.streamSize = (int)littleEndianInputStream.readUInt();
/* 221 */       streamDescriptorEntry.block = littleEndianInputStream.readUShort();
/* 222 */       int k = littleEndianInputStream.readUByte();
/* 223 */       streamDescriptorEntry.flags = littleEndianInputStream.readUByte();
/*     */       
/* 225 */       streamDescriptorEntry.reserved2 = littleEndianInputStream.readInt();
/* 226 */       streamDescriptorEntry.streamName = StringUtil.readUnicodeLE((LittleEndianInput)littleEndianInputStream, k);
/* 227 */       littleEndianInputStream.readShort();
/* 228 */       assert streamDescriptorEntry.streamName.length() == k;
/*     */     } 
/*     */     
/* 231 */     for (StreamDescriptorEntry streamDescriptorEntry : arrayOfStreamDescriptorEntry) {
/* 232 */       seekableByteArrayInputStream.seek(streamDescriptorEntry.streamOffset);
/* 233 */       seekableByteArrayInputStream.setBlock(streamDescriptorEntry.block);
/* 234 */       BoundedInputStream boundedInputStream = new BoundedInputStream(seekableByteArrayInputStream, streamDescriptorEntry.streamSize);
/* 235 */       nPOIFSFileSystem.createDocument((InputStream)boundedInputStream, streamDescriptorEntry.streamName);
/* 236 */       boundedInputStream.close();
/*     */     } 
/*     */     
/* 239 */     littleEndianInputStream.close();
/* 240 */     seekableByteArrayInputStream.close();
/* 241 */     seekableByteArrayInputStream = null;
/* 242 */     byteArrayOutputStream.reset();
/* 243 */     nPOIFSFileSystem.writeFilesystem(byteArrayOutputStream);
/* 244 */     nPOIFSFileSystem.close();
/* 245 */     this._length = byteArrayOutputStream.size();
/* 246 */     return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getLength() {
/* 254 */     if (this._length == -1L) {
/* 255 */       throw new IllegalStateException("Decryptor.getDataStream() was not called");
/*     */     }
/* 257 */     return this._length;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\cryptoapi\CryptoAPIDecryptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */