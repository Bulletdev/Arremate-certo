/*     */ package br.com.arremate.d.e.a;
/*     */ 
/*     */ import br.com.arremate.d.e.a;
/*     */ import br.com.arremate.d.f;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.t;
/*     */ import br.com.arremate.f.v;
/*     */ import br.com.arremate.h.e;
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
/*     */ import br.com.arremate.m.y;
/*     */ import br.com.arremate.n.n;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.RoundingMode;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Timer;
/*     */ import java.util.TimerTask;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.e.f;
/*     */ import org.e.g;
/*     */ import org.e.i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class b
/*     */   extends g
/*     */   implements a
/*     */ {
/*     */   private final ExecutorService d;
/*     */   private final ExecutorService executor;
/*     */   private final Map<Integer, Future> m;
/*     */   private final Map<Integer, a> n;
/*     */   private final Calendar d;
/*     */   private final Object f;
/*     */   private c a;
/*     */   private Future a;
/*     */   private Timer a;
/*     */   private int T;
/*     */   private boolean l;
/*     */   private long q;
/*     */   private Timer f;
/*     */   private int U;
/*     */   private int V;
/*     */   private long o;
/*     */   
/*     */   public b(br.com.arremate.d.b paramb, i parami, boolean paramBoolean) {
/*  70 */     super(paramb, parami);
/*  71 */     j(TimeUnit.SECONDS.toMillis(1L));
/*     */     
/*  73 */     this.d = (Calendar)Executors.newFixedThreadPool(1);
/*  74 */     this.executor = Executors.newCachedThreadPool();
/*  75 */     this.m = new HashMap<>();
/*  76 */     this.n = new HashMap<>();
/*     */     
/*  78 */     this.d = Calendar.getInstance();
/*     */     
/*  80 */     this.f = (Timer)new Object();
/*     */     
/*  82 */     this.U = 0;
/*  83 */     this.V = 0;
/*  84 */     this.o = 0L;
/*     */     
/*  86 */     if (paramBoolean) {
/*  87 */       this.d.setTime(a().g().getTime());
/*  88 */       this.d.add(12, -1);
/*  89 */       b().a(this);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void an() {
/*  94 */     aM();
/*     */     
/*  96 */     i i = a();
/*  97 */     this.a = new Timer("CountdownTimer");
/*  98 */     this.a.schedule(new TimerTask(this, i) {
/*  99 */           private int W = 0;
/*     */ 
/*     */           
/*     */           public void run() {
/* 103 */             if (this.W < 60) {
/* 104 */               this.a.a().B().parallelStream().forEach(param1g -> {
/*     */                     long l = param1g.z();
/*     */                     
/*     */                     if (l <= 0L) {
/*     */                       return;
/*     */                     }
/*     */                     if (param1g.aM() || param1g.au()) {
/*     */                       param1g.x(l - 1000L);
/*     */                       param1i.fireTableCellUpdated(param1i.indexOf(param1g.v()), 14);
/*     */                     } 
/*     */                   });
/* 115 */               this.W++;
/*     */             } else {
/* 117 */               b.a(this.a);
/* 118 */               this.W = 0;
/*     */             } 
/*     */           }
/*     */         }1000L, 1000L);
/*     */   }
/*     */   
/*     */   private void aM() {
/* 125 */     long l1 = System.currentTimeMillis();
/* 126 */     Calendar calendar = y.i();
/* 127 */     l1 = System.currentTimeMillis() - l1;
/* 128 */     if (l1 >= 1000L) {
/* 129 */       calendar.add(14, (int)l1);
/*     */     }
/*     */     
/* 132 */     long l2 = a().g().getTimeInMillis();
/* 133 */     long l3 = l2 - calendar.getTimeInMillis();
/* 134 */     if (l3 > 0L) {
/* 135 */       a().B().parallelStream().forEach(paramg -> paramg.x(paramLong));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void aF() {
/* 142 */     this.f = new Timer("logBestBids");
/* 143 */     this.f.schedule(new TimerTask(this)
/*     */         {
/*     */           public void run() {
/* 146 */             b.b(this.a);
/*     */           }
/* 148 */         },  TimeUnit.MINUTES.toMillis(5L), TimeUnit.MINUTES.toMillis(5L));
/*     */   }
/*     */   
/*     */   private void aG() {
/* 152 */     synchronized (this.f) {
/* 153 */       if (this.U > 0) {
/*     */ 
/*     */         
/* 156 */         double d1 = BigDecimal.valueOf(this.V).divide(BigDecimal.valueOf(this.U), 4, RoundingMode.HALF_EVEN).multiply(BigDecimal.valueOf(100L)).doubleValue();
/*     */ 
/*     */ 
/*     */         
/* 160 */         double d2 = BigDecimal.valueOf(this.o).divide(BigDecimal.valueOf(this.U), 4, RoundingMode.HALF_EVEN).divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_EVEN).doubleValue();
/*     */         
/* 162 */         j.a().a(this.U, d1, d2);
/*     */         
/* 164 */         this.U = 0;
/* 165 */         this.V = 0;
/* 166 */         this.o = 0L;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected t b() {
/* 173 */     t t = super.b();
/* 174 */     if (t == t.c) {
/* 175 */       an();
/*     */       
/* 177 */       this.a = (Timer)c.a(a(), b());
/* 178 */       this.a = (Timer)this.d.submit((Runnable)this.a);
/* 179 */       this.T = b().B();
/* 180 */       aF();
/*     */     } 
/*     */     
/* 183 */     return t;
/*     */   }
/*     */ 
/*     */   
/*     */   public t a() {
/* 188 */     c c1 = a();
/* 189 */     Calendar calendar = n.i();
/* 190 */     if (calendar.compareTo(c1.h()) < 0)
/* 191 */       return t.b; 
/* 192 */     if (calendar.compareTo(c1.g()) > 0) {
/* 193 */       return t.d;
/*     */     }
/*     */     
/* 196 */     return t.c;
/*     */   }
/*     */ 
/*     */   
/*     */   public void R() {
/*     */     try {
/* 202 */       int i = b().B();
/* 203 */       if (this.T < i) {
/* 204 */         this.T = i;
/* 205 */         this.a.aJ();
/*     */         
/*     */         return;
/*     */       } 
/* 209 */       if (this.a.isDone()) {
/* 210 */         this.a = (Timer)this.d.submit((Runnable)this.a);
/*     */         
/*     */         return;
/*     */       } 
/* 214 */       if (this.a.g() > 0L) {
/* 215 */         e(this.a.g());
/*     */       }
/*     */       
/* 218 */       Calendar calendar = y.i();
/* 219 */       this.q = (calendar.get(13) * 1000);
/* 220 */       boolean bool1 = (this.d.compareTo(calendar) < 0) ? true : false;
/* 221 */       boolean bool2 = (this.q > 54000L && this.q < 62000L) ? true : false;
/* 222 */       this.l = (bool1 && bool2);
/*     */       
/* 224 */       f(this.a.f());
/* 225 */       i i1 = this.a.j();
/* 226 */       for (Iterator<String> iterator = i1.o(); iterator.hasNext(); ) {
/* 227 */         String str = iterator.next();
/* 228 */         e e = a(str);
/* 229 */         if (e != null && !e.br()) {
/* 230 */           i i2 = i1.j(str);
/* 231 */           d(e, i2);
/*     */         } 
/*     */       } 
/* 234 */     } catch (g g1) {
/* 235 */       a.error("Feiled to load items data", (Throwable)g1);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void d(e parame, i parami) {
/* 240 */     int j = parame.v();
/*     */     
/*     */     try {
/* 243 */       Future future = this.m.get(Integer.valueOf(j));
/* 244 */       if (future == null || future.isDone()) {
/* 245 */         a a1 = this.n.get(Integer.valueOf(j));
/* 246 */         if (a1 == null) {
/* 247 */           a1 = new a(parame, b(), this);
/*     */           
/* 249 */           if (t.c.equals(c())) {
/* 250 */             this.n.put(Integer.valueOf(j), a1);
/*     */             
/* 252 */             String str1 = a1.l();
/* 253 */             DecimalFormat decimalFormat = y.a("###,###,###,##0.0000");
/* 254 */             String str2 = decimalFormat.format(parame.l());
/*     */             
/* 256 */             StringBuilder stringBuilder = new StringBuilder();
/* 257 */             stringBuilder.append(str1).append(" ").append(parame.bo()).append(" entrou em disputa com valor mínimo de R$ ").append(str2);
/* 258 */             l(stringBuilder.toString());
/*     */           } 
/*     */         } 
/*     */         
/* 262 */         a1.e(parami);
/* 263 */         a1.e(this.l);
/* 264 */         Future<?> future1 = this.executor.submit((Runnable)a1);
/* 265 */         this.m.put(Integer.valueOf(j), future1);
/*     */       } 
/* 267 */     } catch (Exception exception) {
/* 268 */       a.warn("Failed to start thread from item {}", Integer.valueOf(j), exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean c(e parame, double paramDouble) {
/* 273 */     f f = this.n.get(Integer.valueOf(parame.v()));
/* 274 */     if (f != null) {
/* 275 */       return f.a(new h(paramDouble), true);
/*     */     }
/*     */     
/* 278 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> b(e parame) throws Exception {
/* 283 */     int i = parame.v();
/* 284 */     f f = this.n.get(Integer.valueOf(i));
/* 285 */     if (f != null) {
/* 286 */       return f.e();
/*     */     }
/*     */     
/* 289 */     if (!isRunning()) {
/* 290 */       if (b().a() == null || b().a().isEmpty()) {
/* 291 */         b().bN();
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 296 */       return d(parame);
/*     */     } 
/*     */     
/* 299 */     return new ArrayList<>();
/*     */   }
/*     */   private List<h> d(e parame) {
/*     */     String str1;
/* 303 */     ArrayList<h> arrayList = new ArrayList();
/*     */ 
/*     */     
/* 306 */     if (parame.ay()) {
/* 307 */       str1 = ((f)parame).a().bC();
/*     */     } else {
/* 309 */       str1 = parame.bo();
/*     */     } 
/*     */     
/* 312 */     c c1 = (c)parame.a();
/* 313 */     String str2 = c1.bk();
/* 314 */     String str3 = b().d(str2, str1).getData();
/* 315 */     if (str3.isEmpty()) {
/* 316 */       return arrayList;
/*     */     }
/*     */     
/* 319 */     if (!str3.startsWith("[")) {
/* 320 */       return arrayList;
/*     */     }
/*     */     
/* 323 */     f f1 = new f(str3);
/* 324 */     f f2 = f1.b(0).c("propostasItem");
/*     */     
/* 326 */     return a(parame, f2);
/*     */   }
/*     */   
/*     */   private List<h> a(e parame, f paramf) {
/* 330 */     ArrayList<h> arrayList = new ArrayList();
/*     */     
/* 332 */     for (byte b1 = 0; b1 < paramf.length(); b1++) {
/* 333 */       i i = paramf.b(b1);
/* 334 */       if (!i.has("situacao") || i.getInt("situacao") != 2)
/*     */       {
/*     */ 
/*     */         
/* 338 */         if (i.has("valores")) {
/*     */ 
/*     */ 
/*     */           
/* 342 */           h h = new h();
/* 343 */           h.l(i.getInt("classificacao"));
/* 344 */           h.x(i.getBoolean("declaracaoMeEpp"));
/* 345 */           h.ap(h.aT() ? "ME/EPP" : "Demais (Diferente de ME/EPP)");
/*     */           
/* 347 */           i i1 = i.j("participante");
/* 348 */           h.D(i1.getString("identificacao"));
/* 349 */           h.A(parame.a().a().aw().equals(h.av()));
/* 350 */           h.E(i1.getString("nome"));
/*     */           
/* 352 */           if (parame.w() == v.b.v()) {
/* 353 */             h.q(i.j("valores").j("valorPropostaInicialOuLances").getDouble("valorInformado"));
/*     */           } else {
/* 355 */             i i2 = i.j("valores").j("valorPropostaInicialOuLances").j("valorCalculado");
/* 356 */             if (i2.has("valorUnitario")) {
/* 357 */               h.q(i2.getDouble("valorUnitario"));
/*     */             } else {
/* 359 */               h.q(i2.getDouble("valorTotal"));
/*     */             } 
/*     */           } 
/*     */           
/* 363 */           if (i.has("marcaFabricante")) {
/* 364 */             h.al(i.getString("marcaFabricante"));
/* 365 */             h.ao(i.getString("modeloVersao"));
/*     */           } 
/*     */           
/* 368 */           arrayList.add(h);
/*     */         }  } 
/*     */     } 
/* 371 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public void S() {
/* 376 */     aG();
/*     */     
/* 378 */     if (!t.d.equals(c())) {
/*     */       return;
/*     */     }
/*     */     try {
/*     */       f f;
/* 383 */       if (b().a() == null || b().a().isEmpty()) {
/* 384 */         b().bN();
/*     */       }
/*     */       
/* 387 */       byte b1 = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       do {
/* 393 */         e e = b().a(a().bk(), b1);
/* 394 */         String str = e.getData();
/* 395 */         if (str.isEmpty()) {
/*     */           break;
/*     */         }
/*     */         
/* 399 */         f = new f(str);
/* 400 */         for (byte b2 = 0; b2 < f.length(); b2++) {
/* 401 */           i i = f.b(b2);
/* 402 */           String str1 = i.getString("identificador");
/* 403 */           e e1 = a(str1);
/* 404 */           if (e1 != null) {
/* 405 */             d(e1, i);
/*     */           }
/*     */         } 
/*     */         
/* 409 */         b1++;
/* 410 */       } while (f.length() >= 10);
/*     */       
/* 412 */       this.m.entrySet().stream().forEachOrdered(paramEntry -> {
/*     */             try {
/*     */               ((Future)paramEntry.getValue()).get();
/* 415 */             } catch (Exception exception) {}
/*     */           
/*     */           });
/* 418 */     } catch (Exception exception) {
/* 419 */       a.error("failed to load closed dispute items", exception);
/*     */     } finally {
/* 421 */       if (this.executor != null) {
/* 422 */         this.executor.shutdown();
/*     */       }
/*     */       
/* 425 */       this.n.clear();
/* 426 */       this.m.clear();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void g(e parame) {
/* 432 */     if (!b(parame.v())) {
/* 433 */       super.g(parame);
/*     */       
/* 435 */       this.n.remove(Integer.valueOf(parame.v()));
/* 436 */       this.m.remove(Integer.valueOf(parame.v()));
/* 437 */       if (this.a != null) {
/* 438 */         this.a.q(parame.bo());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void ab() {
/* 445 */     super.ab();
/*     */     
/* 447 */     if (this.a != null) {
/* 448 */       this.a.cancel();
/* 449 */       this.a = null;
/*     */     } 
/*     */     
/* 452 */     if (this.f != null) {
/* 453 */       this.f.cancel();
/* 454 */       this.f = null;
/*     */     } 
/*     */     
/* 457 */     if (this.a != null) {
/* 458 */       this.a.shutdown();
/*     */     }
/*     */     
/* 461 */     if (this.d != null) {
/* 462 */       this.d.shutdown();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void m(long paramLong) {
/* 468 */     a(0, paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   public void n(long paramLong) {
/* 473 */     a(1, paramLong);
/*     */   }
/*     */   
/*     */   private void a(int paramInt, long paramLong) {
/* 477 */     synchronized (this.f) {
/* 478 */       this.U++;
/* 479 */       this.V += paramInt;
/* 480 */       this.o += paramLong;
/*     */     } 
/*     */   }
/*     */   
/*     */   boolean g(i parami) {
/* 485 */     return this.a.h(parami);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void a(f paramf, List<h> paramList) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void T() {}
/*     */ 
/*     */   
/*     */   public final c a() {
/* 498 */     return (c)super.a();
/*     */   }
/*     */ 
/*     */   
/*     */   public final e b() {
/* 503 */     return (e)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\e\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */