/*     */ package br.com.arremate.d.e;
/*     */ 
/*     */ import br.com.arremate.d.a;
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.f.i;
/*     */ import br.com.arremate.f.v;
/*     */ import br.com.arremate.g.a;
/*     */ import br.com.arremate.g.b;
/*     */ import br.com.arremate.g.e;
/*     */ import br.com.arremate.j.c.e;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.m.y;
/*     */ import br.com.arremate.n.n;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.Date;
/*     */ import org.e.i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class l
/*     */   extends i
/*     */ {
/*     */   final a b;
/*     */   
/*     */   public l(e parame, e parame1, p paramp) {
/*  28 */     super(parame, parame1, paramp);
/*  29 */     this.b = new a(this, true);
/*     */   }
/*     */ 
/*     */   
/*     */   protected h a() throws b, e, a {
/*  34 */     return this.b.a();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean a(i parami, String paramString) {
/*  39 */     return ((!g.b(paramString, g.n) && 
/*  40 */       !g.b(paramString, g.i) && (parami == i.a || 
/*     */       
/*  42 */       g.b(paramString, g.h) || (
/*  43 */       g.b(paramString, g.k) && parami == i.c))) || (
/*     */       
/*  45 */       a().a().aR() && !a().a().aS()));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void P() {
/*     */     try {
/*  51 */       i i1 = i();
/*  52 */       if (i1 == null) {
/*     */         return;
/*     */       }
/*     */       
/*  56 */       aD();
/*     */       
/*  58 */       String str1 = "";
/*  59 */       String str2 = "";
/*     */       
/*  61 */       if (i1.has("fase")) {
/*  62 */         str1 = i1.getString("fase");
/*     */       }
/*     */       
/*  65 */       if (i1.has("situacao")) {
/*  66 */         str2 = i1.getString("situacao");
/*     */       }
/*     */       
/*  69 */       if (i1.has("dataHoraFimContagem")) {
/*  70 */         String str = i1.getString("dataHoraFimContagem");
/*  71 */         Date date = getDateFormat().parse(str);
/*  72 */         long l1 = date.getTime() - n.a().longValue();
/*     */         
/*  74 */         if (l1 < 0L) {
/*  75 */           l1 = 0L;
/*     */         }
/*     */         
/*  78 */         if (!v().equals(i1.getString("dataHoraFimContagem"))) {
/*  79 */           o(i1.getString("dataHoraFimContagem"));
/*  80 */           a().a().x(l1);
/*     */         } 
/*     */         
/*  83 */         if (a().a().z() <= 0L && i1.has("situacaoAposContagem")) {
/*  84 */           str1 = i1.getString("situacaoAposContagem");
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/*  89 */       String str3 = i1.has("situacaoParticipacaoRodada") ? i1.getString("situacaoParticipacaoRodada") : "";
/*  90 */       g g = a(str2, str1, str3);
/*     */       
/*  92 */       if (i1.has("desclassificado") && i1.getBoolean("desclassificado") && g != g.av && g != g.s)
/*     */       {
/*  94 */         g = g.aW;
/*     */       }
/*     */       
/*  97 */       if (a().a().z() <= 0L && g == g.f) {
/*  98 */         g = g.k;
/*     */       }
/*     */       
/* 101 */       if (g != null) {
/* 102 */         String str = a().bB();
/* 103 */         a().N(g.getValue());
/*     */         
/* 105 */         if (a().bv() && !a().bB().equals(str)) {
/* 106 */           a().v(true);
/*     */           
/* 108 */           DecimalFormat decimalFormat = y.a("###,###,###,##0.0000");
/* 109 */           String str4 = decimalFormat.format(a().y());
/*     */           
/* 111 */           b().l(
/* 112 */               String.join("", new CharSequence[] {
/*     */                   
/* 114 */                   "O Item ", a().bo(), " entrou em Lance Fechado com o valor de ", 
/*     */                   
/* 116 */                   (a().w() == v.b.v()) ? (str4 + " %") : ("R$ " + str4)
/*     */                 }));
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 124 */       a().a(a());
/*     */       
/* 126 */       aE();
/*     */       
/* 128 */       if (a().br()) {
/* 129 */         b().g(a());
/*     */       }
/* 131 */     } catch (Exception exception) {
/* 132 */       a.error("#020", exception);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\e\l.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */