/*     */ package br.com.arremate.l.k;
/*     */ 
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.f.e;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.i.a;
/*     */ import br.com.arremate.j.d;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.k.a.g;
/*     */ import br.com.arremate.k.a.k;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.m.y;
/*     */ import java.math.BigDecimal;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.TreeSet;
/*     */ import javax.swing.JOptionPane;
/*     */ import org.e.f;
/*     */ import org.e.i;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ public class b
/*     */   extends j implements a {
/*     */   private e d;
/*     */   
/*     */   public b(d paramd, int paramInt) {
/*  35 */     super(paramd, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ao() {
/*     */     try {
/*  41 */       byte b1 = 1;
/*  42 */       String str1 = "porcodigo, empcnpj, liccodigo, licnumero, licuasg, licuasgnome, licdataabertura, licoculta, liccriterio, licsrp, licunitario, licmododedisputa";
/*  43 */       String str2 = "?, ?, ?, ?, ?, ?, ?, 0, ?, ?, ?, ?";
/*     */       
/*  45 */       String str3 = "INSERT INTO tblicitacao (" + str1 + ") VALUES (" + str2 + ");";
/*  46 */       PreparedStatement preparedStatement = a.a().prepareStatement(str3);
/*  47 */       preparedStatement.setInt(b1++, b().v());
/*  48 */       preparedStatement.setLong(b1++, C());
/*  49 */       preparedStatement.setInt(b1++, v());
/*  50 */       preparedStatement.setString(b1++, bo());
/*  51 */       preparedStatement.setInt(b1++, K());
/*  52 */       preparedStatement.setString(b1++, bT());
/*  53 */       preparedStatement.setTimestamp(b1++, new Timestamp(h().getTimeInMillis()));
/*  54 */       preparedStatement.setString(b1++, a().K());
/*  55 */       preparedStatement.setBoolean(b1++, bf());
/*  56 */       preparedStatement.setBoolean(b1++, aZ());
/*  57 */       preparedStatement.setInt(b1++, a().getId());
/*     */       
/*  59 */       return (preparedStatement.executeUpdate() == 1);
/*  60 */     } catch (Exception exception) {
/*  61 */       exception.printStackTrace();
/*     */ 
/*     */       
/*  64 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public br.com.arremate.d.b b() {
/*  69 */     k k = new k(this);
/*  70 */     return new br.com.arremate.d.b((g)k);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<g> a(i parami) {
/*  77 */     ArrayList<g> arrayList = new ArrayList();
/*  78 */     if (!(parami instanceof d) || !parami.isRunning()) {
/*  79 */       return arrayList;
/*     */     }
/*     */     
/*  82 */     d d = (d)parami;
/*  83 */     String str = d.c(Integer.valueOf(v()));
/*     */     
/*  85 */     if (str.isEmpty()) {
/*  86 */       return arrayList;
/*     */     }
/*     */     
/*  89 */     Document document = Jsoup.parse(str);
/*  90 */     Elements elements = document.select("table[id=tabLotes]");
/*     */     
/*  92 */     if (!elements.isEmpty()) {
/*  93 */       boolean bool = false;
/*     */       do {
/*  95 */         bool = false;
/*  96 */         Elements elements1 = elements.get(0).select("tr");
/*     */         
/*  98 */         if (elements1.isEmpty()) {
/*     */           break;
/*     */         }
/* 101 */         elements1.remove(0);
/*     */         
/* 103 */         for (Element element1 : elements1) {
/* 104 */           Elements elements2 = element1.select("td");
/*     */ 
/*     */           
/* 107 */           if (elements2.size() > 0 && null != elements2.get(5).text() && !elements2.get(5).text().trim().isEmpty()) {
/*     */             
/* 109 */             a a1 = a(elements2);
/* 110 */             arrayList.add(a1);
/*     */           } 
/*     */         } 
/*     */         
/* 114 */         Element element = document.select("a.paginaPosterior").first();
/* 115 */         if (element == null)
/* 116 */           continue;  str = d.d(element.attr("href"));
/*     */         
/* 118 */         if (str.isEmpty()) {
/*     */           break;
/*     */         }
/*     */         
/* 122 */         document = Jsoup.parse(str);
/* 123 */         elements = document.select("table[id=tabLotes]");
/*     */         
/* 125 */         bool = true;
/*     */       }
/* 127 */       while (bool);
/*     */ 
/*     */       
/* 130 */       arrayList.parallelStream()
/* 131 */         .forEach(paramg -> {
/*     */             String str = paramd.e(Integer.valueOf(paramg.v()));
/*     */             
/*     */             if (!str.isEmpty()) {
/*     */               Document document = Jsoup.parse(str);
/*     */               
/*     */               Element element1 = document.select("span[id=valorTotal]").first();
/*     */               
/*     */               if (element1 == null) {
/*     */                 element1 = document.select("span[id=valorTotal_" + paramg.bo() + "]").first();
/*     */               }
/*     */               
/*     */               if (element1 == null) {
/*     */                 element1 = document.select("span[id=valorTotal_0]").first();
/*     */               }
/*     */               
/*     */               if (element1 != null) {
/*     */                 String str1 = element1.text().toLowerCase();
/*     */                 
/*     */                 str1 = str1.replace("r$", "");
/*     */                 
/*     */                 str1 = y.Q(str1);
/*     */                 
/*     */                 paramg.n(Double.parseDouble(str1));
/*     */               } 
/*     */               
/*     */               Element element2 = document.select("span[id=valorUnitario]").first();
/*     */               
/*     */               if (element2 == null) {
/*     */                 element2 = document.select("span[id=valorUnitario_" + paramg.bo() + "]").first();
/*     */               }
/*     */               
/*     */               if (element2 == null) {
/*     */                 element2 = document.select("span[id=valorUnitario_0]").first();
/*     */               }
/*     */               
/*     */               if (element2 != null) {
/*     */                 String str1 = element2.text().toLowerCase();
/*     */                 
/*     */                 str1 = str1.replace("r$", "");
/*     */                 
/*     */                 str1 = y.Q(str1);
/*     */                 
/*     */                 paramg.m(Double.parseDouble(str1));
/*     */               } 
/*     */               if (element2 != null && element1 != null) {
/*     */                 int i = (int)(paramg.k() / paramg.j());
/*     */                 paramg.k(i);
/*     */               } 
/*     */             } 
/*     */           });
/* 182 */     } else if (str.contains("erroSituacaoProcessoCompraCadastroProposta")) {
/* 183 */       arrayList = a(d);
/* 184 */       if (arrayList == null || arrayList.isEmpty())
/*     */       {
/* 186 */         arrayList = b(d);
/*     */       }
/*     */     } 
/*     */     
/* 190 */     if (arrayList != null && !arrayList.isEmpty() && a() != m.a) {
/* 191 */       arrayList = a((d)parami, arrayList);
/*     */     }
/*     */     
/* 194 */     return arrayList;
/*     */   }
/*     */   
/*     */   private ArrayList<g> a(d paramd, ArrayList<g> paramArrayList) {
/* 198 */     ArrayList<g> arrayList = new ArrayList();
/*     */     
/* 200 */     String str = paramd.f(Integer.valueOf(v()));
/* 201 */     Document document = Jsoup.parse(str);
/*     */     
/* 203 */     f f = (new i(paramd.g(v()))).c("participacoesEmLotes");
/*     */     
/* 205 */     Elements elements = document.select("tbody.tableContent tr[id^=tabelaLancesFornecedor]");
/*     */     
/* 207 */     elements.stream()
/* 208 */       .forEach(paramElement -> {
/*     */           String str1 = String.valueOf(Integer.parseInt(paramElement.select("td[id^=numero]").first().text().trim()));
/*     */           
/*     */           String str2 = paramElement.select("input[name=selecao]").attr("onclick");
/*     */           
/*     */           g g = paramArrayList1.stream().filter(()).findFirst().orElse(null);
/*     */           
/*     */           if (g != null) {
/*     */             String str = str2.split("'")[11].replace(".", "").replace(",", ".");
/*     */             
/*     */             if (!str.equals("-")) {
/*     */               g.e(new BigDecimal(str));
/*     */             }
/*     */             for (byte b1 = 0; b1 < paramf.length(); b1++) {
/*     */               i i = paramf.b(b1);
/*     */               if (String.valueOf(i.j("lote").getInt("numero")).equals(str1)) {
/*     */                 g.ak(i.getString("identificadorFornecedorFormatado"));
/*     */                 paramf.remove(b1);
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           paramArrayList2.add(g);
/*     */         });
/* 232 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ArrayList<g> a(d paramd) {
/* 242 */     ArrayList<g> arrayList = new ArrayList();
/*     */     
/* 244 */     String str = paramd.f(Integer.valueOf(v()));
/* 245 */     Document document = Jsoup.parse(str);
/*     */     
/* 247 */     Elements elements = document.select("tbody.tableContent tr[id^=tabelaLancesFornecedor]");
/*     */     
/* 249 */     elements.stream()
/* 250 */       .forEach(paramElement -> {
/*     */           int i = Integer.parseInt(paramElement.select("input[name=selecao]").first().val());
/*     */           
/*     */           String str1 = String.valueOf(Integer.parseInt(paramElement.select("td[id^=numero]").first().text().trim()));
/*     */           
/*     */           String str2 = paramElement.select("td[id^=descricao]").first().text().trim();
/*     */           
/*     */           String str3 = paramElement.select("span[id^=meuMelhorValor]").first().text().trim().toLowerCase();
/*     */           
/*     */           str3 = str3.replace("r$", "");
/*     */           
/*     */           str3 = y.Q(str3);
/*     */           
/*     */           double d1 = Double.parseDouble(str3);
/*     */           
/*     */           a a1 = new a(i, this);
/*     */           
/*     */           a1.T(str1);
/*     */           a1.ag(str2);
/*     */           if (aZ()) {
/*     */             a1.m(d1);
/*     */             String str4 = paramd.b(Integer.valueOf(i), Integer.valueOf(v()));
/*     */             Document document = Jsoup.parse(str4);
/*     */             String str5 = document.select("span[id^=quantidade]").first().text().trim();
/*     */             str5 = y.Q(str5);
/*     */             a1.k(Integer.parseInt(str5));
/*     */             a1.n(a1.i() * d1);
/*     */           } else {
/*     */             a1.n(d1);
/*     */           } 
/*     */           paramArrayList.add(a1);
/*     */         });
/* 282 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ArrayList<g> b(d paramd) {
/* 294 */     ArrayList<g> arrayList = new ArrayList();
/*     */ 
/*     */     
/* 297 */     String str1 = JOptionPane.showInputDialog("Não foi possível identificar os lotes que você está participando\nna licitação " + 
/*     */ 
/*     */         
/* 300 */         bo() + ", portanto é necessário que\nvocê informe o número do(s) lote(s) que deseja participar\nseparados por vírgula:");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 306 */     String str2 = paramd.g(Integer.valueOf(v()));
/*     */     
/* 308 */     if (str1 != null && !str1.isEmpty() && !str2.isEmpty()) {
/* 309 */       String[] arrayOfString = str1.split(",");
/*     */ 
/*     */ 
/*     */       
/* 313 */       TreeSet<Integer> treeSet = new TreeSet();
/*     */       
/*     */       try {
/* 316 */         for (String str : arrayOfString) {
/* 317 */           int i = Integer.parseInt(str.trim());
/*     */           
/* 319 */           treeSet.add(Integer.valueOf(i));
/*     */         } 
/* 321 */       } catch (Exception exception) {
/* 322 */         return arrayList;
/*     */       } 
/*     */       
/* 325 */       Document document = Jsoup.parse(str2);
/* 326 */       Elements elements = document.select("table[id=tabelaLotesPregao]");
/*     */       
/* 328 */       if (elements.size() > 0) {
/* 329 */         Elements elements1 = elements.get(0).select("tbody > tr");
/*     */         
/* 331 */         if (elements1.size() > 0)
/*     */         {
/* 333 */           for (Element element : elements1) {
/* 334 */             Elements elements2 = element.select("td");
/* 335 */             String str = elements2.get(1).text().trim();
/* 336 */             int i = Integer.parseInt(str);
/*     */ 
/*     */             
/* 339 */             if (treeSet.contains(Integer.valueOf(i))) {
/* 340 */               treeSet.remove(Integer.valueOf(i));
/*     */               
/* 342 */               a a1 = a(elements2);
/* 343 */               arrayList.add(a1);
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 350 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private a a(Elements paramElements) {
/* 361 */     int i = Integer.parseInt(paramElements.get(0).child(0).attr("value"));
/*     */     
/* 363 */     a a1 = new a(i, this);
/* 364 */     a1.ag(paramElements.get(2).text());
/* 365 */     a1.T(paramElements.get(1).text().trim());
/* 366 */     a1.n(0.0D);
/*     */     
/* 368 */     return a1;
/*     */   }
/*     */ 
/*     */   
/*     */   public String bg() {
/* 373 */     if (a() == u.d)
/* 374 */       return "Maior Desconto"; 
/* 375 */     if (a() == u.h) {
/* 376 */       return "Taxa Administrativa ou Preço Global";
/*     */     }
/* 378 */     return "";
/*     */   }
/*     */   
/*     */   public boolean bi() {
/* 382 */     return (a() == e.a);
/*     */   }
/*     */   
/*     */   public e a() {
/* 386 */     return this.d;
/*     */   }
/*     */   
/*     */   public void a(e parame) {
/* 390 */     this.d = parame;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\k\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */