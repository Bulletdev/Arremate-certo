/*     */ package br.com.arremate.d.a;
/*     */ 
/*     */ import br.com.arremate.a.k;
/*     */ import br.com.arremate.d.a;
/*     */ import br.com.arremate.d.f;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.f.i;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.s;
/*     */ import br.com.arremate.f.v;
/*     */ import br.com.arremate.g.a;
/*     */ import br.com.arremate.g.b;
/*     */ import br.com.arremate.g.e;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.a.a;
/*     */ import br.com.arremate.l.b;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.m.y;
/*     */ import br.com.arremate.n.n;
/*     */ import java.math.BigDecimal;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.Executor;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.TimeUnit;
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
/*     */ public class d
/*     */   extends f
/*     */ {
/*     */   private final Executor executor;
/*     */   private a a;
/*     */   private i b;
/*     */   private List<h> h;
/*     */   private int G;
/*     */   private int H;
/*     */   
/*     */   public d(e parame, i parami, g paramg) {
/*  51 */     super(parame, parami, paramg);
/*     */     
/*  53 */     this.executor = Executors.newCachedThreadPool();
/*  54 */     this.h = new ArrayList<>();
/*     */   }
/*     */ 
/*     */   
/*     */   protected h a() throws b, e, a {
/*  59 */     if (a().a().a().equals(m.c)) {
/*  60 */       if (this.a == null) {
/*  61 */         this.a = new a(this, true);
/*     */       }
/*     */       
/*  64 */       return this.a.a();
/*     */     } 
/*     */     
/*  67 */     return super.a();
/*     */   }
/*     */ 
/*     */   
/*     */   protected synchronized void P() {
/*     */     try {
/*  73 */       if (this.b == null || this.b.length() == 0) {
/*     */         return;
/*     */       }
/*     */       
/*  77 */       ak();
/*  78 */       al();
/*  79 */       aj();
/*     */       
/*  81 */       if (a().a().k() && this.b.has("fatorEqualizacao")) {
/*  82 */         a().a().p(this.b.getDouble("fatorEqualizacao"));
/*     */       }
/*     */       
/*  85 */       ai();
/*     */       
/*  87 */       boolean bool = this.b.getBoolean("vencedor");
/*  88 */       h h = new h(this.b.getDouble("valorMelhorLance"));
/*     */ 
/*     */       
/*  91 */       if (this.b.has("lances") && !this.b.isNull("lances") && h.m() > 0.0D) {
/*  92 */         h.c(new Date(this.b.getLong("dataHoraMelhorLance")));
/*     */         
/*  94 */         double d1 = a().f();
/*  95 */         s s = s.c;
/*     */         
/*  97 */         List<h> list = a(this.b.c("lances"));
/*  98 */         if (list.size() != 1 || this.h.size() <= list.size()) {
/*  99 */           this.h = list;
/*     */         } else {
/* 101 */           bool = ((h)this.h.get(0)).bb();
/*     */         } 
/*     */         
/* 104 */         if (bool) {
/* 105 */           d1 = h.m();
/* 106 */           s = s.a;
/*     */         } else {
/* 108 */           for (h h1 : this.h) {
/* 109 */             if (h1.bb()) {
/* 110 */               d1 = h1.m();
/*     */             }
/*     */           } 
/*     */         } 
/*     */         
/* 115 */         a().h(d1);
/* 116 */         a().h(h);
/* 117 */         a().a(s);
/*     */       } 
/*     */       
/* 120 */       if (a().br()) {
/* 121 */         a().g(a());
/*     */       }
/* 123 */     } catch (RuntimeException runtimeException) {
/* 124 */       a.error("#020", runtimeException);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void ai() {
/* 129 */     if (!this.b.has("valorEntreLancesIguais") || this.b.isNull("valorEntreLancesIguais")) {
/*     */       return;
/*     */     }
/*     */     
/* 133 */     BigDecimal bigDecimal = this.b.getBigDecimal("valorEntreLancesIguais");
/* 134 */     if (bigDecimal.compareTo(BigDecimal.ZERO) <= 0 || bigDecimal.compareTo(a().r()) == 0) {
/*     */       return;
/*     */     }
/*     */     
/* 138 */     a().e(bigDecimal);
/*     */   }
/*     */   
/*     */   private void aj() throws g {
/* 142 */     if (a().bx()) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 147 */     String str1 = "";
/* 148 */     boolean bool = false;
/*     */     
/* 150 */     if (this.b.has("codigoSituacaoLoteDisputaLote")) {
/*     */       
/* 152 */       bool = !this.b.isNull("codigoSituacaoLoteDisputaLote") ? this.b.getInt("codigoSituacaoLoteDisputaLote") : true;
/*     */       
/* 154 */       str1 = a(bool);
/*     */     } 
/*     */     
/* 157 */     if (g.b(a().bB(), g.aW) && 
/* 158 */       !g.b(str1, g.A))
/*     */     {
/* 160 */       str1 = g.aW.getValue();
/*     */     }
/*     */     
/* 163 */     if (str1.isEmpty()) {
/* 164 */       a.warn(String.format("Situação ainda não mapeada para o Banco do Brasil - Situação: %s, codigo: %s", new Object[] { str1, Integer.valueOf(bool) }));
/*     */       
/*     */       return;
/*     */     } 
/* 168 */     String str2 = a().bB();
/* 169 */     a().N(str1);
/*     */     
/* 171 */     if (a().bv() && !a().bB().equals(str2)) {
/* 172 */       DecimalFormat decimalFormat = y.a("###,###,###,##0.0000");
/* 173 */       String str = decimalFormat.format(a().y());
/*     */       
/* 175 */       a().l(
/* 176 */           String.join("", new CharSequence[] {
/*     */               
/* 178 */               "O Lote ", a().bo(), " entrou em Lance Fechado com o valor de ", 
/*     */               
/* 180 */               (a().w() == v.b.v()) ? (str + " %") : ("R$ " + str)
/*     */             }));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private String a(int paramInt) {
/*     */     a a1;
/* 188 */     switch (paramInt) {
/*     */       case 2:
/*     */       case 3:
/* 191 */         return g.y.getValue();
/*     */       case 4:
/* 193 */         return g.A.getValue();
/*     */       case 6:
/* 195 */         return g.C.getValue();
/*     */       case 11:
/* 197 */         return g.z.getValue();
/*     */       case 13:
/* 199 */         return g.F.getValue();
/*     */       case 15:
/*     */       case 17:
/* 202 */         return g.E.getValue();
/*     */       case 21:
/* 204 */         return g.B.getValue();
/*     */       case 22:
/* 206 */         return g.I.getValue();
/*     */       case 23:
/* 208 */         a1 = (a)a().a();
/* 209 */         if (a1.aA()) {
/* 210 */           if (a1.aS()) {
/* 211 */             return g.i.getValue();
/*     */           }
/*     */           
/* 214 */           if (!a1.aR() && a1.aA()) {
/* 215 */             return g.p.getValue();
/*     */           }
/*     */           
/* 218 */           return g.J.getValue();
/*     */         } 
/* 220 */         return a1.bB();
/*     */       
/*     */       case 24:
/* 223 */         return g.K.getValue();
/*     */       case -1:
/*     */       case 5:
/* 226 */         return g.D.getValue();
/*     */     } 
/*     */     
/* 229 */     return "";
/*     */   }
/*     */ 
/*     */   
/*     */   private void ak() throws g {
/* 234 */     if (this.b.has("quantidadeParticipantesPresentes") && 
/* 235 */       !this.b.isNull("quantidadeParticipantesPresentes")) {
/* 236 */       this.G = this.b.getInt("quantidadeParticipantesPresentes");
/*     */     }
/*     */     
/* 239 */     if (this.b.has("quantidadeParticipantesAusentes") && 
/* 240 */       !this.b.isNull("quantidadeParticipantesAusentes")) {
/* 241 */       this.H = this.b.getInt("quantidadeParticipantesAusentes");
/*     */     }
/*     */   }
/*     */   
/*     */   private void al() throws g {
/* 246 */     if (this.b == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 251 */     if (this.b.has("mensagens") && !this.b.isNull("mensagens")) {
/* 252 */       f f1 = this.b.c("mensagens");
/*     */       
/* 254 */       if (f1.length() > 0) {
/* 255 */         a().b(Integer.valueOf(a().a().v()), f1);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean a(i parami, String paramString) {
/* 262 */     return (parami == i.a || 
/* 263 */       a().bu() || a().bv());
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> e() {
/* 268 */     return (this.h == null) ? new ArrayList<>() : this.h;
/*     */   }
/*     */   
/*     */   private List<h> a(f paramf) {
/* 272 */     ArrayList<h> arrayList = new ArrayList();
/*     */     
/* 274 */     for (byte b = 0; b < paramf.length(); b++) {
/* 275 */       i i1 = paramf.b(b);
/* 276 */       int j = i1.getInt("classificacao");
/* 277 */       double d1 = i1.getDouble("valor");
/* 278 */       Date date = new Date(i1.getLong("dataHora"));
/* 279 */       boolean bool = i1.getBoolean("seuLance");
/*     */       
/* 281 */       h h = new h();
/* 282 */       h.l(j);
/* 283 */       h.q(d1);
/* 284 */       h.c(date);
/* 285 */       h.A(bool);
/*     */       
/* 287 */       arrayList.add(h);
/*     */     } 
/*     */     
/* 290 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean a(h paramh, boolean paramBoolean) {
/* 295 */     if (!b(paramh.m()) && !paramBoolean) {
/* 296 */       a.warn("Tentativa de lance abaixo do mínimo");
/* 297 */       return false;
/*     */     } 
/*     */     
/* 300 */     a a1 = (a)a().a();
/* 301 */     if (a(paramBoolean, a1, paramh)) {
/* 302 */       return false;
/*     */     }
/*     */     
/* 305 */     j j = null;
/*     */     
/*     */     try {
/* 308 */       h h1 = a().a();
/* 309 */       j = h1.a();
/* 310 */       if (j != null) {
/*     */ 
/*     */         
/* 313 */         if (!k.b()) {
/* 314 */           a1.w(a1.aR());
/* 315 */           a1.y(n.a().longValue());
/* 316 */           a("Simula disputa", paramh, m(), paramBoolean, new String[] {
/* 317 */                 String.join("", new CharSequence[] { "Logins ativos para lance: ", Integer.toString(h1.n()) })
/*     */               });
/* 319 */           this.executor.execute(j);
/* 320 */           return true;
/*     */         } 
/*     */         
/* 323 */         i i1 = j.a(a(paramh.m()), a1);
/* 324 */         long l = i1.getLong("elapsedTime");
/*     */         
/* 326 */         if (i1.has("jsonRetorno")) {
/* 327 */           a(paramh, paramBoolean, i1.j("jsonRetorno"), l);
/* 328 */           this.executor.execute(j);
/* 329 */           return true;
/* 330 */         }  if (i1.has("mensagemErro")) {
/* 331 */           String str = i1.getString("mensagemErro");
/* 332 */           if (str.contains("Apenas o fornecedor com uma proposta válida poderá registrar um lance")) {
/* 333 */             a1.N(g.aW.getValue());
/* 334 */           } else if (str.contains("não se encontra em situação")) {
/* 335 */             str = str + " -- Situação: " + a().bB();
/* 336 */           } else if (str.contains("O texto enviado não confere com o da imagem")) {
/* 337 */             str = str + " | Texto do captcha: " + i1.getString("captchaText");
/*     */           } 
/*     */           
/* 340 */           a("Tentativa de lance", paramh, m(), paramBoolean, new String[] { "Mensagem de erro: " + str });
/*     */           
/* 342 */           if (!paramBoolean && str.contains("foi encaminhado para disputa do lote")) {
/* 343 */             this.executor.execute(j);
/* 344 */             return a(paramh);
/*     */           } 
/*     */         } else {
/* 347 */           a("Tentativa de lance", paramh, m(), paramBoolean, new String[] {
/* 348 */                 String.join("", new CharSequence[] { "Mensagem de retorno do portal sem informações após ", Long.toString(l), "ms" })
/*     */               });
/*     */         } 
/* 351 */         this.executor.execute(j);
/*     */       } else {
/* 353 */         a("Lance não enviado", paramh, m(), paramBoolean, new String[] { "Sem logins disponíveis para lance", 
/*     */               
/* 355 */               String.join("", new CharSequence[] { "Logins enviando lance/quebrando captcha: ", Integer.toString(h1.o())
/* 356 */                 }), String.join("", new CharSequence[] { "Logins capturando sessão: ", Integer.toString(h1.m()) }) });
/*     */       }
/*     */     
/* 359 */     } catch (Exception exception) {
/* 360 */       a.error("Item {}, disputa {} - Erro ao enviar lance", new Object[] { a().bo(), Integer.valueOf(a().a().v()), exception });
/*     */       
/* 362 */       if (j != null) {
/* 363 */         this.executor.execute(j);
/*     */       }
/*     */     } 
/*     */     
/* 367 */     return false;
/*     */   }
/*     */   
/*     */   private boolean a(boolean paramBoolean, a parama, h paramh) {
/* 371 */     if (parama.B() <= 0L || parama
/* 372 */       .at() || paramBoolean || paramh
/*     */       
/* 374 */       .j() != 1 || this.h
/* 375 */       .isEmpty()) {
/* 376 */       return false;
/*     */     }
/*     */     
/* 379 */     long l = a(parama);
/* 380 */     if (l >= TimeUnit.SECONDS.toMillis(10L)) {
/* 381 */       return true;
/*     */     }
/*     */     
/* 384 */     if (l > 50L) {
/*     */       try {
/* 386 */         Thread.sleep(l);
/* 387 */       } catch (InterruptedException interruptedException) {}
/*     */     }
/*     */ 
/*     */     
/* 391 */     return false;
/*     */   }
/*     */   
/*     */   private long a(a parama) {
/* 395 */     long l = ((h)this.h.get(0)).b().getTime() + parama.B();
/* 396 */     l -= y.i().getTimeInMillis();
/* 397 */     return l;
/*     */   }
/*     */   
/*     */   private void a(h paramh, boolean paramBoolean, i parami, long paramLong) throws NumberFormatException, g {
/* 401 */     a a1 = (a)a().a();
/*     */ 
/*     */     
/* 404 */     double d1 = paramLong / 1000.0D;
/* 405 */     DecimalFormat decimalFormat = new DecimalFormat("#.##");
/* 406 */     String str = decimalFormat.format(d1);
/*     */     
/* 408 */     h h1 = a().a();
/* 409 */     a("Lance enviado", paramh, m(), paramBoolean, new String[] {
/* 410 */           String.join("", new CharSequence[] { "Tempo para envio: ", str
/* 411 */             }), String.join("", new CharSequence[] { "Logins ativos para lance: ", Integer.toString(h1.n()) })
/*     */         });
/*     */     
/* 414 */     a1.w(a1.aR());
/* 415 */     a1.y(n.a().longValue());
/*     */     
/* 417 */     if (parami.has("disputas") && !parami.isNull("disputas")) {
/* 418 */       f f1 = parami.c("disputas");
/*     */       
/* 420 */       if (f1.length() > 0) {
/* 421 */         for (byte b = 0; b < f1.length(); b++) {
/* 422 */           i i1 = f1.b(b);
/* 423 */           int j = i1.getInt("codigoLicitacaoDisputaLote");
/* 424 */           int k = i1.getInt("codigoLoteDisputaLote");
/*     */ 
/*     */           
/* 427 */           if (j == a().a().v() && a1.v() == k) {
/* 428 */             a(i1);
/* 429 */             P();
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       }
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
/*     */   protected boolean a(h paramh) {
/* 447 */     b b = a().b();
/*     */ 
/*     */     
/* 450 */     if (b.f() != b.g() && 
/* 451 */       !m().equals("Lance Derradeiro")) {
/* 452 */       return false;
/*     */     }
/*     */     
/* 455 */     h h1 = a(paramh, m());
/*     */     
/* 457 */     if (h1.m() > 0.0D) {
/* 458 */       return a(h1, false);
/*     */     }
/*     */     
/* 461 */     return false;
/*     */   }
/*     */   
/*     */   private h a(h paramh, String paramString) {
/* 465 */     long l1 = 0L;
/* 466 */     long l2 = (long)(paramh.m() * 100.0D);
/* 467 */     long l3 = (long)(a().l() * 100.0D);
/* 468 */     long l4 = (long)(a().f() * 100.0D);
/*     */     
/* 470 */     if (l3 < l2) {
/*     */       
/* 472 */       l1 = l2 - 1L;
/* 473 */     } else if (paramString.equals("Lance Derradeiro") || l2 < l4) {
/*     */       
/* 475 */       l1 = l2 + 1L;
/*     */       
/* 477 */       if (l1 >= l4) {
/* 478 */         l1 = 0L;
/*     */       }
/*     */     } 
/*     */     
/* 482 */     double d1 = l1 / 100.0D;
/*     */     
/* 484 */     return new h(d1);
/*     */   }
/*     */   
/*     */   private double a(double paramDouble) {
/* 488 */     double d1 = a().a().a();
/* 489 */     if (d1 > 0.0D) {
/* 490 */       return paramDouble / d1;
/*     */     }
/* 492 */     return paramDouble;
/*     */   }
/*     */ 
/*     */   
/*     */   public i a() {
/* 497 */     return (i)super.b();
/*     */   }
/*     */   
/*     */   public void a(i parami) {
/* 501 */     this.b = parami;
/*     */   }
/*     */   
/*     */   public int k() {
/* 505 */     return this.G;
/*     */   }
/*     */   
/*     */   public void v(int paramInt) {
/* 509 */     this.G = paramInt;
/*     */   }
/*     */   
/*     */   public int l() {
/* 513 */     return this.H;
/*     */   }
/*     */   
/*     */   public void w(int paramInt) {
/* 517 */     this.H = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\a\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */