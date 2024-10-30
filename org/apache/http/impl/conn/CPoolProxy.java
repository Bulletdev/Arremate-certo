/*     */ package org.apache.http.impl.conn;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.net.InetAddress;
/*     */ import java.net.Socket;
/*     */ import javax.net.ssl.SSLSession;
/*     */ import org.apache.http.HttpClientConnection;
/*     */ import org.apache.http.HttpConnectionMetrics;
/*     */ import org.apache.http.HttpEntityEnclosingRequest;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.conn.ManagedHttpClientConnection;
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
/*     */ class CPoolProxy
/*     */   implements ManagedHttpClientConnection, HttpContext
/*     */ {
/*     */   private volatile CPoolEntry poolEntry;
/*     */   
/*     */   CPoolProxy(CPoolEntry paramCPoolEntry) {
/*  53 */     this.poolEntry = paramCPoolEntry;
/*     */   }
/*     */   
/*     */   CPoolEntry getPoolEntry() {
/*  57 */     return this.poolEntry;
/*     */   }
/*     */   
/*     */   CPoolEntry detach() {
/*  61 */     CPoolEntry cPoolEntry = this.poolEntry;
/*  62 */     this.poolEntry = null;
/*  63 */     return cPoolEntry;
/*     */   }
/*     */   
/*     */   ManagedHttpClientConnection getConnection() {
/*  67 */     CPoolEntry cPoolEntry = this.poolEntry;
/*  68 */     if (cPoolEntry == null) {
/*  69 */       return null;
/*     */     }
/*  71 */     return (ManagedHttpClientConnection)cPoolEntry.getConnection();
/*     */   }
/*     */   
/*     */   ManagedHttpClientConnection getValidConnection() {
/*  75 */     ManagedHttpClientConnection managedHttpClientConnection = getConnection();
/*  76 */     if (managedHttpClientConnection == null) {
/*  77 */       throw new ConnectionShutdownException();
/*     */     }
/*  79 */     return managedHttpClientConnection;
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/*  84 */     CPoolEntry cPoolEntry = this.poolEntry;
/*  85 */     if (cPoolEntry != null) {
/*  86 */       cPoolEntry.closeConnection();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void shutdown() throws IOException {
/*  92 */     CPoolEntry cPoolEntry = this.poolEntry;
/*  93 */     if (cPoolEntry != null) {
/*  94 */       cPoolEntry.shutdownConnection();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isOpen() {
/* 100 */     CPoolEntry cPoolEntry = this.poolEntry;
/* 101 */     return (cPoolEntry != null) ? (!cPoolEntry.isClosed()) : false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isStale() {
/* 106 */     ManagedHttpClientConnection managedHttpClientConnection = getConnection();
/* 107 */     return (managedHttpClientConnection != null) ? managedHttpClientConnection.isStale() : true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSocketTimeout(int paramInt) {
/* 112 */     getValidConnection().setSocketTimeout(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSocketTimeout() {
/* 117 */     return getValidConnection().getSocketTimeout();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getId() {
/* 122 */     return getValidConnection().getId();
/*     */   }
/*     */ 
/*     */   
/*     */   public void bind(Socket paramSocket) throws IOException {
/* 127 */     getValidConnection().bind(paramSocket);
/*     */   }
/*     */ 
/*     */   
/*     */   public Socket getSocket() {
/* 132 */     return getValidConnection().getSocket();
/*     */   }
/*     */ 
/*     */   
/*     */   public SSLSession getSSLSession() {
/* 137 */     return getValidConnection().getSSLSession();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isResponseAvailable(int paramInt) throws IOException {
/* 142 */     return getValidConnection().isResponseAvailable(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void sendRequestHeader(HttpRequest paramHttpRequest) throws HttpException, IOException {
/* 147 */     getValidConnection().sendRequestHeader(paramHttpRequest);
/*     */   }
/*     */ 
/*     */   
/*     */   public void sendRequestEntity(HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest) throws HttpException, IOException {
/* 152 */     getValidConnection().sendRequestEntity(paramHttpEntityEnclosingRequest);
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpResponse receiveResponseHeader() throws HttpException, IOException {
/* 157 */     return getValidConnection().receiveResponseHeader();
/*     */   }
/*     */ 
/*     */   
/*     */   public void receiveResponseEntity(HttpResponse paramHttpResponse) throws HttpException, IOException {
/* 162 */     getValidConnection().receiveResponseEntity(paramHttpResponse);
/*     */   }
/*     */ 
/*     */   
/*     */   public void flush() throws IOException {
/* 167 */     getValidConnection().flush();
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpConnectionMetrics getMetrics() {
/* 172 */     return getValidConnection().getMetrics();
/*     */   }
/*     */ 
/*     */   
/*     */   public InetAddress getLocalAddress() {
/* 177 */     return getValidConnection().getLocalAddress();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getLocalPort() {
/* 182 */     return getValidConnection().getLocalPort();
/*     */   }
/*     */ 
/*     */   
/*     */   public InetAddress getRemoteAddress() {
/* 187 */     return getValidConnection().getRemoteAddress();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRemotePort() {
/* 192 */     return getValidConnection().getRemotePort();
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getAttribute(String paramString) {
/* 197 */     ManagedHttpClientConnection managedHttpClientConnection = getValidConnection();
/* 198 */     return (managedHttpClientConnection instanceof HttpContext) ? ((HttpContext)managedHttpClientConnection).getAttribute(paramString) : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAttribute(String paramString, Object paramObject) {
/* 203 */     ManagedHttpClientConnection managedHttpClientConnection = getValidConnection();
/* 204 */     if (managedHttpClientConnection instanceof HttpContext) {
/* 205 */       ((HttpContext)managedHttpClientConnection).setAttribute(paramString, paramObject);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Object removeAttribute(String paramString) {
/* 211 */     ManagedHttpClientConnection managedHttpClientConnection = getValidConnection();
/* 212 */     return (managedHttpClientConnection instanceof HttpContext) ? ((HttpContext)managedHttpClientConnection).removeAttribute(paramString) : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 217 */     StringBuilder stringBuilder = new StringBuilder("CPoolProxy{");
/* 218 */     ManagedHttpClientConnection managedHttpClientConnection = getConnection();
/* 219 */     if (managedHttpClientConnection != null) {
/* 220 */       stringBuilder.append(managedHttpClientConnection);
/*     */     } else {
/* 222 */       stringBuilder.append("detached");
/*     */     } 
/* 224 */     stringBuilder.append('}');
/* 225 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public static HttpClientConnection newProxy(CPoolEntry paramCPoolEntry) {
/* 229 */     return (HttpClientConnection)new CPoolProxy(paramCPoolEntry);
/*     */   }
/*     */   
/*     */   private static CPoolProxy getProxy(HttpClientConnection paramHttpClientConnection) {
/* 233 */     if (!CPoolProxy.class.isInstance(paramHttpClientConnection)) {
/* 234 */       throw new IllegalStateException("Unexpected connection proxy class: " + paramHttpClientConnection.getClass());
/*     */     }
/* 236 */     return CPoolProxy.class.cast(paramHttpClientConnection);
/*     */   }
/*     */   
/*     */   public static CPoolEntry getPoolEntry(HttpClientConnection paramHttpClientConnection) {
/* 240 */     CPoolEntry cPoolEntry = getProxy(paramHttpClientConnection).getPoolEntry();
/* 241 */     if (cPoolEntry == null) {
/* 242 */       throw new ConnectionShutdownException();
/*     */     }
/* 244 */     return cPoolEntry;
/*     */   }
/*     */   
/*     */   public static CPoolEntry detach(HttpClientConnection paramHttpClientConnection) {
/* 248 */     return getProxy(paramHttpClientConnection).detach();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\CPoolProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */