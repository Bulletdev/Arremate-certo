/*    */ package com.google.a.b;
/*    */ 
/*    */ import com.google.a.a.b;
/*    */ import java.util.Collections;
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
/*    */ @b
/*    */ final class a<T>
/*    */   extends z<T>
/*    */ {
/* 27 */   static final a<Object> a = new a();
/*    */   private static final long serialVersionUID = 0L;
/*    */   
/*    */   static <T> z<T> a() {
/* 31 */     return a;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean cm() {
/* 38 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public T get() {
/* 43 */     throw new IllegalStateException("Optional.get() cannot be called on an absent value");
/*    */   }
/*    */ 
/*    */   
/*    */   public T a(T paramT) {
/* 48 */     return D.b(paramT, "use Optional.orNull() instead of Optional.or(null)");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public z<T> a(z<? extends T> paramz) {
/* 54 */     return (z<T>)D.<z<? extends T>>checkNotNull(paramz);
/*    */   }
/*    */ 
/*    */   
/*    */   public T a(M<? extends T> paramM) {
/* 59 */     return D.b(paramM
/* 60 */         .get(), "use Optional.orNull() instead of a Supplier that returns null");
/*    */   }
/*    */ 
/*    */   
/*    */   public T a() {
/* 65 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<T> asSet() {
/* 70 */     return Collections.emptySet();
/*    */   }
/*    */ 
/*    */   
/*    */   public <V> z<V> a(s<? super T, V> params) {
/* 75 */     D.checkNotNull(params);
/* 76 */     return z.b();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 81 */     return (paramObject == this);
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 86 */     return 2040732332;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 91 */     return "Optional.absent()";
/*    */   }
/*    */   
/*    */   private Object readResolve() {
/* 95 */     return a;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\b\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */