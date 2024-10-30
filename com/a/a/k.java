/*     */ package com.a.a;
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
/*     */ public class k
/*     */   extends o
/*     */ {
/*  65 */   private t a = new t(new double[] { 0.0D, 0.3333333333333333D, 0.6666666666666666D, 1.0D }, 4);
/*  66 */   private int gJ = 1;
/*  67 */   private int gK = 1;
/*     */   
/*     */   private boolean by = false;
/*     */   private boolean bz = false;
/*  71 */   private static double[][] a = new double[0][];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public k(f paramf, j paramj) {
/*  81 */     super(paramf, paramj);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int aL() {
/*  90 */     return this.gJ;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void aN(int paramInt) {
/* 101 */     if (paramInt < 0) throw new IllegalArgumentException("base index >= 0 required."); 
/* 102 */     this.gJ = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int aM() {
/* 111 */     return this.gK;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void aO(int paramInt) {
/* 121 */     if (paramInt <= 0) throw new IllegalArgumentException("base length > 0 required."); 
/* 122 */     this.gK = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean dM() {
/* 132 */     return this.by;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean dN() {
/* 142 */     return this.bz;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ak(boolean paramBoolean) {
/* 151 */     this.by = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void al(boolean paramBoolean) {
/* 160 */     this.bz = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public t a() {
/* 169 */     return (t)this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(t paramt) {
/* 179 */     if (paramt == null)
/* 180 */       throw new IllegalArgumentException("Knot-vector cannot be null."); 
/* 181 */     this.a = (double[][])paramt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int aA() {
/* 188 */     return 1;
/*     */   }
/*     */   
/*     */   protected void c(double[] paramArrayOfdouble) {
/* 192 */     double d = paramArrayOfdouble[paramArrayOfdouble.length - 1];
/*     */     
/* 194 */     int i = this.a.size();
/*     */     
/* 196 */     for (byte b = 0; b < i; b++) {
/* 197 */       double[] arrayOfDouble = a[b];
/* 198 */       double d1 = c(d, b);
/* 199 */       for (byte b1 = 0; b1 < paramArrayOfdouble.length - 1; b1++)
/* 200 */         paramArrayOfdouble[b1] = paramArrayOfdouble[b1] + arrayOfDouble[b1] * d1; 
/*     */     } 
/*     */   }
/*     */   
/*     */   private double c(double paramDouble, int paramInt) {
/* 205 */     double d = 1.0D;
/*     */     
/* 207 */     int i = this.a.size();
/*     */     
/* 209 */     for (byte b = 0; b < i; b++) {
/* 210 */       double d1 = this.a.a(paramInt) - this.a.a(b);
/* 211 */       if (d1 != 0.0D) {
/* 212 */         d *= (paramDouble - this.a.a(b)) / d1;
/*     */       }
/*     */     } 
/* 215 */     return d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(l paraml) {
/* 226 */     if (!this.a.isInRange(0, this.a.aE()))
/* 227 */       throw new IllegalArgumentException("Group iterator not in range"); 
/* 228 */     if (this.gJ + this.gK >= this.a.size()) {
/* 229 */       throw new IllegalArgumentException("baseIndex + baseLength >= knotVector.size");
/*     */     }
/* 231 */     if (a.length < this.a.size()) {
/* 232 */       a = new double[2 * this.a.size()][];
/*     */     }
/* 234 */     this.a.j(0, 0);
/*     */     
/* 236 */     boolean bool = false;
/*     */     
/* 238 */     if (this.gJ != 0 && this.by) {
/* 239 */       for (byte b = 0; b < this.a.size(); b++) {
/* 240 */         if (!this.a.hasNext())
/* 241 */           throw new IllegalArgumentException("Group iterator ended early"); 
/* 242 */         a[b] = this.a.a(this.a.next()).b();
/*     */       } 
/*     */       
/* 245 */       bool = a(paraml, this.a.a(0), this.a.a(this.gJ), bool);
/*     */     } 
/*     */     
/* 248 */     this.a.j(0, 0);
/*     */     
/* 250 */     int i = 0;
/* 251 */     int j = 0;
/*     */     
/*     */     while (true) {
/* 254 */       int m = this.a.aJ();
/* 255 */       int n = this.a.aK();
/*     */       
/* 257 */       int i1 = 0;
/* 258 */       int i2 = 0;
/* 259 */       byte b1 = 0;
/*     */       
/* 261 */       byte b2 = 0;
/* 262 */       for (; b2 < this.a.size(); b2++) {
/* 263 */         if (b1 == this.gK) {
/* 264 */           i1 = this.a.aJ();
/* 265 */           i2 = this.a.aK();
/*     */         } 
/*     */         
/* 268 */         if (!this.a.hasNext())
/* 269 */           break;  a[b2] = this.a.a(this.a.next()).b();
/* 270 */         b1++;
/*     */       } 
/*     */       
/* 273 */       if (b2 < this.a.size()) {
/*     */         break;
/*     */       }
/*     */       
/* 277 */       this.a.j(i1, i2);
/* 278 */       i = m;
/* 279 */       j = n;
/*     */ 
/*     */       
/* 282 */       bool = a(paraml, this.a.a(this.gJ), this.a.a(this.gJ + this.gK), bool);
/*     */     } 
/*     */     
/* 285 */     if (this.gJ + this.gK < this.a.size() - 1 && this.bz) {
/* 286 */       this.a.j(i, j);
/*     */       
/* 288 */       for (byte b = 0; b < this.a.size(); b++) {
/* 289 */         if (!this.a.hasNext()) {
/* 290 */           System.out.println("not enough points to interpolate last");
/*     */           return;
/*     */         } 
/* 293 */         a[b] = this.a.a(this.a.next()).b();
/*     */       } 
/*     */       
/* 296 */       a(paraml, this.a.a(this.gJ + this.gK), this.a.a(this.a.size() - 1), bool);
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean a(l paraml, double paramDouble1, double paramDouble2, boolean paramBoolean) {
/* 301 */     if (paramDouble2 < paramDouble1) {
/* 302 */       double d = paramDouble1;
/* 303 */       paramDouble1 = paramDouble2;
/* 304 */       paramDouble2 = d;
/*     */     } 
/*     */     
/* 307 */     if (!paramBoolean) {
/* 308 */       paramBoolean = true;
/* 309 */       double[] arrayOfDouble = new double[paraml.aN() + 1];
/* 310 */       arrayOfDouble[paraml.aN()] = paramDouble1;
/* 311 */       c(arrayOfDouble);
/*     */       
/* 313 */       if (this.bx) {
/* 314 */         paraml.d(arrayOfDouble);
/*     */       } else {
/* 316 */         paraml.e(arrayOfDouble);
/*     */       } 
/*     */     } 
/* 319 */     c.a(this, paramDouble1, paramDouble2, paraml);
/*     */     
/* 321 */     return paramBoolean;
/*     */   }
/*     */   
/*     */   public void go() {
/* 325 */     if (a.length > 0)
/* 326 */       a = new double[0][]; 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\a\a\k.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */