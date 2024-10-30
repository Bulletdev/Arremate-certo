/*     */ package org.apache.poi.poifs.storage;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import org.apache.poi.poifs.common.POIFSBigBlockSize;
/*     */ import org.apache.poi.util.IntList;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.util.LittleEndian;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class BlockAllocationTableReader
/*     */ {
/*  44 */   private static final POILogger _logger = POILogFactory.getLogger(BlockAllocationTableReader.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int MAX_BLOCK_COUNT = 65535;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final IntList _entries;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private POIFSBigBlockSize bigBlockSize;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BlockAllocationTableReader(POIFSBigBlockSize paramPOIFSBigBlockSize, int paramInt1, int[] paramArrayOfint, int paramInt2, int paramInt3, BlockList paramBlockList) throws IOException {
/*  81 */     this(paramPOIFSBigBlockSize);
/*     */     
/*  83 */     sanityCheckBlockCount(paramInt1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  91 */     int i = Math.min(paramInt1, paramArrayOfint.length);
/*     */ 
/*     */ 
/*     */     
/*  95 */     RawDataBlock[] arrayOfRawDataBlock = new RawDataBlock[paramInt1];
/*     */     
/*     */     byte b;
/*  98 */     for (b = 0; b < i; b++) {
/*     */ 
/*     */       
/* 101 */       int j = paramArrayOfint[b];
/* 102 */       if (j > paramBlockList.blockCount()) {
/* 103 */         throw new IOException("Your file contains " + paramBlockList.blockCount() + " sectors, but the initial DIFAT array at index " + b + " referenced block # " + j + ". This isn't allowed and " + " your file is corrupt");
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 109 */       arrayOfRawDataBlock[b] = (RawDataBlock)paramBlockList.remove(j);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 114 */     if (b < paramInt1) {
/*     */ 
/*     */ 
/*     */       
/* 118 */       if (paramInt3 < 0)
/*     */       {
/* 120 */         throw new IOException("BAT count exceeds limit, yet XBAT index indicates no valid entries");
/*     */       }
/*     */       
/* 123 */       int j = paramInt3;
/* 124 */       int k = paramPOIFSBigBlockSize.getXBATEntriesPerBlock();
/* 125 */       int m = paramPOIFSBigBlockSize.getNextXBATChainOffset();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 130 */       for (byte b1 = 0; b1 < paramInt2; b1++) {
/*     */         
/* 132 */         i = Math.min(paramInt1 - b, k);
/*     */         
/* 134 */         byte[] arrayOfByte = paramBlockList.remove(j).getData();
/* 135 */         boolean bool = false;
/*     */         
/* 137 */         for (byte b2 = 0; b2 < i; b2++) {
/*     */           
/* 139 */           arrayOfRawDataBlock[b++] = (RawDataBlock)paramBlockList.remove(LittleEndian.getInt(arrayOfByte, bool));
/*     */ 
/*     */           
/* 142 */           bool += true;
/*     */         } 
/* 144 */         j = LittleEndian.getInt(arrayOfByte, m);
/* 145 */         if (j == -2) {
/*     */           break;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 151 */     if (b != paramInt1)
/*     */     {
/* 153 */       throw new IOException("Could not find all blocks");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 158 */     setEntries((ListManagedBlock[])arrayOfRawDataBlock, paramBlockList);
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
/*     */   BlockAllocationTableReader(POIFSBigBlockSize paramPOIFSBigBlockSize, ListManagedBlock[] paramArrayOfListManagedBlock, BlockList paramBlockList) throws IOException {
/* 171 */     this(paramPOIFSBigBlockSize);
/* 172 */     setEntries(paramArrayOfListManagedBlock, paramBlockList);
/*     */   }
/*     */   
/*     */   BlockAllocationTableReader(POIFSBigBlockSize paramPOIFSBigBlockSize) {
/* 176 */     this.bigBlockSize = paramPOIFSBigBlockSize;
/* 177 */     this._entries = new IntList();
/*     */   }
/*     */   
/*     */   public static void sanityCheckBlockCount(int paramInt) throws IOException {
/* 181 */     if (paramInt <= 0) {
/* 182 */       throw new IOException("Illegal block count; minimum count is 1, got " + paramInt + " instead");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 187 */     if (paramInt > 65535) {
/* 188 */       throw new IOException("Block count " + paramInt + " is too high. POI maximum is " + Character.MAX_VALUE + ".");
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
/*     */ 
/*     */ 
/*     */   
/*     */   ListManagedBlock[] fetchBlocks(int paramInt1, int paramInt2, BlockList paramBlockList) throws IOException {
/* 209 */     ArrayList<ListManagedBlock> arrayList = new ArrayList();
/* 210 */     int i = paramInt1;
/* 211 */     boolean bool = true;
/* 212 */     ListManagedBlock listManagedBlock = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 218 */     while (i != -2) {
/*     */       
/*     */       try {
/* 221 */         listManagedBlock = paramBlockList.remove(i);
/* 222 */         arrayList.add(listManagedBlock);
/*     */         
/* 224 */         i = this._entries.get(i);
/* 225 */         bool = false;
/* 226 */       } catch (IOException iOException) {
/* 227 */         if (i == paramInt2) {
/*     */           
/* 229 */           _logger.log(5, new Object[] { "Warning, header block comes after data blocks in POIFS block listing" });
/* 230 */           i = -2; continue;
/* 231 */         }  if (i == 0 && bool) {
/*     */ 
/*     */           
/* 234 */           _logger.log(5, new Object[] { "Warning, incorrectly terminated empty data blocks in POIFS block listing (should end at -2, ended at 0)" });
/* 235 */           i = -2;
/*     */           continue;
/*     */         } 
/* 238 */         throw iOException;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 243 */     return arrayList.<ListManagedBlock>toArray(new ListManagedBlock[arrayList.size()]);
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
/*     */   boolean isUsed(int paramInt) {
/*     */     try {
/* 258 */       return (this._entries.get(paramInt) != -1);
/* 259 */     } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
/*     */       
/* 261 */       return false;
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
/*     */   int getNextBlockIndex(int paramInt) throws IOException {
/* 277 */     if (isUsed(paramInt)) {
/* 278 */       return this._entries.get(paramInt);
/*     */     }
/* 280 */     throw new IOException("index " + paramInt + " is unused");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setEntries(ListManagedBlock[] paramArrayOfListManagedBlock, BlockList paramBlockList) throws IOException {
/* 291 */     int i = this.bigBlockSize.getBATEntriesPerBlock();
/*     */     
/* 293 */     for (byte b = 0; b < paramArrayOfListManagedBlock.length; b++) {
/*     */       
/* 295 */       byte[] arrayOfByte = paramArrayOfListManagedBlock[b].getData();
/* 296 */       boolean bool = false;
/*     */       
/* 298 */       for (byte b1 = 0; b1 < i; b1++) {
/*     */         
/* 300 */         int j = LittleEndian.getInt(arrayOfByte, bool);
/*     */         
/* 302 */         if (j == -1)
/*     */         {
/* 304 */           paramBlockList.zap(this._entries.size());
/*     */         }
/* 306 */         this._entries.add(j);
/* 307 */         bool += true;
/*     */       } 
/*     */ 
/*     */       
/* 311 */       paramArrayOfListManagedBlock[b] = null;
/*     */     } 
/* 313 */     paramBlockList.setBAT(this);
/*     */   }
/*     */   
/*     */   @Internal
/*     */   public IntList getEntries() {
/* 318 */     return this._entries;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\storage\BlockAllocationTableReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */