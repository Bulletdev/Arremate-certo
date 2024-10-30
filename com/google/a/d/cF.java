/*    */ package com.google.a.d;
/*    */ 
/*    */ import com.google.a.a.b;
/*    */ import com.google.a.b.D;
/*    */ import java.io.Serializable;
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
/*    */ @b(ck = true)
/*    */ final class cf
/*    */   extends cj<Comparable>
/*    */   implements Serializable
/*    */ {
/* 29 */   static final cf a = new cf();
/*    */   
/*    */   private transient cj<Comparable> b;
/*    */   private transient cj<Comparable> c;
/*    */   private static final long serialVersionUID = 0L;
/*    */   
/*    */   public int compare(Comparable<Comparable> paramComparable1, Comparable paramComparable2) {
/* 36 */     D.checkNotNull(paramComparable1);
/* 37 */     D.checkNotNull(paramComparable2);
/* 38 */     return paramComparable1.compareTo(paramComparable2);
/*    */   }
/*    */ 
/*    */   
/*    */   public <S extends Comparable> cj<S> c() {
/* 43 */     cj<Comparable> cj1 = this.b;
/* 44 */     if (cj1 == null) {
/* 45 */       cj1 = this.b = super.<Comparable>c();
/*    */     }
/* 47 */     return (cj)cj1;
/*    */   }
/*    */ 
/*    */   
/*    */   public <S extends Comparable> cj<S> d() {
/* 52 */     cj<Comparable> cj1 = this.c;
/* 53 */     if (cj1 == null) {
/* 54 */       cj1 = this.c = super.<Comparable>d();
/*    */     }
/* 56 */     return (cj)cj1;
/*    */   }
/*    */ 
/*    */   
/*    */   public <S extends Comparable> cj<S> a() {
/* 61 */     return cB.a;
/*    */   }
/*    */ 
/*    */   
/*    */   private Object readResolve() {
/* 66 */     return a;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 71 */     return "Ordering.natural()";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\cf.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */