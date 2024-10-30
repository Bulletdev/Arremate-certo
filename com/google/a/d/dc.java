/*    */ package com.google.a.d;
/*    */ 
/*    */ import com.google.a.a.b;
/*    */ import java.util.ListIterator;
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
/*    */ abstract class dc<F, T>
/*    */   extends db<F, T>
/*    */   implements ListIterator<T>
/*    */ {
/*    */   dc(ListIterator<? extends F> paramListIterator) {
/* 33 */     super(paramListIterator);
/*    */   }
/*    */   
/*    */   private ListIterator<? extends F> d() {
/* 37 */     return bH.a(this.h);
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean hasPrevious() {
/* 42 */     return d().hasPrevious();
/*    */   }
/*    */ 
/*    */   
/*    */   public final T previous() {
/* 47 */     return transform(d().previous());
/*    */   }
/*    */ 
/*    */   
/*    */   public final int nextIndex() {
/* 52 */     return d().nextIndex();
/*    */   }
/*    */ 
/*    */   
/*    */   public final int previousIndex() {
/* 57 */     return d().previousIndex();
/*    */   }
/*    */ 
/*    */   
/*    */   public void set(T paramT) {
/* 62 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */   
/*    */   public void add(T paramT) {
/* 67 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\dc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */