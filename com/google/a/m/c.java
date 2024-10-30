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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class c
/*     */ {
/*     */   public static final int BYTES = 2;
/*     */   
/*     */   public static int c(char paramChar) {
/*  69 */     return paramChar;
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
/*     */   public static char a(long paramLong) {
/*  81 */     char c1 = (char)(int)paramLong;
/*  82 */     D.a((c1 == paramLong), "Out of range: %s", paramLong);
/*  83 */     return c1;
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
/*     */   public static char b(long paramLong) {
/*  95 */     if (paramLong > 65535L) {
/*  96 */       return Character.MAX_VALUE;
/*     */     }
/*  98 */     if (paramLong < 0L) {
/*  99 */       return Character.MIN_VALUE;
/*     */     }
/* 101 */     return (char)(int)paramLong;
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
/*     */   public static int compare(char paramChar1, char paramChar2) {
/* 117 */     return paramChar1 - paramChar2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean contains(char[] paramArrayOfchar, char paramChar) {
/* 128 */     for (char c1 : paramArrayOfchar) {
/* 129 */       if (c1 == paramChar) {
/* 130 */         return true;
/*     */       }
/*     */     } 
/* 133 */     return false;
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
/*     */   public static int indexOf(char[] paramArrayOfchar, char paramChar) {
/* 145 */     return a(paramArrayOfchar, paramChar, 0, paramArrayOfchar.length);
/*     */   }
/*     */ 
/*     */   
/*     */   private static int a(char[] paramArrayOfchar, char paramChar, int paramInt1, int paramInt2) {
/* 150 */     for (int i = paramInt1; i < paramInt2; i++) {
/* 151 */       if (paramArrayOfchar[i] == paramChar) {
/* 152 */         return i;
/*     */       }
/*     */     } 
/* 155 */     return -1;
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
/*     */   public static int a(char[] paramArrayOfchar1, char[] paramArrayOfchar2) {
/* 169 */     D.b(paramArrayOfchar1, "array");
/* 170 */     D.b(paramArrayOfchar2, "target");
/* 171 */     if (paramArrayOfchar2.length == 0) {
/* 172 */       return 0;
/*     */     }
/*     */ 
/*     */     
/* 176 */     for (byte b = 0; b < paramArrayOfchar1.length - paramArrayOfchar2.length + 1; b++) {
/* 177 */       byte b1 = 0; while (true) { if (b1 < paramArrayOfchar2.length) {
/* 178 */           if (paramArrayOfchar1[b + b1] != paramArrayOfchar2[b1])
/*     */             break;  b1++;
/*     */           continue;
/*     */         } 
/* 182 */         return b; }
/*     */     
/* 184 */     }  return -1;
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
/*     */   public static int lastIndexOf(char[] paramArrayOfchar, char paramChar) {
/* 196 */     return b(paramArrayOfchar, paramChar, 0, paramArrayOfchar.length);
/*     */   }
/*     */ 
/*     */   
/*     */   private static int b(char[] paramArrayOfchar, char paramChar, int paramInt1, int paramInt2) {
/* 201 */     for (int i = paramInt2 - 1; i >= paramInt1; i--) {
/* 202 */       if (paramArrayOfchar[i] == paramChar) {
/* 203 */         return i;
/*     */       }
/*     */     } 
/* 206 */     return -1;
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
/*     */   public static char a(char... paramVarArgs) {
/* 218 */     D.checkArgument((paramVarArgs.length > 0));
/* 219 */     char c1 = paramVarArgs[0];
/* 220 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 221 */       if (paramVarArgs[b] < c1) {
/* 222 */         c1 = paramVarArgs[b];
/*     */       }
/*     */     } 
/* 225 */     return c1;
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
/*     */   public static char b(char... paramVarArgs) {
/* 237 */     D.checkArgument((paramVarArgs.length > 0));
/* 238 */     char c1 = paramVarArgs[0];
/* 239 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 240 */       if (paramVarArgs[b] > c1) {
/* 241 */         c1 = paramVarArgs[b];
/*     */       }
/*     */     } 
/* 244 */     return c1;
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
/*     */   public static char a(char paramChar1, char paramChar2, char paramChar3) {
/* 262 */     D.a((paramChar2 <= paramChar3), "min (%s) must be less than or equal to max (%s)", paramChar2, paramChar3);
/* 263 */     return (paramChar1 < paramChar2) ? paramChar2 : ((paramChar1 < paramChar3) ? paramChar1 : paramChar3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static char[] a(char[]... paramVarArgs) {
/* 274 */     int i = 0;
/* 275 */     for (char[] arrayOfChar1 : paramVarArgs) {
/* 276 */       i += arrayOfChar1.length;
/*     */     }
/* 278 */     char[] arrayOfChar = new char[i];
/* 279 */     int j = 0;
/* 280 */     for (char[] arrayOfChar1 : paramVarArgs) {
/* 281 */       System.arraycopy(arrayOfChar1, 0, arrayOfChar, j, arrayOfChar1.length);
/* 282 */       j += arrayOfChar1.length;
/*     */     } 
/* 284 */     return arrayOfChar;
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
/*     */   public static byte[] a(char paramChar) {
/* 298 */     return new byte[] { (byte)(paramChar >> 8), (byte)paramChar };
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
/*     */   public static char a(byte[] paramArrayOfbyte) {
/* 313 */     D.a((paramArrayOfbyte.length >= 2), "array too small: %s < %s", paramArrayOfbyte.length, 2);
/* 314 */     return a(paramArrayOfbyte[0], paramArrayOfbyte[1]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.a.a.c
/*     */   public static char a(byte paramByte1, byte paramByte2) {
/* 325 */     return (char)(paramByte1 << 8 | paramByte2 & 0xFF);
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
/*     */   public static char[] b(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 342 */     D.a((paramInt1 >= 0), "Invalid minLength: %s", paramInt1);
/* 343 */     D.a((paramInt2 >= 0), "Invalid padding: %s", paramInt2);
/* 344 */     return (paramArrayOfchar.length < paramInt1) ? Arrays.copyOf(paramArrayOfchar, paramInt1 + paramInt2) : paramArrayOfchar;
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
/*     */   public static String a(String paramString, char... paramVarArgs) {
/* 356 */     D.checkNotNull(paramString);
/* 357 */     int i = paramVarArgs.length;
/* 358 */     if (i == 0) {
/* 359 */       return "";
/*     */     }
/*     */     
/* 362 */     StringBuilder stringBuilder = new StringBuilder(i + paramString.length() * (i - 1));
/* 363 */     stringBuilder.append(paramVarArgs[0]);
/* 364 */     for (byte b = 1; b < i; b++) {
/* 365 */       stringBuilder.append(paramString).append(paramVarArgs[b]);
/*     */     }
/* 367 */     return stringBuilder.toString();
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
/*     */   public static Comparator<char[]> g() {
/* 385 */     return (Comparator<char[]>)b.a;
/*     */   }
/*     */   
/*     */   private enum b implements Comparator<char[]> {
/* 389 */     a;
/*     */ 
/*     */     
/*     */     public int b(char[] param1ArrayOfchar1, char[] param1ArrayOfchar2) {
/* 393 */       int i = Math.min(param1ArrayOfchar1.length, param1ArrayOfchar2.length);
/* 394 */       for (byte b1 = 0; b1 < i; b1++) {
/* 395 */         int j = c.compare(param1ArrayOfchar1[b1], param1ArrayOfchar2[b1]);
/* 396 */         if (j != 0) {
/* 397 */           return j;
/*     */         }
/*     */       } 
/* 400 */       return param1ArrayOfchar1.length - param1ArrayOfchar2.length;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 405 */       return "Chars.lexicographicalComparator()";
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
/*     */   public static char[] a(Collection<Character> paramCollection) {
/* 422 */     if (paramCollection instanceof a) {
/* 423 */       return ((a)paramCollection).toCharArray();
/*     */     }
/*     */     
/* 426 */     Object[] arrayOfObject = paramCollection.toArray();
/* 427 */     int i = arrayOfObject.length;
/* 428 */     char[] arrayOfChar = new char[i];
/* 429 */     for (byte b = 0; b < i; b++)
/*     */     {
/* 431 */       arrayOfChar[b] = ((Character)D.checkNotNull(arrayOfObject[b])).charValue();
/*     */     }
/* 433 */     return arrayOfChar;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(char[] paramArrayOfchar) {
/* 442 */     D.checkNotNull(paramArrayOfchar);
/* 443 */     b(paramArrayOfchar, 0, paramArrayOfchar.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void b(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 453 */     D.checkNotNull(paramArrayOfchar);
/* 454 */     D.a(paramInt1, paramInt2, paramArrayOfchar.length);
/* 455 */     Arrays.sort(paramArrayOfchar, paramInt1, paramInt2);
/* 456 */     reverse(paramArrayOfchar, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void reverse(char[] paramArrayOfchar) {
/* 466 */     D.checkNotNull(paramArrayOfchar);
/* 467 */     reverse(paramArrayOfchar, 0, paramArrayOfchar.length);
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
/*     */   public static void reverse(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 481 */     D.checkNotNull(paramArrayOfchar);
/* 482 */     D.a(paramInt1, paramInt2, paramArrayOfchar.length);
/* 483 */     for (int i = paramInt1, j = paramInt2 - 1; i < j; i++, j--) {
/* 484 */       char c1 = paramArrayOfchar[i];
/* 485 */       paramArrayOfchar[i] = paramArrayOfchar[j];
/* 486 */       paramArrayOfchar[j] = c1;
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
/*     */   public static List<Character> a(char... paramVarArgs) {
/* 503 */     if (paramVarArgs.length == 0) {
/* 504 */       return Collections.emptyList();
/*     */     }
/* 506 */     return new a(paramVarArgs);
/*     */   }
/*     */   
/*     */   @b
/*     */   private static class a extends AbstractList<Character> implements Serializable, RandomAccess {
/*     */     final char[] i;
/*     */     final int start;
/*     */     final int end;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     a(char[] param1ArrayOfchar) {
/* 517 */       this(param1ArrayOfchar, 0, param1ArrayOfchar.length);
/*     */     }
/*     */     
/*     */     a(char[] param1ArrayOfchar, int param1Int1, int param1Int2) {
/* 521 */       this.i = param1ArrayOfchar;
/* 522 */       this.start = param1Int1;
/* 523 */       this.end = param1Int2;
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 528 */       return this.end - this.start;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isEmpty() {
/* 533 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public Character get(int param1Int) {
/* 538 */       D.b(param1Int, size());
/* 539 */       return Character.valueOf(this.i[this.start + param1Int]);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 545 */       return (param1Object instanceof Character && 
/* 546 */         c.c(this.i, ((Character)param1Object).charValue(), this.start, this.end) != -1);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int indexOf(Object param1Object) {
/* 552 */       if (param1Object instanceof Character) {
/* 553 */         int i = c.c(this.i, ((Character)param1Object).charValue(), this.start, this.end);
/* 554 */         if (i >= 0) {
/* 555 */           return i - this.start;
/*     */         }
/*     */       } 
/* 558 */       return -1;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int lastIndexOf(Object param1Object) {
/* 564 */       if (param1Object instanceof Character) {
/* 565 */         int i = c.d(this.i, ((Character)param1Object).charValue(), this.start, this.end);
/* 566 */         if (i >= 0) {
/* 567 */           return i - this.start;
/*     */         }
/*     */       } 
/* 570 */       return -1;
/*     */     }
/*     */ 
/*     */     
/*     */     public Character a(int param1Int, Character param1Character) {
/* 575 */       D.b(param1Int, size());
/* 576 */       char c = this.i[this.start + param1Int];
/*     */       
/* 578 */       this.i[this.start + param1Int] = ((Character)D.checkNotNull(param1Character)).charValue();
/* 579 */       return Character.valueOf(c);
/*     */     }
/*     */ 
/*     */     
/*     */     public List<Character> subList(int param1Int1, int param1Int2) {
/* 584 */       int i = size();
/* 585 */       D.a(param1Int1, param1Int2, i);
/* 586 */       if (param1Int1 == param1Int2) {
/* 587 */         return Collections.emptyList();
/*     */       }
/* 589 */       return new a(this.i, this.start + param1Int1, this.start + param1Int2);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 594 */       if (param1Object == this) {
/* 595 */         return true;
/*     */       }
/* 597 */       if (param1Object instanceof a) {
/* 598 */         a a1 = (a)param1Object;
/* 599 */         int i = size();
/* 600 */         if (a1.size() != i) {
/* 601 */           return false;
/*     */         }
/* 603 */         for (byte b = 0; b < i; b++) {
/* 604 */           if (this.i[this.start + b] != a1.i[a1.start + b]) {
/* 605 */             return false;
/*     */           }
/*     */         } 
/* 608 */         return true;
/*     */       } 
/* 610 */       return super.equals(param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 615 */       int i = 1;
/* 616 */       for (int j = this.start; j < this.end; j++) {
/* 617 */         i = 31 * i + c.c(this.i[j]);
/*     */       }
/* 619 */       return i;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 624 */       StringBuilder stringBuilder = new StringBuilder(size() * 3);
/* 625 */       stringBuilder.append('[').append(this.i[this.start]);
/* 626 */       for (int i = this.start + 1; i < this.end; i++) {
/* 627 */         stringBuilder.append(", ").append(this.i[i]);
/*     */       }
/* 629 */       return stringBuilder.append(']').toString();
/*     */     }
/*     */     
/*     */     char[] toCharArray() {
/* 633 */       return Arrays.copyOfRange(this.i, this.start, this.end);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\m\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */