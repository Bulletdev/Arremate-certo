/*     */ package com.google.a.m;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import java.io.Serializable;
/*     */ import java.util.AbstractList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
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
/*     */ @b
/*     */ public final class b
/*     */ {
/*     */   public static int a(byte paramByte) {
/*  60 */     return paramByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean contains(byte[] paramArrayOfbyte, byte paramByte) {
/*  71 */     for (byte b1 : paramArrayOfbyte) {
/*  72 */       if (b1 == paramByte) {
/*  73 */         return true;
/*     */       }
/*     */     } 
/*  76 */     return false;
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
/*     */   public static int indexOf(byte[] paramArrayOfbyte, byte paramByte) {
/*  88 */     return a(paramArrayOfbyte, paramByte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */   
/*     */   private static int a(byte[] paramArrayOfbyte, byte paramByte, int paramInt1, int paramInt2) {
/*  93 */     for (int i = paramInt1; i < paramInt2; i++) {
/*  94 */       if (paramArrayOfbyte[i] == paramByte) {
/*  95 */         return i;
/*     */       }
/*     */     } 
/*  98 */     return -1;
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
/*     */   public static int a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/* 112 */     D.b(paramArrayOfbyte1, "array");
/* 113 */     D.b(paramArrayOfbyte2, "target");
/* 114 */     if (paramArrayOfbyte2.length == 0) {
/* 115 */       return 0;
/*     */     }
/*     */ 
/*     */     
/* 119 */     for (byte b1 = 0; b1 < paramArrayOfbyte1.length - paramArrayOfbyte2.length + 1; b1++) {
/* 120 */       byte b2 = 0; while (true) { if (b2 < paramArrayOfbyte2.length) {
/* 121 */           if (paramArrayOfbyte1[b1 + b2] != paramArrayOfbyte2[b2])
/*     */             break;  b2++;
/*     */           continue;
/*     */         } 
/* 125 */         return b1; }
/*     */     
/* 127 */     }  return -1;
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
/*     */   public static int lastIndexOf(byte[] paramArrayOfbyte, byte paramByte) {
/* 139 */     return b(paramArrayOfbyte, paramByte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */   
/*     */   private static int b(byte[] paramArrayOfbyte, byte paramByte, int paramInt1, int paramInt2) {
/* 144 */     for (int i = paramInt2 - 1; i >= paramInt1; i--) {
/* 145 */       if (paramArrayOfbyte[i] == paramByte) {
/* 146 */         return i;
/*     */       }
/*     */     } 
/* 149 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] a(byte[]... paramVarArgs) {
/* 160 */     int i = 0;
/* 161 */     for (byte[] arrayOfByte1 : paramVarArgs) {
/* 162 */       i += arrayOfByte1.length;
/*     */     }
/* 164 */     byte[] arrayOfByte = new byte[i];
/* 165 */     int j = 0;
/* 166 */     for (byte[] arrayOfByte1 : paramVarArgs) {
/* 167 */       System.arraycopy(arrayOfByte1, 0, arrayOfByte, j, arrayOfByte1.length);
/* 168 */       j += arrayOfByte1.length;
/*     */     } 
/* 170 */     return arrayOfByte;
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
/*     */   public static byte[] a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 187 */     D.a((paramInt1 >= 0), "Invalid minLength: %s", paramInt1);
/* 188 */     D.a((paramInt2 >= 0), "Invalid padding: %s", paramInt2);
/* 189 */     return (paramArrayOfbyte.length < paramInt1) ? Arrays.copyOf(paramArrayOfbyte, paramInt1 + paramInt2) : paramArrayOfbyte;
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
/*     */   public static byte[] a(Collection<? extends Number> paramCollection) {
/* 206 */     if (paramCollection instanceof a) {
/* 207 */       return ((a)paramCollection).toByteArray();
/*     */     }
/*     */     
/* 210 */     Object[] arrayOfObject = paramCollection.toArray();
/* 211 */     int i = arrayOfObject.length;
/* 212 */     byte[] arrayOfByte = new byte[i];
/* 213 */     for (byte b1 = 0; b1 < i; b1++)
/*     */     {
/* 215 */       arrayOfByte[b1] = ((Number)D.checkNotNull(arrayOfObject[b1])).byteValue();
/*     */     }
/* 217 */     return arrayOfByte;
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
/*     */   public static List<Byte> a(byte... paramVarArgs) {
/* 233 */     if (paramVarArgs.length == 0) {
/* 234 */       return Collections.emptyList();
/*     */     }
/* 236 */     return new a(paramVarArgs);
/*     */   }
/*     */   
/*     */   @b
/*     */   private static class a extends AbstractList<Byte> implements Serializable, RandomAccess {
/*     */     final byte[] d;
/*     */     final int start;
/*     */     final int end;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     a(byte[] param1ArrayOfbyte) {
/* 247 */       this(param1ArrayOfbyte, 0, param1ArrayOfbyte.length);
/*     */     }
/*     */     
/*     */     a(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
/* 251 */       this.d = param1ArrayOfbyte;
/* 252 */       this.start = param1Int1;
/* 253 */       this.end = param1Int2;
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 258 */       return this.end - this.start;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isEmpty() {
/* 263 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public Byte a(int param1Int) {
/* 268 */       D.b(param1Int, size());
/* 269 */       return Byte.valueOf(this.d[this.start + param1Int]);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 275 */       return (param1Object instanceof Byte && b.c(this.d, ((Byte)param1Object).byteValue(), this.start, this.end) != -1);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int indexOf(Object param1Object) {
/* 281 */       if (param1Object instanceof Byte) {
/* 282 */         int i = b.c(this.d, ((Byte)param1Object).byteValue(), this.start, this.end);
/* 283 */         if (i >= 0) {
/* 284 */           return i - this.start;
/*     */         }
/*     */       } 
/* 287 */       return -1;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int lastIndexOf(Object param1Object) {
/* 293 */       if (param1Object instanceof Byte) {
/* 294 */         int i = b.d(this.d, ((Byte)param1Object).byteValue(), this.start, this.end);
/* 295 */         if (i >= 0) {
/* 296 */           return i - this.start;
/*     */         }
/*     */       } 
/* 299 */       return -1;
/*     */     }
/*     */ 
/*     */     
/*     */     public Byte a(int param1Int, Byte param1Byte) {
/* 304 */       D.b(param1Int, size());
/* 305 */       byte b = this.d[this.start + param1Int];
/*     */       
/* 307 */       this.d[this.start + param1Int] = ((Byte)D.checkNotNull(param1Byte)).byteValue();
/* 308 */       return Byte.valueOf(b);
/*     */     }
/*     */ 
/*     */     
/*     */     public List<Byte> subList(int param1Int1, int param1Int2) {
/* 313 */       int i = size();
/* 314 */       D.a(param1Int1, param1Int2, i);
/* 315 */       if (param1Int1 == param1Int2) {
/* 316 */         return Collections.emptyList();
/*     */       }
/* 318 */       return new a(this.d, this.start + param1Int1, this.start + param1Int2);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 323 */       if (param1Object == this) {
/* 324 */         return true;
/*     */       }
/* 326 */       if (param1Object instanceof a) {
/* 327 */         a a1 = (a)param1Object;
/* 328 */         int i = size();
/* 329 */         if (a1.size() != i) {
/* 330 */           return false;
/*     */         }
/* 332 */         for (byte b = 0; b < i; b++) {
/* 333 */           if (this.d[this.start + b] != a1.d[a1.start + b]) {
/* 334 */             return false;
/*     */           }
/*     */         } 
/* 337 */         return true;
/*     */       } 
/* 339 */       return super.equals(param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 344 */       int i = 1;
/* 345 */       for (int j = this.start; j < this.end; j++) {
/* 346 */         i = 31 * i + b.a(this.d[j]);
/*     */       }
/* 348 */       return i;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 353 */       StringBuilder stringBuilder = new StringBuilder(size() * 5);
/* 354 */       stringBuilder.append('[').append(this.d[this.start]);
/* 355 */       for (int i = this.start + 1; i < this.end; i++) {
/* 356 */         stringBuilder.append(", ").append(this.d[i]);
/*     */       }
/* 358 */       return stringBuilder.append(']').toString();
/*     */     }
/*     */     
/*     */     byte[] toByteArray() {
/* 362 */       return Arrays.copyOfRange(this.d, this.start, this.end);
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
/*     */   public static void reverse(byte[] paramArrayOfbyte) {
/* 375 */     D.checkNotNull(paramArrayOfbyte);
/* 376 */     reverse(paramArrayOfbyte, 0, paramArrayOfbyte.length);
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
/*     */   public static void reverse(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 390 */     D.checkNotNull(paramArrayOfbyte);
/* 391 */     D.a(paramInt1, paramInt2, paramArrayOfbyte.length);
/* 392 */     for (int i = paramInt1, j = paramInt2 - 1; i < j; i++, j--) {
/* 393 */       byte b1 = paramArrayOfbyte[i];
/* 394 */       paramArrayOfbyte[i] = paramArrayOfbyte[j];
/* 395 */       paramArrayOfbyte[j] = b1;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\m\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */