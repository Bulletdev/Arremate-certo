/*     */ package br.com.arremate.d.b;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.f;
/*     */ import br.com.arremate.f.t;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.g.d;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.a.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.l.q.c.f;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Timer;
/*     */ import java.util.TimerTask;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.TimeUnit;
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
/*     */ public class c
/*     */   extends g
/*     */ {
/*     */   private final Map<Integer, Future> i;
/*     */   private final Map<Integer, b> b;
/*     */   private final ExecutorService executor;
/*     */   private Map<Integer, Boolean> j;
/*     */   private String T;
/*     */   private String U;
/*     */   private long j;
/*     */   private Timer a;
/*     */   
/*     */   public c(b paramb, a parama, boolean paramBoolean) {
/*  48 */     super(paramb, (i)parama);
/*  49 */     a(new a(this, parama));
/*  50 */     this.executor = Executors.newCachedThreadPool();
/*  51 */     this.i = new HashMap<>();
/*  52 */     this.b = new HashMap<>();
/*  53 */     this.j = new HashMap<>();
/*     */     
/*  55 */     if (paramBoolean) {
/*  56 */       a().b(this);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void ab() {
/*  62 */     super.ab();
/*     */     
/*  64 */     if (this.a != null) {
/*  65 */       this.a.cancel();
/*  66 */       this.a = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected t b() {
/*  72 */     t t = super.b();
/*  73 */     if (t == t.c) {
/*  74 */       an();
/*     */     }
/*     */     
/*  77 */     return t;
/*     */   }
/*     */ 
/*     */   
/*     */   public t a() {
/*     */     try {
/*  83 */       e e = a().b(a().bo());
/*  84 */       String str = e.getData();
/*     */       
/*  86 */       if (!str.isEmpty()) {
/*  87 */         e(e.k());
/*  88 */         String str1 = e(Jsoup.parse(str));
/*     */         
/*  90 */         if (!str1.isEmpty()) {
/*  91 */           k(str1);
/*     */           
/*  93 */           switch (str1) {
/*     */             case "etapa de lances":
/*     */             case "direito de preferência me-epp":
/*     */             case "etapa de negociação ativa":
/*     */             case "análise da aceitabilidade do preço":
/*     */             case "etapa de negociação ativa / redistribuição de itens":
/*  99 */               return t.c;
/*     */             case "pregão suspenso":
/*     */             case "aguardando reativação do pregão":
/*     */             case "aguardando abertura sessão pública-retomada":
/*     */             case "aguardando prazo abertura sessão pública-retomada":
/* 104 */               return t.e;
/*     */             case "etapa de habilitação":
/*     */             case "homologação":
/*     */             case "análise de recursos":
/*     */             case "encerrado com vencedor":
/*     */             case "prazo para memoriais":
/* 110 */               return t.d;
/*     */           } 
/* 112 */           return t.b;
/*     */         }
/*     */       
/* 115 */       } else if (!D() && !E()) {
/*     */         
/* 117 */         if (isRunning() && a() != null && !a().isRunning()) {
/* 118 */           a().z();
/*     */         }
/*     */       } 
/* 121 */     } catch (Exception exception) {
/* 122 */       a.error("Erro ao capturar situação do pregão", exception);
/*     */     } 
/*     */     
/* 125 */     return t.b;
/*     */   }
/*     */   
/*     */   String e(Document paramDocument) {
/* 129 */     Elements elements = paramDocument.select("span[id=ctl00_wucOcFicha_txtStatus]");
/*     */     
/* 131 */     return (elements != null && !elements.isEmpty()) ? elements
/* 132 */       .first().text().toLowerCase() : "";
/*     */   }
/*     */ 
/*     */   
/*     */   private void an() {
/* 137 */     this.a = new Timer("CountdownTimer");
/* 138 */     this.a.schedule(a(), 1000L, 1000L);
/*     */   }
/*     */   
/*     */   private TimerTask a() {
/* 142 */     return new TimerTask(this)
/*     */       {
/*     */         public void run() {
/* 145 */           this.a.a().B().forEach(param1g -> {
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
/*     */   public void R() {
/*     */     try {
/*     */       Elements elements1;
/*     */       String str4, str5;
/* 164 */       e e = a().b(a().bo());
/* 165 */       String str1 = e.getData();
/* 166 */       e(e.k());
/*     */       
/* 168 */       if (str1.isEmpty()) {
/* 169 */         if (!D() && !E() && !a().isRunning()) {
/* 170 */           while (a().z() != 1 && isRunning()) {
/* 171 */             a(f.i);
/* 172 */             a.warn("Tentativa falha de login thread da licitacao");
/*     */           } 
/*     */         }
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 179 */       Document document = Jsoup.parse(str1);
/* 180 */       this.T = e(document);
/* 181 */       String str2 = f(document);
/* 182 */       String str3 = g(document);
/* 183 */       this.j = TimeUnit.MINUTES.toMillis(Integer.parseInt(str2)) + TimeUnit.SECONDS.toMillis(Integer.parseInt(str3));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 188 */       if (a().a() == u.b) {
/* 189 */         elements1 = document.select("table[id=ctl00_conteudo_loteGridItens_grdLote]");
/* 190 */         str4 = "th";
/* 191 */         str5 = "agrupamento";
/*     */       } else {
/* 193 */         elements1 = document.select("table[id=ctl00_conteudo_dg]");
/* 194 */         str4 = "td";
/* 195 */         str5 = "item";
/*     */       } 
/*     */ 
/*     */       
/* 199 */       if (elements1 == null || elements1.isEmpty()) {
/*     */         return;
/*     */       }
/*     */       
/* 203 */       Elements elements2 = elements1.first().select("tr");
/* 204 */       Elements elements3 = elements2.first().select(str4);
/* 205 */       elements2.remove(0);
/*     */       
/* 207 */       byte b1 = 2;
/* 208 */       byte b2 = -1;
/* 209 */       byte b3 = -1;
/*     */ 
/*     */       
/* 212 */       for (byte b4 = 2; b4 < elements3.size(); b4++) {
/* 213 */         String str = elements3.get(b4).text().toLowerCase();
/*     */         
/* 215 */         if (str.contains(str5)) {
/* 216 */           b1 = b4;
/* 217 */         } else if (str.contains("melhor oferta")) {
/* 218 */           b2 = b4;
/* 219 */         } else if (str.contains("situação")) {
/* 220 */           b3 = b4;
/*     */         } 
/*     */       } 
/*     */       
/* 224 */       e = a().e(a().bo());
/* 225 */       e(e.k());
/* 226 */       document = Jsoup.parse(e.getData());
/*     */       
/* 228 */       Elements elements4 = document.select("table[id=ctl00_conteudo_ItensHabilitados] > tbody > tr");
/* 229 */       byte b5 = -1;
/* 230 */       byte b6 = -1;
/* 231 */       byte b7 = -1;
/* 232 */       byte b8 = -1;
/*     */       
/* 234 */       if (!elements4.isEmpty()) {
/* 235 */         Elements elements = elements4.first().select("th");
/*     */         
/* 237 */         for (byte b = 0; b < elements.size(); b++) {
/* 238 */           String str = elements.get(b).text().toLowerCase();
/*     */           
/* 240 */           if (str.contains("intervalo mínimo entre lances")) {
/* 241 */             b5 = b;
/* 242 */           } else if (str.contains(str5)) {
/* 243 */             b6 = b;
/* 244 */           } else if (str.contains("melhor oferta")) {
/* 245 */             b7 = b;
/* 246 */           } else if (str.contains("situação")) {
/* 247 */             b8 = b;
/*     */           } 
/*     */         } 
/*     */         
/* 251 */         elements4.remove(0);
/*     */       } 
/*     */       
/* 254 */       for (Element element : elements2) {
/* 255 */         String str = element.select("td").get(b1).text();
/* 256 */         e e1 = a(str);
/*     */         
/* 258 */         if (e1 != null) {
/* 259 */           Element element1 = null;
/*     */           
/* 261 */           for (Element element2 : elements4) {
/* 262 */             if (str.equals(element2.select("td").get(b6).text())) {
/* 263 */               element1 = element2;
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/* 268 */           a(e1, element, element1, b1, b2, b3, b5, b7, b8);
/*     */         }
/*     */       
/*     */       }
/*     */     
/* 273 */     } catch (Exception exception) {
/* 274 */       a.info("Failed to load items data", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   String f(Document paramDocument) {
/* 279 */     Elements elements = paramDocument.select("input[id=ctl00_wucOcFicha_hidMinutoRet]");
/*     */     
/* 281 */     return (elements != null && !elements.isEmpty()) ? elements
/* 282 */       .first().attr("value") : "0";
/*     */   }
/*     */ 
/*     */   
/*     */   String g(Document paramDocument) {
/* 287 */     Elements elements = paramDocument.select("input[id=ctl00_wucOcFicha_hidSegundoRet]");
/*     */     
/* 289 */     return (elements != null && !elements.isEmpty()) ? elements
/* 290 */       .first().attr("value") : "0";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(e parame, Element paramElement1, Element paramElement2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 297 */     int i = parame.v();
/*     */     
/*     */     try {
/* 300 */       Future future = this.i.get(Integer.valueOf(i));
/*     */       
/* 302 */       if (future == null || future.isDone()) {
/* 303 */         b b = this.b.get(Integer.valueOf(i));
/*     */         
/* 305 */         if (parame.br()) {
/* 306 */           if (b != null) {
/* 307 */             this.b.remove(Integer.valueOf(i));
/*     */           }
/*     */           
/*     */           return;
/*     */         } 
/*     */         
/* 313 */         if (b == null) {
/* 314 */           b = new b(parame, a(), this);
/* 315 */           this.b.put(Integer.valueOf(i), b);
/*     */         } 
/*     */         
/* 318 */         b.a(paramElement1);
/* 319 */         b.b(paramElement2);
/* 320 */         b.y(paramInt1);
/* 321 */         b.z(paramInt2);
/* 322 */         b.A(paramInt3);
/* 323 */         b.C(paramInt4);
/* 324 */         b.D(paramInt5);
/* 325 */         b.B(paramInt6);
/* 326 */         Future<?> future1 = this.executor.submit((Runnable)b);
/* 327 */         this.i.put(Integer.valueOf(i), future1);
/*     */       } 
/* 329 */     } catch (Exception exception) {
/* 330 */       a.warn("Failed to start thread from item " + Integer.toString(i), exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> b(e parame) throws d {
/* 336 */     int i = parame.v();
/* 337 */     b b = this.b.get(Integer.valueOf(i));
/*     */     
/* 339 */     if (b == null) {
/* 340 */       b = new b(parame, a(), this);
/*     */     }
/*     */     
/* 343 */     return b.i();
/*     */   }
/*     */ 
/*     */   
/*     */   public void S() {
/* 348 */     R();
/*     */     
/* 350 */     this.i.entrySet().stream().map(paramEntry -> (Future)paramEntry.getValue())
/* 351 */       .forEachOrdered(paramFuture -> {
/*     */           try {
/*     */             paramFuture.get();
/* 354 */           } catch (Exception exception) {}
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void a(f paramf, List<h> paramList) {
/*     */     try {
/* 362 */       if (paramf.h().bb()) {
/* 363 */         if (paramList == null || paramList.isEmpty()) {
/* 364 */           b b = this.b.get(Integer.valueOf(paramf.b().v()));
/*     */           
/* 366 */           if (b == null) {
/* 367 */             b = new b(paramf.b(), a(), this);
/*     */           }
/*     */           
/* 370 */           paramList = b.e();
/*     */         } 
/*     */         
/* 373 */         paramList.stream().filter(paramh -> paramh.bb())
/* 374 */           .findFirst().ifPresent(paramh -> {
/*     */               h h1 = paramf.h();
/*     */               h1.c(paramh.b());
/*     */               h1.q(paramh.m());
/*     */               h1.E(paramh.ay());
/*     */             });
/*     */       } 
/* 381 */     } catch (Exception exception) {
/* 382 */       a.warn("Failed to update closed item " + paramf.b().bo(), exception);
/*     */     } 
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
/*     */   public boolean b(e parame, double paramDouble) {
/* 395 */     if (parame == null || (!parame.bt() && !parame.bx())) {
/* 396 */       return false;
/*     */     }
/*     */     
/* 399 */     h h = new h(paramDouble);
/* 400 */     b b = this.b.get(Integer.valueOf(parame.v()));
/*     */     
/* 402 */     if (b == null) {
/* 403 */       a.info("Não foi possível enviar lance manual pois o item não foi encontrado em disputa");
/* 404 */       return false;
/*     */     } 
/*     */     
/* 407 */     return b.a(h, true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void T() {
/* 413 */     a().H().forEach(parame -> {
/*     */           b b = this.b.get(Integer.valueOf(parame.v()));
/*     */           if (b != null) {
/*     */             int[] arrayOfInt = b.a();
/*     */             parame.ah(arrayOfInt[0]);
/*     */             parame.ai(arrayOfInt[1]);
/*     */           } 
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final a a() {
/* 426 */     return (a)super.a();
/*     */   }
/*     */   
/*     */   String q() {
/* 430 */     return this.T;
/*     */   }
/*     */   
/*     */   long d() {
/* 434 */     return this.j;
/*     */   }
/*     */   
/*     */   public String r() {
/* 438 */     return this.U;
/*     */   }
/*     */   
/*     */   public void m(String paramString) {
/* 442 */     this.U = paramString;
/*     */   }
/*     */   
/*     */   public Map<Integer, Boolean> e() {
/* 446 */     return this.j;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\b\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */