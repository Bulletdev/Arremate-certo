/*    */ package org.h2.util;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class CacheSecondLevel
/*    */   implements Cache
/*    */ {
/*    */   private final Cache baseCache;
/*    */   private final Map<Integer, CacheObject> map;
/*    */   
/*    */   CacheSecondLevel(Cache paramCache, Map<Integer, CacheObject> paramMap) {
/* 21 */     this.baseCache = paramCache;
/* 22 */     this.map = paramMap;
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 27 */     this.map.clear();
/* 28 */     this.baseCache.clear();
/*    */   }
/*    */ 
/*    */   
/*    */   public CacheObject find(int paramInt) {
/* 33 */     CacheObject cacheObject = this.baseCache.find(paramInt);
/* 34 */     if (cacheObject == null) {
/* 35 */       cacheObject = this.map.get(Integer.valueOf(paramInt));
/*    */     }
/* 37 */     return cacheObject;
/*    */   }
/*    */ 
/*    */   
/*    */   public CacheObject get(int paramInt) {
/* 42 */     CacheObject cacheObject = this.baseCache.get(paramInt);
/* 43 */     if (cacheObject == null) {
/* 44 */       cacheObject = this.map.get(Integer.valueOf(paramInt));
/*    */     }
/* 46 */     return cacheObject;
/*    */   }
/*    */ 
/*    */   
/*    */   public ArrayList<CacheObject> getAllChanged() {
/* 51 */     return this.baseCache.getAllChanged();
/*    */   }
/*    */ 
/*    */   
/*    */   public int getMaxMemory() {
/* 56 */     return this.baseCache.getMaxMemory();
/*    */   }
/*    */ 
/*    */   
/*    */   public int getMemory() {
/* 61 */     return this.baseCache.getMemory();
/*    */   }
/*    */ 
/*    */   
/*    */   public void put(CacheObject paramCacheObject) {
/* 66 */     this.baseCache.put(paramCacheObject);
/* 67 */     this.map.put(Integer.valueOf(paramCacheObject.getPos()), paramCacheObject);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean remove(int paramInt) {
/* 72 */     boolean bool = this.baseCache.remove(paramInt);
/* 73 */     return bool | ((this.map.remove(Integer.valueOf(paramInt)) != null) ? 1 : 0);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setMaxMemory(int paramInt) {
/* 79 */     this.baseCache.setMaxMemory(paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public CacheObject update(int paramInt, CacheObject paramCacheObject) {
/* 84 */     CacheObject cacheObject = this.baseCache.update(paramInt, paramCacheObject);
/* 85 */     this.map.put(Integer.valueOf(paramInt), paramCacheObject);
/* 86 */     return cacheObject;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\CacheSecondLevel.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */