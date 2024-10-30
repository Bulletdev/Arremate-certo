/*     */ package org.apache.poi.poifs.crypt;
/*     */ 
/*     */ import java.nio.charset.Charset;
/*     */ import java.security.DigestException;
/*     */ import java.security.GeneralSecurityException;
/*     */ import java.security.Key;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.Provider;
/*     */ import java.security.Security;
/*     */ import java.util.Arrays;
/*     */ import java.util.Locale;
/*     */ import javax.crypto.Cipher;
/*     */ import javax.crypto.Mac;
/*     */ import javax.crypto.SecretKey;
/*     */ import javax.crypto.spec.IvParameterSpec;
/*     */ import javax.crypto.spec.RC2ParameterSpec;
/*     */ import org.apache.poi.EncryptedDocumentException;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.util.LittleEndian;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Internal
/*     */ public class CryptoFunctions
/*     */ {
/*     */   public static byte[] hashPassword(String paramString, HashAlgorithm paramHashAlgorithm, byte[] paramArrayOfbyte, int paramInt) {
/*  83 */     return hashPassword(paramString, paramHashAlgorithm, paramArrayOfbyte, paramInt, true);
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
/*     */   public static byte[] hashPassword(String paramString, HashAlgorithm paramHashAlgorithm, byte[] paramArrayOfbyte, int paramInt, boolean paramBoolean) {
/* 101 */     if (paramString == null) {
/* 102 */       paramString = "VelvetSweatshop";
/*     */     }
/*     */     
/* 105 */     MessageDigest messageDigest = getMessageDigest(paramHashAlgorithm);
/*     */     
/* 107 */     messageDigest.update(paramArrayOfbyte);
/* 108 */     byte[] arrayOfByte1 = messageDigest.digest(StringUtil.getToUnicodeLE(paramString));
/* 109 */     byte[] arrayOfByte2 = new byte[4];
/*     */     
/* 111 */     byte[] arrayOfByte3 = paramBoolean ? arrayOfByte2 : arrayOfByte1;
/* 112 */     byte[] arrayOfByte4 = paramBoolean ? arrayOfByte1 : arrayOfByte2;
/*     */     
/*     */     try {
/* 115 */       for (byte b = 0; b < paramInt; b++) {
/* 116 */         LittleEndian.putInt(arrayOfByte2, 0, b);
/* 117 */         messageDigest.reset();
/* 118 */         messageDigest.update(arrayOfByte3);
/* 119 */         messageDigest.update(arrayOfByte4);
/* 120 */         messageDigest.digest(arrayOfByte1, 0, arrayOfByte1.length);
/*     */       } 
/* 122 */     } catch (DigestException digestException) {
/* 123 */       throw new EncryptedDocumentException("error in password hashing");
/*     */     } 
/*     */     
/* 126 */     return arrayOfByte1;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] generateIv(HashAlgorithm paramHashAlgorithm, byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, int paramInt) {
/* 147 */     byte[] arrayOfByte = paramArrayOfbyte1;
/* 148 */     if (paramArrayOfbyte2 != null) {
/* 149 */       MessageDigest messageDigest = getMessageDigest(paramHashAlgorithm);
/* 150 */       messageDigest.update(paramArrayOfbyte1);
/* 151 */       arrayOfByte = messageDigest.digest(paramArrayOfbyte2);
/*     */     } 
/* 153 */     return getBlock36(arrayOfByte, paramInt);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] generateKey(byte[] paramArrayOfbyte1, HashAlgorithm paramHashAlgorithm, byte[] paramArrayOfbyte2, int paramInt) {
/* 178 */     MessageDigest messageDigest = getMessageDigest(paramHashAlgorithm);
/* 179 */     messageDigest.update(paramArrayOfbyte1);
/* 180 */     byte[] arrayOfByte = messageDigest.digest(paramArrayOfbyte2);
/* 181 */     return getBlock36(arrayOfByte, paramInt);
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
/*     */   
/*     */   public static Cipher getCipher(SecretKey paramSecretKey, CipherAlgorithm paramCipherAlgorithm, ChainingMode paramChainingMode, byte[] paramArrayOfbyte, int paramInt) {
/* 200 */     return getCipher(paramSecretKey, paramCipherAlgorithm, paramChainingMode, paramArrayOfbyte, paramInt, null);
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
/*     */ 
/*     */   
/*     */   public static Cipher getCipher(Key paramKey, CipherAlgorithm paramCipherAlgorithm, ChainingMode paramChainingMode, byte[] paramArrayOfbyte, int paramInt, String paramString) {
/* 220 */     int i = (paramKey.getEncoded()).length;
/* 221 */     if (paramString == null) paramString = "NoPadding";
/*     */     
/*     */     try {
/*     */       Cipher cipher;
/* 225 */       if (Cipher.getMaxAllowedKeyLength(paramCipherAlgorithm.jceId) < i * 8) {
/* 226 */         throw new EncryptedDocumentException("Export Restrictions in place - please install JCE Unlimited Strength Jurisdiction Policy files");
/*     */       }
/*     */ 
/*     */       
/* 230 */       if (paramCipherAlgorithm == CipherAlgorithm.rc4) {
/* 231 */         cipher = Cipher.getInstance(paramCipherAlgorithm.jceId);
/* 232 */       } else if (paramCipherAlgorithm.needsBouncyCastle) {
/* 233 */         registerBouncyCastle();
/* 234 */         cipher = Cipher.getInstance(paramCipherAlgorithm.jceId + "/" + paramChainingMode.jceId + "/" + paramString, "BC");
/*     */       } else {
/* 236 */         cipher = Cipher.getInstance(paramCipherAlgorithm.jceId + "/" + paramChainingMode.jceId + "/" + paramString);
/*     */       } 
/*     */       
/* 239 */       if (paramArrayOfbyte == null) {
/* 240 */         cipher.init(paramInt, paramKey);
/*     */       } else {
/*     */         IvParameterSpec ivParameterSpec;
/* 243 */         if (paramCipherAlgorithm == CipherAlgorithm.rc2) {
/* 244 */           RC2ParameterSpec rC2ParameterSpec = new RC2ParameterSpec((paramKey.getEncoded()).length * 8, paramArrayOfbyte);
/*     */         } else {
/* 246 */           ivParameterSpec = new IvParameterSpec(paramArrayOfbyte);
/*     */         } 
/* 248 */         cipher.init(paramInt, paramKey, ivParameterSpec);
/*     */       } 
/* 250 */       return cipher;
/* 251 */     } catch (GeneralSecurityException generalSecurityException) {
/* 252 */       throw new EncryptedDocumentException(generalSecurityException);
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
/*     */   private static byte[] getBlock36(byte[] paramArrayOfbyte, int paramInt) {
/* 265 */     return getBlockX(paramArrayOfbyte, paramInt, (byte)54);
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
/*     */   public static byte[] getBlock0(byte[] paramArrayOfbyte, int paramInt) {
/* 277 */     return getBlockX(paramArrayOfbyte, paramInt, (byte)0);
/*     */   }
/*     */   
/*     */   private static byte[] getBlockX(byte[] paramArrayOfbyte, int paramInt, byte paramByte) {
/* 281 */     if (paramArrayOfbyte.length == paramInt) return paramArrayOfbyte;
/*     */     
/* 283 */     byte[] arrayOfByte = new byte[paramInt];
/* 284 */     Arrays.fill(arrayOfByte, paramByte);
/* 285 */     System.arraycopy(paramArrayOfbyte, 0, arrayOfByte, 0, Math.min(arrayOfByte.length, paramArrayOfbyte.length));
/* 286 */     return arrayOfByte;
/*     */   }
/*     */   
/*     */   public static MessageDigest getMessageDigest(HashAlgorithm paramHashAlgorithm) {
/*     */     try {
/* 291 */       if (paramHashAlgorithm.needsBouncyCastle) {
/* 292 */         registerBouncyCastle();
/* 293 */         return MessageDigest.getInstance(paramHashAlgorithm.jceId, "BC");
/*     */       } 
/* 295 */       return MessageDigest.getInstance(paramHashAlgorithm.jceId);
/*     */     }
/* 297 */     catch (GeneralSecurityException generalSecurityException) {
/* 298 */       throw new EncryptedDocumentException("hash algo not supported", generalSecurityException);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static Mac getMac(HashAlgorithm paramHashAlgorithm) {
/*     */     try {
/* 304 */       if (paramHashAlgorithm.needsBouncyCastle) {
/* 305 */         registerBouncyCastle();
/* 306 */         return Mac.getInstance(paramHashAlgorithm.jceHmacId, "BC");
/*     */       } 
/* 308 */       return Mac.getInstance(paramHashAlgorithm.jceHmacId);
/*     */     }
/* 310 */     catch (GeneralSecurityException generalSecurityException) {
/* 311 */       throw new EncryptedDocumentException("hmac algo not supported", generalSecurityException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void registerBouncyCastle() {
/* 317 */     if (Security.getProvider("BC") != null) {
/*     */       return;
/*     */     }
/*     */     
/*     */     try {
/* 322 */       ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
/* 323 */       String str = "org.bouncycastle.jce.provider.BouncyCastleProvider";
/* 324 */       Class<?> clazz = classLoader.loadClass(str);
/* 325 */       Security.addProvider((Provider)clazz.newInstance());
/* 326 */     } catch (Exception exception) {
/* 327 */       throw new EncryptedDocumentException("Only the BouncyCastle provider supports your encryption settings - please add it to the classpath.", exception);
/*     */     } 
/*     */   }
/*     */   
/* 331 */   private static final int[] INITIAL_CODE_ARRAY = new int[] { 57840, 7439, 52380, 33984, 4364, 3600, 61902, 12606, 6258, 57657, 54287, 34041, 10252, 43370, 20163 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 337 */   private static final byte[] PAD_ARRAY = new byte[] { -69, -1, -1, -70, -1, -1, -71, Byte.MIN_VALUE, 0, -66, 15, 0, -65, 15, 0 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 343 */   private static final int[][] ENCRYPTION_MATRIX = new int[][] { { 44796, 19929, 39858, 10053, 20106, 40212, 10761 }, { 31585, 63170, 64933, 60267, 50935, 40399, 11199 }, { 17763, 35526, 1453, 2906, 5812, 11624, 23248 }, { 885, 1770, 3540, 7080, 14160, 28320, 56640 }, { 55369, 41139, 20807, 41614, 21821, 43642, 17621 }, { 28485, 56970, 44341, 19019, 38038, 14605, 29210 }, { 60195, 50791, 40175, 10751, 21502, 43004, 24537 }, { 18387, 36774, 3949, 7898, 15796, 31592, 63184 }, { 47201, 24803, 49606, 37805, 14203, 28406, 56812 }, { 17824, 35648, 1697, 3394, 6788, 13576, 27152 }, { 43601, 17539, 35078, 557, 1114, 2228, 4456 }, { 30388, 60776, 51953, 34243, 7079, 14158, 28316 }, { 14128, 28256, 56512, 43425, 17251, 34502, 7597 }, { 13105, 26210, 52420, 35241, 883, 1766, 3532 }, { 4129, 8258, 16516, 33032, 4657, 9314, 18628 } };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int createXorVerifier1(String paramString) {
/* 372 */     byte[] arrayOfByte = toAnsiPassword(paramString);
/*     */ 
/*     */     
/* 375 */     short s = 0;
/*     */     
/* 377 */     if (!"".equals(paramString)) {
/*     */       
/* 379 */       for (int i = arrayOfByte.length - 1; i >= 0; i--) {
/*     */         
/* 381 */         s = rotateLeftBase15Bit(s);
/* 382 */         s = (short)(s ^ arrayOfByte[i]);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 387 */       s = rotateLeftBase15Bit(s);
/* 388 */       s = (short)(s ^ arrayOfByte.length);
/*     */ 
/*     */       
/* 391 */       s = (short)(s ^ 0xCE4B);
/*     */     } 
/*     */     
/* 394 */     return s & 0xFFFF;
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
/*     */   public static int createXorVerifier2(String paramString) {
/* 411 */     byte[] arrayOfByte = new byte[4];
/*     */ 
/*     */     
/* 414 */     byte b = 15;
/*     */     
/* 416 */     if (!"".equals(paramString)) {
/*     */       
/* 418 */       paramString = paramString.substring(0, Math.min(paramString.length(), 15));
/*     */       
/* 420 */       byte[] arrayOfByte1 = toAnsiPassword(paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 425 */       int i = INITIAL_CODE_ARRAY[arrayOfByte1.length - 1];
/*     */ 
/*     */       
/*     */       int j;
/*     */ 
/*     */       
/* 431 */       for (j = 0; j < arrayOfByte1.length; j++) {
/* 432 */         int k = 15 - arrayOfByte1.length + j;
/* 433 */         for (byte b1 = 0; b1 < 7; b1++) {
/* 434 */           if ((arrayOfByte1[j] & 1 << b1) != 0) {
/* 435 */             i ^= ENCRYPTION_MATRIX[k][b1];
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 441 */       j = createXorVerifier1(paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 446 */       LittleEndian.putShort(arrayOfByte, 0, (short)j);
/* 447 */       LittleEndian.putShort(arrayOfByte, 2, (short)i);
/*     */     } 
/*     */     
/* 450 */     return LittleEndian.getInt(arrayOfByte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String xorHashPassword(String paramString) {
/* 457 */     int i = createXorVerifier2(paramString);
/* 458 */     return String.format(Locale.ROOT, "%1$08X", new Object[] { Integer.valueOf(i) });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String xorHashPasswordReversed(String paramString) {
/* 466 */     int i = createXorVerifier2(paramString);
/*     */     
/* 468 */     return String.format(Locale.ROOT, "%1$02X%2$02X%3$02X%4$02X", new Object[] { Integer.valueOf(i >>> 0 & 0xFF), Integer.valueOf(i >>> 8 & 0xFF), Integer.valueOf(i >>> 16 & 0xFF), Integer.valueOf(i >>> 24 & 0xFF) });
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
/*     */ 
/*     */   
/*     */   public static int createXorKey1(String paramString) {
/* 488 */     return createXorVerifier2(paramString) >>> 16;
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
/*     */   public static byte[] createXorArray1(String paramString) {
/* 501 */     if (paramString.length() > 15) paramString = paramString.substring(0, 15); 
/* 502 */     byte[] arrayOfByte1 = paramString.getBytes(Charset.forName("ASCII"));
/*     */ 
/*     */ 
/*     */     
/* 506 */     byte[] arrayOfByte2 = new byte[16];
/* 507 */     System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
/* 508 */     System.arraycopy(PAD_ARRAY, 0, arrayOfByte2, arrayOfByte1.length, PAD_ARRAY.length - arrayOfByte1.length + 1);
/*     */     
/* 510 */     int i = createXorKey1(paramString);
/*     */ 
/*     */     
/* 513 */     byte b1 = 2;
/*     */     
/* 515 */     byte[] arrayOfByte3 = { (byte)(i & 0xFF), (byte)(i >>> 8 & 0xFF) };
/* 516 */     for (byte b2 = 0; b2 < arrayOfByte2.length; b2++) {
/* 517 */       arrayOfByte2[b2] = (byte)(arrayOfByte2[b2] ^ arrayOfByte3[b2 & 0x1]);
/* 518 */       arrayOfByte2[b2] = rotateLeft(arrayOfByte2[b2], b1);
/*     */     } 
/*     */     
/* 521 */     return arrayOfByte2;
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
/*     */   private static byte[] toAnsiPassword(String paramString) {
/* 538 */     byte[] arrayOfByte = new byte[paramString.length()];
/*     */     
/* 540 */     for (byte b = 0; b < paramString.length(); b++) {
/* 541 */       char c = paramString.charAt(b);
/* 542 */       byte b1 = (byte)(c & 0xFF);
/* 543 */       byte b2 = (byte)(c >>> 8 & 0xFF);
/* 544 */       arrayOfByte[b] = (b1 != 0) ? b1 : b2;
/*     */     } 
/*     */     
/* 547 */     return arrayOfByte;
/*     */   }
/*     */   
/*     */   private static byte rotateLeft(byte paramByte, int paramInt) {
/* 551 */     return (byte)((paramByte & 0xFF) << paramInt | (paramByte & 0xFF) >>> 8 - paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static short rotateLeftBase15Bit(short paramShort) {
/* 562 */     short s1 = (short)(((paramShort & 0x4000) == 0) ? 0 : 1);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 567 */     short s2 = (short)(paramShort << 1 & 0x7FFF);
/*     */ 
/*     */ 
/*     */     
/* 571 */     return (short)(s1 | s2);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\CryptoFunctions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */