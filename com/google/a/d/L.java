/*    */ package com.google.a.d;
/*    */ 
/*    */ import com.google.a.a.b;
/*    */ import java.util.NoSuchElementException;
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
/*    */ @b
/*    */ public abstract class l<T>
/*    */   extends dj<T>
/*    */ {
/*    */   private T r;
/*    */   
/*    */   protected l(T paramT) {
/* 51 */     this.r = paramT;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected abstract T l(T paramT);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean hasNext() {
/* 63 */     return (this.r != null);
/*    */   }
/*    */ 
/*    */   
/*    */   public final T next() {
/* 68 */     if (!hasNext()) {
/* 69 */       throw new NoSuchElementException();
/*    */     }
/*    */     try {
/* 72 */       return this.r;
/*    */     } finally {
/* 74 */       this.r = l(this.r);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\l.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */