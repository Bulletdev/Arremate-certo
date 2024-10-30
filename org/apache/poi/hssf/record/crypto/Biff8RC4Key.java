/*     */ package org.apache.poi.hssf.record.crypto;
/*     */ 
/*     */ import java.security.GeneralSecurityException;
/*     */ import java.security.MessageDigest;
/*     */ import java.util.Arrays;
/*     */ import javax.crypto.Cipher;
/*     */ import javax.crypto.ShortBufferException;
/*     */ import javax.crypto.spec.SecretKeySpec;
/*     */ import org.apache.poi.EncryptedDocumentException;
/*     */ import org.apache.poi.poifs.crypt.CipherAlgorithm;
/*     */ import org.apache.poi.poifs.crypt.CryptoFunctions;
/*     */ import org.apache.poi.poifs.crypt.HashAlgorithm;
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.LittleEndian;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Biff8RC4Key
/*     */   extends Biff8EncryptionKey
/*     */ {
/*     */   public static final int KEY_DIGEST_LENGTH = 5;
/*     */   private static final int PASSWORD_HASH_NUMBER_OF_BYTES_USED = 5;
/*  43 */   private static POILogger log = POILogFactory.getLogger(Biff8RC4Key.class);
/*     */   
/*     */   Biff8RC4Key(byte[] paramArrayOfbyte) {
/*  46 */     if (paramArrayOfbyte.length != 5) {
/*  47 */       throw new IllegalArgumentException("Expected 5 byte key digest, but got " + HexDump.toHex(paramArrayOfbyte));
/*     */     }
/*     */     
/*  50 */     CipherAlgorithm cipherAlgorithm = CipherAlgorithm.rc4;
/*  51 */     this._secretKey = new SecretKeySpec((byte[])paramArrayOfbyte.clone(), cipherAlgorithm.jceId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Biff8RC4Key create(String paramString, byte[] paramArrayOfbyte) {
/*  59 */     return new Biff8RC4Key(createKeyDigest(paramString, paramArrayOfbyte));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean validate(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/*  66 */     check16Bytes(paramArrayOfbyte1, "verifier");
/*  67 */     check16Bytes(paramArrayOfbyte2, "verifierHash");
/*     */ 
/*     */     
/*  70 */     Cipher cipher = getCipher();
/*  71 */     initCipherForBlock(cipher, 0);
/*     */     
/*  73 */     byte[] arrayOfByte1 = (byte[])paramArrayOfbyte1.clone();
/*  74 */     byte[] arrayOfByte2 = (byte[])paramArrayOfbyte2.clone();
/*     */     
/*     */     try {
/*  77 */       cipher.update(arrayOfByte1, 0, arrayOfByte1.length, arrayOfByte1);
/*  78 */       cipher.update(arrayOfByte2, 0, arrayOfByte2.length, arrayOfByte2);
/*  79 */     } catch (ShortBufferException shortBufferException) {
/*  80 */       throw new EncryptedDocumentException("buffer too short", shortBufferException);
/*     */     } 
/*     */     
/*  83 */     MessageDigest messageDigest = CryptoFunctions.getMessageDigest(HashAlgorithm.md5);
/*  84 */     messageDigest.update(arrayOfByte1);
/*  85 */     byte[] arrayOfByte3 = messageDigest.digest();
/*     */     
/*  87 */     if (log.check(1)) {
/*  88 */       byte[] arrayOfByte = xor(paramArrayOfbyte2, xor(arrayOfByte2, arrayOfByte3));
/*  89 */       log.log(1, new Object[] { "valid verifierHash value", HexDump.toHex(arrayOfByte) });
/*     */     } 
/*     */     
/*  92 */     return Arrays.equals(arrayOfByte2, arrayOfByte3);
/*     */   }
/*     */   
/*     */   Cipher getCipher() {
/*  96 */     CipherAlgorithm cipherAlgorithm = CipherAlgorithm.rc4;
/*  97 */     return CryptoFunctions.getCipher(this._secretKey, cipherAlgorithm, null, null, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   static byte[] createKeyDigest(String paramString, byte[] paramArrayOfbyte) {
/* 102 */     check16Bytes(paramArrayOfbyte, "docId");
/* 103 */     int i = Math.min(paramString.length(), 16);
/* 104 */     byte[] arrayOfByte1 = new byte[i * 2];
/* 105 */     for (byte b1 = 0; b1 < i; b1++) {
/* 106 */       char c = paramString.charAt(b1);
/* 107 */       arrayOfByte1[b1 * 2 + 0] = (byte)(c << 0 & 0xFF);
/* 108 */       arrayOfByte1[b1 * 2 + 1] = (byte)(c << 8 & 0xFF);
/*     */     } 
/*     */     
/* 111 */     MessageDigest messageDigest = CryptoFunctions.getMessageDigest(HashAlgorithm.md5);
/* 112 */     messageDigest.update(arrayOfByte1);
/* 113 */     byte[] arrayOfByte2 = messageDigest.digest();
/* 114 */     messageDigest.reset();
/*     */     
/* 116 */     for (byte b2 = 0; b2 < 16; b2++) {
/* 117 */       messageDigest.update(arrayOfByte2, 0, 5);
/* 118 */       messageDigest.update(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */     } 
/*     */     
/* 121 */     return CryptoFunctions.getBlock0(messageDigest.digest(), 5);
/*     */   }
/*     */ 
/*     */   
/*     */   void initCipherForBlock(Cipher paramCipher, int paramInt) {
/* 126 */     byte[] arrayOfByte = new byte[4];
/* 127 */     LittleEndian.putInt(arrayOfByte, 0, paramInt);
/*     */     
/* 129 */     MessageDigest messageDigest = CryptoFunctions.getMessageDigest(HashAlgorithm.md5);
/* 130 */     messageDigest.update(this._secretKey.getEncoded());
/* 131 */     messageDigest.update(arrayOfByte);
/*     */     
/* 133 */     SecretKeySpec secretKeySpec = new SecretKeySpec(messageDigest.digest(), this._secretKey.getAlgorithm());
/*     */     try {
/* 135 */       paramCipher.init(1, secretKeySpec);
/* 136 */     } catch (GeneralSecurityException generalSecurityException) {
/* 137 */       throw new EncryptedDocumentException("Can't rekey for next block", generalSecurityException);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static byte[] xor(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/* 142 */     byte[] arrayOfByte = new byte[paramArrayOfbyte1.length];
/* 143 */     for (byte b = 0; b < arrayOfByte.length; b++) {
/* 144 */       arrayOfByte[b] = (byte)(paramArrayOfbyte1[b] ^ paramArrayOfbyte2[b]);
/*     */     }
/* 146 */     return arrayOfByte;
/*     */   }
/*     */   private static void check16Bytes(byte[] paramArrayOfbyte, String paramString) {
/* 149 */     if (paramArrayOfbyte.length != 16)
/* 150 */       throw new IllegalArgumentException("Expected 16 byte " + paramString + ", but got " + HexDump.toHex(paramArrayOfbyte)); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\crypto\Biff8RC4Key.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */