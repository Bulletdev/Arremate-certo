/*     */ package br.com.arremate.l.q.b;
/*     */ 
/*     */ import br.com.arremate.f.h;
/*     */ import br.com.arremate.f.l;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.o;
/*     */ import br.com.arremate.f.r;
/*     */ import br.com.arremate.f.s;
/*     */ import br.com.arremate.f.w;
/*     */ import br.com.arremate.l.b;
/*     */ import br.com.arremate.l.f;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.m.y;
/*     */ import br.com.arremate.n.g;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ 
/*     */ public class e implements f {
/*     */   private final g b;
/*     */   private r d;
/*     */   private boolean ah;
/*     */   private int bO;
/*     */   private int bP;
/*     */   private String N;
/*     */   
/*     */   public e(g paramg) {
/*  31 */     this.b = paramg;
/*  32 */     this.d = r.b;
/*  33 */     this.ah = true;
/*     */   }
/*     */   
/*     */   public Object[] toArray() {
/*  37 */     Object[] arrayOfObject = new Object[18];
/*     */     
/*  39 */     arrayOfObject[0] = "/img/transparent.png";
/*  40 */     arrayOfObject[1] = cl();
/*  41 */     arrayOfObject[2] = "/img/hammer.png";
/*  42 */     arrayOfObject[3] = a();
/*  43 */     arrayOfObject[4] = cm();
/*  44 */     arrayOfObject[5] = m();
/*  45 */     arrayOfObject[6] = bo();
/*  46 */     arrayOfObject[7] = K();
/*  47 */     arrayOfObject[9] = Double.valueOf(k());
/*  48 */     arrayOfObject[11] = Double.valueOf(y().doubleValue());
/*  49 */     arrayOfObject[10] = Double.valueOf(l());
/*  50 */     arrayOfObject[12] = (f() <= 0.0D) ? null : Double.valueOf(f());
/*  51 */     arrayOfObject[13] = (f().m() <= 0.0D) ? null : Double.valueOf(f().m());
/*  52 */     arrayOfObject[8] = bB();
/*  53 */     arrayOfObject[15] = Integer.valueOf(V());
/*  54 */     arrayOfObject[16] = Integer.valueOf(W());
/*  55 */     arrayOfObject[14] = cn();
/*  56 */     arrayOfObject[17] = ck();
/*     */     
/*  58 */     return arrayOfObject;
/*     */   }
/*     */   
/*     */   public String ck() {
/*  62 */     if (this instanceof f)
/*  63 */       return StringUtils.leftPad(bo().replaceAll("G", ""), 6, "0"); 
/*  64 */     if (this instanceof g) {
/*  65 */       g g1 = (g)this;
/*  66 */       return StringUtils.leftPad(g1.a().bo().replace("G", ""), 6, "0") + " " + 
/*  67 */         StringUtils.leftPad(bo().replaceAll("\\D", ""), 5, "0");
/*     */     } 
/*  69 */     return StringUtils.leftPad(bo().replaceAll("\\D", ""), 5, "0");
/*     */   }
/*     */ 
/*     */   
/*     */   public String cl() {
/*  74 */     if (this.b != null && 
/*  75 */       this.b.aQ()) {
/*  76 */       return "/img/config_edit.png";
/*     */     }
/*     */ 
/*     */     
/*  80 */     return "/img/config.png";
/*     */   }
/*     */   
/*     */   public g a() {
/*  84 */     return this.b;
/*     */   }
/*     */   
/*     */   public boolean bp() {
/*  88 */     return this.ah;
/*     */   }
/*     */   
/*     */   public void R(boolean paramBoolean) {
/*  92 */     this.ah = paramBoolean;
/*     */   }
/*     */   
/*     */   public double f() {
/*  96 */     return this.b.f();
/*     */   }
/*     */   
/*     */   public void h(double paramDouble) {
/* 100 */     this.b.h(paramDouble);
/*     */   }
/*     */   
/*     */   public h f() {
/* 104 */     return this.b.f();
/*     */   }
/*     */   
/*     */   public void l(double paramDouble) {
/* 108 */     this.b.l(paramDouble);
/*     */   }
/*     */   
/*     */   public void h(h paramh) {
/* 112 */     this.b.h(paramh);
/*     */   }
/*     */   
/*     */   public String bB() {
/* 116 */     return (this.b.bB() != null) ? this.b.bB() : "";
/*     */   }
/*     */   
/*     */   public void N(String paramString) {
/* 120 */     this.b.N(paramString);
/*     */   }
/*     */   
/*     */   public s a() {
/* 124 */     return this.b.a();
/*     */   }
/*     */   
/*     */   public void a(s params) {
/* 128 */     this.b.a(params);
/*     */   }
/*     */   
/*     */   public String cm() {
/* 132 */     if (aU()) {
/* 133 */       return "/img/switch_on.png";
/*     */     }
/* 135 */     return "/img/switch_off.png";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal l() {
/* 141 */     return this.b.l();
/*     */   }
/*     */   
/*     */   public r a() {
/* 145 */     return this.d;
/*     */   }
/*     */   
/*     */   public void a(r paramr) {
/* 149 */     this.d = paramr;
/*     */   }
/*     */   
/*     */   public String m() {
/* 153 */     return this.N;
/*     */   }
/*     */   
/*     */   public void i(String paramString) {
/* 157 */     this.N = paramString;
/*     */   }
/*     */   
/*     */   public boolean aU() {
/* 161 */     return this.b.aU();
/*     */   }
/*     */   
/*     */   public void q(boolean paramBoolean) {
/* 165 */     b b = this.b.b();
/* 166 */     g g1 = new g(this, null);
/* 167 */     w w = b.a();
/* 168 */     BigDecimal bigDecimal1 = b.f();
/* 169 */     BigDecimal bigDecimal2 = b.g();
/*     */     
/* 171 */     if (w == w.b) {
/* 172 */       bigDecimal1.multiply(BigDecimal.valueOf(100L));
/* 173 */       bigDecimal2.multiply(BigDecimal.valueOf(100L));
/*     */     } 
/*     */     
/* 176 */     g1.a(bigDecimal1, bigDecimal2, w
/*     */         
/* 178 */         .y(), h.i
/* 179 */         .v(), paramBoolean, b
/*     */         
/* 181 */         .aD(), b
/* 182 */         .a(a()).v(), b
/* 183 */         .aG(), b
/* 184 */         .aH(), b
/* 185 */         .aI(), b
/* 186 */         .v(), b
/* 187 */         .aE(), b
/* 188 */         .t(), b
/* 189 */         .E(), b
/* 190 */         .h(), b
/* 191 */         .u(), b
/* 192 */         .w(), b
/* 193 */         .aJ(), b
/* 194 */         .aK(), b
/* 195 */         .i(), b
/* 196 */         .aL(), b
/* 197 */         .F());
/*     */   }
/*     */ 
/*     */   
/*     */   protected String cn() {
/* 202 */     if (a().a() != m.a) {
/* 203 */       return co();
/*     */     }
/*     */     
/* 206 */     return cp();
/*     */   }
/*     */   
/*     */   public String co() {
/* 210 */     if (this.b.z() > 0L) {
/*     */       
/* 212 */       long l1 = this.b.z();
/* 213 */       long l2 = TimeUnit.MILLISECONDS.toSeconds(l1) % 60L;
/* 214 */       long l3 = TimeUnit.MILLISECONDS.toMinutes(l1) % 60L;
/*     */       
/* 216 */       String str = String.join(":", new CharSequence[] { StringUtils.leftPad(Long.toString(l3), 2, "0"), StringUtils.leftPad(Long.toString(l2), 2, "0") });
/*     */       
/* 218 */       j j = a().a();
/* 219 */       o o = j.b().a();
/* 220 */       l l = j.a();
/* 221 */       boolean bool = (l.equals(l.c) || l.equals(l.g)) ? true : false;
/* 222 */       if (o.equals(o.a) && bool) {
/* 223 */         long l4 = TimeUnit.MILLISECONDS.toHours(l1) % 24L;
/* 224 */         str = String.join(":", new CharSequence[] { Long.toString(l4), str });
/*     */       } 
/*     */       
/* 227 */       return str;
/*     */     } 
/*     */     
/* 230 */     return "";
/*     */   }
/*     */   
/*     */   public String cp() {
/* 234 */     String str = "";
/*     */     
/* 236 */     if (this.b.A() > 0L) {
/*     */ 
/*     */ 
/*     */       
/* 240 */       long l = this.b.A();
/* 241 */       Date date = new Date(l);
/* 242 */       str = y.formatDate(date, "HH:mm:ss");
/*     */     } 
/*     */     
/* 245 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   public int v() {
/* 250 */     return this.b.v();
/*     */   }
/*     */   
/*     */   public String bo() {
/* 254 */     return this.b.bo();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ay() {
/* 259 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean az() {
/* 264 */     return a().k();
/*     */   }
/*     */   
/*     */   public String K() {
/* 268 */     return this.b.K();
/*     */   }
/*     */   
/*     */   public boolean br() {
/* 272 */     return this.b.aw();
/*     */   }
/*     */   
/*     */   public boolean bs() {
/* 276 */     return this.b.ax();
/*     */   }
/*     */   
/*     */   public boolean bt() {
/* 280 */     return this.b.aM();
/*     */   }
/*     */   
/*     */   public boolean bu() {
/* 284 */     return this.b.as();
/*     */   }
/*     */   
/*     */   public boolean bv() {
/* 288 */     return this.b.at();
/*     */   }
/*     */   
/*     */   public boolean au() {
/* 292 */     return this.b.au();
/*     */   }
/*     */   
/*     */   public boolean bw() {
/* 296 */     return this.b.aq();
/*     */   }
/*     */   
/*     */   public boolean bx() {
/* 300 */     return this.b.av();
/*     */   }
/*     */   
/*     */   public double l() {
/* 304 */     return this.b.l();
/*     */   }
/*     */   
/*     */   public double k() {
/* 308 */     return this.b.k();
/*     */   }
/*     */   
/*     */   public double i() {
/* 312 */     return this.b.i();
/*     */   }
/*     */   
/*     */   public int V() {
/* 316 */     return this.bO;
/*     */   }
/*     */   
/*     */   public void ah(int paramInt) {
/* 320 */     this.bO = paramInt;
/*     */   }
/*     */   
/*     */   public int W() {
/* 324 */     return this.bP;
/*     */   }
/*     */   
/*     */   public void ai(int paramInt) {
/* 328 */     this.bP = paramInt;
/*     */   }
/*     */   
/*     */   public b b() {
/* 332 */     return this.b.b();
/*     */   }
/*     */   
/*     */   public j a() {
/* 336 */     return this.b.a();
/*     */   }
/*     */   
/*     */   public int w() {
/* 340 */     return this.b.w();
/*     */   }
/*     */   
/*     */   public int j() {
/* 344 */     return this.b.j();
/*     */   }
/*     */   
/*     */   public void l(int paramInt) {
/* 348 */     this.b.l(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean aW() {
/* 355 */     return this.b.aW();
/*     */   }
/*     */   
/*     */   public void y(boolean paramBoolean) {
/* 359 */     this.b.y(paramBoolean);
/*     */   }
/*     */   
/*     */   public BigDecimal r() {
/* 363 */     return this.b.r();
/*     */   }
/*     */   
/*     */   public BigDecimal s() {
/* 367 */     return this.b.s();
/*     */   }
/*     */   
/*     */   public long z() {
/* 371 */     return this.b.z();
/*     */   }
/*     */   
/*     */   public void C(long paramLong) {
/* 375 */     this.b.x(paramLong);
/*     */   }
/*     */   
/*     */   public BigDecimal y() {
/* 379 */     return this.b.t();
/*     */   }
/*     */   
/*     */   public BigDecimal n() {
/* 383 */     return this.b.t();
/*     */   }
/*     */   
/*     */   public void g(BigDecimal paramBigDecimal) {
/* 387 */     this.b.g(paramBigDecimal);
/*     */   }
/*     */   
/*     */   public boolean aR() {
/* 391 */     return this.b.aR();
/*     */   }
/*     */   
/*     */   public boolean aS() {
/* 395 */     return this.b.aS();
/*     */   }
/*     */   
/*     */   public void w(boolean paramBoolean) {
/* 399 */     this.b.w(paramBoolean);
/*     */   }
/*     */   
/*     */   public void v(boolean paramBoolean) {
/* 403 */     this.b.v(paramBoolean);
/*     */   }
/*     */   
/*     */   public void x(long paramLong) {
/* 407 */     this.b.x(paramLong);
/*     */   }
/*     */   
/*     */   public void e(BigDecimal paramBigDecimal) {
/* 411 */     this.b.e(paramBigDecimal);
/*     */   }
/*     */   
/*     */   public void f(BigDecimal paramBigDecimal) {
/* 415 */     this.b.f(paramBigDecimal);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\q\b\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */