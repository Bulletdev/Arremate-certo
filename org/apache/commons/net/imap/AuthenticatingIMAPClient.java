/*     */ package org.apache.commons.net.imap;
/*     */ 
/*     */ import java.io.IOException;
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
/*     */ public class AuthenticatingIMAPClient
/*     */   extends IMAPSClient
/*     */ {
/*     */   public AuthenticatingIMAPClient() {
/*  43 */     this("TLS", false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AuthenticatingIMAPClient(boolean paramBoolean) {
/*  52 */     this("TLS", paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AuthenticatingIMAPClient(String paramString) {
/*  61 */     this(paramString, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AuthenticatingIMAPClient(String paramString, boolean paramBoolean) {
/*  71 */     this(paramString, paramBoolean, (SSLContext)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AuthenticatingIMAPClient(String paramString, boolean paramBoolean, SSLContext paramSSLContext) {
/*  82 */     super(paramString, paramBoolean, paramSSLContext);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AuthenticatingIMAPClient(boolean paramBoolean, SSLContext paramSSLContext) {
/*  92 */     this("TLS", paramBoolean, paramSSLContext);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AuthenticatingIMAPClient(SSLContext paramSSLContext) {
/* 101 */     this(false, paramSSLContext);
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
/*     */   public boolean authenticate(AUTH_METHOD paramAUTH_METHOD, String paramString1, String paramString2) throws IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException {
/* 126 */     return auth(paramAUTH_METHOD, paramString1, paramString2);
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
/*     */   public boolean auth(AUTH_METHOD paramAUTH_METHOD, String paramString1, String paramString2) throws IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException {
/*     */     int j;
/*     */     byte[] arrayOfByte1;
/*     */     int i;
/*     */     Mac mac;
/*     */     byte[] arrayOfByte2;
/*     */     byte[] arrayOfByte3;
/*     */     byte[] arrayOfByte4;
/*     */     int k;
/* 151 */     if (!IMAPReply.isContinuation(sendCommand(IMAPCommand.AUTHENTICATE, paramAUTH_METHOD.getAuthName())))
/*     */     {
/* 153 */       return false;
/*     */     }
/*     */     
/* 156 */     switch (paramAUTH_METHOD) {
/*     */ 
/*     */       
/*     */       case PLAIN:
/* 160 */         j = sendData(
/* 161 */             Base64.encodeBase64StringUnChunked(("\000" + paramString1 + "\000" + paramString2)
/* 162 */               .getBytes(getCharset())));
/* 163 */         if (j == 0)
/*     */         {
/* 165 */           setState(IMAP.IMAPState.AUTH_STATE);
/*     */         }
/* 167 */         return (j == 0);
/*     */ 
/*     */ 
/*     */       
/*     */       case CRAM_MD5:
/* 172 */         arrayOfByte1 = Base64.decodeBase64(getReplyString().substring(2).trim());
/*     */         
/* 174 */         mac = Mac.getInstance("HmacMD5");
/* 175 */         mac.init(new SecretKeySpec(paramString2.getBytes(getCharset()), "HmacMD5"));
/*     */         
/* 177 */         arrayOfByte2 = convertToHexString(mac.doFinal(arrayOfByte1)).getBytes(getCharset());
/*     */         
/* 179 */         arrayOfByte3 = paramString1.getBytes(getCharset());
/* 180 */         arrayOfByte4 = new byte[arrayOfByte3.length + 1 + arrayOfByte2.length];
/* 181 */         System.arraycopy(arrayOfByte3, 0, arrayOfByte4, 0, arrayOfByte3.length);
/* 182 */         arrayOfByte4[arrayOfByte3.length] = 32;
/* 183 */         System.arraycopy(arrayOfByte2, 0, arrayOfByte4, arrayOfByte3.length + 1, arrayOfByte2.length);
/*     */         
/* 185 */         k = sendData(Base64.encodeBase64StringUnChunked(arrayOfByte4));
/* 186 */         if (k == 0)
/*     */         {
/* 188 */           setState(IMAP.IMAPState.AUTH_STATE);
/*     */         }
/* 190 */         return (k == 0);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case LOGIN:
/* 196 */         if (sendData(Base64.encodeBase64StringUnChunked(paramString1.getBytes(getCharset()))) != 3)
/*     */         {
/* 198 */           return false;
/*     */         }
/* 200 */         i = sendData(Base64.encodeBase64StringUnChunked(paramString2.getBytes(getCharset())));
/* 201 */         if (i == 0)
/*     */         {
/* 203 */           setState(IMAP.IMAPState.AUTH_STATE);
/*     */         }
/* 205 */         return (i == 0);
/*     */ 
/*     */       
/*     */       case XOAUTH:
/*     */       case XOAUTH2:
/* 210 */         i = sendData(paramString1);
/* 211 */         if (i == 0)
/*     */         {
/* 213 */           setState(IMAP.IMAPState.AUTH_STATE);
/*     */         }
/* 215 */         return (i == 0);
/*     */     } 
/*     */     
/* 218 */     return false;
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
/*     */   private String convertToHexString(byte[] paramArrayOfbyte) {
/* 230 */     StringBuilder stringBuilder = new StringBuilder(paramArrayOfbyte.length * 2);
/* 231 */     for (byte b : paramArrayOfbyte) {
/*     */       
/* 233 */       if ((b & 0xFF) <= 15) {
/* 234 */         stringBuilder.append("0");
/*     */       }
/* 236 */       stringBuilder.append(Integer.toHexString(b & 0xFF));
/*     */     } 
/* 238 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum AUTH_METHOD
/*     */   {
/* 247 */     PLAIN("PLAIN"),
/*     */     
/* 249 */     CRAM_MD5("CRAM-MD5"),
/*     */     
/* 251 */     LOGIN("LOGIN"),
/*     */     
/* 253 */     XOAUTH("XOAUTH"),
/*     */     
/* 255 */     XOAUTH2("XOAUTH2");
/*     */     
/*     */     private final String authName;
/*     */     
/*     */     AUTH_METHOD(String param1String1) {
/* 260 */       this.authName = param1String1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final String getAuthName() {
/* 268 */       return this.authName;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\imap\AuthenticatingIMAPClient.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */