/*     */ package br.com.arremate.d.e;
/*     */ 
/*     */ import br.com.arremate.a.k;
/*     */ import br.com.arremate.f.s;
/*     */ import br.com.arremate.g.d;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.c.e;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.n.n;
/*     */ import java.math.BigDecimal;
/*     */ import java.text.DecimalFormat;
/*     */ import org.e.f;
/*     */ import org.e.g;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class i
/*     */   extends e
/*     */ {
/*     */   public i(e parame, e parame1, p paramp) {
/*  24 */     super(parame, parame1, paramp);
/*     */   }
/*     */   
/*     */   protected void aD() throws g {
/*  28 */     if (i().has("melhorValorGeral") && !i().isNull("melhorValorGeral")) {
/*  29 */       org.e.i i1 = i().j("melhorValorGeral");
/*     */       
/*  31 */       if (!i1.isNull("valorCalculado")) {
/*  32 */         a().l(i1.getDouble("valorCalculado"));
/*     */       }
/*     */     } 
/*     */     
/*  36 */     if (i().has("melhorValorFornecedor")) {
/*  37 */       a().h(i().j("melhorValorFornecedor").getDouble("valorCalculado"));
/*     */     }
/*     */   }
/*     */   
/*     */   protected void aE() throws g {
/*  42 */     if (a().a().r().compareTo(BigDecimal.ZERO) == 0 && 
/*  43 */       a().a().s().compareTo(BigDecimal.ZERO) == 0 && 
/*  44 */       i().has("variacaoMinimaEntreLances") && !i().isNull("variacaoMinimaEntreLances")) {
/*  45 */       BigDecimal bigDecimal = BigDecimal.valueOf(i().getDouble("variacaoMinimaEntreLances"));
/*     */       
/*  47 */       if (i().getString("tipoVariacaoMinimaEntreLances").equals("V")) {
/*  48 */         a().a().e(bigDecimal);
/*     */       } else {
/*  50 */         a().a().f(bigDecimal);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected s a() {
/*  58 */     s s = s.c;
/*  59 */     if (i().has("situacaoParticipanteDisputa")) {
/*  60 */       switch (i().getString("situacaoParticipanteDisputa")) {
/*     */         case "E":
/*  62 */           s = s.b;
/*     */           break;
/*     */         case "G":
/*  65 */           s = s.a;
/*     */           break;
/*     */       } 
/*  68 */     } else if (a().f().m() == a().f()) {
/*  69 */       s = s.a;
/*     */     } 
/*     */     
/*  72 */     return s;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean a(h paramh, boolean paramBoolean) {
/*  77 */     if (!b(paramh.m()) && !paramBoolean) {
/*  78 */       a.warn("Tentativa de lance abaixo do mínimo");
/*  79 */       return false;
/*     */     } 
/*     */     
/*     */     try {
/*  83 */       if (!k.b()) {
/*  84 */         a().a().y(n.a().longValue());
/*  85 */         a("Lance de simulação", paramh, m(), paramBoolean, new String[0]);
/*  86 */         return true;
/*     */       } 
/*     */       
/*  89 */       a.info("Enviando lance no valor de {} para o item {}", Double.valueOf(paramh.m()), a().bo());
/*  90 */       e e1 = a().a(
/*  91 */           b().a().bk(), 
/*  92 */           a().bo(), paramh
/*  93 */           .m(), 
/*  94 */           u());
/*     */ 
/*     */       
/*  97 */       return b(e1, paramh, paramBoolean);
/*  98 */     } catch (d d) {
/*  99 */       b("enviar lance", d);
/* 100 */     } catch (Exception exception) {
/* 101 */       a.error(String.join(" - ", new CharSequence[] { "#025", a().bo() }), exception);
/*     */     } 
/*     */     
/* 104 */     return false;
/*     */   }
/*     */   
/*     */   protected boolean b(e parame, h paramh, boolean paramBoolean) {
/* 108 */     String str = parame.getData().trim();
/* 109 */     a.info("Retorno sobre envio de lance para o item {}, status: {} | message: {}", new Object[] { a().bo(), Integer.valueOf(parame.getStatusCode()), str });
/*     */     
/* 111 */     if (parame.getStatusCode() == 200) {
/*     */       
/*     */       try {
/* 114 */         double d = parame.k() / 1000.0D;
/* 115 */         DecimalFormat decimalFormat = new DecimalFormat("#.##");
/* 116 */         String str1 = decimalFormat.format(d);
/*     */         
/* 118 */         a("Lance enviado", paramh, m(), paramBoolean, new String[] { "Tempo para envio: " + str1 });
/*     */         
/* 120 */         a().a().y(n.a().longValue());
/* 121 */         a().a().w(a().a().aR());
/*     */         
/* 123 */         if (!str.isEmpty() && !str.equals("{}")) {
/* 124 */           f f = new f(str);
/*     */           
/* 126 */           if (f.length() > 0) {
/* 127 */             org.e.i i1 = f.b(0);
/*     */             
/* 129 */             if (b().g(i1)) {
/* 130 */               b(i1);
/* 131 */               P();
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 136 */         return true;
/* 137 */       } catch (g g) {}
/*     */     }
/*     */ 
/*     */     
/* 141 */     a.info("Falha ao enviar lance, status: {} | message: {}", Integer.valueOf(parame.getStatusCode()), str);
/* 142 */     a(str, parame.getStatusCode(), paramh, paramBoolean);
/* 143 */     return false;
/*     */   }
/*     */   
/*     */   private void a(String paramString, int paramInt, h paramh, boolean paramBoolean) {
/* 147 */     String str = "Não houve mensagem de retorno do portal!";
/*     */     
/* 149 */     if (!paramString.isEmpty() && !paramString.equals("{}")) {
/* 150 */       org.e.i i1 = new org.e.i(paramString);
/*     */       
/* 152 */       if (i1.has("message")) {
/* 153 */         str = i1.getString("message");
/*     */       }
/*     */     } 
/*     */     
/* 157 */     a("Tentativa de lance", paramh, m(), paramBoolean, new String[] { str, "Status: " + paramInt });
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\e\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */