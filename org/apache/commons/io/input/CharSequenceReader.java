/*     */ package org.apache.commons.io.input;
/*     */ 
/*     */ import java.io.Reader;
/*     */ import java.io.Serializable;
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
/*     */ public class CharSequenceReader
/*     */   extends Reader
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 3724187752191401220L;
/*     */   private final CharSequence charSequence;
/*     */   private int idx;
/*     */   private int mark;
/*     */   private final int start;
/*     */   private final Integer end;
/*     */   
/*     */   public CharSequenceReader(CharSequence paramCharSequence) {
/*  77 */     this(paramCharSequence, 0);
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
/*     */   public CharSequenceReader(CharSequence paramCharSequence, int paramInt) {
/*  96 */     this(paramCharSequence, paramInt, 2147483647);
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
/*     */   public CharSequenceReader(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 118 */     if (paramInt1 < 0) {
/* 119 */       throw new IllegalArgumentException("Start index is less than zero: " + paramInt1);
/*     */     }
/*     */     
/* 122 */     if (paramInt2 < paramInt1) {
/* 123 */       throw new IllegalArgumentException("End index is less than start " + paramInt1 + ": " + paramInt2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 129 */     this.charSequence = (paramCharSequence != null) ? paramCharSequence : "";
/* 130 */     this.start = paramInt1;
/* 131 */     this.end = Integer.valueOf(paramInt2);
/*     */     
/* 133 */     this.idx = paramInt1;
/* 134 */     this.mark = paramInt1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int start() {
/* 143 */     return Math.min(this.charSequence.length(), this.start);
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
/*     */   private int end() {
/* 156 */     return Math.min(this.charSequence.length(), (this.end == null) ? Integer.MAX_VALUE : this.end.intValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/* 164 */     this.idx = this.start;
/* 165 */     this.mark = this.start;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean ready() {
/* 175 */     return (this.idx < end());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mark(int paramInt) {
/* 185 */     this.mark = this.idx;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean markSupported() {
/* 195 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int read() {
/* 206 */     if (this.idx >= end()) {
/* 207 */       return -1;
/*     */     }
/* 209 */     return this.charSequence.charAt(this.idx++);
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
/*     */   public int read(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 223 */     if (this.idx >= end()) {
/* 224 */       return -1;
/*     */     }
/* 226 */     Objects.requireNonNull(paramArrayOfchar, "array");
/* 227 */     if (paramInt2 < 0 || paramInt1 < 0 || paramInt1 + paramInt2 > paramArrayOfchar.length) {
/* 228 */       throw new IndexOutOfBoundsException("Array Size=" + paramArrayOfchar.length + ", offset=" + paramInt1 + ", length=" + paramInt2);
/*     */     }
/*     */ 
/*     */     
/* 232 */     if (this.charSequence instanceof String) {
/* 233 */       int i = Math.min(paramInt2, end() - this.idx);
/* 234 */       ((String)this.charSequence).getChars(this.idx, this.idx + i, paramArrayOfchar, paramInt1);
/* 235 */       this.idx += i;
/* 236 */       return i;
/*     */     } 
/* 238 */     if (this.charSequence instanceof StringBuilder) {
/* 239 */       int i = Math.min(paramInt2, end() - this.idx);
/* 240 */       ((StringBuilder)this.charSequence).getChars(this.idx, this.idx + i, paramArrayOfchar, paramInt1);
/* 241 */       this.idx += i;
/* 242 */       return i;
/*     */     } 
/* 244 */     if (this.charSequence instanceof StringBuffer) {
/* 245 */       int i = Math.min(paramInt2, end() - this.idx);
/* 246 */       ((StringBuffer)this.charSequence).getChars(this.idx, this.idx + i, paramArrayOfchar, paramInt1);
/* 247 */       this.idx += i;
/* 248 */       return i;
/*     */     } 
/*     */     
/* 251 */     byte b1 = 0;
/* 252 */     for (byte b2 = 0; b2 < paramInt2; b2++) {
/* 253 */       int i = read();
/* 254 */       if (i == -1) {
/* 255 */         return b1;
/*     */       }
/* 257 */       paramArrayOfchar[paramInt1 + b2] = (char)i;
/* 258 */       b1++;
/*     */     } 
/* 260 */     return b1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/* 269 */     this.idx = this.mark;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long skip(long paramLong) {
/* 280 */     if (paramLong < 0L) {
/* 281 */       throw new IllegalArgumentException("Number of characters to skip is less than zero: " + paramLong);
/*     */     }
/*     */     
/* 284 */     if (this.idx >= end()) {
/* 285 */       return 0L;
/*     */     }
/* 287 */     int i = (int)Math.min(end(), this.idx + paramLong);
/* 288 */     int j = i - this.idx;
/* 289 */     this.idx = i;
/* 290 */     return j;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 301 */     CharSequence charSequence = this.charSequence.subSequence(start(), end());
/* 302 */     return charSequence.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\input\CharSequenceReader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */