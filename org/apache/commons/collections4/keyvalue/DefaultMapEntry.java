/*    */ package org.apache.commons.collections4.keyvalue;
/*    */ 
/*    */ import java.util.Map;
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
/*    */ public final class DefaultMapEntry<K, V>
/*    */   extends AbstractMapEntry<K, V>
/*    */ {
/*    */   public DefaultMapEntry(K paramK, V paramV) {
/* 39 */     super(paramK, paramV);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public DefaultMapEntry(KeyValue<? extends K, ? extends V> paramKeyValue) {
/* 49 */     super((K)paramKeyValue.getKey(), (V)paramKeyValue.getValue());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public DefaultMapEntry(Map.Entry<? extends K, ? extends V> paramEntry) {
/* 59 */     super(paramEntry.getKey(), paramEntry.getValue());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\keyvalue\DefaultMapEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */