/*     */ package org.apache.poi.util;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.Locale;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RLEDecompressingInputStream
/*     */   extends InputStream
/*     */ {
/*  36 */   private static final int[] POWER2 = new int[] { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final InputStream in;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final byte[] buf;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int pos;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int len;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RLEDecompressingInputStream(InputStream paramInputStream) throws IOException {
/*  74 */     this.in = paramInputStream;
/*  75 */     this.buf = new byte[4096];
/*  76 */     this.pos = 0;
/*  77 */     int i = paramInputStream.read();
/*  78 */     if (i != 1) {
/*  79 */       throw new IllegalArgumentException(String.format(Locale.ROOT, "Header byte 0x01 expected, received 0x%02X", new Object[] { Integer.valueOf(i & 0xFF) }));
/*     */     }
/*  81 */     this.len = readChunk();
/*     */   }
/*     */ 
/*     */   
/*     */   public int read() throws IOException {
/*  86 */     if (this.len == -1) {
/*  87 */       return -1;
/*     */     }
/*  89 */     if (this.pos >= this.len && (
/*  90 */       this.len = readChunk()) == -1) {
/*  91 */       return -1;
/*     */     }
/*     */     
/*  94 */     return this.buf[this.pos++];
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte) throws IOException {
/*  99 */     return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 104 */     if (this.len == -1) {
/* 105 */       return -1;
/*     */     }
/* 107 */     int i = paramInt1;
/* 108 */     int j = paramInt2;
/* 109 */     while (j > 0) {
/* 110 */       if (this.pos >= this.len && (
/* 111 */         this.len = readChunk()) == -1) {
/* 112 */         return (i > paramInt1) ? (i - paramInt1) : -1;
/*     */       }
/*     */       
/* 115 */       int k = Math.min(j, this.len - this.pos);
/* 116 */       System.arraycopy(this.buf, this.pos, paramArrayOfbyte, i, k);
/* 117 */       this.pos += k;
/* 118 */       j -= k;
/* 119 */       i += k;
/*     */     } 
/* 121 */     return paramInt2;
/*     */   }
/*     */ 
/*     */   
/*     */   public long skip(long paramLong) throws IOException {
/* 126 */     long l = paramLong;
/* 127 */     while (l > 0L) {
/* 128 */       if (this.pos >= this.len && (
/* 129 */         this.len = readChunk()) == -1) {
/* 130 */         return -1L;
/*     */       }
/*     */       
/* 133 */       int i = (int)Math.min(paramLong, (this.len - this.pos));
/* 134 */       this.pos += i;
/* 135 */       l -= i;
/*     */     } 
/* 137 */     return paramLong;
/*     */   }
/*     */ 
/*     */   
/*     */   public int available() {
/* 142 */     return (this.len > 0) ? (this.len - this.pos) : 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 147 */     this.in.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int readChunk() throws IOException {
/* 157 */     this.pos = 0;
/* 158 */     int i = readShort(this.in);
/* 159 */     if (i == -1) {
/* 160 */       return -1;
/*     */     }
/* 162 */     int j = (i & 0xFFF) + 1;
/* 163 */     if ((i & 0x7000) != 12288) {
/* 164 */       throw new IllegalArgumentException(String.format(Locale.ROOT, "Chunksize header A should be 0x3000, received 0x%04X", new Object[] { Integer.valueOf(i & 0xE000) }));
/*     */     }
/* 166 */     boolean bool = ((i & 0x8000) == 0) ? true : false;
/* 167 */     if (bool) {
/* 168 */       if (this.in.read(this.buf, 0, j) < j) {
/* 169 */         throw new IllegalStateException(String.format(Locale.ROOT, "Not enough bytes read, expected %d", new Object[] { Integer.valueOf(j) }));
/*     */       }
/* 171 */       return j;
/*     */     } 
/* 173 */     byte b1 = 0;
/* 174 */     byte b2 = 0;
/* 175 */     while (b1 < j) {
/* 176 */       int k = this.in.read();
/* 177 */       b1++;
/* 178 */       if (k == -1) {
/*     */         break;
/*     */       }
/* 181 */       for (byte b = 0; b < 8 && 
/* 182 */         b1 < j; b++) {
/*     */ 
/*     */         
/* 185 */         if ((k & POWER2[b]) == 0) {
/*     */           
/* 187 */           int m = this.in.read();
/* 188 */           if (m == -1) {
/* 189 */             return -1;
/*     */           }
/* 191 */           this.buf[b2++] = (byte)m;
/* 192 */           b1++;
/*     */         } else {
/*     */           
/* 195 */           int m = readShort(this.in);
/* 196 */           if (m == -1) {
/* 197 */             return -1;
/*     */           }
/* 199 */           b1 += 2;
/* 200 */           int n = getCopyLenBits(b2 - 1);
/* 201 */           int i1 = (m >> n) + 1;
/* 202 */           int i2 = (m & POWER2[n] - 1) + 3;
/* 203 */           int i3 = b2 - i1;
/* 204 */           int i4 = i3 + i2;
/* 205 */           for (int i5 = i3; i5 < i4; i5++) {
/* 206 */             this.buf[b2++] = this.buf[i5];
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 211 */     return b2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static int getCopyLenBits(int paramInt) {
/* 222 */     for (byte b = 11; b >= 4; b--) {
/* 223 */       if ((paramInt & POWER2[b]) != 0) {
/* 224 */         return 15 - b;
/*     */       }
/*     */     } 
/* 227 */     return 12;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int readShort() throws IOException {
/* 237 */     return readShort(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int readInt() throws IOException {
/* 247 */     return readInt(this);
/*     */   }
/*     */   
/*     */   private int readShort(InputStream paramInputStream) throws IOException {
/*     */     int i;
/* 252 */     if ((i = paramInputStream.read()) == -1)
/* 253 */       return -1; 
/*     */     int j;
/* 255 */     if ((j = paramInputStream.read()) == -1) {
/* 256 */       return -1;
/*     */     }
/* 258 */     return i & 0xFF | (j & 0xFF) << 8;
/*     */   }
/*     */   
/*     */   private int readInt(InputStream paramInputStream) throws IOException {
/*     */     int i;
/* 263 */     if ((i = paramInputStream.read()) == -1)
/* 264 */       return -1; 
/*     */     int j;
/* 266 */     if ((j = paramInputStream.read()) == -1)
/* 267 */       return -1; 
/*     */     int k;
/* 269 */     if ((k = paramInputStream.read()) == -1)
/* 270 */       return -1; 
/*     */     int m;
/* 272 */     if ((m = paramInputStream.read()) == -1) {
/* 273 */       return -1;
/*     */     }
/* 275 */     return i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16 | (m & 0xFF) << 24;
/*     */   }
/*     */   
/*     */   public static byte[] decompress(byte[] paramArrayOfbyte) throws IOException {
/* 279 */     return decompress(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */   
/*     */   public static byte[] decompress(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 283 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 284 */     ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(paramArrayOfbyte, paramInt1, paramInt2);
/* 285 */     RLEDecompressingInputStream rLEDecompressingInputStream = new RLEDecompressingInputStream(byteArrayInputStream);
/* 286 */     IOUtils.copy(rLEDecompressingInputStream, byteArrayOutputStream);
/* 287 */     rLEDecompressingInputStream.close();
/* 288 */     byteArrayOutputStream.close();
/* 289 */     return byteArrayOutputStream.toByteArray();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\RLEDecompressingInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */