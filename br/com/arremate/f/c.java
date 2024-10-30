/*    */ package br.com.arremate.f;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum c
/*    */ {
/*  9 */   a(0, "Item"),
/* 10 */   b(1, "Descrição"),
/* 11 */   c(2, "Valor Limite"),
/* 12 */   d(3, "Variação Inicial"),
/* 13 */   e(4, "Variação Final"),
/* 14 */   f(5, "Tipo de Redução"),
/* 15 */   g(6, "Lance Fechado");
/*    */   
/*    */   private int ah;
/*    */   private String aG;
/*    */   
/*    */   c(int paramInt1, String paramString1) {
/* 21 */     this.ah = paramInt1;
/* 22 */     this.aG = paramString1;
/*    */   }
/*    */   
/*    */   public int v() {
/* 26 */     return this.ah;
/*    */   }
/*    */   
/*    */   public String J() {
/* 30 */     return this.aG;
/*    */   }
/*    */   
/*    */   public static c a(int paramInt) {
/* 34 */     c c1 = null;
/*    */     
/* 36 */     for (c c2 : values()) {
/* 37 */       if (c2.v() == paramInt) {
/* 38 */         c1 = c2;
/*    */       }
/*    */     } 
/*    */     
/* 42 */     return c1;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\f\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */