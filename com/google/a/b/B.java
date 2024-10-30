/*    */ package com.google.a.b;
/*    */ 
/*    */ import com.google.a.a.b;
/*    */ import java.util.Iterator;
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
/*    */ @b
/*    */ abstract class b<T>
/*    */   implements Iterator<T>
/*    */ {
/*    */   private T next;
/* 31 */   private a a = a.c;
/*    */   
/*    */   protected abstract T b();
/*    */   
/*    */   private enum a {
/* 36 */     b,
/* 37 */     c,
/* 38 */     d,
/* 39 */     e;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @com.google.b.a.a
/*    */   protected final T c() {
/* 48 */     this.a = a.d;
/* 49 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean hasNext() {
/* 54 */     D.ab((this.a != a.e));
/* 55 */     switch (null.y[this.a.ordinal()]) {
/*    */       case 1:
/* 57 */         return false;
/*    */       case 2:
/* 59 */         return true;
/*    */     } 
/*    */     
/* 62 */     return cn();
/*    */   }
/*    */   
/*    */   private boolean cn() {
/* 66 */     this.a = a.e;
/* 67 */     this.next = b();
/* 68 */     if (this.a != a.d) {
/* 69 */       this.a = a.b;
/* 70 */       return true;
/*    */     } 
/* 72 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public final T next() {
/* 77 */     if (!hasNext()) {
/* 78 */       throw new NoSuchElementException();
/*    */     }
/* 80 */     this.a = a.c;
/* 81 */     T t = this.next;
/* 82 */     this.next = null;
/* 83 */     return t;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void remove() {
/* 88 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\b\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */