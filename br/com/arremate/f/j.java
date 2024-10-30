/*    */ package br.com.arremate.f;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum j
/*    */ {
/*  9 */   a(0, "Em Disputa"),
/* 10 */   b(0, "Participando"),
/* 11 */   c(0, "Suspenso"),
/* 12 */   d(1, "Disputa Agendada"),
/* 13 */   e(1, "Inscrição de Proposta"),
/* 14 */   f(1, "Aguardando Abertura da Sessão"),
/* 15 */   g(3, "Disputa Encerrada");
/*    */   
/*    */   private final int order;
/*    */   private final String aH;
/*    */   
/*    */   j(int paramInt1, String paramString1) {
/* 21 */     this.order = paramInt1;
/* 22 */     this.aH = paramString1;
/*    */   }
/*    */   
/*    */   public int getOrder() {
/* 26 */     return this.order;
/*    */   }
/*    */   
/*    */   public String K() {
/* 30 */     return this.aH;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\f\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */