/*     */ package com.a.a;
/*     */ 
/*     */ import com.a.b.a;
/*     */ import com.a.d.a.a.a.a.a;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.Shape;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.geom.PathIterator;
/*     */ import java.awt.geom.Point2D;
/*     */ import java.awt.geom.Rectangle2D;
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
/*     */ public class r
/*     */   extends l
/*     */   implements Shape
/*     */ {
/*  58 */   private int gN = 0;
/*  59 */   private int gO = 0;
/*  60 */   private int gP = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public r() {
/*  66 */     super(2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public r(int paramInt) {
/*  75 */     super(paramInt);
/*     */     
/*  77 */     if (paramInt < 2) {
/*  78 */       throw new IllegalArgumentException("dimension >= 2 required");
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
/*     */   
/*     */   public void f(int[] paramArrayOfint) {
/*  92 */     int i = paramArrayOfint[0];
/*  93 */     int j = paramArrayOfint[1];
/*     */     
/*  95 */     int k = aN();
/*     */     
/*  97 */     if (i < 0 || j < 0 || i >= k || j >= k) {
/*  98 */       throw new IllegalArgumentException("basis vectors must be >= 0 and < dimension");
/*     */     }
/* 100 */     this.gO = i;
/* 101 */     this.gP = j;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] c() {
/* 110 */     return new int[] { this.gO, this.gP };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double c(double paramDouble1, double paramDouble2) {
/* 117 */     int i = aO();
/*     */     
/* 119 */     if (i == 0) {
/* 120 */       return Double.MAX_VALUE;
/*     */     }
/* 122 */     double[] arrayOfDouble = a(0);
/*     */     
/* 124 */     double d1 = arrayOfDouble[this.gO];
/* 125 */     double d2 = arrayOfDouble[this.gP];
/* 126 */     double d3 = Double.MAX_VALUE;
/*     */     
/* 128 */     for (byte b = 1; b < i; b++) {
/* 129 */       arrayOfDouble = a(b);
/* 130 */       double d4 = arrayOfDouble[this.gO];
/* 131 */       double d5 = arrayOfDouble[this.gP];
/*     */       
/* 133 */       if (g(b) == l.at) {
/* 134 */         double d = a.b(d4, d5, d1, d2, paramDouble1, paramDouble2, null);
/* 135 */         if (d < d3) {
/* 136 */           d3 = d;
/*     */         }
/*     */       } 
/* 139 */       d1 = d4;
/* 140 */       d2 = d5;
/*     */     } 
/*     */     
/* 143 */     return d3;
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
/*     */   public int getWindingRule() {
/* 157 */     return this.gN;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void aQ(int paramInt) {
/* 165 */     if (paramInt != 0 && paramInt != 1) {
/* 166 */       throw new IllegalArgumentException("winding rule must be WIND_EVEN_ODD or WIND_NON_ZERO");
/*     */     }
/* 168 */     this.gN = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PathIterator getPathIterator(AffineTransform paramAffineTransform) {
/* 175 */     return new s(this, paramAffineTransform);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PathIterator getPathIterator(AffineTransform paramAffineTransform, double paramDouble) {
/* 183 */     return new s(this, paramAffineTransform);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle getBounds() {
/* 194 */     Rectangle2D rectangle2D = getBounds2D();
/* 195 */     if (rectangle2D == null) return null; 
/* 196 */     return rectangle2D.getBounds();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle2D getBounds2D() {
/* 205 */     int i = aO();
/*     */     
/* 207 */     double d1 = Double.MAX_VALUE;
/* 208 */     double d2 = Double.MAX_VALUE;
/* 209 */     double d3 = -1.7976931348623157E308D;
/* 210 */     double d4 = -1.7976931348623157E308D;
/*     */     
/* 212 */     boolean bool = false;
/*     */     
/* 214 */     for (byte b = 0; b < i; b++) {
/* 215 */       double[] arrayOfDouble = a(b);
/*     */       
/* 217 */       boolean bool1 = false;
/*     */       
/* 219 */       if (g(b) == l.as) {
/* 220 */         if (b < i - 1 && g(b + 1) == l.at) {
/* 221 */           bool1 = true;
/*     */         }
/*     */       } else {
/* 224 */         bool1 = true;
/*     */       } 
/*     */       
/* 227 */       if (bool1) {
/* 228 */         bool = true;
/* 229 */         if (arrayOfDouble[this.gO] < d1) d1 = arrayOfDouble[this.gO]; 
/* 230 */         if (arrayOfDouble[this.gP] < d2) d2 = arrayOfDouble[this.gP]; 
/* 231 */         if (arrayOfDouble[this.gO] > d3) d3 = arrayOfDouble[this.gO]; 
/* 232 */         if (arrayOfDouble[this.gP] > d4) d4 = arrayOfDouble[this.gP];
/*     */       
/*     */       } 
/*     */     } 
/* 236 */     if (!bool) {
/* 237 */       return null;
/*     */     }
/* 239 */     return new Rectangle2D.Double(d1, d2, d3 - d1, d4 - d2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(double paramDouble1, double paramDouble2) {
/* 249 */     int i = a.a(getPathIterator((AffineTransform)null), paramDouble1, paramDouble2);
/*     */     
/* 251 */     if (this.gN == 1) {
/* 252 */       return (i != 0);
/*     */     }
/* 254 */     return ((i & 0x1) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(Point2D paramPoint2D) {
/* 263 */     return contains(paramPoint2D.getX(), paramPoint2D.getY());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
/* 274 */     double d1 = paramDouble1 + paramDouble3;
/* 275 */     double d2 = paramDouble2 + paramDouble4;
/*     */     
/* 277 */     if (!contains(paramDouble1, paramDouble2)) return false; 
/* 278 */     if (!contains(paramDouble1, d2)) return false; 
/* 279 */     if (!contains(d1, paramDouble2)) return false; 
/* 280 */     if (!contains(d1, d2)) return false;
/*     */     
/* 282 */     int i = aO();
/*     */     
/* 284 */     if (i == 0) return false;
/*     */     
/* 286 */     double[] arrayOfDouble = a(0);
/*     */     
/* 288 */     double d3 = arrayOfDouble[this.gO];
/* 289 */     double d4 = arrayOfDouble[this.gP];
/*     */     
/* 291 */     for (byte b = 1; b < i; b++) {
/* 292 */       arrayOfDouble = a(b);
/* 293 */       double d5 = arrayOfDouble[this.gO];
/* 294 */       double d6 = arrayOfDouble[this.gP];
/*     */       
/* 296 */       if (g(b) == l.at) {
/* 297 */         if (a.c(d5, d6, d3, d4, paramDouble1, paramDouble2, d1, paramDouble2, null) == a.av)
/* 298 */           return false; 
/* 299 */         if (a.c(d5, d6, d3, d4, paramDouble1, paramDouble2, paramDouble1, d2, null) == a.av)
/* 300 */           return false; 
/* 301 */         if (a.c(d5, d6, d3, d4, paramDouble1, d2, d1, d2, null) == a.av)
/* 302 */           return false; 
/* 303 */         if (a.c(d5, d6, d3, d4, d1, paramDouble2, d1, d2, null) == a.av) {
/* 304 */           return false;
/*     */         }
/*     */       } 
/* 307 */       d3 = d5;
/* 308 */       d4 = d6;
/*     */     } 
/*     */     
/* 311 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(Rectangle2D paramRectangle2D) {
/* 320 */     return contains(paramRectangle2D.getX(), paramRectangle2D.getY(), paramRectangle2D.getWidth(), paramRectangle2D.getHeight());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean intersects(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
/* 330 */     double d1 = paramDouble1 + paramDouble3;
/* 331 */     double d2 = paramDouble2 + paramDouble4;
/*     */     
/* 333 */     if (contains(paramDouble1, paramDouble2)) return true; 
/* 334 */     if (contains(paramDouble1, d2)) return true; 
/* 335 */     if (contains(d1, paramDouble2)) return true; 
/* 336 */     if (contains(d1, d2)) return true;
/*     */     
/* 338 */     int i = aO();
/*     */     
/* 340 */     if (i == 0) return false;
/*     */     
/* 342 */     double[] arrayOfDouble = a(0);
/*     */     
/* 344 */     double d3 = arrayOfDouble[this.gO];
/* 345 */     double d4 = arrayOfDouble[this.gP];
/*     */     
/* 347 */     for (byte b = 1; b < i; b++) {
/* 348 */       arrayOfDouble = a(b);
/* 349 */       double d5 = arrayOfDouble[this.gO];
/* 350 */       double d6 = arrayOfDouble[this.gP];
/*     */       
/* 352 */       if (g(b) == l.at) {
/* 353 */         if (a.c(d5, d6, d3, d4, paramDouble1, paramDouble2, d1, paramDouble2, null) == a.av)
/* 354 */           return true; 
/* 355 */         if (a.c(d5, d6, d3, d4, paramDouble1, paramDouble2, paramDouble1, d2, null) == a.av)
/* 356 */           return true; 
/* 357 */         if (a.c(d5, d6, d3, d4, paramDouble1, d2, d1, d2, null) == a.av)
/* 358 */           return true; 
/* 359 */         if (a.c(d5, d6, d3, d4, d1, paramDouble2, d1, d2, null) == a.av) {
/* 360 */           return true;
/*     */         }
/* 362 */         if (d5 >= paramDouble1 && d6 >= paramDouble2 && d5 <= d1 && d6 <= d2) return true; 
/* 363 */         if (d3 >= paramDouble1 && d4 >= paramDouble2 && d3 <= d1 && d4 <= d2) return true;
/*     */       
/*     */       } 
/* 366 */       d3 = d5;
/* 367 */       d4 = d6;
/*     */     } 
/*     */     
/* 370 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean intersects(Rectangle2D paramRectangle2D) {
/* 379 */     return intersects(paramRectangle2D.getX(), paramRectangle2D.getY(), paramRectangle2D.getWidth(), paramRectangle2D.getHeight());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\a\a\r.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */