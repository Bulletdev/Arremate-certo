/*     */ package org.apache.poi.poifs.crypt.standard;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.FilterOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.security.GeneralSecurityException;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.SecureRandom;
/*     */ import java.util.Arrays;
/*     */ import javax.crypto.Cipher;
/*     */ import javax.crypto.CipherOutputStream;
/*     */ import javax.crypto.SecretKey;
/*     */ import org.apache.poi.EncryptedDocumentException;
/*     */ import org.apache.poi.poifs.crypt.CryptoFunctions;
/*     */ import org.apache.poi.poifs.crypt.DataSpaceMapUtils;
/*     */ import org.apache.poi.poifs.crypt.EncryptionInfo;
/*     */ import org.apache.poi.poifs.crypt.Encryptor;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryEntry;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryNode;
/*     */ import org.apache.poi.poifs.filesystem.POIFSWriterEvent;
/*     */ import org.apache.poi.poifs.filesystem.POIFSWriterListener;
/*     */ import org.apache.poi.util.IOUtils;
/*     */ import org.apache.poi.util.LittleEndianByteArrayOutputStream;
/*     */ import org.apache.poi.util.LittleEndianOutputStream;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.apache.poi.util.TempFile;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StandardEncryptor
/*     */   extends Encryptor
/*     */ {
/*  57 */   private static final POILogger logger = POILogFactory.getLogger(StandardEncryptor.class);
/*     */   
/*     */   private final StandardEncryptionInfoBuilder builder;
/*     */   
/*     */   protected StandardEncryptor(StandardEncryptionInfoBuilder paramStandardEncryptionInfoBuilder) {
/*  62 */     this.builder = paramStandardEncryptionInfoBuilder;
/*     */   }
/*     */ 
/*     */   
/*     */   public void confirmPassword(String paramString) {
/*  67 */     SecureRandom secureRandom = new SecureRandom();
/*  68 */     byte[] arrayOfByte1 = new byte[16], arrayOfByte2 = new byte[16];
/*  69 */     secureRandom.nextBytes(arrayOfByte1);
/*  70 */     secureRandom.nextBytes(arrayOfByte2);
/*     */     
/*  72 */     confirmPassword(paramString, (byte[])null, (byte[])null, arrayOfByte1, arrayOfByte2, (byte[])null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void confirmPassword(String paramString, byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, byte[] paramArrayOfbyte3, byte[] paramArrayOfbyte4, byte[] paramArrayOfbyte5) {
/*  83 */     StandardEncryptionVerifier standardEncryptionVerifier = this.builder.getVerifier();
/*     */     
/*  85 */     standardEncryptionVerifier.setSalt(paramArrayOfbyte4);
/*  86 */     SecretKey secretKey = StandardDecryptor.generateSecretKey(paramString, standardEncryptionVerifier, getKeySizeInBytes());
/*  87 */     setSecretKey(secretKey);
/*  88 */     Cipher cipher = getCipher(secretKey, (String)null);
/*     */     
/*     */     try {
/*  91 */       byte[] arrayOfByte1 = cipher.doFinal(paramArrayOfbyte3);
/*  92 */       MessageDigest messageDigest = CryptoFunctions.getMessageDigest(standardEncryptionVerifier.getHashAlgorithm());
/*  93 */       byte[] arrayOfByte2 = messageDigest.digest(paramArrayOfbyte3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 102 */       int i = (standardEncryptionVerifier.getCipherAlgorithm()).encryptedVerifierHashLength;
/* 103 */       byte[] arrayOfByte3 = cipher.doFinal(Arrays.copyOf(arrayOfByte2, i));
/*     */       
/* 105 */       standardEncryptionVerifier.setEncryptedVerifier(arrayOfByte1);
/* 106 */       standardEncryptionVerifier.setEncryptedVerifierHash(arrayOfByte3);
/* 107 */     } catch (GeneralSecurityException generalSecurityException) {
/* 108 */       throw new EncryptedDocumentException("Password confirmation failed", generalSecurityException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private Cipher getCipher(SecretKey paramSecretKey, String paramString) {
/* 114 */     StandardEncryptionVerifier standardEncryptionVerifier = this.builder.getVerifier();
/* 115 */     return CryptoFunctions.getCipher(paramSecretKey, standardEncryptionVerifier.getCipherAlgorithm(), standardEncryptionVerifier.getChainingMode(), null, 1, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public OutputStream getDataStream(DirectoryNode paramDirectoryNode) throws IOException, GeneralSecurityException {
/* 120 */     createEncryptionInfoEntry(paramDirectoryNode);
/* 121 */     DataSpaceMapUtils.addDefaultDataSpace((DirectoryEntry)paramDirectoryNode);
/* 122 */     return new StandardCipherOutputStream(paramDirectoryNode);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected class StandardCipherOutputStream
/*     */     extends FilterOutputStream
/*     */     implements POIFSWriterListener
/*     */   {
/*     */     protected long countBytes;
/*     */ 
/*     */     
/*     */     protected final File fileOut;
/*     */ 
/*     */     
/*     */     protected final DirectoryNode dir;
/*     */ 
/*     */ 
/*     */     
/*     */     private StandardCipherOutputStream(DirectoryNode param1DirectoryNode, File param1File) throws IOException {
/* 143 */       super(new CipherOutputStream(new FileOutputStream(param1File), StandardEncryptor.this.getCipher(StandardEncryptor.this.getSecretKey(), "PKCS5Padding")));
/*     */ 
/*     */       
/* 146 */       this.fileOut = param1File;
/* 147 */       this.dir = param1DirectoryNode;
/*     */     }
/*     */     
/*     */     protected StandardCipherOutputStream(DirectoryNode param1DirectoryNode) throws IOException {
/* 151 */       this(param1DirectoryNode, TempFile.createTempFile("encrypted_package", "crypt"));
/*     */     }
/*     */ 
/*     */     
/*     */     public void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
/* 156 */       this.out.write(param1ArrayOfbyte, param1Int1, param1Int2);
/* 157 */       this.countBytes += param1Int2;
/*     */     }
/*     */ 
/*     */     
/*     */     public void write(int param1Int) throws IOException {
/* 162 */       this.out.write(param1Int);
/* 163 */       this.countBytes++;
/*     */     }
/*     */ 
/*     */     
/*     */     public void close() throws IOException {
/* 168 */       super.close();
/* 169 */       writeToPOIFS();
/*     */     }
/*     */     
/*     */     void writeToPOIFS() throws IOException {
/* 173 */       int i = (int)(this.fileOut.length() + 8L);
/* 174 */       this.dir.createDocument("EncryptedPackage", i, this);
/*     */     }
/*     */ 
/*     */     
/*     */     public void processPOIFSWriterEvent(POIFSWriterEvent param1POIFSWriterEvent) {
/*     */       try {
/* 180 */         LittleEndianOutputStream littleEndianOutputStream = new LittleEndianOutputStream((OutputStream)param1POIFSWriterEvent.getStream());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 186 */         littleEndianOutputStream.writeLong(this.countBytes);
/*     */         
/* 188 */         FileInputStream fileInputStream = new FileInputStream(this.fileOut);
/* 189 */         IOUtils.copy(fileInputStream, (OutputStream)littleEndianOutputStream);
/* 190 */         fileInputStream.close();
/* 191 */         if (!this.fileOut.delete()) {
/* 192 */           StandardEncryptor.logger.log(7, new Object[] { "Can't delete temporary encryption file: " + this.fileOut });
/*     */         }
/*     */         
/* 195 */         littleEndianOutputStream.close();
/* 196 */       } catch (IOException iOException) {
/* 197 */         throw new EncryptedDocumentException(iOException);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   protected int getKeySizeInBytes() {
/* 203 */     return this.builder.getHeader().getKeySize() / 8;
/*     */   }
/*     */   
/*     */   protected void createEncryptionInfoEntry(DirectoryNode paramDirectoryNode) throws IOException {
/* 207 */     final EncryptionInfo info = this.builder.getEncryptionInfo();
/* 208 */     final StandardEncryptionHeader header = this.builder.getHeader();
/* 209 */     final StandardEncryptionVerifier verifier = this.builder.getVerifier();
/*     */     
/* 211 */     EncryptionRecord encryptionRecord = new EncryptionRecord() {
/*     */         public void write(LittleEndianByteArrayOutputStream param1LittleEndianByteArrayOutputStream) {
/* 213 */           param1LittleEndianByteArrayOutputStream.writeShort(info.getVersionMajor());
/* 214 */           param1LittleEndianByteArrayOutputStream.writeShort(info.getVersionMinor());
/* 215 */           param1LittleEndianByteArrayOutputStream.writeInt(info.getEncryptionFlags());
/* 216 */           header.write(param1LittleEndianByteArrayOutputStream);
/* 217 */           verifier.write(param1LittleEndianByteArrayOutputStream);
/*     */         }
/*     */       };
/*     */     
/* 221 */     DataSpaceMapUtils.createEncryptionEntry((DirectoryEntry)paramDirectoryNode, "EncryptionInfo", encryptionRecord);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\standard\StandardEncryptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */