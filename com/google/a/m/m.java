/*     */ package com.google.a.m;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.i;
/*     */ import java.io.Serializable;
/*     */ import java.util.AbstractList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import java.util.RandomAccess;
/*     */ import java.util.Spliterator;
/*     */ import java.util.Spliterators;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @b
/*     */ public final class m
/*     */ {
/*     */   public static final int BYTES = 8;
/*     */   public static final long bn = 4611686018427387904L;
/*     */   
/*     */   public static int f(long paramLong) {
/*  79 */     return (int)(paramLong ^ paramLong >>> 32L);
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
/*     */   public static int compare(long paramLong1, long paramLong2) {
/*  95 */     return (paramLong1 < paramLong2) ? -1 : ((paramLong1 > paramLong2) ? 1 : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean contains(long[] paramArrayOflong, long paramLong) {
/* 106 */     for (long l : paramArrayOflong) {
/* 107 */       if (l == paramLong) {
/* 108 */         return true;
/*     */       }
/*     */     } 
/* 111 */     return false;
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
/*     */   public static int indexOf(long[] paramArrayOflong, long paramLong) {
/* 123 */     return a(paramArrayOflong, paramLong, 0, paramArrayOflong.length);
/*     */   }
/*     */ 
/*     */   
/*     */   private static int a(long[] paramArrayOflong, long paramLong, int paramInt1, int paramInt2) {
/* 128 */     for (int i = paramInt1; i < paramInt2; i++) {
/* 129 */       if (paramArrayOflong[i] == paramLong) {
/* 130 */         return i;
/*     */       }
/*     */     } 
/* 133 */     return -1;
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
/*     */   public static int a(long[] paramArrayOflong1, long[] paramArrayOflong2) {
/* 147 */     D.b(paramArrayOflong1, "array");
/* 148 */     D.b(paramArrayOflong2, "target");
/* 149 */     if (paramArrayOflong2.length == 0) {
/* 150 */       return 0;
/*     */     }
/*     */ 
/*     */     
/* 154 */     for (byte b = 0; b < paramArrayOflong1.length - paramArrayOflong2.length + 1; b++) {
/* 155 */       byte b1 = 0; while (true) { if (b1 < paramArrayOflong2.length) {
/* 156 */           if (paramArrayOflong1[b + b1] != paramArrayOflong2[b1])
/*     */             break;  b1++;
/*     */           continue;
/*     */         } 
/* 160 */         return b; }
/*     */     
/* 162 */     }  return -1;
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
/*     */   public static int lastIndexOf(long[] paramArrayOflong, long paramLong) {
/* 174 */     return b(paramArrayOflong, paramLong, 0, paramArrayOflong.length);
/*     */   }
/*     */ 
/*     */   
/*     */   private static int b(long[] paramArrayOflong, long paramLong, int paramInt1, int paramInt2) {
/* 179 */     for (int i = paramInt2 - 1; i >= paramInt1; i--) {
/* 180 */       if (paramArrayOflong[i] == paramLong) {
/* 181 */         return i;
/*     */       }
/*     */     } 
/* 184 */     return -1;
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
/*     */   public static long min(long... paramVarArgs) {
/* 196 */     D.checkArgument((paramVarArgs.length > 0));
/* 197 */     long l = paramVarArgs[0];
/* 198 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 199 */       if (paramVarArgs[b] < l) {
/* 200 */         l = paramVarArgs[b];
/*     */       }
/*     */     } 
/* 203 */     return l;
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
/*     */   public static long max(long... paramVarArgs) {
/* 215 */     D.checkArgument((paramVarArgs.length > 0));
/* 216 */     long l = paramVarArgs[0];
/* 217 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 218 */       if (paramVarArgs[b] > l) {
/* 219 */         l = paramVarArgs[b];
/*     */       }
/*     */     } 
/* 222 */     return l;
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
/*     */   @com.google.a.a.a
/*     */   public static long f(long paramLong1, long paramLong2, long paramLong3) {
/* 240 */     D.a((paramLong2 <= paramLong3), "min (%s) must be less than or equal to max (%s)", paramLong2, paramLong3);
/* 241 */     return Math.min(Math.max(paramLong1, paramLong2), paramLong3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long[] a(long[]... paramVarArgs) {
/* 252 */     int i = 0;
/* 253 */     for (long[] arrayOfLong1 : paramVarArgs) {
/* 254 */       i += arrayOfLong1.length;
/*     */     }
/* 256 */     long[] arrayOfLong = new long[i];
/* 257 */     int j = 0;
/* 258 */     for (long[] arrayOfLong1 : paramVarArgs) {
/* 259 */       System.arraycopy(arrayOfLong1, 0, arrayOfLong, j, arrayOfLong1.length);
/* 260 */       j += arrayOfLong1.length;
/*     */     } 
/* 262 */     return arrayOfLong;
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
/*     */   public static byte[] a(long paramLong) {
/* 278 */     byte[] arrayOfByte = new byte[8];
/* 279 */     for (byte b = 7; b >= 0; b--) {
/* 280 */       arrayOfByte[b] = (byte)(int)(paramLong & 0xFFL);
/* 281 */       paramLong >>= 8L;
/*     */     } 
/* 283 */     return arrayOfByte;
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
/*     */   public static long c(byte[] paramArrayOfbyte) {
/* 298 */     D.a((paramArrayOfbyte.length >= 8), "array too small: %s < %s", paramArrayOfbyte.length, 8);
/* 299 */     return a(paramArrayOfbyte[0], paramArrayOfbyte[1], paramArrayOfbyte[2], paramArrayOfbyte[3], paramArrayOfbyte[4], paramArrayOfbyte[5], paramArrayOfbyte[6], paramArrayOfbyte[7]);
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
/*     */   public static long a(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, byte paramByte7, byte paramByte8) {
/* 311 */     return (paramByte1 & 0xFFL) << 56L | (paramByte2 & 0xFFL) << 48L | (paramByte3 & 0xFFL) << 40L | (paramByte4 & 0xFFL) << 32L | (paramByte5 & 0xFFL) << 24L | (paramByte6 & 0xFFL) << 16L | (paramByte7 & 0xFFL) << 8L | paramByte8 & 0xFFL;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final class a
/*     */   {
/*     */     private static final byte[] e;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     static {
/* 331 */       byte[] arrayOfByte = new byte[128];
/* 332 */       Arrays.fill(arrayOfByte, (byte)-1); byte b;
/* 333 */       for (b = 0; b < 10; b++) {
/* 334 */         arrayOfByte[48 + b] = (byte)b;
/*     */       }
/* 336 */       for (b = 0; b < 26; b++) {
/* 337 */         arrayOfByte[65 + b] = (byte)(10 + b);
/* 338 */         arrayOfByte[97 + b] = (byte)(10 + b);
/*     */       } 
/* 340 */       e = arrayOfByte;
/*     */     }
/*     */     
/*     */     static int digit(char param1Char) {
/* 344 */       return (param1Char < '') ? e[param1Char] : -1;
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
/*     */   @com.google.a.a.a
/*     */   public static Long a(String paramString) {
/* 367 */     return a(paramString, 10);
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
/*     */   @com.google.a.a.a
/*     */   public static Long a(String paramString, int paramInt) {
/* 392 */     if (((String)D.checkNotNull(paramString)).isEmpty()) {
/* 393 */       return null;
/*     */     }
/* 395 */     if (paramInt < 2 || paramInt > 36) {
/* 396 */       throw new IllegalArgumentException((new StringBuilder(65)).append("radix must be between MIN_RADIX and MAX_RADIX but was ").append(paramInt).toString());
/*     */     }
/*     */     
/* 399 */     boolean bool = (paramString.charAt(0) == '-') ? true : false;
/* 400 */     byte b = bool ? 1 : 0;
/* 401 */     if (b == paramString.length()) {
/* 402 */       return null;
/*     */     }
/* 404 */     int i = a.digit(paramString.charAt(b++));
/* 405 */     if (i < 0 || i >= paramInt) {
/* 406 */       return null;
/*     */     }
/* 408 */     long l1 = -i;
/*     */     
/* 410 */     long l2 = Long.MIN_VALUE / paramInt;
/*     */     
/* 412 */     while (b < paramString.length()) {
/* 413 */       i = a.digit(paramString.charAt(b++));
/* 414 */       if (i < 0 || i >= paramInt || l1 < l2) {
/* 415 */         return null;
/*     */       }
/* 417 */       l1 *= paramInt;
/* 418 */       if (l1 < Long.MIN_VALUE + i) {
/* 419 */         return null;
/*     */       }
/* 421 */       l1 -= i;
/*     */     } 
/*     */     
/* 424 */     if (bool)
/* 425 */       return Long.valueOf(l1); 
/* 426 */     if (l1 == Long.MIN_VALUE) {
/* 427 */       return null;
/*     */     }
/* 429 */     return Long.valueOf(-l1);
/*     */   }
/*     */   
/*     */   private static final class d
/*     */     extends i<String, Long> implements Serializable {
/* 434 */     static final d a = new d();
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     protected Long b(String param1String) {
/* 438 */       return Long.decode(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     protected String a(Long param1Long) {
/* 443 */       return param1Long.toString();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 448 */       return "Longs.stringConverter()";
/*     */     }
/*     */     
/*     */     private Object readResolve() {
/* 452 */       return a;
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
/*     */   @com.google.a.a.a
/*     */   public static i<String, Long> c() {
/* 471 */     return d.a;
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
/*     */   public static long[] a(long[] paramArrayOflong, int paramInt1, int paramInt2) {
/* 488 */     D.a((paramInt1 >= 0), "Invalid minLength: %s", paramInt1);
/* 489 */     D.a((paramInt2 >= 0), "Invalid padding: %s", paramInt2);
/* 490 */     return (paramArrayOflong.length < paramInt1) ? Arrays.copyOf(paramArrayOflong, paramInt1 + paramInt2) : paramArrayOflong;
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
/*     */   public static String a(String paramString, long... paramVarArgs) {
/* 502 */     D.checkNotNull(paramString);
/* 503 */     if (paramVarArgs.length == 0) {
/* 504 */       return "";
/*     */     }
/*     */ 
/*     */     
/* 508 */     StringBuilder stringBuilder = new StringBuilder(paramVarArgs.length * 10);
/* 509 */     stringBuilder.append(paramVarArgs[0]);
/* 510 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 511 */       stringBuilder.append(paramString).append(paramVarArgs[b]);
/*     */     }
/* 513 */     return stringBuilder.toString();
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
/*     */   public static Comparator<long[]> g() {
/* 530 */     return (Comparator<long[]>)b.a;
/*     */   }
/*     */   
/*     */   private enum b implements Comparator<long[]> {
/* 534 */     a;
/*     */ 
/*     */     
/*     */     public int compare(long[] param1ArrayOflong1, long[] param1ArrayOflong2) {
/* 538 */       int i = Math.min(param1ArrayOflong1.length, param1ArrayOflong2.length);
/* 539 */       for (byte b1 = 0; b1 < i; b1++) {
/* 540 */         int j = m.compare(param1ArrayOflong1[b1], param1ArrayOflong2[b1]);
/* 541 */         if (j != 0) {
/* 542 */           return j;
/*     */         }
/*     */       } 
/* 545 */       return param1ArrayOflong1.length - param1ArrayOflong2.length;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 550 */       return "Longs.lexicographicalComparator()";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void b(long[] paramArrayOflong) {
/* 560 */     D.checkNotNull(paramArrayOflong);
/* 561 */     a(paramArrayOflong, 0, paramArrayOflong.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(long[] paramArrayOflong, int paramInt1, int paramInt2) {
/* 571 */     D.checkNotNull(paramArrayOflong);
/* 572 */     D.a(paramInt1, paramInt2, paramArrayOflong.length);
/* 573 */     Arrays.sort(paramArrayOflong, paramInt1, paramInt2);
/* 574 */     reverse(paramArrayOflong, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void reverse(long[] paramArrayOflong) {
/* 584 */     D.checkNotNull(paramArrayOflong);
/* 585 */     reverse(paramArrayOflong, 0, paramArrayOflong.length);
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
/*     */   public static void reverse(long[] paramArrayOflong, int paramInt1, int paramInt2) {
/* 599 */     D.checkNotNull(paramArrayOflong);
/* 600 */     D.a(paramInt1, paramInt2, paramArrayOflong.length);
/* 601 */     for (int i = paramInt1, j = paramInt2 - 1; i < j; i++, j--) {
/* 602 */       long l = paramArrayOflong[i];
/* 603 */       paramArrayOflong[i] = paramArrayOflong[j];
/* 604 */       paramArrayOflong[j] = l;
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
/*     */   public static long[] a(Collection<? extends Number> paramCollection) {
/* 622 */     if (paramCollection instanceof c) {
/* 623 */       return ((c)paramCollection).b();
/*     */     }
/*     */     
/* 626 */     Object[] arrayOfObject = paramCollection.toArray();
/* 627 */     int i = arrayOfObject.length;
/* 628 */     long[] arrayOfLong = new long[i];
/* 629 */     for (byte b = 0; b < i; b++)
/*     */     {
/* 631 */       arrayOfLong[b] = ((Number)D.checkNotNull(arrayOfObject[b])).longValue();
/*     */     }
/* 633 */     return arrayOfLong;
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
/*     */   public static List<Long> a(long... paramVarArgs) {
/* 652 */     if (paramVarArgs.length == 0) {
/* 653 */       return Collections.emptyList();
/*     */     }
/* 655 */     return new c(paramVarArgs);
/*     */   }
/*     */   
/*     */   @b
/*     */   private static class c extends AbstractList<Long> implements Serializable, RandomAccess {
/*     */     final long[] g;
/*     */     final int start;
/*     */     final int end;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     c(long[] param1ArrayOflong) {
/* 666 */       this(param1ArrayOflong, 0, param1ArrayOflong.length);
/*     */     }
/*     */     
/*     */     c(long[] param1ArrayOflong, int param1Int1, int param1Int2) {
/* 670 */       this.g = param1ArrayOflong;
/* 671 */       this.start = param1Int1;
/* 672 */       this.end = param1Int2;
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 677 */       return this.end - this.start;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isEmpty() {
/* 682 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public Long a(int param1Int) {
/* 687 */       D.b(param1Int, size());
/* 688 */       return Long.valueOf(this.g[this.start + param1Int]);
/*     */     }
/*     */ 
/*     */     
/*     */     public Spliterator.OfLong a() {
/* 693 */       return Spliterators.spliterator(this.g, this.start, this.end, 0);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 699 */       return (param1Object instanceof Long && m.c(this.g, ((Long)param1Object).longValue(), this.start, this.end) != -1);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int indexOf(Object param1Object) {
/* 705 */       if (param1Object instanceof Long) {
/* 706 */         int i = m.c(this.g, ((Long)param1Object).longValue(), this.start, this.end);
/* 707 */         if (i >= 0) {
/* 708 */           return i - this.start;
/*     */         }
/*     */       } 
/* 711 */       return -1;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int lastIndexOf(Object param1Object) {
/* 717 */       if (param1Object instanceof Long) {
/* 718 */         int i = m.d(this.g, ((Long)param1Object).longValue(), this.start, this.end);
/* 719 */         if (i >= 0) {
/* 720 */           return i - this.start;
/*     */         }
/*     */       } 
/* 723 */       return -1;
/*     */     }
/*     */ 
/*     */     
/*     */     public Long a(int param1Int, Long param1Long) {
/* 728 */       D.b(param1Int, size());
/* 729 */       long l = this.g[this.start + param1Int];
/*     */       
/* 731 */       this.g[this.start + param1Int] = ((Long)D.checkNotNull(param1Long)).longValue();
/* 732 */       return Long.valueOf(l);
/*     */     }
/*     */ 
/*     */     
/*     */     public List<Long> subList(int param1Int1, int param1Int2) {
/* 737 */       int i = size();
/* 738 */       D.a(param1Int1, param1Int2, i);
/* 739 */       if (param1Int1 == param1Int2) {
/* 740 */         return Collections.emptyList();
/*     */       }
/* 742 */       return new c(this.g, this.start + param1Int1, this.start + param1Int2);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 747 */       if (param1Object == this) {
/* 748 */         return true;
/*     */       }
/* 750 */       if (param1Object instanceof c) {
/* 751 */         c c1 = (c)param1Object;
/* 752 */         int i = size();
/* 753 */         if (c1.size() != i) {
/* 754 */           return false;
/*     */         }
/* 756 */         for (byte b = 0; b < i; b++) {
/* 757 */           if (this.g[this.start + b] != c1.g[c1.start + b]) {
/* 758 */             return false;
/*     */           }
/*     */         } 
/* 761 */         return true;
/*     */       } 
/* 763 */       return super.equals(param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 768 */       int i = 1;
/* 769 */       for (int j = this.start; j < this.end; j++) {
/* 770 */         i = 31 * i + m.f(this.g[j]);
/*     */       }
/* 772 */       return i;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 777 */       StringBuilder stringBuilder = new StringBuilder(size() * 10);
/* 778 */       stringBuilder.append('[').append(this.g[this.start]);
/* 779 */       for (int i = this.start + 1; i < this.end; i++) {
/* 780 */         stringBuilder.append(", ").append(this.g[i]);
/*     */       }
/* 782 */       return stringBuilder.append(']').toString();
/*     */     }
/*     */     
/*     */     long[] b() {
/* 786 */       return Arrays.copyOfRange(this.g, this.start, this.end);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\m\m.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */