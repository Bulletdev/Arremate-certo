/*     */ package org.apache.http.impl.io;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.CharBuffer;
/*     */ import java.nio.charset.Charset;
/*     */ import java.nio.charset.CharsetDecoder;
/*     */ import java.nio.charset.CoderResult;
/*     */ import java.nio.charset.CodingErrorAction;
/*     */ import org.apache.http.Consts;
/*     */ import org.apache.http.io.BufferInfo;
/*     */ import org.apache.http.io.HttpTransportMetrics;
/*     */ import org.apache.http.io.SessionInputBuffer;
/*     */ import org.apache.http.params.HttpParams;
/*     */ import org.apache.http.util.Args;
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
/*     */ @Deprecated
/*     */ public abstract class AbstractSessionInputBuffer
/*     */   implements BufferInfo, SessionInputBuffer
/*     */ {
/*     */   private InputStream inStream;
/*     */   private byte[] buffer;
/*     */   private ByteArrayBuffer lineBuffer;
/*     */   private Charset charset;
/*     */   private boolean ascii;
/*     */   private int maxLineLen;
/*     */   private int minChunkLimit;
/*     */   private HttpTransportMetricsImpl metrics;
/*     */   private CodingErrorAction onMalformedCharAction;
/*     */   private CodingErrorAction onUnmappableCharAction;
/*     */   private int bufferPos;
/*     */   private int bufferLen;
/*     */   private CharsetDecoder decoder;
/*     */   private CharBuffer cbuf;
/*     */   
/*     */   protected void init(InputStream paramInputStream, int paramInt, HttpParams paramHttpParams) {
/*  94 */     Args.notNull(paramInputStream, "Input stream");
/*  95 */     Args.notNegative(paramInt, "Buffer size");
/*  96 */     Args.notNull(paramHttpParams, "HTTP parameters");
/*  97 */     this.inStream = paramInputStream;
/*  98 */     this.buffer = new byte[paramInt];
/*  99 */     this.bufferPos = 0;
/* 100 */     this.bufferLen = 0;
/* 101 */     this.lineBuffer = new ByteArrayBuffer(paramInt);
/* 102 */     String str = (String)paramHttpParams.getParameter("http.protocol.element-charset");
/* 103 */     this.charset = (str != null) ? Charset.forName(str) : Consts.ASCII;
/* 104 */     this.ascii = this.charset.equals(Consts.ASCII);
/* 105 */     this.decoder = null;
/* 106 */     this.maxLineLen = paramHttpParams.getIntParameter("http.connection.max-line-length", -1);
/* 107 */     this.minChunkLimit = paramHttpParams.getIntParameter("http.connection.min-chunk-limit", 512);
/* 108 */     this.metrics = createTransportMetrics();
/* 109 */     CodingErrorAction codingErrorAction1 = (CodingErrorAction)paramHttpParams.getParameter("http.malformed.input.action");
/*     */     
/* 111 */     this.onMalformedCharAction = (codingErrorAction1 != null) ? codingErrorAction1 : CodingErrorAction.REPORT;
/* 112 */     CodingErrorAction codingErrorAction2 = (CodingErrorAction)paramHttpParams.getParameter("http.unmappable.input.action");
/*     */     
/* 114 */     this.onUnmappableCharAction = (codingErrorAction2 != null) ? codingErrorAction2 : CodingErrorAction.REPORT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected HttpTransportMetricsImpl createTransportMetrics() {
/* 121 */     return new HttpTransportMetricsImpl();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int capacity() {
/* 129 */     return this.buffer.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int length() {
/* 137 */     return this.bufferLen - this.bufferPos;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int available() {
/* 145 */     return capacity() - length();
/*     */   }
/*     */ 
/*     */   
/*     */   protected int fillBuffer() throws IOException {
/* 150 */     if (this.bufferPos > 0) {
/* 151 */       int m = this.bufferLen - this.bufferPos;
/* 152 */       if (m > 0) {
/* 153 */         System.arraycopy(this.buffer, this.bufferPos, this.buffer, 0, m);
/*     */       }
/* 155 */       this.bufferPos = 0;
/* 156 */       this.bufferLen = m;
/*     */     } 
/*     */     
/* 159 */     int j = this.bufferLen;
/* 160 */     int k = this.buffer.length - j;
/* 161 */     int i = this.inStream.read(this.buffer, j, k);
/* 162 */     if (i == -1) {
/* 163 */       return -1;
/*     */     }
/* 165 */     this.bufferLen = j + i;
/* 166 */     this.metrics.incrementBytesTransferred(i);
/* 167 */     return i;
/*     */   }
/*     */   
/*     */   protected boolean hasBufferedData() {
/* 171 */     return (this.bufferPos < this.bufferLen);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int read() throws IOException {
/* 177 */     while (!hasBufferedData()) {
/* 178 */       int i = fillBuffer();
/* 179 */       if (i == -1) {
/* 180 */         return -1;
/*     */       }
/*     */     } 
/* 183 */     return this.buffer[this.bufferPos++] & 0xFF;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 188 */     if (paramArrayOfbyte == null) {
/* 189 */       return 0;
/*     */     }
/* 191 */     if (hasBufferedData()) {
/* 192 */       int j = Math.min(paramInt2, this.bufferLen - this.bufferPos);
/* 193 */       System.arraycopy(this.buffer, this.bufferPos, paramArrayOfbyte, paramInt1, j);
/* 194 */       this.bufferPos += j;
/* 195 */       return j;
/*     */     } 
/*     */ 
/*     */     
/* 199 */     if (paramInt2 > this.minChunkLimit) {
/* 200 */       int j = this.inStream.read(paramArrayOfbyte, paramInt1, paramInt2);
/* 201 */       if (j > 0) {
/* 202 */         this.metrics.incrementBytesTransferred(j);
/*     */       }
/* 204 */       return j;
/*     */     } 
/*     */     
/* 207 */     while (!hasBufferedData()) {
/* 208 */       int j = fillBuffer();
/* 209 */       if (j == -1) {
/* 210 */         return -1;
/*     */       }
/*     */     } 
/* 213 */     int i = Math.min(paramInt2, this.bufferLen - this.bufferPos);
/* 214 */     System.arraycopy(this.buffer, this.bufferPos, paramArrayOfbyte, paramInt1, i);
/* 215 */     this.bufferPos += i;
/* 216 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte) throws IOException {
/* 221 */     if (paramArrayOfbyte == null) {
/* 222 */       return 0;
/*     */     }
/* 224 */     return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */   
/*     */   private int locateLF() {
/* 228 */     for (int i = this.bufferPos; i < this.bufferLen; i++) {
/* 229 */       if (this.buffer[i] == 10) {
/* 230 */         return i;
/*     */       }
/*     */     } 
/* 233 */     return -1;
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
/* 253 */     Args.notNull(paramCharArrayBuffer, "Char array buffer");
/* 254 */     int i = 0;
/* 255 */     boolean bool = true;
/* 256 */     while (bool) {
/*     */       
/* 258 */       int j = locateLF();
/* 259 */       if (j != -1) {
/*     */         
/* 261 */         if (this.lineBuffer.isEmpty())
/*     */         {
/* 263 */           return lineFromReadBuffer(paramCharArrayBuffer, j);
/*     */         }
/* 265 */         bool = false;
/* 266 */         int k = j + 1 - this.bufferPos;
/* 267 */         this.lineBuffer.append(this.buffer, this.bufferPos, k);
/* 268 */         this.bufferPos = j + 1;
/*     */       } else {
/*     */         
/* 271 */         if (hasBufferedData()) {
/* 272 */           int k = this.bufferLen - this.bufferPos;
/* 273 */           this.lineBuffer.append(this.buffer, this.bufferPos, k);
/* 274 */           this.bufferPos = this.bufferLen;
/*     */         } 
/* 276 */         i = fillBuffer();
/* 277 */         if (i == -1) {
/* 278 */           bool = false;
/*     */         }
/*     */       } 
/* 281 */       if (this.maxLineLen > 0 && this.lineBuffer.length() >= this.maxLineLen) {
/* 282 */         throw new IOException("Maximum line length limit exceeded");
/*     */       }
/*     */     } 
/* 285 */     if (i == -1 && this.lineBuffer.isEmpty())
/*     */     {
/* 287 */       return -1;
/*     */     }
/* 289 */     return lineFromLineBuffer(paramCharArrayBuffer);
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
/* 308 */     int i = this.lineBuffer.length();
/* 309 */     if (i > 0) {
/* 310 */       if (this.lineBuffer.byteAt(i - 1) == 10) {
/* 311 */         i--;
/*     */       }
/*     */       
/* 314 */       if (i > 0 && 
/* 315 */         this.lineBuffer.byteAt(i - 1) == 13) {
/* 316 */         i--;
/*     */       }
/*     */     } 
/*     */     
/* 320 */     if (this.ascii) {
/* 321 */       paramCharArrayBuffer.append(this.lineBuffer, 0, i);
/*     */     } else {
/* 323 */       ByteBuffer byteBuffer = ByteBuffer.wrap(this.lineBuffer.buffer(), 0, i);
/* 324 */       i = appendDecoded(paramCharArrayBuffer, byteBuffer);
/*     */     } 
/* 326 */     this.lineBuffer.clear();
/* 327 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   private int lineFromReadBuffer(CharArrayBuffer paramCharArrayBuffer, int paramInt) throws IOException {
/* 332 */     int i = this.bufferPos;
/* 333 */     int j = paramInt;
/* 334 */     this.bufferPos = j + 1;
/* 335 */     if (j > i && this.buffer[j - 1] == 13)
/*     */     {
/* 337 */       j--;
/*     */     }
/* 339 */     int k = j - i;
/* 340 */     if (this.ascii) {
/* 341 */       paramCharArrayBuffer.append(this.buffer, i, k);
/*     */     } else {
/* 343 */       ByteBuffer byteBuffer = ByteBuffer.wrap(this.buffer, i, k);
/* 344 */       k = appendDecoded(paramCharArrayBuffer, byteBuffer);
/*     */     } 
/* 346 */     return k;
/*     */   }
/*     */ 
/*     */   
/*     */   private int appendDecoded(CharArrayBuffer paramCharArrayBuffer, ByteBuffer paramByteBuffer) throws IOException {
/* 351 */     if (!paramByteBuffer.hasRemaining()) {
/* 352 */       return 0;
/*     */     }
/* 354 */     if (this.decoder == null) {
/* 355 */       this.decoder = this.charset.newDecoder();
/* 356 */       this.decoder.onMalformedInput(this.onMalformedCharAction);
/* 357 */       this.decoder.onUnmappableCharacter(this.onUnmappableCharAction);
/*     */     } 
/* 359 */     if (this.cbuf == null) {
/* 360 */       this.cbuf = CharBuffer.allocate(1024);
/*     */     }
/* 362 */     this.decoder.reset();
/* 363 */     int i = 0;
/* 364 */     while (paramByteBuffer.hasRemaining()) {
/* 365 */       CoderResult coderResult1 = this.decoder.decode(paramByteBuffer, this.cbuf, true);
/* 366 */       i += handleDecodingResult(coderResult1, paramCharArrayBuffer, paramByteBuffer);
/*     */     } 
/* 368 */     CoderResult coderResult = this.decoder.flush(this.cbuf);
/* 369 */     i += handleDecodingResult(coderResult, paramCharArrayBuffer, paramByteBuffer);
/* 370 */     this.cbuf.clear();
/* 371 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int handleDecodingResult(CoderResult paramCoderResult, CharArrayBuffer paramCharArrayBuffer, ByteBuffer paramByteBuffer) throws IOException {
/* 378 */     if (paramCoderResult.isError()) {
/* 379 */       paramCoderResult.throwException();
/*     */     }
/* 381 */     this.cbuf.flip();
/* 382 */     int i = this.cbuf.remaining();
/* 383 */     while (this.cbuf.hasRemaining()) {
/* 384 */       paramCharArrayBuffer.append(this.cbuf.get());
/*     */     }
/* 386 */     this.cbuf.compact();
/* 387 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public String readLine() throws IOException {
/* 392 */     CharArrayBuffer charArrayBuffer = new CharArrayBuffer(64);
/* 393 */     int i = readLine(charArrayBuffer);
/* 394 */     if (i != -1) {
/* 395 */       return charArrayBuffer.toString();
/*     */     }
/* 397 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpTransportMetrics getMetrics() {
/* 402 */     return this.metrics;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\io\AbstractSessionInputBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */