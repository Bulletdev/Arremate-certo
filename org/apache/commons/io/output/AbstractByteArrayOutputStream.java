/*     */ package org.apache.commons.io.output;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.SequenceInputStream;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import org.apache.commons.io.input.ClosedInputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractByteArrayOutputStream
/*     */   extends OutputStream
/*     */ {
/*     */   static final int DEFAULT_SIZE = 1024;
/*  64 */   private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
/*     */ 
/*     */   
/*  67 */   private final List<byte[]> buffers = (List)new ArrayList<>();
/*     */ 
/*     */   
/*     */   private int currentBufferIndex;
/*     */ 
/*     */   
/*     */   private int filledBufferSum;
/*     */ 
/*     */   
/*     */   private byte[] currentBuffer;
/*     */ 
/*     */   
/*     */   protected int count;
/*     */ 
/*     */   
/*     */   private boolean reuseBuffers = true;
/*     */ 
/*     */   
/*     */   protected void needNewBuffer(int paramInt) {
/*  86 */     if (this.currentBufferIndex < this.buffers.size() - 1) {
/*     */       
/*  88 */       this.filledBufferSum += this.currentBuffer.length;
/*     */       
/*  90 */       this.currentBufferIndex++;
/*  91 */       this.currentBuffer = this.buffers.get(this.currentBufferIndex);
/*     */     } else {
/*     */       int i;
/*     */       
/*  95 */       if (this.currentBuffer == null) {
/*  96 */         i = paramInt;
/*  97 */         this.filledBufferSum = 0;
/*     */       } else {
/*  99 */         i = Math.max(this.currentBuffer.length << 1, paramInt - this.filledBufferSum);
/*     */ 
/*     */         
/* 102 */         this.filledBufferSum += this.currentBuffer.length;
/*     */       } 
/*     */       
/* 105 */       this.currentBufferIndex++;
/* 106 */       this.currentBuffer = new byte[i];
/* 107 */       this.buffers.add(this.currentBuffer);
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
/*     */   public abstract void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void writeImpl(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 127 */     int i = this.count + paramInt2;
/* 128 */     int j = paramInt2;
/* 129 */     int k = this.count - this.filledBufferSum;
/* 130 */     while (j > 0) {
/* 131 */       int m = Math.min(j, this.currentBuffer.length - k);
/* 132 */       System.arraycopy(paramArrayOfbyte, paramInt1 + paramInt2 - j, this.currentBuffer, k, m);
/* 133 */       j -= m;
/* 134 */       if (j > 0) {
/* 135 */         needNewBuffer(i);
/* 136 */         k = 0;
/*     */       } 
/*     */     } 
/* 139 */     this.count = i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void write(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void writeImpl(int paramInt) {
/* 154 */     int i = this.count - this.filledBufferSum;
/* 155 */     if (i == this.currentBuffer.length) {
/* 156 */       needNewBuffer(this.count + 1);
/* 157 */       i = 0;
/*     */     } 
/* 159 */     this.currentBuffer[i] = (byte)paramInt;
/* 160 */     this.count++;
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
/*     */   public abstract int write(InputStream paramInputStream) throws IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int writeImpl(InputStream paramInputStream) throws IOException {
/* 189 */     int i = 0;
/* 190 */     int j = this.count - this.filledBufferSum;
/* 191 */     int k = paramInputStream.read(this.currentBuffer, j, this.currentBuffer.length - j);
/* 192 */     while (k != -1) {
/* 193 */       i += k;
/* 194 */       j += k;
/* 195 */       this.count += k;
/* 196 */       if (j == this.currentBuffer.length) {
/* 197 */         needNewBuffer(this.currentBuffer.length);
/* 198 */         j = 0;
/*     */       } 
/* 200 */       k = paramInputStream.read(this.currentBuffer, j, this.currentBuffer.length - j);
/*     */     } 
/* 202 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract int size();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws IOException {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void reset();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void resetImpl() {
/* 234 */     this.count = 0;
/* 235 */     this.filledBufferSum = 0;
/* 236 */     this.currentBufferIndex = 0;
/* 237 */     if (this.reuseBuffers) {
/* 238 */       this.currentBuffer = this.buffers.get(this.currentBufferIndex);
/*     */     } else {
/*     */       
/* 241 */       this.currentBuffer = null;
/* 242 */       int i = ((byte[])this.buffers.get(0)).length;
/* 243 */       this.buffers.clear();
/* 244 */       needNewBuffer(i);
/* 245 */       this.reuseBuffers = true;
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
/*     */   public abstract void writeTo(OutputStream paramOutputStream) throws IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void writeToImpl(OutputStream paramOutputStream) throws IOException {
/* 268 */     int i = this.count;
/* 269 */     for (byte[] arrayOfByte : this.buffers) {
/* 270 */       int j = Math.min(arrayOfByte.length, i);
/* 271 */       paramOutputStream.write(arrayOfByte, 0, j);
/* 272 */       i -= j;
/* 273 */       if (i == 0) {
/*     */         break;
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
/*     */ 
/*     */   
/*     */   public abstract InputStream toInputStream();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected <T extends InputStream> InputStream toInputStream(InputStreamConstructor<T> paramInputStreamConstructor) {
/* 308 */     int i = this.count;
/* 309 */     if (i == 0) {
/* 310 */       return (InputStream)ClosedInputStream.CLOSED_INPUT_STREAM;
/*     */     }
/* 312 */     ArrayList<? extends InputStream> arrayList = new ArrayList(this.buffers.size());
/* 313 */     for (byte[] arrayOfByte : this.buffers) {
/* 314 */       int j = Math.min(arrayOfByte.length, i);
/* 315 */       arrayList.add(paramInputStreamConstructor.construct(arrayOfByte, 0, j));
/* 316 */       i -= j;
/* 317 */       if (i == 0) {
/*     */         break;
/*     */       }
/*     */     } 
/* 321 */     this.reuseBuffers = false;
/* 322 */     return new SequenceInputStream(Collections.enumeration(arrayList));
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
/*     */   public abstract byte[] toByteArray();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected byte[] toByteArrayImpl() {
/* 362 */     int i = this.count;
/* 363 */     if (i == 0) {
/* 364 */       return EMPTY_BYTE_ARRAY;
/*     */     }
/* 366 */     byte[] arrayOfByte = new byte[i];
/* 367 */     int j = 0;
/* 368 */     for (byte[] arrayOfByte1 : this.buffers) {
/* 369 */       int k = Math.min(arrayOfByte1.length, i);
/* 370 */       System.arraycopy(arrayOfByte1, 0, arrayOfByte, j, k);
/* 371 */       j += k;
/* 372 */       i -= k;
/* 373 */       if (i == 0) {
/*     */         break;
/*     */       }
/*     */     } 
/* 377 */     return arrayOfByte;
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
/*     */   @Deprecated
/*     */   public String toString() {
/* 391 */     return new String(toByteArray(), Charset.defaultCharset());
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
/*     */   public String toString(String paramString) throws UnsupportedEncodingException {
/* 404 */     return new String(toByteArray(), paramString);
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
/*     */   public String toString(Charset paramCharset) {
/* 417 */     return new String(toByteArray(), paramCharset);
/*     */   }
/*     */   
/*     */   @FunctionalInterface
/*     */   protected static interface InputStreamConstructor<T extends InputStream> {
/*     */     T construct(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\output\AbstractByteArrayOutputStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */