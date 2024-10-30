/*     */ package org.apache.commons.net.pop3;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.security.InvalidKeyException;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.security.spec.InvalidKeySpecException;
/*     */ import javax.crypto.Mac;
/*     */ import javax.crypto.spec.SecretKeySpec;
/*     */ import org.apache.commons.net.util.Base64;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ExtendedPOP3Client
/*     */   extends POP3SClient
/*     */ {
/*     */   public boolean auth(AUTH_METHOD paramAUTH_METHOD, String paramString1, String paramString2) throws IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException {
/*     */     byte[] arrayOfByte1;
/*     */     Mac mac;
/*     */     byte[] arrayOfByte2;
/*     */     byte[] arrayOfByte3;
/*     */     byte[] arrayOfByte4;
/*  70 */     if (sendCommand(13, paramAUTH_METHOD.getAuthName()) != 2)
/*     */     {
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     switch (paramAUTH_METHOD) {
/*     */       
/*     */       case PLAIN:
/*  78 */         return (sendCommand(new String(
/*     */               
/*  80 */               Base64.encodeBase64(("\000" + paramString1 + "\000" + paramString2).getBytes(getCharset())), 
/*  81 */               getCharset())) == 0);
/*     */ 
/*     */       
/*     */       case CRAM_MD5:
/*  85 */         arrayOfByte1 = Base64.decodeBase64(getReplyString().substring(2).trim());
/*     */         
/*  87 */         mac = Mac.getInstance("HmacMD5");
/*  88 */         mac.init(new SecretKeySpec(paramString2.getBytes(getCharset()), "HmacMD5"));
/*     */         
/*  90 */         arrayOfByte2 = convertToHexString(mac.doFinal(arrayOfByte1)).getBytes(getCharset());
/*     */         
/*  92 */         arrayOfByte3 = paramString1.getBytes(getCharset());
/*  93 */         arrayOfByte4 = new byte[arrayOfByte3.length + 1 + arrayOfByte2.length];
/*  94 */         System.arraycopy(arrayOfByte3, 0, arrayOfByte4, 0, arrayOfByte3.length);
/*  95 */         arrayOfByte4[arrayOfByte3.length] = 32;
/*  96 */         System.arraycopy(arrayOfByte2, 0, arrayOfByte4, arrayOfByte3.length + 1, arrayOfByte2.length);
/*     */         
/*  98 */         return (sendCommand(Base64.encodeBase64StringUnChunked(arrayOfByte4)) == 0);
/*     */     } 
/* 100 */     return false;
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
/*     */   private String convertToHexString(byte[] paramArrayOfbyte) {
/* 113 */     StringBuilder stringBuilder = new StringBuilder(paramArrayOfbyte.length * 2);
/* 114 */     for (byte b : paramArrayOfbyte) {
/*     */       
/* 116 */       if ((b & 0xFF) <= 15) {
/* 117 */         stringBuilder.append("0");
/*     */       }
/* 119 */       stringBuilder.append(Integer.toHexString(b & 0xFF));
/*     */     } 
/* 121 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum AUTH_METHOD
/*     */   {
/* 130 */     PLAIN("PLAIN"),
/*     */ 
/*     */     
/* 133 */     CRAM_MD5("CRAM-MD5");
/*     */     
/*     */     private final String methodName;
/*     */     
/*     */     AUTH_METHOD(String param1String1) {
/* 138 */       this.methodName = param1String1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final String getAuthName() {
/* 146 */       return this.methodName;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\pop3\ExtendedPOP3Client.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */