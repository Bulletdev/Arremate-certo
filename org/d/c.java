/*    */ package org.d;
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
/*    */ public abstract class c<T>
/*    */ {
/* 14 */   public static final b<Object> a = new b();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private c() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean a(k<T> paramk)
/*    */   {
/* 25 */     return a(paramk, ""); } public final <U> c<U> b(c<? super T, U> paramc) {
/* 26 */     return a(paramc);
/*    */   }
/*    */   
/*    */   public static <T> c<T> a() {
/* 30 */     return a;
/*    */   }
/*    */   
/*    */   public static <T> c<T> a(T paramT, g paramg) {
/* 34 */     return new a<T>(paramT, paramg);
/*    */   }
/*    */   public abstract boolean a(k<T> paramk, String paramString);
/*    */   public abstract <U> c<U> a(c<? super T, U> paramc);
/*    */   public static interface c<I, O> {
/*    */     c<O> b(I param1I, g param1g); }
/*    */   private static final class a<T> extends c<T> { private final T aA;
/*    */     private a(T param1T, g param1g) {
/* 42 */       this.aA = param1T;
/* 43 */       this.a = param1g;
/*    */     }
/*    */     private final g a;
/*    */     
/*    */     public boolean a(k<T> param1k, String param1String) {
/* 48 */       if (param1k.E(this.aA)) {
/* 49 */         return true;
/*    */       }
/* 51 */       this.a.a(param1String);
/* 52 */       param1k.a(this.aA, this.a);
/* 53 */       return false;
/*    */     }
/*    */ 
/*    */     
/*    */     public <U> c<U> a(c.c<? super T, U> param1c) {
/* 58 */       return param1c.b(this.aA, this.a);
/*    */     } }
/*    */   private static final class b<T> extends c<T> { private b() {}
/*    */     
/*    */     public boolean a(k<T> param1k, String param1String) {
/* 63 */       return false;
/*    */     }
/*    */     public <U> c<U> a(c.c<? super T, U> param1c) {
/* 66 */       return a();
/*    */     } }
/*    */ 
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\d\c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */