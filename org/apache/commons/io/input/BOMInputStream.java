/*     */ package org.apache.commons.io.input;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import org.apache.commons.io.ByteOrderMark;
/*     */ import org.apache.commons.io.IOUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BOMInputStream
/*     */   extends ProxyInputStream
/*     */ {
/*     */   private final boolean include;
/*     */   private final List<ByteOrderMark> boms;
/*     */   private ByteOrderMark byteOrderMark;
/*     */   private int[] firstBytes;
/*     */   private int fbLength;
/*     */   private int fbIndex;
/*     */   private int markFbIndex;
/*     */   private boolean markedAtStart;
/*     */   private static final Comparator<ByteOrderMark> ByteOrderMarkLengthComparator;
/*     */   
/*     */   public BOMInputStream(InputStream paramInputStream) {
/* 108 */     this(paramInputStream, false, new ByteOrderMark[] { ByteOrderMark.UTF_8 });
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
/*     */   public BOMInputStream(InputStream paramInputStream, boolean paramBoolean) {
/* 120 */     this(paramInputStream, paramBoolean, new ByteOrderMark[] { ByteOrderMark.UTF_8 });
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
/*     */   public BOMInputStream(InputStream paramInputStream, ByteOrderMark... paramVarArgs) {
/* 132 */     this(paramInputStream, false, paramVarArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/* 138 */     ByteOrderMarkLengthComparator = ((paramByteOrderMark1, paramByteOrderMark2) -> {
/*     */         int i = paramByteOrderMark1.length();
/*     */         int j = paramByteOrderMark2.length();
/*     */         return Integer.compare(j, i);
/*     */       });
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
/*     */   public BOMInputStream(InputStream paramInputStream, boolean paramBoolean, ByteOrderMark... paramVarArgs) {
/* 155 */     super(paramInputStream);
/* 156 */     if (IOUtils.length((Object[])paramVarArgs) == 0) {
/* 157 */       throw new IllegalArgumentException("No BOMs specified");
/*     */     }
/* 159 */     this.include = paramBoolean;
/* 160 */     List<ByteOrderMark> list = Arrays.asList(paramVarArgs);
/*     */     
/* 162 */     list.sort(ByteOrderMarkLengthComparator);
/* 163 */     this.boms = list;
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
/*     */   public boolean hasBOM() throws IOException {
/* 175 */     return (getBOM() != null);
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
/*     */   public boolean hasBOM(ByteOrderMark paramByteOrderMark) throws IOException {
/* 190 */     if (!this.boms.contains(paramByteOrderMark)) {
/* 191 */       throw new IllegalArgumentException("Stream not configure to detect " + paramByteOrderMark);
/*     */     }
/* 193 */     getBOM();
/* 194 */     return (this.byteOrderMark != null && this.byteOrderMark.equals(paramByteOrderMark));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteOrderMark getBOM() throws IOException {
/* 205 */     if (this.firstBytes == null) {
/* 206 */       this.fbLength = 0;
/*     */       
/* 208 */       int i = ((ByteOrderMark)this.boms.get(0)).length();
/* 209 */       this.firstBytes = new int[i];
/*     */       
/* 211 */       for (byte b = 0; b < this.firstBytes.length; b++) {
/* 212 */         this.firstBytes[b] = this.in.read();
/* 213 */         this.fbLength++;
/* 214 */         if (this.firstBytes[b] < 0) {
/*     */           break;
/*     */         }
/*     */       } 
/*     */       
/* 219 */       this.byteOrderMark = find();
/* 220 */       if (this.byteOrderMark != null && 
/* 221 */         !this.include) {
/* 222 */         if (this.byteOrderMark.length() < this.firstBytes.length) {
/* 223 */           this.fbIndex = this.byteOrderMark.length();
/*     */         } else {
/* 225 */           this.fbLength = 0;
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 230 */     return this.byteOrderMark;
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
/*     */   public String getBOMCharsetName() throws IOException {
/* 242 */     getBOM();
/* 243 */     return (this.byteOrderMark == null) ? null : this.byteOrderMark.getCharsetName();
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
/*     */   private int readFirstBytes() throws IOException {
/* 256 */     getBOM();
/* 257 */     return (this.fbIndex < this.fbLength) ? this.firstBytes[this.fbIndex++] : -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ByteOrderMark find() {
/* 266 */     for (ByteOrderMark byteOrderMark : this.boms) {
/* 267 */       if (matches(byteOrderMark)) {
/* 268 */         return byteOrderMark;
/*     */       }
/*     */     } 
/* 271 */     return null;
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
/*     */   private boolean matches(ByteOrderMark paramByteOrderMark) {
/* 286 */     for (byte b = 0; b < paramByteOrderMark.length(); b++) {
/* 287 */       if (paramByteOrderMark.get(b) != this.firstBytes[b]) {
/* 288 */         return false;
/*     */       }
/*     */     } 
/* 291 */     return true;
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
/*     */   public int read() throws IOException {
/* 307 */     int i = readFirstBytes();
/* 308 */     return (i >= 0) ? i : this.in.read();
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
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 326 */     byte b = 0;
/* 327 */     int i = 0;
/* 328 */     while (paramInt2 > 0 && i) {
/* 329 */       i = readFirstBytes();
/* 330 */       if (i >= 0) {
/* 331 */         paramArrayOfbyte[paramInt1++] = (byte)(i & 0xFF);
/* 332 */         paramInt2--;
/* 333 */         b++;
/*     */       } 
/*     */     } 
/* 336 */     int j = this.in.read(paramArrayOfbyte, paramInt1, paramInt2);
/* 337 */     return (j < 0) ? ((b > 0) ? b : -1) : (b + j);
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
/*     */   public int read(byte[] paramArrayOfbyte) throws IOException {
/* 351 */     return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void mark(int paramInt) {
/* 362 */     this.markFbIndex = this.fbIndex;
/* 363 */     this.markedAtStart = (this.firstBytes == null);
/* 364 */     this.in.mark(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void reset() throws IOException {
/* 375 */     this.fbIndex = this.markFbIndex;
/* 376 */     if (this.markedAtStart) {
/* 377 */       this.firstBytes = null;
/*     */     }
/*     */     
/* 380 */     this.in.reset();
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
/*     */   public long skip(long paramLong) throws IOException {
/* 394 */     byte b = 0;
/* 395 */     while (paramLong > b && readFirstBytes() >= 0) {
/* 396 */       b++;
/*     */     }
/* 398 */     return this.in.skip(paramLong - b) + b;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\input\BOMInputStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */