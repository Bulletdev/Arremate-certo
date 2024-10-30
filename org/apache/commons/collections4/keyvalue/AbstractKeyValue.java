/*    */ package org.apache.commons.collections4.keyvalue;
/*    */ 
/*    */ import org.apache.commons.collections4.KeyValue;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AbstractKeyValue<K, V>
/*    */   implements KeyValue<K, V>
/*    */ {
/*    */   private K key;
/*    */   private V value;
/*    */   
/*    */   protected AbstractKeyValue(K paramK, V paramV) {
/* 43 */     this.key = paramK;
/* 44 */     this.value = paramV;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public K getKey() {
/* 53 */     return this.key;
/*    */   }
/*    */   
/*    */   protected K setKey(K paramK) {
/* 57 */     K k = this.key;
/* 58 */     this.key = paramK;
/* 59 */     return k;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public V getValue() {
/* 68 */     return this.value;
/*    */   }
/*    */   
/*    */   protected V setValue(V paramV) {
/* 72 */     V v = this.value;
/* 73 */     this.value = paramV;
/* 74 */     return v;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 84 */     return (new StringBuilder()).append(getKey()).append('=').append(getValue()).toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\keyvalue\AbstractKeyValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */