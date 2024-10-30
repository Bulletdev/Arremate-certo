/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.c;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.NavigableMap;
/*     */ import java.util.NavigableSet;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.Set;
/*     */ import java.util.SortedMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @c
/*     */ abstract class j<K, V>
/*     */   extends bW.o<K, V>
/*     */   implements NavigableMap<K, V>
/*     */ {
/*     */   public abstract V get(Object paramObject);
/*     */   
/*     */   public Map.Entry<K, V> firstEntry() {
/*  43 */     return bH.<Map.Entry<K, V>>b(c(), (Map.Entry<K, V>)null);
/*     */   }
/*     */ 
/*     */   
/*     */   public Map.Entry<K, V> lastEntry() {
/*  48 */     return bH.<Map.Entry<K, V>>b(f(), (Map.Entry<K, V>)null);
/*     */   }
/*     */ 
/*     */   
/*     */   public Map.Entry<K, V> pollFirstEntry() {
/*  53 */     return bH.<Map.Entry<K, V>>c(c());
/*     */   }
/*     */ 
/*     */   
/*     */   public Map.Entry<K, V> pollLastEntry() {
/*  58 */     return bH.<Map.Entry<K, V>>c(f());
/*     */   }
/*     */ 
/*     */   
/*     */   public K firstKey() {
/*  63 */     Map.Entry<K, V> entry = firstEntry();
/*  64 */     if (entry == null) {
/*  65 */       throw new NoSuchElementException();
/*     */     }
/*  67 */     return entry.getKey();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public K lastKey() {
/*  73 */     Map.Entry<K, V> entry = lastEntry();
/*  74 */     if (entry == null) {
/*  75 */       throw new NoSuchElementException();
/*     */     }
/*  77 */     return entry.getKey();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Map.Entry<K, V> lowerEntry(K paramK) {
/*  83 */     return headMap(paramK, false).lastEntry();
/*     */   }
/*     */ 
/*     */   
/*     */   public Map.Entry<K, V> floorEntry(K paramK) {
/*  88 */     return headMap(paramK, true).lastEntry();
/*     */   }
/*     */ 
/*     */   
/*     */   public Map.Entry<K, V> ceilingEntry(K paramK) {
/*  93 */     return tailMap(paramK, true).firstEntry();
/*     */   }
/*     */ 
/*     */   
/*     */   public Map.Entry<K, V> higherEntry(K paramK) {
/*  98 */     return tailMap(paramK, false).firstEntry();
/*     */   }
/*     */ 
/*     */   
/*     */   public K lowerKey(K paramK) {
/* 103 */     return bW.b(lowerEntry(paramK));
/*     */   }
/*     */ 
/*     */   
/*     */   public K floorKey(K paramK) {
/* 108 */     return bW.b(floorEntry(paramK));
/*     */   }
/*     */ 
/*     */   
/*     */   public K ceilingKey(K paramK) {
/* 113 */     return bW.b(ceilingEntry(paramK));
/*     */   }
/*     */ 
/*     */   
/*     */   public K higherKey(K paramK) {
/* 118 */     return bW.b(higherEntry(paramK));
/*     */   }
/*     */ 
/*     */   
/*     */   abstract Iterator<Map.Entry<K, V>> f();
/*     */   
/*     */   public SortedMap<K, V> subMap(K paramK1, K paramK2) {
/* 125 */     return subMap(paramK1, true, paramK2, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public SortedMap<K, V> headMap(K paramK) {
/* 130 */     return headMap(paramK, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public SortedMap<K, V> tailMap(K paramK) {
/* 135 */     return tailMap(paramK, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public NavigableSet<K> navigableKeySet() {
/* 140 */     return new bW.s<>(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<K> keySet() {
/* 145 */     return navigableKeySet();
/*     */   }
/*     */ 
/*     */   
/*     */   public NavigableSet<K> descendingKeySet() {
/* 150 */     return descendingMap().navigableKeySet();
/*     */   }
/*     */ 
/*     */   
/*     */   public NavigableMap<K, V> descendingMap() {
/* 155 */     return new a();
/*     */   }
/*     */   
/*     */   private final class a
/*     */     extends bW.e<K, V> {
/*     */     NavigableMap<K, V> b() {
/* 161 */       return this.a;
/*     */     }
/*     */     private a(j this$0) {}
/*     */     
/*     */     Iterator<Map.Entry<K, V>> c() {
/* 166 */       return this.a.f();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */