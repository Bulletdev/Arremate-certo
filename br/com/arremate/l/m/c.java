/*     */ package br.com.arremate.l.m;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.i.a;
/*     */ import br.com.arremate.j.g.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.k.a.b.b;
/*     */ import br.com.arremate.k.a.g;
/*     */ import br.com.arremate.l.d;
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
/*     */ public class c
/*     */   extends j
/*     */   implements a
/*     */ {
/*  33 */   private static final Logger a = LoggerFactory.getLogger(c.class);
/*     */   
/*     */   public c(d paramd, int paramInt) {
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
/*  56 */       preparedStatement.setBoolean(b++, bf());
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
/*     */   public b b() {
/*  71 */     b b = new b(this);
/*  72 */     return new b((g)b);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<g> a(i parami) {
/*  79 */     if (!(parami instanceof a) || !parami.isRunning()) {
/*  80 */       return new ArrayList<>();
/*     */     }
/*     */     
/*  83 */     m m = a((a)parami);
/*  84 */     a(m);
/*     */     
/*  86 */     if (m == m.c) {
/*  87 */       return new ArrayList<>();
/*     */     }
/*     */     
/*  90 */     a a1 = (a)parami;
/*  91 */     List<String> list = a(a1);
/*     */     
/*  93 */     if (a() == u.a) {
/*  94 */       return d(list);
/*     */     }
/*  96 */     return c(list);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> a(a parama) {
/* 107 */     ArrayList<String> arrayList = new ArrayList();
/* 108 */     int i = 1;
/*     */     
/* 110 */     String str1 = parama.H(bY());
/* 111 */     Document document = Jsoup.parse(str1);
/* 112 */     Element element = document.select("frame[id=frmDetalhePregao]").first();
/* 113 */     String str2 = element.attr("src").split(Pattern.quote("?q="))[1];
/*     */     
/*     */     try {
/* 116 */       str1 = parama.I(str2);
/* 117 */       document = Jsoup.parse(str1);
/*     */       
/* 119 */       String str = document.select("td[class=navegacao]").first().text().replaceAll("[^\\w]", "");
/* 120 */       if (str.contains("pgina1de")) {
/* 121 */         i = Integer.parseInt(str.substring(str.indexOf("pgina1de") + 8).trim());
/*     */       }
/* 123 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/* 126 */     str1 = parama.J(str2);
/* 127 */     arrayList.add(str1);
/*     */     
/* 129 */     for (byte b = 1; b < i; b++) {
/* 130 */       str1 = parama.b(str2, b);
/* 131 */       arrayList.add(str1);
/*     */     } 
/*     */     
/* 134 */     return arrayList;
/*     */   }
/*     */   
/*     */   private List<g> c(List<String> paramList) {
/* 138 */     ArrayList<g> arrayList = new ArrayList();
/*     */     
/* 140 */     paramList.stream().filter(paramString -> !"".equals(paramString))
/* 141 */       .map(paramString -> Jsoup.parse(paramString))
/* 142 */       .map(paramDocument -> paramDocument.select("td[id=tdRepeater] > table tr td table"))
/* 143 */       .forEachOrdered(paramElements -> paramElements.forEach(()));
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
/* 174 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   private List<g> d(List<String> paramList) {
/* 179 */     ArrayList<g> arrayList = new ArrayList();
/*     */     
/* 181 */     paramList.stream().filter(paramString -> !"".equals(paramString))
/* 182 */       .map(paramString -> Jsoup.parse(paramString))
/* 183 */       .forEachOrdered(paramDocument -> {
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
/*     */     
/* 211 */     return arrayList;
/*     */   }
/*     */   
/*     */   private m a(a parama) {
/* 215 */     e e = parama.q(bY());
/* 216 */     String str = e.getData();
/*     */     
/* 218 */     if (str != null && !str.trim().isEmpty()) {
/* 219 */       Document document = Jsoup.parse(str);
/* 220 */       Element element1 = document.select("frame[id=frmDetalhePregao]").first();
/* 221 */       String str1 = element1.attr("src");
/*     */       
/* 223 */       str = parama.r(str1.split("\\?")[1]).getData();
/* 224 */       document = Jsoup.parse(str);
/*     */       
/* 226 */       Element element2 = document.select("span[id=lblProrrogacaoAutomatica]").first();
/* 227 */       if (element2 != null) {
/* 228 */         String str2 = element2.text().trim();
/*     */         
/* 230 */         if (str2.equals("Disputa com auto-encerramento"))
/* 231 */           return m.a; 
/* 232 */         if (str2.contains("Disputa aberta e fechada"))
/* 233 */           return m.c; 
/* 234 */         if (str2.contains("Disputa aberta") || str2.contains("prorrogação automática")) {
/* 235 */           return m.b;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 240 */     return m.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public String bg() {
/* 245 */     if (a() == m.c) {
/* 246 */       return "modo Aberto/Fechado";
/*     */     }
/*     */     
/* 249 */     return "";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\m\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */