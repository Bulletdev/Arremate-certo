/*    */ package com.google.a.d;
/*    */ 
/*    */ import com.google.a.a.b;
/*    */ import com.google.a.b.D;
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
/*    */ @b
/*    */ abstract class db<F, T>
/*    */   implements Iterator<T>
/*    */ {
/*    */   final Iterator<? extends F> h;
/*    */   
/*    */   db(Iterator<? extends F> paramIterator) {
/* 35 */     this.h = (Iterator<? extends F>)D.checkNotNull(paramIterator);
/*    */   }
/*    */ 
/*    */   
/*    */   abstract T transform(F paramF);
/*    */   
/*    */   public final boolean hasNext() {
/* 42 */     return this.h.hasNext();
/*    */   }
/*    */ 
/*    */   
/*    */   public final T next() {
/* 47 */     return transform(this.h.next());
/*    */   }
/*    */ 
/*    */   
/*    */   public final void remove() {
/* 52 */     this.h.remove();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\db.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */