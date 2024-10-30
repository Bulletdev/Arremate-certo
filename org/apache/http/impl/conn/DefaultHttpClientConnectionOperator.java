/*     */ package org.apache.http.impl.conn;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.net.ConnectException;
/*     */ import java.net.InetAddress;
/*     */ import java.net.InetSocketAddress;
/*     */ import java.net.NoRouteToHostException;
/*     */ import java.net.Socket;
/*     */ import java.net.SocketTimeoutException;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.client.protocol.HttpClientContext;
/*     */ import org.apache.http.config.Lookup;
/*     */ import org.apache.http.config.SocketConfig;
/*     */ import org.apache.http.conn.ConnectTimeoutException;
/*     */ import org.apache.http.conn.DnsResolver;
/*     */ import org.apache.http.conn.HttpClientConnectionOperator;
/*     */ import org.apache.http.conn.HttpHostConnectException;
/*     */ import org.apache.http.conn.ManagedHttpClientConnection;
/*     */ import org.apache.http.conn.SchemePortResolver;
/*     */ import org.apache.http.conn.UnsupportedSchemeException;
/*     */ import org.apache.http.conn.socket.ConnectionSocketFactory;
/*     */ import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
/*     */ import org.apache.http.protocol.HttpContext;
/*     */ import org.apache.http.util.Args;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class DefaultHttpClientConnectionOperator
/*     */   implements HttpClientConnectionOperator
/*     */ {
/*     */   static final String SOCKET_FACTORY_REGISTRY = "http.socket-factory-registry";
/*  69 */   private final Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */   
/*     */   private final Lookup<ConnectionSocketFactory> socketFactoryRegistry;
/*     */   
/*     */   private final SchemePortResolver schemePortResolver;
/*     */   
/*     */   private final DnsResolver dnsResolver;
/*     */ 
/*     */   
/*     */   public DefaultHttpClientConnectionOperator(Lookup<ConnectionSocketFactory> paramLookup, SchemePortResolver paramSchemePortResolver, DnsResolver paramDnsResolver) {
/*  80 */     Args.notNull(paramLookup, "Socket factory registry");
/*  81 */     this.socketFactoryRegistry = paramLookup;
/*  82 */     this.schemePortResolver = (paramSchemePortResolver != null) ? paramSchemePortResolver : DefaultSchemePortResolver.INSTANCE;
/*     */     
/*  84 */     this.dnsResolver = (paramDnsResolver != null) ? paramDnsResolver : SystemDefaultDnsResolver.INSTANCE;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Lookup<ConnectionSocketFactory> getSocketFactoryRegistry(HttpContext paramHttpContext) {
/*  90 */     Lookup<ConnectionSocketFactory> lookup = (Lookup)paramHttpContext.getAttribute("http.socket-factory-registry");
/*     */     
/*  92 */     if (lookup == null) {
/*  93 */       lookup = this.socketFactoryRegistry;
/*     */     }
/*  95 */     return lookup;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void connect(ManagedHttpClientConnection paramManagedHttpClientConnection, HttpHost paramHttpHost, InetSocketAddress paramInetSocketAddress, int paramInt, SocketConfig paramSocketConfig, HttpContext paramHttpContext) throws IOException {
/* 106 */     Lookup<ConnectionSocketFactory> lookup = getSocketFactoryRegistry(paramHttpContext);
/* 107 */     ConnectionSocketFactory connectionSocketFactory = (ConnectionSocketFactory)lookup.lookup(paramHttpHost.getSchemeName());
/* 108 */     if (connectionSocketFactory == null) {
/* 109 */       throw new UnsupportedSchemeException(paramHttpHost.getSchemeName() + " protocol is not supported");
/*     */     }
/*     */     
/* 112 */     (new InetAddress[1])[0] = paramHttpHost.getAddress(); InetAddress[] arrayOfInetAddress = (paramHttpHost.getAddress() != null) ? new InetAddress[1] : this.dnsResolver.resolve(paramHttpHost.getHostName());
/*     */     
/* 114 */     int i = this.schemePortResolver.resolve(paramHttpHost);
/* 115 */     for (byte b = 0; b < arrayOfInetAddress.length; b++) {
/* 116 */       InetAddress inetAddress = arrayOfInetAddress[b];
/* 117 */       boolean bool = (b == arrayOfInetAddress.length - 1) ? true : false;
/*     */       
/* 119 */       Socket socket = connectionSocketFactory.createSocket(paramHttpContext);
/* 120 */       socket.setSoTimeout(paramSocketConfig.getSoTimeout());
/* 121 */       socket.setReuseAddress(paramSocketConfig.isSoReuseAddress());
/* 122 */       socket.setTcpNoDelay(paramSocketConfig.isTcpNoDelay());
/* 123 */       socket.setKeepAlive(paramSocketConfig.isSoKeepAlive());
/* 124 */       if (paramSocketConfig.getRcvBufSize() > 0) {
/* 125 */         socket.setReceiveBufferSize(paramSocketConfig.getRcvBufSize());
/*     */       }
/* 127 */       if (paramSocketConfig.getSndBufSize() > 0) {
/* 128 */         socket.setSendBufferSize(paramSocketConfig.getSndBufSize());
/*     */       }
/*     */       
/* 131 */       int j = paramSocketConfig.getSoLinger();
/* 132 */       if (j >= 0) {
/* 133 */         socket.setSoLinger(true, j);
/*     */       }
/* 135 */       paramManagedHttpClientConnection.bind(socket);
/*     */       
/* 137 */       InetSocketAddress inetSocketAddress = new InetSocketAddress(inetAddress, i);
/* 138 */       if (this.log.isDebugEnabled()) {
/* 139 */         this.log.debug("Connecting to " + inetSocketAddress);
/*     */       }
/*     */       try {
/* 142 */         socket = connectionSocketFactory.connectSocket(paramInt, socket, paramHttpHost, inetSocketAddress, paramInetSocketAddress, paramHttpContext);
/*     */         
/* 144 */         paramManagedHttpClientConnection.bind(socket);
/* 145 */         if (this.log.isDebugEnabled()) {
/* 146 */           this.log.debug("Connection established " + paramManagedHttpClientConnection);
/*     */         }
/*     */         return;
/* 149 */       } catch (SocketTimeoutException socketTimeoutException) {
/* 150 */         if (bool) {
/* 151 */           throw new ConnectTimeoutException(socketTimeoutException, paramHttpHost, arrayOfInetAddress);
/*     */         }
/* 153 */       } catch (ConnectException connectException) {
/* 154 */         if (bool) {
/* 155 */           String str = connectException.getMessage();
/* 156 */           throw "Connection timed out".equals(str) ? new ConnectTimeoutException(connectException, paramHttpHost, arrayOfInetAddress) : new HttpHostConnectException(connectException, paramHttpHost, arrayOfInetAddress);
/*     */         }
/*     */       
/*     */       }
/* 160 */       catch (NoRouteToHostException noRouteToHostException) {
/* 161 */         if (bool) {
/* 162 */           throw noRouteToHostException;
/*     */         }
/*     */       } 
/* 165 */       if (this.log.isDebugEnabled()) {
/* 166 */         this.log.debug("Connect to " + inetSocketAddress + " timed out. " + "Connection will be retried using another IP address");
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void upgrade(ManagedHttpClientConnection paramManagedHttpClientConnection, HttpHost paramHttpHost, HttpContext paramHttpContext) throws IOException {
/* 177 */     HttpClientContext httpClientContext = HttpClientContext.adapt(paramHttpContext);
/* 178 */     Lookup<ConnectionSocketFactory> lookup = getSocketFactoryRegistry((HttpContext)httpClientContext);
/* 179 */     ConnectionSocketFactory connectionSocketFactory = (ConnectionSocketFactory)lookup.lookup(paramHttpHost.getSchemeName());
/* 180 */     if (connectionSocketFactory == null) {
/* 181 */       throw new UnsupportedSchemeException(paramHttpHost.getSchemeName() + " protocol is not supported");
/*     */     }
/*     */     
/* 184 */     if (!(connectionSocketFactory instanceof LayeredConnectionSocketFactory)) {
/* 185 */       throw new UnsupportedSchemeException(paramHttpHost.getSchemeName() + " protocol does not support connection upgrade");
/*     */     }
/*     */     
/* 188 */     LayeredConnectionSocketFactory layeredConnectionSocketFactory = (LayeredConnectionSocketFactory)connectionSocketFactory;
/* 189 */     Socket socket = paramManagedHttpClientConnection.getSocket();
/* 190 */     int i = this.schemePortResolver.resolve(paramHttpHost);
/* 191 */     socket = layeredConnectionSocketFactory.createLayeredSocket(socket, paramHttpHost.getHostName(), i, paramHttpContext);
/* 192 */     paramManagedHttpClientConnection.bind(socket);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\DefaultHttpClientConnectionOperator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */