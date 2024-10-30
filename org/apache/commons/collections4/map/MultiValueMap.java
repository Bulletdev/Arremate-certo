/*     */ package org.apache.commons.collections4.map;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.AbstractCollection;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.CollectionUtils;
/*     */ import org.apache.commons.collections4.Factory;
/*     */ import org.apache.commons.collections4.FunctorException;
/*     */ import org.apache.commons.collections4.MultiMap;
/*     */ import org.apache.commons.collections4.Transformer;
/*     */ import org.apache.commons.collections4.iterators.EmptyIterator;
/*     */ import org.apache.commons.collections4.iterators.IteratorChain;
/*     */ import org.apache.commons.collections4.iterators.LazyIteratorChain;
/*     */ import org.apache.commons.collections4.iterators.TransformIterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ public class MultiValueMap<K, V>
/*     */   extends AbstractMapDecorator<K, Object>
/*     */   implements Serializable, MultiMap<K, V>
/*     */ {
/*     */   private static final long serialVersionUID = -2214159910087182007L;
/*     */   private final Factory<? extends Collection<V>> collectionFactory;
/*     */   private transient Collection<V> valuesView;
/*     */   
/*     */   public static <K, V> MultiValueMap<K, V> multiValueMap(Map<K, ? super Collection<V>> paramMap) {
/*  89 */     return multiValueMap(paramMap, (Class)ArrayList.class);
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
/*     */   public static <K, V, C extends Collection<V>> MultiValueMap<K, V> multiValueMap(Map<K, ? super C> paramMap, Class<C> paramClass) {
/* 106 */     return new MultiValueMap<K, V>(paramMap, new ReflectionFactory<C>(paramClass));
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
/*     */   public static <K, V, C extends Collection<V>> MultiValueMap<K, V> multiValueMap(Map<K, ? super C> paramMap, Factory<C> paramFactory) {
/* 123 */     return new MultiValueMap<K, V>(paramMap, paramFactory);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MultiValueMap() {
/* 133 */     this(new HashMap<K, Collection<V>>(), new ReflectionFactory<Collection<V>>((Class)ArrayList.class));
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
/*     */   protected <C extends Collection<V>> MultiValueMap(Map<K, ? super C> paramMap, Factory<C> paramFactory) {
/* 147 */     super((Map)paramMap);
/* 148 */     if (paramFactory == null) {
/* 149 */       throw new IllegalArgumentException("The factory must not be null");
/*     */     }
/* 151 */     this.collectionFactory = paramFactory;
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
/*     */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 163 */     paramObjectOutputStream.defaultWriteObject();
/* 164 */     paramObjectOutputStream.writeObject(this.map);
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
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 177 */     paramObjectInputStream.defaultReadObject();
/* 178 */     this.map = (Map<K, Object>)paramObjectInputStream.readObject();
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
/*     */   public void clear() {
/* 195 */     decorated().clear();
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
/*     */   public boolean removeMapping(Object paramObject1, Object paramObject2) {
/* 213 */     Collection<V> collection = getCollection(paramObject1);
/* 214 */     if (collection == null) {
/* 215 */       return false;
/*     */     }
/* 217 */     boolean bool = collection.remove(paramObject2);
/* 218 */     if (!bool) {
/* 219 */       return false;
/*     */     }
/* 221 */     if (collection.isEmpty()) {
/* 222 */       remove(paramObject1);
/*     */     }
/* 224 */     return true;
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
/*     */   public boolean containsValue(Object paramObject) {
/* 238 */     Set<Map.Entry<K, Object>> set = decorated().entrySet();
/* 239 */     if (set != null) {
/* 240 */       for (Map.Entry<K, Object> entry : set) {
/* 241 */         if (((Collection)entry.getValue()).contains(paramObject)) {
/* 242 */           return true;
/*     */         }
/*     */       } 
/*     */     }
/* 246 */     return false;
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
/*     */   public Object put(K paramK, Object paramObject) {
/* 262 */     boolean bool = false;
/* 263 */     Collection<V> collection = getCollection(paramK);
/* 264 */     if (collection == null) {
/* 265 */       collection = createCollection(1);
/* 266 */       collection.add((V)paramObject);
/* 267 */       if (collection.size() > 0) {
/*     */         
/* 269 */         decorated().put(paramK, collection);
/* 270 */         bool = true;
/*     */       } 
/*     */     } else {
/* 273 */       bool = collection.add((V)paramObject);
/*     */     } 
/* 275 */     return bool ? paramObject : null;
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
/*     */   public void putAll(Map<? extends K, ?> paramMap) {
/* 292 */     if (paramMap instanceof MultiMap) {
/* 293 */       for (Map.Entry entry : ((MultiMap)paramMap).entrySet()) {
/* 294 */         putAll((K)entry.getKey(), (Collection<V>)entry.getValue());
/*     */       }
/*     */     } else {
/* 297 */       for (Map.Entry<? extends K, ?> entry : paramMap.entrySet()) {
/* 298 */         put((K)entry.getKey(), entry.getValue());
/*     */       }
/*     */     } 
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
/*     */   public Set<Map.Entry<K, Object>> entrySet() {
/* 314 */     return super.entrySet();
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
/*     */   public Collection<Object> values() {
/* 327 */     Collection<V> collection = this.valuesView;
/* 328 */     return (collection != null) ? (Collection)collection : (Collection)(this.valuesView = new Values());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsValue(Object paramObject1, Object paramObject2) {
/* 339 */     Collection<V> collection = getCollection(paramObject1);
/* 340 */     if (collection == null) {
/* 341 */       return false;
/*     */     }
/* 343 */     return collection.contains(paramObject2);
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
/*     */   public Collection<V> getCollection(Object paramObject) {
/* 355 */     return (Collection<V>)decorated().get(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size(Object paramObject) {
/* 365 */     Collection<V> collection = getCollection(paramObject);
/* 366 */     if (collection == null) {
/* 367 */       return 0;
/*     */     }
/* 369 */     return collection.size();
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
/*     */   public boolean putAll(K paramK, Collection<V> paramCollection) {
/* 381 */     if (paramCollection == null || paramCollection.size() == 0) {
/* 382 */       return false;
/*     */     }
/* 384 */     boolean bool = false;
/* 385 */     Collection<V> collection = getCollection(paramK);
/* 386 */     if (collection == null) {
/* 387 */       collection = createCollection(paramCollection.size());
/* 388 */       collection.addAll(paramCollection);
/* 389 */       if (collection.size() > 0) {
/*     */         
/* 391 */         decorated().put(paramK, collection);
/* 392 */         bool = true;
/*     */       } 
/*     */     } else {
/* 395 */       bool = collection.addAll(paramCollection);
/*     */     } 
/* 397 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<V> iterator(Object paramObject) {
/* 407 */     if (!containsKey(paramObject)) {
/* 408 */       return EmptyIterator.emptyIterator();
/*     */     }
/* 410 */     return new ValuesIterator(paramObject);
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
/*     */   public Iterator<Map.Entry<K, V>> iterator() {
/* 426 */     ArrayList<K> arrayList = new ArrayList<K>(keySet());
/* 427 */     final Iterator<K> keyIterator = arrayList.iterator();
/*     */     
/* 429 */     return (Iterator<Map.Entry<K, V>>)new LazyIteratorChain<Map.Entry<K, V>>()
/*     */       {
/*     */         protected Iterator<? extends Map.Entry<K, V>> nextIterator(int param1Int) {
/* 432 */           if (!keyIterator.hasNext()) {
/* 433 */             return null;
/*     */           }
/* 435 */           final Object key = keyIterator.next();
/* 436 */           Transformer<V, Map.Entry<K, V>> transformer = new Transformer<V, Map.Entry<K, V>>()
/*     */             {
/*     */               public Map.Entry<K, V> transform(final V input) {
/* 439 */                 return new Map.Entry<K, V>()
/*     */                   {
/*     */                     public K getKey() {
/* 442 */                       return (K)key;
/*     */                     }
/*     */                     
/*     */                     public V getValue() {
/* 446 */                       return (V)input;
/*     */                     }
/*     */                     
/*     */                     public V setValue(V param3V) {
/* 450 */                       throw new UnsupportedOperationException();
/*     */                     }
/*     */                   };
/*     */               }
/*     */             };
/* 455 */           return (Iterator<? extends Map.Entry<K, V>>)new TransformIterator(new MultiValueMap.ValuesIterator(object), transformer);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int totalSize() {
/* 466 */     int i = 0;
/* 467 */     for (Object object : decorated().values()) {
/* 468 */       i += CollectionUtils.size(object);
/*     */     }
/* 470 */     return i;
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
/*     */   protected Collection<V> createCollection(int paramInt) {
/* 484 */     return (Collection<V>)this.collectionFactory.create();
/*     */   }
/*     */ 
/*     */   
/*     */   private class Values
/*     */     extends AbstractCollection<V>
/*     */   {
/*     */     private Values() {}
/*     */     
/*     */     public Iterator<V> iterator() {
/* 494 */       IteratorChain iteratorChain = new IteratorChain();
/* 495 */       for (Object object : MultiValueMap.this.keySet()) {
/* 496 */         iteratorChain.addIterator(new MultiValueMap.ValuesIterator(object));
/*     */       }
/* 498 */       return (Iterator<V>)iteratorChain;
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 503 */       return MultiValueMap.this.totalSize();
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 508 */       MultiValueMap.this.clear();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private class ValuesIterator
/*     */     implements Iterator<V>
/*     */   {
/*     */     private final Object key;
/*     */     private final Collection<V> values;
/*     */     private final Iterator<V> iterator;
/*     */     
/*     */     public ValuesIterator(Object param1Object) {
/* 521 */       this.key = param1Object;
/* 522 */       this.values = MultiValueMap.this.getCollection(param1Object);
/* 523 */       this.iterator = this.values.iterator();
/*     */     }
/*     */ 
/*     */     
/*     */     public void remove() {
/* 528 */       this.iterator.remove();
/* 529 */       if (this.values.isEmpty()) {
/* 530 */         MultiValueMap.this.remove(this.key);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 536 */       return this.iterator.hasNext();
/*     */     }
/*     */ 
/*     */     
/*     */     public V next() {
/* 541 */       return this.iterator.next();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class ReflectionFactory<T extends Collection<?>>
/*     */     implements Serializable, Factory<T>
/*     */   {
/*     */     private static final long serialVersionUID = 2986114157496788874L;
/*     */     
/*     */     private final Class<T> clazz;
/*     */ 
/*     */     
/*     */     public ReflectionFactory(Class<T> param1Class) {
/* 556 */       this.clazz = param1Class;
/*     */     }
/*     */ 
/*     */     
/*     */     public T create() {
/*     */       try {
/* 562 */         return this.clazz.newInstance();
/* 563 */       } catch (Exception exception) {
/* 564 */         throw new FunctorException("Cannot instantiate class: " + this.clazz, exception);
/*     */       } 
/*     */     }
/*     */     
/*     */     private void readObject(ObjectInputStream param1ObjectInputStream) throws IOException, ClassNotFoundException {
/* 569 */       param1ObjectInputStream.defaultReadObject();
/*     */       
/* 571 */       if (this.clazz != null && !Collection.class.isAssignableFrom(this.clazz))
/* 572 */         throw new UnsupportedOperationException(); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\map\MultiValueMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */