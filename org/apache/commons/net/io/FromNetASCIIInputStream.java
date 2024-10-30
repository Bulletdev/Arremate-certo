/*     */ package org.apache.commons.net.io;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.PushbackInputStream;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class FromNetASCIIInputStream
/*     */   extends PushbackInputStream
/*     */ {
/*     */   static final boolean _noConversionRequired;
/*  42 */   static final String _lineSeparator = System.getProperty("line.separator"); static {
/*  43 */     _noConversionRequired = _lineSeparator.equals("\r\n");
/*  44 */     _lineSeparatorBytes = _lineSeparator.getBytes(StandardCharsets.US_ASCII);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final byte[] _lineSeparatorBytes;
/*     */ 
/*     */ 
/*     */   
/*     */   private int length;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isConversionRequired() {
/*  60 */     return !_noConversionRequired;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FromNetASCIIInputStream(InputStream paramInputStream) {
/*  70 */     super(paramInputStream, _lineSeparatorBytes.length + 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int readInt() throws IOException {
/*  78 */     int i = super.read();
/*     */     
/*  80 */     if (i == 13) {
/*     */       
/*  82 */       i = super.read();
/*  83 */       if (i == 10) {
/*     */         
/*  85 */         unread(_lineSeparatorBytes);
/*  86 */         i = super.read();
/*     */         
/*  88 */         this.length--;
/*     */       }
/*     */       else {
/*     */         
/*  92 */         if (i != -1) {
/*  93 */           unread(i);
/*     */         }
/*  95 */         return 13;
/*     */       } 
/*     */     } 
/*     */     
/*  99 */     return i;
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
/*     */   public int read() throws IOException {
/* 119 */     if (_noConversionRequired) {
/* 120 */       return super.read();
/*     */     }
/*     */     
/* 123 */     return readInt();
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
/*     */   public int read(byte[] paramArrayOfbyte) throws IOException {
/* 141 */     return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
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
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 162 */     if (_noConversionRequired) {
/* 163 */       return super.read(paramArrayOfbyte, paramInt1, paramInt2);
/*     */     }
/*     */     
/* 166 */     if (paramInt2 < 1) {
/* 167 */       return 0;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 173 */     int i = available();
/*     */     
/* 175 */     this.length = (paramInt2 > i) ? i : paramInt2;
/*     */ 
/*     */     
/* 178 */     if (this.length < 1) {
/* 179 */       this.length = 1;
/*     */     }
/*     */ 
/*     */     
/* 183 */     if ((i = readInt()) == -1) {
/* 184 */       return -1;
/*     */     }
/*     */     
/* 187 */     int j = paramInt1;
/*     */ 
/*     */     
/*     */     do {
/* 191 */       paramArrayOfbyte[paramInt1++] = (byte)i;
/*     */     }
/* 193 */     while (--this.length > 0 && (i = readInt()) != -1);
/*     */ 
/*     */     
/* 196 */     return paramInt1 - j;
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
/*     */   public int available() throws IOException {
/* 212 */     if (this.in == null) {
/* 213 */       throw new IOException("Stream closed");
/*     */     }
/* 215 */     return this.buf.length - this.pos + this.in.available();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\io\FromNetASCIIInputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */