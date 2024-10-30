/*    */ package br.com.arremate.f;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum p
/*    */ {
/*  8 */   a(0, "Indefinido"),
/*  9 */   b(1, "ME/EPP"),
/* 10 */   c(2, "Demais");
/*    */   
/*    */   private final int index;
/*    */   private final String aH;
/*    */   
/*    */   p(int paramInt1, String paramString1) {
/* 16 */     this.index = paramInt1;
/* 17 */     this.aH = paramString1;
/*    */   }
/*    */   
/*    */   public int getIndex() {
/* 21 */     return this.index;
/*    */   }
/*    */   
/*    */   public String K() {
/* 25 */     return this.aH;
/*    */   }
/*    */   
/*    */   public static p a(int paramInt) {
/* 29 */     for (p p1 : values()) {
/* 30 */       if (p1.getIndex() == paramInt) {
/* 31 */         return p1;
/*    */       }
/*    */     } 
/*    */     
/* 35 */     return (p)a;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\f\p.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */