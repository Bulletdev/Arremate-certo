/*     */ package org.apache.commons.net.smtp;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStreamWriter;
/*     */ import javax.net.ssl.HostnameVerifier;
/*     */ import javax.net.ssl.KeyManager;
/*     */ import javax.net.ssl.SSLContext;
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
/*     */ public class SMTPSClient
/*     */   extends SMTPClient
/*     */ {
/*     */   private static final String DEFAULT_PROTOCOL = "TLS";
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
/*     */   public SMTPSClient() {
/* 100 */     this("TLS", false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SMTPSClient(boolean paramBoolean) {
/* 109 */     this("TLS", paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SMTPSClient(String paramString) {
/* 118 */     this(paramString, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SMTPSClient(String paramString, boolean paramBoolean) {
/* 128 */     this.protocol = paramString;
/* 129 */     this.isImplicit = paramBoolean;
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
/*     */   public SMTPSClient(String paramString1, boolean paramBoolean, String paramString2) {
/* 141 */     super(paramString2);
/* 142 */     this.protocol = paramString1;
/* 143 */     this.isImplicit = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SMTPSClient(boolean paramBoolean, SSLContext paramSSLContext) {
/* 153 */     this.isImplicit = paramBoolean;
/* 154 */     this.context = paramSSLContext;
/* 155 */     this.protocol = "TLS";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SMTPSClient(SSLContext paramSSLContext) {
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
/* 181 */       applySocketAttributes();
/* 182 */       performSSLNegotiation();
/*     */     } 
/* 184 */     super._connectAction_();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void initSSLContext() throws IOException {
/* 194 */     if (this.context == null)
/*     */     {
/* 196 */       this.context = SSLContextUtils.createSSLContext(this.protocol, getKeyManager(), getTrustManager());
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
/* 207 */     initSSLContext();
/*     */     
/* 209 */     SSLSocketFactory sSLSocketFactory = this.context.getSocketFactory();
/* 210 */     String str = (this._hostname_ != null) ? this._hostname_ : getRemoteAddress().getHostAddress();
/* 211 */     int i = getRemotePort();
/*     */     
/* 213 */     SSLSocket sSLSocket = (SSLSocket)sSLSocketFactory.createSocket(this._socket_, str, i, true);
/* 214 */     sSLSocket.setEnableSessionCreation(true);
/* 215 */     sSLSocket.setUseClientMode(true);
/*     */     
/* 217 */     if (this.tlsEndpointChecking) {
/* 218 */       SSLSocketUtils.enableEndpointNameVerification(sSLSocket);
/*     */     }
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
/* 232 */     this.reader = (BufferedReader)new CRLFLineReader(new InputStreamReader(this._input_, this.encoding));
/*     */     
/* 234 */     this.writer = new BufferedWriter(new OutputStreamWriter(this._output_, this.encoding));
/*     */ 
/*     */     
/* 237 */     if (this.hostnameVerifier != null && !this.hostnameVerifier.verify(str, sSLSocket.getSession())) {
/* 238 */       throw new SSLHandshakeException("Hostname doesn't match certificate");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public KeyManager getKeyManager() {
/* 248 */     return this.keyManager;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKeyManager(KeyManager paramKeyManager) {
/* 258 */     this.keyManager = paramKeyManager;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEnabledCipherSuites(String[] paramArrayOfString) {
/* 268 */     this.suites = (String[])paramArrayOfString.clone();
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
/* 279 */     if (this._socket_ instanceof SSLSocket)
/*     */     {
/* 281 */       return ((SSLSocket)this._socket_).getEnabledCipherSuites();
/*     */     }
/* 283 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEnabledProtocols(String[] paramArrayOfString) {
/* 293 */     this.protocols = (String[])paramArrayOfString.clone();
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
/* 304 */     if (this._socket_ instanceof SSLSocket)
/*     */     {
/* 306 */       return ((SSLSocket)this._socket_).getEnabledProtocols();
/*     */     }
/* 308 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean execTLS() throws IOException {
/* 319 */     if (!SMTPReply.isPositiveCompletion(sendCommand("STARTTLS")))
/*     */     {
/* 321 */       return false;
/*     */     }
/*     */     
/* 324 */     performSSLNegotiation();
/* 325 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TrustManager getTrustManager() {
/* 334 */     return this.trustManager;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTrustManager(TrustManager paramTrustManager) {
/* 344 */     this.trustManager = paramTrustManager;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HostnameVerifier getHostnameVerifier() {
/* 354 */     return this.hostnameVerifier;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHostnameVerifier(HostnameVerifier paramHostnameVerifier) {
/* 364 */     this.hostnameVerifier = paramHostnameVerifier;
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
/* 376 */     return this.tlsEndpointChecking;
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
/* 388 */     this.tlsEndpointChecking = paramBoolean;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\smtp\SMTPSClient.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */