/*     */ package org.apache.http.impl.io;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.CharBuffer;
/*     */ import java.nio.charset.Charset;
/*     */ import java.nio.charset.CharsetEncoder;
/*     */ import java.nio.charset.CoderResult;
/*     */ import java.nio.charset.CodingErrorAction;
/*     */ import org.apache.http.Consts;
/*     */ import org.apache.http.io.BufferInfo;
/*     */ import org.apache.http.io.HttpTransportMetrics;
/*     */ import org.apache.http.io.SessionOutputBuffer;
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
/*     */ @Deprecated
/*     */ public abstract class AbstractSessionOutputBuffer
/*     */   implements BufferInfo, SessionOutputBuffer
/*     */ {
/*  66 */   private static final byte[] CRLF = new byte[] { 13, 10 };
/*     */   
/*     */   private OutputStream outStream;
/*     */   
/*     */   private ByteArrayBuffer buffer;
/*     */   
/*     */   private Charset charset;
/*     */   
/*     */   private boolean ascii;
/*     */   
/*     */   private int minChunkLimit;
/*     */   
/*     */   private HttpTransportMetricsImpl metrics;
/*     */   
/*     */   private CodingErrorAction onMalformedCharAction;
/*     */   
/*     */   private CodingErrorAction onUnmappableCharAction;
/*     */   
/*     */   private CharsetEncoder encoder;
/*     */   private ByteBuffer bbuf;
/*     */   
/*     */   protected AbstractSessionOutputBuffer(OutputStream paramOutputStream, int paramInt1, Charset paramCharset, int paramInt2, CodingErrorAction paramCodingErrorAction1, CodingErrorAction paramCodingErrorAction2) {
/*  88 */     Args.notNull(paramOutputStream, "Input stream");
/*  89 */     Args.notNegative(paramInt1, "Buffer size");
/*  90 */     this.outStream = paramOutputStream;
/*  91 */     this.buffer = new ByteArrayBuffer(paramInt1);
/*  92 */     this.charset = (paramCharset != null) ? paramCharset : Consts.ASCII;
/*  93 */     this.ascii = this.charset.equals(Consts.ASCII);
/*  94 */     this.encoder = null;
/*  95 */     this.minChunkLimit = (paramInt2 >= 0) ? paramInt2 : 512;
/*  96 */     this.metrics = createTransportMetrics();
/*  97 */     this.onMalformedCharAction = (paramCodingErrorAction1 != null) ? paramCodingErrorAction1 : CodingErrorAction.REPORT;
/*     */     
/*  99 */     this.onUnmappableCharAction = (paramCodingErrorAction2 != null) ? paramCodingErrorAction2 : CodingErrorAction.REPORT;
/*     */   }
/*     */ 
/*     */   
/*     */   public AbstractSessionOutputBuffer() {}
/*     */ 
/*     */   
/*     */   protected void init(OutputStream paramOutputStream, int paramInt, HttpParams paramHttpParams) {
/* 107 */     Args.notNull(paramOutputStream, "Input stream");
/* 108 */     Args.notNegative(paramInt, "Buffer size");
/* 109 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 110 */     this.outStream = paramOutputStream;
/* 111 */     this.buffer = new ByteArrayBuffer(paramInt);
/* 112 */     String str = (String)paramHttpParams.getParameter("http.protocol.element-charset");
/* 113 */     this.charset = (str != null) ? Charset.forName(str) : Consts.ASCII;
/* 114 */     this.ascii = this.charset.equals(Consts.ASCII);
/* 115 */     this.encoder = null;
/* 116 */     this.minChunkLimit = paramHttpParams.getIntParameter("http.connection.min-chunk-limit", 512);
/* 117 */     this.metrics = createTransportMetrics();
/* 118 */     CodingErrorAction codingErrorAction1 = (CodingErrorAction)paramHttpParams.getParameter("http.malformed.input.action");
/*     */     
/* 120 */     this.onMalformedCharAction = (codingErrorAction1 != null) ? codingErrorAction1 : CodingErrorAction.REPORT;
/* 121 */     CodingErrorAction codingErrorAction2 = (CodingErrorAction)paramHttpParams.getParameter("http.unmappable.input.action");
/*     */     
/* 123 */     this.onUnmappableCharAction = (codingErrorAction2 != null) ? codingErrorAction2 : CodingErrorAction.REPORT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected HttpTransportMetricsImpl createTransportMetrics() {
/* 130 */     return new HttpTransportMetricsImpl();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int capacity() {
/* 138 */     return this.buffer.capacity();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int length() {
/* 146 */     return this.buffer.length();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int available() {
/* 154 */     return capacity() - length();
/*     */   }
/*     */   
/*     */   protected void flushBuffer() throws IOException {
/* 158 */     int i = this.buffer.length();
/* 159 */     if (i > 0) {
/* 160 */       this.outStream.write(this.buffer.buffer(), 0, i);
/* 161 */       this.buffer.clear();
/* 162 */       this.metrics.incrementBytesTransferred(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void flush() throws IOException {
/* 168 */     flushBuffer();
/* 169 */     this.outStream.flush();
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 174 */     if (paramArrayOfbyte == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 180 */     if (paramInt2 > this.minChunkLimit || paramInt2 > this.buffer.capacity()) {
/*     */       
/* 182 */       flushBuffer();
/*     */       
/* 184 */       this.outStream.write(paramArrayOfbyte, paramInt1, paramInt2);
/* 185 */       this.metrics.incrementBytesTransferred(paramInt2);
/*     */     } else {
/*     */       
/* 188 */       int i = this.buffer.capacity() - this.buffer.length();
/* 189 */       if (paramInt2 > i)
/*     */       {
/* 191 */         flushBuffer();
/*     */       }
/*     */       
/* 194 */       this.buffer.append(paramArrayOfbyte, paramInt1, paramInt2);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(byte[] paramArrayOfbyte) throws IOException {
/* 200 */     if (paramArrayOfbyte == null) {
/*     */       return;
/*     */     }
/* 203 */     write(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(int paramInt) throws IOException {
/* 208 */     if (this.buffer.isFull()) {
/* 209 */       flushBuffer();
/*     */     }
/* 211 */     this.buffer.append(paramInt);
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
/* 225 */     if (paramString == null) {
/*     */       return;
/*     */     }
/* 228 */     if (paramString.length() > 0) {
/* 229 */       if (this.ascii) {
/* 230 */         for (byte b = 0; b < paramString.length(); b++) {
/* 231 */           write(paramString.charAt(b));
/*     */         }
/*     */       } else {
/* 234 */         CharBuffer charBuffer = CharBuffer.wrap(paramString);
/* 235 */         writeEncoded(charBuffer);
/*     */       } 
/*     */     }
/* 238 */     write(CRLF);
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
/* 252 */     if (paramCharArrayBuffer == null) {
/*     */       return;
/*     */     }
/* 255 */     if (this.ascii) {
/* 256 */       int i = 0;
/* 257 */       int j = paramCharArrayBuffer.length();
/* 258 */       while (j > 0) {
/* 259 */         int k = this.buffer.capacity() - this.buffer.length();
/* 260 */         k = Math.min(k, j);
/* 261 */         if (k > 0) {
/* 262 */           this.buffer.append(paramCharArrayBuffer, i, k);
/*     */         }
/* 264 */         if (this.buffer.isFull()) {
/* 265 */           flushBuffer();
/*     */         }
/* 267 */         i += k;
/* 268 */         j -= k;
/*     */       } 
/*     */     } else {
/* 271 */       CharBuffer charBuffer = CharBuffer.wrap(paramCharArrayBuffer.buffer(), 0, paramCharArrayBuffer.length());
/* 272 */       writeEncoded(charBuffer);
/*     */     } 
/* 274 */     write(CRLF);
/*     */   }
/*     */   
/*     */   private void writeEncoded(CharBuffer paramCharBuffer) throws IOException {
/* 278 */     if (!paramCharBuffer.hasRemaining()) {
/*     */       return;
/*     */     }
/* 281 */     if (this.encoder == null) {
/* 282 */       this.encoder = this.charset.newEncoder();
/* 283 */       this.encoder.onMalformedInput(this.onMalformedCharAction);
/* 284 */       this.encoder.onUnmappableCharacter(this.onUnmappableCharAction);
/*     */     } 
/* 286 */     if (this.bbuf == null) {
/* 287 */       this.bbuf = ByteBuffer.allocate(1024);
/*     */     }
/* 289 */     this.encoder.reset();
/* 290 */     while (paramCharBuffer.hasRemaining()) {
/* 291 */       CoderResult coderResult1 = this.encoder.encode(paramCharBuffer, this.bbuf, true);
/* 292 */       handleEncodingResult(coderResult1);
/*     */     } 
/* 294 */     CoderResult coderResult = this.encoder.flush(this.bbuf);
/* 295 */     handleEncodingResult(coderResult);
/* 296 */     this.bbuf.clear();
/*     */   }
/*     */   
/*     */   private void handleEncodingResult(CoderResult paramCoderResult) throws IOException {
/* 300 */     if (paramCoderResult.isError()) {
/* 301 */       paramCoderResult.throwException();
/*     */     }
/* 303 */     this.bbuf.flip();
/* 304 */     while (this.bbuf.hasRemaining()) {
/* 305 */       write(this.bbuf.get());
/*     */     }
/* 307 */     this.bbuf.compact();
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpTransportMetrics getMetrics() {
/* 312 */     return this.metrics;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\io\AbstractSessionOutputBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */