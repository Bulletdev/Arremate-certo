/*     */ package org.apache.commons.collections4.map;
/*     */ 
/*     */ import java.util.Comparator;
/*     */ import java.util.SortedMap;
/*     */ import org.apache.commons.collections4.Factory;
/*     */ import org.apache.commons.collections4.Transformer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LazySortedMap<K, V>
/*     */   extends LazyMap<K, V>
/*     */   implements SortedMap<K, V>
/*     */ {
/*     */   private static final long serialVersionUID = 2715322183617658933L;
/*     */   
/*     */   public static <K, V> LazySortedMap<K, V> lazySortedMap(SortedMap<K, V> paramSortedMap, Factory<? extends V> paramFactory) {
/*  77 */     return new LazySortedMap<K, V>(paramSortedMap, paramFactory);
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
/*     */   public static <K, V> LazySortedMap<K, V> lazySortedMap(SortedMap<K, V> paramSortedMap, Transformer<? super K, ? extends V> paramTransformer) {
/*  93 */     return new LazySortedMap<K, V>(paramSortedMap, paramTransformer);
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
/*     */   protected LazySortedMap(SortedMap<K, V> paramSortedMap, Factory<? extends V> paramFactory) {
/* 105 */     super(paramSortedMap, paramFactory);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected LazySortedMap(SortedMap<K, V> paramSortedMap, Transformer<? super K, ? extends V> paramTransformer) {
/* 116 */     super(paramSortedMap, paramTransformer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SortedMap<K, V> getSortedMap() {
/* 126 */     return (SortedMap<K, V>)this.map;
/*     */   }
/*     */ 
/*     */   
/*     */   public K firstKey() {
/* 131 */     return getSortedMap().firstKey();
/*     */   }
/*     */   
/*     */   public K lastKey() {
/* 135 */     return getSortedMap().lastKey();
/*     */   }
/*     */   
/*     */   public Comparator<? super K> comparator() {
/* 139 */     return getSortedMap().comparator();
/*     */   }
/*     */   
/*     */   public SortedMap<K, V> subMap(K paramK1, K paramK2) {
/* 143 */     SortedMap<K, V> sortedMap = getSortedMap().subMap(paramK1, paramK2);
/* 144 */     return new LazySortedMap(sortedMap, this.factory);
/*     */   }
/*     */   
/*     */   public SortedMap<K, V> headMap(K paramK) {
/* 148 */     SortedMap<K, V> sortedMap = getSortedMap().headMap(paramK);
/* 149 */     return new LazySortedMap(sortedMap, this.factory);
/*     */   }
/*     */   
/*     */   public SortedMap<K, V> tailMap(K paramK) {
/* 153 */     SortedMap<K, V> sortedMap = getSortedMap().tailMap(paramK);
/* 154 */     return new LazySortedMap(sortedMap, this.factory);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\map\LazySortedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */