/*     */ package com.google.a.k;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.x;
/*     */ import com.google.a.b.y;
/*     */ import java.io.Serializable;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
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
/*     */ @a
/*     */ @c
/*     */ public final class i
/*     */   implements Serializable
/*     */ {
/*     */   private final l a;
/*     */   private final l b;
/*     */   private final double J;
/*     */   private static final int BYTES = 88;
/*     */   private static final long serialVersionUID = 0L;
/*     */   
/*     */   i(l paraml1, l paraml2, double paramDouble) {
/*  61 */     this.a = paraml1;
/*  62 */     this.b = paraml2;
/*  63 */     this.J = paramDouble;
/*     */   }
/*     */ 
/*     */   
/*     */   public long count() {
/*  68 */     return this.a.count();
/*     */   }
/*     */ 
/*     */   
/*     */   public l a() {
/*  73 */     return this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public l b() {
/*  78 */     return this.b;
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
/*     */   public double x() {
/*  96 */     D.ab((count() != 0L));
/*  97 */     return this.J / count();
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
/*     */   public double y() {
/* 114 */     D.ab((count() > 1L));
/* 115 */     return this.J / (count() - 1L);
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
/*     */   public double z() {
/* 135 */     D.ab((count() > 1L));
/* 136 */     if (Double.isNaN(this.J)) {
/* 137 */       return Double.NaN;
/*     */     }
/* 139 */     double d1 = a().J();
/* 140 */     double d2 = b().J();
/* 141 */     D.ab((d1 > 0.0D));
/* 142 */     D.ab((d2 > 0.0D));
/*     */ 
/*     */ 
/*     */     
/* 146 */     double d3 = i(d1 * d2);
/* 147 */     return j(this.J / Math.sqrt(d3));
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
/*     */   public f d() {
/* 182 */     D.ab((count() > 1L));
/* 183 */     if (Double.isNaN(this.J)) {
/* 184 */       return f.a();
/*     */     }
/* 186 */     double d = this.a.J();
/* 187 */     if (d > 0.0D) {
/* 188 */       if (this.b.J() > 0.0D) {
/* 189 */         return f.a(this.a.B(), this.b.B())
/* 190 */           .c(this.J / d);
/*     */       }
/* 192 */       return f.b(this.b.B());
/*     */     } 
/*     */     
/* 195 */     D.ab((this.b.J() > 0.0D));
/* 196 */     return f.a(this.a.B());
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
/*     */   public boolean equals(Object paramObject) {
/* 217 */     if (paramObject == null) {
/* 218 */       return false;
/*     */     }
/* 220 */     if (getClass() != paramObject.getClass()) {
/* 221 */       return false;
/*     */     }
/* 223 */     i i1 = (i)paramObject;
/* 224 */     return (this.a.equals(i1.a) && this.b
/* 225 */       .equals(i1.b) && 
/* 226 */       Double.doubleToLongBits(this.J) == Double.doubleToLongBits(i1.J));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 237 */     return y.a(new Object[] { this.a, this.b, Double.valueOf(this.J) });
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 242 */     if (count() > 0L) {
/* 243 */       return x.a(this)
/* 244 */         .a("xStats", this.a)
/* 245 */         .a("yStats", this.b)
/* 246 */         .a("populationCovariance", x())
/* 247 */         .toString();
/*     */     }
/* 249 */     return x.a(this)
/* 250 */       .a("xStats", this.a)
/* 251 */       .a("yStats", this.b)
/* 252 */       .toString();
/*     */   }
/*     */ 
/*     */   
/*     */   double A() {
/* 257 */     return this.J;
/*     */   }
/*     */   
/*     */   private static double i(double paramDouble) {
/* 261 */     if (paramDouble > 0.0D) {
/* 262 */       return paramDouble;
/*     */     }
/* 264 */     return Double.MIN_VALUE;
/*     */   }
/*     */ 
/*     */   
/*     */   private static double j(double paramDouble) {
/* 269 */     if (paramDouble >= 1.0D) {
/* 270 */       return 1.0D;
/*     */     }
/* 272 */     if (paramDouble <= -1.0D) {
/* 273 */       return -1.0D;
/*     */     }
/* 275 */     return paramDouble;
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
/*     */   public byte[] toByteArray() {
/* 290 */     ByteBuffer byteBuffer = ByteBuffer.allocate(88).order(ByteOrder.LITTLE_ENDIAN);
/* 291 */     this.a.e(byteBuffer);
/* 292 */     this.b.e(byteBuffer);
/* 293 */     byteBuffer.putDouble(this.J);
/* 294 */     return byteBuffer.array();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static i a(byte[] paramArrayOfbyte) {
/* 305 */     D.checkNotNull(paramArrayOfbyte);
/* 306 */     D.a((paramArrayOfbyte.length == 88), "Expected PairedStats.BYTES = %s, got %s", 88, paramArrayOfbyte.length);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 311 */     ByteBuffer byteBuffer = ByteBuffer.wrap(paramArrayOfbyte).order(ByteOrder.LITTLE_ENDIAN);
/* 312 */     l l1 = l.a(byteBuffer);
/* 313 */     l l2 = l.a(byteBuffer);
/* 314 */     double d = byteBuffer.getDouble();
/* 315 */     return new i(l1, l2, d);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\k\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */