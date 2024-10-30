/*     */ package org.apache.commons.io.input;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.CharBuffer;
/*     */ import java.nio.charset.CharacterCodingException;
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
/*     */ public class CharSequenceInputStream
/*     */   extends InputStream
/*     */ {
/*     */   private static final int BUFFER_SIZE = 2048;
/*     */   private static final int NO_MARK = -1;
/*     */   private final CharsetEncoder encoder;
/*     */   private final CharBuffer cbuf;
/*     */   private final ByteBuffer bbuf;
/*     */   private int mark_cbuf;
/*     */   private int mark_bbuf;
/*     */   
/*     */   public CharSequenceInputStream(CharSequence paramCharSequence, Charset paramCharset, int paramInt) {
/*  64 */     this
/*     */       
/*  66 */       .encoder = paramCharset.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
/*     */     
/*  68 */     float f = this.encoder.maxBytesPerChar();
/*  69 */     if (paramInt < f) {
/*  70 */       throw new IllegalArgumentException("Buffer size " + paramInt + " is less than maxBytesPerChar " + f);
/*     */     }
/*     */     
/*  73 */     this.bbuf = ByteBuffer.allocate(paramInt);
/*  74 */     this.bbuf.flip();
/*  75 */     this.cbuf = CharBuffer.wrap(paramCharSequence);
/*  76 */     this.mark_cbuf = -1;
/*  77 */     this.mark_bbuf = -1;
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
/*     */   public CharSequenceInputStream(CharSequence paramCharSequence, String paramString, int paramInt) {
/*  89 */     this(paramCharSequence, Charset.forName(paramString), paramInt);
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
/*     */   public CharSequenceInputStream(CharSequence paramCharSequence, Charset paramCharset) {
/* 101 */     this(paramCharSequence, paramCharset, 2048);
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
/*     */   public CharSequenceInputStream(CharSequence paramCharSequence, String paramString) {
/* 113 */     this(paramCharSequence, paramString, 2048);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void fillBuffer() throws CharacterCodingException {
/* 123 */     this.bbuf.compact();
/* 124 */     CoderResult coderResult = this.encoder.encode(this.cbuf, this.bbuf, true);
/* 125 */     if (coderResult.isError()) {
/* 126 */       coderResult.throwException();
/*     */     }
/* 128 */     this.bbuf.flip();
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 133 */     Objects.requireNonNull(paramArrayOfbyte, "array");
/* 134 */     if (paramInt2 < 0 || paramInt1 + paramInt2 > paramArrayOfbyte.length) {
/* 135 */       throw new IndexOutOfBoundsException("Array Size=" + paramArrayOfbyte.length + ", offset=" + paramInt1 + ", length=" + paramInt2);
/*     */     }
/*     */     
/* 138 */     if (paramInt2 == 0) {
/* 139 */       return 0;
/*     */     }
/* 141 */     if (!this.bbuf.hasRemaining() && !this.cbuf.hasRemaining()) {
/* 142 */       return -1;
/*     */     }
/* 144 */     int i = 0;
/* 145 */     while (paramInt2 > 0) {
/* 146 */       if (this.bbuf.hasRemaining()) {
/* 147 */         int j = Math.min(this.bbuf.remaining(), paramInt2);
/* 148 */         this.bbuf.get(paramArrayOfbyte, paramInt1, j);
/* 149 */         paramInt1 += j;
/* 150 */         paramInt2 -= j;
/* 151 */         i += j; continue;
/*     */       } 
/* 153 */       fillBuffer();
/* 154 */       if (!this.bbuf.hasRemaining() && !this.cbuf.hasRemaining()) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */     
/* 159 */     return (i == 0 && !this.cbuf.hasRemaining()) ? -1 : i;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read() throws IOException {
/*     */     while (true) {
/* 165 */       if (this.bbuf.hasRemaining()) {
/* 166 */         return this.bbuf.get() & 0xFF;
/*     */       }
/* 168 */       fillBuffer();
/* 169 */       if (!this.bbuf.hasRemaining() && !this.cbuf.hasRemaining()) {
/* 170 */         return -1;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte) throws IOException {
/* 177 */     return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long skip(long paramLong) throws IOException {
/* 185 */     long l = 0L;
/* 186 */     while (paramLong > 0L && available() > 0) {
/* 187 */       read();
/* 188 */       paramLong--;
/* 189 */       l++;
/*     */     } 
/* 191 */     return l;
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
/*     */   public int available() throws IOException {
/* 206 */     return this.bbuf.remaining() + this.cbuf.remaining();
/*     */   }
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
/*     */   public synchronized void mark(int paramInt) {
/* 220 */     this.mark_cbuf = this.cbuf.position();
/* 221 */     this.mark_bbuf = this.bbuf.position();
/* 222 */     this.cbuf.mark();
/* 223 */     this.bbuf.mark();
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
/*     */   public synchronized void reset() throws IOException {
/* 241 */     if (this.mark_cbuf != -1) {
/*     */       
/* 243 */       if (this.cbuf.position() != 0) {
/* 244 */         this.encoder.reset();
/* 245 */         this.cbuf.rewind();
/* 246 */         this.bbuf.rewind();
/* 247 */         this.bbuf.limit(0);
/* 248 */         while (this.cbuf.position() < this.mark_cbuf) {
/* 249 */           this.bbuf.rewind();
/* 250 */           this.bbuf.limit(0);
/* 251 */           fillBuffer();
/*     */         } 
/*     */       } 
/* 254 */       if (this.cbuf.position() != this.mark_cbuf) {
/* 255 */         throw new IllegalStateException("Unexpected CharBuffer position: actual=" + this.cbuf.position() + " expected=" + this.mark_cbuf);
/*     */       }
/*     */       
/* 258 */       this.bbuf.position(this.mark_bbuf);
/* 259 */       this.mark_cbuf = -1;
/* 260 */       this.mark_bbuf = -1;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean markSupported() {
/* 266 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\input\CharSequenceInputStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */