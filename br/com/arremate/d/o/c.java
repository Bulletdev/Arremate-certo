/*     */ package br.com.arremate.d.o;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.d.e;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.s;
/*     */ import br.com.arremate.f.t;
/*     */ import br.com.arremate.g.d;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.f;
/*     */ import br.com.arremate.j.g;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.l.b;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.l.q.c.f;
/*     */ import br.com.arremate.m.y;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.StringJoiner;
/*     */ import java.util.Timer;
/*     */ import java.util.TimerTask;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.Future;
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
/*     */ public final class c
/*     */   extends g
/*     */ {
/*     */   private final ExecutorService a;
/*     */   private final Map<Integer, Future<?>> g;
/*     */   private final Map<Integer, b> h;
/*     */   private final g b;
/*     */   private final HashSet<g> a;
/*     */   private String af;
/*  53 */   long r = 0L;
/*     */   private Timer a;
/*     */   
/*     */   public c(b paramb, i parami) {
/*  57 */     super(paramb, parami);
/*  58 */     a(new a(this, a()));
/*  59 */     j(1000L);
/*     */     
/*  61 */     this.a = (Timer)Executors.newCachedThreadPool();
/*  62 */     this.g = new HashMap<>();
/*  63 */     this.h = new HashMap<>();
/*     */     
/*  65 */     this.b = new g(a());
/*  66 */     this.b.z();
/*  67 */     this.a = (Timer)new HashSet(Arrays.asList((Object[])new g[] { g.aD, g.aA, g.aB, g.aC }));
/*     */ 
/*     */     
/*  70 */     this.af = "{}";
/*     */   }
/*     */ 
/*     */   
/*     */   protected t b() {
/*  75 */     t t = super.b();
/*  76 */     if (t == t.c && 
/*  77 */       a().a() != m.a) {
/*  78 */       an();
/*     */     }
/*     */ 
/*     */     
/*  82 */     return t;
/*     */   }
/*     */   
/*     */   private void an() {
/*  86 */     this.a = new Timer("CountdownTimer");
/*  87 */     this.a.schedule(new TimerTask(this)
/*     */         {
/*     */           public void run() {
/*  90 */             this.a.a().B().parallelStream().forEach(param1g -> {
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
/*     */   public t a() {
/* 108 */     String str = this.b.f(a().v());
/*     */     try {
/* 110 */       if (!str.isEmpty()) {
/* 111 */         Document document = Jsoup.parse(str);
/* 112 */         String str1 = document.select("#lbSituacaoField").first().text().toLowerCase();
/* 113 */         k(str1);
/*     */         
/* 115 */         switch (str1) {
/*     */           case "aguardando abertura":
/* 117 */             return t.b;
/*     */           case "aberto":
/* 119 */             if (M()) {
/* 120 */               return t.c;
/*     */             }
/* 122 */             return t.d;
/*     */           
/*     */           case "encerrado":
/* 125 */             return t.d;
/*     */           case "suspenso":
/* 127 */             if (M()) {
/* 128 */               return t.e;
/*     */             }
/* 130 */             return t.d;
/*     */         } 
/*     */         
/* 133 */         return t.b;
/*     */       }
/*     */     
/* 136 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/* 139 */     return t.b;
/*     */   }
/*     */   
/*     */   private boolean M() {
/* 143 */     boolean bool = false;
/*     */     
/*     */     try {
/* 146 */       String str = this.b.f(a().v());
/* 147 */       if (!str.isEmpty()) {
/* 148 */         Document document = Jsoup.parse(str);
/* 149 */         Elements elements = document.select("tbody[id=listaLotesTbody] > tr");
/* 150 */         bool = elements.stream().anyMatch(paramElement -> {
/*     */               Element element = paramElement.select("label[id*=lbFaseLote]").first();
/*     */               String str = element.text().trim();
/*     */               return this.a.stream().noneMatch(());
/*     */             });
/*     */       } 
/* 156 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/* 159 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public void R() {
/* 164 */     if (this.af.equals("{}")) {
/* 165 */       StringJoiner stringJoiner = new StringJoiner(",");
/* 166 */       for (e e : a().L()) {
/* 167 */         stringJoiner.add(Integer.toString(e.v()));
/*     */       }
/*     */       
/* 170 */       this.af = String.join("", new CharSequence[] { "{", stringJoiner.toString(), "}" });
/*     */     } 
/*     */     
/*     */     try {
/* 174 */       e e = this.b.e(a().v(), this.af);
/* 175 */       this.r += e.k();
/* 176 */       String str = e.getData();
/* 177 */       if (str.isEmpty()) {
/* 178 */         aY();
/*     */         
/*     */         return;
/*     */       } 
/* 182 */       i i = new i(str);
/* 183 */       if (!i.has("response")) {
/* 184 */         aY();
/*     */         
/*     */         return;
/*     */       } 
/* 188 */       e(this.r);
/* 189 */       this.r = 0L;
/*     */       
/* 191 */       f f = i.c("response");
/* 192 */       f.spliterator().forEachRemaining(paramObject -> {
/*     */             i i = (i)paramObject;
/*     */             e e = a(i.getInt("idLote"));
/*     */             if (e != null) {
/*     */               String str = i.getString("faseLote");
/*     */               if (a(e, str)) {
/*     */                 e(e, i);
/*     */               }
/*     */             } 
/*     */           });
/* 202 */     } catch (Exception exception) {
/* 203 */       a.error("Failed to capture dispute item data", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void aY() {
/* 208 */     a().H().forEach(parame -> e(parame, null));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean a(e parame, String paramString) {
/* 214 */     return ((!parame.bw() && !parame.br()) || !paramString.equals(parame.bB()));
/*     */   }
/*     */   
/*     */   private void e(e parame, i parami) {
/* 218 */     int j = parame.v();
/* 219 */     Future future = this.g.get(Integer.valueOf(j));
/*     */     
/*     */     try {
/* 222 */       if (future == null || future.isDone()) {
/* 223 */         b b = this.h.get(Integer.valueOf(j));
/*     */         
/* 225 */         if (b == null) {
/* 226 */           b = new b(parame, (i)this.b, this);
/*     */           
/* 228 */           this.h.put(Integer.valueOf(j), b);
/*     */           
/* 230 */           StringBuilder stringBuilder = new StringBuilder();
/* 231 */           stringBuilder.append("Lote ").append(parame.bo()).append(" entrou em disputa com valor mínimo de R$ ")
/* 232 */             .append(y.a("###,###,###,##0.0000").format(parame.l()));
/*     */           
/* 234 */           l(stringBuilder.toString());
/*     */         } 
/*     */         
/* 237 */         b.b(parami);
/*     */         
/* 239 */         Future<?> future1 = this.a.submit((Runnable)b);
/* 240 */         this.g.put(Integer.valueOf(j), future1);
/*     */       } 
/* 242 */     } catch (Exception exception) {
/* 243 */       a.warn("[Item {}] Failed to start thread from item", parame.bo(), exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> b(e parame) throws d {
/* 249 */     b b = this.h.get(Integer.valueOf(parame.v()));
/* 250 */     if (b == null) {
/* 251 */       b = new b(parame, (i)this.b, this);
/*     */     }
/*     */     
/* 254 */     return b.e();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean b(e parame, double paramDouble) {
/* 259 */     b b = this.h.get(Integer.valueOf(parame.v()));
/* 260 */     if (b == null) {
/* 261 */       return false;
/*     */     }
/*     */     
/* 264 */     return b.a(new h(paramDouble), true);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void T() {
/* 269 */     a().I().forEach(parame -> {
/*     */           b b = this.h.get(Integer.valueOf(parame.v()));
/*     */           if (b != null) {
/*     */             parame.ah(b.s());
/*     */             parame.ai(b.t());
/*     */           } 
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void g(e parame) {
/* 281 */     super.g(parame);
/*     */     
/* 283 */     this.h.remove(Integer.valueOf(parame.v()));
/* 284 */     this.g.remove(Integer.valueOf(parame.v()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void S() {
/*     */     try {
/* 291 */       String str = this.b.f(a().v());
/* 292 */       if (!str.isEmpty()) {
/* 293 */         Document document = Jsoup.parse(str);
/* 294 */         Elements elements = document.select("tbody[id=listaLotesTbody]");
/*     */         
/* 296 */         Map<Integer, e> map = a(elements, g.aD);
/* 297 */         if (!map.isEmpty()) {
/* 298 */           a(this.b.f(a().v(), a(map)), map);
/*     */         }
/*     */         
/* 301 */         map = a(elements, g.aA);
/* 302 */         if (!map.isEmpty()) {
/* 303 */           a(this.b.g(a().v(), a(map)), map);
/*     */         }
/*     */         
/* 306 */         map = a(elements, g.aC);
/* 307 */         if (!map.isEmpty()) {
/* 308 */           a(this.b.h(a().v(), a(map)), map);
/*     */         }
/*     */         
/* 311 */         map = a(elements, g.aB);
/* 312 */         if (!map.isEmpty()) {
/* 313 */           a(this.b.i(a().v(), a(map)), map);
/*     */         }
/*     */       } 
/* 316 */     } catch (Exception exception) {
/* 317 */       a.error("Failed to get closed items", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void a(e parame, Map<Integer, e> paramMap) {
/* 322 */     e(parame.k());
/* 323 */     if (parame.getData().isEmpty()) {
/*     */       return;
/*     */     }
/*     */     
/* 327 */     i i = new i(parame.getData());
/* 328 */     i.c("response").forEach(paramObject -> {
/*     */           i i = (i)paramObject;
/*     */           e e = (e)paramMap.get(Integer.valueOf(i.getInt("idLote")));
/*     */           e.N(i.getString("faseLote"));
/*     */           double d1 = y.a(i.getString("meuLanceFornecedor")).doubleValue();
/*     */           e.h(d1);
/*     */           double d2 = 0.0D;
/*     */           for (i i1 : i.c("listaFornecedores")) {
/*     */             i i2 = i1;
/*     */             if (i2.getBoolean("habilitado")) {
/*     */               Double double_ = y.a(i2.getString("lanceMaximoMinimo"));
/*     */               if (double_.doubleValue() < d2 || d2 == 0.0D) {
/*     */                 d2 = double_.doubleValue();
/*     */               }
/*     */             } 
/*     */           } 
/*     */           e.l(d2);
/*     */           e.a((d2 == d1) ? s.a : s.c);
/*     */           super.g(e);
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Map<Integer, e> a(Elements paramElements, g paramg) {
/* 355 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 356 */     paramElements.select("label[id*=lbFaseLote]").stream()
/* 357 */       .filter(paramElement -> paramElement.text().trim().equals(paramg.getValue()))
/* 358 */       .forEach(paramElement -> {
/*     */           int i = Integer.parseInt(paramElement.id().replace("lbFaseLote", "").trim());
/*     */           
/*     */           e e = a(i);
/*     */           if (e != null) {
/*     */             paramMap.put(Integer.valueOf(i), e);
/*     */           }
/*     */         });
/* 366 */     return (Map)hashMap;
/*     */   }
/*     */   
/*     */   private String a(Map<Integer, e> paramMap) {
/* 370 */     StringJoiner stringJoiner = new StringJoiner(",");
/* 371 */     for (e e : paramMap.values()) {
/* 372 */       stringJoiner.add(Integer.toString(e.v()));
/*     */     }
/*     */     
/* 375 */     return String.join("", new CharSequence[] { "{", stringJoiner.toString(), "}" });
/*     */   }
/*     */ 
/*     */   
/*     */   public void ab() {
/* 380 */     super.ab();
/*     */     
/* 382 */     if (this.a != null) {
/* 383 */       this.a.cancel();
/* 384 */       this.a = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public g b() {
/* 389 */     return this.b;
/*     */   }
/*     */ 
/*     */   
/*     */   protected a a() {
/* 394 */     return (a)super.a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void a(f paramf, List<h> paramList) {}
/*     */ 
/*     */   
/*     */   public b a() {
/* 403 */     return (b)super.a();
/*     */   }
/*     */ 
/*     */   
/*     */   public f a() {
/* 408 */     return (f)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\o\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */