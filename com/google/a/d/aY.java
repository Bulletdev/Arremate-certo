/*    */ package com.google.a.d;
/*    */ 
/*    */ import com.google.a.a.b;
/*    */ import com.google.b.a.a;
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
/*    */ @b
/*    */ public abstract class ay<T>
/*    */   extends aI
/*    */   implements Iterator<T>
/*    */ {
/*    */   public boolean hasNext() {
/* 49 */     return i().hasNext();
/*    */   }
/*    */ 
/*    */   
/*    */   @a
/*    */   public T next() {
/* 55 */     return i().next();
/*    */   }
/*    */ 
/*    */   
/*    */   public void remove() {
/* 60 */     i().remove();
/*    */   }
/*    */   
/*    */   protected abstract Iterator<T> i();
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\ay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */