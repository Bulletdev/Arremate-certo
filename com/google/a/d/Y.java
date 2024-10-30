/*    */ package com.google.a.d;
/*    */ 
/*    */ import com.google.a.a.b;
/*    */ import com.google.a.b.D;
/*    */ import com.google.a.b.s;
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
/*    */ 
/*    */ 
/*    */ @b(ck = true)
/*    */ final class y<F, T>
/*    */   extends cj<F>
/*    */   implements Serializable
/*    */ {
/*    */   final s<F, ? extends T> c;
/*    */   final cj<T> a;
/*    */   private static final long serialVersionUID = 0L;
/*    */   
/*    */   y(s<F, ? extends T> params, cj<T> paramcj) {
/* 37 */     this.c = (s<F, ? extends T>)D.checkNotNull(params);
/* 38 */     this.a = (cj<T>)D.checkNotNull(paramcj);
/*    */   }
/*    */ 
/*    */   
/*    */   public int compare(F paramF1, F paramF2) {
/* 43 */     return this.a.compare((T)this.c.apply(paramF1), (T)this.c.apply(paramF2));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 48 */     if (paramObject == this) {
/* 49 */       return true;
/*    */     }
/* 51 */     if (paramObject instanceof y) {
/* 52 */       y y1 = (y)paramObject;
/* 53 */       return (this.c.equals(y1.c) && this.a.equals(y1.a));
/*    */     } 
/* 55 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 60 */     return com.google.a.b.y.a(new Object[] { this.c, this.a });
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 65 */     String str1 = String.valueOf(this.a), str2 = String.valueOf(this.c); return (new StringBuilder(13 + String.valueOf(str1).length() + String.valueOf(str2).length())).append(str1).append(".onResultOf(").append(str2).append(")").toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\y.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */