/*     */ package org.apache.poi.hpsf;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.StringWriter;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import org.apache.poi.util.SuppressForbidden;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Util
/*     */ {
/*     */   public static final long EPOCH_DIFF = 11644473600000L;
/*     */   
/*     */   public static boolean equal(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/*  56 */     if (paramArrayOfbyte1.length != paramArrayOfbyte2.length)
/*  57 */       return false; 
/*  58 */     for (byte b = 0; b < paramArrayOfbyte1.length; b++) {
/*  59 */       if (paramArrayOfbyte1[b] != paramArrayOfbyte2[b])
/*  60 */         return false; 
/*  61 */     }  return true;
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
/*     */   public static void copy(byte[] paramArrayOfbyte1, int paramInt1, int paramInt2, byte[] paramArrayOfbyte2, int paramInt3) {
/*  79 */     for (byte b = 0; b < paramInt2; b++) {
/*  80 */       paramArrayOfbyte2[paramInt3 + b] = paramArrayOfbyte1[paramInt1 + b];
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
/*     */   public static byte[] cat(byte[][] paramArrayOfbyte) {
/*  95 */     int i = 0;
/*  96 */     for (byte b1 = 0; b1 < paramArrayOfbyte.length; b1++)
/*  97 */       i += (paramArrayOfbyte[b1]).length; 
/*  98 */     byte[] arrayOfByte = new byte[i];
/*  99 */     byte b2 = 0;
/* 100 */     for (byte b3 = 0; b3 < paramArrayOfbyte.length; b3++) {
/* 101 */       for (byte b = 0; b < (paramArrayOfbyte[b3]).length; b++)
/* 102 */         arrayOfByte[b2++] = paramArrayOfbyte[b3][b]; 
/* 103 */     }  return arrayOfByte;
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
/*     */   public static byte[] copy(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 120 */     byte[] arrayOfByte = new byte[paramInt2];
/* 121 */     copy(paramArrayOfbyte, paramInt1, paramInt2, arrayOfByte, 0);
/* 122 */     return arrayOfByte;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Date filetimeToDate(int paramInt1, int paramInt2) {
/* 152 */     long l = paramInt1 << 32L | paramInt2 & 0xFFFFFFFFL;
/* 153 */     return filetimeToDate(l);
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
/*     */   public static Date filetimeToDate(long paramLong) {
/* 168 */     long l1 = paramLong / 10000L;
/* 169 */     long l2 = l1 - 11644473600000L;
/* 170 */     return new Date(l2);
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
/*     */   public static long dateToFileTime(Date paramDate) {
/* 186 */     long l1 = paramDate.getTime();
/* 187 */     long l2 = l1 + 11644473600000L;
/* 188 */     return l2 * 10000L;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean equals(Collection<?> paramCollection1, Collection<?> paramCollection2) {
/* 216 */     Object[] arrayOfObject1 = paramCollection1.toArray();
/* 217 */     Object[] arrayOfObject2 = paramCollection2.toArray();
/* 218 */     return internalEquals(arrayOfObject1, arrayOfObject2);
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
/*     */   public static boolean equals(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2) {
/* 234 */     Object[] arrayOfObject1 = (Object[])paramArrayOfObject1.clone();
/* 235 */     Object[] arrayOfObject2 = (Object[])paramArrayOfObject2.clone();
/* 236 */     return internalEquals(arrayOfObject1, arrayOfObject2);
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean internalEquals(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2) {
/* 241 */     for (byte b = 0; b < paramArrayOfObject1.length; b++) {
/*     */       
/* 243 */       Object object = paramArrayOfObject1[b];
/* 244 */       boolean bool = false;
/* 245 */       for (byte b1 = 0; !bool && b1 < paramArrayOfObject1.length; b1++) {
/*     */         
/* 247 */         Object object1 = paramArrayOfObject2[b1];
/* 248 */         if (object.equals(object1)) {
/*     */           
/* 250 */           bool = true;
/* 251 */           paramArrayOfObject2[b1] = null;
/*     */         } 
/*     */       } 
/* 254 */       if (!bool)
/* 255 */         return false; 
/*     */     } 
/* 257 */     return true;
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
/*     */   public static byte[] pad4(byte[] paramArrayOfbyte) {
/*     */     byte[] arrayOfByte;
/* 271 */     byte b = 4;
/*     */     
/* 273 */     int i = paramArrayOfbyte.length % 4;
/* 274 */     if (i == 0) {
/* 275 */       arrayOfByte = paramArrayOfbyte;
/*     */     } else {
/*     */       
/* 278 */       i = 4 - i;
/* 279 */       arrayOfByte = new byte[paramArrayOfbyte.length + i];
/* 280 */       System.arraycopy(paramArrayOfbyte, 0, arrayOfByte, 0, paramArrayOfbyte.length);
/*     */     } 
/* 282 */     return arrayOfByte;
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
/*     */   public static char[] pad4(char[] paramArrayOfchar) {
/*     */     char[] arrayOfChar;
/* 296 */     byte b = 4;
/*     */     
/* 298 */     int i = paramArrayOfchar.length % 4;
/* 299 */     if (i == 0) {
/* 300 */       arrayOfChar = paramArrayOfchar;
/*     */     } else {
/*     */       
/* 303 */       i = 4 - i;
/* 304 */       arrayOfChar = new char[paramArrayOfchar.length + i];
/* 305 */       System.arraycopy(paramArrayOfchar, 0, arrayOfChar, 0, paramArrayOfchar.length);
/*     */     } 
/* 307 */     return arrayOfChar;
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
/*     */   public static char[] pad4(String paramString) {
/* 321 */     return pad4(paramString.toCharArray());
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
/*     */   @SuppressForbidden("uses printStackTrace")
/*     */   public static String toString(Throwable paramThrowable) {
/* 338 */     StringWriter stringWriter = new StringWriter();
/* 339 */     PrintWriter printWriter = new PrintWriter(stringWriter);
/* 340 */     paramThrowable.printStackTrace(printWriter);
/* 341 */     printWriter.close();
/*     */     
/*     */     try {
/* 344 */       stringWriter.close();
/* 345 */       return stringWriter.toString();
/*     */     }
/* 347 */     catch (IOException iOException) {
/*     */       
/* 349 */       StringBuffer stringBuffer = new StringBuffer(paramThrowable.getMessage());
/* 350 */       stringBuffer.append("\n");
/* 351 */       stringBuffer.append("Could not create a stacktrace. Reason: ");
/* 352 */       stringBuffer.append(iOException.getMessage());
/* 353 */       return stringBuffer.toString();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */