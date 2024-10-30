/*    */ package com.a.c;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class i
/*    */   extends c
/*    */ {
/* 40 */   protected c b = null;
/* 41 */   protected c c = null;
/*    */   
/*    */   public i(c paramc1, c paramc2) {
/* 44 */     d(paramc1);
/* 45 */     e(paramc2);
/*    */   }
/*    */   
/*    */   public void d(c paramc) {
/* 49 */     a(paramc);
/* 50 */     if (this.b != null)
/* 51 */       this.b.a = null; 
/* 52 */     paramc.a = this;
/* 53 */     this.b = paramc;
/*    */   }
/*    */   
/*    */   public void e(c paramc) {
/* 57 */     a(paramc);
/* 58 */     if (this.c != null)
/* 59 */       this.c.a = null; 
/* 60 */     paramc.a = this;
/* 61 */     this.c = paramc;
/*    */   }
/*    */   
/*    */   public c b() {
/* 65 */     return this.b;
/*    */   }
/*    */   
/*    */   public c c() {
/* 69 */     return this.c;
/*    */   }
/*    */   
/*    */   public abstract String dC();
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\a\c\i.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */