/*     */ package br.com.arremate.b.a;
/*     */ 
/*     */ import br.com.arremate.f.j;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.j.g.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.m.c;
/*     */ import br.com.arremate.m.y;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Calendar;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class o
/*     */   extends a
/*     */ {
/*  27 */   private final List<j> f = new ArrayList<>();
/*  28 */   private final List<String> g = new ArrayList<>();
/*     */   
/*     */   public o(a parama) {
/*  31 */     super((i)parama);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<j> a(List<j> paramList) throws Exception {
/*  36 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*  37 */     for (j j : paramList) {
/*  38 */       switch (null.b[j.ordinal()]) {
/*     */         case 1:
/*  40 */           hashMap.put(j, Arrays.asList(new String[] { "18023", "18024" }));
/*     */         
/*     */         case 2:
/*  43 */           hashMap.put(j, Arrays.asList(new String[] { "18025" }));
/*     */         
/*     */         case 3:
/*  46 */           hashMap.put(j, Arrays.asList(new String[] { "18026", "18027", "18028", "18029", "18040", "18055", "18056" }));
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     } 
/*  53 */     if (a().get()) {
/*  54 */       return this.f;
/*     */     }
/*     */     
/*  57 */     String[] arrayOfString = { "2024", "2023" };
/*     */ 
/*     */     
/*  60 */     for (String str : arrayOfString) {
/*  61 */       Map<String, String> map = b(str);
/*     */       
/*  63 */       if (map.isEmpty()) {
/*  64 */         return this.f;
/*     */       }
/*     */       
/*  67 */       for (Map.Entry<Object, Object> entry : hashMap.entrySet()) {
/*  68 */         for (String str1 : entry.getValue()) {
/*  69 */           a((j)entry.getKey(), str1, map);
/*     */         }
/*     */       } 
/*     */       
/*  73 */       map = a(str);
/*     */       
/*  75 */       for (String str1 : this.g) {
/*  76 */         if (a().get()) {
/*  77 */           return this.f;
/*     */         }
/*     */         
/*  80 */         map.put("ctl00$campoPesquisa$sNrProcessoDisplay", str1);
/*     */         
/*  82 */         j j = a(map);
/*  83 */         if (j != null) {
/*  84 */           this.f.add(j);
/*     */         }
/*     */       } 
/*     */       
/*  88 */       this.g.clear();
/*     */     } 
/*     */     
/*  91 */     return this.f;
/*     */   }
/*     */   
/*     */   private void a(j paramj, String paramString, Map<String, String> paramMap) throws Exception {
/*  95 */     byte b = 1; int i = 0;
/*  96 */     paramMap.put("__EVENTTARGET", "");
/*  97 */     paramMap.put("__EVENTARGUMENT", "");
/*  98 */     paramMap.put("ctl00$ddlVisoes", paramString);
/*  99 */     paramMap.put("ctl00$btnPesquisar", "Pesquisar");
/*     */     
/*     */     do {
/* 102 */       if (a().get()) {
/*     */         return;
/*     */       }
/*     */       
/* 106 */       String str = a().b(paramMap);
/* 107 */       Document document = Jsoup.parse(str);
/* 108 */       a(paramMap, document);
/*     */       
/* 110 */       if (str.toLowerCase().contains("nenhum registro encontrado para esta pesquisa")) {
/*     */         return;
/*     */       }
/*     */       
/* 114 */       if (!i) {
/* 115 */         Element element1 = document.select("td[class=navegacao]").first();
/* 116 */         if (element1 != null) {
/* 117 */           String str1 = element1.html().replaceAll("&nbsp;", "");
/* 118 */           String str2 = "página1de";
/*     */           
/* 120 */           if (str1.contains(str2)) {
/* 121 */             int k = str1.indexOf(str2) + str2.length();
/* 122 */             i = Integer.parseInt(str1.substring(k));
/*     */           } 
/*     */         } 
/*     */         
/* 126 */         if (i > 1) {
/* 127 */           paramMap.put("__EVENTTARGET", "ctl00$pesquisaDataGrid$dtgPesquisa");
/* 128 */           paramMap.remove("ctl00$btnPesquisar");
/*     */         } 
/*     */       } 
/*     */       
/* 132 */       Element element = document.select("div[id=ctl00_pesquisaDataGrid_dtgPesquisa_divScroll] > table > tbody").first();
/* 133 */       if (element == null || element.text().isEmpty()) {
/*     */         return;
/*     */       }
/*     */       
/* 137 */       if (!a(element, paramj)) {
/*     */         return;
/*     */       }
/*     */       
/* 141 */       b++;
/* 142 */       paramMap.put("__EVENTARGUMENT", "Page$" + b);
/* 143 */     } while (b <= i);
/*     */   }
/*     */   
/*     */   private boolean a(Element paramElement, j paramj) throws Exception {
/* 147 */     Elements elements = paramElement.select("tr");
/* 148 */     for (Element element1 : elements) {
/* 149 */       if (a().get()) {
/* 150 */         return false;
/*     */       }
/*     */       
/* 153 */       String str1 = element1.select("td:eq(5)").first().text();
/* 154 */       Calendar calendar = y.c(str1);
/* 155 */       if (a(calendar)) {
/* 156 */         return false;
/*     */       }
/*     */       
/* 159 */       Elements elements1 = element1.select("td");
/* 160 */       if (elements1.get(6).toString().contains("ic_compra_deserto.gif") || elements1.get(6).toString().contains("ic_compra_fracassado.gif")) {
/*     */         continue;
/*     */       }
/*     */       
/* 164 */       int i = Integer.parseInt(elements1.get(0).text().trim());
/* 165 */       if (a(i)) {
/*     */         continue;
/*     */       }
/*     */       
/* 169 */       Element element2 = elements1.get(1).select("a").first();
/* 170 */       String str2 = c(element2);
/* 171 */       if (str2.isEmpty()) {
/* 172 */         this.g.add(element2.text());
/*     */         
/*     */         continue;
/*     */       } 
/* 176 */       if (!b(str2)) {
/*     */         continue;
/*     */       }
/*     */       
/* 180 */       j j1 = a(element1, element2, str2, paramj, calendar);
/* 181 */       this.f.add(j1);
/*     */     } 
/*     */     
/* 184 */     return true;
/*     */   }
/*     */   
/*     */   private j a(Element paramElement1, Element paramElement2, String paramString, j paramj, Calendar paramCalendar) {
/* 188 */     Elements elements = paramElement1.select("td");
/*     */     
/* 190 */     int i = Integer.parseInt(elements.get(0).text().trim());
/*     */     
/* 192 */     Element element = elements.get(2).select("span").first();
/* 193 */     String str1 = element.attr("onmouseover").replace("toolTip('','", "").replace("');", "");
/*     */     
/* 195 */     String str2 = paramElement2.text();
/*     */     
/* 197 */     paramString = paramString.substring(paramString.indexOf("?q=") + 3);
/* 198 */     paramString = paramString.substring(0, paramString.indexOf("&"));
/*     */     
/* 200 */     boolean bool = elements.get(6).select("img").attr("title").contains("Gerar registro de preço");
/*     */     
/* 202 */     c c = new c(a().a(), i);
/* 203 */     c.T(str2);
/* 204 */     c.aw(str1);
/* 205 */     c.b(paramCalendar);
/* 206 */     c.a(paramj);
/* 207 */     c.aA(paramString);
/* 208 */     c.s(bool);
/* 209 */     c.z(bool);
/* 210 */     c.a(m.e);
/* 211 */     c.a(elements.html().contains("Por lote") ? u.b : u.a);
/* 212 */     return (j)c;
/*     */   }
/*     */   
/*     */   private String c(Element paramElement) {
/* 216 */     String str = paramElement.attr("onclick");
/* 217 */     int i = str.indexOf("PregaoEletronicoValidacaoParticipacao");
/* 218 */     if (i < 0) {
/* 219 */       return "";
/*     */     }
/*     */     
/* 222 */     str = str.substring(str.indexOf("PregaoEletronicoValidacaoParticipacao")).replace("'", "").trim();
/* 223 */     return str;
/*     */   }
/*     */   
/*     */   private Map<String, String> a(String paramString) {
/* 227 */     Map<String, String> map = b(paramString);
/* 228 */     map.put("ctl00$ddlVisoes", "18039");
/* 229 */     return map;
/*     */   }
/*     */   
/*     */   private j a(Map<String, String> paramMap) {
/* 233 */     String str = a().b(paramMap);
/* 234 */     if (str.isEmpty()) {
/* 235 */       return null;
/*     */     }
/*     */     
/* 238 */     Document document = Jsoup.parse(str);
/* 239 */     Element element = document.select("div[id=ctl00_pesquisaDataGrid_dtgPesquisa_divScroll] > table > tbody").first();
/* 240 */     if (element == null || element.text().isEmpty() || str.contains("Nenhum registro encontrado para esta pesquisa")) {
/* 241 */       return null;
/*     */     }
/*     */     
/* 244 */     Elements elements = element.select("tr");
/* 245 */     for (Element element1 : elements) {
/* 246 */       String str1 = element1.select("td:eq(5)").first().text();
/* 247 */       Calendar calendar = y.c(str1);
/*     */       
/* 249 */       Elements elements1 = element1.select("td");
/*     */       
/* 251 */       int i = Integer.parseInt(elements1.get(0).text().trim());
/* 252 */       if (a(i)) {
/*     */         continue;
/*     */       }
/*     */       
/* 256 */       Element element2 = elements1.get(1).select("a").first();
/* 257 */       String str2 = a(element2, str);
/* 258 */       if (str2.isEmpty() || !b(str2)) {
/*     */         continue;
/*     */       }
/*     */       
/* 262 */       j j = j.d;
/* 263 */       String str3 = elements1.get(7).select("span:eq(1) > img").attr("title").toLowerCase();
/* 264 */       if (str3.contains("em disputa")) {
/* 265 */         j = j.a;
/* 266 */       } else if (str3.contains("homologado") || str3.contains("homologação") || str3.contains("habilitação") || str3.contains("encerra") || str3
/* 267 */         .contains("recurso") || str3.contains("adjudicação") || str3.contains("julgamento") || str3.contains("ajuste de preços")) {
/* 268 */         j = j.g;
/* 269 */       } else if (str3.contains("suspenso")) {
/* 270 */         j = j.c;
/*     */       } 
/*     */       
/* 273 */       return a(element1, element2, str2, j, calendar);
/*     */     } 
/*     */     
/* 276 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected List<j> a(String paramString) throws Exception {
/* 281 */     if (paramString.contains("/")) {
/* 282 */       paramString = paramString.replace("/", ".");
/*     */     }
/*     */     
/* 285 */     ArrayList<j> arrayList = new ArrayList();
/* 286 */     String[] arrayOfString = { "2024", "2023" };
/*     */     
/* 288 */     for (String str : arrayOfString) {
/* 289 */       Map<String, String> map = a(str);
/* 290 */       map.put("ctl00$campoPesquisa$sNrProcessoDisplay", paramString.trim());
/*     */       
/* 292 */       j j = a(map);
/*     */ 
/*     */       
/* 295 */       if (j != null) {
/* 296 */         arrayList.add(j);
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 301 */     if (arrayList.isEmpty()) {
/* 302 */       f("No portal não foram encontrados pregões com o número inserido!\nPor favor revise o número digitado no campo e tente novamente!");
/*     */     }
/*     */ 
/*     */     
/* 306 */     return arrayList;
/*     */   }
/*     */   
/*     */   private String a(Element paramElement, String paramString) {
/* 310 */     String str = c(paramElement);
/* 311 */     if (str.isEmpty()) {
/* 312 */       int i = paramString.indexOf("redirecionar.setAttribute(\"onclick\", \"javascript: window.location.href = 'PregaoEletronicoValidacaoParticipacao.aspx?");
/* 313 */       if (i < 0) {
/* 314 */         return "";
/*     */       }
/*     */       
/* 317 */       paramString = paramString.substring(i);
/* 318 */       str = paramString.substring(paramString.indexOf("q="), paramString.indexOf("=='"));
/*     */     } 
/*     */     
/* 321 */     return str;
/*     */   }
/*     */   
/*     */   private boolean b(String paramString) {
/* 325 */     String str = a().E(paramString);
/* 326 */     Document document = Jsoup.parse(str);
/* 327 */     return !document.html().contains("DETALHES DO PROCESSO");
/*     */   }
/*     */   
/*     */   private Map<String, String> b(String paramString) {
/* 331 */     String str = a().ak();
/* 332 */     if (str == null || str.isEmpty()) {
/* 333 */       return new HashMap<>();
/*     */     }
/*     */     
/* 336 */     Document document = Jsoup.parse(str);
/* 337 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 338 */     hashMap.put("__EVENTTARGET", "ctl00$pesquisaDataGrid$dtgPesquisa");
/* 339 */     hashMap.put("__EVENTARGUMENT", "Sort$tDtFinalProposta");
/* 340 */     hashMap.put("__VIEWSTATE", document.select("input[id=__VIEWSTATE]").first().val());
/* 341 */     hashMap.put("__VIEWSTATEGENERATOR", document.select("input[id=__VIEWSTATEGENERATOR]").first().val());
/* 342 */     hashMap.put("__VIEWSTATEENCRYPTED", "");
/* 343 */     hashMap.put("__EVENTVALIDATION", document.select("input[id=__EVENTVALIDATION]").first().val());
/* 344 */     hashMap.put("ctl00$hidsDsPesquisaAvancada", "");
/* 345 */     hashMap.put("ctl00$hidXmlDados", "");
/* 346 */     hashMap.put("ctl00$hidInterface", "");
/* 347 */     hashMap.put("ctl00$hidVisao", "");
/* 348 */     hashMap.put("ctl00$hidTag", "");
/* 349 */     hashMap.put("ctl00$hidFiltro", "");
/* 350 */     hashMap.put("ctl00$hidDataSourceWebService", "");
/* 351 */     hashMap.put("ctl00$hidUrlWebServiceDataSource", "");
/* 352 */     hashMap.put("ctl00$bMostrarCriterio", "0");
/* 353 */     hashMap.put("ctl00$oBuscaAvancada$hidsAbaPesquisaAvancada", "false");
/* 354 */     hashMap.put("ctl00$oBuscaAvancada$ddlCampo", "decimal:COTACAO_x_nCdFornecedor");
/* 355 */     hashMap.put("ctl00$oBuscaAvancada$ddlOperador", "=");
/* 356 */     hashMap.put("sValorCOTACAO_x_nCdFornecedor", "");
/* 357 */     hashMap.put("hidDesc_sValorCOTACAO_x_nCdFornecedor", "");
/* 358 */     hashMap.put("ctl00$oBuscaAvancada$ddlEOu", "AND");
/* 359 */     hashMap.put("ctl00$campoPesquisa$sNrProcessoDisplay", "");
/* 360 */     hashMap.put("ctl00$btnPesquisar", "Pesquisar");
/* 361 */     hashMap.put("ctl00$ddlVisoes", "18009");
/* 362 */     hashMap.put("ctl00$OutrosFiltros$nCdUnidadeCompradora", "UC.nCdEmpresa");
/* 363 */     hashMap.put("ctl00$OutrosFiltros$ddlRegistroPreco", "3");
/* 364 */     hashMap.put("ctl00$OutrosFiltros$ddlSituacaoRegistroPreco", "1");
/* 365 */     hashMap.put("ctl00$OutrosFiltros$ddlModalidadeLicitacao", "2");
/* 366 */     hashMap.put("ctl00$OutrosFiltros$sDsObjeto", "");
/* 367 */     hashMap.put("ctl00$OutrosFiltros$ddlAno", paramString);
/* 368 */     hashMap.put("ctl00$OutrosFiltros$dataInicio", "01/01/" + paramString);
/* 369 */     hashMap.put("ctl00$OutrosFiltros$dtbDataInicio", "01/01/" + paramString);
/* 370 */     hashMap.put("ctl00$OutrosFiltros$dataFim", "31/12/" + paramString);
/* 371 */     hashMap.put("ctl00$OutrosFiltros$dtbDataFim", "31/12/" + paramString);
/* 372 */     hashMap.put("ctl00$pesquisaDataGrid$hidCaminho", "");
/* 373 */     hashMap.put("ctl00$pesquisaDataGrid$hidCdPregao", "");
/* 374 */     hashMap.put("ctl00$pesquisaDataGrid$hidIdSuperSimples", "");
/*     */     
/* 376 */     str = a().b(hashMap);
/* 377 */     if (str.isEmpty()) {
/* 378 */       return new HashMap<>();
/*     */     }
/* 380 */     document = Jsoup.parse(str);
/* 381 */     a((Map)hashMap, document);
/* 382 */     hashMap.put("__EVENTTARGET", "");
/* 383 */     hashMap.put("__EVENTARGUMENT", "");
/*     */     
/* 385 */     return (Map)hashMap;
/*     */   }
/*     */   
/*     */   private void a(Map<String, String> paramMap, Document paramDocument) {
/* 389 */     paramMap.put("__VIEWSTATE", paramDocument.select("input[id=__VIEWSTATE]").first().val());
/* 390 */     paramMap.put("__VIEWSTATEGENERATOR", paramDocument.select("input[id=__VIEWSTATEGENERATOR]").first().val());
/* 391 */     paramMap.put("__EVENTVALIDATION", paramDocument.select("input[id=__EVENTVALIDATION]").first().val());
/*     */   }
/*     */ 
/*     */   
/*     */   public a a() {
/* 396 */     return (a)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\b\a\o.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */