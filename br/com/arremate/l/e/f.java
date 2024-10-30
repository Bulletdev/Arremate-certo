/*     */ package br.com.arremate.l.e;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.f.v;
/*     */ import br.com.arremate.i.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.j.l.a.d;
/*     */ import br.com.arremate.k.a.a.d;
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
/*     */ import java.util.Calendar;
/*     */ import java.util.List;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ public class f
/*     */   extends j
/*     */   implements a
/*     */ {
/*  36 */   private static final Logger a = LoggerFactory.getLogger(f.class);
/*     */   
/*     */   private Calendar e;
/*  39 */   private String dE = "none";
/*     */   
/*     */   public f(d paramd, int paramInt) {
/*  42 */     super(paramd, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ao() {
/*     */     try {
/*  48 */       byte b = 1;
/*  49 */       String str1 = "porcodigo, empcnpj, liccodigo, licnumero, licuasg, licuasgnome, licdataabertura, licoculta, licsrp, licunitario, licdataencerramento, licicms, licmododedisputa";
/*  50 */       String str2 = "?, ?, ?, ?, ?, ?, ?, 0, ?, ?, ?, ?, ?";
/*     */       
/*  52 */       String str3 = "INSERT INTO tblicitacao (" + str1 + ") VALUES (" + str2 + ");";
/*  53 */       PreparedStatement preparedStatement = a.a().prepareStatement(str3);
/*  54 */       preparedStatement.setInt(b++, b().v());
/*  55 */       preparedStatement.setLong(b++, C());
/*  56 */       preparedStatement.setInt(b++, v());
/*  57 */       preparedStatement.setString(b++, bo());
/*  58 */       preparedStatement.setInt(b++, K());
/*  59 */       preparedStatement.setString(b++, bT());
/*  60 */       preparedStatement.setTimestamp(b++, new Timestamp(h().getTimeInMillis()));
/*  61 */       preparedStatement.setBoolean(b++, bf());
/*  62 */       preparedStatement.setBoolean(b++, aZ());
/*  63 */       preparedStatement.setTimestamp(b++, (g() != null) ? new Timestamp(g().getTimeInMillis()) : null);
/*  64 */       preparedStatement.setBoolean(b++, k());
/*  65 */       preparedStatement.setInt(b++, a().getId());
/*     */       
/*  67 */       return (preparedStatement.executeUpdate() == 1);
/*  68 */     } catch (SQLException sQLException) {
/*  69 */       a.error("Erro ao gravar dados da disputa", sQLException);
/*     */ 
/*     */       
/*  72 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public b b() {
/*  82 */     d d = new d(this);
/*  83 */     b b = new b((g)d);
/*     */     
/*  85 */     if (a() != m.a) {
/*  86 */       b.J();
/*     */     }
/*     */     
/*  89 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<g> a(i parami) {
/* 100 */     ArrayList<g> arrayList = new ArrayList();
/*     */     
/* 102 */     if (parami instanceof d && parami.isRunning()) {
/* 103 */       d d = (d)parami;
/*     */       
/* 105 */       String str = d.d(v());
/*     */       
/* 107 */       Document document = Jsoup.parse(str);
/*     */       
/* 109 */       Elements elements = document.select("table[class=tex3] p[class=tex3]");
/*     */       
/* 111 */       for (byte b = 0; b < elements.size(); b++) {
/* 112 */         if (elements.get(b).html().contains("Modo de Disputa")) {
/* 113 */           if (elements.get(b).html().contains("Aberto/Fechado")) {
/* 114 */             a(m.c);
/* 115 */           } else if (elements.get(b).html().contains("Aberto")) {
/* 116 */             a(m.b);
/*     */           } else {
/* 118 */             a(m.a);
/*     */           } 
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 124 */       Element element = document.select("table[class=td] > tbody").first();
/*     */       
/* 126 */       if (element != null) {
/*     */         
/* 128 */         Elements elements1 = element.select("tr[class=tex3]");
/*     */ 
/*     */         
/* 131 */         for (byte b1 = 1; b1 < elements1.size(); b1++) {
/* 132 */           Elements elements2 = elements1.get(b1).select("td");
/*     */           
/* 134 */           if (elements2.toString().toLowerCase().contains("consultar proposta do grupo")) {
/* 135 */             List<g> list = a(d, elements2);
/*     */             
/* 137 */             if (list.isEmpty()) {
/* 138 */               arrayList.clear();
/*     */               
/*     */               break;
/*     */             } 
/*     */             
/* 143 */             if (k()) {
/*     */               
/* 145 */               a(u.b);
/* 146 */               arrayList.clear();
/*     */               
/*     */               break;
/*     */             } 
/*     */             
/* 151 */             if (list.stream().anyMatch(paramg -> (paramg.w() == v.b.v()))) {
/* 152 */               this.dE = "some";
/*     */             }
/*     */             else {
/*     */               
/* 156 */               arrayList.addAll(list);
/*     */             } 
/* 158 */           } else if (elements2.toString().contains("DescrComplementar")) {
/* 159 */             b b2 = a(elements2, d);
/*     */             
/* 161 */             if (b2 == null) {
/* 162 */               arrayList.clear();
/*     */               
/*     */               break;
/*     */             } 
/* 166 */             int k = b1 + 2;
/*     */             
/* 168 */             if (k < elements1.size() && elements1.get(k).html().contains("DescDetalhada")) {
/* 169 */               String str1 = elements1.get(k).html();
/* 170 */               String str2 = str1.substring(str1.indexOf("DescDetalhada('") + 15);
/* 171 */               str2 = str2.substring(0, str2.indexOf("')"));
/* 172 */               b2.ah(a(str2, d));
/*     */             } 
/*     */             
/* 175 */             a(b2, d);
/* 176 */             arrayList.add(b2);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 184 */     if (this.dE.equals("some") && arrayList.isEmpty()) {
/* 185 */       this.dE = "all";
/*     */     }
/*     */     
/* 188 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<g> a(d paramd, Elements paramElements) {
/* 199 */     ArrayList<b> arrayList = new ArrayList();
/*     */     
/* 201 */     String str1 = N(paramElements.get(1).toString());
/* 202 */     String str2 = paramElements.get(0).text().trim();
/*     */ 
/*     */     
/* 205 */     String str3 = paramd.d(Integer.valueOf(v()), str1);
/*     */     
/* 207 */     Document document = Jsoup.parse(str3);
/* 208 */     Element element = document.select("table[class=td] > tbody").first();
/*     */     
/* 210 */     if (element != null) {
/*     */       
/* 212 */       Elements elements = element.select("tr[class=tex3]");
/*     */ 
/*     */       
/* 215 */       for (byte b = 1; b < elements.size(); b++) {
/* 216 */         Elements elements1 = elements.get(b).select("td");
/*     */         
/* 218 */         if (elements1.toString().contains("DescrComplementar")) {
/*     */           
/* 220 */           b b1 = a(elements1, str1, str2, paramd);
/*     */           
/* 222 */           if (b1 == null) {
/* 223 */             arrayList.clear();
/*     */             
/*     */             break;
/*     */           } 
/* 227 */           a(b1, paramd);
/* 228 */           arrayList.add(b1);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 233 */     return (List)arrayList;
/*     */   }
/*     */   
/*     */   private b a(Elements paramElements, d paramd) {
/* 237 */     return a(paramElements, "", "", paramd);
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
/*     */ 
/*     */   
/*     */   private b a(Elements paramElements, String paramString1, String paramString2, d paramd) {
/*     */     try {
/* 252 */       String str1 = String.valueOf(Integer.parseInt(paramElements.get(0).text().trim()));
/* 253 */       String str2 = paramElements.get(1).text().trim();
/* 254 */       String str3 = paramElements.get(6).text().trim();
/* 255 */       int i = v.a.v();
/* 256 */       byte b1 = bf() ? 8 : 7;
/* 257 */       byte b2 = bf() ? 9 : 8;
/* 258 */       String str4 = paramElements.get(b2).text().trim();
/* 259 */       String str5 = paramElements.get(b1).text().trim();
/* 260 */       boolean bool = str5.contains("Desconto (%)");
/*     */ 
/*     */ 
/*     */       
/* 264 */       if (bool) {
/* 265 */         i = v.b.v();
/* 266 */         b2 = b1;
/* 267 */         str4 = paramElements.get(b2).text().toLowerCase().replace("desconto (%)", "").replace(".", "").replace(",", ".").trim();
/* 268 */         str5 = str4;
/*     */       } else {
/* 270 */         if (str5.isEmpty()) {
/* 271 */           b2++;
/* 272 */           b1++;
/*     */           
/* 274 */           str4 = paramElements.get(b2).text().trim();
/* 275 */           str5 = paramElements.get(b1).text().trim();
/*     */         } 
/* 277 */         str4 = str4.replace("Valor Total (R$)", "").replace("Val. Total c/ Desc. (R$)", "").trim();
/* 278 */         str4 = str4.replace(".", "").replace(",", ".");
/* 279 */         str5 = str5.replace("Valor Unitário (R$)", "").replace("Valor Estimado (R$)", "").trim();
/* 280 */         str5 = str5.replace(".", "").replace(",", ".");
/*     */       } 
/*     */ 
/*     */       
/* 284 */       String str6 = N(paramElements.get(1).toString());
/*     */       
/* 286 */       b b = new b(Integer.parseInt(str6), this);
/* 287 */       b.T(str1);
/* 288 */       b.ag(str2);
/* 289 */       b.k(Integer.parseInt(str3));
/* 290 */       b.m(Double.parseDouble(str5));
/* 291 */       b.n(Double.parseDouble(str4));
/* 292 */       b.R(i);
/*     */       
/* 294 */       if (paramString1 != null && !paramString1.isEmpty()) {
/* 295 */         b.T(Integer.parseInt(paramString1));
/* 296 */         b.ai(paramString2);
/*     */       } 
/*     */       
/* 299 */       return b;
/* 300 */     } catch (Exception exception) {
/* 301 */       a.error("Erro ao capturar as informações dos itens", exception);
/*     */ 
/*     */       
/* 304 */       return null;
/*     */     } 
/*     */   }
/*     */   private String a(String paramString, d paramd) {
/* 308 */     String str = "";
/*     */     try {
/* 310 */       String str1 = paramd.M(paramString);
/*     */       
/* 312 */       if (!"".equals(str1)) {
/* 313 */         Document document = Jsoup.parse(str1);
/* 314 */         Elements elements = document.select("span[class=tex3]");
/*     */         
/* 316 */         if (!elements.isEmpty()) {
/* 317 */           str = elements.first().text().trim();
/*     */         }
/*     */       } 
/* 320 */     } catch (Exception exception) {
/* 321 */       a.info("Falha ao realizar leitura de descrição completa", exception);
/*     */     } 
/*     */     
/* 324 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String N(String paramString) {
/* 334 */     String str1 = "DescrComplementar(";
/* 335 */     String str2 = ");";
/* 336 */     int i = paramString.indexOf(str1) + str1.length();
/* 337 */     int k = paramString.indexOf(str2);
/*     */     
/* 339 */     if (k == -1) {
/* 340 */       k = paramString.indexOf(")");
/*     */       
/* 342 */       if (k == -1) {
/* 343 */         k = paramString.indexOf(",");
/*     */       }
/*     */     } 
/*     */     
/* 347 */     return paramString.substring(i, k);
/*     */   }
/*     */   
/*     */   private void a(b paramb, d paramd) {
/* 351 */     String str = paramd.m(paramb.v());
/*     */     
/* 353 */     if (!str.isEmpty()) {
/* 354 */       Document document = Jsoup.parse(str);
/* 355 */       Elements elements = document.select("table[class=tex3] table table span");
/*     */       
/* 357 */       for (byte b1 = 0; b1 < elements.size(); b1++) {
/* 358 */         if (elements.get(b1).text().contains("Intervalo mínimo entre lances")) {
/* 359 */           String str1 = elements.get(b1 + 1).text();
/*     */           
/* 361 */           if (str1.equals("-")) {
/*     */             break;
/*     */           }
/*     */           
/* 365 */           if (str1.contains("%")) {
/* 366 */             str1 = str1.replace("%", "").trim();
/* 367 */             paramb.f(BigDecimal.valueOf(y.a(str1).doubleValue())); break;
/*     */           } 
/* 369 */           str1 = str1.replace("R$", "").trim();
/* 370 */           paramb.e(BigDecimal.valueOf(y.a(str1).doubleValue()));
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Calendar g() {
/* 380 */     return this.e;
/*     */   }
/*     */   
/*     */   public void a(Calendar paramCalendar) {
/* 384 */     this.e = paramCalendar;
/*     */   }
/*     */   
/*     */   public String bk() {
/* 388 */     StringBuilder stringBuilder = new StringBuilder();
/* 389 */     stringBuilder.append(StringUtils.leftPad(Integer.toString(K()), 6, "0"));
/* 390 */     stringBuilder.append("05");
/* 391 */     stringBuilder.append(StringUtils.leftPad(bo(), 9, "0"));
/* 392 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String bg() {
/* 397 */     if (this.dE.equals("all"))
/* 398 */       return "Maior Percentual de Desconto em Grupo"; 
/* 399 */     if (this.dE.equals("some")) {
/* 400 */       return "notAddSomeGroupsCN";
/*     */     }
/*     */     
/* 403 */     if (k() && a() == u.b) {
/* 404 */       return "Equalização ICMS para Grupos";
/*     */     }
/* 406 */     return "";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\e\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */