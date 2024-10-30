/*     */ package org.apache.commons.collections4.map;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractMapDecorator<K, V>
/*     */   extends AbstractIterableMap<K, V>
/*     */ {
/*     */   transient Map<K, V> map;
/*     */   
/*     */   protected AbstractMapDecorator() {}
/*     */   
/*     */   protected AbstractMapDecorator(Map<K, V> paramMap) {
/*  61 */     if (paramMap == null) {
/*  62 */       throw new NullPointerException("Map must not be null.");
/*     */     }
/*  64 */     this.map = paramMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Map<K, V> decorated() {
/*  73 */     return this.map;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  78 */     decorated().clear();
/*     */   }
/*     */   
/*     */   public boolean containsKey(Object paramObject) {
/*  82 */     return decorated().containsKey(paramObject);
/*     */   }
/*     */   
/*     */   public boolean containsValue(Object paramObject) {
/*  86 */     return decorated().containsValue(paramObject);
/*     */   }
/*     */   
/*     */   public Set<Map.Entry<K, V>> entrySet() {
/*  90 */     return decorated().entrySet();
/*     */   }
/*     */   
/*     */   public V get(Object paramObject) {
/*  94 */     return decorated().get(paramObject);
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/*  98 */     return decorated().isEmpty();
/*     */   }
/*     */   
/*     */   public Set<K> keySet() {
/* 102 */     return decorated().keySet();
/*     */   }
/*     */   
/*     */   public V put(K paramK, V paramV) {
/* 106 */     return decorated().put(paramK, paramV);
/*     */   }
/*     */   
/*     */   public void putAll(Map<? extends K, ? extends V> paramMap) {
/* 110 */     decorated().putAll(paramMap);
/*     */   }
/*     */   
/*     */   public V remove(Object paramObject) {
/* 114 */     return decorated().remove(paramObject);
/*     */   }
/*     */   
/*     */   public int size() {
/* 118 */     return decorated().size();
/*     */   }
/*     */   
/*     */   public Collection<V> values() {
/* 122 */     return decorated().values();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 127 */     if (paramObject == this) {
/* 128 */       return true;
/*     */     }
/* 130 */     return decorated().equals(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 135 */     return decorated().hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 140 */     return decorated().toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\map\AbstractMapDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */