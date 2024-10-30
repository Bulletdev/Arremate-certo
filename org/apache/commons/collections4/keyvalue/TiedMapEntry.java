/*     */ package org.apache.commons.collections4.keyvalue;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.collections4.KeyValue;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TiedMapEntry<K, V>
/*     */   implements Serializable, Map.Entry<K, V>, KeyValue<K, V>
/*     */ {
/*     */   private static final long serialVersionUID = -8453869361373831205L;
/*     */   private final Map<K, V> map;
/*     */   private final K key;
/*     */   
/*     */   public TiedMapEntry(Map<K, V> paramMap, K paramK) {
/*  52 */     this.map = paramMap;
/*  53 */     this.key = paramK;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public K getKey() {
/*  64 */     return this.key;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public V getValue() {
/*  73 */     return this.map.get(this.key);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public V setValue(V paramV) {
/*  84 */     if (paramV == this) {
/*  85 */       throw new IllegalArgumentException("Cannot set value to this map entry");
/*     */     }
/*  87 */     return this.map.put(this.key, paramV);
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
/*     */   public boolean equals(Object paramObject) {
/* 100 */     if (paramObject == this) {
/* 101 */       return true;
/*     */     }
/* 103 */     if (!(paramObject instanceof Map.Entry)) {
/* 104 */       return false;
/*     */     }
/* 106 */     Map.Entry entry = (Map.Entry)paramObject;
/* 107 */     V v = getValue();
/* 108 */     return (((this.key == null) ? (entry.getKey() == null) : this.key.equals(entry.getKey())) && ((v == null) ? (entry.getValue() == null) : v.equals(entry.getValue())));
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
/*     */   public int hashCode() {
/* 122 */     V v = getValue();
/* 123 */     return ((getKey() == null) ? 0 : getKey().hashCode()) ^ ((v == null) ? 0 : v.hashCode());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 134 */     return (new StringBuilder()).append(getKey()).append("=").append(getValue()).toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\keyvalue\TiedMapEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */