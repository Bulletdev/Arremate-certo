/*     */ package org.apache.commons.collections4;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.collection.UnmodifiableCollection;
/*     */ import org.apache.commons.collections4.iterators.UnmodifiableMapIterator;
/*     */ import org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter;
/*     */ import org.apache.commons.collections4.map.UnmodifiableEntrySet;
/*     */ import org.apache.commons.collections4.set.UnmodifiableSet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SplitMapUtils
/*     */ {
/*     */   private static class WrappedGet<K, V>
/*     */     implements IterableMap<K, V>, Unmodifiable
/*     */   {
/*     */     private final Get<K, V> get;
/*     */     
/*     */     private WrappedGet(Get<K, V> param1Get) {
/*  52 */       this.get = param1Get;
/*     */     }
/*     */     
/*     */     public void clear() {
/*  56 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean containsKey(Object param1Object) {
/*  60 */       return this.get.containsKey(param1Object);
/*     */     }
/*     */     
/*     */     public boolean containsValue(Object param1Object) {
/*  64 */       return this.get.containsValue(param1Object);
/*     */     }
/*     */     
/*     */     public Set<Map.Entry<K, V>> entrySet() {
/*  68 */       return UnmodifiableEntrySet.unmodifiableEntrySet(this.get.entrySet());
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/*  73 */       if (param1Object == this) {
/*  74 */         return true;
/*     */       }
/*  76 */       return (param1Object instanceof WrappedGet && ((WrappedGet)param1Object).get.equals(this.get));
/*     */     }
/*     */     
/*     */     public V get(Object param1Object) {
/*  80 */       return this.get.get(param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*  85 */       return "WrappedGet".hashCode() << 4 | this.get.hashCode();
/*     */     }
/*     */     
/*     */     public boolean isEmpty() {
/*  89 */       return this.get.isEmpty();
/*     */     }
/*     */     
/*     */     public Set<K> keySet() {
/*  93 */       return UnmodifiableSet.unmodifiableSet(this.get.keySet());
/*     */     }
/*     */     
/*     */     public V put(K param1K, V param1V) {
/*  97 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public void putAll(Map<? extends K, ? extends V> param1Map) {
/* 101 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public V remove(Object param1Object) {
/* 105 */       return this.get.remove(param1Object);
/*     */     }
/*     */     
/*     */     public int size() {
/* 109 */       return this.get.size();
/*     */     }
/*     */     
/*     */     public Collection<V> values() {
/* 113 */       return UnmodifiableCollection.unmodifiableCollection(this.get.values());
/*     */     }
/*     */     
/*     */     public MapIterator<K, V> mapIterator() {
/*     */       EntrySetToMapIteratorAdapter entrySetToMapIteratorAdapter;
/* 118 */       if (this.get instanceof IterableGet) {
/* 119 */         MapIterator mapIterator = ((IterableGet)this.get).mapIterator();
/*     */       } else {
/* 121 */         entrySetToMapIteratorAdapter = new EntrySetToMapIteratorAdapter(this.get.entrySet());
/*     */       } 
/* 123 */       return UnmodifiableMapIterator.unmodifiableMapIterator((MapIterator)entrySetToMapIteratorAdapter);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class WrappedPut<K, V> implements Map<K, V>, Put<K, V> {
/*     */     private final Put<K, V> put;
/*     */     
/*     */     private WrappedPut(Put<K, V> param1Put) {
/* 131 */       this.put = param1Put;
/*     */     }
/*     */     
/*     */     public void clear() {
/* 135 */       this.put.clear();
/*     */     }
/*     */     
/*     */     public boolean containsKey(Object param1Object) {
/* 139 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean containsValue(Object param1Object) {
/* 143 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Set<Map.Entry<K, V>> entrySet() {
/* 147 */       throw new UnsupportedOperationException();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 152 */       if (param1Object == this) {
/* 153 */         return true;
/*     */       }
/* 155 */       return (param1Object instanceof WrappedPut && ((WrappedPut)param1Object).put.equals(this.put));
/*     */     }
/*     */     
/*     */     public V get(Object param1Object) {
/* 159 */       throw new UnsupportedOperationException();
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 164 */       return "WrappedPut".hashCode() << 4 | this.put.hashCode();
/*     */     }
/*     */     
/*     */     public boolean isEmpty() {
/* 168 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Set<K> keySet() {
/* 172 */       throw new UnsupportedOperationException();
/*     */     }
/*     */ 
/*     */     
/*     */     public V put(K param1K, V param1V) {
/* 177 */       return (V)this.put.put(param1K, param1V);
/*     */     }
/*     */     
/*     */     public void putAll(Map<? extends K, ? extends V> param1Map) {
/* 181 */       this.put.putAll(param1Map);
/*     */     }
/*     */     
/*     */     public V remove(Object param1Object) {
/* 185 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public int size() {
/* 189 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Collection<V> values() {
/* 193 */       throw new UnsupportedOperationException();
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
/*     */   public static <K, V> IterableMap<K, V> readableMap(Get<K, V> paramGet) {
/* 212 */     if (paramGet == null) {
/* 213 */       throw new NullPointerException("Get must not be null");
/*     */     }
/* 215 */     if (paramGet instanceof Map) {
/* 216 */       return (paramGet instanceof IterableMap) ? (IterableMap<K, V>)paramGet : MapUtils.<K, V>iterableMap((Map<K, V>)paramGet);
/*     */     }
/*     */ 
/*     */     
/* 220 */     return new WrappedGet<K, V>(paramGet);
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
/*     */   public static <K, V> Map<K, V> writableMap(Put<K, V> paramPut) {
/* 238 */     if (paramPut == null) {
/* 239 */       throw new NullPointerException("Put must not be null");
/*     */     }
/* 241 */     if (paramPut instanceof Map) {
/* 242 */       return (Map<K, V>)paramPut;
/*     */     }
/* 244 */     return new WrappedPut<K, V>(paramPut);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\SplitMapUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */