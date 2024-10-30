/*    */ package org.junit.c.c;
/*    */ 
/*    */ import org.d.g;
/*    */ import org.d.i;
/*    */ import org.d.k;
/*    */ import org.d.m;
/*    */ import org.d.p;
/*    */ 
/*    */ public class c<T extends Throwable>
/*    */   extends p<T> {
/*    */   private final k<String> b;
/*    */   
/*    */   public c(k<String> paramk) {
/* 14 */     this.b = paramk;
/*    */   }
/*    */   
/*    */   public void a(g paramg) {
/* 18 */     paramg.a("exception with message ");
/* 19 */     paramg.a((m)this.b);
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean c(T paramT) {
/* 24 */     return this.b.E(paramT.getMessage());
/*    */   }
/*    */ 
/*    */   
/*    */   protected void a(T paramT, g paramg) {
/* 29 */     paramg.a("message ");
/* 30 */     this.b.a(paramT.getMessage(), paramg);
/*    */   }
/*    */   
/*    */   @i
/*    */   public static <T extends Throwable> k<T> i(k<String> paramk) {
/* 35 */     return (k)new c<Throwable>(paramk);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\c\c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */