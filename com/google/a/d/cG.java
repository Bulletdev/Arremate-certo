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
/*    */ final class cg<T>
/*    */   extends cj<T>
/*    */   implements Serializable
/*    */ {
/*    */   final cj<? super T> a;
/*    */   private static final long serialVersionUID = 0L;
/*    */   
/*    */   cg(cj<? super T> paramcj) {
/* 29 */     this.a = paramcj;
/*    */   }
/*    */ 
/*    */   
/*    */   public int compare(T paramT1, T paramT2) {
/* 34 */     if (paramT1 == paramT2) {
/* 35 */       return 0;
/*    */     }
/* 37 */     if (paramT1 == null) {
/* 38 */       return -1;
/*    */     }
/* 40 */     if (paramT2 == null) {
/* 41 */       return 1;
/*    */     }
/* 43 */     return this.a.compare(paramT1, paramT2);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public <S extends T> cj<S> a() {
/* 49 */     return this.a.<T>a().d();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public <S extends T> cj<S> c() {
/* 55 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public <S extends T> cj<S> d() {
/* 60 */     return this.a.d();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 65 */     if (paramObject == this) {
/* 66 */       return true;
/*    */     }
/* 68 */     if (paramObject instanceof cg) {
/* 69 */       cg cg1 = (cg)paramObject;
/* 70 */       return this.a.equals(cg1.a);
/*    */     } 
/* 72 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 77 */     return this.a.hashCode() ^ 0x39153A74;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 82 */     String str = String.valueOf(this.a); return (new StringBuilder(13 + String.valueOf(str).length())).append(str).append(".nullsFirst()").toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\cg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */