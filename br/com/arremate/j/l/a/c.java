/*     */ package br.com.arremate.j.l.a;
/*     */ 
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.m.y;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.RoundingMode;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import java.util.Random;
/*     */ import java.util.concurrent.TimeUnit;
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
/*     */ public class c
/*     */ {
/*  35 */   private static final String dh = y.ac(d.DOMAIN + "itens_linhaItem.html");
/*  36 */   private static final String di = y.ac(d.DOMAIN + "consultaProposta_linhaItem.html");
/*  37 */   private static final String dj = y.ac(d.DOMAIN + "consultaProposta_linhaItemSrp.html");
/*  38 */   private static final String dk = y.ac(d.DOMAIN + "acompanhar2.html");
/*  39 */   private static final String dl = y.ac(d.DOMAIN + "acompanhar2_linhaItem.html");
/*     */   
/*  41 */   private static final String dm = "Melhor lance para o item foi ofertado a menos de 3 segundos. Seu lance foi descartado, conforme art. 2º da IN/MP nº 3, de 16/12/2011, alterado pela IN/MP nº 3, de 04/10/2013.";
/*  42 */   private static final String dn = "Lance anterior ofertado a menos de 20 segundos. Seu lance foi descartado, conforme art. 2º da IN/MP nº 3, de 16/12/2011, alterado pela IN/MP nº 3, de 04/10/2013.";
/*  43 */   private static final String do = "Lance não registrado. A situação do item impede o registro de novos lances.";
/*  44 */   private static final String dp = "Lance não registrado. O valor informado deve ser menor que seu último lance.";
/*     */   
/*     */   private final int code;
/*     */   
/*     */   private final String de;
/*     */   
/*     */   private final int aG;
/*     */   
/*     */   private final int aH;
/*     */   
/*     */   private final int aI;
/*     */   private final int aJ;
/*     */   private final List<h> t;
/*     */   private final List<e> u;
/*     */   private final int aK;
/*     */   private final boolean C;
/*     */   private g bv;
/*     */   private long startTime;
/*     */   private long currentTime;
/*     */   
/*     */   public c(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean) {
/*  65 */     this.code = paramInt1;
/*  66 */     this.de = paramString;
/*  67 */     this.aG = paramInt2;
/*  68 */     this.aH = paramInt3;
/*  69 */     this.aI = paramInt4;
/*  70 */     this.aJ = paramInt5;
/*  71 */     this.aK = paramInt6;
/*  72 */     this.C = paramBoolean;
/*  73 */     this.bv = g.f;
/*  74 */     this.startTime = 0L;
/*  75 */     this.currentTime = 0L;
/*  76 */     this.t = new ArrayList<>();
/*  77 */     this.u = new ArrayList<>();
/*     */   }
/*     */   
/*     */   public void a(e parame, h paramh) {
/*  81 */     this.t.add(paramh);
/*     */     
/*  83 */     if (parame != null)
/*  84 */       this.u.add(parame); 
/*     */   }
/*     */   
/*     */   public String build() {
/*     */     String str1, str2;
/*  89 */     cg();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  94 */     if (this.C) {
/*  95 */       str1 = Double.toString(d().m() / this.aK);
/*  96 */       str2 = Double.toString(e().m() / this.aK);
/*     */     } else {
/*  98 */       str1 = Double.toString(d().m());
/*  99 */       str2 = Double.toString(e().m());
/*     */     } 
/*     */ 
/*     */     
/* 103 */     String str3 = dh.replaceAll("##NUMERO##", this.de);
/* 104 */     str3 = str3.replaceAll("##CODIGO##", Integer.toString(this.code));
/* 105 */     str3 = str3.replace("##SITUACAO##", this.bv.getValue());
/* 106 */     str3 = str3.replace("##ICONE##", aQ());
/* 107 */     str3 = str3.replaceAll("##ULTIMOLANCE##", str1);
/* 108 */     str3 = str3.replaceAll("##MELHORLANCE##", str2);
/*     */     
/* 110 */     return str3;
/*     */   }
/*     */   
/*     */   public String aO() {
/* 114 */     h h = d();
/* 115 */     double d = h.m() / this.aK;
/* 116 */     DecimalFormat decimalFormat = y.a("###,###,###,##0.0000");
/* 117 */     String str1 = decimalFormat.format(d().m());
/* 118 */     String str2 = decimalFormat.format(d);
/* 119 */     String str3 = this.C ? dj : di;
/*     */     
/* 121 */     String str4 = str3.replace("##NUMERO##", this.de);
/* 122 */     str4 = str4.replace("##CODIGO##", Integer.toString(this.code));
/* 123 */     str4 = str4.replace("##QUANTIDADE##", Integer.toString(this.aK));
/* 124 */     str4 = str4.replace("##VALOR_TOTAL##", str1);
/* 125 */     str4 = str4.replace("##VALOR_UNITARIO##", str2);
/*     */     
/* 127 */     return str4;
/*     */   }
/*     */   
/*     */   protected void cg() {
/* 131 */     ch();
/* 132 */     long l = p();
/*     */     
/* 134 */     this.bv = a(l);
/*     */     
/* 136 */     ci();
/*     */   }
/*     */   
/*     */   private void ch() {
/* 140 */     this.currentTime = System.currentTimeMillis();
/*     */   }
/*     */   
/*     */   private long p() {
/* 144 */     return TimeUnit.MILLISECONDS.toSeconds(this.currentTime - this.startTime);
/*     */   }
/*     */   
/*     */   protected void ci() {
/* 148 */     this.u.parallelStream().forEachOrdered(parame -> {
/*     */           h h = e();
/*     */           double d = h.m();
/*     */           if (this.C) {
/*     */             d /= this.aK;
/*     */           }
/*     */           if (!h.ay().equals(parame.aT()) && parame.d() < d && a(parame.b())) {
/*     */             long l = getCurrentTime() - h.b().getTime();
/*     */             l = TimeUnit.MILLISECONDS.toSeconds(l);
/*     */             if (l > 4L) {
/*     */               double d1 = a(parame.a(), parame.b(), d);
/*     */               if (d1 < parame.d()) {
/*     */                 d1 = parame.d();
/*     */               }
/*     */               a(parame.aT(), d1);
/*     */             } 
/*     */           } 
/*     */         });
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
/*     */   private boolean a(g paramg) {
/* 177 */     return (paramg == g.f || this.bv == g.k || (this.bv == g.j && paramg == g.j));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String a(String paramString, double paramDouble) {
/* 184 */     g g1 = a(p());
/* 185 */     if (g1 == g.s || g1 == g.g)
/*     */     {
/* 187 */       return "AtualizarPagina('" + do + "');";
/*     */     }
/*     */     
/* 190 */     if (this.C) {
/* 191 */       paramDouble *= this.aK;
/*     */     }
/*     */     
/* 194 */     synchronized (this.t) {
/* 195 */       Date date = new Date(System.currentTimeMillis());
/* 196 */       h h1 = e();
/*     */ 
/*     */       
/* 199 */       long l1 = h1.b().getTime() + TimeUnit.SECONDS.toMillis(3L);
/*     */       
/* 201 */       if (paramDouble < h1.m() && date.before(new Date(l1))) {
/* 202 */         return "AtualizarPagina('" + dm + "');";
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 209 */       Optional<h> optional = this.t.stream().filter(paramh -> paramh.ay().equals(paramString)).findFirst();
/*     */       
/* 211 */       if (!optional.isPresent()) {
/* 212 */         return "AtualizarPagina('')";
/*     */       }
/*     */       
/* 215 */       h h2 = optional.get();
/*     */       
/* 217 */       if (paramDouble >= h2.m()) {
/* 218 */         return "AtualizarPagina('" + dp + "');";
/*     */       }
/*     */       
/* 221 */       long l2 = h2.b().getTime() + TimeUnit.SECONDS.toMillis(20L);
/*     */       
/* 223 */       if (date.before(new Date(l2))) {
/* 224 */         return "AtualizarPagina('" + dn + "');";
/*     */       }
/*     */       
/* 227 */       h2.q(paramDouble);
/* 228 */       h2.c(date);
/*     */       
/* 230 */       Collections.sort(this.t, (paramh1, paramh2) -> {
/*     */             if (paramh1.m() < paramh2.m()) {
/*     */               return -1;
/*     */             }
/*     */             if (paramh1.m() > paramh2.m()) {
/*     */               return 1;
/*     */             }
/*     */             if (paramh1.m() == paramh2.m()) {
/*     */               long l1 = paramh1.b().getTime();
/*     */               long l2 = paramh2.b().getTime();
/*     */               if (l1 < l2) {
/*     */                 return -1;
/*     */               }
/*     */               if (l1 > l2)
/*     */                 return 1; 
/*     */             } else {
/*     */               return 0;
/*     */             } 
/*     */             return 0;
/*     */           });
/* 250 */       for (byte b = 0; b < this.t.size(); b++) {
/* 251 */         ((h)this.t.get(b)).l(b + 1);
/*     */       }
/*     */     } 
/*     */     
/* 255 */     return "Lance+registrado+com+sucesso";
/*     */   }
/*     */ 
/*     */   
/*     */   protected double a(float paramFloat1, float paramFloat2, double paramDouble) {
/* 260 */     BigDecimal bigDecimal1 = new BigDecimal(paramDouble);
/* 261 */     BigDecimal bigDecimal2 = new BigDecimal(paramFloat1);
/*     */     
/* 263 */     if (paramFloat1 != paramFloat2) {
/* 264 */       Random random = new Random();
/* 265 */       BigDecimal bigDecimal3 = new BigDecimal(paramFloat1);
/* 266 */       BigDecimal bigDecimal4 = new BigDecimal(paramFloat2);
/* 267 */       BigDecimal bigDecimal5 = bigDecimal4.subtract(bigDecimal3);
/*     */       
/* 269 */       bigDecimal2 = (new BigDecimal(random.nextDouble())).multiply(bigDecimal5);
/* 270 */       bigDecimal2 = bigDecimal2.add(new BigDecimal(paramFloat1));
/* 271 */       bigDecimal2 = bigDecimal2.setScale(2, RoundingMode.DOWN);
/*     */       
/* 273 */       if (bigDecimal2.compareTo(bigDecimal3) == -1) {
/* 274 */         bigDecimal2 = bigDecimal3;
/* 275 */       } else if (bigDecimal2.compareTo(bigDecimal4) == 1) {
/* 276 */         bigDecimal2 = bigDecimal4;
/*     */       } 
/*     */     } 
/*     */     
/* 280 */     bigDecimal1 = bigDecimal1.subtract(bigDecimal2);
/* 281 */     return bigDecimal1.doubleValue();
/*     */   }
/*     */   
/*     */   public String aP() {
/* 285 */     StringBuilder stringBuilder = new StringBuilder();
/* 286 */     DecimalFormat decimalFormat = new DecimalFormat("###,###,###,##0.0000");
/* 287 */     String str = "#FFFFFF";
/*     */     
/* 289 */     for (h h : this.t) {
/* 290 */       double d = h.m();
/*     */       
/* 292 */       if (this.C) {
/* 293 */         d /= this.aK;
/*     */       }
/*     */       
/* 296 */       String str1 = dl.replace("##NOME_EMPRESA##", h.ay());
/* 297 */       str1 = str1.replace("##CNPJ##", h.av());
/* 298 */       str1 = str1.replace("##VALOR##", decimalFormat.format(d));
/* 299 */       str1 = str1.replace("##DATA_LANCE##", y.formatDate(h.b()));
/* 300 */       str1 = str1.replaceAll("##COR##", str);
/* 301 */       stringBuilder.append(str1);
/*     */       
/* 303 */       str = str.equals("#FFFFFF") ? "#FEFEFE" : "#FFFFFF";
/*     */     } 
/*     */     
/* 306 */     return dk.replace("##HTML_ITENS##", stringBuilder.toString());
/*     */   }
/*     */   
/*     */   protected h d() {
/* 310 */     return this.t
/* 311 */       .stream()
/* 312 */       .filter(paramh -> paramh.bb())
/* 313 */       .findFirst()
/* 314 */       .get();
/*     */   }
/*     */   
/*     */   protected h e() {
/* 318 */     return this.t
/* 319 */       .stream()
/* 320 */       .filter(paramh -> (paramh.j() == 1))
/* 321 */       .findFirst()
/* 322 */       .get();
/*     */   }
/*     */   
/*     */   protected h a(String paramString) {
/* 326 */     return this.t
/* 327 */       .stream()
/* 328 */       .filter(paramh -> paramh.ay().equals(paramString))
/* 329 */       .findFirst()
/* 330 */       .get();
/*     */   }
/*     */   
/*     */   private g a(long paramLong) {
/* 334 */     if (paramLong >= this.aJ)
/* 335 */       return g.s; 
/* 336 */     if (paramLong >= this.aI)
/* 337 */       return g.k; 
/* 338 */     if (paramLong >= this.aH)
/* 339 */       return g.j; 
/* 340 */     if (paramLong >= this.aG) {
/* 341 */       return g.f;
/*     */     }
/* 343 */     return g.g;
/*     */   }
/*     */   
/*     */   private String aQ() {
/* 347 */     return aj() ? "LanceVencedor" : "LanceNaoVencedor";
/*     */   }
/*     */   
/*     */   protected boolean aj() {
/* 351 */     return (d().m() == e().m());
/*     */   }
/*     */   
/*     */   protected long getStartTime() {
/* 355 */     return this.startTime;
/*     */   }
/*     */   
/*     */   protected g a() {
/* 359 */     return this.bv;
/*     */   }
/*     */   
/*     */   protected long getCurrentTime() {
/* 363 */     return this.currentTime;
/*     */   }
/*     */   
/*     */   void r(long paramLong) {
/* 367 */     this.startTime = paramLong;
/*     */   }
/*     */   
/*     */   public int getCode() {
/* 371 */     return this.code;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\l\a\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */