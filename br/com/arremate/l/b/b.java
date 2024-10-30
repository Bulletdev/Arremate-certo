/*     */ package br.com.arremate.l.b;
/*     */ 
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.i.a;
/*     */ import br.com.arremate.j.a.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.k.a.g;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.m.y;
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
/*     */ 
/*     */ 
/*     */ public class b
/*     */   extends j
/*     */   implements a
/*     */ {
/*     */   public b(d paramd, int paramInt) {
/*  31 */     super(paramd, paramInt);
/*  32 */     a(m.b);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ao() {
/*     */     try {
/*  38 */       byte b1 = 1;
/*  39 */       String str1 = "porcodigo, empcnpj, liccodigo, licnumero, licuasg, licuasgnome, licdataabertura, licoculta, licsrp, licunitario, licmododedisputa, lictipoapuracao";
/*     */       
/*  41 */       String str2 = "?, ?, ?, ?, ?, ?, ?, 0, ?, ?, ?, ?";
/*     */       
/*  43 */       String str3 = "INSERT INTO tblicitacao (" + str1 + ") VALUES (" + str2 + ");";
/*  44 */       PreparedStatement preparedStatement = a.a().prepareStatement(str3);
/*  45 */       preparedStatement.setInt(b1++, b().v());
/*  46 */       preparedStatement.setLong(b1++, C());
/*  47 */       preparedStatement.setInt(b1++, v());
/*  48 */       preparedStatement.setString(b1++, bo());
/*  49 */       preparedStatement.setInt(b1++, K());
/*  50 */       preparedStatement.setString(b1++, bT());
/*  51 */       preparedStatement.setTimestamp(b1++, new Timestamp(h().getTimeInMillis()));
/*  52 */       preparedStatement.setBoolean(b1++, bf());
/*  53 */       preparedStatement.setBoolean(b1++, aZ());
/*  54 */       preparedStatement.setInt(b1++, a().getId());
/*  55 */       preparedStatement.setInt(b1++, a().w());
/*     */       
/*  57 */       return (preparedStatement.executeUpdate() == 1);
/*  58 */     } catch (Exception exception) {
/*  59 */       a.error("Falha ao adicionar licitação do CP", exception);
/*     */ 
/*     */       
/*  62 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public br.com.arremate.d.b b() {
/*  67 */     br.com.arremate.k.a.b b1 = new br.com.arremate.k.a.b(this);
/*  68 */     return new br.com.arremate.d.b((g)b1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<g> a(i parami) {
/*  74 */     a a1 = (a)parami;
/*  75 */     String str1 = a1.b(bo()).getData();
/*     */     
/*  77 */     if (str1.isEmpty()) {
/*  78 */       return new ArrayList<>();
/*     */     }
/*     */     
/*  81 */     Document document = Jsoup.parse(str1);
/*  82 */     d(document);
/*     */     
/*  84 */     String str2 = document.select("span[id=ctl00_wucOcFicha_txtStatus]").first().text().trim().toLowerCase();
/*     */     
/*  86 */     Elements elements1 = document.select("table[id=ctl00_conteudo_dg] > tbody > tr");
/*  87 */     if (elements1 != null && !elements1.isEmpty()) {
/*  88 */       a(u.a);
/*  89 */       return a(elements1, str2);
/*     */     } 
/*  91 */     Elements elements2 = document.select("table[id=ctl00_conteudo_loteGridItens_grdLote] > tbody > tr");
/*  92 */     if (elements2 != null && !elements2.isEmpty()) {
/*  93 */       a(u.b);
/*  94 */       return b(elements2, str2);
/*     */     } 
/*     */ 
/*     */     
/*  98 */     return new ArrayList<>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<g> a(Elements paramElements, String paramString) {
/* 108 */     ArrayList<g> arrayList = new ArrayList();
/*     */     
/* 110 */     paramElements.remove(0);
/*     */     
/* 112 */     paramElements.stream().forEach(paramElement -> {
/*     */           Elements elements = paramElement.select("td");
/*     */           
/*     */           String str = elements.get(1).html();
/*     */           
/*     */           if (str.contains("envelope_fechado") || str.contains("envelope_aberto") || a(elements, paramString)) {
/*     */             String str1 = String.valueOf(Integer.parseInt(elements.select("td[data-label=Item]").text()));
/*     */             int i = Integer.parseInt(elements.select("td[data-label=Código]").text());
/*     */             String str2 = elements.select("td[data-label=Descrição]").text();
/*     */             String str3 = elements.select("td[data-label=Qtde.]").text().replace(".", "");
/* 122 */             double d = (str3 != null && !str3.isEmpty()) ? y.a(str3).doubleValue() : 1.0D;
/*     */             
/*     */             String str4 = elements.select("td[data-label=Unidade de Fornecimento]").text();
/*     */             
/*     */             a a1 = new a(i, this);
/*     */             a1.T(str1);
/*     */             a1.ag(str2);
/*     */             a1.k(d);
/*     */             a1.aj(str4);
/*     */             a1.m(0.0D);
/*     */             a1.n(0.0D);
/*     */             paramList.add(a1);
/*     */           } 
/*     */         });
/* 136 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<g> b(Elements paramElements, String paramString) {
/* 147 */     ArrayList<g> arrayList = new ArrayList();
/*     */     
/* 149 */     paramElements.remove(0);
/*     */     
/* 151 */     paramElements.stream().forEach(paramElement -> {
/*     */           Elements elements = paramElement.select("td");
/*     */           
/*     */           String str = elements.get(1).html();
/*     */           
/*     */           if (str.contains("envelope_fechado") || str.contains("envelope_aberto") || a(elements, paramString)) {
/*     */             int i = Integer.parseInt(elements.select("td[data-label=Agrupamento]").text());
/*     */             
/*     */             String str1 = elements.select("td[data-label=Descrição]").text();
/*     */             a a1 = new a(i, this);
/*     */             a1.T(String.valueOf(i));
/*     */             a1.ag(str1);
/*     */             a1.k(1.0D);
/*     */             a1.m(0.0D);
/*     */             a1.n(0.0D);
/*     */             paramList.add(a1);
/*     */           } 
/*     */         });
/* 169 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean a(Elements paramElements, String paramString) {
/* 174 */     Element element = paramElements.select("td[data-label=Melhor Oferta]").first();
/* 175 */     if (element != null) {
/* 176 */       String str = element.attr("style");
/* 177 */       return ((paramString.equals("encerrado com vencedor") || paramString.equals("homologação")) && str != null && !str.isEmpty());
/*     */     } 
/*     */     
/* 180 */     return false;
/*     */   }
/*     */   
/*     */   private void d(Document paramDocument) {
/*     */     try {
/* 185 */       Element element = paramDocument.select("span[id=ctl00_wucOcFicha_txtOC]").first();
/* 186 */       z(!element.text().toLowerCase().contains("valor total"));
/*     */       
/* 188 */       String str = "UPDATE tblicitacao SET licunitario = ? WHERE porcodigo = ? AND liccodigo = ? AND empcnpj = ?";
/* 189 */       try (PreparedStatement null = a.a().prepareStatement(str)) {
/* 190 */         preparedStatement.setBoolean(1, aZ());
/* 191 */         preparedStatement.setInt(2, b().v());
/* 192 */         preparedStatement.setInt(3, v());
/* 193 */         preparedStatement.setLong(4, C());
/* 194 */         preparedStatement.execute();
/*     */       } 
/* 196 */     } catch (Exception exception) {
/* 197 */       a.info("Failed to update bidding is unitary", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int D() {
/* 203 */     return 3;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\b\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */