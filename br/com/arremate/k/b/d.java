/*     */ package br.com.arremate.k.b;
/*     */ 
/*     */ import br.com.arremate.f.w;
/*     */ import br.com.arremate.g.a;
/*     */ import br.com.arremate.g.b;
/*     */ import br.com.arremate.g.e;
/*     */ import br.com.arremate.l.b;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.n;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.RoundingMode;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import org.apache.commons.lang3.StringUtils;
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
/*     */ public class d
/*     */   extends a
/*     */ {
/*     */   public h a(double paramDouble, h paramh, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, b paramb, boolean paramBoolean) {
/*  41 */     double d1 = paramh.m();
/*     */     
/*  43 */     if (paramDouble <= d1)
/*     */     {
/*  45 */       return null;
/*     */     }
/*     */     
/*  48 */     h h1 = null;
/*     */     
/*  50 */     if (paramBoolean) {
/*  51 */       h1 = a(paramDouble, paramh, paramh, paramb
/*     */ 
/*     */           
/*  54 */           .h(), paramBigDecimal1, paramBigDecimal2, paramb
/*     */ 
/*     */           
/*  57 */           .E());
/*     */     }
/*     */ 
/*     */     
/*  61 */     if (h1 == null) {
/*  62 */       double d2 = b(paramb
/*  63 */           .f(), paramb
/*  64 */           .g(), paramb
/*  65 */           .a(), d1, paramb
/*     */           
/*  67 */           .E());
/*  68 */       h1 = new h(d2);
/*  69 */       h1.l(1);
/*     */     } 
/*     */     
/*  72 */     if (h1.m() > paramDouble) {
/*  73 */       h1.q(paramDouble);
/*     */     }
/*     */     
/*  76 */     return h1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected h a(double paramDouble, h paramh1, h paramh2, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, BigDecimal paramBigDecimal3, int paramInt) {
/*  82 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected h a(List<h> paramList, double paramDouble1, double paramDouble2, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, BigDecimal paramBigDecimal3, int paramInt, boolean paramBoolean) throws e {
/*  88 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected h a(List<h> paramList, double paramDouble1, double paramDouble2, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, w paramw, BigDecimal paramBigDecimal3, BigDecimal paramBigDecimal4, int paramInt, boolean paramBoolean) throws b {
/*  94 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected h a(List<h> paramList, int paramInt1, double paramDouble, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, int paramInt2) throws a {
/* 100 */     return null;
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
/*     */   protected h a(h paramh, double paramDouble1, double paramDouble2, double paramDouble3, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, w paramw, BigDecimal paramBigDecimal3, BigDecimal paramBigDecimal4, int paramInt) {
/* 125 */     if (paramDouble2 >= paramDouble1 || paramDouble1 <= paramDouble3)
/*     */     {
/* 127 */       return null;
/*     */     }
/*     */     
/* 130 */     h h1 = null;
/*     */     
/* 132 */     if (paramh.m() == paramDouble2) {
/* 133 */       double d1 = b(paramBigDecimal1, paramBigDecimal2, paramw, paramDouble2, paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 140 */       if (d1 > paramDouble1) {
/* 141 */         d1 = paramDouble1;
/*     */       }
/*     */       
/* 144 */       h1 = new h(d1);
/*     */     } 
/*     */     
/* 147 */     return h1;
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
/*     */   public h a(List<h> paramList, double paramDouble1, double paramDouble2, double paramDouble3, n paramn, boolean paramBoolean, b paramb, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2) {
/* 170 */     return null;
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
/*     */   public h a(int paramInt, List<h> paramList, e parame) {
/* 184 */     b b = parame.b();
/*     */     
/*     */     try {
/* 187 */       if (!b.aE()) {
/* 188 */         return null;
/*     */       }
/*     */       
/* 191 */       double d1 = parame.f();
/*     */       
/* 193 */       for (int i = paramInt; i < paramList.size(); i++) {
/* 194 */         h h = paramList.get(i);
/*     */         
/* 196 */         if (h.m() == d1) {
/* 197 */           int j = i + 1;
/*     */ 
/*     */           
/* 200 */           if (j >= paramList.size()) {
/*     */             break;
/*     */           }
/*     */           
/* 204 */           h h1 = paramList.get(j);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 211 */           if (h1.m() < d1) {
/*     */             break;
/*     */           }
/*     */         } 
/*     */ 
/*     */         
/* 217 */         if (parame.l() > h.m() && d1 <= h.m()) {
/*     */ 
/*     */           
/* 220 */           double d2 = b(b
/* 221 */               .f(), b
/* 222 */               .g(), b
/* 223 */               .a(), h
/* 224 */               .m(), b
/* 225 */               .E());
/*     */           
/* 227 */           if (d2 > parame.l()) {
/* 228 */             d2 = parame.l();
/*     */           }
/*     */           
/* 231 */           h h1 = new h(d2);
/* 232 */           h1.l(h.j());
/* 233 */           h1.c(h.b());
/* 234 */           return h1;
/*     */         } 
/*     */       } 
/* 237 */     } catch (Exception exception) {
/* 238 */       a.info("Error at calcularLanceDemaisPosicoes()", exception);
/*     */     } 
/*     */     
/* 241 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private double b(BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, w paramw, double paramDouble, int paramInt) {
/* 246 */     Random random = new Random();
/*     */ 
/*     */     
/* 249 */     double d2 = paramBigDecimal2.subtract(paramBigDecimal1).doubleValue();
/*     */ 
/*     */     
/* 252 */     double d3 = random.nextDouble() * d2 + paramBigDecimal1.doubleValue();
/*     */     
/* 254 */     switch (null.k[paramw.ordinal()])
/*     */     { case 1:
/* 256 */         d1 = paramDouble + paramDouble * d3;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 266 */         d1 = a(d1, paramInt);
/* 267 */         return d1; }  double d1 = paramDouble + d3; d1 = a(d1, paramInt); return d1;
/*     */   }
/*     */ 
/*     */   
/*     */   protected double a(double paramDouble, int paramInt) {
/* 272 */     byte b = 4;
/* 273 */     double d1 = 0.0D;
/*     */     
/* 275 */     if (paramInt >= 0 && paramInt <= 8) {
/* 276 */       if (paramInt < b) {
/* 277 */         paramInt = Math.abs(paramInt - b);
/* 278 */         d1 = BigDecimal.valueOf(paramDouble).setScale(paramInt, RoundingMode.DOWN).doubleValue();
/*     */       } else {
/* 280 */         d1 = BigDecimal.valueOf(paramDouble).intValue();
/*     */         
/* 282 */         if (paramInt > b) {
/* 283 */           int i = paramInt - b;
/* 284 */           i = Integer.valueOf(StringUtils.rightPad("1", i, "0")).intValue();
/* 285 */           d1 += Math.abs(d1 % i - i);
/*     */         } 
/*     */       } 
/*     */     } else {
/* 289 */       d1 = BigDecimal.valueOf(paramDouble).setScale(b, RoundingMode.DOWN).doubleValue();
/*     */     } 
/*     */     
/* 292 */     paramDouble = d1;
/* 293 */     return paramDouble;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\k\b\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */