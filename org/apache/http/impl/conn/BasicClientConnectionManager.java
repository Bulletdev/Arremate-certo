/*     */ package org.apache.http.impl.conn;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.atomic.AtomicLong;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.HttpClientConnection;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.conn.ClientConnectionManager;
/*     */ import org.apache.http.conn.ClientConnectionOperator;
/*     */ import org.apache.http.conn.ClientConnectionRequest;
/*     */ import org.apache.http.conn.ManagedClientConnection;
/*     */ import org.apache.http.conn.OperatedClientConnection;
/*     */ import org.apache.http.conn.routing.HttpRoute;
/*     */ import org.apache.http.conn.scheme.SchemeRegistry;
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
/*     */ @Deprecated
/*     */ @Contract(threading = ThreadingBehavior.SAFE)
/*     */ public class BasicClientConnectionManager
/*     */   implements ClientConnectionManager
/*     */ {
/*  73 */   private final Log log = LogFactory.getLog(getClass());
/*     */   
/*  75 */   private static final AtomicLong COUNTER = new AtomicLong();
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String MISUSE_MESSAGE = "Invalid use of BasicClientConnManager: connection still allocated.\nMake sure to release the connection before allocating another one.";
/*     */ 
/*     */ 
/*     */   
/*     */   private final SchemeRegistry schemeRegistry;
/*     */ 
/*     */ 
/*     */   
/*     */   private final ClientConnectionOperator connOperator;
/*     */ 
/*     */ 
/*     */   
/*     */   private HttpPoolEntry poolEntry;
/*     */ 
/*     */ 
/*     */   
/*     */   private ManagedClientConnectionImpl conn;
/*     */ 
/*     */   
/*     */   private volatile boolean shutdown;
/*     */ 
/*     */ 
/*     */   
/*     */   public BasicClientConnectionManager(SchemeRegistry paramSchemeRegistry) {
/* 103 */     Args.notNull(paramSchemeRegistry, "Scheme registry");
/* 104 */     this.schemeRegistry = paramSchemeRegistry;
/* 105 */     this.connOperator = createConnectionOperator(paramSchemeRegistry);
/*     */   }
/*     */   
/*     */   public BasicClientConnectionManager() {
/* 109 */     this(SchemeRegistryFactory.createDefault());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void finalize() throws Throwable {
/*     */     try {
/* 115 */       shutdown();
/*     */     } finally {
/* 117 */       super.finalize();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemeRegistry getSchemeRegistry() {
/* 123 */     return this.schemeRegistry;
/*     */   }
/*     */   
/*     */   protected ClientConnectionOperator createConnectionOperator(SchemeRegistry paramSchemeRegistry) {
/* 127 */     return new DefaultClientConnectionOperator(paramSchemeRegistry);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final ClientConnectionRequest requestConnection(final HttpRoute route, final Object state) {
/* 135 */     return new ClientConnectionRequest()
/*     */       {
/*     */         public void abortRequest() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public ManagedClientConnection getConnection(long param1Long, TimeUnit param1TimeUnit) {
/* 145 */           return BasicClientConnectionManager.this.getConnection(route, state);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void assertNotShutdown() {
/* 153 */     Asserts.check(!this.shutdown, "Connection manager has been shut down");
/*     */   }
/*     */   
/*     */   ManagedClientConnection getConnection(HttpRoute paramHttpRoute, Object paramObject) {
/* 157 */     Args.notNull(paramHttpRoute, "Route");
/* 158 */     synchronized (this) {
/* 159 */       assertNotShutdown();
/* 160 */       if (this.log.isDebugEnabled()) {
/* 161 */         this.log.debug("Get connection for route " + paramHttpRoute);
/*     */       }
/* 163 */       Asserts.check((this.conn == null), "Invalid use of BasicClientConnManager: connection still allocated.\nMake sure to release the connection before allocating another one.");
/* 164 */       if (this.poolEntry != null && !this.poolEntry.getPlannedRoute().equals(paramHttpRoute)) {
/* 165 */         this.poolEntry.close();
/* 166 */         this.poolEntry = null;
/*     */       } 
/* 168 */       if (this.poolEntry == null) {
/* 169 */         String str = Long.toString(COUNTER.getAndIncrement());
/* 170 */         OperatedClientConnection operatedClientConnection = this.connOperator.createConnection();
/* 171 */         this.poolEntry = new HttpPoolEntry(this.log, str, paramHttpRoute, operatedClientConnection, 0L, TimeUnit.MILLISECONDS);
/*     */       } 
/* 173 */       long l = System.currentTimeMillis();
/* 174 */       if (this.poolEntry.isExpired(l)) {
/* 175 */         this.poolEntry.close();
/* 176 */         this.poolEntry.getTracker().reset();
/*     */       } 
/* 178 */       this.conn = new ManagedClientConnectionImpl(this, this.connOperator, this.poolEntry);
/* 179 */       return this.conn;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void shutdownConnection(HttpClientConnection paramHttpClientConnection) {
/*     */     try {
/* 185 */       paramHttpClientConnection.shutdown();
/* 186 */     } catch (IOException iOException) {
/* 187 */       if (this.log.isDebugEnabled()) {
/* 188 */         this.log.debug("I/O exception shutting down connection", iOException);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void releaseConnection(ManagedClientConnection paramManagedClientConnection, long paramLong, TimeUnit paramTimeUnit) {
/* 195 */     Args.check(paramManagedClientConnection instanceof ManagedClientConnectionImpl, "Connection class mismatch, connection not obtained from this manager");
/*     */     
/* 197 */     ManagedClientConnectionImpl managedClientConnectionImpl = (ManagedClientConnectionImpl)paramManagedClientConnection;
/* 198 */     synchronized (managedClientConnectionImpl) {
/* 199 */       if (this.log.isDebugEnabled()) {
/* 200 */         this.log.debug("Releasing connection " + paramManagedClientConnection);
/*     */       }
/* 202 */       if (managedClientConnectionImpl.getPoolEntry() == null) {
/*     */         return;
/*     */       }
/* 205 */       ClientConnectionManager clientConnectionManager = managedClientConnectionImpl.getManager();
/* 206 */       Asserts.check((clientConnectionManager == this), "Connection not obtained from this manager");
/* 207 */       synchronized (this) {
/* 208 */         if (this.shutdown) {
/* 209 */           shutdownConnection((HttpClientConnection)managedClientConnectionImpl);
/*     */           return;
/*     */         } 
/*     */         try {
/* 213 */           if (managedClientConnectionImpl.isOpen() && !managedClientConnectionImpl.isMarkedReusable()) {
/* 214 */             shutdownConnection((HttpClientConnection)managedClientConnectionImpl);
/*     */           }
/* 216 */           if (managedClientConnectionImpl.isMarkedReusable()) {
/* 217 */             this.poolEntry.updateExpiry(paramLong, (paramTimeUnit != null) ? paramTimeUnit : TimeUnit.MILLISECONDS);
/* 218 */             if (this.log.isDebugEnabled()) {
/*     */               String str;
/* 220 */               if (paramLong > 0L) {
/* 221 */                 str = "for " + paramLong + " " + paramTimeUnit;
/*     */               } else {
/* 223 */                 str = "indefinitely";
/*     */               } 
/* 225 */               this.log.debug("Connection can be kept alive " + str);
/*     */             } 
/*     */           } 
/*     */         } finally {
/* 229 */           managedClientConnectionImpl.detach();
/* 230 */           this.conn = null;
/* 231 */           if (this.poolEntry.isClosed()) {
/* 232 */             this.poolEntry = null;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void closeExpiredConnections() {
/* 241 */     synchronized (this) {
/* 242 */       assertNotShutdown();
/* 243 */       long l = System.currentTimeMillis();
/* 244 */       if (this.poolEntry != null && this.poolEntry.isExpired(l)) {
/* 245 */         this.poolEntry.close();
/* 246 */         this.poolEntry.getTracker().reset();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void closeIdleConnections(long paramLong, TimeUnit paramTimeUnit) {
/* 253 */     Args.notNull(paramTimeUnit, "Time unit");
/* 254 */     synchronized (this) {
/* 255 */       assertNotShutdown();
/* 256 */       long l1 = paramTimeUnit.toMillis(paramLong);
/* 257 */       if (l1 < 0L) {
/* 258 */         l1 = 0L;
/*     */       }
/* 260 */       long l2 = System.currentTimeMillis() - l1;
/* 261 */       if (this.poolEntry != null && this.poolEntry.getUpdated() <= l2) {
/* 262 */         this.poolEntry.close();
/* 263 */         this.poolEntry.getTracker().reset();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void shutdown() {
/* 270 */     synchronized (this) {
/* 271 */       this.shutdown = true;
/*     */       try {
/* 273 */         if (this.poolEntry != null) {
/* 274 */           this.poolEntry.close();
/*     */         }
/*     */       } finally {
/* 277 */         this.poolEntry = null;
/* 278 */         this.conn = null;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\BasicClientConnectionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */