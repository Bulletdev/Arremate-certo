/*     */ package com.google.a.h;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.m.k;
/*     */ import com.google.a.m.v;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public abstract class n
/*     */ {
/*     */   public abstract int av();
/*     */   
/*     */   public abstract int asInt();
/*     */   
/*     */   public abstract long asLong();
/*     */   
/*     */   public abstract long ad();
/*     */   
/*     */   public abstract byte[] asBytes();
/*     */   
/*     */   @com.google.b.a.a
/*     */   public int a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  87 */     paramInt2 = k.min(new int[] { paramInt2, av() / 8 });
/*  88 */     D.a(paramInt1, paramInt1 + paramInt2, paramArrayOfbyte.length);
/*  89 */     a(paramArrayOfbyte, paramInt1, paramInt2);
/*  90 */     return paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract void a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2);
/*     */ 
/*     */ 
/*     */   
/*     */   byte[] g() {
/* 101 */     return asBytes();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract boolean a(n paramn);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static n b(int paramInt) {
/* 117 */     return new b(paramInt);
/*     */   }
/*     */   
/*     */   private static final class b extends n implements Serializable {
/*     */     final int hash;
/*     */     
/*     */     b(int param1Int) {
/* 124 */       this.hash = param1Int;
/*     */     }
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     public int av() {
/* 129 */       return 32;
/*     */     }
/*     */ 
/*     */     
/*     */     public byte[] asBytes() {
/* 134 */       return new byte[] { (byte)this.hash, (byte)(this.hash >> 8), (byte)(this.hash >> 16), (byte)(this.hash >> 24) };
/*     */     }
/*     */ 
/*     */     
/*     */     public int asInt() {
/* 139 */       return this.hash;
/*     */     }
/*     */ 
/*     */     
/*     */     public long asLong() {
/* 144 */       throw new IllegalStateException("this HashCode only has 32 bits; cannot create a long");
/*     */     }
/*     */ 
/*     */     
/*     */     public long ad() {
/* 149 */       return v.d(this.hash);
/*     */     }
/*     */ 
/*     */     
/*     */     void a(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
/* 154 */       for (byte b1 = 0; b1 < param1Int2; b1++) {
/* 155 */         param1ArrayOfbyte[param1Int1 + b1] = (byte)(this.hash >> b1 * 8);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     boolean a(n param1n) {
/* 161 */       return (this.hash == param1n.asInt());
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
/*     */   public static n b(long paramLong) {
/* 174 */     return new c(paramLong);
/*     */   }
/*     */   
/*     */   private static final class c extends n implements Serializable { final long aT;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     c(long param1Long) {
/* 181 */       this.aT = param1Long;
/*     */     }
/*     */ 
/*     */     
/*     */     public int av() {
/* 186 */       return 64;
/*     */     }
/*     */ 
/*     */     
/*     */     public byte[] asBytes() {
/* 191 */       return new byte[] { (byte)(int)this.aT, (byte)(int)(this.aT >> 8L), (byte)(int)(this.aT >> 16L), (byte)(int)(this.aT >> 24L), (byte)(int)(this.aT >> 32L), (byte)(int)(this.aT >> 40L), (byte)(int)(this.aT >> 48L), (byte)(int)(this.aT >> 56L) };
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
/*     */     
/*     */     public int asInt() {
/* 205 */       return (int)this.aT;
/*     */     }
/*     */ 
/*     */     
/*     */     public long asLong() {
/* 210 */       return this.aT;
/*     */     }
/*     */ 
/*     */     
/*     */     public long ad() {
/* 215 */       return this.aT;
/*     */     }
/*     */ 
/*     */     
/*     */     void a(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
/* 220 */       for (byte b = 0; b < param1Int2; b++) {
/* 221 */         param1ArrayOfbyte[param1Int1 + b] = (byte)(int)(this.aT >> b * 8);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     boolean a(n param1n) {
/* 227 */       return (this.aT == param1n.asLong());
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static n b(byte[] paramArrayOfbyte) {
/* 240 */     D.a((paramArrayOfbyte.length >= 1), "A HashCode must contain at least 1 byte.");
/* 241 */     return c((byte[])paramArrayOfbyte.clone());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static n c(byte[] paramArrayOfbyte) {
/* 249 */     return new a(paramArrayOfbyte);
/*     */   }
/*     */   
/*     */   private static final class a extends n implements Serializable { final byte[] bytes;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     a(byte[] param1ArrayOfbyte) {
/* 256 */       this.bytes = (byte[])D.checkNotNull(param1ArrayOfbyte);
/*     */     }
/*     */ 
/*     */     
/*     */     public int av() {
/* 261 */       return this.bytes.length * 8;
/*     */     }
/*     */ 
/*     */     
/*     */     public byte[] asBytes() {
/* 266 */       return (byte[])this.bytes.clone();
/*     */     }
/*     */ 
/*     */     
/*     */     public int asInt() {
/* 271 */       D.b((this.bytes.length >= 4), "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", this.bytes.length);
/*     */ 
/*     */ 
/*     */       
/* 275 */       return this.bytes[0] & 0xFF | (this.bytes[1] & 0xFF) << 8 | (this.bytes[2] & 0xFF) << 16 | (this.bytes[3] & 0xFF) << 24;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long asLong() {
/* 283 */       D.b((this.bytes.length >= 8), "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", this.bytes.length);
/*     */ 
/*     */ 
/*     */       
/* 287 */       return ad();
/*     */     }
/*     */ 
/*     */     
/*     */     public long ad() {
/* 292 */       long l = (this.bytes[0] & 0xFF);
/* 293 */       for (byte b = 1; b < Math.min(this.bytes.length, 8); b++) {
/* 294 */         l |= (this.bytes[b] & 0xFFL) << b * 8;
/*     */       }
/* 296 */       return l;
/*     */     }
/*     */ 
/*     */     
/*     */     void a(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
/* 301 */       System.arraycopy(this.bytes, 0, param1ArrayOfbyte, param1Int1, param1Int2);
/*     */     }
/*     */ 
/*     */     
/*     */     byte[] g() {
/* 306 */       return this.bytes;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean a(n param1n) {
/* 313 */       if (this.bytes.length != (param1n.g()).length) {
/* 314 */         return false;
/*     */       }
/*     */       
/* 317 */       int i = 1;
/* 318 */       for (byte b = 0; b < this.bytes.length; b++) {
/* 319 */         i &= (this.bytes[b] == param1n.g()[b]) ? 1 : 0;
/*     */       }
/* 321 */       return i;
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static n a(String paramString) {
/* 338 */     D.a(
/* 339 */         (paramString.length() >= 2), "input string (%s) must have at least 2 characters", paramString);
/* 340 */     D.a(
/* 341 */         (paramString.length() % 2 == 0), "input string (%s) must have an even number of characters", paramString);
/*     */ 
/*     */ 
/*     */     
/* 345 */     byte[] arrayOfByte = new byte[paramString.length() / 2];
/* 346 */     for (byte b = 0; b < paramString.length(); b += 2) {
/* 347 */       int i = b(paramString.charAt(b)) << 4;
/* 348 */       int j = b(paramString.charAt(b + 1));
/* 349 */       arrayOfByte[b / 2] = (byte)(i + j);
/*     */     } 
/* 351 */     return c(arrayOfByte);
/*     */   }
/*     */   
/*     */   private static int b(char paramChar) {
/* 355 */     if (paramChar >= '0' && paramChar <= '9') {
/* 356 */       return paramChar - 48;
/*     */     }
/* 358 */     if (paramChar >= 'a' && paramChar <= 'f') {
/* 359 */       return paramChar - 97 + 10;
/*     */     }
/* 361 */     throw new IllegalArgumentException((new StringBuilder(32)).append("Illegal hexadecimal character: ").append(paramChar).toString());
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
/*     */   public final boolean equals(Object paramObject) {
/* 373 */     if (paramObject instanceof n) {
/* 374 */       n n1 = (n)paramObject;
/* 375 */       return (av() == n1.av() && a(n1));
/*     */     } 
/* 377 */     return false;
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
/*     */   public final int hashCode() {
/* 389 */     if (av() >= 32) {
/* 390 */       return asInt();
/*     */     }
/*     */     
/* 393 */     byte[] arrayOfByte = g();
/* 394 */     int i = arrayOfByte[0] & 0xFF;
/* 395 */     for (byte b = 1; b < arrayOfByte.length; b++) {
/* 396 */       i |= (arrayOfByte[b] & 0xFF) << b * 8;
/*     */     }
/* 398 */     return i;
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
/*     */   public final String toString() {
/* 414 */     byte[] arrayOfByte = g();
/* 415 */     StringBuilder stringBuilder = new StringBuilder(2 * arrayOfByte.length);
/* 416 */     for (byte b : arrayOfByte) {
/* 417 */       stringBuilder.append(hexDigits[b >> 4 & 0xF]).append(hexDigits[b & 0xF]);
/*     */     }
/* 419 */     return stringBuilder.toString();
/*     */   }
/*     */   
/* 422 */   private static final char[] hexDigits = "0123456789abcdef".toCharArray();
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\h\n.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */