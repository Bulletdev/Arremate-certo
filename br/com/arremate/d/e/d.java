/*     */ package br.com.arremate.d.e;
/*     */ 
/*     */ import br.com.arremate.d.e;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.f.l;
/*     */ import br.com.arremate.f.t;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.c.c;
/*     */ import br.com.arremate.j.c.e;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.e.c;
/*     */ import br.com.arremate.l.m;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.m.y;
/*     */ import java.text.DateFormat;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.e.f;
/*     */ import org.e.i;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class d
/*     */   extends e
/*     */ {
/*     */   public d(p paramp, c paramc) {
/*  39 */     super(paramp, (i)paramc);
/*  40 */     h(TimeUnit.MINUTES.toMillis(1L));
/*     */   }
/*     */ 
/*     */   
/*     */   public List<m> d() {
/*  45 */     ArrayList<m> arrayList = new ArrayList();
/*     */     
/*  47 */     c c = a().a();
/*  48 */     l l = c.a();
/*  49 */     if (l.equals(l.h) || l.equals(l.k)) {
/*  50 */       if (a().c() != t.c) {
/*  51 */         return arrayList;
/*     */       }
/*     */       
/*  54 */       arrayList.addAll(a(c));
/*     */     } else {
/*     */       try {
/*  57 */         int i = a().a().v();
/*  58 */         String str = a().f(i).getData();
/*  59 */         if (str != null && str.length() > 0) {
/*  60 */           Document document = Jsoup.parse(str);
/*  61 */           Elements elements = document.select("table[class=td]");
/*  62 */           if (elements.size() <= 0) {
/*  63 */             return arrayList;
/*     */           }
/*     */           
/*  66 */           elements = elements.first().select("tr");
/*  67 */           if (elements == null) {
/*  68 */             return arrayList;
/*     */           }
/*     */ 
/*     */           
/*  72 */           for (byte b = 0; b < elements.size(); b++) {
/*  73 */             m m = a(elements.get(b));
/*  74 */             if (a(m)) {
/*     */               break;
/*     */             }
/*     */             
/*  78 */             c(m);
/*  79 */             arrayList.add(0, m);
/*     */           } 
/*     */         } 
/*  82 */       } catch (Exception exception) {
/*  83 */         a.warn("Failed to capture new messages", exception);
/*     */       } 
/*     */     } 
/*     */     
/*  87 */     return arrayList;
/*     */   }
/*     */   
/*     */   private m a(Element paramElement) {
/*  91 */     String str1 = paramElement.select("span[class=mensagem2]").text();
/*  92 */     String str2 = paramElement.select("td[class=tex3b]").text();
/*  93 */     String str3 = paramElement.select("td[class=tex3]").text();
/*     */     
/*  95 */     str2 = str2.replace(str1, "").replace(":", "").replace("informa", "").replace("fala", "").trim();
/*  96 */     str1 = str1.replaceAll("[()]", "").trim();
/*     */     
/*  98 */     return new m(str3, y.a(str1), str2);
/*     */   }
/*     */   
/*     */   private List<m> a(c paramc) {
/*     */     f f;
/* 103 */     ArrayList<m> arrayList = new ArrayList();
/* 104 */     SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
/* 105 */     String str = paramc.bk();
/*     */     
/* 107 */     byte b = 0;
/*     */ 
/*     */ 
/*     */     
/*     */     do {
/* 112 */       e e1 = ((e)a()).c(str, b);
/* 113 */       if (e1.getData().isEmpty()) {
/*     */         break;
/*     */       }
/*     */       
/* 117 */       f = new f(e1.getData());
/* 118 */       for (byte b1 = 0; b1 < f.length(); b1++) {
/* 119 */         i i = f.b(b1);
/* 120 */         m m = a(i, simpleDateFormat);
/*     */         
/* 122 */         if (a(m)) {
/*     */           break;
/*     */         }
/* 125 */         c(m);
/* 126 */         arrayList.add(m);
/*     */       } 
/*     */       
/* 129 */       b++;
/* 130 */     } while (f.length() >= 20);
/*     */     
/* 132 */     Collections.reverse(arrayList);
/* 133 */     return arrayList;
/*     */   }
/*     */   
/*     */   private m a(i parami, DateFormat paramDateFormat) {
/* 137 */     String str1 = parami.getString("dataHora");
/* 138 */     String str2 = parami.getString("tipoRemetente");
/* 139 */     String str3 = parami.getString("texto");
/*     */     
/* 141 */     switch (str2) {
/*     */       case "0":
/* 143 */         str2 = "Sistema";
/*     */         break;
/*     */       case "1":
/* 146 */         str2 = "Fornecedor";
/*     */         break;
/*     */       case "3":
/* 149 */         str2 = "Governo";
/*     */         break;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 155 */     m m = null;
/*     */     try {
/* 157 */       m = new m(str3, paramDateFormat.parse(str1), str2);
/* 158 */     } catch (ParseException parseException) {
/* 159 */       a.warn("Failed to capture new messages", parseException);
/*     */     } 
/* 161 */     return m;
/*     */   }
/*     */ 
/*     */   
/*     */   public c a() {
/* 166 */     return (c)super.a();
/*     */   }
/*     */   
/*     */   private void c(m paramm) {
/* 170 */     String str = paramm.j();
/* 171 */     if (paramm.cd().equals("Sistema") && str.contains("O item") && str.contains("está encerrado.")) {
/* 172 */       e e1 = a().a(a(str));
/* 173 */       if (e1 != null) {
/* 174 */         e1.N(g.s.getValue());
/* 175 */         a().g(e1);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private String a(String paramString) throws NumberFormatException {
/* 181 */     Pattern pattern = Pattern.compile("(?<=\\s)\\d+(?=\\s)");
/* 182 */     Matcher matcher = pattern.matcher(paramString);
/*     */     
/* 184 */     if (matcher.find()) {
/* 185 */       return matcher.group();
/*     */     }
/* 187 */     pattern = Pattern.compile("(?<=\\s)G\\d+(?=\\s)");
/* 188 */     matcher = pattern.matcher(paramString);
/*     */     
/* 190 */     if (matcher.find()) {
/* 191 */       return matcher.group();
/*     */     }
/*     */ 
/*     */     
/* 195 */     return "";
/*     */   }
/*     */ 
/*     */   
/*     */   public p a() {
/* 200 */     return (p)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\e\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */