/*    */ package com.google.a.b;
/*    */ 
/*    */ import com.google.a.a.a;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @a
/*    */ @b
/*    */ final class t<F, T>
/*    */   extends l<F>
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 0L;
/*    */   private final s<F, ? extends T> c;
/*    */   private final l<T> b;
/*    */   
/*    */   t(s<F, ? extends T> params, l<T> paraml) {
/* 40 */     this.c = D.<s<F, ? extends T>>checkNotNull(params);
/* 41 */     this.b = D.<l<T>>checkNotNull(paraml);
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean b(F paramF1, F paramF2) {
/* 46 */     return this.b.a(this.c.apply(paramF1), this.c.apply(paramF2));
/*    */   }
/*    */ 
/*    */   
/*    */   protected int a(F paramF) {
/* 51 */     return this.b.hash(this.c.apply(paramF));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 56 */     if (paramObject == this) {
/* 57 */       return true;
/*    */     }
/* 59 */     if (paramObject instanceof t) {
/* 60 */       t t1 = (t)paramObject;
/* 61 */       return (this.c.equals(t1.c) && this.b.equals(t1.b));
/*    */     } 
/* 63 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 68 */     return y.a(new Object[] { this.c, this.b });
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 73 */     String str1 = String.valueOf(this.b), str2 = String.valueOf(this.c); return (new StringBuilder(13 + String.valueOf(str1).length() + String.valueOf(str2).length())).append(str1).append(".onResultOf(").append(str2).append(")").toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\b\t.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */