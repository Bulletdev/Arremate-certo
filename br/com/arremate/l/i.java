/*     */ package br.com.arremate.l;
/*     */ 
/*     */ import br.com.arremate.f.w;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Random;
/*     */ import org.jsoup.nodes.Element;
/*     */ 
/*     */ public class i
/*     */ {
/*     */   private int aQ;
/*     */   private int aR;
/*     */   private String eh;
/*     */   private Double f;
/*  14 */   private String ap = "";
/*  15 */   private String aq = "";
/*  16 */   private String ar = "";
/*  17 */   private String as = "";
/*  18 */   private String ao = "";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String dV;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean ab;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public i(int paramInt1, int paramInt2, String paramString1, Double paramDouble, String paramString2, Element paramElement) {
/*  34 */     this(paramInt1, paramInt2, paramString1, paramDouble, paramString2, paramElement, false);
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
/*     */   public i(int paramInt1, int paramInt2, String paramString1, Double paramDouble, String paramString2, Element paramElement, boolean paramBoolean) {
/*  50 */     this.aQ = paramInt1;
/*  51 */     this.aR = paramInt2;
/*  52 */     this.eh = paramString1;
/*  53 */     this.f = paramDouble;
/*  54 */     this.dV = paramString2;
/*  55 */     this.ab = paramBoolean;
/*     */     
/*  57 */     if (paramElement != null) {
/*  58 */       this.ap = paramElement.select("input[name=ippCod]").first().attr("value");
/*  59 */       this.aq = paramElement.select("input[name=valormin]").first().attr("value");
/*  60 */       this.ar = paramElement.select("input[name=menorlance]").first().attr("value");
/*  61 */       this.as = paramElement.select("input[name=formajulg]").first().attr("value");
/*  62 */       this.ao = paramElement.select("input[name=fatorEqualiz]").first().attr("value");
/*     */     } 
/*     */   }
/*     */   
/*     */   public int I() {
/*  67 */     return this.aQ;
/*     */   }
/*     */   
/*     */   public void U(int paramInt) {
/*  71 */     this.aQ = paramInt;
/*     */   }
/*     */   
/*     */   public int J() {
/*  75 */     return this.aR;
/*     */   }
/*     */   
/*     */   public void V(int paramInt) {
/*  79 */     this.aR = paramInt;
/*     */   }
/*     */   
/*     */   public String bM() {
/*  83 */     return this.eh;
/*     */   }
/*     */   
/*     */   public void aq(String paramString) {
/*  87 */     this.eh = paramString;
/*     */   }
/*     */   
/*     */   public Double b() {
/*  91 */     return this.f;
/*     */   }
/*     */   
/*     */   public void b(Double paramDouble) {
/*  95 */     this.f = paramDouble;
/*     */   }
/*     */   
/*     */   public String bN() {
/*  99 */     return this.ap;
/*     */   }
/*     */   
/*     */   public void ar(String paramString) {
/* 103 */     this.ap = paramString;
/*     */   }
/*     */   
/*     */   public String bO() {
/* 107 */     return this.aq;
/*     */   }
/*     */   
/*     */   public void as(String paramString) {
/* 111 */     this.aq = paramString;
/*     */   }
/*     */   
/*     */   public String bP() {
/* 115 */     return this.ar;
/*     */   }
/*     */   
/*     */   public void at(String paramString) {
/* 119 */     this.ar = paramString;
/*     */   }
/*     */   
/*     */   public String bQ() {
/* 123 */     return this.as;
/*     */   }
/*     */   
/*     */   public void au(String paramString) {
/* 127 */     this.as = paramString;
/*     */   }
/*     */   
/*     */   public String bR() {
/* 131 */     return this.ao;
/*     */   }
/*     */   
/*     */   public void av(String paramString) {
/* 135 */     this.ao = paramString;
/*     */   }
/*     */   
/*     */   public String bB() {
/* 139 */     return this.dV;
/*     */   }
/*     */   
/*     */   public void N(String paramString) {
/* 143 */     this.dV = paramString;
/*     */   }
/*     */   
/*     */   public boolean bc() {
/* 147 */     return this.ab;
/*     */   }
/*     */   
/*     */   public void B(boolean paramBoolean) {
/* 151 */     this.ab = paramBoolean;
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
/*     */   public static double a(b paramb, double paramDouble) {
/* 197 */     return a(paramb.f(), paramb.g(), paramb
/* 198 */         .a(), paramDouble);
/*     */   }
/*     */ 
/*     */   
/*     */   public static double a(BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, w paramw, double paramDouble) {
/* 203 */     Random random = new Random();
/*     */ 
/*     */     
/* 206 */     double d2 = paramBigDecimal2.subtract(paramBigDecimal1).doubleValue();
/*     */ 
/*     */     
/* 209 */     double d3 = random.nextDouble() * d2 + paramBigDecimal1.doubleValue();
/*     */     
/* 211 */     switch (null.k[paramw.ordinal()])
/*     */     { case 1:
/* 213 */         d1 = paramDouble + paramDouble * d3;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 222 */         return d1; }  double d1 = paramDouble + d3; return d1;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */