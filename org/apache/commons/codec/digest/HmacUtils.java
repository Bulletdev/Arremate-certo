/*      */ package org.apache.commons.codec.digest;
/*      */ 
/*      */ import java.io.BufferedInputStream;
/*      */ import java.io.File;
/*      */ import java.io.FileInputStream;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.security.InvalidKeyException;
/*      */ import java.security.NoSuchAlgorithmException;
/*      */ import javax.crypto.Mac;
/*      */ import javax.crypto.spec.SecretKeySpec;
/*      */ import org.apache.commons.codec.binary.Hex;
/*      */ import org.apache.commons.codec.binary.StringUtils;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class HmacUtils
/*      */ {
/*      */   private static final int STREAM_BUFFER_LENGTH = 1024;
/*      */   private final Mac mac;
/*      */   
/*      */   public static boolean isAvailable(String paramString) {
/*      */     try {
/*   69 */       Mac.getInstance(paramString);
/*   70 */       return true;
/*   71 */     } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
/*   72 */       return false;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isAvailable(HmacAlgorithms paramHmacAlgorithms) {
/*      */     try {
/*   85 */       Mac.getInstance(paramHmacAlgorithms.getName());
/*   86 */       return true;
/*   87 */     } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
/*   88 */       return false;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static Mac getHmacMd5(byte[] paramArrayOfbyte) {
/*  109 */     return getInitializedMac(HmacAlgorithms.HMAC_MD5, paramArrayOfbyte);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static Mac getHmacSha1(byte[] paramArrayOfbyte) {
/*  129 */     return getInitializedMac(HmacAlgorithms.HMAC_SHA_1, paramArrayOfbyte);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static Mac getHmacSha256(byte[] paramArrayOfbyte) {
/*  149 */     return getInitializedMac(HmacAlgorithms.HMAC_SHA_256, paramArrayOfbyte);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static Mac getHmacSha384(byte[] paramArrayOfbyte) {
/*  169 */     return getInitializedMac(HmacAlgorithms.HMAC_SHA_384, paramArrayOfbyte);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static Mac getHmacSha512(byte[] paramArrayOfbyte) {
/*  189 */     return getInitializedMac(HmacAlgorithms.HMAC_SHA_512, paramArrayOfbyte);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Mac getInitializedMac(HmacAlgorithms paramHmacAlgorithms, byte[] paramArrayOfbyte) {
/*  209 */     return getInitializedMac(paramHmacAlgorithms.getName(), paramArrayOfbyte);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Mac getInitializedMac(String paramString, byte[] paramArrayOfbyte) {
/*  230 */     if (paramArrayOfbyte == null) {
/*  231 */       throw new IllegalArgumentException("Null key");
/*      */     }
/*      */     
/*      */     try {
/*  235 */       SecretKeySpec secretKeySpec = new SecretKeySpec(paramArrayOfbyte, paramString);
/*  236 */       Mac mac = Mac.getInstance(paramString);
/*  237 */       mac.init(secretKeySpec);
/*  238 */       return mac;
/*  239 */     } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
/*  240 */       throw new IllegalArgumentException(noSuchAlgorithmException);
/*  241 */     } catch (InvalidKeyException invalidKeyException) {
/*  242 */       throw new IllegalArgumentException(invalidKeyException);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static byte[] hmacMd5(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/*  262 */     return (new HmacUtils(HmacAlgorithms.HMAC_MD5, paramArrayOfbyte1)).hmac(paramArrayOfbyte2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static byte[] hmacMd5(byte[] paramArrayOfbyte, InputStream paramInputStream) throws IOException {
/*  284 */     return (new HmacUtils(HmacAlgorithms.HMAC_MD5, paramArrayOfbyte)).hmac(paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static byte[] hmacMd5(String paramString1, String paramString2) {
/*  301 */     return (new HmacUtils(HmacAlgorithms.HMAC_MD5, paramString1)).hmac(paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static String hmacMd5Hex(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/*  318 */     return (new HmacUtils(HmacAlgorithms.HMAC_MD5, paramArrayOfbyte1)).hmacHex(paramArrayOfbyte2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static String hmacMd5Hex(byte[] paramArrayOfbyte, InputStream paramInputStream) throws IOException {
/*  340 */     return (new HmacUtils(HmacAlgorithms.HMAC_MD5, paramArrayOfbyte)).hmacHex(paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static String hmacMd5Hex(String paramString1, String paramString2) {
/*  357 */     return (new HmacUtils(HmacAlgorithms.HMAC_MD5, paramString1)).hmacHex(paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static byte[] hmacSha1(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/*  376 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_1, paramArrayOfbyte1)).hmac(paramArrayOfbyte2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static byte[] hmacSha1(byte[] paramArrayOfbyte, InputStream paramInputStream) throws IOException {
/*  398 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_1, paramArrayOfbyte)).hmac(paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static byte[] hmacSha1(String paramString1, String paramString2) {
/*  415 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_1, paramString1)).hmac(paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static String hmacSha1Hex(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/*  432 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_1, paramArrayOfbyte1)).hmacHex(paramArrayOfbyte2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static String hmacSha1Hex(byte[] paramArrayOfbyte, InputStream paramInputStream) throws IOException {
/*  454 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_1, paramArrayOfbyte)).hmacHex(paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static String hmacSha1Hex(String paramString1, String paramString2) {
/*  471 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_1, paramString1)).hmacHex(paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static byte[] hmacSha256(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/*  490 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_256, paramArrayOfbyte1)).hmac(paramArrayOfbyte2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static byte[] hmacSha256(byte[] paramArrayOfbyte, InputStream paramInputStream) throws IOException {
/*  512 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_256, paramArrayOfbyte)).hmac(paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static byte[] hmacSha256(String paramString1, String paramString2) {
/*  529 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_256, paramString1)).hmac(paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static String hmacSha256Hex(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/*  546 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_256, paramArrayOfbyte1)).hmacHex(paramArrayOfbyte2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static String hmacSha256Hex(byte[] paramArrayOfbyte, InputStream paramInputStream) throws IOException {
/*  568 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_256, paramArrayOfbyte)).hmacHex(paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static String hmacSha256Hex(String paramString1, String paramString2) {
/*  585 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_256, paramString1)).hmacHex(paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static byte[] hmacSha384(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/*  604 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_384, paramArrayOfbyte1)).hmac(paramArrayOfbyte2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static byte[] hmacSha384(byte[] paramArrayOfbyte, InputStream paramInputStream) throws IOException {
/*  626 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_384, paramArrayOfbyte)).hmac(paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static byte[] hmacSha384(String paramString1, String paramString2) {
/*  643 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_384, paramString1)).hmac(paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static String hmacSha384Hex(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/*  660 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_384, paramArrayOfbyte1)).hmacHex(paramArrayOfbyte2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static String hmacSha384Hex(byte[] paramArrayOfbyte, InputStream paramInputStream) throws IOException {
/*  682 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_384, paramArrayOfbyte)).hmacHex(paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static String hmacSha384Hex(String paramString1, String paramString2) {
/*  699 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_384, paramString1)).hmacHex(paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static byte[] hmacSha512(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/*  718 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_512, paramArrayOfbyte1)).hmac(paramArrayOfbyte2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static byte[] hmacSha512(byte[] paramArrayOfbyte, InputStream paramInputStream) throws IOException {
/*  740 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_512, paramArrayOfbyte)).hmac(paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static byte[] hmacSha512(String paramString1, String paramString2) {
/*  757 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_512, paramString1)).hmac(paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static String hmacSha512Hex(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/*  774 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_512, paramArrayOfbyte1)).hmacHex(paramArrayOfbyte2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static String hmacSha512Hex(byte[] paramArrayOfbyte, InputStream paramInputStream) throws IOException {
/*  796 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_512, paramArrayOfbyte)).hmacHex(paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static String hmacSha512Hex(String paramString1, String paramString2) {
/*  813 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_512, paramString1)).hmacHex(paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Mac updateHmac(Mac paramMac, byte[] paramArrayOfbyte) {
/*  830 */     paramMac.reset();
/*  831 */     paramMac.update(paramArrayOfbyte);
/*  832 */     return paramMac;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Mac updateHmac(Mac paramMac, InputStream paramInputStream) throws IOException {
/*  852 */     paramMac.reset();
/*  853 */     byte[] arrayOfByte = new byte[1024];
/*  854 */     int i = paramInputStream.read(arrayOfByte, 0, 1024);
/*      */     
/*  856 */     while (i > -1) {
/*  857 */       paramMac.update(arrayOfByte, 0, i);
/*  858 */       i = paramInputStream.read(arrayOfByte, 0, 1024);
/*      */     } 
/*      */     
/*  861 */     return paramMac;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Mac updateHmac(Mac paramMac, String paramString) {
/*  876 */     paramMac.reset();
/*  877 */     paramMac.update(StringUtils.getBytesUtf8(paramString));
/*  878 */     return paramMac;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public HmacUtils() {
/*  888 */     this(null);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private HmacUtils(Mac paramMac) {
/*  894 */     this.mac = paramMac;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public HmacUtils(String paramString, byte[] paramArrayOfbyte) {
/*  907 */     this(getInitializedMac(paramString, paramArrayOfbyte));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public HmacUtils(String paramString1, String paramString2) {
/*  920 */     this(paramString1, StringUtils.getBytesUtf8(paramString2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public HmacUtils(HmacAlgorithms paramHmacAlgorithms, String paramString) {
/*  933 */     this(paramHmacAlgorithms.getName(), StringUtils.getBytesUtf8(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public HmacUtils(HmacAlgorithms paramHmacAlgorithms, byte[] paramArrayOfbyte) {
/*  946 */     this(paramHmacAlgorithms.getName(), paramArrayOfbyte);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public byte[] hmac(byte[] paramArrayOfbyte) {
/*  957 */     return this.mac.doFinal(paramArrayOfbyte);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String hmacHex(byte[] paramArrayOfbyte) {
/*  968 */     return Hex.encodeHexString(hmac(paramArrayOfbyte));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public byte[] hmac(String paramString) {
/*  979 */     return this.mac.doFinal(StringUtils.getBytesUtf8(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String hmacHex(String paramString) {
/*  990 */     return Hex.encodeHexString(hmac(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public byte[] hmac(ByteBuffer paramByteBuffer) {
/* 1001 */     this.mac.update(paramByteBuffer);
/* 1002 */     return this.mac.doFinal();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String hmacHex(ByteBuffer paramByteBuffer) {
/* 1013 */     return Hex.encodeHexString(hmac(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public byte[] hmac(InputStream paramInputStream) throws IOException {
/* 1030 */     byte[] arrayOfByte = new byte[1024];
/*      */     
/*      */     int i;
/* 1033 */     while ((i = paramInputStream.read(arrayOfByte, 0, 1024)) > -1) {
/* 1034 */       this.mac.update(arrayOfByte, 0, i);
/*      */     }
/* 1036 */     return this.mac.doFinal();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String hmacHex(InputStream paramInputStream) throws IOException {
/* 1053 */     return Hex.encodeHexString(hmac(paramInputStream));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public byte[] hmac(File paramFile) throws IOException {
/* 1066 */     try (BufferedInputStream null = new BufferedInputStream(new FileInputStream(paramFile))) {
/* 1067 */       return hmac(bufferedInputStream);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String hmacHex(File paramFile) throws IOException {
/* 1081 */     return Hex.encodeHexString(hmac(paramFile));
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\digest\HmacUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */