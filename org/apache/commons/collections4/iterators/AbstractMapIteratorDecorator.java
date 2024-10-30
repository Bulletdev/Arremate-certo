/*    */ package org.apache.commons.collections4.iterators;
/*    */ 
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AbstractMapIteratorDecorator<K, V>
/*    */   implements MapIterator<K, V>
/*    */ {
/*    */   private final MapIterator<K, V> iterator;
/*    */   
/*    */   public AbstractMapIteratorDecorator(MapIterator<K, V> paramMapIterator) {
/* 43 */     if (paramMapIterator == null) {
/* 44 */       throw new NullPointerException("MapIterator must not be null");
/*    */     }
/* 46 */     this.iterator = paramMapIterator;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected MapIterator<K, V> getMapIterator() {
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
/*    */   public void remove() {
/* 72 */     this.iterator.remove();
/*    */   }
/*    */ 
/*    */   
/*    */   public K getKey() {
/* 77 */     return (K)this.iterator.getKey();
/*    */   }
/*    */ 
/*    */   
/*    */   public V getValue() {
/* 82 */     return (V)this.iterator.getValue();
/*    */   }
/*    */ 
/*    */   
/*    */   public V setValue(V paramV) {
/* 87 */     return (V)this.iterator.setValue(paramV);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\iterators\AbstractMapIteratorDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */