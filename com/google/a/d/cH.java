/*    */ package com.google.a.d;
/*    */ 
/*    */ import com.google.a.a.b;
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
/*    */ @b(ck = true)
/*    */ final class ch<T>
/*    */   extends cj<T>
/*    */   implements Serializable
/*    */ {
/*    */   final cj<? super T> a;
/*    */   private static final long serialVersionUID = 0L;
/*    */   
/*    */   ch(cj<? super T> paramcj) {
/* 29 */     this.a = paramcj;
/*    */   }
/*    */ 
/*    */   
/*    */   public int compare(T paramT1, T paramT2) {
/* 34 */     if (paramT1 == paramT2) {
/* 35 */       return 0;
/*    */     }
/* 37 */     if (paramT1 == null) {
/* 38 */       return 1;
/*    */     }
/* 40 */     if (paramT2 == null) {
/* 41 */       return -1;
/*    */     }
/* 43 */     return this.a.compare(paramT1, paramT2);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public <S extends T> cj<S> a() {
/* 49 */     return this.a.<T>a().c();
/*    */   }
/*    */ 
/*    */   
/*    */   public <S extends T> cj<S> c() {
/* 54 */     return this.a.c();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public <S extends T> cj<S> d() {
/* 60 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 65 */     if (paramObject == this) {
/* 66 */       return true;
/*    */     }
/* 68 */     if (paramObject instanceof ch) {
/* 69 */       ch ch1 = (ch)paramObject;
/* 70 */       return this.a.equals(ch1.a);
/*    */     } 
/* 72 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 77 */     return this.a.hashCode() ^ 0xC9177248;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 82 */     String str = String.valueOf(this.a); return (new StringBuilder(12 + String.valueOf(str).length())).append(str).append(".nullsLast()").toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\ch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */