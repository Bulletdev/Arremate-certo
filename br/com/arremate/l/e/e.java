/*     */ package br.com.arremate.l.e;
/*     */ 
/*     */ import br.com.arremate.f.v;
/*     */ import br.com.arremate.j.c.c;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.l.g;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class e
/*     */   extends c
/*     */ {
/*  25 */   private static final Logger a = LoggerFactory.getLogger(c.class);
/*     */   
/*     */   public e(d paramd, int paramInt) {
/*  28 */     super(paramd, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<g> a(i parami) {
/*  33 */     ArrayList<a> arrayList = new ArrayList();
/*     */     
/*  35 */     if (parami instanceof c && parami.isRunning()) {
/*  36 */       c c1 = (c)parami;
/*     */ 
/*     */       
/*  39 */       String str = c1.e(v()).getData();
/*     */       
/*  41 */       Document document = Jsoup.parse(str);
/*  42 */       Element element = document.select("table[class=td] > tbody").first();
/*     */       
/*  44 */       if (element != null) {
/*     */         
/*  46 */         Elements elements1 = element.select("tr[class=tex3]");
/*     */         
/*  48 */         Elements elements2 = element.select("tr[class=tex3a]");
/*  49 */         byte b1 = 0;
/*     */         
/*  51 */         for (byte b2 = 1; b2 < elements1.size(); b2++) {
/*  52 */           Elements elements = elements1.get(b2).select("td");
/*     */           
/*  54 */           if (!elements.toString().toLowerCase().contains("consultar proposta do grupo")) {
/*  55 */             if (elements.toString().contains("DescrComplementar")) {
/*  56 */               Elements elements3 = elements2.get(b1).select("td");
/*  57 */               a a = a(elements, elements3);
/*     */               
/*  59 */               if (a == null) {
/*  60 */                 arrayList.clear();
/*     */                 
/*     */                 break;
/*     */               } 
/*  64 */               arrayList.add(a);
/*  65 */               b1++;
/*     */             } 
/*     */           } else {
/*  68 */             List<g> list = a(c1, elements);
/*     */             
/*  70 */             if (list.isEmpty()) {
/*  71 */               arrayList.clear();
/*     */               
/*     */               break;
/*     */             } 
/*  75 */             arrayList.addAll(list);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  82 */     return (List)arrayList;
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
/*     */   protected List<g> a(c paramc, Elements paramElements) {
/*  94 */     ArrayList<a> arrayList = new ArrayList();
/*     */     
/*  96 */     String str1 = N(paramElements.get(1).toString());
/*  97 */     String str2 = paramElements.get(0).text().trim();
/*     */ 
/*     */     
/* 100 */     String str3 = paramc.d(v(), str1).getData();
/*     */     
/* 102 */     Document document = Jsoup.parse(str3);
/* 103 */     Element element = document.select("table[class=td] > tbody").first();
/*     */     
/* 105 */     if (element != null) {
/*     */       
/* 107 */       Elements elements1 = element.select("tr[class=tex3]");
/*     */       
/* 109 */       Elements elements2 = element.select("tr[class=tex3a]");
/* 110 */       byte b1 = 0;
/*     */ 
/*     */       
/* 113 */       for (byte b2 = 1; b2 < elements1.size(); b2++) {
/* 114 */         Elements elements = elements1.get(b2).select("td");
/*     */         
/* 116 */         if (elements.toString().contains("DescrComplementar")) {
/*     */           
/* 118 */           Elements elements3 = elements2.get(b1).select("td");
/* 119 */           a a = a(elements, elements3, str1, str2);
/*     */           
/* 121 */           if (a == null) {
/* 122 */             arrayList.clear();
/*     */             
/*     */             break;
/*     */           } 
/* 126 */           arrayList.add(a);
/* 127 */           b1++;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 132 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private a a(Elements paramElements1, Elements paramElements2) {
/* 143 */     return a(paramElements1, paramElements2, "", "");
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
/*     */ 
/*     */   
/*     */   private a a(Elements paramElements1, Elements paramElements2, String paramString1, String paramString2) {
/*     */     try {
/* 158 */       byte b = aZ() ? 3 : 2;
/*     */       
/* 160 */       String str1 = String.valueOf(Integer.parseInt(paramElements1.get(0).text().trim()));
/* 161 */       String str2 = paramElements1.get(1).text().trim();
/* 162 */       String str3 = paramElements1.get(6).text().trim();
/* 163 */       int i = v.a.v();
/* 164 */       String str4 = paramElements2.get(1).text().trim();
/* 165 */       String str5 = paramElements2.get(b).text().trim();
/*     */ 
/*     */       
/* 168 */       if (aZ()) {
/* 169 */         str6 = paramElements2.get(2).text().trim();
/*     */       } else {
/* 171 */         str6 = paramElements1.get(7).text().trim();
/*     */       } 
/*     */ 
/*     */       
/* 175 */       str4 = str4.replace("Fator de Equalização", "").trim();
/* 176 */       str4 = str4.replace(".", "").replace(",", ".");
/* 177 */       str5 = str5.replace("Valor Total Equaliz. (R$)", "").trim();
/* 178 */       str5 = str5.replace(".", "").replace(",", ".");
/* 179 */       String str6 = str6.replace("Valor Unitário (R$)", "").replace("Valor Equalizado (R$)", "").trim();
/* 180 */       str6 = str6.replace("Qtd Ofertada)", "").replace(".", "").replace(",", ".");
/*     */ 
/*     */       
/* 183 */       String str7 = N(paramElements1.get(1).toString());
/*     */       
/* 185 */       a a = new a(Integer.parseInt(str7), this);
/* 186 */       a.T(str1);
/* 187 */       a.ag(str2);
/* 188 */       a.k(Integer.parseInt(str3));
/* 189 */       a.p(Double.parseDouble(str4));
/* 190 */       a.n(Double.parseDouble(str5));
/* 191 */       a.m(Double.parseDouble(str6));
/* 192 */       a.R(i);
/*     */       
/* 194 */       if (paramString1 != null && !paramString1.isEmpty()) {
/* 195 */         a.T(Integer.parseInt(paramString1));
/* 196 */         a.ai(paramString2);
/*     */       } 
/*     */       
/* 199 */       return a;
/* 200 */     } catch (Exception exception) {
/* 201 */       a.error("Erro ao capturar as informações dos itens", exception);
/*     */ 
/*     */       
/* 204 */       return null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\e\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */