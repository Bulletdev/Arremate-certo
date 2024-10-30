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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class q
/*     */   extends r
/*     */ {
/*     */   public static final int BYTES = 2;
/*     */   public static final short a = 16384;
/*     */   
/*     */   public static int a(short paramShort) {
/*  74 */     return paramShort;
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
/*     */   public static short a(long paramLong) {
/*  86 */     short s = (short)(int)paramLong;
/*  87 */     D.a((s == paramLong), "Out of range: %s", paramLong);
/*  88 */     return s;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static short b(long paramLong) {
/*  99 */     if (paramLong > 32767L) {
/* 100 */       return Short.MAX_VALUE;
/*     */     }
/* 102 */     if (paramLong < -32768L) {
/* 103 */       return Short.MIN_VALUE;
/*     */     }
/* 105 */     return (short)(int)paramLong;
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
/*     */   public static int compare(short paramShort1, short paramShort2) {
/* 121 */     return paramShort1 - paramShort2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean contains(short[] paramArrayOfshort, short paramShort) {
/* 132 */     for (short s : paramArrayOfshort) {
/* 133 */       if (s == paramShort) {
/* 134 */         return true;
/*     */       }
/*     */     } 
/* 137 */     return false;
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
/*     */   public static int indexOf(short[] paramArrayOfshort, short paramShort) {
/* 149 */     return a(paramArrayOfshort, paramShort, 0, paramArrayOfshort.length);
/*     */   }
/*     */ 
/*     */   
/*     */   private static int a(short[] paramArrayOfshort, short paramShort, int paramInt1, int paramInt2) {
/* 154 */     for (int i = paramInt1; i < paramInt2; i++) {
/* 155 */       if (paramArrayOfshort[i] == paramShort) {
/* 156 */         return i;
/*     */       }
/*     */     } 
/* 159 */     return -1;
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
/*     */   public static int a(short[] paramArrayOfshort1, short[] paramArrayOfshort2) {
/* 173 */     D.b(paramArrayOfshort1, "array");
/* 174 */     D.b(paramArrayOfshort2, "target");
/* 175 */     if (paramArrayOfshort2.length == 0) {
/* 176 */       return 0;
/*     */     }
/*     */ 
/*     */     
/* 180 */     for (byte b = 0; b < paramArrayOfshort1.length - paramArrayOfshort2.length + 1; b++) {
/* 181 */       byte b1 = 0; while (true) { if (b1 < paramArrayOfshort2.length) {
/* 182 */           if (paramArrayOfshort1[b + b1] != paramArrayOfshort2[b1])
/*     */             break;  b1++;
/*     */           continue;
/*     */         } 
/* 186 */         return b; }
/*     */     
/* 188 */     }  return -1;
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
/*     */   public static int lastIndexOf(short[] paramArrayOfshort, short paramShort) {
/* 200 */     return b(paramArrayOfshort, paramShort, 0, paramArrayOfshort.length);
/*     */   }
/*     */ 
/*     */   
/*     */   private static int b(short[] paramArrayOfshort, short paramShort, int paramInt1, int paramInt2) {
/* 205 */     for (int i = paramInt2 - 1; i >= paramInt1; i--) {
/* 206 */       if (paramArrayOfshort[i] == paramShort) {
/* 207 */         return i;
/*     */       }
/*     */     } 
/* 210 */     return -1;
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
/*     */   @com.google.a.a.c("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
/*     */   public static short min(short... paramVarArgs) {
/* 224 */     D.checkArgument((paramVarArgs.length > 0));
/* 225 */     short s = paramVarArgs[0];
/* 226 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 227 */       if (paramVarArgs[b] < s) {
/* 228 */         s = paramVarArgs[b];
/*     */       }
/*     */     } 
/* 231 */     return s;
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
/*     */   @com.google.a.a.c("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
/*     */   public static short max(short... paramVarArgs) {
/* 245 */     D.checkArgument((paramVarArgs.length > 0));
/* 246 */     short s = paramVarArgs[0];
/* 247 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 248 */       if (paramVarArgs[b] > s) {
/* 249 */         s = paramVarArgs[b];
/*     */       }
/*     */     } 
/* 252 */     return s;
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
/*     */   public static short a(short paramShort1, short paramShort2, short paramShort3) {
/* 270 */     D.a((paramShort2 <= paramShort3), "min (%s) must be less than or equal to max (%s)", paramShort2, paramShort3);
/* 271 */     return (paramShort1 < paramShort2) ? paramShort2 : ((paramShort1 < paramShort3) ? paramShort1 : paramShort3);
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
/*     */   public static short[] a(short[]... paramVarArgs) {
/* 283 */     int i = 0;
/* 284 */     for (short[] arrayOfShort1 : paramVarArgs) {
/* 285 */       i += arrayOfShort1.length;
/*     */     }
/* 287 */     short[] arrayOfShort = new short[i];
/* 288 */     int j = 0;
/* 289 */     for (short[] arrayOfShort1 : paramVarArgs) {
/* 290 */       System.arraycopy(arrayOfShort1, 0, arrayOfShort, j, arrayOfShort1.length);
/* 291 */       j += arrayOfShort1.length;
/*     */     } 
/* 293 */     return arrayOfShort;
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
/*     */   @com.google.a.a.c
/*     */   public static byte[] a(short paramShort) {
/* 307 */     return new byte[] { (byte)(paramShort >> 8), (byte)paramShort };
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
/*     */   @com.google.a.a.c
/*     */   public static short a(byte[] paramArrayOfbyte) {
/* 322 */     D.a((paramArrayOfbyte.length >= 2), "array too small: %s < %s", paramArrayOfbyte.length, 2);
/* 323 */     return a(paramArrayOfbyte[0], paramArrayOfbyte[1]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.a.a.c
/*     */   public static short a(byte paramByte1, byte paramByte2) {
/* 334 */     return (short)(paramByte1 << 8 | paramByte2 & 0xFF);
/*     */   }
/*     */   
/*     */   private static final class c
/*     */     extends i<String, Short> implements Serializable {
/* 339 */     static final c a = new c();
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     protected Short a(String param1String) {
/* 343 */       return Short.decode(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     protected String a(Short param1Short) {
/* 348 */       return param1Short.toString();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 353 */       return "Shorts.stringConverter()";
/*     */     }
/*     */     
/*     */     private Object readResolve() {
/* 357 */       return a;
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
/*     */   public static i<String, Short> c() {
/* 376 */     return c.a;
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
/*     */   public static short[] a(short[] paramArrayOfshort, int paramInt1, int paramInt2) {
/* 393 */     D.a((paramInt1 >= 0), "Invalid minLength: %s", paramInt1);
/* 394 */     D.a((paramInt2 >= 0), "Invalid padding: %s", paramInt2);
/* 395 */     return (paramArrayOfshort.length < paramInt1) ? Arrays.copyOf(paramArrayOfshort, paramInt1 + paramInt2) : paramArrayOfshort;
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
/*     */   public static String a(String paramString, short... paramVarArgs) {
/* 408 */     D.checkNotNull(paramString);
/* 409 */     if (paramVarArgs.length == 0) {
/* 410 */       return "";
/*     */     }
/*     */ 
/*     */     
/* 414 */     StringBuilder stringBuilder = new StringBuilder(paramVarArgs.length * 6);
/* 415 */     stringBuilder.append(paramVarArgs[0]);
/* 416 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 417 */       stringBuilder.append(paramString).append(paramVarArgs[b]);
/*     */     }
/* 419 */     return stringBuilder.toString();
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
/*     */   public static Comparator<short[]> g() {
/* 436 */     return (Comparator<short[]>)a.a;
/*     */   }
/*     */   
/*     */   private enum a implements Comparator<short[]> {
/* 440 */     a;
/*     */ 
/*     */     
/*     */     public int b(short[] param1ArrayOfshort1, short[] param1ArrayOfshort2) {
/* 444 */       int i = Math.min(param1ArrayOfshort1.length, param1ArrayOfshort2.length);
/* 445 */       for (byte b = 0; b < i; b++) {
/* 446 */         int j = q.compare(param1ArrayOfshort1[b], param1ArrayOfshort2[b]);
/* 447 */         if (j != 0) {
/* 448 */           return j;
/*     */         }
/*     */       } 
/* 451 */       return param1ArrayOfshort1.length - param1ArrayOfshort2.length;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 456 */       return "Shorts.lexicographicalComparator()";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(short[] paramArrayOfshort) {
/* 466 */     D.checkNotNull(paramArrayOfshort);
/* 467 */     a(paramArrayOfshort, 0, paramArrayOfshort.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(short[] paramArrayOfshort, int paramInt1, int paramInt2) {
/* 477 */     D.checkNotNull(paramArrayOfshort);
/* 478 */     D.a(paramInt1, paramInt2, paramArrayOfshort.length);
/* 479 */     Arrays.sort(paramArrayOfshort, paramInt1, paramInt2);
/* 480 */     reverse(paramArrayOfshort, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void reverse(short[] paramArrayOfshort) {
/* 490 */     D.checkNotNull(paramArrayOfshort);
/* 491 */     reverse(paramArrayOfshort, 0, paramArrayOfshort.length);
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
/*     */   public static void reverse(short[] paramArrayOfshort, int paramInt1, int paramInt2) {
/* 505 */     D.checkNotNull(paramArrayOfshort);
/* 506 */     D.a(paramInt1, paramInt2, paramArrayOfshort.length);
/* 507 */     for (int i = paramInt1, j = paramInt2 - 1; i < j; i++, j--) {
/* 508 */       short s = paramArrayOfshort[i];
/* 509 */       paramArrayOfshort[i] = paramArrayOfshort[j];
/* 510 */       paramArrayOfshort[j] = s;
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
/*     */   public static short[] a(Collection<? extends Number> paramCollection) {
/* 528 */     if (paramCollection instanceof b) {
/* 529 */       return ((b)paramCollection).a();
/*     */     }
/*     */     
/* 532 */     Object[] arrayOfObject = paramCollection.toArray();
/* 533 */     int i = arrayOfObject.length;
/* 534 */     short[] arrayOfShort = new short[i];
/* 535 */     for (byte b = 0; b < i; b++)
/*     */     {
/* 537 */       arrayOfShort[b] = ((Number)D.checkNotNull(arrayOfObject[b])).shortValue();
/*     */     }
/* 539 */     return arrayOfShort;
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
/*     */   public static List<Short> a(short... paramVarArgs) {
/* 555 */     if (paramVarArgs.length == 0) {
/* 556 */       return Collections.emptyList();
/*     */     }
/* 558 */     return new b(paramVarArgs);
/*     */   }
/*     */   
/*     */   @b
/*     */   private static class b extends AbstractList<Short> implements Serializable, RandomAccess {
/*     */     final short[] a;
/*     */     final int start;
/*     */     final int end;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     b(short[] param1ArrayOfshort) {
/* 569 */       this(param1ArrayOfshort, 0, param1ArrayOfshort.length);
/*     */     }
/*     */     
/*     */     b(short[] param1ArrayOfshort, int param1Int1, int param1Int2) {
/* 573 */       this.a = param1ArrayOfshort;
/* 574 */       this.start = param1Int1;
/* 575 */       this.end = param1Int2;
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 580 */       return this.end - this.start;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isEmpty() {
/* 585 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public Short a(int param1Int) {
/* 590 */       D.b(param1Int, size());
/* 591 */       return Short.valueOf(this.a[this.start + param1Int]);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 597 */       return (param1Object instanceof Short && q.c(this.a, ((Short)param1Object).shortValue(), this.start, this.end) != -1);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int indexOf(Object param1Object) {
/* 603 */       if (param1Object instanceof Short) {
/* 604 */         int i = q.c(this.a, ((Short)param1Object).shortValue(), this.start, this.end);
/* 605 */         if (i >= 0) {
/* 606 */           return i - this.start;
/*     */         }
/*     */       } 
/* 609 */       return -1;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int lastIndexOf(Object param1Object) {
/* 615 */       if (param1Object instanceof Short) {
/* 616 */         int i = q.d(this.a, ((Short)param1Object).shortValue(), this.start, this.end);
/* 617 */         if (i >= 0) {
/* 618 */           return i - this.start;
/*     */         }
/*     */       } 
/* 621 */       return -1;
/*     */     }
/*     */ 
/*     */     
/*     */     public Short a(int param1Int, Short param1Short) {
/* 626 */       D.b(param1Int, size());
/* 627 */       short s = this.a[this.start + param1Int];
/*     */       
/* 629 */       this.a[this.start + param1Int] = ((Short)D.checkNotNull(param1Short)).shortValue();
/* 630 */       return Short.valueOf(s);
/*     */     }
/*     */ 
/*     */     
/*     */     public List<Short> subList(int param1Int1, int param1Int2) {
/* 635 */       int i = size();
/* 636 */       D.a(param1Int1, param1Int2, i);
/* 637 */       if (param1Int1 == param1Int2) {
/* 638 */         return Collections.emptyList();
/*     */       }
/* 640 */       return new b(this.a, this.start + param1Int1, this.start + param1Int2);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 645 */       if (param1Object == this) {
/* 646 */         return true;
/*     */       }
/* 648 */       if (param1Object instanceof b) {
/* 649 */         b b1 = (b)param1Object;
/* 650 */         int i = size();
/* 651 */         if (b1.size() != i) {
/* 652 */           return false;
/*     */         }
/* 654 */         for (byte b2 = 0; b2 < i; b2++) {
/* 655 */           if (this.a[this.start + b2] != b1.a[b1.start + b2]) {
/* 656 */             return false;
/*     */           }
/*     */         } 
/* 659 */         return true;
/*     */       } 
/* 661 */       return super.equals(param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 666 */       int i = 1;
/* 667 */       for (int j = this.start; j < this.end; j++) {
/* 668 */         i = 31 * i + q.a(this.a[j]);
/*     */       }
/* 670 */       return i;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 675 */       StringBuilder stringBuilder = new StringBuilder(size() * 6);
/* 676 */       stringBuilder.append('[').append(this.a[this.start]);
/* 677 */       for (int i = this.start + 1; i < this.end; i++) {
/* 678 */         stringBuilder.append(", ").append(this.a[i]);
/*     */       }
/* 680 */       return stringBuilder.append(']').toString();
/*     */     }
/*     */     
/*     */     short[] a() {
/* 684 */       return Arrays.copyOfRange(this.a, this.start, this.end);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\m\q.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */