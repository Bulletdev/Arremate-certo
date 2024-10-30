/*     */ package org.h2.util;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CacheTQ
/*     */   implements Cache
/*     */ {
/*     */   static final String TYPE_NAME = "TQ";
/*     */   private final Cache lru;
/*     */   private final Cache fifo;
/*  24 */   private final SmallLRUCache<Integer, Object> recentlyUsed = SmallLRUCache.newInstance(1024);
/*     */   
/*  26 */   private int lastUsed = -1;
/*     */   
/*     */   private int maxMemory;
/*     */   
/*     */   CacheTQ(CacheWriter paramCacheWriter, int paramInt) {
/*  31 */     this.maxMemory = paramInt;
/*  32 */     this.lru = new CacheLRU(paramCacheWriter, (int)(paramInt * 0.8D), false);
/*  33 */     this.fifo = new CacheLRU(paramCacheWriter, (int)(paramInt * 0.2D), true);
/*  34 */     setMaxMemory(4 * paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  39 */     this.lru.clear();
/*  40 */     this.fifo.clear();
/*  41 */     this.recentlyUsed.clear();
/*  42 */     this.lastUsed = -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public CacheObject find(int paramInt) {
/*  47 */     CacheObject cacheObject = this.lru.find(paramInt);
/*  48 */     if (cacheObject == null) {
/*  49 */       cacheObject = this.fifo.find(paramInt);
/*     */     }
/*  51 */     return cacheObject;
/*     */   }
/*     */ 
/*     */   
/*     */   public CacheObject get(int paramInt) {
/*  56 */     CacheObject cacheObject = this.lru.find(paramInt);
/*  57 */     if (cacheObject != null) {
/*  58 */       return cacheObject;
/*     */     }
/*  60 */     cacheObject = this.fifo.find(paramInt);
/*  61 */     if (cacheObject != null && !cacheObject.isStream()) {
/*  62 */       if (this.recentlyUsed.get(Integer.valueOf(paramInt)) != null) {
/*  63 */         if (this.lastUsed != paramInt) {
/*  64 */           this.fifo.remove(paramInt);
/*  65 */           this.lru.put(cacheObject);
/*     */         } 
/*     */       } else {
/*  68 */         this.recentlyUsed.put(Integer.valueOf(paramInt), this);
/*     */       } 
/*  70 */       this.lastUsed = paramInt;
/*     */     } 
/*  72 */     return cacheObject;
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayList<CacheObject> getAllChanged() {
/*  77 */     ArrayList<?> arrayList = New.arrayList();
/*  78 */     arrayList.addAll(this.lru.getAllChanged());
/*  79 */     arrayList.addAll(this.fifo.getAllChanged());
/*  80 */     return (ArrayList)arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMaxMemory() {
/*  85 */     return this.maxMemory;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMemory() {
/*  90 */     return this.lru.getMemory() + this.fifo.getMemory();
/*     */   }
/*     */ 
/*     */   
/*     */   public void put(CacheObject paramCacheObject) {
/*  95 */     if (paramCacheObject.isStream()) {
/*  96 */       this.fifo.put(paramCacheObject);
/*  97 */     } else if (this.recentlyUsed.get(Integer.valueOf(paramCacheObject.getPos())) != null) {
/*  98 */       this.lru.put(paramCacheObject);
/*     */     } else {
/* 100 */       this.fifo.put(paramCacheObject);
/* 101 */       this.lastUsed = paramCacheObject.getPos();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean remove(int paramInt) {
/* 107 */     boolean bool = this.lru.remove(paramInt);
/* 108 */     if (!bool) {
/* 109 */       bool = this.fifo.remove(paramInt);
/*     */     }
/* 111 */     this.recentlyUsed.remove(Integer.valueOf(paramInt));
/* 112 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMaxMemory(int paramInt) {
/* 117 */     this.maxMemory = paramInt;
/* 118 */     this.lru.setMaxMemory((int)(paramInt * 0.8D));
/* 119 */     this.fifo.setMaxMemory((int)(paramInt * 0.2D));
/* 120 */     this.recentlyUsed.setMaxSize(4 * paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public CacheObject update(int paramInt, CacheObject paramCacheObject) {
/* 125 */     if (this.lru.find(paramInt) != null) {
/* 126 */       return this.lru.update(paramInt, paramCacheObject);
/*     */     }
/* 128 */     return this.fifo.update(paramInt, paramCacheObject);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\CacheTQ.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */