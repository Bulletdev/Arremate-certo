/*     */ package com.google.a.o.a;
/*     */ 
/*     */ import com.google.a.a.c;
/*     */ import com.google.b.a.a;
/*     */ import com.google.c.a.f;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.concurrent.atomic.AtomicLongFieldUpdater;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ @f(a = f.a.FULL)
/*     */ public class m
/*     */   extends Number
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 0L;
/*     */   private volatile transient long value;
/*  62 */   private static final AtomicLongFieldUpdater<m> a = AtomicLongFieldUpdater.newUpdater(m.class, "value");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public m(double paramDouble) {
/*  70 */     this.value = Double.doubleToRawLongBits(paramDouble);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public m() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final double K() {
/*  84 */     return Double.longBitsToDouble(this.value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void set(double paramDouble) {
/*  93 */     long l = Double.doubleToRawLongBits(paramDouble);
/*  94 */     this.value = l;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void u(double paramDouble) {
/* 103 */     long l = Double.doubleToRawLongBits(paramDouble);
/* 104 */     a.lazySet(this, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final double k(double paramDouble) {
/* 114 */     long l = Double.doubleToRawLongBits(paramDouble);
/* 115 */     return Double.longBitsToDouble(a.getAndSet(this, l));
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
/*     */   public final boolean c(double paramDouble1, double paramDouble2) {
/* 128 */     return a.compareAndSet(this, Double.doubleToRawLongBits(paramDouble1), Double.doubleToRawLongBits(paramDouble2));
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
/*     */   public final boolean d(double paramDouble1, double paramDouble2) {
/* 145 */     return a.weakCompareAndSet(this, 
/* 146 */         Double.doubleToRawLongBits(paramDouble1), Double.doubleToRawLongBits(paramDouble2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   public final double getAndAdd(double paramDouble) {
/*     */     while (true) {
/* 158 */       long l1 = this.value;
/* 159 */       double d1 = Double.longBitsToDouble(l1);
/* 160 */       double d2 = d1 + paramDouble;
/* 161 */       long l2 = Double.doubleToRawLongBits(d2);
/* 162 */       if (a.compareAndSet(this, l1, l2)) {
/* 163 */         return d1;
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
/*     */   @a
/*     */   public final double addAndGet(double paramDouble) {
/*     */     while (true) {
/* 177 */       long l1 = this.value;
/* 178 */       double d1 = Double.longBitsToDouble(l1);
/* 179 */       double d2 = d1 + paramDouble;
/* 180 */       long l2 = Double.doubleToRawLongBits(d2);
/* 181 */       if (a.compareAndSet(this, l1, l2)) {
/* 182 */         return d2;
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
/* 194 */     return Double.toString(K());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int intValue() {
/* 203 */     return (int)K();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long longValue() {
/* 212 */     return (long)K();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float floatValue() {
/* 221 */     return (float)K();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double doubleValue() {
/* 227 */     return K();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 236 */     paramObjectOutputStream.defaultWriteObject();
/*     */     
/* 238 */     paramObjectOutputStream.writeDouble(K());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 244 */     paramObjectInputStream.defaultReadObject();
/*     */     
/* 246 */     set(paramObjectInputStream.readDouble());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\m.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */