/*     */ package org.apache.http.impl.io;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.CharBuffer;
/*     */ import java.nio.charset.CharsetDecoder;
/*     */ import java.nio.charset.CoderResult;
/*     */ import org.apache.http.MessageConstraintException;
/*     */ import org.apache.http.config.MessageConstraints;
/*     */ import org.apache.http.io.BufferInfo;
/*     */ import org.apache.http.io.HttpTransportMetrics;
/*     */ import org.apache.http.io.SessionInputBuffer;
/*     */ import org.apache.http.util.Args;
/*     */ import org.apache.http.util.Asserts;
/*     */ import org.apache.http.util.ByteArrayBuffer;
/*     */ import org.apache.http.util.CharArrayBuffer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SessionInputBufferImpl
/*     */   implements BufferInfo, SessionInputBuffer
/*     */ {
/*     */   private final HttpTransportMetricsImpl metrics;
/*     */   private final byte[] buffer;
/*     */   private final ByteArrayBuffer lineBuffer;
/*     */   private final int minChunkLimit;
/*     */   private final MessageConstraints constraints;
/*     */   private final CharsetDecoder decoder;
/*     */   private InputStream inStream;
/*     */   private int bufferPos;
/*     */   private int bufferLen;
/*     */   private CharBuffer cbuf;
/*     */   
/*     */   public SessionInputBufferImpl(HttpTransportMetricsImpl paramHttpTransportMetricsImpl, int paramInt1, int paramInt2, MessageConstraints paramMessageConstraints, CharsetDecoder paramCharsetDecoder) {
/*  94 */     Args.notNull(paramHttpTransportMetricsImpl, "HTTP transport metrcis");
/*  95 */     Args.positive(paramInt1, "Buffer size");
/*  96 */     this.metrics = paramHttpTransportMetricsImpl;
/*  97 */     this.buffer = new byte[paramInt1];
/*  98 */     this.bufferPos = 0;
/*  99 */     this.bufferLen = 0;
/* 100 */     this.minChunkLimit = (paramInt2 >= 0) ? paramInt2 : 512;
/* 101 */     this.constraints = (paramMessageConstraints != null) ? paramMessageConstraints : MessageConstraints.DEFAULT;
/* 102 */     this.lineBuffer = new ByteArrayBuffer(paramInt1);
/* 103 */     this.decoder = paramCharsetDecoder;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SessionInputBufferImpl(HttpTransportMetricsImpl paramHttpTransportMetricsImpl, int paramInt) {
/* 109 */     this(paramHttpTransportMetricsImpl, paramInt, paramInt, null, null);
/*     */   }
/*     */   
/*     */   public void bind(InputStream paramInputStream) {
/* 113 */     this.inStream = paramInputStream;
/*     */   }
/*     */   
/*     */   public boolean isBound() {
/* 117 */     return (this.inStream != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public int capacity() {
/* 122 */     return this.buffer.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public int length() {
/* 127 */     return this.bufferLen - this.bufferPos;
/*     */   }
/*     */ 
/*     */   
/*     */   public int available() {
/* 132 */     return capacity() - length();
/*     */   }
/*     */   
/*     */   private int streamRead(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 136 */     Asserts.notNull(this.inStream, "Input stream");
/* 137 */     return this.inStream.read(paramArrayOfbyte, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public int fillBuffer() throws IOException {
/* 142 */     if (this.bufferPos > 0) {
/* 143 */       int m = this.bufferLen - this.bufferPos;
/* 144 */       if (m > 0) {
/* 145 */         System.arraycopy(this.buffer, this.bufferPos, this.buffer, 0, m);
/*     */       }
/* 147 */       this.bufferPos = 0;
/* 148 */       this.bufferLen = m;
/*     */     } 
/*     */     
/* 151 */     int j = this.bufferLen;
/* 152 */     int k = this.buffer.length - j;
/* 153 */     int i = streamRead(this.buffer, j, k);
/* 154 */     if (i == -1) {
/* 155 */       return -1;
/*     */     }
/* 157 */     this.bufferLen = j + i;
/* 158 */     this.metrics.incrementBytesTransferred(i);
/* 159 */     return i;
/*     */   }
/*     */   
/*     */   public boolean hasBufferedData() {
/* 163 */     return (this.bufferPos < this.bufferLen);
/*     */   }
/*     */   
/*     */   public void clear() {
/* 167 */     this.bufferPos = 0;
/* 168 */     this.bufferLen = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int read() throws IOException {
/* 174 */     while (!hasBufferedData()) {
/* 175 */       int i = fillBuffer();
/* 176 */       if (i == -1) {
/* 177 */         return -1;
/*     */       }
/*     */     } 
/* 180 */     return this.buffer[this.bufferPos++] & 0xFF;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 185 */     if (paramArrayOfbyte == null) {
/* 186 */       return 0;
/*     */     }
/* 188 */     if (hasBufferedData()) {
/* 189 */       int j = Math.min(paramInt2, this.bufferLen - this.bufferPos);
/* 190 */       System.arraycopy(this.buffer, this.bufferPos, paramArrayOfbyte, paramInt1, j);
/* 191 */       this.bufferPos += j;
/* 192 */       return j;
/*     */     } 
/*     */ 
/*     */     
/* 196 */     if (paramInt2 > this.minChunkLimit) {
/* 197 */       int j = streamRead(paramArrayOfbyte, paramInt1, paramInt2);
/* 198 */       if (j > 0) {
/* 199 */         this.metrics.incrementBytesTransferred(j);
/*     */       }
/* 201 */       return j;
/*     */     } 
/*     */     
/* 204 */     while (!hasBufferedData()) {
/* 205 */       int j = fillBuffer();
/* 206 */       if (j == -1) {
/* 207 */         return -1;
/*     */       }
/*     */     } 
/* 210 */     int i = Math.min(paramInt2, this.bufferLen - this.bufferPos);
/* 211 */     System.arraycopy(this.buffer, this.bufferPos, paramArrayOfbyte, paramInt1, i);
/* 212 */     this.bufferPos += i;
/* 213 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte) throws IOException {
/* 218 */     if (paramArrayOfbyte == null) {
/* 219 */       return 0;
/*     */     }
/* 221 */     return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
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
/*     */   public int readLine(CharArrayBuffer paramCharArrayBuffer) throws IOException {
/* 241 */     Args.notNull(paramCharArrayBuffer, "Char array buffer");
/* 242 */     int i = this.constraints.getMaxLineLength();
/* 243 */     int j = 0;
/* 244 */     boolean bool = true;
/* 245 */     while (bool) {
/*     */       
/* 247 */       int k = -1; int m;
/* 248 */       for (m = this.bufferPos; m < this.bufferLen; m++) {
/* 249 */         if (this.buffer[m] == 10) {
/* 250 */           k = m;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/* 255 */       if (i > 0) {
/* 256 */         m = this.lineBuffer.length() + ((k >= 0) ? k : this.bufferLen) - this.bufferPos;
/*     */         
/* 258 */         if (m >= i) {
/* 259 */           throw new MessageConstraintException("Maximum line length limit exceeded");
/*     */         }
/*     */       } 
/*     */       
/* 263 */       if (k != -1) {
/*     */         
/* 265 */         if (this.lineBuffer.isEmpty())
/*     */         {
/* 267 */           return lineFromReadBuffer(paramCharArrayBuffer, k);
/*     */         }
/* 269 */         bool = false;
/* 270 */         m = k + 1 - this.bufferPos;
/* 271 */         this.lineBuffer.append(this.buffer, this.bufferPos, m);
/* 272 */         this.bufferPos = k + 1;
/*     */         continue;
/*     */       } 
/* 275 */       if (hasBufferedData()) {
/* 276 */         m = this.bufferLen - this.bufferPos;
/* 277 */         this.lineBuffer.append(this.buffer, this.bufferPos, m);
/* 278 */         this.bufferPos = this.bufferLen;
/*     */       } 
/* 280 */       j = fillBuffer();
/* 281 */       if (j == -1) {
/* 282 */         bool = false;
/*     */       }
/*     */     } 
/*     */     
/* 286 */     if (j == -1 && this.lineBuffer.isEmpty())
/*     */     {
/* 288 */       return -1;
/*     */     }
/* 290 */     return lineFromLineBuffer(paramCharArrayBuffer);
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
/*     */   private int lineFromLineBuffer(CharArrayBuffer paramCharArrayBuffer) throws IOException {
/* 309 */     int i = this.lineBuffer.length();
/* 310 */     if (i > 0) {
/* 311 */       if (this.lineBuffer.byteAt(i - 1) == 10) {
/* 312 */         i--;
/*     */       }
/*     */       
/* 315 */       if (i > 0 && 
/* 316 */         this.lineBuffer.byteAt(i - 1) == 13) {
/* 317 */         i--;
/*     */       }
/*     */     } 
/*     */     
/* 321 */     if (this.decoder == null) {
/* 322 */       paramCharArrayBuffer.append(this.lineBuffer, 0, i);
/*     */     } else {
/* 324 */       ByteBuffer byteBuffer = ByteBuffer.wrap(this.lineBuffer.buffer(), 0, i);
/* 325 */       i = appendDecoded(paramCharArrayBuffer, byteBuffer);
/*     */     } 
/* 327 */     this.lineBuffer.clear();
/* 328 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   private int lineFromReadBuffer(CharArrayBuffer paramCharArrayBuffer, int paramInt) throws IOException {
/* 333 */     int i = paramInt;
/* 334 */     int j = this.bufferPos;
/*     */     
/* 336 */     this.bufferPos = i + 1;
/* 337 */     if (i > j && this.buffer[i - 1] == 13)
/*     */     {
/* 339 */       i--;
/*     */     }
/* 341 */     int k = i - j;
/* 342 */     if (this.decoder == null) {
/* 343 */       paramCharArrayBuffer.append(this.buffer, j, k);
/*     */     } else {
/* 345 */       ByteBuffer byteBuffer = ByteBuffer.wrap(this.buffer, j, k);
/* 346 */       k = appendDecoded(paramCharArrayBuffer, byteBuffer);
/*     */     } 
/* 348 */     return k;
/*     */   }
/*     */ 
/*     */   
/*     */   private int appendDecoded(CharArrayBuffer paramCharArrayBuffer, ByteBuffer paramByteBuffer) throws IOException {
/* 353 */     if (!paramByteBuffer.hasRemaining()) {
/* 354 */       return 0;
/*     */     }
/* 356 */     if (this.cbuf == null) {
/* 357 */       this.cbuf = CharBuffer.allocate(1024);
/*     */     }
/* 359 */     this.decoder.reset();
/* 360 */     int i = 0;
/* 361 */     while (paramByteBuffer.hasRemaining()) {
/* 362 */       CoderResult coderResult1 = this.decoder.decode(paramByteBuffer, this.cbuf, true);
/* 363 */       i += handleDecodingResult(coderResult1, paramCharArrayBuffer, paramByteBuffer);
/*     */     } 
/* 365 */     CoderResult coderResult = this.decoder.flush(this.cbuf);
/* 366 */     i += handleDecodingResult(coderResult, paramCharArrayBuffer, paramByteBuffer);
/* 367 */     this.cbuf.clear();
/* 368 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int handleDecodingResult(CoderResult paramCoderResult, CharArrayBuffer paramCharArrayBuffer, ByteBuffer paramByteBuffer) throws IOException {
/* 375 */     if (paramCoderResult.isError()) {
/* 376 */       paramCoderResult.throwException();
/*     */     }
/* 378 */     this.cbuf.flip();
/* 379 */     int i = this.cbuf.remaining();
/* 380 */     while (this.cbuf.hasRemaining()) {
/* 381 */       paramCharArrayBuffer.append(this.cbuf.get());
/*     */     }
/* 383 */     this.cbuf.compact();
/* 384 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public String readLine() throws IOException {
/* 389 */     CharArrayBuffer charArrayBuffer = new CharArrayBuffer(64);
/* 390 */     int i = readLine(charArrayBuffer);
/* 391 */     return (i != -1) ? charArrayBuffer.toString() : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDataAvailable(int paramInt) throws IOException {
/* 396 */     return hasBufferedData();
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpTransportMetrics getMetrics() {
/* 401 */     return this.metrics;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\io\SessionInputBufferImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */