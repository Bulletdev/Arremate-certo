/*    */ package com.google.a.d;
/*    */ 
/*    */ import com.google.a.a.b;
/*    */ import java.io.Serializable;
/*    */ import java.util.List;
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
/*    */ final class ag<T>
/*    */   extends cj<T>
/*    */   implements Serializable
/*    */ {
/*    */   final bj<T, Integer> g;
/*    */   private static final long serialVersionUID = 0L;
/*    */   
/*    */   ag(List<T> paramList) {
/* 30 */     this(bW.a(paramList));
/*    */   }
/*    */   
/*    */   ag(bj<T, Integer> parambj) {
/* 34 */     this.g = parambj;
/*    */   }
/*    */ 
/*    */   
/*    */   public int compare(T paramT1, T paramT2) {
/* 39 */     return c(paramT1) - c(paramT2);
/*    */   }
/*    */   
/*    */   private int c(T paramT) {
/* 43 */     Integer integer = this.g.get(paramT);
/* 44 */     if (integer == null) {
/* 45 */       throw new cj.c(paramT);
/*    */     }
/* 47 */     return integer.intValue();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 52 */     if (paramObject instanceof ag) {
/* 53 */       ag ag1 = (ag)paramObject;
/* 54 */       return this.g.equals(ag1.g);
/*    */     } 
/* 56 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 61 */     return this.g.hashCode();
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 66 */     String str = String.valueOf(this.g.j()); return (new StringBuilder(19 + String.valueOf(str).length())).append("Ordering.explicit(").append(str).append(")").toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\ag.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */