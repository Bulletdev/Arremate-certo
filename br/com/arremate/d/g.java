/*     */ package br.com.arremate.d;
/*     */ 
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.f.f;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.s;
/*     */ import br.com.arremate.f.t;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.m;
/*     */ import br.com.arremate.l.p.j;
/*     */ import br.com.arremate.l.q.b.a;
/*     */ import br.com.arremate.l.q.b.b;
/*     */ import br.com.arremate.l.q.b.c;
/*     */ import br.com.arremate.l.q.b.d;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.l.q.b.f;
/*     */ import br.com.arremate.l.q.b.i;
/*     */ import br.com.arremate.l.q.c.f;
/*     */ import br.com.arremate.l.q.c.n;
/*     */ import br.com.arremate.m.A;
/*     */ import br.com.arremate.m.n;
/*     */ import br.com.arremate.n.n;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import java.util.Timer;
/*     */ import java.util.TimerTask;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import java.util.stream.Collectors;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.SwingUtilities;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class g
/*     */   extends Thread
/*     */ {
/*  47 */   protected static final Logger a = LoggerFactory.getLogger(g.class);
/*     */   
/*     */   private final b b;
/*     */   
/*     */   private final i a;
/*     */   private final AtomicBoolean b;
/*     */   private final b a;
/*     */   private final c a;
/*     */   private final d a;
/*     */   private t a;
/*     */   private e a;
/*     */   private h a;
/*     */   private long e;
/*     */   private long f;
/*     */   private Timer d;
/*     */   private Timer e;
/*     */   private long g;
/*     */   
/*     */   public g(b paramb, i parami) {
/*  66 */     this.b = (AtomicBoolean)paramb;
/*  67 */     this.a = (h)parami;
/*  68 */     this.b = new AtomicBoolean(true);
/*  69 */     this.e = 0L;
/*  70 */     this.f = TimeUnit.SECONDS.toMillis(10L);
/*  71 */     this.g = 0L;
/*     */     
/*  73 */     this.a = (h)new b();
/*  74 */     this.a = (h)new c();
/*  75 */     this.a = (h)new d();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/*     */     try {
/* 118 */       X();
/* 119 */       a().H();
/* 120 */       U();
/* 121 */       Y();
/*     */       
/* 123 */       if (isRunning()) {
/* 124 */         a(f.k);
/*     */         
/* 126 */         if (this.a == t.d) {
/* 127 */           JOptionPane.showMessageDialog(null, "Não é possível iniciar a disputa, a fase de lances já foi encerrada.", "Informação", 1);
/* 128 */           a().c(false);
/*     */         } else {
/* 130 */           Z();
/* 131 */           aa();
/* 132 */           ac(); do {
/*     */             f f;
/*     */             h h1;
/* 135 */             R();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 142 */             boolean bool = a().L().stream().anyMatch(parame -> (parame.bt() || parame.bx() || parame.au()));
/* 143 */             if (bool) {
/* 144 */               f = f.c;
/* 145 */               h1 = this.a;
/*     */               
/* 147 */               if (n.a().longValue() - c() < 30000L) {
/* 148 */                 f = f.e;
/*     */               }
/*     */               
/* 151 */               if (a().a() == m.c) {
/* 152 */                 f = a(f);
/*     */               }
/*     */             } else {
/* 155 */               f = f.m;
/* 156 */               h1 = this.a;
/*     */               
/* 158 */               this.a = (h)a();
/* 159 */               if (this.a == t.d || this.a == t.f) {
/* 160 */                 a().c(false);
/* 161 */                 l("A fase de lances do pregão está encerrada. A disputa foi pausada!");
/* 162 */                 JOptionPane.showMessageDialog(null, "A fase de lances do pregão está encerrada. A disputa foi pausada!", "Informação", 1);
/*     */               } 
/*     */             } 
/*     */             
/* 166 */             a(f, (a)h1);
/* 167 */             i(this.e);
/*     */             
/* 169 */             ac();
/* 170 */           } while (isRunning() || (this.a != null && this.a.isRunning()));
/*     */         } 
/*     */         
/* 173 */         if (!D() && !E() && !this.a.aa()) {
/* 174 */           a(f.s);
/* 175 */           S();
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 180 */       if (this.a != t.b) {
/* 181 */         e(a().a().L());
/*     */       }
/* 183 */     } catch (Exception exception) {
/* 184 */       a.error("run", exception);
/* 185 */       a().a("#001 - run");
/*     */     } finally {
/* 187 */       ad();
/* 188 */       O();
/* 189 */       W();
/* 190 */       V();
/*     */       
/* 192 */       a().I();
/* 193 */       a().r();
/* 194 */       a(f.b);
/* 195 */       a().u();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void U() {
/* 200 */     if (this.a != null) {
/* 201 */       this.a.start();
/*     */     } else {
/* 203 */       a.warn("Thread captura de chat não instanciada");
/*     */     } 
/*     */   }
/*     */   
/*     */   private void O() {
/* 208 */     if (this.a != null) {
/* 209 */       this.a.O();
/*     */     } else {
/* 211 */       a.warn("Thread captura de chat não instanciada");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<br.com.arremate.l.g> f() {
/* 221 */     return (List<br.com.arremate.l.g>)a().L().stream().filter(parame -> parame.a().a().equals(s.a))
/*     */       
/* 223 */       .map(e::a).collect(Collectors.toList());
/*     */   }
/*     */   
/*     */   protected void V() {
/* 227 */     this.a.c(this);
/*     */   }
/*     */   
/*     */   protected void W() {
/* 231 */     this.a.b();
/*     */   }
/*     */ 
/*     */   
/*     */   private f a(f paramf) {
/* 236 */     boolean bool = a().L().stream().anyMatch(parame -> parame.bv());
/*     */     
/* 238 */     if (bool) {
/* 239 */       paramf = f.d;
/*     */       
/* 241 */       if (a() != null && a().a() != paramf) {
/* 242 */         SwingUtilities.invokeLater(() -> {
/*     */               JOptionPane.showMessageDialog(a(), "Existem itens em situação de lance fechado", "Informação", 1);
/*     */ 
/*     */ 
/*     */               
/*     */               n.a().b(a());
/*     */             });
/*     */ 
/*     */ 
/*     */         
/* 252 */         Optional optional = a().L().stream().filter(parame -> (parame.bv() && !(parame instanceof br.com.arremate.l.q.b.g))).min((parame1, parame2) -> (parame1.z() > parame2.z()) ? 1 : ((parame1.z() == parame2.z()) ? 0 : -1));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 262 */         optional.ifPresent(parame -> {
/*     */               long l = parame.z() - parame.b().w();
/*     */               a().g(l);
/*     */               a().K();
/*     */             });
/*     */       } 
/* 268 */     } else if (a().a() != paramf && a() != null) {
/* 269 */       a().L();
/*     */     } 
/*     */     
/* 272 */     return paramf;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void X() {
/* 279 */     a().a().I().forEach(parame -> {
/*     */           parame.N("");
/*     */           parame.l(0.0D);
/*     */           parame.h(0.0D);
/*     */           parame.C(0L);
/*     */         });
/* 285 */     a().a().K().forEach(parame -> {
/*     */           parame.N("");
/*     */           parame.l(0.0D);
/*     */           parame.h(0.0D);
/*     */           parame.C(0L);
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void Y() {
/*     */     try {
/* 299 */       a(f.g, (a)this.a);
/*     */       
/* 301 */       while (isRunning()) {
/* 302 */         this.a = (h)b();
/*     */         
/* 304 */         if (isRunning()) {
/* 305 */           switch (null.f[this.a.ordinal()]) {
/*     */             case 1:
/*     */             case 2:
/*     */               return;
/*     */             case 3:
/* 310 */               a(f.f);
/*     */               break;
/*     */             case 4:
/* 313 */               a(f.r);
/*     */               break;
/*     */             default:
/* 316 */               a(f.h);
/*     */               break;
/*     */           } 
/*     */           
/* 320 */           i(this.f);
/*     */         } 
/*     */       } 
/* 323 */     } catch (Exception exception) {
/* 324 */       a.error("#011 - Erro em aguardarPregaoEntrarDisputa()", exception);
/* 325 */       a().a("#011 - aguardarPregaoEntrarDisputa()");
/*     */     } 
/*     */   }
/*     */   
/*     */   protected t b() {
/* 330 */     ac();
/* 331 */     return a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void e(List<e> paramList) {
/* 340 */     StringBuilder stringBuilder = new StringBuilder("UPDATE tbitemlicitacao SET ");
/* 341 */     stringBuilder.append("itesituacao = ?, itestatuslance = ?, itemelhorlance = ?, iteultimolance = ?, ");
/* 342 */     stringBuilder.append("itevencedorcnpj = ?, itevencedornomeempresa = ?, itevencedorporte = ?, itevencedormodelo = ?, itevencedormarca = ?, itevencedorfabricante = ? ");
/* 343 */     stringBuilder.append("WHERE porcodigo = ? AND empcnpj = ? AND liccodigo = ? AND itecodigo = ?");
/*     */     
/* 345 */     paramList.parallelStream().forEach(parame -> {
/*     */           try (PreparedStatement null = a.a().prepareStatement(paramStringBuilder.toString())) {
/*     */             byte b1 = 1;
/*     */             
/*     */             if (!parame.bw() && !(parame instanceof f)) {
/*     */               preparedStatement.setString(b1++, parame.bB());
/*     */               
/*     */               preparedStatement.setInt(b1++, parame.a().x());
/*     */               
/*     */               preparedStatement.setDouble(b1++, parame.f().m());
/*     */               
/*     */               preparedStatement.setDouble(b1++, parame.f());
/*     */               
/*     */               String str1 = "";
/*     */               
/*     */               String str2 = "";
/*     */               
/*     */               String str3 = "";
/*     */               String str4 = "";
/*     */               String str5 = "";
/*     */               String str6 = "";
/*     */               if (parame.br()) {
/*     */                 f f = a().a().b(parame.v());
/*     */                 if (f != null) {
/*     */                   str1 = f.h().av();
/*     */                   str2 = f.h().ay();
/*     */                   str3 = f.h().bL();
/*     */                   str4 = f.h().bK();
/*     */                   str5 = f.h().bH();
/*     */                   str6 = f.h().bI();
/*     */                 } 
/*     */               } 
/*     */               preparedStatement.setString(b1++, str1);
/*     */               preparedStatement.setString(b1++, str2);
/*     */               preparedStatement.setString(b1++, str3);
/*     */               preparedStatement.setString(b1++, str4);
/*     */               preparedStatement.setString(b1++, str5);
/*     */               preparedStatement.setString(b1++, str6);
/*     */               preparedStatement.setInt(b1++, parame.a().a().b().v());
/*     */               preparedStatement.setLong(b1++, parame.a().a().C());
/*     */               preparedStatement.setInt(b1++, parame.a().a().v());
/*     */               preparedStatement.setInt(b1++, parame.a().v());
/*     */               preparedStatement.execute();
/*     */             } 
/* 389 */           } catch (Exception exception) {
/*     */             a.error("Failed to save items data", exception);
/*     */             h("#019 - Falha ao gravar dados dos itens");
/*     */           } 
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void g(e parame) {
/* 402 */     f f = a().a(parame, a().a());
/* 403 */     a(f, a().a(), (List<h>)null);
/*     */ 
/*     */ 
/*     */     
/* 407 */     if (parame instanceof f) {
/* 408 */       f f1 = (f)parame;
/* 409 */       f1.a().B().forEach(paramg -> {
/*     */             e e1 = a().a().a(paramg.v());
/*     */             f f = a().a(e1, a().a());
/*     */             a(f, a().a(), (List<h>)null);
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
/*     */   public void a(e parame, List<h> paramList) {
/* 424 */     f f = a().a(parame, a().a());
/* 425 */     a(f, a().a(), paramList);
/*     */   }
/*     */   
/*     */   public void a(f paramf, n paramn, List<h> paramList) {
/* 429 */     if (!n.bQ()) {
/*     */       return;
/*     */     }
/*     */     
/* 433 */     paramf.S(true);
/* 434 */     a(paramf, paramList);
/* 435 */     paramf.i(paramf.h());
/* 436 */     int j = paramn.a(paramf);
/*     */     
/* 438 */     if (j >= 0) {
/* 439 */       paramn.fireTableRowsUpdated(j, j);
/*     */     }
/*     */   }
/*     */   
/*     */   private void Z() {
/* 444 */     long l1 = TimeUnit.SECONDS.toMillis(10L);
/* 445 */     long l2 = TimeUnit.MINUTES.toMillis(1L);
/*     */     
/* 447 */     this.d = new Timer();
/* 448 */     this.d.schedule(new TimerTask(this)
/*     */         {
/*     */           public void run() {
/* 451 */             this.c.T();
/*     */           }
/*     */         },  l1, l2);
/*     */   }
/*     */   
/*     */   private void aa() {
/* 457 */     long l1 = TimeUnit.SECONDS.toMillis(10L);
/* 458 */     long l2 = TimeUnit.MINUTES.toMillis(5L);
/*     */     
/* 460 */     this.e = new Timer();
/* 461 */     this.e.schedule(new TimerTask(this)
/*     */         {
/*     */           public void run() {
/* 464 */             j.a().p(this.c.a());
/*     */           }
/*     */         },  l1, l2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ab() {
/* 473 */     this.b.set(false);
/*     */     
/* 475 */     if (this.a != null) {
/* 476 */       this.a.ah();
/*     */     }
/*     */     
/* 479 */     if (a() != null) {
/* 480 */       a().I();
/*     */     }
/*     */     
/* 483 */     if (this.d != null) {
/* 484 */       this.d.cancel();
/*     */     }
/*     */     
/* 487 */     if (this.e != null) {
/* 488 */       this.e.cancel();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean D() {
/* 499 */     if (A.a().bX()) {
/* 500 */       return false;
/*     */     }
/*     */     
/* 503 */     a(f.p);
/* 504 */     l("Perdeu conexão com a internet!");
/*     */     
/* 506 */     byte b1 = 0;
/* 507 */     while (isRunning() && !A.a().bX()) {
/*     */       try {
/* 509 */         j("Falha ao restabelecer conexão com a internet. Tentativa nº " + ++b1);
/* 510 */         Thread.sleep(3000L);
/* 511 */       } catch (InterruptedException interruptedException) {}
/*     */     } 
/*     */ 
/*     */     
/* 515 */     if (isRunning()) {
/* 516 */       l("Restabelicida conexão com a internet!");
/*     */       
/* 518 */       if (!this.a.isRunning()) {
/* 519 */         this.a.z();
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 525 */     return !isRunning();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean E() {
/* 535 */     if (a().T()) {
/* 536 */       return false;
/*     */     }
/*     */     
/* 539 */     a(f.q);
/* 540 */     l("Perdeu conexão com o portal!");
/* 541 */     a.info("Perdeu conexão com o portal");
/* 542 */     byte b1 = 0;
/*     */     
/* 544 */     while (isRunning() && !a().T()) {
/*     */       try {
/* 546 */         j("Falha ao restabelecer conexão com o portal. Tentativa nº " + ++b1);
/* 547 */         Thread.sleep(3000L);
/* 548 */       } catch (InterruptedException interruptedException) {}
/*     */     } 
/*     */ 
/*     */     
/* 552 */     if (isRunning()) {
/* 553 */       l("Restabelecida conexão com o portal!");
/* 554 */       a.info("Reestabeleu conexão com o portal com {} tentativas", Integer.valueOf(b1));
/*     */       
/* 556 */       if (!this.a.isRunning()) {
/* 557 */         this.a.z();
/*     */       }
/*     */     } else {
/* 560 */       a.info("Não conseguiu reestabelecer a conexão, apertou stop");
/* 561 */       this.a.b();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 567 */     return !isRunning();
/*     */   }
/*     */   
/*     */   protected void ac() {
/* 571 */     while (isRunning() && (a().ac() || a().ab())) {
/*     */       try {
/* 573 */         Thread.sleep(TimeUnit.SECONDS.toMillis(5L));
/* 574 */       } catch (InterruptedException interruptedException) {}
/*     */     } 
/*     */ 
/*     */     
/* 578 */     if (a().aa()) {
/* 579 */       a().c(false);
/* 580 */       l("A disputa foi pausada! Dados incorretos ao tentar renovar a sessão do login");
/* 581 */       JOptionPane.showMessageDialog(null, "A disputa " + a().bX() + " foi pausada devido aos acessos do portal estarem iválidos.Atualize suas credenciais de acesso para disputar novamente!", "Informação", 1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void j(String paramString) {
/* 588 */     if (!paramString.isEmpty() && a() != null) {
/* 589 */       a().a(paramString);
/*     */     }
/*     */   }
/*     */   
/*     */   public void k(String paramString) {
/* 594 */     l("Situação atual do pregão: " + paramString);
/*     */   }
/*     */   
/*     */   public void l(String paramString) {
/* 598 */     a(paramString, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(String paramString, boolean paramBoolean) {
/* 608 */     if (!paramString.isEmpty() && a() != null) {
/* 609 */       a().a(paramString, paramBoolean);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(String paramString1, String paramString2) {
/* 620 */     a(paramString1, paramString2, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void a(String paramString1, String paramString2, boolean paramBoolean) {
/* 631 */     if (!paramString1.isEmpty()) {
/* 632 */       if (!"".equals(paramString2)) {
/* 633 */         paramString1 = paramString2 + " -> " + paramString1;
/*     */       }
/* 635 */       a(paramString1, paramBoolean);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void h(String paramString) {
/* 645 */     if (!paramString.isEmpty() && a() != null) {
/* 646 */       a().a(paramString);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void e(long paramLong) {
/* 656 */     if (a() != null) {
/* 657 */       a().e(paramLong);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void f(long paramLong) {
/* 667 */     if (a() != null) {
/* 668 */       a().f(paramLong);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void g(long paramLong) {
/* 678 */     if (a() != null) {
/* 679 */       a().g(paramLong);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(m paramm) {
/* 689 */     if (a() != null) {
/* 690 */       a().a(paramm);
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
/*     */   protected void a(f paramf, a parama) {
/* 702 */     SwingUtilities.invokeLater(() -> {
/*     */           if (isRunning()) {
/*     */             a().a(parama);
/*     */             a(paramf);
/*     */           } 
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void a(f paramf) {
/* 712 */     a().a(paramf);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ad() {
/* 719 */     a().a((a)this.a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ae() {
/* 726 */     if (isRunning()) {
/* 727 */       a().a((a)this.a);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void i(long paramLong) {
/* 737 */     if (paramLong <= 0L) {
/*     */       return;
/*     */     }
/*     */     
/*     */     try {
/* 742 */       Thread.sleep(paramLong);
/* 743 */     } catch (InterruptedException interruptedException) {}
/*     */   }
/*     */ 
/*     */   
/*     */   public String a(f paramf) {
/* 748 */     return (paramf instanceof f) ? "Item" : "Grupo";
/*     */   }
/*     */   
/*     */   public e a(String paramString) {
/* 752 */     if (a() == null) {
/* 753 */       return null;
/*     */     }
/*     */     
/* 756 */     return a().a().a(paramString);
/*     */   }
/*     */   
/*     */   public e b(String paramString) {
/* 760 */     if (a() == null) {
/* 761 */       return null;
/*     */     }
/*     */     
/* 764 */     return a().a().b(paramString);
/*     */   }
/*     */   
/*     */   public e a(int paramInt) {
/* 768 */     if (a() == null) {
/* 769 */       return null;
/*     */     }
/*     */     
/* 772 */     return a().a().a(paramInt);
/*     */   }
/*     */   
/*     */   public final i a() {
/* 776 */     if (a() == null) {
/* 777 */       return null;
/*     */     }
/*     */     
/* 780 */     return a().a();
/*     */   }
/*     */   
/*     */   public j a() {
/* 784 */     return a().a();
/*     */   }
/*     */   
/*     */   public i a() {
/* 788 */     return (i)this.a;
/*     */   }
/*     */   
/*     */   public boolean isRunning() {
/* 792 */     return this.b.get();
/*     */   }
/*     */   
/*     */   public t c() {
/* 796 */     return (t)this.a;
/*     */   }
/*     */   
/*     */   public void a(e parame) {
/* 800 */     this.a = (h)parame;
/*     */   }
/*     */   
/*     */   protected e a() {
/* 804 */     return (e)this.a;
/*     */   }
/*     */   
/*     */   public h a() {
/* 808 */     return this.a;
/*     */   }
/*     */   
/*     */   public void a(h paramh) {
/* 812 */     this.a = paramh;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void j(long paramLong) {
/* 821 */     this.e = paramLong;
/*     */   }
/*     */   
/*     */   protected long b() {
/* 825 */     return this.e;
/*     */   }
/*     */   
/*     */   protected boolean b(int paramInt) {
/* 829 */     f f = null;
/* 830 */     if (a() != null) {
/* 831 */       f = a().a().b(paramInt);
/*     */     }
/*     */     
/* 834 */     return (f != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void k(long paramLong) {
/* 843 */     this.f = paramLong;
/*     */   }
/*     */   
/*     */   public long c() {
/* 847 */     return this.g;
/*     */   }
/*     */   
/*     */   public void l(long paramLong) {
/* 851 */     this.g = paramLong;
/*     */   }
/*     */   
/*     */   public void a(Date paramDate) {
/* 855 */     if (a() != null) {
/* 856 */       a().f(paramDate.getTime());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public b a() {
/* 864 */     return (b)this.b;
/*     */   }
/*     */   
/*     */   public abstract t a();
/*     */   
/*     */   public abstract void R();
/*     */   
/*     */   public abstract void S();
/*     */   
/*     */   protected abstract void a(f paramf, List<h> paramList);
/*     */   
/*     */   public abstract List<h> b(e parame) throws Exception;
/*     */   
/*     */   protected abstract void T();
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */