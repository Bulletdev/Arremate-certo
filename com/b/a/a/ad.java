/*    */ package com.b.a.a;
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
/*    */ abstract class ad
/*    */   extends Thread
/*    */ {
/*    */   protected final Q b;
/*    */   private final O e;
/*    */   
/*    */   ad(String paramString, Q paramQ, O paramO) {
/* 27 */     super(paramString);
/*    */     
/* 29 */     this.b = paramQ;
/* 30 */     this.e = paramO;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void run() {
/* 37 */     u u = this.b.a();
/*    */     
/* 39 */     if (u != null)
/*    */     {
/*    */       
/* 42 */       u.b(this.e, this);
/*    */     }
/*    */     
/* 45 */     gt();
/*    */     
/* 47 */     if (u != null)
/*    */     {
/*    */       
/* 50 */       u.c(this.e, this);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void gS() {
/* 57 */     u u = this.b.a();
/*    */     
/* 59 */     if (u != null)
/*    */     {
/* 61 */       u.a(this.e, this);
/*    */     }
/*    */   }
/*    */   
/*    */   protected abstract void gt();
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\b\a\a\ad.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */