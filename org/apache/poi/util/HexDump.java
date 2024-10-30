/*     */ package org.apache.poi.util;
/*     */ 
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.io.PrintStream;
/*     */ import java.nio.charset.Charset;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Internal
/*     */ public class HexDump
/*     */ {
/*  38 */   public static final String EOL = System.getProperty("line.separator");
/*  39 */   public static final Charset UTF8 = Charset.forName("UTF-8");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void dump(byte[] paramArrayOfbyte, long paramLong, OutputStream paramOutputStream, int paramInt1, int paramInt2) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
/*  65 */     if (paramOutputStream == null) {
/*  66 */       throw new IllegalArgumentException("cannot write to nullstream");
/*     */     }
/*     */     
/*  69 */     OutputStreamWriter outputStreamWriter = new OutputStreamWriter(paramOutputStream, UTF8);
/*  70 */     outputStreamWriter.write(dump(paramArrayOfbyte, paramLong, paramInt1, paramInt2));
/*  71 */     outputStreamWriter.flush();
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
/*     */   public static synchronized void dump(byte[] paramArrayOfbyte, long paramLong, OutputStream paramOutputStream, int paramInt) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
/*  94 */     dump(paramArrayOfbyte, paramLong, paramOutputStream, paramInt, 2147483647);
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
/*     */   public static String dump(byte[] paramArrayOfbyte, long paramLong, int paramInt) {
/* 110 */     return dump(paramArrayOfbyte, paramLong, paramInt, 2147483647);
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
/*     */   public static String dump(byte[] paramArrayOfbyte, long paramLong, int paramInt1, int paramInt2) {
/* 127 */     if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0) {
/* 128 */       return "No Data" + EOL;
/*     */     }
/*     */     
/* 131 */     int i = (paramInt2 == Integer.MAX_VALUE || paramInt2 < 0 || paramInt1 + paramInt2 < 0) ? paramArrayOfbyte.length : Math.min(paramArrayOfbyte.length, paramInt1 + paramInt2);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 136 */     if (paramInt1 < 0 || paramInt1 >= paramArrayOfbyte.length) {
/* 137 */       String str = "illegal index: " + paramInt1 + " into array of length " + paramArrayOfbyte.length;
/* 138 */       throw new ArrayIndexOutOfBoundsException(str);
/*     */     } 
/*     */     
/* 141 */     long l = paramLong + paramInt1;
/* 142 */     StringBuilder stringBuilder = new StringBuilder(74);
/*     */     
/* 144 */     for (int j = paramInt1; j < i; j += 16) {
/* 145 */       int k = i - j;
/*     */       
/* 147 */       if (k > 16) {
/* 148 */         k = 16;
/*     */       }
/*     */       
/* 151 */       writeHex(stringBuilder, l, 8, ""); byte b;
/* 152 */       for (b = 0; b < 16; b++) {
/* 153 */         if (b < k) {
/* 154 */           writeHex(stringBuilder, paramArrayOfbyte[b + j], 2, " ");
/*     */         } else {
/* 156 */           stringBuilder.append("   ");
/*     */         } 
/*     */       } 
/* 159 */       stringBuilder.append(' ');
/* 160 */       for (b = 0; b < k; b++) {
/* 161 */         stringBuilder.append(toAscii(paramArrayOfbyte[b + j]));
/*     */       }
/* 163 */       stringBuilder.append(EOL);
/* 164 */       l += k;
/*     */     } 
/* 166 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public static char toAscii(int paramInt) {
/* 170 */     char c = (char)(paramInt & 0xFF);
/* 171 */     if (Character.isISOControl(c)) return '.';
/*     */     
/* 173 */     switch (c) {
/*     */       
/*     */       case 'Ý':
/*     */       case 'ÿ':
/* 177 */         c = '.';
/*     */         break;
/*     */     } 
/*     */ 
/*     */     
/* 182 */     return c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String toHex(byte[] paramArrayOfbyte) {
/* 193 */     StringBuilder stringBuilder = new StringBuilder();
/* 194 */     stringBuilder.append('[');
/* 195 */     if (paramArrayOfbyte != null && paramArrayOfbyte.length > 0)
/*     */     {
/* 197 */       for (byte b = 0; b < paramArrayOfbyte.length; b++) {
/*     */         
/* 199 */         if (b > 0) {
/* 200 */           stringBuilder.append(", ");
/*     */         }
/* 202 */         stringBuilder.append(toHex(paramArrayOfbyte[b]));
/*     */       } 
/*     */     }
/* 205 */     stringBuilder.append(']');
/* 206 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String toHex(short[] paramArrayOfshort) {
/* 217 */     StringBuilder stringBuilder = new StringBuilder();
/* 218 */     stringBuilder.append('[');
/* 219 */     for (byte b = 0; b < paramArrayOfshort.length; b++) {
/*     */       
/* 221 */       if (b > 0) {
/* 222 */         stringBuilder.append(", ");
/*     */       }
/* 224 */       stringBuilder.append(toHex(paramArrayOfshort[b]));
/*     */     } 
/* 226 */     stringBuilder.append(']');
/* 227 */     return stringBuilder.toString();
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
/*     */   public static String toHex(byte[] paramArrayOfbyte, int paramInt) {
/* 240 */     if (paramArrayOfbyte.length == 0) {
/* 241 */       return ": 0";
/*     */     }
/* 243 */     int i = (int)Math.round(Math.log(paramArrayOfbyte.length) / Math.log(10.0D) + 0.5D);
/* 244 */     StringBuilder stringBuilder = new StringBuilder();
/* 245 */     writeHex(stringBuilder, 0L, i, "");
/* 246 */     stringBuilder.append(": "); byte b; byte b1;
/* 247 */     for (b = 0, b1 = -1; b < paramArrayOfbyte.length; b++) {
/* 248 */       if (++b1 == paramInt) {
/* 249 */         stringBuilder.append('\n');
/* 250 */         writeHex(stringBuilder, b, i, "");
/* 251 */         stringBuilder.append(": ");
/* 252 */         b1 = 0;
/* 253 */       } else if (b > 0) {
/* 254 */         stringBuilder.append(", ");
/*     */       } 
/* 256 */       stringBuilder.append(toHex(paramArrayOfbyte[b]));
/*     */     } 
/* 258 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String toHex(short paramShort) {
/* 268 */     StringBuilder stringBuilder = new StringBuilder(4);
/* 269 */     writeHex(stringBuilder, (paramShort & 0xFFFF), 4, "");
/* 270 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String toHex(byte paramByte) {
/* 280 */     StringBuilder stringBuilder = new StringBuilder(2);
/* 281 */     writeHex(stringBuilder, (paramByte & 0xFF), 2, "");
/* 282 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String toHex(int paramInt) {
/* 292 */     StringBuilder stringBuilder = new StringBuilder(8);
/* 293 */     writeHex(stringBuilder, paramInt & 0xFFFFFFFFL, 8, "");
/* 294 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String toHex(long paramLong) {
/* 304 */     StringBuilder stringBuilder = new StringBuilder(16);
/* 305 */     writeHex(stringBuilder, paramLong, 16, "");
/* 306 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String toHex(String paramString) {
/* 316 */     return (paramString == null || paramString.length() == 0) ? "[]" : toHex(paramString.getBytes(LocaleUtil.CHARSET_1252));
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
/*     */   public static void dump(InputStream paramInputStream, PrintStream paramPrintStream, int paramInt1, int paramInt2) throws IOException {
/* 331 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 332 */     if (paramInt2 == -1) {
/*     */       
/* 334 */       int i = paramInputStream.read();
/* 335 */       while (i != -1)
/*     */       {
/* 337 */         byteArrayOutputStream.write(i);
/* 338 */         i = paramInputStream.read();
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 343 */       int i = paramInt2;
/* 344 */       while (i-- > 0) {
/*     */         
/* 346 */         int j = paramInputStream.read();
/* 347 */         if (j == -1) {
/*     */           break;
/*     */         }
/* 350 */         byteArrayOutputStream.write(j);
/*     */       } 
/*     */     } 
/*     */     
/* 354 */     byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
/* 355 */     dump(arrayOfByte, 0L, paramPrintStream, paramInt1, arrayOfByte.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String longToHex(long paramLong) {
/* 362 */     StringBuilder stringBuilder = new StringBuilder(18);
/* 363 */     writeHex(stringBuilder, paramLong, 16, "0x");
/* 364 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String intToHex(int paramInt) {
/* 371 */     StringBuilder stringBuilder = new StringBuilder(10);
/* 372 */     writeHex(stringBuilder, paramInt & 0xFFFFFFFFL, 8, "0x");
/* 373 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String shortToHex(int paramInt) {
/* 380 */     StringBuilder stringBuilder = new StringBuilder(6);
/* 381 */     writeHex(stringBuilder, paramInt & 0xFFFFL, 4, "0x");
/* 382 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String byteToHex(int paramInt) {
/* 389 */     StringBuilder stringBuilder = new StringBuilder(4);
/* 390 */     writeHex(stringBuilder, paramInt & 0xFFL, 2, "0x");
/* 391 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void writeHex(StringBuilder paramStringBuilder, long paramLong, int paramInt, String paramString) {
/* 399 */     paramStringBuilder.append(paramString);
/* 400 */     char[] arrayOfChar = new char[paramInt];
/* 401 */     long l = paramLong;
/* 402 */     for (int i = paramInt - 1; i >= 0; i--) {
/* 403 */       int j = (int)(l & 0xFL);
/* 404 */       arrayOfChar[i] = (char)((j < 10) ? (48 + j) : (65 + j - 10));
/* 405 */       l >>>= 4L;
/*     */     } 
/* 407 */     paramStringBuilder.append(arrayOfChar);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void main(String[] paramArrayOfString) throws Exception {
/* 412 */     File file = new File(paramArrayOfString[0]);
/* 413 */     BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
/* 414 */     byte[] arrayOfByte = new byte[(int)file.length()];
/* 415 */     bufferedInputStream.read(arrayOfByte);
/* 416 */     System.out.println(dump(arrayOfByte, 0L, 0));
/* 417 */     bufferedInputStream.close();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\HexDump.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */