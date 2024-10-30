/*     */ package com.google.a.c;
/*     */ 
/*     */ import com.google.a.a.b;
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
/*     */ @b(cl = true)
/*     */ final class n
/*     */   extends t
/*     */   implements l, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 7249069246863182397L;
/*     */   
/*     */   final long a(long paramLong1, long paramLong2) {
/*  49 */     return paramLong1 + paramLong2;
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
/*  68 */     boolean bool = true; Unsafe unsafe1; long l1, l2; int[] arrayOfInt; Unsafe unsafe2; int i;
/*  69 */     if (((unsafe1 = this.a) != null || !a(l1 = this.at, l1 + paramLong)) && ((arrayOfInt = a.get()) == null || unsafe1 == null || (i = unsafe1.length) < 1 || (unsafe2 = unsafe1[i - 1 & arrayOfInt[0]]) == null || 
/*     */ 
/*     */ 
/*     */       
/*  73 */       !(bool = unsafe2.b(l2 = ((t.a)unsafe2).value, l2 + paramLong)))) a(paramLong, arrayOfInt, bool);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void increment() {
/*  80 */     add(1L);
/*     */   }
/*     */ 
/*     */   
/*     */   public void decrement() {
/*  85 */     add(-1L);
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
/*  97 */     long l1 = this.at;
/*  98 */     Unsafe unsafe = this.a;
/*  99 */     if (unsafe != null) {
/* 100 */       int i = unsafe.length;
/* 101 */       for (byte b = 0; b < i; b++) {
/* 102 */         Unsafe unsafe1 = unsafe[b];
/* 103 */         if (unsafe1 != null) l1 += ((t.a)unsafe1).value; 
/*     */       } 
/*     */     } 
/* 106 */     return l1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/* 116 */     M(0L);
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
/* 128 */     long l1 = this.at;
/* 129 */     Unsafe unsafe = this.a;
/* 130 */     this.at = 0L;
/* 131 */     if (unsafe != null) {
/* 132 */       int i = unsafe.length;
/* 133 */       for (byte b = 0; b < i; b++) {
/* 134 */         Unsafe unsafe1 = unsafe[b];
/* 135 */         if (unsafe1 != null) {
/* 136 */           l1 += ((t.a)unsafe1).value;
/* 137 */           ((t.a)unsafe1).value = 0L;
/*     */         } 
/*     */       } 
/*     */     } 
/* 141 */     return l1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 151 */     return Long.toString(X());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long longValue() {
/* 161 */     return X();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int intValue() {
/* 167 */     return (int)X();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float floatValue() {
/* 173 */     return (float)X();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double doubleValue() {
/* 179 */     return X();
/*     */   }
/*     */   
/*     */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 183 */     paramObjectOutputStream.defaultWriteObject();
/* 184 */     paramObjectOutputStream.writeLong(X());
/*     */   }
/*     */   
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 188 */     paramObjectInputStream.defaultReadObject();
/* 189 */     this.dR = 0;
/* 190 */     this.a = null;
/* 191 */     this.at = paramObjectInputStream.readLong();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\c\n.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */