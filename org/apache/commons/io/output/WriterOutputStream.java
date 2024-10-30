/*     */ package org.apache.commons.io.output;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.io.Writer;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.CharBuffer;
/*     */ import java.nio.charset.Charset;
/*     */ import java.nio.charset.CharsetDecoder;
/*     */ import java.nio.charset.CoderResult;
/*     */ import java.nio.charset.CodingErrorAction;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WriterOutputStream
/*     */   extends OutputStream
/*     */ {
/*     */   private static final int BUFFER_SIZE = 1024;
/*     */   private final Writer writer;
/*     */   private final CharsetDecoder decoder;
/*     */   private final boolean writeImmediately;
/*  85 */   private final ByteBuffer decoderIn = ByteBuffer.allocate(128);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final CharBuffer decoderOut;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WriterOutputStream(Writer paramWriter, CharsetDecoder paramCharsetDecoder) {
/* 104 */     this(paramWriter, paramCharsetDecoder, 1024, false);
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
/*     */   public WriterOutputStream(Writer paramWriter, CharsetDecoder paramCharsetDecoder, int paramInt, boolean paramBoolean) {
/* 122 */     checkIbmJdkWithBrokenUTF16(paramCharsetDecoder.charset());
/* 123 */     this.writer = paramWriter;
/* 124 */     this.decoder = paramCharsetDecoder;
/* 125 */     this.writeImmediately = paramBoolean;
/* 126 */     this.decoderOut = CharBuffer.allocate(paramInt);
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
/*     */   public WriterOutputStream(Writer paramWriter, Charset paramCharset, int paramInt, boolean paramBoolean) {
/* 143 */     this(paramWriter, paramCharset
/* 144 */         .newDecoder()
/* 145 */         .onMalformedInput(CodingErrorAction.REPLACE)
/* 146 */         .onUnmappableCharacter(CodingErrorAction.REPLACE)
/* 147 */         .replaceWith("?"), paramInt, paramBoolean);
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
/*     */   public WriterOutputStream(Writer paramWriter, Charset paramCharset) {
/* 161 */     this(paramWriter, paramCharset, 1024, false);
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
/*     */   public WriterOutputStream(Writer paramWriter, String paramString, int paramInt, boolean paramBoolean) {
/* 178 */     this(paramWriter, Charset.forName(paramString), paramInt, paramBoolean);
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
/*     */   public WriterOutputStream(Writer paramWriter, String paramString) {
/* 190 */     this(paramWriter, paramString, 1024, false);
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
/*     */   @Deprecated
/*     */   public WriterOutputStream(Writer paramWriter) {
/* 203 */     this(paramWriter, Charset.defaultCharset(), 1024, false);
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
/*     */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 216 */     while (paramInt2 > 0) {
/* 217 */       int i = Math.min(paramInt2, this.decoderIn.remaining());
/* 218 */       this.decoderIn.put(paramArrayOfbyte, paramInt1, i);
/* 219 */       processInput(false);
/* 220 */       paramInt2 -= i;
/* 221 */       paramInt1 += i;
/*     */     } 
/* 223 */     if (this.writeImmediately) {
/* 224 */       flushOutput();
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
/*     */   public void write(byte[] paramArrayOfbyte) throws IOException {
/* 236 */     write(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(int paramInt) throws IOException {
/* 247 */     write(new byte[] { (byte)paramInt }, 0, 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void flush() throws IOException {
/* 258 */     flushOutput();
/* 259 */     this.writer.flush();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 270 */     processInput(true);
/* 271 */     flushOutput();
/* 272 */     this.writer.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void processInput(boolean paramBoolean) throws IOException {
/*     */     CoderResult coderResult;
/* 283 */     this.decoderIn.flip();
/*     */     
/*     */     while (true) {
/* 286 */       coderResult = this.decoder.decode(this.decoderIn, this.decoderOut, paramBoolean);
/* 287 */       if (coderResult.isOverflow())
/* 288 */       { flushOutput(); continue; }  break;
/* 289 */     }  if (coderResult.isUnderflow()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 298 */       this.decoderIn.compact();
/*     */       return;
/*     */     } 
/*     */     throw new IOException("Unexpected coder result");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void flushOutput() throws IOException {
/* 307 */     if (this.decoderOut.position() > 0) {
/* 308 */       this.writer.write(this.decoderOut.array(), 0, this.decoderOut.position());
/* 309 */       this.decoderOut.rewind();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void checkIbmJdkWithBrokenUTF16(Charset paramCharset) {
/* 319 */     if (!"UTF-16".equals(paramCharset.name())) {
/*     */       return;
/*     */     }
/* 322 */     String str = "vés";
/* 323 */     byte[] arrayOfByte = "vés".getBytes(paramCharset);
/*     */     
/* 325 */     CharsetDecoder charsetDecoder = paramCharset.newDecoder();
/* 326 */     ByteBuffer byteBuffer = ByteBuffer.allocate(16);
/* 327 */     CharBuffer charBuffer = CharBuffer.allocate("vés".length());
/* 328 */     int i = arrayOfByte.length;
/* 329 */     for (byte b = 0; b < i; b++) {
/* 330 */       byteBuffer.put(arrayOfByte[b]);
/* 331 */       byteBuffer.flip();
/*     */       try {
/* 333 */         charsetDecoder.decode(byteBuffer, charBuffer, (b == i - 1));
/* 334 */       } catch (IllegalArgumentException illegalArgumentException) {
/* 335 */         throw new UnsupportedOperationException("UTF-16 requested when runninng on an IBM JDK with broken UTF-16 support. Please find a JDK that supports UTF-16 if you intend to use UF-16 with WriterOutputStream");
/*     */       } 
/*     */       
/* 338 */       byteBuffer.compact();
/*     */     } 
/* 340 */     charBuffer.rewind();
/* 341 */     if (!"vés".equals(charBuffer.toString()))
/* 342 */       throw new UnsupportedOperationException("UTF-16 requested when runninng on an IBM JDK with broken UTF-16 support. Please find a JDK that supports UTF-16 if you intend to use UF-16 with WriterOutputStream"); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\output\WriterOutputStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */