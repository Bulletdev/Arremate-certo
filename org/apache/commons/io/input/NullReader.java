/*     */ package org.apache.commons.io.input;
/*     */ 
/*     */ import java.io.EOFException;
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NullReader
/*     */   extends Reader
/*     */ {
/*     */   private final long size;
/*     */   private long position;
/*  71 */   private long mark = -1L;
/*     */ 
/*     */   
/*     */   private long readlimit;
/*     */   
/*     */   private boolean eof;
/*     */   
/*     */   private final boolean throwEofException;
/*     */   
/*     */   private final boolean markSupported;
/*     */ 
/*     */   
/*     */   public NullReader() {
/*  84 */     this(0L, true, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NullReader(long paramLong) {
/*  94 */     this(paramLong, true, false);
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
/*     */   public NullReader(long paramLong, boolean paramBoolean1, boolean paramBoolean2) {
/* 109 */     this.size = paramLong;
/* 110 */     this.markSupported = paramBoolean1;
/* 111 */     this.throwEofException = paramBoolean2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getPosition() {
/* 120 */     return this.position;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getSize() {
/* 129 */     return this.size;
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
/* 140 */     this.eof = false;
/* 141 */     this.position = 0L;
/* 142 */     this.mark = -1L;
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
/*     */   public synchronized void mark(int paramInt) {
/* 154 */     if (!this.markSupported) {
/* 155 */       throw new UnsupportedOperationException("Mark not supported");
/*     */     }
/* 157 */     this.mark = this.position;
/* 158 */     this.readlimit = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean markSupported() {
/* 168 */     return this.markSupported;
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
/*     */   public int read() throws IOException {
/* 183 */     if (this.eof) {
/* 184 */       throw new IOException("Read after end of file");
/*     */     }
/* 186 */     if (this.position == this.size) {
/* 187 */       return doEndOfFile();
/*     */     }
/* 189 */     this.position++;
/* 190 */     return processChar();
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
/*     */   public int read(char[] paramArrayOfchar) throws IOException {
/* 206 */     return read(paramArrayOfchar, 0, paramArrayOfchar.length);
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
/*     */   public int read(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
/* 224 */     if (this.eof) {
/* 225 */       throw new IOException("Read after end of file");
/*     */     }
/* 227 */     if (this.position == this.size) {
/* 228 */       return doEndOfFile();
/*     */     }
/* 230 */     this.position += paramInt2;
/* 231 */     int i = paramInt2;
/* 232 */     if (this.position > this.size) {
/* 233 */       i = paramInt2 - (int)(this.position - this.size);
/* 234 */       this.position = this.size;
/*     */     } 
/* 236 */     processChars(paramArrayOfchar, paramInt1, i);
/* 237 */     return i;
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
/*     */   public synchronized void reset() throws IOException {
/* 250 */     if (!this.markSupported) {
/* 251 */       throw new UnsupportedOperationException("Mark not supported");
/*     */     }
/* 253 */     if (this.mark < 0L) {
/* 254 */       throw new IOException("No position has been marked");
/*     */     }
/* 256 */     if (this.position > this.mark + this.readlimit) {
/* 257 */       throw new IOException("Marked position [" + this.mark + "] is no longer valid - passed the read limit [" + this.readlimit + "]");
/*     */     }
/*     */ 
/*     */     
/* 261 */     this.position = this.mark;
/* 262 */     this.eof = false;
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
/*     */   public long skip(long paramLong) throws IOException {
/* 278 */     if (this.eof) {
/* 279 */       throw new IOException("Skip after end of file");
/*     */     }
/* 281 */     if (this.position == this.size) {
/* 282 */       return doEndOfFile();
/*     */     }
/* 284 */     this.position += paramLong;
/* 285 */     long l = paramLong;
/* 286 */     if (this.position > this.size) {
/* 287 */       l = paramLong - this.position - this.size;
/* 288 */       this.position = this.size;
/*     */     } 
/* 290 */     return l;
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
/*     */   protected int processChar() {
/* 303 */     return 0;
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
/*     */   protected void processChars(char[] paramArrayOfchar, int paramInt1, int paramInt2) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int doEndOfFile() throws EOFException {
/* 330 */     this.eof = true;
/* 331 */     if (this.throwEofException) {
/* 332 */       throw new EOFException();
/*     */     }
/* 334 */     return -1;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\input\NullReader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */