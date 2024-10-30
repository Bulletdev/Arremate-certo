/*     */ package org.apache.commons.collections4.map;
/*     */ 
/*     */ import java.util.Comparator;
/*     */ import java.util.SortedMap;
/*     */ import org.apache.commons.collections4.Predicate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PredicatedSortedMap<K, V>
/*     */   extends PredicatedMap<K, V>
/*     */   implements SortedMap<K, V>
/*     */ {
/*     */   private static final long serialVersionUID = 3359846175935304332L;
/*     */   
/*     */   public static <K, V> PredicatedSortedMap<K, V> predicatedSortedMap(SortedMap<K, V> paramSortedMap, Predicate<? super K> paramPredicate, Predicate<? super V> paramPredicate1) {
/*  73 */     return new PredicatedSortedMap<K, V>(paramSortedMap, paramPredicate, paramPredicate1);
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
/*     */   protected PredicatedSortedMap(SortedMap<K, V> paramSortedMap, Predicate<? super K> paramPredicate, Predicate<? super V> paramPredicate1) {
/*  87 */     super(paramSortedMap, paramPredicate, paramPredicate1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SortedMap<K, V> getSortedMap() {
/*  97 */     return (SortedMap<K, V>)this.map;
/*     */   }
/*     */ 
/*     */   
/*     */   public K firstKey() {
/* 102 */     return getSortedMap().firstKey();
/*     */   }
/*     */   
/*     */   public K lastKey() {
/* 106 */     return getSortedMap().lastKey();
/*     */   }
/*     */   
/*     */   public Comparator<? super K> comparator() {
/* 110 */     return getSortedMap().comparator();
/*     */   }
/*     */   
/*     */   public SortedMap<K, V> subMap(K paramK1, K paramK2) {
/* 114 */     SortedMap<K, V> sortedMap = getSortedMap().subMap(paramK1, paramK2);
/* 115 */     return new PredicatedSortedMap(sortedMap, this.keyPredicate, this.valuePredicate);
/*     */   }
/*     */   
/*     */   public SortedMap<K, V> headMap(K paramK) {
/* 119 */     SortedMap<K, V> sortedMap = getSortedMap().headMap(paramK);
/* 120 */     return new PredicatedSortedMap(sortedMap, this.keyPredicate, this.valuePredicate);
/*     */   }
/*     */   
/*     */   public SortedMap<K, V> tailMap(K paramK) {
/* 124 */     SortedMap<K, V> sortedMap = getSortedMap().tailMap(paramK);
/* 125 */     return new PredicatedSortedMap(sortedMap, this.keyPredicate, this.valuePredicate);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\map\PredicatedSortedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */