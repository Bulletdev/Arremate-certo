/*    */ package org.junit.c.d;
/*    */ 
/*    */ import org.junit.runner.a.e;
/*    */ import org.junit.runner.j;
/*    */ import org.junit.runner.m;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class b
/*    */   extends j
/*    */ {
/*    */   private final j a;
/*    */   private final org.junit.runner.a.b a;
/*    */   
/*    */   public b(j paramj, org.junit.runner.a.b paramb) {
/* 29 */     this.a = (org.junit.runner.a.b)paramj;
/* 30 */     this.a = paramb;
/*    */   }
/*    */ 
/*    */   
/*    */   public m a() {
/*    */     try {
/* 36 */       m m = this.a.a();
/* 37 */       this.a.I(m);
/* 38 */       return m;
/* 39 */     } catch (e e) {
/* 40 */       return (m)new org.junit.c.e.b(org.junit.runner.a.b.class, new Exception(String.format("No tests found matching %s from %s", new Object[] { this.a.eY(), this.a.toString() })));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\d\b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */