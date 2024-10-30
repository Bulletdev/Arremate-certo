/*     */ package br.com.arremate.l.d;
/*     */ 
/*     */ import br.com.arremate.f.l;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.i.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.k.a.d;
/*     */ import br.com.arremate.k.a.g;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.m.y;
/*     */ import java.math.BigDecimal;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.e.i;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ public class b
/*     */   extends j
/*     */   implements a
/*     */ {
/*     */   private String dB;
/*     */   private String dC;
/*     */   
/*     */   public b(d paramd, int paramInt) {
/*  37 */     super(paramd, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ao() {
/*     */     try {
/*  43 */       byte b1 = 1;
/*  44 */       String str1 = "porcodigo, empcnpj, liccodigo, licnumero, licuasg, licuasgnome, licdataabertura, licoculta, licsrp, licunitario, licicms, licmododedisputa, licpreclosingtime, licclosingtime, licmunicipio, liclimitecasasdecimais, licmodalidade";
/*  45 */       String str2 = "?, ?, ?, ?, ?, ?, ?, 0, ?, ?, ?, ?, ?, ?, ?, ?, ?";
/*     */       
/*  47 */       String str3 = "INSERT INTO tblicitacao (" + str1 + ") VALUES (" + str2 + ");";
/*  48 */       PreparedStatement preparedStatement = br.com.arremate.e.a.a().prepareStatement(str3);
/*  49 */       preparedStatement.setInt(b1++, b().v());
/*  50 */       preparedStatement.setLong(b1++, C());
/*  51 */       preparedStatement.setInt(b1++, v());
/*  52 */       preparedStatement.setString(b1++, bo());
/*  53 */       preparedStatement.setInt(b1++, K());
/*  54 */       preparedStatement.setString(b1++, bT());
/*  55 */       preparedStatement.setTimestamp(b1++, new Timestamp(h().getTimeInMillis()));
/*  56 */       preparedStatement.setBoolean(b1++, bf());
/*  57 */       preparedStatement.setBoolean(b1++, aZ());
/*  58 */       preparedStatement.setBoolean(b1++, k());
/*  59 */       preparedStatement.setInt(b1++, a().getId());
/*  60 */       preparedStatement.setInt(b1++, L());
/*  61 */       preparedStatement.setInt(b1++, M());
/*  62 */       preparedStatement.setString(b1++, bW());
/*  63 */       preparedStatement.setInt(b1++, N());
/*  64 */       preparedStatement.setInt(b1++, a().getId());
/*     */       
/*  66 */       return (preparedStatement.executeUpdate() == 1);
/*  67 */     } catch (SQLException sQLException) {
/*  68 */       a.error("Erro ao gravar dados da disputa", sQLException);
/*     */ 
/*     */       
/*  71 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public br.com.arremate.d.b b() {
/*  76 */     d d = new d(this);
/*  77 */     return new br.com.arremate.d.b((g)d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<g> a(i parami) {
/*  84 */     ArrayList<g> arrayList = new ArrayList();
/*  85 */     br.com.arremate.j.f.a a1 = (br.com.arremate.j.f.a)parami;
/*     */     
/*  87 */     String str = a1.w(this.dB).getData();
/*  88 */     if (str.isEmpty()) {
/*  89 */       return arrayList;
/*     */     }
/*     */     
/*  92 */     Document document = Jsoup.parse(str);
/*  93 */     Element element = document.select("table[class=table table-data] td:contains(CASAS DECIMAIS:)").first();
/*  94 */     if (element != null) {
/*  95 */       Y(Integer.parseInt(element.select("b").text()));
/*     */     }
/*     */     
/*  98 */     Elements elements = document.select("tbody#batchItemProp > tr");
/*  99 */     return a(elements, a1);
/*     */   }
/*     */   
/*     */   public List<g> a(Elements paramElements, br.com.arremate.j.f.a parama) {
/* 103 */     ArrayList<g> arrayList = new ArrayList();
/* 104 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */ 
/*     */     
/*     */     while (true) {
/* 108 */       String str = parama.x(this.dC).getData();
/* 109 */       if (!str.isEmpty()) {
/* 110 */         Elements elements = b(str).select("table#batchListRows > tbody > tr");
/*     */         
/* 112 */         for (Element element : paramElements) {
/* 113 */           Elements elements1 = element.select("td");
/*     */           
/* 115 */           double d = y.a(elements1.get(9).select("input").first().attr("value")).doubleValue();
/* 116 */           if (d <= 0.0D) {
/*     */             continue;
/*     */           }
/*     */           
/* 120 */           String str1 = elements1.get(0).text().trim();
/*     */           
/* 122 */           a a1 = (a)hashMap.get(str1);
/* 123 */           if (a1 == null) {
/* 124 */             a1 = new a();
/* 125 */             a1.e = new Elements();
/* 126 */             a1.a = (b)a(str1, parama, elements);
/* 127 */             hashMap.put(str1, a1);
/*     */           } 
/*     */           
/* 130 */           a1.e.add(element);
/*     */         } 
/*     */         
/* 133 */         for (Map.Entry<Object, Object> entry : hashMap.entrySet()) {
/* 134 */           a a1 = (a)entry.getValue();
/* 135 */           if (a1.a.aZ()) {
/* 136 */             arrayList.add(b((String)entry.getKey(), a1)); continue;
/*     */           } 
/* 138 */           arrayList.add(a((String)entry.getKey(), a1));
/*     */         } 
/*     */ 
/*     */         
/* 142 */         return arrayList;
/*     */       } 
/*     */     } 
/*     */   } private g a(String paramString, br.com.arremate.j.f.a parama, Elements paramElements) {
/* 146 */     String[] arrayOfString = paramElements.get(Integer.parseInt(paramString)).attr("onclick").split("'");
/* 147 */     e e = parama.h(arrayOfString[1], arrayOfString[3]);
/* 148 */     String str1 = b(e.getData()).select("input#BidKind").val();
/*     */     
/* 150 */     br.com.arremate.l.c.a a1 = new br.com.arremate.l.c.a(Integer.parseInt(paramString), this);
/*     */     
/* 152 */     a1.T(paramString);
/* 153 */     a1.z(str1.equals("UNITÁRIO"));
/*     */     
/* 155 */     String str2 = String.join("", new CharSequence[] { "LOTE ", paramString, " (", a1.aZ() ? "Unitário" : "Global", ")" });
/* 156 */     a1.ag(str2);
/* 157 */     return (g)a1;
/*     */   }
/*     */   
/*     */   private g a(String paramString, a parama) {
/* 161 */     BigDecimal bigDecimal = BigDecimal.ZERO;
/*     */ 
/*     */     
/* 164 */     for (Element element : parama.e) {
/* 165 */       Elements elements = element.select("td");
/* 166 */       BigDecimal bigDecimal1 = BigDecimal.valueOf(y.a(elements.get(4).text()).doubleValue());
/* 167 */       BigDecimal bigDecimal2 = BigDecimal.valueOf(y.a(elements.get(9).select("input").first().attr("value")).doubleValue());
/*     */       
/* 169 */       bigDecimal = bigDecimal.add(bigDecimal1.multiply(bigDecimal2));
/*     */     } 
/*     */     
/* 172 */     parama.a.k(1.0D);
/* 173 */     parama.a.n(bigDecimal.doubleValue());
/* 174 */     parama.a.m(bigDecimal.doubleValue());
/*     */     
/* 176 */     return (g)parama.a;
/*     */   }
/*     */   
/*     */   private g b(String paramString, a parama) {
/* 180 */     Elements elements = parama.e.get(0).select("td");
/*     */     
/* 182 */     BigDecimal bigDecimal1 = BigDecimal.valueOf(y.a(elements.get(4).text()).doubleValue());
/* 183 */     BigDecimal bigDecimal2 = BigDecimal.valueOf(y.a(elements.get(9).select("input").first().attr("value")).doubleValue());
/* 184 */     BigDecimal bigDecimal3 = bigDecimal1.multiply(bigDecimal2);
/*     */     
/* 186 */     parama.a.z(true);
/* 187 */     parama.a.k(bigDecimal1.doubleValue());
/* 188 */     parama.a.m(bigDecimal2.doubleValue());
/* 189 */     parama.a.n(bigDecimal3.doubleValue());
/*     */     
/* 191 */     return (g)parama.a;
/*     */   }
/*     */   
/*     */   private Document b(String paramString) {
/* 195 */     i i = new i(paramString);
/* 196 */     return Jsoup.parse(i.getString("html"));
/*     */   }
/*     */ 
/*     */   
/*     */   public String bg() {
/* 201 */     if (a() == l.k) {
/* 202 */       return "Concorrência Eletrônica";
/*     */     }
/*     */     
/* 205 */     if (a() == m.g) {
/* 206 */       return "Modo Fechado";
/*     */     }
/*     */     
/* 209 */     if (a() == u.d) {
/* 210 */       return "Maior Desconto Percentual";
/*     */     }
/*     */     
/* 213 */     return super.bg();
/*     */   }
/*     */   
/*     */   public String bi() {
/* 217 */     return this.dB;
/*     */   }
/*     */   
/*     */   public void P(String paramString) {
/* 221 */     this.dB = paramString;
/*     */   }
/*     */   
/*     */   public String bj() {
/* 225 */     return this.dC;
/*     */   }
/*     */   
/*     */   public void Q(String paramString) {
/* 229 */     this.dC = paramString;
/*     */   }
/*     */   
/*     */   private class a {
/*     */     g a;
/*     */     Elements e;
/*     */     
/*     */     private a(b this$0) {}
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\d\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */