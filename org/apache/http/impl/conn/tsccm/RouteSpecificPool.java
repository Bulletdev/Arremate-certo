/*     */ package org.apache.http.impl.conn.tsccm;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.LinkedList;
/*     */ import java.util.ListIterator;
/*     */ import java.util.Queue;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.conn.OperatedClientConnection;
/*     */ import org.apache.http.conn.params.ConnPerRoute;
/*     */ import org.apache.http.conn.routing.HttpRoute;
/*     */ import org.apache.http.util.Args;
/*     */ import org.apache.http.util.Asserts;
/*     */ import org.apache.http.util.LangUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class RouteSpecificPool
/*     */ {
/*  56 */   private final Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */ 
/*     */   
/*     */   protected final HttpRoute route;
/*     */ 
/*     */ 
/*     */   
/*     */   protected final int maxEntries;
/*     */ 
/*     */ 
/*     */   
/*     */   protected final ConnPerRoute connPerRoute;
/*     */ 
/*     */ 
/*     */   
/*     */   protected final LinkedList<BasicPoolEntry> freeEntries;
/*     */ 
/*     */   
/*     */   protected final Queue<WaitingThread> waitingThreads;
/*     */ 
/*     */   
/*     */   protected int numEntries;
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public RouteSpecificPool(HttpRoute paramHttpRoute, int paramInt) {
/*  84 */     this.route = paramHttpRoute;
/*  85 */     this.maxEntries = paramInt;
/*  86 */     this.connPerRoute = new ConnPerRoute()
/*     */       {
/*     */         public int getMaxForRoute(HttpRoute param1HttpRoute) {
/*  89 */           return RouteSpecificPool.this.maxEntries;
/*     */         }
/*     */       };
/*  92 */     this.freeEntries = new LinkedList<BasicPoolEntry>();
/*  93 */     this.waitingThreads = new LinkedList<WaitingThread>();
/*  94 */     this.numEntries = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RouteSpecificPool(HttpRoute paramHttpRoute, ConnPerRoute paramConnPerRoute) {
/* 105 */     this.route = paramHttpRoute;
/* 106 */     this.connPerRoute = paramConnPerRoute;
/* 107 */     this.maxEntries = paramConnPerRoute.getMaxForRoute(paramHttpRoute);
/* 108 */     this.freeEntries = new LinkedList<BasicPoolEntry>();
/* 109 */     this.waitingThreads = new LinkedList<WaitingThread>();
/* 110 */     this.numEntries = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final HttpRoute getRoute() {
/* 120 */     return this.route;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getMaxEntries() {
/* 130 */     return this.maxEntries;
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
/*     */   public boolean isUnused() {
/* 143 */     return (this.numEntries < 1 && this.waitingThreads.isEmpty());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCapacity() {
/* 153 */     return this.connPerRoute.getMaxForRoute(this.route) - this.numEntries;
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
/*     */   public final int getEntryCount() {
/* 165 */     return this.numEntries;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasicPoolEntry allocEntry(Object paramObject) {
/* 175 */     if (!this.freeEntries.isEmpty()) {
/* 176 */       ListIterator<BasicPoolEntry> listIterator = this.freeEntries.listIterator(this.freeEntries.size());
/* 177 */       while (listIterator.hasPrevious()) {
/* 178 */         BasicPoolEntry basicPoolEntry = listIterator.previous();
/* 179 */         if (basicPoolEntry.getState() == null || LangUtils.equals(paramObject, basicPoolEntry.getState())) {
/* 180 */           listIterator.remove();
/* 181 */           return basicPoolEntry;
/*     */         } 
/*     */       } 
/*     */     } 
/* 185 */     if (getCapacity() == 0 && !this.freeEntries.isEmpty()) {
/* 186 */       BasicPoolEntry basicPoolEntry = this.freeEntries.remove();
/* 187 */       basicPoolEntry.shutdownEntry();
/* 188 */       OperatedClientConnection operatedClientConnection = basicPoolEntry.getConnection();
/*     */       try {
/* 190 */         operatedClientConnection.close();
/* 191 */       } catch (IOException iOException) {
/* 192 */         this.log.debug("I/O error closing connection", iOException);
/*     */       } 
/* 194 */       return basicPoolEntry;
/*     */     } 
/* 196 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void freeEntry(BasicPoolEntry paramBasicPoolEntry) {
/* 207 */     if (this.numEntries < 1) {
/* 208 */       throw new IllegalStateException("No entry created for this pool. " + this.route);
/*     */     }
/*     */     
/* 211 */     if (this.numEntries <= this.freeEntries.size()) {
/* 212 */       throw new IllegalStateException("No entry allocated from this pool. " + this.route);
/*     */     }
/*     */     
/* 215 */     this.freeEntries.add(paramBasicPoolEntry);
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
/*     */   public void createdEntry(BasicPoolEntry paramBasicPoolEntry) {
/* 228 */     Args.check(this.route.equals(paramBasicPoolEntry.getPlannedRoute()), "Entry not planned for this pool");
/* 229 */     this.numEntries++;
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
/*     */   public boolean deleteEntry(BasicPoolEntry paramBasicPoolEntry) {
/* 245 */     boolean bool = this.freeEntries.remove(paramBasicPoolEntry);
/* 246 */     if (bool) {
/* 247 */       this.numEntries--;
/*     */     }
/* 249 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dropEntry() {
/* 260 */     Asserts.check((this.numEntries > 0), "There is no entry that could be dropped");
/* 261 */     this.numEntries--;
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
/*     */   public void queueThread(WaitingThread paramWaitingThread) {
/* 274 */     Args.notNull(paramWaitingThread, "Waiting thread");
/* 275 */     this.waitingThreads.add(paramWaitingThread);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasThread() {
/* 286 */     return !this.waitingThreads.isEmpty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WaitingThread nextThread() {
/* 296 */     return this.waitingThreads.peek();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeThread(WaitingThread paramWaitingThread) {
/* 306 */     if (paramWaitingThread == null) {
/*     */       return;
/*     */     }
/*     */     
/* 310 */     this.waitingThreads.remove(paramWaitingThread);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\tsccm\RouteSpecificPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */