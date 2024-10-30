/*      */ package org.apache.commons.codec.digest;
/*      */ 
/*      */ import java.io.BufferedInputStream;
/*      */ import java.io.File;
/*      */ import java.io.FileInputStream;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.RandomAccessFile;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.channels.FileChannel;
/*      */ import java.nio.file.Files;
/*      */ import java.nio.file.OpenOption;
/*      */ import java.nio.file.Path;
/*      */ import java.security.MessageDigest;
/*      */ import java.security.NoSuchAlgorithmException;
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
/*      */ 
/*      */ public class DigestUtils
/*      */ {
/*      */   private static final int STREAM_BUFFER_LENGTH = 1024;
/*      */   private final MessageDigest messageDigest;
/*      */   
/*      */   public static byte[] digest(MessageDigest paramMessageDigest, byte[] paramArrayOfbyte) {
/*   72 */     return paramMessageDigest.digest(paramArrayOfbyte);
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
/*      */   public static byte[] digest(MessageDigest paramMessageDigest, ByteBuffer paramByteBuffer) {
/*   87 */     paramMessageDigest.update(paramByteBuffer);
/*   88 */     return paramMessageDigest.digest();
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
/*      */   public static byte[] digest(MessageDigest paramMessageDigest, File paramFile) throws IOException {
/*  104 */     return updateDigest(paramMessageDigest, paramFile).digest();
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
/*      */   public static byte[] digest(MessageDigest paramMessageDigest, InputStream paramInputStream) throws IOException {
/*  120 */     return updateDigest(paramMessageDigest, paramInputStream).digest();
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
/*      */   public static byte[] digest(MessageDigest paramMessageDigest, Path paramPath, OpenOption... paramVarArgs) throws IOException {
/*  139 */     return updateDigest(paramMessageDigest, paramPath, paramVarArgs).digest();
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
/*      */   public static byte[] digest(MessageDigest paramMessageDigest, RandomAccessFile paramRandomAccessFile) throws IOException {
/*  152 */     return updateDigest(paramMessageDigest, paramRandomAccessFile).digest();
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
/*      */   public static MessageDigest getDigest(String paramString) {
/*      */     try {
/*  170 */       return MessageDigest.getInstance(paramString);
/*  171 */     } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
/*  172 */       throw new IllegalArgumentException(noSuchAlgorithmException);
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
/*      */ 
/*      */   
/*      */   public static MessageDigest getDigest(String paramString, MessageDigest paramMessageDigest) {
/*      */     try {
/*  195 */       return MessageDigest.getInstance(paramString);
/*  196 */     } catch (Exception exception) {
/*  197 */       return paramMessageDigest;
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
/*      */   public static MessageDigest getMd2Digest() {
/*  212 */     return getDigest("MD2");
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
/*      */   public static MessageDigest getMd5Digest() {
/*  225 */     return getDigest("MD5");
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
/*      */   public static MessageDigest getSha1Digest() {
/*  239 */     return getDigest("SHA-1");
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
/*      */   public static MessageDigest getSha256Digest() {
/*  252 */     return getDigest("SHA-256");
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
/*      */   public static MessageDigest getSha3_224Digest() {
/*  266 */     return getDigest("SHA3-224");
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
/*      */   public static MessageDigest getSha3_256Digest() {
/*  280 */     return getDigest("SHA3-256");
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
/*      */   public static MessageDigest getSha3_384Digest() {
/*  294 */     return getDigest("SHA3-384");
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
/*      */   public static MessageDigest getSha3_512Digest() {
/*  308 */     return getDigest("SHA3-512");
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
/*      */   public static MessageDigest getSha384Digest() {
/*  321 */     return getDigest("SHA-384");
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
/*      */   public static MessageDigest getSha512_224Digest() {
/*  333 */     return getDigest("SHA-512/224");
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
/*      */   public static MessageDigest getSha512_256Digest() {
/*  345 */     return getDigest("SHA-512/256");
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
/*      */   public static MessageDigest getSha512Digest() {
/*  358 */     return getDigest("SHA-512");
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
/*      */   @Deprecated
/*      */   public static MessageDigest getShaDigest() {
/*  371 */     return getSha1Digest();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isAvailable(String paramString) {
/*  381 */     return (getDigest(paramString, null) != null);
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
/*      */   public static byte[] md2(byte[] paramArrayOfbyte) {
/*  393 */     return getMd2Digest().digest(paramArrayOfbyte);
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
/*      */   public static byte[] md2(InputStream paramInputStream) throws IOException {
/*  407 */     return digest(getMd2Digest(), paramInputStream);
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
/*      */   public static byte[] md2(String paramString) {
/*  419 */     return md2(StringUtils.getBytesUtf8(paramString));
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
/*      */   public static String md2Hex(byte[] paramArrayOfbyte) {
/*  431 */     return Hex.encodeHexString(md2(paramArrayOfbyte));
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
/*      */   public static String md2Hex(InputStream paramInputStream) throws IOException {
/*  445 */     return Hex.encodeHexString(md2(paramInputStream));
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
/*      */   public static String md2Hex(String paramString) {
/*  457 */     return Hex.encodeHexString(md2(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] md5(byte[] paramArrayOfbyte) {
/*  468 */     return getMd5Digest().digest(paramArrayOfbyte);
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
/*      */   public static byte[] md5(InputStream paramInputStream) throws IOException {
/*  482 */     return digest(getMd5Digest(), paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] md5(String paramString) {
/*  493 */     return md5(StringUtils.getBytesUtf8(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String md5Hex(byte[] paramArrayOfbyte) {
/*  504 */     return Hex.encodeHexString(md5(paramArrayOfbyte));
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
/*      */   public static String md5Hex(InputStream paramInputStream) throws IOException {
/*  518 */     return Hex.encodeHexString(md5(paramInputStream));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String md5Hex(String paramString) {
/*  529 */     return Hex.encodeHexString(md5(paramString));
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
/*      */   @Deprecated
/*      */   public static byte[] sha(byte[] paramArrayOfbyte) {
/*  542 */     return sha1(paramArrayOfbyte);
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
/*      */   @Deprecated
/*      */   public static byte[] sha(InputStream paramInputStream) throws IOException {
/*  558 */     return sha1(paramInputStream);
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
/*      */   @Deprecated
/*      */   public static byte[] sha(String paramString) {
/*  571 */     return sha1(paramString);
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
/*      */   public static byte[] sha1(byte[] paramArrayOfbyte) {
/*  583 */     return getSha1Digest().digest(paramArrayOfbyte);
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
/*      */   public static byte[] sha1(InputStream paramInputStream) throws IOException {
/*  597 */     return digest(getSha1Digest(), paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] sha1(String paramString) {
/*  608 */     return sha1(StringUtils.getBytesUtf8(paramString));
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
/*      */   public static String sha1Hex(byte[] paramArrayOfbyte) {
/*  620 */     return Hex.encodeHexString(sha1(paramArrayOfbyte));
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
/*      */   public static String sha1Hex(InputStream paramInputStream) throws IOException {
/*  634 */     return Hex.encodeHexString(sha1(paramInputStream));
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
/*      */   public static String sha1Hex(String paramString) {
/*  646 */     return Hex.encodeHexString(sha1(paramString));
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
/*      */   public static byte[] sha256(byte[] paramArrayOfbyte) {
/*  658 */     return getSha256Digest().digest(paramArrayOfbyte);
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
/*      */   public static byte[] sha256(InputStream paramInputStream) throws IOException {
/*  672 */     return digest(getSha256Digest(), paramInputStream);
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
/*      */   public static byte[] sha256(String paramString) {
/*  684 */     return sha256(StringUtils.getBytesUtf8(paramString));
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
/*      */   public static String sha256Hex(byte[] paramArrayOfbyte) {
/*  696 */     return Hex.encodeHexString(sha256(paramArrayOfbyte));
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
/*      */   public static String sha256Hex(InputStream paramInputStream) throws IOException {
/*  710 */     return Hex.encodeHexString(sha256(paramInputStream));
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
/*      */   public static String sha256Hex(String paramString) {
/*  722 */     return Hex.encodeHexString(sha256(paramString));
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
/*      */   public static byte[] sha3_224(byte[] paramArrayOfbyte) {
/*  734 */     return getSha3_224Digest().digest(paramArrayOfbyte);
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
/*      */   public static byte[] sha3_224(InputStream paramInputStream) throws IOException {
/*  748 */     return digest(getSha3_224Digest(), paramInputStream);
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
/*      */   public static byte[] sha3_224(String paramString) {
/*  760 */     return sha3_224(StringUtils.getBytesUtf8(paramString));
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
/*      */   public static String sha3_224Hex(byte[] paramArrayOfbyte) {
/*  772 */     return Hex.encodeHexString(sha3_224(paramArrayOfbyte));
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
/*      */   public static String sha3_224Hex(InputStream paramInputStream) throws IOException {
/*  786 */     return Hex.encodeHexString(sha3_224(paramInputStream));
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
/*      */   public static String sha3_224Hex(String paramString) {
/*  798 */     return Hex.encodeHexString(sha3_224(paramString));
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
/*      */   public static byte[] sha3_256(byte[] paramArrayOfbyte) {
/*  810 */     return getSha3_256Digest().digest(paramArrayOfbyte);
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
/*      */   public static byte[] sha3_256(InputStream paramInputStream) throws IOException {
/*  824 */     return digest(getSha3_256Digest(), paramInputStream);
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
/*      */   public static byte[] sha3_256(String paramString) {
/*  836 */     return sha3_256(StringUtils.getBytesUtf8(paramString));
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
/*      */   public static String sha3_256Hex(byte[] paramArrayOfbyte) {
/*  848 */     return Hex.encodeHexString(sha3_256(paramArrayOfbyte));
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
/*      */   public static String sha3_256Hex(InputStream paramInputStream) throws IOException {
/*  862 */     return Hex.encodeHexString(sha3_256(paramInputStream));
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
/*      */   public static String sha3_256Hex(String paramString) {
/*  874 */     return Hex.encodeHexString(sha3_256(paramString));
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
/*      */   public static byte[] sha3_384(byte[] paramArrayOfbyte) {
/*  886 */     return getSha3_384Digest().digest(paramArrayOfbyte);
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
/*      */   public static byte[] sha3_384(InputStream paramInputStream) throws IOException {
/*  900 */     return digest(getSha3_384Digest(), paramInputStream);
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
/*      */   public static byte[] sha3_384(String paramString) {
/*  912 */     return sha3_384(StringUtils.getBytesUtf8(paramString));
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
/*      */   public static String sha3_384Hex(byte[] paramArrayOfbyte) {
/*  924 */     return Hex.encodeHexString(sha3_384(paramArrayOfbyte));
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
/*      */   public static String sha3_384Hex(InputStream paramInputStream) throws IOException {
/*  938 */     return Hex.encodeHexString(sha3_384(paramInputStream));
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
/*      */   public static String sha3_384Hex(String paramString) {
/*  950 */     return Hex.encodeHexString(sha3_384(paramString));
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
/*      */   public static byte[] sha3_512(byte[] paramArrayOfbyte) {
/*  962 */     return getSha3_512Digest().digest(paramArrayOfbyte);
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
/*      */   public static byte[] sha3_512(InputStream paramInputStream) throws IOException {
/*  976 */     return digest(getSha3_512Digest(), paramInputStream);
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
/*      */   public static byte[] sha3_512(String paramString) {
/*  988 */     return sha3_512(StringUtils.getBytesUtf8(paramString));
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
/*      */   public static String sha3_512Hex(byte[] paramArrayOfbyte) {
/* 1000 */     return Hex.encodeHexString(sha3_512(paramArrayOfbyte));
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
/*      */   public static String sha3_512Hex(InputStream paramInputStream) throws IOException {
/* 1014 */     return Hex.encodeHexString(sha3_512(paramInputStream));
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
/*      */   public static String sha3_512Hex(String paramString) {
/* 1026 */     return Hex.encodeHexString(sha3_512(paramString));
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
/*      */   public static byte[] sha384(byte[] paramArrayOfbyte) {
/* 1038 */     return getSha384Digest().digest(paramArrayOfbyte);
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
/*      */   public static byte[] sha384(InputStream paramInputStream) throws IOException {
/* 1052 */     return digest(getSha384Digest(), paramInputStream);
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
/*      */   public static byte[] sha384(String paramString) {
/* 1064 */     return sha384(StringUtils.getBytesUtf8(paramString));
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
/*      */   public static String sha384Hex(byte[] paramArrayOfbyte) {
/* 1076 */     return Hex.encodeHexString(sha384(paramArrayOfbyte));
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
/*      */   public static String sha384Hex(InputStream paramInputStream) throws IOException {
/* 1090 */     return Hex.encodeHexString(sha384(paramInputStream));
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
/*      */   public static String sha384Hex(String paramString) {
/* 1102 */     return Hex.encodeHexString(sha384(paramString));
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
/*      */   public static byte[] sha512(byte[] paramArrayOfbyte) {
/* 1114 */     return getSha512Digest().digest(paramArrayOfbyte);
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
/*      */   public static byte[] sha512(InputStream paramInputStream) throws IOException {
/* 1128 */     return digest(getSha512Digest(), paramInputStream);
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
/*      */   public static byte[] sha512(String paramString) {
/* 1140 */     return sha512(StringUtils.getBytesUtf8(paramString));
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
/*      */   public static byte[] sha512_224(byte[] paramArrayOfbyte) {
/* 1152 */     return getSha512_224Digest().digest(paramArrayOfbyte);
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
/*      */   public static byte[] sha512_224(InputStream paramInputStream) throws IOException {
/* 1166 */     return digest(getSha512_224Digest(), paramInputStream);
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
/*      */   public static byte[] sha512_224(String paramString) {
/* 1178 */     return sha512_224(StringUtils.getBytesUtf8(paramString));
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
/*      */   public static String sha512_224Hex(byte[] paramArrayOfbyte) {
/* 1190 */     return Hex.encodeHexString(sha512_224(paramArrayOfbyte));
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
/*      */   public static String sha512_224Hex(InputStream paramInputStream) throws IOException {
/* 1204 */     return Hex.encodeHexString(sha512_224(paramInputStream));
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
/*      */   public static String sha512_224Hex(String paramString) {
/* 1216 */     return Hex.encodeHexString(sha512_224(paramString));
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
/*      */   public static byte[] sha512_256(byte[] paramArrayOfbyte) {
/* 1228 */     return getSha512_256Digest().digest(paramArrayOfbyte);
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
/*      */   public static byte[] sha512_256(InputStream paramInputStream) throws IOException {
/* 1242 */     return digest(getSha512_256Digest(), paramInputStream);
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
/*      */   public static byte[] sha512_256(String paramString) {
/* 1254 */     return sha512_256(StringUtils.getBytesUtf8(paramString));
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
/*      */   public static String sha512_256Hex(byte[] paramArrayOfbyte) {
/* 1266 */     return Hex.encodeHexString(sha512_256(paramArrayOfbyte));
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
/*      */   public static String sha512_256Hex(InputStream paramInputStream) throws IOException {
/* 1280 */     return Hex.encodeHexString(sha512_256(paramInputStream));
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
/*      */   public static String sha512_256Hex(String paramString) {
/* 1292 */     return Hex.encodeHexString(sha512_256(paramString));
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
/*      */   public static String sha512Hex(byte[] paramArrayOfbyte) {
/* 1304 */     return Hex.encodeHexString(sha512(paramArrayOfbyte));
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
/*      */   public static String sha512Hex(InputStream paramInputStream) throws IOException {
/* 1318 */     return Hex.encodeHexString(sha512(paramInputStream));
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
/*      */   public static String sha512Hex(String paramString) {
/* 1330 */     return Hex.encodeHexString(sha512(paramString));
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
/*      */   @Deprecated
/*      */   public static String shaHex(byte[] paramArrayOfbyte) {
/* 1343 */     return sha1Hex(paramArrayOfbyte);
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
/*      */   @Deprecated
/*      */   public static String shaHex(InputStream paramInputStream) throws IOException {
/* 1359 */     return sha1Hex(paramInputStream);
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
/*      */   @Deprecated
/*      */   public static String shaHex(String paramString) {
/* 1372 */     return sha1Hex(paramString);
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
/*      */   public static MessageDigest updateDigest(MessageDigest paramMessageDigest, byte[] paramArrayOfbyte) {
/* 1386 */     paramMessageDigest.update(paramArrayOfbyte);
/* 1387 */     return paramMessageDigest;
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
/*      */   public static MessageDigest updateDigest(MessageDigest paramMessageDigest, ByteBuffer paramByteBuffer) {
/* 1401 */     paramMessageDigest.update(paramByteBuffer);
/* 1402 */     return paramMessageDigest;
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
/*      */   public static MessageDigest updateDigest(MessageDigest paramMessageDigest, File paramFile) throws IOException {
/* 1418 */     try (BufferedInputStream null = new BufferedInputStream(new FileInputStream(paramFile))) {
/* 1419 */       return updateDigest(paramMessageDigest, bufferedInputStream);
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
/*      */   private static MessageDigest updateDigest(MessageDigest paramMessageDigest, FileChannel paramFileChannel) throws IOException {
/* 1435 */     ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
/* 1436 */     while (paramFileChannel.read(byteBuffer) > 0) {
/* 1437 */       byteBuffer.flip();
/* 1438 */       paramMessageDigest.update(byteBuffer);
/* 1439 */       byteBuffer.clear();
/*      */     } 
/* 1441 */     return paramMessageDigest;
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
/*      */   public static MessageDigest updateDigest(MessageDigest paramMessageDigest, InputStream paramInputStream) throws IOException {
/* 1458 */     byte[] arrayOfByte = new byte[1024];
/* 1459 */     int i = paramInputStream.read(arrayOfByte, 0, 1024);
/*      */     
/* 1461 */     while (i > -1) {
/* 1462 */       paramMessageDigest.update(arrayOfByte, 0, i);
/* 1463 */       i = paramInputStream.read(arrayOfByte, 0, 1024);
/*      */     } 
/*      */     
/* 1466 */     return paramMessageDigest;
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
/*      */   public static MessageDigest updateDigest(MessageDigest paramMessageDigest, Path paramPath, OpenOption... paramVarArgs) throws IOException {
/* 1485 */     try (BufferedInputStream null = new BufferedInputStream(Files.newInputStream(paramPath, paramVarArgs))) {
/* 1486 */       return updateDigest(paramMessageDigest, bufferedInputStream);
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
/*      */   public static MessageDigest updateDigest(MessageDigest paramMessageDigest, RandomAccessFile paramRandomAccessFile) throws IOException {
/* 1501 */     return updateDigest(paramMessageDigest, paramRandomAccessFile.getChannel());
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
/*      */   public static MessageDigest updateDigest(MessageDigest paramMessageDigest, String paramString) {
/* 1521 */     paramMessageDigest.update(StringUtils.getBytesUtf8(paramString));
/* 1522 */     return paramMessageDigest;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public DigestUtils() {
/* 1534 */     this.messageDigest = null;
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
/*      */   public DigestUtils(MessageDigest paramMessageDigest) {
/* 1547 */     this.messageDigest = paramMessageDigest;
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
/*      */   public DigestUtils(String paramString) {
/* 1563 */     this(getDigest(paramString));
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
/*      */   public byte[] digest(byte[] paramArrayOfbyte) {
/* 1575 */     return updateDigest(this.messageDigest, paramArrayOfbyte).digest();
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
/*      */   public byte[] digest(ByteBuffer paramByteBuffer) {
/* 1588 */     return updateDigest(this.messageDigest, paramByteBuffer).digest();
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
/*      */   public byte[] digest(File paramFile) throws IOException {
/* 1602 */     return updateDigest(this.messageDigest, paramFile).digest();
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
/*      */   public byte[] digest(InputStream paramInputStream) throws IOException {
/* 1616 */     return updateDigest(this.messageDigest, paramInputStream).digest();
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
/*      */   public byte[] digest(Path paramPath, OpenOption... paramVarArgs) throws IOException {
/* 1632 */     return updateDigest(this.messageDigest, paramPath, paramVarArgs).digest();
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
/*      */   public byte[] digest(String paramString) {
/* 1644 */     return updateDigest(this.messageDigest, paramString).digest();
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
/*      */   public String digestAsHex(byte[] paramArrayOfbyte) {
/* 1656 */     return Hex.encodeHexString(digest(paramArrayOfbyte));
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
/*      */   public String digestAsHex(ByteBuffer paramByteBuffer) {
/* 1669 */     return Hex.encodeHexString(digest(paramByteBuffer));
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
/*      */   public String digestAsHex(File paramFile) throws IOException {
/* 1683 */     return Hex.encodeHexString(digest(paramFile));
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
/*      */   public String digestAsHex(InputStream paramInputStream) throws IOException {
/* 1697 */     return Hex.encodeHexString(digest(paramInputStream));
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
/*      */   public String digestAsHex(Path paramPath, OpenOption... paramVarArgs) throws IOException {
/* 1713 */     return Hex.encodeHexString(digest(paramPath, paramVarArgs));
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
/*      */   public String digestAsHex(String paramString) {
/* 1725 */     return Hex.encodeHexString(digest(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MessageDigest getMessageDigest() {
/* 1734 */     return this.messageDigest;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\digest\DigestUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */