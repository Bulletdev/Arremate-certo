/*    */ package org.apache.commons.collections4.keyvalue;
/*    */ 
/*    */ import java.util.Map;
/*    */ import org.apache.commons.collections4.KeyValue;
/*    */ import org.apache.commons.collections4.Unmodifiable;
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
/*    */ public final class UnmodifiableMapEntry<K, V>
/*    */   extends AbstractMapEntry<K, V>
/*    */   implements Unmodifiable
/*    */ {
/*    */   public UnmodifiableMapEntry(K paramK, V paramV) {
/* 40 */     super(paramK, paramV);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public UnmodifiableMapEntry(KeyValue<? extends K, ? extends V> paramKeyValue) {
/* 50 */     super((K)paramKeyValue.getKey(), (V)paramKeyValue.getValue());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public UnmodifiableMapEntry(Map.Entry<? extends K, ? extends V> paramEntry) {
/* 60 */     super(paramEntry.getKey(), paramEntry.getValue());
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
/*    */   public V setValue(V paramV) {
/* 72 */     throw new UnsupportedOperationException("setValue() is not supported");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\keyvalue\UnmodifiableMapEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */