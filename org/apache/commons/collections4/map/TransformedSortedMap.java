/*     */ package org.apache.commons.collections4.map;
/*     */ 
/*     */ import java.util.Comparator;
/*     */ import java.util.Map;
/*     */ import java.util.SortedMap;
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
/*     */ public class TransformedSortedMap<K, V>
/*     */   extends TransformedMap<K, V>
/*     */   implements SortedMap<K, V>
/*     */ {
/*     */   private static final long serialVersionUID = -8751771676410385778L;
/*     */   
/*     */   public static <K, V> TransformedSortedMap<K, V> transformingSortedMap(SortedMap<K, V> paramSortedMap, Transformer<? super K, ? extends K> paramTransformer, Transformer<? super V, ? extends V> paramTransformer1) {
/*  69 */     return new TransformedSortedMap<K, V>(paramSortedMap, paramTransformer, paramTransformer1);
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
/*     */   public static <K, V> TransformedSortedMap<K, V> transformedSortedMap(SortedMap<K, V> paramSortedMap, Transformer<? super K, ? extends K> paramTransformer, Transformer<? super V, ? extends V> paramTransformer1) {
/*  93 */     TransformedSortedMap<K, V> transformedSortedMap = new TransformedSortedMap<K, V>(paramSortedMap, paramTransformer, paramTransformer1);
/*     */     
/*  95 */     if (paramSortedMap.size() > 0) {
/*  96 */       Map<K, V> map = transformedSortedMap.transformMap(paramSortedMap);
/*  97 */       transformedSortedMap.clear();
/*  98 */       transformedSortedMap.decorated().putAll(map);
/*     */     } 
/* 100 */     return transformedSortedMap;
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
/*     */   protected TransformedSortedMap(SortedMap<K, V> paramSortedMap, Transformer<? super K, ? extends K> paramTransformer, Transformer<? super V, ? extends V> paramTransformer1) {
/* 118 */     super(paramSortedMap, paramTransformer, paramTransformer1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SortedMap<K, V> getSortedMap() {
/* 128 */     return (SortedMap<K, V>)this.map;
/*     */   }
/*     */ 
/*     */   
/*     */   public K firstKey() {
/* 133 */     return getSortedMap().firstKey();
/*     */   }
/*     */   
/*     */   public K lastKey() {
/* 137 */     return getSortedMap().lastKey();
/*     */   }
/*     */   
/*     */   public Comparator<? super K> comparator() {
/* 141 */     return getSortedMap().comparator();
/*     */   }
/*     */   
/*     */   public SortedMap<K, V> subMap(K paramK1, K paramK2) {
/* 145 */     SortedMap<K, V> sortedMap = getSortedMap().subMap(paramK1, paramK2);
/* 146 */     return new TransformedSortedMap(sortedMap, this.keyTransformer, this.valueTransformer);
/*     */   }
/*     */   
/*     */   public SortedMap<K, V> headMap(K paramK) {
/* 150 */     SortedMap<K, V> sortedMap = getSortedMap().headMap(paramK);
/* 151 */     return new TransformedSortedMap(sortedMap, this.keyTransformer, this.valueTransformer);
/*     */   }
/*     */   
/*     */   public SortedMap<K, V> tailMap(K paramK) {
/* 155 */     SortedMap<K, V> sortedMap = getSortedMap().tailMap(paramK);
/* 156 */     return new TransformedSortedMap(sortedMap, this.keyTransformer, this.valueTransformer);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\map\TransformedSortedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */