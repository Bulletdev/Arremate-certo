/*     */ package br.com.arremate.l.f;
/*     */ 
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.f.l;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.i.a;
/*     */ import br.com.arremate.j.h.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.k.a.e;
/*     */ import br.com.arremate.k.a.g;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.m.y;
/*     */ import java.math.BigDecimal;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ public class b
/*     */   extends j
/*     */   implements a
/*     */ {
/*     */   public b(d paramd, int paramInt) {
/*  33 */     super(paramd, paramInt);
/*  34 */     Q(999);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ao() {
/*     */     try {
/*  40 */       byte b1 = 1;
/*  41 */       String str1 = "porcodigo, empcnpj, liccodigo, licnumero, licuasg, licuasgnome, licdataabertura, licoculta, licsrp, licunitario, licmododedisputa, lictipoapuracao, liclimitecasasdecimais, licmodalidade";
/*  42 */       String str2 = "?, ?, ?, ?, ?, ?, ?, 0, ?, ?, ?, ?, ?, ?";
/*     */       
/*  44 */       String str3 = "INSERT INTO tblicitacao (" + str1 + ") VALUES (" + str2 + ");";
/*  45 */       PreparedStatement preparedStatement = a.a().prepareStatement(str3);
/*  46 */       preparedStatement.setInt(b1++, b().v());
/*  47 */       preparedStatement.setLong(b1++, C());
/*  48 */       preparedStatement.setInt(b1++, v());
/*  49 */       preparedStatement.setString(b1++, bo());
/*  50 */       preparedStatement.setInt(b1++, K());
/*  51 */       preparedStatement.setString(b1++, bT());
/*  52 */       preparedStatement.setTimestamp(b1++, new Timestamp(h().getTimeInMillis()));
/*  53 */       preparedStatement.setBoolean(b1++, bf());
/*  54 */       preparedStatement.setBoolean(b1++, aZ());
/*  55 */       preparedStatement.setInt(b1++, a().getId());
/*  56 */       preparedStatement.setInt(b1++, a().w());
/*  57 */       preparedStatement.setInt(b1++, N());
/*  58 */       preparedStatement.setInt(b1++, a().getId());
/*     */       
/*  60 */       return (preparedStatement.executeUpdate() == 1);
/*  61 */     } catch (Exception exception) {
/*  62 */       a.error("Falha ao adicionar licitação do CP", exception);
/*     */ 
/*     */       
/*  65 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public br.com.arremate.d.b b() {
/*  70 */     e e = new e(this);
/*  71 */     return new br.com.arremate.d.b((g)e);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<g> a(i parami) {
/*  77 */     ArrayList<g> arrayList = new ArrayList();
/*     */     try {
/*     */       boolean bool;
/*  80 */       a a1 = (a)parami;
/*  81 */       BigDecimal bigDecimal1 = BigDecimal.ZERO;
/*  82 */       BigDecimal bigDecimal2 = BigDecimal.ZERO;
/*     */       
/*  84 */       String str = a1.j(v());
/*  85 */       if (str != null && !str.isEmpty()) {
/*  86 */         Document document = Jsoup.parse(str);
/*  87 */         Element element = document.select("div[class=dataInnerBlock1]").first();
/*     */         
/*  89 */         Elements elements = element.select("p");
/*  90 */         for (Element element1 : elements) {
/*  91 */           String str1 = element1.text();
/*     */           
/*  93 */           if (str1.contains("Valor do Intervalo de Lances (R$)")) {
/*  94 */             str1 = str1.replace("Valor do Intervalo de Lances (R$):", "");
/*  95 */             bigDecimal1 = BigDecimal.valueOf(y.a(str1).doubleValue()); continue;
/*  96 */           }  if (str1.contains("Valor do Intervalo de Lances (%)")) {
/*  97 */             str1 = str1.replace("Valor do Intervalo de Lances (%):", "");
/*  98 */             bigDecimal2 = BigDecimal.valueOf(y.a(str1).doubleValue());
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 103 */       HashMap<Object, Object> hashMap = new HashMap<>();
/* 104 */       if (a() != u.a && !aZ()) {
/* 105 */         String str1 = a1.f(v(), 1).getData();
/* 106 */         Document document = Jsoup.parse(str1);
/* 107 */         Elements elements = document.select("table[id=tabTableSorter] > tfoot > tr > td > p > b");
/* 108 */         double d1 = Double.parseDouble(elements.text());
/* 109 */         double d2 = Math.ceil(d1 / 10.0D);
/* 110 */         byte b2 = 1;
/*     */         
/*     */         do {
/* 113 */           String str2 = a1.f(v(), b2).getData();
/* 114 */           b2++;
/* 115 */           Document document1 = Jsoup.parse(str2);
/* 116 */           Elements elements1 = document1.select("table[id=tabTableSorter] > tbody > tr");
/* 117 */           for (Element element : elements1) {
/* 118 */             String str3 = element.getElementsByClass("td70").text().replaceFirst("^0+(?!$)", "");
/* 119 */             int k = Integer.parseInt(element.attr("id").replaceAll("[^0-9.]", ""));
/* 120 */             hashMap.put(str3, Integer.valueOf(k));
/*     */           } 
/* 122 */         } while (b2 <= d2);
/*     */       } 
/*     */ 
/*     */       
/* 126 */       byte b1 = 1;
/*     */       
/*     */       do {
/* 129 */         String str1 = a1.d(v(), b1);
/* 130 */         if (str1.isEmpty()) {
/* 131 */           return arrayList;
/*     */         }
/*     */         
/* 134 */         Document document = Jsoup.parse(str1);
/* 135 */         String str2 = (a() == u.a) ? "Total de Registros" : "Total de Lotes";
/*     */         
/* 137 */         bool = document.select("td:contains(" + str2 + ") > ul.pagesBlock").stream().filter(paramElement -> (paramElement.select("a.pageNext").first() != null)).findFirst().isPresent();
/*     */         
/* 139 */         Elements elements1 = document.select("div[class=dataInnerBlock1]");
/* 140 */         if (elements1.isEmpty()) {
/* 141 */           return arrayList;
/*     */         }
/*     */         
/* 144 */         Elements elements2 = elements1.get(0).select("p");
/* 145 */         for (Element element : elements2) {
/* 146 */           String str3 = element.text().toLowerCase();
/* 147 */           if (str3.contains("pregão progressivo")) {
/* 148 */             a(u.d);
/* 149 */             return arrayList;
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 154 */         byte b2 = 1;
/* 155 */         int k = -1;
/* 156 */         Elements elements3 = document.select("table[id=searchTableSorter] > thead > tr:contains(Un. Medida) > th");
/* 157 */         for (Element element : elements3) {
/* 158 */           if (element.text().contains("Un. Medida")) {
/* 159 */             k = elements3.indexOf(element);
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/* 164 */         Elements elements4 = new Elements();
/*     */         while (true) {
/* 166 */           elements4.addAll((Collection)document.select("table[id=searchTableSorter] > tbody > tr"));
/*     */ 
/*     */           
/* 169 */           boolean bool1 = document.select("td:contains(Total de Itens) > ul.pagesBlock").stream().anyMatch(paramElement -> (paramElement.select("a.pageNext").first() != null));
/*     */           
/* 171 */           if (!bool1) {
/*     */             break;
/*     */           }
/*     */           
/* 175 */           b2++;
/* 176 */           document = Jsoup.parse(a1.c(v(), b1, b2));
/*     */         } 
/*     */         
/* 179 */         b1++;
/*     */         
/* 181 */         Elements elements5 = elements4.select("tr[class*=propostaOK]");
/* 182 */         if (elements5.isEmpty()) {
/*     */           continue;
/*     */         }
/*     */         
/* 186 */         if (a() == u.a) {
/* 187 */           arrayList.addAll(a(elements5, elements4, bigDecimal1, bigDecimal2, k));
/*     */         } else {
/*     */           
/* 190 */           String str3 = elements1.get(1).select("p").get(0).text().replace("Lote:", "").trim();
/*     */           
/* 192 */           if (aZ()) {
/* 193 */             arrayList.addAll(a(str3, elements5, elements4, bigDecimal1, bigDecimal2, k));
/*     */           } else {
/* 195 */             g g = a(str3, (Map)hashMap, elements5, elements4, bigDecimal1, bigDecimal2, k);
/* 196 */             if (g != null) {
/* 197 */               arrayList.add(g);
/*     */             }
/*     */           } 
/*     */         } 
/* 201 */       } while (bool);
/* 202 */     } catch (Exception exception) {
/* 203 */       a.warn("Erro ao ao capturar itens da licitação CP", exception);
/*     */     } 
/*     */     
/* 206 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   private List<g> a(Elements paramElements1, Elements paramElements2, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, int paramInt) throws Exception {
/* 211 */     ArrayList<a> arrayList = new ArrayList();
/*     */     
/* 213 */     for (Element element : paramElements1) {
/* 214 */       a a1 = a(element, paramElements2, paramInt);
/* 215 */       a1.e(paramBigDecimal1);
/* 216 */       a1.f(paramBigDecimal2);
/* 217 */       arrayList.add(a1);
/*     */     } 
/*     */     
/* 220 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   private List<g> a(String paramString, Elements paramElements1, Elements paramElements2, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, int paramInt) throws Exception {
/* 225 */     ArrayList<a> arrayList = new ArrayList();
/*     */     
/* 227 */     for (Element element : paramElements1) {
/* 228 */       a a1 = a(element, paramElements2, paramInt);
/* 229 */       a1.e(paramBigDecimal1);
/* 230 */       a1.f(paramBigDecimal2);
/*     */       
/* 232 */       a1.T(Integer.parseInt(paramString));
/* 233 */       a1.ai("G" + paramString);
/*     */       
/* 235 */       arrayList.add(a1);
/*     */     } 
/*     */     
/* 238 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private g a(String paramString, Map<String, Integer> paramMap, Elements paramElements1, Elements paramElements2, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, int paramInt) throws Exception {
/* 244 */     int i = 0;
/* 245 */     if (paramMap.containsKey(paramString)) {
/* 246 */       i = ((Integer)paramMap.get(paramString)).intValue();
/*     */     } else {
/* 248 */       return null;
/*     */     } 
/*     */     
/* 251 */     BigDecimal bigDecimal = BigDecimal.ZERO;
/*     */     
/* 253 */     for (Element element : paramElements1) {
/* 254 */       a a2 = a(element, paramElements2, paramInt);
/* 255 */       bigDecimal = bigDecimal.add(BigDecimal.valueOf(a2.k()));
/*     */     } 
/*     */     
/* 258 */     a a1 = new a(i, this);
/* 259 */     a1.T(paramString);
/* 260 */     a1.ag(String.join("", new CharSequence[] { "Lote ", paramString }));
/* 261 */     a1.k(1.0D);
/* 262 */     a1.aj("UND");
/* 263 */     a1.m(bigDecimal.doubleValue());
/* 264 */     a1.n(bigDecimal.doubleValue());
/* 265 */     a1.e(paramBigDecimal1);
/* 266 */     a1.f(paramBigDecimal2);
/* 267 */     return a1;
/*     */   }
/*     */   
/*     */   private a a(Element paramElement, Elements paramElements, int paramInt) throws Exception {
/* 271 */     String str1 = paramElement.select("td[class=td50]").first().text().trim();
/* 272 */     String str2 = str1.replaceAll("\\d", "");
/* 273 */     str1 = String.valueOf(Integer.parseInt(str1.replaceAll("\\D", ""))) + str2;
/*     */     
/* 275 */     String str3 = "";
/* 276 */     Element element1 = paramElement.select("td[class=td390]").first();
/* 277 */     if (element1 == null) {
/* 278 */       element1 = paramElement.select("td[class=td290]").first();
/*     */     }
/* 280 */     if (element1 == null) {
/* 281 */       element1 = paramElement.select("td[class=td375]").first();
/*     */     }
/* 283 */     if (element1 == null) {
/* 284 */       element1 = paramElement.select("p[id^=produtoTexto]").first();
/*     */     }
/*     */     
/* 287 */     if (element1 != null) {
/* 288 */       str3 = element1.text().trim();
/*     */     }
/*     */     
/* 291 */     Element element2 = paramElements.get(paramElements.indexOf(paramElement) + 1);
/* 292 */     String str4 = element2.select("input[name=slCD_ITEM_LICITACAO]").first().attr("value").trim();
/* 293 */     int i = Integer.parseInt(str4);
/*     */     
/* 295 */     String str5 = element2.select("input[name=ttQUANTIDADE]").first().attr("value").trim();
/* 296 */     int k = y.a(str5).intValue();
/*     */ 
/*     */     
/* 299 */     Element element3 = element2.select("input[id=ttVALOR_UNITARIO]").first();
/* 300 */     String str6 = y.Q(element3.attr("value"));
/* 301 */     double d1 = Double.parseDouble(str6);
/*     */ 
/*     */     
/* 304 */     Element element4 = element2.select("input[id=ttVALOR_TOTAL]").first();
/* 305 */     String str7 = y.Q(element4.attr("value"));
/* 306 */     double d2 = Double.parseDouble(str7);
/* 307 */     String str8 = "";
/* 308 */     if (paramInt > 0) {
/* 309 */       str8 = paramElement.select("td").get(paramInt).text().trim();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 314 */     a a1 = new a(i, this);
/* 315 */     a1.T(str1);
/* 316 */     a1.ag(str3);
/* 317 */     a1.k(k);
/* 318 */     a1.aj(str8);
/* 319 */     a1.m(d1);
/* 320 */     a1.n(d2);
/*     */     
/* 322 */     return a1;
/*     */   }
/*     */ 
/*     */   
/*     */   public String bg() {
/* 327 */     if (a() == u.b && aZ()) {
/* 328 */       return "Grupo";
/*     */     }
/*     */     
/* 331 */     if (a() == u.d) {
/* 332 */       return "Maior Desconto Percentual";
/*     */     }
/*     */     
/* 335 */     if (a() == u.l) {
/* 336 */       return "Técnica e Preço";
/*     */     }
/*     */     
/* 339 */     if (a() == u.k) {
/* 340 */       return "Técnica";
/*     */     }
/*     */     
/* 343 */     if (a() == l.c) {
/* 344 */       return "Dispensa Eletrônica";
/*     */     }
/*     */     
/* 347 */     return "";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\f\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */