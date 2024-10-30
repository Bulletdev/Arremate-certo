/*    */ package com.google.a.g;
/*    */ 
/*    */ import com.google.a.b.D;
/*    */ import com.google.a.d.bH;
/*    */ import com.google.a.d.bt;
/*    */ import com.google.a.d.dj;
/*    */ import java.util.AbstractSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
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
/*    */ final class l<E>
/*    */   extends AbstractSet<E>
/*    */ {
/*    */   private final Map<?, E> ad;
/*    */   private final Object ak;
/*    */   
/*    */   l(Map<?, E> paramMap, Object paramObject) {
/* 43 */     this.ad = (Map<?, E>)D.checkNotNull(paramMap);
/* 44 */     this.ak = D.checkNotNull(paramObject);
/*    */   }
/*    */ 
/*    */   
/*    */   public dj<E> b() {
/* 49 */     E e = A();
/* 50 */     return (e == null) ? 
/* 51 */       bt.n().b() : 
/* 52 */       bH.a(e);
/*    */   }
/*    */ 
/*    */   
/*    */   public int size() {
/* 57 */     return (A() == null) ? 0 : 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean contains(Object paramObject) {
/* 62 */     E e = A();
/* 63 */     return (e != null && e.equals(paramObject));
/*    */   }
/*    */   
/*    */   private E A() {
/* 67 */     return this.ad.get(this.ak);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\g\l.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */