/*    */ package junit.b;
/*    */ 
/*    */ import org.junit.c.l;
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
/*    */ public class k
/*    */ {
/*    */   protected i c;
/*    */   protected Throwable f;
/*    */   
/*    */   public k(i parami, Throwable paramThrowable) {
/* 20 */     this.c = parami;
/* 21 */     this.f = paramThrowable;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public i b() {
/* 28 */     return this.c;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Throwable c() {
/* 35 */     return this.f;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 43 */     return this.c + ": " + this.f.getMessage();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String dY() {
/* 51 */     return l.c(c());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String dZ() {
/* 58 */     return c().getMessage();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean ep() {
/* 67 */     return c() instanceof b;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\junit\b\k.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */