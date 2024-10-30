/*     */ package br.com.arremate.k.b;
/*     */ 
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.q.b.g;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.RoundingMode;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class c
/*     */ {
/*     */   public Map<Integer, h> a(List<g> paramList, double paramDouble1, double paramDouble2, double paramDouble3, boolean paramBoolean) {
/*  25 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     
/*  27 */     if (paramDouble3 >= paramDouble2) {
/*  28 */       return (Map)hashMap;
/*     */     }
/*     */     
/*  31 */     if (paramDouble3 <= paramDouble1) {
/*  32 */       paramList.stream()
/*  33 */         .filter(paramg -> (paramg.l() < paramg.f() && paramg.l() > 0.0D))
/*     */         
/*  35 */         .forEach(paramg -> {
/*     */             double d = paramg.l();
/*     */             paramMap.put(Integer.valueOf(paramg.v()), new h(d));
/*     */           });
/*     */     } else {
/*  40 */       Double double_ = Double.valueOf(paramDouble2 - paramDouble3);
/*  41 */       hashMap.putAll(a(paramList, double_.doubleValue(), paramBoolean));
/*     */     } 
/*     */     
/*  44 */     return (Map)hashMap;
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
/*     */   private Map<Integer, h> a(List<g> paramList, double paramDouble, boolean paramBoolean) {
/*  56 */     ArrayList<a> arrayList = new ArrayList();
/*  57 */     double d1 = 0.0D;
/*     */ 
/*     */     
/*  60 */     for (g g : paramList) {
/*  61 */       double d3 = g.f();
/*  62 */       double d4 = g.l();
/*  63 */       double d5 = d3 - d4;
/*     */       
/*  65 */       if (d5 <= 0.0D || d4 <= 0.0D) {
/*     */         continue;
/*     */       }
/*     */       
/*  69 */       if (paramBoolean) {
/*  70 */         d5 *= g.i();
/*     */       }
/*     */       
/*  73 */       a a = new a(g.v());
/*  74 */       a.g(d5);
/*  75 */       a.h(d3);
/*  76 */       a.j(d4);
/*  77 */       a.k(g.i());
/*  78 */       d1 += d5;
/*  79 */       arrayList.add(a);
/*     */     } 
/*     */ 
/*     */     
/*  83 */     Collections.sort(arrayList, (parama1, parama2) -> Objects.equals(Double.valueOf(parama1.e()), Double.valueOf(parama2.e())) ? 0 : ((parama1.e() > parama2.e()) ? -1 : 1));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  91 */     double d2 = a(arrayList, d1, paramDouble, paramBoolean, true);
/*     */ 
/*     */     
/*  94 */     if (d2 > 0.0D) {
/*  95 */       a(arrayList, d1, d2, paramBoolean, false);
/*     */     }
/*     */ 
/*     */     
/*  99 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     
/* 101 */     arrayList.stream()
/* 102 */       .filter(parama -> (parama.g() > 0.0D && parama.g() < parama.f() && parama.g() >= parama.h()))
/*     */ 
/*     */       
/* 105 */       .forEach(parama -> paramMap.put(Integer.valueOf(parama.v()), new h(parama.g())));
/*     */ 
/*     */ 
/*     */     
/* 109 */     return (Map)hashMap;
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
/*     */   private double a(List<a> paramList, double paramDouble1, double paramDouble2, boolean paramBoolean1, boolean paramBoolean2) {
/* 124 */     byte b = 4;
/* 125 */     Double double_ = Double.valueOf(0.0D);
/*     */     
/* 127 */     for (a a : paramList) {
/*     */ 
/*     */       
/* 130 */       double d1 = paramBoolean2 ? a.f() : a.g();
/* 131 */       double d2 = a(a.e(), paramDouble1);
/* 132 */       double d3 = d2 * paramDouble2;
/* 133 */       double d4 = a.i();
/*     */       
/* 135 */       if (d3 < 0.01D) {
/* 136 */         d3 = 0.01D;
/*     */       }
/*     */       
/* 139 */       if (paramBoolean1)
/*     */       {
/* 141 */         d3 /= d4;
/*     */       }
/*     */       
/* 144 */       double d5 = d1 - d3;
/*     */       
/* 146 */       BigDecimal bigDecimal = BigDecimal.valueOf(d5).setScale(b, RoundingMode.DOWN);
/* 147 */       d5 = bigDecimal.doubleValue();
/*     */       
/* 149 */       if (d5 < a.h()) {
/* 150 */         d5 = a.h();
/*     */       }
/*     */ 
/*     */       
/* 154 */       double d6 = paramDouble2 - double_.doubleValue();
/*     */ 
/*     */       
/* 157 */       double d7 = d1 - d5;
/*     */       
/* 159 */       if (paramBoolean1) {
/* 160 */         d7 *= d4;
/*     */       }
/*     */       
/* 163 */       if (d6 < d7) {
/*     */         
/* 165 */         d5 = paramBoolean1 ? (d1 - d6 / d4) : (d1 - d6);
/*     */ 
/*     */         
/* 168 */         d5 = BigDecimal.valueOf(d5).setScale(b, RoundingMode.DOWN).doubleValue();
/*     */         
/* 170 */         if (d5 < a.h()) {
/* 171 */           d5 = a.h();
/*     */         }
/*     */ 
/*     */         
/* 175 */         double_ = Double.valueOf(paramDouble2);
/*     */       } else {
/* 177 */         double_ = Double.valueOf(double_.doubleValue() + d7);
/*     */       } 
/*     */       
/* 180 */       a.i(d5);
/*     */     } 
/*     */     
/* 183 */     return paramDouble2 - double_.doubleValue();
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
/*     */   private double a(double paramDouble1, double paramDouble2) {
/* 195 */     paramDouble1 *= 100.0D;
/*     */     
/* 197 */     double d = paramDouble1 / paramDouble2;
/*     */ 
/*     */     
/* 200 */     d /= 100.0D;
/*     */     
/* 202 */     return d;
/*     */   }
/*     */   
/*     */   private static class a
/*     */   {
/*     */     private final int ah;
/*     */     private double e;
/*     */     private double f;
/*     */     private double g;
/*     */     private double h;
/*     */     private double i;
/*     */     
/*     */     public a(int param1Int) {
/* 215 */       this.ah = param1Int;
/*     */     }
/*     */     
/*     */     public int v() {
/* 219 */       return this.ah;
/*     */     }
/*     */     
/*     */     public void g(double param1Double) {
/* 223 */       this.e = param1Double;
/*     */     }
/*     */     
/*     */     public double e() {
/* 227 */       return this.e;
/*     */     }
/*     */     
/*     */     public double f() {
/* 231 */       return this.f;
/*     */     }
/*     */     
/*     */     public void h(double param1Double) {
/* 235 */       this.f = param1Double;
/*     */     }
/*     */     
/*     */     public double g() {
/* 239 */       return this.g;
/*     */     }
/*     */     
/*     */     public void i(double param1Double) {
/* 243 */       this.g = param1Double;
/*     */     }
/*     */     
/*     */     public double h() {
/* 247 */       return this.h;
/*     */     }
/*     */     
/*     */     public void j(double param1Double) {
/* 251 */       this.h = param1Double;
/*     */     }
/*     */     
/*     */     public double i() {
/* 255 */       return this.i;
/*     */     }
/*     */     
/*     */     public void k(double param1Double) {
/* 259 */       this.i = param1Double;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\k\b\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */