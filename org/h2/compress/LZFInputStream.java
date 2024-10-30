/*     */ package org.h2.compress;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.mvstore.DataUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LZFInputStream
/*     */   extends InputStream
/*     */ {
/*     */   private final InputStream in;
/*  20 */   private CompressLZF decompress = new CompressLZF();
/*     */   private int pos;
/*     */   private int bufferLength;
/*     */   private byte[] inBuffer;
/*     */   private byte[] buffer;
/*     */   
/*     */   public LZFInputStream(InputStream paramInputStream) throws IOException {
/*  27 */     this.in = paramInputStream;
/*  28 */     if (readInt() != 1211255123) {
/*  29 */       throw new IOException("Not an LZFInputStream");
/*     */     }
/*     */   }
/*     */   
/*     */   private static byte[] ensureSize(byte[] paramArrayOfbyte, int paramInt) {
/*  34 */     return (paramArrayOfbyte == null || paramArrayOfbyte.length < paramInt) ? DataUtils.newBytes(paramInt) : paramArrayOfbyte;
/*     */   }
/*     */   
/*     */   private void fillBuffer() throws IOException {
/*  38 */     if (this.buffer != null && this.pos < this.bufferLength) {
/*     */       return;
/*     */     }
/*  41 */     int i = readInt();
/*  42 */     if (this.decompress == null) {
/*     */       
/*  44 */       this.bufferLength = 0;
/*  45 */     } else if (i < 0) {
/*  46 */       i = -i;
/*  47 */       this.buffer = ensureSize(this.buffer, i);
/*  48 */       readFully(this.buffer, i);
/*  49 */       this.bufferLength = i;
/*     */     } else {
/*  51 */       this.inBuffer = ensureSize(this.inBuffer, i);
/*  52 */       int j = readInt();
/*  53 */       readFully(this.inBuffer, i);
/*  54 */       this.buffer = ensureSize(this.buffer, j);
/*     */       try {
/*  56 */         this.decompress.expand(this.inBuffer, 0, i, this.buffer, 0, j);
/*  57 */       } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
/*  58 */         DbException.convertToIOException(arrayIndexOutOfBoundsException);
/*     */       } 
/*  60 */       this.bufferLength = j;
/*     */     } 
/*  62 */     this.pos = 0;
/*     */   }
/*     */   
/*     */   private void readFully(byte[] paramArrayOfbyte, int paramInt) throws IOException {
/*  66 */     int i = 0;
/*  67 */     while (paramInt > 0) {
/*  68 */       int j = this.in.read(paramArrayOfbyte, i, paramInt);
/*  69 */       paramInt -= j;
/*  70 */       i += j;
/*     */     } 
/*     */   }
/*     */   
/*     */   private int readInt() throws IOException {
/*  75 */     int i = this.in.read();
/*  76 */     if (i < 0) {
/*  77 */       this.decompress = null;
/*  78 */       return 0;
/*     */     } 
/*  80 */     i = (i << 24) + (this.in.read() << 16) + (this.in.read() << 8) + this.in.read();
/*  81 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read() throws IOException {
/*  86 */     fillBuffer();
/*  87 */     if (this.pos >= this.bufferLength) {
/*  88 */       return -1;
/*     */     }
/*  90 */     return this.buffer[this.pos++] & 0xFF;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte) throws IOException {
/*  95 */     return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 100 */     if (paramInt2 == 0) {
/* 101 */       return 0;
/*     */     }
/* 103 */     int i = 0;
/* 104 */     while (paramInt2 > 0) {
/* 105 */       int j = readBlock(paramArrayOfbyte, paramInt1, paramInt2);
/* 106 */       if (j < 0) {
/*     */         break;
/*     */       }
/* 109 */       i += j;
/* 110 */       paramInt1 += j;
/* 111 */       paramInt2 -= j;
/*     */     } 
/* 113 */     return (i == 0) ? -1 : i;
/*     */   }
/*     */   
/*     */   private int readBlock(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 117 */     fillBuffer();
/* 118 */     if (this.pos >= this.bufferLength) {
/* 119 */       return -1;
/*     */     }
/* 121 */     int i = Math.min(paramInt2, this.bufferLength - this.pos);
/* 122 */     i = Math.min(i, paramArrayOfbyte.length - paramInt1);
/* 123 */     System.arraycopy(this.buffer, this.pos, paramArrayOfbyte, paramInt1, i);
/* 124 */     this.pos += i;
/* 125 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 130 */     this.in.close();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\compress\LZFInputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */