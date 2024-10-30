/*     */ package org.apache.http.impl.conn;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.net.ConnectException;
/*     */ import java.net.InetAddress;
/*     */ import java.net.InetSocketAddress;
/*     */ import java.net.Socket;
/*     */ import java.net.UnknownHostException;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.conn.ClientConnectionOperator;
/*     */ import org.apache.http.conn.ConnectTimeoutException;
/*     */ import org.apache.http.conn.DnsResolver;
/*     */ import org.apache.http.conn.HttpInetSocketAddress;
/*     */ import org.apache.http.conn.OperatedClientConnection;
/*     */ import org.apache.http.conn.scheme.Scheme;
/*     */ import org.apache.http.conn.scheme.SchemeLayeredSocketFactory;
/*     */ import org.apache.http.conn.scheme.SchemeRegistry;
/*     */ import org.apache.http.conn.scheme.SchemeSocketFactory;
/*     */ import org.apache.http.params.HttpConnectionParams;
/*     */ import org.apache.http.params.HttpParams;
/*     */ import org.apache.http.protocol.HttpContext;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ @Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
/*     */ public class DefaultClientConnectionOperator
/*     */   implements ClientConnectionOperator
/*     */ {
/*  93 */   private final Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final SchemeRegistry schemeRegistry;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final DnsResolver dnsResolver;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultClientConnectionOperator(SchemeRegistry paramSchemeRegistry) {
/* 109 */     Args.notNull(paramSchemeRegistry, "Scheme registry");
/* 110 */     this.schemeRegistry = paramSchemeRegistry;
/* 111 */     this.dnsResolver = new SystemDefaultDnsResolver();
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
/*     */   public DefaultClientConnectionOperator(SchemeRegistry paramSchemeRegistry, DnsResolver paramDnsResolver) {
/* 124 */     Args.notNull(paramSchemeRegistry, "Scheme registry");
/*     */     
/* 126 */     Args.notNull(paramDnsResolver, "DNS resolver");
/*     */     
/* 128 */     this.schemeRegistry = paramSchemeRegistry;
/* 129 */     this.dnsResolver = paramDnsResolver;
/*     */   }
/*     */ 
/*     */   
/*     */   public OperatedClientConnection createConnection() {
/* 134 */     return new DefaultClientConnection();
/*     */   }
/*     */   
/*     */   private SchemeRegistry getSchemeRegistry(HttpContext paramHttpContext) {
/* 138 */     SchemeRegistry schemeRegistry = (SchemeRegistry)paramHttpContext.getAttribute("http.scheme-registry");
/*     */     
/* 140 */     if (schemeRegistry == null) {
/* 141 */       schemeRegistry = this.schemeRegistry;
/*     */     }
/* 143 */     return schemeRegistry;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void openConnection(OperatedClientConnection paramOperatedClientConnection, HttpHost paramHttpHost, InetAddress paramInetAddress, HttpContext paramHttpContext, HttpParams paramHttpParams) throws IOException {
/* 153 */     Args.notNull(paramOperatedClientConnection, "Connection");
/* 154 */     Args.notNull(paramHttpHost, "Target host");
/* 155 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 156 */     Asserts.check(!paramOperatedClientConnection.isOpen(), "Connection must not be open");
/*     */     
/* 158 */     SchemeRegistry schemeRegistry = getSchemeRegistry(paramHttpContext);
/* 159 */     Scheme scheme = schemeRegistry.getScheme(paramHttpHost.getSchemeName());
/* 160 */     SchemeSocketFactory schemeSocketFactory = scheme.getSchemeSocketFactory();
/*     */     
/* 162 */     InetAddress[] arrayOfInetAddress = resolveHostname(paramHttpHost.getHostName());
/* 163 */     int i = scheme.resolvePort(paramHttpHost.getPort());
/* 164 */     for (byte b = 0; b < arrayOfInetAddress.length; b++) {
/* 165 */       InetAddress inetAddress = arrayOfInetAddress[b];
/* 166 */       boolean bool = (b == arrayOfInetAddress.length - 1) ? true : false;
/*     */       
/* 168 */       Socket socket = schemeSocketFactory.createSocket(paramHttpParams);
/* 169 */       paramOperatedClientConnection.opening(socket, paramHttpHost);
/*     */       
/* 171 */       HttpInetSocketAddress httpInetSocketAddress = new HttpInetSocketAddress(paramHttpHost, inetAddress, i);
/* 172 */       InetSocketAddress inetSocketAddress = null;
/* 173 */       if (paramInetAddress != null) {
/* 174 */         inetSocketAddress = new InetSocketAddress(paramInetAddress, 0);
/*     */       }
/* 176 */       if (this.log.isDebugEnabled()) {
/* 177 */         this.log.debug("Connecting to " + httpInetSocketAddress);
/*     */       }
/*     */       try {
/* 180 */         Socket socket1 = schemeSocketFactory.connectSocket(socket, (InetSocketAddress)httpInetSocketAddress, inetSocketAddress, paramHttpParams);
/* 181 */         if (socket != socket1) {
/* 182 */           socket = socket1;
/* 183 */           paramOperatedClientConnection.opening(socket, paramHttpHost);
/*     */         } 
/* 185 */         prepareSocket(socket, paramHttpContext, paramHttpParams);
/* 186 */         paramOperatedClientConnection.openCompleted(schemeSocketFactory.isSecure(socket), paramHttpParams);
/*     */         return;
/* 188 */       } catch (ConnectException connectException) {
/* 189 */         if (bool) {
/* 190 */           throw connectException;
/*     */         }
/* 192 */       } catch (ConnectTimeoutException connectTimeoutException) {
/* 193 */         if (bool) {
/* 194 */           throw connectTimeoutException;
/*     */         }
/*     */       } 
/* 197 */       if (this.log.isDebugEnabled()) {
/* 198 */         this.log.debug("Connect to " + httpInetSocketAddress + " timed out. " + "Connection will be retried using another IP address");
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateSecureConnection(OperatedClientConnection paramOperatedClientConnection, HttpHost paramHttpHost, HttpContext paramHttpContext, HttpParams paramHttpParams) throws IOException {
/* 210 */     Args.notNull(paramOperatedClientConnection, "Connection");
/* 211 */     Args.notNull(paramHttpHost, "Target host");
/* 212 */     Args.notNull(paramHttpParams, "Parameters");
/* 213 */     Asserts.check(paramOperatedClientConnection.isOpen(), "Connection must be open");
/*     */     
/* 215 */     SchemeRegistry schemeRegistry = getSchemeRegistry(paramHttpContext);
/* 216 */     Scheme scheme = schemeRegistry.getScheme(paramHttpHost.getSchemeName());
/* 217 */     Asserts.check(scheme.getSchemeSocketFactory() instanceof SchemeLayeredSocketFactory, "Socket factory must implement SchemeLayeredSocketFactory");
/*     */     
/* 219 */     SchemeLayeredSocketFactory schemeLayeredSocketFactory = (SchemeLayeredSocketFactory)scheme.getSchemeSocketFactory();
/* 220 */     Socket socket = schemeLayeredSocketFactory.createLayeredSocket(paramOperatedClientConnection.getSocket(), paramHttpHost.getHostName(), scheme.resolvePort(paramHttpHost.getPort()), paramHttpParams);
/*     */     
/* 222 */     prepareSocket(socket, paramHttpContext, paramHttpParams);
/* 223 */     paramOperatedClientConnection.update(socket, paramHttpHost, schemeLayeredSocketFactory.isSecure(socket), paramHttpParams);
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
/*     */   protected void prepareSocket(Socket paramSocket, HttpContext paramHttpContext, HttpParams paramHttpParams) throws IOException {
/* 239 */     paramSocket.setTcpNoDelay(HttpConnectionParams.getTcpNoDelay(paramHttpParams));
/* 240 */     paramSocket.setSoTimeout(HttpConnectionParams.getSoTimeout(paramHttpParams));
/*     */     
/* 242 */     int i = HttpConnectionParams.getLinger(paramHttpParams);
/* 243 */     if (i >= 0) {
/* 244 */       paramSocket.setSoLinger((i > 0), i);
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
/*     */ 
/*     */   
/*     */   protected InetAddress[] resolveHostname(String paramString) throws UnknownHostException {
/* 263 */     return this.dnsResolver.resolve(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\DefaultClientConnectionOperator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */