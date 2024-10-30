/*    */ package org.apache.commons.collections4.iterators;
/*    */ 
/*    */ import java.util.Iterator;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class UnmodifiableIterator<E>
/*    */   implements Iterator<E>, Unmodifiable
/*    */ {
/*    */   private final Iterator<? extends E> iterator;
/*    */   
/*    */   public static <E> Iterator<E> unmodifiableIterator(Iterator<? extends E> paramIterator) {
/* 48 */     if (paramIterator == null) {
/* 49 */       throw new NullPointerException("Iterator must not be null");
/*    */     }
/* 51 */     if (paramIterator instanceof Unmodifiable)
/*    */     {
/* 53 */       return (Iterator)paramIterator;
/*    */     }
/*    */     
/* 56 */     return new UnmodifiableIterator<E>(paramIterator);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private UnmodifiableIterator(Iterator<? extends E> paramIterator) {
/* 67 */     this.iterator = paramIterator;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean hasNext() {
/* 72 */     return this.iterator.hasNext();
/*    */   }
/*    */   
/*    */   public E next() {
/* 76 */     return this.iterator.next();
/*    */   }
/*    */   
/*    */   public void remove() {
/* 80 */     throw new UnsupportedOperationException("remove() is not supported");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\iterators\UnmodifiableIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */