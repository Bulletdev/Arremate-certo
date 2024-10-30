/*     */ package org.apache.commons.collections4.map;
/*     */ 
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.ListIterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.SortedMap;
/*     */ import org.apache.commons.collections4.IterableSortedMap;
/*     */ import org.apache.commons.collections4.MapIterator;
/*     */ import org.apache.commons.collections4.OrderedMapIterator;
/*     */ import org.apache.commons.collections4.iterators.ListIteratorWrapper;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractSortedMapDecorator<K, V>
/*     */   extends AbstractMapDecorator<K, V>
/*     */   implements IterableSortedMap<K, V>
/*     */ {
/*     */   protected AbstractSortedMapDecorator() {}
/*     */   
/*     */   public AbstractSortedMapDecorator(SortedMap<K, V> paramSortedMap) {
/*  65 */     super(paramSortedMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SortedMap<K, V> decorated() {
/*  75 */     return (SortedMap<K, V>)super.decorated();
/*     */   }
/*     */ 
/*     */   
/*     */   public Comparator<? super K> comparator() {
/*  80 */     return decorated().comparator();
/*     */   }
/*     */   
/*     */   public K firstKey() {
/*  84 */     return decorated().firstKey();
/*     */   }
/*     */   
/*     */   public K lastKey() {
/*  88 */     return decorated().lastKey();
/*     */   }
/*     */   
/*     */   public SortedMap<K, V> subMap(K paramK1, K paramK2) {
/*  92 */     return decorated().subMap(paramK1, paramK2);
/*     */   }
/*     */   
/*     */   public SortedMap<K, V> headMap(K paramK) {
/*  96 */     return decorated().headMap(paramK);
/*     */   }
/*     */   
/*     */   public SortedMap<K, V> tailMap(K paramK) {
/* 100 */     return decorated().tailMap(paramK);
/*     */   }
/*     */   
/*     */   public K previousKey(K paramK) {
/* 104 */     SortedMap<K, V> sortedMap = headMap(paramK);
/* 105 */     return sortedMap.isEmpty() ? null : sortedMap.lastKey();
/*     */   }
/*     */   
/*     */   public K nextKey(K paramK) {
/* 109 */     Iterator<K> iterator = tailMap(paramK).keySet().iterator();
/* 110 */     iterator.next();
/* 111 */     return iterator.hasNext() ? iterator.next() : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OrderedMapIterator<K, V> mapIterator() {
/* 119 */     return new SortedMapIterator<K, V>(entrySet());
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
/*     */   protected static class SortedMapIterator<K, V>
/*     */     extends EntrySetToMapIteratorAdapter<K, V>
/*     */     implements OrderedMapIterator<K, V>
/*     */   {
/*     */     protected SortedMapIterator(Set<Map.Entry<K, V>> param1Set) {
/* 136 */       super(param1Set);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public synchronized void reset() {
/* 144 */       super.reset();
/* 145 */       this.iterator = (Iterator<Map.Entry<K, V>>)new ListIteratorWrapper(this.iterator);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean hasPrevious() {
/* 152 */       return ((ListIterator)this.iterator).hasPrevious();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public K previous() {
/* 159 */       this.entry = ((ListIterator<Map.Entry<K, V>>)this.iterator).previous();
/* 160 */       return getKey();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\map\AbstractSortedMapDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */