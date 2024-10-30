/*     */ package com.sun.jna;
/*     */ 
/*     */ import java.lang.ref.ReferenceQueue;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Memory
/*     */   extends Pointer
/*     */ {
/*  53 */   private static ReferenceQueue<Memory> QUEUE = new ReferenceQueue<Memory>();
/*     */   
/*     */   private static LinkedReference HEAD;
/*     */ 
/*     */   
/*     */   private static class LinkedReference
/*     */     extends WeakReference<Memory>
/*     */   {
/*     */     private LinkedReference next;
/*     */     
/*     */     private LinkedReference prev;
/*     */ 
/*     */     
/*     */     private LinkedReference(Memory param1Memory) {
/*  67 */       super(param1Memory, Memory.QUEUE);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     static LinkedReference track(Memory param1Memory) {
/*  77 */       synchronized (Memory.QUEUE) {
/*     */         LinkedReference linkedReference1;
/*     */ 
/*     */         
/*  81 */         while ((linkedReference1 = (LinkedReference)Memory.QUEUE.poll()) != null) {
/*  82 */           linkedReference1.unlink();
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/*  87 */       LinkedReference linkedReference = new LinkedReference(param1Memory);
/*     */       
/*  89 */       synchronized (LinkedReference.class) {
/*  90 */         if (Memory.HEAD != null) {
/*  91 */           linkedReference.next = Memory.HEAD;
/*  92 */           Memory.HEAD = Memory.HEAD.prev = linkedReference;
/*     */         } else {
/*  94 */           Memory.HEAD = linkedReference;
/*     */         } 
/*     */       } 
/*     */       
/*  98 */       return linkedReference;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void unlink() {
/* 105 */       synchronized (LinkedReference.class) {
/*     */         LinkedReference linkedReference;
/*     */         
/* 108 */         if (Memory.HEAD != this) {
/* 109 */           if (this.prev == null) {
/*     */             return;
/*     */           }
/*     */ 
/*     */           
/* 114 */           linkedReference = this.prev.next = this.next;
/*     */         } else {
/* 116 */           linkedReference = Memory.HEAD = Memory.HEAD.next;
/*     */         } 
/*     */         
/* 119 */         if (linkedReference != null) {
/* 120 */           linkedReference.prev = this.prev;
/*     */         }
/*     */ 
/*     */         
/* 124 */         this.prev = null;
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/* 129 */   private static final WeakMemoryHolder buffers = new WeakMemoryHolder();
/*     */   
/*     */   private final LinkedReference reference;
/*     */   protected long size;
/*     */   
/*     */   public static void purge() {
/* 135 */     buffers.clean();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void disposeAll() {
/* 140 */     synchronized (LinkedReference.class) {
/*     */       LinkedReference linkedReference;
/*     */       
/* 143 */       while ((linkedReference = HEAD) != null) {
/* 144 */         Memory memory = HEAD.get();
/*     */         
/* 146 */         if (memory != null) {
/*     */           
/* 148 */           memory.dispose();
/*     */         } else {
/* 150 */           HEAD.unlink();
/*     */         } 
/*     */         
/* 153 */         if (HEAD == linkedReference) {
/* 154 */           throw new IllegalStateException("the HEAD did not change");
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 159 */     synchronized (QUEUE) {
/*     */       LinkedReference linkedReference;
/*     */ 
/*     */       
/* 163 */       while ((linkedReference = (LinkedReference)QUEUE.poll()) != null) {
/* 164 */         linkedReference.unlink();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static int integrityCheck() {
/* 175 */     synchronized (LinkedReference.class) {
/* 176 */       if (HEAD == null) {
/* 177 */         return 0;
/*     */       }
/*     */       
/* 180 */       ArrayList<LinkedReference> arrayList = new ArrayList();
/* 181 */       LinkedReference linkedReference = HEAD;
/*     */       
/* 183 */       while (linkedReference != null) {
/* 184 */         arrayList.add(linkedReference);
/* 185 */         linkedReference = linkedReference.next;
/*     */       } 
/*     */       
/* 188 */       int i = arrayList.size() - 1;
/* 189 */       linkedReference = arrayList.get(i);
/*     */       
/* 191 */       while (linkedReference != null) {
/* 192 */         if (arrayList.get(i) != linkedReference) {
/* 193 */           throw new IllegalStateException((new StringBuilder()).append(arrayList.get(i)).append(" vs. ").append(linkedReference).append(" at index ").append(i).toString());
/*     */         }
/*     */         
/* 196 */         linkedReference = linkedReference.prev;
/* 197 */         i--;
/*     */       } 
/*     */       
/* 200 */       return arrayList.size();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class SharedMemory
/*     */     extends Memory
/*     */   {
/*     */     public SharedMemory(long param1Long1, long param1Long2) {
/* 212 */       this.size = param1Long2;
/* 213 */       this.peer = Memory.this.peer + param1Long1;
/*     */     }
/*     */ 
/*     */     
/*     */     protected synchronized void dispose() {
/* 218 */       this.peer = 0L;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void boundsCheck(long param1Long1, long param1Long2) {
/* 223 */       Memory.this.boundsCheck(this.peer - Memory.this.peer + param1Long1, param1Long2);
/*     */     }
/*     */     
/*     */     public String toString() {
/* 227 */       return super.toString() + " (shared from " + Memory.this.toString() + ")";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Memory(long paramLong) {
/* 237 */     this.size = paramLong;
/* 238 */     if (paramLong <= 0L) {
/* 239 */       throw new IllegalArgumentException("Allocation size must be greater than zero");
/*     */     }
/* 241 */     this.peer = malloc(paramLong);
/* 242 */     if (this.peer == 0L) {
/* 243 */       throw new OutOfMemoryError("Cannot allocate " + paramLong + " bytes");
/*     */     }
/* 245 */     this.reference = LinkedReference.track(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Memory() {
/* 251 */     this.reference = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Pointer share(long paramLong) {
/* 262 */     return share(paramLong, size() - paramLong);
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
/*     */   public Pointer share(long paramLong1, long paramLong2) {
/* 274 */     boundsCheck(paramLong1, paramLong2);
/* 275 */     return new SharedMemory(paramLong1, paramLong2);
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
/*     */   public Memory align(int paramInt) {
/* 287 */     if (paramInt <= 0) {
/* 288 */       throw new IllegalArgumentException("Byte boundary must be positive: " + paramInt);
/*     */     }
/* 290 */     for (byte b = 0; b < 32; b++) {
/* 291 */       if (paramInt == 1 << b) {
/* 292 */         long l = paramInt - 1L ^ 0xFFFFFFFFFFFFFFFFL;
/*     */         
/* 294 */         if ((this.peer & l) != this.peer) {
/* 295 */           long l1 = this.peer + paramInt - 1L & l;
/* 296 */           long l2 = this.peer + this.size - l1;
/* 297 */           if (l2 <= 0L) {
/* 298 */             throw new IllegalArgumentException("Insufficient memory to align to the requested boundary");
/*     */           }
/* 300 */           return (Memory)share(l1 - this.peer, l2);
/*     */         } 
/* 302 */         return this;
/*     */       } 
/*     */     } 
/* 305 */     throw new IllegalArgumentException("Byte boundary must be a power of two");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void finalize() {
/* 311 */     dispose();
/*     */   }
/*     */ 
/*     */   
/*     */   protected synchronized void dispose() {
/* 316 */     if (this.peer == 0L) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 322 */       free(this.peer);
/*     */     } finally {
/* 324 */       this.peer = 0L;
/*     */ 
/*     */       
/* 327 */       this.reference.unlink();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 333 */     clear(this.size);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean valid() {
/* 338 */     return (this.peer != 0L);
/*     */   }
/*     */   
/*     */   public long size() {
/* 342 */     return this.size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void boundsCheck(long paramLong1, long paramLong2) {
/* 351 */     if (paramLong1 < 0L) {
/* 352 */       throw new IndexOutOfBoundsException("Invalid offset: " + paramLong1);
/*     */     }
/* 354 */     if (paramLong1 + paramLong2 > this.size) {
/* 355 */       String str = "Bounds exceeds available space : size=" + this.size + ", offset=" + (paramLong1 + paramLong2);
/*     */       
/* 357 */       throw new IndexOutOfBoundsException(str);
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
/*     */   public void read(long paramLong, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 375 */     boundsCheck(paramLong, paramInt2 * 1L);
/* 376 */     super.read(paramLong, paramArrayOfbyte, paramInt1, paramInt2);
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
/*     */   public void read(long paramLong, short[] paramArrayOfshort, int paramInt1, int paramInt2) {
/* 389 */     boundsCheck(paramLong, paramInt2 * 2L);
/* 390 */     super.read(paramLong, paramArrayOfshort, paramInt1, paramInt2);
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
/*     */   public void read(long paramLong, char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 403 */     boundsCheck(paramLong, (paramInt2 * Native.WCHAR_SIZE));
/* 404 */     super.read(paramLong, paramArrayOfchar, paramInt1, paramInt2);
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
/*     */   public void read(long paramLong, int[] paramArrayOfint, int paramInt1, int paramInt2) {
/* 417 */     boundsCheck(paramLong, paramInt2 * 4L);
/* 418 */     super.read(paramLong, paramArrayOfint, paramInt1, paramInt2);
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
/*     */   public void read(long paramLong, long[] paramArrayOflong, int paramInt1, int paramInt2) {
/* 431 */     boundsCheck(paramLong, paramInt2 * 8L);
/* 432 */     super.read(paramLong, paramArrayOflong, paramInt1, paramInt2);
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
/*     */   public void read(long paramLong, float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/* 445 */     boundsCheck(paramLong, paramInt2 * 4L);
/* 446 */     super.read(paramLong, paramArrayOffloat, paramInt1, paramInt2);
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
/*     */   public void read(long paramLong, double[] paramArrayOfdouble, int paramInt1, int paramInt2) {
/* 459 */     boundsCheck(paramLong, paramInt2 * 8L);
/* 460 */     super.read(paramLong, paramArrayOfdouble, paramInt1, paramInt2);
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
/*     */   public void read(long paramLong, Pointer[] paramArrayOfPointer, int paramInt1, int paramInt2) {
/* 473 */     boundsCheck(paramLong, (paramInt2 * Native.POINTER_SIZE));
/* 474 */     super.read(paramLong, paramArrayOfPointer, paramInt1, paramInt2);
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
/*     */   public void write(long paramLong, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 491 */     boundsCheck(paramLong, paramInt2 * 1L);
/* 492 */     super.write(paramLong, paramArrayOfbyte, paramInt1, paramInt2);
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
/*     */   public void write(long paramLong, short[] paramArrayOfshort, int paramInt1, int paramInt2) {
/* 505 */     boundsCheck(paramLong, paramInt2 * 2L);
/* 506 */     super.write(paramLong, paramArrayOfshort, paramInt1, paramInt2);
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
/*     */   public void write(long paramLong, char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 519 */     boundsCheck(paramLong, (paramInt2 * Native.WCHAR_SIZE));
/* 520 */     super.write(paramLong, paramArrayOfchar, paramInt1, paramInt2);
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
/*     */   public void write(long paramLong, int[] paramArrayOfint, int paramInt1, int paramInt2) {
/* 533 */     boundsCheck(paramLong, paramInt2 * 4L);
/* 534 */     super.write(paramLong, paramArrayOfint, paramInt1, paramInt2);
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
/*     */   public void write(long paramLong, long[] paramArrayOflong, int paramInt1, int paramInt2) {
/* 547 */     boundsCheck(paramLong, paramInt2 * 8L);
/* 548 */     super.write(paramLong, paramArrayOflong, paramInt1, paramInt2);
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
/*     */   public void write(long paramLong, float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/* 561 */     boundsCheck(paramLong, paramInt2 * 4L);
/* 562 */     super.write(paramLong, paramArrayOffloat, paramInt1, paramInt2);
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
/*     */   public void write(long paramLong, double[] paramArrayOfdouble, int paramInt1, int paramInt2) {
/* 575 */     boundsCheck(paramLong, paramInt2 * 8L);
/* 576 */     super.write(paramLong, paramArrayOfdouble, paramInt1, paramInt2);
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
/*     */   public void write(long paramLong, Pointer[] paramArrayOfPointer, int paramInt1, int paramInt2) {
/* 589 */     boundsCheck(paramLong, (paramInt2 * Native.POINTER_SIZE));
/* 590 */     super.write(paramLong, paramArrayOfPointer, paramInt1, paramInt2);
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
/*     */   public byte getByte(long paramLong) {
/* 607 */     boundsCheck(paramLong, 1L);
/* 608 */     return super.getByte(paramLong);
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
/*     */   public char getChar(long paramLong) {
/* 621 */     boundsCheck(paramLong, Native.WCHAR_SIZE);
/* 622 */     return super.getChar(paramLong);
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
/*     */   public short getShort(long paramLong) {
/* 635 */     boundsCheck(paramLong, 2L);
/* 636 */     return super.getShort(paramLong);
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
/*     */   public int getInt(long paramLong) {
/* 649 */     boundsCheck(paramLong, 4L);
/* 650 */     return super.getInt(paramLong);
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
/*     */   public long getLong(long paramLong) {
/* 663 */     boundsCheck(paramLong, 8L);
/* 664 */     return super.getLong(paramLong);
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
/*     */   public float getFloat(long paramLong) {
/* 677 */     boundsCheck(paramLong, 4L);
/* 678 */     return super.getFloat(paramLong);
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
/*     */   public double getDouble(long paramLong) {
/* 691 */     boundsCheck(paramLong, 8L);
/* 692 */     return super.getDouble(paramLong);
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
/*     */   public Pointer getPointer(long paramLong) {
/* 705 */     boundsCheck(paramLong, Native.POINTER_SIZE);
/* 706 */     return shareReferenceIfInBounds(super.getPointer(paramLong));
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
/*     */   public ByteBuffer getByteBuffer(long paramLong1, long paramLong2) {
/* 723 */     boundsCheck(paramLong1, paramLong2);
/* 724 */     ByteBuffer byteBuffer = super.getByteBuffer(paramLong1, paramLong2);
/*     */ 
/*     */     
/* 727 */     buffers.put(byteBuffer, this);
/* 728 */     return byteBuffer;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getString(long paramLong, String paramString) {
/* 734 */     boundsCheck(paramLong, 0L);
/* 735 */     return super.getString(paramLong, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWideString(long paramLong) {
/* 741 */     boundsCheck(paramLong, 0L);
/* 742 */     return super.getWideString(paramLong);
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
/*     */   public void setByte(long paramLong, byte paramByte) {
/* 759 */     boundsCheck(paramLong, 1L);
/* 760 */     super.setByte(paramLong, paramByte);
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
/*     */   public void setChar(long paramLong, char paramChar) {
/* 773 */     boundsCheck(paramLong, Native.WCHAR_SIZE);
/* 774 */     super.setChar(paramLong, paramChar);
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
/*     */   public void setShort(long paramLong, short paramShort) {
/* 787 */     boundsCheck(paramLong, 2L);
/* 788 */     super.setShort(paramLong, paramShort);
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
/*     */   public void setInt(long paramLong, int paramInt) {
/* 801 */     boundsCheck(paramLong, 4L);
/* 802 */     super.setInt(paramLong, paramInt);
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
/*     */   public void setLong(long paramLong1, long paramLong2) {
/* 815 */     boundsCheck(paramLong1, 8L);
/* 816 */     super.setLong(paramLong1, paramLong2);
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
/*     */   public void setFloat(long paramLong, float paramFloat) {
/* 829 */     boundsCheck(paramLong, 4L);
/* 830 */     super.setFloat(paramLong, paramFloat);
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
/*     */   public void setDouble(long paramLong, double paramDouble) {
/* 843 */     boundsCheck(paramLong, 8L);
/* 844 */     super.setDouble(paramLong, paramDouble);
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
/*     */   public void setPointer(long paramLong, Pointer paramPointer) {
/* 857 */     boundsCheck(paramLong, Native.POINTER_SIZE);
/* 858 */     super.setPointer(paramLong, paramPointer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setString(long paramLong, String paramString1, String paramString2) {
/* 863 */     boundsCheck(paramLong, (Native.getBytes(paramString1, paramString2)).length + 1L);
/* 864 */     super.setString(paramLong, paramString1, paramString2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setWideString(long paramLong, String paramString) {
/* 869 */     boundsCheck(paramLong, (paramString.length() + 1L) * Native.WCHAR_SIZE);
/* 870 */     super.setWideString(paramLong, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 875 */     return "allocated@0x" + Long.toHexString(this.peer) + " (" + this.size + " bytes)";
/*     */   }
/*     */ 
/*     */   
/*     */   protected static void free(long paramLong) {
/* 880 */     if (paramLong != 0L) {
/* 881 */       Native.free(paramLong);
/*     */     }
/*     */   }
/*     */   
/*     */   protected static long malloc(long paramLong) {
/* 886 */     return Native.malloc(paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   public String dump() {
/* 891 */     return dump(0L, (int)size());
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
/*     */   private Pointer shareReferenceIfInBounds(Pointer paramPointer) {
/* 905 */     if (paramPointer == null) {
/* 906 */       return null;
/*     */     }
/* 908 */     long l = paramPointer.peer - this.peer;
/* 909 */     if (l >= 0L && l < this.size) {
/* 910 */       return share(l);
/*     */     }
/* 912 */     return paramPointer;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\Memory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */