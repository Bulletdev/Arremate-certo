/*    */ package com.google.a.d;
/*    */ 
/*    */ import com.google.a.a.c;
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
/*    */ abstract class k<C extends Comparable>
/*    */   implements cq<C>
/*    */ {
/*    */   public boolean a(C paramC) {
/* 31 */     return (a(paramC) != null);
/*    */   }
/*    */ 
/*    */   
/*    */   public abstract cn<C> a(C paramC);
/*    */ 
/*    */   
/*    */   public boolean isEmpty() {
/* 39 */     return p().isEmpty();
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(cn<C> paramcn) {
/* 44 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(cn<C> paramcn) {
/* 49 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 54 */     b((cn)cn.c());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean a(cq<C> paramcq) {
/* 59 */     return d(paramcq.p());
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(cq<C> paramcq) {
/* 64 */     b(paramcq.p());
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(cq<C> paramcq) {
/* 69 */     c(paramcq.p());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean a(cn<C> paramcn) {
/* 74 */     return !a(paramcn).isEmpty();
/*    */   }
/*    */ 
/*    */   
/*    */   public abstract boolean b(cn<C> paramcn);
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 82 */     if (paramObject == this)
/* 83 */       return true; 
/* 84 */     if (paramObject instanceof cq) {
/* 85 */       cq cq1 = (cq)paramObject;
/* 86 */       return p().equals(cq1.p());
/*    */     } 
/* 88 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public final int hashCode() {
/* 93 */     return p().hashCode();
/*    */   }
/*    */ 
/*    */   
/*    */   public final String toString() {
/* 98 */     return p().toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\k.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */