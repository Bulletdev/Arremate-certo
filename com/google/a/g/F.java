/*    */ package com.google.a.g;
/*    */ 
/*    */ import com.google.a.b.D;
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
/*    */ abstract class f<N, E>
/*    */   implements J<N, E>
/*    */ {
/*    */   protected final Map<E, N> ab;
/*    */   
/*    */   protected f(Map<E, N> paramMap) {
/* 38 */     this.ab = (Map<E, N>)D.checkNotNull(paramMap);
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<N> B() {
/* 43 */     return w();
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<N> C() {
/* 48 */     return w();
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<E> x() {
/* 53 */     return Collections.unmodifiableSet(this.ab.keySet());
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<E> y() {
/* 58 */     return x();
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<E> z() {
/* 63 */     return x();
/*    */   }
/*    */ 
/*    */   
/*    */   public N A(E paramE) {
/* 68 */     return (N)D.checkNotNull(this.ab.get(paramE));
/*    */   }
/*    */ 
/*    */   
/*    */   public N a(E paramE, boolean paramBoolean) {
/* 73 */     if (!paramBoolean) {
/* 74 */       return B(paramE);
/*    */     }
/* 76 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public N B(E paramE) {
/* 81 */     N n = this.ab.remove(paramE);
/* 82 */     return (N)D.checkNotNull(n);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(E paramE, N paramN, boolean paramBoolean) {
/* 87 */     if (!paramBoolean) {
/* 88 */       e(paramE, paramN);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void e(E paramE, N paramN) {
/* 94 */     N n = this.ab.put(paramE, paramN);
/* 95 */     D.ab((n == null));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\g\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */