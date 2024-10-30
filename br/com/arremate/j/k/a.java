/*     */ package br.com.arremate.j.k;
/*     */ 
/*     */ import br.com.arremate.f.x;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.h.g;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.m.A;
/*     */ import com.google.a.o.a.af;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class a
/*     */   extends i
/*     */ {
/*  20 */   private static final af d = af.a(10.0D);
/*     */   
/*     */   private static final String DOMAIN = "https://www.publinexo.com.br/publinexo/";
/*  23 */   private static final String aZ = String.join("", new CharSequence[] { "https://www.publinexo.com.br/publinexo/", "login" });
/*  24 */   private static final String cS = String.join("", new CharSequence[] { "https://www.publinexo.com.br/publinexo/", "jsp/geral/ger_perfilCampos.jsp" });
/*  25 */   private static final String cT = String.join("", new CharSequence[] { "https://www.publinexo.com.br/publinexo/", "jsp/pregao/pg_vd_painel_pregoes.jsp?tipo=" });
/*  26 */   private static final String cU = String.join("", new CharSequence[] { "https://www.publinexo.com.br/publinexo/", "jsp/pregao/pg_vd_pregao_detalhe.jsp" });
/*  27 */   private static final String cj = String.join("", new CharSequence[] { "https://www.publinexo.com.br/publinexo/", "jsp/login/logout.jsp" });
/*  28 */   private static final String cV = String.join("", new CharSequence[] { "https://www.publinexo.com.br/publinexo/", "jsp/pregao/pg_vd_ante_sala_itens.jsp" });
/*  29 */   private static final String cW = String.join("", new CharSequence[] { "https://www.publinexo.com.br/publinexo/", "jsp/disputa_comprador/modal_chatHistoricoCompleto.do" });
/*  30 */   private static final String cX = String.join("", new CharSequence[] { "https://www.publinexo.com.br/publinexo/", "jsp/disputa_comprador/modal_lancesHistoricoCompleto.do" });
/*  31 */   private static final String cY = String.join("", new CharSequence[] { "https://www.publinexo.com.br/publinexo/", "jsp/disputa_fornecedor/loadItensEmDisputa.do" });
/*  32 */   private static final String cZ = String.join("", new CharSequence[] { "https://www.publinexo.com.br/publinexo/", "jsp/disputa_fornecedor/loadItensEncerrados.do" });
/*  33 */   private static final String da = String.join("", new CharSequence[] { "https://www.publinexo.com.br/publinexo/", "jsp/disputa_fornecedor/enviaLances.do" });
/*  34 */   private static final String db = String.join("", new CharSequence[] { "https://www.publinexo.com.br/publinexo/", "jsp/pregao/pg_cp_popup_ata.jsp" });
/*     */   
/*     */   public a(d paramd) {
/*  37 */     a(paramd);
/*     */     
/*  39 */     a(g.c()
/*  40 */         .b(60000)
/*  41 */         .d(50)
/*  42 */         .e(200)
/*  43 */         .a(d)
/*  44 */         .a(StandardCharsets.UTF_8)
/*  45 */         .a("User-Agen", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:102.0) Gecko/20100101 Firefox/102.0")
/*  46 */         .a("Host", "www.publinexo.com.br")
/*  47 */         .a("Origin", "https://www.publinexo.com.br/publinexo/").a());
/*     */   }
/*     */ 
/*     */   
/*     */   public int z() {
/*     */     try {
/*  53 */       c().bB();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  58 */       String str = c().a(g.d().a(aZ).a("userName", a().getUser()).a("password", a().getPassword()).a("acao", "N").b()).getData();
/*     */       
/*  60 */       if (!str.contains("Bem vindo a Publinexo")) {
/*  61 */         return 2;
/*     */       }
/*     */       
/*  64 */       cf();
/*     */       
/*  66 */       if (!ae()) {
/*  67 */         setRunning(true);
/*     */       }
/*     */       
/*  70 */       return 1;
/*  71 */     } catch (Exception exception) {
/*  72 */       a.warn("Falha ao realizar login no Publinexo.", exception);
/*     */ 
/*     */       
/*  75 */       return 0;
/*     */     } 
/*     */   }
/*     */   private void cf() {
/*  79 */     Document document = Jsoup.parse(c().a(g.c().a(cS)).getData());
/*  80 */     D(document.select("input[name=campo1]").val());
/*  81 */     E(document.select("input[name=emp_razao_social]").val());
/*     */   }
/*     */ 
/*     */   
/*     */   public void b() {
/*  86 */     c().a(g.c().a(cj));
/*  87 */     super.b();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean T() {
/*  92 */     return A.a().p(aZ);
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, x paramx) {
/*  97 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, NameValuePair[] paramArrayOfNameValuePair, x paramx) {
/* 102 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */   
/*     */   public e m(int paramInt, String paramString) {
/* 106 */     return c().a(
/* 107 */         g.c().a(cT).a(paramString)
/* 108 */         .a("nome_campo", "prg_id")
/* 109 */         .a("filtro", "")
/* 110 */         .a("pagina", paramInt)
/* 111 */         .a("tipo", paramString)
/* 112 */         .a("origem", "P")
/* 113 */         .a("prg_id", ""));
/*     */   }
/*     */   
/*     */   public e b(int paramInt, String paramString1, String paramString2) {
/* 117 */     return c().a(
/* 118 */         g.c().a(cU)
/* 119 */         .a("nome_campo", "prg_id")
/* 120 */         .a("filtro", "")
/* 121 */         .a("pagina", paramInt)
/* 122 */         .a("tipo", paramString1)
/* 123 */         .a("origem", "P")
/* 124 */         .a("prg_id", paramString2));
/*     */   }
/*     */   
/*     */   public e n(String paramString1, String paramString2) {
/* 128 */     return c().a(
/* 129 */         g.c().a(cV)
/* 130 */         .a("tipo", paramString1)
/* 131 */         .a("prg_id", paramString2)
/* 132 */         .a("disp_sim", "true"));
/*     */   }
/*     */   
/*     */   public e v(int paramInt) {
/* 136 */     return c().a(
/* 137 */         g.d().a(cW)
/* 138 */         .a("tipo", "")
/* 139 */         .a("prg_id", paramInt));
/*     */   }
/*     */   
/*     */   public e C(String paramString) {
/* 143 */     return c().a(
/* 144 */         g.d().a(cX)
/* 145 */         .a("tipo", "")
/* 146 */         .a("prgi_id", paramString)
/* 147 */         .a("visao", "visao_fornecedor")
/* 148 */         .a("origem", ""));
/*     */   }
/*     */   
/*     */   public e D(String paramString) {
/* 152 */     return c().a(
/* 153 */         g.d().a(cY)
/* 154 */         .a("prg_id", paramString)
/* 155 */         .a("itemSelected", ""));
/*     */   }
/*     */   
/*     */   public e f(String paramString, int paramInt) {
/* 159 */     return c().a(
/* 160 */         g.d().a(cZ)
/* 161 */         .a("prg_id", paramString)
/* 162 */         .a("itemSelected", "")
/* 163 */         .a("pagina", paramInt)
/* 164 */         .a("encerrado_filtro_txt", "")
/* 165 */         .a("encerrado_filtro_op", "1"));
/*     */   }
/*     */   
/*     */   public e b(String paramString1, String paramString2, String paramString3, String paramString4) {
/* 169 */     return c().a(
/* 170 */         g.d().a(da)
/* 171 */         .a("radioItem", "on")
/* 172 */         .a("it_status", 2)
/* 173 */         .a("prg_id", paramString1)
/* 174 */         .a("txt_item", paramString2)
/* 175 */         .a("txt_ultimo_lance_fornecedor", paramString3)
/* 176 */         .a("txt_lance", paramString4));
/*     */   }
/*     */   
/*     */   public e o(String paramString1, String paramString2) {
/* 180 */     return c().a(
/* 181 */         g.c().a(db)
/* 182 */         .a("tipo", paramString1)
/* 183 */         .a("prg_id", paramString2)
/* 184 */         .a("tipoAta", "PRE"));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\k\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */