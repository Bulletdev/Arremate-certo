/*     */ package org.apache.http.impl.conn;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InterruptedIOException;
/*     */ import java.net.InetAddress;
/*     */ import java.net.Socket;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import javax.net.ssl.SSLSession;
/*     */ import javax.net.ssl.SSLSocket;
/*     */ import org.apache.http.HttpConnectionMetrics;
/*     */ import org.apache.http.HttpEntityEnclosingRequest;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.conn.ClientConnectionManager;
/*     */ import org.apache.http.conn.ManagedClientConnection;
/*     */ import org.apache.http.conn.OperatedClientConnection;
/*     */ import org.apache.http.protocol.HttpContext;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public abstract class AbstractClientConnAdapter
/*     */   implements ManagedClientConnection, HttpContext
/*     */ {
/*     */   private final ClientConnectionManager connManager;
/*     */   private volatile OperatedClientConnection wrappedConnection;
/*     */   private volatile boolean markedReusable;
/*     */   private volatile boolean released;
/*     */   private volatile long duration;
/*     */   
/*     */   protected AbstractClientConnAdapter(ClientConnectionManager paramClientConnectionManager, OperatedClientConnection paramOperatedClientConnection) {
/* 102 */     this.connManager = paramClientConnectionManager;
/* 103 */     this.wrappedConnection = paramOperatedClientConnection;
/* 104 */     this.markedReusable = false;
/* 105 */     this.released = false;
/* 106 */     this.duration = Long.MAX_VALUE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected synchronized void detach() {
/* 114 */     this.wrappedConnection = null;
/* 115 */     this.duration = Long.MAX_VALUE;
/*     */   }
/*     */   
/*     */   protected OperatedClientConnection getWrappedConnection() {
/* 119 */     return this.wrappedConnection;
/*     */   }
/*     */   
/*     */   protected ClientConnectionManager getManager() {
/* 123 */     return this.connManager;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected final void assertNotAborted() throws InterruptedIOException {
/* 131 */     if (isReleased()) {
/* 132 */       throw new InterruptedIOException("Connection has been shut down");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isReleased() {
/* 141 */     return this.released;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void assertValid(OperatedClientConnection paramOperatedClientConnection) throws ConnectionShutdownException {
/* 152 */     if (isReleased() || paramOperatedClientConnection == null) {
/* 153 */       throw new ConnectionShutdownException();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isOpen() {
/* 159 */     OperatedClientConnection operatedClientConnection = getWrappedConnection();
/* 160 */     if (operatedClientConnection == null) {
/* 161 */       return false;
/*     */     }
/*     */     
/* 164 */     return operatedClientConnection.isOpen();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isStale() {
/* 169 */     if (isReleased()) {
/* 170 */       return true;
/*     */     }
/* 172 */     OperatedClientConnection operatedClientConnection = getWrappedConnection();
/* 173 */     if (operatedClientConnection == null) {
/* 174 */       return true;
/*     */     }
/*     */     
/* 177 */     return operatedClientConnection.isStale();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSocketTimeout(int paramInt) {
/* 182 */     OperatedClientConnection operatedClientConnection = getWrappedConnection();
/* 183 */     assertValid(operatedClientConnection);
/* 184 */     operatedClientConnection.setSocketTimeout(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSocketTimeout() {
/* 189 */     OperatedClientConnection operatedClientConnection = getWrappedConnection();
/* 190 */     assertValid(operatedClientConnection);
/* 191 */     return operatedClientConnection.getSocketTimeout();
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpConnectionMetrics getMetrics() {
/* 196 */     OperatedClientConnection operatedClientConnection = getWrappedConnection();
/* 197 */     assertValid(operatedClientConnection);
/* 198 */     return operatedClientConnection.getMetrics();
/*     */   }
/*     */ 
/*     */   
/*     */   public void flush() throws IOException {
/* 203 */     OperatedClientConnection operatedClientConnection = getWrappedConnection();
/* 204 */     assertValid(operatedClientConnection);
/* 205 */     operatedClientConnection.flush();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isResponseAvailable(int paramInt) throws IOException {
/* 210 */     OperatedClientConnection operatedClientConnection = getWrappedConnection();
/* 211 */     assertValid(operatedClientConnection);
/* 212 */     return operatedClientConnection.isResponseAvailable(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void receiveResponseEntity(HttpResponse paramHttpResponse) throws HttpException, IOException {
/* 218 */     OperatedClientConnection operatedClientConnection = getWrappedConnection();
/* 219 */     assertValid(operatedClientConnection);
/* 220 */     unmarkReusable();
/* 221 */     operatedClientConnection.receiveResponseEntity(paramHttpResponse);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpResponse receiveResponseHeader() throws HttpException, IOException {
/* 227 */     OperatedClientConnection operatedClientConnection = getWrappedConnection();
/* 228 */     assertValid(operatedClientConnection);
/* 229 */     unmarkReusable();
/* 230 */     return operatedClientConnection.receiveResponseHeader();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendRequestEntity(HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest) throws HttpException, IOException {
/* 236 */     OperatedClientConnection operatedClientConnection = getWrappedConnection();
/* 237 */     assertValid(operatedClientConnection);
/* 238 */     unmarkReusable();
/* 239 */     operatedClientConnection.sendRequestEntity(paramHttpEntityEnclosingRequest);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendRequestHeader(HttpRequest paramHttpRequest) throws HttpException, IOException {
/* 245 */     OperatedClientConnection operatedClientConnection = getWrappedConnection();
/* 246 */     assertValid(operatedClientConnection);
/* 247 */     unmarkReusable();
/* 248 */     operatedClientConnection.sendRequestHeader(paramHttpRequest);
/*     */   }
/*     */ 
/*     */   
/*     */   public InetAddress getLocalAddress() {
/* 253 */     OperatedClientConnection operatedClientConnection = getWrappedConnection();
/* 254 */     assertValid(operatedClientConnection);
/* 255 */     return operatedClientConnection.getLocalAddress();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getLocalPort() {
/* 260 */     OperatedClientConnection operatedClientConnection = getWrappedConnection();
/* 261 */     assertValid(operatedClientConnection);
/* 262 */     return operatedClientConnection.getLocalPort();
/*     */   }
/*     */ 
/*     */   
/*     */   public InetAddress getRemoteAddress() {
/* 267 */     OperatedClientConnection operatedClientConnection = getWrappedConnection();
/* 268 */     assertValid(operatedClientConnection);
/* 269 */     return operatedClientConnection.getRemoteAddress();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRemotePort() {
/* 274 */     OperatedClientConnection operatedClientConnection = getWrappedConnection();
/* 275 */     assertValid(operatedClientConnection);
/* 276 */     return operatedClientConnection.getRemotePort();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isSecure() {
/* 281 */     OperatedClientConnection operatedClientConnection = getWrappedConnection();
/* 282 */     assertValid(operatedClientConnection);
/* 283 */     return operatedClientConnection.isSecure();
/*     */   }
/*     */ 
/*     */   
/*     */   public void bind(Socket paramSocket) throws IOException {
/* 288 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public Socket getSocket() {
/* 293 */     OperatedClientConnection operatedClientConnection = getWrappedConnection();
/* 294 */     assertValid(operatedClientConnection);
/* 295 */     if (!isOpen()) {
/* 296 */       return null;
/*     */     }
/* 298 */     return operatedClientConnection.getSocket();
/*     */   }
/*     */ 
/*     */   
/*     */   public SSLSession getSSLSession() {
/* 303 */     OperatedClientConnection operatedClientConnection = getWrappedConnection();
/* 304 */     assertValid(operatedClientConnection);
/* 305 */     if (!isOpen()) {
/* 306 */       return null;
/*     */     }
/*     */     
/* 309 */     SSLSession sSLSession = null;
/* 310 */     Socket socket = operatedClientConnection.getSocket();
/* 311 */     if (socket instanceof SSLSocket) {
/* 312 */       sSLSession = ((SSLSocket)socket).getSession();
/*     */     }
/* 314 */     return sSLSession;
/*     */   }
/*     */ 
/*     */   
/*     */   public void markReusable() {
/* 319 */     this.markedReusable = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void unmarkReusable() {
/* 324 */     this.markedReusable = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isMarkedReusable() {
/* 329 */     return this.markedReusable;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setIdleDuration(long paramLong, TimeUnit paramTimeUnit) {
/* 334 */     if (paramLong > 0L) {
/* 335 */       this.duration = paramTimeUnit.toMillis(paramLong);
/*     */     } else {
/* 337 */       this.duration = -1L;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void releaseConnection() {
/* 343 */     if (this.released) {
/*     */       return;
/*     */     }
/* 346 */     this.released = true;
/* 347 */     this.connManager.releaseConnection(this, this.duration, TimeUnit.MILLISECONDS);
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void abortConnection() {
/* 352 */     if (this.released) {
/*     */       return;
/*     */     }
/* 355 */     this.released = true;
/* 356 */     unmarkReusable();
/*     */     try {
/* 358 */       shutdown();
/* 359 */     } catch (IOException iOException) {}
/*     */     
/* 361 */     this.connManager.releaseConnection(this, this.duration, TimeUnit.MILLISECONDS);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getAttribute(String paramString) {
/* 366 */     OperatedClientConnection operatedClientConnection = getWrappedConnection();
/* 367 */     assertValid(operatedClientConnection);
/* 368 */     if (operatedClientConnection instanceof HttpContext) {
/* 369 */       return ((HttpContext)operatedClientConnection).getAttribute(paramString);
/*     */     }
/* 371 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object removeAttribute(String paramString) {
/* 377 */     OperatedClientConnection operatedClientConnection = getWrappedConnection();
/* 378 */     assertValid(operatedClientConnection);
/* 379 */     if (operatedClientConnection instanceof HttpContext) {
/* 380 */       return ((HttpContext)operatedClientConnection).removeAttribute(paramString);
/*     */     }
/* 382 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAttribute(String paramString, Object paramObject) {
/* 388 */     OperatedClientConnection operatedClientConnection = getWrappedConnection();
/* 389 */     assertValid(operatedClientConnection);
/* 390 */     if (operatedClientConnection instanceof HttpContext)
/* 391 */       ((HttpContext)operatedClientConnection).setAttribute(paramString, paramObject); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\AbstractClientConnAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */