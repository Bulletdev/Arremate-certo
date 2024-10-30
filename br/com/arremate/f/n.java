/*    */ package br.com.arremate.f;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum n
/*    */ {
/*  8 */   a(0),
/*  9 */   b(1),
/* 10 */   c(2);
/*    */   
/*    */   private final int ai;
/*    */   
/*    */   n(int paramInt1) {
/* 15 */     this.ai = paramInt1;
/*    */   }
/*    */   
/*    */   public int w() {
/* 19 */     return this.ai;
/*    */   }
/*    */   
/*    */   public static n a(int paramInt) {
/* 23 */     switch (paramInt) {
/*    */       case 0:
/* 25 */         return (n)a;
/*    */       case 1:
/* 27 */         return b;
/*    */     } 
/* 29 */     return c;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\f\n.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */