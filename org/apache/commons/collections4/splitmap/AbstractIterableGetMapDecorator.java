/*     */ package org.apache.commons.collections4.splitmap;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.IterableGet;
/*     */ import org.apache.commons.collections4.MapIterator;
/*     */ import org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AbstractIterableGetMapDecorator<K, V>
/*     */   implements IterableGet<K, V>
/*     */ {
/*     */   transient Map<K, V> map;
/*     */   
/*     */   public AbstractIterableGetMapDecorator(Map<K, V> paramMap) {
/*  45 */     if (paramMap == null) {
/*  46 */       throw new NullPointerException("Map must not be null.");
/*     */     }
/*  48 */     this.map = paramMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected AbstractIterableGetMapDecorator() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Map<K, V> decorated() {
/*  64 */     return this.map;
/*     */   }
/*     */   
/*     */   public boolean containsKey(Object paramObject) {
/*  68 */     return decorated().containsKey(paramObject);
/*     */   }
/*     */   
/*     */   public boolean containsValue(Object paramObject) {
/*  72 */     return decorated().containsValue(paramObject);
/*     */   }
/*     */   
/*     */   public Set<Map.Entry<K, V>> entrySet() {
/*  76 */     return decorated().entrySet();
/*     */   }
/*     */   
/*     */   public V get(Object paramObject) {
/*  80 */     return decorated().get(paramObject);
/*     */   }
/*     */   
/*     */   public V remove(Object paramObject) {
/*  84 */     return decorated().remove(paramObject);
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/*  88 */     return decorated().isEmpty();
/*     */   }
/*     */   
/*     */   public Set<K> keySet() {
/*  92 */     return decorated().keySet();
/*     */   }
/*     */   
/*     */   public int size() {
/*  96 */     return decorated().size();
/*     */   }
/*     */   
/*     */   public Collection<V> values() {
/* 100 */     return decorated().values();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MapIterator<K, V> mapIterator() {
/* 108 */     return (MapIterator<K, V>)new EntrySetToMapIteratorAdapter(entrySet());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 113 */     if (paramObject == this) {
/* 114 */       return true;
/*     */     }
/* 116 */     return decorated().equals(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     return decorated().hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 126 */     return decorated().toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\splitmap\AbstractIterableGetMapDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */