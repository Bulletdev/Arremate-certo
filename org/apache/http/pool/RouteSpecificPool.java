/*     */ package org.apache.http.pool;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.Future;
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
/*     */ abstract class RouteSpecificPool<T, C, E extends PoolEntry<T, C>>
/*     */ {
/*     */   private final T route;
/*     */   private final Set<E> leased;
/*     */   private final LinkedList<E> available;
/*     */   private final LinkedList<Future<E>> pending;
/*     */   
/*     */   RouteSpecificPool(T paramT) {
/*  47 */     this.route = paramT;
/*  48 */     this.leased = new HashSet<E>();
/*  49 */     this.available = new LinkedList<E>();
/*  50 */     this.pending = new LinkedList<Future<E>>();
/*     */   }
/*     */   
/*     */   protected abstract E createEntry(C paramC);
/*     */   
/*     */   public final T getRoute() {
/*  56 */     return this.route;
/*     */   }
/*     */   
/*     */   public int getLeasedCount() {
/*  60 */     return this.leased.size();
/*     */   }
/*     */   
/*     */   public int getPendingCount() {
/*  64 */     return this.pending.size();
/*     */   }
/*     */   
/*     */   public int getAvailableCount() {
/*  68 */     return this.available.size();
/*     */   }
/*     */   
/*     */   public int getAllocatedCount() {
/*  72 */     return this.available.size() + this.leased.size();
/*     */   }
/*     */   
/*     */   public E getFree(Object paramObject) {
/*  76 */     if (!this.available.isEmpty()) {
/*  77 */       if (paramObject != null) {
/*  78 */         Iterator<E> iterator1 = this.available.iterator();
/*  79 */         while (iterator1.hasNext()) {
/*  80 */           PoolEntry poolEntry = (PoolEntry)iterator1.next();
/*  81 */           if (paramObject.equals(poolEntry.getState())) {
/*  82 */             iterator1.remove();
/*  83 */             this.leased.add((E)poolEntry);
/*  84 */             return (E)poolEntry;
/*     */           } 
/*     */         } 
/*     */       } 
/*  88 */       Iterator<E> iterator = this.available.iterator();
/*  89 */       while (iterator.hasNext()) {
/*  90 */         PoolEntry poolEntry = (PoolEntry)iterator.next();
/*  91 */         if (poolEntry.getState() == null) {
/*  92 */           iterator.remove();
/*  93 */           this.leased.add((E)poolEntry);
/*  94 */           return (E)poolEntry;
/*     */         } 
/*     */       } 
/*     */     } 
/*  98 */     return null;
/*     */   }
/*     */   
/*     */   public E getLastUsed() {
/* 102 */     return this.available.isEmpty() ? null : this.available.getLast();
/*     */   }
/*     */   
/*     */   public boolean remove(E paramE) {
/* 106 */     Args.notNull(paramE, "Pool entry");
/* 107 */     if (!this.available.remove(paramE) && 
/* 108 */       !this.leased.remove(paramE)) {
/* 109 */       return false;
/*     */     }
/*     */     
/* 112 */     return true;
/*     */   }
/*     */   
/*     */   public void free(E paramE, boolean paramBoolean) {
/* 116 */     Args.notNull(paramE, "Pool entry");
/* 117 */     boolean bool = this.leased.remove(paramE);
/* 118 */     Asserts.check(bool, "Entry %s has not been leased from this pool", paramE);
/* 119 */     if (paramBoolean) {
/* 120 */       this.available.addFirst(paramE);
/*     */     }
/*     */   }
/*     */   
/*     */   public E add(C paramC) {
/* 125 */     E e = createEntry(paramC);
/* 126 */     this.leased.add(e);
/* 127 */     return e;
/*     */   }
/*     */   
/*     */   public void queue(Future<E> paramFuture) {
/* 131 */     if (paramFuture == null) {
/*     */       return;
/*     */     }
/* 134 */     this.pending.add(paramFuture);
/*     */   }
/*     */   
/*     */   public Future<E> nextPending() {
/* 138 */     return this.pending.poll();
/*     */   }
/*     */   
/*     */   public void unqueue(Future<E> paramFuture) {
/* 142 */     if (paramFuture == null) {
/*     */       return;
/*     */     }
/*     */     
/* 146 */     this.pending.remove(paramFuture);
/*     */   }
/*     */   
/*     */   public void shutdown() {
/* 150 */     for (Future<E> future : this.pending) {
/* 151 */       future.cancel(true);
/*     */     }
/* 153 */     this.pending.clear();
/* 154 */     for (PoolEntry poolEntry : this.available) {
/* 155 */       poolEntry.close();
/*     */     }
/* 157 */     this.available.clear();
/* 158 */     for (PoolEntry poolEntry : this.leased) {
/* 159 */       poolEntry.close();
/*     */     }
/* 161 */     this.leased.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 166 */     StringBuilder stringBuilder = new StringBuilder();
/* 167 */     stringBuilder.append("[route: ");
/* 168 */     stringBuilder.append(this.route);
/* 169 */     stringBuilder.append("][leased: ");
/* 170 */     stringBuilder.append(this.leased.size());
/* 171 */     stringBuilder.append("][available: ");
/* 172 */     stringBuilder.append(this.available.size());
/* 173 */     stringBuilder.append("][pending: ");
/* 174 */     stringBuilder.append(this.pending.size());
/* 175 */     stringBuilder.append("]");
/* 176 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\pool\RouteSpecificPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */