/*    */ package br.com.arremate.f;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum v
/*    */ {
/*  8 */   a(0),
/*  9 */   b(1),
/* 10 */   c(2);
/*    */   
/*    */   private final int ah;
/*    */   
/*    */   v(int paramInt1) {
/* 15 */     this.ah = paramInt1;
/*    */   }
/*    */   
/*    */   public int v() {
/* 19 */     return this.ah;
/*    */   }
/*    */   
/*    */   public static v a(int paramInt) {
/* 23 */     switch (paramInt) {
/*    */       case 2:
/* 25 */         return c;
/*    */       case 1:
/* 27 */         return b;
/*    */     } 
/* 29 */     return (v)a;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\f\v.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */