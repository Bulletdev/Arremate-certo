/*     */ package br.com.arremate.l.e;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.f.o;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.k.a.a.b;
/*     */ import br.com.arremate.k.a.g;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.m.l;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ public class d
/*     */   extends c
/*     */ {
/*     */   public d(br.com.arremate.l.d paramd, int paramInt) {
/*  25 */     super(paramd, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ao() {
/*  30 */     String str = "SELECT * FROM tbempresa WHERE porcodigo = " + b().v() + " AND empcnpj = " + C();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  37 */       Statement statement = a.a().createStatement();
/*  38 */       ResultSet resultSet = statement.executeQuery(str);
/*     */       
/*  40 */       if (!resultSet.next()) {
/*  41 */         str = "SELECT * FROM tbempresa WHERE porcodigo = " + l.a().a(o.a).v() + " AND empcnpj = " + C();
/*  42 */         statement = a.a().createStatement();
/*  43 */         resultSet = statement.executeQuery(str);
/*     */         
/*  45 */         if (resultSet.next()) {
/*  46 */           byte b = 1;
/*     */           
/*  48 */           str = "INSERT INTO tbempresa (empcnpj, empnome, emplogin, empsenha, empativo, porcodigo) VALUES (?, ?, ?, ?, ?, ?);";
/*  49 */           PreparedStatement preparedStatement = a.a().prepareStatement(str);
/*     */           
/*  51 */           preparedStatement.setLong(b++, resultSet.getLong("empcnpj"));
/*  52 */           preparedStatement.setString(b++, resultSet.getString("empnome"));
/*  53 */           preparedStatement.setString(b++, resultSet.getString("emplogin"));
/*  54 */           preparedStatement.setString(b++, resultSet.getString("empsenha"));
/*  55 */           preparedStatement.setBoolean(b++, resultSet.getBoolean("empativo"));
/*  56 */           preparedStatement.setInt(b++, l.a().a(o.k).v());
/*     */           
/*  58 */           preparedStatement.execute();
/*  59 */           preparedStatement.close();
/*     */         } 
/*     */       } 
/*     */       
/*  63 */       statement.close();
/*  64 */     } catch (Exception exception) {
/*  65 */       exception.printStackTrace();
/*     */     } 
/*     */     
/*  68 */     return super.ao();
/*     */   }
/*     */ 
/*     */   
/*     */   public b b() {
/*  73 */     b b = new b(this);
/*  74 */     return new b((g)b);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<g> a(i parami) {
/*  81 */     ArrayList<a> arrayList = new ArrayList();
/*     */     
/*  83 */     if (parami instanceof br.com.arremate.j.c.d && parami.isRunning()) {
/*  84 */       br.com.arremate.j.c.d d1 = (br.com.arremate.j.c.d)parami;
/*  85 */       String str = d1.e(v()).getData();
/*     */       
/*  87 */       Document document = Jsoup.parse(str);
/*  88 */       Elements elements = document.select("table[id=tbItems1] > tbody > tr");
/*     */ 
/*     */       
/*  91 */       elements.remove(0);
/*  92 */       elements.remove(0);
/*     */       int j;
/*  94 */       for (j = 0; j < elements.size(); j += 3) {
/*  95 */         Element element1 = elements.get(j);
/*  96 */         int k = Integer.parseInt(element1.select("a").first().attr("href").replaceAll(".+?(?=\\=)\\=", "").trim());
/*  97 */         String str1 = String.valueOf(Integer.parseInt(element1.select("td").get(0).text().trim()));
/*  98 */         String str2 = element1.select("td").get(1).text().trim();
/*     */         
/* 100 */         Element element2 = elements.get(j + 1);
/* 101 */         int m = Integer.parseInt(element2.select("td").get(0).text().trim());
/* 102 */         double d2 = Double.parseDouble(element2.select("td").get(3).text().replace(".", "").replace(",", "."));
/*     */         
/* 104 */         a a = new a(k, this);
/* 105 */         a.T(str1);
/* 106 */         a.ag(str2);
/* 107 */         a.k(m);
/* 108 */         a.n(d2);
/* 109 */         a.R(0);
/*     */         
/* 111 */         arrayList.add(a);
/*     */       } 
/*     */     } 
/*     */     
/* 115 */     return (List)arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\e\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */