/*     */ package br.com.arremate.d.k;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.s;
/*     */ import br.com.arremate.f.t;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.g.d;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.j.i.b;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.i.b;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.q.c.f;
/*     */ import br.com.arremate.m.y;
/*     */ import java.time.LocalDate;
/*     */ import java.time.LocalDateTime;
/*     */ import java.time.LocalTime;
/*     */ import java.time.ZoneId;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Timer;
/*     */ import java.util.TimerTask;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.stream.Collectors;
/*     */ import java.util.stream.IntStream;
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
/*     */ 
/*     */ public class e
/*     */   extends g
/*     */ {
/*     */   private final ExecutorService a;
/*     */   private final Map<Integer, Future<?>> c;
/*     */   private final Map<Integer, c> l;
/*     */   private boolean m;
/*     */   private Timer a;
/*     */   private Timer g;
/*     */   private final Map<Integer, f> t;
/*     */   private final long w;
/*     */   
/*     */   public e(b paramb, i parami, boolean paramBoolean) {
/*  59 */     super(paramb, parami);
/*  60 */     j(TimeUnit.SECONDS.toMillis(5L));
/*  61 */     a(new b(this, parami));
/*     */     
/*  63 */     this.a = (Timer)Executors.newCachedThreadPool();
/*  64 */     this.c = new HashMap<>();
/*  65 */     this.l = new HashMap<>();
/*  66 */     this.t = new HashMap<>();
/*     */     
/*  68 */     ZoneId zoneId = ZoneId.of("America/Sao_Paulo");
/*  69 */     this.w = LocalDateTime.of(LocalDate.now(zoneId), LocalTime.MIDNIGHT).atZone(zoneId).toInstant().toEpochMilli();
/*  70 */     if (paramBoolean) {
/*  71 */       a().a(this);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public t a() {
/*  77 */     br.com.arremate.h.e e1 = a().q(a().v());
/*  78 */     i i = new i(e1.getData());
/*  79 */     e(e1.k());
/*     */     
/*  81 */     String str = i.j("data").getString("situacao");
/*  82 */     switch (str) {
/*     */       case "Em Disputa":
/*  84 */         return t.c;
/*     */       case "Disputa Encerrada":
/*     */       case "Cancelada":
/*     */       case "Homologada":
/*  88 */         return t.d;
/*     */     } 
/*  90 */     return t.b;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected t b() {
/*  96 */     t t = super.b();
/*  97 */     if (t == t.c) {
/*     */ 
/*     */       
/* 100 */       an();
/* 101 */       bb();
/*     */     } 
/*     */     
/* 104 */     return t;
/*     */   }
/*     */   
/*     */   private void an() {
/* 108 */     this.a = new Timer("CountdownTimer");
/* 109 */     this.a.schedule(new TimerTask(this)
/*     */         {
/*     */           public void run() {
/* 112 */             this.a.a().B().parallelStream().forEach(param1g -> {
/*     */                   long l = param1g.z();
/*     */                   if (l <= 0L) {
/*     */                     return;
/*     */                   }
/*     */                   if (param1g.aM() || param1g.au()) {
/*     */                     param1g.x(l - 1000L);
/*     */                     this.a.a().fireTableCellUpdated(this.a.a().indexOf(param1g.v()), 14);
/*     */                   } 
/*     */                 });
/*     */           }
/*     */         }1000L, 1000L);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void bb() {
/* 129 */     this.g = new Timer("checkForClosedItemsTimer");
/* 130 */     this.g.schedule(new TimerTask(this)
/*     */         {
/*     */           public void run() {
/* 133 */             if (this.a.a().H().size() > 0) {
/* 134 */               boolean bool = false;
/* 135 */               f f = null;
/*     */               
/*     */               do {
/* 138 */                 br.com.arremate.h.e e1 = this.a.a().h(this.a.a().v(), bool);
/* 139 */                 f = (new i(e1.getData())).j("data").c("listaLoteTO");
/*     */                 
/* 141 */                 for (byte b = 0; b < f.length(); b++) {
/* 142 */                   i i = (i)f.get(b);
/* 143 */                   String str = String.valueOf(i.getInt("numeroLote"));
/*     */                   
/* 145 */                   this.a.a().H().parallelStream().forEach(param1e -> {
/*     */                         if (param1String.equals(param1e.bo()) && param1i.getBoolean("situacaoLotePermiteAtribuirArrematado")) {
/*     */                           e.a(this.a).remove(Integer.valueOf(param1e.v()));
/*     */                           
/*     */                           param1e.N("Arrematado");
/*     */                           
/*     */                           this.a.g(param1e);
/*     */                         } 
/*     */                       });
/*     */                 } 
/*     */                 
/* 156 */                 bool += true;
/* 157 */               } while (f.length() == 10);
/*     */             } 
/*     */           }
/*     */         }120000L, 120000L);
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
/*     */ 
/*     */   
/*     */   public void R() {
/*     */     try {
/* 177 */       f f = e();
/*     */       
/* 179 */       if (f != null) {
/* 180 */         for (byte b = 0; b < f.length(); b++) {
/* 181 */           i i = f.b(b);
/* 182 */           int j = i.getInt("numeroLicitacao");
/* 183 */           if (String.valueOf(j).equals(a().bo())) {
/* 184 */             int k = i.getInt("numeroLote");
/* 185 */             this.t.put(Integer.valueOf(k), i.c("mensagens"));
/*     */             
/* 187 */             br.com.arremate.l.q.b.e e1 = a(String.valueOf(k));
/* 188 */             if (e1 != null && !e1.br()) {
/* 189 */               e(e1, i);
/*     */             }
/*     */           }
/*     */         
/*     */         } 
/*     */       }
/* 195 */     } catch (Exception exception) {
/* 196 */       a.error("Erro na captura dos itens", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private f e() {
/* 201 */     boolean bool = false;
/* 202 */     byte b = 0;
/*     */     
/* 204 */     f f = new f();
/* 205 */     long l = 0L;
/*     */     do {
/*     */       br.com.arremate.h.e e1;
/* 208 */       if (!b) {
/* 209 */         e1 = a().o();
/*     */       } else {
/* 211 */         e1 = a().r(b);
/*     */       } 
/*     */       
/* 214 */       i i = (new i(e1.getData())).j("data");
/* 215 */       bool = i.getBoolean("ultimaPagina");
/* 216 */       f.a(i.c("conteudo"));
/*     */       
/* 218 */       l += e1.k();
/* 219 */       b++;
/* 220 */     } while (!bool);
/*     */     
/* 222 */     e(l / b);
/*     */     
/* 224 */     return f;
/*     */   }
/*     */   
/*     */   private void e(br.com.arremate.l.q.b.e parame, i parami) {
/* 228 */     int j = parame.v();
/* 229 */     Future future = this.c.get(Integer.valueOf(j));
/*     */     
/*     */     try {
/* 232 */       if (future == null || future.isDone()) {
/* 233 */         c c = this.l.get(Integer.valueOf(j));
/*     */         
/* 235 */         if (c == null) {
/* 236 */           if (a().a() == u.d) {
/* 237 */             c = new d(parame, (i)a(), this);
/*     */           } else {
/* 239 */             c = new c(parame, (i)a(), this);
/*     */           } 
/*     */           
/* 242 */           if (t.c.equals(c()) && !this.m) {
/* 243 */             this.l.put(Integer.valueOf(j), c);
/*     */             
/* 245 */             if (!parame.br()) {
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 250 */               String str = "Lote " + parame.bo() + " entrou em disputa com valor mínimo de R$ " + y.a("###,###,###,##0.0000").format(parame.l());
/* 251 */               l(str);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 256 */         c.b(parami);
/*     */         
/* 258 */         Future<?> future1 = this.a.submit((Runnable)c);
/* 259 */         this.c.put(Integer.valueOf(j), future1);
/*     */       } 
/* 261 */     } catch (Exception exception) {
/* 262 */       a.warn("[Item {}] Failed to start thread from item", parame.bo(), exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean b(br.com.arremate.l.q.b.e parame, double paramDouble) {
/* 267 */     c c = this.l.get(Integer.valueOf(parame.v()));
/* 268 */     if (c == null) {
/* 269 */       return false;
/*     */     }
/*     */     
/* 272 */     return c.a(new h(paramDouble), true);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> b(br.com.arremate.l.q.b.e parame) throws d {
/* 277 */     if (!parame.br() && isRunning()) {
/* 278 */       c c = this.l.get(Integer.valueOf(parame.v()));
/* 279 */       if (c == null) {
/* 280 */         c = new c(parame, (i)a(), this);
/*     */       }
/*     */       
/* 283 */       return c.e();
/* 284 */     }  if (parame.br()) {
/* 285 */       return f(parame);
/*     */     }
/*     */     
/* 288 */     return new ArrayList<>();
/*     */   }
/*     */ 
/*     */   
/*     */   public void S() {
/*     */     try {
/* 294 */       boolean bool = false;
/* 295 */       f f = null;
/*     */       
/*     */       do {
/* 298 */         br.com.arremate.h.e e1 = a().h(a().v(), bool);
/* 299 */         f = (new i(e1.getData())).j("data").c("listaLoteTO");
/*     */         
/* 301 */         for (byte b = 0; b < f.length(); b++) {
/* 302 */           i i = (i)f.get(b);
/* 303 */           String str = String.valueOf(i.getInt("numeroLote"));
/*     */           
/* 305 */           if (e(str)) {
/*     */ 
/*     */ 
/*     */             
/* 309 */             br.com.arremate.l.q.b.e e2 = a(str);
/* 310 */             if (i.getBoolean("situacaoLotePermiteAtribuirArrematado")) {
/* 311 */               e2.N("Arrematado");
/*     */             }
/* 313 */             List<h> list = f(e2);
/* 314 */             e2.h(list.get(0));
/* 315 */             e2.a((e2.f() == e2.f().m()) ? s.a : s.c);
/*     */             
/* 317 */             g(e2);
/*     */           } 
/*     */         } 
/* 320 */         bool += true;
/* 321 */       } while (f.length() == 10);
/* 322 */     } catch (g g1) {
/* 323 */       a.error("Failed to load finished items Licitacoes-e", (Throwable)g1);
/*     */     } 
/*     */   }
/*     */   
/*     */   private List<h> f(br.com.arremate.l.q.b.e parame) {
/* 328 */     br.com.arremate.h.e e1 = a().j(parame.a().v(), parame.v());
/* 329 */     String str = e1.getData();
/* 330 */     if (str.isEmpty()) {
/* 331 */       return new ArrayList<>();
/*     */     }
/*     */     
/* 334 */     f f = (new i(str)).c("data");
/* 335 */     ArrayList<h> arrayList = new ArrayList();
/* 336 */     List list = (List)IntStream.range(0, f.length()).mapToObj(f::b).collect(Collectors.toList());
/*     */     
/* 338 */     if (a().a() == u.d) {
/* 339 */       list.sort(Comparator.comparingDouble(paramObject -> ((i)paramObject).getDouble("valor")).reversed());
/*     */     } else {
/* 341 */       list.sort(Comparator.comparingDouble(parami -> parami.getDouble("valor")));
/*     */     } 
/*     */     
/* 344 */     boolean bool = false;
/* 345 */     byte b = 0;
/*     */     
/* 347 */     for (i i : list) {
/* 348 */       h h = new h();
/* 349 */       h.l(++b);
/* 350 */       h.c(y.a(i.getString("data"), i.getString("hora")));
/* 351 */       h.q(i.getDouble("valor"));
/*     */       
/* 353 */       if (i.getString("nomeFornecedor").equals(a().a().bv())) {
/* 354 */         if (!bool) {
/* 355 */           bool = true;
/* 356 */           parame.h(h.m());
/*     */         } 
/*     */         
/* 359 */         h.A(true);
/*     */       } 
/*     */       
/* 362 */       arrayList.add(h);
/*     */     } 
/*     */     
/* 365 */     return arrayList;
/*     */   }
/*     */   
/*     */   private boolean e(String paramString) {
/* 369 */     for (g g1 : a().B()) {
/* 370 */       if (g1.bo().equals(paramString)) {
/* 371 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 375 */     return false;
/*     */   }
/*     */   
/*     */   public long i() {
/* 379 */     return this.w;
/*     */   }
/*     */ 
/*     */   
/*     */   public void ab() {
/* 384 */     super.ab();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 390 */     if (this.a != null) {
/* 391 */       this.a.cancel();
/*     */     }
/*     */     
/* 394 */     if (this.g != null) {
/* 395 */       this.g.cancel();
/*     */     }
/*     */   }
/*     */   
/*     */   void p(br.com.arremate.l.q.b.e parame) {
/* 400 */     this.l.remove(Integer.valueOf(parame.v()));
/*     */   }
/*     */ 
/*     */   
/*     */   public b a() {
/* 405 */     return (b)super.a();
/*     */   }
/*     */ 
/*     */   
/*     */   public final b a() {
/* 410 */     return (b)super.a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void T() {}
/*     */ 
/*     */   
/*     */   protected void a(f paramf, List<h> paramList) {}
/*     */ 
/*     */   
/*     */   public Map<Integer, f> i() {
/* 422 */     return this.t;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\k\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */