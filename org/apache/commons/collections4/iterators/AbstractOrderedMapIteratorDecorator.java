/*    */ package org.apache.commons.collections4.iterators;
/*    */ 
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
/*    */ public class AbstractOrderedMapIteratorDecorator<K, V>
/*    */   implements OrderedMapIterator<K, V>
/*    */ {
/*    */   private final OrderedMapIterator<K, V> iterator;
/*    */   
/*    */   public AbstractOrderedMapIteratorDecorator(OrderedMapIterator<K, V> paramOrderedMapIterator) {
/* 43 */     if (paramOrderedMapIterator == null) {
/* 44 */       throw new NullPointerException("OrderedMapIterator must not be null");
/*    */     }
/* 46 */     this.iterator = paramOrderedMapIterator;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected OrderedMapIterator<K, V> getOrderedMapIterator() {
/* 55 */     return this.iterator;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean hasNext() {
/* 62 */     return this.iterator.hasNext();
/*    */   }
/*    */ 
/*    */   
/*    */   public K next() {
/* 67 */     return (K)this.iterator.next();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean hasPrevious() {
/* 72 */     return this.iterator.hasPrevious();
/*    */   }
/*    */ 
/*    */   
/*    */   public K previous() {
/* 77 */     return (K)this.iterator.previous();
/*    */   }
/*    */ 
/*    */   
/*    */   public void remove() {
/* 82 */     this.iterator.remove();
/*    */   }
/*    */ 
/*    */   
/*    */   public K getKey() {
/* 87 */     return (K)this.iterator.getKey();
/*    */   }
/*    */ 
/*    */   
/*    */   public V getValue() {
/* 92 */     return (V)this.iterator.getValue();
/*    */   }
/*    */ 
/*    */   
/*    */   public V setValue(V paramV) {
/* 97 */     return (V)this.iterator.setValue(paramV);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\iterators\AbstractOrderedMapIteratorDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */