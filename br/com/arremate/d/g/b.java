/*     */ package br.com.arremate.d.g;
/*     */ 
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.f.s;
/*     */ import br.com.arremate.f.t;
/*     */ import br.com.arremate.g.d;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.c.c;
/*     */ import br.com.arremate.j.c.d;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.k.b.g;
/*     */ import br.com.arremate.l.e.c;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.l.q.b.i;
/*     */ import br.com.arremate.l.q.c.f;
/*     */ import br.com.arremate.m.n;
/*     */ import br.com.arremate.m.y;
/*     */ import br.com.arremate.n.n;
/*     */ import java.text.DecimalFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
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
/*     */ public class b
/*     */   extends g
/*     */ {
/*     */   private final ExecutorService executor;
/*     */   private final Map<Integer, Future> m;
/*     */   private final Map<Integer, a> n;
/*     */   private final g b;
/*     */   
/*     */   public b(br.com.arremate.d.b paramb, i parami, boolean paramBoolean) {
/*  53 */     super(paramb, parami);
/*     */     
/*  55 */     this.executor = Executors.newCachedThreadPool();
/*  56 */     this.m = new HashMap<>();
/*  57 */     this.n = new HashMap<>();
/*  58 */     this.b = new g();
/*     */     
/*  60 */     this.d = Calendar.getInstance();
/*     */     
/*  62 */     if (paramBoolean) {
/*  63 */       this.d.setTime(a().g().getTime());
/*  64 */       this.d.add(12, -1);
/*  65 */       a().a(this);
/*     */     } 
/*     */   }
/*     */   private final Calendar d; private boolean l; private long q; private long t; private Timer a;
/*     */   private void an() {
/*  70 */     if (this.a != null) {
/*     */       return;
/*     */     }
/*     */     
/*  74 */     aM();
/*     */     
/*  76 */     i i = a();
/*  77 */     this.a = new Timer("CountdownTimer");
/*  78 */     this.a.schedule(new TimerTask(this, i) {
/*  79 */           private int W = 0;
/*     */ 
/*     */           
/*     */           public void run() {
/*  83 */             if (this.W < 60) {
/*  84 */               this.a.a().B().parallelStream().forEach(param1g -> {
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
/*  95 */               this.W++;
/*     */             } else {
/*  97 */               b.a(this.a);
/*  98 */               this.W = 0;
/*     */             } 
/*     */           }
/*     */         }1000L, 1000L);
/*     */   }
/*     */   
/*     */   private void aM() {
/* 105 */     long l1 = System.currentTimeMillis();
/* 106 */     Calendar calendar = y.i();
/* 107 */     l1 = System.currentTimeMillis() - l1;
/* 108 */     if (l1 >= 1000L) {
/* 109 */       calendar.add(14, (int)l1);
/*     */     }
/*     */     
/* 112 */     long l2 = a().g().getTimeInMillis();
/* 113 */     long l3 = l2 - calendar.getTimeInMillis();
/* 114 */     if (l3 > 0L) {
/* 115 */       a().B().parallelStream().forEach(paramg -> paramg.x(paramLong));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public t a() {
/* 123 */     return a(a());
/*     */   }
/*     */   
/*     */   public t a(c paramc) {
/* 127 */     Calendar calendar = n.i();
/* 128 */     if (calendar.compareTo(paramc.h()) < 0)
/* 129 */       return t.b; 
/* 130 */     if (calendar.compareTo(paramc.g()) > 0) {
/* 131 */       return t.d;
/*     */     }
/*     */     
/* 134 */     return t.c;
/*     */   }
/*     */ 
/*     */   
/*     */   public void R() {
/*     */     try {
/* 140 */       an();
/*     */       
/* 142 */       Calendar calendar = y.i();
/* 143 */       this.q = (calendar.get(13) * 1000);
/*     */       
/* 145 */       boolean bool = (this.d.compareTo(calendar) < 0) ? true : false;
/* 146 */       f(bool);
/*     */       
/* 148 */       if (this.q + this.t >= 61000L) {
/* 149 */         boolean bool1 = (bool && a().L().stream().anyMatch(parame -> parame.b().aH())) ? true : false;
/* 150 */         if (this.t > 2000L && bool1) {
/* 151 */           b("Enviar lance antes da virada do minuto devido a lentidão no portal", this.t);
/*     */         }
/*     */       } 
/* 154 */     } catch (Exception exception) {
/* 155 */       a.error("[#004] carregarItens()", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void f(boolean paramBoolean) {
/*     */     try {
/* 161 */       e e = a().h(a().v());
/* 162 */       if (e.O()) {
/* 163 */         throw new d(e.k());
/*     */       }
/*     */       
/* 166 */       String str = e.getData();
/* 167 */       if (str.trim().isEmpty()) {
/*     */         return;
/*     */       }
/*     */       
/* 171 */       if (str.contains("Cotação/Dispensa Eletrônica não disponível para envio de lances")) {
/* 172 */         a().B().parallelStream().forEach(paramg -> paramg.N(g.s.getValue()));
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 178 */       this.t = e.k();
/* 179 */       e(this.t);
/*     */       
/* 181 */       this.b.t(this.t);
/* 182 */       long l = this.b.s();
/*     */       
/* 184 */       boolean bool = (this.q + l > 54000L && this.q + this.t < 62000L) ? true : false;
/* 185 */       this.l = (paramBoolean && bool);
/* 186 */       t(str);
/* 187 */     } catch (d d) {
/* 188 */       s("capturar as informações da disputa para o envio de lance");
/* 189 */     } catch (Exception exception) {
/* 190 */       a.error("[#003] carregaDadosItens()", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void t(String paramString) {
/*     */     try {
/* 196 */       if (paramString.contains("Ocorreu um erro na aplicação. Se o erro persistir, contate o administrador do sistema")) {
/*     */         return;
/*     */       }
/*     */       
/* 200 */       Document document = Jsoup.parse(paramString);
/* 201 */       Elements elements = document.select("table[class=td] > tbody");
/* 202 */       Element element = elements.get(2);
/*     */       
/* 204 */       if (element != null) {
/* 205 */         Elements elements1 = element.select("tr[class=tex3]");
/*     */         
/* 207 */         for (byte b1 = 0; b1 < elements1.size(); b1++) {
/* 208 */           Elements elements2 = elements1.get(b1).select("td");
/* 209 */           String str = elements2.get(0).text().trim();
/* 210 */           e e = a(str);
/* 211 */           if (e != null)
/*     */           {
/*     */ 
/*     */             
/* 215 */             a(e, elements2); } 
/*     */         } 
/*     */       } 
/* 218 */     } catch (Exception exception) {
/* 219 */       a.error("[#002] processarDadosDisputa()", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void a(e parame, Elements paramElements) {
/* 224 */     if (parame.br() && isRunning()) {
/*     */       return;
/*     */     }
/*     */     
/* 228 */     int i = parame.v();
/*     */     
/*     */     try {
/* 231 */       Future future = this.m.get(Integer.valueOf(i));
/* 232 */       a a = this.n.get(Integer.valueOf(i));
/*     */       
/* 234 */       if (future != null && !future.isDone())
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 240 */         if (a.a() != null && a.a().doubleValue() >= parame.f()) {
/* 241 */           a.info("Cancela thread do item {} com valor antigo", parame.bo());
/* 242 */           future.cancel(true);
/* 243 */           future = null;
/*     */         } 
/*     */       }
/*     */       
/* 247 */       if (future == null || future.isDone()) {
/* 248 */         if (a == null) {
/* 249 */           a = new a(parame, (i)a(), this);
/* 250 */           this.n.put(Integer.valueOf(i), a);
/*     */           
/* 252 */           String str1 = a.l();
/* 253 */           DecimalFormat decimalFormat = y.a("###,###,###,##0.0000");
/* 254 */           String str2 = decimalFormat.format(parame.l());
/*     */           
/* 256 */           StringBuilder stringBuilder = new StringBuilder();
/* 257 */           stringBuilder.append(str1).append(" ").append(parame.bo()).append(" entrou em disputa com valor mínimo de R$ ").append(str2);
/* 258 */           l(stringBuilder.toString());
/*     */         } 
/*     */         
/* 261 */         a.a(paramElements);
/* 262 */         a.e(this.l);
/* 263 */         Future<?> future1 = this.executor.submit((Runnable)a);
/* 264 */         this.m.put(Integer.valueOf(i), future1);
/*     */       } 
/* 266 */     } catch (Exception exception) {
/* 267 */       a.warn("Failed to start thread from item {}", Integer.valueOf(i), exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void b(String paramString, long paramLong) {
/* 272 */     double d = paramLong / 1000.0D;
/* 273 */     DecimalFormat decimalFormat = new DecimalFormat("#.##");
/*     */     
/* 275 */     StringBuilder stringBuilder = new StringBuilder("Não foi possível ");
/* 276 */     stringBuilder.append(paramString);
/* 277 */     stringBuilder.append(". Motivo: Tempo de ");
/* 278 */     stringBuilder.append(decimalFormat.format(d));
/* 279 */     stringBuilder.append("s para a captura das informações.");
/*     */     
/* 281 */     l(stringBuilder.toString());
/* 282 */     l(n.a().longValue());
/*     */   }
/*     */   
/*     */   private void s(String paramString) {
/* 286 */     if (a().ac() || a().ab()) {
/*     */       return;
/*     */     }
/*     */     
/* 290 */     StringBuilder stringBuilder = new StringBuilder("Não foi possível ");
/* 291 */     stringBuilder.append(paramString);
/* 292 */     stringBuilder.append(". Motivo: Tempo limite de ");
/* 293 */     stringBuilder.append(TimeUnit.MILLISECONDS.toSeconds(c.DEFAULT_TIMEOUT));
/* 294 */     stringBuilder.append("s para captura das informações excedido.");
/*     */     
/* 296 */     l(stringBuilder.toString());
/* 297 */     l(n.a().longValue());
/*     */   }
/*     */   
/*     */   public boolean c(e parame, double paramDouble) {
/* 301 */     h h = new h(paramDouble);
/* 302 */     a a = new a(parame, (i)a(), this);
/* 303 */     return a.a(h, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> b(e parame) {
/* 308 */     ArrayList<h> arrayList = new ArrayList();
/*     */ 
/*     */     
/*     */     try {
/* 312 */       String str = a().i(parame.a().v()).getData();
/* 313 */       Document document = Jsoup.parse(str);
/* 314 */       Elements elements = document.select("table").first().select("> tbody > tr > td > table > tbody > tr");
/*     */       
/* 316 */       boolean bool = false;
/*     */ 
/*     */       
/* 319 */       HashMap<Object, Object> hashMap = new HashMap<>();
/*     */       
/* 321 */       for (Element element : elements) {
/* 322 */         if (element.text().trim().equals("Item: " + parame.bo())) {
/* 323 */           bool = true; continue;
/* 324 */         }  if (bool) {
/* 325 */           if (element.text().contains("Observação: Participaram deste item os fornecedores abaixo relacionados, com suas respectivas propostas:")) {
/*     */             
/* 327 */             Elements elements1 = element.select("> td > table > tbody > tr");
/*     */             
/* 329 */             for (byte b1 = 1; b1 < elements1.size(); b1++) {
/* 330 */               Elements elements2 = elements1.get(b1).select("> td");
/* 331 */               hashMap.put(elements2.get(1).text(), elements2);
/*     */             }  continue;
/* 333 */           }  if (element.text().contains("Propostas/Lances (5 melhores)")) {
/* 334 */             Elements elements1 = element.select("td > table").first().select("> tbody > tr[bgcolor=#ffffff]");
/*     */             
/* 336 */             byte b1 = 1;
/*     */             
/* 338 */             boolean bool1 = false;
/* 339 */             if (parame.a().k()) {
/* 340 */               bool1 = true;
/*     */             }
/*     */             
/* 343 */             for (Element element1 : elements1) {
/* 344 */               h h = new h();
/* 345 */               String str1 = element1.select("td").last().text().replace(" ", " ");
/* 346 */               SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
/* 347 */               Date date = simpleDateFormat.parse(str1);
/* 348 */               h.c(date);
/*     */               
/* 350 */               String str2 = element1.select("td").get(bool1).text().replace(".", "").replace(",", ".");
/* 351 */               h.q(Double.parseDouble(str2));
/*     */               
/*     */               try {
/* 354 */                 String str3 = element1.select("td").get(1).text();
/* 355 */                 long l = Long.parseLong(str3.replaceAll("\\D", ""));
/* 356 */                 boolean bool2 = (a().a().x() == l) ? true : false;
/* 357 */                 h.A(bool2);
/* 358 */               } catch (NumberFormatException numberFormatException) {
/* 359 */                 a.warn("#020", numberFormatException);
/*     */               } 
/*     */               
/* 362 */               h.l(b1);
/* 363 */               b1++;
/*     */               
/*     */               try {
/* 366 */                 if (n.bQ()) {
/* 367 */                   String str3 = element1.select("td").get(1).text();
/* 368 */                   h.D(str3);
/* 369 */                   h.E(((Elements)hashMap.get(str3)).get(0).text());
/* 370 */                   h.al(((Elements)hashMap.get(str3)).get(4).text());
/*     */                 } 
/* 372 */               } catch (Exception exception) {
/* 373 */                 a.warn("[#012] Problemas ao capturar fornecedores", exception);
/*     */               } 
/*     */               
/* 376 */               arrayList.add(h);
/*     */             } 
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/* 383 */     } catch (Exception exception) {
/* 384 */       a.error("[#009] getMelhoresLances()", exception);
/*     */     } 
/*     */     
/* 387 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public void S() {
/* 392 */     for (e e : a().L()) {
/* 393 */       List<h> list = b(e);
/* 394 */       if (!list.isEmpty()) {
/* 395 */         e.h(list.get(0));
/* 396 */         e.N(g.s.getValue());
/*     */         
/* 398 */         if (((h)list.get(0)).bb()) {
/* 399 */           e.h(((h)list.get(0)).m());
/*     */           
/* 401 */           if (list.size() > 1 && ((h)list.get(1)).m() == e.f()) {
/* 402 */             e.a(s.b);
/*     */           } else {
/* 404 */             e.a(s.a);
/*     */           } 
/*     */         } else {
/* 407 */           Optional<h> optional = list.stream().filter(paramh -> paramh.bb()).findFirst();
/* 408 */           if (optional.isPresent()) {
/* 409 */             e.h(((h)optional.get()).m());
/*     */           }
/*     */           
/* 412 */           e.a(s.c);
/*     */         } 
/*     */         
/* 415 */         int i = a().indexOf(e.v());
/* 416 */         if (i >= 0) {
/* 417 */           a().fireTableRowsUpdated(i, i);
/*     */         }
/*     */         
/* 420 */         a(e, list);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void g(e parame) {
/* 427 */     if (!b(parame.v())) {
/* 428 */       super.g(parame);
/* 429 */       this.n.remove(Integer.valueOf(parame.v()));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void ab() {
/* 435 */     super.ab();
/*     */     
/* 437 */     if (this.a != null) {
/* 438 */       this.a.cancel();
/* 439 */       this.a = null;
/*     */     } 
/*     */     
/* 442 */     if (this.executor != null) {
/* 443 */       this.executor.shutdown();
/*     */     }
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
/* 457 */     return (c)super.a();
/*     */   }
/*     */ 
/*     */   
/*     */   public final d a() {
/* 462 */     return (d)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\g\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */