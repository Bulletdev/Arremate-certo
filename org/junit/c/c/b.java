/*    */ package org.junit.c.c;
/*    */ 
/*    */ import org.d.g;
/*    */ import org.d.i;
/*    */ import org.d.k;
/*    */ import org.d.m;
/*    */ import org.d.p;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class b<T extends Throwable>
/*    */   extends p<T>
/*    */ {
/*    */   private final k<?> h;
/*    */   
/*    */   public b(k<?> paramk) {
/* 20 */     this.h = paramk;
/*    */   }
/*    */   
/*    */   public void a(g paramg) {
/* 24 */     paramg.a("exception with cause ");
/* 25 */     paramg.a((m)this.h);
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean c(T paramT) {
/* 30 */     return this.h.E(paramT.getCause());
/*    */   }
/*    */ 
/*    */   
/*    */   protected void a(T paramT, g paramg) {
/* 35 */     paramg.a("cause ");
/* 36 */     this.h.a(paramT.getCause(), paramg);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @i
/*    */   public static <T extends Throwable> k<T> h(k<?> paramk) {
/* 48 */     return (k)new b<Throwable>(paramk);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\c\b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */