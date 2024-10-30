/*     */ package org.apache.commons.collections4.multimap;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.SetUtils;
/*     */ import org.apache.commons.collections4.SetValuedMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractSetValuedMap<K, V>
/*     */   extends AbstractMultiValuedMap<K, V>
/*     */   implements SetValuedMap<K, V>
/*     */ {
/*     */   protected AbstractSetValuedMap() {}
/*     */   
/*     */   protected AbstractSetValuedMap(Map<K, ? extends Set<V>> paramMap) {
/*  53 */     super((Map)paramMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Map<K, Set<V>> getMap() {
/*  60 */     return (Map)super.getMap();
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
/*     */   public Set<V> get(K paramK) {
/*  81 */     return wrappedCollection(paramK);
/*     */   }
/*     */ 
/*     */   
/*     */   Set<V> wrappedCollection(K paramK) {
/*  86 */     return new WrappedSet(paramK);
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
/*     */   public Set<V> remove(Object paramObject) {
/* 100 */     return SetUtils.emptyIfNull(getMap().remove(paramObject));
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract Set<V> createCollection();
/*     */   
/*     */   private class WrappedSet
/*     */     extends AbstractMultiValuedMap<K, V>.WrappedCollection
/*     */     implements Set<V>
/*     */   {
/*     */     public WrappedSet(K param1K) {
/* 111 */       super(param1K);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 116 */       Set set1 = (Set)getMapping();
/* 117 */       if (set1 == null) {
/* 118 */         return Collections.emptySet().equals(param1Object);
/*     */       }
/* 120 */       if (!(param1Object instanceof Set)) {
/* 121 */         return false;
/*     */       }
/* 123 */       Set set2 = (Set)param1Object;
/* 124 */       return SetUtils.isEqualSet(set1, set2);
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 129 */       Set set = (Set)getMapping();
/* 130 */       return SetUtils.hashCodeForSet(set);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\multimap\AbstractSetValuedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */