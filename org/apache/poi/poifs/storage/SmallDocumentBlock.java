/*     */ package org.apache.poi.poifs.storage;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import org.apache.poi.poifs.common.POIFSBigBlockSize;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class SmallDocumentBlock
/*     */   implements BlockWritable, ListManagedBlock
/*     */ {
/*     */   private static final int BLOCK_SHIFT = 6;
/*     */   private byte[] _data;
/*     */   private static final byte _default_fill = -1;
/*     */   private static final int _block_size = 64;
/*     */   private static final int BLOCK_MASK = 63;
/*     */   private final int _blocks_per_big_block;
/*     */   private final POIFSBigBlockSize _bigBlockSize;
/*     */   
/*     */   private SmallDocumentBlock(POIFSBigBlockSize paramPOIFSBigBlockSize, byte[] paramArrayOfbyte, int paramInt) {
/*  46 */     this(paramPOIFSBigBlockSize);
/*  47 */     System.arraycopy(paramArrayOfbyte, paramInt * 64, this._data, 0, 64);
/*     */   }
/*     */ 
/*     */   
/*     */   protected SmallDocumentBlock(POIFSBigBlockSize paramPOIFSBigBlockSize) {
/*  52 */     this._bigBlockSize = paramPOIFSBigBlockSize;
/*  53 */     this._blocks_per_big_block = getBlocksPerBigBlock(paramPOIFSBigBlockSize);
/*  54 */     this._data = new byte[64];
/*     */   }
/*     */ 
/*     */   
/*     */   private static int getBlocksPerBigBlock(POIFSBigBlockSize paramPOIFSBigBlockSize) {
/*  59 */     return paramPOIFSBigBlockSize.getBigBlockSize() / 64;
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
/*     */   public static SmallDocumentBlock[] convert(POIFSBigBlockSize paramPOIFSBigBlockSize, byte[] paramArrayOfbyte, int paramInt) {
/*  76 */     SmallDocumentBlock[] arrayOfSmallDocumentBlock = new SmallDocumentBlock[(paramInt + 64 - 1) / 64];
/*     */     
/*  78 */     byte b1 = 0;
/*     */     
/*  80 */     for (byte b2 = 0; b2 < arrayOfSmallDocumentBlock.length; b2++) {
/*     */       
/*  82 */       arrayOfSmallDocumentBlock[b2] = new SmallDocumentBlock(paramPOIFSBigBlockSize);
/*  83 */       if (b1 < paramArrayOfbyte.length) {
/*     */         
/*  85 */         int i = Math.min(64, paramArrayOfbyte.length - b1);
/*     */         
/*  87 */         System.arraycopy(paramArrayOfbyte, b1, (arrayOfSmallDocumentBlock[b2])._data, 0, i);
/*  88 */         if (i != 64)
/*     */         {
/*  90 */           Arrays.fill((arrayOfSmallDocumentBlock[b2])._data, i, 64, (byte)-1);
/*     */         
/*     */         }
/*     */       }
/*     */       else {
/*     */         
/*  96 */         Arrays.fill((arrayOfSmallDocumentBlock[b2])._data, (byte)-1);
/*     */       } 
/*  98 */       b1 += 64;
/*     */     } 
/* 100 */     return arrayOfSmallDocumentBlock;
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
/*     */   public static int fill(POIFSBigBlockSize paramPOIFSBigBlockSize, List<SmallDocumentBlock> paramList) {
/* 113 */     int i = getBlocksPerBigBlock(paramPOIFSBigBlockSize);
/*     */     
/* 115 */     int j = paramList.size();
/* 116 */     int k = (j + i - 1) / i;
/*     */     
/* 118 */     int m = k * i;
/*     */     
/* 120 */     for (; j < m; j++)
/*     */     {
/* 122 */       paramList.add(makeEmptySmallDocumentBlock(paramPOIFSBigBlockSize));
/*     */     }
/* 124 */     return k;
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
/*     */   public static SmallDocumentBlock[] convert(POIFSBigBlockSize paramPOIFSBigBlockSize, BlockWritable[] paramArrayOfBlockWritable, int paramInt) throws IOException, ArrayIndexOutOfBoundsException {
/* 144 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*     */     
/* 146 */     for (byte b1 = 0; b1 < paramArrayOfBlockWritable.length; b1++)
/*     */     {
/* 148 */       paramArrayOfBlockWritable[b1].writeBlocks(byteArrayOutputStream);
/*     */     }
/* 150 */     byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
/* 151 */     SmallDocumentBlock[] arrayOfSmallDocumentBlock = new SmallDocumentBlock[convertToBlockCount(paramInt)];
/*     */ 
/*     */     
/* 154 */     for (byte b2 = 0; b2 < arrayOfSmallDocumentBlock.length; b2++)
/*     */     {
/* 156 */       arrayOfSmallDocumentBlock[b2] = new SmallDocumentBlock(paramPOIFSBigBlockSize, arrayOfByte, b2);
/*     */     }
/* 158 */     return arrayOfSmallDocumentBlock;
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
/*     */   public static List<SmallDocumentBlock> extract(POIFSBigBlockSize paramPOIFSBigBlockSize, ListManagedBlock[] paramArrayOfListManagedBlock) throws IOException {
/* 172 */     int i = getBlocksPerBigBlock(paramPOIFSBigBlockSize);
/*     */     
/* 174 */     ArrayList<SmallDocumentBlock> arrayList = new ArrayList();
/*     */     
/* 176 */     for (byte b = 0; b < paramArrayOfListManagedBlock.length; b++) {
/*     */       
/* 178 */       byte[] arrayOfByte = paramArrayOfListManagedBlock[b].getData();
/*     */       
/* 180 */       for (byte b1 = 0; b1 < i; b1++)
/*     */       {
/* 182 */         arrayList.add(new SmallDocumentBlock(paramPOIFSBigBlockSize, arrayOfByte, b1));
/*     */       }
/*     */     } 
/* 185 */     return arrayList;
/*     */   }
/*     */   
/*     */   public static DataInputBlock getDataInputBlock(SmallDocumentBlock[] paramArrayOfSmallDocumentBlock, int paramInt) {
/* 189 */     int i = paramInt >> 6;
/* 190 */     int j = paramInt & 0x3F;
/* 191 */     return new DataInputBlock((paramArrayOfSmallDocumentBlock[i])._data, j);
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
/*     */   public static int calcSize(int paramInt) {
/* 203 */     return paramInt * 64;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getSmallBlocksPerBigBlock() {
/* 208 */     return this._blocks_per_big_block;
/*     */   }
/*     */ 
/*     */   
/*     */   private static SmallDocumentBlock makeEmptySmallDocumentBlock(POIFSBigBlockSize paramPOIFSBigBlockSize) {
/* 213 */     SmallDocumentBlock smallDocumentBlock = new SmallDocumentBlock(paramPOIFSBigBlockSize);
/*     */     
/* 215 */     Arrays.fill(smallDocumentBlock._data, (byte)-1);
/* 216 */     return smallDocumentBlock;
/*     */   }
/*     */ 
/*     */   
/*     */   private static int convertToBlockCount(int paramInt) {
/* 221 */     return (paramInt + 64 - 1) / 64;
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
/*     */   public void writeBlocks(OutputStream paramOutputStream) throws IOException {
/* 236 */     paramOutputStream.write(this._data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getData() {
/* 247 */     return this._data;
/*     */   }
/*     */   
/*     */   public POIFSBigBlockSize getBigBlockSize() {
/* 251 */     return this._bigBlockSize;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\storage\SmallDocumentBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */