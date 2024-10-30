/*     */ package org.apache.http.impl.io;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.CharBuffer;
/*     */ import java.nio.charset.CharsetEncoder;
/*     */ import java.nio.charset.CoderResult;
/*     */ import org.apache.http.io.BufferInfo;
/*     */ import org.apache.http.io.HttpTransportMetrics;
/*     */ import org.apache.http.io.SessionOutputBuffer;
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
/*     */ public class SessionOutputBufferImpl
/*     */   implements BufferInfo, SessionOutputBuffer
/*     */ {
/*  58 */   private static final byte[] CRLF = new byte[] { 13, 10 };
/*     */ 
/*     */ 
/*     */   
/*     */   private final HttpTransportMetricsImpl metrics;
/*     */ 
/*     */ 
/*     */   
/*     */   private final ByteArrayBuffer buffer;
/*     */ 
/*     */ 
/*     */   
/*     */   private final int fragementSizeHint;
/*     */ 
/*     */ 
/*     */   
/*     */   private final CharsetEncoder encoder;
/*     */ 
/*     */   
/*     */   private OutputStream outStream;
/*     */ 
/*     */   
/*     */   private ByteBuffer bbuf;
/*     */ 
/*     */ 
/*     */   
/*     */   public SessionOutputBufferImpl(HttpTransportMetricsImpl paramHttpTransportMetricsImpl, int paramInt1, int paramInt2, CharsetEncoder paramCharsetEncoder) {
/*  85 */     Args.positive(paramInt1, "Buffer size");
/*  86 */     Args.notNull(paramHttpTransportMetricsImpl, "HTTP transport metrcis");
/*  87 */     this.metrics = paramHttpTransportMetricsImpl;
/*  88 */     this.buffer = new ByteArrayBuffer(paramInt1);
/*  89 */     this.fragementSizeHint = (paramInt2 >= 0) ? paramInt2 : 0;
/*  90 */     this.encoder = paramCharsetEncoder;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SessionOutputBufferImpl(HttpTransportMetricsImpl paramHttpTransportMetricsImpl, int paramInt) {
/*  96 */     this(paramHttpTransportMetricsImpl, paramInt, paramInt, null);
/*     */   }
/*     */   
/*     */   public void bind(OutputStream paramOutputStream) {
/* 100 */     this.outStream = paramOutputStream;
/*     */   }
/*     */   
/*     */   public boolean isBound() {
/* 104 */     return (this.outStream != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public int capacity() {
/* 109 */     return this.buffer.capacity();
/*     */   }
/*     */ 
/*     */   
/*     */   public int length() {
/* 114 */     return this.buffer.length();
/*     */   }
/*     */ 
/*     */   
/*     */   public int available() {
/* 119 */     return capacity() - length();
/*     */   }
/*     */   
/*     */   private void streamWrite(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 123 */     Asserts.notNull(this.outStream, "Output stream");
/* 124 */     this.outStream.write(paramArrayOfbyte, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   private void flushStream() throws IOException {
/* 128 */     if (this.outStream != null) {
/* 129 */       this.outStream.flush();
/*     */     }
/*     */   }
/*     */   
/*     */   private void flushBuffer() throws IOException {
/* 134 */     int i = this.buffer.length();
/* 135 */     if (i > 0) {
/* 136 */       streamWrite(this.buffer.buffer(), 0, i);
/* 137 */       this.buffer.clear();
/* 138 */       this.metrics.incrementBytesTransferred(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void flush() throws IOException {
/* 144 */     flushBuffer();
/* 145 */     flushStream();
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 150 */     if (paramArrayOfbyte == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 156 */     if (paramInt2 > this.fragementSizeHint || paramInt2 > this.buffer.capacity()) {
/*     */       
/* 158 */       flushBuffer();
/*     */       
/* 160 */       streamWrite(paramArrayOfbyte, paramInt1, paramInt2);
/* 161 */       this.metrics.incrementBytesTransferred(paramInt2);
/*     */     } else {
/*     */       
/* 164 */       int i = this.buffer.capacity() - this.buffer.length();
/* 165 */       if (paramInt2 > i)
/*     */       {
/* 167 */         flushBuffer();
/*     */       }
/*     */       
/* 170 */       this.buffer.append(paramArrayOfbyte, paramInt1, paramInt2);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(byte[] paramArrayOfbyte) throws IOException {
/* 176 */     if (paramArrayOfbyte == null) {
/*     */       return;
/*     */     }
/* 179 */     write(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(int paramInt) throws IOException {
/* 184 */     if (this.fragementSizeHint > 0) {
/* 185 */       if (this.buffer.isFull()) {
/* 186 */         flushBuffer();
/*     */       }
/* 188 */       this.buffer.append(paramInt);
/*     */     } else {
/* 190 */       flushBuffer();
/* 191 */       this.outStream.write(paramInt);
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
/*     */   public void writeLine(String paramString) throws IOException {
/* 206 */     if (paramString == null) {
/*     */       return;
/*     */     }
/* 209 */     if (paramString.length() > 0) {
/* 210 */       if (this.encoder == null) {
/* 211 */         for (byte b = 0; b < paramString.length(); b++) {
/* 212 */           write(paramString.charAt(b));
/*     */         }
/*     */       } else {
/* 215 */         CharBuffer charBuffer = CharBuffer.wrap(paramString);
/* 216 */         writeEncoded(charBuffer);
/*     */       } 
/*     */     }
/* 219 */     write(CRLF);
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
/*     */   public void writeLine(CharArrayBuffer paramCharArrayBuffer) throws IOException {
/* 233 */     if (paramCharArrayBuffer == null) {
/*     */       return;
/*     */     }
/* 236 */     if (this.encoder == null) {
/* 237 */       int i = 0;
/* 238 */       int j = paramCharArrayBuffer.length();
/* 239 */       while (j > 0) {
/* 240 */         int k = this.buffer.capacity() - this.buffer.length();
/* 241 */         k = Math.min(k, j);
/* 242 */         if (k > 0) {
/* 243 */           this.buffer.append(paramCharArrayBuffer, i, k);
/*     */         }
/* 245 */         if (this.buffer.isFull()) {
/* 246 */           flushBuffer();
/*     */         }
/* 248 */         i += k;
/* 249 */         j -= k;
/*     */       } 
/*     */     } else {
/* 252 */       CharBuffer charBuffer = CharBuffer.wrap(paramCharArrayBuffer.buffer(), 0, paramCharArrayBuffer.length());
/* 253 */       writeEncoded(charBuffer);
/*     */     } 
/* 255 */     write(CRLF);
/*     */   }
/*     */   
/*     */   private void writeEncoded(CharBuffer paramCharBuffer) throws IOException {
/* 259 */     if (!paramCharBuffer.hasRemaining()) {
/*     */       return;
/*     */     }
/* 262 */     if (this.bbuf == null) {
/* 263 */       this.bbuf = ByteBuffer.allocate(1024);
/*     */     }
/* 265 */     this.encoder.reset();
/* 266 */     while (paramCharBuffer.hasRemaining()) {
/* 267 */       CoderResult coderResult1 = this.encoder.encode(paramCharBuffer, this.bbuf, true);
/* 268 */       handleEncodingResult(coderResult1);
/*     */     } 
/* 270 */     CoderResult coderResult = this.encoder.flush(this.bbuf);
/* 271 */     handleEncodingResult(coderResult);
/* 272 */     this.bbuf.clear();
/*     */   }
/*     */   
/*     */   private void handleEncodingResult(CoderResult paramCoderResult) throws IOException {
/* 276 */     if (paramCoderResult.isError()) {
/* 277 */       paramCoderResult.throwException();
/*     */     }
/* 279 */     this.bbuf.flip();
/* 280 */     while (this.bbuf.hasRemaining()) {
/* 281 */       write(this.bbuf.get());
/*     */     }
/* 283 */     this.bbuf.compact();
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpTransportMetrics getMetrics() {
/* 288 */     return this.metrics;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\io\SessionOutputBufferImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */