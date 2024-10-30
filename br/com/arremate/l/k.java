/*     */ package br.com.arremate.l;
/*     */ 
/*     */ import br.com.arremate.f.c;
/*     */ import java.math.BigDecimal;
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
/*     */ public class k
/*     */ {
/*     */   private String en;
/*     */   private String eo;
/*     */   private Double g;
/*     */   private BigDecimal l;
/*     */   private BigDecimal m;
/*     */   private String ep;
/*     */   private BigDecimal n;
/*     */   private String dZ;
/*     */   private g b;
/*     */   
/*     */   public k(g paramg) {
/*  30 */     this.b = paramg;
/*  31 */     String[] arrayOfString = { "Valor", "Percentual" };
/*  32 */     this.en = Integer.toString(paramg.v());
/*  33 */     this.eo = paramg.K();
/*  34 */     this.g = Double.valueOf(paramg.l());
/*  35 */     this.l = paramg.b().f();
/*  36 */     this.m = paramg.b().g();
/*  37 */     this.ep = arrayOfString[paramg.b().a().y()];
/*  38 */     this.n = paramg.t();
/*     */   }
/*     */   
/*     */   public k(g paramg, String paramString) {
/*  42 */     this.b = paramg;
/*  43 */     String[] arrayOfString = { "Valor", "Percentual" };
/*  44 */     this.en = Integer.toString(paramg.v());
/*  45 */     this.eo = paramg.K();
/*  46 */     this.g = Double.valueOf(paramg.l());
/*  47 */     this.l = paramg.b().f();
/*  48 */     this.m = paramg.b().g();
/*  49 */     this.ep = arrayOfString[paramg.b().a().y()];
/*  50 */     this.n = paramg.t();
/*  51 */     this.dZ = paramString;
/*     */   }
/*     */   
/*     */   public Object[] b() {
/*  55 */     Object[] arrayOfObject = new Object[6];
/*  56 */     arrayOfObject[c.a.v()] = this.en;
/*  57 */     arrayOfObject[c.b.v()] = this.eo;
/*  58 */     arrayOfObject[c.c.v()] = this.g;
/*  59 */     arrayOfObject[c.d.v()] = this.l;
/*  60 */     arrayOfObject[c.e.v()] = this.m;
/*  61 */     arrayOfObject[c.f.v()] = this.ep;
/*  62 */     return arrayOfObject;
/*     */   }
/*     */   
/*     */   public String bZ() {
/*  66 */     return this.en;
/*     */   }
/*     */   
/*     */   public void aB(String paramString) {
/*  70 */     this.en = paramString;
/*     */   }
/*     */   
/*     */   public String ca() {
/*  74 */     return this.eo;
/*     */   }
/*     */   
/*     */   public void aC(String paramString) {
/*  78 */     this.eo = paramString;
/*     */   }
/*     */   
/*     */   public double o() {
/*  82 */     return this.g.doubleValue();
/*     */   }
/*     */   
/*     */   public void r(double paramDouble) {
/*  86 */     this.g = Double.valueOf(paramDouble);
/*     */   }
/*     */   
/*     */   public BigDecimal v() {
/*  90 */     return this.l;
/*     */   }
/*     */   
/*     */   public void h(BigDecimal paramBigDecimal) {
/*  94 */     this.l = paramBigDecimal;
/*     */   }
/*     */   
/*     */   public BigDecimal w() {
/*  98 */     return this.m;
/*     */   }
/*     */   
/*     */   public void i(BigDecimal paramBigDecimal) {
/* 102 */     this.m = paramBigDecimal;
/*     */   }
/*     */   
/*     */   public String cb() {
/* 106 */     return this.ep;
/*     */   }
/*     */   
/*     */   public void aD(String paramString) {
/* 110 */     this.ep = paramString;
/*     */   }
/*     */   
/*     */   public BigDecimal x() {
/* 114 */     return this.n;
/*     */   }
/*     */   
/*     */   public void j(BigDecimal paramBigDecimal) {
/* 118 */     this.n = paramBigDecimal;
/*     */   }
/*     */   
/*     */   public g a() {
/* 122 */     return this.b;
/*     */   }
/*     */   
/*     */   public String bE() {
/* 126 */     return this.dZ;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\k.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */