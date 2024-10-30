/*     */ package org.apache.poi.util;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.Closeable;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.PushbackInputStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.channels.ReadableByteChannel;
/*     */ import java.util.zip.CRC32;
/*     */ import org.apache.poi.EmptyFileException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class IOUtils
/*     */ {
/*  34 */   private static final POILogger logger = POILogFactory.getLogger(IOUtils.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] peekFirst8Bytes(InputStream paramInputStream) throws IOException, EmptyFileException {
/*  49 */     paramInputStream.mark(8);
/*     */     
/*  51 */     byte[] arrayOfByte = new byte[8];
/*  52 */     int i = readFully(paramInputStream, arrayOfByte);
/*     */     
/*  54 */     if (i < 1) {
/*  55 */       throw new EmptyFileException();
/*     */     }
/*     */     
/*  58 */     if (paramInputStream instanceof PushbackInputStream) {
/*  59 */       PushbackInputStream pushbackInputStream = (PushbackInputStream)paramInputStream;
/*  60 */       pushbackInputStream.unread(arrayOfByte, 0, i);
/*     */     } else {
/*  62 */       paramInputStream.reset();
/*     */     } 
/*     */     
/*  65 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] toByteArray(InputStream paramInputStream) throws IOException {
/*  72 */     return toByteArray(paramInputStream, 2147483647);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] toByteArray(InputStream paramInputStream, int paramInt) throws IOException {
/*     */     int j;
/*  79 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((paramInt == Integer.MAX_VALUE) ? 4096 : paramInt);
/*     */     
/*  81 */     byte[] arrayOfByte = new byte[4096];
/*  82 */     int i = 0;
/*     */     do {
/*  84 */       j = paramInputStream.read(arrayOfByte, 0, Math.min(arrayOfByte.length, paramInt - i));
/*  85 */       i += Math.max(j, 0);
/*  86 */       if (j <= 0)
/*  87 */         continue;  byteArrayOutputStream.write(arrayOfByte, 0, j);
/*     */     }
/*  89 */     while (i < paramInt && j > -1);
/*     */     
/*  91 */     if (paramInt != Integer.MAX_VALUE && i < paramInt) {
/*  92 */       throw new IOException("unexpected EOF");
/*     */     }
/*     */     
/*  95 */     return byteArrayOutputStream.toByteArray();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] toByteArray(ByteBuffer paramByteBuffer, int paramInt) {
/* 105 */     if (paramByteBuffer.hasArray() && paramByteBuffer.arrayOffset() == 0)
/*     */     {
/* 107 */       return paramByteBuffer.array();
/*     */     }
/*     */     
/* 110 */     byte[] arrayOfByte = new byte[paramInt];
/* 111 */     paramByteBuffer.get(arrayOfByte);
/* 112 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int readFully(InputStream paramInputStream, byte[] paramArrayOfbyte) throws IOException {
/* 119 */     return readFully(paramInputStream, paramArrayOfbyte, 0, paramArrayOfbyte.length);
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
/*     */   public static int readFully(InputStream paramInputStream, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 137 */     int i = 0;
/*     */     while (true) {
/* 139 */       int j = paramInputStream.read(paramArrayOfbyte, paramInt1 + i, paramInt2 - i);
/* 140 */       if (j < 0) {
/* 141 */         return (i == 0) ? -1 : i;
/*     */       }
/* 143 */       i += j;
/* 144 */       if (i == paramInt2) {
/* 145 */         return i;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int readFully(ReadableByteChannel paramReadableByteChannel, ByteBuffer paramByteBuffer) throws IOException {
/* 162 */     int i = 0;
/*     */     do {
/* 164 */       int j = paramReadableByteChannel.read(paramByteBuffer);
/* 165 */       if (j < 0) {
/* 166 */         return !i ? -1 : i;
/*     */       }
/* 168 */       i += j;
/* 169 */     } while (i != paramByteBuffer.capacity() && paramByteBuffer.position() != paramByteBuffer.capacity());
/* 170 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void copy(InputStream paramInputStream, OutputStream paramOutputStream) throws IOException {
/* 180 */     byte[] arrayOfByte = new byte[4096];
/*     */     int i;
/* 182 */     while ((i = paramInputStream.read(arrayOfByte)) != -1) {
/* 183 */       if (i > 0) {
/* 184 */         paramOutputStream.write(arrayOfByte, 0, i);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long calculateChecksum(byte[] paramArrayOfbyte) {
/* 193 */     CRC32 cRC32 = new CRC32();
/* 194 */     cRC32.update(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/* 195 */     return cRC32.getValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long calculateChecksum(InputStream paramInputStream) throws IOException {
/* 205 */     CRC32 cRC32 = new CRC32();
/*     */     
/* 207 */     byte[] arrayOfByte = new byte[4096];
/*     */     int i;
/* 209 */     while ((i = paramInputStream.read(arrayOfByte)) != -1) {
/* 210 */       if (i > 0) {
/* 211 */         cRC32.update(arrayOfByte, 0, i);
/*     */       }
/*     */     } 
/* 214 */     return cRC32.getValue();
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
/*     */   public static void closeQuietly(Closeable paramCloseable) {
/* 227 */     if (paramCloseable == null) {
/*     */       return;
/*     */     }
/*     */     
/*     */     try {
/* 232 */       paramCloseable.close();
/* 233 */     } catch (Exception exception) {
/* 234 */       logger.log(7, "Unable to close resource: " + exception, exception);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\IOUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */