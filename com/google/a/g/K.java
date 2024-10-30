/*    */ package com.google.a.g;
/*    */ 
/*    */ import com.google.a.d.aU;
/*    */ import com.google.a.d.ba;
/*    */ import com.google.a.d.w;
/*    */ import java.util.Collections;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class k<N, E>
/*    */   extends b<N, E>
/*    */ {
/*    */   protected k(Map<E, N> paramMap1, Map<E, N> paramMap2, int paramInt) {
/* 39 */     super(paramMap1, paramMap2, paramInt);
/*    */   }
/*    */   
/*    */   static <N, E> k<N, E> a() {
/* 43 */     return new k<>(
/* 44 */         (Map<E, N>)aU.a(2), (Map<E, N>)aU.a(2), 0);
/*    */   }
/*    */ 
/*    */   
/*    */   static <N, E> k<N, E> a(Map<E, N> paramMap1, Map<E, N> paramMap2, int paramInt) {
/* 49 */     return new k<>(
/* 50 */         (Map<E, N>)ba.a(paramMap1), (Map<E, N>)ba.a(paramMap2), paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<N> B() {
/* 55 */     return Collections.unmodifiableSet(((w)this.Z).values());
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<N> C() {
/* 60 */     return Collections.unmodifiableSet(((w)this.aa).values());
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<E> g(N paramN) {
/* 65 */     return new l<>((Map<?, E>)((w)this.aa).a(), paramN);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\g\k.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */