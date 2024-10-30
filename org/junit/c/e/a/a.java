/*    */ package org.junit.c.e.a;
/*    */ 
/*    */ import org.junit.c.b;
/*    */ import org.junit.f.a.h;
/*    */ import org.junit.runner.b.c;
/*    */ import org.junit.runner.c;
/*    */ 
/*    */ 
/*    */ public class a
/*    */ {
/*    */   private final c a;
/*    */   private final c b;
/*    */   
/*    */   public a(c paramc, c paramc1) {
/* 15 */     this.a = paramc;
/* 16 */     this.b = paramc1;
/*    */   }
/*    */   
/*    */   public void l(Throwable paramThrowable) {
/* 20 */     if (paramThrowable instanceof h) {
/* 21 */       a((h)paramThrowable);
/*    */     } else {
/* 23 */       this.a.c(new org.junit.runner.b.a(this.b, paramThrowable));
/*    */     } 
/*    */   }
/*    */   
/*    */   private void a(h paramh) {
/* 28 */     for (Throwable throwable : paramh.bq()) {
/* 29 */       l(throwable);
/*    */     }
/*    */   }
/*    */   
/*    */   public void b(b paramb) {
/* 34 */     this.a.d(new org.junit.runner.b.a(this.b, (Throwable)paramb));
/*    */   }
/*    */   
/*    */   public void iz() {
/* 38 */     this.a.p(this.b);
/*    */   }
/*    */   
/*    */   public void iA() {
/* 42 */     this.a.n(this.b);
/*    */   }
/*    */   
/*    */   public void iB() {
/* 46 */     this.a.o(this.b);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void iC() {
/* 57 */     this.a.l(this.b);
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
/*    */   public void iD() {
/* 69 */     this.a.m(this.b);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\e\a\a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */