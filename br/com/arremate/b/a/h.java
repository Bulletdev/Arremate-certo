/*     */ package br.com.arremate.b.a;
/*     */ 
/*     */ import br.com.arremate.f.j;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.g.b;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.m.y;
/*     */ import java.net.URLDecoder;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.Optional;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class h
/*     */   extends a
/*     */ {
/*     */   private String F;
/*     */   private String G;
/*     */   private String H;
/*     */   
/*     */   public h(i parami) {
/*  33 */     super(parami);
/*     */   }
/*     */ 
/*     */   
/*     */   protected List<j> a(List<j> paramList) throws Exception {
/*  38 */     this.F = null;
/*  39 */     this.G = null;
/*  40 */     this.H = null;
/*     */     
/*  42 */     String str = a().ah();
/*  43 */     Document document = Jsoup.parse(str);
/*     */     
/*  45 */     this.F = document.getElementById("__VIEWSTATE").val().trim();
/*  46 */     this.G = document.getElementById("__VIEWSTATEGENERATOR").val().trim();
/*  47 */     this.H = document.getElementById("__PREVIOUSPAGE").val().trim();
/*     */     
/*  49 */     ArrayList<j> arrayList = new ArrayList();
/*  50 */     for (j j : paramList) {
/*  51 */       switch (null.b[j.ordinal()]) {
/*     */         case 1:
/*  53 */           str = a().a(this.F, this.G, this.H);
/*     */           break;
/*     */         case 2:
/*  56 */           str = a().b(this.F, this.G, this.H);
/*     */           break;
/*     */         case 3:
/*  59 */           str = a().c(this.F, this.G, this.H);
/*     */           break;
/*     */       } 
/*     */       
/*  63 */       document = Jsoup.parse(str);
/*  64 */       a(document, arrayList, j);
/*     */     } 
/*     */     
/*  67 */     return arrayList;
/*     */   }
/*     */   
/*     */   private void a(Document paramDocument, ArrayList<j> paramArrayList, j paramj) throws Exception {
/*  71 */     b(paramDocument, paramArrayList, paramj);
/*     */     
/*  73 */     Element element = paramDocument.getElementById("ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolderPublico_ctlPaginador");
/*  74 */     int i = Integer.parseInt(element.select("li[class=info]").first().text().replace("1 de ", "").trim());
/*  75 */     if (i > 1) {
/*  76 */       byte b = 2;
/*  77 */       String str = paramDocument.select("form[name=aspnetForm]").attr("action").replace("./LicitacoesPorStatus.aspx?", "LicitacoesPorStatus.aspx?");
/*     */       
/*     */       do {
/*  80 */         String str1 = paramDocument.getElementById("__VIEWSTATE").val().trim();
/*  81 */         String str2 = paramDocument.getElementById("__VIEWSTATEGENERATOR").val().trim();
/*  82 */         String str3 = paramDocument.getElementById("__PREVIOUSPAGE").val().trim();
/*  83 */         String str4 = paramDocument.getElementById("__EVENTVALIDATION").val().trim();
/*     */         
/*  85 */         String str5 = a().a(str, str1, str2, str3, str4);
/*  86 */         paramDocument = Jsoup.parse(str5);
/*  87 */         b(paramDocument, paramArrayList, paramj);
/*  88 */         ++b;
/*  89 */       } while (b < i && !a().get());
/*     */     } 
/*     */   }
/*     */   
/*     */   private void b(Document paramDocument, ArrayList<j> paramArrayList, j paramj) throws Exception {
/*  94 */     Element element = paramDocument.select("table#ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolderPublico_gvLicitacoes").first();
/*  95 */     Elements elements = element.select("tr");
/*  96 */     elements.remove(0);
/*     */     
/*  98 */     for (Element element1 : elements) {
/*  99 */       if (a().get()) {
/*     */         break;
/*     */       }
/*     */       
/* 103 */       Elements elements1 = element1.select("td");
/* 104 */       String str = elements1.get(2).text().toLowerCase();
/* 105 */       if (str.contains("pregão eletrônico")) {
/* 106 */         String str1 = elements1.get(3).text().toLowerCase().trim();
/* 107 */         if (!str1.isEmpty() && !str1.contains("sine die")) {
/* 108 */           Calendar calendar = y.c(str1);
/* 109 */           if (a(calendar)) {
/*     */             continue;
/*     */           }
/*     */         } 
/*     */         
/* 114 */         String str2 = elements1.get(0).text().trim();
/* 115 */         if (a(str2)) {
/*     */           continue;
/*     */         }
/*     */         
/* 119 */         e e = a().k(str2);
/* 120 */         if (e.getData().isEmpty()) {
/*     */           continue;
/*     */         }
/*     */         
/* 124 */         paramDocument = Jsoup.parse(e.getData());
/* 125 */         Element element2 = paramDocument.getElementById("ctl00_ctl00_ContentPlaceHolder1_BarraFerramentasContexto_LinkButtonInscreverPropostaComercial");
/* 126 */         if (element2 != null) {
/*     */           continue;
/*     */         }
/*     */         
/* 130 */         Elements elements2 = paramDocument.select("table#ctl00_ctl00_ContentPlaceHolder1_Abas1_TableAbas").select("tr").select("td[class=abaCinzaCenter]");
/* 131 */         Optional<Element> optional = elements2.stream().filter(paramElement -> paramElement.text().toLowerCase().contains("proposta")).findFirst();
/* 132 */         if (!optional.isPresent()) {
/*     */           continue;
/*     */         }
/*     */         
/* 136 */         if (a().get()) {
/*     */           break;
/*     */         }
/*     */         
/* 140 */         j j1 = a(str2, optional.get(), paramDocument);
/* 141 */         if (j1 != null) {
/* 142 */           j1.a(paramj);
/* 143 */           paramArrayList.add(j1);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected List<j> a(String paramString) throws Exception {
/* 151 */     e e = a().k(paramString);
/* 152 */     if (e.getData().isEmpty()) {
/* 153 */       return null;
/*     */     }
/*     */     
/* 156 */     Document document = Jsoup.parse(e.getData());
/* 157 */     Element element = document.getElementById("ctl00_ctl00_ContentPlaceHolder1_BarraFerramentasContexto_LinkButtonInscreverPropostaComercial");
/* 158 */     if (element != null) {
/* 159 */       f("Não foi possível capturar o edital! A proposta comercial ainda não foi enviada para este pregão!");
/* 160 */       return null;
/*     */     } 
/*     */     
/* 163 */     Elements elements = document.select("table#ctl00_ctl00_ContentPlaceHolder1_Abas1_TableAbas").select("tr").select("td[class=abaCinzaCenter]");
/* 164 */     Optional<Element> optional = elements.stream().filter(paramElement -> paramElement.text().toLowerCase().contains("proposta")).findFirst();
/* 165 */     if (!optional.isPresent()) {
/* 166 */       f("Não foi possível capturar o edital! O fornecedor não está cadastrado no(s) grupo(s) de mercadoria exigido(s) no edital para participar do pregão ou o fornecedor se cadastrou após a publicação do mesmo!");
/* 167 */       return null;
/*     */     } 
/*     */     
/* 170 */     j j = a(paramString, optional.get(), document);
/* 171 */     if (j != null) {
/* 172 */       String str = document.getElementById("ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder1_ctl09_lblStatus").text().toLowerCase();
/* 173 */       if (str.contains("inscrição de proposta") || str.contains("aguardando abertura")) {
/* 174 */         j.a(j.d);
/* 175 */       } else if (str.contains("em lances")) {
/* 176 */         j.a(j.a);
/*     */       } else {
/* 178 */         j.a(j.g);
/*     */       } 
/*     */       
/* 181 */       ArrayList<j> arrayList = new ArrayList();
/* 182 */       arrayList.add(j);
/*     */       
/* 184 */       return arrayList;
/*     */     } 
/*     */     
/* 187 */     return null;
/*     */   }
/*     */   
/*     */   private j a(String paramString, Element paramElement, Document paramDocument) {
/*     */     try {
/* 192 */       int i = Math.abs(Objects.hashCode(paramString));
/* 193 */       String str1 = paramDocument.getElementById("ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder1_ctl09_lblEmpresa").text().trim();
/*     */       
/* 195 */       String str2 = "";
/* 196 */       String str3 = paramDocument.getElementById("ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder1_ctl09_lblDataAberturaSessao").text().toLowerCase().trim();
/* 197 */       if (str3.isEmpty() || str3.contains("sine die")) {
/* 198 */         str2 = "Data referente a abertura de proposta";
/* 199 */         str3 = paramDocument.getElementById("ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder1_ctl09_lblDataAberturaProposta").text().trim();
/*     */         
/* 201 */         if (str3.isEmpty() || str3.contains("sine die")) {
/* 202 */           str2 = "Data referente ao limite spres. proposta";
/* 203 */           str3 = paramDocument.getElementById("ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder1_ctl09_lblDataLimiteApres").text().trim();
/*     */           
/* 205 */           if (str3.isEmpty() || str3.contains("sine die")) {
/* 206 */             str2 = "Data referente a data de publicação";
/* 207 */             str3 = paramDocument.getElementById("ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder1_ctl09_lblDataPublicacao").text().trim();
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 212 */       Calendar calendar = y.c(str3);
/*     */       
/* 214 */       String str4 = paramElement.select("a").attr("href").trim().replace("../Proposta/ApresentarProposta.aspx?token=", "");
/* 215 */       str4 = URLDecoder.decode(str4, "UTF-8");
/*     */       
/* 217 */       b b = new b(a().a(), i);
/* 218 */       b.T(paramString);
/* 219 */       b.aw(str1);
/* 220 */       b.a(m.a);
/* 221 */       b.ay(str2);
/* 222 */       b.b(calendar);
/* 223 */       b.aA(str4);
/* 224 */       return (j)b;
/* 225 */     } catch (Exception exception) {
/* 226 */       a.warn("Failed to load bidding {}", paramString);
/*     */ 
/*     */       
/* 229 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public a a() {
/* 234 */     return (a)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\b\a\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */