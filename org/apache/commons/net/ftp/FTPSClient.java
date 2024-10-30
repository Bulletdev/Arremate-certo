/*     */ package org.apache.commons.net.ftp;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.net.Socket;
/*     */ import javax.net.ssl.HostnameVerifier;
/*     */ import javax.net.ssl.KeyManager;
/*     */ import javax.net.ssl.SSLContext;
/*     */ import javax.net.ssl.SSLException;
/*     */ import javax.net.ssl.SSLHandshakeException;
/*     */ import javax.net.ssl.SSLSocket;
/*     */ import javax.net.ssl.SSLSocketFactory;
/*     */ import javax.net.ssl.TrustManager;
/*     */ import org.apache.commons.net.util.Base64;
/*     */ import org.apache.commons.net.util.SSLContextUtils;
/*     */ import org.apache.commons.net.util.SSLSocketUtils;
/*     */ import org.apache.commons.net.util.TrustManagerUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FTPSClient
/*     */   extends FTPClient
/*     */ {
/*     */   public static final int DEFAULT_FTPS_DATA_PORT = 989;
/*     */   public static final int DEFAULT_FTPS_PORT = 990;
/*  63 */   private static final String[] PROT_COMMAND_VALUE = new String[] { "C", "E", "S", "P" };
/*     */ 
/*     */   
/*     */   private static final String DEFAULT_PROT = "C";
/*     */ 
/*     */   
/*     */   private static final String DEFAULT_PROTOCOL = "TLS";
/*     */   
/*     */   private static final String CMD_AUTH = "AUTH";
/*     */   
/*     */   private static final String CMD_ADAT = "ADAT";
/*     */   
/*     */   private static final String CMD_PROT = "PROT";
/*     */   
/*     */   private static final String CMD_PBSZ = "PBSZ";
/*     */   
/*     */   private static final String CMD_MIC = "MIC";
/*     */   
/*     */   private static final String CMD_CONF = "CONF";
/*     */   
/*     */   private static final String CMD_ENC = "ENC";
/*     */   
/*     */   private static final String CMD_CCC = "CCC";
/*     */   
/*     */   private final boolean isImplicit;
/*     */   
/*     */   private final String protocol;
/*     */   
/*  91 */   private String auth = "TLS";
/*     */ 
/*     */   
/*     */   private SSLContext context;
/*     */ 
/*     */   
/*     */   private Socket plainSocket;
/*     */ 
/*     */   
/*     */   private boolean isCreation = true;
/*     */   
/*     */   private boolean isClientMode = true;
/*     */   
/*     */   private boolean isNeedClientAuth;
/*     */   
/*     */   private boolean isWantClientAuth;
/*     */   
/*     */   private String[] suites;
/*     */   
/*     */   private String[] protocols;
/*     */   
/* 112 */   private TrustManager trustManager = TrustManagerUtils.getValidateServerCertificateTrustManager();
/*     */   
/*     */   private KeyManager keyManager;
/*     */   
/*     */   private HostnameVerifier hostnameVerifier;
/*     */   
/*     */   private boolean tlsEndpointChecking;
/*     */   @Deprecated
/*     */   public static String KEYSTORE_ALGORITHM;
/*     */   @Deprecated
/*     */   public static String TRUSTSTORE_ALGORITHM;
/*     */   @Deprecated
/*     */   public static String PROVIDER;
/*     */   @Deprecated
/*     */   public static String STORE_TYPE;
/*     */   
/*     */   public FTPSClient() {
/* 129 */     this("TLS", false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FTPSClient(boolean paramBoolean) {
/* 138 */     this("TLS", paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FTPSClient(String paramString) {
/* 147 */     this(paramString, false);
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
/*     */   public FTPSClient(String paramString, boolean paramBoolean) {
/* 159 */     this.protocol = paramString;
/* 160 */     this.isImplicit = paramBoolean;
/* 161 */     if (paramBoolean) {
/* 162 */       setDefaultPort(990);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FTPSClient(boolean paramBoolean, SSLContext paramSSLContext) {
/* 173 */     this("TLS", paramBoolean);
/* 174 */     this.context = paramSSLContext;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FTPSClient(SSLContext paramSSLContext) {
/* 184 */     this(false, paramSSLContext);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAuthValue(String paramString) {
/* 194 */     this.auth = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAuthValue() {
/* 202 */     return this.auth;
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
/*     */   protected void _connectAction_() throws IOException {
/* 217 */     if (this.isImplicit) {
/* 218 */       applySocketAttributes();
/* 219 */       sslNegotiation();
/*     */     } 
/* 221 */     super._connectAction_();
/*     */     
/* 223 */     if (!this.isImplicit) {
/* 224 */       execAUTH();
/* 225 */       sslNegotiation();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void execAUTH() throws SSLException, IOException {
/* 236 */     int i = sendCommand("AUTH", this.auth);
/* 237 */     if (334 != i)
/*     */     {
/*     */       
/* 240 */       if (234 != i) {
/* 241 */         throw new SSLException(getReplyString());
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void initSslContext() throws IOException {
/* 250 */     if (this.context == null) {
/* 251 */       this.context = SSLContextUtils.createSSLContext(this.protocol, getKeyManager(), getTrustManager());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void sslNegotiation() throws IOException {
/* 261 */     this.plainSocket = this._socket_;
/* 262 */     initSslContext();
/* 263 */     SSLSocket sSLSocket = createSSLSocket(this._socket_);
/* 264 */     sSLSocket.setEnableSessionCreation(this.isCreation);
/* 265 */     sSLSocket.setUseClientMode(this.isClientMode);
/*     */ 
/*     */     
/* 268 */     if (this.isClientMode) {
/* 269 */       if (this.tlsEndpointChecking) {
/* 270 */         SSLSocketUtils.enableEndpointNameVerification(sSLSocket);
/*     */       }
/*     */     } else {
/* 273 */       sSLSocket.setNeedClientAuth(this.isNeedClientAuth);
/* 274 */       sSLSocket.setWantClientAuth(this.isWantClientAuth);
/*     */     } 
/*     */     
/* 277 */     if (this.protocols != null) {
/* 278 */       sSLSocket.setEnabledProtocols(this.protocols);
/*     */     }
/* 280 */     if (this.suites != null) {
/* 281 */       sSLSocket.setEnabledCipherSuites(this.suites);
/*     */     }
/* 283 */     sSLSocket.startHandshake();
/*     */ 
/*     */     
/* 286 */     this._socket_ = sSLSocket;
/* 287 */     this
/* 288 */       ._controlInput_ = new BufferedReader(new InputStreamReader(sSLSocket.getInputStream(), getControlEncoding()));
/* 289 */     this
/* 290 */       ._controlOutput_ = new BufferedWriter(new OutputStreamWriter(sSLSocket.getOutputStream(), getControlEncoding()));
/*     */     
/* 292 */     if (this.isClientMode && 
/* 293 */       this.hostnameVerifier != null && 
/* 294 */       !this.hostnameVerifier.verify(this._hostname_, sSLSocket.getSession())) {
/* 295 */       throw new SSLHandshakeException("Hostname doesn't match certificate");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private KeyManager getKeyManager() {
/* 305 */     return this.keyManager;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKeyManager(KeyManager paramKeyManager) {
/* 315 */     this.keyManager = paramKeyManager;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEnabledSessionCreation(boolean paramBoolean) {
/* 323 */     this.isCreation = paramBoolean;
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
/*     */   public boolean getEnableSessionCreation() {
/* 336 */     if (this._socket_ instanceof SSLSocket) {
/* 337 */       return ((SSLSocket)this._socket_).getEnableSessionCreation();
/*     */     }
/* 339 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNeedClientAuth(boolean paramBoolean) {
/* 347 */     this.isNeedClientAuth = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getNeedClientAuth() {
/* 357 */     if (this._socket_ instanceof SSLSocket) {
/* 358 */       return ((SSLSocket)this._socket_).getNeedClientAuth();
/*     */     }
/* 360 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWantClientAuth(boolean paramBoolean) {
/* 370 */     this.isWantClientAuth = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getWantClientAuth() {
/* 380 */     if (this._socket_ instanceof SSLSocket) {
/* 381 */       return ((SSLSocket)this._socket_).getWantClientAuth();
/*     */     }
/* 383 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUseClientMode(boolean paramBoolean) {
/* 392 */     this.isClientMode = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getUseClientMode() {
/* 403 */     if (this._socket_ instanceof SSLSocket) {
/* 404 */       return ((SSLSocket)this._socket_).getUseClientMode();
/*     */     }
/* 406 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEnabledCipherSuites(String[] paramArrayOfString) {
/* 415 */     this.suites = (String[])paramArrayOfString.clone();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] getEnabledCipherSuites() {
/* 425 */     if (this._socket_ instanceof SSLSocket) {
/* 426 */       return ((SSLSocket)this._socket_).getEnabledCipherSuites();
/*     */     }
/* 428 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEnabledProtocols(String[] paramArrayOfString) {
/* 437 */     this.protocols = (String[])paramArrayOfString.clone();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] getEnabledProtocols() {
/* 447 */     if (this._socket_ instanceof SSLSocket) {
/* 448 */       return ((SSLSocket)this._socket_).getEnabledProtocols();
/*     */     }
/* 450 */     return null;
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
/*     */   public void execPBSZ(long paramLong) throws SSLException, IOException {
/* 462 */     if (paramLong < 0L || 4294967295L < paramLong) {
/* 463 */       throw new IllegalArgumentException();
/*     */     }
/* 465 */     int i = sendCommand("PBSZ", String.valueOf(paramLong));
/* 466 */     if (200 != i) {
/* 467 */       throw new SSLException(getReplyString());
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
/*     */ 
/*     */ 
/*     */   
/*     */   public long parsePBSZ(long paramLong) throws SSLException, IOException {
/* 484 */     execPBSZ(paramLong);
/* 485 */     long l = paramLong;
/* 486 */     String str = extractPrefixedData("PBSZ=", getReplyString());
/* 487 */     if (str != null) {
/* 488 */       long l1 = Long.parseLong(str);
/* 489 */       if (l1 < l) {
/* 490 */         l = l1;
/*     */       }
/*     */     } 
/* 493 */     return l;
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
/*     */   public void execPROT(String paramString) throws SSLException, IOException {
/* 514 */     if (paramString == null) {
/* 515 */       paramString = "C";
/*     */     }
/* 517 */     if (!checkPROTValue(paramString)) {
/* 518 */       throw new IllegalArgumentException();
/*     */     }
/* 520 */     if (200 != sendCommand("PROT", paramString)) {
/* 521 */       throw new SSLException(getReplyString());
/*     */     }
/* 523 */     if ("C".equals(paramString)) {
/* 524 */       setSocketFactory(null);
/* 525 */       setServerSocketFactory(null);
/*     */     } else {
/* 527 */       setSocketFactory(new FTPSSocketFactory(this.context));
/* 528 */       setServerSocketFactory(new FTPSServerSocketFactory(this.context));
/* 529 */       initSslContext();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean checkPROTValue(String paramString) {
/* 539 */     for (String str : PROT_COMMAND_VALUE) {
/*     */       
/* 541 */       if (str.equals(paramString)) {
/* 542 */         return true;
/*     */       }
/*     */     } 
/* 545 */     return false;
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
/*     */   public int sendCommand(String paramString1, String paramString2) throws IOException {
/* 561 */     int i = super.sendCommand(paramString1, paramString2);
/*     */     
/* 563 */     if ("CCC".equals(paramString1)) {
/* 564 */       if (200 == i) {
/* 565 */         this._socket_.close();
/* 566 */         this._socket_ = this.plainSocket;
/* 567 */         this
/*     */           
/* 569 */           ._controlInput_ = new BufferedReader(new InputStreamReader(this._socket_.getInputStream(), getControlEncoding()));
/* 570 */         this
/*     */           
/* 572 */           ._controlOutput_ = new BufferedWriter(new OutputStreamWriter(this._socket_.getOutputStream(), getControlEncoding()));
/*     */       } else {
/* 574 */         throw new SSLException(getReplyString());
/*     */       } 
/*     */     }
/* 577 */     return i;
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
/*     */   @Deprecated
/*     */   protected Socket _openDataConnection_(int paramInt, String paramString) throws IOException {
/* 600 */     return _openDataConnection_(FTPCommand.getCommand(paramInt), paramString);
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
/*     */   protected Socket _openDataConnection_(String paramString1, String paramString2) throws IOException {
/* 620 */     Socket socket = super._openDataConnection_(paramString1, paramString2);
/* 621 */     _prepareDataSocket_(socket);
/* 622 */     if (socket instanceof SSLSocket) {
/* 623 */       SSLSocket sSLSocket = (SSLSocket)socket;
/*     */       
/* 625 */       sSLSocket.setUseClientMode(this.isClientMode);
/* 626 */       sSLSocket.setEnableSessionCreation(this.isCreation);
/*     */ 
/*     */       
/* 629 */       if (!this.isClientMode) {
/* 630 */         sSLSocket.setNeedClientAuth(this.isNeedClientAuth);
/* 631 */         sSLSocket.setWantClientAuth(this.isWantClientAuth);
/*     */       } 
/* 633 */       if (this.suites != null) {
/* 634 */         sSLSocket.setEnabledCipherSuites(this.suites);
/*     */       }
/* 636 */       if (this.protocols != null) {
/* 637 */         sSLSocket.setEnabledProtocols(this.protocols);
/*     */       }
/* 639 */       sSLSocket.startHandshake();
/*     */     } 
/*     */     
/* 642 */     return socket;
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
/*     */   protected void _prepareDataSocket_(Socket paramSocket) throws IOException {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TrustManager getTrustManager() {
/* 665 */     return this.trustManager;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTrustManager(TrustManager paramTrustManager) {
/* 676 */     this.trustManager = paramTrustManager;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HostnameVerifier getHostnameVerifier() {
/* 687 */     return this.hostnameVerifier;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHostnameVerifier(HostnameVerifier paramHostnameVerifier) {
/* 698 */     this.hostnameVerifier = paramHostnameVerifier;
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
/*     */   public boolean isEndpointCheckingEnabled() {
/* 712 */     return this.tlsEndpointChecking;
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
/*     */   public void setEndpointCheckingEnabled(boolean paramBoolean) {
/* 726 */     this.tlsEndpointChecking = paramBoolean;
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
/*     */   public void disconnect() throws IOException {
/* 742 */     super.disconnect();
/* 743 */     if (this.plainSocket != null) {
/* 744 */       this.plainSocket.close();
/*     */     }
/* 746 */     setSocketFactory(null);
/* 747 */     setServerSocketFactory(null);
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
/*     */   public int execAUTH(String paramString) throws IOException {
/* 760 */     return sendCommand("AUTH", paramString);
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
/*     */   public int execADAT(byte[] paramArrayOfbyte) throws IOException {
/* 773 */     if (paramArrayOfbyte != null)
/*     */     {
/* 775 */       return sendCommand("ADAT", Base64.encodeBase64StringUnChunked(paramArrayOfbyte));
/*     */     }
/* 777 */     return sendCommand("ADAT");
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
/*     */   public int execCCC() throws IOException {
/* 791 */     return sendCommand("CCC");
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
/*     */   public int execMIC(byte[] paramArrayOfbyte) throws IOException {
/* 816 */     if (paramArrayOfbyte != null)
/*     */     {
/* 818 */       return sendCommand("MIC", Base64.encodeBase64StringUnChunked(paramArrayOfbyte));
/*     */     }
/* 820 */     return sendCommand("MIC", "");
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
/*     */   public int execCONF(byte[] paramArrayOfbyte) throws IOException {
/* 833 */     if (paramArrayOfbyte != null)
/*     */     {
/* 835 */       return sendCommand("CONF", Base64.encodeBase64StringUnChunked(paramArrayOfbyte));
/*     */     }
/* 837 */     return sendCommand("CONF", "");
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
/*     */   public int execENC(byte[] paramArrayOfbyte) throws IOException {
/* 850 */     if (paramArrayOfbyte != null)
/*     */     {
/* 852 */       return sendCommand("ENC", Base64.encodeBase64StringUnChunked(paramArrayOfbyte));
/*     */     }
/* 854 */     return sendCommand("ENC", "");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] parseADATReply(String paramString) {
/* 865 */     if (paramString == null) {
/* 866 */       return null;
/*     */     }
/* 868 */     return Base64.decodeBase64(extractPrefixedData("ADAT=", paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String extractPrefixedData(String paramString1, String paramString2) {
/* 878 */     int i = paramString2.indexOf(paramString1);
/* 879 */     if (i == -1) {
/* 880 */       return null;
/*     */     }
/*     */     
/* 883 */     return paramString2.substring(i + paramString1.length()).trim();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private SSLSocket createSSLSocket(Socket paramSocket) throws IOException {
/* 894 */     if (paramSocket != null) {
/* 895 */       SSLSocketFactory sSLSocketFactory = this.context.getSocketFactory();
/* 896 */       return (SSLSocket)sSLSocketFactory.createSocket(paramSocket, this._hostname_, paramSocket.getPort(), false);
/*     */     } 
/* 898 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ftp\FTPSClient.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */