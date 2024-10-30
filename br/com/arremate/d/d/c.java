/*     */ package br.com.arremate.d.d;
/*     */ 
/*     */ import br.com.arremate.a.k;
/*     */ import br.com.arremate.d.a;
/*     */ import br.com.arremate.d.f;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.f.i;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.s;
/*     */ import br.com.arremate.g.a;
/*     */ import br.com.arremate.g.b;
/*     */ import br.com.arremate.g.d;
/*     */ import br.com.arremate.g.e;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.f.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.k.b.a;
/*     */ import br.com.arremate.k.b.b;
/*     */ import br.com.arremate.l.d.a;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.m.y;
/*     */ import br.com.arremate.n.n;
/*     */ import java.math.BigDecimal;
/*     */ import java.text.DecimalFormat;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.e.i;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ public class c
/*     */   extends f {
/*     */   private final SimpleDateFormat dateFormat;
/*     */   private a a;
/*     */   private List<h> j;
/*     */   private Element c;
/*     */   private Long a;
/*     */   private String V;
/*     */   private int S;
/*     */   
/*     */   public c(e parame, i parami, g paramg) {
/*  51 */     super(parame, parami, paramg);
/*  52 */     a((a)new b());
/*  53 */     this.dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
/*  54 */     this.j = new ArrayList<>();
/*  55 */     this.a = Long.valueOf(0L);
/*  56 */     this.S = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   protected h a() throws b, e, a {
/*  61 */     if (a().a().a().equals(m.c)) {
/*  62 */       if (this.a == null) {
/*  63 */         this.a = (Long)new a(this, true);
/*     */       }
/*     */       
/*  66 */       return this.a.a();
/*     */     } 
/*     */     
/*  69 */     return super.a();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void P() {
/*     */     try {
/*  75 */       e e = a();
/*  76 */       i i = a.g(e.getData());
/*     */       
/*  78 */       if (i == null) {
/*  79 */         a.info("[BNC] Failed to get item data | Bidding: {} | Item: {} | UASG: {}", new Object[] { a().a().bo(), 
/*  80 */               a().bo(), a().a().bT() });
/*     */         
/*     */         return;
/*     */       } 
/*  84 */       Document document = Jsoup.parse(i.getString("html"));
/*  85 */       Element element = document.select("table#BatchAndProcess").first();
/*     */       
/*  87 */       if (h(element)) {
/*     */         return;
/*     */       }
/*     */       
/*  91 */       aw();
/*  92 */       ax();
/*     */       
/*  94 */       this.V = document.select("input#idBatch").attr("value").trim();
/*     */       
/*  96 */       c(element);
/*  97 */       d(element);
/*  98 */       a(document);
/*  99 */       this.j = b(document);
/* 100 */       b(document);
/* 101 */       ay();
/* 102 */       az();
/*     */       
/* 104 */       if (a().br()) {
/* 105 */         b().g(a());
/* 106 */         b().p(a());
/*     */       } 
/* 108 */     } catch (Exception exception) {
/* 109 */       a.error("Failed to update batch {} data", a().bo(), exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean h(Element paramElement) {
/* 114 */     if (paramElement == null) {
/* 115 */       return false;
/*     */     }
/*     */     
/* 118 */     String str1 = b().a().bo();
/* 119 */     String str2 = b().a().bT();
/* 120 */     String str3 = b().a().bW();
/*     */     
/* 122 */     Element element1 = paramElement.select("td:contains(Núm. Processo:) > b").first();
/* 123 */     Element element2 = paramElement.select("td:contains(Promotor:) > b").first();
/* 124 */     Element element3 = paramElement.select("td:contains(Cidade:) > b").first();
/*     */     
/* 126 */     boolean bool1 = (element2 == null || element2.text().equals(str2)) ? true : false;
/* 127 */     boolean bool2 = (element1 == null || element1.text().equals(str1)) ? true : false;
/* 128 */     boolean bool3 = (element3 == null || element3.text().contains(str3)) ? true : false;
/* 129 */     boolean bool4 = (bool2 && bool1 && bool3) ? true : false;
/*     */     
/* 131 */     if (bool4) {
/* 132 */       this.S = 0;
/* 133 */       return false;
/*     */     } 
/* 135 */     this.S++;
/* 136 */     a.warn("[BNC] Did not update item {}, because data came from a different bidding. Expected number: {}, uasg: {}, city: {} and received: number: {}, uasg: {}, city: {}", new Object[] {
/* 137 */           a().a().bo(), str1, str2, str3, element1.text(), element2.text(), element3.text()
/*     */         });
/*     */     
/* 140 */     return (this.S <= 5);
/*     */   }
/*     */ 
/*     */   
/*     */   private void aw() {
/* 145 */     String str = this.c.getElementById("CurrentStatusName").text().trim();
/* 146 */     str = a.a(str, a());
/* 147 */     a().N(str);
/*     */   }
/*     */   
/*     */   private void ax() throws ParseException {
/* 151 */     if ((a().bt() || a().au()) && 
/* 152 */       a().a().a() != m.a) {
/* 153 */       String str = this.c.getElementById("CurrentStatusTime").text().trim();
/* 154 */       Long long_ = Long.valueOf(a(str));
/* 155 */       if (long_.longValue() > this.a.longValue()) {
/* 156 */         this.a = long_;
/*     */         
/* 158 */         long_ = Long.valueOf(long_.longValue() - n.a().longValue());
/* 159 */         if (long_.longValue() > 0L) {
/* 160 */           a().C(long_.longValue());
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private long a(String paramString) throws ParseException {
/* 167 */     Long long_ = Long.valueOf(this.dateFormat.parse(paramString).getTime());
/* 168 */     m m = a().a().a();
/* 169 */     g g = a().a();
/*     */     
/* 171 */     if (m == m.c) {
/* 172 */       if (g.ar()) {
/* 173 */         long_ = Long.valueOf(long_.longValue() + TimeUnit.MINUTES.toMillis(15L));
/* 174 */       } else if (g.at() || g.au()) {
/* 175 */         long_ = Long.valueOf(long_.longValue() + TimeUnit.MINUTES.toMillis(5L));
/* 176 */       } else if (g.as()) {
/* 177 */         long_ = Long.valueOf(0L);
/*     */       }
/*     */     
/* 180 */     } else if (g.as()) {
/* 181 */       long_ = Long.valueOf(long_.longValue() + TimeUnit.MINUTES.toMillis(a().a().M()));
/* 182 */     } else if (g.ar()) {
/* 183 */       if (m == m.b) {
/* 184 */         long_ = Long.valueOf(long_.longValue() + TimeUnit.MINUTES.toMillis(10L));
/* 185 */       } else if (g.b(a().bB(), g.aU)) {
/* 186 */         long_ = Long.valueOf(long_.longValue() + TimeUnit.MINUTES.toMillis(a().a().L()));
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 191 */     return long_.longValue();
/*     */   }
/*     */   
/*     */   private e a() {
/* 195 */     String str1 = this.c.getElementById("ButtonBidAndInfo").select("button").attr("onclick");
/* 196 */     str1 = str1.substring(str1.indexOf("[gkz]"));
/* 197 */     String str2 = str1.substring(0, str1.indexOf("',"));
/*     */     
/* 199 */     str1 = str1.substring(str1.indexOf("',"));
/* 200 */     String str3 = str1.substring(str1.indexOf("[gkz]"), str1.indexOf("']"));
/* 201 */     return b().j(str2, str3);
/*     */   }
/*     */   
/*     */   private void a(Document paramDocument) {
/* 205 */     a a1 = (a)a().a();
/* 206 */     if (a1.bh().isEmpty()) {
/* 207 */       Elements elements = paramDocument.select("form[method=post]").select("div");
/* 208 */       String str = elements.get(1).text().replace("LANCE", "").replace("(", "").replace(")", "").replace(":", "").trim();
/* 209 */       a1.O(str);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void c(Element paramElement) {
/* 214 */     Element element = paramElement.select("td:contains(FASE:)").first();
/*     */     
/* 216 */     if (element == null) {
/*     */       return;
/*     */     }
/*     */     
/* 220 */     element = element.select("b").first();
/*     */     
/* 222 */     if (element == null) {
/*     */       return;
/*     */     }
/*     */     
/* 226 */     String str = a.a(element.text().trim(), a());
/* 227 */     a().N(str);
/*     */   }
/*     */   
/*     */   private void d(Element paramElement) {
/* 231 */     Elements elements = c(paramElement);
/* 232 */     boolean bool = true;
/*     */     
/* 234 */     if (elements.isEmpty()) {
/* 235 */       elements = d(paramElement);
/*     */       
/* 237 */       if (elements.isEmpty()) {
/*     */         return;
/*     */       }
/*     */       
/* 241 */       bool = false;
/*     */     } 
/* 243 */     String str = elements.select("b").text();
/* 244 */     double d = y.a(str).doubleValue();
/*     */     
/* 246 */     if (d != 0.0D) {
/* 247 */       if (bool) {
/* 248 */         a().e(BigDecimal.valueOf(d));
/*     */       } else {
/* 250 */         a().f(BigDecimal.valueOf(d));
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private Elements c(Element paramElement) {
/* 256 */     Elements elements = paramElement.select("td:contains(Margem de Lance:)");
/*     */     
/* 258 */     if (elements.isEmpty()) {
/* 259 */       elements = paramElement.select("td:contains(Intervalo mínimo em valor:)");
/*     */     }
/*     */     
/* 262 */     return elements;
/*     */   }
/*     */   
/*     */   private Elements d(Element paramElement) {
/* 266 */     return paramElement.select("td:contains(Intervalo mínimo em %:)");
/*     */   }
/*     */   
/*     */   private void b(Document paramDocument) {
/* 270 */     Element element = paramDocument.select("div:contains(Seu melhor lance:) > b").first();
/*     */     
/* 272 */     if (element != null) {
/* 273 */       double d = y.a(element.text()).doubleValue();
/* 274 */       a().h(d);
/* 275 */     } else if (!this.j.isEmpty()) {
/* 276 */       Optional<h> optional = this.j.stream().filter(h::bb).findFirst();
/*     */       
/* 278 */       if (optional.isPresent()) {
/* 279 */         a().h(((h)optional.get()).m());
/*     */       } else {
/* 281 */         a.warn("[BNC] Couldn't find a bid from this company | Bidding: {} | Item: {} | UASG: {}", new Object[] {
/* 282 */               a().a().bo(), a().bo(), a().a().bT() });
/*     */       } 
/*     */     } else {
/* 285 */       a.warn("[BNC] Couldn't update last bid | Bidding: {} | Item: {} | UASG: {}", new Object[] {
/* 286 */             a().a().bo(), a().bo(), a().a().bT() });
/*     */     } 
/*     */   }
/*     */   
/*     */   private void ay() {
/* 291 */     h h = null;
/*     */     
/* 293 */     if (!this.j.isEmpty()) {
/* 294 */       h = this.j.get(0);
/*     */     }
/*     */     
/* 297 */     Element element = this.c.select("#WinnerBidValue").first();
/* 298 */     if (element != null) {
/* 299 */       double d = y.a(element.text()).doubleValue();
/*     */       
/* 301 */       boolean bool = (d > 0.0D && (h == null || h.m() > d)) ? true : false;
/*     */       
/* 303 */       if (bool) {
/* 304 */         a.info("[BNC] First place bid is delayed. Item {} best bid on main dispute page: R$ {}", a().bo(), Double.valueOf(d));
/* 305 */         h = new h(d);
/*     */       } 
/*     */     } 
/*     */     
/* 309 */     if (h != null) {
/* 310 */       a().h(h);
/*     */     }
/*     */   }
/*     */   
/*     */   private void az() {
/* 315 */     if (this.j.isEmpty()) {
/*     */       return;
/*     */     }
/* 318 */     h h = this.j.get(0);
/* 319 */     boolean bool = (this.j.size() > 1 && h.m() == ((h)this.j.get(1)).m()) ? true : false;
/* 320 */     s s = s.c;
/*     */     
/* 322 */     if (h.bb()) {
/* 323 */       s = bool ? s.b : s.a;
/* 324 */     } else if (bool && a().f() == h.m()) {
/* 325 */       s = s.b;
/*     */     } 
/* 327 */     a().a(s);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean a(i parami, String paramString) {
/* 332 */     return (parami == i.a || 
/* 333 */       g.b(paramString, g.aj) || (
/* 334 */       g.b(paramString, g.I) && parami == i.b) || (
/* 335 */       g.b(paramString, g.aU) && parami == i.d) || 
/* 336 */       a().bv());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean a(h paramh, boolean paramBoolean) {
/* 341 */     if (!b(paramh.m()) && !paramBoolean) {
/* 342 */       a.warn("Tentativa de lance abaixo do mínimo");
/* 343 */       return false;
/*     */     } 
/*     */     
/* 346 */     if (!k.b()) {
/* 347 */       a().a().y(n.a().longValue());
/* 348 */       a().w(a().aR());
/* 349 */       a("Lance de simulação", paramh, m(), paramBoolean, new String[0]);
/* 350 */       return true;
/*     */     } 
/*     */     try {
/*     */       e e;
/* 354 */       if (this.V.isEmpty()) {
/* 355 */         a.warn("Batch {} without id code to send bid", a().bo());
/* 356 */         return false;
/*     */       } 
/*     */       
/* 359 */       double d = paramh.m();
/*     */ 
/*     */       
/* 362 */       if (!a().bv()) {
/* 363 */         e = b().k(this.V, 
/* 364 */             y.a("###,###,##0.0000").format(d));
/*     */       } else {
/*     */         
/* 367 */         e = b().i(this.V, 
/* 368 */             y.a("###,###,##0.0000").format(d));
/*     */       } 
/*     */ 
/*     */       
/* 372 */       if (e.getData().isEmpty()) {
/* 373 */         a("Tentativa de lance", paramh, m(), paramBoolean, new String[] { "Sem retorno do portal" });
/* 374 */         a.warn("Failed to send bid, empty response for item {}, value: {}, status code: {}", new Object[] { a().bo(), Double.valueOf(paramh.m()), Integer.valueOf(e.getStatusCode()) });
/* 375 */         return false;
/*     */       } 
/*     */       
/* 378 */       return a(e, paramh, paramBoolean);
/* 379 */     } catch (Exception exception) {
/* 380 */       a.error("Failed to send batch {} bid", a().bo(), exception);
/*     */ 
/*     */       
/* 383 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean a(e parame, h paramh, boolean paramBoolean) {
/*     */     try {
/* 389 */       double d = parame.k() / 1000.0D;
/* 390 */       DecimalFormat decimalFormat = new DecimalFormat("#.##");
/* 391 */       String str = decimalFormat.format(d);
/*     */       
/* 393 */       i i = new i(parame.getData());
/* 394 */       if (i.has("modal")) {
/* 395 */         Document document = Jsoup.parse(i.getString("html"));
/* 396 */         Element element = document.select("div.modal-body").first();
/* 397 */         element.select("button").remove();
/* 398 */         String str1 = document.select("div.modal-body").first().text().trim();
/*     */         
/* 400 */         if (i.getString("modal").equals("error")) {
/* 401 */           if (c(str1)) {
/* 402 */             a().y(true);
/*     */           }
/*     */           
/* 405 */           a("Tentativa de lance", paramh, m(), paramBoolean, new String[] { str1, "Tempo para envio: " + str });
/* 406 */           return false;
/* 407 */         }  if (str1.toLowerCase().contains("lance efetuado")) {
/* 408 */           a().a().y(n.a().longValue());
/* 409 */           a().a().w(a().a().aR());
/*     */           
/* 411 */           a("Lance enviado", paramh, m(), paramBoolean, new String[] { "Tempo para envio: " + str });
/* 412 */           return true;
/*     */         } 
/*     */       } 
/*     */       
/* 416 */       if (i.has("message") && i.getString("message").equals("null")) {
/* 417 */         a().a().y(n.a().longValue());
/*     */         
/* 419 */         a("Lance enviado", paramh, m(), paramBoolean, new String[] { "Tempo para envio: " + str });
/* 420 */         return true;
/*     */       } 
/* 422 */     } catch (Exception exception) {
/* 423 */       a.error("Failed to process response batch {} bid", a().bo(), exception);
/*     */     } 
/*     */     
/* 426 */     a("Tentativa de lance", paramh, m(), paramBoolean, new String[] { "Retorno do portal é desconhecido" });
/* 427 */     a.warn("Failed to send bid, couldn't understand response for item {}, value: {}, status code: {}", new Object[] { a().bo(), Double.valueOf(paramh.m()), Integer.valueOf(parame.getStatusCode()) });
/* 428 */     return false;
/*     */   }
/*     */   
/*     */   private boolean c(String paramString) {
/* 432 */     paramString = paramString.toLowerCase();
/* 433 */     return ((paramString.contains("valor do lance precisa respeitar o intervalo mínimo entre lances") || paramString
/* 434 */       .contains("valor do lance precisa respeitar a margem")) && paramString
/* 435 */       .contains("lances intermediários ou da melhor oferta"));
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> e() throws d {
/* 440 */     if (!this.j.isEmpty()) {
/* 441 */       return new ArrayList<>(this.j);
/*     */     }
/*     */     try {
/* 444 */       e e = a();
/* 445 */       i i = a.g(e.getData());
/* 446 */       if (i != null) {
/* 447 */         Document document = Jsoup.parse(i.getString("html"));
/* 448 */         return b(document);
/*     */       } 
/* 450 */     } catch (Exception exception) {
/* 451 */       a.error("Failed to parse batch {} html for get best bids", a().bo(), exception);
/*     */     } 
/*     */ 
/*     */     
/* 455 */     return new ArrayList<>();
/*     */   }
/*     */   
/*     */   private List<h> b(Document paramDocument) {
/* 459 */     ArrayList<h> arrayList = new ArrayList();
/*     */     
/*     */     try {
/* 462 */       byte b = 1;
/* 463 */       a a1 = (a)a().a();
/*     */       
/* 465 */       Elements elements = paramDocument.select("table#Ranking > tbody > tr");
/* 466 */       if (elements.isEmpty()) {
/* 467 */         elements = paramDocument.select("div#Ranking > table > tbody > tr");
/*     */         
/* 469 */         if (elements.isEmpty()) {
/* 470 */           a.info("[BNC] Not able to get bid list");
/*     */         }
/*     */       } 
/* 473 */       elements.remove(0);
/*     */       
/* 475 */       for (Element element : elements) {
/* 476 */         Elements elements1 = element.select("td");
/*     */         
/* 478 */         String str = elements1.get(0).text();
/* 479 */         double d = y.a(elements1.get(1).text()).doubleValue();
/* 480 */         boolean bool = elements1.select("input").hasAttr("checked");
/*     */         
/* 482 */         h h = new h(d);
/* 483 */         h.E(str);
/* 484 */         h.x(bool);
/* 485 */         h.ap(bool ? "ME/EPP" : "Demais (Diferente de ME/EPP)");
/* 486 */         h.l(b++);
/*     */         
/* 488 */         h.A((str
/* 489 */             .toLowerCase().equals(a1.a().a().bv().toLowerCase()) || (
/* 490 */             !a1.bh().isEmpty() && str.toLowerCase().equals(a1.bh().toLowerCase()))));
/*     */ 
/*     */         
/* 493 */         arrayList.add(h);
/*     */       } 
/* 495 */     } catch (Exception exception) {
/* 496 */       a.error("Failed to get batch {} best bids", a().bo(), exception);
/*     */     } 
/*     */     
/* 499 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public a b() {
/* 504 */     return (a)super.b();
/*     */   }
/*     */ 
/*     */   
/*     */   public d b() {
/* 509 */     return (d)super.b();
/*     */   }
/*     */   
/*     */   protected void e(Element paramElement) {
/* 513 */     this.c = paramElement;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\d\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */