/*     */ package org.apache.commons.net.pop3;
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
/*     */ public class POP3SClient
/*     */   extends POP3Client
/*     */ {
/*     */   private static final int DEFAULT_POP3S_PORT = 995;
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
/*     */   public POP3SClient() {
/*  99 */     this("TLS", false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public POP3SClient(boolean paramBoolean) {
/* 108 */     this("TLS", paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public POP3SClient(String paramString) {
/* 118 */     this(paramString, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public POP3SClient(String paramString, boolean paramBoolean) {
/* 128 */     this(paramString, paramBoolean, (SSLContext)null);
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
/*     */   public POP3SClient(String paramString, boolean paramBoolean, SSLContext paramSSLContext) {
/* 140 */     this.protocol = paramString;
/* 141 */     this.isImplicit = paramBoolean;
/* 142 */     this.context = paramSSLContext;
/* 143 */     if (this.isImplicit) {
/* 144 */       setDefaultPort(995);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public POP3SClient(boolean paramBoolean, SSLContext paramSSLContext) {
/* 155 */     this("TLS", paramBoolean, paramSSLContext);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public POP3SClient(SSLContext paramSSLContext) {
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
/*     */     
/* 221 */     if (this.protocols != null) {
/* 222 */       sSLSocket.setEnabledProtocols(this.protocols);
/*     */     }
/* 224 */     if (this.suites != null) {
/* 225 */       sSLSocket.setEnabledCipherSuites(this.suites);
/*     */     }
/* 227 */     sSLSocket.startHandshake();
/*     */ 
/*     */     
/* 230 */     this._socket_ = sSLSocket;
/* 231 */     this._input_ = sSLSocket.getInputStream();
/* 232 */     this._output_ = sSLSocket.getOutputStream();
/* 233 */     this.reader = (BufferedReader)new CRLFLineReader(new InputStreamReader(this._input_, DEFAULT_ENCODING));
/* 234 */     this.writer = new BufferedWriter(new OutputStreamWriter(this._output_, DEFAULT_ENCODING));
/*     */     
/* 236 */     if (this.hostnameVerifier != null && !this.hostnameVerifier.verify(str, sSLSocket.getSession())) {
/* 237 */       throw new SSLHandshakeException("Hostname doesn't match certificate");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private KeyManager getKeyManager() {
/* 247 */     return this.keyManager;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKeyManager(KeyManager paramKeyManager) {
/* 257 */     this.keyManager = paramKeyManager;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEnabledCipherSuites(String[] paramArrayOfString) {
/* 267 */     this.suites = (String[])paramArrayOfString.clone();
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
/* 278 */     if (this._socket_ instanceof SSLSocket)
/*     */     {
/* 280 */       return ((SSLSocket)this._socket_).getEnabledCipherSuites();
/*     */     }
/* 282 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEnabledProtocols(String[] paramArrayOfString) {
/* 292 */     this.protocols = (String[])paramArrayOfString.clone();
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
/* 303 */     if (this._socket_ instanceof SSLSocket)
/*     */     {
/* 305 */       return ((SSLSocket)this._socket_).getEnabledProtocols();
/*     */     }
/* 307 */     return null;
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
/* 319 */     if (sendCommand("STLS") != 0)
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


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\pop3\POP3SClient.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */