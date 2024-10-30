/*     */ package org.apache.http.impl.execchain;
/*     */ 
/*     */ import java.io.Closeable;
/*     */ import java.io.IOException;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.http.HttpClientConnection;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.concurrent.Cancellable;
/*     */ import org.apache.http.conn.ConnectionReleaseTrigger;
/*     */ import org.apache.http.conn.HttpClientConnectionManager;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Contract(threading = ThreadingBehavior.SAFE)
/*     */ class ConnectionHolder
/*     */   implements Closeable, Cancellable, ConnectionReleaseTrigger
/*     */ {
/*     */   private final Log log;
/*     */   private final HttpClientConnectionManager manager;
/*     */   private final HttpClientConnection managedConn;
/*     */   private final AtomicBoolean released;
/*     */   private volatile boolean reusable;
/*     */   private volatile Object state;
/*     */   private volatile long validDuration;
/*     */   private volatile TimeUnit timeUnit;
/*     */   
/*     */   public ConnectionHolder(Log paramLog, HttpClientConnectionManager paramHttpClientConnectionManager, HttpClientConnection paramHttpClientConnection) {
/*  66 */     this.log = paramLog;
/*  67 */     this.manager = paramHttpClientConnectionManager;
/*  68 */     this.managedConn = paramHttpClientConnection;
/*  69 */     this.released = new AtomicBoolean(false);
/*     */   }
/*     */   
/*     */   public boolean isReusable() {
/*  73 */     return this.reusable;
/*     */   }
/*     */   
/*     */   public void markReusable() {
/*  77 */     this.reusable = true;
/*     */   }
/*     */   
/*     */   public void markNonReusable() {
/*  81 */     this.reusable = false;
/*     */   }
/*     */   
/*     */   public void setState(Object paramObject) {
/*  85 */     this.state = paramObject;
/*     */   }
/*     */   
/*     */   public void setValidFor(long paramLong, TimeUnit paramTimeUnit) {
/*  89 */     synchronized (this.managedConn) {
/*  90 */       this.validDuration = paramLong;
/*  91 */       this.timeUnit = paramTimeUnit;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void releaseConnection(boolean paramBoolean) {
/*  96 */     if (this.released.compareAndSet(false, true)) {
/*  97 */       synchronized (this.managedConn) {
/*  98 */         if (paramBoolean) {
/*  99 */           this.manager.releaseConnection(this.managedConn, this.state, this.validDuration, this.timeUnit);
/*     */         } else {
/*     */           
/*     */           try {
/* 103 */             this.managedConn.close();
/* 104 */             this.log.debug("Connection discarded");
/* 105 */           } catch (IOException iOException) {
/* 106 */             if (this.log.isDebugEnabled()) {
/* 107 */               this.log.debug(iOException.getMessage(), iOException);
/*     */             }
/*     */           } finally {
/* 110 */             this.manager.releaseConnection(this.managedConn, null, 0L, TimeUnit.MILLISECONDS);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void releaseConnection() {
/* 120 */     releaseConnection(this.reusable);
/*     */   }
/*     */ 
/*     */   
/*     */   public void abortConnection() {
/* 125 */     if (this.released.compareAndSet(false, true)) {
/* 126 */       synchronized (this.managedConn) {
/*     */         try {
/* 128 */           this.managedConn.shutdown();
/* 129 */           this.log.debug("Connection discarded");
/* 130 */         } catch (IOException iOException) {
/* 131 */           if (this.log.isDebugEnabled()) {
/* 132 */             this.log.debug(iOException.getMessage(), iOException);
/*     */           }
/*     */         } finally {
/* 135 */           this.manager.releaseConnection(this.managedConn, null, 0L, TimeUnit.MILLISECONDS);
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean cancel() {
/* 144 */     boolean bool = this.released.get();
/* 145 */     this.log.debug("Cancelling request execution");
/* 146 */     abortConnection();
/* 147 */     return !bool;
/*     */   }
/*     */   
/*     */   public boolean isReleased() {
/* 151 */     return this.released.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 156 */     releaseConnection(false);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\execchain\ConnectionHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */