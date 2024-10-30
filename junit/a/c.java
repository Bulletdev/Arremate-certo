/*    */ package junit.a;
/*    */ 
/*    */ import junit.b.a;
/*    */ import junit.b.i;
/*    */ import junit.b.m;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class c
/*    */   extends a
/*    */   implements i
/*    */ {
/*    */   protected i b;
/*    */   
/*    */   public c(i parami) {
/* 17 */     this.b = parami;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void b(m paramm) {
/* 24 */     this.b.a(paramm);
/*    */   }
/*    */   
/*    */   public int bc() {
/* 28 */     return this.b.bc();
/*    */   }
/*    */   
/*    */   public void a(m paramm) {
/* 32 */     b(paramm);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 37 */     return this.b.toString();
/*    */   }
/*    */   
/*    */   public i a() {
/* 41 */     return this.b;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\junit\a\c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */