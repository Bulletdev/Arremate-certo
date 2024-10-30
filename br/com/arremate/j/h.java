/*     */ package br.com.arremate.j;
/*     */ 
/*     */ import br.com.arremate.a.j;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.o;
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
/*     */ public class h
/*     */   extends i
/*     */ {
/*  27 */   private static final af d = af.a(5.0D);
/*     */   
/*     */   private static final String DOMAIN = "https://e-lic.sc.gov.br/";
/*  30 */   private static final String bY = String.join("", new CharSequence[] { "https://e-lic.sc.gov.br/", "portal/Mural.aspx" });
/*  31 */   private static final String bZ = String.join("", new CharSequence[] { "https://e-lic.sc.gov.br/", "core/" });
/*     */   
/*     */   public static final int DEFAULT_TIMEOUT = 60000;
/*     */   
/*  35 */   private static final String ca = String.join("", new CharSequence[] { "https://e-lic.sc.gov.br/", "ajaxpro/Paradigma.Wbc.WBCPublic.PregaoEletronicoDisputaLanceVendedor,Paradigma.Wbc.WebApp.ashx" });
/*  36 */   private static final String cb = String.join("", new CharSequence[] { "https://e-lic.sc.gov.br/", "ajaxpro/Paradigma.Wbc.WBCPublic.PregaoEletronicoDisputaLanceRegraVendedor,Paradigma.Wbc.WebApp.ashx" });
/*     */   
/*  38 */   private final String cc = "https://e-lic.sc.gov.br";
/*     */   
/*     */   public h(d paramd) {
/*  41 */     a(paramd);
/*     */     
/*  43 */     a(
/*  44 */         g.c()
/*  45 */         .a(201)
/*  46 */         .a(500)
/*  47 */         .b(60000)
/*  48 */         .d(60)
/*  49 */         .e(300)
/*  50 */         .a(d)
/*  51 */         .a("Origin", "https://e-lic.sc.gov.br")
/*  52 */         .a("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.61 Safari/537.36")
/*  53 */         .a());
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
/*  64 */     byte b = 0;
/*     */ 
/*     */     
/*     */     try {
/*  68 */       String str1 = c().a(g.c().a(bY).b()).getData();
/*     */       
/*  70 */       Document document = Jsoup.parse(str1);
/*  71 */       Element element = document.select("img[id=ctl00_ctl08_imgCaptcha]").first();
/*  72 */       if (element == null) {
/*  73 */         a.info("Failed to select captcha html img");
/*  74 */         return b;
/*     */       } 
/*     */       
/*  77 */       String str2 = "https://e-lic.sc.gov.br" + element.attr("src");
/*     */ 
/*     */       
/*  80 */       String str3 = c().a(g.c().a(str2).a(x.c).b()).getData();
/*  81 */       String str4 = j.a().a(str3, o.i).a();
/*     */       
/*  83 */       String str5 = document.select("input[id=__VIEWSTATE]").first().val();
/*  84 */       String str6 = document.select("input[id=__VIEWSTATEGENERATOR]").first().val();
/*  85 */       String str7 = document.select("input[id=__EVENTVALIDATION]").first().val();
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
/*     */ 
/*     */       
/* 104 */       str1 = c().a(g.d().a(bY).a("__EVENTTARGET", "").a("__EVENTARGUMENT", "").a("__VIEWSTATE", str5).a("__VIEWSTATEGENERATOR", str6).a("__EVENTVALIDATION", str7).a("ctl00$ctl08$tbxLogin", getUser()).a("ctl00$ctl08$tbxSenha", getPassword()).a("ctl00$ctl08$btnAcessar", "Acessar").a("ctl00$ctl08$tbxCaptchaText", str4).a("ctl00$ddlMenu", "Default.aspx").a("ctl00$conteudoPrincipal$sNrProcesso", "").a("ctl00$conteudoPrincipal$tbsDsObjeto", "").a("ctl00$conteudoPrincipal$ddlEmpresaUnidadeCompradora", "").a("ctl00$conteudoPrincipal$ddlModulo", "0").b()).getData().toLowerCase();
/*     */       
/* 106 */       if (str1.contains("usuário não habilitado") || str1.contains("senha inválida") || str1.contains("esse é seu primeiro acesso no sistema"))
/* 107 */       { b = 2; }
/* 108 */       else { if (str1.contains("ctl00_ctl07_imgcaptcha")) {
/* 109 */           return b;
/*     */         }
/* 111 */         String str = bZ + Jsoup.parse(str1).select("frame").attr("src");
/* 112 */         c().a(g.c().a(str).b());
/*     */         
/* 114 */         bW();
/* 115 */         b = 1;
/*     */         
/* 117 */         if (!ae()) {
/* 118 */           setRunning(true);
/*     */         } }
/*     */     
/* 121 */     } catch (Exception exception) {
/* 122 */       a.error("Erro ao realizar login", exception);
/*     */     } 
/*     */     
/* 125 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void bW() throws Exception {
/* 131 */     String str1 = c().a(g.c().a("https://e-lic.sc.gov.br/core/netmarket/adm/AtualizacaoDadosEmpresa.aspx").b()).getData();
/* 132 */     Document document = Jsoup.parse(str1);
/* 133 */     Element element1 = document.select("#ctl00_ContentPrincipal_tbxCnpj").first();
/*     */     
/* 135 */     if (element1 == null && str1.contains("<script>top.location")) {
/* 136 */       String str = str1.replace("<script>top.location ='/", "").replace("' </script>", "");
/*     */ 
/*     */       
/* 139 */       str1 = c().a(g.c().a("https://e-lic.sc.gov.br/").a(str).b()).getData();
/* 140 */       document = Jsoup.parse(str1);
/* 141 */       element1 = document.select("#ctl00_ContentPrincipal_tbxCnpj").first();
/*     */     } 
/*     */     
/* 144 */     Element element2 = document.select("#ctl00_ContentPrincipal_tbxRazaoSocial").first();
/*     */     
/* 146 */     if (element1 == null || element2 == null) {
/* 147 */       throw new Exception("Failed to find cnpj or enterprise name element");
/*     */     }
/*     */     
/* 150 */     String str2 = element1.text().trim();
/* 151 */     String str3 = element2.text().trim();
/* 152 */     D(str2);
/* 153 */     E(str3);
/*     */   }
/*     */   
/*     */   public void a(g paramg) {
/* 157 */     b(paramg);
/* 158 */     a(g.a(this, c(), parame -> {
/*     */             String str = parame.getData().toLowerCase();
/*     */ 
/*     */             
/* 162 */             return (str.contains("\"bFlSessaoValida\":\"false\"") || str.contains("sua sessão com o sistema foi encerrada") || str.contains("sessão encerrada") || str.contains("sua sessão expirou") || str.contains("sessão expirada") || str.contains("sessão perdida") || str.contains("sua sessão será perdida") || str.contains("desconectado") || parame.getStatusCode() == 401);
/*     */           }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public e a(a parama, double paramDouble) throws Exception {
/* 171 */     String str1 = ca;
/* 172 */     String str2 = "Lote";
/* 173 */     String str3 = "Lote";
/*     */     
/* 175 */     if (parama.a().a() == u.a) {
/* 176 */       str1 = cb;
/* 177 */       str2 = "Item";
/* 178 */       str3 = "";
/*     */     } 
/*     */     
/* 181 */     e e = new e();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 191 */     e = c().a(
/* 192 */         g.e().a(str1)
/* 193 */         .a(StandardCharsets.UTF_8)
/* 194 */         .b("AjaxPro-Method", "Enviar" + str3 + "Lance")
/* 195 */         .a((new i())
/* 196 */           .a("nCdPregaoEletronico", parama.a().v())
/* 197 */           .c("sTokenGoogleReCaptcha", "")
/* 198 */           .b("bFlScoreViolado", false)
/* 199 */           .c("lstCwLance", (new f())
/* 200 */             .a((new i())
/* 201 */               .a("nCd" + str2, parama.v())
/* 202 */               .a("nCdMoeda", 1)
/* 203 */               .a("dVl" + str3 + "Lance", paramDouble)
/* 204 */               .a("nCdPregaoEletronico", parama.a().v())))));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 210 */     String str4 = e.getData();
/* 211 */     str4 = str4.replace("\\", "");
/* 212 */     str4 = str4.substring(str4.indexOf("{"), str4.lastIndexOf("}") + 1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 218 */     e.q(e.k());
/* 219 */     e.setData(str4);
/* 220 */     return e;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, x paramx) {
/* 225 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, NameValuePair[] paramArrayOfNameValuePair, x paramx) {
/* 230 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String E(String paramString) {
/* 240 */     return c().a(
/* 241 */         g.c().a("https://e-lic.sc.gov.br/").a("WBCPublic/PregaoEletronico/").a(paramString)
/* 242 */         .b("Referer", String.join("", new CharSequence[] { "https://e-lic.sc.gov.br/", "WBCPublic/PregaoEletronico/PregaoEletronicoPesquisa.aspx?q=rnsQQdAYWLC6SYmaU_nDFQFkBVth1d__2d49gQfwu7rLebV4W6AbuUQCROdne3AI"
/* 243 */             }))).getData();
/*     */   }
/*     */   
/*     */   public e o(String paramString) {
/* 247 */     return c().a(
/* 248 */         g.c().a("https://e-lic.sc.gov.br/").a("WBCPublic/PregaoEletronico/Controles/PregaoEletronicoListaItensDisputaRegraVendedor.aspx?q=").a(paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   public e p(String paramString) {
/* 253 */     return c().a(
/* 254 */         g.c().a("https://e-lic.sc.gov.br/").a("WBCPublic/PregaoEletronico/Controles/PregaoEletronicoListaItensDisputaVendedor.aspx?q=").a(paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   public String c(Object paramObject1, Object paramObject2) {
/* 259 */     return a(paramObject1, paramObject2, 0);
/*     */   }
/*     */   
/*     */   public String a(Object paramObject1, Object paramObject2, int paramInt) {
/* 263 */     return c().a(
/* 264 */         g.e().a("https://e-lic.sc.gov.br/").a("WBCPublic/PregaoEletronico/PregaoEletronicoAjax.asmx/Encode")
/* 265 */         .a(StandardCharsets.UTF_8)
/* 266 */         .a((new i()).c("sParametro", "nCdPregaoEletronico=" + paramObject1 + "&nIdTipoApuracao=" + paramObject2 + "&nPaginaIndex=" + paramInt)))
/* 267 */       .getData();
/*     */   }
/*     */   
/*     */   public e q(String paramString) {
/* 271 */     return c().a(g.c().a("https://e-lic.sc.gov.br/").a("WBCPublic/PregaoEletronico/PregaoEletronicoFrame.aspx?q=").a(paramString));
/*     */   }
/*     */   
/*     */   public e r(String paramString) {
/* 275 */     return c().a(g.c().a("https://e-lic.sc.gov.br/").a("WBCPublic/PregaoEletronico/PregaoEletronicoDetalhes.aspx?").a(paramString));
/*     */   }
/*     */   
/*     */   public String F(String paramString) {
/* 279 */     return c().a(
/* 280 */         g.c().a("https://e-lic.sc.gov.br/").a("WBCPublic/PregaoEletronico/PregaoEletronicoDisputaLanceRegraVendedor.aspx?q=").a(paramString))
/* 281 */       .getData();
/*     */   }
/*     */   
/*     */   public String k(String paramString) {
/* 285 */     return c().a(
/* 286 */         g.c().a("https://e-lic.sc.gov.br/").a("WBCPublic/PregaoEletronico/PregaoEletronicoChatPopup.aspx?q=").a(paramString))
/* 287 */       .getData();
/*     */   }
/*     */   
/*     */   public String G(String paramString) {
/* 291 */     String str = c().a(g.c().a("https://e-lic.sc.gov.br/").a("WBCPublic/PregaoEletronico/").a(paramString)).getData();
/* 292 */     return !str.isEmpty() ? str
/* 293 */       .split("\\$\\(\\'\\#divLances\\'\\)\\.load\\(\\'")[1].split("\\'\\, carregarGrid_callback\\)\\;", 2)[0] : "";
/*     */   }
/*     */ 
/*     */   
/*     */   public e s(String paramString) {
/* 298 */     return c().a(g.c().a("https://e-lic.sc.gov.br").a(paramString));
/*     */   }
/*     */   
/*     */   public String h(Object paramObject) {
/* 302 */     return c().a(
/* 303 */         g.e().a("https://e-lic.sc.gov.br/").a("Portal/WebService/Servicos.asmx/PesquisarProcessoDetalhes")
/* 304 */         .a(StandardCharsets.UTF_8)
/* 305 */         .a((new i()).c("dtoProcesso", (new i())
/* 306 */             .c("nCdProcesso", paramObject)
/* 307 */             .a("nCdModulo", 18)
/* 308 */             .a("nCdSituacao", 1)
/* 309 */             .a("tmpTipoMuralProcesso", 0)
/* 310 */             .c("dtoIdioma", (new i()).a("nCdIdioma", 1)))))
/*     */       
/* 312 */       .getData();
/*     */   }
/*     */   
/*     */   public String ak() {
/* 316 */     return c().a(
/* 317 */         g.c().a("https://e-lic.sc.gov.br/")
/* 318 */         .a("WBCPublic/PregaoEletronico/PregaoEletronicoPesquisa.aspx?q=rnsQQdAYWLC6SYmaU_nDFQFkBVth1d__2d49gQfwu7rLebV4W6AbuUQCROdne3AI"))
/* 319 */       .getData();
/*     */   }
/*     */   
/*     */   public String a(List<String> paramList) {
/* 323 */     return c().a(
/* 324 */         g.d().a("https://e-lic.sc.gov.br/")
/* 325 */         .a("WBCPublic/PregaoEletronico/PregaoEletronicoPesquisa.aspx?q=rnsQQdAYWLC6SYmaU_nDFQFkBVth1d__2d49gQfwu7rLebV4W6AbuUQCROdne3AI")
/* 326 */         .a("__EVENTTARGET", paramList.get(0))
/* 327 */         .a("__EVENTARGUMENT", paramList.get(1))
/* 328 */         .a("__LASTFOCUS", paramList.get(2))
/* 329 */         .a("__VIEWSTATE", paramList.get(3))
/* 330 */         .a("__VIEWSTATEGENERATOR", paramList.get(4))
/* 331 */         .a("__VIEWSTATEENCRYPTED", paramList.get(5))
/* 332 */         .a("__EVENTVALIDATION", paramList.get(6))
/* 333 */         .a("ctl00$hidsDsPesquisaAvancada", paramList.get(7))
/* 334 */         .a("ctl00$hidXmlDados", paramList.get(8))
/* 335 */         .a("ctl00$hidInterface", paramList.get(9))
/* 336 */         .a("ctl00$hidVisao", paramList.get(10))
/* 337 */         .a("ctl00$hidTag", paramList.get(11))
/* 338 */         .a("ctl00$hidFiltro", paramList.get(12))
/* 339 */         .a("ctl00$hidDataSourceWebService", paramList.get(13))
/* 340 */         .a("ctl00$hidUrlWebServiceDataSource", paramList.get(14))
/* 341 */         .a("ctl00$bMostrarCriterio", paramList.get(15))
/* 342 */         .a("ctl00$oBuscaAvancada$hidsAbaPesquisaAvancada", paramList.get(16))
/* 343 */         .a("ctl00$campoPesquisa$sNrProcessoDisplay", paramList.get(17))
/* 344 */         .a("ctl00$ddlVisoes", paramList.get(18))
/* 345 */         .a("ctl00$OutrosFiltros$nCdUnidadeCompradora", paramList.get(19))
/* 346 */         .a("ctl00$pesquisaDataGrid$hidCaminho", paramList.get(20))
/* 347 */         .a("ctl00$pesquisaDataGrid$hidCdPregao", paramList.get(21))
/* 348 */         .a("ctl00$pesquisaDataGrid$hidIdSuperSimples", paramList.get(22)))
/* 349 */       .getData();
/*     */   }
/*     */   
/*     */   public String H(String paramString) {
/* 353 */     return c().a(g.c().a("https://e-lic.sc.gov.br/").a("WBCPublic/PregaoEletronico/PregaoEletronicoFrame.aspx?q=").a(paramString)).getData();
/*     */   }
/*     */   
/*     */   public String I(String paramString) {
/* 357 */     return c().a(
/* 358 */         g.c().a("https://e-lic.sc.gov.br/").a("WBCPublic/PregaoEletronico/PregaoEletronicoPropostaRegraVendedor.aspx?q=").a(paramString))
/* 359 */       .getData();
/*     */   }
/*     */   
/*     */   public String J(String paramString) {
/* 363 */     return c().a(
/* 364 */         g.c().a("https://e-lic.sc.gov.br/").a("WBCPublic/PregaoEletronico/Controles/PregaoEletronicoListaItensRegraProposta.aspx?q=").a(paramString))
/* 365 */       .getData();
/*     */   }
/*     */   
/*     */   public String b(String paramString, int paramInt) {
/* 369 */     return c().a(
/* 370 */         g.c().a("https://e-lic.sc.gov.br/").a("WBCPublic/PregaoEletronico/Controles/PregaoEletronicoListaItensRegraProposta.aspx?q=").a(paramString)
/* 371 */         .a("&nPaginaIndex=").a(String.valueOf(paramInt)))
/* 372 */       .getData();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean T() {
/* 382 */     return A.a().p(bY);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */