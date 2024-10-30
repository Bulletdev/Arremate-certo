/*     */ package com.a.a;
/*     */ 
/*     */ import com.a.b.a;
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
/*     */ public class l
/*     */ {
/*  45 */   public static final Object as = new Object();
/*  46 */   public static final Object at = new Object();
/*     */   
/*  48 */   private double[][] b = new double[2][0];
/*  49 */   private Object[] p = new Object[this.b.length];
/*  50 */   private int size = 0;
/*     */   
/*  52 */   private double W = 1.0D;
/*     */ 
/*     */ 
/*     */   
/*     */   private final int gL;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public l(int paramInt) {
/*  62 */     if (paramInt <= 0) {
/*  63 */       throw new IllegalArgumentException("dimension > 0 required");
/*     */     }
/*  65 */     this.gL = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int aN() {
/*  75 */     return this.gL;
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
/*     */   public double S() {
/*  87 */     return this.W;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void w(double paramDouble) {
/*  98 */     if (paramDouble <= 0.0D) {
/*  99 */       throw new IllegalArgumentException("flatness > 0 required");
/*     */     }
/* 101 */     this.W = paramDouble;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double[] a(int paramInt) {
/* 110 */     return this.b[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(int paramInt, double[] paramArrayOfdouble) {
/* 121 */     if (paramArrayOfdouble == null) {
/* 122 */       throw new IllegalArgumentException("Point cannot be null.");
/*     */     }
/* 124 */     if (paramArrayOfdouble.length < this.gL) {
/* 125 */       throw new IllegalArgumentException("p.length >= dimension required");
/*     */     }
/* 127 */     if (this.b[paramInt] == null) {
/* 128 */       throw new ArrayIndexOutOfBoundsException(paramInt);
/*     */     }
/* 130 */     this.b[paramInt] = paramArrayOfdouble;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object g(int paramInt) {
/* 140 */     if (this.p[paramInt] == null) {
/* 141 */       throw new ArrayIndexOutOfBoundsException(paramInt);
/*     */     }
/* 143 */     return this.p[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void d(int paramInt, Object paramObject) {
/* 154 */     if (paramObject != as && paramObject != at) {
/* 155 */       throw new IllegalArgumentException("unknown type");
/*     */     }
/* 157 */     if (this.p[paramInt] == null) {
/* 158 */       throw new ArrayIndexOutOfBoundsException(paramInt);
/*     */     }
/* 160 */     if (paramInt == 0 && paramObject != as) {
/* 161 */       throw new IllegalArgumentException("type[0] must always be MOVE_TO");
/*     */     }
/* 163 */     this.p[paramInt] = paramObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int aO() {
/* 172 */     return this.size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void aP(int paramInt) {
/* 183 */     if (paramInt != 0 && this.b[paramInt - 1] == null)
/* 184 */       throw new ArrayIndexOutOfBoundsException(paramInt); 
/* 185 */     this.size = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCapacity() {
/* 192 */     return this.b.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ensureCapacity(int paramInt) {
/* 200 */     if (this.b.length < paramInt) {
/* 201 */       int i = 2 * this.b.length;
/*     */       
/* 203 */       if (i < paramInt) {
/* 204 */         i = paramInt;
/*     */       }
/* 206 */       double[][] arrayOfDouble = new double[i][];
/* 207 */       for (byte b1 = 0; b1 < this.size; b1++) {
/* 208 */         arrayOfDouble[b1] = this.b[b1];
/*     */       }
/* 210 */       Object[] arrayOfObject = new Object[i];
/* 211 */       for (byte b2 = 0; b2 < this.size; b2++) {
/* 212 */         arrayOfObject[b2] = this.p[b2];
/*     */       }
/* 214 */       this.b = arrayOfDouble;
/* 215 */       this.p = arrayOfObject;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void gr() {
/* 224 */     if (this.size < this.b.length) {
/* 225 */       double[][] arrayOfDouble = new double[this.size][];
/* 226 */       for (byte b1 = 0; b1 < this.size; b1++) {
/* 227 */         arrayOfDouble[b1] = this.b[b1];
/*     */       }
/* 229 */       Object[] arrayOfObject = new Object[this.size];
/* 230 */       for (byte b2 = 0; b2 < this.size; b2++) {
/* 231 */         arrayOfObject[b2] = this.p[b2];
/*     */       }
/* 233 */       this.b = arrayOfDouble;
/* 234 */       this.p = arrayOfObject;
/*     */     } 
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
/*     */   public void d(double[] paramArrayOfdouble) {
/* 247 */     a(paramArrayOfdouble, at);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void e(double[] paramArrayOfdouble) {
/* 258 */     a(paramArrayOfdouble, as);
/*     */   }
/*     */   
/*     */   private void a(double[] paramArrayOfdouble, Object paramObject) {
/* 262 */     if (paramArrayOfdouble == null) {
/* 263 */       throw new IllegalArgumentException("Point cannot be null.");
/*     */     }
/* 265 */     if (paramArrayOfdouble.length < this.gL) {
/* 266 */       throw new IllegalArgumentException("p.length >= dimension required");
/*     */     }
/* 268 */     if (this.size == 0) paramObject = as;
/*     */     
/* 270 */     ensureCapacity(this.size + 1);
/* 271 */     this.b[this.size] = paramArrayOfdouble;
/* 272 */     this.p[this.size] = paramObject;
/* 273 */     this.size++;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double e(double[] paramArrayOfdouble) {
/* 284 */     if (paramArrayOfdouble == null) {
/* 285 */       throw new IllegalArgumentException("Point cannot be null.");
/*     */     }
/* 287 */     if (paramArrayOfdouble.length < this.gL) {
/* 288 */       throw new IllegalArgumentException("p.length >= dimension required");
/*     */     }
/* 290 */     int i = aO();
/*     */     
/* 292 */     if (i == 0) {
/* 293 */       return Double.MAX_VALUE;
/*     */     }
/* 295 */     double d = Double.MAX_VALUE;
/*     */     
/* 297 */     double[] arrayOfDouble1 = a(0);
/*     */     
/* 299 */     double[] arrayOfDouble2 = new double[this.gL + 1];
/*     */     
/* 301 */     for (byte b = 1; b < i; b++) {
/* 302 */       double[] arrayOfDouble = a(b);
/*     */       
/* 304 */       if (g(b) == at) {
/* 305 */         double d1 = a.b(arrayOfDouble, arrayOfDouble1, paramArrayOfdouble, arrayOfDouble2, this.gL);
/*     */         
/* 307 */         if (d1 < d) {
/* 308 */           d = d1;
/*     */         }
/*     */       } 
/*     */     } 
/* 312 */     return d;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\a\a\l.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */