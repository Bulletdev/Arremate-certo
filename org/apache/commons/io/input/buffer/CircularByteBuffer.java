/*     */ package org.apache.commons.io.input.buffer;
/*     */ 
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
/*     */ public class CircularByteBuffer
/*     */ {
/*     */   private final byte[] buffer;
/*     */   private int startOffset;
/*     */   private int endOffset;
/*     */   private int currentNumberOfBytes;
/*     */   
/*     */   public CircularByteBuffer(int paramInt) {
/*  42 */     this.buffer = new byte[paramInt];
/*  43 */     this.startOffset = 0;
/*  44 */     this.endOffset = 0;
/*  45 */     this.currentNumberOfBytes = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CircularByteBuffer() {
/*  52 */     this(8192);
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
/*     */   public byte read() {
/*  64 */     if (this.currentNumberOfBytes <= 0) {
/*  65 */       throw new IllegalStateException("No bytes available.");
/*     */     }
/*  67 */     byte b = this.buffer[this.startOffset];
/*  68 */     this.currentNumberOfBytes--;
/*  69 */     if (++this.startOffset == this.buffer.length) {
/*  70 */       this.startOffset = 0;
/*     */     }
/*  72 */     return b;
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
/*     */   public void read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  90 */     Objects.requireNonNull(paramArrayOfbyte);
/*  91 */     if (paramInt1 < 0 || paramInt1 >= paramArrayOfbyte.length) {
/*  92 */       throw new IllegalArgumentException("Invalid offset: " + paramInt1);
/*     */     }
/*  94 */     if (paramInt2 < 0 || paramInt2 > this.buffer.length) {
/*  95 */       throw new IllegalArgumentException("Invalid length: " + paramInt2);
/*     */     }
/*  97 */     if (paramInt1 + paramInt2 > paramArrayOfbyte.length) {
/*  98 */       throw new IllegalArgumentException("The supplied byte array contains only " + paramArrayOfbyte.length + " bytes, but offset, and length would require " + (paramInt1 + paramInt2 - 1));
/*     */     }
/*     */ 
/*     */     
/* 102 */     if (this.currentNumberOfBytes < paramInt2) {
/* 103 */       throw new IllegalStateException("Currently, there are only " + this.currentNumberOfBytes + "in the buffer, not " + paramInt2);
/*     */     }
/*     */     
/* 106 */     int i = paramInt1;
/* 107 */     for (byte b = 0; b < paramInt2; b++) {
/* 108 */       paramArrayOfbyte[i++] = this.buffer[this.startOffset];
/* 109 */       this.currentNumberOfBytes--;
/* 110 */       if (++this.startOffset == this.buffer.length) {
/* 111 */         this.startOffset = 0;
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
/*     */   public void add(byte paramByte) {
/* 125 */     if (this.currentNumberOfBytes >= this.buffer.length) {
/* 126 */       throw new IllegalStateException("No space available");
/*     */     }
/* 128 */     this.buffer[this.endOffset] = paramByte;
/* 129 */     this.currentNumberOfBytes++;
/* 130 */     if (++this.endOffset == this.buffer.length) {
/* 131 */       this.endOffset = 0;
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
/*     */ 
/*     */   
/*     */   public boolean peek(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 151 */     Objects.requireNonNull(paramArrayOfbyte, "Buffer");
/* 152 */     if (paramInt1 < 0 || paramInt1 >= paramArrayOfbyte.length) {
/* 153 */       throw new IllegalArgumentException("Invalid offset: " + paramInt1);
/*     */     }
/* 155 */     if (paramInt2 < 0 || paramInt2 > this.buffer.length) {
/* 156 */       throw new IllegalArgumentException("Invalid length: " + paramInt2);
/*     */     }
/* 158 */     if (paramInt2 < this.currentNumberOfBytes) {
/* 159 */       return false;
/*     */     }
/* 161 */     int i = this.startOffset;
/* 162 */     for (byte b = 0; b < paramInt2; b++) {
/* 163 */       if (this.buffer[i] != paramArrayOfbyte[b + paramInt1]) {
/* 164 */         return false;
/*     */       }
/* 166 */       if (++i == this.buffer.length) {
/* 167 */         i = 0;
/*     */       }
/*     */     } 
/* 170 */     return true;
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
/*     */   public void add(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 187 */     Objects.requireNonNull(paramArrayOfbyte, "Buffer");
/* 188 */     if (paramInt1 < 0 || paramInt1 >= paramArrayOfbyte.length) {
/* 189 */       throw new IllegalArgumentException("Invalid offset: " + paramInt1);
/*     */     }
/* 191 */     if (paramInt2 < 0) {
/* 192 */       throw new IllegalArgumentException("Invalid length: " + paramInt2);
/*     */     }
/* 194 */     if (this.currentNumberOfBytes + paramInt2 > this.buffer.length) {
/* 195 */       throw new IllegalStateException("No space available");
/*     */     }
/* 197 */     for (byte b = 0; b < paramInt2; b++) {
/* 198 */       this.buffer[this.endOffset] = paramArrayOfbyte[paramInt1 + b];
/* 199 */       if (++this.endOffset == this.buffer.length) {
/* 200 */         this.endOffset = 0;
/*     */       }
/*     */     } 
/* 203 */     this.currentNumberOfBytes += paramInt2;
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
/*     */   public boolean hasSpace() {
/* 215 */     return (this.currentNumberOfBytes < this.buffer.length);
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
/*     */   public boolean hasSpace(int paramInt) {
/* 227 */     return (this.currentNumberOfBytes + paramInt <= this.buffer.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasBytes() {
/* 236 */     return (this.currentNumberOfBytes > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSpace() {
/* 245 */     return this.buffer.length - this.currentNumberOfBytes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCurrentNumberOfBytes() {
/* 254 */     return this.currentNumberOfBytes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 261 */     this.startOffset = 0;
/* 262 */     this.endOffset = 0;
/* 263 */     this.currentNumberOfBytes = 0;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\input\buffer\CircularByteBuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */