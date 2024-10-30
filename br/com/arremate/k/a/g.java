/*     */ package br.com.arremate.k.a;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.p;
/*     */ import br.com.arremate.f.r;
/*     */ import br.com.arremate.f.s;
/*     */ import br.com.arremate.f.v;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.k.c.c;
/*     */ import br.com.arremate.l.c;
/*     */ import br.com.arremate.l.e;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.k;
/*     */ import br.com.arremate.l.p;
/*     */ import br.com.arremate.l.p.b;
/*     */ import br.com.arremate.l.p.f;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.l.q.b.f;
/*     */ import br.com.arremate.l.q.b.h;
/*     */ import br.com.arremate.l.q.b.i;
/*     */ import br.com.arremate.l.q.c.a;
/*     */ import br.com.arremate.l.q.c.e;
/*     */ import br.com.arremate.l.q.c.k;
/*     */ import br.com.arremate.l.q.c.n;
/*     */ import br.com.arremate.m.A;
/*     */ import br.com.arremate.m.d;
/*     */ import br.com.arremate.m.n;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import javax.swing.JOptionPane;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class g
/*     */ {
/*  49 */   protected static final Logger a = LoggerFactory.getLogger(g.class);
/*     */   
/*     */   private final j a;
/*     */   
/*     */   private final AtomicBoolean i;
/*     */   private boolean E;
/*     */   private br.com.arremate.d.g e;
/*     */   private br.com.arremate.d.g f;
/*     */   private long G;
/*     */   private String dr;
/*     */   private String ds;
/*     */   boolean F;
/*     */   
/*     */   public g(j paramj) {
/*  63 */     this.i = new AtomicBoolean(true);
/*  64 */     this.a = paramj;
/*  65 */     this.E = false;
/*  66 */     this.dr = null;
/*  67 */     this.F = false;
/*     */   }
/*     */   
/*     */   public List<e> x() {
/*  71 */     return new ArrayList<>();
/*     */   }
/*     */   
/*     */   public final String aW() {
/*  75 */     StringBuilder stringBuilder = new StringBuilder("SELECT");
/*  76 */     stringBuilder.append(" COALESCE(TRIM(REPLACE(tbitemlicitacao.itegrupo, 'G', '')), 9999)::NUMERIC AS column_order_grupo,");
/*  77 */     stringBuilder.append(" tbitemlicitacao.itecodigo,");
/*  78 */     stringBuilder.append(" tbitemlicitacao.itenumero,");
/*  79 */     stringBuilder.append(" tbitemlicitacao.itedescricao,");
/*  80 */     stringBuilder.append(" tbitemlicitacao.itequantidade,");
/*  81 */     stringBuilder.append(" tbitemlicitacao.itevalortotal,");
/*  82 */     stringBuilder.append(" tbitemlicitacao.itegrupo,");
/*  83 */     stringBuilder.append(" tbitemlicitacao.iteposicao,");
/*  84 */     stringBuilder.append(" tbitemlicitacao.itetempominimoentrelances,");
/*  85 */     stringBuilder.append(" tbitemlicitacao.itevalorminimoentrepropriolance,");
/*  86 */     stringBuilder.append(" tbitemlicitacao.itevalorminimoentremelhorlance,");
/*  87 */     stringBuilder.append(" tbitemlicitacao.itepercentualminimoentrelance,");
/*  88 */     stringBuilder.append(" tbitemlicitacao.itecodigogrupo,");
/*  89 */     stringBuilder.append(" tbitemlicitacao.itesituacao,");
/*  90 */     stringBuilder.append(" tbitemlicitacao.itestatuslance,");
/*  91 */     stringBuilder.append(" tbitemlicitacao.itemelhorlance,");
/*  92 */     stringBuilder.append(" tbitemlicitacao.iteultimolance,");
/*  93 */     stringBuilder.append(" tbitemlicitacao.itevencedorcnpj,");
/*  94 */     stringBuilder.append(" tbitemlicitacao.itevencedornomeempresa,");
/*  95 */     stringBuilder.append(" tbitemlicitacao.itevencedorporte,");
/*  96 */     stringBuilder.append(" tbitemlicitacao.itevencedormodelo,");
/*  97 */     stringBuilder.append(" tbitemlicitacao.itevencedormarca,");
/*  98 */     stringBuilder.append(" tbitemlicitacao.itevencedorfabricante,");
/*  99 */     stringBuilder.append(" tbitemlicitacao.itetipo,");
/* 100 */     stringBuilder.append(" tbitemlicitacao.itetempominimoentremelhorlance,");
/* 101 */     stringBuilder.append(" tbitemlicitacao.iteequalizacao,");
/* 102 */     stringBuilder.append(" tbitemlicitacao.itedescricaocompleta,");
/* 103 */     stringBuilder.append(" tbitemlicitacao.itevalorlancefechado,");
/* 104 */     stringBuilder.append(" tbitemlicitacao.iteunidademedida,");
/* 105 */     stringBuilder.append(" tbitemlicitacao.iteidempresa,");
/* 106 */     stringBuilder.append(" tbitemlicitacao.iteunitario,");
/* 107 */     stringBuilder.append(" CASE ");
/* 108 */     stringBuilder.append(" WHEN tblicitacao.licunitario = true THEN tbitemlicitacao.itevalorunitario");
/* 109 */     stringBuilder.append(" WHEN tbitemlicitacao.iteunitario = true THEN tbitemlicitacao.itevalorunitario");
/* 110 */     stringBuilder.append(" WHEN tblicitacao.licunitario IS NULL AND tblicitacao.licsrp IS TRUE THEN tbitemlicitacao.itevalorunitario");
/* 111 */     stringBuilder.append(" ELSE tbitemlicitacao.itevalortotal");
/* 112 */     stringBuilder.append(" END AS itevalorproposta,");
/* 113 */     stringBuilder.append(" CASE ");
/* 114 */     stringBuilder.append(" WHEN tbitemlicitacao.itevalorminimo IS NOT NULL THEN tbitemlicitacao.itevalorminimo ");
/* 115 */     stringBuilder.append(" WHEN tblicitacao.licunitario = true THEN tbitemlicitacao.itevalorunitario");
/* 116 */     stringBuilder.append(" WHEN tbitemlicitacao.iteunitario = true THEN tbitemlicitacao.itevalorunitario");
/* 117 */     stringBuilder.append(" ELSE tbitemlicitacao.itevalortotal");
/* 118 */     stringBuilder.append(" END AS itevalorminimo");
/* 119 */     stringBuilder.append(" FROM tbitemlicitacao");
/* 120 */     stringBuilder.append(" INNER JOIN tblicitacao ON tblicitacao.liccodigo = tbitemlicitacao.liccodigo AND tblicitacao.empcnpj = tbitemlicitacao.empcnpj ");
/* 121 */     stringBuilder.append(" WHERE tbitemlicitacao.empcnpj = ").append(a().C());
/* 122 */     stringBuilder.append(" AND tbitemlicitacao.liccodigo = ").append(a().v());
/* 123 */     stringBuilder.append(" AND tbitemlicitacao.porcodigo = ").append(a().b().v());
/* 124 */     stringBuilder.append(" ORDER BY column_order_grupo, tbitemlicitacao.itenumero");
/* 125 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void b(e parame, List<e> paramList) {
/* 136 */     f f = new f(parame);
/* 137 */     f.N(parame.a(0).bB());
/* 138 */     paramList.add(f);
/*     */ 
/*     */     
/* 141 */     for (br.com.arremate.l.g g1 : parame.B()) {
/* 142 */       br.com.arremate.l.q.b.g g2 = new br.com.arremate.l.q.b.g(g1, parame);
/* 143 */       paramList.add(g2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean ak() {
/* 154 */     try (Statement null = a.a().createStatement()) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 159 */       String str = "SELECT COUNT(*) AS contem_grupo FROM tbitemlicitacao WHERE tbitemlicitacao.empcnpj = " + a().a().x() + " AND tbitemlicitacao.liccodigo = " + a().v() + " AND tbitemlicitacao.porcodigo = " + a().b().v() + " AND NOT tbitemlicitacao.itegrupo IS NULL AND tbitemlicitacao.itegrupo <> ''";
/*     */ 
/*     */       
/* 162 */       ResultSet resultSet = statement.executeQuery(str);
/*     */       
/* 164 */       if (resultSet.next()) {
/* 165 */         return resultSet.getBoolean("contem_grupo");
/*     */       }
/*     */     }
/* 168 */     catch (Exception exception) {
/* 169 */       a.warn("Falha ao verificar se a disputa possui grupo", exception);
/*     */     } 
/*     */     
/* 172 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean e(String paramString1, String paramString2) {
/* 183 */     StringBuilder stringBuilder = new StringBuilder("Este procedimento irá remover o pregão ");
/* 184 */     stringBuilder.append(paramString1);
/* 185 */     stringBuilder.append(" do órgão ");
/* 186 */     stringBuilder.append(paramString2);
/* 187 */     stringBuilder.append("\n\nEmpresa: ");
/* 188 */     stringBuilder.append(a().a().bv());
/* 189 */     stringBuilder.append("\n\nDeseja realmente realizar a operação?");
/*     */     
/* 191 */     int i = JOptionPane.showConfirmDialog(null, stringBuilder.toString(), "Mensagem", 0, 2);
/*     */ 
/*     */     
/* 194 */     if (i == 0) {
/* 195 */       if (a().delete()) {
/* 196 */         return true;
/*     */       }
/*     */       
/* 199 */       String str = "Erro ao remover pregão, tente novamente";
/* 200 */       JOptionPane.showMessageDialog(null, str, "Mensagem", 0);
/*     */     } 
/* 202 */     return false;
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
/*     */   public synchronized void a(i parami, br.com.arremate.l.p.g paramg) {
/* 214 */     if (!A.a().bX()) {
/*     */       return;
/*     */     }
/* 217 */     byte b1 = 0;
/* 218 */     byte b2 = 0;
/* 219 */     byte b3 = 0;
/* 220 */     byte b4 = 0;
/* 221 */     double d1 = 0.0D;
/* 222 */     double d2 = 0.0D;
/*     */     
/* 224 */     for (e e : parami.L()) {
/* 225 */       if (!(e instanceof f)) {
/* 226 */         b1++;
/*     */       }
/*     */       
/* 229 */       if (e instanceof br.com.arremate.l.q.b.g) {
/*     */         continue;
/*     */       }
/*     */ 
/*     */       
/* 234 */       if (!e.br() && !e.bx()) {
/*     */         continue;
/*     */       }
/*     */       
/* 238 */       double d3 = e.l();
/* 239 */       double d4 = e.f().m();
/* 240 */       s s = e.a();
/*     */       
/* 242 */       switch (null.j[s.ordinal()]) {
/*     */         case 1:
/* 244 */           if (!e.bs()) {
/* 245 */             d1 += a(e);
/* 246 */             d2 += b(e);
/* 247 */             b2++;
/*     */           } 
/*     */         
/*     */         case 2:
/*     */         case 3:
/* 252 */           b3++;
/*     */           
/* 254 */           if (d3 < d4) {
/* 255 */             b4++;
/*     */           }
/*     */       } 
/*     */ 
/*     */ 
/*     */     
/*     */     } 
/* 262 */     b b = new b(a());
/* 263 */     b.af(b1);
/* 264 */     b.ac(b2);
/* 265 */     b.ad(b3);
/* 266 */     b.ae(b4);
/* 267 */     b.af(parami.getRowCount());
/* 268 */     b.t(d1);
/* 269 */     b.s(d2);
/* 270 */     b.a(paramg);
/* 271 */     f.a().a(b);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void b(i parami, br.com.arremate.l.p.g paramg) throws Exception {
/* 282 */     a(parami, paramg);
/* 283 */     f.a().cs();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private double a(e parame) {
/* 293 */     if (parame.w() == v.b.v()) {
/* 294 */       return 0.0D;
/*     */     }
/*     */     
/* 297 */     double d = parame.f().m() - parame.l();
/*     */ 
/*     */     
/* 300 */     if ((a().aZ() || parame.a().aZ()) && !(parame instanceof f)) {
/* 301 */       d *= parame.i();
/*     */     }
/*     */     
/* 304 */     return (d > 0.0D) ? d : 0.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private double b(e parame) {
/* 314 */     if (parame.w() == v.b.v()) {
/* 315 */       return 0.0D;
/*     */     }
/*     */     
/* 318 */     double d = parame.f().m();
/*     */ 
/*     */     
/* 321 */     if ((a().aZ() || parame.a().aZ()) && !(parame instanceof f)) {
/* 322 */       d *= parame.i();
/*     */     }
/*     */     
/* 325 */     return d;
/*     */   }
/*     */   
/*     */   public void z(e parame) throws Exception {
/* 329 */     if (q())
/*     */     {
/* 331 */       parame.a(r.a);
/*     */     }
/*     */     
/* 334 */     if (parame instanceof f) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 339 */     String str = "UPDATE tbitemlicitacao SET itevalorminimo = ? WHERE empcnpj = ? AND liccodigo = ? AND itecodigo = ? AND porcodigo = ?";
/*     */     
/* 341 */     byte b = 1;
/*     */     
/* 343 */     try (PreparedStatement null = a.a().prepareStatement(str)) {
/* 344 */       preparedStatement.setDouble(b++, parame.a().l());
/* 345 */       preparedStatement.setLong(b++, a().C());
/* 346 */       preparedStatement.setInt(b++, a().v());
/* 347 */       preparedStatement.setInt(b++, parame.a().v());
/* 348 */       preparedStatement.setInt(b++, a().b().v());
/*     */       
/* 350 */       if (preparedStatement.executeUpdate() == 0) {
/* 351 */         throw new Exception("Não atualizou nenhum dado");
/*     */       }
/* 353 */     } catch (Exception exception) {
/* 354 */       a.warn("Não atualizou nenhum dado", exception);
/* 355 */       throw exception;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void A(e parame) throws Exception {
/* 360 */     if (parame.a().a() != m.c) {
/*     */       return;
/*     */     }
/*     */     
/* 364 */     if (q())
/*     */     {
/* 366 */       parame.a(r.a);
/*     */     }
/*     */     
/* 369 */     if (parame instanceof f) {
/*     */       return;
/*     */     }
/*     */     
/* 373 */     if (parame.a().aY()) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 378 */     String str = "UPDATE tbitemlicitacao SET itevalorlancefechado = ? WHERE empcnpj = ? AND liccodigo = ? AND itecodigo = ? AND porcodigo = ?";
/*     */     
/* 380 */     byte b = 1;
/*     */     
/* 382 */     try (PreparedStatement null = a.a().prepareStatement(str)) {
/* 383 */       preparedStatement.setBigDecimal(b++, parame.a().t());
/* 384 */       preparedStatement.setLong(b++, a().C());
/* 385 */       preparedStatement.setInt(b++, a().v());
/* 386 */       preparedStatement.setInt(b++, parame.a().v());
/* 387 */       preparedStatement.setInt(b++, a().b().v());
/*     */       
/* 389 */       if (preparedStatement.executeUpdate() == 0) {
/* 390 */         throw new Exception("Não atualizou nenhum dado");
/*     */       }
/* 392 */     } catch (Exception exception) {
/* 393 */       a.warn("Não atualizou nenhum dado", exception);
/* 394 */       throw exception;
/*     */     } 
/*     */   }
/*     */   
/*     */   public Map<Integer, Integer> m() {
/* 399 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     
/* 401 */     hashMap.put(Integer.valueOf(0), Integer.valueOf(0));
/* 402 */     hashMap.put(Integer.valueOf(1), Integer.valueOf(20));
/* 403 */     hashMap.put(Integer.valueOf(2), Integer.valueOf(20));
/* 404 */     hashMap.put(Integer.valueOf(3), Integer.valueOf(20));
/* 405 */     hashMap.put(Integer.valueOf(6), Integer.valueOf(70));
/* 406 */     hashMap.put(Integer.valueOf(4), Integer.valueOf(0));
/*     */     
/* 408 */     char c1 = 'Ɨ';
/* 409 */     char c2 = '';
/*     */ 
/*     */ 
/*     */     
/* 413 */     if (n.aE()) {
/* 414 */       hashMap.put(Integer.valueOf(5), Integer.valueOf(80));
/* 415 */       c1 -= 'P';
/*     */     } else {
/* 417 */       hashMap.put(Integer.valueOf(5), Integer.valueOf(0));
/*     */     } 
/*     */     
/* 420 */     if (a().a() == m.c) {
/* 421 */       hashMap.put(Integer.valueOf(11), Integer.valueOf(105));
/* 422 */       c1 -= 'i';
/*     */     } else {
/* 424 */       hashMap.put(Integer.valueOf(11), Integer.valueOf(0));
/*     */       
/* 426 */       if (a().b().bk() && 
/* 427 */         a().a().a() == p.c) {
/* 428 */         hashMap.put(Integer.valueOf(4), Integer.valueOf(60));
/* 429 */         c1 -= '<';
/*     */       } else {
/* 431 */         c1 -= '(';
/* 432 */         c2 += '(';
/*     */       } 
/*     */     } 
/*     */     
/* 436 */     hashMap.put(Integer.valueOf(7), Integer.valueOf(c1));
/* 437 */     hashMap.put(Integer.valueOf(9), Integer.valueOf(105));
/* 438 */     hashMap.put(Integer.valueOf(10), Integer.valueOf(105));
/* 439 */     hashMap.put(Integer.valueOf(8), Integer.valueOf(c2));
/* 440 */     hashMap.put(Integer.valueOf(12), Integer.valueOf(105));
/* 441 */     hashMap.put(Integer.valueOf(13), Integer.valueOf(105));
/* 442 */     hashMap.put(Integer.valueOf(15), Integer.valueOf(30));
/* 443 */     hashMap.put(Integer.valueOf(16), Integer.valueOf(30));
/* 444 */     hashMap.put(Integer.valueOf(14), Integer.valueOf(60));
/* 445 */     hashMap.put(Integer.valueOf(17), Integer.valueOf(0));
/*     */     
/* 447 */     return (Map)hashMap;
/*     */   }
/*     */   
/*     */   public void b(h paramh) {
/* 451 */     p p = a(paramh);
/* 452 */     d d = new d(p);
/* 453 */     Map map = d.q();
/*     */     
/* 455 */     if (!map.isEmpty()) {
/* 456 */       d.d(map);
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(h paramh) {
/* 461 */     StringBuilder stringBuilder = new StringBuilder("Arremate_");
/* 462 */     stringBuilder.append(a().b().a().N());
/* 463 */     stringBuilder.append("_");
/* 464 */     stringBuilder.append(a().K());
/* 465 */     stringBuilder.append("_");
/* 466 */     stringBuilder.append(a().bo());
/*     */     
/* 468 */     p p = a(paramh);
/* 469 */     d d = new d(p);
/* 470 */     d.aH(stringBuilder.toString());
/*     */   }
/*     */   
/*     */   protected p a(h paramh) {
/* 474 */     p p = new p(a());
/*     */     
/* 476 */     i i = (i)paramh.getModel();
/* 477 */     ArrayList arrayList = new ArrayList(i.L());
/*     */ 
/*     */     
/* 480 */     arrayList.forEach(parame -> {
/*     */           if (!(parame instanceof f)) {
/*     */             k k = new k(parame.a());
/*     */             
/*     */             k.aB(String.valueOf(parame.a().bo()));
/*     */             paramp.a(k);
/*     */           } 
/*     */         });
/* 488 */     return p;
/*     */   }
/*     */   
/*     */   public String aU() {
/* 492 */     return a().bo();
/*     */   }
/*     */   
/*     */   public void a(b paramb, k paramk) {
/* 496 */     if (this.E) {
/* 497 */       JOptionPane.showMessageDialog(null, "Já existe uma exportação de itens encerrados! Aguarde sua finalização e tente novamente.");
/*     */       return;
/*     */     } 
/* 500 */     this.E = true;
/*     */     
/* 502 */     (new Thread(() -> {
/*     */           a a = e.a(paramk, this);
/*     */           
/*     */           if (paramk.getModel().getRowCount() == 0) {
/*     */             String str = "O pregão " + aU() + " não possui nenhum item encerrado.";
/*     */             JOptionPane.showMessageDialog(null, str, "Erro", 0);
/*     */             this.E = false;
/*     */             return;
/*     */           } 
/*     */           a.a(paramb);
/*     */           this.E = false;
/* 513 */         })).start();
/*     */   }
/*     */   
/*     */   public void a(b paramb, k paramk, String paramString) {
/* 517 */     if (this.E) {
/* 518 */       JOptionPane.showMessageDialog(null, "Já existe uma exportação de itens encerrados! Aguarde sua finalização e tente novamente.");
/*     */       return;
/*     */     } 
/* 521 */     this.E = true;
/*     */     
/* 523 */     (new Thread(() -> {
/*     */           a a = e.a(paramk, this, paramString);
/*     */           
/*     */           if (paramk.getModel().getRowCount() == 0) {
/*     */             String str = "O pregão " + aU() + " não possui nenhum item encerrado.";
/*     */             JOptionPane.showMessageDialog(null, str, "Erro", 0);
/*     */             this.E = false;
/*     */             return;
/*     */           } 
/*     */           a.a(paramb);
/*     */           this.E = false;
/* 534 */         })).start();
/*     */   }
/*     */   
/*     */   public void y(e parame) {
/* 538 */     if (a().b().bk() && 
/* 539 */       a().a().a() != p.c) {
/*     */       
/* 541 */       StringBuilder stringBuilder = new StringBuilder();
/* 542 */       stringBuilder.append("A disputa contra ME/EPP está disponível somente para indústrias, e sua empresa (");
/* 543 */       stringBuilder.append(a().a().bv().toUpperCase());
/* 544 */       stringBuilder.append(") está enquadrada no regime ME/EPP.");
/*     */       
/* 546 */       JOptionPane.showMessageDialog(null, stringBuilder.toString(), "Erro", 0);
/*     */     } else {
/* 548 */       parame.q(!parame.aU());
/*     */     } 
/*     */   }
/*     */   
/*     */   public c a() {
/* 553 */     String str1 = a().b().K();
/* 554 */     String str2 = a().a().bv();
/* 555 */     String str3 = a().bo();
/*     */     
/* 557 */     String str4 = (a().K() != 999) ? Integer.toString(a().K()) : "";
/*     */     
/* 559 */     String str5 = a().bT();
/* 560 */     String str6 = Integer.toString(a().v());
/* 561 */     String str7 = a().bS();
/* 562 */     boolean bool = a().bf();
/*     */     
/* 564 */     return new c(str1, str2, str6, str3, str4, str5, str7, "", bool);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String aV() {
/* 571 */     StringBuilder stringBuilder = new StringBuilder();
/* 572 */     String str = Integer.toString(a().K());
/*     */     
/* 574 */     if (!"999".equals(str)) {
/* 575 */       stringBuilder.append(str).append(" - ");
/*     */     }
/*     */     
/* 578 */     stringBuilder.append(a().bT());
/* 579 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public String getTitle() {
/* 583 */     String str = a().b().a().N();
/* 584 */     int i = a().K();
/* 585 */     StringBuilder stringBuilder = (new StringBuilder(str)).append(": ");
/*     */     
/* 587 */     if (i != 999) {
/* 588 */       stringBuilder.append(i).append(" - ");
/*     */     }
/*     */     
/* 591 */     stringBuilder.append(a().bo());
/* 592 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public boolean a(b paramb) {
/* 596 */     this.ds = null;
/*     */     
/*     */     try {
/* 599 */       if (this.e != null && this.e.isAlive() && !this.e.isInterrupted()) {
/* 600 */         return false;
/*     */       }
/*     */       
/* 603 */       Future<i> future = c.b(this.a);
/* 604 */       i i = future.get();
/*     */ 
/*     */       
/* 607 */       if (a().a().aO() && i != null && i.isRunning()) {
/* 608 */         this.e = a(paramb, i);
/* 609 */         this.e.start();
/* 610 */         return true;
/*     */       } 
/*     */       
/* 613 */       if (i != null && i.getMessage() != null && !i.getMessage().isEmpty()) {
/* 614 */         this.ds = i.getMessage();
/*     */       }
/* 616 */     } catch (Exception exception) {
/* 617 */       a.error("Failed to start bid", exception);
/*     */     } 
/*     */     
/* 620 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public br.com.arremate.d.g b(b paramb, i parami) {
/* 626 */     return a(paramb, parami);
/*     */   }
/*     */   
/*     */   public boolean al() {
/* 630 */     if (this.e == null) {
/* 631 */       return false;
/*     */     }
/*     */     
/* 634 */     this.e.ab();
/* 635 */     return true;
/*     */   }
/*     */   
/*     */   public boolean d(e parame, double paramDouble) {
/* 639 */     cl();
/*     */     
/* 641 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */   
/*     */   public boolean am() {
/* 645 */     if (this.i.get()) {
/* 646 */       this.i.set(false);
/* 647 */       return true;
/*     */     } 
/*     */     
/* 650 */     String str = "Já existe uma solicitação em andamento. Aguarde o fim do processo para realizar esta operação!";
/* 651 */     JOptionPane.showMessageDialog(null, str, "Erro", 0);
/* 652 */     return false;
/*     */   }
/*     */   
/*     */   public void ck() {
/* 656 */     this.i.set(true);
/*     */   }
/*     */   
/*     */   public List<h> b(e parame) {
/* 660 */     return a(parame, (i)null);
/*     */   }
/*     */   
/*     */   public List<h> a(e parame, i parami) {
/* 664 */     List<h> list = null;
/*     */     
/*     */     try {
/* 667 */       if (this.e != null && this.e.isRunning()) {
/* 668 */         this.f = this.e;
/*     */       } else {
/* 670 */         a(parame, parami);
/*     */       } 
/*     */       
/* 673 */       if (this.f == null) {
/* 674 */         return null;
/*     */       }
/*     */       
/* 677 */       list = this.f.b(parame);
/* 678 */       if (this.F) {
/* 679 */         this.f.a().b();
/*     */       }
/* 681 */     } catch (Exception exception) {
/* 682 */       a.error("Failed to get best bids", exception);
/*     */     } 
/*     */     
/* 685 */     this.f = null;
/* 686 */     this.F = false;
/* 687 */     return list;
/*     */   }
/*     */   
/*     */   protected void a(e parame, i parami) throws Exception {
/* 691 */     if (this.f != null) {
/* 692 */       br.com.arremate.d.g g1 = this.f;
/*     */       
/* 694 */       if (g1.a().isRunning()) {
/*     */         return;
/*     */       }
/*     */     } 
/*     */     
/* 699 */     if (parami == null || !parami.isRunning()) {
/* 700 */       Future<i> future = c.a(a());
/* 701 */       parami = future.get();
/* 702 */       this.F = true;
/*     */     } 
/*     */     
/* 705 */     this.f = a(parami);
/* 706 */     this.f.ab();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean q() {
/* 712 */     return (this.e != null) ? this.e.isRunning() : false;
/*     */   }
/*     */   
/*     */   public j a() {
/* 716 */     return this.a;
/*     */   }
/*     */   
/*     */   private void cl() {
/* 720 */     JOptionPane.showMessageDialog(null, "Esta funcionalidade ainda não foi desenvolvida para este portal!");
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(b paramb, n paramn) {}
/*     */   
/*     */   public void interrupt() {
/* 727 */     if (this.e != null) {
/* 728 */       this.e.interrupt();
/*     */     }
/*     */   }
/*     */   
/*     */   public long q() {
/* 733 */     return TimeUnit.SECONDS.toMillis(15L);
/*     */   }
/*     */   
/*     */   protected br.com.arremate.d.g d() {
/* 737 */     return this.e;
/*     */   }
/*     */   
/*     */   protected void d(br.com.arremate.d.g paramg) {
/* 741 */     this.e = paramg;
/*     */   }
/*     */   
/*     */   protected br.com.arremate.d.g e() {
/* 745 */     return this.f;
/*     */   }
/*     */   
/*     */   protected void e(br.com.arremate.d.g paramg) {
/* 749 */     this.f = paramg;
/*     */   }
/*     */   
/*     */   public void s(long paramLong) {
/* 753 */     this.G = paramLong;
/*     */   }
/*     */   
/*     */   public String aX() {
/* 757 */     return (this.dr != null) ? this.dr : "Não foi possível capturar os melhores lances do portal no momento";
/*     */   }
/*     */ 
/*     */   
/*     */   public void G(String paramString) {
/* 762 */     this.dr = paramString;
/*     */   }
/*     */   
/*     */   public String aY() {
/* 766 */     return this.ds;
/*     */   }
/*     */   
/*     */   protected abstract br.com.arremate.d.g a(b paramb, i parami);
/*     */   
/*     */   protected abstract br.com.arremate.d.g a(i parami);
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\k\a\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */