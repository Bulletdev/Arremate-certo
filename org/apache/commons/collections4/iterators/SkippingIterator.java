/*    */ package org.apache.commons.collections4.iterators;
/*    */ 
/*    */ import java.util.Iterator;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SkippingIterator<E>
/*    */   extends AbstractIteratorDecorator<E>
/*    */ {
/*    */   private final long offset;
/*    */   private long pos;
/*    */   
/*    */   public SkippingIterator(Iterator<E> paramIterator, long paramLong) {
/* 51 */     super(paramIterator);
/*    */     
/* 53 */     if (paramLong < 0L) {
/* 54 */       throw new IllegalArgumentException("Offset parameter must not be negative.");
/*    */     }
/*    */     
/* 57 */     this.offset = paramLong;
/* 58 */     this.pos = 0L;
/* 59 */     init();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void init() {
/* 66 */     while (this.pos < this.offset && hasNext()) {
/* 67 */       next();
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public E next() {
/* 75 */     E e = super.next();
/* 76 */     this.pos++;
/* 77 */     return e;
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
/*    */   
/*    */   public void remove() {
/* 90 */     if (this.pos <= this.offset) {
/* 91 */       throw new IllegalStateException("remove() can not be called before calling next()");
/*    */     }
/* 93 */     super.remove();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\iterators\SkippingIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */