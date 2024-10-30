/*     */ package org.apache.http.impl.conn;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InterruptedIOException;
/*     */ import java.net.Socket;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.net.ssl.SSLSession;
/*     */ import javax.net.ssl.SSLSocket;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.HttpResponseFactory;
/*     */ import org.apache.http.conn.ManagedHttpClientConnection;
/*     */ import org.apache.http.conn.OperatedClientConnection;
/*     */ import org.apache.http.impl.SocketHttpClientConnection;
/*     */ import org.apache.http.io.HttpMessageParser;
/*     */ import org.apache.http.io.SessionInputBuffer;
/*     */ import org.apache.http.io.SessionOutputBuffer;
/*     */ import org.apache.http.params.BasicHttpParams;
/*     */ import org.apache.http.params.HttpParams;
/*     */ import org.apache.http.params.HttpProtocolParams;
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
/*     */ 
/*     */ @Deprecated
/*     */ public class DefaultClientConnection
/*     */   extends SocketHttpClientConnection
/*     */   implements ManagedHttpClientConnection, OperatedClientConnection, HttpContext
/*     */ {
/*  70 */   private final Log log = LogFactory.getLog(getClass());
/*  71 */   private final Log headerLog = LogFactory.getLog("org.apache.http.headers");
/*  72 */   private final Log wireLog = LogFactory.getLog("org.apache.http.wire");
/*     */ 
/*     */   
/*     */   private volatile Socket socket;
/*     */ 
/*     */   
/*     */   private HttpHost targetHost;
/*     */ 
/*     */   
/*     */   private boolean connSecure;
/*     */ 
/*     */   
/*     */   private volatile boolean shutdown;
/*     */ 
/*     */   
/*     */   private final Map<String, Object> attributes;
/*     */ 
/*     */   
/*     */   public DefaultClientConnection() {
/*  91 */     this.attributes = new HashMap<String, Object>();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getId() {
/*  96 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final HttpHost getTargetHost() {
/* 101 */     return this.targetHost;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isSecure() {
/* 106 */     return this.connSecure;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Socket getSocket() {
/* 111 */     return this.socket;
/*     */   }
/*     */ 
/*     */   
/*     */   public SSLSession getSSLSession() {
/* 116 */     if (this.socket instanceof SSLSocket) {
/* 117 */       return ((SSLSocket)this.socket).getSession();
/*     */     }
/* 119 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void opening(Socket paramSocket, HttpHost paramHttpHost) throws IOException {
/* 125 */     assertNotOpen();
/* 126 */     this.socket = paramSocket;
/* 127 */     this.targetHost = paramHttpHost;
/*     */ 
/*     */     
/* 130 */     if (this.shutdown) {
/* 131 */       paramSocket.close();
/*     */       
/* 133 */       throw new InterruptedIOException("Connection already shutdown");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void openCompleted(boolean paramBoolean, HttpParams paramHttpParams) throws IOException {
/* 139 */     Args.notNull(paramHttpParams, "Parameters");
/* 140 */     assertNotOpen();
/* 141 */     this.connSecure = paramBoolean;
/* 142 */     bind(this.socket, paramHttpParams);
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
/*     */   public void shutdown() throws IOException {
/* 160 */     this.shutdown = true;
/*     */     try {
/* 162 */       super.shutdown();
/* 163 */       if (this.log.isDebugEnabled()) {
/* 164 */         this.log.debug("Connection " + this + " shut down");
/*     */       }
/* 166 */       Socket socket = this.socket;
/* 167 */       if (socket != null) {
/* 168 */         socket.close();
/*     */       }
/* 170 */     } catch (IOException iOException) {
/* 171 */       this.log.debug("I/O error shutting down connection", iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/*     */     try {
/* 178 */       super.close();
/* 179 */       if (this.log.isDebugEnabled()) {
/* 180 */         this.log.debug("Connection " + this + " closed");
/*     */       }
/* 182 */     } catch (IOException iOException) {
/* 183 */       this.log.debug("I/O error closing connection", iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SessionInputBuffer createSessionInputBuffer(Socket paramSocket, int paramInt, HttpParams paramHttpParams) throws IOException {
/* 192 */     SessionInputBuffer sessionInputBuffer = super.createSessionInputBuffer(paramSocket, (paramInt > 0) ? paramInt : 8192, paramHttpParams);
/*     */ 
/*     */ 
/*     */     
/* 196 */     if (this.wireLog.isDebugEnabled()) {
/* 197 */       sessionInputBuffer = new LoggingSessionInputBuffer(sessionInputBuffer, new Wire(this.wireLog), HttpProtocolParams.getHttpElementCharset(paramHttpParams));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 202 */     return sessionInputBuffer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SessionOutputBuffer createSessionOutputBuffer(Socket paramSocket, int paramInt, HttpParams paramHttpParams) throws IOException {
/* 210 */     SessionOutputBuffer sessionOutputBuffer = super.createSessionOutputBuffer(paramSocket, (paramInt > 0) ? paramInt : 8192, paramHttpParams);
/*     */ 
/*     */ 
/*     */     
/* 214 */     if (this.wireLog.isDebugEnabled()) {
/* 215 */       sessionOutputBuffer = new LoggingSessionOutputBuffer(sessionOutputBuffer, new Wire(this.wireLog), HttpProtocolParams.getHttpElementCharset(paramHttpParams));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 220 */     return sessionOutputBuffer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected HttpMessageParser<HttpResponse> createResponseParser(SessionInputBuffer paramSessionInputBuffer, HttpResponseFactory paramHttpResponseFactory, HttpParams paramHttpParams) {
/* 229 */     return (HttpMessageParser<HttpResponse>)new DefaultHttpResponseParser(paramSessionInputBuffer, null, paramHttpResponseFactory, paramHttpParams);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void bind(Socket paramSocket) throws IOException {
/* 235 */     bind(paramSocket, (HttpParams)new BasicHttpParams());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(Socket paramSocket, HttpHost paramHttpHost, boolean paramBoolean, HttpParams paramHttpParams) throws IOException {
/* 243 */     assertOpen();
/* 244 */     Args.notNull(paramHttpHost, "Target host");
/* 245 */     Args.notNull(paramHttpParams, "Parameters");
/*     */     
/* 247 */     if (paramSocket != null) {
/* 248 */       this.socket = paramSocket;
/* 249 */       bind(paramSocket, paramHttpParams);
/*     */     } 
/* 251 */     this.targetHost = paramHttpHost;
/* 252 */     this.connSecure = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpResponse receiveResponseHeader() throws HttpException, IOException {
/* 257 */     HttpResponse httpResponse = super.receiveResponseHeader();
/* 258 */     if (this.log.isDebugEnabled()) {
/* 259 */       this.log.debug("Receiving response: " + httpResponse.getStatusLine());
/*     */     }
/* 261 */     if (this.headerLog.isDebugEnabled()) {
/* 262 */       this.headerLog.debug("<< " + httpResponse.getStatusLine().toString());
/* 263 */       Header[] arrayOfHeader = httpResponse.getAllHeaders();
/* 264 */       for (Header header : arrayOfHeader) {
/* 265 */         this.headerLog.debug("<< " + header.toString());
/*     */       }
/*     */     } 
/* 268 */     return httpResponse;
/*     */   }
/*     */ 
/*     */   
/*     */   public void sendRequestHeader(HttpRequest paramHttpRequest) throws HttpException, IOException {
/* 273 */     if (this.log.isDebugEnabled()) {
/* 274 */       this.log.debug("Sending request: " + paramHttpRequest.getRequestLine());
/*     */     }
/* 276 */     super.sendRequestHeader(paramHttpRequest);
/* 277 */     if (this.headerLog.isDebugEnabled()) {
/* 278 */       this.headerLog.debug(">> " + paramHttpRequest.getRequestLine().toString());
/* 279 */       Header[] arrayOfHeader = paramHttpRequest.getAllHeaders();
/* 280 */       for (Header header : arrayOfHeader) {
/* 281 */         this.headerLog.debug(">> " + header.toString());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getAttribute(String paramString) {
/* 288 */     return this.attributes.get(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object removeAttribute(String paramString) {
/* 293 */     return this.attributes.remove(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAttribute(String paramString, Object paramObject) {
/* 298 */     this.attributes.put(paramString, paramObject);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\DefaultClientConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */