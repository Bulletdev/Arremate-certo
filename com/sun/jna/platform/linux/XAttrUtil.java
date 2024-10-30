/*     */ package com.sun.jna.platform.linux;
/*     */ 
/*     */ import com.sun.jna.Memory;
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.Pointer;
/*     */ import java.io.IOException;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.Collection;
/*     */ import java.util.LinkedHashSet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class XAttrUtil
/*     */ {
/*     */   public static void setXAttr(String paramString1, String paramString2, String paramString3) throws IOException {
/*  56 */     setXAttr(paramString1, paramString2, paramString3, Native.getDefaultStringEncoding());
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
/*     */   public static void setXAttr(String paramString1, String paramString2, String paramString3, String paramString4) throws IOException {
/*  70 */     setXAttr(paramString1, paramString2, paramString3.getBytes(paramString4));
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
/*     */   public static void setXAttr(String paramString1, String paramString2, byte[] paramArrayOfbyte) throws IOException {
/*  82 */     int i = XAttr.INSTANCE.setxattr(paramString1, paramString2, paramArrayOfbyte, new XAttr.size_t(paramArrayOfbyte.length), 0);
/*  83 */     if (i != 0) {
/*  84 */       int j = Native.getLastError();
/*  85 */       throw new IOException("errno: " + j);
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
/*     */   public static void lSetXAttr(String paramString1, String paramString2, String paramString3) throws IOException {
/* 100 */     lSetXAttr(paramString1, paramString2, paramString3, Native.getDefaultStringEncoding());
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
/*     */   public static void lSetXAttr(String paramString1, String paramString2, String paramString3, String paramString4) throws IOException {
/* 115 */     lSetXAttr(paramString1, paramString2, paramString3.getBytes(paramString4));
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
/*     */   public static void lSetXAttr(String paramString1, String paramString2, byte[] paramArrayOfbyte) throws IOException {
/* 128 */     int i = XAttr.INSTANCE.lsetxattr(paramString1, paramString2, paramArrayOfbyte, new XAttr.size_t(paramArrayOfbyte.length), 0);
/* 129 */     if (i != 0) {
/* 130 */       int j = Native.getLastError();
/* 131 */       throw new IOException("errno: " + j);
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
/*     */   public static void fSetXAttr(int paramInt, String paramString1, String paramString2) throws IOException {
/* 145 */     fSetXAttr(paramInt, paramString1, paramString2, Native.getDefaultStringEncoding());
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
/*     */   public static void fSetXAttr(int paramInt, String paramString1, String paramString2, String paramString3) throws IOException {
/* 159 */     fSetXAttr(paramInt, paramString1, paramString2.getBytes(paramString3));
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
/*     */   public static void fSetXAttr(int paramInt, String paramString, byte[] paramArrayOfbyte) throws IOException {
/* 171 */     int i = XAttr.INSTANCE.fsetxattr(paramInt, paramString, paramArrayOfbyte, new XAttr.size_t(paramArrayOfbyte.length), 0);
/* 172 */     if (i != 0) {
/* 173 */       int j = Native.getLastError();
/* 174 */       throw new IOException("errno: " + j);
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
/*     */   public static String getXAttr(String paramString1, String paramString2) throws IOException {
/* 188 */     return getXAttr(paramString1, paramString2, Native.getDefaultStringEncoding());
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
/*     */   public static String getXAttr(String paramString1, String paramString2, String paramString3) throws IOException {
/* 201 */     byte[] arrayOfByte = getXAttrBytes(paramString1, paramString2);
/* 202 */     return new String(arrayOfByte, Charset.forName(paramString3));
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
/*     */   public static byte[] getXAttrBytes(String paramString1, String paramString2) throws IOException {
/*     */     XAttr.ssize_t ssize_t;
/*     */     byte[] arrayOfByte;
/* 216 */     int i = 0;
/*     */     
/*     */     do {
/* 219 */       ssize_t = XAttr.INSTANCE.getxattr(paramString1, paramString2, (byte[])null, XAttr.size_t.ZERO);
/* 220 */       if (ssize_t.longValue() < 0L) {
/* 221 */         i = Native.getLastError();
/* 222 */         throw new IOException("errno: " + i);
/*     */       } 
/*     */       
/* 225 */       arrayOfByte = new byte[ssize_t.intValue()];
/* 226 */       ssize_t = XAttr.INSTANCE.getxattr(paramString1, paramString2, arrayOfByte, new XAttr.size_t(arrayOfByte.length));
/* 227 */       if (ssize_t.longValue() >= 0L)
/* 228 */         continue;  i = Native.getLastError();
/* 229 */       if (i != 34) {
/* 230 */         throw new IOException("errno: " + i);
/*     */       }
/*     */     }
/* 233 */     while (ssize_t.longValue() < 0L && i == 34);
/*     */     
/* 235 */     return arrayOfByte;
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
/*     */   public static Memory getXAttrAsMemory(String paramString1, String paramString2) throws IOException {
/*     */     XAttr.ssize_t ssize_t;
/*     */     Memory memory;
/* 249 */     int i = 0;
/*     */     
/*     */     do {
/* 252 */       ssize_t = XAttr.INSTANCE.getxattr(paramString1, paramString2, (Pointer)null, XAttr.size_t.ZERO);
/* 253 */       if (ssize_t.longValue() < 0L) {
/* 254 */         i = Native.getLastError();
/* 255 */         throw new IOException("errno: " + i);
/*     */       } 
/*     */       
/* 258 */       if (ssize_t.longValue() == 0L) {
/* 259 */         return null;
/*     */       }
/*     */       
/* 262 */       memory = new Memory(ssize_t.longValue());
/* 263 */       ssize_t = XAttr.INSTANCE.getxattr(paramString1, paramString2, (Pointer)memory, new XAttr.size_t(memory.size()));
/* 264 */       if (ssize_t.longValue() >= 0L)
/* 265 */         continue;  i = Native.getLastError();
/* 266 */       if (i != 34) {
/* 267 */         throw new IOException("errno: " + i);
/*     */       }
/*     */     }
/* 270 */     while (ssize_t.longValue() < 0L && i == 34);
/*     */     
/* 272 */     return memory;
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
/*     */   public static String lGetXAttr(String paramString1, String paramString2) throws IOException {
/* 286 */     return lGetXAttr(paramString1, paramString2, Native.getDefaultStringEncoding());
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
/*     */   public static String lGetXAttr(String paramString1, String paramString2, String paramString3) throws IOException {
/* 300 */     byte[] arrayOfByte = lGetXAttrBytes(paramString1, paramString2);
/* 301 */     return new String(arrayOfByte, Charset.forName(paramString3));
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
/*     */   public static byte[] lGetXAttrBytes(String paramString1, String paramString2) throws IOException {
/*     */     XAttr.ssize_t ssize_t;
/*     */     byte[] arrayOfByte;
/* 316 */     int i = 0;
/*     */     
/*     */     do {
/* 319 */       ssize_t = XAttr.INSTANCE.lgetxattr(paramString1, paramString2, (byte[])null, XAttr.size_t.ZERO);
/* 320 */       if (ssize_t.longValue() < 0L) {
/* 321 */         i = Native.getLastError();
/* 322 */         throw new IOException("errno: " + i);
/*     */       } 
/*     */       
/* 325 */       arrayOfByte = new byte[ssize_t.intValue()];
/* 326 */       ssize_t = XAttr.INSTANCE.lgetxattr(paramString1, paramString2, arrayOfByte, new XAttr.size_t(arrayOfByte.length));
/* 327 */       if (ssize_t.longValue() >= 0L)
/* 328 */         continue;  i = Native.getLastError();
/* 329 */       if (i != 34) {
/* 330 */         throw new IOException("errno: " + i);
/*     */       }
/*     */     }
/* 333 */     while (ssize_t.longValue() < 0L && i == 34);
/*     */     
/* 335 */     return arrayOfByte;
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
/*     */   public static Memory lGetXAttrAsMemory(String paramString1, String paramString2) throws IOException {
/*     */     XAttr.ssize_t ssize_t;
/*     */     Memory memory;
/* 350 */     int i = 0;
/*     */     
/*     */     do {
/* 353 */       ssize_t = XAttr.INSTANCE.lgetxattr(paramString1, paramString2, (Pointer)null, XAttr.size_t.ZERO);
/* 354 */       if (ssize_t.longValue() < 0L) {
/* 355 */         i = Native.getLastError();
/* 356 */         throw new IOException("errno: " + i);
/*     */       } 
/*     */       
/* 359 */       if (ssize_t.longValue() == 0L) {
/* 360 */         return null;
/*     */       }
/*     */       
/* 363 */       memory = new Memory(ssize_t.longValue());
/* 364 */       ssize_t = XAttr.INSTANCE.lgetxattr(paramString1, paramString2, (Pointer)memory, new XAttr.size_t(memory.size()));
/* 365 */       if (ssize_t.longValue() >= 0L)
/* 366 */         continue;  i = Native.getLastError();
/* 367 */       if (i != 34) {
/* 368 */         throw new IOException("errno: " + i);
/*     */       }
/*     */     }
/* 371 */     while (ssize_t.longValue() < 0L && i == 34);
/*     */     
/* 373 */     return memory;
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
/*     */   public static String fGetXAttr(int paramInt, String paramString) throws IOException {
/* 386 */     return fGetXAttr(paramInt, paramString, Native.getDefaultStringEncoding());
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
/*     */   public static String fGetXAttr(int paramInt, String paramString1, String paramString2) throws IOException {
/* 399 */     byte[] arrayOfByte = fGetXAttrBytes(paramInt, paramString1);
/* 400 */     return new String(arrayOfByte, Charset.forName(paramString2));
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
/*     */   public static byte[] fGetXAttrBytes(int paramInt, String paramString) throws IOException {
/*     */     XAttr.ssize_t ssize_t;
/*     */     byte[] arrayOfByte;
/* 414 */     int i = 0;
/*     */     
/*     */     do {
/* 417 */       ssize_t = XAttr.INSTANCE.fgetxattr(paramInt, paramString, (byte[])null, XAttr.size_t.ZERO);
/* 418 */       if (ssize_t.longValue() < 0L) {
/* 419 */         i = Native.getLastError();
/* 420 */         throw new IOException("errno: " + i);
/*     */       } 
/*     */       
/* 423 */       arrayOfByte = new byte[ssize_t.intValue()];
/* 424 */       ssize_t = XAttr.INSTANCE.fgetxattr(paramInt, paramString, arrayOfByte, new XAttr.size_t(arrayOfByte.length));
/* 425 */       if (ssize_t.longValue() >= 0L)
/* 426 */         continue;  i = Native.getLastError();
/* 427 */       if (i != 34) {
/* 428 */         throw new IOException("errno: " + i);
/*     */       }
/*     */     }
/* 431 */     while (ssize_t.longValue() < 0L && i == 34);
/*     */     
/* 433 */     return arrayOfByte;
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
/*     */   public static Memory fGetXAttrAsMemory(int paramInt, String paramString) throws IOException {
/*     */     XAttr.ssize_t ssize_t;
/*     */     Memory memory;
/* 447 */     int i = 0;
/*     */     
/*     */     do {
/* 450 */       ssize_t = XAttr.INSTANCE.fgetxattr(paramInt, paramString, (Pointer)null, XAttr.size_t.ZERO);
/* 451 */       if (ssize_t.longValue() < 0L) {
/* 452 */         i = Native.getLastError();
/* 453 */         throw new IOException("errno: " + i);
/*     */       } 
/*     */       
/* 456 */       if (ssize_t.longValue() == 0L) {
/* 457 */         return null;
/*     */       }
/*     */       
/* 460 */       memory = new Memory(ssize_t.longValue());
/* 461 */       ssize_t = XAttr.INSTANCE.fgetxattr(paramInt, paramString, (Pointer)memory, new XAttr.size_t(memory.size()));
/* 462 */       if (ssize_t.longValue() >= 0L)
/* 463 */         continue;  i = Native.getLastError();
/* 464 */       if (i != 34) {
/* 465 */         throw new IOException("errno: " + i);
/*     */       }
/*     */     }
/* 468 */     while (ssize_t.longValue() < 0L && i == 34);
/*     */     
/* 470 */     return memory;
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
/*     */   public static Collection<String> listXAttr(String paramString) throws IOException {
/* 482 */     return listXAttr(paramString, Native.getDefaultStringEncoding());
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
/*     */   public static Collection<String> listXAttr(String paramString1, String paramString2) throws IOException {
/*     */     XAttr.ssize_t ssize_t;
/*     */     byte[] arrayOfByte;
/* 496 */     int i = 0;
/*     */     
/*     */     do {
/* 499 */       ssize_t = XAttr.INSTANCE.listxattr(paramString1, (byte[])null, XAttr.size_t.ZERO);
/* 500 */       if (ssize_t.longValue() < 0L) {
/* 501 */         i = Native.getLastError();
/* 502 */         throw new IOException("errno: " + i);
/*     */       } 
/*     */       
/* 505 */       arrayOfByte = new byte[ssize_t.intValue()];
/* 506 */       ssize_t = XAttr.INSTANCE.listxattr(paramString1, arrayOfByte, new XAttr.size_t(arrayOfByte.length));
/* 507 */       if (ssize_t.longValue() >= 0L)
/* 508 */         continue;  i = Native.getLastError();
/* 509 */       if (i != 34) {
/* 510 */         throw new IOException("errno: " + i);
/*     */       }
/*     */     }
/* 513 */     while (ssize_t.longValue() < 0L && i == 34);
/*     */     
/* 515 */     return splitBufferToStrings(arrayOfByte, paramString2);
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
/*     */   public static Collection<String> lListXAttr(String paramString) throws IOException {
/* 528 */     return lListXAttr(paramString, Native.getDefaultStringEncoding());
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
/*     */   public static Collection<String> lListXAttr(String paramString1, String paramString2) throws IOException {
/*     */     XAttr.ssize_t ssize_t;
/*     */     byte[] arrayOfByte;
/* 543 */     int i = 0;
/*     */     
/*     */     do {
/* 546 */       ssize_t = XAttr.INSTANCE.llistxattr(paramString1, (byte[])null, XAttr.size_t.ZERO);
/* 547 */       if (ssize_t.longValue() < 0L) {
/* 548 */         i = Native.getLastError();
/* 549 */         throw new IOException("errno: " + i);
/*     */       } 
/*     */       
/* 552 */       arrayOfByte = new byte[ssize_t.intValue()];
/* 553 */       ssize_t = XAttr.INSTANCE.llistxattr(paramString1, arrayOfByte, new XAttr.size_t(arrayOfByte.length));
/* 554 */       if (ssize_t.longValue() >= 0L)
/* 555 */         continue;  i = Native.getLastError();
/* 556 */       if (i != 34) {
/* 557 */         throw new IOException("errno: " + i);
/*     */       }
/*     */     }
/* 560 */     while (ssize_t.longValue() < 0L && i == 34);
/*     */     
/* 562 */     return splitBufferToStrings(arrayOfByte, paramString2);
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
/*     */   public static Collection<String> fListXAttr(int paramInt) throws IOException {
/* 574 */     return fListXAttr(paramInt, Native.getDefaultStringEncoding());
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
/*     */   public static Collection<String> fListXAttr(int paramInt, String paramString) throws IOException {
/*     */     XAttr.ssize_t ssize_t;
/*     */     byte[] arrayOfByte;
/* 588 */     int i = 0;
/*     */     
/*     */     do {
/* 591 */       ssize_t = XAttr.INSTANCE.flistxattr(paramInt, (byte[])null, XAttr.size_t.ZERO);
/* 592 */       if (ssize_t.longValue() < 0L) {
/* 593 */         i = Native.getLastError();
/* 594 */         throw new IOException("errno: " + i);
/*     */       } 
/*     */       
/* 597 */       arrayOfByte = new byte[ssize_t.intValue()];
/* 598 */       ssize_t = XAttr.INSTANCE.flistxattr(paramInt, arrayOfByte, new XAttr.size_t(arrayOfByte.length));
/* 599 */       if (ssize_t.longValue() >= 0L)
/* 600 */         continue;  i = Native.getLastError();
/* 601 */       if (i != 34) {
/* 602 */         throw new IOException("errno: " + i);
/*     */       }
/*     */     }
/* 605 */     while (ssize_t.longValue() < 0L && i == 34);
/*     */     
/* 607 */     return splitBufferToStrings(arrayOfByte, paramString);
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
/*     */   public static void removeXAttr(String paramString1, String paramString2) throws IOException {
/* 619 */     int i = XAttr.INSTANCE.removexattr(paramString1, paramString2);
/* 620 */     if (i != 0) {
/* 621 */       int j = Native.getLastError();
/* 622 */       throw new IOException("errno: " + j);
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
/*     */   public static void lRemoveXAttr(String paramString1, String paramString2) throws IOException {
/* 635 */     int i = XAttr.INSTANCE.lremovexattr(paramString1, paramString2);
/* 636 */     if (i != 0) {
/* 637 */       int j = Native.getLastError();
/* 638 */       throw new IOException("errno: " + j);
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
/*     */   public static void fRemoveXAttr(int paramInt, String paramString) throws IOException {
/* 650 */     int i = XAttr.INSTANCE.fremovexattr(paramInt, paramString);
/* 651 */     if (i != 0) {
/* 652 */       int j = Native.getLastError();
/* 653 */       throw new IOException("errno: " + j);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static Collection<String> splitBufferToStrings(byte[] paramArrayOfbyte, String paramString) throws IOException {
/* 659 */     Charset charset = Charset.forName(paramString);
/* 660 */     LinkedHashSet<String> linkedHashSet = new LinkedHashSet(1);
/* 661 */     int i = 0;
/* 662 */     for (byte b = 0; b < paramArrayOfbyte.length; b++) {
/*     */       
/* 664 */       if (paramArrayOfbyte[b] == 0) {
/*     */         
/* 666 */         String str = new String(paramArrayOfbyte, i, b - i, charset);
/* 667 */         linkedHashSet.add(str);
/* 668 */         i = b + 1;
/*     */       } 
/*     */     } 
/* 671 */     return linkedHashSet;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\linux\XAttrUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */