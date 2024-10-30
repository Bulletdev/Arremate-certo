/*     */ package br.com.arremate.b.a;
/*     */ 
/*     */ import br.com.arremate.f.j;
/*     */ import br.com.arremate.f.l;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.j.k.a;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.n.b;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.List;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ public class p
/*     */   extends a
/*     */ {
/*  25 */   private final SimpleDateFormat a = new SimpleDateFormat("dd/MM/yy hh:mm");
/*     */   private boolean e = false;
/*     */   
/*     */   public p(a parama) {
/*  29 */     super((i)parama);
/*     */   }
/*     */ 
/*     */   
/*     */   protected List<j> a(List<j> paramList) throws Exception {
/*  34 */     ArrayList<b> arrayList = new ArrayList();
/*  35 */     arrayList.addAll(a(paramList, "SR"));
/*  36 */     arrayList.addAll(a(paramList, "CR"));
/*  37 */     return (List)arrayList;
/*     */   }
/*     */   
/*     */   private List<b> a(List<j> paramList, String paramString) throws ParseException {
/*  41 */     this.e = false;
/*  42 */     ArrayList<b> arrayList = new ArrayList();
/*  43 */     byte b = 1;
/*  44 */     int i = 1;
/*     */     
/*     */     do {
/*  47 */       String str = a().m(b, paramString).getData();
/*  48 */       Document document = Jsoup.parse(str);
/*     */       
/*  50 */       Element element = document.select("a[href*=pbf_ultima_pagina]").first();
/*  51 */       if (element != null) {
/*  52 */         i = Integer.parseInt(element.attr("href").replaceAll("[^\\d]", ""));
/*     */       }
/*     */       
/*  55 */       a(paramList, document, paramString, arrayList);
/*  56 */       ++b;
/*  57 */     } while (b <= i && !this.e);
/*     */     
/*  59 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   private List<b> a(List<j> paramList, Document paramDocument, String paramString, ArrayList<b> paramArrayList) throws ParseException {
/*  64 */     Elements elements = paramDocument.select("table[class=tabela_listagem]").first().select("tr[class=listagem_linha]");
/*  65 */     for (Element element : elements) {
/*  66 */       Elements elements1 = element.select("td");
/*  67 */       String str1 = elements1.first().select("a").first().text();
/*     */       
/*  69 */       if (a(str1) || a().get()) {
/*     */         continue;
/*     */       }
/*     */       
/*  73 */       String str2 = elements1.last().text();
/*     */       
/*  75 */       if ("cancelado".equalsIgnoreCase(str2)) {
/*     */         continue;
/*     */       }
/*     */       
/*  79 */       String str3 = a().b(1, paramString, str1).getData();
/*  80 */       Document document = Jsoup.parse(str3);
/*  81 */       Elements elements2 = document.select("table[class=box_simples]").first().select("td");
/*  82 */       Calendar calendar = a(elements2);
/*     */       
/*  84 */       if (a(calendar)) {
/*  85 */         this.e = true;
/*     */         
/*     */         break;
/*     */       } 
/*  89 */       j j = a(elements2.get(4).text(), paramString, str1);
/*     */       
/*  91 */       if (!paramList.contains(j)) {
/*     */         continue;
/*     */       }
/*     */       
/*  95 */       b b = new b(a().a(), Integer.parseInt(str1));
/*  96 */       b.a(l.a);
/*  97 */       b.a(u.c);
/*  98 */       b.z(true);
/*  99 */       b.a(j);
/* 100 */       b.T(elements2.get(6).text());
/* 101 */       b.b(calendar);
/* 102 */       b.aw(elements2.get(22).text());
/* 103 */       b.s(paramString.equals("CR"));
/* 104 */       b.a(a(document));
/*     */       
/* 106 */       paramArrayList.add(b);
/*     */     } 
/*     */     
/* 109 */     return paramArrayList;
/*     */   }
/*     */   
/*     */   private Calendar a(Elements paramElements) throws ParseException {
/* 113 */     Calendar calendar = Calendar.getInstance();
/* 114 */     String str = paramElements.get(12).text().replace(" ", "").trim();
/* 115 */     if (str.isEmpty()) {
/* 116 */       str = paramElements.get(10).text().replace(" ", "").trim();
/*     */     }
/* 118 */     calendar.setTime(this.a.parse(str));
/* 119 */     return calendar;
/*     */   }
/*     */   
/*     */   private m a(Document paramDocument) {
/* 123 */     String str = paramDocument.select("input[name=tipoDisputa]").first().val();
/* 124 */     switch (str) {
/*     */       case "randomico":
/* 126 */         return m.a;
/*     */       case "determinado":
/* 128 */         return m.b;
/*     */     } 
/* 130 */     return m.e;
/*     */   }
/*     */ 
/*     */   
/*     */   private j a(String paramString1, String paramString2, String paramString3) {
/* 135 */     switch (paramString1) {
/*     */       case "Fase de acolhimento das propostas":
/*     */       case "Fase de abertura das propostas":
/*     */       case "Análise das propostas":
/*     */       case "Análise das propostas encerrada":
/*     */       case "Acolhimento de Propostas Encerrada":
/* 141 */         return j.d;
/*     */       case "Consultar Status no Item":
/* 143 */         if (!b(paramString2, paramString3))
/* 144 */           return j.a; 
/*     */         break;
/*     */     } 
/* 147 */     return j.g;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean b(String paramString1, String paramString2) {
/* 152 */     e e = a().n(paramString1, paramString2);
/* 153 */     Document document = Jsoup.parse(e.getData());
/*     */     
/* 155 */     Elements elements = document.select("tr[class=listagem_linha]");
/* 156 */     if (elements != null && !elements.isEmpty()) {
/* 157 */       for (Element element : elements) {
/* 158 */         String str = element.select("td").last().text();
/* 159 */         if (str.equals("EM DISPUTA")) {
/* 160 */           return false;
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 165 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final a a() {
/* 170 */     return (a)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\b\a\p.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */