/*     */ package br.com.arremate.b.a;
/*     */ 
/*     */ import br.com.arremate.f.j;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.j.j;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.m.b;
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
/*     */ public class f
/*     */   extends a
/*     */ {
/*     */   public f(j paramj) {
/*  28 */     super((i)paramj);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<j> a(List<j> paramList) throws Exception {
/*  33 */     ArrayList<j> arrayList = new ArrayList();
/*  34 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*  35 */     for (j j : paramList) {
/*  36 */       switch (null.b[j.ordinal()]) {
/*     */         case 1:
/*  38 */           hashMap.put(j, Arrays.asList(new String[] { "18023", "18024" }));
/*     */         
/*     */         case 2:
/*  41 */           hashMap.put(j, Arrays.asList(new String[] { "18025" }));
/*     */         
/*     */         case 3:
/*  44 */           hashMap.put(j, Arrays.asList(new String[] { "18026", "18027", "18028", "18029", "18040", "18055", "18056" }));
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     } 
/*  51 */     List<String> list = b();
/*  52 */     if (list.isEmpty()) {
/*  53 */       return arrayList;
/*     */     }
/*     */     
/*  56 */     for (Map.Entry<Object, Object> entry : hashMap.entrySet()) {
/*  57 */       for (String str : entry.getValue()) {
/*  58 */         a(arrayList, (j)entry.getKey(), str, list);
/*  59 */         if (a().get()) {
/*  60 */           return arrayList;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  65 */     return arrayList;
/*     */   }
/*     */   
/*     */   private void a(List<j> paramList, j paramj, String paramString, List<String> paramList1) throws Exception {
/*  69 */     byte b = 1; int i = 0;
/*  70 */     paramList1.set(0, "ctl00$ddlVisoes");
/*  71 */     paramList1.set(1, "");
/*  72 */     paramList1.set(18, paramString);
/*     */     
/*     */     do {
/*  75 */       if (a().get()) {
/*     */         return;
/*     */       }
/*     */       
/*  79 */       String str = a().a(paramList1);
/*  80 */       Document document = Jsoup.parse(str);
/*  81 */       if (!i) {
/*  82 */         if (str.toLowerCase().contains("nenhum registro encontrado para esta pesquisa")) {
/*     */           return;
/*     */         }
/*     */         
/*  86 */         Element element1 = document.select("td[class=navegacao]").first();
/*  87 */         if (element1 != null) {
/*  88 */           String str1 = element1.html().replaceAll("&nbsp;", "");
/*  89 */           String str2 = "página1de";
/*     */           
/*  91 */           if (str1.contains(str2)) {
/*  92 */             int k = str1.indexOf(str2) + str2.length();
/*  93 */             i = Integer.parseInt(str1.substring(k));
/*     */           } 
/*     */         } 
/*     */         
/*  97 */         if (i > 1) {
/*  98 */           paramList1.set(0, "ctl00$pesquisaDataGrid$dtgPesquisa");
/*     */         }
/*     */       } 
/*     */       
/* 102 */       Element element = document.select("div[id=ctl00_pesquisaDataGrid_dtgPesquisa_divScroll] > table > tbody").first();
/* 103 */       if (element == null || element.text().isEmpty()) {
/*     */         return;
/*     */       }
/*     */       
/* 107 */       if (!a(paramList, element, paramj)) {
/*     */         return;
/*     */       }
/*     */       
/* 111 */       b++;
/* 112 */       paramList1.set(1, "Page$" + b);
/* 113 */     } while (b <= i);
/*     */   }
/*     */   
/*     */   private boolean a(List<j> paramList, Element paramElement, j paramj) throws Exception {
/* 117 */     Elements elements = paramElement.select("tr");
/* 118 */     for (Element element1 : elements) {
/* 119 */       if (a().get()) {
/* 120 */         return false;
/*     */       }
/*     */       
/* 123 */       String str1 = element1.select("td:eq(5)").first().text();
/* 124 */       Calendar calendar = y.c(str1);
/* 125 */       if (a(calendar)) {
/* 126 */         return false;
/*     */       }
/*     */       
/* 129 */       Elements elements1 = element1.select("td");
/* 130 */       if (elements1.get(6).toString().contains("ic_compra_deserto.gif") || elements1.get(6).toString().contains("ic_compra_fracassado.gif")) {
/*     */         continue;
/*     */       }
/*     */       
/* 134 */       int i = Integer.parseInt(elements1.get(0).text().trim());
/* 135 */       if (a(i)) {
/*     */         continue;
/*     */       }
/*     */       
/* 139 */       Element element2 = elements1.get(1).select("a").first();
/* 140 */       String str2 = a(element2);
/* 141 */       if (!b(str2)) {
/*     */         continue;
/*     */       }
/*     */       
/* 145 */       j j1 = a(element1, element2, str2, paramj, calendar);
/* 146 */       paramList.add(j1);
/*     */     } 
/*     */     
/* 149 */     return true;
/*     */   }
/*     */   
/*     */   protected j a(Element paramElement1, Element paramElement2, String paramString, j paramj, Calendar paramCalendar) {
/* 153 */     Elements elements = paramElement1.select("td");
/*     */     
/* 155 */     int i = Integer.parseInt(elements.get(0).text().trim());
/*     */     
/* 157 */     Element element = elements.get(2).select("span").first();
/* 158 */     String str1 = element.attr("onmouseover").replace("toolTip('','", "").replace("');", "");
/*     */     
/* 160 */     String str2 = paramElement2.text();
/*     */     
/* 162 */     paramString = paramString.substring(paramString.indexOf("?q=") + 3);
/* 163 */     paramString = paramString.substring(0, paramString.indexOf("&"));
/*     */     
/* 165 */     boolean bool = elements.get(6).select("img").attr("title").contains("Gerar registro de preço");
/*     */     
/* 167 */     b b = new b(a().a(), i);
/* 168 */     b.T(str2);
/* 169 */     b.aw(str1);
/* 170 */     b.b(paramCalendar);
/* 171 */     b.a(paramj);
/* 172 */     b.aA(paramString);
/* 173 */     b.s(bool);
/* 174 */     b.z(bool);
/* 175 */     b.a(m.e);
/* 176 */     b.a(elements.html().contains("Por lote") ? u.b : u.a);
/* 177 */     return (j)b;
/*     */   }
/*     */ 
/*     */   
/*     */   protected List<j> a(String paramString) throws Exception {
/* 182 */     List<String> list = b();
/* 183 */     list.set(17, paramString.trim());
/*     */     
/* 185 */     String str = a().a(list);
/* 186 */     if (str.isEmpty() || str.equals("")) {
/* 187 */       return null;
/*     */     }
/*     */     
/* 190 */     Document document = Jsoup.parse(str);
/*     */     
/* 192 */     Element element = document.select("div[id=ctl00_pesquisaDataGrid_dtgPesquisa_divScroll] > table > tbody").first();
/* 193 */     if (element == null || element.text().isEmpty() || str.contains("Nenhum registro encontrado para esta pesquisa")) {
/* 194 */       f("No portal não foram encontrados pregões com o número inserido!\nPor favor revise o número digitado no campo e tente novamente!");
/*     */       
/* 196 */       return null;
/*     */     } 
/*     */     
/* 199 */     j j = null;
/*     */     
/* 201 */     Elements elements = element.select("tr");
/* 202 */     for (Element element1 : elements) {
/* 203 */       String str1 = element1.select("td:eq(5)").first().text();
/* 204 */       Calendar calendar = y.c(str1);
/*     */       
/* 206 */       Elements elements1 = element1.select("td");
/*     */       
/* 208 */       int i = Integer.parseInt(elements1.get(0).text().trim());
/* 209 */       if (a(i)) {
/*     */         continue;
/*     */       }
/*     */       
/* 213 */       Element element2 = elements1.get(1).select("a").first();
/* 214 */       String str2 = a(element2);
/* 215 */       if (!b(str2)) {
/*     */         continue;
/*     */       }
/*     */       
/* 219 */       j j1 = j.d;
/* 220 */       String str3 = elements1.get(7).select("span:eq(1) > img").attr("title").toLowerCase();
/* 221 */       if (str3.contains("em disputa")) {
/* 222 */         j1 = j.a;
/* 223 */       } else if (str3.contains("homologado") || str3.contains("homologação") || str3.contains("habilitação") || str3.contains("encerra") || str3
/* 224 */         .contains("recurso") || str3.contains("adjudicação") || str3.contains("julgamento") || str3.contains("ajuste de preços")) {
/* 225 */         j1 = j.g;
/* 226 */       } else if (str3.contains("suspenso")) {
/* 227 */         j1 = j.c;
/*     */       } 
/*     */       
/* 230 */       j = a(element1, element2, str2, j1, calendar);
/*     */     } 
/*     */     
/* 233 */     if (j == null) {
/* 234 */       f("No portal consta que você não está cadastrado como participante no pregão em questão!");
/* 235 */       return null;
/*     */     } 
/*     */     
/* 238 */     ArrayList<j> arrayList = new ArrayList();
/* 239 */     arrayList.add(j);
/*     */     
/* 241 */     return arrayList;
/*     */   }
/*     */   
/*     */   protected String a(Element paramElement) {
/* 245 */     String str = paramElement.attr("onclick");
/* 246 */     str = str.substring(str.indexOf("PregaoEletronicoValidacaoParticipacao")).replace("'", "").trim();
/* 247 */     return str;
/*     */   }
/*     */   
/*     */   protected boolean b(String paramString) {
/* 251 */     String str = a().E(paramString);
/* 252 */     Document document = Jsoup.parse(str);
/* 253 */     return !document.html().contains("DETALHES DO PROCESSO");
/*     */   }
/*     */   
/*     */   private List<String> b() {
/* 257 */     String str = a().ak();
/* 258 */     if (str == null || str.isEmpty()) {
/* 259 */       return new ArrayList<>();
/*     */     }
/*     */     
/* 262 */     Document document = Jsoup.parse(str);
/* 263 */     ArrayList<String> arrayList = new ArrayList();
/* 264 */     arrayList.add("ctl00$pesquisaDataGrid$dtgPesquisa");
/* 265 */     arrayList.add("Sort$tDtFinalProposta");
/* 266 */     arrayList.add("");
/* 267 */     arrayList.add(document.select("input[id=__VIEWSTATE]").first().val());
/* 268 */     arrayList.add(document.select("input[id=__VIEWSTATEGENERATOR]").first().val());
/* 269 */     arrayList.add("");
/* 270 */     arrayList.add(document.select("input[id=__EVENTVALIDATION]").first().val());
/* 271 */     arrayList.add("");
/* 272 */     arrayList.add("");
/* 273 */     arrayList.add("");
/* 274 */     arrayList.add("");
/* 275 */     arrayList.add("");
/* 276 */     arrayList.add("");
/* 277 */     arrayList.add("");
/* 278 */     arrayList.add("");
/* 279 */     arrayList.add("0");
/* 280 */     arrayList.add("false");
/* 281 */     arrayList.add("");
/* 282 */     arrayList.add("18039");
/* 283 */     arrayList.add("UC.nCdEmpresa");
/* 284 */     arrayList.add("");
/* 285 */     arrayList.add("");
/* 286 */     arrayList.add("");
/*     */     
/* 288 */     str = a().a(arrayList);
/* 289 */     if (str == null || str.isEmpty()) {
/* 290 */       return new ArrayList<>();
/*     */     }
/* 292 */     document = Jsoup.parse(str);
/* 293 */     arrayList.set(3, document.select("input[id=__VIEWSTATE]").first().val());
/* 294 */     arrayList.set(4, document.select("input[id=__VIEWSTATEGENERATOR]").first().val());
/* 295 */     arrayList.set(6, document.select("input[id=__EVENTVALIDATION]").first().val());
/*     */     
/* 297 */     str = a().a(arrayList);
/* 298 */     if (str == null || str.isEmpty()) {
/* 299 */       return new ArrayList<>();
/*     */     }
/* 301 */     document = Jsoup.parse(str);
/* 302 */     arrayList.set(3, document.select("input[id=__VIEWSTATE]").first().val());
/* 303 */     arrayList.set(4, document.select("input[id=__VIEWSTATEGENERATOR]").first().val());
/* 304 */     arrayList.set(6, document.select("input[id=__EVENTVALIDATION]").first().val());
/*     */     
/* 306 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public j a() {
/* 311 */     return (j)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\b\a\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */