/*     */ package org.apache.commons.collections4;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.bag.HashBag;
/*     */ import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
/*     */ import org.apache.commons.collections4.multimap.HashSetValuedHashMap;
/*     */ import org.apache.commons.collections4.multimap.TransformedMultiValuedMap;
/*     */ import org.apache.commons.collections4.multimap.UnmodifiableMultiValuedMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MultiMapUtils
/*     */ {
/*  55 */   public static final MultiValuedMap EMPTY_MULTI_VALUED_MAP = (MultiValuedMap)UnmodifiableMultiValuedMap.unmodifiableMultiValuedMap((MultiValuedMap)new ArrayListValuedHashMap(0, 0));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K, V> MultiValuedMap<K, V> emptyMultiValuedMap() {
/*  67 */     return EMPTY_MULTI_VALUED_MAP;
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
/*     */   public static <K, V> MultiValuedMap<K, V> emptyIfNull(MultiValuedMap<K, V> paramMultiValuedMap) {
/*  83 */     return (paramMultiValuedMap == null) ? EMPTY_MULTI_VALUED_MAP : paramMultiValuedMap;
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
/*     */   public static boolean isEmpty(MultiValuedMap<?, ?> paramMultiValuedMap) {
/*  95 */     return (paramMultiValuedMap == null || paramMultiValuedMap.isEmpty());
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
/*     */   public static <K, V> Collection<V> getCollection(MultiValuedMap<K, V> paramMultiValuedMap, K paramK) {
/* 111 */     if (paramMultiValuedMap != null) {
/* 112 */       return paramMultiValuedMap.get(paramK);
/*     */     }
/* 114 */     return null;
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
/*     */   public static <K, V> List<V> getValuesAsList(MultiValuedMap<K, V> paramMultiValuedMap, K paramK) {
/* 130 */     if (paramMultiValuedMap != null) {
/* 131 */       Collection<V> collection = paramMultiValuedMap.get(paramK);
/* 132 */       if (collection instanceof List) {
/* 133 */         return (List<V>)collection;
/*     */       }
/* 135 */       return new ArrayList<V>(collection);
/*     */     } 
/* 137 */     return null;
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
/*     */   public static <K, V> Set<V> getValuesAsSet(MultiValuedMap<K, V> paramMultiValuedMap, K paramK) {
/* 150 */     if (paramMultiValuedMap != null) {
/* 151 */       Collection<V> collection = paramMultiValuedMap.get(paramK);
/* 152 */       if (collection instanceof Set) {
/* 153 */         return (Set<V>)collection;
/*     */       }
/* 155 */       return new HashSet<V>(collection);
/*     */     } 
/* 157 */     return null;
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
/*     */   public static <K, V> Bag<V> getValuesAsBag(MultiValuedMap<K, V> paramMultiValuedMap, K paramK) {
/* 170 */     if (paramMultiValuedMap != null) {
/* 171 */       Collection<V> collection = paramMultiValuedMap.get(paramK);
/* 172 */       if (collection instanceof Bag) {
/* 173 */         return (Bag<V>)collection;
/*     */       }
/* 175 */       return (Bag<V>)new HashBag(collection);
/*     */     } 
/* 177 */     return null;
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
/*     */   public static <K, V> ListValuedMap<K, V> newListValuedHashMap() {
/* 192 */     return (ListValuedMap<K, V>)new ArrayListValuedHashMap();
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
/*     */   public static <K, V> SetValuedMap<K, V> newSetValuedHashMap() {
/* 204 */     return (SetValuedMap<K, V>)new HashSetValuedHashMap();
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
/*     */   public static <K, V> MultiValuedMap<K, V> unmodifiableMultiValuedMap(MultiValuedMap<? extends K, ? extends V> paramMultiValuedMap) {
/* 222 */     return (MultiValuedMap<K, V>)UnmodifiableMultiValuedMap.unmodifiableMultiValuedMap(paramMultiValuedMap);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K, V> MultiValuedMap<K, V> transformedMultiValuedMap(MultiValuedMap<K, V> paramMultiValuedMap, Transformer<? super K, ? extends K> paramTransformer, Transformer<? super V, ? extends V> paramTransformer1) {
/* 251 */     return (MultiValuedMap<K, V>)TransformedMultiValuedMap.transformingMap(paramMultiValuedMap, paramTransformer, paramTransformer1);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\MultiMapUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */