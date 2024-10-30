/*     */ package org.h2.store.fs;
/*     */ 
/*     */ import java.io.EOFException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.nio.channels.FileLock;
/*     */ import java.nio.channels.SeekableByteChannel;
/*     */ import java.util.Arrays;
/*     */ import org.h2.engine.Constants;
/*     */ import org.h2.mvstore.DataUtils;
/*     */ import org.h2.security.AES;
/*     */ import org.h2.security.BlockCipher;
/*     */ import org.h2.security.SHA256;
/*     */ import org.h2.util.MathUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FilePathEncrypt
/*     */   extends FilePathWrapper
/*     */ {
/*     */   private static final String SCHEME = "encrypt";
/*     */   
/*     */   public static void register() {
/*  35 */     FilePath.register(new FilePathEncrypt());
/*     */   }
/*     */ 
/*     */   
/*     */   public FileChannel open(String paramString) throws IOException {
/*  40 */     String[] arrayOfString = parse(this.name);
/*  41 */     FileChannel fileChannel = FileUtils.open(arrayOfString[1], paramString);
/*  42 */     byte[] arrayOfByte = arrayOfString[0].getBytes(Constants.UTF8);
/*  43 */     return new FileEncrypt(this.name, arrayOfByte, fileChannel);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getScheme() {
/*  48 */     return "encrypt";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String getPrefix() {
/*  53 */     String[] arrayOfString = parse(this.name);
/*  54 */     return getScheme() + ":" + arrayOfString[0] + ":";
/*     */   }
/*     */ 
/*     */   
/*     */   public FilePath unwrap(String paramString) {
/*  59 */     return FilePath.get(parse(paramString)[1]);
/*     */   }
/*     */ 
/*     */   
/*     */   public long size() {
/*  64 */     long l = getBase().size() - 4096L;
/*  65 */     l = Math.max(0L, l);
/*  66 */     if ((l & 0xFFFL) != 0L) {
/*  67 */       l -= 4096L;
/*     */     }
/*  69 */     return l;
/*     */   }
/*     */ 
/*     */   
/*     */   public OutputStream newOutputStream(boolean paramBoolean) throws IOException {
/*  74 */     return new FileChannelOutputStream(open("rw"), paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream newInputStream() throws IOException {
/*  79 */     return new FileChannelInputStream(open("r"), true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String[] parse(String paramString) {
/*  89 */     if (!paramString.startsWith(getScheme())) {
/*  90 */       throw new IllegalArgumentException(paramString + " doesn't start with " + getScheme());
/*     */     }
/*     */     
/*  93 */     paramString = paramString.substring(getScheme().length() + 1);
/*  94 */     int i = paramString.indexOf(':');
/*     */     
/*  96 */     if (i < 0) {
/*  97 */       throw new IllegalArgumentException(paramString + " doesn't contain encryption algorithm and password");
/*     */     }
/*     */     
/* 100 */     String str = paramString.substring(0, i);
/* 101 */     paramString = paramString.substring(i + 1);
/* 102 */     return new String[] { str, paramString };
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
/*     */   public static byte[] getPasswordBytes(char[] paramArrayOfchar) {
/* 114 */     int i = paramArrayOfchar.length;
/* 115 */     byte[] arrayOfByte = new byte[i * 2];
/* 116 */     for (byte b = 0; b < i; b++) {
/* 117 */       char c = paramArrayOfchar[b];
/* 118 */       arrayOfByte[b + b] = (byte)(c >>> 8);
/* 119 */       arrayOfByte[b + b + 1] = (byte)c;
/*     */     } 
/* 121 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class FileEncrypt
/*     */     extends FileBase
/*     */   {
/*     */     static final int BLOCK_SIZE = 4096;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     static final int BLOCK_SIZE_MASK = 4095;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     static final int HEADER_LENGTH = 4096;
/*     */ 
/*     */ 
/*     */     
/* 145 */     private static final byte[] HEADER = "H2encrypt\n".getBytes();
/* 146 */     private static final int SALT_POS = HEADER.length;
/*     */ 
/*     */ 
/*     */     
/*     */     private static final int SALT_LENGTH = 8;
/*     */ 
/*     */ 
/*     */     
/*     */     private static final int HASH_ITERATIONS = 10;
/*     */ 
/*     */ 
/*     */     
/*     */     private final FileChannel base;
/*     */ 
/*     */ 
/*     */     
/*     */     private long pos;
/*     */ 
/*     */ 
/*     */     
/*     */     private long size;
/*     */ 
/*     */ 
/*     */     
/*     */     private final String name;
/*     */ 
/*     */     
/*     */     private FilePathEncrypt.XTS xts;
/*     */ 
/*     */     
/*     */     private byte[] encryptionKey;
/*     */ 
/*     */ 
/*     */     
/*     */     public FileEncrypt(String param1String, byte[] param1ArrayOfbyte, FileChannel param1FileChannel) {
/* 181 */       this.name = param1String;
/* 182 */       this.base = param1FileChannel;
/* 183 */       this.encryptionKey = param1ArrayOfbyte;
/*     */     }
/*     */     private void init() throws IOException {
/*     */       byte[] arrayOfByte;
/* 187 */       if (this.xts != null) {
/*     */         return;
/*     */       }
/* 190 */       this.size = this.base.size() - 4096L;
/* 191 */       boolean bool = (this.size < 0L) ? true : false;
/*     */       
/* 193 */       if (bool) {
/* 194 */         byte[] arrayOfByte1 = Arrays.copyOf(HEADER, 4096);
/* 195 */         arrayOfByte = MathUtils.secureRandomBytes(8);
/* 196 */         System.arraycopy(arrayOfByte, 0, arrayOfByte1, SALT_POS, arrayOfByte.length);
/* 197 */         DataUtils.writeFully(this.base, 0L, ByteBuffer.wrap(arrayOfByte1));
/* 198 */         this.size = 0L;
/*     */       } else {
/* 200 */         arrayOfByte = new byte[8];
/* 201 */         DataUtils.readFully(this.base, SALT_POS, ByteBuffer.wrap(arrayOfByte));
/* 202 */         if ((this.size & 0xFFFL) != 0L) {
/* 203 */           this.size -= 4096L;
/*     */         }
/*     */       } 
/* 206 */       AES aES = new AES();
/* 207 */       aES.setKey(SHA256.getPBKDF2(this.encryptionKey, arrayOfByte, 10, 16));
/*     */       
/* 209 */       this.encryptionKey = null;
/* 210 */       this.xts = new FilePathEncrypt.XTS((BlockCipher)aES);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void implCloseChannel() throws IOException {
/* 215 */       this.base.close();
/*     */     }
/*     */ 
/*     */     
/*     */     public FileChannel position(long param1Long) throws IOException {
/* 220 */       this.pos = param1Long;
/* 221 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public long position() throws IOException {
/* 226 */       return this.pos;
/*     */     }
/*     */ 
/*     */     
/*     */     public int read(ByteBuffer param1ByteBuffer) throws IOException {
/* 231 */       int i = read(param1ByteBuffer, this.pos);
/* 232 */       if (i > 0) {
/* 233 */         this.pos += i;
/*     */       }
/* 235 */       return i;
/*     */     }
/*     */ 
/*     */     
/*     */     public int read(ByteBuffer param1ByteBuffer, long param1Long) throws IOException {
/* 240 */       int i = param1ByteBuffer.remaining();
/* 241 */       if (i == 0) {
/* 242 */         return 0;
/*     */       }
/* 244 */       init();
/* 245 */       i = (int)Math.min(i, this.size - param1Long);
/* 246 */       if (param1Long >= this.size)
/* 247 */         return -1; 
/* 248 */       if (param1Long < 0L) {
/* 249 */         throw new IllegalArgumentException("pos: " + param1Long);
/*     */       }
/* 251 */       if ((param1Long & 0xFFFL) != 0L || (i & 0xFFF) != 0) {
/*     */ 
/*     */ 
/*     */         
/* 255 */         long l = param1Long / 4096L * 4096L;
/* 256 */         int j = (int)(param1Long - l);
/* 257 */         int k = (i + j + 4096 - 1) / 4096 * 4096;
/* 258 */         ByteBuffer byteBuffer = ByteBuffer.allocate(k);
/* 259 */         readInternal(byteBuffer, l, k);
/* 260 */         byteBuffer.flip();
/* 261 */         byteBuffer.limit(j + i);
/* 262 */         byteBuffer.position(j);
/* 263 */         param1ByteBuffer.put(byteBuffer);
/* 264 */         return i;
/*     */       } 
/* 266 */       readInternal(param1ByteBuffer, param1Long, i);
/* 267 */       return i;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void readInternal(ByteBuffer param1ByteBuffer, long param1Long, int param1Int) throws IOException {
/*     */       // Byte code:
/*     */       //   0: aload_1
/*     */       //   1: invokevirtual position : ()I
/*     */       //   4: istore #5
/*     */       //   6: aload_0
/*     */       //   7: getfield base : Ljava/nio/channels/FileChannel;
/*     */       //   10: lload_2
/*     */       //   11: ldc2_w 4096
/*     */       //   14: ladd
/*     */       //   15: aload_1
/*     */       //   16: invokestatic readFully : (Ljava/nio/channels/FileChannel;JLjava/nio/ByteBuffer;)V
/*     */       //   19: lload_2
/*     */       //   20: ldc2_w 4096
/*     */       //   23: ldiv
/*     */       //   24: lstore #6
/*     */       //   26: iload #4
/*     */       //   28: ifle -> 74
/*     */       //   31: aload_0
/*     */       //   32: getfield xts : Lorg/h2/store/fs/FilePathEncrypt$XTS;
/*     */       //   35: lload #6
/*     */       //   37: dup2
/*     */       //   38: lconst_1
/*     */       //   39: ladd
/*     */       //   40: lstore #6
/*     */       //   42: sipush #4096
/*     */       //   45: aload_1
/*     */       //   46: invokevirtual array : ()[B
/*     */       //   49: aload_1
/*     */       //   50: invokevirtual arrayOffset : ()I
/*     */       //   53: iload #5
/*     */       //   55: iadd
/*     */       //   56: invokevirtual decrypt : (JI[BI)V
/*     */       //   59: wide iinc #5 4096
/*     */       //   65: wide iinc #4 -4096
/*     */       //   71: goto -> 26
/*     */       //   74: return
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #272	-> 0
/*     */       //   #273	-> 6
/*     */       //   #274	-> 19
/*     */       //   #275	-> 26
/*     */       //   #276	-> 31
/*     */       //   #277	-> 59
/*     */       //   #278	-> 65
/*     */       //   #280	-> 74
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static void readFully(FileChannel param1FileChannel, long param1Long, ByteBuffer param1ByteBuffer) throws IOException {
/*     */       do {
/* 285 */         int i = param1FileChannel.read(param1ByteBuffer, param1Long);
/* 286 */         if (i < 0) {
/* 287 */           throw new EOFException();
/*     */         }
/* 289 */         param1Long += i;
/* 290 */       } while (param1ByteBuffer.remaining() > 0);
/*     */     }
/*     */ 
/*     */     
/*     */     public int write(ByteBuffer param1ByteBuffer, long param1Long) throws IOException {
/* 295 */       init();
/* 296 */       int i = param1ByteBuffer.remaining();
/* 297 */       if ((param1Long & 0xFFFL) != 0L || (i & 0xFFF) != 0) {
/*     */ 
/*     */ 
/*     */         
/* 301 */         long l1 = param1Long / 4096L * 4096L;
/* 302 */         int j = (int)(param1Long - l1);
/* 303 */         int k = (i + j + 4096 - 1) / 4096 * 4096;
/* 304 */         ByteBuffer byteBuffer = ByteBuffer.allocate(k);
/* 305 */         int m = (int)(this.size - l1 + 4096L - 1L) / 4096 * 4096;
/* 306 */         int n = Math.min(k, m);
/* 307 */         if (n > 0) {
/* 308 */           readInternal(byteBuffer, l1, n);
/* 309 */           byteBuffer.rewind();
/*     */         } 
/* 311 */         byteBuffer.limit(j + i);
/* 312 */         byteBuffer.position(j);
/* 313 */         byteBuffer.put(param1ByteBuffer);
/* 314 */         byteBuffer.limit(k);
/* 315 */         byteBuffer.rewind();
/* 316 */         writeInternal(byteBuffer, l1, k);
/* 317 */         long l2 = param1Long + i;
/* 318 */         this.size = Math.max(this.size, l2);
/* 319 */         int i1 = (int)(this.size & 0xFFFL);
/* 320 */         if (i1 > 0) {
/* 321 */           byteBuffer = ByteBuffer.allocate(i1);
/* 322 */           DataUtils.writeFully(this.base, l1 + 4096L + k, byteBuffer);
/*     */         } 
/* 324 */         return i;
/*     */       } 
/* 326 */       writeInternal(param1ByteBuffer, param1Long, i);
/* 327 */       long l = param1Long + i;
/* 328 */       this.size = Math.max(this.size, l);
/* 329 */       return i;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void writeInternal(ByteBuffer param1ByteBuffer, long param1Long, int param1Int) throws IOException {
/*     */       // Byte code:
/*     */       //   0: iload #4
/*     */       //   2: invokestatic allocate : (I)Ljava/nio/ByteBuffer;
/*     */       //   5: astore #5
/*     */       //   7: aload #5
/*     */       //   9: aload_1
/*     */       //   10: invokevirtual put : (Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
/*     */       //   13: pop
/*     */       //   14: aload #5
/*     */       //   16: invokevirtual flip : ()Ljava/nio/Buffer;
/*     */       //   19: pop
/*     */       //   20: lload_2
/*     */       //   21: ldc2_w 4096
/*     */       //   24: ldiv
/*     */       //   25: lstore #6
/*     */       //   27: iconst_0
/*     */       //   28: istore #8
/*     */       //   30: iload #4
/*     */       //   32: istore #9
/*     */       //   34: iload #9
/*     */       //   36: ifle -> 84
/*     */       //   39: aload_0
/*     */       //   40: getfield xts : Lorg/h2/store/fs/FilePathEncrypt$XTS;
/*     */       //   43: lload #6
/*     */       //   45: dup2
/*     */       //   46: lconst_1
/*     */       //   47: ladd
/*     */       //   48: lstore #6
/*     */       //   50: sipush #4096
/*     */       //   53: aload #5
/*     */       //   55: invokevirtual array : ()[B
/*     */       //   58: aload #5
/*     */       //   60: invokevirtual arrayOffset : ()I
/*     */       //   63: iload #8
/*     */       //   65: iadd
/*     */       //   66: invokevirtual encrypt : (JI[BI)V
/*     */       //   69: wide iinc #8 4096
/*     */       //   75: wide iinc #9 -4096
/*     */       //   81: goto -> 34
/*     */       //   84: aload_0
/*     */       //   85: getfield base : Ljava/nio/channels/FileChannel;
/*     */       //   88: lload_2
/*     */       //   89: ldc2_w 4096
/*     */       //   92: ladd
/*     */       //   93: aload #5
/*     */       //   95: invokestatic writeFully : (Ljava/nio/channels/FileChannel;JLjava/nio/ByteBuffer;)V
/*     */       //   98: return
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #334	-> 0
/*     */       //   #335	-> 7
/*     */       //   #336	-> 14
/*     */       //   #337	-> 20
/*     */       //   #338	-> 27
/*     */       //   #339	-> 34
/*     */       //   #340	-> 39
/*     */       //   #341	-> 69
/*     */       //   #342	-> 75
/*     */       //   #344	-> 84
/*     */       //   #345	-> 98
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static void writeFully(FileChannel param1FileChannel, long param1Long, ByteBuffer param1ByteBuffer) throws IOException {
/* 349 */       int i = 0;
/*     */       do {
/* 351 */         int j = param1FileChannel.write(param1ByteBuffer, param1Long + i);
/* 352 */         i += j;
/* 353 */       } while (param1ByteBuffer.remaining() > 0);
/*     */     }
/*     */ 
/*     */     
/*     */     public int write(ByteBuffer param1ByteBuffer) throws IOException {
/* 358 */       int i = write(param1ByteBuffer, this.pos);
/* 359 */       if (i > 0) {
/* 360 */         this.pos += i;
/*     */       }
/* 362 */       return i;
/*     */     }
/*     */ 
/*     */     
/*     */     public long size() throws IOException {
/* 367 */       init();
/* 368 */       return this.size;
/*     */     }
/*     */ 
/*     */     
/*     */     public FileChannel truncate(long param1Long) throws IOException {
/* 373 */       init();
/* 374 */       if (param1Long > this.size) {
/* 375 */         return this;
/*     */       }
/* 377 */       if (param1Long < 0L) {
/* 378 */         throw new IllegalArgumentException("newSize: " + param1Long);
/*     */       }
/* 380 */       int i = (int)(param1Long & 0xFFFL);
/* 381 */       if (i > 0) {
/* 382 */         this.base.truncate(param1Long + 4096L + 4096L);
/*     */       } else {
/* 384 */         this.base.truncate(param1Long + 4096L);
/*     */       } 
/* 386 */       this.size = param1Long;
/* 387 */       this.pos = Math.min(this.pos, this.size);
/* 388 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public void force(boolean param1Boolean) throws IOException {
/* 393 */       this.base.force(param1Boolean);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public FileLock tryLock(long param1Long1, long param1Long2, boolean param1Boolean) throws IOException {
/* 399 */       return this.base.tryLock(param1Long1, param1Long2, param1Boolean);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 404 */       return this.name;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class XTS
/*     */   {
/*     */     private static final int GF_128_FEEDBACK = 135;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static final int CIPHER_BLOCK_SIZE = 16;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final BlockCipher cipher;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XTS(BlockCipher param1BlockCipher) {
/* 430 */       this.cipher = param1BlockCipher;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void encrypt(long param1Long, int param1Int1, byte[] param1ArrayOfbyte, int param1Int2) {
/* 442 */       byte[] arrayOfByte = initTweak(param1Long);
/* 443 */       byte b = 0;
/* 444 */       for (; b + 16 <= param1Int1; b += 16) {
/* 445 */         if (b > 0) {
/* 446 */           updateTweak(arrayOfByte);
/*     */         }
/* 448 */         xorTweak(param1ArrayOfbyte, b + param1Int2, arrayOfByte);
/* 449 */         this.cipher.encrypt(param1ArrayOfbyte, b + param1Int2, 16);
/* 450 */         xorTweak(param1ArrayOfbyte, b + param1Int2, arrayOfByte);
/*     */       } 
/* 452 */       if (b < param1Int1) {
/* 453 */         updateTweak(arrayOfByte);
/* 454 */         swap(param1ArrayOfbyte, b + param1Int2, b - 16 + param1Int2, param1Int1 - b);
/* 455 */         xorTweak(param1ArrayOfbyte, b - 16 + param1Int2, arrayOfByte);
/* 456 */         this.cipher.encrypt(param1ArrayOfbyte, b - 16 + param1Int2, 16);
/* 457 */         xorTweak(param1ArrayOfbyte, b - 16 + param1Int2, arrayOfByte);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void decrypt(long param1Long, int param1Int1, byte[] param1ArrayOfbyte, int param1Int2) {
/* 470 */       byte[] arrayOfByte1 = initTweak(param1Long), arrayOfByte2 = arrayOfByte1;
/* 471 */       byte b = 0;
/* 472 */       for (; b + 16 <= param1Int1; b += 16) {
/* 473 */         if (b > 0) {
/* 474 */           updateTweak(arrayOfByte1);
/* 475 */           if (b + 16 + 16 > param1Int1 && b + 16 < param1Int1) {
/*     */             
/* 477 */             arrayOfByte2 = (byte[])arrayOfByte1.clone();
/* 478 */             updateTweak(arrayOfByte1);
/*     */           } 
/*     */         } 
/* 481 */         xorTweak(param1ArrayOfbyte, b + param1Int2, arrayOfByte1);
/* 482 */         this.cipher.decrypt(param1ArrayOfbyte, b + param1Int2, 16);
/* 483 */         xorTweak(param1ArrayOfbyte, b + param1Int2, arrayOfByte1);
/*     */       } 
/* 485 */       if (b < param1Int1) {
/* 486 */         swap(param1ArrayOfbyte, b, b - 16 + param1Int2, param1Int1 - b + param1Int2);
/* 487 */         xorTweak(param1ArrayOfbyte, b - 16 + param1Int2, arrayOfByte2);
/* 488 */         this.cipher.decrypt(param1ArrayOfbyte, b - 16 + param1Int2, 16);
/* 489 */         xorTweak(param1ArrayOfbyte, b - 16 + param1Int2, arrayOfByte2);
/*     */       } 
/*     */     }
/*     */     
/*     */     private byte[] initTweak(long param1Long) {
/* 494 */       byte[] arrayOfByte = new byte[16];
/* 495 */       for (byte b = 0; b < 16; b++, param1Long >>>= 8L) {
/* 496 */         arrayOfByte[b] = (byte)(int)(param1Long & 0xFFL);
/*     */       }
/* 498 */       this.cipher.encrypt(arrayOfByte, 0, 16);
/* 499 */       return arrayOfByte;
/*     */     }
/*     */     
/*     */     private static void xorTweak(byte[] param1ArrayOfbyte1, int param1Int, byte[] param1ArrayOfbyte2) {
/* 503 */       for (byte b = 0; b < 16; b++) {
/* 504 */         param1ArrayOfbyte1[param1Int + b] = (byte)(param1ArrayOfbyte1[param1Int + b] ^ param1ArrayOfbyte2[b]);
/*     */       }
/*     */     }
/*     */     
/*     */     private static void updateTweak(byte[] param1ArrayOfbyte) {
/* 509 */       byte b1 = 0, b2 = 0;
/* 510 */       for (byte b = 0; b < 16; b++) {
/* 511 */         b2 = (byte)(param1ArrayOfbyte[b] >> 7 & 0x1);
/* 512 */         param1ArrayOfbyte[b] = (byte)((param1ArrayOfbyte[b] << 1) + b1 & 0xFF);
/* 513 */         b1 = b2;
/*     */       } 
/* 515 */       if (b2 != 0) {
/* 516 */         param1ArrayOfbyte[0] = (byte)(param1ArrayOfbyte[0] ^ 0x87);
/*     */       }
/*     */     }
/*     */     
/*     */     private static void swap(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2, int param1Int3) {
/* 521 */       for (byte b = 0; b < param1Int3; b++) {
/* 522 */         byte b1 = param1ArrayOfbyte[param1Int1 + b];
/* 523 */         param1ArrayOfbyte[param1Int1 + b] = param1ArrayOfbyte[param1Int2 + b];
/* 524 */         param1ArrayOfbyte[param1Int2 + b] = b1;
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\fs\FilePathEncrypt.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */