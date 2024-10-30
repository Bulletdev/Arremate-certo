/*    */ package org.junit.c.d;
/*    */ 
/*    */ import org.junit.c.e.b;
/*    */ import org.junit.runner.a.h;
/*    */ import org.junit.runner.j;
/*    */ import org.junit.runner.m;
/*    */ 
/*    */ public class d
/*    */   extends c
/*    */ {
/*    */   private final j a;
/*    */   private final h a;
/*    */   
/*    */   public d(j paramj, h paramh) {
/* 15 */     this.a = (h)paramj;
/* 16 */     this.a = paramh;
/*    */   }
/*    */ 
/*    */   
/*    */   protected m b() {
/* 21 */     m m = this.a.a();
/*    */     try {
/* 23 */       this.a.I(m);
/* 24 */     } catch (org.junit.runner.a.d d1) {
/* 25 */       return (m)new b(this.a.getClass(), (Throwable)d1);
/*    */     } 
/* 27 */     return m;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\d\d.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */