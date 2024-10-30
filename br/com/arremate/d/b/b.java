/*     */ package br.com.arremate.d.b;
/*     */ 
/*     */ import br.com.arremate.a.k;
/*     */ import br.com.arremate.d.d;
/*     */ import br.com.arremate.d.f;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.f.i;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.s;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.g.d;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.i.d;
/*     */ import br.com.arremate.j.a.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.k.b.a;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.n;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.m.y;
/*     */ import java.math.BigDecimal;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.apache.http.Header;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class b
/*     */   extends f
/*     */ {
/*     */   private final DecimalFormat decimalFormat;
/*     */   private final String P;
/*     */   private Element a;
/*     */   private Element b;
/*     */   private int L;
/*     */   private int N;
/*     */   private int O;
/*     */   private int P;
/*     */   private int Q;
/*     */   private String Q;
/*     */   private int R;
/*     */   private String R;
/*     */   private String S;
/*     */   
/*     */   public b(e parame, a parama, c paramc) {
/*  57 */     super(parame, (i)parama, paramc);
/*  58 */     a((a)new br.com.arremate.k.b.b());
/*  59 */     a((d)new d());
/*  60 */     this.decimalFormat = y.a("###,###,###,##0.0000");
/*  61 */     this.O = -1;
/*  62 */     this.L = -1;
/*  63 */     this.N = -1;
/*  64 */     this.Q = "";
/*  65 */     this.S = "";
/*     */     
/*  67 */     if (parame.a().a() == u.b) {
/*  68 */       this.P = "table[id=ctl00_conteudo_grdGradeLote] > tbody > tr";
/*     */     } else {
/*  70 */       this.P = "table[id=ctl00_conteudo_grdGradeItem] > tbody > tr";
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void P() {
/*  76 */     if (this.a == null) {
/*     */       return;
/*     */     }
/*     */     
/*     */     try {
/*  81 */       a().C(b().d());
/*  82 */       Elements elements = this.a.select("td");
/*     */       
/*  84 */       if (!elements.isEmpty()) {
/*  85 */         String str1 = b().q();
/*  86 */         g g = g.x;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  96 */         boolean bool1 = (str1.equals("homologação") || str1.equals("etapa de habilitação") || str1.equals("análise de recursos") || str1.equals("encerrado com vencedor") || str1.equals("prazo para memoriais") || (this.N >= 0 && elements.get(this.N).text().toLowerCase().equals("encerrada"))) ? true : false;
/*     */ 
/*     */ 
/*     */         
/* 100 */         boolean bool2 = (this.N >= 0) ? elements.get(this.N).text().toLowerCase().equals("ativa") : false;
/*     */ 
/*     */         
/* 103 */         if (bool2) {
/* 104 */           g = g.aM;
/*     */           
/* 106 */           if (b().d() <= 180000L) {
/* 107 */             g = g.aE;
/*     */           }
/* 109 */         } else if (str1.contains("aceitabilidade do preço")) {
/* 110 */           g = g.aO;
/* 111 */         } else if (str1.contains("etapa de negociação")) {
/* 112 */           g = g.an;
/* 113 */         } else if (str1.contains("direito de preferência me-epp")) {
/* 114 */           g = g.aN;
/* 115 */         } else if (str1.contains("encerrado com vencedor")) {
/* 116 */           g = g.ai;
/* 117 */         } else if (bool1) {
/* 118 */           g = g.s;
/*     */         } 
/*     */         
/* 121 */         if (this.O > 0) {
/* 122 */           Elements elements1 = elements.get(this.O - 1).select("img");
/* 123 */           if (elements1 != null && 
/* 124 */             elements1.stream().anyMatch(paramElement -> paramElement.attr("alt").equals("Fracassado"))) {
/* 125 */             g = g.at;
/*     */           }
/*     */         } 
/*     */ 
/*     */         
/* 130 */         String str3 = g.getValue();
/* 131 */         a().N(str3);
/*     */ 
/*     */ 
/*     */         
/* 135 */         Element element = elements.get(this.L);
/* 136 */         String str2 = element.text().trim();
/* 137 */         if (!str2.isEmpty()) {
/* 138 */           double d = Double.parseDouble(y.Q(str2));
/* 139 */           a().l(d);
/*     */ 
/*     */           
/* 142 */           String str = element.attr("style");
/* 143 */           s s = (str.contains("#66BB6A") || str.contains("#7CB342")) ? s.a : s.c;
/*     */ 
/*     */           
/* 146 */           a().a(s);
/*     */           
/* 148 */           if (s == s.a) {
/* 149 */             a().h(d);
/*     */           } else {
/*     */             
/* 152 */             e().stream().filter(paramh -> paramh.bb())
/* 153 */               .findFirst().ifPresent(paramh -> a().h(paramh.m()));
/*     */           } 
/*     */         } 
/*     */         
/* 157 */         if (this.Q.isEmpty() || (
/* 158 */           a().a().r().compareTo(BigDecimal.ZERO) == 0 && 
/* 159 */           a().a().s().compareTo(BigDecimal.ZERO) == 0)) {
/* 160 */           au();
/*     */         }
/*     */         
/* 163 */         if (a().br() || a().a().av()) {
/* 164 */           b().a(a(), e());
/*     */         }
/*     */       } 
/* 167 */     } catch (Exception exception) {
/* 168 */       a.error("#020", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean a(i parami, String paramString) {
/* 174 */     return ((g.b(paramString, g.aM) && parami == i.a) || 
/*     */       
/* 176 */       g.b(paramString, g.aE));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected h h(List<h> paramList) {
/* 187 */     br.com.arremate.l.b b1 = a().b();
/* 188 */     n n = a().a().b();
/* 189 */     d d = a().a().a();
/* 190 */     m m = a().a().a();
/*     */     
/* 192 */     if (b1.a(n, d, m)) {
/*     */       try {
/* 194 */         if (paramList == null) {
/* 195 */           paramList = e();
/*     */         }
/*     */         
/* 198 */         if (!paramList.isEmpty()) {
/* 199 */           h h = a().a(
/* 200 */               a().l(), paramList
/* 201 */               .get(0), 
/* 202 */               a().r(), 
/* 203 */               a().s(), b1, true);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 208 */           if (h != null) {
/* 209 */             i("1º Lugar");
/* 210 */             return h;
/*     */           } 
/*     */           
/* 213 */           return i(paramList);
/*     */         } 
/* 215 */       } catch (d d1) {
/* 216 */         a("capturar os melhores lances para disputar contra ME/EPP", d1);
/*     */       } 
/*     */     }
/*     */     
/* 220 */     return super.h(paramList);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> e() throws d {
/* 225 */     return a(a());
/*     */   }
/*     */   
/*     */   private Document a() {
/* 229 */     String str = b().i(p());
/*     */     
/* 231 */     if (str == null || str.isEmpty()) {
/* 232 */       return null;
/*     */     }
/*     */     
/* 235 */     return Jsoup.parse(str);
/*     */   }
/*     */   
/*     */   private List<h> a(Document paramDocument) throws d {
/* 239 */     ArrayList<h> arrayList = new ArrayList();
/*     */     
/* 241 */     if (paramDocument == null) {
/* 242 */       return arrayList;
/*     */     }
/*     */     
/*     */     try {
/* 246 */       String str1 = paramDocument.select("span[id=ctl00_wucOcFicha_lbApelido1021107]").text().replace("(", "").replace(")", "");
/* 247 */       if (str1.isEmpty()) {
/* 248 */         str1 = paramDocument.select("span[id=ctl00_wucOcFicha_lbInfoUsuario]").text();
/*     */       }
/* 250 */       String str2 = str1;
/* 251 */       Elements elements = paramDocument.select(this.P);
/* 252 */       if (elements != null && !elements.isEmpty()) {
/* 253 */         elements.remove(0);
/* 254 */         elements.forEach(paramElement -> {
/*     */               Elements elements = paramElement.select("td");
/*     */               
/*     */               String str1 = elements.get(0).text();
/*     */               
/*     */               String str2 = (elements.size() > 6) ? elements.get(6).text() : str1;
/*     */               if (paramList.stream().anyMatch(())) {
/*     */                 return;
/*     */               }
/*     */               double d = Double.parseDouble(y.Q(elements.get(1).text()));
/*     */               boolean bool1 = !elements.get(5).text().toUpperCase().contains("OUTROS") ? true : false;
/*     */               String str3 = elements.get(5).text();
/* 266 */               boolean bool2 = (str1.equals(paramString) || str2.contains(paramString)) ? true : false;
/*     */               
/*     */               Date date = y.a(elements.get(2).text());
/*     */               String str4 = elements.get(3).text().trim().toLowerCase();
/*     */               if (str4.equals("válido e confirmado") || str4.equals("classificada")) {
/*     */                 h h = new h();
/*     */                 h.x(bool1);
/*     */                 h.ap(str3);
/*     */                 h.c(date);
/*     */                 h.q(d);
/*     */                 h.E(str2);
/*     */                 h.A(bool2);
/*     */                 h.l(paramList.size() + 1);
/*     */                 paramList.add(h);
/*     */               } 
/*     */             });
/*     */       } 
/* 283 */     } catch (Exception exception) {
/* 284 */       a.info("Failed to load best bids without hash", exception);
/*     */     } 
/*     */     
/* 287 */     return arrayList;
/*     */   }
/*     */   
/*     */   public List<h> i() throws d {
/* 291 */     Document document = a();
/* 292 */     List<h> list = a(document);
/*     */     
/* 294 */     if (g.b(a().bB(), g.ai) || 
/* 295 */       g.b(a().bB(), g.s))
/* 296 */       return b(list); 
/* 297 */     if (g.b(a().bB(), g.at)) {
/* 298 */       String str1 = b().b(a().a().bo()).getData();
/* 299 */       if (!str1.isEmpty()) {
/* 300 */         String str2 = b().e(Jsoup.parse(str1));
/* 301 */         if (g.b(str2, g.ai)) {
/* 302 */           return b(list);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 307 */     if (a().a().a() == u.b) {
/* 308 */       return list;
/*     */     }
/*     */     
/* 311 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     
/* 313 */     Elements elements1 = document.select(this.P);
/* 314 */     Elements elements2 = null;
/* 315 */     if (elements1 != null && !elements1.isEmpty()) {
/* 316 */       elements2 = elements1.first().select("td");
/*     */     }
/* 318 */     if (elements2 == null || elements2.size() < 7) {
/* 319 */       return list;
/*     */     }
/*     */     
/* 322 */     elements1.stream().skip(1L).forEach(paramElement -> {
/*     */           Elements elements = paramElement.select("td");
/*     */           
/*     */           paramHashMap.put(elements.get(6).text().trim().toLowerCase(), elements.get(0).text().trim().toLowerCase());
/*     */         });
/* 327 */     e e = b().c(p());
/* 328 */     String str = e.getData();
/* 329 */     document = Jsoup.parse(str);
/*     */     
/* 331 */     Elements elements3 = document.select("table[class=GridPregaoV2] > tbody > tr");
/*     */     
/* 333 */     list.forEach(paramh -> {
/*     */           Element element = paramElements.select("tr:contains(" + (String)paramHashMap.get(paramh.ay().toLowerCase()) + ")").first();
/*     */           
/*     */           paramh.am(element.select("td[data-label=Fabricante]").text());
/*     */           paramh.al(element.select("td[data-label=Marca/Modelo]").text());
/*     */         });
/* 339 */     return list;
/*     */   }
/*     */   
/*     */   private List<h> b(List<h> paramList) {
/* 343 */     String str1 = b().c(p()).getData();
/* 344 */     String str2 = b().r();
/* 345 */     if (str2 == null) {
/* 346 */       str2 = b().f(p());
/* 347 */       b().m(str2);
/*     */     } 
/*     */     
/* 350 */     Document document1 = Jsoup.parse(str1);
/* 351 */     Document document2 = Jsoup.parse(str2);
/* 352 */     Elements elements1 = document1.select("table[class=GridPregaoV2] > tbody > tr");
/* 353 */     Elements elements2 = document2.select("h4:contains(Licitantes)").first().nextElementSibling().select("table > tbody > tr");
/* 354 */     paramList.forEach(paramh -> {
/*     */           Elements elements = paramElements1.select("tr:contains(" + paramh.ay() + ")").first().select("td");
/*     */           
/*     */           String str = elements.get(0).text();
/*     */           paramh.D(elements.get(2).text());
/*     */           paramh.E(elements.get(3).text());
/*     */           Element element = paramElements2.select("tr:contains(" + str + ")").first();
/*     */           paramh.am(element.select("td[data-label=Fabricante]").text());
/*     */           paramh.al(element.select("td[data-label=Marca/Modelo]").text());
/*     */         });
/* 364 */     return paramList;
/*     */   }
/*     */   
/*     */   public void au() {
/* 368 */     if (this.b == null) {
/*     */       return;
/*     */     }
/*     */     
/*     */     try {
/* 373 */       Elements elements = this.b.select("td");
/*     */       
/* 375 */       if (this.Q > -1) {
/* 376 */         this.Q = elements.get(this.Q).select("input").first().attr("name");
/*     */       }
/*     */       
/* 379 */       if (this.R > -1) {
/* 380 */         this.R = elements.get(this.R).select("div").first().attr("id");
/*     */       }
/*     */       
/* 383 */       if (this.P > -1) {
/* 384 */         String str = elements.get(this.P).text();
/*     */         
/* 386 */         if (str.contains("%")) {
/* 387 */           str = str.replace("%", "").trim();
/* 388 */           str = y.Q(str);
/* 389 */           a().a().f(new BigDecimal(str));
/*     */         } else {
/* 391 */           str = y.Q(str);
/* 392 */           a().a().e(new BigDecimal(str));
/*     */         } 
/*     */       } 
/* 395 */     } catch (Exception exception) {
/* 396 */       a.info("Failed to load value between bids and best offer field name", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean a(h paramh, boolean paramBoolean) {
/* 402 */     if (!b(paramh.m()) && !paramBoolean) {
/* 403 */       b().h("Tentativa de envio de lance abaixo do mínimo.");
/* 404 */       return false;
/*     */     } 
/*     */     
/* 407 */     if (this.Q.isEmpty()) {
/* 408 */       h("Não foi possível enviar lance porque ainda não foi carregado o nome do campo Melhor Oferta");
/* 409 */       a("Tentativa de lance", paramh, m(), paramBoolean, new String[] { "Não foi possível realizar a leitura da página Enviar Oferta" });
/*     */       
/* 411 */       return false;
/*     */     } 
/*     */     
/* 414 */     if (b().e().get(Integer.valueOf(a().v())) != null && ((Boolean)b().e().get(Integer.valueOf(a().v()))).booleanValue()) {
/* 415 */       return false;
/*     */     }
/*     */     
/* 418 */     if (!k.b()) {
/* 419 */       a("Lance de simulação", paramh, m(), paramBoolean, new String[0]);
/* 420 */       return true;
/*     */     } 
/*     */     
/* 423 */     String str1 = this.decimalFormat.format(paramh.m());
/* 424 */     String str2 = a().a().bo();
/* 425 */     String str3 = b().e(str2).getData();
/* 426 */     Document document = Jsoup.parse(str3);
/* 427 */     String str4 = d(document);
/* 428 */     String str5 = c(document);
/* 429 */     String str6 = b().f(document);
/* 430 */     String str7 = b().g(document);
/*     */     
/* 432 */     a.info("Sending bid for item {} with value R$ {}, on situation {}", new Object[] { a().bo(), str1, a().bB() });
/*     */     
/* 434 */     e e = b().a(str2, this.Q, str1, str4, str5, str6, str7);
/*     */     
/* 436 */     str3 = e.getData();
/*     */     
/*     */     try {
/* 439 */       if (str3 != null && !str3.isEmpty()) {
/* 440 */         document = Jsoup.parse(str3);
/*     */         
/* 442 */         if (this.R != null && !this.R.trim().isEmpty()) {
/* 443 */           Elements elements1 = document.select("div[id=" + this.R + "]");
/*     */           
/* 445 */           if (elements1 != null && elements1.size() > 0) {
/* 446 */             String str = elements1.first().text();
/*     */             
/* 448 */             if (str.toUpperCase().equals("VÁLIDO E CONFIRMADO")) {
/* 449 */               a("Lance enviado", paramh, m(), paramBoolean, new String[0]);
/* 450 */               return true;
/*     */             } 
/* 452 */             a.info("Failed to sendo bid ({}) of item {} and captured bid situation equals to \"{}\"", new Object[] { str1, 
/* 453 */                   a().bo(), str });
/* 454 */             a("Tentativa de lance", paramh, m(), paramBoolean, new String[] { str });
/*     */             
/* 456 */             if (str.contains("não existe item disponível para envio de oferta") || str.contains("fora do prazo")) {
/* 457 */               b().e().put(Integer.valueOf(a().v()), Boolean.valueOf(true));
/*     */             }
/* 459 */             return false;
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 464 */         Elements elements = document.select("div[class=aviso]");
/* 465 */         if (elements != null && elements.size() > 0) {
/* 466 */           String str = elements.first().text();
/* 467 */           a("Tentativa de lance", paramh, m(), paramBoolean, new String[] { str });
/* 468 */           return false;
/*     */         } 
/*     */       } else {
/* 471 */         a.info("Bid post returned empty and with statuscode equals to {}", Integer.valueOf(e.getStatusCode()));
/*     */       } 
/*     */ 
/*     */       
/* 475 */       Optional<h> optional = e().stream().filter(paramh -> paramh.bb()).findFirst();
/* 476 */       if (optional.isPresent()) {
/* 477 */         if (((h)optional.get()).m() == paramh.m()) {
/* 478 */           a("Lance enviado", paramh, m(), paramBoolean, new String[0]);
/* 479 */           return true;
/*     */         } 
/* 481 */         a("Tentativa de lance", paramh, m(), paramBoolean, new String[] {
/* 482 */               a(document, paramh.m())
/*     */             });
/*     */       } else {
/* 485 */         a.info("Didn't find last bid at best bids page");
/*     */       } 
/* 487 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/* 490 */     return false;
/*     */   }
/*     */   
/*     */   private String a(Document paramDocument, double paramDouble) {
/* 494 */     if (paramDocument == null) {
/* 495 */       a.info("Couldn't find reason why bid failed, document null");
/* 496 */       return "";
/*     */     } 
/*     */     
/*     */     try {
/* 500 */       String str = paramDocument.select("span[id=ctl00_wucOcFicha_lbApelido1021107]").text().replace("(", "").replace(")", "");
/* 501 */       Elements elements = paramDocument.select(this.P);
/* 502 */       elements.remove(0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 509 */       Optional<Elements> optional = elements.stream().map(paramElement -> paramElement.select("td")).filter(paramElements -> { String str = paramElements.get(0).text(); double d = Double.parseDouble(y.Q(paramElements.get(1).text())); return (paramString.equals(str) && d == paramDouble); }).findFirst();
/*     */       
/* 511 */       if (optional.isPresent()) {
/* 512 */         return ((Elements)optional.get()).get(3).text();
/*     */       }
/* 514 */       a.info("Couldn't find reason why bid failed");
/*     */     }
/* 516 */     catch (Exception exception) {
/* 517 */       a.info("Failed to load best bids without hash", exception);
/*     */     } 
/*     */     
/* 520 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int[] a() {
/* 529 */     int[] arrayOfInt = { 0, 0 };
/* 530 */     long l = System.currentTimeMillis();
/*     */     
/*     */     try {
/* 533 */       Document document = a();
/* 534 */       List<h> list = a(document);
/*     */ 
/*     */       
/* 537 */       long l1 = list.stream().filter(paramh -> (paramLong - paramh.b().getTime() < TimeUnit.MINUTES.toMillis(5L))).count();
/*     */       
/* 539 */       arrayOfInt[0] = (int)l1;
/* 540 */       arrayOfInt[1] = (int)(list.size() - l1);
/*     */       
/* 542 */       if (a().k() == 0.0D) {
/* 543 */         String str = document.select("span[id=ctl00_wucOcFicha_lbApelido1021107]").text().replace("(", "").replace(")", "");
/* 544 */         Elements elements = document.select(this.P);
/* 545 */         elements.remove(0);
/* 546 */         elements.forEach(paramElement -> {
/*     */               Elements elements = paramElement.select("td");
/*     */               
/*     */               String str = elements.get(0).text();
/*     */               boolean bool = str.equals(paramString);
/*     */               if (bool && elements.get(4).text().toUpperCase().contains("ANÁLISE DE PROPOSTAS")) {
/*     */                 double d = Double.parseDouble(y.Q(elements.get(1).text()));
/*     */                 a().a().n(d);
/*     */               } 
/*     */             });
/*     */       } 
/* 557 */     } catch (Exception exception) {
/* 558 */       a.error(String.join(" - ", new CharSequence[] { "#035", a().bo() }), exception);
/* 559 */       b().h("#035 - " + a().bo());
/*     */     } 
/*     */     
/* 562 */     return arrayOfInt;
/*     */   }
/*     */   private String n() {
/*     */     try {
/*     */       Header[] arrayOfHeader;
/* 567 */       String str1 = a().a().bo();
/* 568 */       String str2 = b().b(str1).getData();
/*     */       
/* 570 */       if (str2.isEmpty()) {
/* 571 */         return "";
/*     */       }
/*     */       
/* 574 */       Document document = Jsoup.parse(str2);
/* 575 */       String str3 = d(document);
/* 576 */       String str4 = c(document);
/* 577 */       String str5 = b(document);
/*     */ 
/*     */       
/* 580 */       if (a().a().a() == u.b) {
/* 581 */         arrayOfHeader = b().b(str1, Integer.parseInt(a().bo()), str3, str4, str5);
/*     */       } else {
/* 583 */         arrayOfHeader = b().a(str1, Integer.parseInt(a().bo()), str3, str4, str5);
/*     */       } 
/*     */       
/* 586 */       for (Header header : arrayOfHeader) {
/* 587 */         if (header.getName().equals("Location")) {
/* 588 */           String str = header.getValue();
/* 589 */           str = str.substring(str.indexOf("?") + 1);
/* 590 */           return str;
/*     */         } 
/*     */       } 
/* 593 */     } catch (Exception exception) {
/* 594 */       a.info("Failed to load hash", exception);
/*     */     } 
/*     */     
/* 597 */     return "";
/*     */   }
/*     */   
/*     */   private String b(Document paramDocument) {
/* 601 */     return paramDocument.select("input[id=__EVENTVALIDATION]").first().val();
/*     */   }
/*     */ 
/*     */   
/*     */   private String c(Document paramDocument) {
/* 606 */     return paramDocument.select("input[id=__VIEWSTATEGENERATOR]").first().val();
/*     */   }
/*     */ 
/*     */   
/*     */   private String d(Document paramDocument) {
/* 611 */     return paramDocument.select("input[id=__VIEWSTATE]").first().val();
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(Element paramElement) {
/* 616 */     this.a = paramElement;
/*     */   }
/*     */   
/*     */   public void b(Element paramElement) {
/* 620 */     this.b = paramElement;
/*     */   }
/*     */ 
/*     */   
/*     */   public c b() {
/* 625 */     return (c)super.b();
/*     */   }
/*     */ 
/*     */   
/*     */   public a b() {
/* 630 */     return (a)super.b();
/*     */   }
/*     */   
/*     */   public void y(int paramInt) {
/* 634 */     this.O = paramInt;
/*     */   }
/*     */   
/*     */   public void z(int paramInt) {
/* 638 */     this.L = paramInt;
/*     */   }
/*     */   
/*     */   public void A(int paramInt) {
/* 642 */     this.N = paramInt;
/*     */   }
/*     */   
/*     */   public void B(int paramInt) {
/* 646 */     this.R = paramInt;
/*     */   }
/*     */   
/*     */   public String o() {
/* 650 */     return this.Q;
/*     */   }
/*     */   
/*     */   public void C(int paramInt) {
/* 654 */     this.P = paramInt;
/*     */   }
/*     */   
/*     */   public void D(int paramInt) {
/* 658 */     this.Q = paramInt;
/*     */   }
/*     */   
/*     */   private String p() {
/* 662 */     if (this.S.isEmpty()) {
/* 663 */       this.S = n();
/*     */     }
/*     */     
/* 666 */     return this.S;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\b\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */