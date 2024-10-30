/*     */ package br.com.arremate.d;
/*     */ import br.com.arremate.f.h;
/*     */ import br.com.arremate.f.i;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.r;
/*     */ import br.com.arremate.f.s;
/*     */ import br.com.arremate.g.a;
/*     */ import br.com.arremate.g.b;
/*     */ import br.com.arremate.g.d;
/*     */ import br.com.arremate.g.e;
/*     */ import br.com.arremate.i.d;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.k.b.a;
/*     */ import br.com.arremate.l.b;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.n;
/*     */ import br.com.arremate.l.p.a;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.l.q.b.i;
/*     */ import br.com.arremate.m.n;
/*     */ import br.com.arremate.m.y;
/*     */ import br.com.arremate.n.n;
/*     */ import java.math.BigDecimal;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ public abstract class f extends Thread {
/*  34 */   protected static final Logger a = LoggerFactory.getLogger(f.class);
/*     */   
/*     */   private final e c;
/*     */   
/*     */   private final i b;
/*     */   
/*     */   private final g b;
/*     */   private String N;
/*     */   private Double e;
/*     */   private boolean h;
/*     */   private a a;
/*     */   protected d a;
/*     */   private a a;
/*     */   
/*     */   public f(e parame, i parami, g paramg) {
/*  49 */     this.a = new a(parame);
/*  50 */     this.c = parame;
/*  51 */     this.b = (g)parami;
/*  52 */     this.b = paramg;
/*  53 */     this.a = (a)new a();
/*  54 */     this.h = false;
/*     */     
/*  56 */     this.a = null;
/*     */     
/*  58 */     switch (null.e[this.c.a().a().ordinal()]) {
/*     */       case 1:
/*  60 */         this.a = (a)new d();
/*     */         break;
/*     */       case 2:
/*  63 */         if (!parame.ay()) {
/*  64 */           this.a = (a)new c();
/*     */         }
/*     */         break;
/*     */     } 
/*     */     
/*  69 */     setName(getClass().getName() + "_" + parame.a().v() + "_" + parame.bo());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void P();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract boolean a(i parami, String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract List<h> e() throws d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean a(h paramh, boolean paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/*     */     try {
/* 106 */       a((Double)null);
/* 107 */       P();
/*     */       
/* 109 */       i i1 = this.b.a();
/* 110 */       int j = i1.indexOf(a().v());
/*     */       
/* 112 */       if (j >= 0) {
/* 113 */         i1.fireTableRowsUpdated(j, j);
/*     */       }
/*     */       
/* 116 */       Q();
/*     */       
/* 118 */       if (!t()) {
/*     */         return;
/*     */       }
/*     */       
/* 122 */       h h = a();
/*     */       
/* 124 */       if (h != null) {
/* 125 */         double d1 = h.m();
/*     */         
/* 127 */         if (d1 != 0.0D && b(d1)) {
/* 128 */           a(Double.valueOf(d1));
/* 129 */           this.c.i(this.N);
/* 130 */           a(h, false);
/*     */         } 
/* 132 */       } else if (s()) {
/* 133 */         this.c.a(r.b);
/*     */       } 
/* 135 */     } catch (a|b|e a1) {
/* 136 */       b().a(a1.getMessage(), this.c.bo());
/* 137 */     } catch (Exception exception) {
/* 138 */       h("#007 - Erro na thread monitora disputa");
/* 139 */       a.warn("Falha no processo de cálculo do novo lance", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void Q() {
/* 144 */     if (this.a.bn()) {
/* 145 */       this.a.cq();
/*     */     }
/*     */     
/* 148 */     if (this.a.bm()) {
/* 149 */       this.a.cr();
/* 150 */       b().l(this.a.ch());
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean s() {
/* 155 */     b b = this.c.b();
/* 156 */     String str = null;
/*     */     
/* 158 */     if (this.c.l() == 0.0D) {
/* 159 */       str = "possui o valor limite configurado igual a \"0,00\"";
/*     */     }
/*     */     
/* 162 */     if (this.c.a().a() == m.c) {
/*     */ 
/*     */       
/* 165 */       boolean bool = (this.c.w() == v.a.v()) ? ((this.c.y().compareTo(BigDecimal.valueOf(this.c.f())) >= 0) ? true : false) : ((this.c.y().compareTo(BigDecimal.valueOf(this.c.f())) <= 0) ? true : false);
/*     */       
/* 167 */       if (this.c.bv() && bool && !this.c.aS()) {
/* 168 */         str = "não possui margem para enviar o Lance Fechado";
/*     */       }
/* 170 */     } else if (!a(this.c.f().m()) && 
/* 171 */       !b.aE() && (
/* 172 */       !b.aD() || !a(this.c.f()))) {
/* 173 */       str = "não possui margem para ganhar o 1° lugar";
/*     */     } 
/*     */     
/* 176 */     if (str != null) {
/* 177 */       StringBuilder stringBuilder = new StringBuilder();
/* 178 */       stringBuilder.append("O item ");
/* 179 */       stringBuilder.append(this.c.bo()).append(" ");
/* 180 */       stringBuilder.append(str);
/* 181 */       stringBuilder.append(", item da disputa pausado automaticamente na fase \"");
/* 182 */       stringBuilder.append(this.c.bB());
/* 183 */       stringBuilder.append("\".");
/* 184 */       b().l(stringBuilder.toString());
/*     */       
/* 186 */       return true;
/*     */     } 
/*     */     
/* 189 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean t() {
/* 199 */     i i1 = this.c.b().a(this.c.a());
/*     */     
/* 201 */     return (this.c.bt() && 
/* 202 */       u() && 
/* 203 */       v() && 
/* 204 */       w() && 
/* 205 */       x() && 
/* 206 */       y() && 
/* 207 */       a(i1, this.c.bB()) && 
/* 208 */       z() && 
/* 209 */       A());
/*     */   }
/*     */   
/*     */   private boolean u() {
/* 213 */     return (this.c.l() > 0.0D);
/*     */   }
/*     */   
/*     */   private boolean v() {
/* 217 */     return (this.c.f().m() > 0.0D);
/*     */   }
/*     */   
/*     */   private boolean w() {
/* 221 */     return (this.c.f() > 0.0D);
/*     */   }
/*     */   
/*     */   private boolean x() {
/* 225 */     return (this.c.a() == r.a);
/*     */   }
/*     */   
/*     */   private boolean y() {
/* 229 */     if (this.c.bv()) {
/* 230 */       return true;
/*     */     }
/*     */     
/* 233 */     return (B() && C());
/*     */   }
/*     */   
/*     */   private boolean z() {
/* 237 */     long l1 = n.a().longValue();
/* 238 */     long l2 = 0L;
/* 239 */     g g1 = this.c.a();
/*     */     
/* 241 */     if (g1 != null) {
/* 242 */       long l = g1.b().t() - 500L;
/* 243 */       l2 = g1.A() + l;
/*     */     } 
/*     */     
/* 246 */     return (l1 > l2);
/*     */   }
/*     */   
/*     */   private boolean A() {
/* 250 */     return (this.a == null || this.a.d(this.c));
/*     */   }
/*     */   
/*     */   protected boolean B() {
/* 254 */     return (this.c.l() < this.c.f());
/*     */   }
/*     */   
/*     */   protected boolean C() {
/* 258 */     return (this.c.f().m() <= this.c.f());
/*     */   }
/*     */ 
/*     */   
/*     */   protected h a() throws b, e, a {
/*     */     h h;
/* 264 */     if (this.c.a() == s.a) {
/* 265 */       h = b();
/*     */     } else {
/* 267 */       h = c();
/*     */     } 
/*     */     
/* 270 */     if (h != null)
/*     */     {
/* 272 */       if (!b(h.m())) {
/* 273 */         h = new h(this.c.l());
/* 274 */         this.N = "Lance Derradeiro";
/*     */       } 
/*     */     }
/*     */     
/* 278 */     return h;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private h b() throws a {
/* 288 */     return b((List<h>)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected h b(List<h> paramList) throws a {
/* 299 */     n n = this.c.a().b();
/* 300 */     d d1 = this.c.a().a();
/* 301 */     b b = this.c.b();
/* 302 */     m m = a().a().a();
/* 303 */     boolean bool = b.a(n, d1, m);
/*     */     
/* 305 */     h h = null;
/*     */     
/*     */     try {
/* 308 */       if (n.bk() && bool) {
/* 309 */         if (paramList == null) {
/* 310 */           paramList = e();
/*     */         }
/*     */         
/* 313 */         double d2 = this.c.l();
/* 314 */         double d3 = this.c.f();
/* 315 */         double d4 = this.c.k();
/* 316 */         BigDecimal bigDecimal1 = this.c.r();
/* 317 */         BigDecimal bigDecimal2 = this.c.s();
/*     */         
/* 319 */         h = this.a.a(paramList, d2, d3, d4, n, bool, b, bigDecimal1, bigDecimal2);
/*     */       } 
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
/* 332 */       if (h == null && this.c.k() == this.c.f()) {
/* 333 */         if (paramList == null) {
/* 334 */           paramList = e();
/*     */         }
/*     */         
/* 337 */         h = f(paramList);
/*     */       } 
/* 339 */     } catch (d d2) {
/* 340 */       a("enviar lance para distanciar de ME/EPP", d2);
/*     */     } 
/*     */     
/* 343 */     return h;
/*     */   }
/*     */   
/*     */   protected h f(List<h> paramList) {
/* 347 */     if (paramList != null) {
/* 348 */       return this.a.d(paramList, this.c);
/*     */     }
/*     */     
/* 351 */     return null;
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
/*     */   h c() throws b, e {
/* 363 */     return c((List<h>)null);
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
/*     */   protected h c(List<h> paramList) throws b, e {
/*     */     h h;
/* 376 */     int j = this.c.j();
/*     */ 
/*     */     
/* 379 */     if (j != h.i.v()) {
/* 380 */       h = g(paramList);
/*     */     } else {
/* 382 */       h = h(paramList);
/*     */     } 
/*     */     
/* 385 */     return h;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private h g(List<h> paramList) {
/* 395 */     h h = null;
/* 396 */     int j = this.c.j();
/*     */     
/*     */     try {
/* 399 */       if (paramList == null) {
/* 400 */         paramList = e();
/*     */       }
/*     */       
/* 403 */       if (j != h.i.v() && !paramList.isEmpty()) {
/* 404 */         h h1 = this.a.a(j - 1, paramList, this.c);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 410 */         if (h1 != null && h1.m() > 0.0D) {
/* 411 */           this.N = h1.j() + "º Lugar";
/* 412 */           h = h1;
/*     */         } 
/*     */       } 
/* 415 */     } catch (d d1) {
/* 416 */       a("enviar lance para posição selecionada", d1);
/*     */     } 
/*     */     
/* 419 */     return h;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected h h(List<h> paramList) {
/* 430 */     h h = this.a.a(this.c);
/*     */     
/* 432 */     if (h != null) {
/* 433 */       this.N = "1º Lugar";
/* 434 */       return h;
/*     */     } 
/*     */     
/* 437 */     return i(paramList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected h i(List<h> paramList) {
/* 447 */     h h = null;
/* 448 */     b b = this.c.b();
/*     */     
/* 450 */     if (b.aE()) {
/*     */       try {
/* 452 */         if (paramList == null) {
/* 453 */           paramList = e();
/*     */         }
/*     */         
/* 456 */         this.h = false;
/* 457 */         h = this.a.e(paramList, this.c);
/*     */         
/* 459 */         if (h != null) {
/* 460 */           String str = Integer.toString(h.j());
/* 461 */           this.N = str + "º Lugar";
/*     */         } else {
/* 463 */           this.N = this.a.a(paramList, this.c.f());
/*     */           
/* 465 */           if (this.N != null && !this.N.isEmpty()) {
/* 466 */             this.c.i(this.N);
/*     */           }
/*     */         } 
/* 469 */       } catch (d d1) {
/* 470 */         a("enviar lance para melhor posição possível", d1);
/*     */         
/* 472 */         if (this.h) {
/* 473 */           if (this.c.bu() && 
/* 474 */             b(this.c.f())) {
/* 475 */             h = new h(this.c.l());
/*     */             
/* 477 */             h.c(new Date(n.a().longValue() - TimeUnit.MINUTES.toMillis(1L)));
/* 478 */             this.N = "Lance Derradeiro";
/*     */             
/* 480 */             b().a("Valor limite será enviado pois o portal está levando muito tempo para informar a lista de melhores lances", 
/*     */                 
/* 482 */                 a().bo());
/* 483 */             this.h = false;
/*     */           } 
/*     */         } else {
/* 486 */           this.h = true;
/*     */         } 
/*     */       } 
/* 489 */     } else if (b.aD()) {
/* 490 */       h = new h(this.c.l());
/* 491 */       this.N = "Lance Derradeiro";
/*     */     } else {
/* 493 */       this.N = "Sem limite";
/*     */     } 
/*     */     
/* 496 */     return h;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean a(double paramDouble) {
/* 507 */     return (a() != null) ? (
/* 508 */       (paramDouble > a().l())) : false;
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
/*     */   protected boolean b(double paramDouble) {
/* 520 */     return (a() != null) ? ((paramDouble >= 
/* 521 */       a().l() || a().bv())) : false;
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
/*     */   protected synchronized void a(String paramString1, h paramh, String paramString2, boolean paramBoolean, String... paramVarArgs) {
/* 535 */     a(paramString1, this.c, paramh, paramString2, paramBoolean, paramVarArgs);
/*     */   }
/*     */   
/*     */   protected synchronized void a(String paramString1, e parame, h paramh, String paramString2, boolean paramBoolean, String... paramVarArgs) {
/* 539 */     StringBuilder stringBuilder = new StringBuilder();
/* 540 */     double d1 = paramh.m();
/*     */     
/* 542 */     if (paramBoolean) {
/* 543 */       stringBuilder.append("Lance Manual: ");
/*     */     }
/*     */     
/* 546 */     stringBuilder.append(paramString1);
/* 547 */     DecimalFormat decimalFormat = y.a("###,###,##0.0000");
/* 548 */     stringBuilder.append(" | Valor lance: ").append(decimalFormat.format(d1));
/*     */     
/* 550 */     if (n.aE() && paramString2 != null && !paramBoolean) {
/* 551 */       stringBuilder.append(" | Posição: ").append(paramString2);
/*     */     }
/*     */     
/* 554 */     if (!"".equals(paramh.bJ())) {
/* 555 */       stringBuilder.append(" | ").append(paramh.bJ());
/*     */     }
/*     */     
/* 558 */     for (String str : paramVarArgs) {
/* 559 */       stringBuilder.append(" | ");
/* 560 */       stringBuilder.append(str);
/*     */     } 
/*     */     
/* 563 */     this.b.a(stringBuilder.toString(), parame.bo());
/*     */   }
/*     */   
/*     */   protected void a(String paramString, d paramd) {
/* 567 */     a(paramString, "captura dos melhores lances", paramd);
/*     */   }
/*     */   
/*     */   protected void b(String paramString, d paramd) {
/* 571 */     a(paramString, "envio de lances", paramd);
/*     */   }
/*     */   
/*     */   protected void a(String paramString1, String paramString2, d paramd) {
/* 575 */     StringBuilder stringBuilder = new StringBuilder("Não foi possível ");
/* 576 */     stringBuilder.append(paramString1);
/* 577 */     stringBuilder.append(" no ");
/* 578 */     stringBuilder.append(l());
/* 579 */     stringBuilder.append(" ");
/* 580 */     stringBuilder.append(this.c.bo());
/* 581 */     stringBuilder.append(". Motivo: Tempo limite de ");
/* 582 */     stringBuilder.append(TimeUnit.MILLISECONDS.toSeconds(paramd.j()));
/* 583 */     stringBuilder.append("s para ");
/* 584 */     stringBuilder.append(paramString2).append(" excedido.");
/*     */     
/* 586 */     if (b() != null) {
/* 587 */       b().l(stringBuilder.toString());
/* 588 */       b().l(n.a().longValue());
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void h(String paramString) {
/* 593 */     this.b.h(paramString);
/*     */   }
/*     */   
/*     */   public String l() {
/* 597 */     return "Item";
/*     */   }
/*     */   
/*     */   public e a() {
/* 601 */     return this.c;
/*     */   }
/*     */   
/*     */   public i b() {
/* 605 */     return (i)this.b;
/*     */   }
/*     */   
/*     */   public g b() {
/* 609 */     return this.b;
/*     */   }
/*     */   
/*     */   public String m() {
/* 613 */     return this.N;
/*     */   }
/*     */   
/*     */   public a a() {
/* 617 */     return (a)this.a;
/*     */   }
/*     */   
/*     */   protected void a(a parama) {
/* 621 */     this.a = (a)parama;
/*     */   }
/*     */   
/*     */   public d a() {
/* 625 */     return (d)this.a;
/*     */   }
/*     */   
/*     */   protected void a(d paramd) {
/* 629 */     this.a = (a)paramd;
/*     */   }
/*     */   
/*     */   protected void i(String paramString) {
/* 633 */     this.N = paramString;
/*     */   }
/*     */   
/*     */   public Double a() {
/* 637 */     return this.e;
/*     */   }
/*     */   
/*     */   private void a(Double paramDouble) {
/* 641 */     this.e = paramDouble;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */