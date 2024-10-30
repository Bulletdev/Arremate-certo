/*     */ package com.google.a.h;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.b.D;
/*     */ import com.google.b.a.j;
/*     */ import java.security.Key;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.zip.Adler32;
/*     */ import java.util.zip.CRC32;
/*     */ import java.util.zip.Checksum;
/*     */ import javax.crypto.spec.SecretKeySpec;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class q
/*     */ {
/*     */   public static o a(int paramInt) {
/*  65 */     int i = H(paramInt);
/*     */     
/*  67 */     if (i == 32) {
/*  68 */       return C.l;
/*     */     }
/*  70 */     if (i <= 128) {
/*  71 */       return B.j;
/*     */     }
/*     */ 
/*     */     
/*  75 */     int j = (i + 127) / 128;
/*  76 */     o[] arrayOfO = new o[j];
/*  77 */     arrayOfO[0] = B.j;
/*  78 */     int k = fy;
/*  79 */     for (byte b = 1; b < j; b++) {
/*  80 */       k += 1500450271;
/*  81 */       arrayOfO[b] = c(k);
/*     */     } 
/*  83 */     return new b(arrayOfO);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  91 */   static final int fy = (int)System.currentTimeMillis();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static o b(int paramInt) {
/* 101 */     return new C(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static o a() {
/* 112 */     return C.k;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static o c(int paramInt) {
/* 123 */     return new B(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static o b() {
/* 134 */     return B.i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static o c() {
/* 144 */     return E.m;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static o a(long paramLong1, long paramLong2) {
/* 154 */     return new E(2, 4, paramLong1, paramLong2);
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
/*     */   @Deprecated
/*     */   public static o d() {
/* 171 */     return d.d;
/*     */   }
/*     */   
/*     */   private static class d {
/* 175 */     static final o d = new A("MD5", "Hashing.md5()");
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
/*     */   @Deprecated
/*     */   public static o e() {
/* 192 */     return e.e;
/*     */   }
/*     */   
/*     */   private static class e {
/* 196 */     static final o e = new A("SHA-1", "Hashing.sha1()");
/*     */   }
/*     */ 
/*     */   
/*     */   public static o f() {
/* 201 */     return f.f;
/*     */   }
/*     */   
/*     */   private static class f {
/* 205 */     static final o f = new A("SHA-256", "Hashing.sha256()");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static o g() {
/* 215 */     return g.g;
/*     */   }
/*     */   
/*     */   private static class g {
/* 219 */     static final o g = new A("SHA-384", "Hashing.sha384()");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static o h() {
/* 225 */     return h.h;
/*     */   }
/*     */   
/*     */   private static class h {
/* 229 */     static final o h = new A("SHA-512", "Hashing.sha512()");
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
/*     */   public static o a(Key paramKey) {
/* 243 */     return new z("HmacMD5", paramKey, a("hmacMd5", paramKey));
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
/*     */   public static o a(byte[] paramArrayOfbyte) {
/* 256 */     return a(new SecretKeySpec((byte[])D.checkNotNull(paramArrayOfbyte), "HmacMD5"));
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
/*     */   public static o b(Key paramKey) {
/* 269 */     return new z("HmacSHA1", paramKey, a("hmacSha1", paramKey));
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
/*     */   public static o b(byte[] paramArrayOfbyte) {
/* 282 */     return b(new SecretKeySpec((byte[])D.checkNotNull(paramArrayOfbyte), "HmacSHA1"));
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
/*     */   public static o c(Key paramKey) {
/* 295 */     return new z("HmacSHA256", paramKey, a("hmacSha256", paramKey));
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
/*     */   public static o c(byte[] paramArrayOfbyte) {
/* 308 */     return c(new SecretKeySpec((byte[])D.checkNotNull(paramArrayOfbyte), "HmacSHA256"));
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
/*     */   public static o d(Key paramKey) {
/* 321 */     return new z("HmacSHA512", paramKey, a("hmacSha512", paramKey));
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
/*     */   public static o d(byte[] paramArrayOfbyte) {
/* 334 */     return d(new SecretKeySpec((byte[])D.checkNotNull(paramArrayOfbyte), "HmacSHA512"));
/*     */   }
/*     */   
/*     */   private static String a(String paramString, Key paramKey) {
/* 338 */     return String.format("Hashing.%s(Key[algorithm=%s, format=%s])", new Object[] { paramString, paramKey
/*     */           
/* 340 */           .getAlgorithm(), paramKey.getFormat() });
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
/*     */   public static o i() {
/* 354 */     return j.a;
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
/*     */   public static o j() {
/* 370 */     return ((a)a.a).c;
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
/*     */   public static o k() {
/* 386 */     return a.b.c;
/*     */   }
/*     */   
/*     */   @j
/*     */   enum a implements t<Checksum> {
/* 391 */     a("Hashing.crc32()")
/*     */     {
/*     */       public Checksum a() {
/* 394 */         return new CRC32();
/*     */       }
/*     */     },
/* 397 */     b("Hashing.adler32()")
/*     */     {
/*     */       public Checksum a() {
/* 400 */         return new Adler32();
/*     */       }
/*     */     };
/*     */     
/*     */     public final o c;
/*     */     
/*     */     a(String param1String1) {
/* 407 */       this.c = new i(this, 32, param1String1);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static o l() {
/* 430 */     return k.b;
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
/*     */   public static int a(n paramn, int paramInt) {
/* 465 */     return a(paramn.ad(), paramInt);
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
/*     */   public static int a(long paramLong, int paramInt) {
/* 500 */     D.a((paramInt > 0), "buckets must be positive: %s", paramInt);
/* 501 */     c c = new c(paramLong);
/* 502 */     int i = 0;
/*     */ 
/*     */ 
/*     */     
/*     */     while (true) {
/* 507 */       int j = (int)((i + 1) / c.nextDouble());
/* 508 */       if (j >= 0 && j < paramInt) {
/* 509 */         i = j; continue;
/*     */       }  break;
/* 511 */     }  return i;
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
/*     */   public static n a(Iterable<n> paramIterable) {
/* 526 */     Iterator<n> iterator = paramIterable.iterator();
/* 527 */     D.a(iterator.hasNext(), "Must be at least 1 hash code to combine.");
/* 528 */     int i = ((n)iterator.next()).av();
/* 529 */     byte[] arrayOfByte = new byte[i / 8];
/* 530 */     for (n n : paramIterable) {
/* 531 */       byte[] arrayOfByte1 = n.asBytes();
/* 532 */       D.a((arrayOfByte1.length == arrayOfByte.length), "All hashcodes must have the same bit length.");
/*     */       
/* 534 */       for (byte b = 0; b < arrayOfByte1.length; b++) {
/* 535 */         arrayOfByte[b] = (byte)(arrayOfByte[b] * 37 ^ arrayOfByte1[b]);
/*     */       }
/*     */     } 
/* 538 */     return n.c(arrayOfByte);
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
/*     */   public static n b(Iterable<n> paramIterable) {
/* 551 */     Iterator<n> iterator = paramIterable.iterator();
/* 552 */     D.a(iterator.hasNext(), "Must be at least 1 hash code to combine.");
/* 553 */     byte[] arrayOfByte = new byte[((n)iterator.next()).av() / 8];
/* 554 */     for (n n : paramIterable) {
/* 555 */       byte[] arrayOfByte1 = n.asBytes();
/* 556 */       D.a((arrayOfByte1.length == arrayOfByte.length), "All hashcodes must have the same bit length.");
/*     */       
/* 558 */       for (byte b = 0; b < arrayOfByte1.length; b++) {
/* 559 */         arrayOfByte[b] = (byte)(arrayOfByte[b] + arrayOfByte1[b]);
/*     */       }
/*     */     } 
/* 562 */     return n.c(arrayOfByte);
/*     */   }
/*     */ 
/*     */   
/*     */   static int H(int paramInt) {
/* 567 */     D.a((paramInt > 0), "Number of bits must be positive");
/* 568 */     return paramInt + 31 & 0xFFFFFFE0;
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
/*     */   public static o a(o paramo1, o paramo2, o... paramVarArgs) {
/* 584 */     ArrayList<o> arrayList = new ArrayList();
/* 585 */     arrayList.add(paramo1);
/* 586 */     arrayList.add(paramo2);
/* 587 */     arrayList.addAll(Arrays.asList(paramVarArgs));
/* 588 */     return new b(arrayList.<o>toArray(new o[0]));
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
/*     */   public static o a(Iterable<o> paramIterable) {
/* 602 */     D.checkNotNull(paramIterable);
/*     */     
/* 604 */     ArrayList<o> arrayList = new ArrayList();
/* 605 */     for (o o : paramIterable) {
/* 606 */       arrayList.add(o);
/*     */     }
/* 608 */     D.a((arrayList.size() > 0), "number of hash functions (%s) must be > 0", arrayList.size());
/* 609 */     return new b(arrayList.<o>toArray(new o[0]));
/*     */   }
/*     */   
/*     */   private static final class b
/*     */     extends b {
/*     */     private b(o... param1VarArgs) {
/* 615 */       super(param1VarArgs);
/* 616 */       for (o o1 : param1VarArgs) {
/* 617 */         D.a(
/* 618 */             (o1.av() % 8 == 0), "the number of bits (%s) in hashFunction (%s) must be divisible by 8", o1
/*     */             
/* 620 */             .av(), o1);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     n a(p[] param1ArrayOfp) {
/* 627 */       byte[] arrayOfByte = new byte[av() / 8];
/* 628 */       int i = 0;
/* 629 */       for (p p1 : param1ArrayOfp) {
/* 630 */         n n = p1.a();
/* 631 */         i += n.a(arrayOfByte, i, n.av() / 8);
/*     */       } 
/* 633 */       return n.c(arrayOfByte);
/*     */     }
/*     */ 
/*     */     
/*     */     public int av() {
/* 638 */       int i = 0;
/* 639 */       for (o o : this.a) {
/* 640 */         i += o.av();
/*     */       }
/* 642 */       return i;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 647 */       if (param1Object instanceof b) {
/* 648 */         b b1 = (b)param1Object;
/* 649 */         return Arrays.equals((Object[])this.a, (Object[])b1.a);
/*     */       } 
/* 651 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 656 */       return Arrays.hashCode((Object[])this.a);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class c
/*     */   {
/*     */     private long state;
/*     */ 
/*     */     
/*     */     public c(long param1Long) {
/* 668 */       this.state = param1Long;
/*     */     }
/*     */     
/*     */     public double nextDouble() {
/* 672 */       this.state = 2862933555777941757L * this.state + 1L;
/* 673 */       return ((int)(this.state >>> 33L) + 1) / 2.147483648E9D;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\h\q.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */