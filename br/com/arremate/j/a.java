/*     */ package br.com.arremate.j;
/*     */ 
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.x;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.h.g;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.m.A;
/*     */ import com.google.a.o.a.af;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.apache.http.protocol.HttpContext;
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
/*  28 */   private static final af d = af.a(5.0D);
/*     */   private static final String DOMAIN = "https://compras.cemig.com.br/";
/*  30 */   private static final String by = String.join("", new CharSequence[] { "https://compras.cemig.com.br/", "PortalPublico.aspx" });
/*  31 */   private static final String bz = String.join("", new CharSequence[] { "https://compras.cemig.com.br/", "Default.aspx" });
/*  32 */   private static final String bA = String.join("", new CharSequence[] { "https://compras.cemig.com.br/", "Edital/ConsultarEdital.aspx" });
/*     */   
/*     */   private final HttpContext d;
/*     */   private final HttpContext c;
/*     */   private final Map<String, String> z;
/*     */   
/*     */   public a(d paramd) {
/*  39 */     this.d = g.a(15000);
/*  40 */     this.c = g.a(120000);
/*     */     
/*  42 */     this.z = new HashMap<>();
/*  43 */     this.z.put("Accept", "*/*");
/*  44 */     this.z.put("X-MicrosoftAjax", "Delta=true");
/*  45 */     this.z.put("X-Requested-With", "XMLHttpRequest");
/*     */     
/*  47 */     a(paramd);
/*  48 */     a(
/*  49 */         g.c()
/*  50 */         .a("Accept-Language", "pt-BR,pt;q=0.9,en-US;q=0.8,en;q=0.7")
/*  51 */         .a("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36")
/*  52 */         .a("standard")
/*  53 */         .b(30000).a((af)d).a(StandardCharsets.UTF_8).a());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int z() {
/*     */     try {
/*  66 */       String str1 = c().a(g.d().a(by).a("ctl00$ctl00$smMain", "ctl00$ctl00$ContentPlaceHolder1$ContentPlaceHolderPublico$upnAcesso|ctl00$ctl00$ContentPlaceHolder1$ContentPlaceHolderPublico$linkButtonAcessoSistema").a("__EVENTTARGET", "ctl00$ctl00$ContentPlaceHolder1$ContentPlaceHolderPublico$linkButtonAcessoSistema").b(this.z).b()).getData();
/*     */       
/*  68 */       String str2 = s(str1);
/*  69 */       String str3 = t(str1);
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
/*  82 */       str1 = c().a(g.d().a(by).a("ctl00$ctl00$smMain", "ctl00$ctl00$ContentPlaceHolder1$ContentPlaceHolderPublico$upnAcesso|ctl00$ctl00$ContentPlaceHolder1$ContentPlaceHolderPublico$ucLogin$btnAutenticar").a("ctl00$ctl00$ContentPlaceHolder1$ContentPlaceHolderPublico$ucLogin$txtLogin", a().getUser()).a("ctl00$ctl00$ContentPlaceHolder1$ContentPlaceHolderPublico$ucLogin$txtSenha", a().getPassword()).a("__VIEWSTATE", str2).a("__VIEWSTATEGENERATOR", str3).a("ctl00$ctl00$ContentPlaceHolder1$ContentPlaceHolderPublico$ucLogin$btnAutenticar.x", "0").a("ctl00$ctl00$ContentPlaceHolder1$ContentPlaceHolderPublico$ucLogin$btnAutenticar.y", "0").b(this.z).a(this.c).b()).getData();
/*     */       
/*  84 */       Document document = Jsoup.parse(str1);
/*  85 */       Element element1 = document.getElementById("ctl00_ctl00_mensagemErroControl_lblMensagem");
/*  86 */       if (element1 != null) {
/*  87 */         String str = element1.text().toLowerCase();
/*  88 */         switch (str) {
/*     */           case "existe uma sessão já ativa. deseja derrubar a sessão?":
/*  90 */             str2 = s(str1);
/*  91 */             str3 = t(str1);
/*  92 */             c().a(
/*  93 */                 g.d().a(by)
/*  94 */                 .a("ctl00$ctl00$smMain", "ctl00$ctl00$UpdatePanelMain|ctl00$ctl00$mensagemErroControl$btnOk")
/*  95 */                 .a("ctl00$ctl00$ContentPlaceHolder1$ContentPlaceHolderPublico$ucLogin$txtLogin", a().getUser())
/*  96 */                 .a("__EVENTTARGET", "ctl00$ctl00$mensagemErroControl$btnOk")
/*  97 */                 .a("__VIEWSTATE", str2)
/*  98 */                 .a("__VIEWSTATEGENERATOR", str3)
/*  99 */                 .b(this.z)
/* 100 */                 .a(this.c)
/* 101 */                 .b());
/*     */             break;
/*     */           
/*     */           case "usuário ou senha inválida":
/*     */           case "login ou senha inválida":
/*     */           case "chave de acesso inválida ou não existe":
/* 107 */             return 2;
/*     */           default:
/* 109 */             return 0;
/*     */         } 
/*     */ 
/*     */       
/*     */       } 
/* 114 */       c().a(g.c().a(bz).b());
/* 115 */       str1 = c().a(g.c().a("https://compras.cemig.com.br/").a("Fornecedor/ConsultarDocumentacao.aspx").b()).getData();
/*     */       
/* 117 */       document = Jsoup.parse(str1);
/* 118 */       Element element2 = document.getElementById("ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder1_labelEmpresa");
/* 119 */       if (element2 != null) {
/* 120 */         String str4 = document.getElementById("ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder1_labelEmpresa").text();
/* 121 */         String str5 = document.getElementById("ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder1_labelCpfCnpj").text();
/*     */         
/* 123 */         a().aa(str4);
/* 124 */         D(str5);
/* 125 */         setRunning(true);
/* 126 */         cb();
/*     */         
/* 128 */         return 1;
/*     */       } 
/* 130 */     } catch (Exception exception) {
/* 131 */       a.error("Failed login of the Cemig portal", exception);
/*     */     } 
/*     */     
/* 134 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void b() {
/*     */     try {
/* 140 */       String str1 = c().a(g.c().a(bz)).getData();
/* 141 */       Document document = Jsoup.parse(str1);
/*     */       
/* 143 */       String str2 = document.getElementById("__VIEWSTATE").val().trim();
/* 144 */       String str3 = document.getElementById("__VIEWSTATEGENERATOR").val().trim();
/* 145 */       String str4 = document.getElementById("__EVENTVALIDATION").val().trim();
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
/* 159 */       str1 = c().a(g.d().a(bz).a("ctl00$ctl00$smMain", "ctl00$ctl00$ContentPlaceHolder1$UpdatePanelToolBar|ctl00$ctl00$ContentPlaceHolder1$LinkButton4").a("ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder1_tbCaixas_ClientState", "{\"ActiveTabIndex\":0,\"TabState\":[true]}").a("__EVENTTARGET", "ctl00$ctl00$ContentPlaceHolder1$LinkButton4").a("__VIEWSTATE", str2).a("__VIEWSTATEGENERATOR", str3).a("__EVENTVALIDATION", str4).a("__VIEWSTATEENCRYPTED", "").a("ctl00$ctl00$ContentPlaceHolder1$Menu1$AccordionTarefasID_AccordionExtender_ClientState", "0").a("ctl00$ctl00$ContentPlaceHolder1$ContentPlaceHolder1$tbCaixas$tabTarefa$CaixaTarefa1$AccordionTarefas_AccordionExtender_ClientState", "0").b(this.z)).getData();
/*     */       
/* 161 */       document = Jsoup.parse(str1);
/* 162 */       Element element = document.getElementById("ctl00_ctl00_mensagemErroControl_lblMensagem");
/* 163 */       if (element != null) {
/* 164 */         str2 = s(str1);
/* 165 */         str3 = t(str1);
/* 166 */         str4 = u(str1);
/*     */ 
/*     */         
/* 169 */         c().a(
/* 170 */             g.d().a(bz)
/* 171 */             .a("ctl00$ctl00$smMain", "ctl00$ctl00$UpdatePanelMain|ctl00$ctl00$mensagemErroControl$btnOk")
/* 172 */             .a("ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder1_tbCaixas_ClientState", "{\"ActiveTabIndex\":0,\"TabState\":[true]}")
/* 173 */             .a("__EVENTTARGET", "ctl00$ctl00$mensagemErroControl$btnOk")
/* 174 */             .a("__VIEWSTATE", str2)
/* 175 */             .a("__VIEWSTATEGENERATOR", str3)
/* 176 */             .a("__VIEWSTATEENCRYPTED", "")
/* 177 */             .a("__EVENTVALIDATION", str4)
/* 178 */             .a("ctl00$ctl00$ContentPlaceHolder1$Menu1$AccordionTarefasID_AccordionExtender_ClientState", "0")
/* 179 */             .a("ctl00$ctl00$ContentPlaceHolder1$ContentPlaceHolder1$tbCaixas$tabTarefa$CaixaTarefa1$AccordionTarefas_AccordionExtender_ClientState", "0")
/* 180 */             .b(this.z));
/*     */       }
/*     */     
/* 183 */     } catch (Exception exception) {
/* 184 */       a.error("Failed logout of the Cemig portal", exception);
/*     */     } 
/*     */     
/* 187 */     super.b();
/*     */   }
/*     */   
/*     */   private String s(String paramString) {
/* 191 */     paramString = paramString.substring(paramString.indexOf("|__VIEWSTATE|") + 13);
/* 192 */     return paramString.substring(0, paramString.indexOf("|"));
/*     */   }
/*     */ 
/*     */   
/*     */   private String t(String paramString) {
/* 197 */     paramString = paramString.substring(paramString.indexOf("|__VIEWSTATEGENERATOR|") + 22);
/* 198 */     return paramString.substring(0, paramString.indexOf("|"));
/*     */   }
/*     */ 
/*     */   
/*     */   private String u(String paramString) {
/* 203 */     paramString = paramString.substring(paramString.indexOf("|__EVENTVALIDATION|") + 19);
/* 204 */     return paramString.substring(0, paramString.indexOf("|"));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String ah() {
/* 212 */     return c().a(g.c().a(by)).getData();
/*     */   }
/*     */   
/*     */   public String ai() {
/* 216 */     return c().a(g.c().a(bA)).getData();
/*     */   }
/*     */   
/*     */   public String a(String paramString1, String paramString2, String paramString3) {
/* 220 */     return b(paramString1, paramString2, paramString3, "l00");
/*     */   }
/*     */   
/*     */   public String b(String paramString1, String paramString2, String paramString3) {
/* 224 */     return b(paramString1, paramString2, paramString3, "l01");
/*     */   }
/*     */ 
/*     */   
/*     */   public String c(String paramString1, String paramString2, String paramString3) {
/* 229 */     return b(paramString1, paramString2, paramString3, "l02");
/*     */   }
/*     */   
/*     */   private String b(String paramString1, String paramString2, String paramString3, String paramString4) {
/* 233 */     return c().a(
/* 234 */         g.d().a(by)
/* 235 */         .a("ctl00$ctl00$smMain", String.join("", new CharSequence[] { "ctl00$ctl00$ContentPlaceHolder1$ContentPlaceHolderPublico$sumarioLicitacoes$upGruposEditais|ctl00$ctl00$ContentPlaceHolder1$ContentPlaceHolderPublico$sumarioLicitacoes$rptGrupos$ct", paramString4, "$btnGrupoEditais"
/* 236 */             })).a("__EVENTTARGET", String.join("", new CharSequence[] { "ctl00$ctl00$ContentPlaceHolder1$ContentPlaceHolderPublico$sumarioLicitacoes$rptGrupos$ct", paramString4, "$btnGrupoEditais"
/* 237 */             })).a("__VIEWSTATE", paramString1)
/* 238 */         .a("__VIEWSTATEGENERATOR", paramString2)
/* 239 */         .a("__PREVIOUSPAGE", paramString3))
/* 240 */       .getData();
/*     */   }
/*     */   
/*     */   public String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
/* 244 */     return c().a(
/* 245 */         g.d().a("https://compras.cemig.com.br/").a(paramString1)
/* 246 */         .a("ctl00$ctl00$smMain", "ctl00$ctl00$ContentPlaceHolder1$ContentPlaceHolderPublico$UpdatePanel1|ctl00$ctl00$ContentPlaceHolder1$ContentPlaceHolderPublico$ctlPaginador$ctlPaginador_lbNextPage")
/* 247 */         .a("__VIEWSTATE", paramString2)
/* 248 */         .a("__VIEWSTATEGENERATOR", paramString3)
/* 249 */         .a("__PREVIOUSPAGE", paramString4)
/* 250 */         .a("__EVENTVALIDATION", paramString5)
/* 251 */         .a("__VIEWSTATEENCRYPTED", "")
/* 252 */         .a("ctl00$ctl00$ContentPlaceHolder1$ContentPlaceHolderPublico$ctlPaginador$ctlPaginador_lbNextPage.x", "0")
/* 253 */         .a("ctl00$ctl00$ContentPlaceHolder1$ContentPlaceHolderPublico$ctlPaginador$ctlPaginador_lbNextPage.y", "0"))
/* 254 */       .getData();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String v(String paramString) {
/* 261 */     return c().a(g.c().a("https://compras.cemig.com.br/").a("Proposta/ApresentarProposta.aspx").a("token", paramString)).getData();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public e k(String paramString) throws Exception {
/* 268 */     String str1 = c().a(g.c().a(bA)).getData();
/* 269 */     Document document = Jsoup.parse(str1);
/* 270 */     String str2 = document.getElementById("__VIEWSTATE").val().trim();
/* 271 */     String str3 = document.getElementById("__VIEWSTATEGENERATOR").val().trim();
/* 272 */     String str4 = document.getElementById("__EVENTVALIDATION").val().trim();
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
/* 285 */     str1 = c().a(g.d().a(bA).a("ctl00$ctl00$smMain", "ctl00$ctl00$smMain|ctl00$ctl00$ContentPlaceHolder1$ContentPlaceHolder1$btnConsular").a("__EVENTTARGET", "ctl00$ctl00$ContentPlaceHolder1$ContentPlaceHolder1$btnConsular").a("__VIEWSTATE", str2).a("__VIEWSTATEGENERATOR", str3).a("__VIEWSTATEENCRYPTED", "").a("__EVENTVALIDATION", str4).a("ctl00$ctl00$ContentPlaceHolder1$Menu1$AccordionTarefasID_AccordionExtender_ClientState", "0").a("ctl00$ctl00$ContentPlaceHolder1$ContentPlaceHolder1$txtNumProposta", paramString).a("ctl00$ctl00$ContentPlaceHolder1$ContentPlaceHolder1$ddlTipoData", "1")).getData();
/*     */     
/* 287 */     document = Jsoup.parse(str1);
/* 288 */     Element element = document.getElementById("ctl00_ctl00_mensagemErroControl_lblMensagem");
/* 289 */     if (element != null && element.text().toLowerCase().equals("nenhuma ocorrência foi encontrada!")) {
/* 290 */       return new e();
/*     */     }
/*     */     
/* 293 */     String str5 = document.getElementById("__VIEWSTATE").val().trim();
/* 294 */     String str6 = document.getElementById("__VIEWSTATEGENERATOR").val().trim();
/* 295 */     String str7 = document.getElementById("__EVENTVALIDATION").val().trim();
/*     */     
/* 297 */     return c().a(
/* 298 */         g.d().a(bA)
/* 299 */         .a("ctl00$ctl00$smMain", "ctl00$ctl00$ContentPlaceHolder1$ContentPlaceHolder1$updtPnlGrid|ctl00$ctl00$ContentPlaceHolder1$ContentPlaceHolder1$gvEdital$ctl02$imgBtnVisualizar")
/* 300 */         .a("ctl00$ctl00$ContentPlaceHolder1$Menu1$AccordionTarefasID_AccordionExtender_ClientState", "0")
/* 301 */         .a("ctl00$ctl00$ContentPlaceHolder1$ContentPlaceHolder1$txtNumProposta", paramString)
/* 302 */         .a("ctl00$ctl00$ContentPlaceHolder1$ContentPlaceHolder1$ddlTipoData", "1")
/* 303 */         .a("__VIEWSTATE", str5)
/* 304 */         .a("__VIEWSTATEGENERATOR", str6)
/* 305 */         .a("__VIEWSTATEENCRYPTED", "")
/* 306 */         .a("__EVENTVALIDATION", str7)
/* 307 */         .a("ctl00$ctl00$ContentPlaceHolder1$ContentPlaceHolder1$gvEdital$ctl02$imgBtnVisualizar.x", "0")
/* 308 */         .a("ctl00$ctl00$ContentPlaceHolder1$ContentPlaceHolder1$gvEdital$ctl02$imgBtnVisualizar.y", "0"));
/*     */   }
/*     */ 
/*     */   
/*     */   public String w(String paramString) {
/* 313 */     return c().a(g.c().a("https://compras.cemig.com.br/").a("Edital/VisualizarEdital.aspx").a("token", paramString)).getData();
/*     */   }
/*     */   
/*     */   public String x(String paramString) {
/* 317 */     return c().a(
/* 318 */         g.c().a("https://compras.cemig.com.br/").a("ExameConformidade/AvaliarExameConformidadeFor.aspx").a("token", paramString)).getData();
/*     */   }
/*     */   
/*     */   public String y(String paramString) {
/* 322 */     return c().a(g.c().a("https://compras.cemig.com.br/").a("Lance/LanceFornecedor.aspx").a("token", paramString)).getData();
/*     */   }
/*     */   
/*     */   public e d(String paramString, int paramInt) {
/* 326 */     i i1 = new i();
/* 327 */     i1.a("itensPorPagina", paramInt);
/* 328 */     i1.a("pagina", 0);
/* 329 */     i1.c("token", paramString);
/*     */     
/* 331 */     return c().a(
/* 332 */         g.e()
/* 333 */         .a("https://compras.cemig.com.br/").a("Lance/LanceFornecedor.aspx/ObterLotesVisaoFornecedor")
/* 334 */         .a(i1).a(this.d));
/*     */   }
/*     */ 
/*     */   
/*     */   public String z(String paramString) {
/* 339 */     return c().a(
/* 340 */         g.c().a("https://compras.cemig.com.br/").a("Edital/HistoricoChat.aspx").a("token", paramString))
/* 341 */       .getData();
/*     */   }
/*     */   
/*     */   public e a(i parami) {
/* 345 */     return c().a(g.e().a("https://compras.cemig.com.br/").a("Lance/LanceFornecedor.aspx/EnviarLance").a(parami));
/*     */   }
/*     */   
/*     */   public void a(g paramg) {
/* 349 */     b(paramg);
/* 350 */     a(g.a(this, c(), parame -> (parame.getStatusCode() == 401)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean T() {
/* 359 */     return A.a().p(by);
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, x paramx) {
/* 364 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, NameValuePair[] paramArrayOfNameValuePair, x paramx) {
/* 369 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */