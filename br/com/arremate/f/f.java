/*    */ package br.com.arremate.f;
/*    */ 
/*    */ import br.com.arremate.m.y;
/*    */ import java.awt.Color;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum f
/*    */ {
/* 14 */   b("Disputa parada", Color.BLACK, "/img/disputa_parada.png"),
/* 15 */   c("Disputa ativa ...", y.e(), "/img/loading-green.gif"),
/* 16 */   d("Disputa em lance fechado ...", y.e(), "/img/loading-green.gif"),
/* 17 */   e("Disputa ativa (instável) ...", y.g(), "/img/loading-orange.gif"),
/* 18 */   f("Pregão em Suspensão Administrativa, aguardando retorno da disputa ...", y.f(), "/img/loading-red.gif"),
/* 19 */   g("Capturando a situação do pregão ...", y.d(), "/img/loading-blue.gif"),
/* 20 */   h("Aguardando pregão entrar em disputa ...", y.d(), "/img/loading-blue.gif"),
/* 21 */   i("Realizando login no portal ...", y.d(), "/img/loading-blue.gif"),
/* 22 */   j("Renovando login no portal ...", y.g(), "/img/loading-orange.gif"),
/* 23 */   k("Carregando a situação dos lotes ...", y.e(), "/img/loading-green.gif"),
/* 24 */   l("Carregando a situação dos itens ...", y.e(), "/img/loading-green.gif"),
/* 25 */   m("Aguardando algum dos seus itens entrar em disputa ...", y.d(), "/img/loading-blue.gif"),
/* 26 */   n("Aguardando algum dos seus lotes entrar em disputa ...", y.d(), "/img/loading-blue.gif"),
/* 27 */   o("Aguardando os lotes serem arrematados ...", y.d(), "/img/loading-blue.gif"),
/* 28 */   p("Sem conexão com a internet, tentando reconectar ...", y.f(), "/img/loading-red.gif"),
/* 29 */   q("Sem conexão com o portal, tentando reconectar ...", y.f(), "/img/loading-red.gif"),
/* 30 */   r("Pregão encontra-se revogado, anulado ou abandonado ...", y.f(), "/img/loading-red.gif"),
/* 31 */   s("Carregando itens fechados/encerrados ...", y.d(), "/img/loading-blue.gif"),
/* 32 */   t("Carregando itens fechados/encerrados (processo lento devido a complexidade da quebra de reCAPTCHA) ...", y.d(), "/img/loading-blue.gif");
/*    */   
/*    */   private final String aI;
/*    */   private final Color a;
/*    */   private final String aJ;
/*    */   
/*    */   f(String paramString1, Color paramColor, String paramString2) {
/* 39 */     this.aI = paramString1;
/* 40 */     this.a = (f[])paramColor;
/* 41 */     this.aJ = paramString2;
/*    */   }
/*    */   
/*    */   public String L() {
/* 45 */     return this.aI;
/*    */   }
/*    */   
/*    */   public Color a() {
/* 49 */     return (Color)this.a;
/*    */   }
/*    */   
/*    */   public String M() {
/* 53 */     return this.aJ;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\f\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */