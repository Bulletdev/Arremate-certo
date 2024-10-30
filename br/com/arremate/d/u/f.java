/*     */ package br.com.arremate.d.u;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.f.s;
/*     */ import br.com.arremate.f.t;
/*     */ import br.com.arremate.g.d;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.j.l.a.d;
/*     */ import br.com.arremate.k.c.c;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.q.b.a;
/*     */ import br.com.arremate.l.q.b.d;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.l.q.b.g;
/*     */ import br.com.arremate.l.q.c.i;
/*     */ import br.com.arremate.m.y;
/*     */ import br.com.arremate.n.n;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class f
/*     */   extends g
/*     */ {
/*     */   public static final String at = "Aberto";
/*     */   public static final String au = "Aviso de Iminência";
/*     */   public static final String av = "Encerramento Aleatório";
/*     */   public static final String aw = "Suspenso";
/*     */   public static final String ax = "Encerrado";
/*     */   protected static final String ay = "A";
/*     */   protected static final String az = "P";
/*     */   protected static final String aA = "F";
/*     */   protected static final String aB = "E";
/*     */   protected static final String aC = "C";
/*     */   protected final ExecutorService executor;
/*     */   protected final Map<Integer, Future> c;
/*     */   protected final Map<Integer, br.com.arremate.d.f> b;
/*     */   private String am;
/*     */   private int ag;
/*     */   private boolean t;
/*     */   
/*     */   public f(b paramb, d paramd) {
/*  70 */     super(paramb, (i)paramd);
/*  71 */     j(250L);
/*  72 */     a(new d(this, paramd));
/*  73 */     this.ag = 0;
/*  74 */     this.am = "";
/*  75 */     this.executor = Executors.newCachedThreadPool();
/*  76 */     this.c = new HashMap<>();
/*  77 */     this.b = new HashMap<>();
/*     */   }
/*     */ 
/*     */   
/*     */   public t a() {
/*  82 */     boolean bool = false;
/*     */     
/*     */     try {
/*  85 */       e e = a().d();
/*  86 */       e(e.k());
/*  87 */       String str = e.getData();
/*     */       
/*  89 */       bool = str.isEmpty();
/*  90 */       if (!bool) {
/*  91 */         e(e.k());
/*  92 */         a(new Date(n.a().longValue()));
/*  93 */         String str1 = Integer.toString(a().v());
/*     */         
/*  95 */         if (str.contains(str1)) {
/*  96 */           if (c(str, str1)) {
/*  97 */             return t.e;
/*     */           }
/*     */           
/* 100 */           return t.c;
/*     */         } 
/*     */         
/* 103 */         e = a().c();
/* 104 */         e(e.k());
/* 105 */         str = e.getData();
/*     */         
/* 107 */         bool = str.isEmpty();
/* 108 */         if (!bool && !str.contains(str1)) {
/* 109 */           e = a().g();
/* 110 */           e(e.k());
/* 111 */           str = e.getData();
/*     */           
/* 113 */           bool = str.isEmpty();
/* 114 */           if (!bool) {
/* 115 */             return str.contains(str1) ? t.f : t.d;
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 122 */       if (bool && 
/* 123 */         !D() && !E() && 
/* 124 */         isRunning() && !a().isRunning()) {
/* 125 */         a().z();
/*     */       
/*     */       }
/*     */     }
/* 129 */     catch (Exception exception) {
/* 130 */       a.error("Erro ao capturar a situação do pregão", exception);
/*     */     } 
/*     */     
/* 133 */     return t.b;
/*     */   }
/*     */   
/*     */   private boolean c(String paramString1, String paramString2) {
/*     */     try {
/* 138 */       Document document = Jsoup.parse(paramString1);
/* 139 */       Elements elements = document.select("table table table");
/* 140 */       Element element = (elements != null && elements.size() > 1) ? elements.get(1) : null;
/*     */       
/* 142 */       if (element != null) {
/* 143 */         Elements elements1 = element.select("tr");
/*     */         
/* 145 */         for (Element element1 : elements1) {
/* 146 */           if (element1.html().contains(paramString2)) {
/* 147 */             return element1.html().contains("Suspensão Administrativa");
/*     */           }
/*     */         } 
/*     */       } 
/* 151 */     } catch (Exception exception) {
/* 152 */       a.warn("Failed to indetify suspended bidding", exception);
/*     */     } 
/*     */     
/* 155 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void R() {
/* 160 */     z("A");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void S() {
/* 167 */     bt();
/* 168 */     z("F");
/* 169 */     bt();
/* 170 */     z("E");
/* 171 */     bt();
/* 172 */     z("C");
/* 173 */     bt();
/* 174 */     z("P");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void z(String paramString) {
/*     */     try {
/* 184 */       if ("".equals(this.am)) {
/* 185 */         bt();
/*     */       }
/*     */       
/* 188 */       e e = a().c(
/* 189 */           a().v(), this.am, paramString);
/*     */ 
/*     */ 
/*     */       
/* 193 */       e(e.k());
/* 194 */       String str = e.getData();
/*     */       
/* 196 */       if (str.isEmpty()) {
/* 197 */         a.info("Não obteve resposta do portal em requisição a página de disputa");
/* 198 */         this.ag++;
/*     */ 
/*     */         
/* 201 */         if (D() || E()) {
/*     */           return;
/*     */         }
/*     */         
/* 205 */         bw();
/* 206 */       } else if (str.contains("Pregão Suspenso") && paramString.equals("A")) {
/* 207 */         bx();
/* 208 */       } else if (str.contains("form.ticket.value = ")) {
/* 209 */         b(str, paramString);
/*     */       } 
/* 211 */     } catch (Exception exception) {
/* 212 */       a.error("#003", exception);
/* 213 */       h("#003");
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void bw() {
/* 218 */     bt();
/*     */     
/* 220 */     if (this.ag >= 3) {
/* 221 */       a.info("Não conseguiu sequence válida depois de 3 tentativas, reiniciando sessão");
/*     */       
/* 223 */       if (a().isRunning()) {
/* 224 */         a().b();
/*     */       }
/*     */       
/* 227 */       a(br.com.arremate.f.f.i);
/*     */       
/* 229 */       while (a().z() != 1 && isRunning()) {
/* 230 */         a.warn("Tentativa falha de login thread da licitacao");
/*     */       }
/*     */       
/* 233 */       bt();
/*     */       
/* 235 */       if (!this.am.isEmpty()) {
/* 236 */         a("Conseguiu carregar sequence da thread da licitação", false);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void b(String paramString1, String paramString2) {
/* 242 */     this.ag = 0;
/*     */     
/* 244 */     if (this.t) {
/* 245 */       by();
/*     */     }
/*     */     
/*     */     try {
/* 249 */       Document document = Jsoup.parse(paramString1);
/* 250 */       Elements elements = document.select("form > table[class=td]");
/*     */       
/* 252 */       LinkedHashSet<Integer> linkedHashSet = a(paramString2);
/*     */       
/* 254 */       if (elements.size() > 1) {
/* 255 */         Element element = elements.get(1);
/*     */         
/* 257 */         if (element != null) {
/* 258 */           Elements elements1 = element.select("tr[class=tex3]");
/* 259 */           a(new Date(n.a().longValue()));
/*     */           
/* 261 */           for (byte b = 0; b < elements1.size(); b++) {
/* 262 */             Element element1 = elements1.get(b);
/* 263 */             String str = e(element1);
/* 264 */             e e = a(str);
/*     */ 
/*     */             
/* 267 */             if (e != null) {
/*     */ 
/*     */ 
/*     */               
/* 271 */               a(e, element1, paramString2);
/*     */               
/* 273 */               if (linkedHashSet != null)
/*     */               {
/* 275 */                 linkedHashSet.remove(Integer.valueOf(e.v()));
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 282 */       a(paramString2, linkedHashSet);
/* 283 */     } catch (Exception exception) {
/* 284 */       a.error("#002", exception);
/* 285 */       h("#002");
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void a(e parame, Element paramElement, String paramString) {
/* 290 */     int i = parame.v();
/* 291 */     Future future = this.c.get(Integer.valueOf(i));
/*     */     
/*     */     try {
/* 294 */       if (future == null || future.isDone()) {
/* 295 */         br.com.arremate.d.f f1 = this.b.get(Integer.valueOf(i));
/*     */         
/* 297 */         if (f1 == null) {
/* 298 */           f1 = a(parame);
/*     */           
/* 300 */           if ("A".equals(paramString)) {
/*     */             
/* 302 */             this.b.put(Integer.valueOf(i), f1);
/*     */             
/* 304 */             String str1 = f1.l();
/* 305 */             DecimalFormat decimalFormat = y.a("###,###,###,##0.0000");
/* 306 */             String str2 = decimalFormat.format(parame.l());
/*     */             
/* 308 */             StringBuilder stringBuilder = new StringBuilder();
/* 309 */             stringBuilder.append(str1)
/* 310 */               .append(" ")
/* 311 */               .append(parame.bo())
/* 312 */               .append(" entrou em disputa com valor mínimo de R$ ")
/* 313 */               .append(str2);
/* 314 */             l(stringBuilder.toString());
/*     */           } 
/*     */         } 
/*     */         
/* 318 */         ((e)f1).i(paramElement);
/*     */         
/* 320 */         if (paramString.equals("C")) {
/* 321 */           parame.N("Cancelado");
/*     */         }
/*     */         
/* 324 */         Future<?> future1 = this.executor.submit((Runnable)f1);
/* 325 */         this.c.put(Integer.valueOf(i), future1);
/*     */       } 
/* 327 */     } catch (Exception exception) {
/* 328 */       a.error("#004", exception);
/* 329 */       h("#004");
/*     */     } 
/*     */   }
/*     */   
/*     */   private void a(String paramString, LinkedHashSet<Integer> paramLinkedHashSet) {
/* 334 */     if (paramString.equals("A") && paramLinkedHashSet != null)
/*     */     {
/*     */       
/* 337 */       paramLinkedHashSet.forEach(paramInteger -> {
/*     */             br.com.arremate.d.f f1 = this.b.get(paramInteger);
/*     */             if (f1 != null) {
/*     */               e e = f1.a();
/*     */               e.N(g.s.getValue());
/*     */               g(e);
/*     */               if (e instanceof br.com.arremate.l.q.b.f) {
/*     */                 a().L().stream().filter(()).forEach(());
/*     */               }
/*     */             } 
/*     */             this.b.remove(paramInteger);
/*     */           });
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected LinkedHashSet<Integer> a(String paramString) {
/* 367 */     LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet();
/*     */     
/* 369 */     if (paramString.equals("A")) {
/*     */       try {
/* 371 */         this.b.forEach((paramInteger, paramf) -> paramLinkedHashSet.add(paramInteger));
/*     */ 
/*     */       
/*     */       }
/* 375 */       catch (Exception exception) {
/* 376 */         a.error("Failed to list open items", exception);
/*     */       } 
/*     */     }
/*     */     
/* 380 */     return linkedHashSet;
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
/*     */   public void bt() {
/*     */     try {
/* 394 */       a.info("Carregando nova sequence");
/*     */       
/* 396 */       if (!a().isRunning() && 
/* 397 */         a().z() != 1) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 402 */       String str = a().d(
/* 403 */           a().v(), 
/* 404 */           a().bo());
/*     */       
/* 406 */       Document document = Jsoup.parse(str);
/* 407 */       Element element = document.select("frame[name=main_lance]").first();
/*     */       
/* 409 */       if (element != null) {
/* 410 */         String str1 = a().aR() + element.attr("src");
/*     */         
/* 412 */         if (!str1.isEmpty()) {
/* 413 */           this.am = str1.substring(str1.indexOf("sequence=") + 9);
/* 414 */           a.info("Conseguiu obter nova sequence: {}", this.am);
/*     */           return;
/*     */         } 
/*     */       } 
/* 418 */     } catch (Exception exception) {
/* 419 */       a.error("#008 - Failed to load sequence");
/* 420 */       h("#008 - Failed to load sequence");
/*     */     } 
/*     */     
/* 423 */     a.info("Não conseguiu capturar nova sequence");
/* 424 */     this.am = "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String e(Element paramElement) {
/*     */     try {
/* 436 */       Elements elements = paramElement.select("td");
/* 437 */       return elements.get(1).text().trim();
/*     */     }
/* 439 */     catch (Exception exception) {
/* 440 */       a.warn("Failed to capture item number from HTML", exception);
/* 441 */       return "";
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> b(e parame) throws d {
/* 447 */     int i = parame.v();
/*     */     
/* 449 */     br.com.arremate.d.f f1 = this.b.get(Integer.valueOf(i));
/* 450 */     if (f1 == null) {
/* 451 */       f1 = a(parame);
/*     */     }
/*     */     
/* 454 */     return f1.e();
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
/*     */   public boolean c(e parame, double paramDouble) {
/* 466 */     if (parame == null || parame instanceof br.com.arremate.l.q.b.f) {
/* 467 */       return false;
/*     */     }
/*     */     
/* 470 */     Element element = null;
/* 471 */     h h = new h(paramDouble);
/*     */     
/* 473 */     if ("".equals(this.am)) {
/* 474 */       bt();
/*     */     }
/*     */     
/*     */     try {
/* 478 */       e e1 = a().c(
/* 479 */           a().v(), this.am, "A");
/*     */ 
/*     */ 
/*     */       
/* 483 */       e(e1.k());
/* 484 */       Document document = Jsoup.parse(e1.getData());
/* 485 */       Elements elements = document.select("form > table[class=td]");
/*     */       
/* 487 */       if (elements.size() > 1) {
/* 488 */         Element element1 = elements.get(1);
/*     */         
/* 490 */         if (element1 != null) {
/* 491 */           Elements elements1 = element1.select("tr[class=tex3]");
/*     */           
/* 493 */           for (byte b = 0; b < elements1.size(); b++) {
/* 494 */             Element element2 = elements1.get(b);
/* 495 */             String str = e(element2);
/*     */             
/* 497 */             if (parame.bo().equals(str)) {
/* 498 */               element = element2;
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 504 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/* 507 */     if (element == null)
/*     */     {
/* 509 */       return false;
/*     */     }
/*     */     
/* 512 */     br.com.arremate.d.f f1 = a(parame);
/* 513 */     ((e)f1).i(element);
/* 514 */     return f1.a(h, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void bx() {
/* 521 */     this.t = true;
/*     */     
/* 523 */     a(br.com.arremate.f.f.f, (a)new d());
/*     */     
/* 525 */     bz();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void by() {
/* 532 */     this.t = false;
/* 533 */     a(br.com.arremate.f.f.c);
/*     */   }
/*     */   
/*     */   protected br.com.arremate.d.f a(e parame) {
/* 537 */     if (parame == null) {
/* 538 */       return null;
/*     */     }
/*     */     
/* 541 */     return new e(parame, a(), this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void bz() {
/* 549 */     for (byte b = 0; b < 60; b++) {
/*     */       try {
/* 551 */         Thread.sleep(1000L);
/* 552 */       } catch (Exception exception) {}
/*     */ 
/*     */ 
/*     */       
/* 556 */       if (!isRunning()) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void T() {
/*     */     try {
/* 565 */       Future<d> future = c.a((j)a());
/* 566 */       d d = future.get();
/*     */       
/* 568 */       a().I().forEach(parame -> {
/*     */             if (parame == null) {
/*     */               return;
/*     */             }
/*     */             
/*     */             if (!paramd.isRunning()) {
/*     */               paramd.z();
/*     */             }
/*     */             
/*     */             e e1 = new e(parame, paramd, null);
/*     */             
/*     */             try {
/*     */               List<h> list = e1.e();
/*     */               
/*     */               long l1 = n.a().longValue();
/*     */               long l2 = l1 - TimeUnit.MINUTES.toMillis(5L);
/*     */               int i = (int)list.stream().filter(()).count();
/*     */               parame.ah(i);
/*     */               parame.ai(list.size() - i);
/* 587 */             } catch (d d1) {
/*     */ 
/*     */               
/*     */               a.error("#035 - Falha ao capturar on/off no " + a(e1) + " " + parame.bo() + ". Motivo: Tempo limite para capturar melhores lances excedido.", (Throwable)d1);
/*     */             
/*     */             }
/* 593 */             catch (Exception exception) {
/*     */               a.error("#035 - Falha ao capturar on/off no " + a(e1) + " " + parame.bo(), exception);
/*     */             } 
/*     */           });
/*     */ 
/*     */       
/* 599 */       c.b((i)d);
/* 600 */     } catch (Exception exception) {
/* 601 */       a.error("#035 - Falha ao capturar on/off no ", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public br.com.arremate.l.e.f a() {
/* 607 */     return (br.com.arremate.l.e.f)super.a();
/*     */   }
/*     */ 
/*     */   
/*     */   public d a() {
/* 612 */     return (d)super.a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String G() {
/* 621 */     return this.am;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void a(br.com.arremate.l.q.c.f paramf, List<h> paramList) {
/* 626 */     e e = paramf.b();
/*     */     
/*     */     try {
/* 629 */       if (paramList == null || paramList.isEmpty()) {
/* 630 */         paramList = b(e);
/*     */       }
/*     */       
/* 633 */       if (!paramList.isEmpty()) {
/* 634 */         h h = paramList.get(0);
/* 635 */         e.h(h);
/*     */         
/* 637 */         s s = h.bb() ? s.a : s.c;
/*     */ 
/*     */         
/* 640 */         for (h h1 : paramList) {
/* 641 */           if (h1.bb()) {
/* 642 */             e.a(s);
/* 643 */             e.h(h1.m());
/*     */             
/* 645 */             if (paramf instanceof i) {
/* 646 */               ((i)paramf).l(h1.j());
/*     */             }
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/* 652 */     } catch (d d) {
/* 653 */       a.info("Falha ao carregar dados do vencedor do " + (e.ay() ? "Grupo " : "Item ") + paramf.b().bo(), (Throwable)d);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\\\u\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */