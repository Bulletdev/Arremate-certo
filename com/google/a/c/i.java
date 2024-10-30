/*    */ package com.google.a.c;
/*    */ 
/*    */ import com.google.a.a.c;
/*    */ import com.google.a.b.D;
/*    */ import com.google.a.d.bj;
/*    */ import java.util.concurrent.ExecutionException;
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
/*    */ @c
/*    */ public abstract class i<K, V>
/*    */   extends h<K, V>
/*    */   implements j<K, V>
/*    */ {
/*    */   public V get(K paramK) throws ExecutionException {
/* 45 */     return a().get(paramK);
/*    */   }
/*    */ 
/*    */   
/*    */   public V h(K paramK) {
/* 50 */     return a().h(paramK);
/*    */   }
/*    */ 
/*    */   
/*    */   public bj<K, V> b(Iterable<? extends K> paramIterable) throws ExecutionException {
/* 55 */     return a().b(paramIterable);
/*    */   }
/*    */ 
/*    */   
/*    */   public V apply(K paramK) {
/* 60 */     return a().apply(paramK);
/*    */   }
/*    */ 
/*    */   
/*    */   public void e(K paramK) {
/* 65 */     a().e(paramK);
/*    */   }
/*    */ 
/*    */   
/*    */   protected abstract j<K, V> a();
/*    */ 
/*    */   
/*    */   public static abstract class a<K, V>
/*    */     extends i<K, V>
/*    */   {
/*    */     private final j<K, V> a;
/*    */ 
/*    */     
/*    */     protected a(j<K, V> param1j) {
/* 79 */       this.a = (j<K, V>)D.checkNotNull(param1j);
/*    */     }
/*    */ 
/*    */     
/*    */     protected final j<K, V> a() {
/* 84 */       return this.a;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\c\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */