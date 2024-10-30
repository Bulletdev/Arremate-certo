/*     */ package br.com.arremate.d.f;
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
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.q.b.e;
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
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ public class b extends g {
/*     */   private final ExecutorService executor;
/*     */   private final Map<Integer, Future> m;
/*     */   private final Map<Integer, a> n;
/*     */   private final g a;
/*     */   private boolean l;
/*     */   private long s;
/*     */   private long t;
/*     */   
/*     */   public b(br.com.arremate.d.b paramb, i parami, boolean paramBoolean) {
/*  48 */     super(paramb, parami);
/*  49 */     j(500L);
/*     */     
/*  51 */     this.executor = Executors.newCachedThreadPool();
/*  52 */     this.m = new HashMap<>();
/*  53 */     this.n = new HashMap<>();
/*  54 */     this.a = new g();
/*     */     
/*  56 */     if (paramBoolean) {
/*  57 */       a().a(this);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public t a() {
/*  63 */     return a(a().v());
/*     */   }
/*     */   
/*     */   public t a(int paramInt) {
/*  67 */     t t = t.c;
/*     */     
/*     */     try {
/*  70 */       e e = a().h(paramInt);
/*  71 */       e(e.k());
/*  72 */       String str = e.getData();
/*     */ 
/*     */       
/*  75 */       if (!str.isEmpty()) {
/*  76 */         return a(str);
/*     */       }
/*  78 */     } catch (Exception exception) {
/*  79 */       a.error("[#006] capturarStatusPregao()", exception);
/*     */     } 
/*     */     
/*  82 */     return t;
/*     */   }
/*     */   
/*     */   private t a(String paramString) {
/*  86 */     if (paramString.contains("Cotação/Dispensa Eletrônica não disponível para envio de lances")) {
/*  87 */       return t.d;
/*     */     }
/*     */     
/*  90 */     return t.c;
/*     */   }
/*     */ 
/*     */   
/*     */   public void R() {
/*     */     try {
/*  96 */       Calendar calendar = y.i();
/*  97 */       this.s = (calendar.get(13) * 1000);
/*     */       
/*  99 */       aO();
/*     */       
/* 101 */       if (this.s + this.t >= 61000L) {
/* 102 */         boolean bool = a().L().stream().anyMatch(parame -> 
/* 103 */             ((parame.b().aG() || parame.b().aH()) && parame.bu()));
/*     */ 
/*     */         
/* 106 */         if (this.t > 2000L && bool) {
/* 107 */           a("Enviar lance antes da virada do minuto devido a lentidão no portal", this.t);
/*     */         }
/*     */       } 
/* 110 */     } catch (Exception exception) {
/* 111 */       a.error("[#004] carregarItens()", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void aO() {
/*     */     try {
/* 117 */       e e = a().h(a().v());
/* 118 */       this.t = e.k();
/* 119 */       e(this.t);
/*     */       
/* 121 */       if (e.O()) {
/* 122 */         throw new d(e.k());
/*     */       }
/*     */       
/* 125 */       String str = e.getData();
/* 126 */       if (str.trim().isEmpty()) {
/*     */         return;
/*     */       }
/*     */       
/* 130 */       if (a(str).equals(t.d)) {
/* 131 */         a().B().parallelStream().forEach(paramg -> paramg.N(g.s.getValue()));
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 137 */       this.a.t(this.t);
/* 138 */       long l = this.a.s();
/* 139 */       this.l = (this.s + l > 54000L && this.s + this.t < 61000L);
/* 140 */       r(str);
/* 141 */     } catch (d d) {
/* 142 */       s("capturar as informações da disputa para o envio de lance");
/* 143 */     } catch (Exception exception) {
/* 144 */       a.error("[#003] carregaDadosItens()", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void r(String paramString) {
/*     */     try {
/* 150 */       if (paramString.contains("Ocorreu um erro na aplicação. Se o erro persistir, contate o administrador do sistema")) {
/*     */         return;
/*     */       }
/*     */       
/* 154 */       Document document = Jsoup.parse(paramString);
/* 155 */       Elements elements = document.select("table[class=td] > tbody");
/* 156 */       Element element1 = elements.get(2);
/* 157 */       Element element2 = elements.get(1).select("tr[class=tex3] > td").first();
/*     */       
/* 159 */       if (element1 != null) {
/* 160 */         Elements elements1 = element1.select("tr[class=tex3]");
/*     */         
/* 162 */         for (byte b1 = 0; b1 < elements1.size(); b1++) {
/* 163 */           Elements elements2 = elements1.get(b1).select("td");
/* 164 */           String str = elements2.get(0).text().trim();
/* 165 */           e e = a(str);
/* 166 */           if (e != null)
/*     */           {
/*     */ 
/*     */             
/* 170 */             a(e, elements2, element2); } 
/*     */         } 
/*     */       } 
/* 173 */     } catch (Exception exception) {
/* 174 */       a.error("[#002] processarDadosDisputa()", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void a(e parame, Elements paramElements, Element paramElement) {
/* 179 */     if (parame.br() && isRunning()) {
/*     */       return;
/*     */     }
/*     */     
/* 183 */     int i = parame.v();
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
/*     */     try {
/* 200 */       Future future = this.m.get(Integer.valueOf(i));
/* 201 */       if (future == null || future.isDone()) {
/* 202 */         a a = this.n.get(Integer.valueOf(i));
/* 203 */         if (a == null) {
/* 204 */           a = new a(parame, (i)a(), this);
/*     */ 
/*     */           
/* 207 */           if (t.c.equals(c())) {
/* 208 */             this.n.put(Integer.valueOf(i), a);
/*     */             
/* 210 */             String str1 = a.l();
/* 211 */             DecimalFormat decimalFormat = y.a("###,###,###,##0.0000");
/* 212 */             String str2 = decimalFormat.format(parame.l());
/*     */             
/* 214 */             StringBuilder stringBuilder = new StringBuilder();
/* 215 */             stringBuilder.append(str1).append(" ").append(parame.bo()).append(" entrou em disputa com valor mínimo de R$ ").append(str2);
/* 216 */             l(stringBuilder.toString());
/*     */           } 
/*     */         } 
/*     */         
/* 220 */         a.a(paramElements);
/* 221 */         a.g(paramElement);
/* 222 */         a.e(this.l);
/* 223 */         Future<?> future1 = this.executor.submit((Runnable)a);
/* 224 */         this.m.put(Integer.valueOf(i), future1);
/*     */       } 
/* 226 */     } catch (Exception exception) {
/* 227 */       a.warn("Failed to start thread from item {}", Integer.valueOf(i), exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void a(String paramString, long paramLong) {
/* 232 */     double d = paramLong / 1000.0D;
/* 233 */     DecimalFormat decimalFormat = new DecimalFormat("#.##");
/*     */     
/* 235 */     StringBuilder stringBuilder = new StringBuilder("Não foi possível ");
/* 236 */     stringBuilder.append(paramString);
/* 237 */     stringBuilder.append(". Motivo: Tempo de ");
/* 238 */     stringBuilder.append(decimalFormat.format(d));
/* 239 */     stringBuilder.append("s para a captura das informações.");
/*     */     
/* 241 */     l(stringBuilder.toString());
/* 242 */     l(n.a().longValue());
/*     */   }
/*     */   
/*     */   private void s(String paramString) {
/* 246 */     if (a().ac() || a().ab()) {
/*     */       return;
/*     */     }
/*     */     
/* 250 */     StringBuilder stringBuilder = new StringBuilder("Não foi possível ");
/* 251 */     stringBuilder.append(paramString);
/* 252 */     stringBuilder.append(". Motivo: Tempo limite de ");
/* 253 */     stringBuilder.append(TimeUnit.MILLISECONDS.toSeconds(c.DEFAULT_TIMEOUT));
/* 254 */     stringBuilder.append("s para captura das informações excedido.");
/*     */     
/* 256 */     l(stringBuilder.toString());
/* 257 */     l(n.a().longValue());
/*     */   }
/*     */   
/*     */   public boolean c(e parame, double paramDouble) {
/* 261 */     h h = new h(paramDouble);
/* 262 */     a a = new a(parame, (i)a(), this);
/* 263 */     return a.a(h, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> b(e parame) {
/* 268 */     ArrayList<h> arrayList = new ArrayList();
/*     */ 
/*     */     
/*     */     try {
/* 272 */       String str = a().i(parame.a().v()).getData();
/* 273 */       Document document = Jsoup.parse(str);
/* 274 */       Elements elements = document.select("table").first().select("> tbody > tr > td > table > tbody > tr");
/*     */       
/* 276 */       boolean bool = false;
/*     */ 
/*     */       
/* 279 */       HashMap<Object, Object> hashMap = new HashMap<>();
/*     */       
/* 281 */       for (Element element : elements) {
/* 282 */         if (element.text().trim().equals("Item: " + parame.bo())) {
/* 283 */           bool = true; continue;
/* 284 */         }  if (bool) {
/* 285 */           if (element.text().contains("Observação: Participaram deste item os fornecedores abaixo relacionados, com suas respectivas propostas:")) {
/*     */             
/* 287 */             Elements elements1 = element.select("> td > table > tbody > tr");
/*     */             
/* 289 */             for (byte b1 = 1; b1 < elements1.size(); b1++) {
/* 290 */               Elements elements2 = elements1.get(b1).select("> td");
/* 291 */               hashMap.put(elements2.get(1).text(), elements2);
/*     */             }  continue;
/* 293 */           }  if (element.text().contains("Propostas/Lances (5 melhores)")) {
/* 294 */             Elements elements1 = element.select("td > table").first().select("> tbody > tr[bgcolor=#ffffff]");
/*     */             
/* 296 */             byte b1 = 1;
/*     */             
/* 298 */             boolean bool1 = false;
/* 299 */             if (parame.a().k()) {
/* 300 */               bool1 = true;
/*     */             }
/*     */             
/* 303 */             for (Element element1 : elements1) {
/* 304 */               h h = new h();
/* 305 */               String str1 = element1.select("td").last().text().replace(" ", " ");
/* 306 */               SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
/* 307 */               Date date = simpleDateFormat.parse(str1);
/* 308 */               h.c(date);
/*     */               
/* 310 */               String str2 = element1.select("td").get(bool1).text().replace(".", "").replace(",", ".");
/* 311 */               h.q(Double.parseDouble(str2));
/*     */               
/*     */               try {
/* 314 */                 String str3 = element1.select("td").get(1).text();
/* 315 */                 long l = Long.parseLong(str3.replaceAll("\\D", ""));
/* 316 */                 boolean bool2 = (a().a().x() == l) ? true : false;
/* 317 */                 h.A(bool2);
/* 318 */               } catch (NumberFormatException numberFormatException) {
/* 319 */                 a.warn("#020", numberFormatException);
/*     */               } 
/*     */               
/* 322 */               h.l(b1);
/* 323 */               b1++;
/*     */               
/*     */               try {
/* 326 */                 if (n.bQ()) {
/* 327 */                   String str3 = element1.select("td").get(1).text();
/* 328 */                   h.D(str3);
/* 329 */                   h.E(((Elements)hashMap.get(str3)).get(0).text());
/* 330 */                   h.al(((Elements)hashMap.get(str3)).get(4).text());
/*     */                 } 
/* 332 */               } catch (Exception exception) {
/* 333 */                 a.warn("[#012] Problemas ao capturar fornecedores", exception);
/*     */               } 
/*     */               
/* 336 */               arrayList.add(h);
/*     */             } 
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/* 343 */     } catch (Exception exception) {
/* 344 */       a.error("[#009] getMelhoresLances()", exception);
/*     */     } 
/*     */     
/* 347 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public void S() {
/* 352 */     for (e e : a().L()) {
/* 353 */       List<h> list = b(e);
/* 354 */       if (!list.isEmpty()) {
/* 355 */         e.N(g.s.getValue());
/* 356 */         e.h(list.get(0));
/*     */         
/* 358 */         if (((h)list.get(0)).bb()) {
/* 359 */           e.h(((h)list.get(0)).m());
/*     */           
/* 361 */           if (list.size() > 1 && ((h)list.get(1)).m() == e.f()) {
/* 362 */             e.a(s.b);
/*     */           } else {
/* 364 */             e.a(s.a);
/*     */           } 
/*     */         } else {
/* 367 */           Optional<h> optional = list.stream().filter(paramh -> paramh.bb()).findFirst();
/* 368 */           if (optional.isPresent()) {
/* 369 */             e.h(((h)optional.get()).m());
/*     */           }
/*     */           
/* 372 */           e.a(s.c);
/*     */         } 
/*     */         
/* 375 */         int i = a().indexOf(e.v());
/* 376 */         if (i >= 0) {
/* 377 */           a().fireTableRowsUpdated(i, i);
/*     */         }
/*     */         
/* 380 */         a(e, list);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void g(e parame) {
/* 387 */     if (!b(parame.v())) {
/* 388 */       super.g(parame);
/* 389 */       this.n.remove(Integer.valueOf(parame.v()));
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
/*     */   public final d a() {
/* 403 */     return (d)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\f\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */