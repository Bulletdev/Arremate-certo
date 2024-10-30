/*     */ package org.apache.http.impl.pool;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.net.InetSocketAddress;
/*     */ import java.net.Socket;
/*     */ import java.security.AccessController;
/*     */ import java.security.PrivilegedActionException;
/*     */ import java.security.PrivilegedExceptionAction;
/*     */ import javax.net.SocketFactory;
/*     */ import javax.net.ssl.SSLSocketFactory;
/*     */ import org.apache.http.HttpClientConnection;
/*     */ import org.apache.http.HttpConnectionFactory;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.config.ConnectionConfig;
/*     */ import org.apache.http.config.SocketConfig;
/*     */ import org.apache.http.impl.DefaultBHttpClientConnection;
/*     */ import org.apache.http.impl.DefaultBHttpClientConnectionFactory;
/*     */ import org.apache.http.params.HttpParamConfig;
/*     */ import org.apache.http.params.HttpParams;
/*     */ import org.apache.http.pool.ConnFactory;
/*     */ import org.apache.http.util.Args;
/*     */ import org.apache.http.util.Asserts;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/*     */ public class BasicConnFactory
/*     */   implements ConnFactory<HttpHost, HttpClientConnection>
/*     */ {
/*     */   private final SocketFactory plainfactory;
/*     */   private final SSLSocketFactory sslfactory;
/*     */   private final int connectTimeout;
/*     */   private final SocketConfig sconfig;
/*     */   private final HttpConnectionFactory<? extends HttpClientConnection> connFactory;
/*     */   
/*     */   @Deprecated
/*     */   public BasicConnFactory(SSLSocketFactory paramSSLSocketFactory, HttpParams paramHttpParams) {
/*  80 */     Args.notNull(paramHttpParams, "HTTP params");
/*  81 */     this.plainfactory = null;
/*  82 */     this.sslfactory = paramSSLSocketFactory;
/*  83 */     this.connectTimeout = paramHttpParams.getIntParameter("http.connection.timeout", 0);
/*  84 */     this.sconfig = HttpParamConfig.getSocketConfig(paramHttpParams);
/*  85 */     this.connFactory = (HttpConnectionFactory<? extends HttpClientConnection>)new DefaultBHttpClientConnectionFactory(HttpParamConfig.getConnectionConfig(paramHttpParams));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public BasicConnFactory(HttpParams paramHttpParams) {
/*  95 */     this((SSLSocketFactory)null, paramHttpParams);
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
/*     */   public BasicConnFactory(SocketFactory paramSocketFactory, SSLSocketFactory paramSSLSocketFactory, int paramInt, SocketConfig paramSocketConfig, ConnectionConfig paramConnectionConfig) {
/* 108 */     this.plainfactory = paramSocketFactory;
/* 109 */     this.sslfactory = paramSSLSocketFactory;
/* 110 */     this.connectTimeout = paramInt;
/* 111 */     this.sconfig = (paramSocketConfig != null) ? paramSocketConfig : SocketConfig.DEFAULT;
/* 112 */     this.connFactory = (HttpConnectionFactory<? extends HttpClientConnection>)new DefaultBHttpClientConnectionFactory((paramConnectionConfig != null) ? paramConnectionConfig : ConnectionConfig.DEFAULT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasicConnFactory(int paramInt, SocketConfig paramSocketConfig, ConnectionConfig paramConnectionConfig) {
/* 121 */     this(null, null, paramInt, paramSocketConfig, paramConnectionConfig);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasicConnFactory(SocketConfig paramSocketConfig, ConnectionConfig paramConnectionConfig) {
/* 128 */     this(null, null, 0, paramSocketConfig, paramConnectionConfig);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasicConnFactory() {
/* 135 */     this(null, null, 0, SocketConfig.DEFAULT, ConnectionConfig.DEFAULT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected HttpClientConnection create(Socket paramSocket, HttpParams paramHttpParams) throws IOException {
/* 143 */     int i = paramHttpParams.getIntParameter("http.socket.buffer-size", 8192);
/* 144 */     DefaultBHttpClientConnection defaultBHttpClientConnection = new DefaultBHttpClientConnection(i);
/* 145 */     defaultBHttpClientConnection.bind(paramSocket);
/* 146 */     return (HttpClientConnection)defaultBHttpClientConnection;
/*     */   }
/*     */   
/*     */   public HttpClientConnection create(HttpHost paramHttpHost) throws IOException {
/*     */     final Socket socket;
/* 151 */     String str1 = paramHttpHost.getSchemeName();
/*     */     
/* 153 */     if ("http".equalsIgnoreCase(str1)) {
/* 154 */       socket = (this.plainfactory != null) ? this.plainfactory.createSocket() : new Socket();
/*     */     }
/* 156 */     else if ("https".equalsIgnoreCase(str1)) {
/* 157 */       socket = ((this.sslfactory != null) ? this.sslfactory : SSLSocketFactory.getDefault()).createSocket();
/*     */     } else {
/*     */       
/* 160 */       throw new IOException(str1 + " scheme is not supported");
/*     */     } 
/* 162 */     String str2 = paramHttpHost.getHostName();
/* 163 */     int i = paramHttpHost.getPort();
/* 164 */     if (i == -1) {
/* 165 */       if (paramHttpHost.getSchemeName().equalsIgnoreCase("http")) {
/* 166 */         i = 80;
/* 167 */       } else if (paramHttpHost.getSchemeName().equalsIgnoreCase("https")) {
/* 168 */         i = 443;
/*     */       } 
/*     */     }
/* 171 */     socket.setSoTimeout(this.sconfig.getSoTimeout());
/* 172 */     if (this.sconfig.getSndBufSize() > 0) {
/* 173 */       socket.setSendBufferSize(this.sconfig.getSndBufSize());
/*     */     }
/* 175 */     if (this.sconfig.getRcvBufSize() > 0) {
/* 176 */       socket.setReceiveBufferSize(this.sconfig.getRcvBufSize());
/*     */     }
/* 178 */     socket.setTcpNoDelay(this.sconfig.isTcpNoDelay());
/* 179 */     int j = this.sconfig.getSoLinger();
/* 180 */     if (j >= 0) {
/* 181 */       socket.setSoLinger(true, j);
/*     */     }
/* 183 */     socket.setKeepAlive(this.sconfig.isSoKeepAlive());
/*     */ 
/*     */     
/* 186 */     final InetSocketAddress address = new InetSocketAddress(str2, i);
/*     */     try {
/* 188 */       AccessController.doPrivileged(new PrivilegedExceptionAction()
/*     */           {
/*     */             public Object run() throws IOException {
/* 191 */               socket.connect(address, BasicConnFactory.this.connectTimeout);
/* 192 */               return null;
/*     */             }
/*     */           });
/* 195 */     } catch (PrivilegedActionException privilegedActionException) {
/* 196 */       Asserts.check(privilegedActionException.getCause() instanceof IOException, "method contract violation only checked exceptions are wrapped: " + privilegedActionException.getCause());
/*     */ 
/*     */       
/* 199 */       throw (IOException)privilegedActionException.getCause();
/*     */     } 
/* 201 */     return (HttpClientConnection)this.connFactory.createConnection(socket);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\pool\BasicConnFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */