/*     */ package br.com.arremate.j;
/*     */ 
/*     */ import br.com.arremate.f.x;
/*     */ import br.com.arremate.h.c;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.h.g;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.l.h.a;
/*     */ import br.com.arremate.m.A;
/*     */ import br.com.arremate.m.y;
/*     */ import com.google.a.o.a.af;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.commons.text.StringEscapeUtils;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class b
/*     */   extends i
/*     */ {
/*     */   static final String bB = "https://portalsiga.es.gov.br";
/*  30 */   private static final af d = af.a(8.0D);
/*     */   private static final String DOMAIN = "https://www.siga.es.gov.br/";
/*  32 */   private static final String bC = String.join("", new CharSequence[] { "https://www.siga.es.gov.br/", "sgc/faces/priv/" });
/*  33 */   private static final String bD = String.join("", new CharSequence[] { bC, "comum/PrincipalAreaLicitante.jsp" });
/*  34 */   private static final String bE = String.join("", new CharSequence[] { bC, "sgc/pregao/" });
/*  35 */   private static final String bF = String.join("", new CharSequence[] { bC, "sgc/seguranca/RelacaoEmpresaRepresentantePageList.jsp" });
/*     */   
/*     */   public b(d paramd) {
/*  38 */     a(paramd);
/*     */     
/*  40 */     a(c().a());
/*     */   }
/*     */   
/*     */   final c c() {
/*  44 */     return g.c()
/*  45 */       .a(302)
/*  46 */       .b(60000).d(25).e(100).a(d)
/*  47 */       .a(StandardCharsets.UTF_8)
/*  48 */       .a("Host", "www.siga.es.gov.br")
/*  49 */       .a("User-Agen", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36")
/*  50 */       .a();
/*     */   }
/*     */ 
/*     */   
/*     */   public int z() {
/*  55 */     byte b1 = 0;
/*     */     
/*     */     try {
/*  58 */       c().bB();
/*     */       
/*  60 */       String str = aj().toLowerCase();
/*  61 */       if (!str.isEmpty()) {
/*  62 */         if (str.contains("selecione o fornecedor")) {
/*  63 */           str = A(str).toLowerCase();
/*     */         }
/*     */         
/*  66 */         if (str.contains("senha é inválida") || str.contains("nome de usuário e senha não conferem")) {
/*  67 */           b1 = 2;
/*  68 */         } else if (StringUtils.containsIgnoreCase(str, StringEscapeUtils.escapeHtml4(getUser()))) {
/*  69 */           if (ay() == null || ay().isEmpty()) {
/*  70 */             Document document = Jsoup.parse(str);
/*  71 */             String str1 = document.select("span[id=formprincipal:usuarioinfosub:fornecedor]").text();
/*     */             
/*  73 */             if (str1.isEmpty()) {
/*  74 */               str1 = document.select("span[id=formnotificacaofornecedorpagelist:usuarioinfosub:fornecedor]").text();
/*     */             }
/*     */             
/*  77 */             str1 = str1.replace("fornecedor: ", "").toUpperCase();
/*  78 */             E(str1);
/*     */           } 
/*     */           
/*  81 */           if (!ae()) {
/*  82 */             setRunning(true);
/*     */           }
/*  84 */           b1 = 1;
/*     */         } 
/*     */       } 
/*  87 */     } catch (Exception exception) {
/*  88 */       a.error("Falha ao realizar login", exception);
/*     */     } 
/*     */     
/*  91 */     return b1;
/*     */   }
/*     */   
/*     */   private String aj() {
/*  95 */     c().a(g.c().a(bD)).getData();
/*  96 */     return c().a(
/*  97 */         g.d().a("https://www.siga.es.gov.br/").a("sgc/faces/pub/seguranca/form.login")
/*  98 */         .a("action", "authentication")
/*  99 */         .a("areaTarget", "")
/* 100 */         .a("login", getUser())
/* 101 */         .a("senha", getPassword()))
/* 102 */       .getData();
/*     */   }
/*     */   
/*     */   private String A(String paramString) {
/*     */     try {
/* 107 */       Document document = Jsoup.parse(paramString);
/* 108 */       Element element = document.select("select[name=fornecedorSelecionado]").first();
/* 109 */       HashMap<Object, Object> hashMap = new HashMap<>();
/*     */       
/* 111 */       for (Element element1 : element.children()) {
/* 112 */         hashMap.put(element1.text().trim().toLowerCase(), element1.attr("value"));
/*     */       }
/*     */       
/* 115 */       c().a(
/* 116 */           g.d().a("https://www.siga.es.gov.br/").a("sgc/SgcFornecServlet")
/* 117 */           .a("action", "selectFornec")
/* 118 */           .a("fornecedorSelecionado", (String)((Map.Entry)hashMap.entrySet().iterator().next()).getValue()))
/* 119 */         .getData();
/*     */       
/* 121 */       int j = 1;
/* 122 */       int k = 1;
/* 123 */       String str = "";
/*     */       do {
/* 125 */         if (j == 1) {
/* 126 */           paramString = c().a(g.c().a(bF)).getData();
/* 127 */           str = B(paramString);
/*     */         } else {
/* 129 */           paramString = b(j, str);
/*     */         } 
/*     */         
/* 132 */         if (!paramString.isEmpty()) {
/* 133 */           document = Jsoup.parse(paramString);
/* 134 */           Elements elements = document.select("table[id=form1:listaDataTable]").select("tbody > tr");
/*     */           
/* 136 */           for (Element element1 : elements) {
/* 137 */             Elements elements1 = element1.select("td");
/* 138 */             String str1 = y.k("##.###.###/####-##", elements1.get(0).text());
/*     */             
/* 140 */             if (str1.equals(ax())) {
/* 141 */               String str2 = elements1.get(1).text().trim().toLowerCase();
/*     */ 
/*     */               
/* 144 */               c().a(g.c().a("https://www.siga.es.gov.br/").a("sgc/sair.logout")).getData();
/* 145 */               if (!aj().contains("mensagemerrorlogin"))
/*     */               {
/*     */                 
/* 148 */                 return c().a(
/* 149 */                     g.d().a("https://www.siga.es.gov.br/").a("sgc/SgcFornecServlet")
/* 150 */                     .a("action", "selectFornec")
/* 151 */                     .a("fornecedorSelecionado", (String)hashMap.get(str2)))
/* 152 */                   .getData();
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 158 */         if (j != k || 
/* 159 */           !paramString.contains("rich-datascr-inact"))
/* 160 */           continue;  k = Integer.parseInt(document.select("tfoot .rich-datascr-inact").last().text());
/*     */ 
/*     */ 
/*     */         
/* 164 */         ++j;
/* 165 */       } while (j <= k);
/* 166 */     } catch (RuntimeException runtimeException) {
/* 167 */       a.error("Erro ao selecionar fornecedor", runtimeException);
/*     */     } 
/*     */     
/* 170 */     return "";
/*     */   }
/*     */   
/*     */   public String b(int paramInt, String paramString) {
/* 174 */     return c().a(
/* 175 */         g.d().a(bF)
/* 176 */         .a("AJAXREQUEST", "j_id_jsp_80052539_0")
/* 177 */         .a("form1", "form1")
/* 178 */         .a("form1:aboutModalOpenedState", "")
/* 179 */         .a("MenuTitleComponent:editalGroupMenu:hidden", "false")
/* 180 */         .a("MenuTitleComponent:processoLicGroupMenu:hidden", "false")
/* 181 */         .a("MenuTitleComponent:comrpaDiretaGroupMenu:hidden", "false")
/* 182 */         .a("MenuTitleComponent:pregaoGroupMenu:hidden", "false")
/* 183 */         .a("MenuTitleComponent:fornecedorGroupMenu:hidden", "false")
/* 184 */         .a("MenuTitleComponent:manutencaoUsuarioGroupMenu:hidden", "true")
/* 185 */         .a("javax.faces.ViewState", paramString)
/* 186 */         .a("form1:listaDataTable:j_id_jsp_80052539_16", paramInt)
/* 187 */         .a("ajaxSingle", "form1:listaDataTable:j_id_jsp_80052539_16")
/* 188 */         .a("AJAX:EVENTS_COUNT", "1")
/* 189 */         .a("", ""))
/* 190 */       .getData();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String ak() {
/* 200 */     return c().a(g.c().a(bE).a("MinhasPropostasPEPageList.jsp")).getData();
/*     */   }
/*     */   
/*     */   public String al() {
/* 204 */     String str = ak();
/* 205 */     return B(str);
/*     */   }
/*     */   
/*     */   public String c(int paramInt, String paramString) {
/* 209 */     return c().a(
/* 210 */         g.d().a(bE).a("MinhasPropostasPEPageList.jsp")
/* 211 */         .a("AJAXREQUEST", "j_id_jsp_1709275800_0")
/* 212 */         .a("formMinhasPropostasPEPageList", "formMinhasPropostasPEPageList")
/* 213 */         .a("formMinhasPropostasPEPageList:aboutModalOpenedState", "")
/* 214 */         .a("MenuTitleComponent:editalGroupMenu:hidden", "false")
/* 215 */         .a("MenuTitleComponent:comrpaDiretaGroupMenu:hidden", "false")
/* 216 */         .a("MenuTitleComponent:pregaoGroupMenu:hidden", "true")
/* 217 */         .a("MenuTitleComponent:fornecedorGroupMenu:hidden", "false")
/* 218 */         .a("MenuTitleComponent:manutencaoUsuarioGroupMenu:hidden", "false")
/* 219 */         .a("javax.faces.ViewState", paramString)
/* 220 */         .a("formMinhasPropostasPEPageList:propostaDataTable:j_id_jsp_1709275800_39", Integer.toString(paramInt))
/* 221 */         .a("ajaxSingle", "formMinhasPropostasPEPageList:propostaDataTable:j_id_jsp_1709275800_39")
/* 222 */         .a("AJAX:EVENTS_COUNT", "1")
/* 223 */         .a("", ""))
/* 224 */       .getData();
/*     */   }
/*     */   
/*     */   public String a(String paramString1, String paramString2) {
/* 228 */     String str = y.formatDate(new Date(), "MM/yyyy");
/* 229 */     return c().a(
/* 230 */         g.d().a(bE).a("PregaoEmAndamentoPageList.jsp")
/* 231 */         .a("formPregaoEmAndamentoPageList", "formPregaoEmAndamentoPageList")
/* 232 */         .a("formPregaoEmAndamentoPageList:aboutModalOpenedState", "")
/* 233 */         .a("MenuTitleComponent:editalGroupMenu:hidden", "false")
/* 234 */         .a("MenuTitleComponent:processoLicGroupMenu:hidden", "false")
/* 235 */         .a("MenuTitleComponent:comrpaDiretaGroupMenu:hidden", "false")
/* 236 */         .a("MenuTitleComponent:pregaoGroupMenu:hidden", "true")
/* 237 */         .a("MenuTitleComponent:fornecedorGroupMenu:hidden", "false")
/* 238 */         .a("MenuTitleComponent:manutencaoUsuarioGroupMenu:hidden", "false")
/* 239 */         .a("formPregaoEmAndamentoPageList:orgaoCombo", "0")
/* 240 */         .a("formPregaoEmAndamentoPageList:modalidadeCombo", "0")
/* 241 */         .a("formPregaoEmAndamentoPageList:processoInput", paramString1)
/* 242 */         .a("formPregaoEmAndamentoPageList:objetoProcessoInput", "")
/* 243 */         .a("formPregaoEmAndamentoPageList:dtInicioTextInputDate", "")
/* 244 */         .a("formPregaoEmAndamentoPageList:dtInicioTextInputCurrentDate", str)
/* 245 */         .a("formPregaoEmAndamentoPageList:dtFimTextInputDate", "")
/* 246 */         .a("formPregaoEmAndamentoPageList:dtFimTextInputCurrentDate", str)
/* 247 */         .a("formPregaoEmAndamentoPageList:editalInput", "")
/* 248 */         .a("formPregaoEmAndamentoPageList:pesquisarButton", "Pesquisar")
/* 249 */         .a("javax.faces.ViewState", paramString2))
/* 250 */       .getData();
/*     */   }
/*     */   
/*     */   public String b(String paramString1, String paramString2) {
/* 254 */     String str = y.formatDate(new Date(), "MM/yyyy");
/* 255 */     return c().a(g.d().a(bE).a("PregaoDiaPageList.jsp")
/* 256 */         .a("formPregaoDiaPageList", "formPregaoDiaPageList")
/* 257 */         .a("formPregaoDiaPageList:aboutModalOpenedState", "")
/* 258 */         .a("MenuTitleComponent:editalGroupMenu:hidden", "false")
/* 259 */         .a("MenuTitleComponent:processoLicGroupMenu:hidden", "false")
/* 260 */         .a("MenuTitleComponent:comrpaDiretaGroupMenu:hidden", "false")
/* 261 */         .a("MenuTitleComponent:pregaoGroupMenu:hidden", "true")
/* 262 */         .a("MenuTitleComponent:fornecedorGroupMenu:hidden", "false")
/* 263 */         .a("MenuTitleComponent:manutencaoUsuarioGroupMenu:hidden", "false")
/* 264 */         .a("formPregaoDiaPageList:orgaoCombo", "0")
/* 265 */         .a("formPregaoDiaPageList:dtInicioTextInputDate", "")
/* 266 */         .a("formPregaoDiaPageList:dtInicioTextInputCurrentDate", str)
/* 267 */         .a("formPregaoDiaPageList:dtFimTextInputDate", "")
/* 268 */         .a("formPregaoDiaPageList:dtFimTextInputCurrentDate", str)
/* 269 */         .a("formPregaoDiaPageList:procurarRadio", "1")
/* 270 */         .a("formPregaoDiaPageList:numeroText", paramString1)
/* 271 */         .a("formPregaoDiaPageList:objetoText", "")
/* 272 */         .a("formPregaoDiaPageList:pesquisarButton", "Pesquisar")
/* 273 */         .a("javax.faces.ViewState", paramString2))
/* 274 */       .getData();
/*     */   }
/*     */   
/*     */   public String c(String paramString1, String paramString2) {
/* 278 */     return c().a(
/* 279 */         g.d().a(bE).a("PregaoPropostaFornecedorPageList.jsp")
/* 280 */         .a("formPregaoPropostaFornecedorPageList", "formPregaoPropostaFornecedorPageList")
/* 281 */         .a("formPregaoPropostaFornecedorPageList:aboutModalOpenedState", "")
/* 282 */         .a("MenuTitleComponent:editalGroupMenu:hidden", "false")
/* 283 */         .a("MenuTitleComponent:processoLicGroupMenu:hidden", "false")
/* 284 */         .a("MenuTitleComponent:comrpaDiretaGroupMenu:hidden", "false")
/* 285 */         .a("MenuTitleComponent:pregaoGroupMenu:hidden", "true")
/* 286 */         .a("MenuTitleComponent:fornecedorGroupMenu:hidden", "false")
/* 287 */         .a("MenuTitleComponent:manutencaoUsuarioGroupMenu:hidden", "false")
/* 288 */         .a("formPregaoPropostaFornecedorPageList:orgaoCombo", "0")
/* 289 */         .a("formPregaoPropostaFornecedorPageList:procurarRadio", "1")
/* 290 */         .a("formPregaoPropostaFornecedorPageList:numeroText", paramString1)
/* 291 */         .a("formPregaoPropostaFornecedorPageList:objetoText", "")
/* 292 */         .a("formPregaoPropostaFornecedorPageList:pesquisarButton", "Pesquisar")
/* 293 */         .a("javax.faces.ViewState", paramString2))
/* 294 */       .getData();
/*     */   }
/*     */   
/*     */   public String d(String paramString1, String paramString2) {
/* 298 */     String str = y.formatDate(new Date(), "MM/yyyy");
/* 299 */     return c().a(
/* 300 */         g.d().a(bE).a("PregoesSuspensosPageList.jsp")
/* 301 */         .a("formPregoesSuspensosPageList", "formPregoesSuspensosPageList")
/* 302 */         .a("formPregoesSuspensosPageList:aboutModalOpenedState", "")
/* 303 */         .a("MenuTitleComponent:editalGroupMenu:hidden", "false")
/* 304 */         .a("MenuTitleComponent:processoLicGroupMenu:hidden", "false")
/* 305 */         .a("MenuTitleComponent:comrpaDiretaGroupMenu:hidden", "false")
/* 306 */         .a("MenuTitleComponent:pregaoGroupMenu:hidden", "true")
/* 307 */         .a("MenuTitleComponent:fornecedorGroupMenu:hidden", "false")
/* 308 */         .a("MenuTitleComponent:manutencaoUsuarioGroupMenu:hidden", "false")
/* 309 */         .a("formPregoesSuspensosPageList:orgaoCombo", "0")
/* 310 */         .a("formPregoesSuspensosPageList:modalidadeCombo", "0")
/* 311 */         .a("formPregoesSuspensosPageList:processoInput", paramString1)
/* 312 */         .a("formPregoesSuspensosPageList:objetoProcessoInput", "")
/* 313 */         .a("formPregoesSuspensosPageList:dtInicioTextInputDate", "")
/* 314 */         .a("formPregoesSuspensosPageList:dtInicioTextInputCurrentDate", str)
/* 315 */         .a("formPregoesSuspensosPageList:dtFimTextInputDate", "")
/* 316 */         .a("formPregoesSuspensosPageList:dtFimTextInputCurrentDate", str)
/* 317 */         .a("formPregoesSuspensosPageList:editalInput", "")
/* 318 */         .a("formPregoesSuspensosPageList:suspensaoInicioTextInputDate", "")
/* 319 */         .a("formPregoesSuspensosPageList:suspensaoInicioTextInputCurrentDate", str)
/* 320 */         .a("formPregoesSuspensosPageList:suspensaoFimTextInputDate", "")
/* 321 */         .a("formPregoesSuspensosPageList:suspensaoFimTextInputCurrentDate", str)
/* 322 */         .a("formPregoesSuspensosPageList:pesquisarButton", "Pesquisar")
/* 323 */         .a("javax.faces.ViewState", paramString2))
/* 324 */       .getData();
/*     */   }
/*     */   
/*     */   public String e(String paramString1, String paramString2) {
/* 328 */     String str = y.formatDate(new Date(), "MM/yyyy");
/* 329 */     return c().a(
/* 330 */         g.d().a(bE).a("PregoesEncerradosPageList.jsp")
/* 331 */         .a("formPregoesEncerradosPageList", "formPregoesEncerradosPageList")
/* 332 */         .a("formPregoesEncerradosPageList:aboutModalOpenedState", "")
/* 333 */         .a("MenuTitleComponent:editalGroupMenu:hidden", "false")
/* 334 */         .a("MenuTitleComponent:processoLicGroupMenu:hidden", "false")
/* 335 */         .a("MenuTitleComponent:comrpaDiretaGroupMenu:hidden", "false")
/* 336 */         .a("MenuTitleComponent:pregaoGroupMenu:hidden", "true")
/* 337 */         .a("MenuTitleComponent:fornecedorGroupMenu:hidden", "false")
/* 338 */         .a("MenuTitleComponent:manutencaoUsuarioGroupMenu:hidden", "false")
/* 339 */         .a("formPregoesEncerradosPageList:orgaoCombo", "0")
/* 340 */         .a("formPregoesEncerradosPageList:modalidadeCombo", "0")
/* 341 */         .a("formPregoesEncerradosPageList:processoInput", paramString1)
/* 342 */         .a("formPregoesEncerradosPageList:objetoProcessoInput", "")
/* 343 */         .a("formPregoesEncerradosPageList:dtInicioTextInputDate", "")
/* 344 */         .a("formPregoesEncerradosPageList:dtInicioTextInputCurrentDate", str)
/* 345 */         .a("formPregoesEncerradosPageList:dtFimTextInputDate", "")
/* 346 */         .a("formPregoesEncerradosPageList:dtFimTextInputCurrentDate", str)
/* 347 */         .a("formPregoesEncerradosPageList:editalInput", "")
/* 348 */         .a("formPregoesEncerradosPageList:encerramentoInicioTextInputDate", "")
/* 349 */         .a("formPregoesEncerradosPageList:encerramentoInicioTextInputCurrentDate", str)
/* 350 */         .a("formPregoesEncerradosPageList:encerramentoFimTextInputDate", "")
/* 351 */         .a("formPregoesEncerradosPageList:encerramentoFimTextInputCurrentDate", str)
/* 352 */         .a("formPregoesEncerradosPageList:pesquisarButton", "Pesquisar")
/* 353 */         .a("javax.faces.ViewState", paramString2))
/* 354 */       .getData();
/*     */   }
/*     */ 
/*     */   
/*     */   public String f(String paramString1, String paramString2) {
/* 359 */     return c().a(
/* 360 */         g.d().a(bE).a("MinhasPropostasPEPageList.jsp")
/* 361 */         .a("formMinhasPropostasPEPageList", "formMinhasPropostasPEPageList")
/* 362 */         .a("formMinhasPropostasPEPageList:aboutModalOpenedState", "")
/* 363 */         .a("MenuTitleComponent:editalGroupMenu:hidden", "false")
/* 364 */         .a("MenuTitleComponent:processoLicGroupMenu:hidden", "false")
/* 365 */         .a("MenuTitleComponent:comrpaDiretaGroupMenu:hidden", "false")
/* 366 */         .a("MenuTitleComponent:pregaoGroupMenu:hidden", "true")
/* 367 */         .a("MenuTitleComponent:fornecedorGroupMenu:hidden", "false")
/* 368 */         .a("MenuTitleComponent:manutencaoUsuarioGroupMenu:hidden", "false")
/* 369 */         .a("javax.faces.ViewState", paramString2)
/* 370 */         .a("formMinhasPropostasPEPageList:propostaDataTable:0:visualizarLink", "formMinhasPropostasPEPageList:propostaDataTable:0:visualizarLink")
/* 371 */         .a("idPropostaPregaoHidden", paramString1))
/* 372 */       .getData();
/*     */   }
/*     */ 
/*     */   
/*     */   public String am() {
/* 377 */     String str = c().a(g.c().a(bE).a("PregaoEmAndamentoPageList.jsp")).getData();
/* 378 */     return B(str);
/*     */   }
/*     */   
/*     */   public String an() {
/* 382 */     String str = c().a(g.c().a(bE).a("PregaoDiaPageList.jsp")).getData();
/* 383 */     return B(str);
/*     */   }
/*     */   
/*     */   public String ao() {
/* 387 */     String str = c().a(g.c().a(bE).a("PregaoPropostaFornecedorPageList.jsp")).getData();
/* 388 */     return B(str);
/*     */   }
/*     */   
/*     */   public String ap() {
/* 392 */     String str = c().a(g.c().a(bE).a("PregoesSuspensosPageList.jsp")).getData();
/* 393 */     return B(str);
/*     */   }
/*     */   
/*     */   public String aq() {
/* 397 */     String str = c().a(g.c().a(bE).a("PregoesEncerradosPageList.jsp")).getData();
/* 398 */     return B(str);
/*     */   }
/*     */   
/*     */   private String B(String paramString) {
/* 402 */     Document document = Jsoup.parse(paramString);
/* 403 */     return document.select("input[id=javax.faces.ViewState]").val();
/*     */   }
/*     */   
/*     */   public String a(a parama) {
/* 407 */     return c().a(
/* 408 */         g.c().a(bE).a("MensagemLerPageList.jsp")
/* 409 */         .a("pregao", parama.a().v())
/* 410 */         .a("lotePregao", parama.v()))
/* 411 */       .getData();
/*     */   }
/*     */ 
/*     */   
/*     */   protected String ar() {
/* 416 */     String str = c().a(g.c().a(bE).a("PregaoDiaPageList.jsp")).getData();
/* 417 */     Document document = Jsoup.parse(str);
/* 418 */     return document.select("input[id=javax.faces.ViewState]").first().val();
/*     */   }
/*     */ 
/*     */   
/*     */   protected e l(String paramString) {
/* 423 */     String str = y.formatDate(new Date(), "MM/yyyy");
/* 424 */     return c().a(g.d().a(bE).a("PregaoDiaPageList.jsp")
/* 425 */         .a("formPregaoDiaPageList", "formPregaoDiaPageList")
/* 426 */         .a("formPregaoDiaPageList:aboutModalOpenedState", "")
/* 427 */         .a("formPregaoDiaPageList:dtFimTextInputCurrentDate", str)
/* 428 */         .a("formPregaoDiaPageList:dtFimTextInputDate", "")
/* 429 */         .a("formPregaoDiaPageList:dtInicioTextInputCurrentDate", str)
/* 430 */         .a("formPregaoDiaPageList:dtInicioTextInputDate", "")
/* 431 */         .a("formPregaoDiaPageList:listaDataTable:0:visualizarLink", "formPregaoDiaPageList:listaDataTable:0:visualizarLink")
/* 432 */         .a("formPregaoDiaPageList:numeroText", "0")
/* 433 */         .a("formPregaoDiaPageList:objetoText", "")
/* 434 */         .a("formPregaoDiaPageList:orgaoCombo", "0")
/* 435 */         .a("formPregaoDiaPageList:procurarRadio", "1")
/* 436 */         .a("idPregao", "0")
/* 437 */         .a("javax.faces.ViewState", paramString)
/* 438 */         .a("MenuTitleComponent:comrpaDiretaGroupMenu:hidden", "false")
/* 439 */         .a("MenuTitleComponent:editalGroupMenu:hidden", "false")
/* 440 */         .a("MenuTitleComponent:fornecedorGroupMenu:hidden", "false")
/* 441 */         .a("MenuTitleComponent:manutencaoUsuarioGroupMenu:hidden", "false")
/* 442 */         .a("MenuTitleComponent:pregaoGroupMenu:hidden", "false")
/* 443 */         .a());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean T() {
/* 454 */     return A.a().p("https://portalsiga.es.gov.br");
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, x paramx) {
/* 459 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, NameValuePair[] paramArrayOfNameValuePair, x paramx) {
/* 464 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */