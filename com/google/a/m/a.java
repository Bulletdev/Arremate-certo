/*     */ package com.google.a.m;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
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
/*     */ @b
/*     */ public final class a
/*     */ {
/*     */   private enum b
/*     */     implements Comparator<Boolean>
/*     */   {
/*  50 */     a(1, "Booleans.trueFirst()"),
/*  51 */     b(-1, "Booleans.falseFirst()");
/*     */     
/*     */     private final int gk;
/*     */     private final String toString;
/*     */     
/*     */     b(int param1Int1, String param1String1) {
/*  57 */       this.gk = param1Int1;
/*  58 */       this.toString = param1String1;
/*     */     }
/*     */ 
/*     */     
/*     */     public int compare(Boolean param1Boolean1, Boolean param1Boolean2) {
/*  63 */       byte b1 = param1Boolean1.booleanValue() ? this.gk : 0;
/*  64 */       byte b2 = param1Boolean2.booleanValue() ? this.gk : 0;
/*  65 */       return b2 - b1;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/*  70 */       return this.toString;
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
/*     */   public static Comparator<Boolean> e() {
/*  84 */     return (Comparator<Boolean>)b.a;
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
/*     */   public static Comparator<Boolean> f() {
/*  97 */     return b.b;
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
/*     */   public static int a(boolean paramBoolean) {
/* 110 */     return paramBoolean ? 1231 : 1237;
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
/*     */   public static int compare(boolean paramBoolean1, boolean paramBoolean2) {
/* 127 */     return (paramBoolean1 == paramBoolean2) ? 0 : (paramBoolean1 ? 1 : -1);
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
/*     */   public static boolean contains(boolean[] paramArrayOfboolean, boolean paramBoolean) {
/* 142 */     for (boolean bool : paramArrayOfboolean) {
/* 143 */       if (bool == paramBoolean) {
/* 144 */         return true;
/*     */       }
/*     */     } 
/* 147 */     return false;
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
/*     */   public static int indexOf(boolean[] paramArrayOfboolean, boolean paramBoolean) {
/* 162 */     return a(paramArrayOfboolean, paramBoolean, 0, paramArrayOfboolean.length);
/*     */   }
/*     */ 
/*     */   
/*     */   private static int a(boolean[] paramArrayOfboolean, boolean paramBoolean, int paramInt1, int paramInt2) {
/* 167 */     for (int i = paramInt1; i < paramInt2; i++) {
/* 168 */       if (paramArrayOfboolean[i] == paramBoolean) {
/* 169 */         return i;
/*     */       }
/*     */     } 
/* 172 */     return -1;
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
/*     */   public static int a(boolean[] paramArrayOfboolean1, boolean[] paramArrayOfboolean2) {
/* 186 */     D.b(paramArrayOfboolean1, "array");
/* 187 */     D.b(paramArrayOfboolean2, "target");
/* 188 */     if (paramArrayOfboolean2.length == 0) {
/* 189 */       return 0;
/*     */     }
/*     */ 
/*     */     
/* 193 */     for (byte b = 0; b < paramArrayOfboolean1.length - paramArrayOfboolean2.length + 1; b++) {
/* 194 */       byte b1 = 0; while (true) { if (b1 < paramArrayOfboolean2.length) {
/* 195 */           if (paramArrayOfboolean1[b + b1] != paramArrayOfboolean2[b1])
/*     */             break;  b1++;
/*     */           continue;
/*     */         } 
/* 199 */         return b; }
/*     */     
/* 201 */     }  return -1;
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
/*     */   public static int lastIndexOf(boolean[] paramArrayOfboolean, boolean paramBoolean) {
/* 213 */     return b(paramArrayOfboolean, paramBoolean, 0, paramArrayOfboolean.length);
/*     */   }
/*     */ 
/*     */   
/*     */   private static int b(boolean[] paramArrayOfboolean, boolean paramBoolean, int paramInt1, int paramInt2) {
/* 218 */     for (int i = paramInt2 - 1; i >= paramInt1; i--) {
/* 219 */       if (paramArrayOfboolean[i] == paramBoolean) {
/* 220 */         return i;
/*     */       }
/*     */     } 
/* 223 */     return -1;
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
/*     */   public static boolean[] a(boolean[]... paramVarArgs) {
/* 235 */     int i = 0;
/* 236 */     for (boolean[] arrayOfBoolean1 : paramVarArgs) {
/* 237 */       i += arrayOfBoolean1.length;
/*     */     }
/* 239 */     boolean[] arrayOfBoolean = new boolean[i];
/* 240 */     int j = 0;
/* 241 */     for (boolean[] arrayOfBoolean1 : paramVarArgs) {
/* 242 */       System.arraycopy(arrayOfBoolean1, 0, arrayOfBoolean, j, arrayOfBoolean1.length);
/* 243 */       j += arrayOfBoolean1.length;
/*     */     } 
/* 245 */     return arrayOfBoolean;
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
/*     */   public static boolean[] a(boolean[] paramArrayOfboolean, int paramInt1, int paramInt2) {
/* 262 */     D.a((paramInt1 >= 0), "Invalid minLength: %s", paramInt1);
/* 263 */     D.a((paramInt2 >= 0), "Invalid padding: %s", paramInt2);
/* 264 */     return (paramArrayOfboolean.length < paramInt1) ? Arrays.copyOf(paramArrayOfboolean, paramInt1 + paramInt2) : paramArrayOfboolean;
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
/*     */   public static String a(String paramString, boolean... paramVarArgs) {
/* 277 */     D.checkNotNull(paramString);
/* 278 */     if (paramVarArgs.length == 0) {
/* 279 */       return "";
/*     */     }
/*     */ 
/*     */     
/* 283 */     StringBuilder stringBuilder = new StringBuilder(paramVarArgs.length * 7);
/* 284 */     stringBuilder.append(paramVarArgs[0]);
/* 285 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 286 */       stringBuilder.append(paramString).append(paramVarArgs[b]);
/*     */     }
/* 288 */     return stringBuilder.toString();
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
/*     */   public static Comparator<boolean[]> g() {
/* 305 */     return (Comparator<boolean[]>)c.a;
/*     */   }
/*     */   
/*     */   private enum c implements Comparator<boolean[]> {
/* 309 */     a;
/*     */ 
/*     */     
/*     */     public int b(boolean[] param1ArrayOfboolean1, boolean[] param1ArrayOfboolean2) {
/* 313 */       int i = Math.min(param1ArrayOfboolean1.length, param1ArrayOfboolean2.length);
/* 314 */       for (byte b = 0; b < i; b++) {
/* 315 */         int j = a.compare(param1ArrayOfboolean1[b], param1ArrayOfboolean2[b]);
/* 316 */         if (j != 0) {
/* 317 */           return j;
/*     */         }
/*     */       } 
/* 320 */       return param1ArrayOfboolean1.length - param1ArrayOfboolean2.length;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 325 */       return "Booleans.lexicographicalComparator()";
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
/*     */   public static boolean[] a(Collection<Boolean> paramCollection) {
/* 344 */     if (paramCollection instanceof a) {
/* 345 */       return ((a)paramCollection).a();
/*     */     }
/*     */     
/* 348 */     Object[] arrayOfObject = paramCollection.toArray();
/* 349 */     int i = arrayOfObject.length;
/* 350 */     boolean[] arrayOfBoolean = new boolean[i];
/* 351 */     for (byte b = 0; b < i; b++)
/*     */     {
/* 353 */       arrayOfBoolean[b] = ((Boolean)D.checkNotNull(arrayOfObject[b])).booleanValue();
/*     */     }
/* 355 */     return arrayOfBoolean;
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
/*     */   public static List<Boolean> a(boolean... paramVarArgs) {
/* 371 */     if (paramVarArgs.length == 0) {
/* 372 */       return Collections.emptyList();
/*     */     }
/* 374 */     return new a(paramVarArgs);
/*     */   }
/*     */   
/*     */   @b
/*     */   private static class a extends AbstractList<Boolean> implements Serializable, RandomAccess {
/*     */     final boolean[] d;
/*     */     final int start;
/*     */     final int end;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     a(boolean[] param1ArrayOfboolean) {
/* 385 */       this(param1ArrayOfboolean, 0, param1ArrayOfboolean.length);
/*     */     }
/*     */     
/*     */     a(boolean[] param1ArrayOfboolean, int param1Int1, int param1Int2) {
/* 389 */       this.d = param1ArrayOfboolean;
/* 390 */       this.start = param1Int1;
/* 391 */       this.end = param1Int2;
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 396 */       return this.end - this.start;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isEmpty() {
/* 401 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public Boolean a(int param1Int) {
/* 406 */       D.b(param1Int, size());
/* 407 */       return Boolean.valueOf(this.d[this.start + param1Int]);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 413 */       return (param1Object instanceof Boolean && 
/* 414 */         a.c(this.d, ((Boolean)param1Object).booleanValue(), this.start, this.end) != -1);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int indexOf(Object param1Object) {
/* 420 */       if (param1Object instanceof Boolean) {
/* 421 */         int i = a.c(this.d, ((Boolean)param1Object).booleanValue(), this.start, this.end);
/* 422 */         if (i >= 0) {
/* 423 */           return i - this.start;
/*     */         }
/*     */       } 
/* 426 */       return -1;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int lastIndexOf(Object param1Object) {
/* 432 */       if (param1Object instanceof Boolean) {
/* 433 */         int i = a.d(this.d, ((Boolean)param1Object).booleanValue(), this.start, this.end);
/* 434 */         if (i >= 0) {
/* 435 */           return i - this.start;
/*     */         }
/*     */       } 
/* 438 */       return -1;
/*     */     }
/*     */ 
/*     */     
/*     */     public Boolean a(int param1Int, Boolean param1Boolean) {
/* 443 */       D.b(param1Int, size());
/* 444 */       boolean bool = this.d[this.start + param1Int];
/*     */       
/* 446 */       this.d[this.start + param1Int] = ((Boolean)D.checkNotNull(param1Boolean)).booleanValue();
/* 447 */       return Boolean.valueOf(bool);
/*     */     }
/*     */ 
/*     */     
/*     */     public List<Boolean> subList(int param1Int1, int param1Int2) {
/* 452 */       int i = size();
/* 453 */       D.a(param1Int1, param1Int2, i);
/* 454 */       if (param1Int1 == param1Int2) {
/* 455 */         return Collections.emptyList();
/*     */       }
/* 457 */       return new a(this.d, this.start + param1Int1, this.start + param1Int2);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 462 */       if (param1Object == this) {
/* 463 */         return true;
/*     */       }
/* 465 */       if (param1Object instanceof a) {
/* 466 */         a a1 = (a)param1Object;
/* 467 */         int i = size();
/* 468 */         if (a1.size() != i) {
/* 469 */           return false;
/*     */         }
/* 471 */         for (byte b = 0; b < i; b++) {
/* 472 */           if (this.d[this.start + b] != a1.d[a1.start + b]) {
/* 473 */             return false;
/*     */           }
/*     */         } 
/* 476 */         return true;
/*     */       } 
/* 478 */       return super.equals(param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 483 */       int i = 1;
/* 484 */       for (int j = this.start; j < this.end; j++) {
/* 485 */         i = 31 * i + a.a(this.d[j]);
/*     */       }
/* 487 */       return i;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 492 */       StringBuilder stringBuilder = new StringBuilder(size() * 7);
/* 493 */       stringBuilder.append(this.d[this.start] ? "[true" : "[false");
/* 494 */       for (int i = this.start + 1; i < this.end; i++) {
/* 495 */         stringBuilder.append(this.d[i] ? ", true" : ", false");
/*     */       }
/* 497 */       return stringBuilder.append(']').toString();
/*     */     }
/*     */     
/*     */     boolean[] a() {
/* 501 */       return Arrays.copyOfRange(this.d, this.start, this.end);
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
/*     */   @com.google.a.a.a
/*     */   public static int a(boolean... paramVarArgs) {
/* 514 */     byte b = 0;
/* 515 */     for (boolean bool : paramVarArgs) {
/* 516 */       if (bool) {
/* 517 */         b++;
/*     */       }
/*     */     } 
/* 520 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void reverse(boolean[] paramArrayOfboolean) {
/* 530 */     D.checkNotNull(paramArrayOfboolean);
/* 531 */     reverse(paramArrayOfboolean, 0, paramArrayOfboolean.length);
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
/*     */   public static void reverse(boolean[] paramArrayOfboolean, int paramInt1, int paramInt2) {
/* 545 */     D.checkNotNull(paramArrayOfboolean);
/* 546 */     D.a(paramInt1, paramInt2, paramArrayOfboolean.length);
/* 547 */     for (int i = paramInt1, j = paramInt2 - 1; i < j; i++, j--) {
/* 548 */       boolean bool = paramArrayOfboolean[i];
/* 549 */       paramArrayOfboolean[i] = paramArrayOfboolean[j];
/* 550 */       paramArrayOfboolean[j] = bool;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\m\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */