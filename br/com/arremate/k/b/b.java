/*     */ package br.com.arremate.k.b;
/*     */ 
/*     */ import br.com.arremate.f.w;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.n;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.RoundingMode;
/*     */ import java.util.List;
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
/*     */ public class b
/*     */   extends a
/*     */ {
/*     */   protected h a(h paramh, double paramDouble1, double paramDouble2, double paramDouble3, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, w paramw, BigDecimal paramBigDecimal3, BigDecimal paramBigDecimal4, int paramInt) {
/*  26 */     if (paramh.aT()) {
/*  27 */       return null;
/*     */     }
/*  29 */     return super.a(paramh, paramDouble1, paramDouble2, paramDouble3, paramBigDecimal1, paramBigDecimal2, paramw, paramBigDecimal3, paramBigDecimal4, paramInt);
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
/*     */   protected h a(double paramDouble, h paramh1, h paramh2, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, BigDecimal paramBigDecimal3, int paramInt) {
/*  55 */     if (!paramh1.aT()) {
/*  56 */       return null;
/*     */     }
/*  58 */     return super.a(paramDouble, paramh1, paramh2, paramBigDecimal1, paramBigDecimal2, paramBigDecimal3, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public h a(List<h> paramList, double paramDouble1, double paramDouble2, double paramDouble3, n paramn, boolean paramBoolean, br.com.arremate.l.b paramb, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2) {
/*  67 */     if (!paramn.bk() || !paramBoolean || paramDouble2 == paramDouble1 || paramDouble1 >= paramDouble3 || paramDouble1 <= 0.0D)
/*     */     {
/*     */ 
/*     */ 
/*     */       
/*  72 */       return null;
/*     */     }
/*     */     
/*  75 */     if (paramList == null || paramList.size() < 2) {
/*  76 */       return null;
/*     */     }
/*     */     
/*  79 */     BigDecimal bigDecimal1 = paramb.h();
/*  80 */     if (bigDecimal1.compareTo(BigDecimal.valueOf(5.01D)) == -1 || bigDecimal1.compareTo(BigDecimal.valueOf(20L)) == 1) {
/*  81 */       return null;
/*     */     }
/*     */     
/*  84 */     BigDecimal bigDecimal2 = BigDecimal.valueOf(paramDouble2);
/*  85 */     BigDecimal bigDecimal3 = c(bigDecimal1);
/*  86 */     BigDecimal bigDecimal4 = bigDecimal2.divide(bigDecimal3, 4, RoundingMode.DOWN);
/*     */     
/*  88 */     h h = paramList.get(0);
/*     */     
/*  90 */     paramList.remove(0);
/*     */     
/*  92 */     for (h h1 : paramList) {
/*  93 */       if (h1 == null || h1.m() > bigDecimal4.doubleValue()) {
/*     */         break;
/*     */       }
/*     */       
/*  97 */       if (h1.aT()) {
/*  98 */         h h2 = a(paramDouble1, h1, h, bigDecimal1, paramBigDecimal1, paramBigDecimal2, paramb
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 105 */             .E());
/*     */         
/* 107 */         if (h2 != null) {
/* 108 */           h2.an("Distanciamento de ME/EPP");
/*     */         }
/*     */         
/* 111 */         return h2;
/*     */       } 
/*     */     } 
/*     */     
/* 115 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\k\b\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */