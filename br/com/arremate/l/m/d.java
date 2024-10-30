/*     */ package br.com.arremate.l.m;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.i.a;
/*     */ import br.com.arremate.j.h;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.k.a.g;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.j;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.regex.Pattern;
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
/*     */ public class d
/*     */   extends j
/*     */   implements a
/*     */ {
/*  33 */   private static final Logger a = LoggerFactory.getLogger(d.class);
/*     */   
/*     */   public d(br.com.arremate.l.d paramd, int paramInt) {
/*  36 */     super(paramd, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ao() {
/*     */     try {
/*  42 */       byte b = 1;
/*  43 */       String str1 = "porcodigo, empcnpj, liccodigo, licnumero, licuasg, licuasgnome, licdataabertura, licoculta, licsrp, licunitario, lichash, lictipoapuracao, licmododedisputa";
/*  44 */       String str2 = "?, ?, ?, ?, ?, ?, ?, 0, ?, ?, ?, ?, ?";
/*     */       
/*  46 */       String str3 = "INSERT INTO tblicitacao (" + str1 + ") VALUES (" + str2 + ");";
/*  47 */       PreparedStatement preparedStatement = a.a().prepareStatement(str3);
/*  48 */       preparedStatement.setInt(b++, b().v());
/*  49 */       preparedStatement.setLong(b++, C());
/*  50 */       preparedStatement.setInt(b++, v());
/*  51 */       preparedStatement.setString(b++, bo());
/*  52 */       preparedStatement.setInt(b++, K());
/*  53 */       preparedStatement.setString(b++, bT());
/*  54 */       preparedStatement.setTimestamp(b++, new Timestamp(h().getTimeInMillis()));
/*  55 */       preparedStatement.setBoolean(b++, bf());
/*  56 */       preparedStatement.setBoolean(b++, aZ());
/*  57 */       preparedStatement.setString(b++, bY());
/*  58 */       preparedStatement.setInt(b++, a().w());
/*  59 */       preparedStatement.setInt(b++, a().getId());
/*     */       
/*  61 */       return (preparedStatement.executeUpdate() == 1);
/*  62 */     } catch (Exception exception) {
/*  63 */       exception.printStackTrace();
/*     */ 
/*     */       
/*  66 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public b b() {
/*  72 */     br.com.arremate.k.a.b.d d1 = new br.com.arremate.k.a.b.d(this);
/*  73 */     return new b((g)d1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<g> a(i parami) {
/*  80 */     ArrayList<g> arrayList = new ArrayList();
/*     */     
/*  82 */     if (!(parami instanceof h) || !parami.isRunning()) {
/*  83 */       return arrayList;
/*     */     }
/*     */     
/*  86 */     m m = a((h)parami);
/*  87 */     a(m);
/*     */     
/*  89 */     h h = (h)parami;
/*  90 */     List<String> list = a(h);
/*     */     
/*  92 */     if (a() == u.a) {
/*  93 */       return d(list);
/*     */     }
/*  95 */     return c(list);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<String> a(h paramh) {
/* 100 */     ArrayList<String> arrayList = new ArrayList();
/* 101 */     int i = 1;
/*     */     
/* 103 */     String str1 = paramh.H(bY());
/* 104 */     Document document = Jsoup.parse(str1);
/* 105 */     Element element = document.select("frame[id=frmDetalhePregao]").first();
/* 106 */     String str2 = element.attr("src").split(Pattern.quote("?q="))[1];
/*     */     
/*     */     try {
/* 109 */       str1 = paramh.I(str2);
/* 110 */       document = Jsoup.parse(str1);
/*     */       
/* 112 */       String str = document.select("td[class=navegacao]").first().text().replaceAll("[^\\w]", "");
/* 113 */       if (str.contains("pgina1de")) {
/* 114 */         i = Integer.parseInt(str.substring(str.indexOf("pgina1de") + 8).trim());
/*     */       }
/* 116 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/* 119 */     str1 = paramh.J(str2);
/* 120 */     arrayList.add(str1);
/*     */     
/* 122 */     for (byte b = 1; b < i; b++) {
/* 123 */       str1 = paramh.b(str2, b);
/* 124 */       arrayList.add(str1);
/*     */     } 
/*     */     
/* 127 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   private List<g> c(List<String> paramList) {
/* 132 */     ArrayList<g> arrayList = new ArrayList();
/*     */     
/* 134 */     paramList.stream().filter(paramString -> !"".equals(paramString))
/* 135 */       .map(paramString -> Jsoup.parse(paramString))
/* 136 */       .map(paramDocument -> paramDocument.select("td[id=tdRepeater] > table tr td table"))
/* 137 */       .forEachOrdered(paramElements -> paramElements.forEach(()));
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
/*     */     
/* 172 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   private List<g> d(List<String> paramList) {
/* 177 */     ArrayList<g> arrayList = new ArrayList();
/*     */     
/* 179 */     paramList.stream().filter(paramString -> !"".equals(paramString))
/* 180 */       .map(paramString -> Jsoup.parse(paramString))
/* 181 */       .forEachOrdered(paramDocument -> {
/*     */           Elements elements = paramDocument.select("[id^=dtgPesquisaItens_][id$=_tbxValor][value]");
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
/*     */           
/*     */           elements.forEach(());
/*     */         });
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
/* 208 */     return arrayList;
/*     */   }
/*     */   
/*     */   private m a(h paramh) {
/* 212 */     e e = paramh.q(bY());
/* 213 */     String str = e.getData();
/*     */     
/* 215 */     if (str != null && !str.trim().isEmpty()) {
/* 216 */       Document document = Jsoup.parse(str);
/* 217 */       Element element1 = document.select("frame[id=frmDetalhePregao]").first();
/* 218 */       String str1 = element1.attr("src");
/*     */       
/* 220 */       str = paramh.r(str1.split("\\?")[1]).getData();
/* 221 */       document = Jsoup.parse(str);
/*     */       
/* 223 */       Element element2 = document.select("span[id=lblProrrogacaoAutomatica]").first();
/* 224 */       if (element2 != null) {
/* 225 */         String str2 = element2.text().trim();
/*     */         
/* 227 */         if (str2.equals("Disputa com auto-encerramento"))
/* 228 */           return m.a; 
/* 229 */         if (str2.contains("Disputa aberta e fechada"))
/* 230 */           return m.c; 
/* 231 */         if (str2.contains("Disputa aberta")) {
/* 232 */           return m.b;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 237 */     return m.a;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\m\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */