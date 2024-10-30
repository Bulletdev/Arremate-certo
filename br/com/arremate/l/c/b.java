/*     */ package br.com.arremate.l.c;
/*     */ 
/*     */ import br.com.arremate.f.l;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.i.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.k.a.c;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class b
/*     */   extends j
/*     */   implements a
/*     */ {
/*     */   private String dB;
/*     */   private String dC;
/*     */   
/*     */   public b(d paramd, int paramInt) {
/*  42 */     super(paramd, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ao() {
/*     */     try {
/*  48 */       byte b1 = 1;
/*  49 */       String str1 = "porcodigo, empcnpj, liccodigo, licnumero, licuasg, licuasgnome, licdataabertura, licoculta, licsrp, licunitario, licicms, licmododedisputa, licpreclosingtime, licclosingtime, licmunicipio, liclimitecasasdecimais, licmodalidade";
/*  50 */       String str2 = "?, ?, ?, ?, ?, ?, ?, 0, ?, ?, ?, ?, ?, ?, ?, ?, ?";
/*     */       
/*  52 */       String str3 = "INSERT INTO tblicitacao (" + str1 + ") VALUES (" + str2 + ");";
/*  53 */       PreparedStatement preparedStatement = br.com.arremate.e.a.a().prepareStatement(str3);
/*  54 */       preparedStatement.setInt(b1++, b().v());
/*  55 */       preparedStatement.setLong(b1++, C());
/*  56 */       preparedStatement.setInt(b1++, v());
/*  57 */       preparedStatement.setString(b1++, bo());
/*  58 */       preparedStatement.setInt(b1++, K());
/*  59 */       preparedStatement.setString(b1++, bT());
/*  60 */       preparedStatement.setTimestamp(b1++, new Timestamp(h().getTimeInMillis()));
/*  61 */       preparedStatement.setBoolean(b1++, bf());
/*  62 */       preparedStatement.setBoolean(b1++, aZ());
/*  63 */       preparedStatement.setBoolean(b1++, k());
/*  64 */       preparedStatement.setInt(b1++, a().getId());
/*  65 */       preparedStatement.setInt(b1++, L());
/*  66 */       preparedStatement.setInt(b1++, M());
/*  67 */       preparedStatement.setString(b1++, bW());
/*  68 */       preparedStatement.setInt(b1++, N());
/*  69 */       preparedStatement.setInt(b1++, a().getId());
/*     */       
/*  71 */       return (preparedStatement.executeUpdate() == 1);
/*  72 */     } catch (SQLException sQLException) {
/*  73 */       a.error("Erro ao gravar dados da disputa", sQLException);
/*     */ 
/*     */       
/*  76 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public br.com.arremate.d.b b() {
/*  81 */     c c = new c(this);
/*  82 */     return new br.com.arremate.d.b((g)c);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<g> a(i parami) {
/*  89 */     ArrayList<g> arrayList = new ArrayList();
/*  90 */     br.com.arremate.j.e.a a1 = (br.com.arremate.j.e.a)parami;
/*     */     
/*  92 */     String str = a1.w(this.dB).getData();
/*  93 */     if (str.isEmpty()) {
/*  94 */       return arrayList;
/*     */     }
/*     */     
/*  97 */     Document document = Jsoup.parse(str);
/*  98 */     Element element = document.select("table[class=table table-data] td:contains(CASAS DECIMAIS:)").first();
/*  99 */     if (element != null) {
/* 100 */       Y(Integer.parseInt(element.select("b").text()));
/*     */     }
/*     */     
/* 103 */     Elements elements = document.select("tbody#batchItemProp > tr");
/* 104 */     return a(elements, a1);
/*     */   }
/*     */   public List<g> a(Elements paramElements, br.com.arremate.j.e.a parama) {
/*     */     String str;
/* 108 */     ArrayList<g> arrayList = new ArrayList();
/* 109 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */ 
/*     */     
/*     */     do {
/* 113 */       str = parama.x(this.dC).getData();
/* 114 */     } while (str.isEmpty());
/*     */     
/* 116 */     Elements elements = b(str).select("table#batchListRows > tbody > tr");
/*     */     
/* 118 */     for (Element element : paramElements) {
/* 119 */       Elements elements1 = element.select("td");
/*     */       
/* 121 */       double d = y.a(elements1.get(9).select("input").first().attr("value")).doubleValue();
/* 122 */       if (d <= 0.0D) {
/*     */         continue;
/*     */       }
/*     */       
/* 126 */       String str1 = elements1.get(0).text().trim();
/*     */       
/* 128 */       a a1 = (a)hashMap.get(str1);
/* 129 */       if (a1 == null) {
/* 130 */         a1 = new a();
/* 131 */         a1.e = new Elements();
/* 132 */         a1.a = (b)a(str1, parama, elements);
/* 133 */         hashMap.put(str1, a1);
/*     */       } 
/*     */       
/* 136 */       a1.e.add(element);
/*     */     } 
/*     */     
/* 139 */     for (Map.Entry<Object, Object> entry : hashMap.entrySet()) {
/* 140 */       a a1 = (a)entry.getValue();
/* 141 */       if (a1.a.aZ()) {
/* 142 */         arrayList.add(b(a1)); continue;
/*     */       } 
/* 144 */       arrayList.add(a(a1));
/*     */     } 
/*     */ 
/*     */     
/* 148 */     return arrayList;
/*     */   }
/*     */   
/*     */   private g a(String paramString, br.com.arremate.j.e.a parama, Elements paramElements) {
/* 152 */     String[] arrayOfString = paramElements.get(Integer.parseInt(paramString)).attr("onclick").split("'");
/* 153 */     e e = parama.h(arrayOfString[1], arrayOfString[3]);
/* 154 */     String str1 = b(e.getData()).select("input#BidKind").val();
/*     */     
/* 156 */     a a1 = new a(Integer.parseInt(paramString), this);
/*     */     
/* 158 */     a1.T(paramString);
/* 159 */     a1.z(str1.equals("UNITÁRIO"));
/*     */     
/* 161 */     String str2 = String.join("", new CharSequence[] { "LOTE ", paramString, " (", a1.aZ() ? "Unitário" : "Global", ")" });
/* 162 */     a1.ag(str2);
/* 163 */     return a1;
/*     */   }
/*     */   
/*     */   private g a(a parama) {
/* 167 */     BigDecimal bigDecimal = BigDecimal.ZERO;
/*     */ 
/*     */     
/* 170 */     for (Element element : parama.e) {
/* 171 */       Elements elements = element.select("td");
/* 172 */       BigDecimal bigDecimal1 = BigDecimal.valueOf(y.a(elements.get(4).text()).doubleValue());
/* 173 */       BigDecimal bigDecimal2 = BigDecimal.valueOf(y.a(elements.get(9).select("input").first().attr("value")).doubleValue());
/*     */       
/* 175 */       bigDecimal = bigDecimal.add(bigDecimal1.multiply(bigDecimal2));
/*     */     } 
/*     */     
/* 178 */     parama.a.k(1.0D);
/* 179 */     parama.a.n(bigDecimal.doubleValue());
/* 180 */     parama.a.m(bigDecimal.doubleValue());
/*     */     
/* 182 */     return (g)parama.a;
/*     */   }
/*     */   
/*     */   private g b(a parama) {
/* 186 */     Elements elements = parama.e.get(0).select("td");
/*     */     
/* 188 */     BigDecimal bigDecimal1 = BigDecimal.valueOf(y.a(elements.get(4).text()).doubleValue());
/* 189 */     BigDecimal bigDecimal2 = BigDecimal.valueOf(y.a(elements.get(9).select("input").first().attr("value")).doubleValue());
/* 190 */     BigDecimal bigDecimal3 = bigDecimal1.multiply(bigDecimal2);
/*     */     
/* 192 */     parama.a.z(true);
/* 193 */     parama.a.k(bigDecimal1.doubleValue());
/* 194 */     parama.a.m(bigDecimal2.doubleValue());
/* 195 */     parama.a.n(bigDecimal3.doubleValue());
/*     */     
/* 197 */     return (g)parama.a;
/*     */   }
/*     */   
/*     */   private Document b(String paramString) {
/* 201 */     i i = new i(paramString);
/* 202 */     return Jsoup.parse(i.getString("html"));
/*     */   }
/*     */   
/*     */   public String bi() {
/* 206 */     return this.dB;
/*     */   }
/*     */   
/*     */   public void P(String paramString) {
/* 210 */     this.dB = paramString;
/*     */   }
/*     */   
/*     */   public String bj() {
/* 214 */     return this.dC;
/*     */   }
/*     */   
/*     */   public void Q(String paramString) {
/* 218 */     this.dC = paramString;
/*     */   }
/*     */   
/*     */   private class a {
/*     */     g a;
/*     */     Elements e;
/*     */     
/*     */     private a(b this$0) {}
/*     */   }
/*     */   
/*     */   public String bg() {
/* 229 */     if (a() == l.k) {
/* 230 */       return "Concorrência Eletrônica";
/*     */     }
/*     */     
/* 233 */     if (a() == u.d) {
/* 234 */       return "Maior Desconto Percentual";
/*     */     }
/*     */     
/* 237 */     if (a() == m.g) {
/* 238 */       return "Modo Fechado";
/*     */     }
/*     */     
/* 241 */     return "";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\c\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */