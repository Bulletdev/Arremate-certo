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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class f
/*     */   extends g
/*     */ {
/*     */   public static final int BYTES = 4;
/*     */   
/*     */   public static int a(float paramFloat) {
/*  73 */     return Float.valueOf(paramFloat).hashCode();
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
/*     */   public static int compare(float paramFloat1, float paramFloat2) {
/*  90 */     return Float.compare(paramFloat1, paramFloat2);
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
/*     */   public static boolean a(float paramFloat) {
/* 102 */     return (Float.NEGATIVE_INFINITY < paramFloat && paramFloat < Float.POSITIVE_INFINITY);
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
/*     */   public static boolean contains(float[] paramArrayOffloat, float paramFloat) {
/* 114 */     for (float f1 : paramArrayOffloat) {
/* 115 */       if (f1 == paramFloat) {
/* 116 */         return true;
/*     */       }
/*     */     } 
/* 119 */     return false;
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
/*     */   public static int indexOf(float[] paramArrayOffloat, float paramFloat) {
/* 132 */     return a(paramArrayOffloat, paramFloat, 0, paramArrayOffloat.length);
/*     */   }
/*     */ 
/*     */   
/*     */   private static int a(float[] paramArrayOffloat, float paramFloat, int paramInt1, int paramInt2) {
/* 137 */     for (int i = paramInt1; i < paramInt2; i++) {
/* 138 */       if (paramArrayOffloat[i] == paramFloat) {
/* 139 */         return i;
/*     */       }
/*     */     } 
/* 142 */     return -1;
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
/*     */   public static int a(float[] paramArrayOffloat1, float[] paramArrayOffloat2) {
/* 158 */     D.b(paramArrayOffloat1, "array");
/* 159 */     D.b(paramArrayOffloat2, "target");
/* 160 */     if (paramArrayOffloat2.length == 0) {
/* 161 */       return 0;
/*     */     }
/*     */ 
/*     */     
/* 165 */     for (byte b = 0; b < paramArrayOffloat1.length - paramArrayOffloat2.length + 1; b++) {
/* 166 */       byte b1 = 0; while (true) { if (b1 < paramArrayOffloat2.length) {
/* 167 */           if (paramArrayOffloat1[b + b1] != paramArrayOffloat2[b1])
/*     */             break;  b1++;
/*     */           continue;
/*     */         } 
/* 171 */         return b; }
/*     */     
/* 173 */     }  return -1;
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
/*     */   public static int lastIndexOf(float[] paramArrayOffloat, float paramFloat) {
/* 186 */     return b(paramArrayOffloat, paramFloat, 0, paramArrayOffloat.length);
/*     */   }
/*     */ 
/*     */   
/*     */   private static int b(float[] paramArrayOffloat, float paramFloat, int paramInt1, int paramInt2) {
/* 191 */     for (int i = paramInt2 - 1; i >= paramInt1; i--) {
/* 192 */       if (paramArrayOffloat[i] == paramFloat) {
/* 193 */         return i;
/*     */       }
/*     */     } 
/* 196 */     return -1;
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
/*     */   public static float min(float... paramVarArgs) {
/* 211 */     D.checkArgument((paramVarArgs.length > 0));
/* 212 */     float f1 = paramVarArgs[0];
/* 213 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 214 */       f1 = Math.min(f1, paramVarArgs[b]);
/*     */     }
/* 216 */     return f1;
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
/*     */   public static float max(float... paramVarArgs) {
/* 231 */     D.checkArgument((paramVarArgs.length > 0));
/* 232 */     float f1 = paramVarArgs[0];
/* 233 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 234 */       f1 = Math.max(f1, paramVarArgs[b]);
/*     */     }
/* 236 */     return f1;
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
/*     */   public static float a(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 256 */     if (paramFloat2 <= paramFloat3) {
/* 257 */       return Math.min(Math.max(paramFloat1, paramFloat2), paramFloat3);
/*     */     }
/* 259 */     throw new IllegalArgumentException(
/* 260 */         L.a("min (%s) must be less than or equal to max (%s)", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) }));
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
/*     */   public static float[] a(float[]... paramVarArgs) {
/* 272 */     int i = 0;
/* 273 */     for (float[] arrayOfFloat1 : paramVarArgs) {
/* 274 */       i += arrayOfFloat1.length;
/*     */     }
/* 276 */     float[] arrayOfFloat = new float[i];
/* 277 */     int j = 0;
/* 278 */     for (float[] arrayOfFloat1 : paramVarArgs) {
/* 279 */       System.arraycopy(arrayOfFloat1, 0, arrayOfFloat, j, arrayOfFloat1.length);
/* 280 */       j += arrayOfFloat1.length;
/*     */     } 
/* 282 */     return arrayOfFloat;
/*     */   }
/*     */   
/*     */   private static final class b
/*     */     extends i<String, Float> implements Serializable {
/* 287 */     static final b a = new b();
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     protected Float b(String param1String) {
/* 291 */       return Float.valueOf(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     protected String a(Float param1Float) {
/* 296 */       return param1Float.toString();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 301 */       return "Floats.stringConverter()";
/*     */     }
/*     */     
/*     */     private Object readResolve() {
/* 305 */       return a;
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
/*     */   public static i<String, Float> c() {
/* 319 */     return b.a;
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
/*     */   public static float[] a(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/* 336 */     D.a((paramInt1 >= 0), "Invalid minLength: %s", paramInt1);
/* 337 */     D.a((paramInt2 >= 0), "Invalid padding: %s", paramInt2);
/* 338 */     return (paramArrayOffloat.length < paramInt1) ? Arrays.copyOf(paramArrayOffloat, paramInt1 + paramInt2) : paramArrayOffloat;
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
/*     */   public static String a(String paramString, float... paramVarArgs) {
/* 354 */     D.checkNotNull(paramString);
/* 355 */     if (paramVarArgs.length == 0) {
/* 356 */       return "";
/*     */     }
/*     */ 
/*     */     
/* 360 */     StringBuilder stringBuilder = new StringBuilder(paramVarArgs.length * 12);
/* 361 */     stringBuilder.append(paramVarArgs[0]);
/* 362 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 363 */       stringBuilder.append(paramString).append(paramVarArgs[b]);
/*     */     }
/* 365 */     return stringBuilder.toString();
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
/*     */   public static Comparator<float[]> g() {
/* 382 */     return (Comparator<float[]>)c.a;
/*     */   }
/*     */   
/*     */   private enum c implements Comparator<float[]> {
/* 386 */     a;
/*     */ 
/*     */     
/*     */     public int b(float[] param1ArrayOffloat1, float[] param1ArrayOffloat2) {
/* 390 */       int i = Math.min(param1ArrayOffloat1.length, param1ArrayOffloat2.length);
/* 391 */       for (byte b = 0; b < i; b++) {
/* 392 */         int j = Float.compare(param1ArrayOffloat1[b], param1ArrayOffloat2[b]);
/* 393 */         if (j != 0) {
/* 394 */           return j;
/*     */         }
/*     */       } 
/* 397 */       return param1ArrayOffloat1.length - param1ArrayOffloat2.length;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 402 */       return "Floats.lexicographicalComparator()";
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
/*     */   public static void a(float[] paramArrayOffloat) {
/* 415 */     D.checkNotNull(paramArrayOffloat);
/* 416 */     a(paramArrayOffloat, 0, paramArrayOffloat.length);
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
/*     */   public static void a(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/* 429 */     D.checkNotNull(paramArrayOffloat);
/* 430 */     D.a(paramInt1, paramInt2, paramArrayOffloat.length);
/* 431 */     Arrays.sort(paramArrayOffloat, paramInt1, paramInt2);
/* 432 */     reverse(paramArrayOffloat, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void reverse(float[] paramArrayOffloat) {
/* 442 */     D.checkNotNull(paramArrayOffloat);
/* 443 */     reverse(paramArrayOffloat, 0, paramArrayOffloat.length);
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
/*     */   public static void reverse(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/* 457 */     D.checkNotNull(paramArrayOffloat);
/* 458 */     D.a(paramInt1, paramInt2, paramArrayOffloat.length);
/* 459 */     for (int i = paramInt1, j = paramInt2 - 1; i < j; i++, j--) {
/* 460 */       float f1 = paramArrayOffloat[i];
/* 461 */       paramArrayOffloat[i] = paramArrayOffloat[j];
/* 462 */       paramArrayOffloat[j] = f1;
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
/*     */   public static float[] a(Collection<? extends Number> paramCollection) {
/* 480 */     if (paramCollection instanceof a) {
/* 481 */       return ((a)paramCollection).a();
/*     */     }
/*     */     
/* 484 */     Object[] arrayOfObject = paramCollection.toArray();
/* 485 */     int i = arrayOfObject.length;
/* 486 */     float[] arrayOfFloat = new float[i];
/* 487 */     for (byte b = 0; b < i; b++)
/*     */     {
/* 489 */       arrayOfFloat[b] = ((Number)D.checkNotNull(arrayOfObject[b])).floatValue();
/*     */     }
/* 491 */     return arrayOfFloat;
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
/*     */   public static List<Float> a(float... paramVarArgs) {
/* 510 */     if (paramVarArgs.length == 0) {
/* 511 */       return Collections.emptyList();
/*     */     }
/* 513 */     return new a(paramVarArgs);
/*     */   }
/*     */   
/*     */   @b
/*     */   private static class a extends AbstractList<Float> implements Serializable, RandomAccess {
/*     */     final float[] a;
/*     */     final int start;
/*     */     final int end;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     a(float[] param1ArrayOffloat) {
/* 524 */       this(param1ArrayOffloat, 0, param1ArrayOffloat.length);
/*     */     }
/*     */     
/*     */     a(float[] param1ArrayOffloat, int param1Int1, int param1Int2) {
/* 528 */       this.a = param1ArrayOffloat;
/* 529 */       this.start = param1Int1;
/* 530 */       this.end = param1Int2;
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 535 */       return this.end - this.start;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isEmpty() {
/* 540 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public Float a(int param1Int) {
/* 545 */       D.b(param1Int, size());
/* 546 */       return Float.valueOf(this.a[this.start + param1Int]);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 552 */       return (param1Object instanceof Float && f.c(this.a, ((Float)param1Object).floatValue(), this.start, this.end) != -1);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int indexOf(Object param1Object) {
/* 558 */       if (param1Object instanceof Float) {
/* 559 */         int i = f.c(this.a, ((Float)param1Object).floatValue(), this.start, this.end);
/* 560 */         if (i >= 0) {
/* 561 */           return i - this.start;
/*     */         }
/*     */       } 
/* 564 */       return -1;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int lastIndexOf(Object param1Object) {
/* 570 */       if (param1Object instanceof Float) {
/* 571 */         int i = f.d(this.a, ((Float)param1Object).floatValue(), this.start, this.end);
/* 572 */         if (i >= 0) {
/* 573 */           return i - this.start;
/*     */         }
/*     */       } 
/* 576 */       return -1;
/*     */     }
/*     */ 
/*     */     
/*     */     public Float a(int param1Int, Float param1Float) {
/* 581 */       D.b(param1Int, size());
/* 582 */       float f = this.a[this.start + param1Int];
/*     */       
/* 584 */       this.a[this.start + param1Int] = ((Float)D.checkNotNull(param1Float)).floatValue();
/* 585 */       return Float.valueOf(f);
/*     */     }
/*     */ 
/*     */     
/*     */     public List<Float> subList(int param1Int1, int param1Int2) {
/* 590 */       int i = size();
/* 591 */       D.a(param1Int1, param1Int2, i);
/* 592 */       if (param1Int1 == param1Int2) {
/* 593 */         return Collections.emptyList();
/*     */       }
/* 595 */       return new a(this.a, this.start + param1Int1, this.start + param1Int2);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 600 */       if (param1Object == this) {
/* 601 */         return true;
/*     */       }
/* 603 */       if (param1Object instanceof a) {
/* 604 */         a a1 = (a)param1Object;
/* 605 */         int i = size();
/* 606 */         if (a1.size() != i) {
/* 607 */           return false;
/*     */         }
/* 609 */         for (byte b = 0; b < i; b++) {
/* 610 */           if (this.a[this.start + b] != a1.a[a1.start + b]) {
/* 611 */             return false;
/*     */           }
/*     */         } 
/* 614 */         return true;
/*     */       } 
/* 616 */       return super.equals(param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 621 */       int i = 1;
/* 622 */       for (int j = this.start; j < this.end; j++) {
/* 623 */         i = 31 * i + f.a(this.a[j]);
/*     */       }
/* 625 */       return i;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 630 */       StringBuilder stringBuilder = new StringBuilder(size() * 12);
/* 631 */       stringBuilder.append('[').append(this.a[this.start]);
/* 632 */       for (int i = this.start + 1; i < this.end; i++) {
/* 633 */         stringBuilder.append(", ").append(this.a[i]);
/*     */       }
/* 635 */       return stringBuilder.append(']').toString();
/*     */     }
/*     */     
/*     */     float[] a() {
/* 639 */       return Arrays.copyOfRange(this.a, this.start, this.end);
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
/*     */   @com.google.a.a.c
/*     */   public static Float a(String paramString) {
/* 665 */     if (d.a.matcher(paramString).matches()) {
/*     */       
/*     */       try {
/*     */         
/* 669 */         return Float.valueOf(Float.parseFloat(paramString));
/* 670 */       } catch (NumberFormatException numberFormatException) {}
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 675 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\m\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */