/*     */ package br.com.arremate.d.c;
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
/*     */ import br.com.arremate.j.e.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.k.b.a;
/*     */ import br.com.arremate.k.b.b;
/*     */ import br.com.arremate.l.c.a;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class c
/*     */   extends f
/*     */ {
/*     */   private final SimpleDateFormat dateFormat;
/*     */   private a a;
/*     */   private List<h> j;
/*     */   private Element c;
/*     */   private Long a;
/*     */   private String V;
/*     */   private int S;
/*     */   
/*     */   public c(e parame, i parami, g paramg) {
/*  55 */     super(parame, parami, paramg);
/*  56 */     a((a)new b());
/*  57 */     this.dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
/*  58 */     this.j = new ArrayList<>();
/*  59 */     this.a = Long.valueOf(0L);
/*  60 */     this.S = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   protected h a() throws b, e, a {
/*  65 */     if (a().a().a().equals(m.c)) {
/*  66 */       if (this.a == null) {
/*  67 */         this.a = (Long)new a(this, true);
/*     */       }
/*     */       
/*  70 */       return this.a.a();
/*     */     } 
/*     */     
/*  73 */     return super.a();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void P() {
/*     */     try {
/*  79 */       e e = a();
/*  80 */       i i = a.g(e.getData());
/*     */       
/*  82 */       if (i == null) {
/*  83 */         a.info("[BLL] Failed to get item data | Bidding: {} | Item: {} | UASG: {}", new Object[] { a().a().bo(), 
/*  84 */               a().bo(), a().a().bT() });
/*     */         
/*     */         return;
/*     */       } 
/*  88 */       Document document = Jsoup.parse(i.getString("html"));
/*  89 */       Element element = document.select("table#BatchAndProcess").first();
/*     */       
/*  91 */       if (h(element)) {
/*     */         return;
/*     */       }
/*     */       
/*  95 */       av();
/*  96 */       ax();
/*     */       
/*  98 */       this.V = document.select("input#idBatch").attr("value").trim();
/*     */       
/* 100 */       c(element);
/* 101 */       d(element);
/* 102 */       a(document);
/* 103 */       this.j = b(document);
/* 104 */       b(document);
/* 105 */       ay();
/* 106 */       az();
/*     */       
/* 108 */       if (a().br()) {
/* 109 */         b().g(a());
/* 110 */         b().p(a());
/*     */       } 
/* 112 */     } catch (Exception exception) {
/* 113 */       a.error("Failed to update batch {} data", a().bo(), exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean h(Element paramElement) {
/* 118 */     if (paramElement == null) {
/* 119 */       return false;
/*     */     }
/*     */     
/* 122 */     String str1 = b().a().bo();
/* 123 */     String str2 = b().a().bT();
/* 124 */     String str3 = b().a().bW();
/*     */     
/* 126 */     Element element1 = paramElement.select("td:contains(Núm. Processo:) > b").first();
/* 127 */     Element element2 = paramElement.select("td:contains(Promotor:) > b").first();
/* 128 */     Element element3 = paramElement.select("td:contains(Cidade:) > b").first();
/*     */     
/* 130 */     boolean bool1 = (element2 == null || element2.text().equals(str2)) ? true : false;
/* 131 */     boolean bool2 = (element1 == null || element1.text().equals(str1)) ? true : false;
/* 132 */     boolean bool3 = (element3 == null || element3.text().contains(str3)) ? true : false;
/* 133 */     boolean bool4 = (bool2 && bool1 && bool3) ? true : false;
/*     */     
/* 135 */     if (bool4) {
/* 136 */       this.S = 0;
/* 137 */       return false;
/*     */     } 
/* 139 */     this.S++;
/* 140 */     a.warn("[BLL] Did not update item {}, because data came from a different bidding. Expected number: {}, uasg: {}, city: {} and received: number: {}, uasg: {}, city: {}", new Object[] {
/* 141 */           a().a().bo(), str1, str2, str3, element1.text(), element2.text(), element3.text()
/*     */         });
/*     */     
/* 144 */     return (this.S <= 5);
/*     */   }
/*     */ 
/*     */   
/*     */   private void av() {
/* 149 */     boolean bool = J();
/* 150 */     aw();
/*     */     
/* 152 */     if (bool && (a().bt() || a().a().au())) {
/* 153 */       String str = s();
/* 154 */       super.b().a(str, a().bo());
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean J() {
/* 159 */     return (a().bB() == null || a().bB().isEmpty() || a().bw());
/*     */   }
/*     */   
/*     */   private void aw() {
/* 163 */     String str = this.c.getElementById("CurrentStatusName").text().trim();
/* 164 */     str = a.a(str, a());
/* 165 */     a().N(str);
/*     */   }
/*     */   
/*     */   private String s() {
/* 169 */     DecimalFormat decimalFormat = y.a("###,###,###,##0.0000");
/* 170 */     String str = decimalFormat.format(a().l());
/* 171 */     return "Entrou em disputa com valor limite de R$ " + str;
/*     */   }
/*     */   
/*     */   private void ax() throws ParseException {
/* 175 */     if ((a().bt() || a().au()) && 
/* 176 */       a().a().a() != m.a) {
/* 177 */       String str = this.c.getElementById("CurrentStatusTime").text().trim();
/* 178 */       Long long_ = Long.valueOf(a(str));
/* 179 */       if (long_.longValue() > this.a.longValue()) {
/* 180 */         this.a = long_;
/*     */         
/* 182 */         long_ = Long.valueOf(long_.longValue() - n.a().longValue());
/* 183 */         if (long_.longValue() > 0L) {
/* 184 */           a().C(long_.longValue());
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private long a(String paramString) throws ParseException {
/* 191 */     Long long_ = Long.valueOf(this.dateFormat.parse(paramString).getTime());
/* 192 */     m m = a().a().a();
/* 193 */     g g = a().a();
/*     */     
/* 195 */     if (m == m.c) {
/* 196 */       if (g.ar()) {
/* 197 */         long_ = Long.valueOf(long_.longValue() + TimeUnit.MINUTES.toMillis(15L));
/* 198 */       } else if (g.at() || g.au()) {
/* 199 */         long_ = Long.valueOf(long_.longValue() + TimeUnit.MINUTES.toMillis(5L));
/* 200 */       } else if (g.as()) {
/* 201 */         long_ = Long.valueOf(0L);
/*     */       }
/*     */     
/* 204 */     } else if (g.as()) {
/* 205 */       long_ = Long.valueOf(long_.longValue() + TimeUnit.MINUTES.toMillis(a().a().M()));
/* 206 */     } else if (g.ar()) {
/* 207 */       if (m == m.b) {
/* 208 */         long_ = Long.valueOf(long_.longValue() + TimeUnit.MINUTES.toMillis(10L));
/* 209 */       } else if (g.b(a().bB(), g.aU)) {
/* 210 */         long_ = Long.valueOf(long_.longValue() + TimeUnit.MINUTES.toMillis(a().a().L()));
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 215 */     return long_.longValue();
/*     */   }
/*     */   
/*     */   private e a() {
/* 219 */     String str1 = this.c.getElementById("ButtonBidAndInfo").select("button").attr("onclick");
/* 220 */     str1 = str1.substring(str1.indexOf("[gkz]"));
/* 221 */     String str2 = str1.substring(0, str1.indexOf("',"));
/*     */     
/* 223 */     str1 = str1.substring(str1.indexOf("',"));
/* 224 */     String str3 = str1.substring(str1.indexOf("[gkz]"), str1.indexOf("']"));
/* 225 */     return b().j(str2, str3);
/*     */   }
/*     */   
/*     */   private void a(Document paramDocument) {
/* 229 */     a a1 = (a)a().a();
/* 230 */     if (a1.bh().isEmpty()) {
/* 231 */       Elements elements = paramDocument.select("form[method=post]").select("div");
/* 232 */       String str = elements.get(1).text().replace("LANCE", "").replace("(", "").replace(")", "").replace(":", "").trim();
/* 233 */       a1.O(str);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void c(Element paramElement) {
/* 238 */     Element element = paramElement.select("td:contains(FASE:)").first();
/*     */     
/* 240 */     if (element == null) {
/*     */       return;
/*     */     }
/*     */     
/* 244 */     element = element.select("b").first();
/*     */     
/* 246 */     if (element == null) {
/*     */       return;
/*     */     }
/*     */     
/* 250 */     String str = a.a(element.text().trim(), a());
/* 251 */     a().N(str);
/*     */   }
/*     */   
/*     */   private void d(Element paramElement) {
/* 255 */     Elements elements = c(paramElement);
/* 256 */     boolean bool = true;
/*     */     
/* 258 */     if (elements.isEmpty()) {
/* 259 */       elements = d(paramElement);
/*     */       
/* 261 */       if (elements.isEmpty()) {
/*     */         return;
/*     */       }
/*     */       
/* 265 */       bool = false;
/*     */     } 
/* 267 */     String str = elements.select("b").text();
/* 268 */     double d = y.a(str).doubleValue();
/*     */     
/* 270 */     if (d != 0.0D) {
/* 271 */       if (bool) {
/* 272 */         a().e(BigDecimal.valueOf(d));
/*     */       } else {
/* 274 */         a().f(BigDecimal.valueOf(d));
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private Elements c(Element paramElement) {
/* 280 */     Elements elements = paramElement.select("td:contains(Margem de Lance:)");
/*     */     
/* 282 */     if (elements.isEmpty()) {
/* 283 */       elements = paramElement.select("td:contains(Intervalo mínimo em valor:)");
/*     */     }
/*     */     
/* 286 */     return elements;
/*     */   }
/*     */   
/*     */   private Elements d(Element paramElement) {
/* 290 */     return paramElement.select("td:contains(Intervalo mínimo em %:)");
/*     */   }
/*     */   
/*     */   private void b(Document paramDocument) {
/* 294 */     Element element = paramDocument.select("div:contains(Seu melhor lance:) > b").first();
/*     */     
/* 296 */     if (element != null) {
/* 297 */       double d = y.a(element.text()).doubleValue();
/* 298 */       a().h(d);
/* 299 */     } else if (!this.j.isEmpty()) {
/* 300 */       Optional<h> optional = this.j.stream().filter(h::bb).findFirst();
/*     */       
/* 302 */       if (optional.isPresent()) {
/* 303 */         a().h(((h)optional.get()).m());
/*     */       } else {
/* 305 */         a.warn("[BLL] Couldn't find a bid from this company | Bidding: {} | Item: {} | UASG: {}", new Object[] {
/* 306 */               a().a().bo(), a().bo(), a().a().bT() });
/*     */       } 
/*     */     } else {
/* 309 */       a.warn("[BLL] Couldn't update last bid | Bidding: {} | Item: {} | UASG: {}", new Object[] {
/* 310 */             a().a().bo(), a().bo(), a().a().bT() });
/*     */     } 
/*     */   }
/*     */   
/*     */   private void ay() {
/* 315 */     h h = null;
/*     */     
/* 317 */     if (!this.j.isEmpty()) {
/* 318 */       h = this.j.get(0);
/*     */     }
/*     */     
/* 321 */     Element element = this.c.select("#WinnerBidValue").first();
/* 322 */     if (element != null) {
/* 323 */       double d = y.a(element.text()).doubleValue();
/*     */       
/* 325 */       boolean bool = (d > 0.0D && (h == null || h.m() > d)) ? true : false;
/*     */       
/* 327 */       if (bool) {
/* 328 */         a.info("[BLL] First place bid is delayed. Item {} best bid on main dispute page: R$ {}", a().bo(), Double.valueOf(d));
/* 329 */         h = new h(d);
/*     */       } 
/*     */     } 
/*     */     
/* 333 */     if (h != null) {
/* 334 */       a().h(h);
/*     */     }
/*     */   }
/*     */   
/*     */   private void az() {
/* 339 */     if (this.j.isEmpty()) {
/*     */       return;
/*     */     }
/* 342 */     h h = this.j.get(0);
/* 343 */     boolean bool = (this.j.size() > 1 && h.m() == ((h)this.j.get(1)).m()) ? true : false;
/* 344 */     s s = s.c;
/*     */     
/* 346 */     if (h.bb()) {
/* 347 */       s = bool ? s.b : s.a;
/* 348 */     } else if (bool && a().f() == h.m()) {
/* 349 */       s = s.b;
/*     */     } 
/* 351 */     a().a(s);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean a(i parami, String paramString) {
/* 356 */     return (parami == i.a || 
/* 357 */       g.b(paramString, g.aj) || (
/* 358 */       g.b(paramString, g.I) && parami == i.b) || (
/* 359 */       g.b(paramString, g.aU) && parami == i.d) || 
/* 360 */       a().bv());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean a(h paramh, boolean paramBoolean) {
/* 366 */     if (!b(paramh.m()) && !paramBoolean) {
/* 367 */       a.warn("Tentativa de lance abaixo do mínimo");
/* 368 */       return false;
/*     */     } 
/*     */     
/* 371 */     if (!k.b()) {
/* 372 */       a().a().y(n.a().longValue());
/* 373 */       a().w(a().aR());
/* 374 */       a("Lance de simulação", paramh, m(), paramBoolean, new String[0]);
/* 375 */       return true;
/*     */     } 
/*     */     try {
/*     */       e e;
/* 379 */       if (this.V.isEmpty()) {
/* 380 */         a.warn("Batch {} without id code to send bid", a().bo());
/* 381 */         return false;
/*     */       } 
/*     */       
/* 384 */       double d = paramh.m();
/*     */ 
/*     */       
/* 387 */       if (!a().bv()) {
/* 388 */         e = b().k(this.V, 
/* 389 */             y.a("###,###,##0.0000").format(d));
/*     */       } else {
/*     */         
/* 392 */         e = b().i(this.V, 
/* 393 */             y.a("###,###,##0.0000").format(d));
/*     */       } 
/*     */ 
/*     */       
/* 397 */       if (e.getData().isEmpty()) {
/* 398 */         a("Tentativa de lance", paramh, m(), paramBoolean, new String[] { "Sem retorno do portal" });
/* 399 */         a.warn("Failed to send bid, empty response for item {}, value: {}, status code: {}", new Object[] { a().bo(), Double.valueOf(paramh.m()), Integer.valueOf(e.getStatusCode()) });
/* 400 */         return false;
/*     */       } 
/*     */       
/* 403 */       return a(e, paramh, paramBoolean);
/* 404 */     } catch (Exception exception) {
/* 405 */       a.error("Failed to send batch {} bid", a().bo(), exception);
/*     */ 
/*     */       
/* 408 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean a(e parame, h paramh, boolean paramBoolean) {
/*     */     try {
/* 414 */       double d = parame.k() / 1000.0D;
/* 415 */       DecimalFormat decimalFormat = new DecimalFormat("#.##");
/* 416 */       String str = decimalFormat.format(d);
/*     */       
/* 418 */       i i = new i(parame.getData());
/* 419 */       if (i.has("modal")) {
/* 420 */         Document document = Jsoup.parse(i.getString("html"));
/* 421 */         Element element = document.select("div.modal-body").first();
/* 422 */         element.select("button").remove();
/* 423 */         String str1 = document.select("div.modal-body").first().text().trim();
/*     */         
/* 425 */         if (i.getString("modal").equals("error")) {
/* 426 */           if (c(str1)) {
/* 427 */             a().y(true);
/*     */           }
/*     */           
/* 430 */           a("Tentativa de lance", paramh, m(), paramBoolean, new String[] { str1, "Tempo para envio: " + str });
/* 431 */           return false;
/* 432 */         }  if (str1.toLowerCase().contains("lance efetuado")) {
/* 433 */           a().a().y(n.a().longValue());
/* 434 */           a().a().w(a().a().aR());
/*     */           
/* 436 */           a("Lance enviado", paramh, m(), paramBoolean, new String[] { "Tempo para envio: " + str });
/* 437 */           return true;
/*     */         } 
/*     */       } 
/*     */       
/* 441 */       if (i.has("message") && i.getString("message").equals("null")) {
/* 442 */         a().a().y(n.a().longValue());
/*     */         
/* 444 */         a("Lance enviado", paramh, m(), paramBoolean, new String[] { "Tempo para envio: " + str });
/* 445 */         return true;
/*     */       } 
/* 447 */     } catch (Exception exception) {
/* 448 */       a.error("Failed to process response batch {} bid", a().bo(), exception);
/*     */     } 
/*     */     
/* 451 */     a("Tentativa de lance", paramh, m(), paramBoolean, new String[] { "Retorno do portal é desconhecido" });
/* 452 */     a.warn("Failed to send bid, couldn't understand response for item {}, value: {}, status code: {}", new Object[] { a().bo(), Double.valueOf(paramh.m()), Integer.valueOf(parame.getStatusCode()) });
/* 453 */     return false;
/*     */   }
/*     */   
/*     */   private boolean c(String paramString) {
/* 457 */     paramString = paramString.toLowerCase();
/* 458 */     return ((paramString.contains("valor do lance precisa respeitar o intervalo mínimo entre lances") || paramString
/* 459 */       .contains("valor do lance precisa respeitar a margem")) && paramString
/* 460 */       .contains("lances intermediários ou da melhor oferta"));
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> e() throws d {
/* 465 */     if (!this.j.isEmpty()) {
/* 466 */       return new ArrayList<>(this.j);
/*     */     }
/*     */     try {
/* 469 */       e e = a();
/* 470 */       i i = a.g(e.getData());
/* 471 */       if (i != null) {
/* 472 */         Document document = Jsoup.parse(i.getString("html"));
/* 473 */         return b(document);
/*     */       } 
/* 475 */     } catch (Exception exception) {
/* 476 */       a.error("Failed to parse batch {} html for get best bids", a().bo(), exception);
/*     */     } 
/*     */ 
/*     */     
/* 480 */     return new ArrayList<>();
/*     */   }
/*     */   
/*     */   private List<h> b(Document paramDocument) {
/* 484 */     ArrayList<h> arrayList = new ArrayList();
/*     */     
/*     */     try {
/* 487 */       byte b = 1;
/* 488 */       a a1 = (a)a().a();
/*     */       
/* 490 */       Elements elements = paramDocument.select("table#Ranking > tbody > tr");
/* 491 */       if (elements.isEmpty()) {
/* 492 */         elements = paramDocument.select("div#Ranking > table > tbody > tr");
/*     */         
/* 494 */         if (elements.isEmpty()) {
/* 495 */           a.info("[BLL] Not able to get bid list");
/*     */         }
/*     */       } 
/* 498 */       elements.remove(0);
/*     */       
/* 500 */       for (Element element : elements) {
/* 501 */         Elements elements1 = element.select("td");
/*     */         
/* 503 */         String str = elements1.get(0).text();
/* 504 */         double d = y.a(elements1.get(1).text()).doubleValue();
/* 505 */         boolean bool = elements1.select("input").hasAttr("checked");
/*     */         
/* 507 */         h h = new h(d);
/* 508 */         h.E(str);
/* 509 */         h.x(bool);
/* 510 */         h.ap(bool ? "ME/EPP" : "Demais (Diferente de ME/EPP)");
/* 511 */         h.l(b++);
/*     */         
/* 513 */         h.A((str
/* 514 */             .equalsIgnoreCase(a1.a().a().bv()) || (
/* 515 */             !a1.bh().isEmpty() && str.equalsIgnoreCase(a1.bh()))));
/*     */ 
/*     */         
/* 518 */         arrayList.add(h);
/*     */       } 
/* 520 */     } catch (Exception exception) {
/* 521 */       a.error("Failed to get batch {} best bids", a().bo(), exception);
/*     */     } 
/*     */     
/* 524 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public a b() {
/* 529 */     return (a)super.b();
/*     */   }
/*     */ 
/*     */   
/*     */   public d b() {
/* 534 */     return (d)super.b();
/*     */   }
/*     */   
/*     */   protected void e(Element paramElement) {
/* 538 */     this.c = paramElement;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\c\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */