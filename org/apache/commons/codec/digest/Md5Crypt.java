/*     */ package org.apache.commons.codec.digest;
/*     */ 
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.SecureRandom;
/*     */ import java.util.Arrays;
/*     */ import java.util.Random;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Md5Crypt
/*     */ {
/*     */   static final String APR1_PREFIX = "$apr1$";
/*     */   private static final int BLOCKSIZE = 16;
/*     */   static final String MD5_PREFIX = "$1$";
/*     */   private static final int ROUNDS = 1000;
/*     */   
/*     */   public static String apr1Crypt(byte[] paramArrayOfbyte) {
/*  80 */     return apr1Crypt(paramArrayOfbyte, "$apr1$" + B64.getRandomSalt(8));
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
/*     */   public static String apr1Crypt(byte[] paramArrayOfbyte, Random paramRandom) {
/*  98 */     return apr1Crypt(paramArrayOfbyte, "$apr1$" + B64.getRandomSalt(8, paramRandom));
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
/*     */   public static String apr1Crypt(byte[] paramArrayOfbyte, String paramString) {
/* 121 */     if (paramString != null && !paramString.startsWith("$apr1$")) {
/* 122 */       paramString = "$apr1$" + paramString;
/*     */     }
/* 124 */     return md5Crypt(paramArrayOfbyte, paramString, "$apr1$");
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
/*     */   public static String apr1Crypt(String paramString) {
/* 142 */     return apr1Crypt(paramString.getBytes(StandardCharsets.UTF_8));
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
/*     */   public static String apr1Crypt(String paramString1, String paramString2) {
/* 164 */     return apr1Crypt(paramString1.getBytes(StandardCharsets.UTF_8), paramString2);
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
/*     */   public static String md5Crypt(byte[] paramArrayOfbyte) {
/* 184 */     return md5Crypt(paramArrayOfbyte, "$1$" + B64.getRandomSalt(8));
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
/*     */   public static String md5Crypt(byte[] paramArrayOfbyte, Random paramRandom) {
/* 207 */     return md5Crypt(paramArrayOfbyte, "$1$" + B64.getRandomSalt(8, paramRandom));
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
/*     */   public static String md5Crypt(byte[] paramArrayOfbyte, String paramString) {
/* 230 */     return md5Crypt(paramArrayOfbyte, paramString, "$1$");
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
/*     */   public static String md5Crypt(byte[] paramArrayOfbyte, String paramString1, String paramString2) {
/* 255 */     return md5Crypt(paramArrayOfbyte, paramString1, paramString2, new SecureRandom());
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
/*     */ 
/*     */   
/*     */   public static String md5Crypt(byte[] paramArrayOfbyte, String paramString1, String paramString2, Random paramRandom) {
/*     */     String str;
/* 283 */     int i = paramArrayOfbyte.length;
/*     */ 
/*     */ 
/*     */     
/* 287 */     if (paramString1 == null) {
/* 288 */       str = B64.getRandomSalt(8, paramRandom);
/*     */     } else {
/* 290 */       Pattern pattern = Pattern.compile("^" + paramString2.replace("$", "\\$") + "([\\.\\/a-zA-Z0-9]{1,8}).*");
/* 291 */       Matcher matcher = pattern.matcher(paramString1);
/* 292 */       if (!matcher.find()) {
/* 293 */         throw new IllegalArgumentException("Invalid salt value: " + paramString1);
/*     */       }
/* 295 */       str = matcher.group(1);
/*     */     } 
/* 297 */     byte[] arrayOfByte1 = str.getBytes(StandardCharsets.UTF_8);
/*     */     
/* 299 */     MessageDigest messageDigest1 = DigestUtils.getMd5Digest();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 304 */     messageDigest1.update(paramArrayOfbyte);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 309 */     messageDigest1.update(paramString2.getBytes(StandardCharsets.UTF_8));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 314 */     messageDigest1.update(arrayOfByte1);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 319 */     MessageDigest messageDigest2 = DigestUtils.getMd5Digest();
/* 320 */     messageDigest2.update(paramArrayOfbyte);
/* 321 */     messageDigest2.update(arrayOfByte1);
/* 322 */     messageDigest2.update(paramArrayOfbyte);
/* 323 */     byte[] arrayOfByte2 = messageDigest2.digest();
/* 324 */     int j = i;
/* 325 */     while (j > 0) {
/* 326 */       messageDigest1.update(arrayOfByte2, 0, (j > 16) ? 16 : j);
/* 327 */       j -= 16;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 333 */     Arrays.fill(arrayOfByte2, (byte)0);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 338 */     j = i;
/* 339 */     boolean bool = false;
/* 340 */     while (j > 0) {
/* 341 */       if ((j & 0x1) == 1) {
/* 342 */         messageDigest1.update(arrayOfByte2[0]);
/*     */       } else {
/* 344 */         messageDigest1.update(paramArrayOfbyte[0]);
/*     */       } 
/* 346 */       j >>= 1;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 352 */     StringBuilder stringBuilder = new StringBuilder(paramString2 + str + "$");
/* 353 */     arrayOfByte2 = messageDigest1.digest();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 359 */     for (byte b = 0; b < 'Ϩ'; b++) {
/* 360 */       messageDigest2 = DigestUtils.getMd5Digest();
/* 361 */       if ((b & 0x1) != 0) {
/* 362 */         messageDigest2.update(paramArrayOfbyte);
/*     */       } else {
/* 364 */         messageDigest2.update(arrayOfByte2, 0, 16);
/*     */       } 
/*     */       
/* 367 */       if (b % 3 != 0) {
/* 368 */         messageDigest2.update(arrayOfByte1);
/*     */       }
/*     */       
/* 371 */       if (b % 7 != 0) {
/* 372 */         messageDigest2.update(paramArrayOfbyte);
/*     */       }
/*     */       
/* 375 */       if ((b & 0x1) != 0) {
/* 376 */         messageDigest2.update(arrayOfByte2, 0, 16);
/*     */       } else {
/* 378 */         messageDigest2.update(paramArrayOfbyte);
/*     */       } 
/* 380 */       arrayOfByte2 = messageDigest2.digest();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 386 */     B64.b64from24bit(arrayOfByte2[0], arrayOfByte2[6], arrayOfByte2[12], 4, stringBuilder);
/* 387 */     B64.b64from24bit(arrayOfByte2[1], arrayOfByte2[7], arrayOfByte2[13], 4, stringBuilder);
/* 388 */     B64.b64from24bit(arrayOfByte2[2], arrayOfByte2[8], arrayOfByte2[14], 4, stringBuilder);
/* 389 */     B64.b64from24bit(arrayOfByte2[3], arrayOfByte2[9], arrayOfByte2[15], 4, stringBuilder);
/* 390 */     B64.b64from24bit(arrayOfByte2[4], arrayOfByte2[10], arrayOfByte2[5], 4, stringBuilder);
/* 391 */     B64.b64from24bit((byte)0, (byte)0, arrayOfByte2[11], 2, stringBuilder);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 397 */     messageDigest1.reset();
/* 398 */     messageDigest2.reset();
/* 399 */     Arrays.fill(paramArrayOfbyte, (byte)0);
/* 400 */     Arrays.fill(arrayOfByte1, (byte)0);
/* 401 */     Arrays.fill(arrayOfByte2, (byte)0);
/*     */     
/* 403 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\digest\Md5Crypt.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */