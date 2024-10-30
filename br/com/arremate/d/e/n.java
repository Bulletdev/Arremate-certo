/*     */ package br.com.arremate.d.e;
/*     */ 
/*     */ import br.com.arremate.a.k;
/*     */ import br.com.arremate.g.d;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.c.e;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.RoundingMode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class n
/*     */   extends l
/*     */ {
/*     */   public n(e parame, e parame1, p paramp) {
/*  21 */     super(parame, parame1, paramp);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void P() {
/*  26 */     super.P();
/*     */     
/*  28 */     if (i().has("fatorEqualizacaoIcms")) {
/*  29 */       a().a().p(i().getDouble("fatorEqualizacaoIcms"));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean a(h paramh, boolean paramBoolean) {
/*  35 */     if (!b(paramh.m()) && !paramBoolean) {
/*  36 */       a.warn("Tentativa de lance abaixo do mínimo");
/*  37 */       return false;
/*     */     } 
/*     */     
/*  40 */     if (a() <= 0.0D) {
/*  41 */       a.warn("Valor de equalização menor ou igual a zero");
/*  42 */       return false;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  52 */       double d = paramh.m();
/*  53 */       a(a(), Double.valueOf(d));
/*     */       
/*  55 */       d = b(d);
/*  56 */       paramh.q(d);
/*     */       
/*  58 */       if (!k.b()) {
/*  59 */         a().a().y(br.com.arremate.n.n.a().longValue());
/*  60 */         a("Lance de simulação", paramh, m(), paramBoolean, new String[0]);
/*  61 */         return true;
/*     */       } 
/*     */ 
/*     */       
/*  65 */       e e = a().a(b().a().bk(), 
/*  66 */           a().bo(), paramh
/*  67 */           .m(), 
/*  68 */           u());
/*     */       
/*  70 */       return b(e, paramh, paramBoolean);
/*  71 */     } catch (d d) {
/*  72 */       b("enviar lance", d);
/*  73 */     } catch (Exception exception) {
/*  74 */       a.error(String.join(" - ", new CharSequence[] { "#025", a().bo() }), exception);
/*  75 */       b().h("#025 - " + a().bo());
/*     */     } 
/*     */     
/*  78 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(e parame, Double paramDouble) {
/*  88 */     BigDecimal bigDecimal1 = BigDecimal.valueOf(paramDouble.doubleValue()).setScale(4, RoundingMode.DOWN);
/*  89 */     BigDecimal bigDecimal2 = BigDecimal.valueOf(a()).setScale(4, RoundingMode.DOWN);
/*     */     
/*  91 */     StringBuilder stringBuilder = new StringBuilder("O Lance do item ");
/*  92 */     stringBuilder.append(parame.bo());
/*  93 */     stringBuilder.append(" com equalização é de R$ ");
/*  94 */     stringBuilder.append(bigDecimal1);
/*  95 */     stringBuilder.append(" e o fator de equalização é de ");
/*  96 */     stringBuilder.append(bigDecimal2);
/*  97 */     b().l(stringBuilder.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private double b(double paramDouble) {
/* 107 */     double d = a();
/* 108 */     return paramDouble / d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private double a() {
/* 119 */     return a().a().a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\e\n.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */