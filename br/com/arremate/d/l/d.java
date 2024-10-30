/*     */ package br.com.arremate.d.l;
/*     */ 
/*     */ import br.com.arremate.a.m;
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.t;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.j.j.a;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.l.q.c.f;
/*     */ import br.com.arremate.m.y;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Timer;
/*     */ import java.util.TimerTask;
/*     */ import java.util.TreeSet;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.e.f;
/*     */ import org.e.i;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class d
/*     */   extends g
/*     */ {
/*  36 */   private static final long B = TimeUnit.SECONDS.toMillis(20L);
/*     */   
/*     */   private final ExecutorService a;
/*     */   
/*     */   private final Map<Integer, Future> g;
/*     */   private final Map<Integer, c> h;
/*     */   private final Map<String, f> u;
/*     */   private final m a;
/*     */   private boolean m;
/*     */   private Timer a;
/*     */   private boolean o;
/*     */   private long C;
/*     */   private long D;
/*     */   
/*     */   public d(b paramb, i parami, boolean paramBoolean) {
/*  51 */     super(paramb, parami);
/*  52 */     k(TimeUnit.SECONDS.toMillis(30L));
/*  53 */     j(TimeUnit.SECONDS.toMillis(5L));
/*  54 */     this.a = (Timer)new m();
/*  55 */     a(new b(this, parami, (m)this.a));
/*     */     
/*  57 */     this.a = (Timer)Executors.newCachedThreadPool();
/*  58 */     this.g = new HashMap<>();
/*  59 */     this.h = new HashMap<>();
/*  60 */     this.u = new HashMap<>();
/*     */   }
/*     */ 
/*     */   
/*     */   public t a() {
/*     */     try {
/*  66 */       long l = y.i().getTimeInMillis();
/*     */       
/*  68 */       if (this.o && !b(l)) {
/*  69 */         return c();
/*     */       }
/*  71 */       e e = a().u(a().v());
/*  72 */       e(e.k());
/*  73 */       this.D = l;
/*     */       
/*  75 */       if (!e.getData().isEmpty()) {
/*  76 */         boolean bool; i i = new i(e.getData().replaceAll("\\\\.", ""));
/*  77 */         f f = i.c("data");
/*  78 */         int j = f.b(0).getInt("idStatus");
/*     */         
/*  80 */         switch (j) {
/*     */           case 1:
/*  82 */             bool = a().B().stream().allMatch(paramg -> paramg.aw());
/*  83 */             return bool ? t.d : t.b;
/*     */           case 2:
/*  85 */             k("Em disputa");
/*  86 */             return t.c;
/*     */           case 4:
/*     */           case 6:
/*     */           case 12:
/*     */           case 18:
/*     */           case 19:
/*     */           case 20:
/*  93 */             return t.d;
/*     */         } 
/*  95 */         return t.b;
/*     */       } 
/*     */       
/*  98 */       a.warn("Error getting bidding status {} - {}. Unknown response: {}", new Object[] {
/*  99 */             a().bo(), a().bT(), Integer.valueOf(e.getStatusCode())
/*     */           });
/* 101 */     } catch (Exception exception) {
/* 102 */       a.error("Failed to get bidding status", exception);
/*     */     } 
/*     */     
/* 105 */     return t.b;
/*     */   }
/*     */ 
/*     */   
/*     */   protected t b() {
/* 110 */     t t = super.b();
/* 111 */     if (t == t.c && a().a() != m.a) {
/* 112 */       an();
/*     */     }
/*     */     
/* 115 */     if (t != t.d) {
/* 116 */       bh();
/*     */     }
/*     */     
/* 119 */     return t;
/*     */   }
/*     */   
/*     */   private void an() {
/* 123 */     this.a = new Timer("CountdownTimer");
/* 124 */     this.a.schedule(new TimerTask(this)
/*     */         {
/*     */           public void run() {
/* 127 */             this.a.a().B().parallelStream().forEach(param1g -> {
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
/*     */   
/*     */   public void R() {
/*     */     try {
/* 146 */       long l = y.i().getTimeInMillis();
/*     */       
/* 148 */       if (!a(l)) {
/* 149 */         bg();
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 154 */       e e = (a().a() == m.a) ? a().a(a().v(), false) : a().a(a().v(), !this.m);
/*     */       
/* 156 */       String str = e.getData();
/* 157 */       e(e.k());
/*     */       
/* 159 */       if (!y.n(str)) {
/* 160 */         a.info("[Licitanet] Pregão {} - {} não atualizou os dados de disputa pois o retorno portal é desconhecido. {}", new Object[] { a().bo(), a().bT(), Integer.valueOf(e.getStatusCode()) });
/*     */         return;
/*     */       } 
/* 163 */       ArrayList<Integer> arrayList = new ArrayList();
/* 164 */       f f = new f(str);
/*     */       
/* 166 */       b(f);
/*     */       
/* 168 */       f.spliterator().forEachRemaining(paramObject -> {
/*     */             i i = (i)paramObject;
/*     */             
/*     */             int j = i.getInt("batch");
/*     */             
/*     */             paramList.add(Integer.valueOf(j));
/*     */             e e = a(j);
/*     */             if (e != null) {
/*     */               e(e, i);
/*     */             }
/*     */           });
/* 179 */       j(arrayList);
/* 180 */       this.C = l;
/* 181 */     } catch (Exception exception) {
/* 182 */       a.error("[Licitanet] Erro inesperado durante a captura de dados atualizados da disputa", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void b(f paramf) {
/*     */     try {
/* 188 */       TreeSet<Integer> treeSet = a(paramf);
/*     */       
/* 190 */       if (treeSet.isEmpty()) {
/*     */         return;
/*     */       }
/* 193 */       i i = a(treeSet);
/* 194 */       i.keySet().forEach(paramString -> {
/*     */             i i1 = parami.j(paramString);
/*     */             
/*     */             if (i1.has("bids")) {
/*     */               this.u.put(paramString, i1.c("bids"));
/*     */             }
/*     */           });
/* 201 */     } catch (Exception exception) {
/* 202 */       a.error("[Licitanet] Erro inesperado durante a captura dos melhores lances de itens em disputa", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private TreeSet<Integer> a(f paramf) {
/* 207 */     TreeSet<Integer> treeSet = new TreeSet();
/* 208 */     paramf.forEach(paramObject -> paramTreeSet.add(Integer.valueOf(((i)paramObject).getInt("batch"))));
/* 209 */     return treeSet;
/*     */   }
/*     */   
/*     */   private i a(TreeSet<Integer> paramTreeSet) {
/* 213 */     e e = a().l(a().v(), StringUtils.join(paramTreeSet, ','));
/*     */     
/* 215 */     if (!y.m(e.getData())) {
/* 216 */       a.info("[Licitanet] {} - {} não capturou os melhores lances da disputa pois o retorno portal é desconhecido. {}", new Object[] {
/* 217 */             a().bo(), a().bT(), Integer.valueOf(e.getStatusCode()) });
/* 218 */       return new i();
/*     */     } 
/*     */     
/* 221 */     i i = new i(e.getData());
/*     */     
/* 223 */     if (i.has("statusCode")) {
/* 224 */       a.info("[Licitanet] {} - {} não capturou os melhores lances da disputa, retorno do portal foi status code no JSON: {} status code na requisição {}", new Object[] {
/* 225 */             a().bo(), a().bT(), i.get("statusCode"), Integer.valueOf(e.getStatusCode()) });
/* 226 */       return new i();
/*     */     } 
/*     */     
/* 229 */     return i;
/*     */   }
/*     */   
/*     */   private void j(List<Integer> paramList) {
/* 233 */     a().H().parallelStream().forEach(parame -> {
/*     */           if (!paramList.contains(Integer.valueOf(parame.v()))) {
/*     */             parame.N("pendente");
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   private void e(e parame, i parami) {
/* 241 */     int j = parame.v();
/* 242 */     Future future = this.g.get(Integer.valueOf(j));
/*     */     
/*     */     try {
/* 245 */       if (future == null || future.isDone()) {
/* 246 */         c c = this.h.get(Integer.valueOf(j));
/*     */         
/* 248 */         if (c == null) {
/* 249 */           c = new c(parame, (i)a(), this);
/*     */           
/* 251 */           if (t.c.equals(c()) && !this.m) {
/* 252 */             this.h.put(Integer.valueOf(j), c);
/*     */             
/* 254 */             if (!parame.br()) {
/* 255 */               StringBuilder stringBuilder = new StringBuilder();
/* 256 */               stringBuilder
/* 257 */                 .append("Lote ")
/* 258 */                 .append(parame.bo())
/* 259 */                 .append(" entrou em disputa com valor mínimo de R$ ")
/* 260 */                 .append(y.a("###,###,###,##0.0000")
/* 261 */                   .format(parame.l()));
/* 262 */               l(stringBuilder.toString());
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 267 */         f f = null;
/*     */         
/* 269 */         if (this.u.containsKey(parame.bo())) {
/* 270 */           f = this.u.get(parame.bo());
/*     */         }
/*     */         
/* 273 */         c.b(parami);
/* 274 */         c.a(f);
/*     */         
/* 276 */         Future<?> future1 = this.a.submit((Runnable)c);
/* 277 */         this.g.put(Integer.valueOf(j), future1);
/*     */       } 
/* 279 */     } catch (Exception exception) {
/* 280 */       a.warn("[Item {}] Failed to start thread from item", parame.bo(), exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void bg() {
/* 285 */     this.h.keySet().forEach(paramInteger -> {
/*     */           Future future = this.g.get(paramInteger);
/*     */           e e = a(paramInteger.intValue());
/*     */           if (e == null || !e.bt() || (future != null && !future.isDone())) {
/*     */             return;
/*     */           }
/*     */           c c = this.h.get(paramInteger);
/*     */           Future<?> future1 = this.a.submit((Runnable)c);
/*     */           this.g.put(paramInteger, future1);
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean b(e parame, double paramDouble) {
/* 300 */     c c = this.h.get(Integer.valueOf(parame.v()));
/* 301 */     if (c == null) {
/* 302 */       return false;
/*     */     }
/* 304 */     return c.a(new h(paramDouble), true);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> b(e parame) throws br.com.arremate.g.d {
/* 309 */     c c = this.h.get(Integer.valueOf(parame.v()));
/* 310 */     if (c == null) {
/* 311 */       c = new c(parame, (i)a(), this);
/*     */     }
/* 313 */     return c.e();
/*     */   }
/*     */ 
/*     */   
/*     */   public void S() {
/* 318 */     this.m = true;
/* 319 */     R();
/*     */     
/* 321 */     this.g.values().stream().forEachOrdered(paramFuture -> {
/*     */           try {
/*     */             paramFuture.get();
/* 324 */           } catch (Exception exception) {}
/*     */         });
/*     */ 
/*     */     
/* 328 */     this.a.shutdown();
/*     */   }
/*     */ 
/*     */   
/*     */   public void ab() {
/* 333 */     super.ab();
/*     */     
/* 335 */     if (this.a != null) {
/* 336 */       this.a.cancel();
/*     */     }
/*     */     
/* 339 */     bi();
/* 340 */     this.a.b();
/*     */   }
/*     */   
/*     */   void p(e parame) {
/* 344 */     this.h.remove(Integer.valueOf(parame.v()));
/*     */   }
/*     */ 
/*     */   
/*     */   public final a a() {
/* 349 */     return (a)super.a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void T() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void a(f paramf, List<h> paramList) {}
/*     */ 
/*     */ 
/*     */   
/*     */   private void bh() {
/* 363 */     if (this.o || !isRunning()) {
/*     */       return;
/*     */     }
/* 366 */     e e = this.a.b(a().v(), a().a().bz());
/* 367 */     a.info("Response webhook subscribed: {}", Integer.valueOf(e.getStatusCode()));
/*     */     
/* 369 */     if (e.getStatusCode() == 200) {
/* 370 */       this.o = true;
/*     */     }
/*     */   }
/*     */   
/*     */   private void bi() {
/* 375 */     e e = this.a.c(a().v(), a().a().bz());
/* 376 */     this.o = false;
/* 377 */     a.info("Response webhook unsubscribed: {}", Integer.valueOf(e.getStatusCode()));
/*     */   }
/*     */   
/*     */   private boolean a(long paramLong) {
/* 381 */     e e = this.a.a(a().v());
/*     */     
/* 383 */     if (e.getStatusCode() == 404) {
/* 384 */       this.o = false;
/* 385 */       bh();
/*     */     } 
/* 387 */     long l1 = paramLong - this.C;
/* 388 */     long l2 = a(e);
/* 389 */     return (this.C == 0L || l1 >= B || l2 > this.C);
/*     */   }
/*     */   
/*     */   private long a(e parame) {
/* 393 */     if (parame.getStatusCode() != 200) {
/* 394 */       return 0L;
/*     */     }
/* 396 */     i i = new i(parame.getData());
/* 397 */     String str = i.getString("lastBid");
/* 398 */     return y.a(str).getTime();
/*     */   }
/*     */   
/*     */   private boolean b(long paramLong) {
/* 402 */     long l = paramLong - this.D;
/* 403 */     return (this.D == 0L || l >= B);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\l\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */