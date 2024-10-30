/*     */ package br.com.arremate.j;
/*     */ 
/*     */ import br.com.arremate.f.x;
/*     */ import br.com.arremate.h.c;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.h.g;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.l.l.a;
/*     */ import br.com.arremate.m.A;
/*     */ import br.com.arremate.m.y;
/*     */ import com.google.a.o.a.af;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class f
/*     */   extends i
/*     */ {
/*  29 */   private static final af d = af.a(8.0D);
/*     */   
/*     */   private static final String DOMAIN = "http://aquisicoes.seplag.mt.gov.br/";
/*  32 */   private static final String bC = String.join("", new CharSequence[] { "http://aquisicoes.seplag.mt.gov.br/", "sgc/faces/priv/" });
/*  33 */   private static final String bD = String.join("", new CharSequence[] { bC, "comum/PrincipalAreaLicitante.jsp" });
/*  34 */   private static final String bX = String.join("", new CharSequence[] { bC, "sgc/seguranca/RelacaoEmpresaRepresentantePageList.jsp" });
/*     */   
/*  36 */   private static final String bE = bC + "sgc/pregao/";
/*     */   
/*     */   static final String bB = "http://aquisicoes.seplag.mt.gov.br/";
/*     */   
/*     */   public f(d paramd) {
/*  41 */     a(paramd);
/*     */     
/*  43 */     a(c().a());
/*     */   }
/*     */   
/*     */   final c c() {
/*  47 */     return g.c()
/*  48 */       .a(302)
/*  49 */       .b(60000).d(25).e(100).a(d)
/*  50 */       .a(StandardCharsets.UTF_8)
/*  51 */       .a("Host", "aquisicoes.seplag.mt.gov.br")
/*  52 */       .a("User-Agen", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36")
/*  53 */       .a();
/*     */   }
/*     */ 
/*     */   
/*     */   public int z() {
/*  58 */     byte b = 0;
/*     */     
/*     */     try {
/*  61 */       c().bB();
/*     */       
/*  63 */       String str = aj().toLowerCase();
/*  64 */       if (!str.isEmpty()) {
/*  65 */         if (str.contains("selecione o fornecedor")) {
/*  66 */           str = A(str).toLowerCase();
/*     */         }
/*     */         
/*  69 */         if (str.contains("nome de usuário e senha não conferem") || str.contains("senha é inválida")) {
/*  70 */           b = 2;
/*  71 */         } else if (StringUtils.containsIgnoreCase(str, getUser())) {
/*  72 */           if (ay() == null || ay().isEmpty()) {
/*  73 */             Document document = Jsoup.parse(str);
/*  74 */             String str1 = document.select("span[id=formprincipal:usuarioinfosub:fornecedor]").text();
/*  75 */             str1 = str1.replace("fornecedor: ", "").toUpperCase();
/*  76 */             E(str1);
/*     */           } 
/*     */           
/*  79 */           if (!ae()) {
/*  80 */             setRunning(true);
/*     */           }
/*  82 */           b = 1;
/*     */         } 
/*     */       } 
/*  85 */     } catch (Exception exception) {
/*  86 */       a.error("Falha ao realizar login", exception);
/*     */     } 
/*     */     
/*  89 */     return b;
/*     */   }
/*     */   
/*     */   private String aj() {
/*  93 */     String str1 = c().a(g.c().a(bD)).getData();
/*  94 */     Document document = Jsoup.parse(str1);
/*  95 */     String str2 = document.select("input[id=javax.faces.ViewState]").first().val();
/*  96 */     String str3 = document.select("input[name*=loginForm:j_id_jsp_]").first().attr("name");
/*     */     
/*  98 */     return c().a(
/*  99 */         g.d().a("http://aquisicoes.seplag.mt.gov.br/").a("sgc/faces/pub/seguranca/LoginPageForm.jsp")
/* 100 */         .a("loginForm", "loginForm")
/* 101 */         .a("action", "authentication")
/* 102 */         .a("areaTarget", "")
/* 103 */         .a("loginForm:usuarioText", getUser())
/* 104 */         .a("loginForm:senhaText", getPassword())
/* 105 */         .a(str3, "/sgc/faces/priv/comum/PrincipalAreaLicitante.jsp")
/* 106 */         .a("loginForm:loginButton", "Entrar")
/* 107 */         .a("javax.faces.ViewState", str2))
/* 108 */       .getData();
/*     */   }
/*     */   
/*     */   private String A(String paramString) {
/*     */     try {
/* 113 */       Document document = Jsoup.parse(paramString);
/* 114 */       Element element = document.select("select[name=fornecedorSelecionado]").first();
/* 115 */       HashMap<Object, Object> hashMap = new HashMap<>();
/*     */       
/* 117 */       for (Element element1 : element.children()) {
/* 118 */         hashMap.put(element1.text().trim().toLowerCase(), element1.attr("value"));
/*     */       }
/*     */       
/* 121 */       c().a(
/* 122 */           g.d().a("http://aquisicoes.seplag.mt.gov.br/").a("sgc/SgcFornecServlet")
/* 123 */           .a("action", "selectFornec")
/* 124 */           .a("fornecedorSelecionado", (String)((Map.Entry)hashMap.entrySet().iterator().next()).getValue()))
/* 125 */         .getData();
/*     */       
/* 127 */       int j = 1;
/* 128 */       int k = 1;
/* 129 */       String str = "";
/*     */       do {
/* 131 */         if (j == 1) {
/* 132 */           paramString = c().a(g.c().a(bX)).getData();
/* 133 */           str = B(paramString);
/*     */         } else {
/* 135 */           paramString = b(j, str);
/*     */         } 
/*     */         
/* 138 */         if (!paramString.isEmpty()) {
/* 139 */           document = Jsoup.parse(paramString);
/* 140 */           Elements elements = document.select("table[id=form1:listaDataTable]").select("tbody > tr");
/*     */           
/* 142 */           for (Element element1 : elements) {
/* 143 */             Elements elements1 = element1.select("td");
/* 144 */             String str1 = y.k("##.###.###/####-##", elements1.get(0).text());
/*     */             
/* 146 */             if (str1.equals(ax())) {
/* 147 */               String str2 = elements1.get(1).text().trim().toLowerCase();
/*     */ 
/*     */               
/* 150 */               c().a(g.c().a("http://aquisicoes.seplag.mt.gov.br/").a("sgc/sair.logout")).getData();
/* 151 */               if (!aj().contains("mensagemerrorlogin"))
/*     */               {
/*     */                 
/* 154 */                 return c().a(
/* 155 */                     g.d().a("http://aquisicoes.seplag.mt.gov.br/").a("sgc/SgcFornecServlet")
/* 156 */                     .a("action", "selectFornec")
/* 157 */                     .a("fornecedorSelecionado", (String)hashMap.get(str2)))
/* 158 */                   .getData();
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 164 */         if (j != k || 
/* 165 */           !paramString.contains("rich-datascr-inact"))
/* 166 */           continue;  k = Integer.parseInt(document.select("tfoot .rich-datascr-inact").last().text());
/*     */ 
/*     */ 
/*     */         
/* 170 */         ++j;
/* 171 */       } while (j <= k);
/* 172 */     } catch (RuntimeException runtimeException) {
/* 173 */       a.error("Erro ao selecionar fornecedor", runtimeException);
/*     */     } 
/*     */     
/* 176 */     return "";
/*     */   }
/*     */   
/*     */   public String b(int paramInt, String paramString) {
/* 180 */     return c().a(
/* 181 */         g.d().a(bX)
/* 182 */         .a("AJAXREQUEST", "j_id_jsp_1678965469_0")
/* 183 */         .a("form1", "form1")
/* 184 */         .a("form1:aboutModalHeadOpenedState", "")
/* 185 */         .a("MenuTitleComponent:editalGroupMenu:hidden", "false")
/* 186 */         .a("MenuTitleComponent:comrpaDiretaGroupMenu:hidden", "false")
/* 187 */         .a("MenuTitleComponent:cotacoesGroupMenu:hidden", "false")
/* 188 */         .a("MenuTitleComponent:pregaoGroupMenu:hidden", "false")
/* 189 */         .a("MenuTitleComponent:fornecedorGroupMenu:hidden", "true")
/* 190 */         .a("MenuTitleComponent:protocolosMenuGoup:hidden", "false")
/* 191 */         .a("MenuTitleComponent:manutencaoUsuarioGroupMenu:hidden", "true")
/* 192 */         .a("MenuTitleComponent:manualSistemaGroup:hidden", "true")
/* 193 */         .a("form1:aboutModalOpenedState", "")
/* 194 */         .a("javax.faces.ViewState", paramString)
/* 195 */         .a("ajaxSingle", "form1:listaDataTable:j_id_jsp_1678965469_16")
/* 196 */         .a("form1:listaDataTable:j_id_jsp_1678965469_16", paramInt)
/* 197 */         .a("AJAX:EVENTS_COUNT", "1")
/* 198 */         .a("", ""))
/* 199 */       .getData();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String ak() {
/* 209 */     return c().a(g.c().a(bE).a("MinhasPropostasPEPageList.jsp")).getData();
/*     */   }
/*     */   
/*     */   public String al() {
/* 213 */     String str = ak();
/* 214 */     return B(str);
/*     */   }
/*     */   
/*     */   public String c(int paramInt, String paramString) {
/* 218 */     return b(paramInt, paramString, "");
/*     */   }
/*     */   
/*     */   public String b(int paramInt, String paramString1, String paramString2) {
/* 222 */     String str = y.formatDate(new Date(), "MM/yyyy");
/* 223 */     return c().a(
/* 224 */         g.d().a(bE).a("MinhasPropostasPEPageList.jsp")
/* 225 */         .a("formMinhasPropostasPEPageList", "formMinhasPropostasPEPageList")
/* 226 */         .a("formMinhasPropostasPEPageList:aboutModalHeadOpenedState", "")
/* 227 */         .a("MenuTitleComponent:editalGroupMenu:hidden", "false")
/* 228 */         .a("MenuTitleComponent:comrpaDiretaGroupMenu:hidden", "false")
/* 229 */         .a("MenuTitleComponent:cotacoesGroupMenu:hidden", "false")
/* 230 */         .a("MenuTitleComponent:pregaoGroupMenu:hidden", "true")
/* 231 */         .a("MenuTitleComponent:fornecedorGroupMenu:hidden", "true")
/* 232 */         .a("MenuTitleComponent:protocolosMenuGoup:hidden", "false")
/* 233 */         .a("MenuTitleComponent:manutencaoUsuarioGroupMenu:hidden", "true")
/* 234 */         .a("formMinhasPropostasPEPageList:numProcesso", paramString2)
/* 235 */         .a("formMinhasPropostasPEPageList:numPregao", "")
/* 236 */         .a("formMinhasPropostasPEPageList:objetoPregao", "")
/* 237 */         .a("formMinhasPropostasPEPageList:j_id_jsp_13542415_14", "")
/* 238 */         .a("formMinhasPropostasPEPageList:j_id_jsp_13542415_17", "")
/* 239 */         .a("formMinhasPropostasPEPageList:dataInicialInputInputDate", "")
/* 240 */         .a("formMinhasPropostasPEPageList:dataInicialInputInputCurrentDate", str)
/* 241 */         .a("formMinhasPropostasPEPageList:dataFinalInputInputDate", "")
/* 242 */         .a("formMinhasPropostasPEPageList:dataFinalInputInputCurrentDate", str)
/* 243 */         .a("formMinhasPropostasPEPageList:popupPanelOpenedState", "")
/* 244 */         .a("formMinhasPropostasPEPageList:aboutModalOpenedState", "")
/* 245 */         .a("javax.faces.ViewState", paramString1)
/* 246 */         .a("formMinhasPropostasPEPageList:propostaDataTable:dataScroller", "idx" + Integer.toString(paramInt))
/* 247 */         .a("formMinhasPropostasPEPageList:_idcl", "formMinhasPropostasPEPageList:propostaDataTable:dataScrolleridx" + Integer.toString(paramInt)))
/* 248 */       .getData();
/*     */   }
/*     */   
/*     */   public String a(String paramString1, String paramString2) {
/* 252 */     String str = y.formatDate(new Date(), "MM/yyyy");
/*     */     
/* 254 */     return c().a(
/* 255 */         g.d().a(bE).a("PregaoEmAndamentoPageList.jsp")
/* 256 */         .a("formPregaoEmAndamentoPageList", "formPregaoEmAndamentoPageList")
/* 257 */         .a("formPregaoEmAndamentoPageList:aboutModalHeadOpenedState", "")
/* 258 */         .a("MenuTitleComponent:editalGroupMenu:hidden", "false")
/* 259 */         .a("MenuTitleComponent:comrpaDiretaGroupMenu:hidden", "false")
/* 260 */         .a("MenuTitleComponent:cotacoesGroupMenu:hidden", "false")
/* 261 */         .a("MenuTitleComponent:pregaoGroupMenu:hidden", "true")
/* 262 */         .a("MenuTitleComponent:fornecedorGroupMenu:hidden", "false")
/* 263 */         .a("MenuTitleComponent:protocolosMenuGoup:hidden", "false")
/* 264 */         .a("MenuTitleComponent:manutencaoUsuarioGroupMenu:hidden", "false")
/* 265 */         .a("formPregaoEmAndamentoPageList:orgaoCombo", "0")
/* 266 */         .a("formPregaoEmAndamentoPageList:modalidadeCombo", "0")
/* 267 */         .a("formPregaoEmAndamentoPageList:processoInput", paramString1)
/* 268 */         .a("formPregaoEmAndamentoPageList:objetoProcessoInput", "")
/* 269 */         .a("formPregaoEmAndamentoPageList:dtInicioTextInputDate", "")
/* 270 */         .a("formPregaoEmAndamentoPageList:dtInicioTextInputCurrentDate", str)
/* 271 */         .a("formPregaoEmAndamentoPageList:dtFimTextInputDate", "")
/* 272 */         .a("formPregaoEmAndamentoPageList:dtFimTextInputCurrentDate", str)
/* 273 */         .a("formPregaoEmAndamentoPageList:editalInput", "")
/* 274 */         .a("formPregaoEmAndamentoPageList:pesquisarButton", "Pesquisar")
/* 275 */         .a("formPregaoEmAndamentoPageList:aboutModalOpenedState", "")
/* 276 */         .a("javax.faces.ViewState", paramString2))
/* 277 */       .getData();
/*     */   }
/*     */   
/*     */   public String c(String paramString1, String paramString2) {
/* 281 */     return c().a(
/* 282 */         g.d().a(bE).a("PregaoPropostaFornecedorPageList.jsp")
/* 283 */         .a("formPregaoPropostaFornecedorPageList", "formPregaoPropostaFornecedorPageList")
/* 284 */         .a("formPregaoPropostaFornecedorPageList:aboutModalHeadOpenedState", "")
/* 285 */         .a("MenuTitleComponent:editalGroupMenu:hidden", "false")
/* 286 */         .a("MenuTitleComponent:comrpaDiretaGroupMenu:hidden", "false")
/* 287 */         .a("MenuTitleComponent:cotacoesGroupMenu:hidden", "false")
/* 288 */         .a("MenuTitleComponent:pregaoGroupMenu:hidden", "true")
/* 289 */         .a("MenuTitleComponent:fornecedorGroupMenu:hidden", "false")
/* 290 */         .a("MenuTitleComponent:protocolosMenuGoup:hidden", "false")
/* 291 */         .a("MenuTitleComponent:manutencaoUsuarioGroupMenu:hidden", "false")
/* 292 */         .a("formPregaoPropostaFornecedorPageList:orgaoCombo", "0")
/* 293 */         .a("formPregaoPropostaFornecedorPageList:procurarRadio", "1")
/* 294 */         .a("formPregaoPropostaFornecedorPageList:numeroText", paramString1)
/* 295 */         .a("formPregaoPropostaFornecedorPageList:objetoText", "")
/* 296 */         .a("formPregaoPropostaFornecedorPageList:pesquisarButton", "Pesquisar")
/* 297 */         .a("formPregaoPropostaFornecedorPageList:aboutModalOpenedState", "")
/* 298 */         .a("javax.faces.ViewState", paramString2))
/* 299 */       .getData();
/*     */   }
/*     */   
/*     */   public String d(String paramString1, String paramString2) {
/* 303 */     String str = y.formatDate(new Date(), "MM/yyyy");
/* 304 */     return c().a(
/* 305 */         g.d().a(bE).a("PregoesSuspensosPageList.jsp")
/* 306 */         .a("formPregoesSuspensosPageList", "formPregoesSuspensosPageList")
/* 307 */         .a("formPregoesSuspensosPageList:aboutModalHeadOpenedState", "")
/* 308 */         .a("MenuTitleComponent:editalGroupMenu:hidden", "false")
/* 309 */         .a("MenuTitleComponent:comrpaDiretaGroupMenu:hidden", "false")
/* 310 */         .a("MenuTitleComponent:cotacoesGroupMenu:hidden", "false")
/* 311 */         .a("MenuTitleComponent:pregaoGroupMenu:hidden", "true")
/* 312 */         .a("MenuTitleComponent:fornecedorGroupMenu:hidden", "false")
/* 313 */         .a("MenuTitleComponent:protocolosMenuGoup:hidden", "false")
/* 314 */         .a("MenuTitleComponent:manutencaoUsuarioGroupMenu:hidden", "false")
/* 315 */         .a("formPregoesSuspensosPageList:orgaoCombo", "0")
/* 316 */         .a("formPregoesSuspensosPageList:modalidadeCombo", "0")
/* 317 */         .a("formPregoesSuspensosPageList:processoInput", paramString1)
/* 318 */         .a("formPregoesSuspensosPageList:objetoProcessoInput", "")
/* 319 */         .a("formPregoesSuspensosPageList:dtInicioTextInputDate", "")
/* 320 */         .a("formPregoesSuspensosPageList:dtInicioTextInputCurrentDate", str)
/* 321 */         .a("formPregoesSuspensosPageList:dtFimTextInputDate", "")
/* 322 */         .a("formPregoesSuspensosPageList:dtFimTextInputCurrentDate", str)
/* 323 */         .a("formPregoesSuspensosPageList:editalInput", "")
/* 324 */         .a("formPregoesSuspensosPageList:suspensaoInicioTextInputDate", "")
/* 325 */         .a("formPregoesSuspensosPageList:suspensaoInicioTextInputCurrentDate", str)
/* 326 */         .a("formPregoesSuspensosPageList:suspensaoFimTextInputDate", "")
/* 327 */         .a("formPregoesSuspensosPageList:suspensaoFimTextInputCurrentDate", str)
/* 328 */         .a("formPregoesSuspensosPageList:pesquisarButton", "Pesquisar")
/* 329 */         .a("formPregoesSuspensosPageList:aboutModalOpenedState", "")
/* 330 */         .a("javax.faces.ViewState", paramString2))
/* 331 */       .getData();
/*     */   }
/*     */   
/*     */   public String e(String paramString1, String paramString2) {
/* 335 */     String str = y.formatDate(new Date(), "MM/yyyy");
/* 336 */     return c().a(
/* 337 */         g.d().a(bE).a("PregoesEncerradosPageList.jsp")
/* 338 */         .a("formPregoesEncerradosPageList", "formPregoesEncerradosPageList")
/* 339 */         .a("formPregoesEncerradosPageList:aboutModalHeadOpenedState", "")
/* 340 */         .a("MenuTitleComponent:editalGroupMenu:hidden", "false")
/* 341 */         .a("MenuTitleComponent:comrpaDiretaGroupMenu:hidden", "false")
/* 342 */         .a("MenuTitleComponent:cotacoesGroupMenu:hidden", "false")
/* 343 */         .a("MenuTitleComponent:pregaoGroupMenu:hidden", "true")
/* 344 */         .a("MenuTitleComponent:fornecedorGroupMenu:hidden", "false")
/* 345 */         .a("MenuTitleComponent:protocolosMenuGoup:hidden", "false")
/* 346 */         .a("MenuTitleComponent:manutencaoUsuarioGroupMenu:hidden", "false")
/* 347 */         .a("formPregoesEncerradosPageList:orgaoCombo", "0")
/* 348 */         .a("formPregoesEncerradosPageList:modalidadeCombo", "0")
/* 349 */         .a("formPregoesEncerradosPageList:processoInput", paramString1)
/* 350 */         .a("formPregoesEncerradosPageList:objetoProcessoInput", "")
/* 351 */         .a("formPregoesEncerradosPageList:dtInicioTextInputDate", "")
/* 352 */         .a("formPregoesEncerradosPageList:dtInicioTextInputCurrentDate", str)
/* 353 */         .a("formPregoesEncerradosPageList:dtFimTextInputDate", "")
/* 354 */         .a("formPregoesEncerradosPageList:dtFimTextInputCurrentDate", str)
/* 355 */         .a("formPregoesEncerradosPageList:editalInput", "")
/* 356 */         .a("formPregoesEncerradosPageList:encerramentoInicioTextInputDate", "")
/* 357 */         .a("formPregoesEncerradosPageList:encerramentoInicioTextInputCurrentDate", str)
/* 358 */         .a("formPregoesEncerradosPageList:encerramentoFimTextInputDate", "")
/* 359 */         .a("formPregoesEncerradosPageList:encerramentoFimTextInputCurrentDate", str)
/* 360 */         .a("formPregoesEncerradosPageList:pesquisarButton", "Pesquisar")
/* 361 */         .a("formPregoesEncerradosPageList:aboutModalOpenedState", "")
/* 362 */         .a("javax.faces.ViewState", paramString2))
/* 363 */       .getData();
/*     */   }
/*     */ 
/*     */   
/*     */   public String f(String paramString1, String paramString2) {
/* 368 */     String str = y.formatDate(new Date(), "MM/yyyy");
/* 369 */     return c().a(
/* 370 */         g.d().a(bE).a("MinhasPropostasPEPageList.jsp")
/* 371 */         .a("formMinhasPropostasPEPageList", "formMinhasPropostasPEPageList")
/* 372 */         .a("formMinhasPropostasPEPageList:aboutModalHeadOpenedState", "")
/* 373 */         .a("MenuTitleComponent:editalGroupMenu:hidden", "false")
/* 374 */         .a("MenuTitleComponent:comrpaDiretaGroupMenu:hidden", "false")
/* 375 */         .a("MenuTitleComponent:cotacoesGroupMenu:hidden", "false")
/* 376 */         .a("MenuTitleComponent:pregaoGroupMenu:hidden", "true")
/* 377 */         .a("MenuTitleComponent:fornecedorGroupMenu:hidden", "false")
/* 378 */         .a("MenuTitleComponent:protocolosMenuGoup:hidden", "false")
/* 379 */         .a("MenuTitleComponent:manutencaoUsuarioGroupMenu:hidden", "false")
/* 380 */         .a("formMinhasPropostasPEPageList:numProcesso", "")
/* 381 */         .a("formMinhasPropostasPEPageList:numPregao", "")
/* 382 */         .a("formMinhasPropostasPEPageList:objetoPregao", "")
/* 383 */         .a("formMinhasPropostasPEPageList:j_id_jsp_1660905357_14", "")
/* 384 */         .a("formMinhasPropostasPEPageList:j_id_jsp_1660905357_17", "")
/* 385 */         .a("formMinhasPropostasPEPageList:dataInicialInputInputDate", "")
/* 386 */         .a("formMinhasPropostasPEPageList:dataInicialInputInputCurrentDate", str)
/* 387 */         .a("formMinhasPropostasPEPageList:dataFinalInputInputDate", "")
/* 388 */         .a("formMinhasPropostasPEPageList:dataFinalInputInputCurrentDate", str)
/* 389 */         .a("formMinhasPropostasPEPageList:popupPanelOpenedState", "")
/* 390 */         .a("formMinhasPropostasPEPageList:aboutModalOpenedState", "")
/* 391 */         .a("javax.faces.ViewState", paramString2)
/* 392 */         .a("formMinhasPropostasPEPageList:propostaDataTable:0:visualizarLink", "formMinhasPropostasPEPageList:propostaDataTable:0:visualizarLink")
/* 393 */         .a("idPropostaPregaoHidden", paramString1))
/* 394 */       .getData();
/*     */   }
/*     */ 
/*     */   
/*     */   public String am() {
/* 399 */     String str = c().a(g.c().a(bE).a("PregaoEmAndamentoPageList.jsp")).getData();
/* 400 */     return B(str);
/*     */   }
/*     */   
/*     */   public String ao() {
/* 404 */     String str = c().a(g.c().a(bE).a("PregaoPropostaFornecedorPageList.jsp")).getData();
/* 405 */     return B(str);
/*     */   }
/*     */   
/*     */   public String ap() {
/* 409 */     String str = c().a(g.c().a(bE).a("PregoesSuspensosPageList.jsp")).getData();
/* 410 */     return B(str);
/*     */   }
/*     */   
/*     */   public String aq() {
/* 414 */     String str = c().a(g.c().a(bE).a("PregoesEncerradosPageList.jsp")).getData();
/* 415 */     return B(str);
/*     */   }
/*     */   
/*     */   private String B(String paramString) {
/* 419 */     Document document = Jsoup.parse(paramString);
/* 420 */     return document.select("input[id=javax.faces.ViewState]").val();
/*     */   }
/*     */   
/*     */   public String a(a parama) {
/* 424 */     return c().a(
/* 425 */         g.c().a(bE).a("MensagemLerPageList.jsp")
/* 426 */         .a("pregao", parama.a().v())
/* 427 */         .a("lotePregao", parama.v()))
/* 428 */       .getData();
/*     */   }
/*     */ 
/*     */   
/*     */   protected String ar() {
/* 433 */     String str = c().a(g.c().a(bE).a("PregaoDiaPageList.jsp")).getData();
/* 434 */     Document document = Jsoup.parse(str);
/* 435 */     return document.select("input[id=javax.faces.ViewState]").first().val();
/*     */   }
/*     */ 
/*     */   
/*     */   protected e l(String paramString) {
/* 440 */     String str = y.formatDate(new Date(), "MM/yyyy");
/* 441 */     return c().a(
/* 442 */         g.d().a(bE).a("PregaoDiaPageList.jsp")
/* 443 */         .a("formPregaoDiaPageList", "formPregaoDiaPageList")
/* 444 */         .a("formPregaoDiaPageList:aboutModalHeadOpenedState", "")
/* 445 */         .a("MenuTitleComponent:editalGroupMenu:hidden", "false")
/* 446 */         .a("MenuTitleComponent:comrpaDiretaGroupMenu:hidden", "false")
/* 447 */         .a("MenuTitleComponent:cotacoesGroupMenu:hidden", "false")
/* 448 */         .a("MenuTitleComponent:pregaoGroupMenu:hidden", "true")
/* 449 */         .a("MenuTitleComponent:fornecedorGroupMenu:hidden", "true")
/* 450 */         .a("MenuTitleComponent:protocolosMenuGoup:hidden", "false")
/* 451 */         .a("MenuTitleComponent:manutencaoUsuarioGroupMenu:hidden", "false")
/* 452 */         .a("formPregaoDiaPageList:orgaoCombo", "0")
/* 453 */         .a("formPregaoDiaPageList:dtInicioTextInputDate", "")
/* 454 */         .a("formPregaoDiaPageList:dtInicioTextInputCurrentDate", str)
/* 455 */         .a("formPregaoDiaPageList:dtFimTextInputDate", "")
/* 456 */         .a("formPregaoDiaPageList:dtFimTextInputCurrentDate", str)
/* 457 */         .a("formPregaoDiaPageList:procurarRadio", "1")
/* 458 */         .a("formPregaoDiaPageList:numeroText", "")
/* 459 */         .a("formPregaoDiaPageList:objetoText", "")
/* 460 */         .a("formPregaoDiaPageList:aboutModalOpenedState", "")
/* 461 */         .a("javax.faces.ViewState", paramString)
/* 462 */         .a("formPregaoDiaPageList:listaDataTable:0:visualizarLink", "formPregaoDiaPageList:listaDataTable:0:visualizarLink")
/* 463 */         .a("idPregao", "0")
/* 464 */         .a());
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
/* 475 */     return A.a().p("http://aquisicoes.seplag.mt.gov.br/");
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, x paramx) {
/* 480 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, NameValuePair[] paramArrayOfNameValuePair, x paramx) {
/* 485 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */