/*     */ package br.com.arremate.k.b;
/*     */ 
/*     */ import br.com.arremate.f.h;
/*     */ import br.com.arremate.f.w;
/*     */ import br.com.arremate.l.b;
/*     */ import br.com.arremate.l.h;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.RoundingMode;
/*     */ import java.util.List;
/*     */ import java.util.Random;
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
/*     */ public class e
/*     */   extends d
/*     */ {
/*     */   public h a(double paramDouble, h paramh, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, b paramb, boolean paramBoolean) {
/*  36 */     double d1 = a(paramBigDecimal1, paramBigDecimal2, paramh
/*  37 */         .m());
/*     */     
/*  39 */     if (paramDouble <= d1)
/*     */     {
/*  41 */       return null;
/*     */     }
/*     */     
/*  44 */     h h1 = null;
/*     */     
/*  46 */     if (paramBoolean) {
/*  47 */       h1 = a(paramDouble, paramh, paramh, paramb
/*     */ 
/*     */           
/*  50 */           .h(), paramBigDecimal1, paramBigDecimal2, paramb
/*     */ 
/*     */           
/*  53 */           .E());
/*     */     }
/*     */ 
/*     */     
/*  57 */     if (h1 == null) {
/*  58 */       double d2 = b(paramb
/*  59 */           .f(), paramb
/*  60 */           .g(), paramBigDecimal1, paramBigDecimal2, paramb
/*     */ 
/*     */           
/*  63 */           .a(), paramh
/*  64 */           .m(), paramb
/*  65 */           .E());
/*  66 */       h1 = new h(d2);
/*     */     } 
/*     */     
/*  69 */     if (h1.m() > paramDouble) {
/*  70 */       h1.q(paramDouble);
/*     */     }
/*     */     
/*  73 */     h1.l(1);
/*  74 */     h1.an("Posição automática");
/*     */     
/*  76 */     return h1;
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
/* 101 */     if (paramDouble2 >= paramDouble1 || paramDouble1 <= paramDouble3)
/*     */     {
/* 103 */       return null;
/*     */     }
/*     */     
/* 106 */     h h1 = null;
/*     */     
/* 108 */     if (paramh.m() == paramDouble2) {
/* 109 */       double d1 = b(paramBigDecimal1, paramBigDecimal2, paramBigDecimal3, paramBigDecimal4, paramw, paramDouble2, paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 118 */       if (d1 > paramDouble1) {
/* 119 */         d1 = paramDouble1;
/*     */       }
/*     */       
/* 122 */       h1 = new h(d1);
/*     */     } 
/*     */     
/* 125 */     return h1;
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
/*     */   public h a(int paramInt, List<h> paramList, br.com.arremate.l.q.b.e parame) {
/* 139 */     b b = parame.b();
/*     */     
/*     */     try {
/* 142 */       if (!b.aE()) {
/* 143 */         return null;
/*     */       }
/*     */       
/* 146 */       double d1 = parame.f();
/*     */       
/* 148 */       for (int i = paramInt; i < paramList.size(); i++) {
/* 149 */         h h = paramList.get(i);
/*     */         
/* 151 */         if (h.m() == d1) {
/* 152 */           int j = i + 1;
/*     */ 
/*     */           
/* 155 */           if (j >= paramList.size()) {
/*     */             break;
/*     */           }
/*     */           
/* 159 */           h h1 = paramList.get(j);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 166 */           if (h1.m() < d1) {
/*     */             break;
/*     */           }
/*     */         } 
/*     */ 
/*     */         
/* 172 */         double d2 = a(parame.r(), parame
/* 173 */             .s(), h.m());
/*     */         
/* 175 */         if (parame.l() > d2 && d1 <= h.m()) {
/*     */ 
/*     */           
/* 178 */           double d3 = b(b
/* 179 */               .f(), b
/* 180 */               .g(), parame
/* 181 */               .r(), parame
/* 182 */               .s(), b
/* 183 */               .a(), h
/* 184 */               .m(), b
/* 185 */               .E());
/*     */           
/* 187 */           if (d3 > parame.l()) {
/* 188 */             d3 = parame.l();
/*     */           }
/*     */           
/* 191 */           h h1 = new h(d3);
/* 192 */           h1.l(h.j());
/* 193 */           h1.c(h.b());
/*     */           
/* 195 */           int j = parame.j();
/* 196 */           if (j != h.i.v()) {
/* 197 */             h1.an("Posição fixa");
/*     */           } else {
/* 199 */             h1.an("Posição automática");
/*     */           } 
/*     */           
/* 202 */           return h1;
/*     */         } 
/*     */       } 
/* 205 */     } catch (Exception exception) {
/* 206 */       a.info("Error at calcularLanceDemaisPosicoes()", exception);
/*     */     } 
/*     */     
/* 209 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private double b(BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, BigDecimal paramBigDecimal3, BigDecimal paramBigDecimal4, w paramw, double paramDouble, int paramInt) {
/* 216 */     byte b = 4;
/*     */     
/* 218 */     if (paramw == w.b) {
/* 219 */       paramBigDecimal1 = paramBigDecimal1.multiply(BigDecimal.valueOf(100L));
/* 220 */       paramBigDecimal2 = paramBigDecimal2.multiply(BigDecimal.valueOf(100L));
/*     */     } 
/*     */     
/* 223 */     if (paramBigDecimal4.compareTo(BigDecimal.ZERO) == 1) {
/* 224 */       paramBigDecimal3 = paramBigDecimal4;
/*     */     }
/*     */     
/* 227 */     if (paramBigDecimal3.compareTo(BigDecimal.ZERO) == 1) {
/* 228 */       if (paramBigDecimal1.compareTo(paramBigDecimal3) == -1) {
/* 229 */         paramBigDecimal1 = paramBigDecimal3;
/*     */       }
/*     */       
/* 232 */       if (paramBigDecimal2.compareTo(paramBigDecimal3) == -1) {
/* 233 */         paramBigDecimal2 = paramBigDecimal3;
/*     */       }
/*     */     } 
/*     */     
/* 237 */     BigDecimal bigDecimal1 = BigDecimal.valueOf(paramDouble);
/* 238 */     BigDecimal bigDecimal2 = paramBigDecimal1;
/*     */     
/* 240 */     if (paramBigDecimal2.compareTo(paramBigDecimal1) == 1) {
/* 241 */       Random random = new Random();
/* 242 */       BigDecimal bigDecimal3 = paramBigDecimal1;
/* 243 */       BigDecimal bigDecimal4 = paramBigDecimal2;
/* 244 */       BigDecimal bigDecimal5 = bigDecimal4.subtract(bigDecimal3);
/*     */       
/* 246 */       bigDecimal2 = BigDecimal.valueOf(random.nextDouble()).multiply(bigDecimal5);
/* 247 */       bigDecimal2 = bigDecimal2.add(paramBigDecimal1);
/* 248 */       bigDecimal2 = bigDecimal2.setScale(b, RoundingMode.HALF_UP);
/*     */       
/* 250 */       if (bigDecimal2.compareTo(bigDecimal3) == -1) {
/* 251 */         bigDecimal2 = bigDecimal3;
/* 252 */       } else if (bigDecimal2.compareTo(bigDecimal4) == 1) {
/* 253 */         bigDecimal2 = bigDecimal4;
/*     */       } 
/*     */     } 
/*     */     
/* 257 */     bigDecimal1 = bigDecimal1.add(bigDecimal2);
/*     */     
/* 259 */     return a(bigDecimal1.doubleValue(), paramInt);
/*     */   }
/*     */   
/*     */   protected double a(BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, double paramDouble) {
/* 263 */     BigDecimal bigDecimal1 = BigDecimal.valueOf(paramDouble);
/* 264 */     BigDecimal bigDecimal2 = null;
/*     */     
/* 266 */     if (paramBigDecimal2.compareTo(BigDecimal.ZERO) == 1) {
/* 267 */       paramBigDecimal1 = paramBigDecimal2;
/*     */     }
/*     */     
/* 270 */     bigDecimal2 = bigDecimal1.add(paramBigDecimal1);
/*     */     
/* 272 */     return a(bigDecimal2.doubleValue(), 0);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\k\b\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */