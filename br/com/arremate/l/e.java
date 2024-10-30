/*     */ package br.com.arremate.l;
/*     */ 
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.f.h;
/*     */ import br.com.arremate.f.s;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class e
/*     */   implements f
/*     */ {
/*     */   private final int ah;
/*     */   private final String aH;
/*  19 */   private final List<g> x = new ArrayList<>();
/*     */   
/*     */   private int aO;
/*     */   
/*     */   private s e;
/*     */   
/*     */   private String dV;
/*     */   private h b;
/*     */   private boolean V = false;
/*     */   private boolean W = false;
/*     */   private long N;
/*     */   private String dW;
/*     */   private String dD;
/*     */   
/*     */   public e(int paramInt, String paramString) {
/*  34 */     this.ah = paramInt;
/*  35 */     this.aH = paramString;
/*  36 */     this.e = s.d;
/*  37 */     this.dW = "";
/*     */   }
/*     */   
/*     */   public void f(g paramg) {
/*  41 */     this.x.add(paramg);
/*     */   }
/*     */   
/*     */   public g a(int paramInt) {
/*  45 */     return this.x.get(paramInt);
/*     */   }
/*     */   
/*     */   public int G() {
/*  49 */     return this.x.size();
/*     */   }
/*     */   
/*     */   public boolean h(String paramString) {
/*  53 */     return this.x.stream().anyMatch(paramg -> paramg.bo().equals(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal j() {
/*  62 */     BigDecimal bigDecimal = BigDecimal.ZERO;
/*     */     
/*  64 */     for (g g : this.x) {
/*  65 */       BigDecimal bigDecimal1 = BigDecimal.valueOf(g.k());
/*     */       
/*  67 */       if (g.a().aZ()) {
/*  68 */         bigDecimal1 = bigDecimal1.multiply(BigDecimal.valueOf(g.i()));
/*     */       }
/*     */       
/*  71 */       bigDecimal = bigDecimal.add(bigDecimal1);
/*     */     } 
/*     */     
/*  74 */     return bigDecimal;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal k() {
/*  83 */     BigDecimal bigDecimal = BigDecimal.ZERO;
/*     */     
/*  85 */     for (g g : this.x) {
/*  86 */       BigDecimal bigDecimal1 = BigDecimal.valueOf(g.l());
/*     */       
/*  88 */       if (a().aZ()) {
/*  89 */         bigDecimal1 = bigDecimal1.multiply(BigDecimal.valueOf(g.i()));
/*     */       }
/*     */       
/*  92 */       bigDecimal = bigDecimal.add(bigDecimal1);
/*     */     } 
/*     */     
/*  95 */     return bigDecimal;
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal l() {
/* 100 */     BigDecimal bigDecimal = BigDecimal.ZERO;
/* 101 */     for (g g : this.x) {
/* 102 */       bigDecimal = bigDecimal.add(g.l());
/*     */     }
/* 104 */     return bigDecimal;
/*     */   }
/*     */   
/*     */   public BigDecimal m() {
/* 108 */     BigDecimal bigDecimal = BigDecimal.ZERO;
/*     */     
/* 110 */     for (g g : this.x) {
/* 111 */       BigDecimal bigDecimal1 = g.t();
/* 112 */       if (a().aZ()) {
/* 113 */         bigDecimal1 = bigDecimal1.multiply(BigDecimal.valueOf(g.i()));
/*     */       }
/*     */       
/* 116 */       bigDecimal = bigDecimal.add(bigDecimal1);
/*     */     } 
/* 118 */     return bigDecimal;
/*     */   }
/*     */   
/*     */   public BigDecimal n() {
/* 122 */     BigDecimal bigDecimal = BigDecimal.ZERO;
/*     */     
/* 124 */     for (g g : this.x) {
/* 125 */       BigDecimal bigDecimal1 = g.t();
/*     */       
/* 127 */       if (a().aZ()) {
/* 128 */         bigDecimal1 = bigDecimal1.multiply(BigDecimal.valueOf(g.i()));
/*     */       }
/*     */       
/* 131 */       if (a(g).compareTo(bigDecimal1) <= 0) {
/*     */         continue;
/*     */       }
/*     */       
/* 135 */       bigDecimal = bigDecimal.add(bigDecimal1);
/*     */     } 
/*     */     
/* 138 */     return bigDecimal;
/*     */   }
/*     */   
/*     */   public BigDecimal o() {
/* 142 */     BigDecimal bigDecimal = BigDecimal.ZERO;
/*     */     
/* 144 */     for (g g : this.x) {
/* 145 */       BigDecimal bigDecimal1 = a(g);
/* 146 */       bigDecimal = bigDecimal.add(bigDecimal1);
/*     */     } 
/*     */     
/* 149 */     return bigDecimal;
/*     */   }
/*     */   
/*     */   public BigDecimal p() {
/* 153 */     BigDecimal bigDecimal = BigDecimal.ZERO;
/* 154 */     for (g g : this.x) {
/* 155 */       bigDecimal = bigDecimal.add(c(g));
/*     */     }
/* 157 */     return bigDecimal;
/*     */   }
/*     */   
/*     */   private BigDecimal a(g paramg) {
/* 161 */     if (a().aZ()) {
/* 162 */       return BigDecimal.valueOf(paramg.f() * paramg.i());
/*     */     }
/*     */     
/* 165 */     return BigDecimal.valueOf(paramg.f());
/*     */   }
/*     */   
/*     */   private BigDecimal b(g paramg) {
/* 169 */     if (a().aZ()) {
/* 170 */       return BigDecimal.valueOf(paramg.l() * paramg.i());
/*     */     }
/*     */     
/* 173 */     return BigDecimal.valueOf(paramg.l());
/*     */   }
/*     */   
/*     */   public BigDecimal c(g paramg) {
/* 177 */     BigDecimal bigDecimal = a(paramg).subtract(b(paramg));
/*     */     
/* 179 */     if (bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
/* 180 */       return BigDecimal.ZERO;
/*     */     }
/*     */     
/* 183 */     return bigDecimal;
/*     */   }
/*     */   
/*     */   public boolean aQ() {
/* 187 */     if (this.x.size() > 0) {
/* 188 */       return (((g)this.x.get(0)).aQ() || (this.aO != 0 && this.aO != h.i
/*     */         
/* 190 */         .v() && this.aO != 1));
/*     */     }
/*     */     
/* 193 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double f() {
/* 202 */     BigDecimal bigDecimal = BigDecimal.ZERO;
/*     */     
/* 204 */     for (g g : this.x) {
/* 205 */       if (g.a().aZ()) {
/* 206 */         bigDecimal = bigDecimal.add(BigDecimal.valueOf(g.f()).multiply(BigDecimal.valueOf(g.i()))); continue;
/*     */       } 
/* 208 */       bigDecimal = bigDecimal.add(BigDecimal.valueOf(g.f()));
/*     */     } 
/*     */ 
/*     */     
/* 212 */     return bigDecimal.doubleValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(b paramb) {
/* 221 */     for (g g : this.x) {
/* 222 */       g.a(paramb);
/*     */     }
/*     */   }
/*     */   
/*     */   public b b() throws NullPointerException {
/* 227 */     if (this.x.size() > 0) {
/* 228 */       return ((g)this.x.get(0)).b();
/*     */     }
/*     */     
/* 231 */     return null;
/*     */   }
/*     */   
/*     */   public j a() throws NullPointerException {
/* 235 */     if (this.x.size() > 0) {
/* 236 */       return ((g)this.x.get(0)).a();
/*     */     }
/*     */     
/* 239 */     return null;
/*     */   }
/*     */   
/*     */   public String bA() {
/* 243 */     return K().toUpperCase().replace("G", "GRUPO ");
/*     */   }
/*     */   
/*     */   public boolean aq() {
/* 247 */     return g.b(bB(), g.g);
/*     */   }
/*     */   
/*     */   public boolean aM() {
/* 251 */     return (g.b(bB(), g.f) || 
/* 252 */       g.b(bB(), g.j) || 
/* 253 */       g.b(bB(), g.k) || 
/*     */       
/* 255 */       g.b(bB(), g.w) || 
/* 256 */       g.b(bB(), g.v) || 
/* 257 */       as() || 
/* 258 */       at());
/*     */   }
/*     */   
/*     */   public boolean as() {
/* 262 */     return (g.b(bB(), g.k) || 
/*     */       
/* 264 */       g.b(bB(), g.aE) || 
/* 265 */       g.b(bB(), g.w));
/*     */   }
/*     */   
/*     */   public boolean at() {
/* 269 */     return g.b(bB(), g.h);
/*     */   }
/*     */   
/*     */   public boolean au() {
/* 273 */     return (g.b(bB(), g.n) || 
/* 274 */       g.b(bB(), g.i) || 
/* 275 */       g.b(bB(), g.m) || 
/* 276 */       g.b(bB(), g.p) || 
/* 277 */       g.b(bB(), g.o));
/*     */   }
/*     */   
/*     */   public boolean av() {
/* 281 */     return (g.b(bB(), g.aW) || 
/* 282 */       g.b(bB(), g.q) || 
/* 283 */       g.b(bB(), g.l));
/*     */   }
/*     */   
/*     */   public boolean aw() {
/* 287 */     return g.b(bB(), g.s);
/*     */   }
/*     */   
/*     */   public boolean ax() {
/* 291 */     return g.b(bB(), g.av);
/*     */   }
/*     */ 
/*     */   
/*     */   public int v() {
/* 296 */     return this.ah;
/*     */   }
/*     */   
/*     */   public String bo() {
/* 300 */     return K();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ay() {
/* 305 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean az() {
/* 310 */     return a().k();
/*     */   }
/*     */   
/*     */   public String K() {
/* 314 */     return this.aH;
/*     */   }
/*     */   
/*     */   public int j() {
/* 318 */     return this.aO;
/*     */   }
/*     */   
/*     */   public void l(int paramInt) {
/* 322 */     this.aO = paramInt;
/*     */   }
/*     */   
/*     */   public s a() {
/* 326 */     return (this.e != null) ? this.e : s.d;
/*     */   }
/*     */   
/*     */   public void a(s params) {
/* 330 */     this.e = params;
/*     */   }
/*     */   
/*     */   public h f() {
/* 334 */     if (this.b == null) {
/* 335 */       l(0.0D);
/*     */     }
/*     */     
/* 338 */     return this.b;
/*     */   }
/*     */   
/*     */   public void h(h paramh) {
/* 342 */     this.b = paramh;
/*     */   }
/*     */   
/*     */   public void l(double paramDouble) {
/* 346 */     h h1 = new h(paramDouble);
/* 347 */     this.b = h1;
/*     */   }
/*     */   
/*     */   public String bB() {
/* 351 */     return this.dV;
/*     */   }
/*     */   
/*     */   public void N(String paramString) {
/* 355 */     this.dV = paramString;
/*     */   }
/*     */   
/*     */   public List<g> B() {
/* 359 */     return this.x;
/*     */   }
/*     */   
/*     */   public boolean aR() {
/* 363 */     return this.V;
/*     */   }
/*     */   
/*     */   public void v(boolean paramBoolean) {
/* 367 */     this.V = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean aS() {
/* 371 */     return this.W;
/*     */   }
/*     */   
/*     */   public void w(boolean paramBoolean) {
/* 375 */     this.W = paramBoolean;
/*     */   }
/*     */   
/*     */   public long z() {
/* 379 */     return this.N;
/*     */   }
/*     */   
/*     */   public void x(long paramLong) {
/* 383 */     this.N = paramLong;
/*     */   }
/*     */   
/*     */   public String bC() {
/* 387 */     return this.dW;
/*     */   }
/*     */   
/*     */   public void af(String paramString) {
/* 391 */     this.dW = paramString;
/*     */   }
/*     */   
/*     */   public String u() {
/* 395 */     return this.dD;
/*     */   }
/*     */   
/*     */   public void n(String paramString) {
/* 399 */     this.dD = paramString;
/*     */   }
/*     */   
/*     */   public BigDecimal q() {
/* 403 */     BigDecimal bigDecimal = BigDecimal.ZERO;
/*     */     
/* 405 */     for (g g : this.x) {
/* 406 */       BigDecimal bigDecimal1 = BigDecimal.valueOf(1.0E-4D);
/*     */       
/* 408 */       if (g.r() != null && g
/* 409 */         .r().compareTo(bigDecimal1) > 0) {
/* 410 */         bigDecimal1 = g.r();
/*     */       }
/*     */       
/* 413 */       if (a().aZ()) {
/* 414 */         bigDecimal1 = bigDecimal1.multiply(BigDecimal.valueOf(g.i()));
/*     */       }
/*     */       
/* 417 */       if (bigDecimal.equals(BigDecimal.ZERO) || bigDecimal1.compareTo(bigDecimal) < 0) {
/* 418 */         bigDecimal = bigDecimal1;
/*     */       }
/*     */     } 
/*     */     
/* 422 */     return bigDecimal;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */