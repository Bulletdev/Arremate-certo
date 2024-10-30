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
/*     */ @b(cl = true)
/*     */ public final class k
/*     */   extends l
/*     */ {
/*     */   public static final int BYTES = 4;
/*     */   public static final int gl = 1073741824;
/*     */   
/*     */   public static int R(int paramInt) {
/*  76 */     return paramInt;
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
/*     */   public static int d(long paramLong) {
/*  88 */     int i = (int)paramLong;
/*  89 */     D.a((i == paramLong), "Out of range: %s", paramLong);
/*  90 */     return i;
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
/*     */   public static int e(long paramLong) {
/* 102 */     if (paramLong > 2147483647L) {
/* 103 */       return Integer.MAX_VALUE;
/*     */     }
/* 105 */     if (paramLong < -2147483648L) {
/* 106 */       return Integer.MIN_VALUE;
/*     */     }
/* 108 */     return (int)paramLong;
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
/*     */   public static int compare(int paramInt1, int paramInt2) {
/* 124 */     return (paramInt1 < paramInt2) ? -1 : ((paramInt1 > paramInt2) ? 1 : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean contains(int[] paramArrayOfint, int paramInt) {
/* 135 */     for (int i : paramArrayOfint) {
/* 136 */       if (i == paramInt) {
/* 137 */         return true;
/*     */       }
/*     */     } 
/* 140 */     return false;
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
/*     */   public static int indexOf(int[] paramArrayOfint, int paramInt) {
/* 152 */     return a(paramArrayOfint, paramInt, 0, paramArrayOfint.length);
/*     */   }
/*     */ 
/*     */   
/*     */   private static int a(int[] paramArrayOfint, int paramInt1, int paramInt2, int paramInt3) {
/* 157 */     for (int i = paramInt2; i < paramInt3; i++) {
/* 158 */       if (paramArrayOfint[i] == paramInt1) {
/* 159 */         return i;
/*     */       }
/*     */     } 
/* 162 */     return -1;
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
/*     */   public static int a(int[] paramArrayOfint1, int[] paramArrayOfint2) {
/* 176 */     D.b(paramArrayOfint1, "array");
/* 177 */     D.b(paramArrayOfint2, "target");
/* 178 */     if (paramArrayOfint2.length == 0) {
/* 179 */       return 0;
/*     */     }
/*     */ 
/*     */     
/* 183 */     for (byte b = 0; b < paramArrayOfint1.length - paramArrayOfint2.length + 1; b++) {
/* 184 */       byte b1 = 0; while (true) { if (b1 < paramArrayOfint2.length) {
/* 185 */           if (paramArrayOfint1[b + b1] != paramArrayOfint2[b1])
/*     */             break;  b1++;
/*     */           continue;
/*     */         } 
/* 189 */         return b; }
/*     */     
/* 191 */     }  return -1;
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
/*     */   public static int lastIndexOf(int[] paramArrayOfint, int paramInt) {
/* 203 */     return b(paramArrayOfint, paramInt, 0, paramArrayOfint.length);
/*     */   }
/*     */ 
/*     */   
/*     */   private static int b(int[] paramArrayOfint, int paramInt1, int paramInt2, int paramInt3) {
/* 208 */     for (int i = paramInt3 - 1; i >= paramInt2; i--) {
/* 209 */       if (paramArrayOfint[i] == paramInt1) {
/* 210 */         return i;
/*     */       }
/*     */     } 
/* 213 */     return -1;
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
/*     */   public static int min(int... paramVarArgs) {
/* 227 */     D.checkArgument((paramVarArgs.length > 0));
/* 228 */     int i = paramVarArgs[0];
/* 229 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 230 */       if (paramVarArgs[b] < i) {
/* 231 */         i = paramVarArgs[b];
/*     */       }
/*     */     } 
/* 234 */     return i;
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
/*     */   public static int max(int... paramVarArgs) {
/* 248 */     D.checkArgument((paramVarArgs.length > 0));
/* 249 */     int i = paramVarArgs[0];
/* 250 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 251 */       if (paramVarArgs[b] > i) {
/* 252 */         i = paramVarArgs[b];
/*     */       }
/*     */     } 
/* 255 */     return i;
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
/*     */   public static int c(int paramInt1, int paramInt2, int paramInt3) {
/* 273 */     D.a((paramInt2 <= paramInt3), "min (%s) must be less than or equal to max (%s)", paramInt2, paramInt3);
/* 274 */     return Math.min(Math.max(paramInt1, paramInt2), paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int[] a(int[]... paramVarArgs) {
/* 285 */     int i = 0;
/* 286 */     for (int[] arrayOfInt1 : paramVarArgs) {
/* 287 */       i += arrayOfInt1.length;
/*     */     }
/* 289 */     int[] arrayOfInt = new int[i];
/* 290 */     int j = 0;
/* 291 */     for (int[] arrayOfInt1 : paramVarArgs) {
/* 292 */       System.arraycopy(arrayOfInt1, 0, arrayOfInt, j, arrayOfInt1.length);
/* 293 */       j += arrayOfInt1.length;
/*     */     } 
/* 295 */     return arrayOfInt;
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
/*     */   public static byte[] a(int paramInt) {
/* 308 */     return new byte[] { (byte)(paramInt >> 24), (byte)(paramInt >> 16), (byte)(paramInt >> 8), (byte)paramInt };
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
/*     */   public static int a(byte[] paramArrayOfbyte) {
/* 325 */     D.a((paramArrayOfbyte.length >= 4), "array too small: %s < %s", paramArrayOfbyte.length, 4);
/* 326 */     return a(paramArrayOfbyte[0], paramArrayOfbyte[1], paramArrayOfbyte[2], paramArrayOfbyte[3]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int a(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4) {
/* 336 */     return paramByte1 << 24 | (paramByte2 & 0xFF) << 16 | (paramByte3 & 0xFF) << 8 | paramByte4 & 0xFF;
/*     */   }
/*     */   
/*     */   private static final class b
/*     */     extends i<String, Integer> implements Serializable {
/* 341 */     static final b a = new b();
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     protected Integer b(String param1String) {
/* 345 */       return Integer.decode(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     protected String a(Integer param1Integer) {
/* 350 */       return param1Integer.toString();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 355 */       return "Ints.stringConverter()";
/*     */     }
/*     */     
/*     */     private Object readResolve() {
/* 359 */       return a;
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
/*     */   public static i<String, Integer> c() {
/* 378 */     return b.a;
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
/*     */   public static int[] a(int[] paramArrayOfint, int paramInt1, int paramInt2) {
/* 395 */     D.a((paramInt1 >= 0), "Invalid minLength: %s", paramInt1);
/* 396 */     D.a((paramInt2 >= 0), "Invalid padding: %s", paramInt2);
/* 397 */     return (paramArrayOfint.length < paramInt1) ? Arrays.copyOf(paramArrayOfint, paramInt1 + paramInt2) : paramArrayOfint;
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
/*     */   public static String a(String paramString, int... paramVarArgs) {
/* 409 */     D.checkNotNull(paramString);
/* 410 */     if (paramVarArgs.length == 0) {
/* 411 */       return "";
/*     */     }
/*     */ 
/*     */     
/* 415 */     StringBuilder stringBuilder = new StringBuilder(paramVarArgs.length * 5);
/* 416 */     stringBuilder.append(paramVarArgs[0]);
/* 417 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 418 */       stringBuilder.append(paramString).append(paramVarArgs[b]);
/*     */     }
/* 420 */     return stringBuilder.toString();
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
/*     */   public static Comparator<int[]> g() {
/* 436 */     return (Comparator<int[]>)c.a;
/*     */   }
/*     */   
/*     */   private enum c implements Comparator<int[]> {
/* 440 */     a;
/*     */ 
/*     */     
/*     */     public int b(int[] param1ArrayOfint1, int[] param1ArrayOfint2) {
/* 444 */       int i = Math.min(param1ArrayOfint1.length, param1ArrayOfint2.length);
/* 445 */       for (byte b = 0; b < i; b++) {
/* 446 */         int j = k.compare(param1ArrayOfint1[b], param1ArrayOfint2[b]);
/* 447 */         if (j != 0) {
/* 448 */           return j;
/*     */         }
/*     */       } 
/* 451 */       return param1ArrayOfint1.length - param1ArrayOfint2.length;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 456 */       return "Ints.lexicographicalComparator()";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void c(int[] paramArrayOfint) {
/* 466 */     D.checkNotNull(paramArrayOfint);
/* 467 */     a(paramArrayOfint, 0, paramArrayOfint.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(int[] paramArrayOfint, int paramInt1, int paramInt2) {
/* 477 */     D.checkNotNull(paramArrayOfint);
/* 478 */     D.a(paramInt1, paramInt2, paramArrayOfint.length);
/* 479 */     Arrays.sort(paramArrayOfint, paramInt1, paramInt2);
/* 480 */     reverse(paramArrayOfint, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void reverse(int[] paramArrayOfint) {
/* 490 */     D.checkNotNull(paramArrayOfint);
/* 491 */     reverse(paramArrayOfint, 0, paramArrayOfint.length);
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
/*     */   public static void reverse(int[] paramArrayOfint, int paramInt1, int paramInt2) {
/* 505 */     D.checkNotNull(paramArrayOfint);
/* 506 */     D.a(paramInt1, paramInt2, paramArrayOfint.length);
/* 507 */     for (int i = paramInt1, j = paramInt2 - 1; i < j; i++, j--) {
/* 508 */       int m = paramArrayOfint[i];
/* 509 */       paramArrayOfint[i] = paramArrayOfint[j];
/* 510 */       paramArrayOfint[j] = m;
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
/*     */   public static int[] a(Collection<? extends Number> paramCollection) {
/* 528 */     if (paramCollection instanceof a) {
/* 529 */       return ((a)paramCollection).b();
/*     */     }
/*     */     
/* 532 */     Object[] arrayOfObject = paramCollection.toArray();
/* 533 */     int i = arrayOfObject.length;
/* 534 */     int[] arrayOfInt = new int[i];
/* 535 */     for (byte b = 0; b < i; b++)
/*     */     {
/* 537 */       arrayOfInt[b] = ((Number)D.checkNotNull(arrayOfObject[b])).intValue();
/*     */     }
/* 539 */     return arrayOfInt;
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
/*     */   public static List<Integer> a(int... paramVarArgs) {
/* 558 */     if (paramVarArgs.length == 0) {
/* 559 */       return Collections.emptyList();
/*     */     }
/* 561 */     return new a(paramVarArgs);
/*     */   }
/*     */   
/*     */   @b
/*     */   private static class a extends AbstractList<Integer> implements Serializable, RandomAccess {
/*     */     final int[] aa;
/*     */     final int start;
/*     */     final int end;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     a(int[] param1ArrayOfint) {
/* 572 */       this(param1ArrayOfint, 0, param1ArrayOfint.length);
/*     */     }
/*     */     
/*     */     a(int[] param1ArrayOfint, int param1Int1, int param1Int2) {
/* 576 */       this.aa = param1ArrayOfint;
/* 577 */       this.start = param1Int1;
/* 578 */       this.end = param1Int2;
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 583 */       return this.end - this.start;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isEmpty() {
/* 588 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public Integer a(int param1Int) {
/* 593 */       D.b(param1Int, size());
/* 594 */       return Integer.valueOf(this.aa[this.start + param1Int]);
/*     */     }
/*     */ 
/*     */     
/*     */     public Spliterator.OfInt a() {
/* 599 */       return Spliterators.spliterator(this.aa, this.start, this.end, 0);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 605 */       return (param1Object instanceof Integer && k.c(this.aa, ((Integer)param1Object).intValue(), this.start, this.end) != -1);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int indexOf(Object param1Object) {
/* 611 */       if (param1Object instanceof Integer) {
/* 612 */         int i = k.c(this.aa, ((Integer)param1Object).intValue(), this.start, this.end);
/* 613 */         if (i >= 0) {
/* 614 */           return i - this.start;
/*     */         }
/*     */       } 
/* 617 */       return -1;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int lastIndexOf(Object param1Object) {
/* 623 */       if (param1Object instanceof Integer) {
/* 624 */         int i = k.d(this.aa, ((Integer)param1Object).intValue(), this.start, this.end);
/* 625 */         if (i >= 0) {
/* 626 */           return i - this.start;
/*     */         }
/*     */       } 
/* 629 */       return -1;
/*     */     }
/*     */ 
/*     */     
/*     */     public Integer a(int param1Int, Integer param1Integer) {
/* 634 */       D.b(param1Int, size());
/* 635 */       int i = this.aa[this.start + param1Int];
/*     */       
/* 637 */       this.aa[this.start + param1Int] = ((Integer)D.checkNotNull(param1Integer)).intValue();
/* 638 */       return Integer.valueOf(i);
/*     */     }
/*     */ 
/*     */     
/*     */     public List<Integer> subList(int param1Int1, int param1Int2) {
/* 643 */       int i = size();
/* 644 */       D.a(param1Int1, param1Int2, i);
/* 645 */       if (param1Int1 == param1Int2) {
/* 646 */         return Collections.emptyList();
/*     */       }
/* 648 */       return new a(this.aa, this.start + param1Int1, this.start + param1Int2);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 653 */       if (param1Object == this) {
/* 654 */         return true;
/*     */       }
/* 656 */       if (param1Object instanceof a) {
/* 657 */         a a1 = (a)param1Object;
/* 658 */         int i = size();
/* 659 */         if (a1.size() != i) {
/* 660 */           return false;
/*     */         }
/* 662 */         for (byte b = 0; b < i; b++) {
/* 663 */           if (this.aa[this.start + b] != a1.aa[a1.start + b]) {
/* 664 */             return false;
/*     */           }
/*     */         } 
/* 667 */         return true;
/*     */       } 
/* 669 */       return super.equals(param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 674 */       int i = 1;
/* 675 */       for (int j = this.start; j < this.end; j++) {
/* 676 */         i = 31 * i + k.R(this.aa[j]);
/*     */       }
/* 678 */       return i;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 683 */       StringBuilder stringBuilder = new StringBuilder(size() * 5);
/* 684 */       stringBuilder.append('[').append(this.aa[this.start]);
/* 685 */       for (int i = this.start + 1; i < this.end; i++) {
/* 686 */         stringBuilder.append(", ").append(this.aa[i]);
/*     */       }
/* 688 */       return stringBuilder.append(']').toString();
/*     */     }
/*     */     
/*     */     int[] b() {
/* 692 */       return Arrays.copyOfRange(this.aa, this.start, this.end);
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
/*     */   
/*     */   @com.google.a.a.a
/*     */   public static Integer a(String paramString) {
/* 717 */     return a(paramString, 10);
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
/*     */   public static Integer a(String paramString, int paramInt) {
/* 742 */     Long long_ = m.a(paramString, paramInt);
/* 743 */     if (long_ == null || long_.longValue() != long_.intValue()) {
/* 744 */       return null;
/*     */     }
/* 746 */     return Integer.valueOf(long_.intValue());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\m\k.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */