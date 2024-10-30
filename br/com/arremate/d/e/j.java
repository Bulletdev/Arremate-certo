/*     */ package br.com.arremate.d.e;
/*     */ 
/*     */ import br.com.arremate.d.d;
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.f.i;
/*     */ import br.com.arremate.f.r;
/*     */ import br.com.arremate.i.d;
/*     */ import br.com.arremate.j.c.e;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.l.q.b.i;
/*     */ import br.com.arremate.n.n;
/*     */ import java.util.Date;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class j
/*     */   extends i
/*     */ {
/*     */   public j(e parame, e parame1, p paramp) {
/*  22 */     super(parame, parame1, paramp);
/*  23 */     a((d)new d());
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/*  28 */     if (!a().b().aF()) {
/*  29 */       super.run();
/*     */     } else {
/*     */       try {
/*  32 */         P();
/*     */         
/*  34 */         i i1 = b().a();
/*  35 */         int k = i1.indexOf(a().v());
/*     */         
/*  37 */         if (k >= 0) {
/*  38 */           i1.fireTableRowsUpdated(k, k);
/*     */         }
/*     */         
/*  41 */         if (a().bt() && 
/*  42 */           a().a() == r.a && a(a().f())) {
/*  43 */           a(new h(a().l()), false);
/*     */         }
/*  45 */       } catch (Exception exception) {
/*  46 */         a.error("Falha ao enviar lance na abertura", exception);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean a(i parami, String paramString) {
/*  53 */     return (parami == i.a || g.b(paramString, g.aE));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void P() {
/*     */     try {
/*  59 */       if (i() == null) {
/*     */         return;
/*     */       }
/*     */       
/*  63 */       aD();
/*     */       
/*  65 */       String str1 = "";
/*  66 */       String str2 = "";
/*     */       
/*  68 */       if (i().has("fase")) {
/*  69 */         str1 = i().getString("fase");
/*     */       }
/*     */       
/*  72 */       if (i().has("situacao")) {
/*  73 */         str2 = i().getString("situacao");
/*     */       }
/*     */       
/*  76 */       if (i().has("dataHoraFimContagem")) {
/*  77 */         String str = i().getString("dataHoraFimContagem");
/*  78 */         Date date = getDateFormat().parse(str);
/*  79 */         long l = date.getTime() - n.a().longValue();
/*     */         
/*  81 */         if (l < -5000L && i().has("situacaoAposContagem")) {
/*  82 */           str1 = i().getString("situacaoAposContagem");
/*     */         }
/*     */         
/*  85 */         if (l < 0L) {
/*  86 */           l = 0L;
/*     */         }
/*     */         
/*  89 */         if (!v().equals(str)) {
/*  90 */           a().a().x(l);
/*  91 */           o(str);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/*  96 */       g g = a(str2, str1);
/*  97 */       if (g == g.f && a().a().z() < TimeUnit.SECONDS.toMillis(121L)) {
/*  98 */         g = g.aE;
/*     */       }
/*     */       
/* 101 */       if (i().has("desclassificado") && i().getBoolean("desclassificado") && g != g.s) {
/* 102 */         g = g.aW;
/*     */       }
/*     */       
/* 105 */       if (g != null) {
/* 106 */         a().N(g.getValue());
/*     */       }
/*     */ 
/*     */       
/* 110 */       a().a(a());
/*     */       
/* 112 */       aE();
/*     */       
/* 114 */       if (a().br()) {
/* 115 */         b().g(a());
/*     */       }
/* 117 */     } catch (Exception exception) {
/* 118 */       a.error("#020", exception);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\e\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */