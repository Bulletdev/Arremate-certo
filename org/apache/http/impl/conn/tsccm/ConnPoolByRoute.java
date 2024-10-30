/*     */ package org.apache.http.impl.conn.tsccm;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Map;
/*     */ import java.util.Queue;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.locks.Condition;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.conn.ClientConnectionOperator;
/*     */ import org.apache.http.conn.ConnectionPoolTimeoutException;
/*     */ import org.apache.http.conn.OperatedClientConnection;
/*     */ import org.apache.http.conn.params.ConnManagerParams;
/*     */ import org.apache.http.conn.params.ConnPerRoute;
/*     */ import org.apache.http.conn.routing.HttpRoute;
/*     */ import org.apache.http.params.HttpParams;
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
/*     */ @Deprecated
/*     */ public class ConnPoolByRoute
/*     */   extends AbstractConnPool
/*     */ {
/*  73 */   private final Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */   
/*     */   private final Lock poolLock;
/*     */ 
/*     */   
/*     */   protected final ClientConnectionOperator operator;
/*     */ 
/*     */   
/*     */   protected final ConnPerRoute connPerRoute;
/*     */ 
/*     */   
/*     */   protected final Set<BasicPoolEntry> leasedConnections;
/*     */ 
/*     */   
/*     */   protected final Queue<BasicPoolEntry> freeConnections;
/*     */ 
/*     */   
/*     */   protected final Queue<WaitingThread> waitingThreads;
/*     */ 
/*     */   
/*     */   protected final Map<HttpRoute, RouteSpecificPool> routeToPool;
/*     */ 
/*     */   
/*     */   private final long connTTL;
/*     */ 
/*     */   
/*     */   private final TimeUnit connTTLTimeUnit;
/*     */ 
/*     */   
/*     */   protected volatile boolean shutdown;
/*     */ 
/*     */   
/*     */   protected volatile int maxTotalConnections;
/*     */ 
/*     */   
/*     */   protected volatile int numConnections;
/*     */ 
/*     */ 
/*     */   
/*     */   public ConnPoolByRoute(ClientConnectionOperator paramClientConnectionOperator, ConnPerRoute paramConnPerRoute, int paramInt) {
/* 114 */     this(paramClientConnectionOperator, paramConnPerRoute, paramInt, -1L, TimeUnit.MILLISECONDS);
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
/*     */   public ConnPoolByRoute(ClientConnectionOperator paramClientConnectionOperator, ConnPerRoute paramConnPerRoute, int paramInt, long paramLong, TimeUnit paramTimeUnit) {
/* 127 */     Args.notNull(paramClientConnectionOperator, "Connection operator");
/* 128 */     Args.notNull(paramConnPerRoute, "Connections per route");
/* 129 */     this.poolLock = super.poolLock;
/* 130 */     this.leasedConnections = super.leasedConnections;
/* 131 */     this.operator = paramClientConnectionOperator;
/* 132 */     this.connPerRoute = paramConnPerRoute;
/* 133 */     this.maxTotalConnections = paramInt;
/* 134 */     this.freeConnections = createFreeConnQueue();
/* 135 */     this.waitingThreads = createWaitingThreadQueue();
/* 136 */     this.routeToPool = createRouteToPoolMap();
/* 137 */     this.connTTL = paramLong;
/* 138 */     this.connTTLTimeUnit = paramTimeUnit;
/*     */   }
/*     */   
/*     */   protected Lock getLock() {
/* 142 */     return this.poolLock;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public ConnPoolByRoute(ClientConnectionOperator paramClientConnectionOperator, HttpParams paramHttpParams) {
/* 152 */     this(paramClientConnectionOperator, ConnManagerParams.getMaxConnectionsPerRoute(paramHttpParams), ConnManagerParams.getMaxTotalConnections(paramHttpParams));
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
/*     */   protected Queue<BasicPoolEntry> createFreeConnQueue() {
/* 164 */     return new LinkedList<BasicPoolEntry>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Queue<WaitingThread> createWaitingThreadQueue() {
/* 174 */     return new LinkedList<WaitingThread>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Map<HttpRoute, RouteSpecificPool> createRouteToPoolMap() {
/* 184 */     return new HashMap<HttpRoute, RouteSpecificPool>();
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
/*     */   protected RouteSpecificPool newRouteSpecificPool(HttpRoute paramHttpRoute) {
/* 197 */     return new RouteSpecificPool(paramHttpRoute, this.connPerRoute);
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
/*     */   protected WaitingThread newWaitingThread(Condition paramCondition, RouteSpecificPool paramRouteSpecificPool) {
/* 212 */     return new WaitingThread(paramCondition, paramRouteSpecificPool);
/*     */   }
/*     */   
/*     */   private void closeConnection(BasicPoolEntry paramBasicPoolEntry) {
/* 216 */     OperatedClientConnection operatedClientConnection = paramBasicPoolEntry.getConnection();
/* 217 */     if (operatedClientConnection != null) {
/*     */       try {
/* 219 */         operatedClientConnection.close();
/* 220 */       } catch (IOException iOException) {
/* 221 */         this.log.debug("I/O error closing connection", iOException);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected RouteSpecificPool getRoutePool(HttpRoute paramHttpRoute, boolean paramBoolean) {
/* 237 */     RouteSpecificPool routeSpecificPool = null;
/* 238 */     this.poolLock.lock();
/*     */     
/*     */     try {
/* 241 */       routeSpecificPool = this.routeToPool.get(paramHttpRoute);
/* 242 */       if (routeSpecificPool == null && paramBoolean) {
/*     */         
/* 244 */         routeSpecificPool = newRouteSpecificPool(paramHttpRoute);
/* 245 */         this.routeToPool.put(paramHttpRoute, routeSpecificPool);
/*     */       } 
/*     */     } finally {
/*     */       
/* 249 */       this.poolLock.unlock();
/*     */     } 
/*     */     
/* 252 */     return routeSpecificPool;
/*     */   }
/*     */   
/*     */   public int getConnectionsInPool(HttpRoute paramHttpRoute) {
/* 256 */     this.poolLock.lock();
/*     */     
/*     */     try {
/* 259 */       RouteSpecificPool routeSpecificPool = getRoutePool(paramHttpRoute, false);
/* 260 */       return (routeSpecificPool != null) ? routeSpecificPool.getEntryCount() : 0;
/*     */     } finally {
/*     */       
/* 263 */       this.poolLock.unlock();
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getConnectionsInPool() {
/* 268 */     this.poolLock.lock();
/*     */     try {
/* 270 */       return this.numConnections;
/*     */     } finally {
/* 272 */       this.poolLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PoolEntryRequest requestPoolEntry(final HttpRoute route, final Object state) {
/* 281 */     final WaitingThreadAborter aborter = new WaitingThreadAborter();
/*     */     
/* 283 */     return new PoolEntryRequest()
/*     */       {
/*     */         public void abortRequest()
/*     */         {
/* 287 */           ConnPoolByRoute.this.poolLock.lock();
/*     */           try {
/* 289 */             aborter.abort();
/*     */           } finally {
/* 291 */             ConnPoolByRoute.this.poolLock.unlock();
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public BasicPoolEntry getPoolEntry(long param1Long, TimeUnit param1TimeUnit) throws InterruptedException, ConnectionPoolTimeoutException {
/* 300 */           return ConnPoolByRoute.this.getEntryBlocking(route, state, param1Long, param1TimeUnit, aborter);
/*     */         }
/*     */       };
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected BasicPoolEntry getEntryBlocking(HttpRoute paramHttpRoute, Object paramObject, long paramLong, TimeUnit paramTimeUnit, WaitingThreadAborter paramWaitingThreadAborter) throws ConnectionPoolTimeoutException, InterruptedException {
/* 330 */     Date date = null;
/* 331 */     if (paramLong > 0L) {
/* 332 */       date = new Date(System.currentTimeMillis() + paramTimeUnit.toMillis(paramLong));
/*     */     }
/*     */ 
/*     */     
/* 336 */     BasicPoolEntry basicPoolEntry = null;
/* 337 */     this.poolLock.lock();
/*     */     
/*     */     try {
/* 340 */       RouteSpecificPool routeSpecificPool = getRoutePool(paramHttpRoute, true);
/* 341 */       WaitingThread waitingThread = null;
/*     */       
/* 343 */       while (basicPoolEntry == null) {
/* 344 */         Asserts.check(!this.shutdown, "Connection pool shut down");
/*     */         
/* 346 */         if (this.log.isDebugEnabled()) {
/* 347 */           this.log.debug("[" + paramHttpRoute + "] total kept alive: " + this.freeConnections.size() + ", total issued: " + this.leasedConnections.size() + ", total allocated: " + this.numConnections + " out of " + this.maxTotalConnections);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 358 */         basicPoolEntry = getFreeEntry(routeSpecificPool, paramObject);
/* 359 */         if (basicPoolEntry != null) {
/*     */           break;
/*     */         }
/*     */         
/* 363 */         boolean bool = (routeSpecificPool.getCapacity() > 0) ? true : false;
/*     */         
/* 365 */         if (this.log.isDebugEnabled()) {
/* 366 */           this.log.debug("Available capacity: " + routeSpecificPool.getCapacity() + " out of " + routeSpecificPool.getMaxEntries() + " [" + paramHttpRoute + "][" + paramObject + "]");
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 371 */         if (bool && this.numConnections < this.maxTotalConnections) {
/*     */           
/* 373 */           basicPoolEntry = createEntry(routeSpecificPool, this.operator); continue;
/*     */         } 
/* 375 */         if (bool && !this.freeConnections.isEmpty()) {
/*     */           
/* 377 */           deleteLeastUsedEntry();
/*     */ 
/*     */           
/* 380 */           routeSpecificPool = getRoutePool(paramHttpRoute, true);
/* 381 */           basicPoolEntry = createEntry(routeSpecificPool, this.operator);
/*     */           
/*     */           continue;
/*     */         } 
/* 385 */         if (this.log.isDebugEnabled()) {
/* 386 */           this.log.debug("Need to wait for connection [" + paramHttpRoute + "][" + paramObject + "]");
/*     */         }
/*     */ 
/*     */         
/* 390 */         if (waitingThread == null) {
/* 391 */           waitingThread = newWaitingThread(this.poolLock.newCondition(), routeSpecificPool);
/*     */           
/* 393 */           paramWaitingThreadAborter.setWaitingThread(waitingThread);
/*     */         } 
/*     */         
/* 396 */         boolean bool1 = false;
/*     */         try {
/* 398 */           routeSpecificPool.queueThread(waitingThread);
/* 399 */           this.waitingThreads.add(waitingThread);
/* 400 */           bool1 = waitingThread.await(date);
/*     */ 
/*     */         
/*     */         }
/*     */         finally {
/*     */ 
/*     */           
/* 407 */           routeSpecificPool.removeThread(waitingThread);
/* 408 */           this.waitingThreads.remove(waitingThread);
/*     */         } 
/*     */ 
/*     */         
/* 412 */         if (!bool1 && date != null && date.getTime() <= System.currentTimeMillis())
/*     */         {
/* 414 */           throw new ConnectionPoolTimeoutException("Timeout waiting for connection from pool");
/*     */         }
/*     */       }
/*     */     
/*     */     }
/*     */     finally {
/*     */       
/* 421 */       this.poolLock.unlock();
/*     */     } 
/* 423 */     return basicPoolEntry;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void freeEntry(BasicPoolEntry paramBasicPoolEntry, boolean paramBoolean, long paramLong, TimeUnit paramTimeUnit) {
/* 429 */     HttpRoute httpRoute = paramBasicPoolEntry.getPlannedRoute();
/* 430 */     if (this.log.isDebugEnabled()) {
/* 431 */       this.log.debug("Releasing connection [" + httpRoute + "][" + paramBasicPoolEntry.getState() + "]");
/*     */     }
/*     */ 
/*     */     
/* 435 */     this.poolLock.lock();
/*     */     try {
/* 437 */       if (this.shutdown) {
/*     */ 
/*     */         
/* 440 */         closeConnection(paramBasicPoolEntry);
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 445 */       this.leasedConnections.remove(paramBasicPoolEntry);
/*     */       
/* 447 */       RouteSpecificPool routeSpecificPool = getRoutePool(httpRoute, true);
/*     */       
/* 449 */       if (paramBoolean && routeSpecificPool.getCapacity() >= 0) {
/* 450 */         if (this.log.isDebugEnabled()) {
/*     */           String str;
/* 452 */           if (paramLong > 0L) {
/* 453 */             str = "for " + paramLong + " " + paramTimeUnit;
/*     */           } else {
/* 455 */             str = "indefinitely";
/*     */           } 
/* 457 */           this.log.debug("Pooling connection [" + httpRoute + "][" + paramBasicPoolEntry.getState() + "]; keep alive " + str);
/*     */         } 
/*     */         
/* 460 */         routeSpecificPool.freeEntry(paramBasicPoolEntry);
/* 461 */         paramBasicPoolEntry.updateExpiry(paramLong, paramTimeUnit);
/* 462 */         this.freeConnections.add(paramBasicPoolEntry);
/*     */       } else {
/* 464 */         closeConnection(paramBasicPoolEntry);
/* 465 */         routeSpecificPool.dropEntry();
/* 466 */         this.numConnections--;
/*     */       } 
/*     */       
/* 469 */       notifyWaitingThread(routeSpecificPool);
/*     */     } finally {
/*     */       
/* 472 */       this.poolLock.unlock();
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
/*     */   protected BasicPoolEntry getFreeEntry(RouteSpecificPool paramRouteSpecificPool, Object paramObject) {
/* 486 */     BasicPoolEntry basicPoolEntry = null;
/* 487 */     this.poolLock.lock();
/*     */     try {
/* 489 */       boolean bool = false;
/* 490 */       while (!bool)
/*     */       {
/* 492 */         basicPoolEntry = paramRouteSpecificPool.allocEntry(paramObject);
/*     */         
/* 494 */         if (basicPoolEntry != null) {
/* 495 */           if (this.log.isDebugEnabled()) {
/* 496 */             this.log.debug("Getting free connection [" + paramRouteSpecificPool.getRoute() + "][" + paramObject + "]");
/*     */           }
/*     */ 
/*     */           
/* 500 */           this.freeConnections.remove(basicPoolEntry);
/* 501 */           if (basicPoolEntry.isExpired(System.currentTimeMillis())) {
/*     */ 
/*     */             
/* 504 */             if (this.log.isDebugEnabled()) {
/* 505 */               this.log.debug("Closing expired free connection [" + paramRouteSpecificPool.getRoute() + "][" + paramObject + "]");
/*     */             }
/*     */             
/* 508 */             closeConnection(basicPoolEntry);
/*     */ 
/*     */ 
/*     */             
/* 512 */             paramRouteSpecificPool.dropEntry();
/* 513 */             this.numConnections--; continue;
/*     */           } 
/* 515 */           this.leasedConnections.add(basicPoolEntry);
/* 516 */           bool = true;
/*     */           
/*     */           continue;
/*     */         } 
/* 520 */         bool = true;
/* 521 */         if (this.log.isDebugEnabled()) {
/* 522 */           this.log.debug("No free connections [" + paramRouteSpecificPool.getRoute() + "][" + paramObject + "]");
/*     */         }
/*     */       }
/*     */     
/*     */     } finally {
/*     */       
/* 528 */       this.poolLock.unlock();
/*     */     } 
/* 530 */     return basicPoolEntry;
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
/*     */   protected BasicPoolEntry createEntry(RouteSpecificPool paramRouteSpecificPool, ClientConnectionOperator paramClientConnectionOperator) {
/* 547 */     if (this.log.isDebugEnabled()) {
/* 548 */       this.log.debug("Creating new connection [" + paramRouteSpecificPool.getRoute() + "]");
/*     */     }
/*     */ 
/*     */     
/* 552 */     BasicPoolEntry basicPoolEntry = new BasicPoolEntry(paramClientConnectionOperator, paramRouteSpecificPool.getRoute(), this.connTTL, this.connTTLTimeUnit);
/*     */     
/* 554 */     this.poolLock.lock();
/*     */     try {
/* 556 */       paramRouteSpecificPool.createdEntry(basicPoolEntry);
/* 557 */       this.numConnections++;
/* 558 */       this.leasedConnections.add(basicPoolEntry);
/*     */     } finally {
/* 560 */       this.poolLock.unlock();
/*     */     } 
/*     */     
/* 563 */     return basicPoolEntry;
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
/*     */   protected void deleteEntry(BasicPoolEntry paramBasicPoolEntry) {
/* 580 */     HttpRoute httpRoute = paramBasicPoolEntry.getPlannedRoute();
/*     */     
/* 582 */     if (this.log.isDebugEnabled()) {
/* 583 */       this.log.debug("Deleting connection [" + httpRoute + "][" + paramBasicPoolEntry.getState() + "]");
/*     */     }
/*     */ 
/*     */     
/* 587 */     this.poolLock.lock();
/*     */     
/*     */     try {
/* 590 */       closeConnection(paramBasicPoolEntry);
/*     */       
/* 592 */       RouteSpecificPool routeSpecificPool = getRoutePool(httpRoute, true);
/* 593 */       routeSpecificPool.deleteEntry(paramBasicPoolEntry);
/* 594 */       this.numConnections--;
/* 595 */       if (routeSpecificPool.isUnused()) {
/* 596 */         this.routeToPool.remove(httpRoute);
/*     */       }
/*     */     } finally {
/*     */       
/* 600 */       this.poolLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void deleteLeastUsedEntry() {
/* 610 */     this.poolLock.lock();
/*     */     
/*     */     try {
/* 613 */       BasicPoolEntry basicPoolEntry = this.freeConnections.remove();
/*     */       
/* 615 */       if (basicPoolEntry != null) {
/* 616 */         deleteEntry(basicPoolEntry);
/* 617 */       } else if (this.log.isDebugEnabled()) {
/* 618 */         this.log.debug("No free connection to delete");
/*     */       } 
/*     */     } finally {
/*     */       
/* 622 */       this.poolLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void handleLostEntry(HttpRoute paramHttpRoute) {
/* 629 */     this.poolLock.lock();
/*     */     
/*     */     try {
/* 632 */       RouteSpecificPool routeSpecificPool = getRoutePool(paramHttpRoute, true);
/* 633 */       routeSpecificPool.dropEntry();
/* 634 */       if (routeSpecificPool.isUnused()) {
/* 635 */         this.routeToPool.remove(paramHttpRoute);
/*     */       }
/*     */       
/* 638 */       this.numConnections--;
/* 639 */       notifyWaitingThread(routeSpecificPool);
/*     */     } finally {
/*     */       
/* 642 */       this.poolLock.unlock();
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
/*     */   protected void notifyWaitingThread(RouteSpecificPool paramRouteSpecificPool) {
/* 661 */     WaitingThread waitingThread = null;
/*     */     
/* 663 */     this.poolLock.lock();
/*     */     
/*     */     try {
/* 666 */       if (paramRouteSpecificPool != null && paramRouteSpecificPool.hasThread()) {
/* 667 */         if (this.log.isDebugEnabled()) {
/* 668 */           this.log.debug("Notifying thread waiting on pool [" + paramRouteSpecificPool.getRoute() + "]");
/*     */         }
/*     */         
/* 671 */         waitingThread = paramRouteSpecificPool.nextThread();
/* 672 */       } else if (!this.waitingThreads.isEmpty()) {
/* 673 */         if (this.log.isDebugEnabled()) {
/* 674 */           this.log.debug("Notifying thread waiting on any pool");
/*     */         }
/* 676 */         waitingThread = this.waitingThreads.remove();
/* 677 */       } else if (this.log.isDebugEnabled()) {
/* 678 */         this.log.debug("Notifying no-one, there are no waiting threads");
/*     */       } 
/*     */       
/* 681 */       if (waitingThread != null) {
/* 682 */         waitingThread.wakeup();
/*     */       }
/*     */     } finally {
/*     */       
/* 686 */       this.poolLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void deleteClosedConnections() {
/* 693 */     this.poolLock.lock();
/*     */     try {
/* 695 */       Iterator<BasicPoolEntry> iterator = this.freeConnections.iterator();
/* 696 */       while (iterator.hasNext()) {
/* 697 */         BasicPoolEntry basicPoolEntry = iterator.next();
/* 698 */         if (!basicPoolEntry.getConnection().isOpen()) {
/* 699 */           iterator.remove();
/* 700 */           deleteEntry(basicPoolEntry);
/*     */         } 
/*     */       } 
/*     */     } finally {
/* 704 */       this.poolLock.unlock();
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
/*     */   public void closeIdleConnections(long paramLong, TimeUnit paramTimeUnit) {
/* 717 */     Args.notNull(paramTimeUnit, "Time unit");
/* 718 */     long l1 = (paramLong > 0L) ? paramLong : 0L;
/* 719 */     if (this.log.isDebugEnabled()) {
/* 720 */       this.log.debug("Closing connections idle longer than " + l1 + " " + paramTimeUnit);
/*     */     }
/*     */     
/* 723 */     long l2 = System.currentTimeMillis() - paramTimeUnit.toMillis(l1);
/* 724 */     this.poolLock.lock();
/*     */     try {
/* 726 */       Iterator<BasicPoolEntry> iterator = this.freeConnections.iterator();
/* 727 */       while (iterator.hasNext()) {
/* 728 */         BasicPoolEntry basicPoolEntry = iterator.next();
/* 729 */         if (basicPoolEntry.getUpdated() <= l2) {
/* 730 */           if (this.log.isDebugEnabled()) {
/* 731 */             this.log.debug("Closing connection last used @ " + new Date(basicPoolEntry.getUpdated()));
/*     */           }
/* 733 */           iterator.remove();
/* 734 */           deleteEntry(basicPoolEntry);
/*     */         } 
/*     */       } 
/*     */     } finally {
/* 738 */       this.poolLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void closeExpiredConnections() {
/* 744 */     this.log.debug("Closing expired connections");
/* 745 */     long l = System.currentTimeMillis();
/*     */     
/* 747 */     this.poolLock.lock();
/*     */     try {
/* 749 */       Iterator<BasicPoolEntry> iterator = this.freeConnections.iterator();
/* 750 */       while (iterator.hasNext()) {
/* 751 */         BasicPoolEntry basicPoolEntry = iterator.next();
/* 752 */         if (basicPoolEntry.isExpired(l)) {
/* 753 */           if (this.log.isDebugEnabled()) {
/* 754 */             this.log.debug("Closing connection expired @ " + new Date(basicPoolEntry.getExpiry()));
/*     */           }
/* 756 */           iterator.remove();
/* 757 */           deleteEntry(basicPoolEntry);
/*     */         } 
/*     */       } 
/*     */     } finally {
/* 761 */       this.poolLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void shutdown() {
/* 767 */     this.poolLock.lock();
/*     */     try {
/* 769 */       if (this.shutdown) {
/*     */         return;
/*     */       }
/* 772 */       this.shutdown = true;
/*     */ 
/*     */       
/* 775 */       Iterator<BasicPoolEntry> iterator1 = this.leasedConnections.iterator();
/* 776 */       while (iterator1.hasNext()) {
/* 777 */         BasicPoolEntry basicPoolEntry = iterator1.next();
/* 778 */         iterator1.remove();
/* 779 */         closeConnection(basicPoolEntry);
/*     */       } 
/*     */ 
/*     */       
/* 783 */       Iterator<BasicPoolEntry> iterator2 = this.freeConnections.iterator();
/* 784 */       while (iterator2.hasNext()) {
/* 785 */         BasicPoolEntry basicPoolEntry = iterator2.next();
/* 786 */         iterator2.remove();
/*     */         
/* 788 */         if (this.log.isDebugEnabled()) {
/* 789 */           this.log.debug("Closing connection [" + basicPoolEntry.getPlannedRoute() + "][" + basicPoolEntry.getState() + "]");
/*     */         }
/*     */         
/* 792 */         closeConnection(basicPoolEntry);
/*     */       } 
/*     */ 
/*     */       
/* 796 */       Iterator<WaitingThread> iterator = this.waitingThreads.iterator();
/* 797 */       while (iterator.hasNext()) {
/* 798 */         WaitingThread waitingThread = iterator.next();
/* 799 */         iterator.remove();
/* 800 */         waitingThread.wakeup();
/*     */       } 
/*     */       
/* 803 */       this.routeToPool.clear();
/*     */     } finally {
/*     */       
/* 806 */       this.poolLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaxTotalConnections(int paramInt) {
/* 814 */     this.poolLock.lock();
/*     */     try {
/* 816 */       this.maxTotalConnections = paramInt;
/*     */     } finally {
/* 818 */       this.poolLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxTotalConnections() {
/* 827 */     return this.maxTotalConnections;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\tsccm\ConnPoolByRoute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */