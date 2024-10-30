/*     */ package br.com.arremate.d.e;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.d.f;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.f.l;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.o;
/*     */ import br.com.arremate.f.s;
/*     */ import br.com.arremate.f.t;
/*     */ import br.com.arremate.f.v;
/*     */ import br.com.arremate.g.d;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.c.c;
/*     */ import br.com.arremate.j.c.e;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.e.c;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.p.j;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.l.q.b.f;
/*     */ import br.com.arremate.l.q.b.i;
/*     */ import br.com.arremate.l.q.c.f;
/*     */ import br.com.arremate.l.q.c.g;
/*     */ import br.com.arremate.l.q.c.i;
/*     */ import br.com.arremate.m.y;
/*     */ import br.com.arremate.n.n;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.RoundingMode;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Comparator;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import java.util.Timer;
/*     */ import java.util.TimerTask;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.TimeUnit;
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
/*     */ public class p
/*     */   extends g
/*     */   implements a
/*     */ {
/*  63 */   private final ExecutorService d = Executors.newFixedThreadPool(1);
/*     */   
/*     */   private final ExecutorService executor;
/*     */   
/*     */   private final Map<Integer, Future> c;
/*     */   
/*     */   private final Map<Integer, e> l;
/*     */   private final Object f;
/*     */   private q a;
/*     */   private Future a;
/*     */   private Timer a;
/*     */   private int T;
/*     */   private Timer f;
/*     */   private int U;
/*     */   private int V;
/*     */   private long o;
/*     */   
/*     */   public p(b paramb, c paramc, boolean paramBoolean) {
/*  81 */     super(paramb, (i)paramc);
/*  82 */     a(new d(this, paramc));
/*  83 */     j(TimeUnit.SECONDS.toMillis(3L));
/*     */     
/*  85 */     this.executor = Executors.newCachedThreadPool();
/*  86 */     this.c = new HashMap<>();
/*  87 */     this.l = new HashMap<>();
/*     */     
/*  89 */     this.f = (Timer)new Object();
/*     */     
/*  91 */     this.U = 0;
/*  92 */     this.V = 0;
/*  93 */     this.o = 0L;
/*     */     
/*  95 */     if (paramBoolean) {
/*  96 */       b().a(this);
/*     */     }
/*     */   }
/*     */   
/*     */   private void aF() {
/* 101 */     this.f = new Timer("logBestBids");
/* 102 */     this.f.schedule(new TimerTask(this)
/*     */         {
/*     */           public void run() {
/* 105 */             p.a(this.a);
/*     */           }
/* 107 */         },  TimeUnit.MINUTES.toMillis(5L), TimeUnit.MINUTES.toMillis(5L));
/*     */   }
/*     */   
/*     */   private void aG() {
/* 111 */     synchronized (this.f) {
/* 112 */       if (this.U > 0) {
/*     */ 
/*     */         
/* 115 */         double d1 = BigDecimal.valueOf(this.V).divide(BigDecimal.valueOf(this.U), 4, RoundingMode.HALF_EVEN).multiply(BigDecimal.valueOf(100L)).doubleValue();
/*     */ 
/*     */ 
/*     */         
/* 119 */         double d2 = BigDecimal.valueOf(this.o).divide(BigDecimal.valueOf(this.U), 4, RoundingMode.HALF_EVEN).divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_EVEN).doubleValue();
/*     */         
/* 121 */         j.a().a(this.U, d1, d2);
/*     */         
/* 123 */         this.U = 0;
/* 124 */         this.V = 0;
/* 125 */         this.o = 0L;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected t b() {
/* 132 */     t t = super.b();
/* 133 */     if (t == t.c) {
/* 134 */       this.a = (Timer)q.a(a(), b());
/* 135 */       this.a = (Timer)this.d.submit((Runnable)this.a);
/* 136 */       this.T = b().B();
/* 137 */       an();
/* 138 */       aF();
/*     */     } 
/*     */     
/* 141 */     return t;
/*     */   }
/*     */ 
/*     */   
/*     */   public t a() {
/* 146 */     l l = a().a();
/* 147 */     if (l.equals(l.h) || l.equals(l.k)) {
/*     */       try {
/* 149 */         e e = new e(b().a());
/* 150 */         e.a((i)b());
/* 151 */         e.bN();
/*     */         
/* 153 */         e e1 = e.j(a().bk());
/* 154 */         e(e1.k());
/*     */         
/* 156 */         i i = new i(e1.getData());
/* 157 */         String str = i.getString("faseCompraFaseExterna");
/* 158 */         switch (str) {
/*     */           case "1":
/*     */           case "2":
/*     */           case "99":
/* 162 */             return t.b;
/*     */           case "3":
/* 164 */             return t.c;
/*     */         } 
/* 166 */         return t.d;
/*     */       }
/* 168 */       catch (Exception exception) {
/* 169 */         a.error("Erro ao capturar a situação do pregão da nova lei", exception);
/* 170 */         b().bL();
/*     */       } 
/*     */     } else {
/*     */       try {
/* 174 */         e e = b().d();
/* 175 */         e(e.k());
/*     */         
/* 177 */         String str = e.getData();
/* 178 */         if (!str.isEmpty()) {
/* 179 */           e(e.k());
/* 180 */           a(new Date(n.a().longValue()));
/*     */           
/* 182 */           String str1 = Integer.toString(a().v());
/* 183 */           if (str.contains(str1)) {
/* 184 */             if (c(str, str1)) {
/* 185 */               return t.e;
/*     */             }
/*     */             
/* 188 */             return t.c;
/*     */           } 
/*     */           
/* 191 */           e = b().c();
/* 192 */           e(e.k());
/*     */           
/* 194 */           str = e.getData();
/* 195 */           if (!str.isEmpty() && !str.contains(str1)) {
/* 196 */             e = b().g();
/* 197 */             e(e.k());
/*     */             
/* 199 */             str = e.getData();
/* 200 */             if (!str.isEmpty()) {
/* 201 */               return str.contains(str1) ? t.f : t.d;
/*     */             }
/*     */           } 
/*     */         } 
/* 205 */       } catch (Exception exception) {
/* 206 */         a.error("Erro ao capturar a situação do pregão da antiga lei", exception);
/*     */       } 
/*     */     } 
/*     */     
/* 210 */     return t.b;
/*     */   }
/*     */   
/*     */   private boolean c(String paramString1, String paramString2) {
/*     */     try {
/* 215 */       Document document = Jsoup.parse(paramString1);
/* 216 */       Elements elements = document.select("table table table");
/* 217 */       Element element = (elements != null && elements.size() > 1) ? elements.get(1) : null;
/*     */       
/* 219 */       if (element != null) {
/* 220 */         Elements elements1 = element.select("tr");
/*     */         
/* 222 */         for (Element element1 : elements1) {
/* 223 */           if (element1.html().contains(paramString2)) {
/* 224 */             return element1.html().contains("Suspensão Administrativa");
/*     */           }
/*     */         } 
/*     */       } 
/* 228 */     } catch (Exception exception) {
/* 229 */       a.warn("Failed to indetify suspended bidding", exception);
/*     */     } 
/*     */     
/* 232 */     return false;
/*     */   }
/*     */   
/*     */   private void an() {
/* 236 */     this.a = new Timer("CountdownTimer");
/* 237 */     this.a.schedule(new TimerTask(this)
/*     */         {
/*     */           public void run() {
/* 240 */             this.a.a().B().parallelStream().forEach(param1g -> {
/*     */                   long l = param1g.z();
/*     */                   
/*     */                   if (l <= 0L) {
/*     */                     return;
/*     */                   }
/*     */                   
/*     */                   if (param1g.aM() || param1g.au()) {
/*     */                     param1g.x(l - 1000L);
/*     */                     
/*     */                     this.a.a().fireTableCellUpdated(this.a.a().indexOf(param1g.v()), 14);
/*     */                   } 
/*     */                 });
/* 253 */             this.a.a().G().parallelStream().forEach(param1f -> {
/*     */                   long l = param1f.z();
/*     */                   if (l <= 0L) {
/*     */                     return;
/*     */                   }
/*     */                   if (param1f.aM() || param1f.au()) {
/*     */                     param1f.x(l - 1000L);
/*     */                     this.a.a().fireTableCellUpdated(this.a.a().indexOf(param1f.v()), 14);
/*     */                   } 
/*     */                 });
/*     */           }
/*     */         }1000L, 1000L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void R() {
/*     */     try {
/* 272 */       int i = b().B();
/* 273 */       if (this.T < i) {
/* 274 */         this.T = i;
/* 275 */         this.a.aJ();
/*     */         
/*     */         return;
/*     */       } 
/* 279 */       if (this.a.isDone()) {
/* 280 */         this.a = (Timer)this.d.submit((Runnable)this.a);
/*     */         
/*     */         return;
/*     */       } 
/* 284 */       if (this.a.e() > 0L) {
/* 285 */         e(this.a.e());
/*     */       }
/*     */       
/* 288 */       f(this.a.f());
/* 289 */       i i1 = this.a.j();
/*     */       
/* 291 */       for (Iterator<String> iterator = i1.o(); iterator.hasNext(); ) {
/* 292 */         String str = iterator.next();
/* 293 */         i i2 = i1.j(str);
/*     */         
/* 295 */         if (i2.has("identificador")) {
/* 296 */           str = i2.getString("identificador");
/*     */         } else {
/*     */           try {
/* 299 */             if (Integer.parseInt(str) < 0) {
/* 300 */               a.warn("Group or item identifier not found");
/*     */             }
/* 302 */           } catch (NumberFormatException numberFormatException) {
/* 303 */             a.warn("Strange item code: {}", str);
/*     */           } 
/*     */         } 
/*     */         
/* 307 */         e e = a(str);
/* 308 */         if (e != null && !e.br()) {
/* 309 */           b(e, i2);
/*     */         }
/*     */       } 
/* 312 */     } catch (Exception exception) {
/* 313 */       a.error("#003", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void b(e parame, i parami) {
/* 318 */     int j = parame.v();
/* 319 */     Future future = this.c.get(Integer.valueOf(j));
/*     */     
/*     */     try {
/* 322 */       if (future == null || future.isDone()) {
/* 323 */         e e1 = this.l.get(Integer.valueOf(j));
/*     */         
/* 325 */         if (e1 == null) {
/* 326 */           e1 = a(parame);
/*     */           
/* 328 */           if (t.c.equals(c())) {
/*     */             
/* 330 */             this.l.put(Integer.valueOf(j), e1);
/*     */             
/* 332 */             String str1 = e1.l();
/* 333 */             DecimalFormat decimalFormat = y.a("###,###,###,##0.0000");
/* 334 */             String str2 = decimalFormat.format(parame.l());
/*     */             
/* 336 */             StringBuilder stringBuilder = new StringBuilder();
/* 337 */             stringBuilder.append(str1).append(" ").append(parame.bo());
/* 338 */             if (parame.w() == v.b.v()) {
/* 339 */               stringBuilder.append(" entrou em disputa com valor mínimo de ").append(str2).append("%");
/*     */             } else {
/* 341 */               stringBuilder.append(" entrou em disputa com valor mínimo de R$ ").append(str2);
/*     */             } 
/* 343 */             l(stringBuilder.toString());
/*     */           } 
/*     */         } 
/*     */         
/* 347 */         e1.b(parami);
/*     */         
/* 349 */         Future<?> future1 = this.executor.submit((Runnable)e1);
/* 350 */         this.c.put(Integer.valueOf(j), future1);
/*     */       } 
/* 352 */     } catch (Exception exception) {
/* 353 */       a.error("#004", exception);
/* 354 */       h("#004");
/*     */     } 
/*     */   }
/*     */   protected e a(e parame) {
/*     */     l l;
/* 359 */     if (parame == null) {
/* 360 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 364 */     j j = parame.a();
/*     */     
/* 366 */     if (parame instanceof f) {
/* 367 */       f f = (f)parame;
/* 368 */       if (j.a() == m.b || j.a() == m.f) {
/* 369 */         f f1 = new f(f, b(), this);
/*     */       } else {
/* 371 */         g g1 = new g(f, b(), this);
/*     */       }
/*     */     
/* 374 */     } else if (parame.w() == v.b.v()) {
/* 375 */       if (j.a() == m.b || j.a() == m.f) {
/* 376 */         k k = new k(parame, b(), this);
/*     */       } else {
/* 378 */         l = new m(parame, b(), this);
/*     */       } 
/* 380 */     } else if (j.k()) {
/* 381 */       if (j.a() == m.b || j.a() == m.f) {
/* 382 */         o o = new o(parame, b(), this);
/*     */       } else {
/* 384 */         l = new n(parame, b(), this);
/*     */       }
/*     */     
/* 387 */     } else if (j.a() == m.b || j.a() == m.f) {
/* 388 */       j j1 = new j(parame, b(), this);
/*     */     } else {
/* 390 */       l = new l(parame, b(), this);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 395 */     return l;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> b(e parame) throws d {
/* 400 */     int i = parame.v();
/*     */     
/* 402 */     f f = this.l.get(Integer.valueOf(i));
/* 403 */     if (f != null) {
/* 404 */       return f.e();
/*     */     }
/*     */     
/* 407 */     if (!isRunning()) {
/* 408 */       l l = parame.a().a();
/*     */       
/* 410 */       boolean bool = (l.equals(l.h) || l.equals(l.k)) ? true : false;
/* 411 */       if (bool && !(parame instanceof br.com.arremate.l.q.b.g)) {
/*     */         try {
/* 413 */           if (b().a() == null || b().a().isEmpty()) {
/* 414 */             b().bN();
/*     */           }
/* 416 */         } catch (Exception exception) {
/* 417 */           a.error("Failed to enter the new area of Comprasnet", exception);
/*     */         } 
/*     */         
/* 420 */         if (parame.ay()) {
/* 421 */           a((f)parame);
/*     */         }
/*     */         
/* 424 */         return d(parame);
/*     */       } 
/*     */       
/* 427 */       e e1 = b().h();
/* 428 */       if (e1.getData().contains(Integer.toString(parame.a().v()))) {
/* 429 */         b b = new b(b());
/* 430 */         return b.c(parame);
/*     */       } 
/*     */     } 
/*     */     
/* 434 */     return new ArrayList<>();
/*     */   }
/*     */   private List<h> d(e parame) {
/*     */     String str1;
/* 438 */     ArrayList<h> arrayList = new ArrayList();
/*     */ 
/*     */     
/* 441 */     if (parame.ay()) {
/* 442 */       str1 = ((f)parame).a().bC();
/*     */     } else {
/* 444 */       str1 = parame.bo();
/*     */     } 
/*     */     
/* 447 */     c c = (c)parame.a();
/* 448 */     String str2 = c.bk();
/* 449 */     String str3 = b().d(str2, str1).getData();
/* 450 */     if (str3.isEmpty()) {
/* 451 */       return arrayList;
/*     */     }
/*     */     
/* 454 */     if (!str3.startsWith("[")) {
/* 455 */       return arrayList;
/*     */     }
/*     */     
/* 458 */     f f1 = new f(str3);
/* 459 */     f f2 = f1.b(0).c("propostasItem");
/*     */     
/* 461 */     if (parame.ay()) {
/* 462 */       return b(parame, f2);
/*     */     }
/* 464 */     return a(parame, f2);
/*     */   }
/*     */ 
/*     */   
/*     */   private List<h> a(e parame, f paramf) {
/* 469 */     ArrayList<h> arrayList = new ArrayList();
/*     */     
/* 471 */     for (byte b = 0; b < paramf.length(); b++) {
/* 472 */       i i = paramf.b(b);
/* 473 */       if (!i.has("situacao") || i.getInt("situacao") != 2)
/*     */       {
/*     */ 
/*     */         
/* 477 */         if (i.has("valores")) {
/*     */ 
/*     */ 
/*     */           
/* 481 */           h h = a(i, parame);
/* 482 */           arrayList.add(h);
/*     */         }  } 
/*     */     } 
/* 485 */     return arrayList;
/*     */   }
/*     */   
/*     */   private List<h> b(e parame, f paramf) {
/* 489 */     List<h> list = a(parame, paramf);
/* 490 */     ArrayList<String> arrayList = new ArrayList();
/*     */     
/* 492 */     for (h h : list) {
/* 493 */       arrayList.add(h.av());
/*     */     }
/*     */     
/* 496 */     a(arrayList, parame);
/* 497 */     return list;
/*     */   }
/*     */   
/*     */   private void a(List<String> paramList, e parame) {
/* 501 */     c c = (c)parame.a();
/* 502 */     String str1 = c.bk();
/* 503 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 504 */     String str2 = ((f)parame).a().bC();
/*     */     
/* 506 */     label23: for (String str : paramList) {
/* 507 */       byte b = 0;
/*     */       
/*     */       while (true) {
/* 510 */         e e1 = b().a(str1, str, str2, b);
/*     */         
/* 512 */         String str3 = e1.getData();
/* 513 */         if (str3.isEmpty()) {
/*     */           return;
/*     */         }
/*     */         
/* 517 */         f f = new f(str3);
/* 518 */         for (byte b1 = 0; b1 < f.length(); b1++) {
/* 519 */           i i1 = f.b(b1);
/* 520 */           i i2 = i1.j("propostaItem");
/*     */           
/* 522 */           String str4 = String.valueOf(i1.getInt("numero"));
/* 523 */           h h = a(i2, parame);
/*     */           
/* 525 */           List<h> list = (List)hashMap.get(str4);
/*     */           
/* 527 */           if (list == null) {
/* 528 */             list = new ArrayList();
/*     */           }
/*     */           
/* 531 */           list.add(h);
/* 532 */           hashMap.put(str4, list);
/*     */         } 
/*     */         
/* 535 */         b++;
/* 536 */         if (f.length() < 10)
/*     */           continue label23; 
/*     */       } 
/* 539 */     }  a((Map)hashMap, parame);
/*     */   }
/*     */   
/*     */   private void a(Map<String, List<h>> paramMap, e parame) {
/* 543 */     b b = a();
/* 544 */     if (b == null) {
/* 545 */       b = n.a().a(parame.a().v(), o.a, b().a().x());
/*     */     }
/*     */     
/* 548 */     for (Map.Entry<String, List<h>> entry : paramMap.entrySet()) {
/* 549 */       f f = null;
/* 550 */       List<h> list = (List)entry.getValue();
/* 551 */       list.sort(Comparator.comparingDouble(h::m));
/*     */       
/* 553 */       for (byte b1 = 0; b1 < list.size(); b1++) {
/* 554 */         h h = list.get(b1);
/* 555 */         h.l(b1 + 1);
/* 556 */         f = b.a().a((String)entry.getKey());
/* 557 */         e e1 = f.b();
/*     */         
/* 559 */         if (e1.f().av() == null || e1.f().av().isEmpty()) {
/* 560 */           g g1 = new g(f.b(), h);
/* 561 */           b.a().a((f)g1);
/*     */         } 
/*     */       } 
/* 564 */       a(f, b.a(), list);
/*     */     } 
/*     */   }
/*     */   
/*     */   private h a(i parami, e parame) {
/* 569 */     h h = new h();
/*     */     
/* 571 */     if (parami.has("classificacao")) {
/* 572 */       h.l(parami.getInt("classificacao"));
/*     */     }
/* 574 */     h.x(parami.getBoolean("declaracaoMeEpp"));
/* 575 */     h.ap(h.aT() ? "ME/EPP" : "Demais (Diferente de ME/EPP)");
/*     */     
/* 577 */     i i1 = parami.j("participante");
/* 578 */     h.D(i1.getString("identificacao"));
/* 579 */     h.A(parame.a().a().aw().equals(h.av()));
/* 580 */     h.E(i1.getString("nome"));
/*     */     
/* 582 */     if (parame.w() == v.b.v()) {
/* 583 */       h.q(parami.j("valores").j("valorPropostaInicialOuLances").getDouble("valorInformado"));
/*     */     } else {
/* 585 */       i i2 = parami.j("valores").j("valorPropostaInicialOuLances").j("valorCalculado");
/* 586 */       if (i2.has("valorUnitario")) {
/* 587 */         h.q(i2.getDouble("valorUnitario"));
/*     */       } else {
/* 589 */         h.q(i2.getDouble("valorTotal"));
/*     */       } 
/*     */     } 
/*     */     
/* 593 */     if (parami.has("marcaFabricante")) {
/* 594 */       h.al(parami.getString("marcaFabricante"));
/* 595 */       h.am(parami.getString("marcaFabricante"));
/* 596 */       h.ao(parami.getString("modeloVersao"));
/*     */     } 
/*     */     
/* 599 */     return h;
/*     */   }
/*     */   private void a(f paramf) {
/*     */     f f1;
/* 603 */     byte b = 0;
/*     */ 
/*     */ 
/*     */     
/*     */     label18: do {
/* 608 */       c c = (c)paramf.a();
/* 609 */       String str = b().a(c.bk(), b).getData();
/* 610 */       if (str.isEmpty()) {
/*     */         break;
/*     */       }
/*     */       
/* 614 */       f1 = new f(str);
/* 615 */       for (byte b1 = 0; b1 < f1.length(); b1++) {
/* 616 */         i i = f1.b(b1);
/* 617 */         if (i.getString("identificador").equals(paramf.bo())) {
/* 618 */           paramf.a().af(String.valueOf(i.getInt("numero")));
/*     */           break label18;
/*     */         } 
/*     */       } 
/* 622 */       b++;
/* 623 */     } while (f1.length() >= 10);
/*     */   }
/*     */   
/*     */   public boolean c(e parame, double paramDouble) {
/* 627 */     if (parame == null || parame instanceof f) {
/* 628 */       return false;
/*     */     }
/*     */     
/* 631 */     e e1 = a(parame);
/* 632 */     h h = new h(paramDouble);
/* 633 */     return e1.a(h, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void S() {
/* 638 */     aG();
/* 639 */     l l = a().a();
/* 640 */     if (l
/* 641 */       .equals(l.h) || l
/* 642 */       .equals(l.k) || 
/* 643 */       c() == t.c) {
/*     */       
/* 645 */       aH();
/*     */     } else {
/*     */       try {
/* 648 */         e e = b().h();
/* 649 */         if (!e.getData().contains(Integer.toString(a().v()))) {
/*     */           return;
/*     */         }
/*     */         
/* 653 */         b b = new b(b());
/* 654 */         for (e e1 : a().L()) {
/* 655 */           if (isInterrupted()) {
/*     */             break;
/*     */           }
/*     */           
/* 659 */           if (!e1.bt() && !e1.bx()) {
/* 660 */             e e2 = b.a(e1);
/* 661 */             e(e2.k());
/* 662 */             String str = e2.getData();
/*     */             
/* 664 */             if (!str.isEmpty() && !str.contains("alert('Acesso negado!')")) {
/* 665 */               Document document = Jsoup.parse(str);
/*     */               
/* 667 */               String str1 = document.select("tr[class=mensagem]").select("span[class=mensagem]").first().text().toLowerCase();
/* 668 */               if (str1.contains("fechado")) {
/* 669 */                 e1.N(g.g.getValue());
/* 670 */               } else if (str1.contains("aguardando convocação 7174") || str1
/* 671 */                 .contains("aguardando convocação me/epp")) {
/* 672 */                 e1.N(g.q.getValue());
/* 673 */               } else if (str1.contains("cancelado")) {
/* 674 */                 e1.N(g.av.getValue());
/* 675 */               } else if (str1.contains("suspenso")) {
/* 676 */                 e1.N(g.r.getValue());
/* 677 */               } else if (str1.contains("realizar julgamento") || str1
/* 678 */                 .contains("homologado") || str1
/* 679 */                 .contains("adjudicado") || str1
/* 680 */                 .contains("realizar habilitação") || str1
/* 681 */                 .contains("aceito e habilitado")) {
/* 682 */                 e1.N(g.s.getValue());
/*     */               } 
/*     */               
/* 685 */               List<h> list = b.a(document, e1);
/* 686 */               if (!list.isEmpty()) {
/* 687 */                 e1.h(list.get(0));
/*     */                 
/* 689 */                 if (((h)list.get(0)).bb()) {
/* 690 */                   e1.h(((h)list.get(0)).m());
/*     */                   
/* 692 */                   if (list.size() > 1 && ((h)list.get(1)).m() == e1.f()) {
/* 693 */                     e1.a(s.b);
/*     */                   } else {
/* 695 */                     e1.a(s.a);
/*     */                   } 
/*     */                 } else {
/* 698 */                   Optional<h> optional = list.stream().filter(paramh -> paramh.bb()).findFirst();
/* 699 */                   if (optional.isPresent()) {
/* 700 */                     e1.h(((h)optional.get()).m());
/*     */                   } else {
/* 702 */                     e1.N(g.aW.getValue());
/*     */                   } 
/*     */                   
/* 705 */                   e1.a(s.c);
/*     */                 } 
/*     */               } 
/*     */               
/* 709 */               if (e1.br()) {
/* 710 */                 a(e1, list);
/*     */               }
/*     */               
/* 713 */               i i = a();
/* 714 */               int j = i.indexOf(e1.v());
/*     */               
/* 716 */               if (j >= 0) {
/* 717 */                 i.fireTableRowsUpdated(j, j);
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/* 722 */       } catch (Exception exception) {
/* 723 */         a.warn("Falha ao carregar itens encerrados", exception);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void aH() {
/*     */     try {
/* 730 */       if (b().a() == null || b().a().isEmpty()) {
/* 731 */         b().bN();
/*     */       }
/* 733 */     } catch (Exception exception) {
/* 734 */       a.error("Failed to enter the new area of Comprasnet", exception);
/*     */     } 
/*     */     
/* 737 */     byte b = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     while (true) {
/* 743 */       e e = b().a(a().bk(), b);
/* 744 */       if (e.getStatusCode() != 204) {
/*     */         
/* 746 */         String str = e.getData();
/* 747 */         if (!str.startsWith("[")) {
/*     */           break;
/*     */         }
/*     */         
/* 751 */         f f = new f(str);
/* 752 */         for (byte b1 = 0; b1 < f.length(); b1++) {
/* 753 */           i i = f.b(b1);
/* 754 */           e e1 = a(i.getString("identificador"));
/* 755 */           if (e1 != null) {
/*     */             
/* 757 */             if (e1.ay()) {
/* 758 */               E(i.getInt("numero"));
/*     */             }
/*     */             
/* 761 */             c(e1, i);
/*     */             
/* 763 */             i i1 = a();
/* 764 */             int j = i1.indexOf(e1.v());
/* 765 */             if (j >= 0) {
/* 766 */               i1.fireTableRowsUpdated(j, j);
/*     */             }
/*     */           } 
/*     */         } 
/* 770 */         b++;
/* 771 */         if (f.length() < 10)
/*     */           break; 
/*     */       } 
/*     */     }  } private void c(e parame, i parami) {
/* 775 */     parame.N("Encerrado");
/*     */     
/* 777 */     String str = "valorCalculado";
/* 778 */     if (parame.w() == v.b.v()) {
/* 779 */       str = "valorInformado";
/*     */     }
/*     */     
/* 782 */     if (parami.has("melhorValorFornecedor")) {
/* 783 */       parame.h(parami.j("melhorValorFornecedor").getDouble(str));
/*     */     }
/* 785 */     if (parami.has("melhorValorGeral")) {
/* 786 */       parame.l(parami.j("melhorValorGeral").getDouble(str));
/*     */     }
/*     */     
/* 789 */     s s = s.c;
/* 790 */     if (parami.has("situacaoParticipanteDisputa")) {
/* 791 */       switch (parami.getString("situacaoParticipanteDisputa")) {
/*     */         case "P":
/* 793 */           s = s.c;
/*     */           break;
/*     */         case "E":
/* 796 */           s = s.b;
/*     */           break;
/*     */         case "G":
/* 799 */           s = s.a;
/*     */           break;
/*     */       } 
/*     */     } else {
/* 803 */       s = (parame.f() == parame.f().m()) ? s.a : s.c;
/*     */     } 
/*     */     
/* 806 */     parame.a(s);
/*     */     
/* 808 */     if (parame.br())
/* 809 */       a(parame, null); 
/*     */   }
/*     */   
/*     */   private void E(int paramInt) {
/*     */     f f;
/* 814 */     byte b = 0;
/*     */ 
/*     */     
/*     */     do {
/* 818 */       String str = b().c(a().bk(), b, paramInt).getData();
/* 819 */       if (str.isEmpty()) {
/*     */         break;
/*     */       }
/*     */       
/* 823 */       f = new f(str);
/* 824 */       for (byte b1 = 0; b1 < f.length(); b1++) {
/* 825 */         i i = f.b(b1);
/* 826 */         e e = a(i.getString("identificador"));
/* 827 */         c(e, i);
/*     */       } 
/*     */       
/* 830 */       b++;
/* 831 */     } while (f.length() >= 10);
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void g(e parame) {
/* 836 */     if (!b(parame.v())) {
/* 837 */       super.g(parame);
/*     */       
/* 839 */       this.l.remove(Integer.valueOf(parame.v()));
/* 840 */       this.c.remove(Integer.valueOf(parame.v()));
/* 841 */       if (this.a != null) {
/* 842 */         this.a.q(parame.bo());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void ab() {
/* 849 */     super.ab();
/*     */     
/* 851 */     if (this.a != null) {
/* 852 */       this.a.cancel();
/* 853 */       this.a = null;
/*     */     } 
/*     */     
/* 856 */     if (this.f != null) {
/* 857 */       this.f.cancel();
/* 858 */       this.f = null;
/*     */     } 
/*     */     
/* 861 */     if (this.a != null) {
/* 862 */       this.a.shutdown();
/*     */     }
/*     */     
/* 865 */     if (this.d != null) {
/* 866 */       this.d.shutdown();
/*     */     }
/*     */     
/* 869 */     if (this.executor != null) {
/* 870 */       this.executor.shutdown();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void m(long paramLong) {
/* 876 */     a(0, paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   public void n(long paramLong) {
/* 881 */     a(1, paramLong);
/*     */   }
/*     */   
/*     */   private void a(int paramInt, long paramLong) {
/* 885 */     synchronized (this.f) {
/* 886 */       this.U++;
/* 887 */       this.V += paramInt;
/* 888 */       this.o += paramLong;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean g(i parami) {
/* 893 */     return this.a.h(parami);
/*     */   }
/*     */ 
/*     */   
/*     */   public c a() {
/* 898 */     return (c)super.a();
/*     */   }
/*     */ 
/*     */   
/*     */   public final e b() {
/* 903 */     return (e)super.a();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void a(f paramf, List<h> paramList) {
/* 908 */     e e = paramf.b();
/*     */     
/*     */     try {
/* 911 */       if (paramList == null || paramList.isEmpty()) {
/* 912 */         paramList = b(e);
/*     */       }
/*     */       
/* 915 */       if (!paramList.isEmpty()) {
/* 916 */         h h = paramList.get(0);
/* 917 */         e.h(h);
/*     */         
/* 919 */         s s = h.bb() ? s.a : s.c;
/* 920 */         e.a(s);
/*     */         
/* 922 */         for (h h1 : paramList) {
/* 923 */           if (h1.bb()) {
/* 924 */             e.a(s);
/* 925 */             e.h(h1.m());
/*     */             
/* 927 */             if (paramf instanceof i) {
/* 928 */               ((i)paramf).l(h1.j());
/*     */             }
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } else {
/* 934 */         e.a(s.c);
/*     */       } 
/* 936 */     } catch (d d) {
/* 937 */       a.info("Falha ao carregar dados do vencedor do " + (e.ay() ? "Grupo " : "Item ") + paramf.b().bo(), (Throwable)d);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void T() {}
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\e\p.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */