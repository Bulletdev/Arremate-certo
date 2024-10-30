/*     */ package org.apache.commons.collections4.multimap;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.collections4.CollectionUtils;
/*     */ import org.apache.commons.collections4.FluentIterable;
/*     */ import org.apache.commons.collections4.MultiValuedMap;
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
/*     */ public class TransformedMultiValuedMap<K, V>
/*     */   extends AbstractMultiValuedMapDecorator<K, V>
/*     */ {
/*     */   private static final long serialVersionUID = 20150612L;
/*     */   private final Transformer<? super K, ? extends K> keyTransformer;
/*     */   private final Transformer<? super V, ? extends V> valueTransformer;
/*     */   
/*     */   public static <K, V> TransformedMultiValuedMap<K, V> transformingMap(MultiValuedMap<K, V> paramMultiValuedMap, Transformer<? super K, ? extends K> paramTransformer, Transformer<? super V, ? extends V> paramTransformer1) {
/*  69 */     return new TransformedMultiValuedMap<K, V>(paramMultiValuedMap, paramTransformer, paramTransformer1);
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
/*     */   public static <K, V> TransformedMultiValuedMap<K, V> transformedMap(MultiValuedMap<K, V> paramMultiValuedMap, Transformer<? super K, ? extends K> paramTransformer, Transformer<? super V, ? extends V> paramTransformer1) {
/*  91 */     TransformedMultiValuedMap<K, V> transformedMultiValuedMap = new TransformedMultiValuedMap<K, V>(paramMultiValuedMap, paramTransformer, paramTransformer1);
/*     */     
/*  93 */     if (!paramMultiValuedMap.isEmpty()) {
/*  94 */       ArrayListValuedHashMap<K, V> arrayListValuedHashMap = new ArrayListValuedHashMap<K, V>(paramMultiValuedMap);
/*  95 */       transformedMultiValuedMap.clear();
/*  96 */       transformedMultiValuedMap.putAll(arrayListValuedHashMap);
/*     */     } 
/*  98 */     return transformedMultiValuedMap;
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
/*     */   protected TransformedMultiValuedMap(MultiValuedMap<K, V> paramMultiValuedMap, Transformer<? super K, ? extends K> paramTransformer, Transformer<? super V, ? extends V> paramTransformer1) {
/* 116 */     super(paramMultiValuedMap);
/* 117 */     this.keyTransformer = paramTransformer;
/* 118 */     this.valueTransformer = paramTransformer1;
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
/*     */   protected K transformKey(K paramK) {
/* 130 */     if (this.keyTransformer == null) {
/* 131 */       return paramK;
/*     */     }
/* 133 */     return (K)this.keyTransformer.transform(paramK);
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
/*     */   protected V transformValue(V paramV) {
/* 145 */     if (this.valueTransformer == null) {
/* 146 */       return paramV;
/*     */     }
/* 148 */     return (V)this.valueTransformer.transform(paramV);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean put(K paramK, V paramV) {
/* 153 */     return decorated().put(transformKey(paramK), transformValue(paramV));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean putAll(K paramK, Iterable<? extends V> paramIterable) {
/* 158 */     if (paramIterable == null) {
/* 159 */       throw new NullPointerException("Values must not be null.");
/*     */     }
/*     */     
/* 162 */     FluentIterable fluentIterable = FluentIterable.of(paramIterable).transform(this.valueTransformer);
/* 163 */     Iterator iterator = fluentIterable.iterator();
/* 164 */     return (iterator.hasNext() && CollectionUtils.addAll(decorated().get(transformKey(paramK)), iterator));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean putAll(Map<? extends K, ? extends V> paramMap) {
/* 169 */     if (paramMap == null) {
/* 170 */       throw new NullPointerException("Map must not be null.");
/*     */     }
/* 172 */     boolean bool = false;
/* 173 */     for (Map.Entry<? extends K, ? extends V> entry : paramMap.entrySet()) {
/* 174 */       bool |= put((K)entry.getKey(), (V)entry.getValue());
/*     */     }
/* 176 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean putAll(MultiValuedMap<? extends K, ? extends V> paramMultiValuedMap) {
/* 181 */     if (paramMultiValuedMap == null) {
/* 182 */       throw new NullPointerException("Map must not be null.");
/*     */     }
/* 184 */     boolean bool = false;
/* 185 */     for (Map.Entry entry : paramMultiValuedMap.entries()) {
/* 186 */       bool |= put((K)entry.getKey(), (V)entry.getValue());
/*     */     }
/* 188 */     return bool;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\multimap\TransformedMultiValuedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */