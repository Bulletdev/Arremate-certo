/*     */ package br.com.arremate.b.a.a;
/*     */ 
/*     */ import br.com.arremate.b.a.a;
/*     */ import br.com.arremate.f.j;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.j.l.a.d;
/*     */ import br.com.arremate.l.e.f;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.m.y;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class c
/*     */   extends a
/*     */ {
/*     */   public c(d paramd) {
/*  30 */     super((i)paramd);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<j> a(List<j> paramList) throws Exception {
/*  35 */     ArrayList<j> arrayList = new ArrayList();
/*  36 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*  37 */     for (j j : paramList) {
/*  38 */       if (a().get()) {
/*  39 */         return arrayList;
/*     */       }
/*     */       
/*  42 */       switch (null.b[j.ordinal()]) {
/*     */         case 1:
/*  44 */           hashMap.put(a().c(), j);
/*     */         
/*     */         case 2:
/*  47 */           hashMap.put(a().d(), j);
/*     */         
/*     */         case 3:
/*  50 */           hashMap.put(a().e(), j);
/*  51 */           hashMap.put(a().f(), j);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     } 
/*  58 */     for (Map.Entry<Object, Object> entry : hashMap.entrySet()) {
/*  59 */       String str = ((e)entry.getKey()).getData();
/*  60 */       if (str.contains("Não existe pregão aberto no qual você tenha enviado proposta, ou o pregão ou o item do pregão que você enviou proposta já foi encerrado") || str
/*  61 */         .contains("No momento não existem propostas para consulta")) {
/*     */         continue;
/*     */       }
/*     */       
/*  65 */       a(str, (j)entry.getValue(), arrayList);
/*  66 */       if (a().get()) {
/*  67 */         return arrayList;
/*     */       }
/*     */     } 
/*     */     
/*  71 */     return arrayList;
/*     */   }
/*     */   
/*     */   private void a(String paramString, j paramj, List<j> paramList) throws Exception {
/*  75 */     Document document = Jsoup.parse(paramString);
/*  76 */     Element element = document.select("table[class=td] > tbody").first();
/*  77 */     if (element == null) {
/*     */       return;
/*     */     }
/*     */     
/*  81 */     Elements elements = element.select("tr");
/*  82 */     elements.remove(0);
/*  83 */     for (Element element1 : elements) {
/*  84 */       if (a().get()) {
/*     */         return;
/*     */       }
/*     */       
/*  88 */       Elements elements1 = element1.select("td");
/*     */       
/*  90 */       String str1 = elements1.get(4).text().trim();
/*  91 */       Calendar calendar = y.c(str1);
/*  92 */       if (a(calendar)) {
/*     */         continue;
/*     */       }
/*     */       
/*  96 */       Pattern pattern = Pattern.compile("(?<!\\d)\\d{6}(?!\\d)");
/*  97 */       String str2 = elements1.get(1).select("a").attr("onclick");
/*  98 */       Matcher matcher = pattern.matcher(str2);
/*  99 */       if (!matcher.find()) {
/*     */         continue;
/*     */       }
/*     */       
/* 103 */       int i = Integer.parseInt(matcher.group(0));
/* 104 */       if (a(i)) {
/*     */         continue;
/*     */       }
/*     */       
/* 108 */       String str3 = elements1.get(1).text().trim();
/* 109 */       String str4 = elements1.get(2).text().trim();
/* 110 */       String str5 = elements1.get(3).text().trim();
/* 111 */       boolean bool = elements1.get(5).text().trim().toLowerCase().equals("sim");
/*     */       
/* 113 */       String str6 = "";
/* 114 */       if (paramj == j.a) {
/* 115 */         str6 = elements1.get(7).text().trim();
/*     */       }
/*     */       
/* 118 */       f f = new f(a().a(), i);
/* 119 */       f.D(false);
/*     */       
/* 121 */       f.a(m.a);
/* 122 */       f.T(str3);
/* 123 */       f.Q(Integer.parseInt(str4));
/* 124 */       f.aw(str5);
/* 125 */       f.b(calendar);
/* 126 */       f.s(bool);
/* 127 */       f.z(bool);
/* 128 */       f.ay(str6);
/* 129 */       f.a(paramj);
/* 130 */       paramList.add(f);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public d a() {
/* 136 */     return (d)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\b\a\a\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */