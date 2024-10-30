/*     */ package br.com.arremate.d.e;
/*     */ 
/*     */ import br.com.arremate.d.a;
/*     */ import br.com.arremate.f.i;
/*     */ import br.com.arremate.f.s;
/*     */ import br.com.arremate.g.a;
/*     */ import br.com.arremate.g.b;
/*     */ import br.com.arremate.g.e;
/*     */ import br.com.arremate.j.c.e;
/*     */ import br.com.arremate.l.e;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.l.q.b.f;
/*     */ import br.com.arremate.m.y;
/*     */ import br.com.arremate.n.n;
/*     */ import java.math.BigDecimal;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.Date;
/*     */ import org.e.i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class g
/*     */   extends h
/*     */ {
/*     */   private final a b;
/*     */   
/*     */   public g(f paramf, e parame, p paramp) {
/*  31 */     super(paramf, parame, paramp);
/*  32 */     this.b = new a(this, true);
/*     */   }
/*     */ 
/*     */   
/*     */   protected h a() throws b, e, a {
/*  37 */     return this.b.a();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean a(i parami, String paramString) {
/*  42 */     e e = a().a();
/*  43 */     return ((!br.com.arremate.f.g.b(paramString, br.com.arremate.f.g.n) && 
/*  44 */       !br.com.arremate.f.g.b(paramString, br.com.arremate.f.g.i) && (parami == i.a || 
/*     */       
/*  46 */       br.com.arremate.f.g.b(paramString, br.com.arremate.f.g.h) || (
/*  47 */       br.com.arremate.f.g.b(paramString, br.com.arremate.f.g.k) && parami == i.c))) || (e
/*     */       
/*  49 */       .aR() && !e.aS()));
/*     */   }
/*     */   
/*     */   protected void a(i parami, e parame) {
/*     */     try {
/*     */       s s;
/*  55 */       if (parame.ay()) {
/*  56 */         b(parami, parame);
/*     */       } else {
/*  58 */         parame.N(a().bB());
/*  59 */         parame.v(a().aR());
/*     */       } 
/*     */ 
/*     */       
/*  63 */       if (parami.has("melhorValorGeral") && !parami.isNull("melhorValorGeral")) {
/*  64 */         i i1 = parami.j("melhorValorGeral");
/*     */         
/*  66 */         if (!i1.isNull("valorCalculado")) {
/*  67 */           parame.l(i1.getDouble("valorCalculado"));
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/*  72 */       if (parami.has("melhorValorFornecedor")) {
/*  73 */         parame.h(parami.j("melhorValorFornecedor").getDouble("valorCalculado"));
/*     */       }
/*     */ 
/*     */       
/*  77 */       if (parami.has("variacaoMinimaEntreLances") && !parami.isNull("variacaoMinimaEntreLances")) {
/*  78 */         BigDecimal bigDecimal = BigDecimal.valueOf(parami.getDouble("variacaoMinimaEntreLances"));
/*     */         
/*  80 */         if (parami.getString("tipoVariacaoMinimaEntreLances").equals("V")) {
/*  81 */           parame.a().e(bigDecimal);
/*     */         } else {
/*  83 */           parame.a().f(bigDecimal);
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/*  89 */       if (parami.has("situacaoParticipanteDisputa")) {
/*  90 */         switch (parami.getString("situacaoParticipanteDisputa")) {
/*     */           case "E":
/*  92 */             s = s.b;
/*     */             break;
/*     */           case "G":
/*  95 */             s = s.a;
/*     */             break;
/*     */           default:
/*  98 */             s = s.c; break;
/*     */         } 
/*     */       } else {
/* 101 */         s = (parame.f() == parame.f().m()) ? s.a : s.c;
/*     */       } 
/*     */       
/* 104 */       parame.a(s);
/* 105 */     } catch (Exception exception) {
/* 106 */       a.warn("Failed to update row data", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void b(i parami, e parame) throws Exception {
/* 111 */     String str1 = parami.has("fase") ? parami.getString("fase") : "";
/* 112 */     String str2 = parami.has("situacao") ? parami.getString("situacao") : "";
/*     */     
/* 114 */     if (parami.has("dataHoraFimContagem")) {
/* 115 */       String str = parami.getString("dataHoraFimContagem").replace("T", " ");
/* 116 */       Date date = getDateFormat().parse(str);
/* 117 */       long l = date.getTime() - n.a().longValue();
/*     */       
/* 119 */       if (l < -5000L && parami.has("situacaoAposContagem")) {
/* 120 */         str1 = parami.getString("situacaoAposContagem");
/*     */       }
/*     */       
/* 123 */       if (l < 0L) {
/* 124 */         l = 0L;
/*     */       }
/*     */       
/* 127 */       if (!v().equals(parami.getString("dataHoraFimContagem"))) {
/* 128 */         parame.x(l);
/* 129 */         o(parami.getString("dataHoraFimContagem"));
/*     */       } 
/*     */     } 
/*     */     
/* 133 */     String str3 = parami.has("situacaoParticipacaoRodada") ? parami.getString("situacaoParticipacaoRodada") : "";
/* 134 */     br.com.arremate.f.g g1 = a(str2, str1, str3);
/* 135 */     if (str1.isEmpty() && str2.isEmpty()) {
/* 136 */       g1 = null;
/*     */     }
/*     */     
/* 139 */     if (parami.has("desclassificado") && parami.getBoolean("desclassificado") && g1 != br.com.arremate.f.g.av && g1 != br.com.arremate.f.g.s)
/*     */     {
/* 141 */       g1 = br.com.arremate.f.g.aW;
/*     */     }
/*     */     
/* 144 */     if (g1 != null) {
/* 145 */       String str = parame.bB();
/* 146 */       parame.N(g1.getValue());
/*     */       
/* 148 */       boolean bool = parame.bv();
/* 149 */       parame.v(bool);
/*     */       
/* 151 */       if (bool && !parame.bB().equals(str)) {
/* 152 */         DecimalFormat decimalFormat = y.a("###,###,###,##0.0000");
/* 153 */         String str4 = decimalFormat.format(parame.y());
/*     */         
/* 155 */         b().l(String.join("", new CharSequence[] { "O Grupo ", parame.bo(), " entrou em Lance Fechado com o valor de R$ ", str4 }));
/*     */       } 
/*     */     } 
/*     */     
/* 159 */     e e1 = ((f)parame).a();
/* 160 */     if (e1.bC().isEmpty())
/* 161 */       e1.af(Integer.toString(parami.getInt("numero"))); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\e\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */