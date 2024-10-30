/*     */ package org.apache.commons.collections4.multimap;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.collections4.MultiValuedMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ArrayListValuedHashMap<K, V>
/*     */   extends AbstractListValuedMap<K, V>
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 20151118L;
/*     */   private static final int DEFAULT_INITIAL_MAP_CAPACITY = 16;
/*     */   private static final int DEFAULT_INITIAL_LIST_CAPACITY = 3;
/*     */   private final int initialListCapacity;
/*     */   
/*     */   public ArrayListValuedHashMap() {
/*  69 */     this(16, 3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayListValuedHashMap(int paramInt) {
/*  79 */     this(16, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayListValuedHashMap(int paramInt1, int paramInt2) {
/*  90 */     super(new HashMap<K, List<V>>(paramInt1));
/*  91 */     this.initialListCapacity = paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayListValuedHashMap(MultiValuedMap<? extends K, ? extends V> paramMultiValuedMap) {
/* 100 */     this(paramMultiValuedMap.size(), 3);
/* 101 */     putAll(paramMultiValuedMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayListValuedHashMap(Map<? extends K, ? extends V> paramMap) {
/* 110 */     this(paramMap.size(), 3);
/* 111 */     putAll(paramMap);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected ArrayList<V> createCollection() {
/* 117 */     return new ArrayList<V>(this.initialListCapacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void trimToSize() {
/* 125 */     for (Collection<V> collection : getMap().values()) {
/* 126 */       ArrayList arrayList = (ArrayList)collection;
/* 127 */       arrayList.trimToSize();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 133 */     paramObjectOutputStream.defaultWriteObject();
/* 134 */     doWriteObject(paramObjectOutputStream);
/*     */   }
/*     */   
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 138 */     paramObjectInputStream.defaultReadObject();
/* 139 */     setMap(new HashMap<K, Collection<V>>());
/* 140 */     doReadObject(paramObjectInputStream);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\multimap\ArrayListValuedHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */