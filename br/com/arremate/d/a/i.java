/*     */ package br.com.arremate.d.a;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.d.e;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.s;
/*     */ import br.com.arremate.f.t;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.d.b;
/*     */ import br.com.arremate.j.d.c;
/*     */ import br.com.arremate.j.d.d;
/*     */ import br.com.arremate.l.a.b;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.l.q.c.f;
/*     */ import br.com.arremate.m.y;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Timer;
/*     */ import java.util.TimerTask;
/*     */ import java.util.TreeSet;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.ScheduledExecutorService;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.stream.Collectors;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.e.f;
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
/*     */ 
/*     */ public class i
/*     */   extends g
/*     */ {
/*     */   private final b a;
/*     */   private final ExecutorService a;
/*     */   private final Map<Integer, Future> g;
/*     */   private final Map<e, d> h;
/*     */   private ScheduledExecutorService a;
/*     */   private h a;
/*     */   private b a;
/*     */   private a a;
/*     */   private Timer a;
/*     */   
/*     */   public i(b paramb, br.com.arremate.j.i parami, boolean paramBoolean) {
/*  64 */     super(paramb, parami);
/*  65 */     j(100L);
/*     */     
/*  67 */     this.a = (Timer)d.a().a(parami.a(), false);
/*     */     
/*  69 */     this.a = (Timer)Executors.newCachedThreadPool();
/*  70 */     this.g = new HashMap<>();
/*  71 */     this.h = new HashMap<>();
/*     */     
/*  73 */     a(new c(this, (br.com.arremate.j.i)this.a));
/*     */     
/*  75 */     if (paramBoolean) {
/*  76 */       this.a.b(this);
/*  77 */       ((c)parami).b(this);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public t a() {
/*  83 */     t t = t.b;
/*     */     
/*     */     try {
/*  86 */       e e = b().e(a().v());
/*  87 */       e(e.k());
/*  88 */       if (!e.getData().isEmpty()) {
/*     */         String str1;
/*     */         
/*  91 */         Document document = Jsoup.parse(e.getData());
/*  92 */         Elements elements = document.select("div[class=campo col11]");
/*  93 */         String str2 = elements.get(6).text().toLowerCase();
/*  94 */         if (str2.contains("encerrada") || str2.contains("homologada") || str2.contains("com recurso") || str2.contains("cancelada")) {
/*  95 */           str1 = "Pregão encerrado";
/*  96 */           t = t.d;
/*  97 */         } else if (str2.contains("em disputa")) {
/*  98 */           str1 = "Pregão em disputa";
/*  99 */           t = t.c;
/* 100 */         } else if (str2.contains("suspenso") || str2.contains("suspensa")) {
/* 101 */           str1 = "Pregão suspenso";
/* 102 */           t = t.e;
/*     */         } else {
/* 104 */           str1 = "Pregão em fase de proposta";
/*     */         } 
/*     */         
/* 107 */         k(str1);
/*     */       } 
/* 109 */     } catch (Exception exception) {
/* 110 */       a.error(String.join("Error getting bidding status", new CharSequence[0]), exception);
/*     */     } 
/*     */     
/* 113 */     return t;
/*     */   }
/*     */ 
/*     */   
/*     */   protected t b() {
/* 118 */     t t = super.b();
/* 119 */     if (t == t.c) {
/* 120 */       this.a = (Timer)new h((j)a());
/* 121 */       this.a.start();
/*     */       
/* 123 */       this.a = (Timer)new b(this);
/* 124 */       this.a = (Timer)new a(this);
/*     */       
/* 126 */       a().cd();
/* 127 */       ao();
/*     */       
/* 129 */       if (a().a() != m.a) {
/* 130 */         an();
/*     */       }
/*     */     } 
/*     */     
/* 134 */     return t;
/*     */   }
/*     */   
/*     */   private void an() {
/* 138 */     this.a = new Timer("CountdownTimer");
/* 139 */     this.a.schedule(new TimerTask(this)
/*     */         {
/*     */           public void run() {
/* 142 */             this.b.a().B().parallelStream().forEach(param1g -> {
/*     */                   long l = param1g.z();
/*     */                   if (l <= 0L) {
/*     */                     return;
/*     */                   }
/*     */                   if (param1g.aM() || param1g.au()) {
/*     */                     param1g.x(l - 1000L);
/*     */                     this.b.a().fireTableCellUpdated(this.b.a().indexOf(param1g.v()), 14);
/*     */                   } 
/*     */                 });
/*     */           }
/*     */         }1000L, 1000L);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void ao() {
/* 159 */     this.a = (Timer)Executors.newSingleThreadScheduledExecutor();
/* 160 */     this.a.scheduleWithFixedDelay(() -> { for (e e : h()) this.a.k(e);  }1L, 1L, TimeUnit.SECONDS);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<e> h() {
/* 168 */     if (a().a() == m.b) {
/* 169 */       return (List<e>)this.h.keySet().stream().filter(parame -> 
/* 170 */           (parame.bx() || (parame.bu() && parame.z() <= 0L)))
/* 171 */         .collect(Collectors.toList());
/*     */     }
/*     */     
/* 174 */     if (a().a() == m.c) {
/* 175 */       return (List<e>)this.h.keySet().stream().filter(parame -> 
/* 176 */           (parame.bx() || (i(parame) && parame.z() <= 0L)))
/* 177 */         .collect(Collectors.toList());
/*     */     }
/*     */     
/* 180 */     return (List<e>)this.h.keySet().stream().filter(parame -> 
/* 181 */         (parame.bx() || parame.bu()))
/* 182 */       .collect(Collectors.toList());
/*     */   }
/*     */   
/*     */   private boolean i(e parame) {
/* 186 */     return (parame.bv() || 
/* 187 */       g.b(parame.bB(), g.p) || 
/* 188 */       g.b(parame.bB(), g.i));
/*     */   }
/*     */ 
/*     */   
/*     */   public void R() {
/* 193 */     Map<e, org.e.i> map = this.a.d();
/* 194 */     for (Map.Entry<e, org.e.i> entry : map.entrySet()) {
/* 195 */       a((e)entry.getKey(), (org.e.i)entry.getValue());
/*     */     }
/*     */     
/* 198 */     this.a.x(a().H().size());
/*     */   }
/*     */   
/*     */   private void a(e parame, org.e.i parami) {
/* 202 */     int j = parame.v();
/*     */     
/*     */     try {
/* 205 */       Future future = this.g.get(Integer.valueOf(j));
/* 206 */       d d = this.h.get(parame);
/*     */       
/* 208 */       if ((future == null || future.isDone()) && !parame.br()) {
/* 209 */         if (d == null) {
/* 210 */           d = a(parame);
/*     */           
/* 212 */           if (t.c.equals(c())) {
/* 213 */             this.h.put(parame, d);
/*     */             
/* 215 */             String str1 = d.l();
/* 216 */             DecimalFormat decimalFormat = y.a("###,###,###,##0.0000");
/* 217 */             String str2 = decimalFormat.format(parame.l());
/*     */             
/* 219 */             StringBuilder stringBuilder = new StringBuilder();
/* 220 */             stringBuilder.append(str1)
/* 221 */               .append(" ").append(parame.bo())
/* 222 */               .append(" entrou em disputa com valor mínimo de R$ ")
/* 223 */               .append(str2);
/* 224 */             l(stringBuilder.toString());
/*     */           } 
/*     */         } 
/*     */         
/* 228 */         d.a(parami);
/* 229 */         Future<?> future1 = this.a.submit((Runnable)d);
/* 230 */         this.g.put(Integer.valueOf(j), future1);
/*     */       } 
/* 232 */     } catch (Exception exception) {
/* 233 */       a.warn("Failed to start thread from batch " + Integer.toString(j), exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private d a(e parame) {
/* 238 */     if (a().a() == m.b) {
/* 239 */       if (a().a() == u.d || a().a() == u.f) {
/* 240 */         return new g(parame, (br.com.arremate.j.i)a(), this);
/*     */       }
/* 242 */       return new e(parame, (br.com.arremate.j.i)a(), this);
/*     */     } 
/*     */ 
/*     */     
/* 246 */     if (a().a() == u.d || a().a() == u.f) {
/* 247 */       return new f(parame, (br.com.arremate.j.i)a(), this);
/*     */     }
/* 249 */     return new d(parame, (br.com.arremate.j.i)a(), this);
/*     */   }
/*     */ 
/*     */   
/*     */   String a(e parame) {
/* 254 */     String str = null;
/*     */     
/*     */     try {
/* 257 */       e e1 = b().c(a().v(), parame.v());
/* 258 */       String str1 = e1.getData();
/*     */       
/* 260 */       if (str1 != null && !str1.isEmpty()) {
/* 261 */         Document document = Jsoup.parse(str1);
/* 262 */         Elements elements = document.select("div[class=campo col12]");
/* 263 */         str = !elements.isEmpty() ? elements.get(2).text().trim() : "";
/*     */       } 
/* 265 */     } catch (Exception exception) {
/* 266 */       a.warn("Falha ao capturar a situação do item", exception);
/*     */     } 
/*     */     
/* 269 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> b(e parame) {
/* 274 */     if (!parame.br() && isRunning()) {
/* 275 */       d d = this.h.get(parame);
/* 276 */       return d.e();
/* 277 */     }  if (parame.br() && 
/* 278 */       b() != null && b().isRunning()) {
/* 279 */       String str = b().d(parame.a().v(), parame.v()).getData();
/* 280 */       if (!str.isEmpty()) {
/* 281 */         Document document = Jsoup.parse(str);
/* 282 */         return a(parame, document);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 287 */     return new ArrayList<>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void S() {
/*     */     try {
/* 295 */       for (e e : a().L()) {
/* 296 */         if (e.bB().isEmpty()) {
/* 297 */           Long long_ = Long.valueOf(System.currentTimeMillis());
/* 298 */           String str = a(e);
/* 299 */           e(System.currentTimeMillis() - long_.longValue());
/*     */           
/* 301 */           if (str != null && !str.isEmpty()) {
/* 302 */             e.N(str);
/*     */           }
/*     */         } 
/*     */         
/* 306 */         if (e.br() && 
/* 307 */           b() != null && b().isRunning()) {
/* 308 */           e e1 = b().d(e.a().v(), e.v());
/* 309 */           e(e1.k());
/*     */           
/* 311 */           if (!e1.getData().isEmpty()) {
/* 312 */             Document document = Jsoup.parse(e1.getData());
/* 313 */             List<h> list = a(e, document);
/*     */             
/* 315 */             if (!list.isEmpty()) {
/* 316 */               h h1 = list.get(0);
/* 317 */               s s = h1.ay().equals(a().ay()) ? s.a : s.c;
/*     */ 
/*     */ 
/*     */               
/* 321 */               list.stream().filter(paramh -> paramh.bb())
/* 322 */                 .findFirst()
/* 323 */                 .ifPresent(paramh -> parame.h(paramh.m()));
/*     */               
/* 325 */               e.h(h1);
/* 326 */               e.a(s);
/*     */               
/* 328 */               if (e.f() == 0.0D && c(e.v())) {
/* 329 */                 e.N(g.aW.getValue());
/*     */               }
/*     */             } 
/*     */             
/* 333 */             super.g(e);
/*     */             
/* 335 */             int j = a().indexOf(e.v());
/* 336 */             if (j >= 0) {
/* 337 */               a().fireTableRowsUpdated(j, j);
/*     */             }
/*     */ 
/*     */             
/* 341 */             Elements elements = document.select("table[id=idHistoricoMensagens]");
/* 342 */             if (!elements.isEmpty()) {
/* 343 */               a().a(e.bo(), elements.first());
/*     */             }
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 349 */         if (isInterrupted()) {
/*     */           break;
/*     */         }
/*     */       } 
/* 353 */     } catch (Exception exception) {
/* 354 */       a.warn("Falha ao carregar itens encerrados", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private List<h> a(e parame, Document paramDocument) {
/* 360 */     TreeSet<?> treeSet = new TreeSet((paramh1, paramh2) -> (paramh1.j() < paramh2.j()) ? -1 : ((paramh1.j() > paramh2.j()) ? 1 : 0));
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
/* 372 */     byte b1 = parame.a().k() ? 5 : 4;
/* 373 */     String str = parame.a().k() ? "idParticipantes" : "tblParticipantes";
/*     */     
/* 375 */     Elements elements = paramDocument.select("table[id=" + str + "] > tbody > tr");
/* 376 */     elements.stream().map(paramElement -> paramElement.select("td"))
/* 377 */       .filter(paramElements -> !paramElements.get(3).text().contains("Desclassificado"))
/* 378 */       .map(paramElements -> {
/*     */           String str1 = (parame.a().a() == u.d) ? "%" : "R$";
/*     */           
/*     */           Calendar calendar = y.c(paramElements.last().text());
/*     */           h h1 = new h();
/*     */           h1.l(paramElements.get(3).text().contains("Arrematante") ? 1 : (Integer.parseInt(paramElements.get(0).text()) + 1));
/*     */           h1.q(Double.parseDouble(y.Q(paramElements.get(paramInt).text().replace(str1, "").trim())));
/*     */           h1.c(calendar.getTime());
/*     */           String str2 = paramElements.get(2).text().replace("*", "");
/*     */           h1.ap(str2);
/* 388 */           h1.x((str2.contains("ME") || str2.contains("EPP")));
/*     */           h1.E(paramElements.get(1).text());
/*     */           return h1;
/* 391 */         }).map(paramh -> {
/*     */           paramh.A(StringUtils.containsIgnoreCase(paramh.ay(), parame.a().a().bv()));
/*     */           return paramh;
/* 394 */         }).forEachOrdered(paramh -> {
/*     */           if (parame.f() != null && !parame.f().av().isEmpty() && paramh.ay().equals(parame.f().ay())) {
/*     */             paramh.D(parame.f().av());
/*     */           }
/*     */ 
/*     */           
/*     */           paramTreeSet.add(paramh);
/*     */         });
/*     */     
/* 403 */     ArrayList<h> arrayList = new ArrayList(treeSet);
/* 404 */     byte b2 = 1;
/*     */ 
/*     */     
/* 407 */     for (h h1 : arrayList) {
/* 408 */       h1.l(b2);
/* 409 */       b2++;
/*     */     } 
/*     */     
/* 412 */     return arrayList;
/*     */   }
/*     */   
/*     */   protected boolean c(int paramInt) {
/* 416 */     if (b() != null && b().isRunning()) {
/* 417 */       String str = b().b(a().v(), paramInt);
/*     */       
/* 419 */       if (!str.isEmpty()) {
/* 420 */         Document document = Jsoup.parse(str);
/* 421 */         Elements elements = document.select("fieldset");
/*     */         
/* 423 */         for (Element element : elements) {
/* 424 */           for (Element element1 : element.select("legend")) {
/* 425 */             if (StringUtils.containsIgnoreCase(element1.text(), a().ay())) {
/* 426 */               Elements elements1 = element.select("div[class=campo col12]");
/*     */ 
/*     */               
/* 429 */               if (elements1.size() > 1) {
/* 430 */                 Element element2 = elements1.get(3);
/*     */                 
/* 432 */                 if (element2 != null) {
/* 433 */                   return StringUtils.containsIgnoreCase(element2.text(), "desclassificada");
/*     */                 }
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 442 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void a(f paramf, List<h> paramList) {
/* 447 */     String str = b().c(paramf.b().a().v(), paramf.b().v());
/* 448 */     if (!"".equals(str)) {
/* 449 */       Document document = Jsoup.parse(str);
/* 450 */       Elements elements = document.select("fieldset");
/*     */       
/* 452 */       for (Element element : elements) {
/* 453 */         boolean bool1 = false;
/* 454 */         boolean bool2 = false;
/*     */         
/* 456 */         for (Element element1 : element.getAllElements()) {
/* 457 */           if (element1.text().equals("CNPJ")) {
/* 458 */             bool1 = true; continue;
/* 459 */           }  if (element1.text().equals("Fornecedor")) {
/* 460 */             bool2 = true; continue;
/* 461 */           }  if (bool1) {
/* 462 */             paramf.h().D(element1.text());
/* 463 */             bool1 = false; continue;
/* 464 */           }  if (bool2) {
/* 465 */             paramf.h().E(element1.text());
/* 466 */             bool2 = false;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void ac() {
/* 476 */     while (isRunning() && (b().ac() || b().ab() || 
/* 477 */       a().ab())) {
/*     */       try {
/* 479 */         Thread.sleep(TimeUnit.SECONDS.toMillis(5L));
/* 480 */       } catch (InterruptedException interruptedException) {}
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean a(e parame, double paramDouble) {
/* 486 */     h h1 = new h(paramDouble);
/* 487 */     d d = this.h.get(parame);
/* 488 */     return d.a(h1, true);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void T() {
/* 493 */     a().H().forEach(parame -> {
/*     */           d d = this.h.get(parame);
/*     */           if (d != null) {
/*     */             parame.ah(d.k());
/*     */             parame.ai(d.l());
/*     */           } 
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void g(e parame) {
/* 504 */     if (!b(parame.v())) {
/* 505 */       super.g(parame);
/* 506 */       this.h.remove(parame);
/* 507 */       this.g.remove(Integer.valueOf(parame.v()));
/*     */       
/* 509 */       this.a.l(parame);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void V() {
/* 515 */     super.V();
/* 516 */     b().c(this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void W() {
/* 521 */     super.W();
/* 522 */     b().b();
/*     */   }
/*     */ 
/*     */   
/*     */   public void ab() {
/* 527 */     super.ab();
/*     */     
/* 529 */     this.a.shutdown();
/*     */     
/* 531 */     if (this.a != null) {
/* 532 */       this.a.am();
/*     */     }
/*     */     
/* 535 */     if (this.a != null) {
/* 536 */       this.a.close();
/*     */     }
/*     */     
/* 539 */     if (this.a != null) {
/* 540 */       this.a.cancel();
/*     */     }
/*     */     
/* 543 */     if (this.a != null) {
/* 544 */       this.a.shutdown();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public b a() {
/* 550 */     return (b)super.a();
/*     */   }
/*     */ 
/*     */   
/*     */   public c a() {
/* 555 */     return (c)super.a();
/*     */   }
/*     */ 
/*     */   
/*     */   protected c a() {
/* 560 */     return (c)super.a();
/*     */   }
/*     */   
/*     */   public b b() {
/* 564 */     return (b)this.a;
/*     */   }
/*     */   
/*     */   public h a() {
/* 568 */     return (h)this.a;
/*     */   }
/*     */   
/*     */   public void b(Integer paramInteger, f paramf) {
/* 572 */     a().a(paramInteger, paramf);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\a\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */