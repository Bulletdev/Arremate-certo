/*     */ package br.com.arremate.d.e;
/*     */ 
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.f.i;
/*     */ import br.com.arremate.f.r;
/*     */ import br.com.arremate.f.s;
/*     */ import br.com.arremate.j.c.e;
/*     */ import br.com.arremate.l.e;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.l.q.b.i;
/*     */ import br.com.arremate.n.n;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.e.g;
/*     */ import org.e.i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class f
/*     */   extends h
/*     */ {
/*     */   public f(br.com.arremate.l.q.b.f paramf, e parame, p paramp) {
/*  27 */     super(paramf, parame, paramp);
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/*  32 */     if (!a().b().aF()) {
/*  33 */       super.run();
/*     */     } else {
/*     */       try {
/*  36 */         P();
/*     */         
/*  38 */         i i = b().a();
/*  39 */         int j = i.indexOf(a().v());
/*     */         
/*  41 */         if (j >= 0) {
/*  42 */           i.fireTableRowsUpdated(j, j);
/*     */         }
/*     */         
/*  45 */         if (a().bt() && a().a() == r.a && a(a().f())) {
/*  46 */           a(new h(a().l()), false);
/*     */         }
/*  48 */       } catch (Exception exception) {
/*  49 */         a.error("Falha ao enviar lance na abertura", exception);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean a(i parami, String paramString) {
/*  56 */     return (parami == i.a || g.b(paramString, g.aE));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void a(i parami, e parame) {
/*     */     try {
/*  62 */       if (parame.ay()) {
/*  63 */         b(parami, parame);
/*     */       } else {
/*  65 */         parame.N(a().bB());
/*     */       } 
/*     */       
/*  68 */       if (parami.has("melhorValorGeral") && !parami.isNull("melhorValorGeral")) {
/*  69 */         i i1 = parami.j("melhorValorGeral");
/*  70 */         if (!i1.isNull("valorCalculado")) {
/*  71 */           parame.l(i1.getDouble("valorCalculado"));
/*     */         }
/*     */       } 
/*     */       
/*  75 */       if (parami.has("melhorValorFornecedor")) {
/*  76 */         parame.h(parami.j("melhorValorFornecedor").getDouble("valorCalculado"));
/*     */       }
/*     */ 
/*     */       
/*  80 */       s s = s.c;
/*  81 */       if (parami.has("situacaoParticipanteDisputa")) {
/*  82 */         switch (parami.getString("situacaoParticipanteDisputa")) {
/*     */           case "P":
/*  84 */             s = s.c;
/*     */             break;
/*     */           case "E":
/*  87 */             s = s.b;
/*     */             break;
/*     */           case "G":
/*  90 */             s = s.a;
/*     */             break;
/*     */         } 
/*     */       
/*  94 */       } else if (parami.has("melhorValorGeral") && parami.has("melhorValorFornecedor")) {
/*  95 */         Double double_1 = Double.valueOf(parami.j("melhorValorGeral").getDouble("valorCalculado"));
/*  96 */         Double double_2 = Double.valueOf(parami.j("melhorValorFornecedor").getDouble("valorCalculado"));
/*  97 */         s = (double_1.compareTo(double_2) == 0) ? s.a : s.c;
/*     */       } else {
/*  99 */         s = (parame.f() == parame.f().m()) ? s.a : s.c;
/*     */       } 
/*     */ 
/*     */       
/* 103 */       parame.a(s);
/*     */       
/* 105 */       if (parame.r().compareTo(BigDecimal.ZERO) == 0 && parame
/* 106 */         .s().compareTo(BigDecimal.ZERO) == 0) {
/* 107 */         c(parami, parame);
/*     */       }
/* 109 */     } catch (Exception exception) {
/* 110 */       a.warn("Failed to update row data", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void b(i parami, e parame) throws Exception {
/* 115 */     String str1 = i().has("fase") ? i().getString("fase") : "";
/* 116 */     String str2 = i().has("situacao") ? i().getString("situacao") : "";
/*     */     
/* 118 */     if (i().has("dataHoraFimContagem")) {
/* 119 */       String str = i().getString("dataHoraFimContagem").replace("T", " ");
/* 120 */       Date date = getDateFormat().parse(str);
/* 121 */       long l = date.getTime() - n.a().longValue();
/*     */       
/* 123 */       if (l < -5000L && i().has("situacaoAposContagem")) {
/* 124 */         str1 = i().getString("situacaoAposContagem");
/*     */       }
/*     */       
/* 127 */       if (l < 0L) {
/* 128 */         l = 0L;
/*     */       }
/*     */       
/* 131 */       if (!v().equals(i().getString("dataHoraFimContagem"))) {
/* 132 */         parame.x(l);
/* 133 */         o(i().getString("dataHoraFimContagem"));
/*     */       } 
/*     */     } 
/*     */     
/* 137 */     g g = a(str2, str1);
/*     */     
/* 139 */     if (str1.isEmpty() && str2.isEmpty()) {
/* 140 */       g = null;
/*     */     }
/*     */     
/* 143 */     if (parami.has("desclassificado") && parami.getBoolean("desclassificado") && g != g.av && g != g.s) {
/* 144 */       g = g.aW;
/*     */     }
/*     */     
/* 147 */     if (parame.z() < TimeUnit.SECONDS.toMillis(121L) && str1.equals("LA") && (str2.isEmpty() || str2.equals("1"))) {
/* 148 */       g = g.aE;
/*     */     }
/*     */     
/* 151 */     if (g != null) {
/* 152 */       parame.N(g.getValue());
/*     */     }
/*     */     
/* 155 */     e e1 = ((br.com.arremate.l.q.b.f)parame).a();
/* 156 */     if (e1.bC().isEmpty()) {
/* 157 */       e1.af(Integer.toString(i().getInt("numero")));
/*     */     }
/*     */   }
/*     */   
/*     */   private void c(i parami, e parame) throws g {
/* 162 */     if (parami.has("variacaoMinimaEntreLances") && !parami.isNull("variacaoMinimaEntreLances")) {
/* 163 */       BigDecimal bigDecimal = BigDecimal.valueOf(parami.getDouble("variacaoMinimaEntreLances"));
/*     */       
/* 165 */       if (parami.getString("tipoVariacaoMinimaEntreLances").equals("V")) {
/* 166 */         parame.e(bigDecimal);
/*     */       } else {
/* 168 */         parame.f(bigDecimal);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\e\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */