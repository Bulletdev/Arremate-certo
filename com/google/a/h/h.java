/*     */ package com.google.a.h;
/*     */ 
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.k.g;
/*     */ import com.google.a.m.k;
/*     */ import com.google.a.m.m;
/*     */ import java.math.RoundingMode;
/*     */ import java.util.Arrays;
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
/*     */ enum h
/*     */   implements g.b
/*     */ {
/*  45 */   a
/*     */   {
/*     */     public <T> boolean a(T param1T, l<? super T> param1l, int param1Int, a param1a)
/*     */     {
/*  49 */       long l1 = param1a.ab();
/*  50 */       long l2 = q.b().<T>a(param1T, param1l).asLong();
/*  51 */       int i = (int)l2;
/*  52 */       int j = (int)(l2 >>> 32L);
/*     */       
/*  54 */       boolean bool = false;
/*  55 */       for (byte b = 1; b <= param1Int; b++) {
/*  56 */         int k = i + b * j;
/*     */         
/*  58 */         if (k < 0) {
/*  59 */           k ^= 0xFFFFFFFF;
/*     */         }
/*  61 */         bool |= param1a.d(k % l1);
/*     */       } 
/*  63 */       return bool;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public <T> boolean b(T param1T, l<? super T> param1l, int param1Int, a param1a) {
/*  69 */       long l1 = param1a.ab();
/*  70 */       long l2 = q.b().<T>a(param1T, param1l).asLong();
/*  71 */       int i = (int)l2;
/*  72 */       int j = (int)(l2 >>> 32L);
/*     */       
/*  74 */       for (byte b = 1; b <= param1Int; b++) {
/*  75 */         int k = i + b * j;
/*     */         
/*  77 */         if (k < 0) {
/*  78 */           k ^= 0xFFFFFFFF;
/*     */         }
/*  80 */         if (!param1a.e(k % l1)) {
/*  81 */           return false;
/*     */         }
/*     */       } 
/*  84 */       return true;
/*     */     }
/*     */   },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  93 */   b
/*     */   {
/*     */     public <T> boolean a(T param1T, l<? super T> param1l, int param1Int, a param1a)
/*     */     {
/*  97 */       long l1 = param1a.ab();
/*  98 */       byte[] arrayOfByte = q.b().<T>a(param1T, param1l).g();
/*  99 */       long l2 = a(arrayOfByte);
/* 100 */       long l3 = b(arrayOfByte);
/*     */       
/* 102 */       boolean bool = false;
/* 103 */       long l4 = l2;
/* 104 */       for (byte b = 0; b < param1Int; b++) {
/*     */         
/* 106 */         bool |= param1a.d((l4 & Long.MAX_VALUE) % l1);
/* 107 */         l4 += l3;
/*     */       } 
/* 109 */       return bool;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public <T> boolean b(T param1T, l<? super T> param1l, int param1Int, a param1a) {
/* 115 */       long l1 = param1a.ab();
/* 116 */       byte[] arrayOfByte = q.b().<T>a(param1T, param1l).g();
/* 117 */       long l2 = a(arrayOfByte);
/* 118 */       long l3 = b(arrayOfByte);
/*     */       
/* 120 */       long l4 = l2;
/* 121 */       for (byte b = 0; b < param1Int; b++) {
/*     */         
/* 123 */         if (!param1a.e((l4 & Long.MAX_VALUE) % l1)) {
/* 124 */           return false;
/*     */         }
/* 126 */         l4 += l3;
/*     */       } 
/* 128 */       return true;
/*     */     }
/*     */     
/*     */     private long a(byte[] param1ArrayOfbyte) {
/* 132 */       return m.a(param1ArrayOfbyte[7], param1ArrayOfbyte[6], param1ArrayOfbyte[5], param1ArrayOfbyte[4], param1ArrayOfbyte[3], param1ArrayOfbyte[2], param1ArrayOfbyte[1], param1ArrayOfbyte[0]);
/*     */     }
/*     */ 
/*     */     
/*     */     private long b(byte[] param1ArrayOfbyte) {
/* 137 */       return m.a(param1ArrayOfbyte[15], param1ArrayOfbyte[14], param1ArrayOfbyte[13], param1ArrayOfbyte[12], param1ArrayOfbyte[11], param1ArrayOfbyte[10], param1ArrayOfbyte[9], param1ArrayOfbyte[8]);
/*     */     }
/*     */   };
/*     */ 
/*     */ 
/*     */   
/*     */   static final class a
/*     */   {
/*     */     private static final int fw = 6;
/*     */ 
/*     */     
/*     */     final AtomicLongArray a;
/*     */     
/*     */     private final w a;
/*     */ 
/*     */     
/*     */     a(long param1Long) {
/* 154 */       D.a((param1Long > 0L), "data length is zero!");
/*     */ 
/*     */       
/* 157 */       this
/* 158 */         .a = (w)new AtomicLongArray(k.d(g.a(param1Long, 64L, RoundingMode.CEILING)));
/* 159 */       this.a = x.a();
/*     */     }
/*     */ 
/*     */     
/*     */     a(long[] param1ArrayOflong) {
/* 164 */       D.a((param1ArrayOflong.length > 0), "data length is zero!");
/* 165 */       this.a = (w)new AtomicLongArray(param1ArrayOflong);
/* 166 */       this.a = x.a();
/* 167 */       long l = 0L;
/* 168 */       for (long l1 : param1ArrayOflong) {
/* 169 */         l += Long.bitCount(l1);
/*     */       }
/* 171 */       this.a.add(l);
/*     */     }
/*     */     
/*     */     boolean d(long param1Long) {
/*     */       long l2, l3;
/* 176 */       if (e(param1Long)) {
/* 177 */         return false;
/*     */       }
/*     */       
/* 180 */       int i = (int)(param1Long >>> 6L);
/* 181 */       long l1 = 1L << (int)param1Long;
/*     */ 
/*     */ 
/*     */       
/*     */       do {
/* 186 */         l2 = this.a.get(i);
/* 187 */         l3 = l2 | l1;
/* 188 */         if (l2 == l3) {
/* 189 */           return false;
/*     */         }
/* 191 */       } while (!this.a.compareAndSet(i, l2, l3));
/*     */ 
/*     */       
/* 194 */       this.a.increment();
/* 195 */       return true;
/*     */     }
/*     */     
/*     */     boolean e(long param1Long) {
/* 199 */       return ((this.a.get((int)(param1Long >>> 6L)) & 1L << (int)param1Long) != 0L);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static long[] a(AtomicLongArray param1AtomicLongArray) {
/* 208 */       long[] arrayOfLong = new long[param1AtomicLongArray.length()];
/* 209 */       for (byte b = 0; b < arrayOfLong.length; b++) {
/* 210 */         arrayOfLong[b] = param1AtomicLongArray.get(b);
/*     */       }
/* 212 */       return arrayOfLong;
/*     */     }
/*     */ 
/*     */     
/*     */     long ab() {
/* 217 */       return this.a.length() * 64L;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     long ac() {
/* 229 */       return this.a.X();
/*     */     }
/*     */     
/*     */     a a() {
/* 233 */       return new a(a((AtomicLongArray)this.a));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void a(a param1a) {
/* 246 */       D.a(
/* 247 */           (this.a.length() == param1a.a.length()), "BitArrays must be of equal length (%s != %s)", this.a
/*     */           
/* 249 */           .length(), param1a.a
/* 250 */           .length());
/* 251 */       for (byte b = 0; b < this.a.length(); b++) {
/* 252 */         long l2, l3, l1 = param1a.a.get(b);
/*     */ 
/*     */ 
/*     */         
/* 256 */         boolean bool = true;
/*     */         do {
/* 258 */           l2 = this.a.get(b);
/* 259 */           l3 = l2 | l1;
/* 260 */           if (l2 == l3) {
/* 261 */             bool = false;
/*     */             break;
/*     */           } 
/* 264 */         } while (!this.a.compareAndSet(b, l2, l3));
/*     */         
/* 266 */         if (bool) {
/* 267 */           int i = Long.bitCount(l3) - Long.bitCount(l2);
/* 268 */           this.a.add(i);
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 275 */       if (param1Object instanceof a) {
/* 276 */         a a1 = (a)param1Object;
/*     */         
/* 278 */         return Arrays.equals(a((AtomicLongArray)this.a), a((AtomicLongArray)a1.a));
/*     */       } 
/* 280 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 286 */       return Arrays.hashCode(a((AtomicLongArray)this.a));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\h\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */