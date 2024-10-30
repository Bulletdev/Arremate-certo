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
/*    */ 
/*    */ public abstract class AbstractMapEntryDecorator<K, V>
/*    */   implements Map.Entry<K, V>, KeyValue<K, V>
/*    */ {
/*    */   private final Map.Entry<K, V> entry;
/*    */   
/*    */   public AbstractMapEntryDecorator(Map.Entry<K, V> paramEntry) {
/* 42 */     if (paramEntry == null) {
/* 43 */       throw new NullPointerException("Map Entry must not be null.");
/*    */     }
/* 45 */     this.entry = paramEntry;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected Map.Entry<K, V> getMapEntry() {
/* 54 */     return this.entry;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public K getKey() {
/* 60 */     return this.entry.getKey();
/*    */   }
/*    */   
/*    */   public V getValue() {
/* 64 */     return this.entry.getValue();
/*    */   }
/*    */   
/*    */   public V setValue(V paramV) {
/* 68 */     return this.entry.setValue(paramV);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 73 */     if (paramObject == this) {
/* 74 */       return true;
/*    */     }
/* 76 */     return this.entry.equals(paramObject);
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 81 */     return this.entry.hashCode();
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 86 */     return this.entry.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\keyvalue\AbstractMapEntryDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */