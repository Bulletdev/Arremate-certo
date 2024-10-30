/*    */ package br.com.arremate.f;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum q
/*    */ {
/*  8 */   a(1, "Disputa do 2° ao 5° colocado"),
/*  9 */   b(4, "Permitir escolher posição a ser disputada pelo robô"),
/* 10 */   c(14, "Visualizar CNPJ, empresa, porte, modelo, marca, fabricante"),
/* 11 */   d(15, "Disputa inteligente ComprasNet (Cotação e Dispensa Eletrônica)"),
/* 12 */   e(23, "Visualizar Melhores Lances nos Itens Encerrados"),
/* 13 */   f(24, "Lance no início da disputa"),
/* 14 */   g(25, "Ocultar pregões"),
/* 15 */   h(29, "Tempo Randômico MG"),
/* 16 */   i(45, "Disputa contra MEI/ME/EPP"),
/* 17 */   j(50, "Exportar Resultados para CRM"),
/* 18 */   k(73, "Customização JnJ");
/*    */   
/*    */   private final int ah;
/*    */   private final String aH;
/*    */   
/*    */   q(int paramInt1, String paramString1) {
/* 24 */     this.ah = paramInt1;
/* 25 */     this.aH = paramString1;
/*    */   }
/*    */   
/*    */   public int v() {
/* 29 */     return this.ah;
/*    */   }
/*    */   
/*    */   public String K() {
/* 33 */     return this.aH;
/*    */   }
/*    */   
/*    */   public static q a(int paramInt) {
/* 37 */     for (q q1 : values()) {
/* 38 */       if (q1.v() == paramInt) {
/* 39 */         return q1;
/*    */       }
/*    */     } 
/* 42 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\f\q.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */