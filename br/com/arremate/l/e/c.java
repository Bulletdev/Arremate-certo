/*     */ package br.com.arremate.l.e;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.f.l;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.f.v;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.i.a;
/*     */ import br.com.arremate.j.c.d;
/*     */ import br.com.arremate.j.c.e;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.k.a.a.a;
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
/*     */ import org.e.f;
/*     */ import org.e.i;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class c
/*     */   extends j
/*     */   implements a
/*     */ {
/*     */   private Calendar e;
/*  42 */   private String dE = "none";
/*  43 */   private String dF = "none";
/*     */   
/*     */   public c(d paramd, int paramInt) {
/*  46 */     super(paramd, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ao() {
/*     */     try {
/*  52 */       byte b = 1;
/*  53 */       String str1 = "porcodigo, empcnpj, liccodigo, licnumero, licuasg, licuasgnome, licdataabertura, licoculta, licsrp, licunitario, licdataencerramento, licicms, licmododedisputa, licmodalidade";
/*     */       
/*  55 */       String str2 = "?, ?, ?, ?, ?, ?, ?, 0, ?, ?, ?, ?, ?, ?";
/*     */       
/*  57 */       String str3 = "INSERT INTO tblicitacao (" + str1 + ") VALUES (" + str2 + ");";
/*  58 */       PreparedStatement preparedStatement = a.a().prepareStatement(str3);
/*  59 */       preparedStatement.setInt(b++, b().v());
/*  60 */       preparedStatement.setLong(b++, C());
/*  61 */       preparedStatement.setInt(b++, v());
/*  62 */       preparedStatement.setString(b++, bo());
/*  63 */       preparedStatement.setInt(b++, K());
/*  64 */       preparedStatement.setString(b++, bT());
/*  65 */       preparedStatement.setTimestamp(b++, new Timestamp(h().getTimeInMillis()));
/*  66 */       preparedStatement.setBoolean(b++, bf());
/*  67 */       preparedStatement.setBoolean(b++, aZ());
/*  68 */       preparedStatement.setTimestamp(b++, (g() != null) ? new Timestamp(g().getTimeInMillis()) : null);
/*  69 */       preparedStatement.setBoolean(b++, k());
/*  70 */       preparedStatement.setInt(b++, a().getId());
/*  71 */       preparedStatement.setInt(b++, a().getId());
/*     */       
/*  73 */       return (preparedStatement.executeUpdate() == 1);
/*  74 */     } catch (SQLException sQLException) {
/*  75 */       a.error("Erro ao gravar dados da disputa", sQLException);
/*     */ 
/*     */       
/*  78 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public b b() {
/*     */     b b;
/*  89 */     if (!a().equals(l.c)) {
/*  90 */       a a1 = new a(this);
/*  91 */       b = new b((g)a1);
/*  92 */       b.J();
/*     */     } else {
/*  94 */       br.com.arremate.k.a.a.c c1 = new br.com.arremate.k.a.a.c(this);
/*  95 */       b = new b((g)c1);
/*     */     } 
/*     */     
/*  98 */     return b;
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
/* 109 */     List<g> list = new ArrayList();
/*     */     
/* 111 */     if (parami instanceof br.com.arremate.j.c.c && parami.isRunning())
/* 112 */     { br.com.arremate.j.c.c c1 = (br.com.arremate.j.c.c)parami;
/*     */       
/* 114 */       switch (null.l[a().ordinal()])
/*     */       { case 1:
/* 116 */           list = b(c1);
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
/* 129 */           return list;case 2: case 3: case 4: list = a(c1); return list; }  list = c(c1); }  return list;
/*     */   } private List<g> a(br.com.arremate.j.c.c paramc) {
/*     */     e e1;
/*     */     f f;
/* 133 */     ArrayList<a> arrayList = new ArrayList();
/* 134 */     String str = bk();
/*     */     
/* 136 */     e e = new e(paramc.a());
/* 137 */     e.a((i)paramc);
/*     */     try {
/* 139 */       e.bN();
/* 140 */     } catch (Exception exception) {
/* 141 */       a.error("Erro ao capturar as informações dos itens", exception);
/*     */     } 
/*     */     
/* 144 */     byte b = 0;
/*     */ 
/*     */ 
/*     */     
/*     */     do {
/* 149 */       e1 = e.b(str, b);
/* 150 */       if (e1.getData().isEmpty())
/* 151 */       { f = new f(); }
/*     */       
/*     */       else
/*     */       
/* 155 */       { f = new f(e1.getData());
/* 156 */         for (byte b1 = 0; b1 < f.length(); b1++) {
/* 157 */           i i = f.b(b1);
/*     */           
/* 159 */           if (i.getString("tipo").equals("G"))
/* 160 */           { List<a> list = new ArrayList();
/*     */             
/* 162 */             if (k()) {
/* 163 */               a(u.b);
/* 164 */               arrayList.clear();
/*     */               
/*     */               break;
/*     */             } 
/* 168 */             if (i.has("proposta")) {
/* 169 */               list = a(e, str, i.getInt("numero"), i.getString("identificador"), i.j("proposta").getInt("id"));
/*     */             }
/*     */             
/* 172 */             if (list.stream().anyMatch(parama -> (parama.w() == v.b.v()))) {
/* 173 */               this.dE = "some";
/*     */             }
/*     */             else {
/*     */               
/* 177 */               arrayList.addAll(list);
/*     */             }  }
/* 179 */           else { a a1 = a(e, str, i);
/*     */             
/* 181 */             if (a1 != null) {
/* 182 */               arrayList.add(a1);
/*     */             } }
/*     */         
/*     */         } 
/*     */         
/* 187 */         b++; } 
/* 188 */     } while (f.length() >= 10 || e1.getStatusCode() == 204);
/*     */     
/* 190 */     if (this.dE.equals("some") && arrayList.isEmpty()) {
/* 191 */       this.dE = "all";
/*     */     }
/*     */     
/* 194 */     if (this.dF.equals("some") && arrayList.isEmpty()) {
/* 195 */       this.dF = "all";
/*     */     }
/*     */     
/* 198 */     e.b();
/* 199 */     return (List)arrayList;
/*     */   }
/*     */   private List<a> a(e parame, String paramString1, int paramInt1, String paramString2, int paramInt2) {
/*     */     f f;
/* 203 */     ArrayList<a> arrayList = new ArrayList();
/*     */     
/* 205 */     byte b = 0;
/*     */ 
/*     */ 
/*     */     
/*     */     do {
/* 210 */       e e1 = parame.b(paramString1, b, paramInt1);
/* 211 */       if (e1.getData().isEmpty()) {
/*     */         break;
/*     */       }
/*     */       
/* 215 */       f = new f(e1.getData());
/* 216 */       for (byte b1 = 0; b1 < f.length(); b1++) {
/* 217 */         i i = f.b(b1);
/*     */         
/* 219 */         a a1 = a(parame, paramString1, i);
/*     */         
/* 221 */         if (a1 != null) {
/* 222 */           a1.T(paramInt2);
/* 223 */           a1.ai(paramString2);
/* 224 */           arrayList.add(a1);
/*     */         } 
/*     */       } 
/*     */       
/* 228 */       b++;
/* 229 */     } while (f.length() >= 10);
/*     */     
/* 231 */     return arrayList;
/*     */   }
/*     */   
/*     */   private a a(e parame, String paramString, i parami) {
/* 235 */     if (!parami.has("proposta")) {
/* 236 */       return null;
/*     */     }
/*     */     
/* 239 */     int k = parami.getInt("numero");
/* 240 */     String str1 = parami.getString("descricao");
/* 241 */     int m = parami.getInt("quantidadeSolicitada");
/* 242 */     String str2 = parami.getString("unidadeFornecimento");
/*     */     
/* 244 */     i i1 = parami.j("proposta");
/* 245 */     double d1 = i1.j("valor").getDouble("valorCalculado");
/* 246 */     double d2 = i1.getDouble("valorTotal");
/*     */     
/* 248 */     v v = v.a;
/* 249 */     if (parami.getString("criterioJulgamento").equals("2")) {
/* 250 */       v = v.b;
/* 251 */       d1 = i1.j("valor").getDouble("valorInformado");
/* 252 */       d2 = d1;
/*     */     } 
/*     */     
/* 255 */     if (a() == l.g && v == v.b) {
/* 256 */       this.dF = "some";
/* 257 */       return null;
/*     */     } 
/*     */     
/* 260 */     a a1 = new a(k, this);
/* 261 */     a1.T(String.valueOf(k));
/* 262 */     a1.ag(str1);
/* 263 */     a1.k(m);
/* 264 */     a1.aj(str2);
/* 265 */     a1.m(d1);
/* 266 */     a1.n(d2);
/* 267 */     a1.R(v.v());
/*     */     
/* 269 */     parami = new i(parame.c(paramString, a1.bo()).getData());
/*     */     
/* 271 */     if (parami.getString("tipoVariacaoMinimaEntreLances").equals("P")) {
/* 272 */       a1.f(parami.getBigDecimal("variacaoMinimaEntreLances"));
/*     */     } else {
/* 274 */       a1.e(parami.getBigDecimal("variacaoMinimaEntreLances"));
/*     */     } 
/*     */     
/* 277 */     return a1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<g> b(br.com.arremate.j.c.c paramc) {
/* 284 */     ArrayList<a> arrayList = new ArrayList();
/*     */     
/* 286 */     d d = new d(paramc.a());
/* 287 */     d.a((i)paramc);
/*     */     
/* 289 */     d.f().getData();
/* 290 */     String str = d.e(v()).getData();
/*     */     
/* 292 */     Document document = Jsoup.parse(str);
/* 293 */     Elements elements = document.select("table[id=tbItems1] > tbody > tr");
/*     */ 
/*     */     
/* 296 */     elements.remove(0);
/* 297 */     elements.remove(0);
/*     */     int i;
/* 299 */     for (i = 0; i < elements.size(); i += 3) {
/* 300 */       Element element1 = elements.get(i);
/* 301 */       int k = Integer.parseInt(element1.select("a").first().attr("href").replaceAll(".+?(?=\\=)\\=", "").trim());
/* 302 */       String str1 = String.valueOf(Integer.parseInt(element1.select("td").get(0).text().trim()));
/* 303 */       String str2 = element1.select("td").get(1).text().trim();
/*     */       
/* 305 */       Element element2 = elements.get(i + 1);
/* 306 */       int m = Integer.parseInt(element2.select("td").get(0).text().trim());
/* 307 */       double d1 = Double.parseDouble(element2.select("td").get(3).text().replace(".", "").replace(",", "."));
/*     */       
/* 309 */       a a1 = new a(k, this);
/* 310 */       a1.T(str1);
/* 311 */       a1.ag(str2);
/* 312 */       a1.k(m);
/* 313 */       a1.n(d1);
/* 314 */       a1.R(v.a.v());
/*     */       
/* 316 */       arrayList.add(a1);
/*     */     } 
/*     */     
/* 319 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<g> c(br.com.arremate.j.c.c paramc) {
/* 326 */     ArrayList<g> arrayList = new ArrayList();
/*     */     
/* 328 */     String str = paramc.e(v()).getData();
/* 329 */     Document document = Jsoup.parse(str);
/*     */     
/* 331 */     Element element = document.select("table[class=td] > tbody").first();
/* 332 */     if (element != null) {
/* 333 */       Elements elements = element.select("tr[class=tex3]");
/*     */       
/* 335 */       for (byte b = 1; b < elements.size(); b++) {
/* 336 */         Elements elements1 = elements.get(b).select("td");
/* 337 */         if (elements1.toString().toLowerCase().contains("consultar proposta do grupo")) {
/* 338 */           List<g> list = a(paramc, elements1);
/* 339 */           if (list.isEmpty()) {
/* 340 */             arrayList.clear();
/*     */             
/*     */             break;
/*     */           } 
/*     */           
/* 345 */           if (k()) {
/*     */             
/* 347 */             a(u.b);
/* 348 */             arrayList.clear();
/*     */             
/*     */             break;
/*     */           } 
/*     */           
/* 353 */           if (list.stream().anyMatch(paramg -> (paramg.w() == v.b.v()))) {
/* 354 */             this.dE = "some";
/*     */           }
/*     */           else {
/*     */             
/* 358 */             arrayList.addAll(list);
/*     */           } 
/* 360 */         } else if (elements1.toString().contains("DescrComplementar")) {
/* 361 */           a a1 = a(elements1, paramc);
/* 362 */           if (a1 == null) {
/* 363 */             arrayList.clear();
/*     */             
/*     */             break;
/*     */           } 
/* 367 */           int i = b + 2;
/* 368 */           if (i < elements.size() && elements.get(i).html().contains("DescDetalhada")) {
/* 369 */             String str1 = elements.get(i).html();
/* 370 */             String str2 = str1.substring(str1.indexOf("DescDetalhada('") + 15);
/* 371 */             str2 = str2.substring(0, str2.indexOf("')"));
/* 372 */             a1.ah(a(str2, paramc));
/*     */           } 
/*     */           
/* 375 */           a(a1, paramc);
/* 376 */           arrayList.add(a1);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 383 */     if (this.dE.equals("some") && arrayList.isEmpty()) {
/* 384 */       this.dE = "all";
/*     */     }
/*     */     
/* 387 */     return arrayList;
/*     */   }
/*     */   
/*     */   protected List<g> a(br.com.arremate.j.c.c paramc, Elements paramElements) {
/* 391 */     ArrayList<a> arrayList = new ArrayList();
/*     */     
/* 393 */     String str1 = N(paramElements.get(1).toString());
/* 394 */     String str2 = paramElements.get(0).text().trim();
/*     */ 
/*     */     
/* 397 */     String str3 = paramc.d(v(), str1).getData();
/*     */     
/* 399 */     Document document = Jsoup.parse(str3);
/* 400 */     Element element = document.select("table[class=td] > tbody").first();
/*     */     
/* 402 */     if (element != null) {
/*     */       
/* 404 */       Elements elements = element.select("tr[class=tex3]");
/*     */ 
/*     */       
/* 407 */       for (byte b = 1; b < elements.size(); b++) {
/* 408 */         Elements elements1 = elements.get(b).select("td");
/*     */         
/* 410 */         if (elements1.toString().contains("DescrComplementar")) {
/*     */           
/* 412 */           a a1 = a(elements1, str1, str2, paramc);
/*     */           
/* 414 */           if (a1 == null) {
/* 415 */             arrayList.clear();
/*     */             
/*     */             break;
/*     */           } 
/* 419 */           a(a1, paramc);
/* 420 */           arrayList.add(a1);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 425 */     return (List)arrayList;
/*     */   }
/*     */   
/*     */   private a a(Elements paramElements, br.com.arremate.j.c.c paramc) {
/* 429 */     return a(paramElements, "", "", paramc);
/*     */   }
/*     */ 
/*     */   
/*     */   private a a(Elements paramElements, String paramString1, String paramString2, br.com.arremate.j.c.c paramc) {
/*     */     try {
/* 435 */       String str1 = String.valueOf(Integer.parseInt(paramElements.get(0).text().trim()));
/* 436 */       String str2 = paramElements.get(1).text().trim();
/* 437 */       String str3 = paramElements.get(5).text().trim();
/* 438 */       String str4 = paramElements.get(6).text().trim();
/* 439 */       int i = v.a.v();
/* 440 */       byte b1 = bf() ? 8 : 7;
/* 441 */       byte b2 = bf() ? 9 : 8;
/* 442 */       String str5 = paramElements.get(b2).text().trim();
/* 443 */       String str6 = paramElements.get(b1).text().trim();
/* 444 */       boolean bool = str6.contains("Desconto (%)");
/*     */ 
/*     */ 
/*     */       
/* 448 */       if (bool) {
/* 449 */         i = v.b.v();
/* 450 */         b2 = b1;
/* 451 */         str5 = paramElements.get(b2).text().toLowerCase().replace("desconto (%)", "").replace(".", "").replace(",", ".").trim();
/* 452 */         str6 = str5;
/*     */       } else {
/* 454 */         if (str6.isEmpty()) {
/* 455 */           b2++;
/* 456 */           b1++;
/*     */           
/* 458 */           str5 = paramElements.get(b2).text().trim();
/* 459 */           str6 = paramElements.get(b1).text().trim();
/*     */         } 
/* 461 */         str5 = str5.replace("Valor Total (R$)", "").replace("Val. Total c/ Desc. (R$)", "").trim();
/* 462 */         str5 = str5.replace(".", "").replace(",", ".");
/* 463 */         str6 = str6.replace("Valor Unitário (R$)", "").replace("Valor Estimado (R$)", "").trim();
/* 464 */         str6 = str6.replace(".", "").replace(",", ".");
/*     */       } 
/*     */ 
/*     */       
/* 468 */       String str7 = N(paramElements.get(1).toString());
/*     */       
/* 470 */       a a1 = new a(Integer.parseInt(str7), this);
/* 471 */       a1.T(str1);
/* 472 */       a1.ag(str2);
/* 473 */       a1.k(Integer.parseInt(str4));
/* 474 */       a1.aj(str3);
/* 475 */       a1.m(Double.parseDouble(str6));
/* 476 */       a1.n(Double.parseDouble(str5));
/* 477 */       a1.R(i);
/*     */       
/* 479 */       if (paramString1 != null && !paramString1.isEmpty()) {
/* 480 */         a1.T(Integer.parseInt(paramString1));
/* 481 */         a1.ai(paramString2);
/*     */       } 
/*     */       
/* 484 */       return a1;
/* 485 */     } catch (Exception exception) {
/* 486 */       a.error("Erro ao capturar as informações dos itens", exception);
/*     */ 
/*     */       
/* 489 */       return null;
/*     */     } 
/*     */   }
/*     */   private String a(String paramString, br.com.arremate.j.c.c paramc) {
/* 493 */     String str = "";
/*     */     try {
/* 495 */       String str1 = paramc.f(paramString).getData();
/*     */       
/* 497 */       if (!"".equals(str1)) {
/* 498 */         Document document = Jsoup.parse(str1);
/* 499 */         Elements elements = document.select("span[class=tex3]");
/*     */         
/* 501 */         if (!elements.isEmpty()) {
/* 502 */           str = elements.first().text().trim();
/*     */         }
/*     */       } 
/* 505 */     } catch (Exception exception) {
/* 506 */       a.info("Falha ao realizar leitura de descrição completa", exception);
/*     */     } 
/*     */     
/* 509 */     return str;
/*     */   }
/*     */   
/*     */   protected String N(String paramString) {
/* 513 */     String str1 = "DescrComplementar(";
/* 514 */     String str2 = ");";
/* 515 */     int i = paramString.indexOf(str1) + str1.length();
/* 516 */     int k = paramString.indexOf(str2);
/*     */     
/* 518 */     if (k == -1) {
/* 519 */       k = paramString.indexOf(")");
/*     */       
/* 521 */       if (k == -1) {
/* 522 */         k = paramString.indexOf(",");
/*     */       }
/*     */     } 
/*     */     
/* 526 */     return paramString.substring(i, k);
/*     */   }
/*     */   
/*     */   private void a(a parama, br.com.arremate.j.c.c paramc) {
/* 530 */     String str = paramc.g(parama.v()).getData();
/*     */     
/* 532 */     if (!str.isEmpty()) {
/* 533 */       Document document = Jsoup.parse(str);
/* 534 */       Elements elements = document.select("table[class=tex3] table table span");
/*     */       
/* 536 */       for (byte b = 0; b < elements.size(); b++) {
/* 537 */         if (elements.get(b).text().contains("Intervalo mínimo entre lances")) {
/* 538 */           String str1 = elements.get(b + 1).text();
/*     */           
/* 540 */           if (str1.equals("-")) {
/*     */             break;
/*     */           }
/*     */           
/* 544 */           if (str1.contains("%")) {
/* 545 */             str1 = str1.replace("%", "").trim();
/* 546 */             parama.f(BigDecimal.valueOf(y.a(str1).doubleValue())); break;
/*     */           } 
/* 548 */           str1 = str1.replace("R$", "").trim();
/* 549 */           parama.e(BigDecimal.valueOf(y.a(str1).doubleValue()));
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String bk() {
/* 559 */     if (a().equals(l.k)) {
/* 560 */       return e(K(), bo());
/*     */     }
/*     */     
/* 563 */     if (a().equals(l.g)) {
/* 564 */       return g(K(), bo());
/*     */     }
/*     */     
/* 567 */     return f(K(), bo());
/*     */   }
/*     */   
/*     */   public static String e(int paramInt, String paramString) {
/* 571 */     return c(paramInt, paramString, "03");
/*     */   }
/*     */   
/*     */   public static String f(int paramInt, String paramString) {
/* 575 */     return c(paramInt, paramString, "05");
/*     */   }
/*     */   
/*     */   public static String g(int paramInt, String paramString) {
/* 579 */     return c(paramInt, paramString, "06");
/*     */   }
/*     */   
/*     */   private static String c(int paramInt, String paramString1, String paramString2) {
/* 583 */     StringBuilder stringBuilder = new StringBuilder();
/* 584 */     stringBuilder.append(StringUtils.leftPad(Integer.toString(paramInt), 6, "0"));
/* 585 */     stringBuilder.append(paramString2);
/* 586 */     if (paramString1 != null) {
/* 587 */       stringBuilder.append(StringUtils.leftPad(paramString1.replace("/", ""), 9, "0"));
/*     */     }
/* 589 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String bg() {
/* 594 */     if (this.dF.equals("all"))
/* 595 */       return "Dispensa por Maior Desconto"; 
/* 596 */     if (this.dF.equals("some")) {
/* 597 */       return "notAddSomeDispenseCN";
/*     */     }
/*     */     
/* 600 */     if (h() == null) {
/* 601 */       return "noOpeningDateCN";
/*     */     }
/*     */     
/* 604 */     if (this.dE.equals("all"))
/* 605 */       return "Maior Percentual de Desconto em Grupo"; 
/* 606 */     if (this.dE.equals("some")) {
/* 607 */       return "notAddSomeGroupsCN";
/*     */     }
/*     */     
/* 610 */     if (k() && a() == u.b) {
/* 611 */       return "Equalização ICMS para Grupos";
/*     */     }
/*     */     
/* 614 */     return "";
/*     */   }
/*     */   
/*     */   public String bl() {
/* 618 */     if (g() == null) {
/* 619 */       return "";
/*     */     }
/*     */     
/* 622 */     return y.formatDate(g().getTime());
/*     */   }
/*     */   
/*     */   public Calendar g() {
/* 626 */     return this.e;
/*     */   }
/*     */   
/*     */   public void a(Calendar paramCalendar) {
/* 630 */     this.e = paramCalendar;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\e\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */