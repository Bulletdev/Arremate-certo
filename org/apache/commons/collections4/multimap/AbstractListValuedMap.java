/*     */ package org.apache.commons.collections4.multimap;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.collections4.ListUtils;
/*     */ import org.apache.commons.collections4.ListValuedMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractListValuedMap<K, V>
/*     */   extends AbstractMultiValuedMap<K, V>
/*     */   implements ListValuedMap<K, V>
/*     */ {
/*     */   protected AbstractListValuedMap() {}
/*     */   
/*     */   protected AbstractListValuedMap(Map<K, ? extends List<V>> paramMap) {
/*  55 */     super((Map)paramMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Map<K, List<V>> getMap() {
/*  62 */     return (Map)super.getMap();
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
/*     */   public List<V> get(K paramK) {
/*  82 */     return wrappedCollection(paramK);
/*     */   }
/*     */ 
/*     */   
/*     */   List<V> wrappedCollection(K paramK) {
/*  87 */     return new WrappedList(paramK);
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
/*     */   public List<V> remove(Object paramObject) {
/* 101 */     return ListUtils.emptyIfNull(getMap().remove(paramObject));
/*     */   }
/*     */   
/*     */   protected abstract List<V> createCollection();
/*     */   
/*     */   private class WrappedList
/*     */     extends AbstractMultiValuedMap<K, V>.WrappedCollection
/*     */     implements List<V>
/*     */   {
/*     */     public WrappedList(K param1K) {
/* 111 */       super(param1K);
/*     */     }
/*     */ 
/*     */     
/*     */     protected List<V> getMapping() {
/* 116 */       return (List<V>)AbstractListValuedMap.this.getMap().get(this.key);
/*     */     }
/*     */ 
/*     */     
/*     */     public void add(int param1Int, V param1V) {
/* 121 */       List<V> list = getMapping();
/* 122 */       if (list == null) {
/* 123 */         list = AbstractListValuedMap.this.createCollection();
/* 124 */         AbstractListValuedMap.this.getMap().put(this.key, list);
/*     */       } 
/* 126 */       list.add(param1Int, param1V);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean addAll(int param1Int, Collection<? extends V> param1Collection) {
/* 131 */       List<V> list = getMapping();
/* 132 */       if (list == null) {
/* 133 */         list = AbstractListValuedMap.this.createCollection();
/* 134 */         boolean bool = list.addAll(param1Int, param1Collection);
/* 135 */         if (bool) {
/* 136 */           AbstractListValuedMap.this.getMap().put(this.key, list);
/*     */         }
/* 138 */         return bool;
/*     */       } 
/* 140 */       return list.addAll(param1Int, param1Collection);
/*     */     }
/*     */ 
/*     */     
/*     */     public V get(int param1Int) {
/* 145 */       List<V> list = ListUtils.emptyIfNull(getMapping());
/* 146 */       return list.get(param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     public int indexOf(Object param1Object) {
/* 151 */       List list = ListUtils.emptyIfNull(getMapping());
/* 152 */       return list.indexOf(param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     public int lastIndexOf(Object param1Object) {
/* 157 */       List list = ListUtils.emptyIfNull(getMapping());
/* 158 */       return list.lastIndexOf(param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     public ListIterator<V> listIterator() {
/* 163 */       return new AbstractListValuedMap.ValuesListIterator(this.key);
/*     */     }
/*     */ 
/*     */     
/*     */     public ListIterator<V> listIterator(int param1Int) {
/* 168 */       return new AbstractListValuedMap.ValuesListIterator(this.key, param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     public V remove(int param1Int) {
/* 173 */       List<Object> list = ListUtils.emptyIfNull(getMapping());
/* 174 */       V v = (V)list.remove(param1Int);
/* 175 */       if (list.isEmpty()) {
/* 176 */         AbstractListValuedMap.this.remove(this.key);
/*     */       }
/* 178 */       return v;
/*     */     }
/*     */ 
/*     */     
/*     */     public V set(int param1Int, V param1V) {
/* 183 */       List<V> list = ListUtils.emptyIfNull(getMapping());
/* 184 */       return list.set(param1Int, param1V);
/*     */     }
/*     */ 
/*     */     
/*     */     public List<V> subList(int param1Int1, int param1Int2) {
/* 189 */       List<V> list = ListUtils.emptyIfNull(getMapping());
/* 190 */       return list.subList(param1Int1, param1Int2);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 195 */       List<V> list = getMapping();
/* 196 */       if (list == null) {
/* 197 */         return Collections.emptyList().equals(param1Object);
/*     */       }
/* 199 */       if (!(param1Object instanceof List)) {
/* 200 */         return false;
/*     */       }
/* 202 */       List list1 = (List)param1Object;
/* 203 */       return ListUtils.isEqualList(list, list1);
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 208 */       List<V> list = getMapping();
/* 209 */       return ListUtils.hashCodeForList(list);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private class ValuesListIterator
/*     */     implements ListIterator<V>
/*     */   {
/*     */     private final K key;
/*     */     private List<V> values;
/*     */     private ListIterator<V> iterator;
/*     */     
/*     */     public ValuesListIterator(K param1K) {
/* 222 */       this.key = param1K;
/* 223 */       this.values = ListUtils.emptyIfNull((List)AbstractListValuedMap.this.getMap().get(param1K));
/* 224 */       this.iterator = this.values.listIterator();
/*     */     }
/*     */     
/*     */     public ValuesListIterator(K param1K, int param1Int) {
/* 228 */       this.key = param1K;
/* 229 */       this.values = ListUtils.emptyIfNull((List)AbstractListValuedMap.this.getMap().get(param1K));
/* 230 */       this.iterator = this.values.listIterator(param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     public void add(V param1V) {
/* 235 */       if (AbstractListValuedMap.this.getMap().get(this.key) == null) {
/* 236 */         List<V> list = AbstractListValuedMap.this.createCollection();
/* 237 */         AbstractListValuedMap.this.getMap().put(this.key, list);
/* 238 */         this.values = list;
/* 239 */         this.iterator = list.listIterator();
/*     */       } 
/* 241 */       this.iterator.add(param1V);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 246 */       return this.iterator.hasNext();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasPrevious() {
/* 251 */       return this.iterator.hasPrevious();
/*     */     }
/*     */ 
/*     */     
/*     */     public V next() {
/* 256 */       return this.iterator.next();
/*     */     }
/*     */ 
/*     */     
/*     */     public int nextIndex() {
/* 261 */       return this.iterator.nextIndex();
/*     */     }
/*     */ 
/*     */     
/*     */     public V previous() {
/* 266 */       return this.iterator.previous();
/*     */     }
/*     */ 
/*     */     
/*     */     public int previousIndex() {
/* 271 */       return this.iterator.previousIndex();
/*     */     }
/*     */ 
/*     */     
/*     */     public void remove() {
/* 276 */       this.iterator.remove();
/* 277 */       if (this.values.isEmpty()) {
/* 278 */         AbstractListValuedMap.this.getMap().remove(this.key);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(V param1V) {
/* 284 */       this.iterator.set(param1V);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\multimap\AbstractListValuedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */