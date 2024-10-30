/*     */ package org.apache.commons.collections4.map;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.CollectionUtils;
/*     */ import org.apache.commons.collections4.collection.CompositeCollection;
/*     */ import org.apache.commons.collections4.set.CompositeSet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CompositeMap<K, V>
/*     */   extends AbstractIterableMap<K, V>
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -6096931280583808322L;
/*     */   private Map<K, V>[] composite;
/*     */   private MapMutator<K, V> mutator;
/*     */   
/*     */   public CompositeMap() {
/*  61 */     this((Map<K, V>[])new Map[0], (MapMutator<K, V>)null);
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
/*     */   public CompositeMap(Map<K, V> paramMap1, Map<K, V> paramMap2) {
/*  73 */     this((Map<K, V>[])new Map[] { paramMap1, paramMap2 }, (MapMutator<K, V>)null);
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
/*     */   public CompositeMap(Map<K, V> paramMap1, Map<K, V> paramMap2, MapMutator<K, V> paramMapMutator) {
/*  85 */     this((Map<K, V>[])new Map[] { paramMap1, paramMap2 }, paramMapMutator);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CompositeMap(Map<K, V>... paramVarArgs) {
/*  96 */     this(paramVarArgs, (MapMutator<K, V>)null);
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
/*     */   public CompositeMap(Map<K, V>[] paramArrayOfMap, MapMutator<K, V> paramMapMutator) {
/* 108 */     this.mutator = paramMapMutator;
/* 109 */     this.composite = (Map<K, V>[])new Map[0];
/* 110 */     for (int i = paramArrayOfMap.length - 1; i >= 0; i--) {
/* 111 */       addComposited(paramArrayOfMap[i]);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMutator(MapMutator<K, V> paramMapMutator) {
/* 122 */     this.mutator = paramMapMutator;
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
/*     */   public synchronized void addComposited(Map<K, V> paramMap) throws IllegalArgumentException {
/* 134 */     for (int i = this.composite.length - 1; i >= 0; i--) {
/* 135 */       Collection<K> collection = CollectionUtils.intersection(this.composite[i].keySet(), paramMap.keySet());
/* 136 */       if (collection.size() != 0) {
/* 137 */         if (this.mutator == null) {
/* 138 */           throw new IllegalArgumentException("Key collision adding Map to CompositeMap");
/*     */         }
/* 140 */         this.mutator.resolveCollision(this, this.composite[i], paramMap, collection);
/*     */       } 
/*     */     } 
/* 143 */     Map[] arrayOfMap = new Map[this.composite.length + 1];
/* 144 */     System.arraycopy(this.composite, 0, arrayOfMap, 0, this.composite.length);
/* 145 */     arrayOfMap[arrayOfMap.length - 1] = paramMap;
/* 146 */     this.composite = (Map<K, V>[])arrayOfMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized Map<K, V> removeComposited(Map<K, V> paramMap) {
/* 157 */     int i = this.composite.length;
/* 158 */     for (byte b = 0; b < i; b++) {
/* 159 */       if (this.composite[b].equals(paramMap)) {
/* 160 */         Map[] arrayOfMap = new Map[i - 1];
/* 161 */         System.arraycopy(this.composite, 0, arrayOfMap, 0, b);
/* 162 */         System.arraycopy(this.composite, b + 1, arrayOfMap, b, i - b - 1);
/* 163 */         this.composite = (Map<K, V>[])arrayOfMap;
/* 164 */         return paramMap;
/*     */       } 
/*     */     } 
/* 167 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 177 */     for (int i = this.composite.length - 1; i >= 0; i--) {
/* 178 */       this.composite[i].clear();
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
/*     */ 
/*     */   
/*     */   public boolean containsKey(Object paramObject) {
/* 199 */     for (int i = this.composite.length - 1; i >= 0; i--) {
/* 200 */       if (this.composite[i].containsKey(paramObject)) {
/* 201 */         return true;
/*     */       }
/*     */     } 
/* 204 */     return false;
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
/*     */   public boolean containsValue(Object paramObject) {
/* 224 */     for (int i = this.composite.length - 1; i >= 0; i--) {
/* 225 */       if (this.composite[i].containsValue(paramObject)) {
/* 226 */         return true;
/*     */       }
/*     */     } 
/* 229 */     return false;
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
/*     */   public Set<Map.Entry<K, V>> entrySet() {
/* 250 */     CompositeSet compositeSet = new CompositeSet();
/* 251 */     for (int i = this.composite.length - 1; i >= 0; i--) {
/* 252 */       compositeSet.addComposited(this.composite[i].entrySet());
/*     */     }
/* 254 */     return (Set<Map.Entry<K, V>>)compositeSet;
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
/*     */   public V get(Object paramObject) {
/* 282 */     for (int i = this.composite.length - 1; i >= 0; i--) {
/* 283 */       if (this.composite[i].containsKey(paramObject)) {
/* 284 */         return this.composite[i].get(paramObject);
/*     */       }
/*     */     } 
/* 287 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 296 */     for (int i = this.composite.length - 1; i >= 0; i--) {
/* 297 */       if (!this.composite[i].isEmpty()) {
/* 298 */         return false;
/*     */       }
/*     */     } 
/* 301 */     return true;
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
/*     */   public Set<K> keySet() {
/* 320 */     CompositeSet compositeSet = new CompositeSet();
/* 321 */     for (int i = this.composite.length - 1; i >= 0; i--) {
/* 322 */       compositeSet.addComposited(this.composite[i].keySet());
/*     */     }
/* 324 */     return (Set<K>)compositeSet;
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
/*     */   
/*     */   public V put(K paramK, V paramV) {
/* 353 */     if (this.mutator == null) {
/* 354 */       throw new UnsupportedOperationException("No mutator specified");
/*     */     }
/* 356 */     return this.mutator.put(this, this.composite, paramK, paramV);
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
/*     */   public void putAll(Map<? extends K, ? extends V> paramMap) {
/* 382 */     if (this.mutator == null) {
/* 383 */       throw new UnsupportedOperationException("No mutator specified");
/*     */     }
/* 385 */     this.mutator.putAll(this, this.composite, paramMap);
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
/*     */   
/*     */   public V remove(Object paramObject) {
/* 414 */     for (int i = this.composite.length - 1; i >= 0; i--) {
/* 415 */       if (this.composite[i].containsKey(paramObject)) {
/* 416 */         return this.composite[i].remove(paramObject);
/*     */       }
/*     */     } 
/* 419 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 430 */     int i = 0;
/* 431 */     for (int j = this.composite.length - 1; j >= 0; j--) {
/* 432 */       i += this.composite[j].size();
/*     */     }
/* 434 */     return i;
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
/*     */   public Collection<V> values() {
/* 451 */     CompositeCollection compositeCollection = new CompositeCollection();
/* 452 */     for (int i = this.composite.length - 1; i >= 0; i--) {
/* 453 */       compositeCollection.addComposited(this.composite[i].values());
/*     */     }
/* 455 */     return (Collection<V>)compositeCollection;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 466 */     if (paramObject instanceof Map) {
/* 467 */       Map map = (Map)paramObject;
/* 468 */       return entrySet().equals(map.entrySet());
/*     */     } 
/* 470 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 479 */     int i = 0;
/* 480 */     for (Map.Entry<K, V> entry : entrySet()) {
/* 481 */       i += entry.hashCode();
/*     */     }
/* 483 */     return i;
/*     */   }
/*     */   
/*     */   public static interface MapMutator<K, V> extends Serializable {
/*     */     void resolveCollision(CompositeMap<K, V> param1CompositeMap, Map<K, V> param1Map1, Map<K, V> param1Map2, Collection<K> param1Collection);
/*     */     
/*     */     V put(CompositeMap<K, V> param1CompositeMap, Map<K, V>[] param1ArrayOfMap, K param1K, V param1V);
/*     */     
/*     */     void putAll(CompositeMap<K, V> param1CompositeMap, Map<K, V>[] param1ArrayOfMap, Map<? extends K, ? extends V> param1Map);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\map\CompositeMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */