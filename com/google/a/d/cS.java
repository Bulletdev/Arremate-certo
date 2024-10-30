/*    */ package com.google.a.d;
/*    */ 
/*    */ import com.google.a.a.b;
/*    */ import com.google.a.a.c;
/*    */ import java.util.ListIterator;
/*    */ import java.util.function.Consumer;
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
/*    */ @b(cl = true)
/*    */ class cs<E>
/*    */   extends aZ<E>
/*    */ {
/*    */   private final bd<E> c;
/*    */   private final bh<? extends E> m;
/*    */   
/*    */   cs(bd<E> parambd, bh<? extends E> parambh) {
/* 36 */     this.c = parambd;
/* 37 */     this.m = parambh;
/*    */   }
/*    */   
/*    */   cs(bd<E> parambd, Object[] paramArrayOfObject) {
/* 41 */     this(parambd, bh.c(paramArrayOfObject));
/*    */   }
/*    */ 
/*    */   
/*    */   bd<E> a() {
/* 46 */     return this.c;
/*    */   }
/*    */   
/*    */   bh<? extends E> i() {
/* 50 */     return this.m;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public dk<E> a(int paramInt) {
/* 56 */     return (dk)this.m.a(paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   @c
/*    */   public void forEach(Consumer<? super E> paramConsumer) {
/* 62 */     this.m.forEach(paramConsumer);
/*    */   }
/*    */ 
/*    */   
/*    */   @c
/*    */   int a(Object[] paramArrayOfObject, int paramInt) {
/* 68 */     return this.m.a(paramArrayOfObject, paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   Object[] d() {
/* 73 */     return this.m.d();
/*    */   }
/*    */ 
/*    */   
/*    */   int ap() {
/* 78 */     return this.m.ap();
/*    */   }
/*    */ 
/*    */   
/*    */   int aq() {
/* 83 */     return this.m.aq();
/*    */   }
/*    */ 
/*    */   
/*    */   public E get(int paramInt) {
/* 88 */     return this.m.get(paramInt);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\cs.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */