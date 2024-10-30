/*    */ package org.junit.e;
/*    */ 
/*    */ import org.junit.f.a.l;
/*    */ import org.junit.runner.c;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class h
/*    */   extends l
/*    */ {
/*    */   private final l e;
/*    */   
/*    */   public h(l paraml, Iterable<l> paramIterable, c paramc) {
/* 15 */     this.e = a(paraml, paramIterable, paramc);
/*    */   }
/*    */ 
/*    */   
/*    */   public void io() throws Throwable {
/* 20 */     this.e.io();
/*    */   }
/*    */ 
/*    */   
/*    */   private static l a(l paraml, Iterable<l> paramIterable, c paramc) {
/* 25 */     for (l l1 : paramIterable) {
/* 26 */       paraml = l1.a(paraml, paramc);
/*    */     }
/* 28 */     return paraml;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\e\h.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */