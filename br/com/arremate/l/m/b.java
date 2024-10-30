/*     */ package br.com.arremate.l.m;
/*     */ 
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.i.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.j.j;
/*     */ import br.com.arremate.k.a.b.a;
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
/*     */ 
/*     */ public class b
/*     */   extends j
/*     */   implements a
/*     */ {
/*  33 */   private static final Logger a = LoggerFactory.getLogger(b.class);
/*     */   
/*     */   public b(d paramd, int paramInt) {
/*  36 */     super(paramd, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ao() {
/*     */     try {
/*  42 */       byte b1 = 1;
/*  43 */       String str1 = "porcodigo, empcnpj, liccodigo, licnumero, licuasg, licuasgnome, licdataabertura, licoculta, licsrp, licunitario, lichash, lictipoapuracao";
/*  44 */       String str2 = "?, ?, ?, ?, ?, ?, ?, 0, ?, ?, ?, ?";
/*     */       
/*  46 */       String str3 = "INSERT INTO tblicitacao (" + str1 + ") VALUES (" + str2 + ");";
/*  47 */       PreparedStatement preparedStatement = a.a().prepareStatement(str3);
/*  48 */       preparedStatement.setInt(b1++, b().v());
/*  49 */       preparedStatement.setLong(b1++, C());
/*  50 */       preparedStatement.setInt(b1++, v());
/*  51 */       preparedStatement.setString(b1++, bo());
/*  52 */       preparedStatement.setInt(b1++, K());
/*  53 */       preparedStatement.setString(b1++, bT());
/*  54 */       preparedStatement.setTimestamp(b1++, new Timestamp(h().getTimeInMillis()));
/*  55 */       preparedStatement.setBoolean(b1++, bf());
/*  56 */       preparedStatement.setBoolean(b1++, aZ());
/*  57 */       preparedStatement.setString(b1++, bY());
/*  58 */       preparedStatement.setInt(b1++, a().w());
/*     */       
/*  60 */       return (preparedStatement.executeUpdate() == 1);
/*  61 */     } catch (Exception exception) {
/*  62 */       a.warn("Erro ao inserir pregão", exception);
/*     */ 
/*     */       
/*  65 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public br.com.arremate.d.b b() {
/*  70 */     a a1 = new a(this);
/*  71 */     return new br.com.arremate.d.b((g)a1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<g> a(i parami) {
/*  78 */     if (!(parami instanceof j) || !parami.isRunning()) {
/*  79 */       return new ArrayList<>();
/*     */     }
/*     */     
/*  82 */     j j1 = (j)parami;
/*  83 */     m m = a(j1);
/*  84 */     a(m);
/*     */     
/*  86 */     if (m != m.a) {
/*  87 */       return new ArrayList<>();
/*     */     }
/*     */     
/*  90 */     List<String> list = a(j1);
/*     */     
/*  92 */     if (a() == u.a) {
/*  93 */       return d(list);
/*     */     }
/*  95 */     return c(list);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<String> a(j paramj) {
/* 106 */     ArrayList<String> arrayList = new ArrayList();
/* 107 */     int i = 1;
/*     */     
/* 109 */     String str1 = paramj.H(bY());
/* 110 */     Document document = Jsoup.parse(str1);
/* 111 */     Element element = document.select("frame[id=frmDetalhePregao]").first();
/* 112 */     String str2 = element.attr("src").split(Pattern.quote("?q="))[1];
/*     */     
/*     */     try {
/* 115 */       str1 = paramj.I(str2);
/* 116 */       document = Jsoup.parse(str1);
/*     */       
/* 118 */       String str = document.select("td[class=navegacao]").first().text().replaceAll("[^\\w]", "");
/* 119 */       if (str.contains("pgina1de")) {
/* 120 */         i = Integer.parseInt(str.substring(str.indexOf("pgina1de") + 8).trim());
/*     */       }
/* 122 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/* 125 */     str1 = paramj.J(str2);
/* 126 */     arrayList.add(str1);
/*     */     
/* 128 */     for (byte b1 = 1; b1 < i; b1++) {
/* 129 */       str1 = paramj.b(str2, b1);
/* 130 */       arrayList.add(str1);
/*     */     } 
/*     */     
/* 133 */     return arrayList;
/*     */   }
/*     */   
/*     */   private List<g> c(List<String> paramList) {
/* 137 */     ArrayList<g> arrayList = new ArrayList();
/*     */     
/* 139 */     paramList.stream().filter(paramString -> !"".equals(paramString))
/* 140 */       .map(paramString -> Jsoup.parse(paramString))
/* 141 */       .map(paramDocument -> paramDocument.select("td[id=tdRepeater] > table tr td table"))
/* 142 */       .forEachOrdered(paramElements -> paramElements.forEach(()));
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
/* 173 */     return arrayList;
/*     */   }
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
/*     */   private m a(j paramj) {
/* 212 */     e e = paramj.q(bY());
/* 213 */     String str = e.getData();
/*     */     
/* 215 */     if (str != null && !str.trim().isEmpty()) {
/* 216 */       Document document = Jsoup.parse(str);
/* 217 */       Element element1 = document.select("frame[id=frmDetalhePregao]").first();
/* 218 */       String str1 = element1.attr("src");
/*     */       
/* 220 */       str = paramj.r(str1.split("\\?")[1]).getData();
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
/*     */ 
/*     */   
/*     */   public String bg() {
/* 242 */     if (a() == m.b) {
/* 243 */       return "modo Aberto";
/*     */     }
/*     */     
/* 246 */     if (a() == m.c) {
/* 247 */       return "modo Aberto/Fechado";
/*     */     }
/*     */     
/* 250 */     return "";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\m\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */