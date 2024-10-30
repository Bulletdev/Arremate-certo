/*     */ package br.com.arremate.l.n;
/*     */ 
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.i.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.j.k.a;
/*     */ import br.com.arremate.k.a.g;
/*     */ import br.com.arremate.k.a.n;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.m.y;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ public class b extends j implements a {
/*     */   public b(d paramd, int paramInt) {
/*  25 */     super(paramd, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ao() {
/*     */     try {
/*  31 */       byte b1 = 1;
/*  32 */       String str1 = "porcodigo, empcnpj, liccodigo, licnumero, licuasg, licuasgnome, licdataabertura, licoculta, licsrp, licunitario, licicms, licmododedisputa, licclosingtime";
/*  33 */       String str2 = "?, ?, ?, ?, ?, ?, ?, 0, ?, ?, ?, ?, ?";
/*     */       
/*  35 */       String str3 = "INSERT INTO tblicitacao (" + str1 + ") VALUES (" + str2 + ");";
/*  36 */       PreparedStatement preparedStatement = a.a().prepareStatement(str3);
/*  37 */       preparedStatement.setInt(b1++, b().v());
/*  38 */       preparedStatement.setLong(b1++, C());
/*  39 */       preparedStatement.setInt(b1++, v());
/*  40 */       preparedStatement.setString(b1++, bo());
/*  41 */       preparedStatement.setInt(b1++, K());
/*  42 */       preparedStatement.setString(b1++, bT());
/*  43 */       preparedStatement.setTimestamp(b1++, new Timestamp(h().getTimeInMillis()));
/*  44 */       preparedStatement.setBoolean(b1++, bf());
/*  45 */       preparedStatement.setBoolean(b1++, aZ());
/*  46 */       preparedStatement.setBoolean(b1++, k());
/*  47 */       preparedStatement.setInt(b1++, a().getId());
/*  48 */       preparedStatement.setInt(b1++, M());
/*     */       
/*  50 */       return (preparedStatement.executeUpdate() == 1);
/*  51 */     } catch (SQLException sQLException) {
/*  52 */       a.error("Erro ao gravar dados da disputa", sQLException);
/*     */ 
/*     */       
/*  55 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<g> a(i parami) {
/*  60 */     ArrayList<g> arrayList = new ArrayList();
/*  61 */     a a1 = (a)parami;
/*  62 */     byte b1 = 1;
/*  63 */     int k = 1;
/*     */     
/*     */     do {
/*  66 */       String str = a1.b(b1, bf() ? "SR" : "CR", Integer.toString(v())).getData();
/*  67 */       Document document = Jsoup.parse(str);
/*  68 */       Element element = document.select("a[href*=f_ultima_pagina]").first();
/*  69 */       if (element != null) {
/*  70 */         k = Integer.parseInt(element.attr("href").replaceAll("[\\D]", ""));
/*     */       }
/*     */       
/*  73 */       Elements elements = document.select("table[class=tabela_listagem] > tbody > tr[class=listagem_linha]");
/*  74 */       arrayList.addAll(a(elements));
/*  75 */       ++b1;
/*  76 */     } while (b1 <= k);
/*     */     
/*  78 */     return arrayList;
/*     */   }
/*     */   
/*     */   private List<g> a(Elements paramElements) {
/*  82 */     ArrayList<a> arrayList = new ArrayList();
/*     */     
/*  84 */     for (Element element : paramElements) {
/*  85 */       byte b1 = 6, b2 = 3, b3 = 4;
/*     */       
/*  87 */       Elements elements = element.select("td");
/*  88 */       if (elements.size() > 11) {
/*  89 */         b1 = 17;
/*  90 */         b2 = 14;
/*  91 */         b3 = 15;
/*     */       } 
/*     */       
/*  94 */       String str1 = elements.get(b1).select("input").val();
/*  95 */       if (str1.isEmpty()) {
/*     */         continue;
/*     */       }
/*     */       
/*  99 */       int i = Integer.parseInt(elements.get(0).select("input").val());
/* 100 */       String str2 = elements.get(0).text().replaceAll("[^\\d.]", "");
/* 101 */       String str3 = "LOTE " + str2;
/* 102 */       String str4 = elements.get(1).select("a").first().text();
/*     */       
/* 104 */       a a1 = new a(i, this);
/* 105 */       a1.ag(str3);
/* 106 */       a1.T(str2);
/* 107 */       a1.ah(str4);
/* 108 */       a1.n(y.a(str1).doubleValue());
/* 109 */       a1.m(a1.k());
/* 110 */       a1.k(y.a(elements.get(b2).text()).doubleValue());
/* 111 */       a1.aj(elements.get(b3).text());
/* 112 */       a1.z(true);
/*     */       
/* 114 */       arrayList.add(a1);
/*     */     } 
/* 116 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public br.com.arremate.d.b b() {
/* 121 */     n n = new n(this);
/* 122 */     return new br.com.arremate.d.b((g)n);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\n\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */