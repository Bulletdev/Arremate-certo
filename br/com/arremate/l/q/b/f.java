/*     */ package br.com.arremate.l.q.b;
/*     */ 
/*     */ import br.com.arremate.f.s;
/*     */ import br.com.arremate.f.v;
/*     */ import br.com.arremate.l.b;
/*     */ import br.com.arremate.l.e;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.m.y;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ public class f
/*     */   extends e
/*     */ {
/*     */   private String es;
/*     */   private final e a;
/*     */   
/*     */   public f(e parame) {
/*  21 */     super(null);
/*  22 */     R(true);
/*  23 */     this.a = parame;
/*  24 */     this.es = "/img/mais.png";
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[] toArray() {
/*  29 */     Object[] arrayOfObject = super.toArray();
/*     */     
/*  31 */     arrayOfObject[0] = cq();
/*  32 */     arrayOfObject[2] = "/img/transparent.png";
/*  33 */     arrayOfObject[4] = cm();
/*     */     
/*  35 */     return arrayOfObject;
/*     */   }
/*     */ 
/*     */   
/*     */   public String cl() {
/*  40 */     if (this.a != null && this.a.aQ()) {
/*  41 */       return "/img/config_edit.png";
/*     */     }
/*  43 */     return "/img/config.png";
/*     */   }
/*     */ 
/*     */   
/*     */   public e a() {
/*  48 */     return this.a;
/*     */   }
/*     */   
/*     */   public String cq() {
/*  52 */     return this.es;
/*     */   }
/*     */   
/*     */   public void aG(String paramString) {
/*  56 */     this.es = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public double l() {
/*  61 */     return a().k().doubleValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public double k() {
/*  66 */     return a().j().doubleValue();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double i() {
/*  72 */     return 1.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double f() {
/*  77 */     return a().f();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void h(double paramDouble) {}
/*     */ 
/*     */   
/*     */   public h f() {
/*  86 */     return a().f();
/*     */   }
/*     */ 
/*     */   
/*     */   public void h(h paramh) {
/*  91 */     a().h(paramh);
/*     */   }
/*     */ 
/*     */   
/*     */   public void l(double paramDouble) {
/*  96 */     a().l(paramDouble);
/*     */   }
/*     */ 
/*     */   
/*     */   public String bB() {
/* 101 */     if (a().bB() != null) {
/* 102 */       return a().bB();
/*     */     }
/* 104 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void N(String paramString) {
/* 110 */     a().N(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public s a() {
/* 115 */     s s = a().a();
/*     */     
/* 117 */     if (s != s.d) {
/* 118 */       return s;
/*     */     }
/*     */     
/* 121 */     if (f().bb()) {
/* 122 */       s = s.a;
/* 123 */     } else if (f() != null && f().m() > 0.0D) {
/* 124 */       s = s.c;
/*     */     } 
/* 126 */     return s;
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(s params) {
/* 131 */     a().a(params);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean aU() {
/* 136 */     return a().a(0).aU();
/*     */   }
/*     */ 
/*     */   
/*     */   public int v() {
/* 141 */     return a().v();
/*     */   }
/*     */ 
/*     */   
/*     */   public String bo() {
/* 146 */     return a().K();
/*     */   }
/*     */ 
/*     */   
/*     */   public String K() {
/* 151 */     return a().bA();
/*     */   }
/*     */ 
/*     */   
/*     */   public String cp() {
/* 156 */     return "";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean bs() {
/* 161 */     return a().ax();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean br() {
/* 166 */     return a().aw();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean bt() {
/* 171 */     return a().aM();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean bu() {
/* 176 */     return a().as();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean bw() {
/* 181 */     return a().aq();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean bx() {
/* 186 */     return a().av();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean bv() {
/* 191 */     return a().at();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean au() {
/* 196 */     return a().au();
/*     */   }
/*     */ 
/*     */   
/*     */   public int j() {
/* 201 */     return a().j();
/*     */   }
/*     */ 
/*     */   
/*     */   public void l(int paramInt) {
/* 206 */     a().l(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public b b() {
/* 211 */     return a().a(0).b();
/*     */   }
/*     */ 
/*     */   
/*     */   public j a() {
/* 216 */     return a().a();
/*     */   }
/*     */ 
/*     */   
/*     */   public int w() {
/* 221 */     return v.a.v();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean aW() {
/* 231 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal r() {
/* 236 */     return BigDecimal.ZERO;
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal s() {
/* 241 */     return BigDecimal.ZERO;
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal y() {
/* 246 */     return a().m();
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal n() {
/* 251 */     return a().n();
/*     */   }
/*     */ 
/*     */   
/*     */   public String co() {
/* 256 */     if (a().z() > 0L) {
/* 257 */       long l = a().z();
/* 258 */       return y.formatDate(new Date(l), "mm:ss");
/*     */     } 
/* 260 */     return "";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean aS() {
/* 265 */     return a().aS();
/*     */   }
/*     */ 
/*     */   
/*     */   public void w(boolean paramBoolean) {
/* 270 */     a().w(paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean aR() {
/* 275 */     return a().aR();
/*     */   }
/*     */ 
/*     */   
/*     */   public void v(boolean paramBoolean) {
/* 280 */     a().v(paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public void x(long paramLong) {
/* 285 */     a().x(paramLong);
/*     */   }
/*     */   
/*     */   public boolean aM() {
/* 289 */     return a().aM();
/*     */   }
/*     */   
/*     */   public boolean av() {
/* 293 */     return a().av();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ay() {
/* 298 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public long z() {
/* 303 */     return this.a.z();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void e(BigDecimal paramBigDecimal) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void f(BigDecimal paramBigDecimal) {}
/*     */ 
/*     */   
/*     */   public void C(long paramLong) {
/* 316 */     a().x(paramLong);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\q\b\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */