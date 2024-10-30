/*     */ package com.google.a.j;
/*     */ 
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.k.e;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.DataInput;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.DataOutput;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.EOFException;
/*     */ import java.io.FilterInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.nio.channels.ReadableByteChannel;
/*     */ import java.nio.channels.WritableByteChannel;
/*     */ import java.util.ArrayDeque;
/*     */ import java.util.Arrays;
/*     */ import java.util.Queue;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @c
/*     */ public final class h
/*     */ {
/*     */   private static final int BUFFER_SIZE = 8192;
/*     */   private static final int fP = 524288;
/*     */   private static final int fQ = 2147483639;
/*     */   private static final int fR = 20;
/*     */   
/*     */   static byte[] i() {
/*  59 */     return new byte[8192];
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public static long copy(InputStream paramInputStream, OutputStream paramOutputStream) throws IOException {
/* 104 */     D.checkNotNull(paramInputStream);
/* 105 */     D.checkNotNull(paramOutputStream);
/* 106 */     byte[] arrayOfByte = i();
/* 107 */     long l = 0L;
/*     */     while (true) {
/* 109 */       int i = paramInputStream.read(arrayOfByte);
/* 110 */       if (i == -1) {
/*     */         break;
/*     */       }
/* 113 */       paramOutputStream.write(arrayOfByte, 0, i);
/* 114 */       l += i;
/*     */     } 
/* 116 */     return l;
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
/*     */   @com.google.b.a.a
/*     */   public static long a(ReadableByteChannel paramReadableByteChannel, WritableByteChannel paramWritableByteChannel) throws IOException {
/* 130 */     D.checkNotNull(paramReadableByteChannel);
/* 131 */     D.checkNotNull(paramWritableByteChannel);
/* 132 */     if (paramReadableByteChannel instanceof FileChannel) {
/* 133 */       FileChannel fileChannel = (FileChannel)paramReadableByteChannel;
/* 134 */       long l1 = fileChannel.position();
/* 135 */       long l2 = l1;
/*     */       
/*     */       while (true) {
/* 138 */         long l3 = fileChannel.transferTo(l2, 524288L, paramWritableByteChannel);
/* 139 */         l2 += l3;
/* 140 */         fileChannel.position(l2);
/* 141 */         if (l3 <= 0L && l2 >= fileChannel.size())
/* 142 */           return l2 - l1; 
/*     */       } 
/*     */     } 
/* 145 */     ByteBuffer byteBuffer = ByteBuffer.wrap(i());
/* 146 */     long l = 0L;
/* 147 */     while (paramReadableByteChannel.read(byteBuffer) != -1) {
/* 148 */       v.b(byteBuffer);
/* 149 */       while (byteBuffer.hasRemaining()) {
/* 150 */         l += paramWritableByteChannel.write(byteBuffer);
/*     */       }
/* 152 */       v.a(byteBuffer);
/*     */     } 
/* 154 */     return l;
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
/*     */   private static byte[] a(InputStream paramInputStream, Queue<byte[]> paramQueue, int paramInt) throws IOException {
/* 173 */     int i = 8192;
/* 174 */     for (; paramInt < 2147483639; 
/* 175 */       i = e.x(i, 2)) {
/* 176 */       byte[] arrayOfByte = new byte[Math.min(i, 2147483639 - paramInt)];
/* 177 */       paramQueue.add(arrayOfByte);
/* 178 */       int j = 0;
/* 179 */       while (j < arrayOfByte.length) {
/*     */         
/* 181 */         int k = paramInputStream.read(arrayOfByte, j, arrayOfByte.length - j);
/* 182 */         if (k == -1) {
/* 183 */           return a(paramQueue, paramInt);
/*     */         }
/* 185 */         j += k;
/* 186 */         paramInt += k;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 191 */     if (paramInputStream.read() == -1)
/*     */     {
/* 193 */       return a(paramQueue, 2147483639);
/*     */     }
/* 195 */     throw new OutOfMemoryError("input is too large to fit in a byte array");
/*     */   }
/*     */ 
/*     */   
/*     */   private static byte[] a(Queue<byte[]> paramQueue, int paramInt) {
/* 200 */     byte[] arrayOfByte = new byte[paramInt];
/* 201 */     int i = paramInt;
/* 202 */     while (i > 0) {
/* 203 */       byte[] arrayOfByte1 = paramQueue.remove();
/* 204 */       int j = Math.min(i, arrayOfByte1.length);
/* 205 */       int k = paramInt - i;
/* 206 */       System.arraycopy(arrayOfByte1, 0, arrayOfByte, k, j);
/* 207 */       i -= j;
/*     */     } 
/* 209 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] toByteArray(InputStream paramInputStream) throws IOException {
/* 220 */     D.checkNotNull(paramInputStream);
/* 221 */     return a(paramInputStream, (Queue)new ArrayDeque<>(20), 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static byte[] toByteArray(InputStream paramInputStream, long paramLong) throws IOException {
/* 230 */     D.a((paramLong >= 0L), "expectedSize (%s) must be non-negative", paramLong);
/* 231 */     if (paramLong > 2147483639L) {
/* 232 */       throw new OutOfMemoryError((new StringBuilder(62)).append(paramLong).append(" bytes is too large to fit in a byte array").toString());
/*     */     }
/*     */     
/* 235 */     byte[] arrayOfByte = new byte[(int)paramLong];
/* 236 */     int i = (int)paramLong;
/*     */     
/* 238 */     while (i > 0) {
/* 239 */       int k = (int)paramLong - i;
/* 240 */       int m = paramInputStream.read(arrayOfByte, k, i);
/* 241 */       if (m == -1)
/*     */       {
/*     */         
/* 244 */         return Arrays.copyOf(arrayOfByte, k);
/*     */       }
/* 246 */       i -= m;
/*     */     } 
/*     */ 
/*     */     
/* 250 */     int j = paramInputStream.read();
/* 251 */     if (j == -1) {
/* 252 */       return arrayOfByte;
/*     */     }
/*     */ 
/*     */     
/* 256 */     ArrayDeque<byte[]> arrayDeque = new ArrayDeque(22);
/* 257 */     arrayDeque.add(arrayOfByte);
/* 258 */     arrayDeque.add(new byte[] { (byte)j });
/* 259 */     return a(paramInputStream, (Queue<byte[]>)arrayDeque, arrayOfByte.length + 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   @com.google.a.a.a
/*     */   public static long c(InputStream paramInputStream) throws IOException {
/* 271 */     long l1 = 0L;
/*     */     
/* 273 */     byte[] arrayOfByte = i(); long l2;
/* 274 */     while ((l2 = paramInputStream.read(arrayOfByte)) != -1L) {
/* 275 */       l1 += l2;
/*     */     }
/* 277 */     return l1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.a.a.a
/*     */   public static c a(byte[] paramArrayOfbyte) {
/* 286 */     return a(new ByteArrayInputStream(paramArrayOfbyte));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.a.a.a
/*     */   public static c a(byte[] paramArrayOfbyte, int paramInt) {
/* 298 */     D.c(paramInt, paramArrayOfbyte.length);
/* 299 */     return a(new ByteArrayInputStream(paramArrayOfbyte, paramInt, paramArrayOfbyte.length - paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.a.a.a
/*     */   public static c a(ByteArrayInputStream paramByteArrayInputStream) {
/* 311 */     return new a((ByteArrayInputStream)D.checkNotNull(paramByteArrayInputStream));
/*     */   }
/*     */   
/*     */   private static class a implements c {
/*     */     final DataInput a;
/*     */     
/*     */     a(ByteArrayInputStream param1ByteArrayInputStream) {
/* 318 */       this.a = new DataInputStream(param1ByteArrayInputStream);
/*     */     }
/*     */ 
/*     */     
/*     */     public void readFully(byte[] param1ArrayOfbyte) {
/*     */       try {
/* 324 */         this.a.readFully(param1ArrayOfbyte);
/* 325 */       } catch (IOException iOException) {
/* 326 */         throw new IllegalStateException(iOException);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void readFully(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
/*     */       try {
/* 333 */         this.a.readFully(param1ArrayOfbyte, param1Int1, param1Int2);
/* 334 */       } catch (IOException iOException) {
/* 335 */         throw new IllegalStateException(iOException);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public int skipBytes(int param1Int) {
/*     */       try {
/* 342 */         return this.a.skipBytes(param1Int);
/* 343 */       } catch (IOException iOException) {
/* 344 */         throw new IllegalStateException(iOException);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean readBoolean() {
/*     */       try {
/* 351 */         return this.a.readBoolean();
/* 352 */       } catch (IOException iOException) {
/* 353 */         throw new IllegalStateException(iOException);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public byte readByte() {
/*     */       try {
/* 360 */         return this.a.readByte();
/* 361 */       } catch (EOFException eOFException) {
/* 362 */         throw new IllegalStateException(eOFException);
/* 363 */       } catch (IOException iOException) {
/* 364 */         throw new AssertionError(iOException);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public int readUnsignedByte() {
/*     */       try {
/* 371 */         return this.a.readUnsignedByte();
/* 372 */       } catch (IOException iOException) {
/* 373 */         throw new IllegalStateException(iOException);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public short readShort() {
/*     */       try {
/* 380 */         return this.a.readShort();
/* 381 */       } catch (IOException iOException) {
/* 382 */         throw new IllegalStateException(iOException);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public int readUnsignedShort() {
/*     */       try {
/* 389 */         return this.a.readUnsignedShort();
/* 390 */       } catch (IOException iOException) {
/* 391 */         throw new IllegalStateException(iOException);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public char readChar() {
/*     */       try {
/* 398 */         return this.a.readChar();
/* 399 */       } catch (IOException iOException) {
/* 400 */         throw new IllegalStateException(iOException);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public int readInt() {
/*     */       try {
/* 407 */         return this.a.readInt();
/* 408 */       } catch (IOException iOException) {
/* 409 */         throw new IllegalStateException(iOException);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public long readLong() {
/*     */       try {
/* 416 */         return this.a.readLong();
/* 417 */       } catch (IOException iOException) {
/* 418 */         throw new IllegalStateException(iOException);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public float readFloat() {
/*     */       try {
/* 425 */         return this.a.readFloat();
/* 426 */       } catch (IOException iOException) {
/* 427 */         throw new IllegalStateException(iOException);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public double readDouble() {
/*     */       try {
/* 434 */         return this.a.readDouble();
/* 435 */       } catch (IOException iOException) {
/* 436 */         throw new IllegalStateException(iOException);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public String readLine() {
/*     */       try {
/* 443 */         return this.a.readLine();
/* 444 */       } catch (IOException iOException) {
/* 445 */         throw new IllegalStateException(iOException);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public String readUTF() {
/*     */       try {
/* 452 */         return this.a.readUTF();
/* 453 */       } catch (IOException iOException) {
/* 454 */         throw new IllegalStateException(iOException);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.a.a.a
/*     */   public static d a() {
/* 462 */     return a(new ByteArrayOutputStream());
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
/*     */   @com.google.a.a.a
/*     */   public static d a(int paramInt) {
/* 475 */     if (paramInt < 0) {
/* 476 */       throw new IllegalArgumentException(String.format("Invalid size: %s", new Object[] { Integer.valueOf(paramInt) }));
/*     */     }
/* 478 */     return a(new ByteArrayOutputStream(paramInt));
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
/*     */   @com.google.a.a.a
/*     */   public static d a(ByteArrayOutputStream paramByteArrayOutputStream) {
/* 495 */     return new b((ByteArrayOutputStream)D.checkNotNull(paramByteArrayOutputStream));
/*     */   }
/*     */   
/*     */   private static class b
/*     */     implements d {
/*     */     final DataOutput a;
/*     */     final ByteArrayOutputStream a;
/*     */     
/*     */     b(ByteArrayOutputStream param1ByteArrayOutputStream) {
/* 504 */       this.a = param1ByteArrayOutputStream;
/* 505 */       this.a = (ByteArrayOutputStream)new DataOutputStream(param1ByteArrayOutputStream);
/*     */     }
/*     */ 
/*     */     
/*     */     public void write(int param1Int) {
/*     */       try {
/* 511 */         this.a.write(param1Int);
/* 512 */       } catch (IOException iOException) {
/* 513 */         throw new AssertionError(iOException);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void write(byte[] param1ArrayOfbyte) {
/*     */       try {
/* 520 */         this.a.write(param1ArrayOfbyte);
/* 521 */       } catch (IOException iOException) {
/* 522 */         throw new AssertionError(iOException);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
/*     */       try {
/* 529 */         this.a.write(param1ArrayOfbyte, param1Int1, param1Int2);
/* 530 */       } catch (IOException iOException) {
/* 531 */         throw new AssertionError(iOException);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void writeBoolean(boolean param1Boolean) {
/*     */       try {
/* 538 */         this.a.writeBoolean(param1Boolean);
/* 539 */       } catch (IOException iOException) {
/* 540 */         throw new AssertionError(iOException);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void writeByte(int param1Int) {
/*     */       try {
/* 547 */         this.a.writeByte(param1Int);
/* 548 */       } catch (IOException iOException) {
/* 549 */         throw new AssertionError(iOException);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void writeBytes(String param1String) {
/*     */       try {
/* 556 */         this.a.writeBytes(param1String);
/* 557 */       } catch (IOException iOException) {
/* 558 */         throw new AssertionError(iOException);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void writeChar(int param1Int) {
/*     */       try {
/* 565 */         this.a.writeChar(param1Int);
/* 566 */       } catch (IOException iOException) {
/* 567 */         throw new AssertionError(iOException);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void writeChars(String param1String) {
/*     */       try {
/* 574 */         this.a.writeChars(param1String);
/* 575 */       } catch (IOException iOException) {
/* 576 */         throw new AssertionError(iOException);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void writeDouble(double param1Double) {
/*     */       try {
/* 583 */         this.a.writeDouble(param1Double);
/* 584 */       } catch (IOException iOException) {
/* 585 */         throw new AssertionError(iOException);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void writeFloat(float param1Float) {
/*     */       try {
/* 592 */         this.a.writeFloat(param1Float);
/* 593 */       } catch (IOException iOException) {
/* 594 */         throw new AssertionError(iOException);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void writeInt(int param1Int) {
/*     */       try {
/* 601 */         this.a.writeInt(param1Int);
/* 602 */       } catch (IOException iOException) {
/* 603 */         throw new AssertionError(iOException);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void writeLong(long param1Long) {
/*     */       try {
/* 610 */         this.a.writeLong(param1Long);
/* 611 */       } catch (IOException iOException) {
/* 612 */         throw new AssertionError(iOException);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void writeShort(int param1Int) {
/*     */       try {
/* 619 */         this.a.writeShort(param1Int);
/* 620 */       } catch (IOException iOException) {
/* 621 */         throw new AssertionError(iOException);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void writeUTF(String param1String) {
/*     */       try {
/* 628 */         this.a.writeUTF(param1String);
/* 629 */       } catch (IOException iOException) {
/* 630 */         throw new AssertionError(iOException);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public byte[] toByteArray() {
/* 636 */       return this.a.toByteArray();
/*     */     }
/*     */   }
/*     */   
/* 640 */   private static final OutputStream a = new OutputStream()
/*     */     {
/*     */       public void write(int param1Int) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void write(byte[] param1ArrayOfbyte) {
/* 649 */         D.checkNotNull(param1ArrayOfbyte);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
/* 655 */         D.checkNotNull(param1ArrayOfbyte);
/*     */       }
/*     */ 
/*     */       
/*     */       public String toString() {
/* 660 */         return "ByteStreams.nullOutputStream()";
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.a.a.a
/*     */   public static OutputStream c() {
/* 671 */     return a;
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
/*     */   @com.google.a.a.a
/*     */   public static InputStream a(InputStream paramInputStream, long paramLong) {
/* 684 */     return new c(paramInputStream, paramLong);
/*     */   }
/*     */   
/*     */   private static final class c
/*     */     extends FilterInputStream {
/*     */     private long bf;
/* 690 */     private long mark = -1L;
/*     */     
/*     */     c(InputStream param1InputStream, long param1Long) {
/* 693 */       super(param1InputStream);
/* 694 */       D.checkNotNull(param1InputStream);
/* 695 */       D.a((param1Long >= 0L), "limit must be non-negative");
/* 696 */       this.bf = param1Long;
/*     */     }
/*     */ 
/*     */     
/*     */     public int available() throws IOException {
/* 701 */       return (int)Math.min(this.in.available(), this.bf);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public synchronized void mark(int param1Int) {
/* 707 */       this.in.mark(param1Int);
/* 708 */       this.mark = this.bf;
/*     */     }
/*     */ 
/*     */     
/*     */     public int read() throws IOException {
/* 713 */       if (this.bf == 0L) {
/* 714 */         return -1;
/*     */       }
/*     */       
/* 717 */       int i = this.in.read();
/* 718 */       if (i != -1) {
/* 719 */         this.bf--;
/*     */       }
/* 721 */       return i;
/*     */     }
/*     */ 
/*     */     
/*     */     public int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
/* 726 */       if (this.bf == 0L) {
/* 727 */         return -1;
/*     */       }
/*     */       
/* 730 */       param1Int2 = (int)Math.min(param1Int2, this.bf);
/* 731 */       int i = this.in.read(param1ArrayOfbyte, param1Int1, param1Int2);
/* 732 */       if (i != -1) {
/* 733 */         this.bf -= i;
/*     */       }
/* 735 */       return i;
/*     */     }
/*     */ 
/*     */     
/*     */     public synchronized void reset() throws IOException {
/* 740 */       if (!this.in.markSupported()) {
/* 741 */         throw new IOException("Mark not supported");
/*     */       }
/* 743 */       if (this.mark == -1L) {
/* 744 */         throw new IOException("Mark not set");
/*     */       }
/*     */       
/* 747 */       this.in.reset();
/* 748 */       this.bf = this.mark;
/*     */     }
/*     */ 
/*     */     
/*     */     public long skip(long param1Long) throws IOException {
/* 753 */       param1Long = Math.min(param1Long, this.bf);
/* 754 */       long l = this.in.skip(param1Long);
/* 755 */       this.bf -= l;
/* 756 */       return l;
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
/*     */   @com.google.a.a.a
/*     */   public static void readFully(InputStream paramInputStream, byte[] paramArrayOfbyte) throws IOException {
/* 771 */     readFully(paramInputStream, paramArrayOfbyte, 0, paramArrayOfbyte.length);
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
/*     */   @com.google.a.a.a
/*     */   public static void readFully(InputStream paramInputStream, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 788 */     int i = read(paramInputStream, paramArrayOfbyte, paramInt1, paramInt2);
/* 789 */     if (i != paramInt2) {
/* 790 */       throw new EOFException((new StringBuilder(81)).append("reached end of stream after reading ").append(i).append(" bytes; ").append(paramInt2).append(" bytes expected").toString());
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
/*     */   @com.google.a.a.a
/*     */   public static void skipFully(InputStream paramInputStream, long paramLong) throws IOException {
/* 806 */     long l = a(paramInputStream, paramLong);
/* 807 */     if (l < paramLong) {
/* 808 */       throw new EOFException((new StringBuilder(100)).append("reached end of stream after skipping ").append(l).append(" bytes; ").append(paramLong).append(" bytes expected").toString());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static long a(InputStream paramInputStream, long paramLong) throws IOException {
/* 819 */     long l = 0L;
/*     */     
/* 821 */     byte[] arrayOfByte = null;
/*     */     
/* 823 */     while (l < paramLong) {
/* 824 */       long l1 = paramLong - l;
/* 825 */       long l2 = b(paramInputStream, l1);
/*     */       
/* 827 */       if (l2 == 0L) {
/*     */ 
/*     */         
/* 830 */         int i = (int)Math.min(l1, 8192L);
/* 831 */         if (arrayOfByte == null)
/*     */         {
/*     */ 
/*     */           
/* 835 */           arrayOfByte = new byte[i];
/*     */         }
/* 837 */         if ((l2 = paramInputStream.read(arrayOfByte, 0, i)) == -1L) {
/*     */           break;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 843 */       l += l2;
/*     */     } 
/*     */     
/* 846 */     return l;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static long b(InputStream paramInputStream, long paramLong) throws IOException {
/* 857 */     int i = paramInputStream.available();
/* 858 */     return (i == 0) ? 0L : paramInputStream.skip(Math.min(i, paramLong));
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
/*     */   @com.google.a.a.a
/*     */   @com.google.b.a.a
/*     */   public static <T> T a(InputStream paramInputStream, e<T> parame) throws IOException {
/*     */     int i;
/* 873 */     D.checkNotNull(paramInputStream);
/* 874 */     D.checkNotNull(parame);
/*     */     
/* 876 */     byte[] arrayOfByte = i();
/*     */     
/*     */     do {
/* 879 */       i = paramInputStream.read(arrayOfByte);
/* 880 */     } while (i != -1 && parame.c(arrayOfByte, 0, i));
/* 881 */     return parame.getResult();
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.a.a.a
/*     */   @com.google.b.a.a
/*     */   public static int read(InputStream paramInputStream, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 913 */     D.checkNotNull(paramInputStream);
/* 914 */     D.checkNotNull(paramArrayOfbyte);
/* 915 */     if (paramInt2 < 0) {
/* 916 */       throw new IndexOutOfBoundsException(String.format("len (%s) cannot be negative", new Object[] { Integer.valueOf(paramInt2) }));
/*     */     }
/* 918 */     D.a(paramInt1, paramInt1 + paramInt2, paramArrayOfbyte.length);
/* 919 */     int i = 0;
/* 920 */     while (i < paramInt2) {
/* 921 */       int j = paramInputStream.read(paramArrayOfbyte, paramInt1 + i, paramInt2 - i);
/* 922 */       if (j == -1) {
/*     */         break;
/*     */       }
/* 925 */       i += j;
/*     */     } 
/* 927 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\j\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */