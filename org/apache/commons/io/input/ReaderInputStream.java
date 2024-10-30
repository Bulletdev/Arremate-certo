/*     */ package org.apache.commons.io.input;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.CharBuffer;
/*     */ import java.nio.charset.Charset;
/*     */ import java.nio.charset.CharsetEncoder;
/*     */ import java.nio.charset.CoderResult;
/*     */ import java.nio.charset.CodingErrorAction;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ReaderInputStream
/*     */   extends InputStream
/*     */ {
/*     */   private static final int DEFAULT_BUFFER_SIZE = 1024;
/*     */   private final Reader reader;
/*     */   private final CharsetEncoder encoder;
/*     */   private final CharBuffer encoderIn;
/*     */   private final ByteBuffer encoderOut;
/*     */   private CoderResult lastCoderResult;
/*     */   private boolean endOfInput;
/*     */   
/*     */   public ReaderInputStream(Reader paramReader, CharsetEncoder paramCharsetEncoder) {
/* 112 */     this(paramReader, paramCharsetEncoder, 1024);
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
/*     */   public ReaderInputStream(Reader paramReader, CharsetEncoder paramCharsetEncoder, int paramInt) {
/* 124 */     this.reader = paramReader;
/* 125 */     this.encoder = paramCharsetEncoder;
/* 126 */     this.encoderIn = CharBuffer.allocate(paramInt);
/* 127 */     this.encoderIn.flip();
/* 128 */     this.encoderOut = ByteBuffer.allocate(128);
/* 129 */     this.encoderOut.flip();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ReaderInputStream(Reader paramReader, Charset paramCharset, int paramInt) {
/* 140 */     this(paramReader, paramCharset
/* 141 */         .newEncoder()
/* 142 */         .onMalformedInput(CodingErrorAction.REPLACE)
/* 143 */         .onUnmappableCharacter(CodingErrorAction.REPLACE), paramInt);
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
/*     */   public ReaderInputStream(Reader paramReader, Charset paramCharset) {
/* 155 */     this(paramReader, paramCharset, 1024);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ReaderInputStream(Reader paramReader, String paramString, int paramInt) {
/* 166 */     this(paramReader, Charset.forName(paramString), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ReaderInputStream(Reader paramReader, String paramString) {
/* 177 */     this(paramReader, paramString, 1024);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public ReaderInputStream(Reader paramReader) {
/* 189 */     this(paramReader, Charset.defaultCharset());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void fillBuffer() throws IOException {
/* 199 */     if (!this.endOfInput && (this.lastCoderResult == null || this.lastCoderResult.isUnderflow())) {
/* 200 */       this.encoderIn.compact();
/* 201 */       int i = this.encoderIn.position();
/*     */ 
/*     */ 
/*     */       
/* 205 */       int j = this.reader.read(this.encoderIn.array(), i, this.encoderIn.remaining());
/* 206 */       if (j == -1) {
/* 207 */         this.endOfInput = true;
/*     */       } else {
/* 209 */         this.encoderIn.position(i + j);
/*     */       } 
/* 211 */       this.encoderIn.flip();
/*     */     } 
/* 213 */     this.encoderOut.compact();
/* 214 */     this.lastCoderResult = this.encoder.encode(this.encoderIn, this.encoderOut, this.endOfInput);
/* 215 */     this.encoderOut.flip();
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
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 230 */     Objects.requireNonNull(paramArrayOfbyte, "array");
/* 231 */     if (paramInt2 < 0 || paramInt1 < 0 || paramInt1 + paramInt2 > paramArrayOfbyte.length) {
/* 232 */       throw new IndexOutOfBoundsException("Array Size=" + paramArrayOfbyte.length + ", offset=" + paramInt1 + ", length=" + paramInt2);
/*     */     }
/*     */     
/* 235 */     int i = 0;
/* 236 */     if (paramInt2 == 0) {
/* 237 */       return 0;
/*     */     }
/* 239 */     while (paramInt2 > 0) {
/* 240 */       if (this.encoderOut.hasRemaining()) {
/* 241 */         int j = Math.min(this.encoderOut.remaining(), paramInt2);
/* 242 */         this.encoderOut.get(paramArrayOfbyte, paramInt1, j);
/* 243 */         paramInt1 += j;
/* 244 */         paramInt2 -= j;
/* 245 */         i += j; continue;
/*     */       } 
/* 247 */       fillBuffer();
/* 248 */       if (this.endOfInput && !this.encoderOut.hasRemaining()) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */     
/* 253 */     return (i == 0 && this.endOfInput) ? -1 : i;
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
/*     */   public int read(byte[] paramArrayOfbyte) throws IOException {
/* 266 */     return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
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
/*     */   public int read() throws IOException {
/*     */     while (true) {
/* 279 */       if (this.encoderOut.hasRemaining()) {
/* 280 */         return this.encoderOut.get() & 0xFF;
/*     */       }
/* 282 */       fillBuffer();
/* 283 */       if (this.endOfInput && !this.encoderOut.hasRemaining()) {
/* 284 */         return -1;
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
/*     */   public void close() throws IOException {
/* 296 */     this.reader.close();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\input\ReaderInputStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */