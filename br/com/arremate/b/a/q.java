/*     */ package br.com.arremate.b.a;
/*     */ 
/*     */ import br.com.arremate.f.j;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.j.b.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.o.b;
/*     */ import br.com.arremate.m.y;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Calendar;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class q
/*     */   extends a
/*     */ {
/*  28 */   Map<String, j> map = new HashMap<>();
/*     */   
/*     */   public q(a parama) {
/*  31 */     super((i)parama);
/*     */     
/*  33 */     this.map.put("Lances", j.a);
/*  34 */     this.map.put("Classificação", j.a);
/*     */     
/*  36 */     this.map.put("Adjudicado", j.g);
/*  37 */     this.map.put("Adjudicação", j.g);
/*  38 */     this.map.put("Homologação", j.g);
/*  39 */     this.map.put("Homologado", j.g);
/*  40 */     this.map.put("Habilitação", j.g);
/*  41 */     this.map.put("Deserta", j.g);
/*  42 */     this.map.put("Revogado", j.g);
/*  43 */     this.map.put("Fracassada", j.g);
/*  44 */     this.map.put("Em Negociação/Habilitação", j.g);
/*     */     
/*  46 */     this.map.put("Suspensa", j.c);
/*  47 */     this.map.put("Suspensão", j.c);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<j> a(List<j> paramList) throws Exception {
/*  52 */     ArrayList<j> arrayList = new ArrayList();
/*  53 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*  54 */     for (j j : paramList) {
/*  55 */       switch (null.b[j.ordinal()]) {
/*     */         case 1:
/*  57 */           hashMap.put(j, Arrays.asList(new String[] { "2", "5" }));
/*     */         
/*     */         case 2:
/*  60 */           hashMap.put(j, Arrays.asList(new String[] { "6", "26" }));
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     } 
/*  67 */     for (Map.Entry<Object, Object> entry : hashMap.entrySet()) {
/*  68 */       for (String str1 : entry.getValue()) {
/*  69 */         if (a().get()) {
/*  70 */           return arrayList;
/*     */         }
/*     */         
/*  73 */         String str2 = a().n(str1);
/*  74 */         if (str2 == null || str2.trim().isEmpty()) {
/*     */           continue;
/*     */         }
/*     */         
/*  78 */         Document document = Jsoup.parse(str2);
/*  79 */         Elements elements = document.select("table[width=100%]:eq(1) tr");
/*  80 */         b(arrayList, elements, (j)entry.getKey());
/*     */         
/*  82 */         Element element = elements.last();
/*  83 */         String str3 = element.select("td").last().text();
/*  84 */         if (str3.trim().contains("de")) {
/*  85 */           str3 = str3.substring(str3.indexOf("de")).replaceAll("\\D", "");
/*  86 */           int i = Integer.parseInt(str3); byte b = 50;
/*     */           
/*  88 */           while (b < i) {
/*  89 */             if (a().get()) {
/*  90 */               return arrayList;
/*     */             }
/*     */             
/*  93 */             str2 = a().e(b);
/*  94 */             if (str2.isEmpty()) {
/*  95 */               a.info("Falhou em buscar as licitações do RJ, requisição sem retorno, provável perca de sessão");
/*  96 */               arrayList = null;
/*     */               
/*     */               break;
/*     */             } 
/* 100 */             document = Jsoup.parse(str2);
/* 101 */             elements = document.select("table[width=100%]:eq(1) tr");
/* 102 */             b(arrayList, elements, (j)entry.getKey());
/* 103 */             b += 50;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 109 */     return arrayList;
/*     */   }
/*     */   
/*     */   private void b(List<j> paramList, Elements paramElements, j paramj) throws Exception {
/* 113 */     for (Element element : paramElements) {
/* 114 */       if (element.html().contains("Edita_Item")) {
/* 115 */         if (a().get()) {
/*     */           return;
/*     */         }
/*     */         
/* 119 */         String str1 = element.select("td").last().select("h3").text().trim();
/* 120 */         if (str1.equals("Suspensa")) {
/*     */           continue;
/*     */         }
/*     */         
/* 124 */         String str2 = element.select("a:eq(0)").first().attr("href");
/* 125 */         String[] arrayOfString = str2.replace("javascript:Edita_Item(", "").replace(")", "").split(",");
/* 126 */         String str3 = arrayOfString[1];
/* 127 */         if (a(str3)) {
/*     */           continue;
/*     */         }
/*     */         
/* 131 */         String str4 = arrayOfString[2].replace("'", "").trim();
/* 132 */         if (!str4.contains("PE")) {
/*     */           continue;
/*     */         }
/*     */         
/* 136 */         String str5 = str3 + "&" + str4;
/* 137 */         String str6 = a().m(str5);
/* 138 */         if (str6.isEmpty()) {
/*     */           continue;
/*     */         }
/*     */         
/* 142 */         Document document = Jsoup.parse(str6);
/* 143 */         j j1 = a(document, str3);
/* 144 */         if (j1 == null) {
/*     */           continue;
/*     */         }
/*     */         
/* 148 */         if (j1.h() != null && a(j1.h())) {
/*     */           continue;
/*     */         }
/*     */         
/* 152 */         String str7 = element.select("td").get(2).text();
/* 153 */         str7 = str7.substring(str7.indexOf("-") + 1).replaceAll(" ", "").trim();
/*     */         
/* 155 */         j1.a(a(document));
/* 156 */         j1.aw(str7);
/* 157 */         j1.T(str4);
/* 158 */         j1.a(paramj);
/* 159 */         paramList.add(j1);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected List<j> a(String paramString) throws Exception {
/* 166 */     paramString = paramString.trim();
/* 167 */     String str1 = paramString;
/*     */ 
/*     */ 
/*     */     
/* 171 */     a().Z();
/*     */     
/* 173 */     if (!paramString.matches("^\\d+$")) {
/* 174 */       String str = a().o(paramString);
/* 175 */       if (str == null || str.isEmpty()) {
/* 176 */         return null;
/*     */       }
/*     */       
/* 179 */       if (str.contains("Não existem Registros Selecionados")) {
/* 180 */         f("Não foi possível localizar este pregão no portal! Por favor revise o número inserido na pesquisa e tente novamente!");
/* 181 */         return null;
/*     */       } 
/*     */       
/* 184 */       if (str.contains("ItemPesquisa")) {
/* 185 */         f("Foram encontrados mais de uma licitação no Portal que possuem o número informado! Favor inserir o número completo do pregão juntamente com o resumo do objeto!\nEx: PE 138/22 / AQUISIÇÃO DE MEDICAMENTOS");
/*     */         
/* 187 */         return null;
/*     */       } 
/*     */       
/* 190 */       Document document1 = Jsoup.parse(str);
/* 191 */       str1 = document1.select("input[id=hdn_campo_]").val();
/*     */     } 
/*     */     
/* 194 */     String str2 = a().q(str1);
/* 195 */     Document document = Jsoup.parse(str2);
/*     */     
/* 197 */     Elements elements = document.select("table[width=100%]:eq(1) tr:has(a)");
/* 198 */     if (elements.isEmpty()) {
/* 199 */       f("Não foi possível localizar este pregão no portal! Por favor revise o número inserido na pesquisa e tente novamente!");
/* 200 */       return null;
/*     */     } 
/*     */     
/* 203 */     String str3 = elements.first().select("td").get(2).text();
/* 204 */     str3 = str3.substring(str3.indexOf("-") + 1).replaceAll(" ", "").trim();
/*     */     
/* 206 */     str2 = a().m(str1);
/* 207 */     if (str2.isEmpty()) {
/* 208 */       return null;
/*     */     }
/*     */     
/* 211 */     document = Jsoup.parse(str2);
/* 212 */     j j = a(document, str1);
/* 213 */     if (j == null) {
/* 214 */       return null;
/*     */     }
/*     */     
/* 217 */     j.aw(str3);
/*     */     
/* 219 */     String str4 = document.select("input[name=Alfa_lleilao]").val();
/* 220 */     j.T(str4);
/*     */     
/* 222 */     String str5 = document.select("form[name=frmLeilaoExibe] > table").first().select("font[color=blue]").text();
/* 223 */     str5 = str5.substring(str5.indexOf("(") + 1, str5.indexOf(")"));
/* 224 */     j j1 = b(str5);
/* 225 */     j.a(j1);
/* 226 */     j.a(a(document));
/*     */     
/* 228 */     ArrayList<j> arrayList = new ArrayList();
/* 229 */     arrayList.add(j);
/*     */     
/* 231 */     return arrayList;
/*     */   }
/*     */   
/*     */   private j b(String paramString) {
/* 235 */     j j = this.map.get(paramString);
/* 236 */     if (j == null) {
/* 237 */       j = j.d;
/*     */     }
/*     */     
/* 240 */     return j;
/*     */   }
/*     */   
/*     */   private j a(Document paramDocument, String paramString) throws Exception {
/* 244 */     Elements elements = paramDocument.select("table tr td table").first().select("tr");
/* 245 */     Optional<Element> optional = elements.stream().filter(paramElement -> paramElement.html().contains("<h3><b>Edital -&nbsp;</b>")).findFirst();
/* 246 */     if (!optional.isPresent()) {
/* 247 */       return null;
/*     */     }
/*     */     
/* 250 */     Element element1 = paramDocument.select("input[name=Data_AbertPropostasALT]").first();
/* 251 */     Element element2 = paramDocument.select("input[name=Hora_AbertPropostasALT]").first();
/* 252 */     String str1 = element1.attr("value") + " " + element2.attr("value");
/* 253 */     Calendar calendar = null;
/* 254 */     if (!str1.trim().isEmpty()) {
/* 255 */       calendar = y.c(str1);
/*     */     }
/*     */     
/* 258 */     String[] arrayOfString = ((Element)optional.get()).select("h3").text().split("-");
/* 259 */     String str2 = arrayOfString[1].trim().replaceAll("\\D", "");
/*     */     
/* 261 */     String str3 = a(paramDocument);
/*     */     
/* 263 */     b b = new b(a().a(), Integer.parseInt(paramString));
/* 264 */     b.Q(Integer.parseInt(str2));
/* 265 */     b.b(calendar);
/* 266 */     b.s(str3.contains("Sim"));
/* 267 */     b.z(true);
/* 268 */     b.a(b(paramDocument));
/* 269 */     return (j)b;
/*     */   }
/*     */   
/*     */   private String a(Document paramDocument) throws Exception {
/* 273 */     String str = "";
/* 274 */     Optional<Element> optional = paramDocument.select("table tr td table").get(1).select("tr").stream().filter(paramElement -> paramElement.html().contains("Edital para SRP")).findFirst();
/*     */     
/* 276 */     if (optional.isPresent()) {
/* 277 */       str = ((Element)optional.get()).select("td").first().text();
/*     */     }
/*     */     
/* 280 */     return str;
/*     */   }
/*     */   
/*     */   private u b(Document paramDocument) {
/* 284 */     Elements elements = paramDocument.select("table tr td table").first().select("tr");
/* 285 */     boolean bool = !paramDocument.select("input[name=chkLote]").isEmpty() ? true : false;
/*     */     
/* 287 */     Optional<Element> optional = elements.stream().filter(paramElement -> paramElement.html().contains("Tipo -")).findFirst();
/* 288 */     if (optional.isPresent()) {
/* 289 */       String str = ((Element)optional.get()).select("td").first().text();
/*     */       
/* 291 */       if (str.contains("Maior Desconto Percentual"))
/* 292 */         return bool ? u.g : u.d; 
/* 293 */       if (str.contains("Processo Padrão") || str.contains("Menor Preço")) {
/* 294 */         return bool ? u.b : u.a;
/*     */       }
/* 296 */       return u.h;
/*     */     } 
/*     */ 
/*     */     
/* 300 */     return bool ? u.b : u.a;
/*     */   }
/*     */   
/*     */   private m a(Document paramDocument) {
/* 304 */     String str1 = paramDocument.text();
/*     */     
/* 306 */     String str2 = "blank";
/* 307 */     String str3 = "Modo de Disputa";
/* 308 */     int i = str1.indexOf(str3);
/* 309 */     if (i != -1) {
/* 310 */       i += str3.length();
/* 311 */       int j = str1.indexOf("Id contratação", i);
/* 312 */       if (j != -1) {
/* 313 */         str2 = str1.substring(i, j).toLowerCase();
/*     */       }
/*     */     } 
/*     */     
/* 317 */     if (str2.contains("fechado"))
/* 318 */       return m.c; 
/* 319 */     if (str2.contains("aberto")) {
/* 320 */       return m.b;
/*     */     }
/* 322 */     return m.a;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public a a() {
/* 328 */     return (a)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\b\a\q.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */