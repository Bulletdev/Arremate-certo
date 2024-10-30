/*     */ package br.com.arremate.b.a;
/*     */ 
/*     */ import br.com.arremate.f.j;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.j.f;
/*     */ import br.com.arremate.j.g;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.l.b;
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
/*     */ public class n
/*     */   extends a
/*     */ {
/*     */   private g a;
/*     */   private List<j> e;
/*     */   private String I;
/*     */   private String J;
/*     */   private String L;
/*     */   private String M;
/*     */   
/*     */   public n(i parami) {
/*  35 */     super(parami);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<j> a(List<j> paramList) throws Exception {
/*  40 */     this.e = paramList;
/*  41 */     this.I = null;
/*  42 */     this.J = null;
/*  43 */     this.L = null;
/*  44 */     this.M = null;
/*  45 */     this.a = new g(a());
/*  46 */     this.a.z();
/*     */     
/*  48 */     ArrayList<j> arrayList = new ArrayList();
/*  49 */     ArrayList<String> arrayList1 = new ArrayList();
/*  50 */     int i = 1, j = 1;
/*  51 */     String str = null;
/*     */     
/*     */     do {
/*     */       Document document;
/*     */       String str1;
/*  56 */       if (a().get()) {
/*  57 */         return arrayList;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*  62 */       if (i == 1) {
/*  63 */         str1 = a().ak();
/*  64 */         document = Jsoup.parse(str1);
/*  65 */         str = document.select("input[id=javax.faces.ViewState]").val();
/*     */       } else {
/*  67 */         str1 = a().c(i, str);
/*  68 */         document = Jsoup.parse(str1);
/*     */       } 
/*     */       
/*  71 */       if (!a(document, arrayList, arrayList1)) {
/*     */         break;
/*     */       }
/*     */       
/*  75 */       if (i != j || i >= 2 || 
/*  76 */         !str1.contains("dataScrolleridx"))
/*  77 */         continue;  int k = Integer.parseInt(document.select("tfoot a[id*=:dataScrolleridx]").last().text());
/*  78 */       if (k <= 1)
/*  79 */         continue;  j = k;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  84 */       ++i;
/*  85 */     } while (i <= j);
/*     */     
/*  87 */     return arrayList;
/*     */   }
/*     */   
/*     */   private boolean a(Document paramDocument, List<j> paramList, List<String> paramList1) throws Exception {
/*  91 */     Elements elements = paramDocument.select("table[id=formMinhasPropostasPEPageList:propostaDataTable] > tbody > tr");
/*  92 */     for (Element element : elements) {
/*  93 */       if (a().get()) {
/*  94 */         return false;
/*     */       }
/*     */       
/*  97 */       String str1 = element.select("span[id$=:numProcessoText]").first().text().trim();
/*  98 */       if (paramList1.contains(str1)) {
/*     */         continue;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 106 */       String str2 = element.select("span[id$=:pregaoText]").first().text().trim();
/*     */       
/* 108 */       Optional optional = paramList.stream().filter(paramj -> paramj.bo().equals(paramString)).findFirst();
/* 109 */       if (optional.isPresent()) {
/*     */         continue;
/*     */       }
/*     */ 
/*     */       
/* 114 */       j j = b(str1);
/* 115 */       if (j == null) {
/* 116 */         paramList1.add(str1); continue;
/*     */       } 
/* 118 */       String str3 = this.a.f(j.v());
/* 119 */       if (str3 == null || str3.trim().isEmpty()) {
/* 120 */         paramList1.add(str1);
/*     */         
/*     */         continue;
/*     */       } 
/* 124 */       Document document = Jsoup.parse(str3);
/* 125 */       String str4 = document.select("label[id=fieldAbertura]").first().text().trim();
/* 126 */       Calendar calendar = y.c(str4);
/* 127 */       if (a(calendar)) {
/* 128 */         return false;
/*     */       }
/*     */       
/* 131 */       if (a(j.v())) {
/* 132 */         paramList1.add(str1);
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/* 137 */       String str5 = element.select("span[id$=:descResumidaText]").first().text().trim();
/* 138 */       j.T(str1);
/* 139 */       j.aw(str5);
/* 140 */       j.az(str2);
/*     */       
/* 142 */       j.b(calendar);
/* 143 */       j.s(b(document));
/* 144 */       j.a(a(document));
/* 145 */       j.Y(2);
/* 146 */       j.a(m.e);
/* 147 */       paramList.add(j);
/*     */     } 
/*     */ 
/*     */     
/* 151 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private j b(String paramString) throws Exception {
/* 157 */     if (this.e.contains(j.g) && !a().get()) {
/* 158 */       if (this.M == null) {
/* 159 */         this.M = a().aq();
/*     */       }
/*     */       
/* 162 */       String str = a().e(paramString, this.M);
/* 163 */       int i = a(str, paramString, ":agendaDataTable", ":LoteText", ":visualizarLoteLink", "idPregao");
/* 164 */       if (i > 0) {
/* 165 */         b b = new b(a().a(), i);
/* 166 */         b.a(j.g);
/* 167 */         return (j)b;
/*     */       } 
/*     */     } 
/*     */     
/* 171 */     if (this.e.contains(j.a) && !a().get()) {
/* 172 */       if (this.J == null) {
/* 173 */         this.J = a().am();
/*     */       }
/*     */       
/* 176 */       String str = a().a(paramString, this.J);
/* 177 */       int i = a(str, paramString, ":agendaDataTable", ":LoteText", ":visualizarLoteLink", "idPregao");
/* 178 */       if (i > 0) {
/* 179 */         b b = new b(a().a(), i);
/* 180 */         b.a(j.a);
/* 181 */         return (j)b;
/*     */       } 
/*     */     } 
/*     */     
/* 185 */     if (this.e.contains(j.d) && !a().get()) {
/* 186 */       if (this.I == null) {
/* 187 */         this.I = a().ao();
/*     */       }
/*     */       
/* 190 */       String str = a().c(paramString, this.I);
/* 191 */       int i = a(str, paramString, ":pregaoDataTable", ":processoText", ":visualizarLink", "idPregaoSel");
/* 192 */       if (i > 0) {
/* 193 */         b b = new b(a().a(), i);
/* 194 */         b.a(j.d);
/* 195 */         return (j)b;
/*     */       } 
/*     */       
/* 198 */       if (this.L == null) {
/* 199 */         this.L = a().ap();
/*     */       }
/*     */       
/* 202 */       str = a().d(paramString, this.L);
/* 203 */       i = a(str, paramString, ":agendaDataTable", ":LoteText", ":visualizarLoteLink", "idPregao");
/* 204 */       if (i > 0) {
/* 205 */         b b = new b(a().a(), i);
/* 206 */         b.a(j.c);
/* 207 */         return (j)b;
/*     */       } 
/*     */     } 
/*     */     
/* 211 */     return null;
/*     */   }
/*     */   
/*     */   private boolean b(Document paramDocument) throws Exception {
/*     */     try {
/* 216 */       Elements elements = paramDocument.select("tr");
/* 217 */       for (Element element : elements) {
/* 218 */         if (!element.select("label[id=lbLancamentoPor]").isEmpty()) {
/* 219 */           return element.select("label[id=lbFichaField]").text().toLowerCase().equals("valor unitário");
/*     */         }
/*     */       } 
/* 222 */     } catch (Exception exception) {
/* 223 */       a.warn("Failed to capture bid type is Srp");
/* 224 */       throw new Exception(exception);
/*     */     } 
/*     */     
/* 227 */     return false;
/*     */   }
/*     */   
/*     */   private u a(Document paramDocument) throws Exception {
/*     */     try {
/* 232 */       if (!paramDocument.select("label[id=lbTipoLicitacaoField]").first().text().trim().toLowerCase().equals("menor preço")) {
/* 233 */         return u.h;
/*     */       }
/* 235 */     } catch (Exception exception) {
/* 236 */       a.warn("Failed to capture bid type");
/* 237 */       throw new Exception(exception);
/*     */     } 
/*     */     
/* 240 */     return u.c;
/*     */   }
/*     */ 
/*     */   
/*     */   private int a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) throws Exception {
/*     */     try {
/* 246 */       if (!paramString1.contains("Nenhum registro encontrado")) {
/* 247 */         Document document = Jsoup.parse(paramString1);
/* 248 */         Elements elements = document.select("table[id$=" + paramString3 + "] > tbody > tr");
/* 249 */         for (Element element : elements) {
/* 250 */           String str = element.select("span[id$=" + paramString4 + "]").first().text().trim();
/* 251 */           if (str.equals(paramString2)) {
/* 252 */             String str1 = element.select("a[id$=" + paramString5 + "]").first().attr("onclick");
/* 253 */             str1 = str1.replaceAll(".*?(?:\\'" + paramString6 + "\\'\\:).*?[\\']", "");
/* 254 */             str1 = str1.replaceAll("\\'.*", "");
/*     */             
/* 256 */             return Integer.parseInt(str1);
/*     */           }
/*     */         
/*     */         } 
/*     */       } 
/* 261 */     } catch (NumberFormatException numberFormatException) {
/* 262 */       a.error("Erro ao pegar o código do pregão");
/* 263 */       throw new Exception(numberFormatException);
/*     */     } 
/*     */     
/* 266 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public f a() {
/* 271 */     return (f)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\b\a\n.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */