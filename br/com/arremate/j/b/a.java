/*     */ package br.com.arremate.j.b;
/*     */ 
/*     */ import br.com.arremate.a.j;
/*     */ import br.com.arremate.f.x;
/*     */ import br.com.arremate.h.b;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.h.g;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.m.A;
/*     */ import com.google.a.o.a.af;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class a
/*     */   extends i
/*     */ {
/*  27 */   private static final af d = af.a(8.0D);
/*     */   
/*     */   private static final String DOMAIN = "https://www.compras.rj.gov.br/";
/*     */   
/*  31 */   private static final String aQ = String.join("", new CharSequence[] { "https://www.compras.rj.gov.br/", "Portal-Siga" });
/*     */   
/*  33 */   private static final String aR = String.join("", new CharSequence[] { "https://www.compras.rj.gov.br/", "mercatto/aplicacao/asp/seg/trata_logon.asp?Status=20" });
/*  34 */   private static final String aS = String.join("", new CharSequence[] { "https://www.compras.rj.gov.br/", "mercatto/aplicacao/asp/seg/loadMenu.asp" });
/*  35 */   private static final String aT = String.join("", new CharSequence[] { "https://www.compras.rj.gov.br/", "mercatto/aplicacao/asp/admtrans/mntbase/sel_subfuncao.asp?ID_Func=123" });
/*  36 */   private static final String aU = String.join("", new CharSequence[] { "https://www.compras.rj.gov.br/", "mercatto/aplicacao/asp/admtrans/mntbase/Cad_ClienteForm.asp?FormMode=Editar" });
/*     */ 
/*     */   
/*  39 */   private static final String aV = String.join("", new CharSequence[] { "https://www.compras.rj.gov.br/", "mercatto/aplicacao/asp/pregao/sel_criterios_leilao.asp?ID_Func=125&Status=" });
/*  40 */   private static final String aW = String.join("", new CharSequence[] { "https://www.compras.rj.gov.br/", "mercatto/aplicacao/asp/pregao/sel_criterios_leilao.asp?ID_Func=125" });
/*     */   
/*  42 */   private final AtomicInteger d = new AtomicInteger(1);
/*     */   
/*     */   public a(d paramd, boolean paramBoolean) {
/*  45 */     a(paramd);
/*  46 */     if (paramBoolean) {
/*  47 */       a(b());
/*     */     } else {
/*  49 */       bH();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void bH() {
/*  54 */     a(g.a(this, b(), parame -> {
/*     */             String str = parame.getData().toLowerCase();
/*     */ 
/*     */             
/*  58 */             return (str.contains("sua sessão com o siga acaba de ser encerrada") || str.contains("sua sessão com o sistema foi encerrada") || str.contains("sessão encerrada") || str.contains("sessão expirou") || str.contains("sessão expirada") || str.contains("derruba seção") || parame.getStatusCode() == 401);
/*     */           }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private b b() {
/*  66 */     return g.c()
/*  67 */       .a(302)
/*  68 */       .b(180000).d(25).e(100).a((af)d)
/*  69 */       .a("Host", "www.compras.rj.gov.br")
/*  70 */       .a("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36")
/*  71 */       .a();
/*     */   }
/*     */ 
/*     */   
/*     */   public int z() {
/*  76 */     byte b = 0;
/*     */     
/*     */     try {
/*  79 */       c().bB();
/*     */       
/*  81 */       String str1 = U();
/*     */       
/*  83 */       if (str1.isEmpty()) {
/*  84 */         setMessage("Falha ao quebrar reCaptcha pra realizar o login no portal!");
/*  85 */         return b;
/*     */       } 
/*     */       
/*  88 */       String str2 = j(str1);
/*     */       
/*  90 */       str1 = c().a(g.c().a(str2).b()).getData();
/*     */       
/*  92 */       if (str1 != null && !str1.isEmpty()) {
/*  93 */         if (str1.toLowerCase().contains("login ou senha inválida")) {
/*  94 */           b = 2;
/*  95 */         } else if (str1.toLowerCase().contains("sua conta está bloqueada")) {
/*  96 */           b = 2;
/*  97 */         } else if (str1.toLowerCase().contains("sua sessão com o sistema foi encerrada")) {
/*  98 */           b = 0;
/*  99 */         } else if (str1.toLowerCase().contains("url=/mercatto/aplicacao/asp/seg/sistema.asp")) {
/* 100 */           c().a(g.c().a(aS).b());
/* 101 */           c().a(g.c().a(aT).b());
/* 102 */           str1 = c().a(g.c().a(aU).b()).getData();
/*     */           
/* 104 */           Document document = Jsoup.parse(str1);
/* 105 */           Element element1 = document.select("input[name=NM_Cli]").first();
/* 106 */           Element element2 = document.select("input[name=NU_CIC_Cli]").first();
/*     */           
/* 108 */           if (element1 != null && !element1.val().isEmpty() && element2 != null && !element2.val().isEmpty()) {
/* 109 */             E(element1.val().trim());
/* 110 */             D(element2.val().replaceAll("[^0-9]*", ""));
/*     */             
/* 112 */             setRunning(true);
/*     */             
/* 114 */             b = 1;
/*     */           } 
/*     */         } 
/*     */       }
/* 118 */     } catch (Exception exception) {
/* 119 */       a.error("LoginComprasRJ Failed", exception);
/*     */     } 
/*     */     
/* 122 */     return b;
/*     */   }
/*     */   
/*     */   private String U() {
/* 126 */     br.com.arremate.a.a.a a1 = l();
/* 127 */     if (a1 == null) {
/* 128 */       return "";
/*     */     }
/*     */     
/* 131 */     return c().a(
/* 132 */         g.d().a(aR)
/* 133 */         .b("Referer", "https://www.compras.rj.gov.br/mercatto/aplicacao/asp/seg/logon.asp")
/* 134 */         .a("g-recaptcha-response", a1.a())
/* 135 */         .a("Botao", "Entrar")
/* 136 */         .a("email_lembrar", "")
/* 137 */         .a("Usuario", getUser())
/* 138 */         .a("Senha", getPassword())
/* 139 */         .b()).getData();
/*     */   }
/*     */   
/*     */   private br.com.arremate.a.a.a l() {
/* 143 */     for (byte b = 0; b < 3; b++) {
/* 144 */       j j = j.a();
/* 145 */       br.com.arremate.a.a.a a1 = j.k();
/*     */       
/* 147 */       if (a1 != null) {
/* 148 */         return a1;
/*     */       }
/*     */     } 
/*     */     
/* 152 */     return null;
/*     */   }
/*     */   
/*     */   public void M(int paramInt) {
/* 156 */     c().a(g.c().a("https://www.compras.rj.gov.br/")
/* 157 */         .a("mercatto/aplicacao/asp/pregao/lance_leilao_consulta.asp?ID_Func=93&Status=3,4,5,6,7,8,10,12,13,14,15,26,27,28,29,30,31,32,33,36,40&IN_LEILAO=S&Pregao_Andamento=S"));
/* 158 */     c().a(g.c().a("https://www.compras.rj.gov.br/").a("mercatto/aplicacao/asp/pregao/Lance_Leilao_Normal.asp?ID_LLeilao=" + Integer.toString(paramInt)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String j(String paramString) {
/* 168 */     Document document = Jsoup.parse(paramString);
/* 169 */     Elements elements = document.select("meta[HTTP-EQUIV=REFRESH]");
/* 170 */     String[] arrayOfString = elements.attr("content").split(";");
/* 171 */     String str = "";
/* 172 */     for (String str1 : arrayOfString) {
/* 173 */       if (str1.contains("url=")) {
/* 174 */         str = str1.replace("url=", "");
/*     */       }
/*     */     } 
/* 177 */     str = "https://www.compras.rj.gov.br" + str;
/* 178 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String a(int paramInt1, int paramInt2) {
/* 187 */     return c().a(g.c().a("https://www.compras.rj.gov.br/").a("mercatto/aplicacao/asp/pregao/lance_leilao_normal_item.asp?leilao=")
/* 188 */         .a(paramInt1).a("&item=").a(paramInt2)).getData();
/*     */   }
/*     */   
/*     */   public e c(int paramInt) {
/* 192 */     e e = c().a(g.c().a("https://www.compras.rj.gov.br/")
/* 193 */         .a("mercatto/aplicacao/asp/pregao/lance_leilao_consulta.asp?ID_Func=93&Status=3,4,5,6,7,8,10,12,13,14,15,26,27,28,29,30,31,32,33,36,40&IN_LEILAO=S&Pregao_Andamento=S"));
/* 194 */     long l = e.k();
/*     */     
/* 196 */     e = c().a(
/* 197 */         g.c().a("https://www.compras.rj.gov.br/").a("mercatto/aplicacao/asp/pregao/Lance_Leilao_Normal.asp?ID_LLeilao=").a(paramInt));
/*     */     
/* 199 */     e.q(e.k() + l);
/* 200 */     return e;
/*     */   }
/*     */   
/*     */   public e a(int paramInt1, int paramInt2) {
/* 204 */     e e = c().a(g.c().a("https://www.compras.rj.gov.br/")
/* 205 */         .a("mercatto/aplicacao/asp/pregao/lance_leilao_consulta.asp?ID_Func=93&Status=3&IN_LEILAO=S&Pregao_Andamento=S"));
/*     */     
/* 207 */     long l = e.k();
/*     */     
/* 209 */     e = c().a(g.c().a("https://www.compras.rj.gov.br/")
/* 210 */         .a("mercatto/aplicacao/asp/pregao/Lance_Leilao_Normal.asp?ID_LLeilao=").a(paramInt1));
/* 211 */     l += e.k();
/*     */     
/* 213 */     e = c().a(g.c().a("https://www.compras.rj.gov.br/")
/* 214 */         .a("mercatto/aplicacao/asp/pregao/lance_leilao_normal_item_forn.asp?leilao=")
/* 215 */         .a(paramInt1).a("&formalicit=1&objeto=").a(paramInt2));
/*     */     
/* 217 */     e.q(e.k() + l);
/* 218 */     return e;
/*     */   }
/*     */   
/*     */   public String c(int paramInt) {
/* 222 */     return c().a(g.c().a("https://www.compras.rj.gov.br/")
/* 223 */         .a("mercatto/aplicacao/asp/pregao/Lance_Leilao_Normal.asp?ID_LLeilao=").a(paramInt)).getData();
/*     */   }
/*     */   
/*     */   public String V() {
/* 227 */     return c().a(g.c().a("https://www.compras.rj.gov.br/").a("mercatto/aplicacao/asp/pregao/Historico_Chat.asp")).getData();
/*     */   }
/*     */   
/*     */   public String k(String paramString) {
/* 231 */     return c().a(g.c().a("https://www.compras.rj.gov.br/").a(paramString)).getData();
/*     */   }
/*     */   
/*     */   public String l(String paramString) {
/* 235 */     c().a(g.c().a("https://www.compras.rj.gov.br/")
/* 236 */         .a("mercatto/aplicacao/asp/pregao/lista_edital.asp?ID_Func=125"));
/*     */     
/* 238 */     c().a(g.d().a("https://www.compras.rj.gov.br/").a("mercatto/Aplicacao/ASP/pregao/Lista_Leilao_trata.asp")
/* 239 */         .a("Sel_Item", paramString)
/* 240 */         .a("funcao", "Editar")
/* 241 */         .a("tipo_Ant", "")
/* 242 */         .a("status_Ant", "")
/* 243 */         .a("Sel_Item_Ant", paramString)
/* 244 */         .a("Forum_Pagina", "")
/* 245 */         .a("Pagina_Anterior", "/mercatto/aplicacao/asp/pregao/Sel_Criterios_leilao.asp")
/* 246 */         .a("lista", paramString)
/* 247 */         .a("Status_lista", "2")
/* 248 */         .a("Participacao", ""));
/*     */     
/* 250 */     return c().a(g.c().a("https://www.compras.rj.gov.br/")
/* 251 */         .a("mercatto/aplicacao/asp/pregao/Lista_Leilao_Exibe.asp?ORIGEM=0&Sel_Item=")
/* 252 */         .a(paramString).a("&tipo=&status=")).getData();
/*     */   }
/*     */   
/*     */   public String m(String paramString) {
/* 256 */     c().a(g.c().a(aW));
/*     */     
/* 258 */     c().a(g.d().a("https://www.compras.rj.gov.br/").a("mercatto/Aplicacao/ASP/pregao/Lista_Leilao_trata.asp")
/* 259 */         .a("Sel_Item", paramString)
/* 260 */         .a("funcao", "Editar")
/* 261 */         .a("Forum_Pagina", "2")
/* 262 */         .a("Status_lista", "2")
/* 263 */         .a("Pagina_Anterior", "/mercatto/aplicacao/asp/pregao/sel_criterios_leilao.asp"));
/*     */ 
/*     */     
/* 266 */     return c().a(g.c().a("https://www.compras.rj.gov.br/")
/* 267 */         .a("mercatto/aplicacao/asp/pregao/Lista_Leilao_Exibe.asp?ORIGEM=0&Sel_Item=&tipo=&status=")).getData();
/*     */   }
/*     */   
/*     */   public String d(int paramInt) {
/* 271 */     c().a(g.c().a("https://www.compras.rj.gov.br/").a("mercatto/aplicacao/asp/pregao/followup_classificacao.asp?ID_Func=153"));
/*     */     
/* 273 */     c().a(g.d().a("https://www.compras.rj.gov.br/").a("mercatto/aplicacao/asp/pregao/sel_criterios_classificacao.asp")
/* 274 */         .a("Pregao", paramInt)
/* 275 */         .a("sel_FormaLicit", "0")
/* 276 */         .a("Status", "")
/* 277 */         .a("StatusClas", ""));
/*     */     
/* 279 */     return c().a(g.c().a("https://www.compras.rj.gov.br/")
/* 280 */         .a("mercatto/Aplicacao/ASP/pregao/List_RankingClassificacaoProp.asp?ID_LLeilao=")
/* 281 */         .a(paramInt).a("&Consulta=SIM")).getData();
/*     */   }
/*     */   
/*     */   public String a(int paramInt, String paramString) {
/* 285 */     c().a(g.c().a("https://www.compras.rj.gov.br/").a("mercatto/aplicacao/asp/pregao/Lista_Leilao_Exibe.asp?ID_Func=125&LST=")
/* 286 */         .a(paramInt).a("&NM_LST=").a(paramString)
/* 287 */         .a("&ORG=/mercatto/aplicacao/asp/pregao/lista_edital.asp"));
/*     */     
/* 289 */     return c().a(g.c().a("https://www.compras.rj.gov.br/")
/* 290 */         .a("mercatto/aplicacao/asp/pregao/List_Envelopes.asp?Retorno=Lista_Leilao_Exibe")).getData();
/*     */   }
/*     */   
/*     */   public String a(int paramInt, String paramString1, String paramString2) {
/* 294 */     c().a(g.c().a("https://www.compras.rj.gov.br/")
/* 295 */         .a("mercatto/aplicacao/asp/pregao/Lista_Leilao_Exibe.asp?ID_Func=125&LST=")
/* 296 */         .a(String.valueOf(paramInt)).a("&NM_LST=").a(paramString1)
/* 297 */         .a("&ORG=/mercatto/aplicacao/asp/pregao/lista_edital.asp"));
/*     */     
/* 299 */     return c().a(g.c().a("https://www.compras.rj.gov.br/")
/* 300 */         .a("/mercatto/aplicacao/asp/pregao/List_Envelopes.asp?offset=").a(paramString2)).getData();
/*     */   }
/*     */   
/*     */   public String n(String paramString) {
/* 304 */     c().a(g.c().a(aW));
/* 305 */     return c().a(g.c().a(aV).a(paramString)).getData();
/*     */   }
/*     */   
/*     */   public String e(int paramInt) {
/* 309 */     return c().a(g.c().a("https://www.compras.rj.gov.br/")
/* 310 */         .a("mercatto/aplicacao/asp/pregao/Sel_criterios_leilao.asp?offset=").a(Integer.toString(paramInt))).getData();
/*     */   }
/*     */   
/*     */   public String W() {
/* 314 */     return c().a(g.c().a("https://www.compras.rj.gov.br/")
/* 315 */         .a("mercatto/aplicacao/asp/pregao/sel_criterios_leilao.asp?ID_Func=125&Status=5")).getData();
/*     */   }
/*     */   
/*     */   public String X() {
/* 319 */     return c().a(g.c().a("https://www.compras.rj.gov.br/")
/* 320 */         .a("mercatto/aplicacao/asp/pregao/sel_criterios_leilao.asp?ID_Func=125&Status=28")).getData();
/*     */   }
/*     */   
/*     */   public String Y() {
/* 324 */     return c().a(g.c().a("https://www.compras.rj.gov.br/")
/* 325 */         .a("mercatto/aplicacao/asp/pregao/sel_criterios_leilao.asp?ID_Func=125&Status=36")).getData();
/*     */   }
/*     */   
/*     */   public String o(String paramString) {
/* 329 */     return c().a(g.d().a("https://www.compras.rj.gov.br/")
/* 330 */         .a("mercatto/aplicacao/asp/inc/Pesquisa.asp")
/* 331 */         .a("pg_atual", "1")
/* 332 */         .a("id_dv", "div_PesquisaEdital")
/* 333 */         .a("funcao", "PesquisaEdital")
/* 334 */         .a("sql", "1")
/* 335 */         .a("paginacao", "N")
/* 336 */         .a("pesquisa", paramString)
/* 337 */         .a("campo", "EDITAL"))
/* 338 */       .getData();
/*     */   }
/*     */   
/*     */   public String q(String paramString) {
/* 342 */     return c().a(g.d().a("https://www.compras.rj.gov.br/")
/* 343 */         .a("mercatto/aplicacao/asp/pregao/Sel_Criterios_leilao.asp")
/* 344 */         .a("Botao", "")
/* 345 */         .a("funcao", "Consultar+Pregao")
/* 346 */         .a("Bt", "Consultar+Pregao")
/* 347 */         .a("Forum_Pagina", "1")
/* 348 */         .a("Pagina_Anterior", "/mercatto/aplicacao/asp/pregao/lista_edital.asp")
/* 349 */         .a("Pagina_ListaEdital", "OK")
/* 350 */         .a("Anula_Revoga", "")
/* 351 */         .a("Justificativa", "")
/* 352 */         .a("JustCancelar", "")
/* 353 */         .a("Tipo_Cancelamento", "0")
/* 354 */         .a("hdnAcao", "")
/* 355 */         .a("JustSuspender", "")
/* 356 */         .a("JustDiligenciar", "")
/* 357 */         .a("JustRetomar", "")
/* 358 */         .a("Sel_Item", paramString)
/* 359 */         .a("Anexos", "")
/* 360 */         .a("sel_FormaLicit", "0")
/* 361 */         .a("sel_Temporal", "0")
/* 362 */         .a("CCusto", "0")
/* 363 */         .a("modalidade", "")
/* 364 */         .a("lista", "")
/* 365 */         .a("Cb_Status", "")
/* 366 */         .a("Processo", "")
/* 367 */         .a("usu_solic", "")
/* 368 */         .a("Pagina", "/mercatto/aplicacao/asp/pregao/lista_edital.asp")
/* 369 */         .a("DataAbertura", "")
/* 370 */         .a("HoraAbertura", "")
/* 371 */         .a("Data_FimPropostas", "")
/* 372 */         .a("Hora_FimPropostas", "")
/* 373 */         .a("Data_AbertPropostas", "")
/* 374 */         .a("Hora_AbertPropostas", "")
/* 375 */         .a("JustifReabre", ""))
/* 376 */       .getData();
/*     */   }
/*     */   
/*     */   public String Z() {
/* 380 */     return c().a(g.c().a("https://www.compras.rj.gov.br/")
/* 381 */         .a("mercatto/aplicacao/asp/pregao/lista_edital.asp?ID_Func=125")).getData();
/*     */   }
/*     */   
/*     */   public e a(int paramInt, String paramString1, String paramString2, String paramString3) {
/* 385 */     return c().a(g.d().a("https://www.compras.rj.gov.br/")
/* 386 */         .a("mercatto/aplicacao/asp/pregao/lance_leilao_trata_normal.asp")
/* 387 */         .a("Botao", "Lance_Item")
/* 388 */         .a("FormaLicit", "1")
/* 389 */         .a("PermLanceInterm", "S")
/* 390 */         .a("IT_VL_UNIT" + paramInt, paramString1)
/* 391 */         .a("direito_pref_" + paramInt, "")
/* 392 */         .a("vl_infotpaux_" + paramInt, "")
/* 393 */         .a("Item_Sel", Integer.toString(paramInt))
/* 394 */         .a("vl_abertura_" + paramInt, paramString2)
/* 395 */         .a("IT_VL_EQUAL" + paramInt, paramString3));
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
/* 406 */     if (ae() || b.a().a(this)) {
/* 407 */       super.b();
/*     */     }
/*     */   }
/*     */   
/*     */   void bI() {
/* 412 */     c().a(g.c().a("https://www.compras.rj.gov.br/").a("mercatto/aplicacao/asp/seg/logoff.asp"));
/*     */   }
/*     */   
/*     */   int A() {
/* 416 */     return this.d.get();
/*     */   }
/*     */   
/*     */   public void bJ() {
/* 420 */     this.d.incrementAndGet();
/*     */   }
/*     */   
/*     */   public void bK() {
/* 424 */     this.d.decrementAndGet();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean T() {
/* 429 */     return A.a().p(aQ);
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, x paramx) {
/* 434 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, NameValuePair[] paramArrayOfNameValuePair, x paramx) {
/* 439 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\b\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */