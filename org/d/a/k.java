/*    */ package org.d.a;
/*    */ 
/*    */ import org.d.b;
/*    */ import org.d.g;
/*    */ import org.d.i;
/*    */ import org.d.m;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class k<T>
/*    */   extends b<T>
/*    */ {
/*    */   private final org.d.k<T> b;
/*    */   
/*    */   public k(org.d.k<T> paramk) {
/* 20 */     this.b = paramk;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean E(Object paramObject) {
/* 25 */     return !this.b.E(paramObject);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(g paramg) {
/* 30 */     paramg.a("not ").a((m)this.b);
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
/*    */   
/*    */   @i
/*    */   public static <T> org.d.k<T> d(org.d.k<T> paramk) {
/* 46 */     return (org.d.k<T>)new k<T>(paramk);
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
/*    */   
/*    */   @i
/*    */   public static <T> org.d.k<T> d(T paramT) {
/* 62 */     return d(i.c(paramT));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\d\a\k.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */