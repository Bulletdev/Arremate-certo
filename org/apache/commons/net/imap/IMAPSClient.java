/*     */ package org.apache.commons.net.imap;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStreamWriter;
/*     */ import javax.net.ssl.HostnameVerifier;
/*     */ import javax.net.ssl.KeyManager;
/*     */ import javax.net.ssl.SSLContext;
/*     */ import javax.net.ssl.SSLException;
/*     */ import javax.net.ssl.SSLHandshakeException;
/*     */ import javax.net.ssl.SSLSocket;
/*     */ import javax.net.ssl.SSLSocketFactory;
/*     */ import javax.net.ssl.TrustManager;
/*     */ import org.apache.commons.net.io.CRLFLineReader;
/*     */ import org.apache.commons.net.util.SSLContextUtils;
/*     */ import org.apache.commons.net.util.SSLSocketUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IMAPSClient
/*     */   extends IMAPClient
/*     */ {
/*     */   public static final int DEFAULT_IMAPS_PORT = 993;
/*     */   public static final String DEFAULT_PROTOCOL = "TLS";
/*     */   private final boolean isImplicit;
/*     */   private final String protocol;
/*     */   private SSLContext context;
/*     */   private String[] suites;
/*     */   private String[] protocols;
/*     */   private TrustManager trustManager;
/*     */   private KeyManager keyManager;
/*     */   private HostnameVerifier hostnameVerifier;
/*     */   private boolean tlsEndpointChecking;
/*     */   
/*     */   public IMAPSClient() {
/* 104 */     this("TLS", false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IMAPSClient(boolean paramBoolean) {
/* 113 */     this("TLS", paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IMAPSClient(String paramString) {
/* 122 */     this(paramString, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IMAPSClient(String paramString, boolean paramBoolean) {
/* 132 */     this(paramString, paramBoolean, (SSLContext)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IMAPSClient(String paramString, boolean paramBoolean, SSLContext paramSSLContext) {
/* 143 */     setDefaultPort(993);
/* 144 */     this.protocol = paramString;
/* 145 */     this.isImplicit = paramBoolean;
/* 146 */     this.context = paramSSLContext;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IMAPSClient(boolean paramBoolean, SSLContext paramSSLContext) {
/* 156 */     this("TLS", paramBoolean, paramSSLContext);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IMAPSClient(SSLContext paramSSLContext) {
/* 165 */     this(false, paramSSLContext);
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
/* 180 */     if (this.isImplicit) {
/* 181 */       performSSLNegotiation();
/*     */     }
/* 183 */     super._connectAction_();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void initSSLContext() throws IOException {
/* 193 */     if (this.context == null)
/*     */     {
/* 195 */       this.context = SSLContextUtils.createSSLContext(this.protocol, getKeyManager(), getTrustManager());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void performSSLNegotiation() throws IOException {
/* 206 */     initSSLContext();
/*     */     
/* 208 */     SSLSocketFactory sSLSocketFactory = this.context.getSocketFactory();
/* 209 */     String str = (this._hostname_ != null) ? this._hostname_ : getRemoteAddress().getHostAddress();
/* 210 */     int i = getRemotePort();
/*     */     
/* 212 */     SSLSocket sSLSocket = (SSLSocket)sSLSocketFactory.createSocket(this._socket_, str, i, true);
/* 213 */     sSLSocket.setEnableSessionCreation(true);
/* 214 */     sSLSocket.setUseClientMode(true);
/*     */     
/* 216 */     if (this.tlsEndpointChecking) {
/* 217 */       SSLSocketUtils.enableEndpointNameVerification(sSLSocket);
/*     */     }
/*     */     
/* 220 */     if (this.protocols != null) {
/* 221 */       sSLSocket.setEnabledProtocols(this.protocols);
/*     */     }
/* 223 */     if (this.suites != null) {
/* 224 */       sSLSocket.setEnabledCipherSuites(this.suites);
/*     */     }
/* 226 */     sSLSocket.startHandshake();
/*     */ 
/*     */     
/* 229 */     this._socket_ = sSLSocket;
/* 230 */     this._input_ = sSLSocket.getInputStream();
/* 231 */     this._output_ = sSLSocket.getOutputStream();
/* 232 */     this._reader = (BufferedReader)new CRLFLineReader(new InputStreamReader(this._input_, "ISO-8859-1"));
/*     */ 
/*     */     
/* 235 */     this.__writer = new BufferedWriter(new OutputStreamWriter(this._output_, "ISO-8859-1"));
/*     */ 
/*     */ 
/*     */     
/* 239 */     if (this.hostnameVerifier != null && !this.hostnameVerifier.verify(str, sSLSocket.getSession())) {
/* 240 */       throw new SSLHandshakeException("Hostname doesn't match certificate");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private KeyManager getKeyManager() {
/* 250 */     return this.keyManager;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKeyManager(KeyManager paramKeyManager) {
/* 260 */     this.keyManager = paramKeyManager;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEnabledCipherSuites(String[] paramArrayOfString) {
/* 270 */     this.suites = (String[])paramArrayOfString.clone();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] getEnabledCipherSuites() {
/* 281 */     if (this._socket_ instanceof SSLSocket)
/*     */     {
/* 283 */       return ((SSLSocket)this._socket_).getEnabledCipherSuites();
/*     */     }
/* 285 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEnabledProtocols(String[] paramArrayOfString) {
/* 295 */     this.protocols = (String[])paramArrayOfString.clone();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] getEnabledProtocols() {
/* 306 */     if (this._socket_ instanceof SSLSocket)
/*     */     {
/* 308 */       return ((SSLSocket)this._socket_).getEnabledProtocols();
/*     */     }
/* 310 */     return null;
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
/*     */   public boolean execTLS() throws SSLException, IOException {
/* 322 */     if (sendCommand(IMAPCommand.getCommand(IMAPCommand.STARTTLS)) != 0)
/*     */     {
/* 324 */       return false;
/*     */     }
/*     */     
/* 327 */     performSSLNegotiation();
/* 328 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TrustManager getTrustManager() {
/* 337 */     return this.trustManager;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTrustManager(TrustManager paramTrustManager) {
/* 347 */     this.trustManager = paramTrustManager;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HostnameVerifier getHostnameVerifier() {
/* 357 */     return this.hostnameVerifier;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHostnameVerifier(HostnameVerifier paramHostnameVerifier) {
/* 367 */     this.hostnameVerifier = paramHostnameVerifier;
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
/*     */   public boolean isEndpointCheckingEnabled() {
/* 379 */     return this.tlsEndpointChecking;
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
/*     */   public void setEndpointCheckingEnabled(boolean paramBoolean) {
/* 391 */     this.tlsEndpointChecking = paramBoolean;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\imap\IMAPSClient.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */