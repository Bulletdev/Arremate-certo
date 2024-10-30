/*     */ package org.apache.commons.collections4.collection;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import org.apache.commons.collections4.MultiMap;
/*     */ import org.apache.commons.collections4.Transformer;
/*     */ import org.apache.commons.collections4.map.MultiValueMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IndexedCollection<K, C>
/*     */   extends AbstractCollectionDecorator<C>
/*     */ {
/*     */   private static final long serialVersionUID = -5512610452568370038L;
/*     */   private final Transformer<C, K> keyTransformer;
/*     */   private final MultiMap<K, C> index;
/*     */   private final boolean uniqueIndex;
/*     */   
/*     */   public static <K, C> IndexedCollection<K, C> uniqueIndexedCollection(Collection<C> paramCollection, Transformer<C, K> paramTransformer) {
/*  74 */     return new IndexedCollection<K, C>(paramCollection, paramTransformer, (MultiMap<K, C>)MultiValueMap.multiValueMap(new HashMap<Object, Object>()), true);
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
/*     */   public static <K, C> IndexedCollection<K, C> nonUniqueIndexedCollection(Collection<C> paramCollection, Transformer<C, K> paramTransformer) {
/*  90 */     return new IndexedCollection<K, C>(paramCollection, paramTransformer, (MultiMap<K, C>)MultiValueMap.multiValueMap(new HashMap<Object, Object>()), false);
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
/*     */   public IndexedCollection(Collection<C> paramCollection, Transformer<C, K> paramTransformer, MultiMap<K, C> paramMultiMap, boolean paramBoolean) {
/* 105 */     super(paramCollection);
/* 106 */     this.keyTransformer = paramTransformer;
/* 107 */     this.index = paramMultiMap;
/* 108 */     this.uniqueIndex = paramBoolean;
/* 109 */     reindex();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean add(C paramC) {
/* 120 */     boolean bool = super.add(paramC);
/* 121 */     if (bool) {
/* 122 */       addToIndex(paramC);
/*     */     }
/* 124 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addAll(Collection<? extends C> paramCollection) {
/*     */     // Byte code:
/*     */     //   0: iconst_0
/*     */     //   1: istore_2
/*     */     //   2: aload_1
/*     */     //   3: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   8: astore_3
/*     */     //   9: aload_3
/*     */     //   10: invokeinterface hasNext : ()Z
/*     */     //   15: ifeq -> 38
/*     */     //   18: aload_3
/*     */     //   19: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   24: astore #4
/*     */     //   26: iload_2
/*     */     //   27: aload_0
/*     */     //   28: aload #4
/*     */     //   30: invokevirtual add : (Ljava/lang/Object;)Z
/*     */     //   33: ior
/*     */     //   34: istore_2
/*     */     //   35: goto -> 9
/*     */     //   38: iload_2
/*     */     //   39: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #129	-> 0
/*     */     //   #130	-> 2
/*     */     //   #131	-> 26
/*     */     //   #132	-> 35
/*     */     //   #133	-> 38
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 138 */     super.clear();
/* 139 */     this.index.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(Object paramObject) {
/* 150 */     return this.index.containsKey(this.keyTransformer.transform(paramObject));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsAll(Collection<?> paramCollection) {
/* 160 */     for (Object object : paramCollection) {
/* 161 */       if (!contains(object)) {
/* 162 */         return false;
/*     */       }
/*     */     } 
/* 165 */     return true;
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
/*     */   public C get(K paramK) {
/* 181 */     Collection<C> collection = (Collection)this.index.get(paramK);
/* 182 */     return (collection == null) ? null : collection.iterator().next();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<C> values(K paramK) {
/* 193 */     return (Collection<C>)this.index.get(paramK);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reindex() {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield index : Lorg/apache/commons/collections4/MultiMap;
/*     */     //   4: invokeinterface clear : ()V
/*     */     //   9: aload_0
/*     */     //   10: invokevirtual decorated : ()Ljava/util/Collection;
/*     */     //   13: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   18: astore_1
/*     */     //   19: aload_1
/*     */     //   20: invokeinterface hasNext : ()Z
/*     */     //   25: ifeq -> 43
/*     */     //   28: aload_1
/*     */     //   29: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   34: astore_2
/*     */     //   35: aload_0
/*     */     //   36: aload_2
/*     */     //   37: invokespecial addToIndex : (Ljava/lang/Object;)V
/*     */     //   40: goto -> 19
/*     */     //   43: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #200	-> 0
/*     */     //   #201	-> 9
/*     */     //   #202	-> 35
/*     */     //   #203	-> 40
/*     */     //   #204	-> 43
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean remove(Object paramObject) {
/* 209 */     boolean bool = super.remove(paramObject);
/* 210 */     if (bool) {
/* 211 */       removeFromIndex((C)paramObject);
/*     */     }
/* 213 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeAll(Collection<?> paramCollection) {
/* 218 */     boolean bool = false;
/* 219 */     for (Object object : paramCollection) {
/* 220 */       bool |= remove(object);
/*     */     }
/* 222 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean retainAll(Collection<?> paramCollection) {
/* 227 */     boolean bool = super.retainAll(paramCollection);
/* 228 */     if (bool) {
/* 229 */       reindex();
/*     */     }
/* 231 */     return bool;
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
/*     */   private void addToIndex(C paramC) {
/* 244 */     Object object = this.keyTransformer.transform(paramC);
/* 245 */     if (this.uniqueIndex && this.index.containsKey(object)) {
/* 246 */       throw new IllegalArgumentException("Duplicate key in uniquely indexed collection.");
/*     */     }
/* 248 */     this.index.put(object, paramC);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void removeFromIndex(C paramC) {
/* 257 */     this.index.remove(this.keyTransformer.transform(paramC));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\collection\IndexedCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */