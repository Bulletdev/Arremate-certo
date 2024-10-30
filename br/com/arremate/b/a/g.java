/*     */ package br.com.arremate.b.a;
/*     */ 
/*     */ import br.com.arremate.f.j;
/*     */ import br.com.arremate.f.l;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.j.h.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.f.b;
/*     */ import br.com.arremate.l.j;
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
/*     */ import org.jsoup.nodes.TextNode;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ public class g
/*     */   extends a
/*     */ {
/*     */   public g(a parama) {
/*  29 */     super((i)parama);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<j> a(List<j> paramList) throws Exception {
/*  34 */     ArrayList<j> arrayList = new ArrayList();
/*  35 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*  36 */     for (j j : paramList) {
/*  37 */       switch (null.b[j.ordinal()]) {
/*     */         case 1:
/*  39 */           hashMap.put(j, Arrays.asList(new String[] { "Avaliação de Propostas", "Fechado", "Suspenso - Antes da Abertura" }));
/*     */         
/*     */         case 2:
/*  42 */           hashMap.put(j, Arrays.asList(new String[] { "Aberto" }));
/*     */         
/*     */         case 3:
/*  45 */           hashMap.put(j, Arrays.asList(new String[] { "Processo Finalizado", "Encaminhado para adjudicação/homologação", "Processo Deserto/Fracassado", "Cancelado" }));
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     } 
/*  52 */     int i = 0; byte b = 1;
/*     */     do {
/*  54 */       if (a().get()) {
/*  55 */         return arrayList;
/*     */       }
/*     */       
/*  58 */       String str = a().i(b);
/*  59 */       if (str == null || str.isEmpty()) {
/*     */         continue;
/*     */       }
/*     */       
/*  63 */       Document document = Jsoup.parse(str);
/*  64 */       if (!a(document, (Map)hashMap, arrayList)) {
/*     */         break;
/*     */       }
/*     */       
/*  68 */       if (!i) {
/*  69 */         Element element = document.select("p.resultCounter").first();
/*  70 */         int j = Integer.parseInt(element.text().replaceAll("\\D", ""));
/*  71 */         i = y.a(j, 10);
/*     */       } 
/*     */       
/*  74 */       b++;
/*  75 */     } while (b <= i);
/*     */     
/*  77 */     return arrayList;
/*     */   }
/*     */   
/*     */   private boolean a(Document paramDocument, Map<j, List<String>> paramMap, List<j> paramList) throws Exception {
/*  81 */     Elements elements = paramDocument.select("table[id=searchTableSorter] > tbody > tr");
/*  82 */     for (Element element1 : elements) {
/*  83 */       if (a().get()) {
/*  84 */         return false;
/*     */       }
/*     */       
/*  87 */       Elements elements1 = element1.select("td");
/*     */       
/*  89 */       j j = null;
/*  90 */       String str1 = elements1.get(5).select("img").attr("alt").trim();
/*  91 */       for (Map.Entry<j, List<String>> entry : paramMap.entrySet()) {
/*  92 */         if (((List)entry.getValue()).contains(str1)) {
/*  93 */           j = (j)entry.getKey();
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*  98 */       if (j == null) {
/*     */         continue;
/*     */       }
/*     */       
/* 102 */       Calendar calendar = a(element1);
/* 103 */       if (a(calendar)) {
/* 104 */         return false;
/*     */       }
/*     */       
/* 107 */       Element element2 = a(elements1);
/* 108 */       if (element2 == null) {
/*     */         continue;
/*     */       }
/*     */       
/* 112 */       String str2 = element2.text();
/*     */       
/* 114 */       String str3 = a(element2, elements1);
/* 115 */       if (str3 == null || a(str3)) {
/*     */         continue;
/*     */       }
/*     */       
/* 119 */       String str4 = a().j(Integer.parseInt(str3));
/*     */       
/* 121 */       if (str2.isEmpty()) {
/* 122 */         str2 = element2.attr("title");
/*     */       }
/*     */       
/* 125 */       String str5 = b(element1);
/*     */       
/* 127 */       boolean bool = a(element1);
/*     */       
/* 129 */       j j1 = a(bool, j, str2, calendar, str3, str5, str4);
/* 130 */       paramList.add(j1);
/*     */     } 
/*     */     
/* 133 */     return true;
/*     */   }
/*     */   
/*     */   private Calendar a(Element paramElement) {
/* 137 */     Element element = paramElement.select("td[class=td110] > span").first();
/* 138 */     return y.c(element.text());
/*     */   }
/*     */ 
/*     */   
/*     */   private String b(Element paramElement) {
/*     */     String str;
/* 144 */     Element element = paramElement.select("td[class=td80] > *").first();
/* 145 */     if (element.nodeName().equals("span")) {
/* 146 */       str = element.text();
/*     */     } else {
/* 148 */       str = element.attr("title");
/*     */     } 
/*     */     
/* 151 */     return str.replaceAll("[^\\d/]", "").replace("//", "/");
/*     */   }
/*     */   
/*     */   private String a(Element paramElement, Elements paramElements) {
/* 155 */     String str1 = paramElement.attr("href");
/* 156 */     String str2 = str1.replaceAll("#", "").replaceAll("\\D", "");
/* 157 */     if (str1.isEmpty()) {
/* 158 */       str1 = paramElements.select("a[href*=ttCD_CHAVE=]").first().attr("href");
/* 159 */       if (str1.isEmpty()) {
/* 160 */         return null;
/*     */       }
/* 162 */       if (str1.indexOf("&") > 0) {
/* 163 */         str2 = str1.substring(str1.indexOf("CHAVE=") + 6, str1.indexOf("&"));
/*     */       } else {
/* 165 */         str2 = str1.substring(str1.indexOf("CHAVE=") + 6);
/*     */       } 
/*     */     } 
/*     */     
/* 169 */     return str2;
/*     */   }
/*     */   
/*     */   private Element a(Elements paramElements) {
/* 173 */     Element element = paramElements.select("a[href^=#unidadeTexto]").first();
/* 174 */     if (element == null) {
/* 175 */       element = paramElements.select("a[href^=#numeroTexto]").first();
/* 176 */       if (element == null) {
/* 177 */         element = paramElements.select("a[href^=#objetoTexto]").first();
/* 178 */         if (element == null) {
/* 179 */           element = paramElements.select("td.td150").first();
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 184 */     return element;
/*     */   }
/*     */   
/*     */   private l a(Elements paramElements) {
/* 188 */     Element element = paramElements.select("p:contains(Modalidade)").first();
/*     */     
/* 190 */     if (element != null && element.text().contains("Dispensa Eletrônica")) {
/* 191 */       return l.c;
/*     */     }
/*     */     
/* 194 */     if (element != null && element.text().contains("Concorrência")) {
/* 195 */       return l.k;
/*     */     }
/*     */     
/* 198 */     return l.a;
/*     */   }
/*     */ 
/*     */   
/*     */   protected List<j> a(String paramString) throws Exception {
/* 203 */     ArrayList<j> arrayList = new ArrayList();
/*     */ 
/*     */     
/* 206 */     if (paramString.matches("^\\d+$")) {
/* 207 */       j j = a(paramString);
/* 208 */       if (j != null) {
/* 209 */         arrayList.add(j);
/*     */       }
/*     */     } 
/*     */     
/* 213 */     List<Element> list = b(paramString);
/* 214 */     if (list != null) {
/* 215 */       for (Element element1 : list) {
/* 216 */         Elements elements = element1.select("td");
/* 217 */         Element element2 = a(elements);
/* 218 */         String str = a(element2, elements);
/* 219 */         j j = a(str);
/* 220 */         if (j != null && 
/* 221 */           j.bo().contains(paramString)) {
/* 222 */           arrayList.add(j);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 228 */     if (!arrayList.isEmpty() && !j().isEmpty()) {
/* 229 */       f("");
/*     */     }
/*     */     
/* 232 */     return arrayList;
/*     */   }
/*     */   
/*     */   private List<Element> b(String paramString) {
/* 236 */     paramString = paramString.trim();
/* 237 */     ArrayList<Element> arrayList = new ArrayList();
/*     */     
/* 239 */     int i = 0; byte b = 1;
/*     */     do {
/* 241 */       String str = a().d(paramString, b);
/* 242 */       if (str == null || str.isEmpty()) {
/* 243 */         return null;
/*     */       }
/*     */       
/* 246 */       if (str.contains("Sem Registros")) {
/* 247 */         f("Não foi possível localizar este pregão no portal! Por favor revise o número inserido na pesquisa e tente novamente!");
/* 248 */         return null;
/*     */       } 
/*     */       
/* 251 */       Document document = Jsoup.parse(str);
/*     */       
/* 253 */       Elements elements = document.select("table[id=searchTableSorter] > tbody > tr");
/* 254 */       for (Element element1 : elements) {
/* 255 */         arrayList.add(element1);
/*     */       }
/*     */       
/* 258 */       if (i)
/* 259 */         continue;  Element element = document.select("p.resultCounter").first();
/* 260 */       int j = Integer.parseInt(element.text().replaceAll("\\D", ""));
/* 261 */       i = y.a(j, 10);
/*     */ 
/*     */       
/* 264 */       ++b;
/* 265 */     } while (b <= i);
/*     */     
/* 267 */     return arrayList;
/*     */   }
/*     */   
/*     */   private j b(String paramString) {
/* 271 */     j j = j.d;
/* 272 */     if (paramString.contains("Aberto")) {
/* 273 */       j = j.a;
/* 274 */     } else if (paramString.contains("Processo Finalizado") || paramString.contains("homologação") || paramString
/* 275 */       .contains("Encaminhado para adjudicação/homologação") || paramString.contains("Cancelado") || paramString
/* 276 */       .contains("Processo Deserto/Fracassado") || paramString.contains("Encerrado para Operação")) {
/* 277 */       j = j.g;
/* 278 */     } else if (paramString.contains("Suspenso")) {
/* 279 */       j = j.c;
/*     */     } 
/*     */     
/* 282 */     return j;
/*     */   }
/*     */   
/*     */   private boolean a(Element paramElement) {
/* 286 */     Element element = paramElement.select("td[class=td60] > span > a").first();
/* 287 */     return element.text().equals("SRP");
/*     */   }
/*     */ 
/*     */   
/*     */   private j a(String paramString) throws Exception {
/* 292 */     if (a(paramString)) {
/* 293 */       f("Esta licitação já está cadastrada no sistema para a empresa selecionada!");
/* 294 */       return null;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 299 */     String str1 = a().j(Integer.parseInt(paramString));
/* 300 */     if (str1 == null || str1.isEmpty()) {
/* 301 */       return null;
/*     */     }
/* 303 */     if (!str1.contains("Dados do Processo")) {
/* 304 */       f("Não foi possível localizar este pregão no portal! Por favor revise o código inserido na pesquisa e tente novamente!");
/* 305 */       return null;
/*     */     } 
/* 307 */     Document document = Jsoup.parse(str1);
/*     */     
/* 309 */     Element element = document.select("div[class=dataInnerBlock1]").first();
/* 310 */     Elements elements = element.select("p");
/*     */     
/* 312 */     String str2 = "";
/* 313 */     String str3 = "";
/* 314 */     Calendar calendar = null;
/* 315 */     String str4 = "";
/* 316 */     boolean bool = false;
/*     */     
/* 318 */     for (Element element1 : elements) {
/* 319 */       String str = element1.text();
/* 320 */       if (str.contains("Número:")) {
/* 321 */         str2 = str.replaceAll("[^\\d/]", "").trim();
/*     */         continue;
/*     */       } 
/* 324 */       if (str.contains("Situação:")) {
/* 325 */         str3 = str.substring(9).trim();
/*     */         continue;
/*     */       } 
/* 328 */       if (str.contains("Abertura das Propostas:")) {
/* 329 */         calendar = y.c(str.substring(23).trim());
/*     */         continue;
/*     */       } 
/* 332 */       if (str.contains("Órgão:")) {
/* 333 */         str4 = str.substring(6).trim();
/*     */         continue;
/*     */       } 
/* 336 */       if (str.contains("Modalidade:")) {
/* 337 */         bool = str.contains("Sistema de Registro de Preços");
/*     */       }
/*     */     } 
/*     */     
/* 341 */     j j = b(str3);
/*     */     
/* 343 */     return a(bool, j, str4, calendar, paramString, str2, str1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private j a(boolean paramBoolean, j paramj, String paramString1, Calendar paramCalendar, String paramString2, String paramString3, String paramString4) throws Exception {
/* 351 */     boolean bool = true;
/* 352 */     u u = u.a;
/* 353 */     m m = m.e;
/* 354 */     l l = l.a;
/* 355 */     int i = 0;
/*     */     
/* 357 */     if (paramString4 != null && !paramString4.isEmpty()) {
/* 358 */       Document document = Jsoup.parse(paramString4);
/*     */       
/* 360 */       Elements elements = document.select("div[class=dataInnerBlock1] > p");
/*     */       
/* 362 */       if (!elements.select("p:contains(Pregão por Maior Desconto Eletrônico)").isEmpty() || 
/* 363 */         !elements.select("p:contains(Concorrência por Maior Desconto)").isEmpty()) {
/* 364 */         u = u.d;
/* 365 */       } else if (!elements.select("p:contains(Concorrência por Técnica e Preço)").isEmpty()) {
/* 366 */         u = u.l;
/* 367 */       } else if (!elements.select("p:contains(Concorrência por Técnica)").isEmpty()) {
/* 368 */         u = u.k;
/*     */       } else {
/* 370 */         Element element = elements.select("p:contains(Modo de Disputa do Lote)").first();
/* 371 */         if (element != null) {
/* 372 */           u = u.b;
/*     */           
/* 374 */           if (element.text().contains("Por Valor Global")) {
/* 375 */             bool = false;
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 380 */       l = a(elements);
/*     */       
/* 382 */       i = a(elements);
/* 383 */       m = a(paramString2, elements);
/*     */       
/* 385 */       if (paramString1.contains("...")) {
/* 386 */         paramString1 = ((TextNode)document.select("b:containsOwn(Órgão:)").first().parent().textNodes().get(0)).text();
/*     */       }
/*     */     } 
/*     */     
/* 390 */     b b = new b(a().a(), Integer.parseInt(paramString2));
/* 391 */     b.T(paramString3);
/* 392 */     b.aw(paramString1);
/* 393 */     b.s(paramBoolean);
/* 394 */     b.z(bool);
/* 395 */     b.a(u);
/* 396 */     b.b(paramCalendar);
/* 397 */     b.a(paramj);
/* 398 */     b.a(m);
/* 399 */     b.Y(i);
/* 400 */     b.a(l);
/* 401 */     return (j)b;
/*     */   }
/*     */   
/*     */   private int a(Elements paramElements) {
/* 405 */     Element element = paramElements.select("p:contains(Casas Decimais)").first();
/*     */     
/* 407 */     if (element != null) {
/* 408 */       String str = element.text();
/*     */       
/* 410 */       if (str.contains("Duas Casas"))
/* 411 */         return 2; 
/* 412 */       if (str.contains("Três Casas")) {
/* 413 */         return 3;
/*     */       }
/*     */     } 
/*     */     
/* 417 */     return 0;
/*     */   }
/*     */   
/*     */   private m a(String paramString, Elements paramElements) {
/* 421 */     Element element = paramElements.select("p:contains(Modo de Disputa:)").first();
/*     */     
/* 423 */     if (element != null) {
/* 424 */       return element.text().contains("Aberto e Fechado") ? m.c : m.b;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 429 */     element = paramElements.select("p:contains(Legislação Aplicada:)").first();
/*     */     
/* 431 */     if (element != null && element.text().contains("Decreto nº 5.450, de 31 de maio de 2005 - Pregão Eletrônico")) {
/* 432 */       return m.a;
/*     */     }
/*     */     
/* 435 */     String str1 = a().A(paramString).getData();
/* 436 */     Document document = Jsoup.parse(str1);
/* 437 */     String str2 = document.select("p:contains(Modo de Disputa:)").text();
/*     */     
/* 439 */     if (str2.contains("Aberto e Fechado"))
/* 440 */       return m.c; 
/* 441 */     if (str2.contains("Tempo de iminência")) {
/* 442 */       return m.a;
/*     */     }
/* 444 */     return m.b;
/*     */   }
/*     */ 
/*     */   
/*     */   public a a() {
/* 449 */     return (a)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\b\a\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */