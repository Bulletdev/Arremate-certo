/*     */ package org.apache.http.util;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ByteArrayBuffer
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 4359112959524048036L;
/*     */   private byte[] buffer;
/*     */   private int len;
/*     */   
/*     */   public ByteArrayBuffer(int paramInt) {
/*  52 */     Args.notNegative(paramInt, "Buffer capacity");
/*  53 */     this.buffer = new byte[paramInt];
/*     */   }
/*     */   
/*     */   private void expand(int paramInt) {
/*  57 */     byte[] arrayOfByte = new byte[Math.max(this.buffer.length << 1, paramInt)];
/*  58 */     System.arraycopy(this.buffer, 0, arrayOfByte, 0, this.len);
/*  59 */     this.buffer = arrayOfByte;
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
/*     */   public void append(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  75 */     if (paramArrayOfbyte == null) {
/*     */       return;
/*     */     }
/*  78 */     if (paramInt1 < 0 || paramInt1 > paramArrayOfbyte.length || paramInt2 < 0 || paramInt1 + paramInt2 < 0 || paramInt1 + paramInt2 > paramArrayOfbyte.length)
/*     */     {
/*  80 */       throw new IndexOutOfBoundsException("off: " + paramInt1 + " len: " + paramInt2 + " b.length: " + paramArrayOfbyte.length);
/*     */     }
/*  82 */     if (paramInt2 == 0) {
/*     */       return;
/*     */     }
/*  85 */     int i = this.len + paramInt2;
/*  86 */     if (i > this.buffer.length) {
/*  87 */       expand(i);
/*     */     }
/*  89 */     System.arraycopy(paramArrayOfbyte, paramInt1, this.buffer, this.len, paramInt2);
/*  90 */     this.len = i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void append(int paramInt) {
/* 100 */     int i = this.len + 1;
/* 101 */     if (i > this.buffer.length) {
/* 102 */       expand(i);
/*     */     }
/* 104 */     this.buffer[this.len] = (byte)paramInt;
/* 105 */     this.len = i;
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
/*     */   public void append(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 123 */     if (paramArrayOfchar == null) {
/*     */       return;
/*     */     }
/* 126 */     if (paramInt1 < 0 || paramInt1 > paramArrayOfchar.length || paramInt2 < 0 || paramInt1 + paramInt2 < 0 || paramInt1 + paramInt2 > paramArrayOfchar.length)
/*     */     {
/* 128 */       throw new IndexOutOfBoundsException("off: " + paramInt1 + " len: " + paramInt2 + " b.length: " + paramArrayOfchar.length);
/*     */     }
/* 130 */     if (paramInt2 == 0) {
/*     */       return;
/*     */     }
/* 133 */     int i = this.len;
/* 134 */     int j = i + paramInt2;
/* 135 */     if (j > this.buffer.length) {
/* 136 */       expand(j);
/*     */     }
/*     */     
/* 139 */     for (int k = paramInt1, m = i; m < j; k++, m++) {
/* 140 */       char c = paramArrayOfchar[k];
/* 141 */       if ((c >= ' ' && c <= '~') || (c >= ' ' && c <= 'ÿ') || c == '\t') {
/*     */ 
/*     */         
/* 144 */         this.buffer[m] = (byte)c;
/*     */       } else {
/* 146 */         this.buffer[m] = 63;
/*     */       } 
/*     */     } 
/* 149 */     this.len = j;
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
/*     */   public void append(CharArrayBuffer paramCharArrayBuffer, int paramInt1, int paramInt2) {
/* 168 */     if (paramCharArrayBuffer == null) {
/*     */       return;
/*     */     }
/* 171 */     append(paramCharArrayBuffer.buffer(), paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 178 */     this.len = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] toByteArray() {
/* 187 */     byte[] arrayOfByte = new byte[this.len];
/* 188 */     if (this.len > 0) {
/* 189 */       System.arraycopy(this.buffer, 0, arrayOfByte, 0, this.len);
/*     */     }
/* 191 */     return arrayOfByte;
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
/*     */   public int byteAt(int paramInt) {
/* 205 */     return this.buffer[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int capacity() {
/* 216 */     return this.buffer.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int length() {
/* 225 */     return this.len;
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
/*     */   public void ensureCapacity(int paramInt) {
/* 239 */     if (paramInt <= 0) {
/*     */       return;
/*     */     }
/* 242 */     int i = this.buffer.length - this.len;
/* 243 */     if (paramInt > i) {
/* 244 */       expand(this.len + paramInt);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] buffer() {
/* 254 */     return this.buffer;
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
/*     */   public void setLength(int paramInt) {
/* 268 */     if (paramInt < 0 || paramInt > this.buffer.length) {
/* 269 */       throw new IndexOutOfBoundsException("len: " + paramInt + " < 0 or > buffer len: " + this.buffer.length);
/*     */     }
/* 271 */     this.len = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 281 */     return (this.len == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFull() {
/* 291 */     return (this.len == this.buffer.length);
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
/*     */   public int indexOf(byte paramByte, int paramInt1, int paramInt2) {
/* 318 */     int i = paramInt1;
/* 319 */     if (i < 0) {
/* 320 */       i = 0;
/*     */     }
/* 322 */     int j = paramInt2;
/* 323 */     if (j > this.len) {
/* 324 */       j = this.len;
/*     */     }
/* 326 */     if (i > j) {
/* 327 */       return -1;
/*     */     }
/* 329 */     for (int k = i; k < j; k++) {
/* 330 */       if (this.buffer[k] == paramByte) {
/* 331 */         return k;
/*     */       }
/*     */     } 
/* 334 */     return -1;
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
/*     */   public int indexOf(byte paramByte) {
/* 350 */     return indexOf(paramByte, 0, this.len);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\htt\\util\ByteArrayBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */