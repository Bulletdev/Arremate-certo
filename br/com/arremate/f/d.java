/*    */ package br.com.arremate.f;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum d
/*    */ {
/*  9 */   a(0),
/* 10 */   b(6),
/* 11 */   c(12),
/* 12 */   d(13),
/* 13 */   e(99);
/*    */   
/*    */   private final int ah;
/*    */   
/*    */   d(int paramInt1) {
/* 18 */     this.ah = paramInt1;
/*    */   }
/*    */   
/*    */   public int v() {
/* 22 */     return this.ah;
/*    */   }
/*    */   
/*    */   public static d a(int paramInt) throws Exception {
/* 26 */     for (d d1 : values()) {
/* 27 */       if (d1.v() == paramInt) {
/* 28 */         return d1;
/*    */       }
/*    */     } 
/*    */     
/* 32 */     throw new Exception("Não foi encontrado enum para o codigo: " + paramInt);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\f\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */