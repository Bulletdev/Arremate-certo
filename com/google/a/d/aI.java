/*    */ package com.google.a.d;
/*    */ 
/*    */ import com.google.a.a.b;
/*    */ import com.google.a.b.E;
/*    */ import java.util.Collection;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
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
/*    */ final class ai<K, V>
/*    */   extends ah<K, V>
/*    */   implements ao<K, V>
/*    */ {
/*    */   ai(cF<K, V> paramcF, E<? super Map.Entry<K, V>> paramE) {
/* 34 */     super(paramcF, paramE);
/*    */   }
/*    */ 
/*    */   
/*    */   public cF<K, V> a() {
/* 39 */     return (cF)this.a;
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<V> get(K paramK) {
/* 44 */     return (Set<V>)super.get(paramK);
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<V> a(Object paramObject) {
/* 49 */     return (Set<V>)super.a(paramObject);
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<V> a(K paramK, Iterable<? extends V> paramIterable) {
/* 54 */     return (Set<V>)super.a(paramK, paramIterable);
/*    */   }
/*    */ 
/*    */   
/*    */   Set<Map.Entry<K, V>> n() {
/* 59 */     return cG.a(a().g(), f());
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<Map.Entry<K, V>> g() {
/* 64 */     return (Set<Map.Entry<K, V>>)super.entries();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\ai.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */