/*    */ package org.apache.commons.collections4.iterators;
/*    */ 
/*    */ import org.apache.commons.collections4.MapIterator;
/*    */ import org.apache.commons.collections4.ResettableIterator;
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
/*    */ public class EmptyMapIterator<K, V>
/*    */   extends AbstractEmptyMapIterator<K, V>
/*    */   implements MapIterator<K, V>, ResettableIterator<K>
/*    */ {
/* 36 */   public static final MapIterator INSTANCE = new EmptyMapIterator();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static <K, V> MapIterator<K, V> emptyMapIterator() {
/* 46 */     return INSTANCE;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\iterators\EmptyMapIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */