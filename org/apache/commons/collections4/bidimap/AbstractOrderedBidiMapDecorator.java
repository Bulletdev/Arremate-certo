/*    */ package org.apache.commons.collections4.bidimap;
/*    */ 
/*    */ import java.util.Map;
/*    */ import org.apache.commons.collections4.BidiMap;
/*    */ import org.apache.commons.collections4.MapIterator;
/*    */ import org.apache.commons.collections4.OrderedBidiMap;
/*    */ import org.apache.commons.collections4.OrderedMapIterator;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AbstractOrderedBidiMapDecorator<K, V>
/*    */   extends AbstractBidiMapDecorator<K, V>
/*    */   implements OrderedBidiMap<K, V>
/*    */ {
/*    */   protected AbstractOrderedBidiMapDecorator(OrderedBidiMap<K, V> paramOrderedBidiMap) {
/* 48 */     super((BidiMap<K, V>)paramOrderedBidiMap);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected OrderedBidiMap<K, V> decorated() {
/* 58 */     return (OrderedBidiMap<K, V>)super.decorated();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public OrderedMapIterator<K, V> mapIterator() {
/* 64 */     return decorated().mapIterator();
/*    */   }
/*    */ 
/*    */   
/*    */   public K firstKey() {
/* 69 */     return (K)decorated().firstKey();
/*    */   }
/*    */ 
/*    */   
/*    */   public K lastKey() {
/* 74 */     return (K)decorated().lastKey();
/*    */   }
/*    */ 
/*    */   
/*    */   public K nextKey(K paramK) {
/* 79 */     return (K)decorated().nextKey(paramK);
/*    */   }
/*    */ 
/*    */   
/*    */   public K previousKey(K paramK) {
/* 84 */     return (K)decorated().previousKey(paramK);
/*    */   }
/*    */ 
/*    */   
/*    */   public OrderedBidiMap<V, K> inverseBidiMap() {
/* 89 */     return decorated().inverseBidiMap();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\bidimap\AbstractOrderedBidiMapDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */