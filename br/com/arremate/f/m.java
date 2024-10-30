/*    */ package br.com.arremate.f;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum m
/*    */ {
/*  9 */   a(0, "Aleatório"),
/* 10 */   b(1, "Aberto"),
/* 11 */   c(2, "Aberto/Fechado"),
/* 12 */   d(3, "Aberto (10520)"),
/* 13 */   e(4, "--"),
/* 14 */   f(5, "Fechado/Aberto"),
/* 15 */   g(6, "Fechado");
/*    */   
/*    */   private final int id;
/*    */   private final String description;
/*    */   
/*    */   m(int paramInt1, String paramString1) {
/* 21 */     this.id = paramInt1;
/* 22 */     this.description = paramString1;
/*    */   }
/*    */   
/*    */   public int getId() {
/* 26 */     return this.id;
/*    */   }
/*    */   
/*    */   public String getDescription() {
/* 30 */     return this.description;
/*    */   }
/*    */   
/*    */   public static m a(int paramInt) {
/* 34 */     for (m m1 : values()) {
/* 35 */       if (m1.getId() == paramInt) {
/* 36 */         return m1;
/*    */       }
/*    */     } 
/*    */     
/* 40 */     return (m)a;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\f\m.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */