/*     */ package org.apache.commons.io.input;
/*     */ 
/*     */ import java.io.Closeable;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.channels.SeekableByteChannel;
/*     */ import java.nio.charset.Charset;
/*     */ import java.nio.charset.CharsetEncoder;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.OpenOption;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.StandardOpenOption;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import org.apache.commons.io.Charsets;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ReversedLinesFileReader
/*     */   implements Closeable
/*     */ {
/*     */   private static final String EMPTY_STRING = "";
/*     */   private static final int DEFAULT_BLOCK_SIZE = 8192;
/*     */   private final int blockSize;
/*     */   private final Charset encoding;
/*     */   private final SeekableByteChannel channel;
/*     */   private final long totalByteLength;
/*     */   private final long totalBlockCount;
/*     */   private final byte[][] newLineSequences;
/*     */   private final int avoidNewlineSplitBufferSize;
/*     */   private final int byteDecrement;
/*     */   private FilePart currentFilePart;
/*     */   private boolean trailingNewlineOfFileSkipped;
/*     */   
/*     */   private class FilePart
/*     */   {
/*     */     private final long no;
/*     */     private final byte[] data;
/*     */     private byte[] leftOver;
/*     */     private int currentLastBytePos;
/*     */     
/*     */     private FilePart(long param1Long, int param1Int, byte[] param1ArrayOfbyte) throws IOException {
/*  64 */       this.no = param1Long;
/*  65 */       int i = param1Int + ((param1ArrayOfbyte != null) ? param1ArrayOfbyte.length : 0);
/*  66 */       this.data = new byte[i];
/*  67 */       long l = (param1Long - 1L) * ReversedLinesFileReader.this.blockSize;
/*     */ 
/*     */       
/*  70 */       if (param1Long > 0L) {
/*  71 */         ReversedLinesFileReader.this.channel.position(l);
/*  72 */         int j = ReversedLinesFileReader.this.channel.read(ByteBuffer.wrap(this.data, 0, param1Int));
/*  73 */         if (j != param1Int) {
/*  74 */           throw new IllegalStateException("Count of requested bytes and actually read bytes don't match");
/*     */         }
/*     */       } 
/*     */       
/*  78 */       if (param1ArrayOfbyte != null) {
/*  79 */         System.arraycopy(param1ArrayOfbyte, 0, this.data, param1Int, param1ArrayOfbyte.length);
/*     */       }
/*  81 */       this.currentLastBytePos = this.data.length - 1;
/*  82 */       this.leftOver = null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void createLeftOver() {
/*  89 */       int i = this.currentLastBytePos + 1;
/*  90 */       if (i > 0) {
/*     */         
/*  92 */         this.leftOver = new byte[i];
/*  93 */         System.arraycopy(this.data, 0, this.leftOver, 0, i);
/*     */       } else {
/*  95 */         this.leftOver = null;
/*     */       } 
/*  97 */       this.currentLastBytePos = -1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private int getNewLineMatchByteCount(byte[] param1ArrayOfbyte, int param1Int) {
/* 108 */       for (byte[] arrayOfByte : ReversedLinesFileReader.this.newLineSequences) {
/* 109 */         int i = 1;
/* 110 */         for (int j = arrayOfByte.length - 1; j >= 0; j--) {
/* 111 */           int k = param1Int + j - arrayOfByte.length - 1;
/* 112 */           i &= (k >= 0 && param1ArrayOfbyte[k] == arrayOfByte[j]) ? 1 : 0;
/*     */         } 
/* 114 */         if (i != 0) {
/* 115 */           return arrayOfByte.length;
/*     */         }
/*     */       } 
/* 118 */       return 0;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private String readLine() throws IOException {
/* 129 */       String str = null;
/*     */ 
/*     */       
/* 132 */       boolean bool = (this.no == 1L) ? true : false;
/*     */       
/* 134 */       int i = this.currentLastBytePos;
/* 135 */       while (i > -1) {
/*     */         
/* 137 */         if (!bool && i < ReversedLinesFileReader.this.avoidNewlineSplitBufferSize) {
/*     */ 
/*     */           
/* 140 */           createLeftOver();
/*     */           
/*     */           break;
/*     */         } 
/*     */         int j;
/* 145 */         if ((j = getNewLineMatchByteCount(this.data, i)) > 0) {
/* 146 */           int k = i + 1;
/* 147 */           int m = this.currentLastBytePos - k + 1;
/*     */           
/* 149 */           if (m < 0) {
/* 150 */             throw new IllegalStateException("Unexpected negative line length=" + m);
/*     */           }
/* 152 */           byte[] arrayOfByte = new byte[m];
/* 153 */           System.arraycopy(this.data, k, arrayOfByte, 0, m);
/*     */           
/* 155 */           str = new String(arrayOfByte, ReversedLinesFileReader.this.encoding);
/*     */           
/* 157 */           this.currentLastBytePos = i - j;
/*     */           
/*     */           break;
/*     */         } 
/*     */         
/* 162 */         i -= ReversedLinesFileReader.this.byteDecrement;
/*     */ 
/*     */         
/* 165 */         if (i < 0) {
/* 166 */           createLeftOver();
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */       
/* 172 */       if (bool && this.leftOver != null) {
/*     */         
/* 174 */         str = new String(this.leftOver, ReversedLinesFileReader.this.encoding);
/* 175 */         this.leftOver = null;
/*     */       } 
/*     */       
/* 178 */       return str;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private FilePart rollOver() throws IOException {
/* 189 */       if (this.currentLastBytePos > -1) {
/* 190 */         throw new IllegalStateException("Current currentLastCharPos unexpectedly positive... last readLine() should have returned something! currentLastCharPos=" + this.currentLastBytePos);
/*     */       }
/*     */ 
/*     */       
/* 194 */       if (this.no > 1L) {
/* 195 */         return new FilePart(this.no - 1L, ReversedLinesFileReader.this.blockSize, this.leftOver);
/*     */       }
/*     */       
/* 198 */       if (this.leftOver != null) {
/* 199 */         throw new IllegalStateException("Unexpected leftover of the last block: leftOverOfThisFilePart=" + new String(this.leftOver, ReversedLinesFileReader.this
/* 200 */               .encoding));
/*     */       }
/* 202 */       return null;
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
/*     */ 
/*     */ 
/*     */ 
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
/*     */   public ReversedLinesFileReader(File paramFile) throws IOException {
/* 230 */     this(paramFile, 8192, Charset.defaultCharset());
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
/*     */   public ReversedLinesFileReader(File paramFile, Charset paramCharset) throws IOException {
/* 243 */     this(paramFile.toPath(), paramCharset);
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
/*     */   public ReversedLinesFileReader(File paramFile, int paramInt, Charset paramCharset) throws IOException {
/* 258 */     this(paramFile.toPath(), paramInt, paramCharset);
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
/*     */   public ReversedLinesFileReader(File paramFile, int paramInt, String paramString) throws IOException {
/* 277 */     this(paramFile.toPath(), paramInt, paramString);
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
/*     */   public ReversedLinesFileReader(Path paramPath, Charset paramCharset) throws IOException {
/* 290 */     this(paramPath, 8192, paramCharset);
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
/*     */   public ReversedLinesFileReader(Path paramPath, int paramInt, Charset paramCharset) throws IOException {
/* 305 */     this.blockSize = paramInt;
/* 306 */     this.encoding = Charsets.toCharset(paramCharset);
/*     */ 
/*     */     
/* 309 */     CharsetEncoder charsetEncoder = this.encoding.newEncoder();
/* 310 */     float f = charsetEncoder.maxBytesPerChar();
/* 311 */     if (f == 1.0F)
/*     */     
/* 313 */     { this.byteDecrement = 1; }
/* 314 */     else if (this.encoding == StandardCharsets.UTF_8)
/*     */     
/*     */     { 
/*     */       
/* 318 */       this.byteDecrement = 1; }
/* 319 */     else if (this.encoding == Charset.forName("Shift_JIS") || this.encoding == 
/*     */       
/* 321 */       Charset.forName("windows-31j") || this.encoding == 
/* 322 */       Charset.forName("x-windows-949") || this.encoding == 
/* 323 */       Charset.forName("gbk") || this.encoding == 
/* 324 */       Charset.forName("x-windows-950"))
/* 325 */     { this.byteDecrement = 1; }
/* 326 */     else if (this.encoding == StandardCharsets.UTF_16BE || this.encoding == StandardCharsets.UTF_16LE)
/*     */     
/*     */     { 
/*     */       
/* 330 */       this.byteDecrement = 2; }
/* 331 */     else { if (this.encoding == StandardCharsets.UTF_16) {
/* 332 */         throw new UnsupportedEncodingException("For UTF-16, you need to specify the byte order (use UTF-16BE or UTF-16LE)");
/*     */       }
/*     */       
/* 335 */       throw new UnsupportedEncodingException("Encoding " + paramCharset + " is not supported yet (feel free to submit a patch)"); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 341 */     this
/* 342 */       .newLineSequences = new byte[][] { "\r\n".getBytes(this.encoding), "\n".getBytes(this.encoding), "\r".getBytes(this.encoding) };
/*     */     
/* 344 */     this.avoidNewlineSplitBufferSize = (this.newLineSequences[0]).length;
/*     */ 
/*     */     
/* 347 */     this.channel = Files.newByteChannel(paramPath, new OpenOption[] { StandardOpenOption.READ });
/* 348 */     this.totalByteLength = this.channel.size();
/* 349 */     int i = (int)(this.totalByteLength % paramInt);
/* 350 */     if (i > 0) {
/* 351 */       this.totalBlockCount = this.totalByteLength / paramInt + 1L;
/*     */     } else {
/* 353 */       this.totalBlockCount = this.totalByteLength / paramInt;
/* 354 */       if (this.totalByteLength > 0L) {
/* 355 */         i = paramInt;
/*     */       }
/*     */     } 
/* 358 */     this.currentFilePart = new FilePart(this.totalBlockCount, i, null);
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
/*     */   public ReversedLinesFileReader(Path paramPath, int paramInt, String paramString) throws IOException {
/* 379 */     this(paramPath, paramInt, Charsets.toCharset(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 389 */     this.channel.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String readLine() throws IOException {
/* 400 */     String str = this.currentFilePart.readLine();
/* 401 */     while (str == null) {
/* 402 */       this.currentFilePart = this.currentFilePart.rollOver();
/* 403 */       if (this.currentFilePart != null) {
/* 404 */         str = this.currentFilePart.readLine();
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 412 */     if ("".equals(str) && !this.trailingNewlineOfFileSkipped) {
/* 413 */       this.trailingNewlineOfFileSkipped = true;
/* 414 */       str = readLine();
/*     */     } 
/*     */     
/* 417 */     return str;
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
/*     */   public List<String> readLines(int paramInt) throws IOException {
/* 436 */     if (paramInt < 0) {
/* 437 */       throw new IllegalArgumentException("lineCount < 0");
/*     */     }
/* 439 */     ArrayList<String> arrayList = new ArrayList(paramInt);
/* 440 */     for (byte b = 0; b < paramInt; b++) {
/* 441 */       String str = readLine();
/* 442 */       if (str == null) {
/* 443 */         return arrayList;
/*     */       }
/* 445 */       arrayList.add(str);
/*     */     } 
/* 447 */     return arrayList;
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
/*     */   public String toString(int paramInt) throws IOException {
/* 463 */     List<String> list = readLines(paramInt);
/* 464 */     Collections.reverse(list);
/* 465 */     return list.isEmpty() ? "" : (String.join(System.lineSeparator(), (Iterable)list) + System.lineSeparator());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\input\ReversedLinesFileReader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */