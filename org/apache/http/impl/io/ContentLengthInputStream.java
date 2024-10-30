/*     */ package org.apache.http.impl.io;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import org.apache.http.ConnectionClosedException;
/*     */ import org.apache.http.io.BufferInfo;
/*     */ import org.apache.http.io.SessionInputBuffer;
/*     */ import org.apache.http.util.Args;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ContentLengthInputStream
/*     */   extends InputStream
/*     */ {
/*     */   private static final int BUFFER_SIZE = 2048;
/*     */   private final long contentLength;
/*  64 */   private long pos = 0L;
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean closed = false;
/*     */ 
/*     */ 
/*     */   
/*  72 */   private SessionInputBuffer in = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ContentLengthInputStream(SessionInputBuffer paramSessionInputBuffer, long paramLong) {
/*  84 */     this.in = (SessionInputBuffer)Args.notNull(paramSessionInputBuffer, "Session input buffer");
/*  85 */     this.contentLength = Args.notNegative(paramLong, "Content length");
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
/*     */   public void close() throws IOException {
/*  97 */     if (!this.closed) {
/*     */       try {
/*  99 */         if (this.pos < this.contentLength) {
/* 100 */           byte[] arrayOfByte = new byte[2048];
/* 101 */           while (read(arrayOfByte) >= 0);
/*     */         
/*     */         }
/*     */       
/*     */       }
/*     */       finally {
/*     */         
/* 108 */         this.closed = true;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int available() throws IOException {
/* 115 */     if (this.in instanceof BufferInfo) {
/* 116 */       int i = ((BufferInfo)this.in).length();
/* 117 */       return Math.min(i, (int)(this.contentLength - this.pos));
/*     */     } 
/* 119 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int read() throws IOException {
/* 130 */     if (this.closed) {
/* 131 */       throw new IOException("Attempted read from closed stream.");
/*     */     }
/*     */     
/* 134 */     if (this.pos >= this.contentLength) {
/* 135 */       return -1;
/*     */     }
/* 137 */     int i = this.in.read();
/* 138 */     if (i == -1) {
/* 139 */       if (this.pos < this.contentLength) {
/* 140 */         throw new ConnectionClosedException("Premature end of Content-Length delimited message body (expected: %,d; received: %,d)", new Object[] { Long.valueOf(this.contentLength), Long.valueOf(this.pos) });
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/* 145 */       this.pos++;
/*     */     } 
/* 147 */     return i;
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
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 164 */     if (this.closed) {
/* 165 */       throw new IOException("Attempted read from closed stream.");
/*     */     }
/*     */     
/* 168 */     if (this.pos >= this.contentLength) {
/* 169 */       return -1;
/*     */     }
/*     */     
/* 172 */     int i = paramInt2;
/* 173 */     if (this.pos + paramInt2 > this.contentLength) {
/* 174 */       i = (int)(this.contentLength - this.pos);
/*     */     }
/* 176 */     int j = this.in.read(paramArrayOfbyte, paramInt1, i);
/* 177 */     if (j == -1 && this.pos < this.contentLength) {
/* 178 */       throw new ConnectionClosedException("Premature end of Content-Length delimited message body (expected: %,d; received: %,d)", new Object[] { Long.valueOf(this.contentLength), Long.valueOf(this.pos) });
/*     */     }
/*     */ 
/*     */     
/* 182 */     if (j > 0) {
/* 183 */       this.pos += j;
/*     */     }
/* 185 */     return j;
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
/* 198 */     return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
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
/*     */   public long skip(long paramLong) throws IOException {
/* 211 */     if (paramLong <= 0L) {
/* 212 */       return 0L;
/*     */     }
/* 214 */     byte[] arrayOfByte = new byte[2048];
/*     */ 
/*     */     
/* 217 */     long l1 = Math.min(paramLong, this.contentLength - this.pos);
/*     */     
/* 219 */     long l2 = 0L;
/* 220 */     while (l1 > 0L) {
/* 221 */       int i = read(arrayOfByte, 0, (int)Math.min(2048L, l1));
/* 222 */       if (i == -1) {
/*     */         break;
/*     */       }
/* 225 */       l2 += i;
/* 226 */       l1 -= i;
/*     */     } 
/* 228 */     return l2;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\io\ContentLengthInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */