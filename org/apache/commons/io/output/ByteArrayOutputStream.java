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
/*     */ public class ByteArrayOutputStream
/*     */   extends AbstractByteArrayOutputStream
/*     */ {
/*     */   public ByteArrayOutputStream() {
/*  34 */     this(1024);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteArrayOutputStream(int paramInt) {
/*  45 */     if (paramInt < 0) {
/*  46 */       throw new IllegalArgumentException("Negative initial size: " + paramInt);
/*     */     }
/*     */     
/*  49 */     synchronized (this) {
/*  50 */       needNewBuffer(paramInt);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  56 */     if (paramInt1 < 0 || paramInt1 > paramArrayOfbyte.length || paramInt2 < 0 || paramInt1 + paramInt2 > paramArrayOfbyte.length || paramInt1 + paramInt2 < 0)
/*     */     {
/*     */ 
/*     */ 
/*     */       
/*  61 */       throw new IndexOutOfBoundsException(); } 
/*  62 */     if (paramInt2 == 0) {
/*     */       return;
/*     */     }
/*  65 */     synchronized (this) {
/*  66 */       writeImpl(paramArrayOfbyte, paramInt1, paramInt2);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void write(int paramInt) {
/*  72 */     writeImpl(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized int write(InputStream paramInputStream) throws IOException {
/*  77 */     return writeImpl(paramInputStream);
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized int size() {
/*  82 */     return this.count;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void reset() {
/*  90 */     resetImpl();
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void writeTo(OutputStream paramOutputStream) throws IOException {
/*  95 */     writeToImpl(paramOutputStream);
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
/*     */   public static InputStream toBufferedInputStream(InputStream paramInputStream) throws IOException {
/* 122 */     return toBufferedInputStream(paramInputStream, 1024);
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
/*     */   public static InputStream toBufferedInputStream(InputStream paramInputStream, int paramInt) throws IOException {
/* 150 */     try (ByteArrayOutputStream null = new ByteArrayOutputStream(paramInt)) {
/* 151 */       byteArrayOutputStream.write(paramInputStream);
/* 152 */       return byteArrayOutputStream.toInputStream();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized InputStream toInputStream() {
/* 158 */     return toInputStream(java.io.ByteArrayInputStream::new);
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized byte[] toByteArray() {
/* 163 */     return toByteArrayImpl();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\output\ByteArrayOutputStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */