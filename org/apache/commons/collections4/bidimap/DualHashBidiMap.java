/*     */ package org.apache.commons.collections4.bidimap;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.collections4.BidiMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DualHashBidiMap<K, V>
/*     */   extends AbstractDualBidiMap<K, V>
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 721969328361808L;
/*     */   
/*     */   public DualHashBidiMap() {
/*  51 */     super(new HashMap<K, V>(), new HashMap<V, K>());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DualHashBidiMap(Map<? extends K, ? extends V> paramMap) {
/*  61 */     super(new HashMap<K, V>(), new HashMap<V, K>());
/*  62 */     putAll(paramMap);
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
/*     */   protected DualHashBidiMap(Map<K, V> paramMap, Map<V, K> paramMap1, BidiMap<V, K> paramBidiMap) {
/*  74 */     super(paramMap, paramMap1, paramBidiMap);
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
/*     */   protected BidiMap<V, K> createBidiMap(Map<V, K> paramMap, Map<K, V> paramMap1, BidiMap<K, V> paramBidiMap) {
/*  88 */     return new DualHashBidiMap(paramMap, paramMap1, paramBidiMap);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/*  94 */     paramObjectOutputStream.defaultWriteObject();
/*  95 */     paramObjectOutputStream.writeObject(this.normalMap);
/*     */   }
/*     */   
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/*  99 */     paramObjectInputStream.defaultReadObject();
/* 100 */     this.normalMap = new HashMap<K, V>();
/* 101 */     this.reverseMap = new HashMap<V, K>();
/*     */     
/* 103 */     Map<? extends K, ? extends V> map = (Map)paramObjectInputStream.readObject();
/* 104 */     putAll(map);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\bidimap\DualHashBidiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */