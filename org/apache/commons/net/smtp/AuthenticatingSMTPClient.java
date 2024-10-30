/*     */ package org.apache.commons.net.smtp;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.net.InetAddress;
/*     */ import java.security.InvalidKeyException;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.security.spec.InvalidKeySpecException;
/*     */ import javax.crypto.Mac;
/*     */ import javax.crypto.spec.SecretKeySpec;
/*     */ import javax.net.ssl.SSLContext;
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
/*     */ public class AuthenticatingSMTPClient
/*     */   extends SMTPSClient
/*     */ {
/*     */   public AuthenticatingSMTPClient() {}
/*     */   
/*     */   public AuthenticatingSMTPClient(String paramString) {
/*  54 */     super(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AuthenticatingSMTPClient(String paramString, boolean paramBoolean) {
/*  65 */     super(paramString, paramBoolean);
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
/*     */   public AuthenticatingSMTPClient(String paramString1, boolean paramBoolean, String paramString2) {
/*  77 */     super(paramString1, paramBoolean, paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AuthenticatingSMTPClient(boolean paramBoolean, SSLContext paramSSLContext) {
/*  88 */     super(paramBoolean, paramSSLContext);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AuthenticatingSMTPClient(String paramString1, String paramString2) {
/*  98 */     super(paramString1, false, paramString2);
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
/*     */   public int ehlo(String paramString) throws IOException {
/* 117 */     return sendCommand(15, paramString);
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
/*     */   public boolean elogin(String paramString) throws IOException {
/* 137 */     return SMTPReply.isPositiveCompletion(ehlo(paramString));
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
/*     */   public boolean elogin() throws IOException {
/* 160 */     InetAddress inetAddress = getLocalAddress();
/* 161 */     String str = inetAddress.getHostName();
/*     */     
/* 163 */     if (str == null) {
/* 164 */       return false;
/*     */     }
/*     */     
/* 167 */     return SMTPReply.isPositiveCompletion(ehlo(str));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] getEnhancedReplyCode() {
/* 177 */     String str = getReplyString().substring(4);
/* 178 */     String[] arrayOfString = str.substring(0, str.indexOf(' ')).split("\\.");
/* 179 */     int[] arrayOfInt = new int[arrayOfString.length];
/* 180 */     for (byte b = 0; b < arrayOfString.length; b++)
/*     */     {
/* 182 */       arrayOfInt[b] = Integer.parseInt(arrayOfString[b]);
/*     */     }
/* 184 */     return arrayOfInt;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean auth(AUTH_METHOD paramAUTH_METHOD, String paramString1, String paramString2) throws IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException {
/* 218 */     if (!SMTPReply.isPositiveIntermediate(sendCommand(14, 
/* 219 */           AUTH_METHOD.getAuthName(paramAUTH_METHOD)))) {
/* 220 */       return false;
/*     */     }
/*     */     
/* 223 */     if (paramAUTH_METHOD.equals(AUTH_METHOD.PLAIN))
/*     */     {
/*     */       
/* 226 */       return SMTPReply.isPositiveCompletion(sendCommand(
/* 227 */             Base64.encodeBase64StringUnChunked(("\000" + paramString1 + "\000" + paramString2).getBytes(getCharset()))));
/*     */     }
/*     */     
/* 230 */     if (paramAUTH_METHOD.equals(AUTH_METHOD.CRAM_MD5)) {
/*     */ 
/*     */       
/* 233 */       byte[] arrayOfByte1 = Base64.decodeBase64(getReplyString().substring(4).trim());
/*     */       
/* 235 */       Mac mac = Mac.getInstance("HmacMD5");
/* 236 */       mac.init(new SecretKeySpec(paramString2.getBytes(getCharset()), "HmacMD5"));
/*     */       
/* 238 */       byte[] arrayOfByte2 = convertToHexString(mac.doFinal(arrayOfByte1)).getBytes(getCharset());
/*     */       
/* 240 */       byte[] arrayOfByte3 = paramString1.getBytes(getCharset());
/* 241 */       byte[] arrayOfByte4 = new byte[arrayOfByte3.length + 1 + arrayOfByte2.length];
/* 242 */       System.arraycopy(arrayOfByte3, 0, arrayOfByte4, 0, arrayOfByte3.length);
/* 243 */       arrayOfByte4[arrayOfByte3.length] = 32;
/* 244 */       System.arraycopy(arrayOfByte2, 0, arrayOfByte4, arrayOfByte3.length + 1, arrayOfByte2.length);
/*     */       
/* 246 */       return SMTPReply.isPositiveCompletion(sendCommand(
/* 247 */             Base64.encodeBase64StringUnChunked(arrayOfByte4)));
/*     */     } 
/* 249 */     if (paramAUTH_METHOD.equals(AUTH_METHOD.LOGIN)) {
/*     */ 
/*     */ 
/*     */       
/* 253 */       if (!SMTPReply.isPositiveIntermediate(sendCommand(
/* 254 */             Base64.encodeBase64StringUnChunked(paramString1.getBytes(getCharset()))))) {
/* 255 */         return false;
/*     */       }
/* 257 */       return SMTPReply.isPositiveCompletion(sendCommand(
/* 258 */             Base64.encodeBase64StringUnChunked(paramString2.getBytes(getCharset()))));
/*     */     } 
/* 260 */     if (paramAUTH_METHOD.equals(AUTH_METHOD.XOAUTH) || paramAUTH_METHOD.equals(AUTH_METHOD.XOAUTH2))
/*     */     {
/* 262 */       return SMTPReply.isPositiveIntermediate(sendCommand(
/* 263 */             Base64.encodeBase64StringUnChunked(paramString1.getBytes(getCharset()))));
/*     */     }
/*     */     
/* 266 */     return false;
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
/* 279 */     StringBuilder stringBuilder = new StringBuilder(paramArrayOfbyte.length * 2);
/* 280 */     for (byte b : paramArrayOfbyte) {
/*     */       
/* 282 */       if ((b & 0xFF) <= 15) {
/* 283 */         stringBuilder.append("0");
/*     */       }
/* 285 */       stringBuilder.append(Integer.toHexString(b & 0xFF));
/*     */     } 
/* 287 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum AUTH_METHOD
/*     */   {
/* 296 */     PLAIN,
/*     */     
/* 298 */     CRAM_MD5,
/*     */     
/* 300 */     LOGIN,
/*     */     
/* 302 */     XOAUTH,
/*     */     
/* 304 */     XOAUTH2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final String getAuthName(AUTH_METHOD param1AUTH_METHOD) {
/* 313 */       if (param1AUTH_METHOD.equals(PLAIN))
/* 314 */         return "PLAIN"; 
/* 315 */       if (param1AUTH_METHOD.equals(CRAM_MD5))
/* 316 */         return "CRAM-MD5"; 
/* 317 */       if (param1AUTH_METHOD.equals(LOGIN))
/* 318 */         return "LOGIN"; 
/* 319 */       if (param1AUTH_METHOD.equals(XOAUTH))
/* 320 */         return "XOAUTH"; 
/* 321 */       if (param1AUTH_METHOD.equals(XOAUTH2)) {
/* 322 */         return "XOAUTH2";
/*     */       }
/* 324 */       return null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\smtp\AuthenticatingSMTPClient.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */