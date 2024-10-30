/*     */ package br.com.arremate.l;
/*     */ 
/*     */ import br.com.arremate.f.h;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.s;
/*     */ import br.com.arremate.f.v;
/*     */ import br.com.arremate.f.w;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.concurrent.atomic.AtomicLong;
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
/*     */ public abstract class g
/*     */   implements f
/*     */ {
/*     */   private final int ah;
/*     */   private final j a;
/*     */   private final AtomicLong d;
/*     */   private String aH;
/*     */   private String dX;
/*     */   private String dJ;
/*     */   private double j;
/*     */   private double k;
/*     */   private double l;
/*     */   private BigDecimal i;
/*     */   private boolean X;
/*     */   private b a;
/*     */   private int ai;
/*     */   private int aO;
/*     */   private double i;
/*     */   private String dY;
/*     */   private boolean Y;
/*     */   private String dV;
/*     */   private double f;
/*     */   private h b;
/*     */   private s e;
/*     */   private long O;
/*     */   private long P;
/*     */   private BigDecimal j;
/*     */   private BigDecimal k;
/*     */   private boolean Z;
/*     */   private double m;
/*     */   private boolean V = false;
/*     */   private boolean W = false;
/*     */   private int aP;
/*     */   private String dZ;
/*     */   private String ea;
/*     */   
/*     */   public g(int paramInt, j paramj) {
/*  62 */     this.ah = paramInt;
/*  63 */     this.a = (b)paramj;
/*  64 */     this.d = new AtomicLong();
/*     */     
/*  66 */     this.aO = h.i.v();
/*  67 */     this.e = s.d;
/*  68 */     this.i = 1.0D;
/*  69 */     this.dX = "";
/*  70 */     this.j = BigDecimal.ZERO;
/*  71 */     this.k = BigDecimal.ZERO;
/*     */   }
/*     */   
/*     */   public abstract boolean ao();
/*     */   
/*     */   public abstract boolean aq();
/*     */   
/*     */   public boolean aM() {
/*  79 */     return (ar() || as() || at());
/*     */   }
/*     */   
/*     */   public abstract boolean ar();
/*     */   
/*     */   public abstract boolean as();
/*     */   
/*     */   public boolean at() {
/*  87 */     return false;
/*     */   }
/*     */   
/*     */   public boolean au() {
/*  91 */     return false;
/*     */   }
/*     */   
/*     */   public boolean av() {
/*  95 */     return false;
/*     */   }
/*     */   
/*     */   public abstract boolean aw();
/*     */   
/*     */   public abstract boolean ax();
/*     */   
/*     */   public j a() {
/* 103 */     return (j)this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public int v() {
/* 108 */     return this.ah;
/*     */   }
/*     */   
/*     */   public String K() {
/* 112 */     return this.aH;
/*     */   }
/*     */ 
/*     */   
/*     */   public void ag(String paramString) {
/* 117 */     if (paramString.length() > 500) {
/* 118 */       paramString = paramString.substring(0, 500);
/*     */     }
/*     */     
/* 121 */     this.aH = paramString;
/*     */   }
/*     */   
/*     */   public String bo() {
/* 125 */     return this.dJ;
/*     */   }
/*     */   
/*     */   public void T(String paramString) {
/* 129 */     this.dJ = paramString;
/*     */   }
/*     */   
/*     */   public double j() {
/* 133 */     return this.j;
/*     */   }
/*     */   
/*     */   public void m(double paramDouble) {
/* 137 */     this.j = paramDouble;
/*     */   }
/*     */   
/*     */   public double k() {
/* 141 */     return this.k;
/*     */   }
/*     */   
/*     */   public void n(double paramDouble) {
/* 145 */     this.k = paramDouble;
/*     */   }
/*     */   
/*     */   public double l() {
/* 149 */     return (this.l != 0.0D) ? this.l : ((this.f != 0.0D) ? this.f : this.k);
/*     */   }
/*     */   
/*     */   public void o(double paramDouble) {
/* 153 */     this.l = paramDouble;
/*     */   }
/*     */   
/*     */   public boolean aT() {
/* 157 */     return this.X;
/*     */   }
/*     */   
/*     */   public void x(boolean paramBoolean) {
/* 161 */     this.X = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean aQ() {
/* 165 */     return (this.a != null || (this.aO != 0 && this.aO != h.i
/*     */       
/* 167 */       .v() && this.aO != 1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public b b() {
/* 178 */     if (this.a == null) {
/* 179 */       return this.a.b();
/*     */     }
/* 181 */     return this.a;
/*     */   }
/*     */   
/*     */   public void a(b paramb) {
/* 185 */     this.a = paramb;
/*     */   }
/*     */   
/*     */   public int w() {
/* 189 */     return this.ai;
/*     */   }
/*     */   
/*     */   public void R(int paramInt) {
/* 193 */     this.ai = paramInt;
/*     */   }
/*     */   
/*     */   public int j() {
/* 197 */     return this.aO;
/*     */   }
/*     */   
/*     */   public void l(int paramInt) {
/* 201 */     this.aO = paramInt;
/*     */   }
/*     */   
/*     */   public double i() {
/* 205 */     return this.i;
/*     */   }
/*     */   
/*     */   public void k(double paramDouble) {
/* 209 */     this.i = paramDouble;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean aU() {
/* 218 */     d d = a().a();
/* 219 */     n n = a().b();
/* 220 */     m m = a().a();
/*     */     
/* 222 */     return b().a(n, d, m);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean aV() {
/* 231 */     return (this.a != null);
/*     */   }
/*     */   
/*     */   public String bB() {
/* 235 */     return this.dV;
/*     */   }
/*     */   
/*     */   public void N(String paramString) {
/* 239 */     this.dV = paramString;
/*     */   }
/*     */   
/*     */   public double f() {
/* 243 */     return this.f;
/*     */   }
/*     */   
/*     */   public void h(double paramDouble) {
/* 247 */     this.f = paramDouble;
/*     */   }
/*     */   
/*     */   public h f() {
/* 251 */     if (this.b == null) {
/* 252 */       l(0.0D);
/*     */     }
/*     */     
/* 255 */     return this.b;
/*     */   }
/*     */   
/*     */   public void h(h paramh) {
/* 259 */     this.b = paramh;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void l(double paramDouble) {
/* 268 */     this.b = new h(paramDouble);
/*     */   }
/*     */   
/*     */   public s a() {
/* 272 */     return (this.e != null) ? this.e : s.d;
/*     */   }
/*     */   
/*     */   public void S(int paramInt) {
/* 276 */     this.e = s.a(paramInt);
/*     */   }
/*     */   
/*     */   public void a(s params) {
/* 280 */     this.e = params;
/*     */   }
/*     */   
/*     */   public long A() {
/* 284 */     return this.O;
/*     */   }
/*     */   
/*     */   public void y(long paramLong) {
/* 288 */     this.O = paramLong;
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
/*     */   public long B() {
/* 313 */     return this.P;
/*     */   }
/*     */   
/*     */   public void z(long paramLong) {
/* 317 */     this.P = paramLong;
/*     */   }
/*     */   
/*     */   public double a() {
/* 321 */     return this.m;
/*     */   }
/*     */   
/*     */   public void p(double paramDouble) {
/* 325 */     this.m = paramDouble;
/*     */   }
/*     */   
/*     */   public String bD() {
/* 329 */     return (this.dX != null) ? this.dX : "";
/*     */   }
/*     */   
/*     */   public void ah(String paramString) {
/* 333 */     this.dX = paramString;
/*     */   }
/*     */   
/*     */   public BigDecimal r() {
/* 337 */     return this.j;
/*     */   }
/*     */   
/*     */   public void e(BigDecimal paramBigDecimal) {
/* 341 */     if (paramBigDecimal != null) {
/* 342 */       this.j = paramBigDecimal;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal l() {
/* 348 */     BigDecimal bigDecimal = BigDecimal.valueOf(this.f - l());
/*     */     
/* 350 */     if (bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
/* 351 */       return BigDecimal.ZERO;
/*     */     }
/*     */     
/* 354 */     return bigDecimal;
/*     */   }
/*     */   
/*     */   public BigDecimal s() {
/* 358 */     return this.k;
/*     */   }
/*     */   
/*     */   public void f(BigDecimal paramBigDecimal) {
/* 362 */     if (paramBigDecimal != null) {
/* 363 */       this.k = paramBigDecimal;
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean aW() {
/* 368 */     return this.Z;
/*     */   }
/*     */   
/*     */   public void y(boolean paramBoolean) {
/* 372 */     this.Z = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean aX() {
/* 376 */     if (r().compareTo(BigDecimal.ZERO) == 1) {
/* 377 */       b b1 = b();
/*     */       
/* 379 */       if (b1.a() == w.a) {
/* 380 */         return (b1.g().compareTo(r()) == -1);
/*     */       }
/*     */       
/* 383 */       return true;
/*     */     } 
/*     */     
/* 386 */     if (s().compareTo(BigDecimal.ZERO) == 1) {
/* 387 */       b b1 = b();
/*     */       
/* 389 */       if (aQ() && w() == v.b.v()) {
/* 390 */         return (b1.g().compareTo(s()) == -1);
/*     */       }
/*     */       
/* 393 */       if (b1.a() == w.b) {
/* 394 */         return (b1.g().multiply(BigDecimal.valueOf(100L)).compareTo(s()) == -1);
/*     */       }
/*     */       
/* 397 */       return true;
/*     */     } 
/*     */     
/* 400 */     return false;
/*     */   }
/*     */   
/*     */   public long z() {
/* 404 */     return this.d.get();
/*     */   }
/*     */   
/*     */   public void x(long paramLong) {
/* 408 */     this.d.set(paramLong);
/*     */   }
/*     */   
/*     */   public BigDecimal t() {
/* 412 */     return (this.i != null) ? this.i : BigDecimal.valueOf(l());
/*     */   }
/*     */   
/*     */   public void g(BigDecimal paramBigDecimal) {
/* 416 */     this.i = paramBigDecimal;
/*     */   }
/*     */   
/*     */   public boolean aY() {
/* 420 */     return (this.i == null);
/*     */   }
/*     */   
/*     */   public boolean aR() {
/* 424 */     return this.V;
/*     */   }
/*     */   
/*     */   public void v(boolean paramBoolean) {
/* 428 */     this.V = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean az() {
/* 433 */     return this.a.k();
/*     */   }
/*     */   
/*     */   public boolean aS() {
/* 437 */     return this.W;
/*     */   }
/*     */   
/*     */   public void w(boolean paramBoolean) {
/* 441 */     this.W = paramBoolean;
/*     */   }
/*     */   
/*     */   public int H() {
/* 445 */     return this.aP;
/*     */   }
/*     */   
/*     */   public void T(int paramInt) {
/* 449 */     this.aP = paramInt;
/*     */   }
/*     */   
/*     */   public String bE() {
/* 453 */     return (this.dZ == null) ? "" : this.dZ;
/*     */   }
/*     */   
/*     */   public void ai(String paramString) {
/* 457 */     this.dZ = paramString;
/*     */   }
/*     */   
/*     */   public String bF() {
/* 461 */     return this.dY;
/*     */   }
/*     */   
/*     */   public void aj(String paramString) {
/* 465 */     this.dY = paramString;
/*     */   }
/*     */   
/*     */   public boolean aZ() {
/* 469 */     return this.Y;
/*     */   }
/*     */   
/*     */   public void z(boolean paramBoolean) {
/* 473 */     this.Y = paramBoolean;
/*     */   }
/*     */   
/*     */   public BigDecimal u() {
/* 477 */     BigDecimal bigDecimal = BigDecimal.valueOf(1.0E-4D);
/*     */     
/* 479 */     if (r() != null && r().compareTo(bigDecimal) > 0) {
/* 480 */       bigDecimal = r();
/*     */     }
/*     */ 
/*     */     
/* 484 */     if (bigDecimal.compareTo(l()) > 0) {
/* 485 */       return BigDecimal.ZERO;
/*     */     }
/*     */     
/* 488 */     if (a().aZ()) {
/* 489 */       bigDecimal = bigDecimal.multiply(BigDecimal.valueOf(i()));
/*     */     }
/*     */     
/* 492 */     return bigDecimal;
/*     */   }
/*     */   
/*     */   public String bG() {
/* 496 */     return this.ea;
/*     */   }
/*     */   
/*     */   public void ak(String paramString) {
/* 500 */     this.ea = paramString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */