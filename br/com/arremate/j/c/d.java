/*    */ package br.com.arremate.j.c;
/*    */ 
/*    */ import br.com.arremate.h.c;
/*    */ import br.com.arremate.h.e;
/*    */ import br.com.arremate.h.g;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class d
/*    */   extends c
/*    */ {
/* 16 */   private static final String bg = String.join("", new CharSequence[] { DOMAIN, "cotacao/" });
/* 17 */   private static final String bh = String.join("", new CharSequence[] { DOMAIN, "assinadas/" });
/* 18 */   public static final String bi = String.join("", new CharSequence[] { bh, "cotacao.asp?filtro=participando" });
/*    */   
/*    */   public d(br.com.arremate.l.d paramd) {
/* 21 */     super(paramd);
/*    */     
/* 23 */     c c1 = d();
/* 24 */     c1.a(500);
/* 25 */     a(c1.a());
/*    */   }
/*    */ 
/*    */   
/*    */   public int z() {
/* 30 */     c c1 = f.a().a(a());
/* 31 */     if (c1.isRunning()) {
/* 32 */       setRunning(true);
/* 33 */       cb();
/* 34 */       a(c1);
/* 35 */       return 1;
/*    */     } 
/*    */     
/* 38 */     setMessage(c1.getMessage());
/* 39 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public e e() {
/* 44 */     return c().a(g.c().a(bi));
/*    */   }
/*    */ 
/*    */   
/*    */   public e f() {
/* 49 */     return c().a(g.c().a(bh).a("cotacao.asp").a("filtro", "participou"));
/*    */   }
/*    */   
/*    */   public e g(String paramString) {
/* 53 */     return c().a(g.c().a(bg).a(paramString)
/* 54 */         .b("Referer", String.join("", new CharSequence[] { DOMAIN, "t_top.asp"
/* 55 */             })).b("Sec-Fetch-Site", "same-origin"));
/*    */   }
/*    */   
/*    */   public e h(int paramInt) {
/* 59 */     e e = c().a(g.c().a(bi));
/* 60 */     if (!e.O()) {
/* 61 */       long l = e.k();
/* 62 */       e = c().a(g.c().a(bg).a("lance.asp").a("cot_codigo", paramInt));
/* 63 */       e.q(e.k() + l);
/*    */     } 
/*    */     
/* 66 */     return e;
/*    */   }
/*    */   
/*    */   public e i(int paramInt) {
/* 70 */     return c().a(g.c().a(bg).a("RelatorioCotacao.asp").a("cot_codigo", paramInt));
/*    */   }
/*    */ 
/*    */   
/*    */   public e e(int paramInt) {
/* 75 */     return c().a(
/* 76 */         g.c().a(bg).a("propostaParticipou.asp")
/* 77 */         .a("cot_codigo", paramInt)
/* 78 */         .b("Accept", "")
/* 79 */         .b("Accept-Encoding", "gzip, deflate, br")
/* 80 */         .b("Accept-Language", "pt-BR,pt;q=0.8,en-US;q=0.5,en;q=0.3")
/* 81 */         .b("Connection", "keep-alive")
/* 82 */         .b("Host", "www.comprasnet.gov.br")
/* 83 */         .b("Referer", String.join("", new CharSequence[] { bg, "menu.asp?filtro=participou&identificador="
/* 84 */             })).b("Sec-Fetch-Dest", "Frame")
/* 85 */         .b("Sec-Fetch-Mode", "navigate")
/* 86 */         .b("Sec-Fetch-Site", "same-origin")
/* 87 */         .b("Sec-Fetch-User", "?1")
/* 88 */         .b("Upgrade-Insecure-Requests", "1"));
/*    */   }
/*    */ 
/*    */   
/*    */   public e a(String paramString, int paramInt1, int paramInt2) {
/* 93 */     return c().a(
/* 94 */         g.d().a(bg).a("lanceEnvia.asp")
/* 95 */         .a("lan_valor", paramString)
/* 96 */         .a("cot_codigo", String.valueOf(paramInt1))
/* 97 */         .a("itc_codigo", String.valueOf(paramInt2)));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\c\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */