/*     */ package org.apache.commons.collections4.map;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.MapIterator;
/*     */ import org.apache.commons.collections4.ResettableIterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntrySetToMapIteratorAdapter<K, V>
/*     */   implements MapIterator<K, V>, ResettableIterator<K>
/*     */ {
/*     */   Set<Map.Entry<K, V>> entrySet;
/*     */   transient Iterator<Map.Entry<K, V>> iterator;
/*     */   transient Map.Entry<K, V> entry;
/*     */   
/*     */   public EntrySetToMapIteratorAdapter(Set<Map.Entry<K, V>> paramSet) {
/*  48 */     this.entrySet = paramSet;
/*  49 */     reset();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public K getKey() {
/*  56 */     return current().getKey();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public V getValue() {
/*  63 */     return current().getValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public V setValue(V paramV) {
/*  70 */     return current().setValue(paramV);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasNext() {
/*  77 */     return this.iterator.hasNext();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public K next() {
/*  84 */     this.entry = this.iterator.next();
/*  85 */     return getKey();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void reset() {
/*  92 */     this.iterator = this.entrySet.iterator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove() {
/*  99 */     this.iterator.remove();
/* 100 */     this.entry = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected synchronized Map.Entry<K, V> current() {
/* 108 */     if (this.entry == null) {
/* 109 */       throw new IllegalStateException();
/*     */     }
/* 111 */     return this.entry;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\map\EntrySetToMapIteratorAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */