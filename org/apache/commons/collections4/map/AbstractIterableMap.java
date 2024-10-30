/*    */ package org.apache.commons.collections4.map;
/*    */ 
/*    */ import org.apache.commons.collections4.IterableMap;
/*    */ import org.apache.commons.collections4.MapIterator;
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
/*    */ public abstract class AbstractIterableMap<K, V>
/*    */   implements IterableMap<K, V>
/*    */ {
/*    */   public MapIterator<K, V> mapIterator() {
/* 34 */     return new EntrySetToMapIteratorAdapter<K, V>(entrySet());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\map\AbstractIterableMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */