/*    */ package com.google.a.d;
/*    */ 
/*    */ import com.google.a.a.b;
/*    */ import com.google.a.a.c;
/*    */ import java.util.Comparator;
/*    */ import java.util.Objects;
/*    */ import java.util.Spliterator;
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
/*    */ @b(cl = true)
/*    */ final class bv<E>
/*    */   extends cs<E>
/*    */   implements cL<E>
/*    */ {
/*    */   bv(bA<E> parambA, bh<E> parambh) {
/* 34 */     super(parambA, parambh);
/*    */   }
/*    */ 
/*    */   
/*    */   bA<E> d() {
/* 39 */     return (bA<E>)super.a();
/*    */   }
/*    */ 
/*    */   
/*    */   public Comparator<? super E> comparator() {
/* 44 */     return d().comparator();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @c
/*    */   public int indexOf(Object paramObject) {
/* 53 */     int i = d().indexOf(paramObject);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 60 */     return (i >= 0 && get(i).equals(paramObject)) ? i : -1;
/*    */   }
/*    */ 
/*    */   
/*    */   @c
/*    */   public int lastIndexOf(Object paramObject) {
/* 66 */     return indexOf(paramObject);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean contains(Object paramObject) {
/* 72 */     return (indexOf(paramObject) >= 0);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @c
/*    */   bh<E> b(int paramInt1, int paramInt2) {
/* 83 */     bh<E> bh = super.b(paramInt1, paramInt2);
/* 84 */     return (new cz<>(bh, comparator())).c();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Spliterator<E> spliterator() {
/* 92 */     Objects.requireNonNull(i()); return D.a(size(), 1301, i()::get, 
/* 93 */         comparator());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\bv.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */