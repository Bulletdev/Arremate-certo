/*     */ package br.com.arremate.b.a;
/*     */ 
/*     */ import br.com.arremate.f.j;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.j.a.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.b.b;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.m.y;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Calendar;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import java.util.Optional;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ public class c
/*     */   extends a {
/*     */   private final List<String> b;
/*     */   private final List<String> c;
/*     */   private final List<String> d;
/*     */   
/*     */   public c(a parama) {
/*  30 */     super((i)parama);
/*     */     
/*  32 */     this.b = Arrays.asList(new String[] { "edital publicado", "aguardando recebimento de propostas", "aguardando reativação do pregão", "pregão suspenso", "aguardando abertura de propostas", "analisando as propostas" });
/*     */     
/*  34 */     this.c = Arrays.asList(new String[] { "etapa de lances" });
/*  35 */     this.d = Arrays.asList(new String[] { "homologação", "análise da aceitabilidade do preço", "análise de recursos", "prazo para memoriais" });
/*     */   }
/*     */ 
/*     */   
/*     */   public List<j> a(List<j> paramList) throws Exception {
/*  40 */     ArrayList<j> arrayList = new ArrayList();
/*  41 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*  42 */     for (j j : paramList) {
/*  43 */       switch (null.b[j.ordinal()]) {
/*     */         case 1:
/*  45 */           hashMap.put(j, this.b);
/*     */         
/*     */         case 2:
/*  48 */           hashMap.put(j, this.c);
/*     */         
/*     */         case 3:
/*  51 */           hashMap.put(j, this.d);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     } 
/*  58 */     if (a().get()) {
/*  59 */       return arrayList;
/*     */     }
/*     */     
/*  62 */     String str = a().T();
/*  63 */     if (str != null && !str.isEmpty()) {
/*  64 */       Document document = Jsoup.parse(str);
/*  65 */       Element element = document.select("table[id=ctl00_ContentPlaceHolder1_WUC_Console_ResultadoPesquisaOC1_GridView_OC] > tbody").first();
/*     */       
/*  67 */       if (element != null && !element.text().isEmpty())
/*     */       {
/*  69 */         for (Element element1 : element.select("tr")) {
/*  70 */           if (a().get()) {
/*  71 */             return arrayList;
/*     */           }
/*     */           
/*  74 */           Elements elements = element1.select("td");
/*  75 */           if (elements.size() <= 0) {
/*     */             continue;
/*     */           }
/*     */           
/*  79 */           String str1 = elements.get(6).text().toLowerCase();
/*  80 */           if (str1.contains("convite")) {
/*     */             continue;
/*     */           }
/*     */           
/*  84 */           for (Map.Entry<Object, Object> entry : hashMap.entrySet()) {
/*  85 */             Optional optional = ((List)entry.getValue()).stream().filter(paramString2 -> paramString1.contains(paramString2)).findFirst();
/*  86 */             if (optional.isPresent()) {
/*     */               
/*  88 */               String[] arrayOfString = elements.get(8).text().split("-", 2);
/*  89 */               String str2 = arrayOfString[1].endsWith("-") ? arrayOfString[1].substring(0, arrayOfString[1].length() - 1) : arrayOfString[1];
/*  90 */               String str3 = arrayOfString[0];
/*     */               
/*  92 */               String str4 = elements.get(5).text().trim();
/*  93 */               int i = Math.abs(Objects.hashCode(str4));
/*  94 */               String str5 = elements.get(7).text().replace(".", "").trim();
/*  95 */               Calendar calendar = y.c(str5);
/*     */               
/*  97 */               if (!a(calendar) && !a(str4)) {
/*  98 */                 b b = new b(a().a(), i);
/*  99 */                 b.T(str4);
/* 100 */                 b.s(str1.contains("ata de registro de preço"));
/* 101 */                 b.b(calendar);
/* 102 */                 b.Q(Integer.parseInt(str3));
/* 103 */                 b.aw(str2);
/* 104 */                 b.a((j)entry.getKey());
/* 105 */                 b.a(m.b);
/* 106 */                 arrayList.add(b);
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 115 */     if (paramList.contains(j.g)) {
/* 116 */       arrayList.addAll(a());
/*     */     }
/*     */     
/* 119 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   protected List<j> a(String paramString) throws Exception {
/* 124 */     String str = a().e(paramString);
/* 125 */     Document document = Jsoup.parse(str);
/* 126 */     Elements elements = document.select("table[id=ctl00_conteudo_Tabela] > tbody > tr");
/* 127 */     if (elements.size() > 1) {
/* 128 */       j j; Elements elements1 = elements.get(1).select("td");
/*     */       
/* 130 */       int i = Math.abs(Objects.hashCode(paramString));
/* 131 */       String str1 = elements1.get(2).text().toLowerCase();
/*     */       
/* 133 */       if (this.c.contains(str1)) {
/* 134 */         j = j.a;
/* 135 */       } else if (this.b.contains(str1)) {
/* 136 */         j = j.d;
/*     */       } else {
/* 138 */         j = j.g;
/*     */       } 
/*     */       
/* 141 */       b b = new b(a().a(), i);
/* 142 */       b.T(paramString);
/* 143 */       b.a(j);
/* 144 */       b.b(y.c(elements1.get(3).text()));
/* 145 */       b.aw(elements1.get(5).text());
/* 146 */       b.a(m.b);
/*     */       
/* 148 */       ArrayList<b> arrayList = new ArrayList();
/* 149 */       arrayList.add(b);
/*     */       
/* 151 */       return (List)arrayList;
/*     */     } 
/*     */     
/* 154 */     return null;
/*     */   }
/*     */   
/*     */   private List<j> a() {
/* 158 */     ArrayList<j> arrayList = new ArrayList();
/* 159 */     String str = a().S();
/* 160 */     Document document = Jsoup.parse(str);
/* 161 */     Element element = document.select("table[id=ctl00_conteudo_Tabela] > tbody").first();
/*     */     
/* 163 */     Elements elements = element.select("tr");
/* 164 */     elements.remove(0);
/*     */     
/* 166 */     for (Element element1 : elements) {
/* 167 */       if (a().get()) {
/* 168 */         return arrayList;
/*     */       }
/*     */       
/* 171 */       Elements elements1 = element1.select("td");
/*     */       
/* 173 */       String str1 = elements1.get(1).text();
/* 174 */       int i = Math.abs(Objects.hashCode(str1));
/*     */       
/* 176 */       if (!a(str1)) {
/* 177 */         b b = new b(a().a(), i);
/* 178 */         b.T(str1);
/* 179 */         b.s(false);
/* 180 */         b.b(y.c(elements1.get(3).text()));
/* 181 */         b.aw(elements1.get(6).text());
/* 182 */         b.a(m.b);
/* 183 */         b.a(j.g);
/* 184 */         b.ay("Com Vencedor");
/* 185 */         arrayList.add(b);
/*     */       } 
/*     */     } 
/*     */     
/* 189 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public a a() {
/* 194 */     return (a)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\b\a\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */