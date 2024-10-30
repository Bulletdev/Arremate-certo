/*    */ package org.d.a;
/*    */ 
/*    */ import org.d.b;
/*    */ import org.d.g;
/*    */ import org.d.i;
/*    */ import org.d.k;
/*    */ import org.d.m;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class f<T>
/*    */   extends b<T>
/*    */ {
/*    */   private final k<T> b;
/*    */   
/*    */   public f(k<T> paramk) {
/* 22 */     this.b = paramk;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean E(Object paramObject) {
/* 27 */     return this.b.E(paramObject);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(g paramg) {
/* 32 */     paramg.a("is ").a((m)this.b);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(Object paramObject, g paramg) {
/* 37 */     this.b.a(paramObject, paramg);
/*    */   }
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
/*    */   @i
/*    */   public static <T> k<T> b(k<T> paramk) {
/* 52 */     return (k<T>)new f<T>(paramk);
/*    */   }
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
/*    */   @i
/*    */   public static <T> k<T> a(T paramT) {
/* 66 */     return b(i.c(paramT));
/*    */   }
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
/*    */   @i
/*    */   @Deprecated
/*    */   public static <T> k<T> a(Class<T> paramClass) {
/* 82 */     k<?> k1 = j.d(paramClass);
/* 83 */     return b((k)k1);
/*    */   }
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
/*    */   @i
/*    */   public static <T> k<T> b(Class<T> paramClass) {
/* 97 */     k<?> k1 = j.d(paramClass);
/* 98 */     return b((k)k1);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\d\a\f.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */