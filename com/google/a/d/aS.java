/*    */ package com.google.a.d;
/*    */ 
/*    */ import com.google.a.a.b;
/*    */ import com.google.b.a.a;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.ConcurrentMap;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @b
/*    */ public abstract class as<K, V>
/*    */   extends aC<K, V>
/*    */   implements ConcurrentMap<K, V>
/*    */ {
/*    */   @a
/*    */   public V putIfAbsent(K paramK, V paramV) {
/* 51 */     return b().putIfAbsent(paramK, paramV);
/*    */   }
/*    */ 
/*    */   
/*    */   @a
/*    */   public boolean remove(Object paramObject1, Object paramObject2) {
/* 57 */     return b().remove(paramObject1, paramObject2);
/*    */   }
/*    */ 
/*    */   
/*    */   @a
/*    */   public V replace(K paramK, V paramV) {
/* 63 */     return b().replace(paramK, paramV);
/*    */   }
/*    */ 
/*    */   
/*    */   @a
/*    */   public boolean replace(K paramK, V paramV1, V paramV2) {
/* 69 */     return b().replace(paramK, paramV1, paramV2);
/*    */   }
/*    */   
/*    */   protected abstract ConcurrentMap<K, V> b();
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\as.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */