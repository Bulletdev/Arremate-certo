/*      */ package org.apache.http.impl.auth;
/*      */ 
/*      */ import java.nio.charset.Charset;
/*      */ import java.security.Key;
/*      */ import java.security.MessageDigest;
/*      */ import java.security.NoSuchAlgorithmException;
/*      */ import java.security.SecureRandom;
/*      */ import java.security.cert.Certificate;
/*      */ import java.security.cert.CertificateEncodingException;
/*      */ import java.util.Arrays;
/*      */ import java.util.Locale;
/*      */ import java.util.Random;
/*      */ import javax.crypto.Cipher;
/*      */ import javax.crypto.spec.SecretKeySpec;
/*      */ import org.apache.commons.codec.binary.Base64;
/*      */ import org.apache.http.Consts;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ final class NTLMEngineImpl
/*      */   implements NTLMEngine
/*      */ {
/*   54 */   private static final Charset UNICODE_LITTLE_UNMARKED = Charset.forName("UnicodeLittleUnmarked");
/*      */   
/*   56 */   private static final Charset DEFAULT_CHARSET = Consts.ASCII;
/*      */   
/*      */   static final int FLAG_REQUEST_UNICODE_ENCODING = 1;
/*      */   
/*      */   static final int FLAG_REQUEST_OEM_ENCODING = 2;
/*      */   
/*      */   static final int FLAG_REQUEST_TARGET = 4;
/*      */   
/*      */   static final int FLAG_REQUEST_SIGN = 16;
/*      */   
/*      */   static final int FLAG_REQUEST_SEAL = 32;
/*      */   
/*      */   static final int FLAG_REQUEST_LAN_MANAGER_KEY = 128;
/*      */   
/*      */   static final int FLAG_REQUEST_NTLMv1 = 512;
/*      */   
/*      */   static final int FLAG_DOMAIN_PRESENT = 4096;
/*      */   
/*      */   static final int FLAG_WORKSTATION_PRESENT = 8192;
/*      */   
/*      */   static final int FLAG_REQUEST_ALWAYS_SIGN = 32768;
/*      */   
/*      */   static final int FLAG_REQUEST_NTLM2_SESSION = 524288;
/*      */   static final int FLAG_REQUEST_VERSION = 33554432;
/*      */   static final int FLAG_TARGETINFO_PRESENT = 8388608;
/*      */   static final int FLAG_REQUEST_128BIT_KEY_EXCH = 536870912;
/*      */   static final int FLAG_REQUEST_EXPLICIT_KEY_EXCH = 1073741824;
/*      */   static final int FLAG_REQUEST_56BIT_ENCRYPTION = -2147483648;
/*      */   static final int MSV_AV_EOL = 0;
/*      */   static final int MSV_AV_NB_COMPUTER_NAME = 1;
/*      */   static final int MSV_AV_NB_DOMAIN_NAME = 2;
/*      */   static final int MSV_AV_DNS_COMPUTER_NAME = 3;
/*      */   static final int MSV_AV_DNS_DOMAIN_NAME = 4;
/*      */   static final int MSV_AV_DNS_TREE_NAME = 5;
/*      */   static final int MSV_AV_FLAGS = 6;
/*      */   static final int MSV_AV_TIMESTAMP = 7;
/*      */   static final int MSV_AV_SINGLE_HOST = 8;
/*      */   static final int MSV_AV_TARGET_NAME = 9;
/*      */   static final int MSV_AV_CHANNEL_BINDINGS = 10;
/*      */   static final int MSV_AV_FLAGS_ACCOUNT_AUTH_CONSTAINED = 1;
/*      */   static final int MSV_AV_FLAGS_MIC = 2;
/*      */   static final int MSV_AV_FLAGS_UNTRUSTED_TARGET_SPN = 4;
/*      */   private static final SecureRandom RND_GEN;
/*      */   
/*      */   static {
/*  101 */     SecureRandom secureRandom = null;
/*      */     try {
/*  103 */       secureRandom = SecureRandom.getInstance("SHA1PRNG");
/*  104 */     } catch (Exception exception) {}
/*      */     
/*  106 */     RND_GEN = secureRandom;
/*      */   }
/*      */ 
/*      */   
/*  110 */   private static final byte[] SIGNATURE = getNullTerminatedAsciiString("NTLMSSP");
/*      */ 
/*      */ 
/*      */   
/*  114 */   private static final byte[] SIGN_MAGIC_SERVER = getNullTerminatedAsciiString("session key to server-to-client signing key magic constant");
/*      */   
/*  116 */   private static final byte[] SIGN_MAGIC_CLIENT = getNullTerminatedAsciiString("session key to client-to-server signing key magic constant");
/*      */   
/*  118 */   private static final byte[] SEAL_MAGIC_SERVER = getNullTerminatedAsciiString("session key to server-to-client sealing key magic constant");
/*      */   
/*  120 */   private static final byte[] SEAL_MAGIC_CLIENT = getNullTerminatedAsciiString("session key to client-to-server sealing key magic constant");
/*      */ 
/*      */ 
/*      */   
/*  124 */   private static final byte[] MAGIC_TLS_SERVER_ENDPOINT = "tls-server-end-point:".getBytes(Consts.ASCII);
/*      */ 
/*      */   
/*      */   private static byte[] getNullTerminatedAsciiString(String paramString) {
/*  128 */     byte[] arrayOfByte1 = paramString.getBytes(Consts.ASCII);
/*  129 */     byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 1];
/*  130 */     System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
/*  131 */     arrayOfByte2[arrayOfByte1.length] = 0;
/*  132 */     return arrayOfByte2;
/*      */   }
/*      */   
/*  135 */   private static final String TYPE_1_MESSAGE = (new Type1Message()).getResponse();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static String getType1Message(String paramString1, String paramString2) {
/*  154 */     return TYPE_1_MESSAGE;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static String getType3Message(String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfbyte1, int paramInt, String paramString5, byte[] paramArrayOfbyte2) throws NTLMEngineException {
/*  181 */     return (new Type3Message(paramString4, paramString3, paramString1, paramString2, paramArrayOfbyte1, paramInt, paramString5, paramArrayOfbyte2)).getResponse();
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static String getType3Message(String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfbyte1, int paramInt, String paramString5, byte[] paramArrayOfbyte2, Certificate paramCertificate, byte[] paramArrayOfbyte3, byte[] paramArrayOfbyte4) throws NTLMEngineException {
/*  210 */     return (new Type3Message(paramString4, paramString3, paramString1, paramString2, paramArrayOfbyte1, paramInt, paramString5, paramArrayOfbyte2, paramCertificate, paramArrayOfbyte3, paramArrayOfbyte4)).getResponse();
/*      */   }
/*      */ 
/*      */   
/*      */   private static int readULong(byte[] paramArrayOfbyte, int paramInt) {
/*  215 */     if (paramArrayOfbyte.length < paramInt + 4) {
/*  216 */       return 0;
/*      */     }
/*  218 */     return paramArrayOfbyte[paramInt] & 0xFF | (paramArrayOfbyte[paramInt + 1] & 0xFF) << 8 | (paramArrayOfbyte[paramInt + 2] & 0xFF) << 16 | (paramArrayOfbyte[paramInt + 3] & 0xFF) << 24;
/*      */   }
/*      */ 
/*      */   
/*      */   private static int readUShort(byte[] paramArrayOfbyte, int paramInt) {
/*  223 */     if (paramArrayOfbyte.length < paramInt + 2) {
/*  224 */       return 0;
/*      */     }
/*  226 */     return paramArrayOfbyte[paramInt] & 0xFF | (paramArrayOfbyte[paramInt + 1] & 0xFF) << 8;
/*      */   }
/*      */   
/*      */   private static byte[] readSecurityBuffer(byte[] paramArrayOfbyte, int paramInt) {
/*  230 */     int i = readUShort(paramArrayOfbyte, paramInt);
/*  231 */     int j = readULong(paramArrayOfbyte, paramInt + 4);
/*  232 */     if (paramArrayOfbyte.length < j + i) {
/*  233 */       return new byte[i];
/*      */     }
/*  235 */     byte[] arrayOfByte = new byte[i];
/*  236 */     System.arraycopy(paramArrayOfbyte, j, arrayOfByte, 0, i);
/*  237 */     return arrayOfByte;
/*      */   }
/*      */ 
/*      */   
/*      */   private static byte[] makeRandomChallenge(Random paramRandom) {
/*  242 */     byte[] arrayOfByte = new byte[8];
/*  243 */     synchronized (paramRandom) {
/*  244 */       paramRandom.nextBytes(arrayOfByte);
/*      */     } 
/*  246 */     return arrayOfByte;
/*      */   }
/*      */ 
/*      */   
/*      */   private static byte[] makeSecondaryKey(Random paramRandom) {
/*  251 */     byte[] arrayOfByte = new byte[16];
/*  252 */     synchronized (paramRandom) {
/*  253 */       paramRandom.nextBytes(arrayOfByte);
/*      */     } 
/*  255 */     return arrayOfByte;
/*      */   }
/*      */ 
/*      */   
/*      */   protected static class CipherGen
/*      */   {
/*      */     protected final Random random;
/*      */     
/*      */     protected final long currentTime;
/*      */     
/*      */     protected final String domain;
/*      */     
/*      */     protected final String user;
/*      */     
/*      */     protected final String password;
/*      */     protected final byte[] challenge;
/*      */     protected final String target;
/*      */     protected final byte[] targetInformation;
/*      */     protected byte[] clientChallenge;
/*      */     protected byte[] clientChallenge2;
/*      */     protected byte[] secondaryKey;
/*      */     protected byte[] timestamp;
/*  277 */     protected byte[] lmHash = null;
/*  278 */     protected byte[] lmResponse = null;
/*  279 */     protected byte[] ntlmHash = null;
/*  280 */     protected byte[] ntlmResponse = null;
/*  281 */     protected byte[] ntlmv2Hash = null;
/*  282 */     protected byte[] lmv2Hash = null;
/*  283 */     protected byte[] lmv2Response = null;
/*  284 */     protected byte[] ntlmv2Blob = null;
/*  285 */     protected byte[] ntlmv2Response = null;
/*  286 */     protected byte[] ntlm2SessionResponse = null;
/*  287 */     protected byte[] lm2SessionResponse = null;
/*  288 */     protected byte[] lmUserSessionKey = null;
/*  289 */     protected byte[] ntlmUserSessionKey = null;
/*  290 */     protected byte[] ntlmv2UserSessionKey = null;
/*  291 */     protected byte[] ntlm2SessionResponseUserSessionKey = null;
/*  292 */     protected byte[] lanManagerSessionKey = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Deprecated
/*      */     public CipherGen(String param1String1, String param1String2, String param1String3, byte[] param1ArrayOfbyte1, String param1String4, byte[] param1ArrayOfbyte2, byte[] param1ArrayOfbyte3, byte[] param1ArrayOfbyte4, byte[] param1ArrayOfbyte5, byte[] param1ArrayOfbyte6) {
/*  302 */       this(NTLMEngineImpl.RND_GEN, System.currentTimeMillis(), param1String1, param1String2, param1String3, param1ArrayOfbyte1, param1String4, param1ArrayOfbyte2, param1ArrayOfbyte3, param1ArrayOfbyte4, param1ArrayOfbyte5, param1ArrayOfbyte6);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public CipherGen(Random param1Random, long param1Long, String param1String1, String param1String2, String param1String3, byte[] param1ArrayOfbyte1, String param1String4, byte[] param1ArrayOfbyte2, byte[] param1ArrayOfbyte3, byte[] param1ArrayOfbyte4, byte[] param1ArrayOfbyte5, byte[] param1ArrayOfbyte6) {
/*  313 */       this.random = param1Random;
/*  314 */       this.currentTime = param1Long;
/*      */       
/*  316 */       this.domain = param1String1;
/*  317 */       this.target = param1String4;
/*  318 */       this.user = param1String2;
/*  319 */       this.password = param1String3;
/*  320 */       this.challenge = param1ArrayOfbyte1;
/*  321 */       this.targetInformation = param1ArrayOfbyte2;
/*  322 */       this.clientChallenge = param1ArrayOfbyte3;
/*  323 */       this.clientChallenge2 = param1ArrayOfbyte4;
/*  324 */       this.secondaryKey = param1ArrayOfbyte5;
/*  325 */       this.timestamp = param1ArrayOfbyte6;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Deprecated
/*      */     public CipherGen(String param1String1, String param1String2, String param1String3, byte[] param1ArrayOfbyte1, String param1String4, byte[] param1ArrayOfbyte2) {
/*  338 */       this(NTLMEngineImpl.RND_GEN, System.currentTimeMillis(), param1String1, param1String2, param1String3, param1ArrayOfbyte1, param1String4, param1ArrayOfbyte2);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public CipherGen(Random param1Random, long param1Long, String param1String1, String param1String2, String param1String3, byte[] param1ArrayOfbyte1, String param1String4, byte[] param1ArrayOfbyte2) {
/*  348 */       this(param1Random, param1Long, param1String1, param1String2, param1String3, param1ArrayOfbyte1, param1String4, param1ArrayOfbyte2, null, null, null, null);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public byte[] getClientChallenge() throws NTLMEngineException {
/*  354 */       if (this.clientChallenge == null) {
/*  355 */         this.clientChallenge = NTLMEngineImpl.makeRandomChallenge(this.random);
/*      */       }
/*  357 */       return this.clientChallenge;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public byte[] getClientChallenge2() throws NTLMEngineException {
/*  363 */       if (this.clientChallenge2 == null) {
/*  364 */         this.clientChallenge2 = NTLMEngineImpl.makeRandomChallenge(this.random);
/*      */       }
/*  366 */       return this.clientChallenge2;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public byte[] getSecondaryKey() throws NTLMEngineException {
/*  372 */       if (this.secondaryKey == null) {
/*  373 */         this.secondaryKey = NTLMEngineImpl.makeSecondaryKey(this.random);
/*      */       }
/*  375 */       return this.secondaryKey;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public byte[] getLMHash() throws NTLMEngineException {
/*  381 */       if (this.lmHash == null) {
/*  382 */         this.lmHash = NTLMEngineImpl.lmHash(this.password);
/*      */       }
/*  384 */       return this.lmHash;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public byte[] getLMResponse() throws NTLMEngineException {
/*  390 */       if (this.lmResponse == null) {
/*  391 */         this.lmResponse = NTLMEngineImpl.lmResponse(getLMHash(), this.challenge);
/*      */       }
/*  393 */       return this.lmResponse;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public byte[] getNTLMHash() throws NTLMEngineException {
/*  399 */       if (this.ntlmHash == null) {
/*  400 */         this.ntlmHash = NTLMEngineImpl.ntlmHash(this.password);
/*      */       }
/*  402 */       return this.ntlmHash;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public byte[] getNTLMResponse() throws NTLMEngineException {
/*  408 */       if (this.ntlmResponse == null) {
/*  409 */         this.ntlmResponse = NTLMEngineImpl.lmResponse(getNTLMHash(), this.challenge);
/*      */       }
/*  411 */       return this.ntlmResponse;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public byte[] getLMv2Hash() throws NTLMEngineException {
/*  417 */       if (this.lmv2Hash == null) {
/*  418 */         this.lmv2Hash = NTLMEngineImpl.lmv2Hash(this.domain, this.user, getNTLMHash());
/*      */       }
/*  420 */       return this.lmv2Hash;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public byte[] getNTLMv2Hash() throws NTLMEngineException {
/*  426 */       if (this.ntlmv2Hash == null) {
/*  427 */         this.ntlmv2Hash = NTLMEngineImpl.ntlmv2Hash(this.domain, this.user, getNTLMHash());
/*      */       }
/*  429 */       return this.ntlmv2Hash;
/*      */     }
/*      */ 
/*      */     
/*      */     public byte[] getTimestamp() {
/*  434 */       if (this.timestamp == null) {
/*  435 */         long l = this.currentTime;
/*  436 */         l += 11644473600000L;
/*  437 */         l *= 10000L;
/*      */         
/*  439 */         this.timestamp = new byte[8];
/*  440 */         for (byte b = 0; b < 8; b++) {
/*  441 */           this.timestamp[b] = (byte)(int)l;
/*  442 */           l >>>= 8L;
/*      */         } 
/*      */       } 
/*  445 */       return this.timestamp;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public byte[] getNTLMv2Blob() throws NTLMEngineException {
/*  451 */       if (this.ntlmv2Blob == null) {
/*  452 */         this.ntlmv2Blob = NTLMEngineImpl.createBlob(getClientChallenge2(), this.targetInformation, getTimestamp());
/*      */       }
/*  454 */       return this.ntlmv2Blob;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public byte[] getNTLMv2Response() throws NTLMEngineException {
/*  460 */       if (this.ntlmv2Response == null) {
/*  461 */         this.ntlmv2Response = NTLMEngineImpl.lmv2Response(getNTLMv2Hash(), this.challenge, getNTLMv2Blob());
/*      */       }
/*  463 */       return this.ntlmv2Response;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public byte[] getLMv2Response() throws NTLMEngineException {
/*  469 */       if (this.lmv2Response == null) {
/*  470 */         this.lmv2Response = NTLMEngineImpl.lmv2Response(getLMv2Hash(), this.challenge, getClientChallenge());
/*      */       }
/*  472 */       return this.lmv2Response;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public byte[] getNTLM2SessionResponse() throws NTLMEngineException {
/*  478 */       if (this.ntlm2SessionResponse == null) {
/*  479 */         this.ntlm2SessionResponse = NTLMEngineImpl.ntlm2SessionResponse(getNTLMHash(), this.challenge, getClientChallenge());
/*      */       }
/*  481 */       return this.ntlm2SessionResponse;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public byte[] getLM2SessionResponse() throws NTLMEngineException {
/*  487 */       if (this.lm2SessionResponse == null) {
/*  488 */         byte[] arrayOfByte = getClientChallenge();
/*  489 */         this.lm2SessionResponse = new byte[24];
/*  490 */         System.arraycopy(arrayOfByte, 0, this.lm2SessionResponse, 0, arrayOfByte.length);
/*  491 */         Arrays.fill(this.lm2SessionResponse, arrayOfByte.length, this.lm2SessionResponse.length, (byte)0);
/*      */       } 
/*  493 */       return this.lm2SessionResponse;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public byte[] getLMUserSessionKey() throws NTLMEngineException {
/*  499 */       if (this.lmUserSessionKey == null) {
/*  500 */         this.lmUserSessionKey = new byte[16];
/*  501 */         System.arraycopy(getLMHash(), 0, this.lmUserSessionKey, 0, 8);
/*  502 */         Arrays.fill(this.lmUserSessionKey, 8, 16, (byte)0);
/*      */       } 
/*  504 */       return this.lmUserSessionKey;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public byte[] getNTLMUserSessionKey() throws NTLMEngineException {
/*  510 */       if (this.ntlmUserSessionKey == null) {
/*  511 */         NTLMEngineImpl.MD4 mD4 = new NTLMEngineImpl.MD4();
/*  512 */         mD4.update(getNTLMHash());
/*  513 */         this.ntlmUserSessionKey = mD4.getOutput();
/*      */       } 
/*  515 */       return this.ntlmUserSessionKey;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public byte[] getNTLMv2UserSessionKey() throws NTLMEngineException {
/*  521 */       if (this.ntlmv2UserSessionKey == null) {
/*  522 */         byte[] arrayOfByte1 = getNTLMv2Hash();
/*  523 */         byte[] arrayOfByte2 = new byte[16];
/*  524 */         System.arraycopy(getNTLMv2Response(), 0, arrayOfByte2, 0, 16);
/*  525 */         this.ntlmv2UserSessionKey = NTLMEngineImpl.hmacMD5(arrayOfByte2, arrayOfByte1);
/*      */       } 
/*  527 */       return this.ntlmv2UserSessionKey;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public byte[] getNTLM2SessionResponseUserSessionKey() throws NTLMEngineException {
/*  533 */       if (this.ntlm2SessionResponseUserSessionKey == null) {
/*  534 */         byte[] arrayOfByte1 = getLM2SessionResponse();
/*  535 */         byte[] arrayOfByte2 = new byte[this.challenge.length + arrayOfByte1.length];
/*  536 */         System.arraycopy(this.challenge, 0, arrayOfByte2, 0, this.challenge.length);
/*  537 */         System.arraycopy(arrayOfByte1, 0, arrayOfByte2, this.challenge.length, arrayOfByte1.length);
/*  538 */         this.ntlm2SessionResponseUserSessionKey = NTLMEngineImpl.hmacMD5(arrayOfByte2, getNTLMUserSessionKey());
/*      */       } 
/*  540 */       return this.ntlm2SessionResponseUserSessionKey;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public byte[] getLanManagerSessionKey() throws NTLMEngineException {
/*  546 */       if (this.lanManagerSessionKey == null) {
/*      */         try {
/*  548 */           byte[] arrayOfByte1 = new byte[14];
/*  549 */           System.arraycopy(getLMHash(), 0, arrayOfByte1, 0, 8);
/*  550 */           Arrays.fill(arrayOfByte1, 8, arrayOfByte1.length, (byte)-67);
/*  551 */           Key key1 = NTLMEngineImpl.createDESKey(arrayOfByte1, 0);
/*  552 */           Key key2 = NTLMEngineImpl.createDESKey(arrayOfByte1, 7);
/*  553 */           byte[] arrayOfByte2 = new byte[8];
/*  554 */           System.arraycopy(getLMResponse(), 0, arrayOfByte2, 0, arrayOfByte2.length);
/*  555 */           Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
/*  556 */           cipher.init(1, key1);
/*  557 */           byte[] arrayOfByte3 = cipher.doFinal(arrayOfByte2);
/*  558 */           cipher = Cipher.getInstance("DES/ECB/NoPadding");
/*  559 */           cipher.init(1, key2);
/*  560 */           byte[] arrayOfByte4 = cipher.doFinal(arrayOfByte2);
/*  561 */           this.lanManagerSessionKey = new byte[16];
/*  562 */           System.arraycopy(arrayOfByte3, 0, this.lanManagerSessionKey, 0, arrayOfByte3.length);
/*  563 */           System.arraycopy(arrayOfByte4, 0, this.lanManagerSessionKey, arrayOfByte3.length, arrayOfByte4.length);
/*  564 */         } catch (Exception exception) {
/*  565 */           throw new NTLMEngineException(exception.getMessage(), exception);
/*      */         } 
/*      */       }
/*  568 */       return this.lanManagerSessionKey;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static byte[] hmacMD5(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) throws NTLMEngineException {
/*  575 */     HMACMD5 hMACMD5 = new HMACMD5(paramArrayOfbyte2);
/*  576 */     hMACMD5.update(paramArrayOfbyte1);
/*  577 */     return hMACMD5.getOutput();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static byte[] RC4(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) throws NTLMEngineException {
/*      */     try {
/*  584 */       Cipher cipher = Cipher.getInstance("RC4");
/*  585 */       cipher.init(1, new SecretKeySpec(paramArrayOfbyte2, "RC4"));
/*  586 */       return cipher.doFinal(paramArrayOfbyte1);
/*  587 */     } catch (Exception exception) {
/*  588 */       throw new NTLMEngineException(exception.getMessage(), exception);
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
/*      */   static byte[] ntlm2SessionResponse(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, byte[] paramArrayOfbyte3) throws NTLMEngineException {
/*      */     try {
/*  603 */       MessageDigest messageDigest = getMD5();
/*  604 */       messageDigest.update(paramArrayOfbyte2);
/*  605 */       messageDigest.update(paramArrayOfbyte3);
/*  606 */       byte[] arrayOfByte1 = messageDigest.digest();
/*      */       
/*  608 */       byte[] arrayOfByte2 = new byte[8];
/*  609 */       System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, 8);
/*  610 */       return lmResponse(paramArrayOfbyte1, arrayOfByte2);
/*  611 */     } catch (Exception exception) {
/*  612 */       if (exception instanceof NTLMEngineException) {
/*  613 */         throw (NTLMEngineException)exception;
/*      */       }
/*  615 */       throw new NTLMEngineException(exception.getMessage(), exception);
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
/*      */   private static byte[] lmHash(String paramString) throws NTLMEngineException {
/*      */     try {
/*  630 */       byte[] arrayOfByte1 = paramString.toUpperCase(Locale.ROOT).getBytes(Consts.ASCII);
/*  631 */       int i = Math.min(arrayOfByte1.length, 14);
/*  632 */       byte[] arrayOfByte2 = new byte[14];
/*  633 */       System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
/*  634 */       Key key1 = createDESKey(arrayOfByte2, 0);
/*  635 */       Key key2 = createDESKey(arrayOfByte2, 7);
/*  636 */       byte[] arrayOfByte3 = "KGS!@#$%".getBytes(Consts.ASCII);
/*  637 */       Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
/*  638 */       cipher.init(1, key1);
/*  639 */       byte[] arrayOfByte4 = cipher.doFinal(arrayOfByte3);
/*  640 */       cipher.init(1, key2);
/*  641 */       byte[] arrayOfByte5 = cipher.doFinal(arrayOfByte3);
/*  642 */       byte[] arrayOfByte6 = new byte[16];
/*  643 */       System.arraycopy(arrayOfByte4, 0, arrayOfByte6, 0, 8);
/*  644 */       System.arraycopy(arrayOfByte5, 0, arrayOfByte6, 8, 8);
/*  645 */       return arrayOfByte6;
/*  646 */     } catch (Exception exception) {
/*  647 */       throw new NTLMEngineException(exception.getMessage(), exception);
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
/*      */   private static byte[] ntlmHash(String paramString) throws NTLMEngineException {
/*  661 */     if (UNICODE_LITTLE_UNMARKED == null) {
/*  662 */       throw new NTLMEngineException("Unicode not supported");
/*      */     }
/*  664 */     byte[] arrayOfByte = paramString.getBytes(UNICODE_LITTLE_UNMARKED);
/*  665 */     MD4 mD4 = new MD4();
/*  666 */     mD4.update(arrayOfByte);
/*  667 */     return mD4.getOutput();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static byte[] lmv2Hash(String paramString1, String paramString2, byte[] paramArrayOfbyte) throws NTLMEngineException {
/*  678 */     if (UNICODE_LITTLE_UNMARKED == null) {
/*  679 */       throw new NTLMEngineException("Unicode not supported");
/*      */     }
/*  681 */     HMACMD5 hMACMD5 = new HMACMD5(paramArrayOfbyte);
/*      */     
/*  683 */     hMACMD5.update(paramString2.toUpperCase(Locale.ROOT).getBytes(UNICODE_LITTLE_UNMARKED));
/*  684 */     if (paramString1 != null) {
/*  685 */       hMACMD5.update(paramString1.toUpperCase(Locale.ROOT).getBytes(UNICODE_LITTLE_UNMARKED));
/*      */     }
/*  687 */     return hMACMD5.getOutput();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static byte[] ntlmv2Hash(String paramString1, String paramString2, byte[] paramArrayOfbyte) throws NTLMEngineException {
/*  698 */     if (UNICODE_LITTLE_UNMARKED == null) {
/*  699 */       throw new NTLMEngineException("Unicode not supported");
/*      */     }
/*  701 */     HMACMD5 hMACMD5 = new HMACMD5(paramArrayOfbyte);
/*      */     
/*  703 */     hMACMD5.update(paramString2.toUpperCase(Locale.ROOT).getBytes(UNICODE_LITTLE_UNMARKED));
/*  704 */     if (paramString1 != null) {
/*  705 */       hMACMD5.update(paramString1.getBytes(UNICODE_LITTLE_UNMARKED));
/*      */     }
/*  707 */     return hMACMD5.getOutput();
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
/*      */   private static byte[] lmResponse(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) throws NTLMEngineException {
/*      */     try {
/*  722 */       byte[] arrayOfByte1 = new byte[21];
/*  723 */       System.arraycopy(paramArrayOfbyte1, 0, arrayOfByte1, 0, 16);
/*  724 */       Key key1 = createDESKey(arrayOfByte1, 0);
/*  725 */       Key key2 = createDESKey(arrayOfByte1, 7);
/*  726 */       Key key3 = createDESKey(arrayOfByte1, 14);
/*  727 */       Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
/*  728 */       cipher.init(1, key1);
/*  729 */       byte[] arrayOfByte2 = cipher.doFinal(paramArrayOfbyte2);
/*  730 */       cipher.init(1, key2);
/*  731 */       byte[] arrayOfByte3 = cipher.doFinal(paramArrayOfbyte2);
/*  732 */       cipher.init(1, key3);
/*  733 */       byte[] arrayOfByte4 = cipher.doFinal(paramArrayOfbyte2);
/*  734 */       byte[] arrayOfByte5 = new byte[24];
/*  735 */       System.arraycopy(arrayOfByte2, 0, arrayOfByte5, 0, 8);
/*  736 */       System.arraycopy(arrayOfByte3, 0, arrayOfByte5, 8, 8);
/*  737 */       System.arraycopy(arrayOfByte4, 0, arrayOfByte5, 16, 8);
/*  738 */       return arrayOfByte5;
/*  739 */     } catch (Exception exception) {
/*  740 */       throw new NTLMEngineException(exception.getMessage(), exception);
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
/*      */   private static byte[] lmv2Response(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, byte[] paramArrayOfbyte3) {
/*  759 */     HMACMD5 hMACMD5 = new HMACMD5(paramArrayOfbyte1);
/*  760 */     hMACMD5.update(paramArrayOfbyte2);
/*  761 */     hMACMD5.update(paramArrayOfbyte3);
/*  762 */     byte[] arrayOfByte1 = hMACMD5.getOutput();
/*  763 */     byte[] arrayOfByte2 = new byte[arrayOfByte1.length + paramArrayOfbyte3.length];
/*  764 */     System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
/*  765 */     System.arraycopy(paramArrayOfbyte3, 0, arrayOfByte2, arrayOfByte1.length, paramArrayOfbyte3.length);
/*  766 */     return arrayOfByte2;
/*      */   }
/*      */   
/*      */   enum Mode
/*      */   {
/*  771 */     CLIENT, SERVER;
/*      */   }
/*      */   
/*      */   static class Handle
/*      */   {
/*      */     private final byte[] exportedSessionKey;
/*      */     private byte[] signingKey;
/*      */     private byte[] sealingKey;
/*      */     private final Cipher rc4;
/*      */     final NTLMEngineImpl.Mode mode;
/*      */     private final boolean isConnection;
/*  782 */     int sequenceNumber = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Handle(byte[] param1ArrayOfbyte, NTLMEngineImpl.Mode param1Mode, boolean param1Boolean) throws NTLMEngineException {
/*  788 */       this.exportedSessionKey = param1ArrayOfbyte;
/*  789 */       this.isConnection = param1Boolean;
/*  790 */       this.mode = param1Mode;
/*      */       
/*      */       try {
/*  793 */         MessageDigest messageDigest1 = NTLMEngineImpl.getMD5();
/*  794 */         MessageDigest messageDigest2 = NTLMEngineImpl.getMD5();
/*  795 */         messageDigest1.update(param1ArrayOfbyte);
/*  796 */         messageDigest2.update(param1ArrayOfbyte);
/*  797 */         if (param1Mode == NTLMEngineImpl.Mode.CLIENT) {
/*      */           
/*  799 */           messageDigest1.update(NTLMEngineImpl.SIGN_MAGIC_CLIENT);
/*  800 */           messageDigest2.update(NTLMEngineImpl.SEAL_MAGIC_CLIENT);
/*      */         }
/*      */         else {
/*      */           
/*  804 */           messageDigest1.update(NTLMEngineImpl.SIGN_MAGIC_SERVER);
/*  805 */           messageDigest2.update(NTLMEngineImpl.SEAL_MAGIC_SERVER);
/*      */         } 
/*  807 */         this.signingKey = messageDigest1.digest();
/*  808 */         this.sealingKey = messageDigest2.digest();
/*      */       }
/*  810 */       catch (Exception exception) {
/*      */         
/*  812 */         throw new NTLMEngineException(exception.getMessage(), exception);
/*      */       } 
/*  814 */       this.rc4 = initCipher();
/*      */     }
/*      */ 
/*      */     
/*      */     public byte[] getSigningKey() {
/*  819 */       return this.signingKey;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public byte[] getSealingKey() {
/*  825 */       return this.sealingKey;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private Cipher initCipher() throws NTLMEngineException {
/*      */       Cipher cipher;
/*      */       try {
/*  833 */         cipher = Cipher.getInstance("RC4");
/*  834 */         if (this.mode == NTLMEngineImpl.Mode.CLIENT)
/*      */         {
/*  836 */           cipher.init(1, new SecretKeySpec(this.sealingKey, "RC4"));
/*      */         }
/*      */         else
/*      */         {
/*  840 */           cipher.init(2, new SecretKeySpec(this.sealingKey, "RC4"));
/*      */         }
/*      */       
/*  843 */       } catch (Exception exception) {
/*      */         
/*  845 */         throw new NTLMEngineException(exception.getMessage(), exception);
/*      */       } 
/*  847 */       return cipher;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private void advanceMessageSequence() throws NTLMEngineException {
/*  853 */       if (!this.isConnection) {
/*      */         
/*  855 */         MessageDigest messageDigest = NTLMEngineImpl.getMD5();
/*  856 */         messageDigest.update(this.sealingKey);
/*  857 */         byte[] arrayOfByte = new byte[4];
/*  858 */         NTLMEngineImpl.writeULong(arrayOfByte, this.sequenceNumber, 0);
/*  859 */         messageDigest.update(arrayOfByte);
/*  860 */         this.sealingKey = messageDigest.digest();
/*  861 */         initCipher();
/*      */       } 
/*  863 */       this.sequenceNumber++;
/*      */     }
/*      */ 
/*      */     
/*      */     private byte[] encrypt(byte[] param1ArrayOfbyte) {
/*  868 */       return this.rc4.update(param1ArrayOfbyte);
/*      */     }
/*      */ 
/*      */     
/*      */     private byte[] decrypt(byte[] param1ArrayOfbyte) {
/*  873 */       return this.rc4.update(param1ArrayOfbyte);
/*      */     }
/*      */ 
/*      */     
/*      */     private byte[] computeSignature(byte[] param1ArrayOfbyte) {
/*  878 */       byte[] arrayOfByte1 = new byte[16];
/*      */ 
/*      */       
/*  881 */       arrayOfByte1[0] = 1;
/*  882 */       arrayOfByte1[1] = 0;
/*  883 */       arrayOfByte1[2] = 0;
/*  884 */       arrayOfByte1[3] = 0;
/*      */ 
/*      */       
/*  887 */       NTLMEngineImpl.HMACMD5 hMACMD5 = new NTLMEngineImpl.HMACMD5(this.signingKey);
/*  888 */       hMACMD5.update(NTLMEngineImpl.encodeLong(this.sequenceNumber));
/*  889 */       hMACMD5.update(param1ArrayOfbyte);
/*  890 */       byte[] arrayOfByte2 = hMACMD5.getOutput();
/*  891 */       byte[] arrayOfByte3 = new byte[8];
/*  892 */       System.arraycopy(arrayOfByte2, 0, arrayOfByte3, 0, 8);
/*  893 */       byte[] arrayOfByte4 = encrypt(arrayOfByte3);
/*  894 */       System.arraycopy(arrayOfByte4, 0, arrayOfByte1, 4, 8);
/*      */ 
/*      */       
/*  897 */       NTLMEngineImpl.encodeLong(arrayOfByte1, 12, this.sequenceNumber);
/*      */       
/*  899 */       return arrayOfByte1;
/*      */     }
/*      */ 
/*      */     
/*      */     private boolean validateSignature(byte[] param1ArrayOfbyte1, byte[] param1ArrayOfbyte2) {
/*  904 */       byte[] arrayOfByte = computeSignature(param1ArrayOfbyte2);
/*      */ 
/*      */ 
/*      */       
/*  908 */       return Arrays.equals(param1ArrayOfbyte1, arrayOfByte);
/*      */     }
/*      */ 
/*      */     
/*      */     public byte[] signAndEncryptMessage(byte[] param1ArrayOfbyte) throws NTLMEngineException {
/*  913 */       byte[] arrayOfByte1 = encrypt(param1ArrayOfbyte);
/*  914 */       byte[] arrayOfByte2 = computeSignature(param1ArrayOfbyte);
/*  915 */       byte[] arrayOfByte3 = new byte[arrayOfByte2.length + arrayOfByte1.length];
/*  916 */       System.arraycopy(arrayOfByte2, 0, arrayOfByte3, 0, arrayOfByte2.length);
/*  917 */       System.arraycopy(arrayOfByte1, 0, arrayOfByte3, arrayOfByte2.length, arrayOfByte1.length);
/*  918 */       advanceMessageSequence();
/*  919 */       return arrayOfByte3;
/*      */     }
/*      */ 
/*      */     
/*      */     public byte[] decryptAndVerifySignedMessage(byte[] param1ArrayOfbyte) throws NTLMEngineException {
/*  924 */       byte[] arrayOfByte1 = new byte[16];
/*  925 */       System.arraycopy(param1ArrayOfbyte, 0, arrayOfByte1, 0, arrayOfByte1.length);
/*  926 */       byte[] arrayOfByte2 = new byte[param1ArrayOfbyte.length - 16];
/*  927 */       System.arraycopy(param1ArrayOfbyte, 16, arrayOfByte2, 0, arrayOfByte2.length);
/*  928 */       byte[] arrayOfByte3 = decrypt(arrayOfByte2);
/*  929 */       if (!validateSignature(arrayOfByte1, arrayOfByte3))
/*      */       {
/*  931 */         throw new NTLMEngineException("Wrong signature");
/*      */       }
/*  933 */       advanceMessageSequence();
/*  934 */       return arrayOfByte3;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static byte[] encodeLong(int paramInt) {
/*  941 */     byte[] arrayOfByte = new byte[4];
/*  942 */     encodeLong(arrayOfByte, 0, paramInt);
/*  943 */     return arrayOfByte;
/*      */   }
/*      */ 
/*      */   
/*      */   private static void encodeLong(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  948 */     paramArrayOfbyte[paramInt1 + 0] = (byte)(paramInt2 & 0xFF);
/*  949 */     paramArrayOfbyte[paramInt1 + 1] = (byte)(paramInt2 >> 8 & 0xFF);
/*  950 */     paramArrayOfbyte[paramInt1 + 2] = (byte)(paramInt2 >> 16 & 0xFF);
/*  951 */     paramArrayOfbyte[paramInt1 + 3] = (byte)(paramInt2 >> 24 & 0xFF);
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
/*      */   private static byte[] createBlob(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, byte[] paramArrayOfbyte3) {
/*  966 */     byte[] arrayOfByte1 = { 1, 1, 0, 0 };
/*  967 */     byte[] arrayOfByte2 = { 0, 0, 0, 0 };
/*  968 */     byte[] arrayOfByte3 = { 0, 0, 0, 0 };
/*  969 */     byte[] arrayOfByte4 = { 0, 0, 0, 0 };
/*  970 */     byte[] arrayOfByte5 = new byte[arrayOfByte1.length + arrayOfByte2.length + paramArrayOfbyte3.length + 8 + arrayOfByte3.length + paramArrayOfbyte2.length + arrayOfByte4.length];
/*      */     
/*  972 */     int i = 0;
/*  973 */     System.arraycopy(arrayOfByte1, 0, arrayOfByte5, i, arrayOfByte1.length);
/*  974 */     i += arrayOfByte1.length;
/*  975 */     System.arraycopy(arrayOfByte2, 0, arrayOfByte5, i, arrayOfByte2.length);
/*  976 */     i += arrayOfByte2.length;
/*  977 */     System.arraycopy(paramArrayOfbyte3, 0, arrayOfByte5, i, paramArrayOfbyte3.length);
/*  978 */     i += paramArrayOfbyte3.length;
/*  979 */     System.arraycopy(paramArrayOfbyte1, 0, arrayOfByte5, i, 8);
/*  980 */     i += 8;
/*  981 */     System.arraycopy(arrayOfByte3, 0, arrayOfByte5, i, arrayOfByte3.length);
/*  982 */     i += arrayOfByte3.length;
/*  983 */     System.arraycopy(paramArrayOfbyte2, 0, arrayOfByte5, i, paramArrayOfbyte2.length);
/*  984 */     i += paramArrayOfbyte2.length;
/*  985 */     System.arraycopy(arrayOfByte4, 0, arrayOfByte5, i, arrayOfByte4.length);
/*  986 */     i += arrayOfByte4.length;
/*  987 */     return arrayOfByte5;
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
/*      */   private static Key createDESKey(byte[] paramArrayOfbyte, int paramInt) {
/* 1003 */     byte[] arrayOfByte1 = new byte[7];
/* 1004 */     System.arraycopy(paramArrayOfbyte, paramInt, arrayOfByte1, 0, 7);
/* 1005 */     byte[] arrayOfByte2 = new byte[8];
/* 1006 */     arrayOfByte2[0] = arrayOfByte1[0];
/* 1007 */     arrayOfByte2[1] = (byte)(arrayOfByte1[0] << 7 | (arrayOfByte1[1] & 0xFF) >>> 1);
/* 1008 */     arrayOfByte2[2] = (byte)(arrayOfByte1[1] << 6 | (arrayOfByte1[2] & 0xFF) >>> 2);
/* 1009 */     arrayOfByte2[3] = (byte)(arrayOfByte1[2] << 5 | (arrayOfByte1[3] & 0xFF) >>> 3);
/* 1010 */     arrayOfByte2[4] = (byte)(arrayOfByte1[3] << 4 | (arrayOfByte1[4] & 0xFF) >>> 4);
/* 1011 */     arrayOfByte2[5] = (byte)(arrayOfByte1[4] << 3 | (arrayOfByte1[5] & 0xFF) >>> 5);
/* 1012 */     arrayOfByte2[6] = (byte)(arrayOfByte1[5] << 2 | (arrayOfByte1[6] & 0xFF) >>> 6);
/* 1013 */     arrayOfByte2[7] = (byte)(arrayOfByte1[6] << 1);
/* 1014 */     oddParity(arrayOfByte2);
/* 1015 */     return new SecretKeySpec(arrayOfByte2, "DES");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void oddParity(byte[] paramArrayOfbyte) {
/* 1025 */     for (byte b = 0; b < paramArrayOfbyte.length; b++) {
/* 1026 */       byte b1 = paramArrayOfbyte[b];
/* 1027 */       boolean bool = (((b1 >>> 7 ^ b1 >>> 6 ^ b1 >>> 5 ^ b1 >>> 4 ^ b1 >>> 3 ^ b1 >>> 2 ^ b1 >>> 1) & 0x1) == 0) ? true : false;
/*      */       
/* 1029 */       if (bool) {
/* 1030 */         paramArrayOfbyte[b] = (byte)(paramArrayOfbyte[b] | 0x1);
/*      */       } else {
/* 1032 */         paramArrayOfbyte[b] = (byte)(paramArrayOfbyte[b] & 0xFFFFFFFE);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Charset getCharset(int paramInt) throws NTLMEngineException {
/* 1044 */     if ((paramInt & 0x1) == 0) {
/* 1045 */       return DEFAULT_CHARSET;
/*      */     }
/* 1047 */     if (UNICODE_LITTLE_UNMARKED == null) {
/* 1048 */       throw new NTLMEngineException("Unicode not supported");
/*      */     }
/* 1050 */     return UNICODE_LITTLE_UNMARKED;
/*      */   }
/*      */ 
/*      */   
/*      */   private static String stripDotSuffix(String paramString) {
/* 1055 */     if (paramString == null) {
/* 1056 */       return null;
/*      */     }
/* 1058 */     int i = paramString.indexOf('.');
/* 1059 */     if (i != -1) {
/* 1060 */       return paramString.substring(0, i);
/*      */     }
/* 1062 */     return paramString;
/*      */   }
/*      */ 
/*      */   
/*      */   private static String convertHost(String paramString) {
/* 1067 */     return stripDotSuffix(paramString);
/*      */   }
/*      */ 
/*      */   
/*      */   private static String convertDomain(String paramString) {
/* 1072 */     return stripDotSuffix(paramString);
/*      */   }
/*      */ 
/*      */   
/*      */   static class NTLMMessage
/*      */   {
/* 1078 */     protected byte[] messageContents = null;
/*      */ 
/*      */     
/* 1081 */     protected int currentOutputPosition = 0;
/*      */ 
/*      */ 
/*      */     
/*      */     NTLMMessage() {}
/*      */ 
/*      */     
/*      */     NTLMMessage(String param1String, int param1Int) throws NTLMEngineException {
/* 1089 */       this(Base64.decodeBase64(param1String.getBytes(NTLMEngineImpl.DEFAULT_CHARSET)), param1Int);
/*      */     }
/*      */ 
/*      */     
/*      */     NTLMMessage(byte[] param1ArrayOfbyte, int param1Int) throws NTLMEngineException {
/* 1094 */       this.messageContents = param1ArrayOfbyte;
/*      */       
/* 1096 */       if (this.messageContents.length < NTLMEngineImpl.SIGNATURE.length) {
/* 1097 */         throw new NTLMEngineException("NTLM message decoding error - packet too short");
/*      */       }
/* 1099 */       byte b = 0;
/* 1100 */       while (b < NTLMEngineImpl.SIGNATURE.length) {
/* 1101 */         if (this.messageContents[b] != NTLMEngineImpl.SIGNATURE[b]) {
/* 1102 */           throw new NTLMEngineException("NTLM message expected - instead got unrecognized bytes");
/*      */         }
/*      */         
/* 1105 */         b++;
/*      */       } 
/*      */ 
/*      */       
/* 1109 */       int i = readULong(NTLMEngineImpl.SIGNATURE.length);
/* 1110 */       if (i != param1Int) {
/* 1111 */         throw new NTLMEngineException("NTLM type " + Integer.toString(param1Int) + " message expected - instead got type " + Integer.toString(i));
/*      */       }
/*      */ 
/*      */       
/* 1115 */       this.currentOutputPosition = this.messageContents.length;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected int getPreambleLength() {
/* 1123 */       return NTLMEngineImpl.SIGNATURE.length + 4;
/*      */     }
/*      */ 
/*      */     
/*      */     protected int getMessageLength() {
/* 1128 */       return this.currentOutputPosition;
/*      */     }
/*      */ 
/*      */     
/*      */     protected byte readByte(int param1Int) throws NTLMEngineException {
/* 1133 */       if (this.messageContents.length < param1Int + 1) {
/* 1134 */         throw new NTLMEngineException("NTLM: Message too short");
/*      */       }
/* 1136 */       return this.messageContents[param1Int];
/*      */     }
/*      */ 
/*      */     
/*      */     protected void readBytes(byte[] param1ArrayOfbyte, int param1Int) throws NTLMEngineException {
/* 1141 */       if (this.messageContents.length < param1Int + param1ArrayOfbyte.length) {
/* 1142 */         throw new NTLMEngineException("NTLM: Message too short");
/*      */       }
/* 1144 */       System.arraycopy(this.messageContents, param1Int, param1ArrayOfbyte, 0, param1ArrayOfbyte.length);
/*      */     }
/*      */ 
/*      */     
/*      */     protected int readUShort(int param1Int) throws NTLMEngineException {
/* 1149 */       return NTLMEngineImpl.readUShort(this.messageContents, param1Int);
/*      */     }
/*      */ 
/*      */     
/*      */     protected int readULong(int param1Int) throws NTLMEngineException {
/* 1154 */       return NTLMEngineImpl.readULong(this.messageContents, param1Int);
/*      */     }
/*      */ 
/*      */     
/*      */     protected byte[] readSecurityBuffer(int param1Int) throws NTLMEngineException {
/* 1159 */       return NTLMEngineImpl.readSecurityBuffer(this.messageContents, param1Int);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected void prepareResponse(int param1Int1, int param1Int2) {
/* 1171 */       this.messageContents = new byte[param1Int1];
/* 1172 */       this.currentOutputPosition = 0;
/* 1173 */       addBytes(NTLMEngineImpl.SIGNATURE);
/* 1174 */       addULong(param1Int2);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected void addByte(byte param1Byte) {
/* 1184 */       this.messageContents[this.currentOutputPosition] = param1Byte;
/* 1185 */       this.currentOutputPosition++;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected void addBytes(byte[] param1ArrayOfbyte) {
/* 1195 */       if (param1ArrayOfbyte == null) {
/*      */         return;
/*      */       }
/* 1198 */       for (byte b : param1ArrayOfbyte) {
/* 1199 */         this.messageContents[this.currentOutputPosition] = b;
/* 1200 */         this.currentOutputPosition++;
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     protected void addUShort(int param1Int) {
/* 1206 */       addByte((byte)(param1Int & 0xFF));
/* 1207 */       addByte((byte)(param1Int >> 8 & 0xFF));
/*      */     }
/*      */ 
/*      */     
/*      */     protected void addULong(int param1Int) {
/* 1212 */       addByte((byte)(param1Int & 0xFF));
/* 1213 */       addByte((byte)(param1Int >> 8 & 0xFF));
/* 1214 */       addByte((byte)(param1Int >> 16 & 0xFF));
/* 1215 */       addByte((byte)(param1Int >> 24 & 0xFF));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getResponse() {
/* 1225 */       return new String(Base64.encodeBase64(getBytes()), Consts.ASCII);
/*      */     }
/*      */     
/*      */     public byte[] getBytes() {
/* 1229 */       if (this.messageContents == null) {
/* 1230 */         buildMessage();
/*      */       }
/*      */       
/* 1233 */       if (this.messageContents.length > this.currentOutputPosition) {
/* 1234 */         byte[] arrayOfByte = new byte[this.currentOutputPosition];
/* 1235 */         System.arraycopy(this.messageContents, 0, arrayOfByte, 0, this.currentOutputPosition);
/* 1236 */         this.messageContents = arrayOfByte;
/*      */       } 
/* 1238 */       return this.messageContents;
/*      */     }
/*      */     
/*      */     protected void buildMessage() {
/* 1242 */       throw new RuntimeException("Message builder not implemented for " + getClass().getName());
/*      */     }
/*      */   }
/*      */   
/*      */   static class Type1Message
/*      */     extends NTLMMessage
/*      */   {
/*      */     private final byte[] hostBytes;
/*      */     private final byte[] domainBytes;
/*      */     private final int flags;
/*      */     
/*      */     Type1Message(String param1String1, String param1String2) throws NTLMEngineException {
/* 1254 */       this(param1String1, param1String2, (Integer)null);
/*      */     }
/*      */ 
/*      */     
/*      */     Type1Message(String param1String1, String param1String2, Integer param1Integer) throws NTLMEngineException {
/* 1259 */       this.flags = (param1Integer == null) ? getDefaultFlags() : param1Integer.intValue();
/*      */ 
/*      */       
/* 1262 */       String str1 = NTLMEngineImpl.convertHost(param1String2);
/*      */       
/* 1264 */       String str2 = NTLMEngineImpl.convertDomain(param1String1);
/*      */       
/* 1266 */       this.hostBytes = (str1 != null) ? str1.getBytes(NTLMEngineImpl.UNICODE_LITTLE_UNMARKED) : null;
/*      */       
/* 1268 */       this.domainBytes = (str2 != null) ? str2.toUpperCase(Locale.ROOT).getBytes(NTLMEngineImpl.UNICODE_LITTLE_UNMARKED) : null;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     Type1Message() {
/* 1274 */       this.hostBytes = null;
/* 1275 */       this.domainBytes = null;
/* 1276 */       this.flags = getDefaultFlags();
/*      */     }
/*      */     
/*      */     private int getDefaultFlags() {
/* 1280 */       return -1576500735;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected void buildMessage() {
/* 1312 */       int i = 0;
/* 1313 */       if (this.domainBytes != null) {
/* 1314 */         i = this.domainBytes.length;
/*      */       }
/* 1316 */       int j = 0;
/* 1317 */       if (this.hostBytes != null) {
/* 1318 */         j = this.hostBytes.length;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/* 1323 */       int k = 40 + j + i;
/*      */ 
/*      */ 
/*      */       
/* 1327 */       prepareResponse(k, 1);
/*      */ 
/*      */       
/* 1330 */       addULong(this.flags);
/*      */ 
/*      */       
/* 1333 */       addUShort(i);
/* 1334 */       addUShort(i);
/*      */ 
/*      */       
/* 1337 */       addULong(j + 32 + 8);
/*      */ 
/*      */       
/* 1340 */       addUShort(j);
/* 1341 */       addUShort(j);
/*      */ 
/*      */       
/* 1344 */       addULong(40);
/*      */ 
/*      */       
/* 1347 */       addUShort(261);
/*      */       
/* 1349 */       addULong(2600);
/*      */       
/* 1351 */       addUShort(3840);
/*      */ 
/*      */       
/* 1354 */       if (this.hostBytes != null) {
/* 1355 */         addBytes(this.hostBytes);
/*      */       }
/*      */       
/* 1358 */       if (this.domainBytes != null) {
/* 1359 */         addBytes(this.domainBytes);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   static class Type2Message
/*      */     extends NTLMMessage
/*      */   {
/*      */     protected final byte[] challenge;
/*      */     protected String target;
/*      */     protected byte[] targetInfo;
/*      */     protected final int flags;
/*      */     
/*      */     Type2Message(String param1String) throws NTLMEngineException {
/* 1373 */       this(Base64.decodeBase64(param1String.getBytes(NTLMEngineImpl.DEFAULT_CHARSET)));
/*      */     }
/*      */     
/*      */     Type2Message(byte[] param1ArrayOfbyte) throws NTLMEngineException {
/* 1377 */       super(param1ArrayOfbyte, 2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1394 */       this.challenge = new byte[8];
/* 1395 */       readBytes(this.challenge, 24);
/*      */       
/* 1397 */       this.flags = readULong(20);
/*      */ 
/*      */       
/* 1400 */       this.target = null;
/*      */ 
/*      */ 
/*      */       
/* 1404 */       if (getMessageLength() >= 20) {
/* 1405 */         byte[] arrayOfByte = readSecurityBuffer(12);
/* 1406 */         if (arrayOfByte.length != 0) {
/* 1407 */           this.target = new String(arrayOfByte, NTLMEngineImpl.getCharset(this.flags));
/*      */         }
/*      */       } 
/*      */ 
/*      */       
/* 1412 */       this.targetInfo = null;
/*      */       
/* 1414 */       if (getMessageLength() >= 48) {
/* 1415 */         byte[] arrayOfByte = readSecurityBuffer(40);
/* 1416 */         if (arrayOfByte.length != 0) {
/* 1417 */           this.targetInfo = arrayOfByte;
/*      */         }
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     byte[] getChallenge() {
/* 1424 */       return this.challenge;
/*      */     }
/*      */ 
/*      */     
/*      */     String getTarget() {
/* 1429 */       return this.target;
/*      */     }
/*      */ 
/*      */     
/*      */     byte[] getTargetInfo() {
/* 1434 */       return this.targetInfo;
/*      */     }
/*      */ 
/*      */     
/*      */     int getFlags() {
/* 1439 */       return this.flags;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static class Type3Message
/*      */     extends NTLMMessage
/*      */   {
/*      */     protected final byte[] type1Message;
/*      */ 
/*      */     
/*      */     protected final byte[] type2Message;
/*      */ 
/*      */     
/*      */     protected final int type2Flags;
/*      */     
/*      */     protected final byte[] domainBytes;
/*      */     
/*      */     protected final byte[] hostBytes;
/*      */     
/*      */     protected final byte[] userBytes;
/*      */     
/*      */     protected byte[] lmResp;
/*      */     
/*      */     protected byte[] ntResp;
/*      */     
/*      */     protected final byte[] sessionKey;
/*      */     
/*      */     protected final byte[] exportedSessionKey;
/*      */     
/*      */     protected final boolean computeMic;
/*      */ 
/*      */     
/*      */     Type3Message(String param1String1, String param1String2, String param1String3, String param1String4, byte[] param1ArrayOfbyte1, int param1Int, String param1String5, byte[] param1ArrayOfbyte2) throws NTLMEngineException {
/* 1474 */       this(param1String1, param1String2, param1String3, param1String4, param1ArrayOfbyte1, param1Int, param1String5, param1ArrayOfbyte2, (Certificate)null, (byte[])null, (byte[])null);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Type3Message(Random param1Random, long param1Long, String param1String1, String param1String2, String param1String3, String param1String4, byte[] param1ArrayOfbyte1, int param1Int, String param1String5, byte[] param1ArrayOfbyte2) throws NTLMEngineException {
/* 1489 */       this(param1Random, param1Long, param1String1, param1String2, param1String3, param1String4, param1ArrayOfbyte1, param1Int, param1String5, param1ArrayOfbyte2, (Certificate)null, (byte[])null, (byte[])null);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Type3Message(String param1String1, String param1String2, String param1String3, String param1String4, byte[] param1ArrayOfbyte1, int param1Int, String param1String5, byte[] param1ArrayOfbyte2, Certificate param1Certificate, byte[] param1ArrayOfbyte3, byte[] param1ArrayOfbyte4) throws NTLMEngineException {
/* 1505 */       this(NTLMEngineImpl.RND_GEN, System.currentTimeMillis(), param1String1, param1String2, param1String3, param1String4, param1ArrayOfbyte1, param1Int, param1String5, param1ArrayOfbyte2, param1Certificate, param1ArrayOfbyte3, param1ArrayOfbyte4);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Type3Message(Random param1Random, long param1Long, String param1String1, String param1String2, String param1String3, String param1String4, byte[] param1ArrayOfbyte1, int param1Int, String param1String5, byte[] param1ArrayOfbyte2, Certificate param1Certificate, byte[] param1ArrayOfbyte3, byte[] param1ArrayOfbyte4) throws NTLMEngineException {
/*      */       byte[] arrayOfByte2;
/* 1523 */       if (param1Random == null) {
/* 1524 */         throw new NTLMEngineException("Random generator not available");
/*      */       }
/*      */ 
/*      */       
/* 1528 */       this.type2Flags = param1Int;
/* 1529 */       this.type1Message = param1ArrayOfbyte3;
/* 1530 */       this.type2Message = param1ArrayOfbyte4;
/*      */ 
/*      */       
/* 1533 */       String str1 = NTLMEngineImpl.convertHost(param1String2);
/*      */       
/* 1535 */       String str2 = NTLMEngineImpl.convertDomain(param1String1);
/*      */       
/* 1537 */       byte[] arrayOfByte1 = param1ArrayOfbyte2;
/* 1538 */       if (param1Certificate != null) {
/* 1539 */         arrayOfByte1 = addGssMicAvsToTargetInfo(param1ArrayOfbyte2, param1Certificate);
/* 1540 */         this.computeMic = true;
/*      */       } else {
/* 1542 */         this.computeMic = false;
/*      */       } 
/*      */ 
/*      */       
/* 1546 */       NTLMEngineImpl.CipherGen cipherGen = new NTLMEngineImpl.CipherGen(param1Random, param1Long, str2, param1String3, param1String4, param1ArrayOfbyte1, param1String5, arrayOfByte1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       try {
/* 1560 */         if ((param1Int & 0x800000) != 0 && param1ArrayOfbyte2 != null && param1String5 != null) {
/*      */ 
/*      */           
/* 1563 */           this.ntResp = cipherGen.getNTLMv2Response();
/* 1564 */           this.lmResp = cipherGen.getLMv2Response();
/* 1565 */           if ((param1Int & 0x80) != 0) {
/* 1566 */             arrayOfByte2 = cipherGen.getLanManagerSessionKey();
/*      */           } else {
/* 1568 */             arrayOfByte2 = cipherGen.getNTLMv2UserSessionKey();
/*      */           }
/*      */         
/*      */         }
/* 1572 */         else if ((param1Int & 0x80000) != 0) {
/*      */           
/* 1574 */           this.ntResp = cipherGen.getNTLM2SessionResponse();
/* 1575 */           this.lmResp = cipherGen.getLM2SessionResponse();
/* 1576 */           if ((param1Int & 0x80) != 0) {
/* 1577 */             arrayOfByte2 = cipherGen.getLanManagerSessionKey();
/*      */           } else {
/* 1579 */             arrayOfByte2 = cipherGen.getNTLM2SessionResponseUserSessionKey();
/*      */           } 
/*      */         } else {
/* 1582 */           this.ntResp = cipherGen.getNTLMResponse();
/* 1583 */           this.lmResp = cipherGen.getLMResponse();
/* 1584 */           if ((param1Int & 0x80) != 0) {
/* 1585 */             arrayOfByte2 = cipherGen.getLanManagerSessionKey();
/*      */           } else {
/* 1587 */             arrayOfByte2 = cipherGen.getNTLMUserSessionKey();
/*      */           }
/*      */         
/*      */         } 
/* 1591 */       } catch (NTLMEngineException nTLMEngineException) {
/*      */ 
/*      */         
/* 1594 */         this.ntResp = new byte[0];
/* 1595 */         this.lmResp = cipherGen.getLMResponse();
/* 1596 */         if ((param1Int & 0x80) != 0) {
/* 1597 */           arrayOfByte2 = cipherGen.getLanManagerSessionKey();
/*      */         } else {
/* 1599 */           arrayOfByte2 = cipherGen.getLMUserSessionKey();
/*      */         } 
/*      */       } 
/*      */       
/* 1603 */       if ((param1Int & 0x10) != 0) {
/* 1604 */         if ((param1Int & 0x40000000) != 0) {
/* 1605 */           this.exportedSessionKey = cipherGen.getSecondaryKey();
/* 1606 */           this.sessionKey = NTLMEngineImpl.RC4(this.exportedSessionKey, arrayOfByte2);
/*      */         } else {
/* 1608 */           this.sessionKey = arrayOfByte2;
/* 1609 */           this.exportedSessionKey = this.sessionKey;
/*      */         } 
/*      */       } else {
/* 1612 */         if (this.computeMic) {
/* 1613 */           throw new NTLMEngineException("Cannot sign/seal: no exported session key");
/*      */         }
/* 1615 */         this.sessionKey = null;
/* 1616 */         this.exportedSessionKey = null;
/*      */       } 
/* 1618 */       Charset charset = NTLMEngineImpl.getCharset(param1Int);
/* 1619 */       this.hostBytes = (str1 != null) ? str1.getBytes(charset) : null;
/* 1620 */       this.domainBytes = (str2 != null) ? str2.toUpperCase(Locale.ROOT).getBytes(charset) : null;
/*      */       
/* 1622 */       this.userBytes = param1String3.getBytes(charset);
/*      */     }
/*      */     
/*      */     public byte[] getEncryptedRandomSessionKey() {
/* 1626 */       return this.sessionKey;
/*      */     }
/*      */     
/*      */     public byte[] getExportedSessionKey() {
/* 1630 */       return this.exportedSessionKey;
/*      */     }
/*      */ 
/*      */     
/*      */     protected void buildMessage() {
/*      */       byte b3;
/* 1636 */       int i = this.ntResp.length;
/* 1637 */       int j = this.lmResp.length;
/*      */       
/* 1639 */       byte b1 = (this.domainBytes != null) ? this.domainBytes.length : 0;
/* 1640 */       byte b2 = (this.hostBytes != null) ? this.hostBytes.length : 0;
/* 1641 */       int k = this.userBytes.length;
/*      */       
/* 1643 */       if (this.sessionKey != null) {
/* 1644 */         b3 = this.sessionKey.length;
/*      */       } else {
/* 1646 */         b3 = 0;
/*      */       } 
/*      */ 
/*      */       
/* 1650 */       int m = 72 + (this.computeMic ? 16 : 0);
/*      */       
/* 1652 */       int n = m + j;
/* 1653 */       int i1 = n + i;
/* 1654 */       int i2 = i1 + b1;
/* 1655 */       int i3 = i2 + k;
/* 1656 */       int i4 = i3 + b2;
/* 1657 */       int i5 = i4 + b3;
/*      */ 
/*      */       
/* 1660 */       prepareResponse(i5, 3);
/*      */ 
/*      */       
/* 1663 */       addUShort(j);
/* 1664 */       addUShort(j);
/*      */ 
/*      */       
/* 1667 */       addULong(m);
/*      */ 
/*      */       
/* 1670 */       addUShort(i);
/* 1671 */       addUShort(i);
/*      */ 
/*      */       
/* 1674 */       addULong(n);
/*      */ 
/*      */       
/* 1677 */       addUShort(b1);
/* 1678 */       addUShort(b1);
/*      */ 
/*      */       
/* 1681 */       addULong(i1);
/*      */ 
/*      */       
/* 1684 */       addUShort(k);
/* 1685 */       addUShort(k);
/*      */ 
/*      */       
/* 1688 */       addULong(i2);
/*      */ 
/*      */       
/* 1691 */       addUShort(b2);
/* 1692 */       addUShort(b2);
/*      */ 
/*      */       
/* 1695 */       addULong(i3);
/*      */ 
/*      */       
/* 1698 */       addUShort(b3);
/* 1699 */       addUShort(b3);
/*      */ 
/*      */       
/* 1702 */       addULong(i4);
/*      */ 
/*      */       
/* 1705 */       addULong(this.type2Flags);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1736 */       addUShort(261);
/*      */       
/* 1738 */       addULong(2600);
/*      */       
/* 1740 */       addUShort(3840);
/*      */       
/* 1742 */       int i6 = -1;
/* 1743 */       if (this.computeMic) {
/* 1744 */         i6 = this.currentOutputPosition;
/* 1745 */         this.currentOutputPosition += 16;
/*      */       } 
/*      */ 
/*      */       
/* 1749 */       addBytes(this.lmResp);
/* 1750 */       addBytes(this.ntResp);
/* 1751 */       addBytes(this.domainBytes);
/* 1752 */       addBytes(this.userBytes);
/* 1753 */       addBytes(this.hostBytes);
/* 1754 */       if (this.sessionKey != null) {
/* 1755 */         addBytes(this.sessionKey);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/* 1760 */       if (this.computeMic) {
/*      */         
/* 1762 */         NTLMEngineImpl.HMACMD5 hMACMD5 = new NTLMEngineImpl.HMACMD5(this.exportedSessionKey);
/* 1763 */         hMACMD5.update(this.type1Message);
/* 1764 */         hMACMD5.update(this.type2Message);
/* 1765 */         hMACMD5.update(this.messageContents);
/* 1766 */         byte[] arrayOfByte = hMACMD5.getOutput();
/* 1767 */         System.arraycopy(arrayOfByte, 0, this.messageContents, i6, arrayOfByte.length);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private byte[] addGssMicAvsToTargetInfo(byte[] param1ArrayOfbyte, Certificate param1Certificate) throws NTLMEngineException {
/* 1778 */       byte[] arrayOfByte2, arrayOfByte1 = new byte[param1ArrayOfbyte.length + 8 + 20];
/* 1779 */       int i = param1ArrayOfbyte.length - 4;
/* 1780 */       System.arraycopy(param1ArrayOfbyte, 0, arrayOfByte1, 0, i);
/* 1781 */       NTLMEngineImpl.writeUShort(arrayOfByte1, 6, i);
/* 1782 */       NTLMEngineImpl.writeUShort(arrayOfByte1, 4, i + 2);
/* 1783 */       NTLMEngineImpl.writeULong(arrayOfByte1, 2, i + 4);
/* 1784 */       NTLMEngineImpl.writeUShort(arrayOfByte1, 10, i + 8);
/* 1785 */       NTLMEngineImpl.writeUShort(arrayOfByte1, 16, i + 10);
/*      */ 
/*      */ 
/*      */       
/*      */       try {
/* 1790 */         byte[] arrayOfByte3 = param1Certificate.getEncoded();
/* 1791 */         MessageDigest messageDigest1 = MessageDigest.getInstance("SHA-256");
/* 1792 */         byte[] arrayOfByte4 = messageDigest1.digest(arrayOfByte3);
/* 1793 */         byte[] arrayOfByte5 = new byte[20 + NTLMEngineImpl.MAGIC_TLS_SERVER_ENDPOINT.length + arrayOfByte4.length];
/*      */         
/* 1795 */         NTLMEngineImpl.writeULong(arrayOfByte5, 53, 16);
/* 1796 */         System.arraycopy(NTLMEngineImpl.MAGIC_TLS_SERVER_ENDPOINT, 0, arrayOfByte5, 20, NTLMEngineImpl.MAGIC_TLS_SERVER_ENDPOINT.length);
/*      */         
/* 1798 */         System.arraycopy(arrayOfByte4, 0, arrayOfByte5, 20 + NTLMEngineImpl.MAGIC_TLS_SERVER_ENDPOINT.length, arrayOfByte4.length);
/*      */         
/* 1800 */         MessageDigest messageDigest2 = NTLMEngineImpl.getMD5();
/* 1801 */         arrayOfByte2 = messageDigest2.digest(arrayOfByte5);
/*      */       }
/* 1803 */       catch (CertificateEncodingException certificateEncodingException) {
/*      */         
/* 1805 */         throw new NTLMEngineException(certificateEncodingException.getMessage(), certificateEncodingException);
/*      */       }
/* 1807 */       catch (NoSuchAlgorithmException noSuchAlgorithmException) {
/*      */         
/* 1809 */         throw new NTLMEngineException(noSuchAlgorithmException.getMessage(), noSuchAlgorithmException);
/*      */       } 
/*      */       
/* 1812 */       System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i + 12, 16);
/* 1813 */       return arrayOfByte1;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   static void writeUShort(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 1819 */     paramArrayOfbyte[paramInt2] = (byte)(paramInt1 & 0xFF);
/* 1820 */     paramArrayOfbyte[paramInt2 + 1] = (byte)(paramInt1 >> 8 & 0xFF);
/*      */   }
/*      */   
/*      */   static void writeULong(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 1824 */     paramArrayOfbyte[paramInt2] = (byte)(paramInt1 & 0xFF);
/* 1825 */     paramArrayOfbyte[paramInt2 + 1] = (byte)(paramInt1 >> 8 & 0xFF);
/* 1826 */     paramArrayOfbyte[paramInt2 + 2] = (byte)(paramInt1 >> 16 & 0xFF);
/* 1827 */     paramArrayOfbyte[paramInt2 + 3] = (byte)(paramInt1 >> 24 & 0xFF);
/*      */   }
/*      */   
/*      */   static int F(int paramInt1, int paramInt2, int paramInt3) {
/* 1831 */     return paramInt1 & paramInt2 | (paramInt1 ^ 0xFFFFFFFF) & paramInt3;
/*      */   }
/*      */   
/*      */   static int G(int paramInt1, int paramInt2, int paramInt3) {
/* 1835 */     return paramInt1 & paramInt2 | paramInt1 & paramInt3 | paramInt2 & paramInt3;
/*      */   }
/*      */   
/*      */   static int H(int paramInt1, int paramInt2, int paramInt3) {
/* 1839 */     return paramInt1 ^ paramInt2 ^ paramInt3;
/*      */   }
/*      */   
/*      */   static int rotintlft(int paramInt1, int paramInt2) {
/* 1843 */     return paramInt1 << paramInt2 | paramInt1 >>> 32 - paramInt2;
/*      */   }
/*      */   
/*      */   static MessageDigest getMD5() {
/*      */     try {
/* 1848 */       return MessageDigest.getInstance("MD5");
/* 1849 */     } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
/* 1850 */       throw new RuntimeException("MD5 message digest doesn't seem to exist - fatal error: " + noSuchAlgorithmException.getMessage(), noSuchAlgorithmException);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class MD4
/*      */   {
/* 1862 */     protected int A = 1732584193;
/* 1863 */     protected int B = -271733879;
/* 1864 */     protected int C = -1732584194;
/* 1865 */     protected int D = 271733878;
/* 1866 */     protected long count = 0L;
/* 1867 */     protected final byte[] dataBuffer = new byte[64];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void update(byte[] param1ArrayOfbyte) {
/* 1876 */       int i = (int)(this.count & 0x3FL);
/* 1877 */       int j = 0;
/* 1878 */       while (param1ArrayOfbyte.length - j + i >= this.dataBuffer.length) {
/*      */ 
/*      */ 
/*      */         
/* 1882 */         int k = this.dataBuffer.length - i;
/* 1883 */         System.arraycopy(param1ArrayOfbyte, j, this.dataBuffer, i, k);
/* 1884 */         this.count += k;
/* 1885 */         i = 0;
/* 1886 */         j += k;
/* 1887 */         processBuffer();
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1892 */       if (j < param1ArrayOfbyte.length) {
/* 1893 */         int k = param1ArrayOfbyte.length - j;
/* 1894 */         System.arraycopy(param1ArrayOfbyte, j, this.dataBuffer, i, k);
/* 1895 */         this.count += k;
/* 1896 */         i += k;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     byte[] getOutput() {
/* 1903 */       int i = (int)(this.count & 0x3FL);
/* 1904 */       int j = (i < 56) ? (56 - i) : (120 - i);
/* 1905 */       byte[] arrayOfByte1 = new byte[j + 8];
/*      */ 
/*      */       
/* 1908 */       arrayOfByte1[0] = Byte.MIN_VALUE;
/*      */       
/* 1910 */       for (byte b = 0; b < 8; b++) {
/* 1911 */         arrayOfByte1[j + b] = (byte)(int)(this.count * 8L >>> 8 * b);
/*      */       }
/*      */ 
/*      */       
/* 1915 */       update(arrayOfByte1);
/*      */ 
/*      */       
/* 1918 */       byte[] arrayOfByte2 = new byte[16];
/* 1919 */       NTLMEngineImpl.writeULong(arrayOfByte2, this.A, 0);
/* 1920 */       NTLMEngineImpl.writeULong(arrayOfByte2, this.B, 4);
/* 1921 */       NTLMEngineImpl.writeULong(arrayOfByte2, this.C, 8);
/* 1922 */       NTLMEngineImpl.writeULong(arrayOfByte2, this.D, 12);
/* 1923 */       return arrayOfByte2;
/*      */     }
/*      */ 
/*      */     
/*      */     protected void processBuffer() {
/* 1928 */       int[] arrayOfInt = new int[16];
/*      */       int i;
/* 1930 */       for (i = 0; i < 16; i++) {
/* 1931 */         arrayOfInt[i] = (this.dataBuffer[i * 4] & 0xFF) + ((this.dataBuffer[i * 4 + 1] & 0xFF) << 8) + ((this.dataBuffer[i * 4 + 2] & 0xFF) << 16) + ((this.dataBuffer[i * 4 + 3] & 0xFF) << 24);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1937 */       i = this.A;
/* 1938 */       int j = this.B;
/* 1939 */       int k = this.C;
/* 1940 */       int m = this.D;
/* 1941 */       round1(arrayOfInt);
/* 1942 */       round2(arrayOfInt);
/* 1943 */       round3(arrayOfInt);
/* 1944 */       this.A += i;
/* 1945 */       this.B += j;
/* 1946 */       this.C += k;
/* 1947 */       this.D += m;
/*      */     }
/*      */ 
/*      */     
/*      */     protected void round1(int[] param1ArrayOfint) {
/* 1952 */       this.A = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.F(this.B, this.C, this.D) + param1ArrayOfint[0], 3);
/* 1953 */       this.D = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.F(this.A, this.B, this.C) + param1ArrayOfint[1], 7);
/* 1954 */       this.C = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.F(this.D, this.A, this.B) + param1ArrayOfint[2], 11);
/* 1955 */       this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.F(this.C, this.D, this.A) + param1ArrayOfint[3], 19);
/*      */       
/* 1957 */       this.A = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.F(this.B, this.C, this.D) + param1ArrayOfint[4], 3);
/* 1958 */       this.D = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.F(this.A, this.B, this.C) + param1ArrayOfint[5], 7);
/* 1959 */       this.C = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.F(this.D, this.A, this.B) + param1ArrayOfint[6], 11);
/* 1960 */       this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.F(this.C, this.D, this.A) + param1ArrayOfint[7], 19);
/*      */       
/* 1962 */       this.A = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.F(this.B, this.C, this.D) + param1ArrayOfint[8], 3);
/* 1963 */       this.D = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.F(this.A, this.B, this.C) + param1ArrayOfint[9], 7);
/* 1964 */       this.C = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.F(this.D, this.A, this.B) + param1ArrayOfint[10], 11);
/* 1965 */       this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.F(this.C, this.D, this.A) + param1ArrayOfint[11], 19);
/*      */       
/* 1967 */       this.A = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.F(this.B, this.C, this.D) + param1ArrayOfint[12], 3);
/* 1968 */       this.D = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.F(this.A, this.B, this.C) + param1ArrayOfint[13], 7);
/* 1969 */       this.C = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.F(this.D, this.A, this.B) + param1ArrayOfint[14], 11);
/* 1970 */       this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.F(this.C, this.D, this.A) + param1ArrayOfint[15], 19);
/*      */     }
/*      */     
/*      */     protected void round2(int[] param1ArrayOfint) {
/* 1974 */       this.A = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.G(this.B, this.C, this.D) + param1ArrayOfint[0] + 1518500249, 3);
/* 1975 */       this.D = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.G(this.A, this.B, this.C) + param1ArrayOfint[4] + 1518500249, 5);
/* 1976 */       this.C = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.G(this.D, this.A, this.B) + param1ArrayOfint[8] + 1518500249, 9);
/* 1977 */       this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.G(this.C, this.D, this.A) + param1ArrayOfint[12] + 1518500249, 13);
/*      */       
/* 1979 */       this.A = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.G(this.B, this.C, this.D) + param1ArrayOfint[1] + 1518500249, 3);
/* 1980 */       this.D = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.G(this.A, this.B, this.C) + param1ArrayOfint[5] + 1518500249, 5);
/* 1981 */       this.C = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.G(this.D, this.A, this.B) + param1ArrayOfint[9] + 1518500249, 9);
/* 1982 */       this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.G(this.C, this.D, this.A) + param1ArrayOfint[13] + 1518500249, 13);
/*      */       
/* 1984 */       this.A = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.G(this.B, this.C, this.D) + param1ArrayOfint[2] + 1518500249, 3);
/* 1985 */       this.D = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.G(this.A, this.B, this.C) + param1ArrayOfint[6] + 1518500249, 5);
/* 1986 */       this.C = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.G(this.D, this.A, this.B) + param1ArrayOfint[10] + 1518500249, 9);
/* 1987 */       this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.G(this.C, this.D, this.A) + param1ArrayOfint[14] + 1518500249, 13);
/*      */       
/* 1989 */       this.A = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.G(this.B, this.C, this.D) + param1ArrayOfint[3] + 1518500249, 3);
/* 1990 */       this.D = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.G(this.A, this.B, this.C) + param1ArrayOfint[7] + 1518500249, 5);
/* 1991 */       this.C = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.G(this.D, this.A, this.B) + param1ArrayOfint[11] + 1518500249, 9);
/* 1992 */       this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.G(this.C, this.D, this.A) + param1ArrayOfint[15] + 1518500249, 13);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void round3(int[] param1ArrayOfint) {
/* 1997 */       this.A = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.H(this.B, this.C, this.D) + param1ArrayOfint[0] + 1859775393, 3);
/* 1998 */       this.D = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.H(this.A, this.B, this.C) + param1ArrayOfint[8] + 1859775393, 9);
/* 1999 */       this.C = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.H(this.D, this.A, this.B) + param1ArrayOfint[4] + 1859775393, 11);
/* 2000 */       this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.H(this.C, this.D, this.A) + param1ArrayOfint[12] + 1859775393, 15);
/*      */       
/* 2002 */       this.A = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.H(this.B, this.C, this.D) + param1ArrayOfint[2] + 1859775393, 3);
/* 2003 */       this.D = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.H(this.A, this.B, this.C) + param1ArrayOfint[10] + 1859775393, 9);
/* 2004 */       this.C = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.H(this.D, this.A, this.B) + param1ArrayOfint[6] + 1859775393, 11);
/* 2005 */       this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.H(this.C, this.D, this.A) + param1ArrayOfint[14] + 1859775393, 15);
/*      */       
/* 2007 */       this.A = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.H(this.B, this.C, this.D) + param1ArrayOfint[1] + 1859775393, 3);
/* 2008 */       this.D = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.H(this.A, this.B, this.C) + param1ArrayOfint[9] + 1859775393, 9);
/* 2009 */       this.C = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.H(this.D, this.A, this.B) + param1ArrayOfint[5] + 1859775393, 11);
/* 2010 */       this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.H(this.C, this.D, this.A) + param1ArrayOfint[13] + 1859775393, 15);
/*      */       
/* 2012 */       this.A = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.H(this.B, this.C, this.D) + param1ArrayOfint[3] + 1859775393, 3);
/* 2013 */       this.D = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.H(this.A, this.B, this.C) + param1ArrayOfint[11] + 1859775393, 9);
/* 2014 */       this.C = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.H(this.D, this.A, this.B) + param1ArrayOfint[7] + 1859775393, 11);
/* 2015 */       this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.H(this.C, this.D, this.A) + param1ArrayOfint[15] + 1859775393, 15);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static class HMACMD5
/*      */   {
/*      */     protected final byte[] ipad;
/*      */     
/*      */     protected final byte[] opad;
/*      */     
/*      */     protected final MessageDigest md5;
/*      */ 
/*      */     
/*      */     HMACMD5(byte[] param1ArrayOfbyte) {
/* 2031 */       byte[] arrayOfByte = param1ArrayOfbyte;
/* 2032 */       this.md5 = NTLMEngineImpl.getMD5();
/*      */ 
/*      */       
/* 2035 */       this.ipad = new byte[64];
/* 2036 */       this.opad = new byte[64];
/*      */       
/* 2038 */       int i = arrayOfByte.length;
/* 2039 */       if (i > 64) {
/*      */         
/* 2041 */         this.md5.update(arrayOfByte);
/* 2042 */         arrayOfByte = this.md5.digest();
/* 2043 */         i = arrayOfByte.length;
/*      */       } 
/* 2045 */       byte b = 0;
/* 2046 */       while (b < i) {
/* 2047 */         this.ipad[b] = (byte)(arrayOfByte[b] ^ 0x36);
/* 2048 */         this.opad[b] = (byte)(arrayOfByte[b] ^ 0x5C);
/* 2049 */         b++;
/*      */       } 
/* 2051 */       while (b < 64) {
/* 2052 */         this.ipad[b] = 54;
/* 2053 */         this.opad[b] = 92;
/* 2054 */         b++;
/*      */       } 
/*      */ 
/*      */       
/* 2058 */       this.md5.reset();
/* 2059 */       this.md5.update(this.ipad);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     byte[] getOutput() {
/* 2065 */       byte[] arrayOfByte = this.md5.digest();
/* 2066 */       this.md5.update(this.opad);
/* 2067 */       return this.md5.digest(arrayOfByte);
/*      */     }
/*      */ 
/*      */     
/*      */     void update(byte[] param1ArrayOfbyte) {
/* 2072 */       this.md5.update(param1ArrayOfbyte);
/*      */     }
/*      */ 
/*      */     
/*      */     void update(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
/* 2077 */       this.md5.update(param1ArrayOfbyte, param1Int1, param1Int2);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String generateType1Msg(String paramString1, String paramString2) throws NTLMEngineException {
/* 2086 */     return getType1Message(paramString2, paramString1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String generateType3Msg(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) throws NTLMEngineException {
/* 2096 */     Type2Message type2Message = new Type2Message(paramString5);
/* 2097 */     return getType3Message(paramString1, paramString2, paramString4, paramString3, type2Message.getChallenge(), type2Message.getFlags(), type2Message.getTarget(), type2Message.getTargetInfo());
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\auth\NTLMEngineImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */