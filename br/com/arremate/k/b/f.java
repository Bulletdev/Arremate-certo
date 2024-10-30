/*     */ package br.com.arremate.k.b;
/*     */ 
/*     */ import br.com.arremate.l.e;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.h;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.RoundingMode;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import java.util.stream.Collectors;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ public class f
/*     */ {
/*  19 */   private static final Logger a = LoggerFactory.getLogger(f.class);
/*     */   
/*     */   private final e a;
/*     */   private final BigDecimal c;
/*     */   
/*     */   public f(e parame, BigDecimal paramBigDecimal) {
/*  25 */     this.a = parame;
/*  26 */     this.c = paramBigDecimal;
/*     */   }
/*     */   
/*     */   public List<h> y() {
/*  30 */     if (this.a.at()) {
/*  31 */       return z();
/*     */     }
/*     */     
/*  34 */     if (this.c.compareTo(BigDecimal.valueOf(this.a.f())) >= 0) {
/*  35 */       a.info("Not sending new bid as our previous bid is less or equal to {}", this.c);
/*  36 */       return Collections.emptyList();
/*     */     } 
/*     */     
/*  39 */     return A();
/*     */   }
/*     */   
/*     */   private List<h> z() {
/*  43 */     ArrayList<h> arrayList = new ArrayList();
/*     */     
/*  45 */     this.a.B().forEach(paramg -> {
/*     */           BigDecimal bigDecimal = paramg.t();
/*     */ 
/*     */ 
/*     */           
/*     */           if (bigDecimal.compareTo(BigDecimal.valueOf(paramg.f())) < 0 && bigDecimal.compareTo(BigDecimal.ZERO) > 0 && paramg.aR() && !paramg.aS()) {
/*     */             h h = new h(paramg, bigDecimal.doubleValue());
/*     */ 
/*     */ 
/*     */             
/*     */             h.an("Lance Fechado");
/*     */ 
/*     */ 
/*     */             
/*     */             paramList.add(h);
/*     */           } else if (!paramg.aS()) {
/*     */             a.info(String.join("stop new closed bid cn group: ", new CharSequence[] { String.valueOf((bigDecimal.compareTo(BigDecimal.valueOf(paramg.f())) >= 0)), String.valueOf((bigDecimal.compareTo(BigDecimal.ZERO) <= 0)), String.valueOf(!paramg.aR()) }));
/*     */           } 
/*     */         });
/*     */ 
/*     */     
/*  66 */     return arrayList;
/*     */   }
/*     */   
/*     */   private List<h> A() {
/*  70 */     ArrayList<h> arrayList = new ArrayList();
/*  71 */     BigDecimal bigDecimal1 = this.c;
/*  72 */     BigDecimal bigDecimal2 = this.a.k();
/*     */     
/*  74 */     if (this.c.compareTo(bigDecimal2) < 0) {
/*  75 */       bigDecimal1 = bigDecimal2;
/*     */     }
/*     */     
/*  78 */     BigDecimal bigDecimal3 = this.a.o();
/*  79 */     BigDecimal bigDecimal4 = bigDecimal3.subtract(bigDecimal1);
/*  80 */     BigDecimal bigDecimal5 = this.a.p();
/*  81 */     double d = bigDecimal4.doubleValue() / bigDecimal5.doubleValue();
/*  82 */     BigDecimal bigDecimal6 = BigDecimal.ZERO;
/*     */ 
/*     */ 
/*     */     
/*  86 */     List list = (List)this.a.B().stream().sorted(Comparator.comparing(g::l).reversed()).collect(Collectors.toList());
/*     */     
/*  88 */     for (g g : list) {
/*  89 */       BigDecimal bigDecimal7 = a(d, g);
/*     */ 
/*     */       
/*  92 */       if (bigDecimal7.compareTo(BigDecimal.ZERO) == 0) {
/*     */         continue;
/*     */       }
/*     */       
/*  96 */       BigDecimal bigDecimal8 = BigDecimal.valueOf(g.f()).subtract(bigDecimal7);
/*  97 */       if (g.a().aZ()) {
/*  98 */         bigDecimal8 = bigDecimal8.multiply(BigDecimal.valueOf(g.i()));
/*     */       }
/* 100 */       bigDecimal8 = bigDecimal8.setScale(4, RoundingMode.DOWN);
/*     */       
/* 102 */       arrayList.add(new h(g, bigDecimal7.doubleValue()));
/* 103 */       bigDecimal6 = bigDecimal6.add(bigDecimal8);
/*     */ 
/*     */       
/* 106 */       if (bigDecimal6.compareTo(bigDecimal4) >= 0) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */     
/* 111 */     return arrayList;
/*     */   }
/*     */   
/*     */   private BigDecimal a(double paramDouble, g paramg) {
/* 115 */     BigDecimal bigDecimal1 = this.a.c(paramg);
/* 116 */     if (bigDecimal1.compareTo(BigDecimal.ZERO) == 0) {
/* 117 */       return BigDecimal.ZERO;
/*     */     }
/*     */ 
/*     */     
/* 121 */     BigDecimal bigDecimal2 = BigDecimal.valueOf(paramDouble * bigDecimal1.doubleValue());
/* 122 */     if (paramg.a().aZ()) {
/* 123 */       bigDecimal2 = bigDecimal2.divide(BigDecimal.valueOf(paramg.i()), 4, RoundingMode.DOWN);
/*     */     }
/*     */     
/* 126 */     if (bigDecimal2.compareTo(BigDecimal.ZERO) == 0) {
/* 127 */       bigDecimal2 = BigDecimal.valueOf(0.01D);
/*     */     }
/*     */ 
/*     */     
/* 131 */     BigDecimal bigDecimal3 = BigDecimal.valueOf(paramg.f());
/* 132 */     BigDecimal bigDecimal4 = bigDecimal3.subtract(bigDecimal2).setScale(2, RoundingMode.DOWN);
/*     */ 
/*     */     
/* 135 */     BigDecimal bigDecimal5 = bigDecimal3;
/* 136 */     BigDecimal bigDecimal6 = BigDecimal.valueOf(paramg.f().m());
/* 137 */     if (bigDecimal4.compareTo(bigDecimal6) <= 0) {
/* 138 */       bigDecimal5 = bigDecimal6;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 143 */     BigDecimal bigDecimal7 = a(paramg, bigDecimal5, bigDecimal4);
/* 144 */     if (bigDecimal7.compareTo(bigDecimal6) <= 0) {
/* 145 */       bigDecimal7 = a(paramg, bigDecimal6, bigDecimal7);
/*     */     }
/*     */     
/* 148 */     if (bigDecimal7.compareTo(BigDecimal.ZERO) > 0 && bigDecimal7.compareTo(bigDecimal4) < 0) {
/* 149 */       bigDecimal4 = bigDecimal7;
/*     */     }
/*     */     
/* 152 */     BigDecimal bigDecimal8 = BigDecimal.valueOf(paramg.l());
/* 153 */     if (bigDecimal4.compareTo(bigDecimal8) < 0) {
/* 154 */       return BigDecimal.ZERO;
/*     */     }
/*     */     
/* 157 */     return bigDecimal4;
/*     */   }
/*     */   
/*     */   private BigDecimal a(g paramg, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2) {
/* 161 */     BigDecimal bigDecimal = BigDecimal.ZERO;
/* 162 */     byte b = 2;
/*     */     
/* 164 */     if (paramg.r().compareTo(BigDecimal.ZERO) > 0) {
/* 165 */       bigDecimal = paramg.r();
/* 166 */       bigDecimal = paramBigDecimal1.subtract(bigDecimal).setScale(b, RoundingMode.DOWN);
/* 167 */     } else if (paramg.s().compareTo(BigDecimal.ZERO) > 0) {
/* 168 */       BigDecimal bigDecimal1 = paramg.s();
/* 169 */       bigDecimal1 = bigDecimal1.divide(BigDecimal.valueOf(100L));
/* 170 */       BigDecimal bigDecimal2 = bigDecimal1.multiply(paramBigDecimal1);
/* 171 */       bigDecimal = paramBigDecimal1.subtract(bigDecimal2).setScale(b, RoundingMode.DOWN);
/* 172 */     } else if (paramBigDecimal2.compareTo(paramBigDecimal1) == 0) {
/* 173 */       bigDecimal = paramBigDecimal1.subtract(BigDecimal.valueOf(0.01D)).setScale(b, RoundingMode.DOWN);
/*     */     } 
/*     */     
/* 176 */     return bigDecimal;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\k\b\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */