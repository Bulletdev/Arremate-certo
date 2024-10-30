/*     */ package br.com.arremate.l.g;
/*     */ 
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.i.a;
/*     */ import br.com.arremate.j.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.k.a.f;
/*     */ import br.com.arremate.k.a.g;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.m.y;
/*     */ import java.math.BigDecimal;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ public class b
/*     */   extends j
/*     */   implements a
/*     */ {
/*     */   public b(d paramd, int paramInt) {
/*  29 */     super(paramd, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ao() {
/*     */     try {
/*  35 */       byte b1 = 1;
/*  36 */       String str1 = "porcodigo, empcnpj, liccodigo, licnumero, licuasg, licuasgnome, licdataabertura, licoculta, licsrp, licunitario, licmododedisputa";
/*  37 */       String str2 = "?, ?, ?, ?, ?, ?, ?, 0, ?, ?, ?";
/*     */       
/*  39 */       String str3 = "INSERT INTO tblicitacao (" + str1 + ") VALUES (" + str2 + ");";
/*  40 */       PreparedStatement preparedStatement = a.a().prepareStatement(str3);
/*  41 */       preparedStatement.setInt(b1++, b().v());
/*  42 */       preparedStatement.setLong(b1++, C());
/*  43 */       preparedStatement.setInt(b1++, v());
/*  44 */       preparedStatement.setString(b1++, bo());
/*  45 */       preparedStatement.setInt(b1++, K());
/*  46 */       preparedStatement.setString(b1++, bT());
/*  47 */       preparedStatement.setTimestamp(b1++, new Timestamp(h().getTimeInMillis()));
/*  48 */       preparedStatement.setBoolean(b1++, bf());
/*  49 */       preparedStatement.setBoolean(b1++, aZ());
/*  50 */       preparedStatement.setInt(b1++, a().getId());
/*     */       
/*  52 */       return (preparedStatement.executeUpdate() == 1);
/*  53 */     } catch (Exception exception) {
/*  54 */       a.error("Falha ao adicionar licitação do Cemig", exception);
/*     */ 
/*     */       
/*  57 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public br.com.arremate.d.b b() {
/*  62 */     f f = new f(this);
/*  63 */     return new br.com.arremate.d.b((g)f);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<g> a(i parami) {
/*  70 */     ArrayList<g> arrayList = new ArrayList();
/*  71 */     a a1 = (a)parami;
/*     */     
/*     */     try {
/*  74 */       String str = a1.v(bY());
/*  75 */       Document document = Jsoup.parse(str);
/*  76 */       Element element = document.select("table[class=tabela-conteudo]").get(0).select("tbody").first();
/*     */       
/*  78 */       Elements elements = element.select("tr");
/*  79 */       elements.forEach(paramElement2 -> {
/*     */             Element element = paramElement2.select("span:containsOwn(Concorrendo)").first();
/*     */             
/*     */             if (element != null) {
/*     */               Elements elements1 = paramElement2.select("td");
/*     */               
/*     */               String str1 = elements1.get(1).text().replace("\n", " ").trim();
/*     */               
/*     */               String str2 = str1.replaceAll("\\D", "");
/*     */               
/*     */               Elements elements2 = paramElement1.getElementById(str1.replace(" ", "").toUpperCase()).select("tr");
/*     */               
/*     */               elements2.remove(0);
/*     */               
/*     */               if (elements2.size() == 1) {
/*     */                 String str = elements1.get(3).text().replace("R$", "").replace(".", "").replace(",", ".").trim();
/*     */                 
/*     */                 double d1 = (new BigDecimal(str)).doubleValue();
/*     */                 
/*     */                 elements1 = elements2.first().select("td");
/*     */                 
/*     */                 int i = Integer.parseInt(elements1.get(0).text().trim());
/*     */                 
/*     */                 double d2 = y.a(elements1.get(4).text().trim()).doubleValue();
/*     */                 a a1 = new a(i, this);
/*     */                 a1.T(str2);
/*     */                 a1.ag(str1);
/*     */                 a1.k(d2);
/*     */                 a1.m(d1);
/*     */                 a1.n(d1);
/*     */                 paramArrayList.add(a1);
/*     */               } else {
/*     */                 for (Element element1 : elements2) {
/*     */                   elements1 = element1.select("td");
/*     */                   int i = Integer.parseInt(elements1.get(0).text().trim());
/*     */                   String str3 = elements1.get(1).text().trim();
/*     */                   String str4 = elements1.get(2).text().trim();
/*     */                   double d1 = y.a(elements1.get(4).text().trim()).doubleValue();
/*     */                   String str5 = elements1.get(5).text().replace("R$", "").replace(".", "").replace(",", ".").trim();
/*     */                   double d2 = (new BigDecimal(str5)).doubleValue();
/*     */                   a a1 = new a(i, this);
/*     */                   a1.T(str3);
/*     */                   a1.ag(str4);
/*     */                   a1.k(d1);
/*     */                   a1.m(d2);
/*     */                   a1.n(d2);
/*     */                   a1.T(Integer.parseInt(str2));
/*     */                   a1.ai(String.join("", new CharSequence[] { "G", str2 }));
/*     */                   paramArrayList.add(a1);
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           });
/* 132 */     } catch (Exception exception) {
/* 133 */       a.error("Error to loading dispute batches");
/*     */     } 
/*     */     
/* 136 */     return arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\g\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */