/*     */ package com.google.a.k;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
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
/*     */ @a
/*     */ @c
/*     */ public abstract class f
/*     */ {
/*     */   public static a a(double paramDouble1, double paramDouble2) {
/*  46 */     D.checkArgument((d.e(paramDouble1) && d.e(paramDouble2)));
/*  47 */     return new a(paramDouble1, paramDouble2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class a
/*     */   {
/*     */     private final double F;
/*     */ 
/*     */ 
/*     */     
/*     */     private final double G;
/*     */ 
/*     */ 
/*     */     
/*     */     private a(double param1Double1, double param1Double2) {
/*  64 */       this.F = param1Double1;
/*  65 */       this.G = param1Double2;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public f a(double param1Double1, double param1Double2) {
/*  75 */       D.checkArgument((d.e(param1Double1) && d.e(param1Double2)));
/*  76 */       if (param1Double1 == this.F) {
/*  77 */         D.checkArgument((param1Double2 != this.G));
/*  78 */         return new f.d(this.F);
/*     */       } 
/*  80 */       return c((param1Double2 - this.G) / (param1Double1 - this.F));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public f c(double param1Double) {
/*  90 */       D.checkArgument(!Double.isNaN(param1Double));
/*  91 */       if (d.e(param1Double)) {
/*  92 */         double d = this.G - this.F * param1Double;
/*  93 */         return new f.c(param1Double, d);
/*     */       } 
/*  95 */       return new f.d(this.F);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static f a(double paramDouble) {
/* 105 */     D.checkArgument(d.e(paramDouble));
/* 106 */     return new d(paramDouble);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static f b(double paramDouble) {
/* 114 */     D.checkArgument(d.e(paramDouble));
/* 115 */     double d = 0.0D;
/* 116 */     return new c(d, paramDouble);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static f a() {
/* 126 */     return b.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean isVertical();
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean isHorizontal();
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract double w();
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract double h(double paramDouble);
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract f b();
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class c
/*     */     extends f
/*     */   {
/*     */     final double H;
/*     */ 
/*     */     
/*     */     final double I;
/*     */ 
/*     */     
/*     */     @com.google.b.a.a.b
/*     */     f a;
/*     */ 
/*     */ 
/*     */     
/*     */     c(double param1Double1, double param1Double2) {
/* 167 */       this.H = param1Double1;
/* 168 */       this.I = param1Double2;
/* 169 */       this.a = null;
/*     */     }
/*     */     
/*     */     c(double param1Double1, double param1Double2, f param1f) {
/* 173 */       this.H = param1Double1;
/* 174 */       this.I = param1Double2;
/* 175 */       this.a = param1f;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isVertical() {
/* 180 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isHorizontal() {
/* 185 */       return (this.H == 0.0D);
/*     */     }
/*     */ 
/*     */     
/*     */     public double w() {
/* 190 */       return this.H;
/*     */     }
/*     */ 
/*     */     
/*     */     public double h(double param1Double) {
/* 195 */       return param1Double * this.H + this.I;
/*     */     }
/*     */ 
/*     */     
/*     */     public f b() {
/* 200 */       f f1 = this.a;
/* 201 */       return (f1 == null) ? (this.a = c()) : f1;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 206 */       return String.format("y = %g * x + %g", new Object[] { Double.valueOf(this.H), Double.valueOf(this.I) });
/*     */     }
/*     */     
/*     */     private f c() {
/* 210 */       if (this.H != 0.0D) {
/* 211 */         return new c(1.0D / this.H, -1.0D * this.I / this.H, this);
/*     */       }
/* 213 */       return new f.d(this.I, this);
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class d
/*     */     extends f
/*     */   {
/*     */     final double x;
/*     */     @com.google.b.a.a.b
/*     */     f a;
/*     */     
/*     */     d(double param1Double) {
/* 225 */       this.x = param1Double;
/* 226 */       this.a = null;
/*     */     }
/*     */     
/*     */     d(double param1Double, f param1f) {
/* 230 */       this.x = param1Double;
/* 231 */       this.a = param1f;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isVertical() {
/* 236 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isHorizontal() {
/* 241 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public double w() {
/* 246 */       throw new IllegalStateException();
/*     */     }
/*     */ 
/*     */     
/*     */     public double h(double param1Double) {
/* 251 */       throw new IllegalStateException();
/*     */     }
/*     */ 
/*     */     
/*     */     public f b() {
/* 256 */       f f1 = this.a;
/* 257 */       return (f1 == null) ? (this.a = c()) : f1;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 262 */       return String.format("x = %g", new Object[] { Double.valueOf(this.x) });
/*     */     }
/*     */     
/*     */     private f c() {
/* 266 */       return new f.c(0.0D, this.x, this);
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class b
/*     */     extends f {
/* 272 */     static final b a = new b();
/*     */ 
/*     */     
/*     */     public boolean isVertical() {
/* 276 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isHorizontal() {
/* 281 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public double w() {
/* 286 */       return Double.NaN;
/*     */     }
/*     */ 
/*     */     
/*     */     public double h(double param1Double) {
/* 291 */       return Double.NaN;
/*     */     }
/*     */ 
/*     */     
/*     */     public f b() {
/* 296 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 301 */       return "NaN";
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\k\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */