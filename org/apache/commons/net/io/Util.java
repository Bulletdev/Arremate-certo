/*     */ package org.apache.commons.net.io;
/*     */ 
/*     */ import java.io.Closeable;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.Reader;
/*     */ import java.io.Writer;
/*     */ import java.net.Socket;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Util
/*     */ {
/*     */   public static final int DEFAULT_COPY_BUFFER_SIZE = 1024;
/*     */   
/*     */   public static long copyStream(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt, long paramLong, CopyStreamListener paramCopyStreamListener, boolean paramBoolean) throws CopyStreamException {
/*  97 */     long l = 0L;
/*  98 */     byte[] arrayOfByte = new byte[(paramInt > 0) ? paramInt : 1024];
/*     */     
/*     */     try {
/*     */       int i;
/* 102 */       while ((i = paramInputStream.read(arrayOfByte)) != -1)
/*     */       {
/*     */ 
/*     */ 
/*     */         
/* 107 */         if (i == 0) {
/*     */           
/* 109 */           int j = paramInputStream.read();
/* 110 */           if (j < 0) {
/*     */             break;
/*     */           }
/* 113 */           paramOutputStream.write(j);
/* 114 */           if (paramBoolean) {
/* 115 */             paramOutputStream.flush();
/*     */           }
/* 117 */           l++;
/* 118 */           if (paramCopyStreamListener != null) {
/* 119 */             paramCopyStreamListener.bytesTransferred(l, 1, paramLong);
/*     */           }
/*     */           
/*     */           continue;
/*     */         } 
/* 124 */         paramOutputStream.write(arrayOfByte, 0, i);
/* 125 */         if (paramBoolean) {
/* 126 */           paramOutputStream.flush();
/*     */         }
/* 128 */         l += i;
/* 129 */         if (paramCopyStreamListener != null) {
/* 130 */           paramCopyStreamListener.bytesTransferred(l, i, paramLong);
/*     */         }
/*     */       }
/*     */     
/* 134 */     } catch (IOException iOException) {
/*     */       
/* 136 */       throw new CopyStreamException("IOException caught while copying.", l, iOException);
/*     */     } 
/*     */ 
/*     */     
/* 140 */     return l;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long copyStream(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt, long paramLong, CopyStreamListener paramCopyStreamListener) throws CopyStreamException {
/* 183 */     return copyStream(paramInputStream, paramOutputStream, paramInt, paramLong, paramCopyStreamListener, true);
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
/*     */   
/*     */   public static long copyStream(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt) throws CopyStreamException {
/* 214 */     return copyStream(paramInputStream, paramOutputStream, paramInt, -1L, null);
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
/*     */   public static long copyStream(InputStream paramInputStream, OutputStream paramOutputStream) throws CopyStreamException {
/* 229 */     return copyStream(paramInputStream, paramOutputStream, 1024);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long copyReader(Reader paramReader, Writer paramWriter, int paramInt, long paramLong, CopyStreamListener paramCopyStreamListener) throws CopyStreamException {
/* 272 */     long l = 0L;
/* 273 */     char[] arrayOfChar = new char[(paramInt > 0) ? paramInt : 1024];
/*     */     
/*     */     try {
/*     */       int i;
/* 277 */       while ((i = paramReader.read(arrayOfChar)) != -1)
/*     */       {
/*     */ 
/*     */         
/* 281 */         if (i == 0) {
/*     */           
/* 283 */           int j = paramReader.read();
/* 284 */           if (j < 0) {
/*     */             break;
/*     */           }
/* 287 */           paramWriter.write(j);
/* 288 */           paramWriter.flush();
/* 289 */           l++;
/* 290 */           if (paramCopyStreamListener != null) {
/* 291 */             paramCopyStreamListener.bytesTransferred(l, 1, paramLong);
/*     */           }
/*     */           
/*     */           continue;
/*     */         } 
/* 296 */         paramWriter.write(arrayOfChar, 0, i);
/* 297 */         paramWriter.flush();
/* 298 */         l += i;
/* 299 */         if (paramCopyStreamListener != null) {
/* 300 */           paramCopyStreamListener.bytesTransferred(l, i, paramLong);
/*     */         }
/*     */       }
/*     */     
/* 304 */     } catch (IOException iOException) {
/*     */       
/* 306 */       throw new CopyStreamException("IOException caught while copying.", l, iOException);
/*     */     } 
/*     */ 
/*     */     
/* 310 */     return l;
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
/*     */   public static long copyReader(Reader paramReader, Writer paramWriter, int paramInt) throws CopyStreamException {
/* 339 */     return copyReader(paramReader, paramWriter, paramInt, -1L, null);
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
/*     */   public static long copyReader(Reader paramReader, Writer paramWriter) throws CopyStreamException {
/* 354 */     return copyReader(paramReader, paramWriter, 1024);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void closeQuietly(Closeable paramCloseable) {
/* 365 */     if (paramCloseable != null) {
/*     */       try {
/* 367 */         paramCloseable.close();
/* 368 */       } catch (IOException iOException) {}
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
/*     */   public static void closeQuietly(Socket paramSocket) {
/* 382 */     if (paramSocket != null)
/*     */       try {
/* 384 */         paramSocket.close();
/* 385 */       } catch (IOException iOException) {} 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\io\Util.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */