/*     */ package org.h2.tools;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.zip.DeflaterOutputStream;
/*     */ import java.util.zip.GZIPInputStream;
/*     */ import java.util.zip.GZIPOutputStream;
/*     */ import java.util.zip.InflaterInputStream;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipInputStream;
/*     */ import java.util.zip.ZipOutputStream;
/*     */ import org.h2.compress.CompressDeflate;
/*     */ import org.h2.compress.CompressLZF;
/*     */ import org.h2.compress.CompressNo;
/*     */ import org.h2.compress.Compressor;
/*     */ import org.h2.compress.LZFInputStream;
/*     */ import org.h2.compress.LZFOutputStream;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.mvstore.DataUtils;
/*     */ import org.h2.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CompressTool
/*     */ {
/*     */   private static final int MAX_BUFFER_SIZE = 393216;
/*     */   private byte[] cachedBuffer;
/*     */   
/*     */   private byte[] getBuffer(int paramInt) {
/*  45 */     if (paramInt > 393216) {
/*  46 */       return DataUtils.newBytes(paramInt);
/*     */     }
/*  48 */     if (this.cachedBuffer == null || this.cachedBuffer.length < paramInt) {
/*  49 */       this.cachedBuffer = DataUtils.newBytes(paramInt);
/*     */     }
/*  51 */     return this.cachedBuffer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CompressTool getInstance() {
/*  62 */     return new CompressTool();
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
/*     */   public byte[] compress(byte[] paramArrayOfbyte, String paramString) {
/*  74 */     int i = paramArrayOfbyte.length;
/*  75 */     if (paramArrayOfbyte.length < 5) {
/*  76 */       paramString = "NO";
/*     */     }
/*  78 */     Compressor compressor = getCompressor(paramString);
/*  79 */     byte[] arrayOfByte1 = getBuffer(((i < 100) ? (i + 100) : i) * 2);
/*  80 */     int j = compress(paramArrayOfbyte, paramArrayOfbyte.length, compressor, arrayOfByte1);
/*  81 */     byte[] arrayOfByte2 = DataUtils.newBytes(j);
/*  82 */     System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, j);
/*  83 */     return arrayOfByte2;
/*     */   }
/*     */ 
/*     */   
/*     */   private static int compress(byte[] paramArrayOfbyte1, int paramInt, Compressor paramCompressor, byte[] paramArrayOfbyte2) {
/*  88 */     int i = 0;
/*  89 */     paramArrayOfbyte2[0] = (byte)paramCompressor.getAlgorithm();
/*  90 */     int j = 1 + writeVariableInt(paramArrayOfbyte2, 1, paramInt);
/*  91 */     i = paramCompressor.compress(paramArrayOfbyte1, paramInt, paramArrayOfbyte2, j);
/*  92 */     if (i > paramInt + j || i <= 0) {
/*  93 */       paramArrayOfbyte2[0] = 0;
/*  94 */       System.arraycopy(paramArrayOfbyte1, 0, paramArrayOfbyte2, j, paramInt);
/*  95 */       i = paramInt + j;
/*     */     } 
/*  97 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] expand(byte[] paramArrayOfbyte) {
/* 107 */     byte b = paramArrayOfbyte[0];
/* 108 */     Compressor compressor = getCompressor(b);
/*     */     try {
/* 110 */       int i = readVariableInt(paramArrayOfbyte, 1);
/* 111 */       int j = 1 + getVariableIntLength(i);
/* 112 */       byte[] arrayOfByte = DataUtils.newBytes(i);
/* 113 */       compressor.expand(paramArrayOfbyte, j, paramArrayOfbyte.length - j, arrayOfByte, 0, i);
/* 114 */       return arrayOfByte;
/* 115 */     } catch (Exception exception) {
/* 116 */       throw DbException.get(90104, exception, new String[0]);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void expand(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, int paramInt) {
/* 124 */     byte b = paramArrayOfbyte1[0];
/* 125 */     Compressor compressor = getCompressor(b);
/*     */     try {
/* 127 */       int i = readVariableInt(paramArrayOfbyte1, 1);
/* 128 */       int j = 1 + getVariableIntLength(i);
/* 129 */       compressor.expand(paramArrayOfbyte1, j, paramArrayOfbyte1.length - j, paramArrayOfbyte2, paramInt, i);
/* 130 */     } catch (Exception exception) {
/* 131 */       throw DbException.get(90104, exception, new String[0]);
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
/*     */   public static int readVariableInt(byte[] paramArrayOfbyte, int paramInt) {
/* 143 */     int i = paramArrayOfbyte[paramInt++] & 0xFF;
/* 144 */     if (i < 128) {
/* 145 */       return i;
/*     */     }
/* 147 */     if (i < 192) {
/* 148 */       return ((i & 0x3F) << 8) + (paramArrayOfbyte[paramInt] & 0xFF);
/*     */     }
/* 150 */     if (i < 224) {
/* 151 */       return ((i & 0x1F) << 16) + ((paramArrayOfbyte[paramInt++] & 0xFF) << 8) + (paramArrayOfbyte[paramInt] & 0xFF);
/*     */     }
/*     */ 
/*     */     
/* 155 */     if (i < 240) {
/* 156 */       return ((i & 0xF) << 24) + ((paramArrayOfbyte[paramInt++] & 0xFF) << 16) + ((paramArrayOfbyte[paramInt++] & 0xFF) << 8) + (paramArrayOfbyte[paramInt] & 0xFF);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 161 */     return ((paramArrayOfbyte[paramInt++] & 0xFF) << 24) + ((paramArrayOfbyte[paramInt++] & 0xFF) << 16) + ((paramArrayOfbyte[paramInt++] & 0xFF) << 8) + (paramArrayOfbyte[paramInt] & 0xFF);
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
/*     */   public static int writeVariableInt(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 177 */     if (paramInt2 < 0) {
/* 178 */       paramArrayOfbyte[paramInt1++] = -16;
/* 179 */       paramArrayOfbyte[paramInt1++] = (byte)(paramInt2 >> 24);
/* 180 */       paramArrayOfbyte[paramInt1++] = (byte)(paramInt2 >> 16);
/* 181 */       paramArrayOfbyte[paramInt1++] = (byte)(paramInt2 >> 8);
/* 182 */       paramArrayOfbyte[paramInt1] = (byte)paramInt2;
/* 183 */       return 5;
/* 184 */     }  if (paramInt2 < 128) {
/* 185 */       paramArrayOfbyte[paramInt1] = (byte)paramInt2;
/* 186 */       return 1;
/* 187 */     }  if (paramInt2 < 16384) {
/* 188 */       paramArrayOfbyte[paramInt1++] = (byte)(0x80 | paramInt2 >> 8);
/* 189 */       paramArrayOfbyte[paramInt1] = (byte)paramInt2;
/* 190 */       return 2;
/* 191 */     }  if (paramInt2 < 2097152) {
/* 192 */       paramArrayOfbyte[paramInt1++] = (byte)(0xC0 | paramInt2 >> 16);
/* 193 */       paramArrayOfbyte[paramInt1++] = (byte)(paramInt2 >> 8);
/* 194 */       paramArrayOfbyte[paramInt1] = (byte)paramInt2;
/* 195 */       return 3;
/* 196 */     }  if (paramInt2 < 268435456) {
/* 197 */       paramArrayOfbyte[paramInt1++] = (byte)(0xE0 | paramInt2 >> 24);
/* 198 */       paramArrayOfbyte[paramInt1++] = (byte)(paramInt2 >> 16);
/* 199 */       paramArrayOfbyte[paramInt1++] = (byte)(paramInt2 >> 8);
/* 200 */       paramArrayOfbyte[paramInt1] = (byte)paramInt2;
/* 201 */       return 4;
/*     */     } 
/* 203 */     paramArrayOfbyte[paramInt1++] = -16;
/* 204 */     paramArrayOfbyte[paramInt1++] = (byte)(paramInt2 >> 24);
/* 205 */     paramArrayOfbyte[paramInt1++] = (byte)(paramInt2 >> 16);
/* 206 */     paramArrayOfbyte[paramInt1++] = (byte)(paramInt2 >> 8);
/* 207 */     paramArrayOfbyte[paramInt1] = (byte)paramInt2;
/* 208 */     return 5;
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
/*     */   public static int getVariableIntLength(int paramInt) {
/* 220 */     if (paramInt < 0)
/* 221 */       return 5; 
/* 222 */     if (paramInt < 128)
/* 223 */       return 1; 
/* 224 */     if (paramInt < 16384)
/* 225 */       return 2; 
/* 226 */     if (paramInt < 2097152)
/* 227 */       return 3; 
/* 228 */     if (paramInt < 268435456) {
/* 229 */       return 4;
/*     */     }
/* 231 */     return 5;
/*     */   }
/*     */ 
/*     */   
/*     */   private static Compressor getCompressor(String paramString) {
/* 236 */     if (paramString == null) {
/* 237 */       paramString = "LZF";
/*     */     }
/* 239 */     int i = paramString.indexOf(' ');
/* 240 */     String str = null;
/* 241 */     if (i > 0) {
/* 242 */       str = paramString.substring(i + 1);
/* 243 */       paramString = paramString.substring(0, i);
/*     */     } 
/* 245 */     int j = getCompressAlgorithm(paramString);
/* 246 */     Compressor compressor = getCompressor(j);
/* 247 */     compressor.setOptions(str);
/* 248 */     return compressor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getCompressAlgorithm(String paramString) {
/* 255 */     paramString = StringUtils.toUpperEnglish(paramString);
/* 256 */     if ("NO".equals(paramString))
/* 257 */       return 0; 
/* 258 */     if ("LZF".equals(paramString))
/* 259 */       return 1; 
/* 260 */     if ("DEFLATE".equals(paramString)) {
/* 261 */       return 2;
/*     */     }
/* 263 */     throw DbException.get(90103, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Compressor getCompressor(int paramInt) {
/* 270 */     switch (paramInt) {
/*     */       case 0:
/* 272 */         return (Compressor)new CompressNo();
/*     */       case 1:
/* 274 */         return (Compressor)new CompressLZF();
/*     */       case 2:
/* 276 */         return (Compressor)new CompressDeflate();
/*     */     } 
/* 278 */     throw DbException.get(90103, "" + paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static OutputStream wrapOutputStream(OutputStream paramOutputStream, String paramString1, String paramString2) {
/*     */     try {
/*     */       LZFOutputStream lZFOutputStream;
/* 290 */       if ("GZIP".equals(paramString1)) {
/* 291 */         paramOutputStream = new GZIPOutputStream(paramOutputStream);
/* 292 */       } else if ("ZIP".equals(paramString1)) {
/* 293 */         ZipOutputStream zipOutputStream = new ZipOutputStream(paramOutputStream);
/* 294 */         zipOutputStream.putNextEntry(new ZipEntry(paramString2));
/* 295 */         paramOutputStream = zipOutputStream;
/* 296 */       } else if ("DEFLATE".equals(paramString1)) {
/* 297 */         paramOutputStream = new DeflaterOutputStream(paramOutputStream);
/* 298 */       } else if ("LZF".equals(paramString1)) {
/* 299 */         lZFOutputStream = new LZFOutputStream(paramOutputStream);
/* 300 */       } else if (paramString1 != null) {
/* 301 */         throw DbException.get(90103, paramString1);
/*     */       } 
/*     */ 
/*     */       
/* 305 */       return (OutputStream)lZFOutputStream;
/* 306 */     } catch (IOException iOException) {
/* 307 */       throw DbException.convertIOException(iOException, null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static InputStream wrapInputStream(InputStream paramInputStream, String paramString1, String paramString2) {
/*     */     try {
/*     */       LZFInputStream lZFInputStream;
/* 317 */       if ("GZIP".equals(paramString1)) {
/* 318 */         paramInputStream = new GZIPInputStream(paramInputStream);
/* 319 */       } else if ("ZIP".equals(paramString1)) {
/* 320 */         ZipEntry zipEntry; ZipInputStream zipInputStream = new ZipInputStream(paramInputStream);
/*     */         do {
/* 322 */           zipEntry = zipInputStream.getNextEntry();
/* 323 */           if (zipEntry == null) {
/* 324 */             return null;
/*     */           }
/* 326 */         } while (!paramString2.equals(zipEntry.getName()));
/*     */ 
/*     */ 
/*     */         
/* 330 */         paramInputStream = zipInputStream;
/* 331 */       } else if ("DEFLATE".equals(paramString1)) {
/* 332 */         paramInputStream = new InflaterInputStream(paramInputStream);
/* 333 */       } else if ("LZF".equals(paramString1)) {
/* 334 */         lZFInputStream = new LZFInputStream(paramInputStream);
/* 335 */       } else if (paramString1 != null) {
/* 336 */         throw DbException.get(90103, paramString1);
/*     */       } 
/*     */ 
/*     */       
/* 340 */       return (InputStream)lZFInputStream;
/* 341 */     } catch (IOException iOException) {
/* 342 */       throw DbException.convertIOException(iOException, null);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\tools\CompressTool.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */