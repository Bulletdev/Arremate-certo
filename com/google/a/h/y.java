/*     */ package com.google.a.h;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import sun.misc.Unsafe;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class y
/*     */   extends F
/*     */   implements w, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 7249069246863182397L;
/*     */   
/*     */   final long a(long paramLong1, long paramLong2) {
/*  47 */     return paramLong1 + paramLong2;
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
/*     */   public void add(long paramLong) {
/*  66 */     boolean bool = true; Unsafe unsafe1; long l1, l2; int[] arrayOfInt; Unsafe unsafe2; int i;
/*  67 */     if (((unsafe1 = this.a) != null || !a(l1 = this.at, l1 + paramLong)) && ((arrayOfInt = a.get()) == null || unsafe1 == null || (i = unsafe1.length) < 1 || (unsafe2 = unsafe1[i - 1 & arrayOfInt[0]]) == null || 
/*     */ 
/*     */ 
/*     */       
/*  71 */       !(bool = unsafe2.b(l2 = ((F.a)unsafe2).value, l2 + paramLong)))) a(paramLong, arrayOfInt, bool);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void increment() {
/*  78 */     add(1L);
/*     */   }
/*     */ 
/*     */   
/*     */   public void decrement() {
/*  83 */     add(-1L);
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
/*     */   public long X() {
/*  95 */     long l = this.at;
/*  96 */     Unsafe unsafe = this.a;
/*  97 */     if (unsafe != null) {
/*  98 */       int i = unsafe.length;
/*  99 */       for (byte b = 0; b < i; b++) {
/* 100 */         Unsafe unsafe1 = unsafe[b];
/* 101 */         if (unsafe1 != null) l += ((F.a)unsafe1).value; 
/*     */       } 
/*     */     } 
/* 104 */     return l;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/* 114 */     M(0L);
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
/*     */   public long Y() {
/* 126 */     long l = this.at;
/* 127 */     Unsafe unsafe = this.a;
/* 128 */     this.at = 0L;
/* 129 */     if (unsafe != null) {
/* 130 */       int i = unsafe.length;
/* 131 */       for (byte b = 0; b < i; b++) {
/* 132 */         Unsafe unsafe1 = unsafe[b];
/* 133 */         if (unsafe1 != null) {
/* 134 */           l += ((F.a)unsafe1).value;
/* 135 */           ((F.a)unsafe1).value = 0L;
/*     */         } 
/*     */       } 
/*     */     } 
/* 139 */     return l;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 149 */     return Long.toString(X());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long longValue() {
/* 159 */     return X();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int intValue() {
/* 165 */     return (int)X();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float floatValue() {
/* 171 */     return (float)X();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double doubleValue() {
/* 177 */     return X();
/*     */   }
/*     */   
/*     */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 181 */     paramObjectOutputStream.defaultWriteObject();
/* 182 */     paramObjectOutputStream.writeLong(X());
/*     */   }
/*     */   
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 186 */     paramObjectInputStream.defaultReadObject();
/* 187 */     this.dR = 0;
/* 188 */     this.a = null;
/* 189 */     this.at = paramObjectInputStream.readLong();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\h\y.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */