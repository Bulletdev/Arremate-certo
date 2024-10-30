/*     */ package br.com.arremate.b.a;
/*     */ 
/*     */ import br.com.arremate.f.j;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.j.b;
/*     */ import br.com.arremate.j.c;
/*     */ import br.com.arremate.l.h.b;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.m.y;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class i
/*     */   extends a
/*     */ {
/*     */   private c a;
/*     */   private List<j> e;
/*     */   private String I;
/*     */   private String J;
/*     */   private String K;
/*     */   private String L;
/*     */   private String M;
/*     */   
/*     */   public i(br.com.arremate.j.i parami) {
/*  35 */     super(parami);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<j> a(List<j> paramList) throws Exception {
/*  40 */     this.e = paramList;
/*  41 */     this.I = null;
/*  42 */     this.J = null;
/*  43 */     this.K = null;
/*  44 */     this.L = null;
/*  45 */     this.M = null;
/*  46 */     this.a = new c(a());
/*  47 */     this.a.z();
/*     */     
/*  49 */     ArrayList<j> arrayList = new ArrayList();
/*  50 */     ArrayList<String> arrayList1 = new ArrayList();
/*  51 */     int j = 1, k = 1;
/*  52 */     String str = null;
/*     */     
/*     */     do {
/*     */       String str1;
/*     */       
/*     */       Document document;
/*  58 */       if (a().get()) {
/*  59 */         return arrayList;
/*     */       }
/*     */       
/*  62 */       if (j == 1) {
/*  63 */         str1 = a().ak();
/*  64 */         document = Jsoup.parse(str1);
/*     */       } else {
/*  66 */         if (str == null) {
/*  67 */           str = a().al();
/*     */         }
/*     */         
/*  70 */         str1 = a().c(j, str);
/*  71 */         document = Jsoup.parse(str1);
/*     */       } 
/*     */       
/*  74 */       if (!a(document, arrayList, arrayList1)) {
/*     */         break;
/*     */       }
/*     */       
/*  78 */       if (j != k)
/*  79 */         continue;  if (!a(document)) {
/*     */         break;
/*     */       }
/*  82 */       if (!str1.contains("rich-datascr-inact"))
/*  83 */         continue;  k = Integer.parseInt(document.select("tfoot .rich-datascr-inact").last().text());
/*     */ 
/*     */ 
/*     */       
/*  87 */       ++j;
/*  88 */     } while (j <= k);
/*     */     
/*  90 */     return arrayList;
/*     */   }
/*     */   
/*     */   private boolean a(Document paramDocument) {
/*  94 */     Element element = paramDocument.select("table").first();
/*  95 */     if (element != null) {
/*  96 */       Element element1 = element.select("tr").last();
/*  97 */       if (element1 != null) {
/*  98 */         String str = element1.select("td").first().text().trim();
/*  99 */         return !a(y.d(str));
/*     */       } 
/*     */     } 
/* 102 */     return true;
/*     */   }
/*     */   
/*     */   private boolean a(Document paramDocument, List<j> paramList, List<String> paramList1) throws Exception {
/* 106 */     Elements elements = paramDocument.select("table[id=formMinhasPropostasPEPageList:propostaDataTable] > tbody > tr");
/* 107 */     for (Element element : elements) {
/* 108 */       if (a().get()) {
/* 109 */         return false;
/*     */       }
/*     */       
/* 112 */       String str1 = element.select("span[id$=:numProcessoText]").first().text().trim();
/* 113 */       if (paramList1.contains(str1)) {
/*     */         continue;
/*     */       }
/*     */       
/* 117 */       String str2 = element.select("a[id$=:visualizarLink]").first().attr("onclick");
/* 118 */       str2 = str2.replaceAll(".*?(?:\\'idPropostaPregaoHidden\\'\\:).*?[\\']", "");
/* 119 */       str2 = str2.replaceAll("\\'.*", "");
/*     */       
/* 121 */       String str3 = element.select("span[id$=:pregaoText]").first().text().trim();
/*     */       
/* 123 */       Optional<b> optional = paramList.stream().filter(paramj -> paramj.bo().equals(paramString)).findFirst();
/* 124 */       if (optional.isPresent()) {
/* 125 */         ((b)optional.get()).Z(str2);
/*     */         
/*     */         continue;
/*     */       } 
/* 129 */       j j = b(str1);
/* 130 */       if (j == null) {
/* 131 */         paramList1.add(str1); continue;
/*     */       } 
/* 133 */       String str4 = this.a.f(j.v());
/* 134 */       if (str4 == null || str4.trim().isEmpty()) {
/* 135 */         paramList1.add(str1);
/*     */         
/*     */         continue;
/*     */       } 
/* 139 */       Document document = Jsoup.parse(str4);
/* 140 */       String str5 = document.select("label[id=fieldAbertura]").first().text().trim();
/* 141 */       Calendar calendar = y.c(str5);
/* 142 */       if (a(calendar)) {
/* 143 */         return false;
/*     */       }
/*     */       
/* 146 */       if (a(j.v())) {
/* 147 */         paramList1.add(str1);
/*     */         
/*     */         continue;
/*     */       } 
/* 151 */       ((b)j).Z(str2);
/* 152 */       String str6 = element.select("span[id$=:descResumidaText]").first().text().trim();
/* 153 */       j.T(str1);
/* 154 */       j.aw(str6);
/* 155 */       j.az(str3);
/*     */       
/* 157 */       j.b(calendar);
/* 158 */       j.s(b(document));
/* 159 */       j.a(a(document));
/* 160 */       j.Y(2);
/* 161 */       paramList.add(j);
/*     */     } 
/*     */ 
/*     */     
/* 165 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private j b(String paramString) throws Exception {
/* 171 */     if (this.e.contains(j.g) && !a().get()) {
/* 172 */       if (this.M == null) {
/* 173 */         this.M = a().aq();
/*     */       }
/*     */       
/* 176 */       String str = a().e(paramString, this.M);
/* 177 */       int j = a(str, paramString, ":agendaDataTable", ":LoteText", ":visualizarLoteLink", "idPregao");
/* 178 */       if (j > 0) {
/* 179 */         b b = new b(a().a(), j);
/* 180 */         b.a(j.g);
/* 181 */         return (j)b;
/*     */       } 
/*     */     } 
/*     */     
/* 185 */     if (this.e.contains(j.a) && !a().get()) {
/*     */       
/* 187 */       if (this.J == null) {
/* 188 */         this.J = a().am();
/*     */       }
/*     */       
/* 191 */       String str = a().a(paramString, this.J);
/* 192 */       int j = a(str, paramString, ":agendaDataTable", ":LoteText", ":visualizarLoteLink", "idPregao");
/* 193 */       if (j > 0) {
/* 194 */         b b = new b(a().a(), j);
/* 195 */         b.a(j.a);
/* 196 */         return (j)b;
/*     */       } 
/*     */ 
/*     */       
/* 200 */       if (this.K == null) {
/* 201 */         this.K = a().an();
/*     */       }
/*     */       
/* 204 */       str = a().b(paramString, this.K);
/* 205 */       j = a(str, paramString, ":listaDataTable", ":processoText", ":visualizarLink", "idPregao");
/* 206 */       if (j > 0) {
/* 207 */         b b = new b(a().a(), j);
/* 208 */         b.a(j.a);
/* 209 */         return (j)b;
/*     */       } 
/*     */     } 
/*     */     
/* 213 */     if (this.e.contains(j.d) && !a().get()) {
/* 214 */       if (this.I == null) {
/* 215 */         this.I = a().ao();
/*     */       }
/*     */       
/* 218 */       String str = a().c(paramString, this.I);
/* 219 */       int j = a(str, paramString, ":pregaoDataTable", ":processoText", ":visualizarLink", "idPregaoSel");
/* 220 */       if (j > 0) {
/* 221 */         b b = new b(a().a(), j);
/* 222 */         b.a(j.d);
/* 223 */         return (j)b;
/*     */       } 
/*     */       
/* 226 */       if (this.L == null) {
/* 227 */         this.L = a().ap();
/*     */       }
/*     */       
/* 230 */       str = a().d(paramString, this.L);
/* 231 */       j = a(str, paramString, ":agendaDataTable", ":LoteText", ":visualizarLoteLink", "idPregao");
/* 232 */       if (j > 0) {
/* 233 */         b b = new b(a().a(), j);
/* 234 */         b.a(j.c);
/* 235 */         return (j)b;
/*     */       } 
/*     */     } 
/*     */     
/* 239 */     return null;
/*     */   }
/*     */   
/*     */   private boolean b(Document paramDocument) throws Exception {
/*     */     try {
/* 244 */       Elements elements = paramDocument.select("tr");
/* 245 */       for (Element element : elements) {
/* 246 */         if (!element.select("label[id=lbLancamentoPor]").isEmpty()) {
/* 247 */           return element.select("label[id=lbFichaField]").text().toLowerCase().equals("valor unitário");
/*     */         }
/*     */       } 
/* 250 */     } catch (Exception exception) {
/* 251 */       a.warn("Failed to capture bid type is Srp");
/* 252 */       throw new Exception(exception);
/*     */     } 
/*     */     
/* 255 */     return false;
/*     */   }
/*     */   
/*     */   private u a(Document paramDocument) throws Exception {
/*     */     try {
/* 260 */       if (!paramDocument.select("label[id=lbTipoLicitacaoField]").first().text().trim().toLowerCase().equals("menor preço")) {
/* 261 */         return u.h;
/*     */       }
/* 263 */     } catch (Exception exception) {
/* 264 */       a.warn("Failed to capture bid type");
/* 265 */       throw new Exception(exception);
/*     */     } 
/*     */     
/* 268 */     return u.c;
/*     */   }
/*     */ 
/*     */   
/*     */   private int a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) throws Exception {
/*     */     try {
/* 274 */       if (!paramString1.contains("Nenhum registro encontrado")) {
/* 275 */         Document document = Jsoup.parse(paramString1);
/* 276 */         Elements elements = document.select("table[id$=" + paramString3 + "] > tbody > tr");
/* 277 */         for (Element element : elements) {
/* 278 */           String str = element.select("span[id$=" + paramString4 + "]").first().text().trim();
/* 279 */           if (str.equals(paramString2)) {
/* 280 */             String str1 = element.select("a[id$=" + paramString5 + "]").first().attr("onclick");
/* 281 */             str1 = str1.replaceAll(".*?(?:\\'" + paramString6 + "\\'\\:).*?[\\']", "");
/* 282 */             str1 = str1.replaceAll("\\'.*", "");
/*     */             
/* 284 */             return Integer.parseInt(str1);
/*     */           }
/*     */         
/*     */         } 
/*     */       } 
/* 289 */     } catch (Exception exception) {
/* 290 */       a.error("Erro ao pegar o código do pregão");
/* 291 */       throw new Exception(exception);
/*     */     } 
/*     */     
/* 294 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public b a() {
/* 299 */     return (b)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\b\a\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */