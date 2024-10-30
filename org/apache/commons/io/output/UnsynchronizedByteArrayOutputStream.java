/*     */ package org.apache.commons.io.output;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class UnsynchronizedByteArrayOutputStream
/*     */   extends AbstractByteArrayOutputStream
/*     */ {
/*     */   public UnsynchronizedByteArrayOutputStream() {
/*  38 */     this(1024);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UnsynchronizedByteArrayOutputStream(int paramInt) {
/*  48 */     if (paramInt < 0) {
/*  49 */       throw new IllegalArgumentException("Negative initial size: " + paramInt);
/*     */     }
/*  51 */     needNewBuffer(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  56 */     if (paramInt1 < 0 || paramInt1 > paramArrayOfbyte.length || paramInt2 < 0 || paramInt1 + paramInt2 > paramArrayOfbyte.length || paramInt1 + paramInt2 < 0)
/*  57 */       throw new IndexOutOfBoundsException(String.format("offset=%,d, length=%,d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) })); 
/*  58 */     if (paramInt2 == 0) {
/*     */       return;
/*     */     }
/*  61 */     writeImpl(paramArrayOfbyte, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(int paramInt) {
/*  66 */     writeImpl(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public int write(InputStream paramInputStream) throws IOException {
/*  71 */     return writeImpl(paramInputStream);
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/*  76 */     return this.count;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/*  84 */     resetImpl();
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeTo(OutputStream paramOutputStream) throws IOException {
/*  89 */     writeToImpl(paramOutputStream);
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
/*     */   public static InputStream toBufferedInputStream(InputStream paramInputStream) throws IOException {
/* 110 */     return toBufferedInputStream(paramInputStream, 1024);
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
/*     */   public static InputStream toBufferedInputStream(InputStream paramInputStream, int paramInt) throws IOException {
/* 133 */     try (UnsynchronizedByteArrayOutputStream null = new UnsynchronizedByteArrayOutputStream(paramInt)) {
/* 134 */       unsynchronizedByteArrayOutputStream.write(paramInputStream);
/* 135 */       return unsynchronizedByteArrayOutputStream.toInputStream();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream toInputStream() {
/* 141 */     return toInputStream(org.apache.commons.io.input.UnsynchronizedByteArrayInputStream::new);
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] toByteArray() {
/* 146 */     return toByteArrayImpl();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\output\UnsynchronizedByteArrayOutputStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */