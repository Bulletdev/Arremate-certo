/*     */ package org.apache.commons.codec.digest;
/*     */ 
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.security.MessageDigest;
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
/*     */ public class Sha2Crypt
/*     */ {
/*     */   private static final int ROUNDS_DEFAULT = 5000;
/*     */   private static final int ROUNDS_MAX = 999999999;
/*     */   private static final int ROUNDS_MIN = 1000;
/*     */   private static final String ROUNDS_PREFIX = "rounds=";
/*     */   private static final int SHA256_BLOCKSIZE = 32;
/*     */   static final String SHA256_PREFIX = "$5$";
/*     */   private static final int SHA512_BLOCKSIZE = 64;
/*     */   static final String SHA512_PREFIX = "$6$";
/*  70 */   private static final Pattern SALT_PATTERN = Pattern.compile("^\\$([56])\\$(rounds=(\\d+)\\$)?([\\.\\/a-zA-Z0-9]{1,16}).*");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String sha256Crypt(byte[] paramArrayOfbyte) {
/*  89 */     return sha256Crypt(paramArrayOfbyte, null);
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
/*     */   public static String sha256Crypt(byte[] paramArrayOfbyte, String paramString) {
/* 110 */     if (paramString == null) {
/* 111 */       paramString = "$5$" + B64.getRandomSalt(8);
/*     */     }
/* 113 */     return sha2Crypt(paramArrayOfbyte, paramString, "$5$", 32, "SHA-256");
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
/*     */   public static String sha256Crypt(byte[] paramArrayOfbyte, String paramString, Random paramRandom) {
/* 136 */     if (paramString == null) {
/* 137 */       paramString = "$5$" + B64.getRandomSalt(8, paramRandom);
/*     */     }
/* 139 */     return sha2Crypt(paramArrayOfbyte, paramString, "$5$", 32, "SHA-256");
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String sha2Crypt(byte[] paramArrayOfbyte, String paramString1, String paramString2, int paramInt, String paramString3) {
/* 170 */     int i = paramArrayOfbyte.length;
/*     */ 
/*     */     
/* 173 */     int j = 5000;
/* 174 */     boolean bool = false;
/* 175 */     if (paramString1 == null) {
/* 176 */       throw new IllegalArgumentException("Salt must not be null");
/*     */     }
/*     */     
/* 179 */     Matcher matcher = SALT_PATTERN.matcher(paramString1);
/* 180 */     if (!matcher.find()) {
/* 181 */       throw new IllegalArgumentException("Invalid salt value: " + paramString1);
/*     */     }
/* 183 */     if (matcher.group(3) != null) {
/* 184 */       j = Integer.parseInt(matcher.group(3));
/* 185 */       j = Math.max(1000, Math.min(999999999, j));
/* 186 */       bool = true;
/*     */     } 
/* 188 */     String str = matcher.group(4);
/* 189 */     byte[] arrayOfByte1 = str.getBytes(StandardCharsets.UTF_8);
/* 190 */     int k = arrayOfByte1.length;
/*     */ 
/*     */ 
/*     */     
/* 194 */     MessageDigest messageDigest1 = DigestUtils.getDigest(paramString3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 200 */     messageDigest1.update(paramArrayOfbyte);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 215 */     messageDigest1.update(arrayOfByte1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 222 */     MessageDigest messageDigest2 = DigestUtils.getDigest(paramString3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 228 */     messageDigest2.update(paramArrayOfbyte);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 234 */     messageDigest2.update(arrayOfByte1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 240 */     messageDigest2.update(paramArrayOfbyte);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 246 */     byte[] arrayOfByte2 = messageDigest2.digest();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 256 */     int m = paramArrayOfbyte.length;
/* 257 */     while (m > paramInt) {
/* 258 */       messageDigest1.update(arrayOfByte2, 0, paramInt);
/* 259 */       m -= paramInt;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 264 */     messageDigest1.update(arrayOfByte2, 0, m);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 280 */     m = paramArrayOfbyte.length;
/* 281 */     while (m > 0) {
/* 282 */       if ((m & 0x1) != 0) {
/* 283 */         messageDigest1.update(arrayOfByte2, 0, paramInt);
/*     */       } else {
/* 285 */         messageDigest1.update(paramArrayOfbyte);
/*     */       } 
/* 287 */       m >>= 1;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 294 */     arrayOfByte2 = messageDigest1.digest();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 300 */     messageDigest2 = DigestUtils.getDigest(paramString3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 309 */     for (byte b1 = 1; b1 <= i; b1++) {
/* 310 */       messageDigest2.update(paramArrayOfbyte);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 317 */     byte[] arrayOfByte3 = messageDigest2.digest();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 329 */     byte[] arrayOfByte4 = new byte[i];
/* 330 */     int n = 0;
/* 331 */     while (n < i - paramInt) {
/* 332 */       System.arraycopy(arrayOfByte3, 0, arrayOfByte4, n, paramInt);
/* 333 */       n += paramInt;
/*     */     } 
/* 335 */     System.arraycopy(arrayOfByte3, 0, arrayOfByte4, n, i - n);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 341 */     messageDigest2 = DigestUtils.getDigest(paramString3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 350 */     for (byte b2 = 1; b2 <= 16 + (arrayOfByte2[0] & 0xFF); b2++) {
/* 351 */       messageDigest2.update(arrayOfByte1);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 358 */     arrayOfByte3 = messageDigest2.digest();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 371 */     byte[] arrayOfByte5 = new byte[k];
/* 372 */     n = 0;
/* 373 */     while (n < k - paramInt) {
/* 374 */       System.arraycopy(arrayOfByte3, 0, arrayOfByte5, n, paramInt);
/* 375 */       n += paramInt;
/*     */     } 
/* 377 */     System.arraycopy(arrayOfByte3, 0, arrayOfByte5, n, k - n);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 390 */     for (byte b3 = 0; b3 <= j - 1; b3++) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 395 */       messageDigest1 = DigestUtils.getDigest(paramString3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 402 */       if ((b3 & 0x1) != 0) {
/* 403 */         messageDigest1.update(arrayOfByte4, 0, i);
/*     */       } else {
/* 405 */         messageDigest1.update(arrayOfByte2, 0, paramInt);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 412 */       if (b3 % 3 != 0) {
/* 413 */         messageDigest1.update(arrayOfByte5, 0, k);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 420 */       if (b3 % 7 != 0) {
/* 421 */         messageDigest1.update(arrayOfByte4, 0, i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 429 */       if ((b3 & 0x1) != 0) {
/* 430 */         messageDigest1.update(arrayOfByte2, 0, paramInt);
/*     */       } else {
/* 432 */         messageDigest1.update(arrayOfByte4, 0, i);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 439 */       arrayOfByte2 = messageDigest1.digest();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 457 */     StringBuilder stringBuilder = new StringBuilder(paramString2);
/* 458 */     if (bool) {
/* 459 */       stringBuilder.append("rounds=");
/* 460 */       stringBuilder.append(j);
/* 461 */       stringBuilder.append("$");
/*     */     } 
/* 463 */     stringBuilder.append(str);
/* 464 */     stringBuilder.append("$");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 490 */     if (paramInt == 32) {
/* 491 */       B64.b64from24bit(arrayOfByte2[0], arrayOfByte2[10], arrayOfByte2[20], 4, stringBuilder);
/* 492 */       B64.b64from24bit(arrayOfByte2[21], arrayOfByte2[1], arrayOfByte2[11], 4, stringBuilder);
/* 493 */       B64.b64from24bit(arrayOfByte2[12], arrayOfByte2[22], arrayOfByte2[2], 4, stringBuilder);
/* 494 */       B64.b64from24bit(arrayOfByte2[3], arrayOfByte2[13], arrayOfByte2[23], 4, stringBuilder);
/* 495 */       B64.b64from24bit(arrayOfByte2[24], arrayOfByte2[4], arrayOfByte2[14], 4, stringBuilder);
/* 496 */       B64.b64from24bit(arrayOfByte2[15], arrayOfByte2[25], arrayOfByte2[5], 4, stringBuilder);
/* 497 */       B64.b64from24bit(arrayOfByte2[6], arrayOfByte2[16], arrayOfByte2[26], 4, stringBuilder);
/* 498 */       B64.b64from24bit(arrayOfByte2[27], arrayOfByte2[7], arrayOfByte2[17], 4, stringBuilder);
/* 499 */       B64.b64from24bit(arrayOfByte2[18], arrayOfByte2[28], arrayOfByte2[8], 4, stringBuilder);
/* 500 */       B64.b64from24bit(arrayOfByte2[9], arrayOfByte2[19], arrayOfByte2[29], 4, stringBuilder);
/* 501 */       B64.b64from24bit((byte)0, arrayOfByte2[31], arrayOfByte2[30], 3, stringBuilder);
/*     */     } else {
/* 503 */       B64.b64from24bit(arrayOfByte2[0], arrayOfByte2[21], arrayOfByte2[42], 4, stringBuilder);
/* 504 */       B64.b64from24bit(arrayOfByte2[22], arrayOfByte2[43], arrayOfByte2[1], 4, stringBuilder);
/* 505 */       B64.b64from24bit(arrayOfByte2[44], arrayOfByte2[2], arrayOfByte2[23], 4, stringBuilder);
/* 506 */       B64.b64from24bit(arrayOfByte2[3], arrayOfByte2[24], arrayOfByte2[45], 4, stringBuilder);
/* 507 */       B64.b64from24bit(arrayOfByte2[25], arrayOfByte2[46], arrayOfByte2[4], 4, stringBuilder);
/* 508 */       B64.b64from24bit(arrayOfByte2[47], arrayOfByte2[5], arrayOfByte2[26], 4, stringBuilder);
/* 509 */       B64.b64from24bit(arrayOfByte2[6], arrayOfByte2[27], arrayOfByte2[48], 4, stringBuilder);
/* 510 */       B64.b64from24bit(arrayOfByte2[28], arrayOfByte2[49], arrayOfByte2[7], 4, stringBuilder);
/* 511 */       B64.b64from24bit(arrayOfByte2[50], arrayOfByte2[8], arrayOfByte2[29], 4, stringBuilder);
/* 512 */       B64.b64from24bit(arrayOfByte2[9], arrayOfByte2[30], arrayOfByte2[51], 4, stringBuilder);
/* 513 */       B64.b64from24bit(arrayOfByte2[31], arrayOfByte2[52], arrayOfByte2[10], 4, stringBuilder);
/* 514 */       B64.b64from24bit(arrayOfByte2[53], arrayOfByte2[11], arrayOfByte2[32], 4, stringBuilder);
/* 515 */       B64.b64from24bit(arrayOfByte2[12], arrayOfByte2[33], arrayOfByte2[54], 4, stringBuilder);
/* 516 */       B64.b64from24bit(arrayOfByte2[34], arrayOfByte2[55], arrayOfByte2[13], 4, stringBuilder);
/* 517 */       B64.b64from24bit(arrayOfByte2[56], arrayOfByte2[14], arrayOfByte2[35], 4, stringBuilder);
/* 518 */       B64.b64from24bit(arrayOfByte2[15], arrayOfByte2[36], arrayOfByte2[57], 4, stringBuilder);
/* 519 */       B64.b64from24bit(arrayOfByte2[37], arrayOfByte2[58], arrayOfByte2[16], 4, stringBuilder);
/* 520 */       B64.b64from24bit(arrayOfByte2[59], arrayOfByte2[17], arrayOfByte2[38], 4, stringBuilder);
/* 521 */       B64.b64from24bit(arrayOfByte2[18], arrayOfByte2[39], arrayOfByte2[60], 4, stringBuilder);
/* 522 */       B64.b64from24bit(arrayOfByte2[40], arrayOfByte2[61], arrayOfByte2[19], 4, stringBuilder);
/* 523 */       B64.b64from24bit(arrayOfByte2[62], arrayOfByte2[20], arrayOfByte2[41], 4, stringBuilder);
/* 524 */       B64.b64from24bit((byte)0, (byte)0, arrayOfByte2[63], 2, stringBuilder);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 532 */     Arrays.fill(arrayOfByte3, (byte)0);
/* 533 */     Arrays.fill(arrayOfByte4, (byte)0);
/* 534 */     Arrays.fill(arrayOfByte5, (byte)0);
/* 535 */     messageDigest1.reset();
/* 536 */     messageDigest2.reset();
/* 537 */     Arrays.fill(paramArrayOfbyte, (byte)0);
/* 538 */     Arrays.fill(arrayOfByte1, (byte)0);
/*     */     
/* 540 */     return stringBuilder.toString();
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
/*     */   public static String sha512Crypt(byte[] paramArrayOfbyte) {
/* 560 */     return sha512Crypt(paramArrayOfbyte, null);
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
/*     */   public static String sha512Crypt(byte[] paramArrayOfbyte, String paramString) {
/* 582 */     if (paramString == null) {
/* 583 */       paramString = "$6$" + B64.getRandomSalt(8);
/*     */     }
/* 585 */     return sha2Crypt(paramArrayOfbyte, paramString, "$6$", 64, "SHA-512");
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
/*     */   public static String sha512Crypt(byte[] paramArrayOfbyte, String paramString, Random paramRandom) {
/* 612 */     if (paramString == null) {
/* 613 */       paramString = "$6$" + B64.getRandomSalt(8, paramRandom);
/*     */     }
/* 615 */     return sha2Crypt(paramArrayOfbyte, paramString, "$6$", 64, "SHA-512");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\digest\Sha2Crypt.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */