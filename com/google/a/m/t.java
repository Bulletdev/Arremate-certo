/*     */ package com.google.a.m;
/*     */ 
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.a.d;
/*     */ import com.google.a.b.D;
/*     */ import java.lang.reflect.Field;
/*     */ import java.nio.ByteOrder;
/*     */ import java.security.AccessController;
/*     */ import java.security.PrivilegedActionException;
/*     */ import java.security.PrivilegedExceptionAction;
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ import sun.misc.Unsafe;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @c
/*     */ public final class t
/*     */ {
/*     */   public static final byte K = -128;
/*     */   public static final byte L = -1;
/*     */   private static final int gn = 255;
/*     */   
/*     */   public static int b(byte paramByte) {
/*  74 */     return paramByte & 0xFF;
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
/*     */   @com.google.b.a.a
/*     */   public static byte a(long paramLong) {
/*  87 */     D.a((paramLong >> 8L == 0L), "out of range: %s", paramLong);
/*  88 */     return (byte)(int)paramLong;
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
/*     */   public static byte b(long paramLong) {
/* 100 */     if (paramLong > b((byte)-1)) {
/* 101 */       return -1;
/*     */     }
/* 103 */     if (paramLong < 0L) {
/* 104 */       return 0;
/*     */     }
/* 106 */     return (byte)(int)paramLong;
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
/*     */   public static int compare(byte paramByte1, byte paramByte2) {
/* 120 */     return b(paramByte1) - b(paramByte2);
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
/*     */   public static byte min(byte... paramVarArgs) {
/* 132 */     D.checkArgument((paramVarArgs.length > 0));
/* 133 */     int i = b(paramVarArgs[0]);
/* 134 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 135 */       int j = b(paramVarArgs[b]);
/* 136 */       if (j < i) {
/* 137 */         i = j;
/*     */       }
/*     */     } 
/* 140 */     return (byte)i;
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
/*     */   public static byte max(byte... paramVarArgs) {
/* 152 */     D.checkArgument((paramVarArgs.length > 0));
/* 153 */     int i = b(paramVarArgs[0]);
/* 154 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 155 */       int j = b(paramVarArgs[b]);
/* 156 */       if (j > i) {
/* 157 */         i = j;
/*     */       }
/*     */     } 
/* 160 */     return (byte)i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.a.a.a
/*     */   public static String a(byte paramByte) {
/* 170 */     return a(paramByte, 10);
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
/*     */   @com.google.a.a.a
/*     */   public static String a(byte paramByte, int paramInt) {
/* 185 */     D.a((paramInt >= 2 && paramInt <= 36), "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 190 */     return Integer.toString(b(paramByte), paramInt);
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
/*     */   @com.google.a.a.a
/*     */   @com.google.b.a.a
/*     */   public static byte a(String paramString) {
/* 205 */     return a(paramString, 10);
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
/*     */   @com.google.a.a.a
/*     */   @com.google.b.a.a
/*     */   public static byte a(String paramString, int paramInt) {
/* 223 */     int i = Integer.parseInt((String)D.checkNotNull(paramString), paramInt);
/*     */     
/* 225 */     if (i >> 8 == 0) {
/* 226 */       return (byte)i;
/*     */     }
/* 228 */     throw new NumberFormatException((new StringBuilder(25)).append("out of range: ").append(i).toString());
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
/*     */   public static String a(String paramString, byte... paramVarArgs) {
/* 242 */     D.checkNotNull(paramString);
/* 243 */     if (paramVarArgs.length == 0) {
/* 244 */       return "";
/*     */     }
/*     */ 
/*     */     
/* 248 */     StringBuilder stringBuilder = new StringBuilder(paramVarArgs.length * (3 + paramString.length()));
/* 249 */     stringBuilder.append(b(paramVarArgs[0]));
/* 250 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 251 */       stringBuilder.append(paramString).append(a(paramVarArgs[b]));
/*     */     }
/* 253 */     return stringBuilder.toString();
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
/*     */   public static Comparator<byte[]> g() {
/* 271 */     return a.h;
/*     */   }
/*     */   
/*     */   @d
/*     */   static Comparator<byte[]> h() {
/* 276 */     return (Comparator<byte[]>)a.a.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @d
/*     */   static class a
/*     */   {
/* 289 */     static final String iR = String.valueOf(a.class.getName()).concat("$UnsafeComparator");
/*     */     
/* 291 */     static final Comparator<byte[]> h = i();
/*     */     
/*     */     @d
/*     */     enum b implements Comparator<byte[]> {
/* 295 */       a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       static final int fz;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 315 */       static final Unsafe b = a(); static final boolean bg = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
/*     */       
/*     */       static {
/* 318 */         fz = b.arrayBaseOffset(byte[].class);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 323 */         if (!"64".equals(System.getProperty("sun.arch.data.model")) || fz % 8 != 0 || b
/*     */ 
/*     */           
/* 326 */           .arrayIndexScale(byte[].class) != 1) {
/* 327 */           throw new Error();
/*     */         }
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private static Unsafe a() {
/*     */         try {
/* 339 */           return Unsafe.getUnsafe();
/* 340 */         } catch (SecurityException securityException) {
/*     */ 
/*     */           
/*     */           try {
/* 344 */             return AccessController.<Unsafe>doPrivileged(new PrivilegedExceptionAction<Unsafe>()
/*     */                 {
/*     */                   public Unsafe c() throws Exception
/*     */                   {
/* 348 */                     Class<Unsafe> clazz = Unsafe.class;
/* 349 */                     for (Field field : clazz.getDeclaredFields()) {
/* 350 */                       field.setAccessible(true);
/* 351 */                       Object object = field.get((Object)null);
/* 352 */                       if (clazz.isInstance(object)) {
/* 353 */                         return clazz.cast(object);
/*     */                       }
/*     */                     } 
/* 356 */                     throw new NoSuchFieldError("the Unsafe");
/*     */                   }
/*     */                 });
/* 359 */           } catch (PrivilegedActionException privilegedActionException) {
/* 360 */             throw new RuntimeException("Could not initialize intrinsics", privilegedActionException.getCause());
/*     */           } 
/*     */         } 
/*     */       }
/*     */       
/*     */       public int b(byte[] param2ArrayOfbyte1, byte[] param2ArrayOfbyte2) {
/* 366 */         byte b1 = 8;
/* 367 */         int i = Math.min(param2ArrayOfbyte1.length, param2ArrayOfbyte2.length);
/* 368 */         int j = i & 0xFFFFFFF8;
/*     */ 
/*     */ 
/*     */         
/*     */         byte b2;
/*     */ 
/*     */         
/* 375 */         for (b2 = 0; b2 < j; b2 += 8) {
/* 376 */           long l1 = b.getLong(param2ArrayOfbyte1, fz + b2);
/* 377 */           long l2 = b.getLong(param2ArrayOfbyte2, fz + b2);
/* 378 */           if (l1 != l2) {
/* 379 */             if (bg) {
/* 380 */               return x.compare(l1, l2);
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 390 */             int k = Long.numberOfTrailingZeros(l1 ^ l2) & 0xFFFFFFF8;
/* 391 */             return (int)(l1 >>> k & 0xFFL) - (int)(l2 >>> k & 0xFFL);
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 396 */         for (; b2 < i; b2++) {
/* 397 */           int k = t.compare(param2ArrayOfbyte1[b2], param2ArrayOfbyte2[b2]);
/* 398 */           if (k != 0) {
/* 399 */             return k;
/*     */           }
/*     */         } 
/* 402 */         return param2ArrayOfbyte1.length - param2ArrayOfbyte2.length;
/*     */       }
/*     */ 
/*     */       
/*     */       public String toString() {
/* 407 */         return "UnsignedBytes.lexicographicalComparator() (sun.misc.Unsafe version)";
/*     */       }
/*     */     }
/*     */     
/*     */     enum a implements Comparator<byte[]> {
/* 412 */       a;
/*     */ 
/*     */       
/*     */       public int b(byte[] param2ArrayOfbyte1, byte[] param2ArrayOfbyte2) {
/* 416 */         int i = Math.min(param2ArrayOfbyte1.length, param2ArrayOfbyte2.length);
/* 417 */         for (byte b = 0; b < i; b++) {
/* 418 */           int j = t.compare(param2ArrayOfbyte1[b], param2ArrayOfbyte2[b]);
/* 419 */           if (j != 0) {
/* 420 */             return j;
/*     */           }
/*     */         } 
/* 423 */         return param2ArrayOfbyte1.length - param2ArrayOfbyte2.length;
/*     */       }
/*     */ 
/*     */       
/*     */       public String toString() {
/* 428 */         return "UnsignedBytes.lexicographicalComparator() (pure Java version)";
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     static Comparator<byte[]> i() {
/*     */       try {
/* 438 */         Class<?> clazz = Class.forName(iR);
/*     */ 
/*     */ 
/*     */         
/* 442 */         return (Comparator)clazz.getEnumConstants()[0];
/*     */       }
/* 444 */       catch (Throwable throwable) {
/* 445 */         return t.h();
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private static byte a(byte paramByte) {
/* 451 */     return (byte)(paramByte ^ 0x80);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void b(byte[] paramArrayOfbyte) {
/* 460 */     D.checkNotNull(paramArrayOfbyte);
/* 461 */     c(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void c(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 471 */     D.checkNotNull(paramArrayOfbyte);
/* 472 */     D.a(paramInt1, paramInt2, paramArrayOfbyte.length); int i;
/* 473 */     for (i = paramInt1; i < paramInt2; i++) {
/* 474 */       paramArrayOfbyte[i] = a(paramArrayOfbyte[i]);
/*     */     }
/* 476 */     Arrays.sort(paramArrayOfbyte, paramInt1, paramInt2);
/* 477 */     for (i = paramInt1; i < paramInt2; i++) {
/* 478 */       paramArrayOfbyte[i] = a(paramArrayOfbyte[i]);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(byte[] paramArrayOfbyte) {
/* 489 */     D.checkNotNull(paramArrayOfbyte);
/* 490 */     b(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */   enum a implements Comparator<byte[]> {
/*     */     a; public int b(byte[] param1ArrayOfbyte1, byte[] param1ArrayOfbyte2) { int i = Math.min(param1ArrayOfbyte1.length, param1ArrayOfbyte2.length);
/*     */       for (byte b = 0; b < i; b++) {
/*     */         int j = t.compare(param1ArrayOfbyte1[b], param1ArrayOfbyte2[b]);
/*     */         if (j != 0)
/*     */           return j; 
/*     */       } 
/*     */       return param1ArrayOfbyte1.length - param1ArrayOfbyte2.length; } public String toString() { return "UnsignedBytes.lexicographicalComparator() (pure Java version)"; } } public static void b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 500 */     D.checkNotNull(paramArrayOfbyte);
/* 501 */     D.a(paramInt1, paramInt2, paramArrayOfbyte.length); int i;
/* 502 */     for (i = paramInt1; i < paramInt2; i++) {
/* 503 */       paramArrayOfbyte[i] = (byte)(paramArrayOfbyte[i] ^ Byte.MAX_VALUE);
/*     */     }
/* 505 */     Arrays.sort(paramArrayOfbyte, paramInt1, paramInt2);
/* 506 */     for (i = paramInt1; i < paramInt2; i++)
/* 507 */       paramArrayOfbyte[i] = (byte)(paramArrayOfbyte[i] ^ Byte.MAX_VALUE); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\m\t.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */