/*     */ package br.com.arremate.d.h;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.d.f;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.t;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.j.h.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.f.b;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.p.j;
/*     */ import br.com.arremate.l.q.c.f;
/*     */ import br.com.arremate.m.y;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import java.util.Timer;
/*     */ import java.util.TimerTask;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.ScheduledExecutorService;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.stream.Collectors;
/*     */ import java.util.stream.IntStream;
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
/*     */ 
/*     */ 
/*     */ public class e
/*     */   extends g
/*     */ {
/*     */   private final ExecutorService e;
/*     */   private final Map<Integer, Future<?>> c;
/*     */   private final Map<Integer, c> l;
/*     */   private final ExecutorService f;
/*     */   private final List<Future<br.com.arremate.h.e>> n;
/*     */   private String ab;
/*     */   private final Object f;
/*     */   private Timer a;
/*     */   private ScheduledExecutorService d;
/*     */   private a a;
/*     */   private a b;
/*     */   private a c;
/*     */   
/*     */   public e(b paramb, a parama, boolean paramBoolean) {
/*  61 */     super(paramb, (i)parama);
/*  62 */     a(new b(this, parama));
/*  63 */     j(2000L);
/*  64 */     this.e = Executors.newCachedThreadPool();
/*  65 */     this.c = (a)new HashMap<>();
/*  66 */     this.l = new HashMap<>();
/*     */     
/*  68 */     this.f = Executors.newFixedThreadPool(5);
/*  69 */     this.n = new ArrayList<>();
/*     */     
/*  71 */     this.f = new Object();
/*     */     
/*  73 */     this.a = new a();
/*  74 */     this.b = new a();
/*  75 */     this.c = new a();
/*     */     
/*  77 */     if (paramBoolean) {
/*  78 */       a().b(this);
/*     */     }
/*     */   }
/*     */   
/*     */   private void aQ() {
/*  83 */     this.d = Executors.newSingleThreadScheduledExecutor();
/*  84 */     Runnable runnable = () -> {
/*     */         synchronized (this.f) {
/*     */           aR();
/*     */           aS();
/*     */           aT();
/*     */         } 
/*     */       };
/*  91 */     this.d.scheduleAtFixedRate(runnable, 5L, 5L, TimeUnit.MINUTES);
/*     */   }
/*     */   
/*     */   private void aR() {
/*  95 */     if (this.a.q() > 0) {
/*  96 */       j.a().a(this.a, (j)a());
/*  97 */       this.a.reset();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void aS() {
/* 102 */     if (this.b.q() > 0) {
/* 103 */       j.a().b(this.b, (j)a());
/* 104 */       this.b.reset();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void aT() {
/* 109 */     if (this.c.q() > 0) {
/* 110 */       j.a().c(this.c, (j)a());
/* 111 */       this.c.reset();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected t b() {
/* 117 */     t t = super.b();
/* 118 */     if (t == t.c && 
/* 119 */       a().a() != m.a) {
/* 120 */       an();
/*     */     }
/*     */ 
/*     */     
/* 124 */     if (this.d == null) {
/* 125 */       aQ();
/*     */     }
/*     */     
/* 128 */     return t;
/*     */   }
/*     */ 
/*     */   
/*     */   public t a() {
/*     */     try {
/* 134 */       br.com.arremate.h.e e1 = a().n(a().v());
/*     */       
/* 136 */       long l = e1.k();
/* 137 */       e(l);
/*     */       
/* 139 */       String str = e1.getData();
/*     */       
/* 141 */       if (e1.O() || e1.getStatusCode() != 200) {
/* 142 */         a(l, e1.getStatusCode());
/*     */       } else {
/* 144 */         b(l, e1.getStatusCode());
/*     */       } 
/*     */       
/* 147 */       if (!str.isEmpty()) {
/* 148 */         i i = new i(str);
/* 149 */         if (i.has("descricaoStatus")) {
/* 150 */           boolean bool; String str1 = i.getString("descricaoStatus");
/* 151 */           k(str1);
/*     */           
/* 153 */           switch (str1) {
/*     */             case "Sessão Pública Iniciada":
/* 155 */               e1 = a().o(a().v());
/*     */               
/* 157 */               b(e1);
/*     */ 
/*     */               
/* 160 */               bool = (e1.getData().contains("Pregão não se encontra na fase de lances") || e1.getData().contains("Processo não se encontra na fase de lances")) ? true : false;
/*     */               
/* 162 */               if (bool) {
/* 163 */                 if (L()) {
/* 164 */                   return t.e;
/*     */                 }
/* 166 */                 return t.d;
/*     */               } 
/* 168 */               return t.c;
/*     */             case "Sessão Pública Finalizada":
/*     */             case "Encaminhado para adjudicação / homologação":
/*     */             case "Processo Fracassado":
/*     */             case "Cancelado":
/* 173 */               return t.d;
/*     */             case "Suspenso - Antes da Abertura":
/* 175 */               return t.e;
/*     */           } 
/*     */ 
/*     */           
/* 179 */           return t.b;
/*     */         }
/*     */       
/*     */       } 
/* 183 */     } catch (Exception exception) {
/* 184 */       a.error("Failed to get bidding status", exception);
/*     */     } 
/*     */     
/* 187 */     return t.b;
/*     */   }
/*     */   
/*     */   private boolean L() {
/* 191 */     String str = a().k(a().v());
/*     */     
/* 193 */     if (!y.m(str)) {
/* 194 */       return false;
/*     */     }
/*     */     
/* 197 */     i i = new i(str);
/*     */     
/* 199 */     if (!i.has("Suspensoes") || !i.has("Reinicio")) {
/* 200 */       return false;
/*     */     }
/*     */     
/* 203 */     f f1 = i.c("Suspensoes");
/* 204 */     f f2 = i.c("Reinicio");
/*     */     
/* 206 */     return (f1.length() > f2.length());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void ab() {
/* 212 */     super.ab();
/*     */     
/* 214 */     if (this.d != null) {
/* 215 */       this.d.shutdown();
/*     */     }
/*     */     
/* 218 */     if (this.a != null) {
/* 219 */       this.a.cancel();
/* 220 */       this.a = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void R() {
/*     */     try {
/* 227 */       br.com.arremate.h.e e1 = a().o(a().v());
/* 228 */       long l1 = e1.k();
/* 229 */       b(e1);
/* 230 */       if (!b(e1)) {
/*     */         return;
/*     */       }
/*     */       
/* 234 */       this.ab = (super.a().a() == u.a) ? "idItem" : "idLote";
/* 235 */       f f = new f(e1.getData());
/* 236 */       List<i> list = (List)IntStream.range(0, f.length()).mapToObj(f::b).collect(Collectors.toList());
/*     */       
/* 238 */       boolean bool = a().L().stream().anyMatch(parame -> paramList.stream().anyMatch(()));
/*     */       
/* 240 */       if (!bool) {
/* 241 */         a.info("Bloqueio na captura de itens - Motivo: Nenhum dos itens em disputa são do cliente - StatusCode: {}", Integer.valueOf(e1.getStatusCode()));
/*     */         
/*     */         return;
/*     */       } 
/* 245 */       h(list);
/* 246 */       g(list);
/*     */       
/* 248 */       long l2 = 0L;
/*     */       
/* 250 */       for (Future<br.com.arremate.h.e> future : this.n) {
/* 251 */         e1 = future.get();
/* 252 */         if (e1.k() > l2) {
/* 253 */           l2 = e1.k();
/*     */         }
/*     */         
/* 256 */         String str = e1.getData();
/*     */         
/* 258 */         if (str.isEmpty()) {
/* 259 */           a.warn("Bloqueio na captura de itens - Motivo : Nenhum dado retornado pelo portal - StatusCode: {}", Integer.valueOf(e1.getStatusCode()));
/*     */           
/*     */           continue;
/*     */         } 
/* 263 */         Document document = Jsoup.parse(str);
/* 264 */         Elements elements = document.select("tbody > tr");
/* 265 */         elements.forEach(paramElement -> {
/*     */               String str = paramElement.attr("id").replace("item", "");
/*     */               
/*     */               if (str.isEmpty()) {
/*     */                 return;
/*     */               }
/*     */               
/*     */               int i = Integer.parseInt(str);
/*     */               br.com.arremate.l.q.b.e e1 = a(i);
/*     */               if (e1 != null) {
/*     */                 Optional<i> optional = paramList.stream().filter(()).findFirst();
/*     */                 if (optional.isPresent()) {
/*     */                   paramList.remove(optional.get());
/*     */                   a(e1, paramElement, optional.get());
/*     */                 } 
/*     */               } 
/*     */             });
/*     */       } 
/* 283 */       i(list);
/* 284 */       e(l1 + l2);
/* 285 */     } catch (Exception exception) {
/* 286 */       a.error("Failed to load items data", exception);
/*     */     } finally {
/* 288 */       this.n.clear();
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean b(br.com.arremate.h.e parame) {
/* 293 */     String str = parame.getData().trim();
/* 294 */     if (parame.getStatusCode() == 405) {
/* 295 */       a.info("Falha na captura de itens - Motivo: Não conseguiu quebrar o captcha - StatusCode: {}", Integer.valueOf(parame.getStatusCode()));
/* 296 */       return false;
/*     */     } 
/* 298 */     if (str.contains("Pregão não se encontra na fase de lances") || str.contains("Processo não se encontra na fase de lances") || str
/* 299 */       .isEmpty()) {
/* 300 */       a.warn("Falha na captura de itens - Motivo : {} - StatusCode: {}", str, Integer.valueOf(parame.getStatusCode()));
/* 301 */       return false;
/*     */     } 
/* 303 */     return true;
/*     */   }
/*     */   
/*     */   private void g(List<i> paramList) {
/* 307 */     int i = y.a(paramList.size(), 10);
/* 308 */     for (byte b = 1; b <= i; b++) {
/* 309 */       byte b1 = b;
/* 310 */       this.n.add(this.f.submit(() -> a().e(a().v(), paramInt)));
/*     */     } 
/*     */   }
/*     */   
/*     */   private void a(br.com.arremate.l.q.b.e parame, Element paramElement, i parami) {
/* 315 */     int j = parame.v();
/*     */     
/*     */     try {
/* 318 */       Future future = (Future)this.c.get(Integer.valueOf(j));
/*     */       
/* 320 */       if (future == null || future.isDone()) {
/* 321 */         c c = this.l.get(Integer.valueOf(j));
/*     */         
/* 323 */         if (c == null) {
/* 324 */           c = a(parame);
/*     */           
/* 326 */           if (t.c.equals(c())) {
/* 327 */             this.l.put(Integer.valueOf(j), c);
/*     */             
/* 329 */             if (!parame.br() && isRunning()) {
/*     */               
/* 331 */               String str = "Item " + parame.bo() + " entrou em disputa com valor mínimo de R$ " + y.a("###,###,###,##0.0000").format(parame.l());
/* 332 */               l(str);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 337 */         c.i(paramElement);
/* 338 */         c.b(parami);
/* 339 */         Future<?> future1 = this.e.submit((Runnable)c);
/* 340 */         this.c.put(Integer.valueOf(j), future1);
/*     */       } 
/* 342 */     } catch (Exception exception) {
/* 343 */       a.warn("[Item {}] Failed to start item thread", parame.bo(), exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private c a(br.com.arremate.l.q.b.e parame) {
/*     */     c c;
/* 350 */     if (a().a() == m.c) {
/* 351 */       c = new d(parame, a(), this);
/*     */     } else {
/* 353 */       c = new c(parame, a(), this);
/*     */     } 
/*     */     
/* 356 */     return c;
/*     */   }
/*     */   
/*     */   private void h(List<i> paramList) {
/* 360 */     String str = "";
/*     */     
/* 362 */     for (br.com.arremate.l.q.b.e e1 : a().H()) {
/* 363 */       boolean bool = false;
/* 364 */       for (i i : paramList) {
/* 365 */         if (i.getInt(this.ab) == e1.v()) {
/* 366 */           bool = true;
/*     */           break;
/*     */         } 
/*     */       } 
/* 370 */       if (!bool) {
/* 371 */         str = String.join(" ", new CharSequence[] { str, e1.bo() });
/*     */       }
/*     */     } 
/*     */     
/* 375 */     if (!str.isEmpty()) {
/* 376 */       a.warn("Falha na captura dos itens pela API: {}", str);
/*     */     }
/*     */   }
/*     */   
/*     */   private void i(List<i> paramList) {
/* 381 */     String str = "";
/*     */     
/* 383 */     for (br.com.arremate.l.q.b.e e1 : a().H()) {
/* 384 */       for (i i : paramList) {
/* 385 */         if (i.getInt(this.ab) == e1.v()) {
/* 386 */           str = String.join(" ", new CharSequence[] { str, e1.bo() });
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 392 */     if (!str.isEmpty()) {
/* 393 */       a.warn("Falha na captura dos itens pelo Portal: {}", str);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void S() {
/*     */     try {
/* 400 */       byte b = 1;
/* 401 */       int i = y.a(a().getRowCount(), 10);
/*     */       
/*     */       do {
/* 404 */         br.com.arremate.h.e e1 = a().f(a().v(), b);
/* 405 */         e(e1.k());
/*     */         
/* 407 */         Document document = Jsoup.parse(e1.getData());
/* 408 */         Elements elements = document.select("tbody > tr");
/* 409 */         elements.forEach(paramElement -> {
/*     */               String str = paramElement.attr("id").replace("item", "");
/*     */               
/*     */               int i = Integer.parseInt(str);
/*     */               br.com.arremate.l.q.b.e e1 = a(i);
/*     */               if (e1 != null) {
/*     */                 a(e1, paramElement, (i)null);
/*     */               }
/*     */             });
/* 418 */         ++b;
/* 419 */       } while (b <= i);
/* 420 */     } catch (Exception exception) {
/* 421 */       a.error("Failed to load finished items data", Integer.valueOf(a().v()), exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> b(br.com.arremate.l.q.b.e parame) {
/* 427 */     if ((parame.bt() || parame.au()) && isRunning()) {
/* 428 */       c c = this.l.get(Integer.valueOf(parame.v()));
/* 429 */       return c.e();
/*     */     } 
/*     */     
/* 432 */     return e(parame);
/*     */   }
/*     */   
/*     */   private List<h> e(br.com.arremate.l.q.b.e parame) {
/* 436 */     ArrayList<h> arrayList = new ArrayList();
/*     */     
/*     */     try {
/* 439 */       String str1 = a().e(parame.a().v(), parame.v());
/* 440 */       String str2 = String.join("", new CharSequence[] { "<script>top.location.href='/4/SessaoPublica/?ttCD_CHAVE=", Integer.toString(parame.a().v()), "';</script>" });
/* 441 */       if (str1.isEmpty() || str1.equals(str2)) {
/* 442 */         return arrayList;
/*     */       }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 465 */       byte b = 1;
/*     */       
/* 467 */       Document document = Jsoup.parse(str1);
/* 468 */       Elements elements = document.select("table[id=tabTableSorter] > tbody > tr");
/* 469 */       for (Element element : elements) {
/* 470 */         Elements elements1 = element.select("td");
/* 471 */         String str3 = elements1.get(0).text().trim();
/* 472 */         String str4 = elements1.get(1).text().trim();
/* 473 */         Double double_ = Double.valueOf(elements1.get(2).text().replace("R$", "").replace(".", "").replace(",", ".").trim());
/* 474 */         String str5 = elements1.get(3).text().trim();
/* 475 */         String str6 = elements1.get(4).text().trim();
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
/*     */ 
/*     */         
/* 490 */         h h = new h(double_.doubleValue());
/* 491 */         h.E(str3);
/* 492 */         h.D(str4);
/* 493 */         h.ap(str6);
/* 494 */         h.al(str5);
/*     */         
/* 496 */         h.l(b++);
/*     */         
/*     */         try {
/* 499 */           h.A((Long.parseLong(str4.replaceAll("\\D", "")) == a().a().x()));
/* 500 */         } catch (Exception exception) {
/* 501 */           a.error("error parsing CNPJ", exception);
/*     */         } 
/*     */         
/* 504 */         arrayList.add(h);
/*     */       } 
/* 506 */     } catch (Exception exception) {
/* 507 */       a.error("[Item {}] Failed to get best bids from ranking page", parame.bo(), exception);
/*     */     } 
/*     */     
/* 510 */     return arrayList;
/*     */   }
/*     */   
/*     */   public boolean b(br.com.arremate.l.q.b.e parame, double paramDouble) {
/* 514 */     f f = this.l.get(Integer.valueOf(parame.v()));
/*     */     
/* 516 */     if (f != null) {
/* 517 */       return f.a(new h(paramDouble), true);
/*     */     }
/*     */     
/* 520 */     return false;
/*     */   }
/*     */   
/*     */   private void an() {
/* 524 */     this.a = (a)new Timer("CountdownTimer");
/* 525 */     this.a.schedule(a(), 1000L, 1000L);
/*     */   }
/*     */   
/*     */   private TimerTask a() {
/* 529 */     return new TimerTask(this)
/*     */       {
/*     */         public void run() {
/* 532 */           this.a.a().B().forEach(param1g -> {
/*     */                 long l = param1g.z();
/*     */                 if (l <= 0L) {
/*     */                   return;
/*     */                 }
/*     */                 if (param1g.aM() || param1g.au()) {
/*     */                   param1g.x(l - 1000L);
/*     */                   this.a.a().fireTableCellUpdated(this.a.a().indexOf(param1g.v()), 14);
/*     */                 } 
/*     */               });
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(long paramLong, int paramInt) {
/* 550 */     a(0, paramLong, paramInt);
/*     */   }
/*     */   
/*     */   public void b(long paramLong, int paramInt) {
/* 554 */     a(1, paramLong, paramInt);
/*     */   }
/*     */   
/*     */   private void a(int paramInt1, long paramLong, int paramInt2) {
/* 558 */     synchronized (this.f) {
/* 559 */       this.a.F(1);
/* 560 */       this.a.G(paramInt1);
/* 561 */       this.a.o(paramLong);
/* 562 */       this.a.a(paramInt2, 1);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void b(br.com.arremate.h.e parame) {
/* 567 */     if (!parame.O() && parame.getStatusCode() == 200) {
/* 568 */       d(parame.k(), parame.getStatusCode());
/* 569 */     } else if (parame.getData() != null && parame.getData().contains("Processo não se encontra na fase de lances")) {
/* 570 */       d(parame.k(), parame.getStatusCode());
/*     */     } else {
/* 572 */       c(parame.k(), parame.getStatusCode());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void c(long paramLong, int paramInt) {
/* 578 */     b(0, paramLong, paramInt);
/*     */   }
/*     */   
/*     */   public void d(long paramLong, int paramInt) {
/* 582 */     b(1, paramLong, paramInt);
/*     */   }
/*     */   
/*     */   private void b(int paramInt1, long paramLong, int paramInt2) {
/* 586 */     synchronized (this.f) {
/* 587 */       this.b.F(1);
/* 588 */       this.b.G(paramInt1);
/* 589 */       this.b.o(paramLong);
/* 590 */       this.b.a(paramInt2, 1);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void e(long paramLong, int paramInt) {
/* 596 */     c(0, paramLong, paramInt);
/*     */   }
/*     */   
/*     */   public void f(long paramLong, int paramInt) {
/* 600 */     c(1, paramLong, paramInt);
/*     */   }
/*     */   
/*     */   private void c(int paramInt1, long paramLong, int paramInt2) {
/* 604 */     synchronized (this.f) {
/* 605 */       this.c.F(1);
/* 606 */       this.c.G(paramInt1);
/* 607 */       this.c.o(paramLong);
/* 608 */       this.c.a(paramInt2, 1);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void a(f paramf, List<h> paramList) {}
/*     */ 
/*     */   
/*     */   protected void T() {}
/*     */ 
/*     */   
/*     */   public b a() {
/* 620 */     return (b)super.a();
/*     */   }
/*     */ 
/*     */   
/*     */   public final a a() {
/* 625 */     return (a)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\h\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */