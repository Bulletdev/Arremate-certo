/*    */ package com.google.a.d;
/*    */ 
/*    */ import com.google.a.a.b;
/*    */ import java.io.Serializable;
/*    */ import java.util.List;
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
/*    */ @b(ck = true)
/*    */ final class r
/*    */   extends cj<Object>
/*    */   implements Serializable
/*    */ {
/* 31 */   static final r a = new r();
/*    */   private static final long serialVersionUID = 0L;
/*    */   
/*    */   public int compare(Object paramObject1, Object paramObject2) {
/* 35 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public <E> List<E> b(Iterable<E> paramIterable) {
/* 40 */     return bS.a(paramIterable);
/*    */   }
/*    */ 
/*    */   
/*    */   public <E> bh<E> a(Iterable<E> paramIterable) {
/* 45 */     return bh.b(paramIterable);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public <S> cj<S> a() {
/* 51 */     return this;
/*    */   }
/*    */   
/*    */   private Object readResolve() {
/* 55 */     return a;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 60 */     return "Ordering.allEqual()";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\r.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */