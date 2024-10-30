/*     */ package org.h2.util;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.Closeable;
/*     */ import java.io.EOFException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStream;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.io.Reader;
/*     */ import java.io.StringWriter;
/*     */ import java.io.Writer;
/*     */ import org.h2.engine.Constants;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.store.fs.FileUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IOUtils
/*     */ {
/*     */   public static void closeSilently(Closeable paramCloseable) {
/*  42 */     if (paramCloseable != null) {
/*     */       try {
/*  44 */         trace("closeSilently", null, paramCloseable);
/*  45 */         paramCloseable.close();
/*  46 */       } catch (Exception exception) {}
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
/*     */   public static void skipFully(InputStream paramInputStream, long paramLong) throws IOException {
/*     */     try {
/*  63 */       while (paramLong > 0L) {
/*  64 */         long l = paramInputStream.skip(paramLong);
/*  65 */         if (l <= 0L) {
/*  66 */           throw new EOFException();
/*     */         }
/*  68 */         paramLong -= l;
/*     */       } 
/*  70 */     } catch (Exception exception) {
/*  71 */       throw DbException.convertToIOException(exception);
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
/*     */   public static void skipFully(Reader paramReader, long paramLong) throws IOException {
/*     */     try {
/*  86 */       while (paramLong > 0L) {
/*  87 */         long l = paramReader.skip(paramLong);
/*  88 */         if (l <= 0L) {
/*  89 */           throw new EOFException();
/*     */         }
/*  91 */         paramLong -= l;
/*     */       } 
/*  93 */     } catch (Exception exception) {
/*  94 */       throw DbException.convertToIOException(exception);
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
/*     */   public static long copyAndClose(InputStream paramInputStream, OutputStream paramOutputStream) throws IOException {
/*     */     try {
/* 109 */       long l = copyAndCloseInput(paramInputStream, paramOutputStream);
/* 110 */       paramOutputStream.close();
/* 111 */       return l;
/* 112 */     } catch (Exception exception) {
/* 113 */       throw DbException.convertToIOException(exception);
/*     */     } finally {
/* 115 */       closeSilently(paramOutputStream);
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
/*     */   public static long copyAndCloseInput(InputStream paramInputStream, OutputStream paramOutputStream) throws IOException {
/*     */     try {
/* 130 */       return copy(paramInputStream, paramOutputStream);
/* 131 */     } catch (Exception exception) {
/* 132 */       throw DbException.convertToIOException(exception);
/*     */     } finally {
/* 134 */       closeSilently(paramInputStream);
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
/*     */   public static long copy(InputStream paramInputStream, OutputStream paramOutputStream) throws IOException {
/* 148 */     return copy(paramInputStream, paramOutputStream, Long.MAX_VALUE);
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
/*     */   public static long copy(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong) throws IOException {
/*     */     try {
/* 163 */       long l = 0L;
/* 164 */       int i = (int)Math.min(paramLong, 4096L);
/* 165 */       byte[] arrayOfByte = new byte[i];
/* 166 */       while (paramLong > 0L) {
/* 167 */         i = paramInputStream.read(arrayOfByte, 0, i);
/* 168 */         if (i < 0) {
/*     */           break;
/*     */         }
/* 171 */         if (paramOutputStream != null) {
/* 172 */           paramOutputStream.write(arrayOfByte, 0, i);
/*     */         }
/* 174 */         l += i;
/* 175 */         paramLong -= i;
/* 176 */         i = (int)Math.min(paramLong, 4096L);
/*     */       } 
/* 178 */       return l;
/* 179 */     } catch (Exception exception) {
/* 180 */       throw DbException.convertToIOException(exception);
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
/*     */   public static long copyAndCloseInput(Reader paramReader, Writer paramWriter, long paramLong) throws IOException {
/*     */     try {
/* 196 */       long l = 0L;
/* 197 */       int i = (int)Math.min(paramLong, 4096L);
/* 198 */       char[] arrayOfChar = new char[i];
/* 199 */       while (paramLong > 0L) {
/* 200 */         i = paramReader.read(arrayOfChar, 0, i);
/* 201 */         if (i < 0) {
/*     */           break;
/*     */         }
/* 204 */         if (paramWriter != null) {
/* 205 */           paramWriter.write(arrayOfChar, 0, i);
/*     */         }
/* 207 */         paramLong -= i;
/* 208 */         i = (int)Math.min(paramLong, 4096L);
/* 209 */         l += i;
/*     */       } 
/* 211 */       return l;
/* 212 */     } catch (Exception exception) {
/* 213 */       throw DbException.convertToIOException(exception);
/*     */     } finally {
/* 215 */       paramReader.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void closeSilently(InputStream paramInputStream) {
/* 225 */     if (paramInputStream != null) {
/*     */       try {
/* 227 */         trace("closeSilently", null, paramInputStream);
/* 228 */         paramInputStream.close();
/* 229 */       } catch (Exception exception) {}
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
/*     */   public static void closeSilently(Reader paramReader) {
/* 241 */     if (paramReader != null) {
/*     */       try {
/* 243 */         paramReader.close();
/* 244 */       } catch (Exception exception) {}
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
/*     */   public static void closeSilently(Writer paramWriter) {
/* 256 */     if (paramWriter != null) {
/*     */       try {
/* 258 */         paramWriter.flush();
/* 259 */         paramWriter.close();
/* 260 */       } catch (Exception exception) {}
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
/*     */   public static byte[] readBytesAndClose(InputStream paramInputStream, int paramInt) throws IOException {
/*     */     try {
/* 277 */       if (paramInt <= 0) {
/* 278 */         paramInt = Integer.MAX_VALUE;
/*     */       }
/* 280 */       int i = Math.min(4096, paramInt);
/* 281 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i);
/* 282 */       copy(paramInputStream, byteArrayOutputStream, paramInt);
/* 283 */       return byteArrayOutputStream.toByteArray();
/* 284 */     } catch (Exception exception) {
/* 285 */       throw DbException.convertToIOException(exception);
/*     */     } finally {
/* 287 */       paramInputStream.close();
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
/*     */   public static String readStringAndClose(Reader paramReader, int paramInt) throws IOException {
/*     */     try {
/* 302 */       if (paramInt <= 0) {
/* 303 */         paramInt = Integer.MAX_VALUE;
/*     */       }
/* 305 */       int i = Math.min(4096, paramInt);
/* 306 */       StringWriter stringWriter = new StringWriter(i);
/* 307 */       copyAndCloseInput(paramReader, stringWriter, paramInt);
/* 308 */       return stringWriter.toString();
/*     */     } finally {
/* 310 */       paramReader.close();
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
/*     */   public static int readFully(InputStream paramInputStream, byte[] paramArrayOfbyte, int paramInt) throws IOException {
/*     */     try {
/* 327 */       int i = 0, j = Math.min(paramInt, paramArrayOfbyte.length);
/* 328 */       while (j > 0) {
/* 329 */         int k = paramInputStream.read(paramArrayOfbyte, i, j);
/* 330 */         if (k < 0) {
/*     */           break;
/*     */         }
/* 333 */         i += k;
/* 334 */         j -= k;
/*     */       } 
/* 336 */       return i;
/* 337 */     } catch (Exception exception) {
/* 338 */       throw DbException.convertToIOException(exception);
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
/*     */   public static int readFully(Reader paramReader, char[] paramArrayOfchar, int paramInt) throws IOException {
/*     */     try {
/* 355 */       int i = 0, j = Math.min(paramInt, paramArrayOfchar.length);
/* 356 */       while (j > 0) {
/* 357 */         int k = paramReader.read(paramArrayOfchar, i, j);
/* 358 */         if (k < 0) {
/*     */           break;
/*     */         }
/* 361 */         i += k;
/* 362 */         j -= k;
/*     */       } 
/* 364 */       return i;
/* 365 */     } catch (Exception exception) {
/* 366 */       throw DbException.convertToIOException(exception);
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
/*     */   public static Reader getBufferedReader(InputStream paramInputStream) {
/* 380 */     return (paramInputStream == null) ? null : new BufferedReader(new InputStreamReader(paramInputStream, Constants.UTF8));
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
/*     */   public static Reader getReader(InputStream paramInputStream) {
/* 395 */     return (paramInputStream == null) ? null : new BufferedReader(new InputStreamReader(paramInputStream, Constants.UTF8));
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
/*     */   public static Writer getBufferedWriter(OutputStream paramOutputStream) {
/* 407 */     return (paramOutputStream == null) ? null : new BufferedWriter(new OutputStreamWriter(paramOutputStream, Constants.UTF8));
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
/*     */   public static Reader getAsciiReader(InputStream paramInputStream) {
/*     */     try {
/* 420 */       return (paramInputStream == null) ? null : new InputStreamReader(paramInputStream, "US-ASCII");
/* 421 */     } catch (Exception exception) {
/*     */       
/* 423 */       throw DbException.convert(exception);
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
/*     */   public static void trace(String paramString1, String paramString2, Object paramObject) {
/* 435 */     if (SysProperties.TRACE_IO) {
/* 436 */       System.out.println("IOUtils." + paramString1 + " " + paramString2 + " " + paramObject);
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
/*     */   public static InputStream getInputStreamFromString(String paramString) {
/* 449 */     if (paramString == null) {
/* 450 */       return null;
/*     */     }
/* 452 */     return new ByteArrayInputStream(paramString.getBytes(Constants.UTF8));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void copyFiles(String paramString1, String paramString2) throws IOException {
/* 462 */     InputStream inputStream = FileUtils.newInputStream(paramString1);
/* 463 */     OutputStream outputStream = FileUtils.newOutputStream(paramString2, false);
/* 464 */     copyAndClose(inputStream, outputStream);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\IOUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */