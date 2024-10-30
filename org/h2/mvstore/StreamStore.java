/*     */ package org.h2.mvstore;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.atomic.AtomicLong;
/*     */ import java.util.concurrent.atomic.AtomicReference;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StreamStore
/*     */ {
/*     */   private final Map<Long, byte[]> map;
/*  40 */   private int minBlockSize = 256;
/*  41 */   private int maxBlockSize = 262144;
/*  42 */   private final AtomicLong nextKey = new AtomicLong();
/*  43 */   private final AtomicReference<byte[]> nextBuffer = (AtomicReference)new AtomicReference<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StreamStore(Map<Long, byte[]> paramMap) {
/*  52 */     this.map = paramMap;
/*     */   }
/*     */   
/*     */   public Map<Long, byte[]> getMap() {
/*  56 */     return this.map;
/*     */   }
/*     */   
/*     */   public void setNextKey(long paramLong) {
/*  60 */     this.nextKey.set(paramLong);
/*     */   }
/*     */   
/*     */   public long getNextKey() {
/*  64 */     return this.nextKey.get();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMinBlockSize(int paramInt) {
/*  73 */     this.minBlockSize = paramInt;
/*     */   }
/*     */   
/*     */   public int getMinBlockSize() {
/*  77 */     return this.minBlockSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaxBlockSize(int paramInt) {
/*  86 */     this.maxBlockSize = paramInt;
/*     */   }
/*     */   
/*     */   public long getMaxBlockSize() {
/*  90 */     return this.maxBlockSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] put(InputStream paramInputStream) throws IOException {
/* 100 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 101 */     byte b = 0;
/*     */     
/*     */     try {
/* 104 */       while (!put(byteArrayOutputStream, paramInputStream, b)) {
/*     */ 
/*     */         
/* 107 */         if (byteArrayOutputStream.size() > this.maxBlockSize / 2) {
/* 108 */           byteArrayOutputStream = putIndirectId(byteArrayOutputStream);
/* 109 */           b++;
/*     */         } 
/*     */       } 
/* 112 */     } catch (IOException iOException) {
/* 113 */       remove(byteArrayOutputStream.toByteArray());
/* 114 */       throw iOException;
/*     */     } 
/* 116 */     if (byteArrayOutputStream.size() > this.minBlockSize * 2) {
/* 117 */       byteArrayOutputStream = putIndirectId(byteArrayOutputStream);
/*     */     }
/* 119 */     return byteArrayOutputStream.toByteArray();
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean put(ByteArrayOutputStream paramByteArrayOutputStream, InputStream paramInputStream, int paramInt) throws IOException {
/* 124 */     if (paramInt > 0) {
/* 125 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*     */       while (true) {
/* 127 */         boolean bool1 = put(byteArrayOutputStream, paramInputStream, paramInt - 1);
/* 128 */         if (byteArrayOutputStream.size() > this.maxBlockSize / 2) {
/* 129 */           byteArrayOutputStream = putIndirectId(byteArrayOutputStream);
/* 130 */           byteArrayOutputStream.writeTo(paramByteArrayOutputStream);
/* 131 */           return bool1;
/* 132 */         }  if (bool1) {
/* 133 */           byteArrayOutputStream.writeTo(paramByteArrayOutputStream);
/* 134 */           return true;
/*     */         } 
/*     */       } 
/*     */     } 
/* 138 */     byte[] arrayOfByte1 = this.nextBuffer.getAndSet(null);
/* 139 */     if (arrayOfByte1 == null) {
/* 140 */       arrayOfByte1 = new byte[this.maxBlockSize];
/*     */     }
/* 142 */     byte[] arrayOfByte2 = read(paramInputStream, arrayOfByte1);
/* 143 */     if (arrayOfByte2 != arrayOfByte1)
/*     */     {
/* 145 */       this.nextBuffer.set(arrayOfByte1);
/*     */     }
/* 147 */     int i = arrayOfByte2.length;
/* 148 */     if (i == 0) {
/* 149 */       return true;
/*     */     }
/* 151 */     boolean bool = (i < this.maxBlockSize) ? true : false;
/* 152 */     if (i < this.minBlockSize) {
/*     */       
/* 154 */       paramByteArrayOutputStream.write(0);
/* 155 */       DataUtils.writeVarInt(paramByteArrayOutputStream, i);
/* 156 */       paramByteArrayOutputStream.write(arrayOfByte2);
/*     */     } else {
/*     */       
/* 159 */       paramByteArrayOutputStream.write(1);
/* 160 */       DataUtils.writeVarInt(paramByteArrayOutputStream, i);
/* 161 */       DataUtils.writeVarLong(paramByteArrayOutputStream, writeBlock(arrayOfByte2));
/*     */     } 
/* 163 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   private static byte[] read(InputStream paramInputStream, byte[] paramArrayOfbyte) throws IOException {
/* 168 */     int i = 0;
/* 169 */     int j = paramArrayOfbyte.length;
/* 170 */     while (j > 0) {
/*     */       try {
/* 172 */         int k = paramInputStream.read(paramArrayOfbyte, i, j);
/* 173 */         if (k < 0) {
/* 174 */           return Arrays.copyOf(paramArrayOfbyte, i);
/*     */         }
/* 176 */         i += k;
/* 177 */         j -= k;
/* 178 */       } catch (RuntimeException runtimeException) {
/* 179 */         throw new IOException(runtimeException);
/*     */       } 
/*     */     } 
/* 182 */     return paramArrayOfbyte;
/*     */   }
/*     */ 
/*     */   
/*     */   private ByteArrayOutputStream putIndirectId(ByteArrayOutputStream paramByteArrayOutputStream) throws IOException {
/* 187 */     byte[] arrayOfByte = paramByteArrayOutputStream.toByteArray();
/* 188 */     paramByteArrayOutputStream = new ByteArrayOutputStream();
/*     */     
/* 190 */     paramByteArrayOutputStream.write(2);
/* 191 */     DataUtils.writeVarLong(paramByteArrayOutputStream, length(arrayOfByte));
/* 192 */     DataUtils.writeVarLong(paramByteArrayOutputStream, writeBlock(arrayOfByte));
/* 193 */     return paramByteArrayOutputStream;
/*     */   }
/*     */   
/*     */   private long writeBlock(byte[] paramArrayOfbyte) {
/* 197 */     long l = getAndIncrementNextKey();
/* 198 */     this.map.put(Long.valueOf(l), paramArrayOfbyte);
/* 199 */     onStore(paramArrayOfbyte.length);
/* 200 */     return l;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onStore(int paramInt) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private long getAndIncrementNextKey() {
/* 219 */     long l = this.nextKey.getAndIncrement();
/* 220 */     if (!this.map.containsKey(Long.valueOf(l))) {
/* 221 */       return l;
/*     */     }
/*     */     
/* 224 */     synchronized (this) {
/* 225 */       long l1 = l, l2 = Long.MAX_VALUE;
/* 226 */       while (l1 < l2) {
/* 227 */         long l3 = l1 + l2 >>> 1L;
/* 228 */         if (this.map.containsKey(Long.valueOf(l3))) {
/* 229 */           l1 = l3 + 1L; continue;
/*     */         } 
/* 231 */         l2 = l3;
/*     */       } 
/*     */       
/* 234 */       l = l1;
/* 235 */       this.nextKey.set(l + 1L);
/* 236 */       return l;
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
/*     */   public long getMaxBlockKey(byte[] paramArrayOfbyte) {
/* 248 */     long l = -1L;
/* 249 */     ByteBuffer byteBuffer = ByteBuffer.wrap(paramArrayOfbyte);
/* 250 */     while (byteBuffer.hasRemaining()) {
/* 251 */       int i; long l1; long l2; byte[] arrayOfByte; long l3; switch (byteBuffer.get()) {
/*     */         
/*     */         case 0:
/* 254 */           i = DataUtils.readVarInt(byteBuffer);
/* 255 */           byteBuffer.position(byteBuffer.position() + i);
/*     */           continue;
/*     */         
/*     */         case 1:
/* 259 */           DataUtils.readVarInt(byteBuffer);
/* 260 */           l1 = DataUtils.readVarLong(byteBuffer);
/* 261 */           l = Math.max(l, l1);
/*     */           continue;
/*     */         
/*     */         case 2:
/* 265 */           DataUtils.readVarLong(byteBuffer);
/* 266 */           l2 = DataUtils.readVarLong(byteBuffer);
/* 267 */           l = l2;
/* 268 */           arrayOfByte = this.map.get(Long.valueOf(l2));
/*     */           
/* 270 */           l3 = getMaxBlockKey(arrayOfByte);
/* 271 */           if (l3 >= 0L) {
/* 272 */             l = Math.max(l, l3);
/*     */           }
/*     */           continue;
/*     */       } 
/* 276 */       throw DataUtils.newIllegalArgumentException("Unsupported id {0}", new Object[] { Arrays.toString(paramArrayOfbyte) });
/*     */     } 
/*     */ 
/*     */     
/* 280 */     return l;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(byte[] paramArrayOfbyte) {
/* 289 */     ByteBuffer byteBuffer = ByteBuffer.wrap(paramArrayOfbyte);
/* 290 */     while (byteBuffer.hasRemaining()) {
/* 291 */       int i; long l1; long l2; switch (byteBuffer.get()) {
/*     */         
/*     */         case 0:
/* 294 */           i = DataUtils.readVarInt(byteBuffer);
/* 295 */           byteBuffer.position(byteBuffer.position() + i);
/*     */           continue;
/*     */         
/*     */         case 1:
/* 299 */           DataUtils.readVarInt(byteBuffer);
/* 300 */           l1 = DataUtils.readVarLong(byteBuffer);
/* 301 */           this.map.remove(Long.valueOf(l1));
/*     */           continue;
/*     */         
/*     */         case 2:
/* 305 */           DataUtils.readVarLong(byteBuffer);
/* 306 */           l2 = DataUtils.readVarLong(byteBuffer);
/*     */           
/* 308 */           remove(this.map.get(Long.valueOf(l2)));
/* 309 */           this.map.remove(Long.valueOf(l2));
/*     */           continue;
/*     */       } 
/* 312 */       throw DataUtils.newIllegalArgumentException("Unsupported id {0}", new Object[] { Arrays.toString(paramArrayOfbyte) });
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
/*     */   public static String toString(byte[] paramArrayOfbyte) {
/* 325 */     StringBuilder stringBuilder = new StringBuilder();
/* 326 */     ByteBuffer byteBuffer = ByteBuffer.wrap(paramArrayOfbyte);
/* 327 */     long l = 0L;
/* 328 */     while (byteBuffer.hasRemaining()) {
/*     */       long l1;
/*     */       int i;
/* 331 */       switch (byteBuffer.get()) {
/*     */         
/*     */         case 0:
/* 334 */           i = DataUtils.readVarInt(byteBuffer);
/* 335 */           byteBuffer.position(byteBuffer.position() + i);
/* 336 */           stringBuilder.append("data len=").append(i);
/* 337 */           l += i;
/*     */           break;
/*     */         
/*     */         case 1:
/* 341 */           i = DataUtils.readVarInt(byteBuffer);
/* 342 */           l += i;
/* 343 */           l1 = DataUtils.readVarLong(byteBuffer);
/* 344 */           stringBuilder.append("block ").append(l1).append(" len=").append(i);
/*     */           break;
/*     */         
/*     */         case 2:
/* 348 */           i = DataUtils.readVarInt(byteBuffer);
/* 349 */           l += DataUtils.readVarLong(byteBuffer);
/* 350 */           l1 = DataUtils.readVarLong(byteBuffer);
/* 351 */           stringBuilder.append("indirect block ").append(l1).append(" len=").append(i);
/*     */           break;
/*     */         default:
/* 354 */           stringBuilder.append("error"); break;
/*     */       } 
/* 356 */       stringBuilder.append(", ");
/*     */     } 
/* 358 */     stringBuilder.append("length=").append(l);
/* 359 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long length(byte[] paramArrayOfbyte) {
/* 370 */     ByteBuffer byteBuffer = ByteBuffer.wrap(paramArrayOfbyte);
/* 371 */     long l = 0L;
/* 372 */     while (byteBuffer.hasRemaining()) {
/* 373 */       int i; switch (byteBuffer.get()) {
/*     */         
/*     */         case 0:
/* 376 */           i = DataUtils.readVarInt(byteBuffer);
/* 377 */           byteBuffer.position(byteBuffer.position() + i);
/* 378 */           l += i;
/*     */           continue;
/*     */         
/*     */         case 1:
/* 382 */           l += DataUtils.readVarInt(byteBuffer);
/* 383 */           DataUtils.readVarLong(byteBuffer);
/*     */           continue;
/*     */         
/*     */         case 2:
/* 387 */           l += DataUtils.readVarLong(byteBuffer);
/* 388 */           DataUtils.readVarLong(byteBuffer);
/*     */           continue;
/*     */       } 
/* 391 */       throw DataUtils.newIllegalArgumentException("Unsupported id {0}", new Object[] { Arrays.toString(paramArrayOfbyte) });
/*     */     } 
/*     */ 
/*     */     
/* 395 */     return l;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInPlace(byte[] paramArrayOfbyte) {
/* 406 */     ByteBuffer byteBuffer = ByteBuffer.wrap(paramArrayOfbyte);
/* 407 */     while (byteBuffer.hasRemaining()) {
/* 408 */       if (byteBuffer.get() != 0) {
/* 409 */         return false;
/*     */       }
/* 411 */       int i = DataUtils.readVarInt(byteBuffer);
/* 412 */       byteBuffer.position(byteBuffer.position() + i);
/*     */     } 
/* 414 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStream get(byte[] paramArrayOfbyte) {
/* 424 */     return new Stream(this, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   byte[] getBlock(long paramLong) {
/* 434 */     byte[] arrayOfByte = this.map.get(Long.valueOf(paramLong));
/* 435 */     if (arrayOfByte == null) {
/* 436 */       throw DataUtils.newIllegalStateException(50, "Block {0} not found", new Object[] { Long.valueOf(paramLong) });
/*     */     }
/*     */ 
/*     */     
/* 440 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */   
/*     */   static class Stream
/*     */     extends InputStream
/*     */   {
/*     */     private final StreamStore store;
/*     */     
/*     */     private byte[] oneByteBuffer;
/*     */     private ByteBuffer idBuffer;
/*     */     private ByteArrayInputStream buffer;
/*     */     private long skip;
/*     */     private final long length;
/*     */     private long pos;
/*     */     
/*     */     Stream(StreamStore param1StreamStore, byte[] param1ArrayOfbyte) {
/* 457 */       this.store = param1StreamStore;
/* 458 */       this.length = param1StreamStore.length(param1ArrayOfbyte);
/* 459 */       this.idBuffer = ByteBuffer.wrap(param1ArrayOfbyte);
/*     */     }
/*     */ 
/*     */     
/*     */     public int read() throws IOException {
/* 464 */       byte[] arrayOfByte = this.oneByteBuffer;
/* 465 */       if (arrayOfByte == null) {
/* 466 */         arrayOfByte = this.oneByteBuffer = new byte[1];
/*     */       }
/* 468 */       int i = read(arrayOfByte, 0, 1);
/* 469 */       return (i == -1) ? -1 : (arrayOfByte[0] & 0xFF);
/*     */     }
/*     */ 
/*     */     
/*     */     public long skip(long param1Long) {
/* 474 */       param1Long = Math.min(this.length - this.pos, param1Long);
/* 475 */       if (param1Long == 0L) {
/* 476 */         return 0L;
/*     */       }
/* 478 */       if (this.buffer != null) {
/* 479 */         long l = this.buffer.skip(param1Long);
/* 480 */         if (l > 0L) {
/* 481 */           param1Long = l;
/*     */         } else {
/* 483 */           this.buffer = null;
/* 484 */           this.skip += param1Long;
/*     */         } 
/*     */       } else {
/* 487 */         this.skip += param1Long;
/*     */       } 
/* 489 */       this.pos += param1Long;
/* 490 */       return param1Long;
/*     */     }
/*     */ 
/*     */     
/*     */     public void close() {
/* 495 */       this.buffer = null;
/* 496 */       this.idBuffer.position(this.idBuffer.limit());
/* 497 */       this.pos = this.length;
/*     */     }
/*     */ 
/*     */     
/*     */     public int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
/* 502 */       if (param1Int2 <= 0) {
/* 503 */         return 0;
/*     */       }
/*     */       while (true) {
/* 506 */         if (this.buffer == null) {
/*     */           try {
/* 508 */             this.buffer = nextBuffer();
/* 509 */           } catch (IllegalStateException illegalStateException) {
/* 510 */             String str = DataUtils.formatMessage(50, "Block not found in id {0}", new Object[] { Arrays.toString(this.idBuffer.array()) });
/*     */ 
/*     */ 
/*     */             
/* 514 */             throw new IOException(str, illegalStateException);
/*     */           } 
/* 516 */           if (this.buffer == null) {
/* 517 */             return -1;
/*     */           }
/*     */         } 
/* 520 */         int i = this.buffer.read(param1ArrayOfbyte, param1Int1, param1Int2);
/* 521 */         if (i > 0) {
/* 522 */           this.pos += i;
/* 523 */           return i;
/*     */         } 
/* 525 */         this.buffer = null;
/*     */       } 
/*     */     }
/*     */     
/*     */     private ByteArrayInputStream nextBuffer() {
/* 530 */       while (this.idBuffer.hasRemaining()) {
/* 531 */         int i; long l1; int j; long l2; int k; long l3; byte[] arrayOfByte1; int m; byte[] arrayOfByte2; ByteBuffer byteBuffer; switch (this.idBuffer.get()) {
/*     */           case 0:
/* 533 */             i = DataUtils.readVarInt(this.idBuffer);
/* 534 */             if (this.skip >= i) {
/* 535 */               this.skip -= i;
/* 536 */               this.idBuffer.position(this.idBuffer.position() + i);
/*     */               continue;
/*     */             } 
/* 539 */             j = (int)(this.idBuffer.position() + this.skip);
/* 540 */             k = (int)(i - this.skip);
/* 541 */             this.idBuffer.position(j + k);
/* 542 */             return new ByteArrayInputStream(this.idBuffer.array(), j, k);
/*     */           
/*     */           case 1:
/* 545 */             i = DataUtils.readVarInt(this.idBuffer);
/* 546 */             l2 = DataUtils.readVarLong(this.idBuffer);
/* 547 */             if (this.skip >= i) {
/* 548 */               this.skip -= i;
/*     */               continue;
/*     */             } 
/* 551 */             arrayOfByte1 = this.store.getBlock(l2);
/* 552 */             m = (int)this.skip;
/* 553 */             this.skip = 0L;
/* 554 */             return new ByteArrayInputStream(arrayOfByte1, m, arrayOfByte1.length - m);
/*     */           
/*     */           case 2:
/* 557 */             l1 = DataUtils.readVarLong(this.idBuffer);
/* 558 */             l3 = DataUtils.readVarLong(this.idBuffer);
/* 559 */             if (this.skip >= l1) {
/* 560 */               this.skip -= l1;
/*     */               continue;
/*     */             } 
/* 563 */             arrayOfByte2 = this.store.getBlock(l3);
/* 564 */             byteBuffer = ByteBuffer.allocate(arrayOfByte2.length + this.idBuffer.limit() - this.idBuffer.position());
/*     */             
/* 566 */             byteBuffer.put(arrayOfByte2);
/* 567 */             byteBuffer.put(this.idBuffer);
/* 568 */             byteBuffer.flip();
/* 569 */             this.idBuffer = byteBuffer;
/* 570 */             return nextBuffer();
/*     */         } 
/*     */         
/* 573 */         throw DataUtils.newIllegalArgumentException("Unsupported id {0}", new Object[] { Arrays.toString(this.idBuffer.array()) });
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 578 */       return null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\mvstore\StreamStore.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */