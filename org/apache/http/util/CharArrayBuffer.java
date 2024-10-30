/*     */ package org.apache.http.util;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.nio.CharBuffer;
/*     */ import org.apache.http.protocol.HTTP;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class CharArrayBuffer
/*     */   implements Serializable, CharSequence
/*     */ {
/*     */   private static final long serialVersionUID = -6208952725094867135L;
/*     */   private char[] buffer;
/*     */   private int len;
/*     */   
/*     */   public CharArrayBuffer(int paramInt) {
/*  55 */     Args.notNegative(paramInt, "Buffer capacity");
/*  56 */     this.buffer = new char[paramInt];
/*     */   }
/*     */   
/*     */   private void expand(int paramInt) {
/*  60 */     char[] arrayOfChar = new char[Math.max(this.buffer.length << 1, paramInt)];
/*  61 */     System.arraycopy(this.buffer, 0, arrayOfChar, 0, this.len);
/*  62 */     this.buffer = arrayOfChar;
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
/*     */   public void append(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*  78 */     if (paramArrayOfchar == null) {
/*     */       return;
/*     */     }
/*  81 */     if (paramInt1 < 0 || paramInt1 > paramArrayOfchar.length || paramInt2 < 0 || paramInt1 + paramInt2 < 0 || paramInt1 + paramInt2 > paramArrayOfchar.length)
/*     */     {
/*  83 */       throw new IndexOutOfBoundsException("off: " + paramInt1 + " len: " + paramInt2 + " b.length: " + paramArrayOfchar.length);
/*     */     }
/*  85 */     if (paramInt2 == 0) {
/*     */       return;
/*     */     }
/*  88 */     int i = this.len + paramInt2;
/*  89 */     if (i > this.buffer.length) {
/*  90 */       expand(i);
/*     */     }
/*  92 */     System.arraycopy(paramArrayOfchar, paramInt1, this.buffer, this.len, paramInt2);
/*  93 */     this.len = i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void append(String paramString) {
/* 103 */     String str = (paramString != null) ? paramString : "null";
/* 104 */     int i = str.length();
/* 105 */     int j = this.len + i;
/* 106 */     if (j > this.buffer.length) {
/* 107 */       expand(j);
/*     */     }
/* 109 */     str.getChars(0, i, this.buffer, this.len);
/* 110 */     this.len = j;
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
/*     */   public void append(CharArrayBuffer paramCharArrayBuffer, int paramInt1, int paramInt2) {
/* 127 */     if (paramCharArrayBuffer == null) {
/*     */       return;
/*     */     }
/* 130 */     append(paramCharArrayBuffer.buffer, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void append(CharArrayBuffer paramCharArrayBuffer) {
/* 141 */     if (paramCharArrayBuffer == null) {
/*     */       return;
/*     */     }
/* 144 */     append(paramCharArrayBuffer.buffer, 0, paramCharArrayBuffer.len);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void append(char paramChar) {
/* 154 */     int i = this.len + 1;
/* 155 */     if (i > this.buffer.length) {
/* 156 */       expand(i);
/*     */     }
/* 158 */     this.buffer[this.len] = paramChar;
/* 159 */     this.len = i;
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
/*     */   public void append(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 177 */     if (paramArrayOfbyte == null) {
/*     */       return;
/*     */     }
/* 180 */     if (paramInt1 < 0 || paramInt1 > paramArrayOfbyte.length || paramInt2 < 0 || paramInt1 + paramInt2 < 0 || paramInt1 + paramInt2 > paramArrayOfbyte.length)
/*     */     {
/* 182 */       throw new IndexOutOfBoundsException("off: " + paramInt1 + " len: " + paramInt2 + " b.length: " + paramArrayOfbyte.length);
/*     */     }
/* 184 */     if (paramInt2 == 0) {
/*     */       return;
/*     */     }
/* 187 */     int i = this.len;
/* 188 */     int j = i + paramInt2;
/* 189 */     if (j > this.buffer.length) {
/* 190 */       expand(j);
/*     */     }
/* 192 */     for (int k = paramInt1, m = i; m < j; k++, m++) {
/* 193 */       this.buffer[m] = (char)(paramArrayOfbyte[k] & 0xFF);
/*     */     }
/* 195 */     this.len = j;
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
/*     */   public void append(ByteArrayBuffer paramByteArrayBuffer, int paramInt1, int paramInt2) {
/* 213 */     if (paramByteArrayBuffer == null) {
/*     */       return;
/*     */     }
/* 216 */     append(paramByteArrayBuffer.buffer(), paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void append(Object paramObject) {
/* 227 */     append(String.valueOf(paramObject));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 234 */     this.len = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public char[] toCharArray() {
/* 243 */     char[] arrayOfChar = new char[this.len];
/* 244 */     if (this.len > 0) {
/* 245 */       System.arraycopy(this.buffer, 0, arrayOfChar, 0, this.len);
/*     */     }
/* 247 */     return arrayOfChar;
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
/*     */   public char charAt(int paramInt) {
/* 262 */     return this.buffer[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public char[] buffer() {
/* 271 */     return this.buffer;
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
/* 282 */     return this.buffer.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int length() {
/* 292 */     return this.len;
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
/*     */   public void ensureCapacity(int paramInt) {
/* 304 */     if (paramInt <= 0) {
/*     */       return;
/*     */     }
/* 307 */     int i = this.buffer.length - this.len;
/* 308 */     if (paramInt > i) {
/* 309 */       expand(this.len + paramInt);
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
/*     */   public void setLength(int paramInt) {
/* 324 */     if (paramInt < 0 || paramInt > this.buffer.length) {
/* 325 */       throw new IndexOutOfBoundsException("len: " + paramInt + " < 0 or > buffer len: " + this.buffer.length);
/*     */     }
/* 327 */     this.len = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 337 */     return (this.len == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFull() {
/* 347 */     return (this.len == this.buffer.length);
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
/*     */   public int indexOf(int paramInt1, int paramInt2, int paramInt3) {
/* 372 */     int i = paramInt2;
/* 373 */     if (i < 0) {
/* 374 */       i = 0;
/*     */     }
/* 376 */     int j = paramInt3;
/* 377 */     if (j > this.len) {
/* 378 */       j = this.len;
/*     */     }
/* 380 */     if (i > j) {
/* 381 */       return -1;
/*     */     }
/* 383 */     for (int k = i; k < j; k++) {
/* 384 */       if (this.buffer[k] == paramInt1) {
/* 385 */         return k;
/*     */       }
/*     */     } 
/* 388 */     return -1;
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
/*     */   public int indexOf(int paramInt) {
/* 402 */     return indexOf(paramInt, 0, this.len);
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
/*     */   public String substring(int paramInt1, int paramInt2) {
/* 420 */     if (paramInt1 < 0) {
/* 421 */       throw new IndexOutOfBoundsException("Negative beginIndex: " + paramInt1);
/*     */     }
/* 423 */     if (paramInt2 > this.len) {
/* 424 */       throw new IndexOutOfBoundsException("endIndex: " + paramInt2 + " > length: " + this.len);
/*     */     }
/* 426 */     if (paramInt1 > paramInt2) {
/* 427 */       throw new IndexOutOfBoundsException("beginIndex: " + paramInt1 + " > endIndex: " + paramInt2);
/*     */     }
/* 429 */     return new String(this.buffer, paramInt1, paramInt2 - paramInt1);
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
/*     */   public String substringTrimmed(int paramInt1, int paramInt2) {
/* 449 */     if (paramInt1 < 0) {
/* 450 */       throw new IndexOutOfBoundsException("Negative beginIndex: " + paramInt1);
/*     */     }
/* 452 */     if (paramInt2 > this.len) {
/* 453 */       throw new IndexOutOfBoundsException("endIndex: " + paramInt2 + " > length: " + this.len);
/*     */     }
/* 455 */     if (paramInt1 > paramInt2) {
/* 456 */       throw new IndexOutOfBoundsException("beginIndex: " + paramInt1 + " > endIndex: " + paramInt2);
/*     */     }
/* 458 */     int i = paramInt1;
/* 459 */     int j = paramInt2;
/* 460 */     while (i < paramInt2 && HTTP.isWhitespace(this.buffer[i])) {
/* 461 */       i++;
/*     */     }
/* 463 */     while (j > i && HTTP.isWhitespace(this.buffer[j - 1])) {
/* 464 */       j--;
/*     */     }
/* 466 */     return new String(this.buffer, i, j - i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence subSequence(int paramInt1, int paramInt2) {
/* 475 */     if (paramInt1 < 0) {
/* 476 */       throw new IndexOutOfBoundsException("Negative beginIndex: " + paramInt1);
/*     */     }
/* 478 */     if (paramInt2 > this.len) {
/* 479 */       throw new IndexOutOfBoundsException("endIndex: " + paramInt2 + " > length: " + this.len);
/*     */     }
/* 481 */     if (paramInt1 > paramInt2) {
/* 482 */       throw new IndexOutOfBoundsException("beginIndex: " + paramInt1 + " > endIndex: " + paramInt2);
/*     */     }
/* 484 */     return CharBuffer.wrap(this.buffer, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 489 */     return new String(this.buffer, 0, this.len);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\htt\\util\CharArrayBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */