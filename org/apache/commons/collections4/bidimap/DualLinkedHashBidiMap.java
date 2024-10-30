/*    */ package org.apache.commons.collections4.bidimap;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.ObjectInputStream;
/*    */ import java.io.ObjectOutputStream;
/*    */ import java.io.Serializable;
/*    */ import java.util.LinkedHashMap;
/*    */ import java.util.Map;
/*    */ import org.apache.commons.collections4.BidiMap;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DualLinkedHashBidiMap<K, V>
/*    */   extends AbstractDualBidiMap<K, V>
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 721969328361810L;
/*    */   
/*    */   public DualLinkedHashBidiMap() {
/* 46 */     super(new LinkedHashMap<K, V>(), new LinkedHashMap<V, K>());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public DualLinkedHashBidiMap(Map<? extends K, ? extends V> paramMap) {
/* 56 */     super(new LinkedHashMap<K, V>(), new LinkedHashMap<V, K>());
/* 57 */     putAll(paramMap);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected DualLinkedHashBidiMap(Map<K, V> paramMap, Map<V, K> paramMap1, BidiMap<V, K> paramBidiMap) {
/* 69 */     super(paramMap, paramMap1, paramBidiMap);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected BidiMap<V, K> createBidiMap(Map<V, K> paramMap, Map<K, V> paramMap1, BidiMap<K, V> paramBidiMap) {
/* 83 */     return new DualLinkedHashBidiMap(paramMap, paramMap1, paramBidiMap);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 89 */     paramObjectOutputStream.defaultWriteObject();
/* 90 */     paramObjectOutputStream.writeObject(this.normalMap);
/*    */   }
/*    */   
/*    */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 94 */     paramObjectInputStream.defaultReadObject();
/* 95 */     this.normalMap = new LinkedHashMap<K, V>();
/* 96 */     this.reverseMap = new LinkedHashMap<V, K>();
/*    */     
/* 98 */     Map<? extends K, ? extends V> map = (Map)paramObjectInputStream.readObject();
/* 99 */     putAll(map);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\bidimap\DualLinkedHashBidiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */