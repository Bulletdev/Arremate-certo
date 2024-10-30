/*     */ package org.apache.poi.poifs.storage;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import org.apache.poi.poifs.common.POIFSBigBlockSize;
/*     */ import org.apache.poi.util.LittleEndian;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class BATBlock
/*     */   extends BigBlock
/*     */ {
/*     */   private int[] _values;
/*     */   private boolean _has_free_sectors;
/*     */   private int ourBlockIndex;
/*     */   
/*     */   private BATBlock(POIFSBigBlockSize paramPOIFSBigBlockSize) {
/*  58 */     super(paramPOIFSBigBlockSize);
/*     */     
/*  60 */     int i = paramPOIFSBigBlockSize.getBATEntriesPerBlock();
/*  61 */     this._values = new int[i];
/*  62 */     this._has_free_sectors = true;
/*     */     
/*  64 */     Arrays.fill(this._values, -1);
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
/*     */   private BATBlock(POIFSBigBlockSize paramPOIFSBigBlockSize, int[] paramArrayOfint, int paramInt1, int paramInt2) {
/*  81 */     this(paramPOIFSBigBlockSize);
/*  82 */     for (int i = paramInt1; i < paramInt2; i++) {
/*  83 */       this._values[i - paramInt1] = paramArrayOfint[i];
/*     */     }
/*     */ 
/*     */     
/*  87 */     if (paramInt2 - paramInt1 == this._values.length) {
/*  88 */       recomputeFree();
/*     */     }
/*     */   }
/*     */   
/*     */   private void recomputeFree() {
/*  93 */     boolean bool = false;
/*  94 */     for (byte b = 0; b < this._values.length; b++) {
/*  95 */       if (this._values[b] == -1) {
/*  96 */         bool = true;
/*     */         break;
/*     */       } 
/*     */     } 
/* 100 */     this._has_free_sectors = bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BATBlock createBATBlock(POIFSBigBlockSize paramPOIFSBigBlockSize, ByteBuffer paramByteBuffer) {
/* 110 */     BATBlock bATBlock = new BATBlock(paramPOIFSBigBlockSize);
/*     */ 
/*     */     
/* 113 */     byte[] arrayOfByte = new byte[4];
/* 114 */     for (byte b = 0; b < bATBlock._values.length; b++) {
/* 115 */       paramByteBuffer.get(arrayOfByte);
/* 116 */       bATBlock._values[b] = LittleEndian.getInt(arrayOfByte);
/*     */     } 
/* 118 */     bATBlock.recomputeFree();
/*     */ 
/*     */     
/* 121 */     return bATBlock;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BATBlock createEmptyBATBlock(POIFSBigBlockSize paramPOIFSBigBlockSize, boolean paramBoolean) {
/* 128 */     BATBlock bATBlock = new BATBlock(paramPOIFSBigBlockSize);
/* 129 */     if (paramBoolean) {
/* 130 */       bATBlock.setXBATChain(paramPOIFSBigBlockSize, -2);
/*     */     }
/* 132 */     return bATBlock;
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
/*     */   public static BATBlock[] createBATBlocks(POIFSBigBlockSize paramPOIFSBigBlockSize, int[] paramArrayOfint) {
/* 145 */     int i = calculateStorageRequirements(paramPOIFSBigBlockSize, paramArrayOfint.length);
/* 146 */     BATBlock[] arrayOfBATBlock = new BATBlock[i];
/* 147 */     byte b = 0;
/* 148 */     int j = paramArrayOfint.length;
/*     */     
/* 150 */     int k = paramPOIFSBigBlockSize.getBATEntriesPerBlock(); int m;
/* 151 */     for (m = 0; m < paramArrayOfint.length; m += k) {
/*     */       
/* 153 */       arrayOfBATBlock[b++] = new BATBlock(paramPOIFSBigBlockSize, paramArrayOfint, m, (j > k) ? (m + k) : paramArrayOfint.length);
/*     */ 
/*     */ 
/*     */       
/* 157 */       j -= k;
/*     */     } 
/* 159 */     return arrayOfBATBlock;
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
/*     */   public static BATBlock[] createXBATBlocks(POIFSBigBlockSize paramPOIFSBigBlockSize, int[] paramArrayOfint, int paramInt) {
/* 176 */     int i = calculateXBATStorageRequirements(paramPOIFSBigBlockSize, paramArrayOfint.length);
/*     */     
/* 178 */     BATBlock[] arrayOfBATBlock = new BATBlock[i];
/* 179 */     byte b = 0;
/* 180 */     int j = paramArrayOfint.length;
/*     */     
/* 182 */     int k = paramPOIFSBigBlockSize.getXBATEntriesPerBlock();
/* 183 */     if (i != 0) {
/*     */       int m;
/* 185 */       for (m = 0; m < paramArrayOfint.length; m += k) {
/*     */         
/* 187 */         arrayOfBATBlock[b++] = new BATBlock(paramPOIFSBigBlockSize, paramArrayOfint, m, (j > k) ? (m + k) : paramArrayOfint.length);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 192 */         j -= k;
/*     */       } 
/* 194 */       for (b = 0; b < arrayOfBATBlock.length - 1; b++)
/*     */       {
/* 196 */         arrayOfBATBlock[b].setXBATChain(paramPOIFSBigBlockSize, paramInt + b + 1);
/*     */       }
/* 198 */       arrayOfBATBlock[b].setXBATChain(paramPOIFSBigBlockSize, -2);
/*     */     } 
/* 200 */     return arrayOfBATBlock;
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
/*     */   public static int calculateStorageRequirements(POIFSBigBlockSize paramPOIFSBigBlockSize, int paramInt) {
/* 213 */     int i = paramPOIFSBigBlockSize.getBATEntriesPerBlock();
/* 214 */     return (paramInt + i - 1) / i;
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
/*     */   public static int calculateXBATStorageRequirements(POIFSBigBlockSize paramPOIFSBigBlockSize, int paramInt) {
/* 227 */     int i = paramPOIFSBigBlockSize.getXBATEntriesPerBlock();
/* 228 */     return (paramInt + i - 1) / i;
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
/*     */   public static long calculateMaximumSize(POIFSBigBlockSize paramPOIFSBigBlockSize, int paramInt) {
/* 246 */     long l = 1L;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 251 */     l += paramInt * paramPOIFSBigBlockSize.getBATEntriesPerBlock();
/*     */ 
/*     */     
/* 254 */     return l * paramPOIFSBigBlockSize.getBigBlockSize();
/*     */   }
/*     */   
/*     */   public static long calculateMaximumSize(HeaderBlock paramHeaderBlock) {
/* 258 */     return calculateMaximumSize(paramHeaderBlock.getBigBlockSize(), paramHeaderBlock.getBATCount());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BATBlockAndIndex getBATBlockAndIndex(int paramInt, HeaderBlock paramHeaderBlock, List<BATBlock> paramList) {
/* 268 */     POIFSBigBlockSize pOIFSBigBlockSize = paramHeaderBlock.getBigBlockSize();
/* 269 */     int i = pOIFSBigBlockSize.getBATEntriesPerBlock();
/*     */     
/* 271 */     int j = paramInt / i;
/* 272 */     int k = paramInt % i;
/* 273 */     return new BATBlockAndIndex(k, paramList.get(j));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BATBlockAndIndex getSBATBlockAndIndex(int paramInt, HeaderBlock paramHeaderBlock, List<BATBlock> paramList) {
/* 283 */     POIFSBigBlockSize pOIFSBigBlockSize = paramHeaderBlock.getBigBlockSize();
/* 284 */     int i = pOIFSBigBlockSize.getBATEntriesPerBlock();
/*     */ 
/*     */     
/* 287 */     int j = paramInt / i;
/* 288 */     int k = paramInt % i;
/* 289 */     return new BATBlockAndIndex(k, paramList.get(j));
/*     */   }
/*     */ 
/*     */   
/*     */   private void setXBATChain(POIFSBigBlockSize paramPOIFSBigBlockSize, int paramInt) {
/* 294 */     int i = paramPOIFSBigBlockSize.getXBATEntriesPerBlock();
/* 295 */     this._values[i] = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasFreeSectors() {
/* 303 */     return this._has_free_sectors;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getUsedSectors(boolean paramBoolean) {
/* 310 */     byte b1 = 0;
/* 311 */     int i = this._values.length;
/* 312 */     if (paramBoolean) i--; 
/* 313 */     for (byte b2 = 0; b2 < i; b2++) {
/* 314 */       if (this._values[b2] != -1) {
/* 315 */         b1++;
/*     */       }
/*     */     } 
/* 318 */     return b1;
/*     */   }
/*     */   
/*     */   public int getValueAt(int paramInt) {
/* 322 */     if (paramInt >= this._values.length) {
/* 323 */       throw new ArrayIndexOutOfBoundsException("Unable to fetch offset " + paramInt + " as the " + "BAT only contains " + this._values.length + " entries");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 328 */     return this._values[paramInt];
/*     */   }
/*     */   public void setValueAt(int paramInt1, int paramInt2) {
/* 331 */     int i = this._values[paramInt1];
/* 332 */     this._values[paramInt1] = paramInt2;
/*     */ 
/*     */     
/* 335 */     if (paramInt2 == -1) {
/* 336 */       this._has_free_sectors = true;
/*     */       return;
/*     */     } 
/* 339 */     if (i == -1) {
/* 340 */       recomputeFree();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOurBlockIndex(int paramInt) {
/* 348 */     this.ourBlockIndex = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getOurBlockIndex() {
/* 354 */     return this.ourBlockIndex;
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
/*     */   void writeData(OutputStream paramOutputStream) throws IOException {
/* 373 */     paramOutputStream.write(serialize());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void writeData(ByteBuffer paramByteBuffer) throws IOException {
/* 380 */     paramByteBuffer.put(serialize());
/*     */   }
/*     */ 
/*     */   
/*     */   private byte[] serialize() {
/* 385 */     byte[] arrayOfByte = new byte[this.bigBlockSize.getBigBlockSize()];
/*     */ 
/*     */     
/* 388 */     boolean bool = false;
/* 389 */     for (byte b = 0; b < this._values.length; b++) {
/* 390 */       LittleEndian.putInt(arrayOfByte, bool, this._values[b]);
/* 391 */       bool += true;
/*     */     } 
/*     */ 
/*     */     
/* 395 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class BATBlockAndIndex
/*     */   {
/*     */     private final int index;
/*     */     private final BATBlock block;
/*     */     
/*     */     private BATBlockAndIndex(int param1Int, BATBlock param1BATBlock) {
/* 405 */       this.index = param1Int;
/* 406 */       this.block = param1BATBlock;
/*     */     }
/*     */     public int getIndex() {
/* 409 */       return this.index;
/*     */     }
/*     */     public BATBlock getBlock() {
/* 412 */       return this.block;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\storage\BATBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */