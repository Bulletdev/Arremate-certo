/*    */ package br.com.arremate.f;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum l
/*    */ {
/*  8 */   a(0, "Pregão Eletrônico"),
/*  9 */   b(1, "Cotação Eletrônica"),
/* 10 */   c(2, "Dispensa Eletrônica"),
/* 11 */   d(4, "Convite"),
/* 12 */   e(5, "RDC"),
/* 13 */   f(6, "LRE"),
/* 14 */   g(7, "Dispensa Eletrônica Comprasnet 4.0"),
/* 15 */   h(8, "Novo Pregão Comprasnet 4.0"),
/* 16 */   i(9, "Dispensa Eletrônica BB 2.0"),
/* 17 */   j(10, "Novo Pregão BB 2.0"),
/* 18 */   k(11, "Concorrencia Eletrônica"),
/* 19 */   l(99, "Não Identificado");
/*    */   
/*    */   private final int id;
/*    */   private final String description;
/*    */   
/*    */   l(int paramInt1, String paramString1) {
/* 25 */     this.id = paramInt1;
/* 26 */     this.description = paramString1;
/*    */   }
/*    */   
/*    */   public int getId() {
/* 30 */     return this.id;
/*    */   }
/*    */   
/*    */   public String getDescription() {
/* 34 */     return this.description;
/*    */   }
/*    */   
/*    */   public static l b(int paramInt) {
/* 38 */     for (l l1 : values()) {
/* 39 */       if (l1.getId() == paramInt) {
/* 40 */         return l1;
/*    */       }
/*    */     } 
/*    */     
/* 44 */     return l;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\f\l.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */