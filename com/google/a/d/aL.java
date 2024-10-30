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
/*    */ 
/*    */ @b
/*    */ final class al<K, V>
/*    */   extends ak<K, V>
/*    */   implements ao<K, V>
/*    */ {
/*    */   al(cF<K, V> paramcF, E<? super K> paramE) {
/* 35 */     super(paramcF, paramE);
/*    */   }
/*    */ 
/*    */   
/*    */   public cF<K, V> a() {
/* 40 */     return (cF<K, V>)this.a;
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<V> get(K paramK) {
/* 45 */     return (Set<V>)super.get(paramK);
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<V> a(Object paramObject) {
/* 50 */     return (Set<V>)super.a(paramObject);
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<V> a(K paramK, Iterable<? extends V> paramIterable) {
/* 55 */     return (Set<V>)super.a(paramK, paramIterable);
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<Map.Entry<K, V>> g() {
/* 60 */     return (Set<Map.Entry<K, V>>)super.entries();
/*    */   }
/*    */ 
/*    */   
/*    */   Set<Map.Entry<K, V>> n() {
/* 65 */     return new a(this);
/*    */   }
/*    */   class a extends ak<K, V>.c implements Set<Map.Entry<K, V>> { a(al this$0) {
/* 68 */       super(this$0);
/*    */     }
/*    */     public int hashCode() {
/* 71 */       return cG.a(this);
/*    */     }
/*    */ 
/*    */     
/*    */     public boolean equals(Object param1Object) {
/* 76 */       return cG.a(this, param1Object);
/*    */     } }
/*    */ 
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\al.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */