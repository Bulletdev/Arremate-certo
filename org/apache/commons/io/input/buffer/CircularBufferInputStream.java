/*     */ package org.apache.commons.io.input.buffer;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.Objects;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CircularBufferInputStream
/*     */   extends InputStream
/*     */ {
/*     */   protected final InputStream in;
/*     */   protected final CircularByteBuffer buffer;
/*     */   protected final int bufferSize;
/*     */   private boolean eofSeen;
/*     */   
/*     */   public CircularBufferInputStream(InputStream paramInputStream, int paramInt) {
/*  46 */     if (paramInt <= 0) {
/*  47 */       throw new IllegalArgumentException("Invalid bufferSize: " + paramInt);
/*     */     }
/*  49 */     this.in = Objects.<InputStream>requireNonNull(paramInputStream, "inputStream");
/*  50 */     this.buffer = new CircularByteBuffer(paramInt);
/*  51 */     this.bufferSize = paramInt;
/*  52 */     this.eofSeen = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CircularBufferInputStream(InputStream paramInputStream) {
/*  62 */     this(paramInputStream, 8192);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void fillBuffer() throws IOException {
/*  71 */     if (this.eofSeen) {
/*     */       return;
/*     */     }
/*  74 */     int i = this.buffer.getSpace();
/*  75 */     byte[] arrayOfByte = new byte[i];
/*  76 */     while (i > 0) {
/*  77 */       int j = this.in.read(arrayOfByte, 0, i);
/*  78 */       if (j == -1) {
/*  79 */         this.eofSeen = true; return;
/*     */       } 
/*  81 */       if (j > 0) {
/*  82 */         this.buffer.add(arrayOfByte, 0, j);
/*  83 */         i -= j;
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
/*     */   protected boolean haveBytes(int paramInt) throws IOException {
/*  96 */     if (this.buffer.getCurrentNumberOfBytes() < paramInt) {
/*  97 */       fillBuffer();
/*     */     }
/*  99 */     return this.buffer.hasBytes();
/*     */   }
/*     */ 
/*     */   
/*     */   public int read() throws IOException {
/* 104 */     if (!haveBytes(1)) {
/* 105 */       return -1;
/*     */     }
/* 107 */     return this.buffer.read() & 0xFF;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte) throws IOException {
/* 112 */     return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 117 */     Objects.requireNonNull(paramArrayOfbyte, "Buffer");
/* 118 */     if (paramInt1 < 0) {
/* 119 */       throw new IllegalArgumentException("Offset must not be negative");
/*     */     }
/* 121 */     if (paramInt2 < 0) {
/* 122 */       throw new IllegalArgumentException("Length must not be negative");
/*     */     }
/* 124 */     if (!haveBytes(paramInt2)) {
/* 125 */       return -1;
/*     */     }
/* 127 */     int i = Math.min(paramInt2, this.buffer.getCurrentNumberOfBytes());
/* 128 */     for (byte b = 0; b < i; b++) {
/* 129 */       paramArrayOfbyte[paramInt1 + b] = this.buffer.read();
/*     */     }
/* 131 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 136 */     this.in.close();
/* 137 */     this.eofSeen = true;
/* 138 */     this.buffer.clear();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\input\buffer\CircularBufferInputStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */