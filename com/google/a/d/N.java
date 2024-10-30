/*    */ package com.google.a.d;
/*    */ 
/*    */ import com.google.a.a.b;
/*    */ import java.util.Collection;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import java.util.SortedMap;
/*    */ import java.util.SortedSet;
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
/*    */ abstract class n<K, V>
/*    */   extends p<K, V>
/*    */ {
/*    */   n(SortedMap<K, Collection<V>> paramSortedMap) {
/* 37 */     super(paramSortedMap);
/*    */   }
/*    */ 
/*    */   
/*    */   public SortedMap<K, Collection<V>> b() {
/* 42 */     return (SortedMap<K, Collection<V>>)super.asMap();
/*    */   }
/*    */ 
/*    */   
/*    */   SortedMap<K, Collection<V>> c() {
/* 47 */     return (SortedMap<K, Collection<V>>)super.t();
/*    */   }
/*    */ 
/*    */   
/*    */   public SortedSet<K> b() {
/* 52 */     return (SortedSet<K>)super.keySet();
/*    */   }
/*    */ 
/*    */   
/*    */   Set<K> b() {
/* 57 */     return c();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\n.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */