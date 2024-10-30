/*     */ package br.com.arremate.d.j;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.d.e;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.f.s;
/*     */ import br.com.arremate.f.t;
/*     */ import br.com.arremate.g.d;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.b;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.h.b;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.l.q.c.f;
/*     */ import br.com.arremate.m.y;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.StringJoiner;
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
/*     */ public final class c
/*     */   extends g
/*     */ {
/*     */   private final ExecutorService a;
/*     */   private final Map<Integer, Future> g;
/*     */   private final Map<Integer, b> h;
/*     */   private final br.com.arremate.j.c b;
/*     */   private final Set<g> a;
/*     */   private String af;
/*  45 */   long r = 0L;
/*     */   
/*     */   public c(b paramb, i parami) {
/*  48 */     super(paramb, parami);
/*  49 */     a(new a(this, a()));
/*  50 */     j(1000L);
/*     */     
/*  52 */     this.g = new HashMap<>();
/*  53 */     this.h = new HashMap<>();
/*  54 */     this.a = (Set<g>)Executors.newCachedThreadPool();
/*     */     
/*  56 */     this.b = new br.com.arremate.j.c(a());
/*  57 */     this.b.z();
/*  58 */     this.a = new HashSet<>(Arrays.asList(new g[] { g.aD, g.aA, g.aB, g.aC, g.az }));
/*     */ 
/*     */     
/*  61 */     this.af = "{}";
/*     */   }
/*     */ 
/*     */   
/*     */   public t a() {
/*  66 */     String str = this.b.f(a().v());
/*     */     try {
/*  68 */       if (!str.isEmpty()) {
/*  69 */         Document document = Jsoup.parse(str);
/*  70 */         String str1 = document.select("#lbSituacaoField").first().text().toLowerCase();
/*  71 */         k(str1);
/*     */         
/*  73 */         switch (str1) {
/*     */           case "aguardando abertura":
/*  75 */             return t.b;
/*     */           case "aberto":
/*  77 */             if (M()) {
/*  78 */               return t.c;
/*     */             }
/*  80 */             return t.d;
/*     */           
/*     */           case "encerrado":
/*  83 */             return t.d;
/*     */           case "suspenso":
/*  85 */             if (M()) {
/*  86 */               return t.e;
/*     */             }
/*  88 */             return t.d;
/*     */         } 
/*     */         
/*  91 */         return t.b;
/*     */       }
/*     */     
/*  94 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/*  97 */     return t.b;
/*     */   }
/*     */   
/*     */   private boolean M() {
/* 101 */     boolean bool = false;
/*     */     
/*     */     try {
/* 104 */       String str = this.b.f(a().v());
/* 105 */       if (!str.isEmpty()) {
/* 106 */         Document document = Jsoup.parse(str);
/* 107 */         Elements elements = document.select("tbody[id=listaLotesTbody] > tr");
/* 108 */         bool = elements.stream().anyMatch(paramElement -> {
/*     */               Element element = paramElement.select("label[id*=lbFaseLote]").first();
/*     */               String str = element.text().trim();
/*     */               return this.a.stream().noneMatch(());
/*     */             });
/*     */       } 
/* 114 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/* 117 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public void R() {
/* 122 */     if (this.af.equals("{}")) {
/* 123 */       StringJoiner stringJoiner = new StringJoiner(",");
/* 124 */       for (e e : a().L()) {
/* 125 */         stringJoiner.add(Integer.toString(e.v()));
/*     */       }
/*     */       
/* 128 */       this.af = String.join("", new CharSequence[] { "{", stringJoiner.toString(), "}" });
/*     */     } 
/*     */     
/*     */     try {
/* 132 */       e e = this.b.e(a().v(), this.af);
/* 133 */       this.r += e.k();
/* 134 */       String str = e.getData();
/* 135 */       if (str.isEmpty()) {
/* 136 */         aY();
/*     */         
/*     */         return;
/*     */       } 
/* 140 */       i i = new i(str);
/* 141 */       if (!i.has("response")) {
/* 142 */         aY();
/*     */         
/*     */         return;
/*     */       } 
/* 146 */       e(this.r);
/* 147 */       this.r = 0L;
/*     */       
/* 149 */       f f = i.c("response");
/* 150 */       f.spliterator().forEachRemaining(paramObject -> {
/*     */             i i = (i)paramObject;
/*     */             e e = a(i.getInt("idLote"));
/*     */             if (e != null) {
/*     */               String str = i.getString("faseLote");
/*     */               if (a(e, str)) {
/*     */                 e(e, i);
/*     */               }
/*     */             } 
/*     */           });
/* 160 */     } catch (Exception exception) {
/* 161 */       a.error("Failed to capture dispute item data", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void aY() {
/* 166 */     a().H().forEach(parame -> e(parame, null));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean a(e parame, String paramString) {
/* 172 */     return ((!parame.bw() && !parame.br()) || !paramString.equals(parame.bB()));
/*     */   }
/*     */   
/*     */   private void e(e parame, i parami) {
/* 176 */     int j = parame.v();
/* 177 */     Future future = this.g.get(Integer.valueOf(j));
/*     */     
/*     */     try {
/* 180 */       if (future == null || future.isDone()) {
/* 181 */         b b = this.h.get(Integer.valueOf(j));
/*     */         
/* 183 */         if (b == null) {
/* 184 */           b = new b(parame, this.b, this);
/*     */           
/* 186 */           this.h.put(Integer.valueOf(j), b);
/*     */           
/* 188 */           StringBuilder stringBuilder = new StringBuilder();
/* 189 */           stringBuilder.append("Lote ").append(parame.bo()).append(" entrou em disputa com valor mínimo de R$ ")
/* 190 */             .append(y.a("###,###,###,##0.0000").format(parame.l()));
/*     */           
/* 192 */           l(stringBuilder.toString());
/*     */         } 
/*     */         
/* 195 */         b.b(parami);
/*     */         
/* 197 */         Future<?> future1 = this.a.submit((Runnable)b);
/* 198 */         this.g.put(Integer.valueOf(j), future1);
/*     */       } 
/* 200 */     } catch (Exception exception) {
/* 201 */       a.warn("[Item {}] Failed to start thread from item", parame.bo(), exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> b(e parame) throws d {
/* 207 */     b b = this.h.get(Integer.valueOf(parame.v()));
/* 208 */     if (b == null) {
/* 209 */       b = new b(parame, this.b, this);
/*     */     }
/*     */     
/* 212 */     return b.e();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean b(e parame, double paramDouble) {
/* 217 */     b b = this.h.get(Integer.valueOf(parame.v()));
/* 218 */     if (b == null) {
/* 219 */       return false;
/*     */     }
/*     */     
/* 222 */     return b.a(new h(paramDouble), true);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void T() {
/* 227 */     a().I().forEach(parame -> {
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
/* 239 */     super.g(parame);
/*     */     
/* 241 */     this.h.remove(Integer.valueOf(parame.v()));
/* 242 */     this.g.remove(Integer.valueOf(parame.v()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void S() {
/*     */     try {
/* 249 */       String str = this.b.f(a().v());
/* 250 */       if (!str.isEmpty()) {
/* 251 */         Document document = Jsoup.parse(str);
/* 252 */         Elements elements = document.select("tbody[id=listaLotesTbody]");
/*     */         
/* 254 */         Map<Integer, e> map = a(elements, g.aD);
/* 255 */         if (!map.isEmpty()) {
/* 256 */           a(this.b.f(a().v(), a(map)), map);
/*     */         }
/*     */         
/* 259 */         map = a(elements, g.aA);
/* 260 */         if (!map.isEmpty()) {
/* 261 */           a(this.b.g(a().v(), a(map)), map);
/*     */         }
/*     */         
/* 264 */         map = a(elements, g.aC);
/* 265 */         if (!map.isEmpty()) {
/* 266 */           a(this.b.h(a().v(), a(map)), map);
/*     */         }
/*     */         
/* 269 */         map = a(elements, g.aB);
/* 270 */         if (!map.isEmpty()) {
/* 271 */           a(this.b.i(a().v(), a(map)), map);
/*     */         }
/*     */       } 
/* 274 */     } catch (Exception exception) {
/* 275 */       a.error("Failed to get closed items", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void a(e parame, Map<Integer, e> paramMap) {
/* 280 */     e(parame.k());
/* 281 */     if (parame.getData().isEmpty()) {
/*     */       return;
/*     */     }
/*     */     
/* 285 */     i i = new i(parame.getData());
/* 286 */     i.c("response").forEach(paramObject -> {
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
/* 313 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 314 */     paramElements.select("label[id*=lbFaseLote]").stream()
/* 315 */       .filter(paramElement -> paramElement.text().trim().equals(paramg.getValue()))
/* 316 */       .forEach(paramElement -> {
/*     */           int i = Integer.parseInt(paramElement.id().replace("lbFaseLote", "").trim());
/*     */           
/*     */           e e = a(i);
/*     */           if (e != null) {
/*     */             paramMap.put(Integer.valueOf(i), e);
/*     */           }
/*     */         });
/* 324 */     return (Map)hashMap;
/*     */   }
/*     */   
/*     */   private String a(Map<Integer, e> paramMap) {
/* 328 */     StringJoiner stringJoiner = new StringJoiner(",");
/* 329 */     for (e e : paramMap.values()) {
/* 330 */       stringJoiner.add(Integer.toString(e.v()));
/*     */     }
/*     */     
/* 333 */     return String.join("", new CharSequence[] { "[", stringJoiner.toString(), "]" });
/*     */   }
/*     */   
/*     */   protected String y() {
/* 337 */     return this.af;
/*     */   }
/*     */ 
/*     */   
/*     */   protected a a() {
/* 342 */     return (a)super.a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void a(f paramf, List<h> paramList) {}
/*     */ 
/*     */   
/*     */   public b a() {
/* 351 */     return (b)super.a();
/*     */   }
/*     */ 
/*     */   
/*     */   public b a() {
/* 356 */     return (b)super.a();
/*     */   }
/*     */   
/*     */   public br.com.arremate.j.c b() {
/* 360 */     return this.b;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\j\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */