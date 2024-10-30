/*     */ package org.apache.http.impl.conn;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.conn.ClientConnectionManager;
/*     */ import org.apache.http.conn.OperatedClientConnection;
/*     */ import org.apache.http.conn.routing.HttpRoute;
/*     */ import org.apache.http.params.HttpParams;
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
/*     */ @Deprecated
/*     */ public abstract class AbstractPooledConnAdapter
/*     */   extends AbstractClientConnAdapter
/*     */ {
/*     */   protected volatile AbstractPoolEntry poolEntry;
/*     */   
/*     */   protected AbstractPooledConnAdapter(ClientConnectionManager paramClientConnectionManager, AbstractPoolEntry paramAbstractPoolEntry) {
/*  66 */     super(paramClientConnectionManager, paramAbstractPoolEntry.connection);
/*  67 */     this.poolEntry = paramAbstractPoolEntry;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getId() {
/*  72 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected AbstractPoolEntry getPoolEntry() {
/*  84 */     return this.poolEntry;
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
/*     */   protected void assertValid(AbstractPoolEntry paramAbstractPoolEntry) {
/*  96 */     if (isReleased() || paramAbstractPoolEntry == null) {
/*  97 */       throw new ConnectionShutdownException();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected final void assertAttached() {
/* 106 */     if (this.poolEntry == null) {
/* 107 */       throw new ConnectionShutdownException();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected synchronized void detach() {
/* 117 */     this.poolEntry = null;
/* 118 */     super.detach();
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpRoute getRoute() {
/* 123 */     AbstractPoolEntry abstractPoolEntry = getPoolEntry();
/* 124 */     assertValid(abstractPoolEntry);
/* 125 */     return (abstractPoolEntry.tracker == null) ? null : abstractPoolEntry.tracker.toRoute();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void open(HttpRoute paramHttpRoute, HttpContext paramHttpContext, HttpParams paramHttpParams) throws IOException {
/* 132 */     AbstractPoolEntry abstractPoolEntry = getPoolEntry();
/* 133 */     assertValid(abstractPoolEntry);
/* 134 */     abstractPoolEntry.open(paramHttpRoute, paramHttpContext, paramHttpParams);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void tunnelTarget(boolean paramBoolean, HttpParams paramHttpParams) throws IOException {
/* 140 */     AbstractPoolEntry abstractPoolEntry = getPoolEntry();
/* 141 */     assertValid(abstractPoolEntry);
/* 142 */     abstractPoolEntry.tunnelTarget(paramBoolean, paramHttpParams);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void tunnelProxy(HttpHost paramHttpHost, boolean paramBoolean, HttpParams paramHttpParams) throws IOException {
/* 148 */     AbstractPoolEntry abstractPoolEntry = getPoolEntry();
/* 149 */     assertValid(abstractPoolEntry);
/* 150 */     abstractPoolEntry.tunnelProxy(paramHttpHost, paramBoolean, paramHttpParams);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void layerProtocol(HttpContext paramHttpContext, HttpParams paramHttpParams) throws IOException {
/* 156 */     AbstractPoolEntry abstractPoolEntry = getPoolEntry();
/* 157 */     assertValid(abstractPoolEntry);
/* 158 */     abstractPoolEntry.layerProtocol(paramHttpContext, paramHttpParams);
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 163 */     AbstractPoolEntry abstractPoolEntry = getPoolEntry();
/* 164 */     if (abstractPoolEntry != null) {
/* 165 */       abstractPoolEntry.shutdownEntry();
/*     */     }
/*     */     
/* 168 */     OperatedClientConnection operatedClientConnection = getWrappedConnection();
/* 169 */     if (operatedClientConnection != null) {
/* 170 */       operatedClientConnection.close();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void shutdown() throws IOException {
/* 176 */     AbstractPoolEntry abstractPoolEntry = getPoolEntry();
/* 177 */     if (abstractPoolEntry != null) {
/* 178 */       abstractPoolEntry.shutdownEntry();
/*     */     }
/*     */     
/* 181 */     OperatedClientConnection operatedClientConnection = getWrappedConnection();
/* 182 */     if (operatedClientConnection != null) {
/* 183 */       operatedClientConnection.shutdown();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getState() {
/* 189 */     AbstractPoolEntry abstractPoolEntry = getPoolEntry();
/* 190 */     assertValid(abstractPoolEntry);
/* 191 */     return abstractPoolEntry.getState();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setState(Object paramObject) {
/* 196 */     AbstractPoolEntry abstractPoolEntry = getPoolEntry();
/* 197 */     assertValid(abstractPoolEntry);
/* 198 */     abstractPoolEntry.setState(paramObject);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\AbstractPooledConnAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */