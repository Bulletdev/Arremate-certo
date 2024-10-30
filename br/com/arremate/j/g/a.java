/*     */ package br.com.arremate.j.g;
/*     */ 
/*     */ import br.com.arremate.a.k;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.f.x;
/*     */ import br.com.arremate.h.b;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.h.g;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.m.A;
/*     */ import com.google.a.o.a.af;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.e.f;
/*     */ import org.e.i;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class a
/*     */   extends i
/*     */ {
/*  31 */   private static final af d = af.a(5.0D);
/*     */   
/*     */   private static final String DOMAIN = "https://www.peintegrado.pe.gov.br/";
/*  34 */   private static final String bY = String.join("", new CharSequence[] { "https://www.peintegrado.pe.gov.br/", "Default.aspx" });
/*  35 */   private static final String ca = String.join("", new CharSequence[] { "https://www.peintegrado.pe.gov.br/", "ajaxpro/Paradigma.Wbc.WBCPublic.PregaoEletronicoDisputaLanceVendedor,Paradigma.Wbc.WebApp.ashx" });
/*  36 */   private static final String cb = String.join("", new CharSequence[] { "https://www.peintegrado.pe.gov.br/", "ajaxpro/Paradigma.Wbc.WBCPublic.PregaoEletronicoDisputaLanceRegraVendedor,Paradigma.Wbc.WebApp.ashx" });
/*  37 */   private static final String co = String.join("", new CharSequence[] { "https://www.peintegrado.pe.gov.br/", "core/netmarket/adm/AtualizacaoDadosEmpresa.aspx" });
/*     */   
/*     */   private static final String cp = "https://www.peintegrado.pe.gov.br";
/*     */   
/*     */   public static final int DEFAULT_TIMEOUT = 60000;
/*     */   
/*  43 */   private final AtomicInteger d = new AtomicInteger(1);
/*     */   
/*     */   public a(d paramd, boolean paramBoolean) {
/*  46 */     a(paramd);
/*     */     
/*  48 */     if (paramBoolean) {
/*  49 */       a(b());
/*     */     } else {
/*  51 */       bH();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void bH() {
/*  56 */     a(g.a(this, b(), parame -> {
/*     */             String str = parame.getData().toLowerCase();
/*     */ 
/*     */             
/*  60 */             return (str.contains("\"bFlSessaoValida\":\"false\"") || str.contains("sua sessão com o sistema foi encerrada") || str.contains("sessão encerrada") || str.contains("sua sessão expirou") || str.contains("sessão expirada") || str.contains("sessão perdida") || str.contains("sua sessão será perdida") || str.contains("existia uma sessão ativa para esse usuário") || str.contains("desconectado") || parame.getStatusCode() == 401);
/*     */           }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private b b() {
/*  69 */     return g.c()
/*  70 */       .a(201)
/*  71 */       .a(500)
/*  72 */       .b(60000)
/*  73 */       .a((af)d)
/*  74 */       .a("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:121.0) Gecko/20100101 Firefox/121.0")
/*  75 */       .a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int z() {
/*  85 */     byte b = 0;
/*     */     
/*     */     try {
/*  88 */       String str = "";
/*     */       do {
/*  90 */         c().bB();
/*     */ 
/*     */         
/*  93 */         str = c().a(g.c().a(bY).b()).getData();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 100 */         c().bB();
/*     */         
/* 102 */         Document document = Jsoup.parse(str);
/*     */         
/* 104 */         str = h(document);
/* 105 */       } while (str.contains("existia uma sessão ativa"));
/*     */ 
/*     */       
/* 108 */       if (str.contains("senha inválida") || str.contains("sua senha <b><em>expirou</em></b>"))
/* 109 */       { b = 2; }
/* 110 */       else { if (str.contains("ctl00_ctl13_imgcaptcha")) {
/* 111 */           return b;
/*     */         }
/* 113 */         bW();
/*     */         
/* 115 */         b = 1;
/*     */         
/* 117 */         if (!ae()) {
/* 118 */           setRunning(true);
/*     */         } }
/*     */ 
/*     */     
/* 122 */     } catch (Exception exception) {
/* 123 */       a.error("Erro ao realizar login", exception);
/*     */     } 
/*     */     
/* 126 */     return b;
/*     */   }
/*     */   
/*     */   private String h(Document paramDocument) {
/* 130 */     return c().a(
/* 131 */         g.d().a(bY)
/* 132 */         .a("__EVENTTARGET", "")
/* 133 */         .a("__EVENTARGUMENT", "")
/* 134 */         .a("__VIEWSTATE", paramDocument.select("input[id=__VIEWSTATE]").first().val())
/* 135 */         .a("__VIEWSTATEGENERATOR", paramDocument.select("input[id=__VIEWSTATEGENERATOR]").first().val())
/* 136 */         .a("__EVENTVALIDATION", paramDocument.select("input[id=__EVENTVALIDATION]").first().val())
/* 137 */         .a("ctl00$login", getUser())
/* 138 */         .a("ctl00$senha", getPassword())
/* 139 */         .a("ctl00$btnAcessar", "Acessar")
/* 140 */         .b())
/* 141 */       .getData().toLowerCase();
/*     */   }
/*     */   
/*     */   private void bW() throws Exception {
/* 145 */     String str1 = c().a(g.c().a(co).b()).getData();
/* 146 */     Document document = Jsoup.parse(str1);
/* 147 */     Element element1 = document.select("#ctl00_ContentPrincipal_tbxCnpj").first();
/*     */     
/* 149 */     if (element1 == null && str1.contains("<script>top.location")) {
/* 150 */       String str = str1.replace("<script>top.location ='/", "").replace("' </script>", "");
/* 151 */       str1 = c().a(g.c().a("https://www.peintegrado.pe.gov.br/").a(str).b()).getData();
/* 152 */       document = Jsoup.parse(str1);
/* 153 */       element1 = document.select("#ctl00_ContentPrincipal_tbxCnpj").first();
/*     */     } 
/*     */     
/* 156 */     Element element2 = document.select("#ctl00_ContentPrincipal_tbxRazaoSocial").first();
/* 157 */     if (element1 == null || element2 == null) {
/* 158 */       throw new Exception("Failed to find cnpj or enterprise name element");
/*     */     }
/*     */     
/* 161 */     String str2 = element1.text().trim();
/* 162 */     String str3 = element2.text().trim();
/* 163 */     D(str2);
/* 164 */     E(str3);
/*     */   }
/*     */   
/*     */   public String a(br.com.arremate.l.m.a parama, double paramDouble) {
/* 168 */     String str1 = ca;
/* 169 */     String str2 = "Lote";
/* 170 */     String str3 = "Lote";
/*     */     
/* 172 */     if (parama.a().a() == u.a) {
/* 173 */       str1 = cb;
/* 174 */       str2 = "Item";
/* 175 */       str3 = "";
/*     */     } 
/*     */ 
/*     */     
/* 179 */     if (k.b()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 196 */       String str = c().a(g.e().a(str1).b("AjaxPro-Method", "Enviar" + str3 + "Lance").a(StandardCharsets.UTF_8).a((new i()).a("nCdPregaoEletronico", parama.a().v()).c("jsonDocJuncao", "").c("lstCwLance", (new f()).a((new i()).a("nCd" + str2, parama.v()).a("nCdMoeda", 1).a("dVl" + str3 + "Lance", paramDouble).a("nCdPregaoEletronico", parama.a().v()))))).getData();
/*     */       
/* 198 */       str = str.replace("\\", "");
/* 199 */       str = str.substring(1, str.length() - 1);
/* 200 */       return str;
/*     */     } 
/* 202 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected String a(String paramString, x paramx) {
/* 208 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, NameValuePair[] paramArrayOfNameValuePair, x paramx) {
/* 213 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String E(String paramString) {
/* 222 */     return c().a(g.c().a("https://www.peintegrado.pe.gov.br/").a("WBCPublic/PregaoEletronico/").a(paramString)
/* 223 */         .b("Referer", String.join("", new CharSequence[] { "https://www.peintegrado.pe.gov.br/", "WBCPublic/PregaoEletronico/PregaoEletronicoPesquisa.aspx?q=rnsQQdAYWLC6SYmaU_nDFQFkBVth1d__2d49gQfwu7rLebV4W6AbuQbwaNGcjfto"
/* 224 */             }))).getData();
/*     */   }
/*     */   
/*     */   public e o(String paramString) {
/* 228 */     return c().a(
/* 229 */         g.c().a("https://www.peintegrado.pe.gov.br/").a("WBCPublic/PregaoEletronico/Controles/PregaoEletronicoListaItensDisputaRegraVendedor.aspx?q=").a(paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   public e p(String paramString) {
/* 234 */     return c().a(
/* 235 */         g.c().a("https://www.peintegrado.pe.gov.br/").a("WBCPublic/PregaoEletronico/Controles/PregaoEletronicoListaItensDisputaVendedor.aspx?q=").a(paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   public String c(Object paramObject1, Object paramObject2) {
/* 240 */     return a(paramObject1, paramObject2, 0);
/*     */   }
/*     */   
/*     */   public String a(Object paramObject1, Object paramObject2, int paramInt) {
/* 244 */     return c().a(
/* 245 */         g.e().a("https://www.peintegrado.pe.gov.br/").a("WBCPublic/PregaoEletronico/PregaoEletronicoAjax.asmx/Encode")
/* 246 */         .a(StandardCharsets.UTF_8)
/* 247 */         .a((new i()).c("sParametro", "nCdPregaoEletronico=" + paramObject1 + "&nIdTipoApuracao=" + paramObject2 + "&nPaginaIndex=" + paramInt)))
/* 248 */       .getData();
/*     */   }
/*     */   
/*     */   public String F(String paramString) {
/* 252 */     return c().a(
/* 253 */         g.c().a("https://www.peintegrado.pe.gov.br/").a("WBCPublic/PregaoEletronico/PregaoEletronicoDisputaLanceRegraVendedor.aspx?q=").a(paramString))
/* 254 */       .getData();
/*     */   }
/*     */   
/*     */   public String k(String paramString) {
/* 258 */     return c().a(
/* 259 */         g.c().a("https://www.peintegrado.pe.gov.br/").a("WBCPublic/PregaoEletronico/PregaoEletronicoChatPopup.aspx?q=").a(paramString))
/* 260 */       .getData();
/*     */   }
/*     */   
/*     */   public String G(String paramString) {
/* 264 */     return c().a(
/* 265 */         g.c().a("https://www.peintegrado.pe.gov.br/").a("WBCPublic/PregaoEletronico/").a(paramString))
/* 266 */       .getData().split("\\$\\(\\'\\#divLances\\'\\)\\.load\\(\\'")[1].split("\\'\\, carregarGrid_callback\\)\\;", 2)[0];
/*     */   }
/*     */   
/*     */   public e s(String paramString) {
/* 270 */     return c().a(g.c().a("https://www.peintegrado.pe.gov.br").a(paramString));
/*     */   }
/*     */   
/*     */   public String h(Object paramObject) {
/* 274 */     return c().a(
/* 275 */         g.e().a("https://www.peintegrado.pe.gov.br/").a("Portal/WebService/Servicos.asmx/PesquisarProcessoDetalhes")
/* 276 */         .a(StandardCharsets.UTF_8)
/* 277 */         .a((new i())
/* 278 */           .c("dtoProcesso", (new i())
/* 279 */             .c("nCdProcesso", paramObject)
/* 280 */             .a("nCdModulo", 18)
/* 281 */             .a("nCdSituacao", 1)
/* 282 */             .a("tmpTipoMuralProcesso", 0)
/* 283 */             .c("dtoIdioma", (new i()).a("nCdIdioma", 1)))))
/*     */ 
/*     */       
/* 286 */       .getData();
/*     */   }
/*     */   
/*     */   public String ak() {
/* 290 */     return c().a(
/* 291 */         g.c().a("https://www.peintegrado.pe.gov.br/")
/* 292 */         .a("WBCPublic/PregaoEletronico/PregaoEletronicoPesquisa.aspx?q=rnsQQdAYWLC6SYmaU_nDFQFkBVth1d__2d49gQfwu7rLebV4W6AbuQbwaNGcjfto")
/* 293 */         .b("Referer", "https://www.peintegrado.pe.gov.br/core/principal.aspx"))
/* 294 */       .getData();
/*     */   }
/*     */   
/*     */   public String b(Map<String, String> paramMap) {
/* 298 */     return c().a(g.d().a("https://www.peintegrado.pe.gov.br/")
/* 299 */         .a("WBCPublic/PregaoEletronico/PregaoEletronicoPesquisa.aspx?q=rnsQQdAYWLC6SYmaU_nDFQFkBVth1d__2d49gQfwu7rLebV4W6AbuQbwaNGcjfto")
/* 300 */         .a(paramMap))
/* 301 */       .getData();
/*     */   }
/*     */   
/*     */   public String H(String paramString) {
/* 305 */     return c().a(g.c().a("https://www.peintegrado.pe.gov.br/").a("WBCPublic/PregaoEletronico/PregaoEletronicoFrame.aspx?q=").a(paramString)).getData();
/*     */   }
/*     */   
/*     */   public e q(String paramString) {
/* 309 */     return c().a(g.c().a("https://www.peintegrado.pe.gov.br/").a("WBCPublic/PregaoEletronico/PregaoEletronicoFrame.aspx?q=").a(paramString));
/*     */   }
/*     */   
/*     */   public e r(String paramString) {
/* 313 */     return c().a(g.c().a("https://www.peintegrado.pe.gov.br/").a("WBCPublic/PregaoEletronico/PregaoEletronicoDetalhes.aspx?").a(paramString));
/*     */   }
/*     */   
/*     */   public String I(String paramString) {
/* 317 */     return c().a(
/* 318 */         g.c().a("https://www.peintegrado.pe.gov.br/").a("WBCPublic/PregaoEletronico/PregaoEletronicoPropostaRegraVendedor.aspx?q=").a(paramString))
/* 319 */       .getData();
/*     */   }
/*     */   
/*     */   public String J(String paramString) {
/* 323 */     return c().a(
/* 324 */         g.c().a("https://www.peintegrado.pe.gov.br/").a("WBCPublic/PregaoEletronico/Controles/PregaoEletronicoListaItensRegraProposta.aspx?q=").a(paramString))
/* 325 */       .getData();
/*     */   }
/*     */   
/*     */   public String b(String paramString, int paramInt) {
/* 329 */     return c().a(
/* 330 */         g.c().a("https://www.peintegrado.pe.gov.br/").a("WBCPublic/PregaoEletronico/Controles/PregaoEletronicoListaItensRegraProposta.aspx?q=").a(paramString)
/* 331 */         .a("&nPaginaIndex=").a(String.valueOf(paramInt)))
/* 332 */       .getData();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void b() {
/* 343 */     if (ae() || b.a().a(this)) {
/* 344 */       super.b();
/*     */     }
/*     */   }
/*     */   
/*     */   void bI() {
/* 349 */     c().a(g.c().a("https://www.peintegrado.pe.gov.br/").a("default.aspx?sDesconectou=s"));
/*     */   }
/*     */   
/*     */   int A() {
/* 353 */     return this.d.get();
/*     */   }
/*     */   
/*     */   public void bJ() {
/* 357 */     this.d.incrementAndGet();
/*     */   }
/*     */   
/*     */   public void bK() {
/* 361 */     this.d.decrementAndGet();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean T() {
/* 366 */     return A.a().p(bY);
/*     */   }
/*     */   
/*     */   public String aE() {
/* 370 */     return "https://www.peintegrado.pe.gov.br/";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\g\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */