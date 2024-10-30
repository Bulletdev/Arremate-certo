/*     */ package br.com.arremate.l.k;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.f.e;
/*     */ import br.com.arremate.f.l;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.i.a;
/*     */ import br.com.arremate.j.d;
/*     */ import br.com.arremate.j.e;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.k.a.g;
/*     */ import br.com.arremate.k.a.l;
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
/*     */ public class c
/*     */   extends j
/*     */   implements a
/*     */ {
/*     */   private e d;
/*  37 */   private List<Integer> y = new ArrayList<>();
/*     */   
/*     */   public c(d paramd, int paramInt) {
/*  40 */     super(paramd, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ao() {
/*     */     try {
/*  46 */       byte b = 1;
/*  47 */       String str1 = "porcodigo, empcnpj, liccodigo, licnumero, licuasg, licuasgnome, licdataabertura, licoculta, liccriterio, licsrp, licunitario, licmododedisputa, lichash";
/*     */       
/*  49 */       String str2 = "?, ?, ?, ?, ?, ?, ?, 0, ?, ?, ?, ?, ?";
/*     */       
/*  51 */       String str3 = "INSERT INTO tblicitacao (" + str1 + ") VALUES (" + str2 + ");";
/*  52 */       PreparedStatement preparedStatement = a.a().prepareStatement(str3);
/*  53 */       preparedStatement.setInt(b++, b().v());
/*  54 */       preparedStatement.setLong(b++, C());
/*  55 */       preparedStatement.setInt(b++, v());
/*  56 */       preparedStatement.setString(b++, bo());
/*  57 */       preparedStatement.setInt(b++, K());
/*  58 */       preparedStatement.setString(b++, bT());
/*  59 */       preparedStatement.setTimestamp(b++, new Timestamp(h().getTimeInMillis()));
/*  60 */       preparedStatement.setString(b++, a().K());
/*  61 */       preparedStatement.setBoolean(b++, bf());
/*  62 */       preparedStatement.setBoolean(b++, aZ());
/*  63 */       preparedStatement.setInt(b++, a().getId());
/*  64 */       preparedStatement.setString(b++, bY());
/*     */       
/*  66 */       return (preparedStatement.executeUpdate() == 1);
/*  67 */     } catch (Exception exception) {
/*  68 */       exception.printStackTrace();
/*     */ 
/*     */       
/*  71 */       return false;
/*     */     } 
/*     */   }
/*     */   public String cc() {
/*  75 */     return bY();
/*     */   }
/*     */ 
/*     */   
/*     */   public b b() {
/*  80 */     l l = new l(this);
/*  81 */     return new b((g)l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<g> a(i parami) {
/*  88 */     ArrayList<g> arrayList = new ArrayList();
/*     */     
/*  90 */     if (!(parami instanceof e) || !parami.isRunning()) {
/*  91 */       return arrayList;
/*     */     }
/*  93 */     e e1 = (e)parami;
/*  94 */     String str = e1.n(cc()).getData();
/*     */     
/*  96 */     if (str.isEmpty()) {
/*  97 */       return arrayList;
/*     */     }
/*  99 */     i i1 = new i(str);
/* 100 */     f f = i1.j("procedimento").c("lotes");
/*     */     
/* 102 */     for (i i2 : f) {
/* 103 */       i i3 = i2;
/*     */       
/* 105 */       if (i3.has("propostaId") && i3.get("propostaId") != i.NULL) {
/* 106 */         int k = i3.getInt("id");
/*     */ 
/*     */ 
/*     */         
/* 110 */         i1 = new i(e1.e(String.valueOf(k), String.valueOf(i3.getInt("propostaId"))).getData());
/*     */ 
/*     */         
/* 113 */         if (!i3.getBoolean("maiorDesconto")) {
/* 114 */           a a1 = new a(k, this);
/* 115 */           a1.ag(i1.getString("descricao"));
/* 116 */           a1.T(String.valueOf(i1.getInt("numero")));
/* 117 */           a1.n(Double.parseDouble(y.Q(i1.getString("valorTotalOriginal"))));
/* 118 */           a1.m((i1.has("valorUnitarioOriginal") && i1.get("valorUnitarioOriginal") != i.NULL) ? Double.parseDouble(y.Q(i1.getString("valorUnitarioOriginal"))) : 0.0D);
/*     */           
/* 120 */           if (a1.j() != 0.0D) {
/* 121 */             a1.k((int)(a1.k() / a1.j()));
/*     */           }
/* 123 */           a1.ak(i1.j("fornecedor").getString("descricao"));
/* 124 */           arrayList.add(a1);
/*     */           
/* 126 */           if (a() != u.c)
/* 127 */             a(u.c); 
/*     */           continue;
/*     */         } 
/* 130 */         this.y.add(Integer.valueOf(i3.getInt("numero")));
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 135 */     return arrayList;
/*     */   }
/*     */   
/*     */   public List<Integer> C() {
/* 139 */     return this.y;
/*     */   }
/*     */   
/*     */   private ArrayList<g> a(d paramd, ArrayList<g> paramArrayList) {
/* 143 */     ArrayList<g> arrayList = new ArrayList();
/*     */     
/* 145 */     String str = paramd.f(Integer.valueOf(v()));
/* 146 */     Document document = Jsoup.parse(str);
/*     */     
/* 148 */     f f = (new i(paramd.g(v()))).c("participacoesEmLotes");
/*     */     
/* 150 */     Elements elements = document.select("tbody.tableContent tr[id^=tabelaLancesFornecedor]");
/*     */     
/* 152 */     elements.stream()
/* 153 */       .forEach(paramElement -> {
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
/*     */             for (byte b = 0; b < paramf.length(); b++) {
/*     */               i i = paramf.b(b);
/*     */               if (String.valueOf(i.j("lote").getInt("numero")).equals(str1)) {
/*     */                 g.ak(i.getString("identificadorFornecedorFormatado"));
/*     */                 paramf.remove(b);
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           paramArrayList2.add(g);
/*     */         });
/* 177 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ArrayList<g> a(d paramd) {
/* 187 */     ArrayList<g> arrayList = new ArrayList();
/*     */     
/* 189 */     String str = paramd.f(Integer.valueOf(v()));
/* 190 */     Document document = Jsoup.parse(str);
/*     */     
/* 192 */     Elements elements = document.select("tbody.tableContent tr[id^=tabelaLancesFornecedor]");
/*     */     
/* 194 */     elements.stream()
/* 195 */       .forEach(paramElement -> {
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
/* 227 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ArrayList<g> b(d paramd) {
/* 238 */     ArrayList<g> arrayList = new ArrayList();
/*     */ 
/*     */     
/* 241 */     String str1 = JOptionPane.showInputDialog("Não foi possível identificar os lotes que você está participando\nna licitação " + 
/*     */ 
/*     */         
/* 244 */         bo() + ", portanto é necessário que\nvocê informe o número do(s) lote(s) que deseja participar\nseparados por vírgula:");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 250 */     String str2 = paramd.g(Integer.valueOf(v()));
/*     */     
/* 252 */     if (str1 != null && !str1.isEmpty() && !str2.isEmpty()) {
/* 253 */       String[] arrayOfString = str1.split(",");
/*     */ 
/*     */ 
/*     */       
/* 257 */       TreeSet<Integer> treeSet = new TreeSet();
/*     */       
/*     */       try {
/* 260 */         for (String str : arrayOfString) {
/* 261 */           int i = Integer.parseInt(str.trim());
/*     */           
/* 263 */           treeSet.add(Integer.valueOf(i));
/*     */         } 
/* 265 */       } catch (Exception exception) {
/* 266 */         return arrayList;
/*     */       } 
/*     */       
/* 269 */       Document document = Jsoup.parse(str2);
/* 270 */       Elements elements = document.select("table[id=tabelaLotesPregao]");
/*     */       
/* 272 */       if (elements.size() > 0) {
/* 273 */         Elements elements1 = elements.get(0).select("tbody > tr");
/*     */         
/* 275 */         if (elements1.size() > 0)
/*     */         {
/* 277 */           for (Element element : elements1) {
/* 278 */             Elements elements2 = element.select("td");
/* 279 */             String str = elements2.get(1).text().trim();
/* 280 */             int i = Integer.parseInt(str);
/*     */ 
/*     */             
/* 283 */             if (treeSet.contains(Integer.valueOf(i))) {
/* 284 */               treeSet.remove(Integer.valueOf(i));
/*     */               
/* 286 */               a a1 = a(elements2);
/* 287 */               arrayList.add(a1);
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 294 */     return arrayList;
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
/* 305 */     int i = Integer.parseInt(paramElements.get(0).child(0).attr("value"));
/*     */     
/* 307 */     a a1 = new a(i, this);
/* 308 */     a1.ag(paramElements.get(2).text());
/* 309 */     a1.T(paramElements.get(1).text().trim());
/* 310 */     a1.n(0.0D);
/*     */     
/* 312 */     return a1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String bg() {
/* 320 */     if (a() == u.d)
/* 321 */       return "Maior Desconto"; 
/* 322 */     if (a() == u.h)
/* 323 */       return "Taxa Administrativa ou Preço Global"; 
/* 324 */     if (!C().isEmpty())
/* 325 */       return "notAddSomeItems"; 
/* 326 */     if (a() == l.c) {
/* 327 */       return "Modalidade de dispensa não suportada";
/*     */     }
/* 329 */     return "";
/*     */   }
/*     */   
/*     */   public boolean bi() {
/* 333 */     return (a() == e.a);
/*     */   }
/*     */   
/*     */   public e a() {
/* 337 */     return this.d;
/*     */   }
/*     */   
/*     */   public void a(e parame) {
/* 341 */     this.d = parame;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\k\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */