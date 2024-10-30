/*     */ package com.google.a.m;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.L;
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
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class d
/*     */   extends e
/*     */ {
/*     */   public static final int BYTES = 8;
/*     */   
/*     */   public static int b(double paramDouble) {
/*  74 */     return Double.valueOf(paramDouble).hashCode();
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
/*     */   public static int compare(double paramDouble1, double paramDouble2) {
/*  95 */     return Double.compare(paramDouble1, paramDouble2);
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
/*     */   public static boolean e(double paramDouble) {
/* 107 */     return (Double.NEGATIVE_INFINITY < paramDouble && paramDouble < Double.POSITIVE_INFINITY);
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
/*     */   public static boolean contains(double[] paramArrayOfdouble, double paramDouble) {
/* 119 */     for (double d1 : paramArrayOfdouble) {
/* 120 */       if (d1 == paramDouble) {
/* 121 */         return true;
/*     */       }
/*     */     } 
/* 124 */     return false;
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
/*     */   public static int indexOf(double[] paramArrayOfdouble, double paramDouble) {
/* 137 */     return a(paramArrayOfdouble, paramDouble, 0, paramArrayOfdouble.length);
/*     */   }
/*     */ 
/*     */   
/*     */   private static int a(double[] paramArrayOfdouble, double paramDouble, int paramInt1, int paramInt2) {
/* 142 */     for (int i = paramInt1; i < paramInt2; i++) {
/* 143 */       if (paramArrayOfdouble[i] == paramDouble) {
/* 144 */         return i;
/*     */       }
/*     */     } 
/* 147 */     return -1;
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
/*     */   public static int a(double[] paramArrayOfdouble1, double[] paramArrayOfdouble2) {
/* 163 */     D.b(paramArrayOfdouble1, "array");
/* 164 */     D.b(paramArrayOfdouble2, "target");
/* 165 */     if (paramArrayOfdouble2.length == 0) {
/* 166 */       return 0;
/*     */     }
/*     */ 
/*     */     
/* 170 */     for (byte b = 0; b < paramArrayOfdouble1.length - paramArrayOfdouble2.length + 1; b++) {
/* 171 */       byte b1 = 0; while (true) { if (b1 < paramArrayOfdouble2.length) {
/* 172 */           if (paramArrayOfdouble1[b + b1] != paramArrayOfdouble2[b1])
/*     */             break;  b1++;
/*     */           continue;
/*     */         } 
/* 176 */         return b; }
/*     */     
/* 178 */     }  return -1;
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
/*     */   public static int lastIndexOf(double[] paramArrayOfdouble, double paramDouble) {
/* 191 */     return b(paramArrayOfdouble, paramDouble, 0, paramArrayOfdouble.length);
/*     */   }
/*     */ 
/*     */   
/*     */   private static int b(double[] paramArrayOfdouble, double paramDouble, int paramInt1, int paramInt2) {
/* 196 */     for (int i = paramInt2 - 1; i >= paramInt1; i--) {
/* 197 */       if (paramArrayOfdouble[i] == paramDouble) {
/* 198 */         return i;
/*     */       }
/*     */     } 
/* 201 */     return -1;
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
/*     */   @com.google.a.a.c("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
/*     */   public static double min(double... paramVarArgs) {
/* 216 */     D.checkArgument((paramVarArgs.length > 0));
/* 217 */     double d1 = paramVarArgs[0];
/* 218 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 219 */       d1 = Math.min(d1, paramVarArgs[b]);
/*     */     }
/* 221 */     return d1;
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
/*     */   @com.google.a.a.c("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
/*     */   public static double max(double... paramVarArgs) {
/* 236 */     D.checkArgument((paramVarArgs.length > 0));
/* 237 */     double d1 = paramVarArgs[0];
/* 238 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 239 */       d1 = Math.max(d1, paramVarArgs[b]);
/*     */     }
/* 241 */     return d1;
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
/*     */   @com.google.a.a.a
/*     */   public static double a(double paramDouble1, double paramDouble2, double paramDouble3) {
/* 261 */     if (paramDouble2 <= paramDouble3) {
/* 262 */       return Math.min(Math.max(paramDouble1, paramDouble2), paramDouble3);
/*     */     }
/* 264 */     throw new IllegalArgumentException(
/* 265 */         L.a("min (%s) must be less than or equal to max (%s)", new Object[] { Double.valueOf(paramDouble2), Double.valueOf(paramDouble3) }));
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
/*     */   public static double[] a(double[]... paramVarArgs) {
/* 277 */     int i = 0;
/* 278 */     for (double[] arrayOfDouble1 : paramVarArgs) {
/* 279 */       i += arrayOfDouble1.length;
/*     */     }
/* 281 */     double[] arrayOfDouble = new double[i];
/* 282 */     int j = 0;
/* 283 */     for (double[] arrayOfDouble1 : paramVarArgs) {
/* 284 */       System.arraycopy(arrayOfDouble1, 0, arrayOfDouble, j, arrayOfDouble1.length);
/* 285 */       j += arrayOfDouble1.length;
/*     */     } 
/* 287 */     return arrayOfDouble;
/*     */   }
/*     */   
/*     */   private static final class b
/*     */     extends i<String, Double> implements Serializable {
/* 292 */     static final b a = new b();
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     protected Double c(String param1String) {
/* 296 */       return Double.valueOf(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     protected String a(Double param1Double) {
/* 301 */       return param1Double.toString();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 306 */       return "Doubles.stringConverter()";
/*     */     }
/*     */     
/*     */     private Object readResolve() {
/* 310 */       return a;
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
/*     */   @com.google.a.a.a
/*     */   public static i<String, Double> c() {
/* 324 */     return b.a;
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
/*     */   public static double[] a(double[] paramArrayOfdouble, int paramInt1, int paramInt2) {
/* 341 */     D.a((paramInt1 >= 0), "Invalid minLength: %s", paramInt1);
/* 342 */     D.a((paramInt2 >= 0), "Invalid padding: %s", paramInt2);
/* 343 */     return (paramArrayOfdouble.length < paramInt1) ? Arrays.copyOf(paramArrayOfdouble, paramInt1 + paramInt2) : paramArrayOfdouble;
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
/*     */   public static String a(String paramString, double... paramVarArgs) {
/* 359 */     D.checkNotNull(paramString);
/* 360 */     if (paramVarArgs.length == 0) {
/* 361 */       return "";
/*     */     }
/*     */ 
/*     */     
/* 365 */     StringBuilder stringBuilder = new StringBuilder(paramVarArgs.length * 12);
/* 366 */     stringBuilder.append(paramVarArgs[0]);
/* 367 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 368 */       stringBuilder.append(paramString).append(paramVarArgs[b]);
/*     */     }
/* 370 */     return stringBuilder.toString();
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
/*     */   public static Comparator<double[]> g() {
/* 387 */     return (Comparator<double[]>)c.a;
/*     */   }
/*     */   
/*     */   private enum c implements Comparator<double[]> {
/* 391 */     a;
/*     */ 
/*     */     
/*     */     public int b(double[] param1ArrayOfdouble1, double[] param1ArrayOfdouble2) {
/* 395 */       int i = Math.min(param1ArrayOfdouble1.length, param1ArrayOfdouble2.length);
/* 396 */       for (byte b = 0; b < i; b++) {
/* 397 */         int j = Double.compare(param1ArrayOfdouble1[b], param1ArrayOfdouble2[b]);
/* 398 */         if (j != 0) {
/* 399 */           return j;
/*     */         }
/*     */       } 
/* 402 */       return param1ArrayOfdouble1.length - param1ArrayOfdouble2.length;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 407 */       return "Doubles.lexicographicalComparator()";
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
/*     */   public static void b(double[] paramArrayOfdouble) {
/* 420 */     D.checkNotNull(paramArrayOfdouble);
/* 421 */     b(paramArrayOfdouble, 0, paramArrayOfdouble.length);
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
/*     */   public static void b(double[] paramArrayOfdouble, int paramInt1, int paramInt2) {
/* 434 */     D.checkNotNull(paramArrayOfdouble);
/* 435 */     D.a(paramInt1, paramInt2, paramArrayOfdouble.length);
/* 436 */     Arrays.sort(paramArrayOfdouble, paramInt1, paramInt2);
/* 437 */     reverse(paramArrayOfdouble, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void reverse(double[] paramArrayOfdouble) {
/* 447 */     D.checkNotNull(paramArrayOfdouble);
/* 448 */     reverse(paramArrayOfdouble, 0, paramArrayOfdouble.length);
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
/*     */   public static void reverse(double[] paramArrayOfdouble, int paramInt1, int paramInt2) {
/* 462 */     D.checkNotNull(paramArrayOfdouble);
/* 463 */     D.a(paramInt1, paramInt2, paramArrayOfdouble.length);
/* 464 */     for (int i = paramInt1, j = paramInt2 - 1; i < j; i++, j--) {
/* 465 */       double d1 = paramArrayOfdouble[i];
/* 466 */       paramArrayOfdouble[i] = paramArrayOfdouble[j];
/* 467 */       paramArrayOfdouble[j] = d1;
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
/*     */   public static double[] a(Collection<? extends Number> paramCollection) {
/* 485 */     if (paramCollection instanceof a) {
/* 486 */       return ((a)paramCollection).a();
/*     */     }
/*     */     
/* 489 */     Object[] arrayOfObject = paramCollection.toArray();
/* 490 */     int i = arrayOfObject.length;
/* 491 */     double[] arrayOfDouble = new double[i];
/* 492 */     for (byte b = 0; b < i; b++)
/*     */     {
/* 494 */       arrayOfDouble[b] = ((Number)D.checkNotNull(arrayOfObject[b])).doubleValue();
/*     */     }
/* 496 */     return arrayOfDouble;
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
/*     */   public static List<Double> a(double... paramVarArgs) {
/* 518 */     if (paramVarArgs.length == 0) {
/* 519 */       return Collections.emptyList();
/*     */     }
/* 521 */     return new a(paramVarArgs);
/*     */   }
/*     */   
/*     */   @b
/*     */   private static class a extends AbstractList<Double> implements Serializable, RandomAccess {
/*     */     final double[] b;
/*     */     final int start;
/*     */     final int end;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     a(double[] param1ArrayOfdouble) {
/* 532 */       this(param1ArrayOfdouble, 0, param1ArrayOfdouble.length);
/*     */     }
/*     */     
/*     */     a(double[] param1ArrayOfdouble, int param1Int1, int param1Int2) {
/* 536 */       this.b = param1ArrayOfdouble;
/* 537 */       this.start = param1Int1;
/* 538 */       this.end = param1Int2;
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 543 */       return this.end - this.start;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isEmpty() {
/* 548 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public Double a(int param1Int) {
/* 553 */       D.b(param1Int, size());
/* 554 */       return Double.valueOf(this.b[this.start + param1Int]);
/*     */     }
/*     */ 
/*     */     
/*     */     public Spliterator.OfDouble a() {
/* 559 */       return Spliterators.spliterator(this.b, this.start, this.end, 0);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 565 */       return (param1Object instanceof Double && 
/* 566 */         d.c(this.b, ((Double)param1Object).doubleValue(), this.start, this.end) != -1);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int indexOf(Object param1Object) {
/* 572 */       if (param1Object instanceof Double) {
/* 573 */         int i = d.c(this.b, ((Double)param1Object).doubleValue(), this.start, this.end);
/* 574 */         if (i >= 0) {
/* 575 */           return i - this.start;
/*     */         }
/*     */       } 
/* 578 */       return -1;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int lastIndexOf(Object param1Object) {
/* 584 */       if (param1Object instanceof Double) {
/* 585 */         int i = d.d(this.b, ((Double)param1Object).doubleValue(), this.start, this.end);
/* 586 */         if (i >= 0) {
/* 587 */           return i - this.start;
/*     */         }
/*     */       } 
/* 590 */       return -1;
/*     */     }
/*     */ 
/*     */     
/*     */     public Double a(int param1Int, Double param1Double) {
/* 595 */       D.b(param1Int, size());
/* 596 */       double d = this.b[this.start + param1Int];
/*     */       
/* 598 */       this.b[this.start + param1Int] = ((Double)D.checkNotNull(param1Double)).doubleValue();
/* 599 */       return Double.valueOf(d);
/*     */     }
/*     */ 
/*     */     
/*     */     public List<Double> subList(int param1Int1, int param1Int2) {
/* 604 */       int i = size();
/* 605 */       D.a(param1Int1, param1Int2, i);
/* 606 */       if (param1Int1 == param1Int2) {
/* 607 */         return Collections.emptyList();
/*     */       }
/* 609 */       return new a(this.b, this.start + param1Int1, this.start + param1Int2);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 614 */       if (param1Object == this) {
/* 615 */         return true;
/*     */       }
/* 617 */       if (param1Object instanceof a) {
/* 618 */         a a1 = (a)param1Object;
/* 619 */         int i = size();
/* 620 */         if (a1.size() != i) {
/* 621 */           return false;
/*     */         }
/* 623 */         for (byte b = 0; b < i; b++) {
/* 624 */           if (this.b[this.start + b] != a1.b[a1.start + b]) {
/* 625 */             return false;
/*     */           }
/*     */         } 
/* 628 */         return true;
/*     */       } 
/* 630 */       return super.equals(param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 635 */       int i = 1;
/* 636 */       for (int j = this.start; j < this.end; j++) {
/* 637 */         i = 31 * i + d.b(this.b[j]);
/*     */       }
/* 639 */       return i;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 644 */       StringBuilder stringBuilder = new StringBuilder(size() * 12);
/* 645 */       stringBuilder.append('[').append(this.b[this.start]);
/* 646 */       for (int i = this.start + 1; i < this.end; i++) {
/* 647 */         stringBuilder.append(", ").append(this.b[i]);
/*     */       }
/* 649 */       return stringBuilder.append(']').toString();
/*     */     }
/*     */     
/*     */     double[] a() {
/* 653 */       return Arrays.copyOfRange(this.b, this.start, this.end);
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
/*     */   @com.google.a.a.c
/* 667 */   static final Pattern a = a();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.a.a.c
/*     */   private static Pattern a() {
/* 678 */     String str1 = "(?:\\d+#(?:\\.\\d*#)?|\\.\\d+#)";
/* 679 */     String str2 = String.valueOf(str1).concat("(?:[eE][+-]?\\d+#)?[fFdD]?");
/* 680 */     String str3 = "(?:[0-9a-fA-F]+#(?:\\.[0-9a-fA-F]*#)?|\\.[0-9a-fA-F]+#)";
/* 681 */     String str4 = (new StringBuilder(25 + String.valueOf(str3).length())).append("0[xX]").append(str3).append("[pP][+-]?\\d+#[fFdD]?").toString();
/* 682 */     String str5 = (new StringBuilder(23 + String.valueOf(str2).length() + String.valueOf(str4).length())).append("[+-]?(?:NaN|Infinity|").append(str2).append("|").append(str4).append(")").toString();
/*     */     
/* 684 */     str5 = str5.replace("#", "+");
/*     */ 
/*     */ 
/*     */     
/* 688 */     return 
/*     */       
/* 690 */       Pattern.compile(str5);
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
/*     */   @com.google.a.a.c
/*     */   public static Double b(String paramString) {
/* 713 */     if (a.matcher(paramString).matches()) {
/*     */       
/*     */       try {
/*     */         
/* 717 */         return Double.valueOf(Double.parseDouble(paramString));
/* 718 */       } catch (NumberFormatException numberFormatException) {}
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 723 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\m\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */