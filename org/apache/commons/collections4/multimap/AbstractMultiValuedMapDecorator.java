/*     */ package org.apache.commons.collections4.multimap;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.MapIterator;
/*     */ import org.apache.commons.collections4.MultiSet;
/*     */ import org.apache.commons.collections4.MultiValuedMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractMultiValuedMapDecorator<K, V>
/*     */   implements Serializable, MultiValuedMap<K, V>
/*     */ {
/*     */   private static final long serialVersionUID = 20150612L;
/*     */   private final MultiValuedMap<K, V> map;
/*     */   
/*     */   protected AbstractMultiValuedMapDecorator(MultiValuedMap<K, V> paramMultiValuedMap) {
/*  58 */     if (paramMultiValuedMap == null) {
/*  59 */       throw new NullPointerException("MultiValuedMap must not be null.");
/*     */     }
/*  61 */     this.map = paramMultiValuedMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected MultiValuedMap<K, V> decorated() {
/*  71 */     return this.map;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/*  77 */     return decorated().size();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/*  82 */     return decorated().isEmpty();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsKey(Object paramObject) {
/*  87 */     return decorated().containsKey(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsValue(Object paramObject) {
/*  92 */     return decorated().containsValue(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsMapping(Object paramObject1, Object paramObject2) {
/*  97 */     return decorated().containsMapping(paramObject1, paramObject2);
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection<V> get(K paramK) {
/* 102 */     return decorated().get(paramK);
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection<V> remove(Object paramObject) {
/* 107 */     return decorated().remove(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeMapping(Object paramObject1, Object paramObject2) {
/* 112 */     return decorated().removeMapping(paramObject1, paramObject2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 117 */     decorated().clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean put(K paramK, V paramV) {
/* 122 */     return decorated().put(paramK, paramV);
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<K> keySet() {
/* 127 */     return decorated().keySet();
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection<Map.Entry<K, V>> entries() {
/* 132 */     return decorated().entries();
/*     */   }
/*     */ 
/*     */   
/*     */   public MultiSet<K> keys() {
/* 137 */     return decorated().keys();
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection<V> values() {
/* 142 */     return decorated().values();
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<K, Collection<V>> asMap() {
/* 147 */     return decorated().asMap();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean putAll(K paramK, Iterable<? extends V> paramIterable) {
/* 152 */     return decorated().putAll(paramK, paramIterable);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean putAll(Map<? extends K, ? extends V> paramMap) {
/* 157 */     return decorated().putAll(paramMap);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean putAll(MultiValuedMap<? extends K, ? extends V> paramMultiValuedMap) {
/* 162 */     return decorated().putAll(paramMultiValuedMap);
/*     */   }
/*     */ 
/*     */   
/*     */   public MapIterator<K, V> mapIterator() {
/* 167 */     return decorated().mapIterator();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 172 */     if (paramObject == this) {
/* 173 */       return true;
/*     */     }
/* 175 */     return decorated().equals(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 180 */     return decorated().hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 185 */     return decorated().toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\multimap\AbstractMultiValuedMapDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */