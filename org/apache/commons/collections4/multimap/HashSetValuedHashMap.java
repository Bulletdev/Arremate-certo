/*     */ package org.apache.commons.collections4.multimap;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
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
/*     */ public class HashSetValuedHashMap<K, V>
/*     */   extends AbstractSetValuedMap<K, V>
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 20151118L;
/*     */   private static final int DEFAULT_INITIAL_MAP_CAPACITY = 16;
/*     */   private static final int DEFAULT_INITIAL_SET_CAPACITY = 3;
/*     */   private final int initialSetCapacity;
/*     */   
/*     */   public HashSetValuedHashMap() {
/*  68 */     this(16, 3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HashSetValuedHashMap(int paramInt) {
/*  78 */     this(16, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HashSetValuedHashMap(int paramInt1, int paramInt2) {
/*  89 */     super(new HashMap<K, Set<V>>(paramInt1));
/*  90 */     this.initialSetCapacity = paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HashSetValuedHashMap(MultiValuedMap<? extends K, ? extends V> paramMultiValuedMap) {
/*  99 */     this(paramMultiValuedMap.size(), 3);
/* 100 */     putAll(paramMultiValuedMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HashSetValuedHashMap(Map<? extends K, ? extends V> paramMap) {
/* 109 */     this(paramMap.size(), 3);
/* 110 */     putAll(paramMap);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected HashSet<V> createCollection() {
/* 116 */     return new HashSet<V>(this.initialSetCapacity);
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 121 */     paramObjectOutputStream.defaultWriteObject();
/* 122 */     doWriteObject(paramObjectOutputStream);
/*     */   }
/*     */   
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 126 */     paramObjectInputStream.defaultReadObject();
/* 127 */     setMap(new HashMap<K, Collection<V>>());
/* 128 */     doReadObject(paramObjectInputStream);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\multimap\HashSetValuedHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */