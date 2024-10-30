/*     */ package br.com.arremate.b.a;
/*     */ 
/*     */ import br.com.arremate.f.j;
/*     */ import br.com.arremate.f.l;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.j.i;
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
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ public class b
/*     */   extends a
/*     */ {
/*     */   public b(br.com.arremate.j.d.b paramb) {
/*  26 */     super((i)paramb);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<j> a(List<j> paramList) throws Exception {
/*  31 */     ArrayList<j> arrayList = new ArrayList();
/*  32 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*  33 */     for (j j : paramList) {
/*  34 */       switch (null.b[j.ordinal()]) {
/*     */         case 1:
/*  36 */           hashMap.put(j, Arrays.asList(new String[] { "3", "4", "5" }));
/*     */         
/*     */         case 2:
/*  39 */           hashMap.put(j, Arrays.asList(new String[] { "6" }));
/*     */         
/*     */         case 3:
/*  42 */           hashMap.put(j, Arrays.asList(new String[] { "7" }));
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     } 
/*  49 */     for (Map.Entry<Object, Object> entry : hashMap.entrySet()) {
/*  50 */       for (String str1 : entry.getValue()) {
/*  51 */         if (a().get()) {
/*  52 */           return arrayList;
/*     */         }
/*     */         
/*  55 */         String str2 = a().L(str1);
/*  56 */         if (str2 != null && !str2.isEmpty()) {
/*  57 */           a(str2, (j)entry.getKey(), arrayList);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  62 */     return arrayList;
/*     */   }
/*     */   
/*     */   private void a(String paramString, j paramj, List<j> paramList) throws Exception {
/*  66 */     Document document = Jsoup.parse(paramString);
/*  67 */     Element element = document.select("table[id=tLicitacoes] > tbody").first();
/*  68 */     if (element == null || element.text().isEmpty()) {
/*     */       return;
/*     */     }
/*     */     
/*  72 */     Elements elements = element.select("tr");
/*  73 */     for (Element element1 : elements) {
/*  74 */       if (a().get()) {
/*     */         return;
/*     */       }
/*     */       
/*  78 */       Elements elements1 = element1.select("td");
/*     */       
/*  80 */       String str1 = elements1.get(5).text().trim();
/*  81 */       if (str1.isEmpty()) {
/*     */         continue;
/*     */       }
/*     */       
/*  85 */       Calendar calendar = y.c(str1);
/*  86 */       if (a(calendar)) {
/*     */         continue;
/*     */       }
/*     */       
/*  90 */       String str2 = elements1.get(0).text().trim();
/*  91 */       if (a(str2)) {
/*     */         continue;
/*     */       }
/*     */       
/*  95 */       paramString = a().t(str2).getData();
/*  96 */       if (paramString.isEmpty()) {
/*     */         continue;
/*     */       }
/*     */       
/* 100 */       document = Jsoup.parse(paramString);
/* 101 */       Elements elements2 = document.select("div[class=campo col11]");
/*     */       
/* 103 */       j j1 = a(document, elements2, str2);
/* 104 */       if (j1 != null) {
/* 105 */         String str = elements1.get(3).text();
/*     */         
/* 107 */         j1.aw(str);
/* 108 */         j1.b(calendar);
/* 109 */         j1.a(paramj);
/* 110 */         paramList.add(j1);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected List<j> a(String paramString) throws Exception {
/* 117 */     if (paramString.length() != 6) {
/* 118 */       return null;
/*     */     }
/*     */     
/* 121 */     String str1 = a().t(paramString).getData();
/* 122 */     if (str1 == null || str1.isEmpty()) {
/* 123 */       return null;
/*     */     }
/*     */     
/* 126 */     if (str1.contains(String.join("", new CharSequence[] { "A licitação informada (", paramString, ") não foi localizada ou não se encontra disponível para a consulta." }))) {
/* 127 */       return null;
/*     */     }
/*     */     
/* 130 */     Document document = Jsoup.parse(str1);
/* 131 */     String str2 = document.select("label[class*=label col9]").get(14).text().trim().toLowerCase();
/* 132 */     if (!str2.contains("data e a hora da disputa")) {
/* 133 */       str2 = document.select("label[class*=label col9]").get(13).text().trim().toLowerCase();
/*     */     }
/*     */     
/* 136 */     if (!str2.contains("data e a hora da disputa")) {
/* 137 */       return null;
/*     */     }
/*     */     
/* 140 */     str1 = a().c(paramString, 0);
/* 141 */     if (str1.contains("Digite os caracteres abaixo para continuar:") && str1
/* 142 */       .contains("https://www.licitacoes-e.com.br/aop/captchaServletAux.png")) {
/*     */       
/* 144 */       StringBuilder stringBuilder = new StringBuilder();
/* 145 */       stringBuilder.append("Não foi possível capturar o pregão ").append(paramString)
/* 146 */         .append("\nVerifique no portal se a proposta foi cadastrada corretamente ou se\na proposta do(s) lote(s) se encontra(m) classificada(s) para a disputa!");
/* 147 */       f(stringBuilder.toString());
/* 148 */       return null;
/*     */     } 
/*     */     
/* 151 */     Elements elements = document.select("div[class=campo col11]");
/* 152 */     j j = a(document, elements, paramString);
/* 153 */     if (j == null) {
/* 154 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 158 */     String str3 = elements.get(11).text().trim().replace("-", " ");
/* 159 */     Calendar calendar = y.c(str3);
/* 160 */     j.b(calendar);
/*     */ 
/*     */     
/* 163 */     String str4 = document.select("label:contains(Cliente)").first().nextElementSibling().text();
/* 164 */     j.aw(str4);
/*     */ 
/*     */     
/* 167 */     String str5 = elements.get(6).text().trim().toLowerCase();
/* 168 */     if (str5.contains("encerrada") || str5.contains("homologada") || str5.contains("cancelada")) {
/* 169 */       j.a(j.g);
/* 170 */     } else if (str5.contains("em disputa")) {
/* 171 */       j.a(j.a);
/* 172 */     } else if (str5.contains("suspenso") || str5.contains("suspensa")) {
/* 173 */       j.a(j.c);
/*     */     } else {
/* 175 */       j.a(j.d);
/*     */     } 
/*     */     
/* 178 */     ArrayList<j> arrayList = new ArrayList();
/* 179 */     arrayList.add(j);
/*     */     
/* 181 */     return arrayList;
/*     */   }
/*     */   
/*     */   private j a(Document paramDocument, Elements paramElements, String paramString) throws Exception {
/* 185 */     String str1 = paramElements.get(0).text().trim();
/*     */     
/* 187 */     String str2 = paramElements.get(3).text().trim();
/* 188 */     u u = u.c;
/* 189 */     if (str2.equalsIgnoreCase("Maior desconto")) {
/* 190 */       u = u.d;
/* 191 */     } else if (str2.equalsIgnoreCase("Maior oferta")) {
/* 192 */       u = u.f;
/* 193 */     } else if (str2.equalsIgnoreCase("Cotação de preço")) {
/* 194 */       u = u.e;
/*     */     } 
/*     */     
/* 197 */     String str3 = paramElements.get(2).text().trim();
/* 198 */     l l = l.a;
/* 199 */     if (str3.equalsIgnoreCase("Dispensa de licitação")) {
/* 200 */       l = l.c;
/* 201 */     } else if (str3.equalsIgnoreCase("Convite")) {
/* 202 */       l = l.d;
/* 203 */     } else if (str3.equalsIgnoreCase("Cotação de preço")) {
/* 204 */       l = l.b;
/* 205 */     } else if (str3.equalsIgnoreCase("RDC")) {
/* 206 */       l = l.e;
/* 207 */     } else if (str3.equalsIgnoreCase("LRE")) {
/* 208 */       l = l.f;
/*     */     } 
/*     */     
/* 211 */     boolean bool = false;
/* 212 */     Elements elements = paramDocument.select("div[class=campo col4]");
/* 213 */     if (elements != null) {
/* 214 */       bool = elements.toString().toLowerCase().contains("sim");
/*     */     }
/*     */ 
/*     */     
/* 218 */     m m = null;
/* 219 */     String str4 = paramDocument.select("div[class=campo col7]").first().text().toLowerCase();
/* 220 */     if (str4.contains("prorrogação automática")) {
/* 221 */       m = m.b;
/*     */     } else {
/* 223 */       String str = a().e(paramString, 0).getData();
/* 224 */       paramDocument = Jsoup.parse(str);
/* 225 */       paramElements = paramDocument.select("fieldset[class=abrefechafieldset clear]");
/* 226 */       if (!paramElements.isEmpty()) {
/* 227 */         paramElements = paramElements.get(0).select("div[class=campo col12]");
/* 228 */         if (!paramElements.isEmpty()) {
/* 229 */           String str5 = paramElements.get(0).text().trim().toLowerCase();
/*     */           
/* 231 */           if (str5.contains("modo de disputa aberto e fechado")) {
/* 232 */             m = m.c;
/*     */           } else {
/* 234 */             m = m.a;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 240 */     br.com.arremate.l.a.b b1 = new br.com.arremate.l.a.b(a().a(), Integer.parseInt(paramString));
/* 241 */     b1.T(str1);
/* 242 */     b1.D(bool);
/* 243 */     b1.a(u);
/* 244 */     b1.a(m);
/* 245 */     b1.a(l);
/* 246 */     b1.Y(2);
/* 247 */     return (j)b1;
/*     */   }
/*     */ 
/*     */   
/*     */   public br.com.arremate.j.d.b a() {
/* 252 */     return (br.com.arremate.j.d.b)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\b\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */