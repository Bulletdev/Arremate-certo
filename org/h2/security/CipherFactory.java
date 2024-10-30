/*     */ package org.h2.security;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.net.InetAddress;
/*     */ import java.net.InetSocketAddress;
/*     */ import java.net.ServerSocket;
/*     */ import java.net.Socket;
/*     */ import java.security.KeyFactory;
/*     */ import java.security.KeyStore;
/*     */ import java.security.PrivateKey;
/*     */ import java.security.Security;
/*     */ import java.security.cert.Certificate;
/*     */ import java.security.cert.CertificateFactory;
/*     */ import java.security.spec.PKCS8EncodedKeySpec;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Properties;
/*     */ import javax.net.ServerSocketFactory;
/*     */ import javax.net.ssl.SSLServerSocket;
/*     */ import javax.net.ssl.SSLServerSocketFactory;
/*     */ import javax.net.ssl.SSLSocket;
/*     */ import javax.net.ssl.SSLSocketFactory;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.store.fs.FileUtils;
/*     */ import org.h2.util.IOUtils;
/*     */ import org.h2.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CipherFactory
/*     */ {
/*     */   public static final String KEYSTORE_PASSWORD = "h2pass";
/*     */   public static final String LEGACY_ALGORITHMS_SECURITY_KEY = "jdk.tls.legacyAlgorithms";
/*  68 */   public static final String DEFAULT_LEGACY_ALGORITHMS = getLegacyAlgorithmsSilently();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String KEYSTORE = "~/.h2.keystore";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String KEYSTORE_KEY = "javax.net.ssl.keyStore";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String KEYSTORE_PASSWORD_KEY = "javax.net.ssl.keyStorePassword";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BlockCipher getBlockCipher(String paramString) {
/*  89 */     if ("XTEA".equalsIgnoreCase(paramString))
/*  90 */       return new XTEA(); 
/*  91 */     if ("AES".equalsIgnoreCase(paramString))
/*  92 */       return new AES(); 
/*  93 */     if ("FOG".equalsIgnoreCase(paramString)) {
/*  94 */       return new Fog();
/*     */     }
/*  96 */     throw DbException.get(90055, paramString);
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
/*     */   public static Socket createSocket(InetAddress paramInetAddress, int paramInt) throws IOException {
/* 109 */     SSLSocket sSLSocket1 = null;
/* 110 */     setKeystore();
/* 111 */     SSLSocketFactory sSLSocketFactory = (SSLSocketFactory)SSLSocketFactory.getDefault();
/* 112 */     SSLSocket sSLSocket2 = (SSLSocket)sSLSocketFactory.createSocket();
/* 113 */     sSLSocket2.connect(new InetSocketAddress(paramInetAddress, paramInt), SysProperties.SOCKET_CONNECT_TIMEOUT);
/*     */     
/* 115 */     sSLSocket2.setEnabledProtocols(disableSSL(sSLSocket2.getEnabledProtocols()));
/*     */     
/* 117 */     if (SysProperties.ENABLE_ANONYMOUS_TLS) {
/* 118 */       String[] arrayOfString = enableAnonymous(sSLSocket2.getEnabledCipherSuites(), sSLSocket2.getSupportedCipherSuites());
/*     */ 
/*     */       
/* 121 */       sSLSocket2.setEnabledCipherSuites(arrayOfString);
/*     */     } 
/* 123 */     sSLSocket1 = sSLSocket2;
/* 124 */     return sSLSocket1;
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
/*     */   public static ServerSocket createServerSocket(int paramInt, InetAddress paramInetAddress) throws IOException {
/* 143 */     SSLServerSocket sSLServerSocket2, sSLServerSocket1 = null;
/* 144 */     if (SysProperties.ENABLE_ANONYMOUS_TLS) {
/* 145 */       removeAnonFromLegacyAlgorithms();
/*     */     }
/* 147 */     setKeystore();
/* 148 */     ServerSocketFactory serverSocketFactory = SSLServerSocketFactory.getDefault();
/*     */     
/* 150 */     if (paramInetAddress == null) {
/* 151 */       sSLServerSocket2 = (SSLServerSocket)serverSocketFactory.createServerSocket(paramInt);
/*     */     } else {
/* 153 */       sSLServerSocket2 = (SSLServerSocket)serverSocketFactory.createServerSocket(paramInt, 0, paramInetAddress);
/*     */     } 
/* 155 */     sSLServerSocket2.setEnabledProtocols(disableSSL(sSLServerSocket2.getEnabledProtocols()));
/*     */     
/* 157 */     if (SysProperties.ENABLE_ANONYMOUS_TLS) {
/* 158 */       String[] arrayOfString = enableAnonymous(sSLServerSocket2.getEnabledCipherSuites(), sSLServerSocket2.getSupportedCipherSuites());
/*     */ 
/*     */       
/* 161 */       sSLServerSocket2.setEnabledCipherSuites(arrayOfString);
/*     */     } 
/*     */     
/* 164 */     sSLServerSocket1 = sSLServerSocket2;
/* 165 */     return sSLServerSocket1;
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
/*     */   public static String removeDhAnonFromCommaSeparatedList(String paramString) {
/* 177 */     if (paramString == null) {
/* 178 */       return paramString;
/*     */     }
/* 180 */     LinkedList linkedList = new LinkedList(Arrays.asList((Object[])paramString.split("\\s*,\\s*")));
/* 181 */     boolean bool1 = linkedList.remove("DH_anon");
/* 182 */     boolean bool2 = linkedList.remove("ECDH_anon");
/* 183 */     if (bool1 || bool2) {
/* 184 */       String str = Arrays.toString(linkedList.toArray((Object[])new String[linkedList.size()]));
/* 185 */       return (linkedList.size() > 0) ? str.substring(1, str.length() - 1) : "";
/*     */     } 
/* 187 */     return paramString;
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
/*     */   public static synchronized void removeAnonFromLegacyAlgorithms() {
/* 206 */     String str1 = getLegacyAlgorithmsSilently();
/* 207 */     if (str1 == null) {
/*     */       return;
/*     */     }
/* 210 */     String str2 = removeDhAnonFromCommaSeparatedList(str1);
/* 211 */     if (!str1.equals(str2)) {
/* 212 */       setLegacyAlgorithmsSilently(str2);
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
/*     */   
/*     */   public static synchronized void resetDefaultLegacyAlgorithms() {
/* 226 */     setLegacyAlgorithmsSilently(DEFAULT_LEGACY_ALGORITHMS);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getLegacyAlgorithmsSilently() {
/* 237 */     String str = null;
/*     */     try {
/* 239 */       str = Security.getProperty("jdk.tls.legacyAlgorithms");
/* 240 */     } catch (SecurityException securityException) {}
/*     */ 
/*     */     
/* 243 */     return str;
/*     */   }
/*     */   
/*     */   private static void setLegacyAlgorithmsSilently(String paramString) {
/* 247 */     if (paramString == null) {
/*     */       return;
/*     */     }
/*     */     try {
/* 251 */       Security.setProperty("jdk.tls.legacyAlgorithms", paramString);
/* 252 */     } catch (SecurityException securityException) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static byte[] getKeyStoreBytes(KeyStore paramKeyStore, String paramString) throws IOException {
/* 259 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*     */     try {
/* 261 */       paramKeyStore.store(byteArrayOutputStream, paramString.toCharArray());
/* 262 */     } catch (Exception exception) {
/* 263 */       throw DbException.convertToIOException(exception);
/*     */     } 
/* 265 */     return byteArrayOutputStream.toByteArray();
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
/*     */   public static KeyStore getKeyStore(String paramString) throws IOException {
/*     */     try {
/* 284 */       KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
/*     */       
/* 286 */       keyStore.load(null, paramString.toCharArray());
/* 287 */       KeyFactory keyFactory = KeyFactory.getInstance("RSA");
/* 288 */       keyStore.load(null, paramString.toCharArray());
/* 289 */       PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(StringUtils.convertHexToBytes("30820277020100300d06092a864886f70d0101010500048202613082025d02010002818100dc0a13c602b7141110eade2f051b54777b060d0f74e6a110f9cce81159f271ebc88d8e8aa1f743b505fc2e7dfe38d33b8d3f64d1b363d1af4d877833897954cbaec2fa384c22a415498cf306bb07ac09b76b001cd68bf77ea0a628f5101959cf2993a9c23dbee79b19305977f8715ae78d023471194cc900b231eecb0aaea98d02030100010281810099aa4ff4d0a09a5af0bd953cb10c4d08c3d98df565664ac5582e494314d5c3c92dddedd5d316a32a206be4ec084616fe57be15e27cad111aa3c21fa79e32258c6ca8430afc69eddd52d3b751b37da6b6860910b94653192c0db1d02abcfd6ce14c01f238eec7c20bd3bb750940004bacba2880349a9494d10e139ecb2355d101024100ffdc3defd9c05a2d377ef6019fa62b3fbd5b0020a04cc8533bca730e1f6fcf5dfceea1b044fbe17d9eababfbc7d955edad6bc60f9be826ad2c22ba77d19a9f65024100dc28d43fdbbc93852cc3567093157702bc16f156f709fb7db0d9eec028f41fd0edcd17224c866e66be1744141fb724a10fd741c8a96afdd9141b36d67fff6309024077b1cddbde0f69604bdcfe33263fb36ddf24aa3b9922327915b890f8a36648295d0139ecdf68c245652c4489c6257b58744fbdd961834a4cab201801a3b1e52d024100b17142e8991d1b350a0802624759d48ae2b8071a158ff91fabeb6a8f7c328e762143dc726b8529f42b1fab6220d1c676fdc27ba5d44e847c72c52064afd351a902407c6e23fe35bcfcd1a662aa82a2aa725fcece311644d5b6e3894853fd4ce9fe78218c957b1ff03fc9e5ef8ffeb6bd58235f6a215c97d354fdace7e781e4a63e8b"));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 323 */       PrivateKey privateKey = keyFactory.generatePrivate(pKCS8EncodedKeySpec);
/* 324 */       Certificate[] arrayOfCertificate = { CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(StringUtils.convertHexToBytes("3082018b3081f502044295ce6b300d06092a864886f70d0101040500300d310b3009060355040313024832301e170d3035303532363133323630335a170d3337303933303036353734375a300d310b300906035504031302483230819f300d06092a864886f70d010101050003818d0030818902818100dc0a13c602b7141110eade2f051b54777b060d0f74e6a110f9cce81159f271ebc88d8e8aa1f743b505fc2e7dfe38d33b8d3f64d1b363d1af4d877833897954cbaec2fa384c22a415498cf306bb07ac09b76b001cd68bf77ea0a628f5101959cf2993a9c23dbee79b19305977f8715ae78d023471194cc900b231eecb0aaea98d0203010001300d06092a864886f70d01010405000381810083f4401a279453701bef9a7681a5b8b24f153f7d18c7c892133d97bd5f13736be7505290a445a7d5ceb75522403e5097515cd966ded6351ff60d5193de34cd36e5cb04d380398e66286f99923fd92296645fd4ada45844d194dfd815e6cd57f385c117be982809028bba1116c85740b3d27a55b1a0948bf291ddba44bed337b9"))) };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 349 */       keyStore.setKeyEntry("h2", privateKey, paramString.toCharArray(), arrayOfCertificate);
/*     */       
/* 351 */       return keyStore;
/* 352 */     } catch (Exception exception) {
/* 353 */       throw DbException.convertToIOException(exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void setKeystore() throws IOException {
/* 358 */     Properties properties = System.getProperties();
/* 359 */     if (properties.getProperty("javax.net.ssl.keyStore") == null) {
/* 360 */       String str1 = "~/.h2.keystore";
/* 361 */       byte[] arrayOfByte = getKeyStoreBytes(getKeyStore("h2pass"), "h2pass");
/*     */       
/* 363 */       boolean bool = true;
/* 364 */       if (FileUtils.exists(str1) && FileUtils.size(str1) == arrayOfByte.length) {
/*     */         
/* 366 */         InputStream inputStream = FileUtils.newInputStream(str1);
/* 367 */         byte[] arrayOfByte1 = IOUtils.readBytesAndClose(inputStream, 0);
/* 368 */         if (arrayOfByte1 != null && Arrays.equals(arrayOfByte, arrayOfByte1)) {
/* 369 */           bool = false;
/*     */         }
/*     */       } 
/* 372 */       if (bool) {
/*     */         try {
/* 374 */           OutputStream outputStream = FileUtils.newOutputStream(str1, false);
/* 375 */           outputStream.write(arrayOfByte);
/* 376 */           outputStream.close();
/* 377 */         } catch (Exception exception) {
/* 378 */           throw DbException.convertToIOException(exception);
/*     */         } 
/*     */       }
/* 381 */       String str2 = FileUtils.toRealPath(str1);
/* 382 */       System.setProperty("javax.net.ssl.keyStore", str2);
/*     */     } 
/* 384 */     if (properties.getProperty("javax.net.ssl.keyStorePassword") == null) {
/* 385 */       System.setProperty("javax.net.ssl.keyStorePassword", "h2pass");
/*     */     }
/*     */   }
/*     */   
/*     */   private static String[] enableAnonymous(String[] paramArrayOfString1, String[] paramArrayOfString2) {
/* 390 */     LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
/* 391 */     for (String str : paramArrayOfString2) {
/* 392 */       if (!str.startsWith("SSL") && str.indexOf("_anon_") >= 0 && (str.indexOf("_AES_") >= 0 || str.indexOf("_3DES_") >= 0) && str.indexOf("_SHA") >= 0)
/*     */       {
/*     */ 
/*     */         
/* 396 */         linkedHashSet.add(str);
/*     */       }
/*     */     } 
/* 399 */     Collections.addAll(linkedHashSet, paramArrayOfString1);
/* 400 */     return (String[])linkedHashSet.toArray((Object[])new String[0]);
/*     */   }
/*     */   
/*     */   private static String[] disableSSL(String[] paramArrayOfString) {
/* 404 */     HashSet<String> hashSet = new HashSet();
/* 405 */     for (String str : paramArrayOfString) {
/* 406 */       if (!str.startsWith("SSL")) {
/* 407 */         hashSet.add(str);
/*     */       }
/*     */     } 
/* 410 */     return (String[])hashSet.toArray((Object[])new String[0]);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\security\CipherFactory.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */