/*     */ package org.apache.commons.collections4.set;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class MapBackedSet<E, V>
/*     */   implements Serializable, Set<E>
/*     */ {
/*     */   private static final long serialVersionUID = 6723912213766056587L;
/*     */   private final Map<E, ? super V> map;
/*     */   private final V dummyValue;
/*     */   
/*     */   public static <E, V> MapBackedSet<E, V> mapBackedSet(Map<E, ? super V> paramMap) {
/*  60 */     return mapBackedSet(paramMap, null);
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
/*     */   public static <E, V> MapBackedSet<E, V> mapBackedSet(Map<E, ? super V> paramMap, V paramV) {
/*  75 */     return new MapBackedSet<E, V>(paramMap, paramV);
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
/*     */   private MapBackedSet(Map<E, ? super V> paramMap, V paramV) {
/*  88 */     if (paramMap == null) {
/*  89 */       throw new NullPointerException("The map must not be null");
/*     */     }
/*  91 */     this.map = paramMap;
/*  92 */     this.dummyValue = paramV;
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/*  97 */     return this.map.size();
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/* 101 */     return this.map.isEmpty();
/*     */   }
/*     */   
/*     */   public Iterator<E> iterator() {
/* 105 */     return this.map.keySet().iterator();
/*     */   }
/*     */   
/*     */   public boolean contains(Object paramObject) {
/* 109 */     return this.map.containsKey(paramObject);
/*     */   }
/*     */   
/*     */   public boolean containsAll(Collection<?> paramCollection) {
/* 113 */     return this.map.keySet().containsAll(paramCollection);
/*     */   }
/*     */   
/*     */   public boolean add(E paramE) {
/* 117 */     int i = this.map.size();
/* 118 */     this.map.put(paramE, this.dummyValue);
/* 119 */     return (this.map.size() != i);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addAll(Collection<? extends E> paramCollection) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield map : Ljava/util/Map;
/*     */     //   4: invokeinterface size : ()I
/*     */     //   9: istore_2
/*     */     //   10: aload_1
/*     */     //   11: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   16: astore_3
/*     */     //   17: aload_3
/*     */     //   18: invokeinterface hasNext : ()Z
/*     */     //   23: ifeq -> 53
/*     */     //   26: aload_3
/*     */     //   27: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   32: astore #4
/*     */     //   34: aload_0
/*     */     //   35: getfield map : Ljava/util/Map;
/*     */     //   38: aload #4
/*     */     //   40: aload_0
/*     */     //   41: getfield dummyValue : Ljava/lang/Object;
/*     */     //   44: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   49: pop
/*     */     //   50: goto -> 17
/*     */     //   53: aload_0
/*     */     //   54: getfield map : Ljava/util/Map;
/*     */     //   57: invokeinterface size : ()I
/*     */     //   62: iload_2
/*     */     //   63: if_icmpeq -> 70
/*     */     //   66: iconst_1
/*     */     //   67: goto -> 71
/*     */     //   70: iconst_0
/*     */     //   71: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #123	-> 0
/*     */     //   #124	-> 10
/*     */     //   #125	-> 34
/*     */     //   #126	-> 50
/*     */     //   #127	-> 53
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean remove(Object paramObject) {
/* 131 */     int i = this.map.size();
/* 132 */     this.map.remove(paramObject);
/* 133 */     return (this.map.size() != i);
/*     */   }
/*     */   
/*     */   public boolean removeAll(Collection<?> paramCollection) {
/* 137 */     return this.map.keySet().removeAll(paramCollection);
/*     */   }
/*     */   
/*     */   public boolean retainAll(Collection<?> paramCollection) {
/* 141 */     return this.map.keySet().retainAll(paramCollection);
/*     */   }
/*     */   
/*     */   public void clear() {
/* 145 */     this.map.clear();
/*     */   }
/*     */   
/*     */   public Object[] toArray() {
/* 149 */     return this.map.keySet().toArray();
/*     */   }
/*     */   
/*     */   public <T> T[] toArray(T[] paramArrayOfT) {
/* 153 */     return (T[])this.map.keySet().toArray((Object[])paramArrayOfT);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 158 */     return this.map.keySet().equals(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 163 */     return this.map.keySet().hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\set\MapBackedSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */