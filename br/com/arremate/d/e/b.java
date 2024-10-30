/*     */ package br.com.arremate.d.e;
/*     */ 
/*     */ import br.com.arremate.g.d;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.c.e;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.m.n;
/*     */ import br.com.arremate.m.y;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.List;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.select.Elements;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class b
/*     */ {
/*  25 */   private static final Logger a = LoggerFactory.getLogger(b.class);
/*     */   
/*     */   private final e b;
/*     */   
/*     */   public b(e parame) {
/*  30 */     this.b = parame;
/*     */   }
/*     */   
/*     */   List<h> c(e parame) throws d {
/*  34 */     e e1 = a(parame);
/*  35 */     if (e1.getData().isEmpty()) {
/*  36 */       if (e1.O()) {
/*  37 */         throw new d(e1.k());
/*     */       }
/*     */       
/*  40 */       return new ArrayList<>();
/*     */     } 
/*     */     
/*  43 */     Document document = Jsoup.parse(e1.getData());
/*  44 */     return a(document, parame);
/*     */   }
/*     */   
/*     */   e a(e parame) {
/*  48 */     e e1 = new e();
/*     */     
/*  50 */     if (this.b != null) {
/*  51 */       e1 = this.b.a(parame.a().v(), parame.v());
/*  52 */       String str = e1.getData();
/*  53 */       if (str.contains("Não é possível visualizar os lances") || str.contains("Nenhum fornecedor deu lance para este item!")) {
/*  54 */         String str1 = str.contains("Não é possível visualizar os lances") ? "Não é possível visualizar os lances" : "Nenhum fornecedor deu lance para este item!";
/*  55 */         a.info("{} - Não foi possível capturar os melhores lances: {}", parame.bo(), str1);
/*  56 */         e1.setData("");
/*     */       } 
/*     */     } 
/*     */     
/*  60 */     return e1;
/*     */   }
/*     */   
/*     */   List<h> a(Document paramDocument, e parame) {
/*  64 */     ArrayList<h> arrayList = new ArrayList();
/*     */     
/*  66 */     if (paramDocument.html().contains("alert('Acesso negado!')")) {
/*  67 */       return arrayList;
/*     */     }
/*     */     
/*  70 */     Elements elements1 = paramDocument.select("table[class=td]");
/*  71 */     if (elements1 == null || elements1.isEmpty()) {
/*  72 */       a.info("{} - Não foi possível capturar os melhores lances: não encontrou a lista de lances", parame.bo());
/*  73 */       return arrayList;
/*     */     } 
/*     */     
/*  76 */     Elements elements2 = elements1.get(1).select("tr");
/*  77 */     elements2.remove(0);
/*     */     
/*  79 */     byte b1 = 1;
/*  80 */     int i = 0;
/*     */     
/*  82 */     while (i < elements2.size() && i >= 0) {
/*  83 */       Elements elements = elements2.get(i).select("td");
/*  84 */       String str1 = elements.get(6).text().toLowerCase();
/*  85 */       if (str1.contains("recusado")) {
/*  86 */         i = a(i, elements2);
/*     */         
/*     */         continue;
/*     */       } 
/*  90 */       String str2 = elements.get(0).text();
/*  91 */       String str3 = elements.get(1).text();
/*  92 */       String str4 = elements.get(4).text();
/*     */ 
/*     */ 
/*     */       
/*  96 */       if (parame.az() && !parame.ay()) {
/*  97 */         Elements elements3 = elements2.get(i + 1).select("td");
/*  98 */         str5 = elements3.get(2).select("span[class=tex5a]").text();
/*     */       } else {
/* 100 */         str5 = elements.get(3).text();
/*     */       } 
/* 102 */       String str5 = str5.replace("R$", "").trim();
/* 103 */       str5 = y.Q(str5);
/* 104 */       double d = Double.parseDouble(str5);
/* 105 */       Calendar calendar = y.c(str4);
/*     */ 
/*     */       
/* 108 */       elements = elements2.get(i + 1).select("td");
/* 109 */       String str6 = a("Porte da Empresa:", elements);
/* 110 */       boolean bool = str6.toLowerCase().contains("porte da empresa: me");
/* 111 */       String str7 = a("Modelo / Versão:", elements);
/* 112 */       String str8 = a("Marca:", elements);
/* 113 */       String str9 = a("Fabricante:", elements);
/*     */       
/* 115 */       h h = new h();
/* 116 */       h.l(b1);
/* 117 */       h.q(d);
/* 118 */       h.c(calendar.getTime());
/* 119 */       h.x(bool);
/*     */       
/*     */       try {
/* 122 */         long l = Long.parseLong(str2.replaceAll("\\D", ""));
/* 123 */         boolean bool1 = (l == this.b.a().x()) ? true : false;
/* 124 */         h.A(bool1);
/* 125 */       } catch (NumberFormatException numberFormatException) {
/* 126 */         a.error("error parsing CNPJ", numberFormatException);
/*     */       } 
/*     */       
/* 129 */       if (n.bQ()) {
/* 130 */         h.E(str3);
/* 131 */         h.D(str2);
/* 132 */         h.ap(str6);
/* 133 */         h.ao(str7);
/* 134 */         h.al(str8);
/* 135 */         h.am(str9);
/*     */       } 
/*     */       
/* 138 */       arrayList.add(h);
/*     */       
/* 140 */       b1++;
/* 141 */       i = a(i, elements2);
/*     */     } 
/*     */     
/* 144 */     return arrayList;
/*     */   }
/*     */   
/*     */   private String a(String paramString, Elements paramElements) {
/* 148 */     Elements elements = paramElements.select("span:containsOwn(" + paramString + ")");
/* 149 */     if (b(elements)) {
/* 150 */       return a(elements);
/*     */     }
/* 152 */     return "";
/*     */   }
/*     */   
/*     */   private boolean b(Elements paramElements) {
/* 156 */     return !paramElements.isEmpty();
/*     */   }
/*     */   
/*     */   private String a(Elements paramElements) {
/* 160 */     String str = paramElements.first().nextElementSibling().html();
/* 161 */     int i = str.indexOf("<");
/* 162 */     if (i != -1) {
/* 163 */       return str.substring(0, i);
/*     */     }
/* 165 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int a(int paramInt, Elements paramElements) {
/* 177 */     byte b1 = -1;
/*     */     try {
/* 179 */       String str = paramElements.get(paramInt).attr("bgcolor");
/*     */       
/* 181 */       for (int i = paramInt + 1; i < paramElements.size(); i++) {
/* 182 */         if (!paramElements.get(i).attr("bgcolor").equals(str)) {
/* 183 */           return i;
/*     */         }
/*     */       } 
/* 186 */     } catch (Exception exception) {
/* 187 */       a.error("Fim da lista ou indexAtual errado", exception);
/*     */     } 
/*     */     
/* 190 */     return b1;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\e\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */