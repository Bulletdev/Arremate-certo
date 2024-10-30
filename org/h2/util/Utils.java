/*     */ package org.h2.util;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.lang.management.ManagementFactory;
/*     */ import java.lang.management.OperatingSystemMXBean;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipInputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Utils
/*     */ {
/*  30 */   public static final byte[] EMPTY_BYTES = new byte[0];
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  35 */   public static final int[] EMPTY_INT_ARRAY = new int[0];
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  40 */   private static final long[] EMPTY_LONG_ARRAY = new long[0];
/*     */   
/*     */   private static final int GC_DELAY = 50;
/*     */   
/*     */   private static final int MAX_GC = 8;
/*     */   private static long lastGC;
/*  46 */   private static final HashMap<String, byte[]> RESOURCES = (HashMap)New.hashMap();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int readInt(byte[] paramArrayOfbyte, int paramInt) {
/*  53 */     return (paramArrayOfbyte[paramInt++] << 24) + ((paramArrayOfbyte[paramInt++] & 0xFF) << 16) + ((paramArrayOfbyte[paramInt++] & 0xFF) << 8) + (paramArrayOfbyte[paramInt] & 0xFF);
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
/*     */   public static void writeLong(byte[] paramArrayOfbyte, int paramInt, long paramLong) {
/*  68 */     writeInt(paramArrayOfbyte, paramInt, (int)(paramLong >> 32L));
/*  69 */     writeInt(paramArrayOfbyte, paramInt + 4, (int)paramLong);
/*     */   }
/*     */   
/*     */   private static void writeInt(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  73 */     paramArrayOfbyte[paramInt1++] = (byte)(paramInt2 >> 24);
/*  74 */     paramArrayOfbyte[paramInt1++] = (byte)(paramInt2 >> 16);
/*  75 */     paramArrayOfbyte[paramInt1++] = (byte)(paramInt2 >> 8);
/*  76 */     paramArrayOfbyte[paramInt1++] = (byte)paramInt2;
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
/*     */   public static long readLong(byte[] paramArrayOfbyte, int paramInt) {
/*  88 */     return (readInt(paramArrayOfbyte, paramInt) << 32L) + (readInt(paramArrayOfbyte, paramInt + 4) & 0xFFFFFFFFL);
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
/*     */   public static int indexOf(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, int paramInt) {
/* 104 */     if (paramArrayOfbyte2.length == 0) {
/* 105 */       return paramInt;
/*     */     }
/* 107 */     if (paramInt > paramArrayOfbyte1.length) {
/* 108 */       return -1;
/*     */     }
/* 110 */     int i = paramArrayOfbyte1.length - paramArrayOfbyte2.length + 1;
/* 111 */     int j = paramArrayOfbyte2.length;
/*     */     
/* 113 */     for (; paramInt < i; paramInt++) {
/* 114 */       byte b = 0; while (true) { if (b < j) {
/* 115 */           if (paramArrayOfbyte1[paramInt + b] != paramArrayOfbyte2[b])
/*     */             break;  b++;
/*     */           continue;
/*     */         } 
/* 119 */         return paramInt; }
/*     */     
/* 121 */     }  return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getByteArrayHash(byte[] paramArrayOfbyte) {
/* 131 */     int i = paramArrayOfbyte.length;
/* 132 */     int j = i;
/* 133 */     if (i < 50) {
/* 134 */       for (byte b = 0; b < i; b++) {
/* 135 */         j = 31 * j + paramArrayOfbyte[b];
/*     */       }
/*     */     } else {
/* 138 */       int k = i / 16; int m;
/* 139 */       for (m = 0; m < 4; m++) {
/* 140 */         j = 31 * j + paramArrayOfbyte[m];
/* 141 */         j = 31 * j + paramArrayOfbyte[--i];
/*     */       } 
/* 143 */       for (m = 4 + k; m < i; m += k) {
/* 144 */         j = 31 * j + paramArrayOfbyte[m];
/*     */       }
/*     */     } 
/* 147 */     return j;
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
/*     */   public static boolean compareSecure(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/* 160 */     if (paramArrayOfbyte1 == null || paramArrayOfbyte2 == null) {
/* 161 */       return (paramArrayOfbyte1 == null && paramArrayOfbyte2 == null);
/*     */     }
/* 163 */     int i = paramArrayOfbyte1.length;
/* 164 */     if (i != paramArrayOfbyte2.length) {
/* 165 */       return false;
/*     */     }
/* 167 */     if (i == 0) {
/* 168 */       return true;
/*     */     }
/*     */     
/* 171 */     int j = 0;
/* 172 */     for (byte b = 0; b < i; b++)
/*     */     {
/* 174 */       j |= paramArrayOfbyte1[b] ^ paramArrayOfbyte2[b];
/*     */     }
/* 176 */     return (j == 0);
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
/*     */   public static int compareNotNullSigned(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/* 192 */     if (paramArrayOfbyte1 == paramArrayOfbyte2) {
/* 193 */       return 0;
/*     */     }
/* 195 */     int i = Math.min(paramArrayOfbyte1.length, paramArrayOfbyte2.length);
/* 196 */     for (byte b = 0; b < i; b++) {
/* 197 */       byte b1 = paramArrayOfbyte1[b];
/* 198 */       byte b2 = paramArrayOfbyte2[b];
/* 199 */       if (b1 != b2) {
/* 200 */         return (b1 > b2) ? 1 : -1;
/*     */       }
/*     */     } 
/* 203 */     return Integer.signum(paramArrayOfbyte1.length - paramArrayOfbyte2.length);
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
/*     */   public static int compareNotNullUnsigned(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/* 219 */     if (paramArrayOfbyte1 == paramArrayOfbyte2) {
/* 220 */       return 0;
/*     */     }
/* 222 */     int i = Math.min(paramArrayOfbyte1.length, paramArrayOfbyte2.length);
/* 223 */     for (byte b = 0; b < i; b++) {
/* 224 */       int j = paramArrayOfbyte1[b] & 0xFF;
/* 225 */       int k = paramArrayOfbyte2[b] & 0xFF;
/* 226 */       if (j != k) {
/* 227 */         return (j > k) ? 1 : -1;
/*     */       }
/*     */     } 
/* 230 */     return Integer.signum(paramArrayOfbyte1.length - paramArrayOfbyte2.length);
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
/*     */   public static byte[] copy(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/* 242 */     int i = paramArrayOfbyte1.length;
/* 243 */     if (i > paramArrayOfbyte2.length) {
/* 244 */       paramArrayOfbyte2 = new byte[i];
/*     */     }
/* 246 */     System.arraycopy(paramArrayOfbyte1, 0, paramArrayOfbyte2, 0, i);
/* 247 */     return paramArrayOfbyte2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] cloneByteArray(byte[] paramArrayOfbyte) {
/* 258 */     if (paramArrayOfbyte == null) {
/* 259 */       return null;
/*     */     }
/* 261 */     int i = paramArrayOfbyte.length;
/* 262 */     if (i == 0) {
/* 263 */       return EMPTY_BYTES;
/*     */     }
/* 265 */     byte[] arrayOfByte = new byte[i];
/* 266 */     System.arraycopy(paramArrayOfbyte, 0, arrayOfByte, 0, i);
/* 267 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int hashCode(Object paramObject) {
/* 277 */     return (paramObject == null) ? 0 : paramObject.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getMemoryUsed() {
/* 287 */     collectGarbage();
/* 288 */     Runtime runtime = Runtime.getRuntime();
/* 289 */     long l = runtime.totalMemory() - runtime.freeMemory();
/* 290 */     return (int)(l >> 10L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getMemoryFree() {
/* 300 */     collectGarbage();
/* 301 */     Runtime runtime = Runtime.getRuntime();
/* 302 */     long l = runtime.freeMemory();
/* 303 */     return (int)(l >> 10L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long getMemoryMax() {
/* 312 */     long l = Runtime.getRuntime().maxMemory();
/* 313 */     return l / 1024L;
/*     */   }
/*     */   
/*     */   private static synchronized void collectGarbage() {
/* 317 */     Runtime runtime = Runtime.getRuntime();
/* 318 */     long l1 = runtime.totalMemory();
/* 319 */     long l2 = System.currentTimeMillis();
/* 320 */     if (lastGC + 50L < l2) {
/* 321 */       for (byte b = 0; b < 8; b++) {
/* 322 */         runtime.gc();
/* 323 */         long l = runtime.totalMemory();
/* 324 */         if (l == l1) {
/* 325 */           lastGC = System.currentTimeMillis();
/*     */           break;
/*     */         } 
/* 328 */         l1 = l;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int[] newIntArray(int paramInt) {
/* 340 */     if (paramInt == 0) {
/* 341 */       return EMPTY_INT_ARRAY;
/*     */     }
/* 343 */     return new int[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long[] newLongArray(int paramInt) {
/* 353 */     if (paramInt == 0) {
/* 354 */       return EMPTY_LONG_ARRAY;
/*     */     }
/* 356 */     return new long[paramInt];
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
/*     */   public static <X> void sortTopN(X[] paramArrayOfX, int paramInt1, int paramInt2, Comparator<? super X> paramComparator) {
/* 370 */     partitionTopN(paramArrayOfX, paramInt1, paramInt2, paramComparator);
/* 371 */     Arrays.sort(paramArrayOfX, paramInt1, (int)Math.min(paramInt1 + paramInt2, paramArrayOfX.length), paramComparator);
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
/*     */   private static <X> void partitionTopN(X[] paramArrayOfX, int paramInt1, int paramInt2, Comparator<? super X> paramComparator) {
/* 386 */     partialQuickSort(paramArrayOfX, 0, paramArrayOfX.length - 1, paramComparator, paramInt1, paramInt1 + paramInt2 - 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static <X> void partialQuickSort(X[] paramArrayOfX, int paramInt1, int paramInt2, Comparator<? super X> paramComparator, int paramInt3, int paramInt4) {
/* 392 */     if (paramInt1 > paramInt4 || paramInt2 < paramInt3 || (paramInt1 > paramInt3 && paramInt2 < paramInt4)) {
/*     */       return;
/*     */     }
/* 395 */     if (paramInt1 == paramInt2) {
/*     */       return;
/*     */     }
/* 398 */     int i = paramInt1, j = paramInt2;
/*     */ 
/*     */     
/* 401 */     int k = paramInt1 + MathUtils.randomInt(paramInt2 - paramInt1);
/* 402 */     X x1 = paramArrayOfX[k];
/* 403 */     int m = paramInt1 + paramInt2 >>> 1;
/* 404 */     X x2 = paramArrayOfX[m];
/* 405 */     paramArrayOfX[m] = x1;
/* 406 */     paramArrayOfX[k] = x2;
/* 407 */     while (i <= j) {
/* 408 */       while (paramComparator.compare(paramArrayOfX[i], x1) < 0) {
/* 409 */         i++;
/*     */       }
/* 411 */       while (paramComparator.compare(paramArrayOfX[j], x1) > 0) {
/* 412 */         j--;
/*     */       }
/* 414 */       if (i <= j) {
/* 415 */         x2 = paramArrayOfX[i];
/* 416 */         paramArrayOfX[i++] = paramArrayOfX[j];
/* 417 */         paramArrayOfX[j--] = x2;
/*     */       } 
/*     */     } 
/* 420 */     if (paramInt1 < j) {
/* 421 */       partialQuickSort(paramArrayOfX, paramInt1, j, paramComparator, paramInt3, paramInt4);
/*     */     }
/* 423 */     if (i < paramInt2) {
/* 424 */       partialQuickSort(paramArrayOfX, i, paramInt2, paramComparator, paramInt3, paramInt4);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean haveCommonComparableSuperclass(Class<?> paramClass1, Class<?> paramClass2) {
/*     */     Class<?> clazz1;
/*     */     Class<?> clazz2;
/* 437 */     if (paramClass1 == paramClass2 || paramClass1.isAssignableFrom(paramClass2) || paramClass2.isAssignableFrom(paramClass1)) {
/* 438 */       return true;
/*     */     }
/*     */     
/*     */     do {
/* 442 */       clazz1 = paramClass1;
/* 443 */       paramClass1 = paramClass1.getSuperclass();
/* 444 */     } while (Comparable.class.isAssignableFrom(paramClass1));
/*     */ 
/*     */     
/*     */     do {
/* 448 */       clazz2 = paramClass2;
/* 449 */       paramClass2 = paramClass2.getSuperclass();
/* 450 */     } while (Comparable.class.isAssignableFrom(paramClass2));
/*     */     
/* 452 */     return (clazz1 == clazz2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] getResource(String paramString) throws IOException {
/* 462 */     byte[] arrayOfByte = RESOURCES.get(paramString);
/* 463 */     if (arrayOfByte == null) {
/* 464 */       arrayOfByte = loadResource(paramString);
/* 465 */       if (arrayOfByte != null) {
/* 466 */         RESOURCES.put(paramString, arrayOfByte);
/*     */       }
/*     */     } 
/* 469 */     return arrayOfByte;
/*     */   }
/*     */   
/*     */   private static byte[] loadResource(String paramString) throws IOException {
/* 473 */     InputStream inputStream = Utils.class.getResourceAsStream("data.zip");
/* 474 */     if (inputStream == null) {
/* 475 */       inputStream = Utils.class.getResourceAsStream(paramString);
/* 476 */       if (inputStream == null) {
/* 477 */         return null;
/*     */       }
/* 479 */       return IOUtils.readBytesAndClose(inputStream, 0);
/*     */     } 
/*     */     
/* 482 */     try (ZipInputStream null = new ZipInputStream(inputStream)) {
/*     */       while (true) {
/* 484 */         ZipEntry zipEntry = zipInputStream.getNextEntry();
/* 485 */         if (zipEntry == null) {
/*     */           break;
/*     */         }
/* 488 */         String str = zipEntry.getName();
/* 489 */         if (!str.startsWith("/")) {
/* 490 */           str = "/" + str;
/*     */         }
/* 492 */         if (str.equals(paramString)) {
/* 493 */           ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 494 */           IOUtils.copy(zipInputStream, byteArrayOutputStream);
/* 495 */           zipInputStream.closeEntry();
/* 496 */           return byteArrayOutputStream.toByteArray();
/*     */         } 
/* 498 */         zipInputStream.closeEntry();
/*     */       } 
/* 500 */     } catch (IOException iOException) {
/*     */       
/* 502 */       iOException.printStackTrace();
/*     */     } 
/* 504 */     return null;
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
/*     */   public static Object callStaticMethod(String paramString, Object... paramVarArgs) throws Exception {
/* 519 */     int i = paramString.lastIndexOf('.');
/* 520 */     String str1 = paramString.substring(0, i);
/* 521 */     String str2 = paramString.substring(i + 1);
/* 522 */     return callMethod(null, Class.forName(str1), str2, paramVarArgs);
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
/*     */   public static Object callMethod(Object paramObject, String paramString, Object... paramVarArgs) throws Exception {
/* 539 */     return callMethod(paramObject, paramObject.getClass(), paramString, paramVarArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Object callMethod(Object paramObject, Class<?> paramClass, String paramString, Object... paramVarArgs) throws Exception {
/* 546 */     Method method = null;
/* 547 */     int i = 0;
/* 548 */     boolean bool = (paramObject == null);
/* 549 */     for (Method method1 : paramClass.getMethods()) {
/* 550 */       if (Modifier.isStatic(method1.getModifiers()) == bool && method1.getName().equals(paramString)) {
/*     */         
/* 552 */         int j = match(method1.getParameterTypes(), paramVarArgs);
/* 553 */         if (j > i) {
/* 554 */           i = j;
/* 555 */           method = method1;
/*     */         } 
/*     */       } 
/*     */     } 
/* 559 */     if (method == null) {
/* 560 */       throw new NoSuchMethodException(paramString);
/*     */     }
/* 562 */     return method.invoke(paramObject, paramVarArgs);
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
/*     */   public static Object newInstance(String paramString, Object... paramVarArgs) throws Exception {
/* 576 */     Constructor<?> constructor = null;
/* 577 */     int i = 0;
/* 578 */     for (Constructor<?> constructor1 : Class.forName(paramString).getConstructors()) {
/* 579 */       int j = match(constructor1.getParameterTypes(), paramVarArgs);
/* 580 */       if (j > i) {
/* 581 */         i = j;
/* 582 */         constructor = constructor1;
/*     */       } 
/*     */     } 
/* 585 */     if (constructor == null) {
/* 586 */       throw new NoSuchMethodException(paramString);
/*     */     }
/* 588 */     return constructor.newInstance(paramVarArgs);
/*     */   }
/*     */   
/*     */   private static int match(Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject) {
/* 592 */     int i = paramArrayOfClass.length;
/* 593 */     if (i == paramArrayOfObject.length) {
/* 594 */       byte b1 = 1;
/* 595 */       for (byte b2 = 0; b2 < i; b2++) {
/* 596 */         Class<?> clazz1 = getNonPrimitiveClass(paramArrayOfClass[b2]);
/* 597 */         Object object = paramArrayOfObject[b2];
/* 598 */         Class<?> clazz2 = (object == null) ? null : object.getClass();
/* 599 */         if (clazz1 == clazz2) {
/* 600 */           b1++;
/* 601 */         } else if (clazz2 != null) {
/*     */           
/* 603 */           if (!clazz1.isAssignableFrom(clazz2))
/* 604 */             return 0; 
/*     */         } 
/*     */       } 
/* 607 */       return b1;
/*     */     } 
/* 609 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object getStaticField(String paramString) throws Exception {
/* 619 */     int i = paramString.lastIndexOf('.');
/* 620 */     String str1 = paramString.substring(0, i);
/* 621 */     String str2 = paramString.substring(i + 1);
/* 622 */     return Class.forName(str1).getField(str2).get(null);
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
/*     */   public static Object getField(Object paramObject, String paramString) throws Exception {
/* 634 */     return paramObject.getClass().getField(paramString).get(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isClassPresent(String paramString) {
/*     */     try {
/* 646 */       Class.forName(paramString);
/* 647 */       return true;
/* 648 */     } catch (ClassNotFoundException classNotFoundException) {
/* 649 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Class<?> getNonPrimitiveClass(Class<?> paramClass) {
/* 660 */     if (!paramClass.isPrimitive())
/* 661 */       return paramClass; 
/* 662 */     if (paramClass == boolean.class)
/* 663 */       return Boolean.class; 
/* 664 */     if (paramClass == byte.class)
/* 665 */       return Byte.class; 
/* 666 */     if (paramClass == char.class)
/* 667 */       return Character.class; 
/* 668 */     if (paramClass == double.class)
/* 669 */       return Double.class; 
/* 670 */     if (paramClass == float.class)
/* 671 */       return Float.class; 
/* 672 */     if (paramClass == int.class)
/* 673 */       return Integer.class; 
/* 674 */     if (paramClass == long.class)
/* 675 */       return Long.class; 
/* 676 */     if (paramClass == short.class)
/* 677 */       return Short.class; 
/* 678 */     if (paramClass == void.class) {
/* 679 */       return Void.class;
/*     */     }
/* 681 */     return paramClass;
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
/*     */   public static String getProperty(String paramString1, String paramString2) {
/*     */     try {
/* 694 */       return System.getProperty(paramString1, paramString2);
/* 695 */     } catch (SecurityException securityException) {
/* 696 */       return paramString2;
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
/*     */   public static int getProperty(String paramString, int paramInt) {
/* 709 */     String str = getProperty(paramString, (String)null);
/* 710 */     if (str != null) {
/*     */       try {
/* 712 */         return Integer.decode(str).intValue();
/* 713 */       } catch (NumberFormatException numberFormatException) {}
/*     */     }
/*     */ 
/*     */     
/* 717 */     return paramInt;
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
/*     */   public static boolean getProperty(String paramString, boolean paramBoolean) {
/* 729 */     String str = getProperty(paramString, (String)null);
/* 730 */     if (str != null) {
/*     */       try {
/* 732 */         return Boolean.parseBoolean(str);
/* 733 */       } catch (NumberFormatException numberFormatException) {}
/*     */     }
/*     */ 
/*     */     
/* 737 */     return paramBoolean;
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
/*     */   public static int scaleForAvailableMemory(int paramInt) {
/* 749 */     long l = Runtime.getRuntime().maxMemory();
/* 750 */     if (l != Long.MAX_VALUE)
/*     */     {
/* 752 */       return (int)(paramInt * l / 1073741824L);
/*     */     }
/*     */     try {
/* 755 */       OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 761 */       Method method = Class.forName("com.sun.management.OperatingSystemMXBean").getMethod("getTotalPhysicalMemorySize", new Class[0]);
/*     */ 
/*     */       
/* 764 */       long l1 = ((Number)method.invoke(operatingSystemMXBean, new Object[0])).longValue();
/* 765 */       return (int)(paramInt * l1 / 1073741824L);
/* 766 */     } catch (Exception exception) {
/*     */ 
/*     */       
/* 769 */       return paramInt;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static interface ClassFactory {
/*     */     boolean match(String param1String);
/*     */     
/*     */     Class<?> loadClass(String param1String) throws ClassNotFoundException;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\Utils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */