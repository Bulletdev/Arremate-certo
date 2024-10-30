/*     */ package com.google.a.o.a;
/*     */ 
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.m.j;
/*     */ import com.google.b.a.a;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.concurrent.atomic.AtomicLongArray;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @c
/*     */ public class n
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 0L;
/*     */   private transient AtomicLongArray b;
/*     */   
/*     */   public n(int paramInt) {
/*  60 */     this.b = new AtomicLongArray(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public n(double[] paramArrayOfdouble) {
/*  71 */     int i = paramArrayOfdouble.length;
/*  72 */     long[] arrayOfLong = new long[i];
/*  73 */     for (byte b = 0; b < i; b++) {
/*  74 */       arrayOfLong[b] = Double.doubleToRawLongBits(paramArrayOfdouble[b]);
/*     */     }
/*  76 */     this.b = new AtomicLongArray(arrayOfLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int length() {
/*  85 */     return this.b.length();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final double a(int paramInt) {
/*  95 */     return Double.longBitsToDouble(this.b.get(paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(int paramInt, double paramDouble) {
/* 105 */     long l = Double.doubleToRawLongBits(paramDouble);
/* 106 */     this.b.set(paramInt, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b(int paramInt, double paramDouble) {
/* 116 */     long l = Double.doubleToRawLongBits(paramDouble);
/* 117 */     this.b.lazySet(paramInt, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final double a(int paramInt, double paramDouble) {
/* 128 */     long l = Double.doubleToRawLongBits(paramDouble);
/* 129 */     return Double.longBitsToDouble(this.b.getAndSet(paramInt, l));
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
/*     */   public final boolean a(int paramInt, double paramDouble1, double paramDouble2) {
/* 143 */     return this.b.compareAndSet(paramInt, Double.doubleToRawLongBits(paramDouble1), Double.doubleToRawLongBits(paramDouble2));
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
/*     */   public final boolean b(int paramInt, double paramDouble1, double paramDouble2) {
/* 161 */     return this.b.weakCompareAndSet(paramInt, Double.doubleToRawLongBits(paramDouble1), Double.doubleToRawLongBits(paramDouble2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   public final double b(int paramInt, double paramDouble) {
/*     */     while (true) {
/* 174 */       long l1 = this.b.get(paramInt);
/* 175 */       double d1 = Double.longBitsToDouble(l1);
/* 176 */       double d2 = d1 + paramDouble;
/* 177 */       long l2 = Double.doubleToRawLongBits(d2);
/* 178 */       if (this.b.compareAndSet(paramInt, l1, l2)) {
/* 179 */         return d1;
/*     */       }
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
/*     */   @a
/*     */   public double c(int paramInt, double paramDouble) {
/*     */     while (true) {
/* 194 */       long l1 = this.b.get(paramInt);
/* 195 */       double d1 = Double.longBitsToDouble(l1);
/* 196 */       double d2 = d1 + paramDouble;
/* 197 */       long l2 = Double.doubleToRawLongBits(d2);
/* 198 */       if (this.b.compareAndSet(paramInt, l1, l2)) {
/* 199 */         return d2;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 211 */     int i = length() - 1;
/* 212 */     if (i == -1) {
/* 213 */       return "[]";
/*     */     }
/*     */ 
/*     */     
/* 217 */     StringBuilder stringBuilder = new StringBuilder(19 * (i + 1));
/* 218 */     stringBuilder.append('[');
/* 219 */     for (int j = 0;; j++) {
/* 220 */       stringBuilder.append(Double.longBitsToDouble(this.b.get(j)));
/* 221 */       if (j == i) {
/* 222 */         return stringBuilder.append(']').toString();
/*     */       }
/* 224 */       stringBuilder.append(',').append(' ');
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 235 */     paramObjectOutputStream.defaultWriteObject();
/*     */ 
/*     */     
/* 238 */     int i = length();
/* 239 */     paramObjectOutputStream.writeInt(i);
/*     */ 
/*     */     
/* 242 */     for (byte b = 0; b < i; b++) {
/* 243 */       paramObjectOutputStream.writeDouble(a(b));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 250 */     paramObjectInputStream.defaultReadObject();
/*     */     
/* 252 */     int i = paramObjectInputStream.readInt();
/* 253 */     j.b b = j.a();
/* 254 */     for (byte b1 = 0; b1 < i; b1++) {
/* 255 */       b.a(Double.doubleToRawLongBits(paramObjectInputStream.readDouble()));
/*     */     }
/* 257 */     this.b = new AtomicLongArray(b.d().a());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\n.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */