/*    */ package com.google.a.d;
/*    */ 
/*    */ import com.google.a.a.b;
/*    */ import com.google.a.a.d;
/*    */ import java.util.ListIterator;
/*    */ import java.util.Spliterator;
/*    */ import java.util.Spliterators;
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
/*    */ @b(ck = true, cl = true)
/*    */ class cu<E>
/*    */   extends bh<E>
/*    */ {
/* 32 */   static final bh<Object> n = new cu(new Object[0]);
/*    */   @d
/*    */   final transient Object[] array;
/*    */   
/*    */   cu(Object[] paramArrayOfObject) {
/* 37 */     this.array = paramArrayOfObject;
/*    */   }
/*    */ 
/*    */   
/*    */   public int size() {
/* 42 */     return this.array.length;
/*    */   }
/*    */ 
/*    */   
/*    */   boolean cO() {
/* 47 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   Object[] d() {
/* 52 */     return this.array;
/*    */   }
/*    */ 
/*    */   
/*    */   int ap() {
/* 57 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   int aq() {
/* 62 */     return this.array.length;
/*    */   }
/*    */ 
/*    */   
/*    */   int a(Object[] paramArrayOfObject, int paramInt) {
/* 67 */     System.arraycopy(this.array, 0, paramArrayOfObject, paramInt, this.array.length);
/* 68 */     return paramInt + this.array.length;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public E get(int paramInt) {
/* 75 */     return (E)this.array[paramInt];
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public dk<E> a(int paramInt) {
/* 83 */     return bH.a((E[])this.array, 0, this.array.length, paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public Spliterator<E> spliterator() {
/* 88 */     return Spliterators.spliterator(this.array, 1296);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\cu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */