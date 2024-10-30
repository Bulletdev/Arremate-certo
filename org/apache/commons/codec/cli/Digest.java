/*     */ package org.apache.commons.codec.cli;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.nio.charset.Charset;
/*     */ import java.security.MessageDigest;
/*     */ import java.util.Arrays;
/*     */ import java.util.Locale;
/*     */ import org.apache.commons.codec.binary.Hex;
/*     */ import org.apache.commons.codec.digest.DigestUtils;
/*     */ import org.apache.commons.codec.digest.MessageDigestAlgorithms;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Digest
/*     */ {
/*     */   private final String algorithm;
/*     */   private final String[] args;
/*     */   private final String[] inputs;
/*     */   
/*     */   public static void main(String[] paramArrayOfString) throws IOException {
/*  53 */     (new Digest(paramArrayOfString)).run();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Digest(String[] paramArrayOfString) {
/*  61 */     if (paramArrayOfString == null) {
/*  62 */       throw new IllegalArgumentException("args");
/*     */     }
/*  64 */     if (paramArrayOfString.length == 0) {
/*  65 */       throw new IllegalArgumentException(
/*  66 */           String.format("Usage: java %s [algorithm] [FILE|DIRECTORY|string] ...", new Object[] { Digest.class.getName() }));
/*     */     }
/*  68 */     this.args = paramArrayOfString;
/*  69 */     this.algorithm = paramArrayOfString[0];
/*  70 */     if (paramArrayOfString.length <= 1) {
/*  71 */       this.inputs = null;
/*     */     } else {
/*  73 */       this.inputs = new String[paramArrayOfString.length - 1];
/*  74 */       System.arraycopy(paramArrayOfString, 1, this.inputs, 0, this.inputs.length);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void println(String paramString, byte[] paramArrayOfbyte) {
/*  79 */     println(paramString, paramArrayOfbyte, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void println(String paramString1, byte[] paramArrayOfbyte, String paramString2) {
/*  88 */     System.out.println(paramString1 + Hex.encodeHexString(paramArrayOfbyte) + ((paramString2 != null) ? ("  " + paramString2) : ""));
/*     */   }
/*     */   
/*     */   private void run() throws IOException {
/*  92 */     if (this.algorithm.equalsIgnoreCase("ALL") || this.algorithm.equals("*")) {
/*  93 */       run(MessageDigestAlgorithms.values());
/*     */       return;
/*     */     } 
/*  96 */     MessageDigest messageDigest = DigestUtils.getDigest(this.algorithm, null);
/*  97 */     if (messageDigest != null) {
/*  98 */       run("", messageDigest);
/*     */     } else {
/* 100 */       run("", DigestUtils.getDigest(this.algorithm.toUpperCase(Locale.ROOT)));
/*     */     } 
/*     */   }
/*     */   
/*     */   private void run(String[] paramArrayOfString) throws IOException {
/* 105 */     for (String str : paramArrayOfString) {
/* 106 */       if (DigestUtils.isAvailable(str)) {
/* 107 */         run(str + " ", str);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void run(String paramString, MessageDigest paramMessageDigest) throws IOException {
/* 113 */     if (this.inputs == null) {
/* 114 */       println(paramString, DigestUtils.digest(paramMessageDigest, System.in));
/*     */       return;
/*     */     } 
/* 117 */     for (String str : this.inputs) {
/* 118 */       File file = new File(str);
/* 119 */       if (file.isFile()) {
/* 120 */         println(paramString, DigestUtils.digest(paramMessageDigest, file), str);
/* 121 */       } else if (file.isDirectory()) {
/* 122 */         File[] arrayOfFile = file.listFiles();
/* 123 */         if (arrayOfFile != null) {
/* 124 */           run(paramString, paramMessageDigest, arrayOfFile);
/*     */         }
/*     */       } else {
/*     */         
/* 128 */         byte[] arrayOfByte = str.getBytes(Charset.defaultCharset());
/* 129 */         println(paramString, DigestUtils.digest(paramMessageDigest, arrayOfByte));
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void run(String paramString, MessageDigest paramMessageDigest, File[] paramArrayOfFile) throws IOException {
/* 135 */     for (File file : paramArrayOfFile) {
/* 136 */       if (file.isFile()) {
/* 137 */         println(paramString, DigestUtils.digest(paramMessageDigest, file), file.getName());
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void run(String paramString1, String paramString2) throws IOException {
/* 143 */     run(paramString1, DigestUtils.getDigest(paramString2));
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 148 */     return String.format("%s %s", new Object[] { super.toString(), Arrays.toString((Object[])this.args) });
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\cli\Digest.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */