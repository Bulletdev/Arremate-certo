/*     */ package br.com.arremate.b.a;
/*     */ 
/*     */ import br.com.arremate.f.j;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.j.h;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.m.d;
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
/*     */ public class r
/*     */   extends a
/*     */ {
/*     */   public r(h paramh) {
/*  28 */     super((i)paramh);
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
/*  51 */     if (a().get()) {
/*  52 */       return arrayList;
/*     */     }
/*     */     
/*  55 */     List<String> list = b();
/*  56 */     if (list.isEmpty()) {
/*  57 */       return arrayList;
/*     */     }
/*  59 */     for (Map.Entry<Object, Object> entry : hashMap.entrySet()) {
/*  60 */       for (String str : entry.getValue()) {
/*  61 */         a(arrayList, (j)entry.getKey(), str, list);
/*     */       }
/*     */     } 
/*     */     
/*  65 */     return arrayList;
/*     */   }
/*     */   
/*     */   private void a(List<j> paramList, j paramj, String paramString, List<String> paramList1) throws Exception {
/*  69 */     paramList1.set(0, "ctl00$ddlVisoes");
/*  70 */     paramList1.set(1, "");
/*  71 */     paramList1.set(18, paramString);
/*     */     
/*  73 */     byte b = 1; int i = 0;
/*     */     
/*     */     do {
/*  76 */       if (a().get()) {
/*     */         return;
/*     */       }
/*     */       
/*  80 */       String str = a().a(paramList1);
/*  81 */       Document document = Jsoup.parse(str);
/*     */       
/*  83 */       if (!i) {
/*  84 */         if (str.toLowerCase().contains("nenhum registro encontrado para esta pesquisa")) {
/*     */           return;
/*     */         }
/*     */         
/*  88 */         Element element1 = document.select("td[class=navegacao]").first();
/*  89 */         if (element1 != null) {
/*  90 */           String str1 = element1.html().replaceAll("&nbsp;", "");
/*  91 */           String str2 = "página1de";
/*     */           
/*  93 */           if (str1.contains(str2)) {
/*  94 */             int k = str1.indexOf(str2) + str2.length();
/*  95 */             i = Integer.parseInt(str1.substring(k));
/*     */           } 
/*     */         } 
/*     */         
/*  99 */         if (i > 1) {
/* 100 */           paramList1.set(0, "ctl00$pesquisaDataGrid$dtgPesquisa");
/*     */         }
/*     */       } 
/*     */       
/* 104 */       Element element = document.select("div[id=ctl00_pesquisaDataGrid_dtgPesquisa_divScroll] > table > tbody").first();
/* 105 */       if (element == null || element.text().isEmpty()) {
/*     */         return;
/*     */       }
/*     */       
/* 109 */       if (!a(paramList, element, paramj)) {
/*     */         return;
/*     */       }
/*     */       
/* 113 */       b++;
/* 114 */       paramList1.set(1, "Page$" + b);
/* 115 */     } while (b <= i);
/*     */   }
/*     */   
/*     */   private boolean a(List<j> paramList, Element paramElement, j paramj) throws Exception {
/* 119 */     Elements elements = paramElement.select("tr");
/* 120 */     for (Element element1 : elements) {
/* 121 */       if (a().get()) {
/* 122 */         return false;
/*     */       }
/*     */       
/* 125 */       String str1 = element1.select("td:eq(5)").first().text();
/* 126 */       Calendar calendar = y.c(str1);
/* 127 */       if (a(calendar)) {
/* 128 */         return false;
/*     */       }
/*     */       
/* 131 */       Elements elements1 = element1.select("td");
/* 132 */       if (elements1.get(6).toString().contains("ic_compra_deserto.gif") || elements1.get(6).toString().contains("ic_compra_fracassado.gif")) {
/*     */         continue;
/*     */       }
/*     */       
/* 136 */       int i = Integer.parseInt(elements1.get(0).text().trim());
/* 137 */       if (a(i)) {
/*     */         continue;
/*     */       }
/*     */       
/* 141 */       Element element2 = elements1.get(1).select("a").first();
/* 142 */       String str2 = a(element2);
/* 143 */       if (!b(str2)) {
/*     */         continue;
/*     */       }
/*     */       
/* 147 */       j j1 = a(element1, element2, str2, paramj, calendar);
/* 148 */       paramList.add(j1);
/*     */     } 
/*     */     
/* 151 */     return true;
/*     */   }
/*     */   
/*     */   protected j a(Element paramElement1, Element paramElement2, String paramString, j paramj, Calendar paramCalendar) {
/* 155 */     Elements elements = paramElement1.select("td");
/*     */     
/* 157 */     int i = Integer.parseInt(elements.get(0).text().trim());
/*     */     
/* 159 */     Element element = elements.get(2).select("span").first();
/* 160 */     String str1 = element.attr("onmouseover").replace("toolTip('','", "").replace("');", "");
/*     */     
/* 162 */     String str2 = paramElement2.text();
/*     */     
/* 164 */     paramString = paramString.substring(paramString.indexOf("?q=") + 3);
/* 165 */     paramString = paramString.substring(0, paramString.indexOf("&"));
/*     */     
/* 167 */     boolean bool = elements.get(6).select("img").attr("title").contains("Gerar registro de preço");
/*     */     
/* 169 */     d d = new d(a().a(), i);
/* 170 */     d.T(str2);
/* 171 */     d.aw(str1);
/* 172 */     d.b(paramCalendar);
/* 173 */     d.a(paramj);
/* 174 */     d.aA(paramString);
/* 175 */     d.s(bool);
/* 176 */     d.z(bool);
/* 177 */     d.a(m.e);
/* 178 */     d.a(elements.html().contains("Por lote") ? u.b : u.a);
/* 179 */     return (j)d;
/*     */   }
/*     */ 
/*     */   
/*     */   protected List<j> a(String paramString) throws Exception {
/* 184 */     paramString = paramString.toUpperCase().trim();
/* 185 */     if (paramString.contains("PE") && !paramString.substring(paramString.indexOf("E") + 1, paramString.indexOf("E") + 2).equals("-")) {
/* 186 */       if (paramString.substring(paramString.indexOf("E") + 1, paramString.indexOf("E") + 2).equals(" ")) {
/* 187 */         paramString = paramString.replaceFirst(" ", "-").replaceAll(" ", "");
/*     */       } else {
/* 189 */         String[] arrayOfString = paramString.split("E");
/* 190 */         paramString = arrayOfString[0] + "E-" + arrayOfString[1];
/*     */       } 
/*     */     }
/*     */     
/* 194 */     List<String> list = b();
/* 195 */     list.set(17, paramString);
/*     */     
/* 197 */     String str = a().a(list);
/* 198 */     if (str.isEmpty() || str.equals("")) {
/* 199 */       return null;
/*     */     }
/*     */     
/* 202 */     Document document = Jsoup.parse(str);
/*     */     
/* 204 */     Element element = document.select("div[id=ctl00_pesquisaDataGrid_dtgPesquisa_divScroll] > table > tbody").first();
/* 205 */     if (element == null || element.text().isEmpty() || str.contains("Nenhum registro encontrado para esta pesquisa")) {
/* 206 */       f("No portal não foram encontrados pregões com o número inserido!\nPor favor revise o número digitado no campo e tente novamente!");
/*     */       
/* 208 */       return null;
/*     */     } 
/*     */     
/* 211 */     j j = null;
/*     */     
/* 213 */     Elements elements = element.select("tr");
/* 214 */     for (Element element1 : elements) {
/*     */       
/* 216 */       String str1 = element1.select("td:eq(5)").first().text();
/* 217 */       Calendar calendar = y.c(str1);
/*     */       
/* 219 */       Elements elements1 = element1.select("td");
/*     */       
/* 221 */       int i = Integer.parseInt(elements1.get(0).text().trim());
/* 222 */       if (a(i)) {
/*     */         continue;
/*     */       }
/*     */       
/* 226 */       Element element2 = elements1.get(1).select("a").first();
/* 227 */       String str2 = a(element2);
/* 228 */       if (!b(str2)) {
/*     */         continue;
/*     */       }
/*     */       
/* 232 */       j j1 = j.d;
/* 233 */       String str3 = elements1.get(7).select("span:eq(1) > img").attr("title").toLowerCase();
/* 234 */       if (str3.contains("em disputa")) {
/* 235 */         j1 = j.a;
/* 236 */       } else if (str3.contains("homologado") || str3.contains("homologação") || str3.contains("habilitação") || str3.contains("encerra") || str3
/* 237 */         .contains("recurso") || str3.contains("adjudicação") || str3.contains("julgamento") || str3.contains("ajuste de preços")) {
/* 238 */         j1 = j.g;
/* 239 */       } else if (str3.contains("suspenso")) {
/* 240 */         j1 = j.c;
/*     */       } 
/*     */       
/* 243 */       j = a(element1, element2, str2, j1, calendar);
/*     */     } 
/*     */     
/* 246 */     if (j == null) {
/* 247 */       f("No portal consta que você não está cadastrado como participante no pregão em questão!");
/* 248 */       return null;
/*     */     } 
/*     */     
/* 251 */     ArrayList<j> arrayList = new ArrayList();
/* 252 */     arrayList.add(j);
/*     */     
/* 254 */     return arrayList;
/*     */   }
/*     */   
/*     */   protected String a(Element paramElement) {
/* 258 */     String str = paramElement.attr("onclick");
/* 259 */     str = str.substring(str.indexOf("PregaoEletronicoValidacaoParticipacao")).replace("'", "").trim();
/* 260 */     return str;
/*     */   }
/*     */   
/*     */   protected boolean b(String paramString) {
/* 264 */     String str = a().E(paramString);
/* 265 */     Document document = Jsoup.parse(str);
/* 266 */     return !document.html().contains("DETALHES DO PROCESSO");
/*     */   }
/*     */   
/*     */   private List<String> b() {
/* 270 */     String str = a().ak();
/* 271 */     if (str == null || str.isEmpty()) {
/* 272 */       return new ArrayList<>();
/*     */     }
/*     */     
/* 275 */     Document document = Jsoup.parse(str);
/* 276 */     ArrayList<String> arrayList = new ArrayList();
/* 277 */     arrayList.add("ctl00$pesquisaDataGrid$dtgPesquisa");
/* 278 */     arrayList.add("Sort$tDtFinalProposta");
/* 279 */     arrayList.add("");
/* 280 */     arrayList.add(document.select("input[id=__VIEWSTATE]").first().val());
/* 281 */     arrayList.add(document.select("input[id=__VIEWSTATEGENERATOR]").first().val());
/* 282 */     arrayList.add("");
/* 283 */     arrayList.add(document.select("input[id=__EVENTVALIDATION]").first().val());
/* 284 */     arrayList.add("");
/* 285 */     arrayList.add("");
/* 286 */     arrayList.add("");
/* 287 */     arrayList.add("");
/* 288 */     arrayList.add("");
/* 289 */     arrayList.add("");
/* 290 */     arrayList.add("");
/* 291 */     arrayList.add("");
/* 292 */     arrayList.add("0");
/* 293 */     arrayList.add("false");
/* 294 */     arrayList.add("");
/* 295 */     arrayList.add("18039");
/* 296 */     arrayList.add("UC.nCdEmpresa");
/* 297 */     arrayList.add("");
/* 298 */     arrayList.add("");
/* 299 */     arrayList.add("");
/*     */     
/* 301 */     str = a().a(arrayList);
/* 302 */     if (str == null || str.isEmpty()) {
/* 303 */       return new ArrayList<>();
/*     */     }
/* 305 */     document = Jsoup.parse(str);
/* 306 */     arrayList.set(3, document.select("input[id=__VIEWSTATE]").first().val());
/* 307 */     arrayList.set(4, document.select("input[id=__VIEWSTATEGENERATOR]").first().val());
/* 308 */     arrayList.set(6, document.select("input[id=__EVENTVALIDATION]").first().val());
/*     */     
/* 310 */     str = a().a(arrayList);
/* 311 */     if (str == null || str.isEmpty()) {
/* 312 */       return new ArrayList<>();
/*     */     }
/* 314 */     document = Jsoup.parse(str);
/* 315 */     arrayList.set(3, document.select("input[id=__VIEWSTATE]").first().val());
/* 316 */     arrayList.set(4, document.select("input[id=__VIEWSTATEGENERATOR]").first().val());
/* 317 */     arrayList.set(6, document.select("input[id=__EVENTVALIDATION]").first().val());
/*     */     
/* 319 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public h a() {
/* 324 */     return (h)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\b\a\r.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */