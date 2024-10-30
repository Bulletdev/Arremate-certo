/*    */ package org.junit.c.c;
/*    */ 
/*    */ import org.d.g;
/*    */ import org.d.i;
/*    */ import org.d.k;
/*    */ import org.d.p;
/*    */ import org.junit.c.l;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class a<T extends Throwable>
/*    */   extends p<T>
/*    */ {
/*    */   private final k<T> g;
/*    */   
/*    */   public a(k<T> paramk) {
/* 19 */     this.g = paramk;
/*    */   }
/*    */   
/*    */   public void a(g paramg) {
/* 23 */     this.g.a(paramg);
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean c(T paramT) {
/* 28 */     return this.g.E(paramT);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void a(T paramT, g paramg) {
/* 33 */     this.g.a(paramT, paramg);
/* 34 */     paramg.a("\nStacktrace was: ");
/* 35 */     paramg.a(f((Throwable)paramT));
/*    */   }
/*    */   
/*    */   private String f(Throwable paramThrowable) {
/* 39 */     return l.c(paramThrowable);
/*    */   }
/*    */ 
/*    */   
/*    */   @i
/*    */   public static <T extends Throwable> k<T> f(k<T> paramk) {
/* 45 */     return (k<T>)new a<T>(paramk);
/*    */   }
/*    */ 
/*    */   
/*    */   @i
/*    */   public static <T extends Exception> k<T> g(k<T> paramk) {
/* 51 */     return (k)new a<Throwable>((k)paramk);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\c\a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */