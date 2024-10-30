/*    */ package org.junit.a.c;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.junit.runner.b.b;
/*    */ import org.junit.runner.k;
/*    */ 
/*    */ 
/*    */ class a
/*    */ {
/*    */   private final List<org.junit.runner.b.a> ax;
/*    */   
/*    */   public a(List<org.junit.runner.b.a> paramList) {
/* 13 */     this.ax = paramList;
/*    */   }
/*    */   
/*    */   public k a() {
/* 17 */     k k = new k();
/* 18 */     b b = k.b();
/* 19 */     for (org.junit.runner.b.a a1 : this.ax) {
/*    */       try {
/* 21 */         b.a(a1);
/* 22 */       } catch (Exception exception) {
/* 23 */         throw new RuntimeException("I can't believe this happened");
/*    */       } 
/*    */     } 
/* 26 */     return k;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\a\c\a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */