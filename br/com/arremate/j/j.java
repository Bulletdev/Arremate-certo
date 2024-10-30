/*     */ package br.com.arremate.j;
/*     */ 
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.f.x;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.h.g;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.l.m.a;
/*     */ import br.com.arremate.m.A;
/*     */ import com.google.a.o.a.af;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.List;
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
/*     */ public class j
/*     */   extends i
/*     */ {
/*  28 */   private static final af d = af.a(5.0D);
/*     */   
/*     */   public static final int DEFAULT_TIMEOUT = 60000;
/*     */   
/*     */   private static final String DOMAIN = "https://compras.barueri.sp.gov.br/";
/*  33 */   private static final String bY = String.join("", new CharSequence[] { "https://compras.barueri.sp.gov.br/", "Default.aspx" });
/*     */   
/*     */   public j(d paramd) {
/*  36 */     a(paramd);
/*     */     
/*  38 */     a(
/*  39 */         g.c()
/*  40 */         .a(201)
/*  41 */         .a(500)
/*  42 */         .b(60000)
/*  43 */         .a(d)
/*  44 */         .a("Host", "compras.barueri.sp.gov.br")
/*  45 */         .a("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:102.0) Gecko/20100101 Firefox/102.0")
/*  46 */         .a());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int z() {
/*  57 */     byte b = 0;
/*     */     
/*     */     try {
/*  60 */       c().bB();
/*  61 */       String str1 = c().a(g.c().a(bY).b()).getData();
/*  62 */       c().bB();
/*     */       
/*  64 */       Document document = Jsoup.parse(str1);
/*  65 */       String str2 = document.select("input[id=__VIEWSTATE]").first().val();
/*  66 */       String str3 = document.select("input[id=__VIEWSTATEGENERATOR]").first().val();
/*  67 */       String str4 = document.select("input[id=__EVENTVALIDATION]").first().val();
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
/*  81 */       str1 = c().a(g.d().a(bY).a("__EVENTTARGET", "").a("__EVENTARGUMENT", "").a("__VIEWSTATE", str2).a("__VIEWSTATEGENERATOR", str3).a("__EVENTVALIDATION", str4).a("ctl00$ctl10$tbxLogin", getUser()).a("ctl00$ctl10$tbxSenha", getPassword()).a("ctl00$ctl10$btnAcessar", "Acessar").a("ctl00$ddlMenu", "Default.aspx").b()).getData().toLowerCase();
/*     */       
/*  83 */       if (str1.contains("usuário não habilitado") || str1.contains("senha inválida") || str1
/*  84 */         .contains("esse é seu primeiro acesso ao sistema ou a sua senha expirou")) {
/*  85 */         b = 2;
/*     */       } else {
/*  87 */         bW();
/*  88 */         b = 1;
/*     */         
/*  90 */         if (!ae()) {
/*  91 */           setRunning(true);
/*     */         }
/*     */       } 
/*  94 */     } catch (Exception exception) {
/*  95 */       a.error("Erro ao realizar login", exception);
/*     */     } 
/*     */     
/*  98 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void bW() throws Exception {
/* 104 */     String str1 = c().a(g.c().a("https://compras.barueri.sp.gov.br/").a("core/netmarket/adm/AtualizacaoDadosEmpresa.aspx").b()).getData();
/* 105 */     Document document = Jsoup.parse(str1);
/* 106 */     Element element1 = document.select("#ctl00_ContentPrincipal_tbxCnpj").first();
/* 107 */     Element element2 = document.select("#ctl00_ContentPrincipal_tbxRazaoSocial").first();
/*     */     
/* 109 */     if (element1 == null || element2 == null) {
/* 110 */       throw new Exception("Failed to find cnpj or enterprise name element");
/*     */     }
/*     */     
/* 113 */     String str2 = element1.text().trim();
/* 114 */     String str3 = element2.text().trim();
/* 115 */     D(str2);
/* 116 */     E(str3);
/*     */   }
/*     */   
/*     */   public void a(g paramg) {
/* 120 */     b(paramg);
/* 121 */     a(g.a(this, c(), parame -> {
/*     */             String str = parame.getData().toLowerCase();
/*     */ 
/*     */             
/* 125 */             return (str.contains("\"bFlSessaoValida\":\"false\"") || str.contains("sua sessão com o sistema foi encerrada") || str.contains("sessão encerrada") || str.contains("sua sessão expirou") || str.contains("sessão expirada") || str.contains("sessão perdida") || str.contains("sua sessão será perdida") || str.contains("desconectado") || parame.getStatusCode() == 401);
/*     */           }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public e a(a parama, double paramDouble) throws Exception {
/* 134 */     String str1 = "https://compras.barueri.sp.gov.br/ajaxpro/Paradigma.Wbc.WBCPublic.PregaoEletronicoDisputaLanceVendedor,Paradigma.Wbc.WebApp.ashx";
/* 135 */     String str2 = "Lote";
/* 136 */     String str3 = "Lote";
/*     */     
/* 138 */     if (parama.a().a() == u.a) {
/* 139 */       str1 = "https://compras.barueri.sp.gov.br/ajaxpro/Paradigma.Wbc.WBCPublic.PregaoEletronicoDisputaLanceRegraVendedor,Paradigma.Wbc.WebApp.ashx";
/* 140 */       str2 = "Item";
/* 141 */       str3 = "";
/*     */     } 
/*     */     
/* 144 */     e e = new e();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 154 */     e = c().a(
/* 155 */         g.e().a(str1)
/* 156 */         .a(StandardCharsets.UTF_8)
/* 157 */         .b("AjaxPro-Method", "Enviar" + str3 + "Lance")
/* 158 */         .a((new i())
/* 159 */           .a("nCdPregaoEletronico", parama.a().v())
/* 160 */           .c("sTokenGoogleReCaptcha", "")
/* 161 */           .b("bFlScoreViolado", false)
/* 162 */           .c("lstCwLance", (new f())
/* 163 */             .a((new i())
/* 164 */               .a("nCd" + str2, parama.v())
/* 165 */               .a("nCdMoeda", 1)
/* 166 */               .a("dVl" + str3 + "Lance", paramDouble)
/* 167 */               .a("nCdPregaoEletronico", parama.a().v())))));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 173 */     String str4 = e.getData();
/* 174 */     str4 = str4.replace("\\", "");
/* 175 */     str4 = str4.substring(str4.indexOf("{"), str4.lastIndexOf("}") + 1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 181 */     e.setData(str4);
/* 182 */     return e;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, x paramx) {
/* 187 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, NameValuePair[] paramArrayOfNameValuePair, x paramx) {
/* 192 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String E(String paramString) {
/* 202 */     return c().a(g.c().a("https://compras.barueri.sp.gov.br/").a("WBCPublic/PregaoEletronico/").a(paramString)
/* 203 */         .b("Referer", String.join("", new CharSequence[] { "https://compras.barueri.sp.gov.br/", "WBCPublic/PregaoEletronico/PregaoEletronicoPesquisa.aspx?q=rnsQQdAYWLC6SYmaU_nDFQFkBVth1d__2d49gQfwu7rLebV4W6AbuUQCROdne3AI"
/* 204 */             }))).getData();
/*     */   }
/*     */   
/*     */   public e o(String paramString) {
/* 208 */     return c().a(
/* 209 */         g.c().a("https://compras.barueri.sp.gov.br/").a("WBCPublic/PregaoEletronico/Controles/PregaoEletronicoListaItensDisputaRegraVendedor.aspx?q=").a(paramString));
/*     */   }
/*     */   
/*     */   public e p(String paramString) {
/* 213 */     return c().a(
/* 214 */         g.c().a("https://compras.barueri.sp.gov.br/").a("WBCPublic/PregaoEletronico/Controles/PregaoEletronicoListaItensDisputaVendedor.aspx?q=").a(paramString));
/*     */   }
/*     */   
/*     */   public String c(Object paramObject1, Object paramObject2) {
/* 218 */     return a(paramObject1, paramObject2, 0);
/*     */   }
/*     */   
/*     */   public String a(Object paramObject1, Object paramObject2, int paramInt) {
/* 222 */     return c().a(
/* 223 */         g.e().a("https://compras.barueri.sp.gov.br/").a("WBCPublic/PregaoEletronico/PregaoEletronicoAjax.asmx/Encode")
/* 224 */         .a(StandardCharsets.UTF_8)
/* 225 */         .a((new i()).c("sParametro", "nCdPregaoEletronico=" + paramObject1 + "&nIdTipoApuracao=" + paramObject2 + "&nPaginaIndex=" + paramInt)))
/* 226 */       .getData();
/*     */   }
/*     */   
/*     */   public e q(String paramString) {
/* 230 */     return c().a(g.c().a("https://compras.barueri.sp.gov.br/").a("WBCPublic/PregaoEletronico/PregaoEletronicoFrame.aspx?q=").a(paramString));
/*     */   }
/*     */   
/*     */   public e r(String paramString) {
/* 234 */     return c().a(g.c().a("https://compras.barueri.sp.gov.br/").a("WBCPublic/PregaoEletronico/PregaoEletronicoDetalhes.aspx?").a(paramString));
/*     */   }
/*     */   
/*     */   public String F(String paramString) {
/* 238 */     return c().a(
/* 239 */         g.c().a("https://compras.barueri.sp.gov.br/").a("WBCPublic/PregaoEletronico/PregaoEletronicoDisputaLanceRegraVendedor.aspx?q=").a(paramString))
/* 240 */       .getData();
/*     */   }
/*     */   
/*     */   public String k(String paramString) {
/* 244 */     return c().a(
/* 245 */         g.c().a("https://compras.barueri.sp.gov.br/").a("WBCPublic/PregaoEletronico/PregaoEletronicoChatPopup.aspx?q=").a(paramString))
/* 246 */       .getData();
/*     */   }
/*     */   
/*     */   public String G(String paramString) {
/* 250 */     return c().a(
/* 251 */         g.c().a("https://compras.barueri.sp.gov.br/").a("WBCPublic/PregaoEletronico/").a(paramString))
/* 252 */       .getData().split("\\$\\(\\'\\#divLances\\'\\)\\.load\\(\\'")[1].split("\\'\\, carregarGrid_callback\\)\\;", 2)[0];
/*     */   }
/*     */   
/*     */   public e s(String paramString) {
/* 256 */     return c().a(g.c().a("https://compras.barueri.sp.gov.br/").a(paramString));
/*     */   }
/*     */   
/*     */   public String h(Object paramObject) {
/* 260 */     return c().a(
/* 261 */         g.e().a("https://compras.barueri.sp.gov.br/").a("Portal/WebService/Servicos.asmx/PesquisarProcessoDetalhes")
/* 262 */         .a((new i())
/*     */           
/* 264 */           .c("dtoProcesso", (new i())
/* 265 */             .c("nCdProcesso", paramObject)
/* 266 */             .a("nCdModulo", 18)
/* 267 */             .a("nCdSituacao", 1)
/* 268 */             .a("tmpTipoMuralProcesso", 0)
/* 269 */             .c("dtoIdioma", (new i()).a("nCdIdioma", 1)))))
/*     */ 
/*     */       
/* 272 */       .getData();
/*     */   }
/*     */   
/*     */   public String ak() {
/* 276 */     return c().a(
/* 277 */         g.c().a("https://compras.barueri.sp.gov.br/")
/* 278 */         .a("WBCPublic/PregaoEletronico/PregaoEletronicoPesquisa.aspx?q=rnsQQdAYWLC6SYmaU_nDFQFkBVth1d__2d49gQfwu7rLebV4W6AbuUQCROdne3AI"))
/* 279 */       .getData();
/*     */   }
/*     */   
/*     */   public String a(List<String> paramList) {
/* 283 */     return c().a(
/* 284 */         g.d().a("https://compras.barueri.sp.gov.br/")
/* 285 */         .a("WBCPublic/PregaoEletronico/PregaoEletronicoPesquisa.aspx?q=rnsQQdAYWLC6SYmaU_nDFQFkBVth1d__2d49gQfwu7rLebV4W6AbuUQCROdne3AI")
/* 286 */         .a("__EVENTTARGET", paramList.get(0))
/* 287 */         .a("__EVENTARGUMENT", paramList.get(1))
/* 288 */         .a("__LASTFOCUS", paramList.get(2))
/* 289 */         .a("__VIEWSTATE", paramList.get(3))
/* 290 */         .a("__VIEWSTATEGENERATOR", paramList.get(4))
/* 291 */         .a("__VIEWSTATEENCRYPTED", paramList.get(5))
/* 292 */         .a("__EVENTVALIDATION", paramList.get(6))
/* 293 */         .a("ctl00$hidsDsPesquisaAvancada", paramList.get(7))
/* 294 */         .a("ctl00$hidXmlDados", paramList.get(8))
/* 295 */         .a("ctl00$hidInterface", paramList.get(9))
/* 296 */         .a("ctl00$hidVisao", paramList.get(10))
/* 297 */         .a("ctl00$hidTag", paramList.get(11))
/* 298 */         .a("ctl00$hidFiltro", paramList.get(12))
/* 299 */         .a("ctl00$hidDataSourceWebService", paramList.get(13))
/* 300 */         .a("ctl00$hidUrlWebServiceDataSource", paramList.get(14))
/* 301 */         .a("ctl00$bMostrarCriterio", paramList.get(15))
/* 302 */         .a("ctl00$oBuscaAvancada$hidsAbaPesquisaAvancada", paramList.get(16))
/* 303 */         .a("ctl00$campoPesquisa$sNrProcessoDisplay", paramList.get(17))
/* 304 */         .a("ctl00$ddlVisoes", paramList.get(18))
/* 305 */         .a("ctl00$OutrosFiltros$nCdUnidadeCompradora", paramList.get(19))
/* 306 */         .a("ctl00$pesquisaDataGrid$hidCaminho", paramList.get(20))
/* 307 */         .a("ctl00$pesquisaDataGrid$hidCdPregao", paramList.get(21))
/* 308 */         .a("ctl00$pesquisaDataGrid$hidIdSuperSimples", paramList.get(22)))
/* 309 */       .getData();
/*     */   }
/*     */   
/*     */   public String H(String paramString) {
/* 313 */     return c().a(g.c().a("https://compras.barueri.sp.gov.br/").a("WBCPublic/PregaoEletronico/PregaoEletronicoFrame.aspx?q=").a(paramString)).getData();
/*     */   }
/*     */   
/*     */   public String I(String paramString) {
/* 317 */     return c().a(
/* 318 */         g.c().a("https://compras.barueri.sp.gov.br/").a("WBCPublic/PregaoEletronico/PregaoEletronicoPropostaRegraVendedor.aspx?q=").a(paramString))
/* 319 */       .getData();
/*     */   }
/*     */   
/*     */   public String J(String paramString) {
/* 323 */     return c().a(
/* 324 */         g.c().a("https://compras.barueri.sp.gov.br/").a("WBCPublic/PregaoEletronico/Controles/PregaoEletronicoListaItensRegraProposta.aspx?q=").a(paramString))
/* 325 */       .getData();
/*     */   }
/*     */   
/*     */   public String b(String paramString, int paramInt) {
/* 329 */     return c().a(
/* 330 */         g.c().a("https://compras.barueri.sp.gov.br/").a("WBCPublic/PregaoEletronico/Controles/PregaoEletronicoListaItensRegraProposta.aspx?q=").a(paramString)
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
/*     */   public boolean T() {
/* 342 */     return A.a().p(bY);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */