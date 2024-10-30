/*    */ package com.google.a.d;
/*    */ 
/*    */ import com.google.a.a.b;
/*    */ import com.google.a.a.c;
/*    */ import com.google.a.b.D;
/*    */ import java.io.Serializable;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Spliterator;
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
/*    */ final class bm<K, V>
/*    */   extends bD<K>
/*    */ {
/*    */   private final bj<K, V> j;
/*    */   
/*    */   bm(bj<K, V> parambj) {
/* 39 */     this.j = parambj;
/*    */   }
/*    */ 
/*    */   
/*    */   public int size() {
/* 44 */     return this.j.size();
/*    */   }
/*    */ 
/*    */   
/*    */   public dj<K> b() {
/* 49 */     return this.j.d();
/*    */   }
/*    */ 
/*    */   
/*    */   public Spliterator<K> spliterator() {
/* 54 */     return this.j.e();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean contains(Object paramObject) {
/* 59 */     return this.j.containsKey(paramObject);
/*    */   }
/*    */ 
/*    */   
/*    */   K get(int paramInt) {
/* 64 */     return (K)((Map.Entry)this.j.h().c().get(paramInt)).getKey();
/*    */   }
/*    */ 
/*    */   
/*    */   public void forEach(Consumer<? super K> paramConsumer) {
/* 69 */     D.checkNotNull(paramConsumer);
/* 70 */     this.j.forEach((paramObject1, paramObject2) -> paramConsumer.accept(paramObject1));
/*    */   }
/*    */ 
/*    */   
/*    */   boolean cO() {
/* 75 */     return true;
/*    */   }
/*    */   
/*    */   @c
/*    */   private static class a<K>
/*    */     implements Serializable {
/*    */     final bj<K, ?> j;
/*    */     private static final long serialVersionUID = 0L;
/*    */     
/*    */     a(bj<K, ?> param1bj) {
/* 85 */       this.j = param1bj;
/*    */     }
/*    */     
/*    */     Object readResolve() {
/* 89 */       return this.j.j();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\bm.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */