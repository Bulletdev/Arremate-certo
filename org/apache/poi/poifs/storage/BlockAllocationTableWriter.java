/*     */ package org.apache.poi.poifs.storage;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import org.apache.poi.poifs.common.POIFSBigBlockSize;
/*     */ import org.apache.poi.poifs.filesystem.BATManaged;
/*     */ import org.apache.poi.util.IntList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class BlockAllocationTableWriter
/*     */   implements BATManaged, BlockWritable
/*     */ {
/*     */   private IntList _entries;
/*     */   private BATBlock[] _blocks;
/*     */   private int _start_block;
/*     */   private POIFSBigBlockSize _bigBlockSize;
/*     */   
/*     */   public BlockAllocationTableWriter(POIFSBigBlockSize paramPOIFSBigBlockSize) {
/*  55 */     this._bigBlockSize = paramPOIFSBigBlockSize;
/*  56 */     this._start_block = -2;
/*  57 */     this._entries = new IntList();
/*  58 */     this._blocks = new BATBlock[0];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int createBlocks() {
/*  68 */     int i = 0;
/*  69 */     int j = 0;
/*     */ 
/*     */     
/*     */     while (true) {
/*  73 */       int m = BATBlock.calculateStorageRequirements(this._bigBlockSize, j + i + this._entries.size());
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  78 */       int n = HeaderBlockWriter.calculateXBATStorageRequirements(this._bigBlockSize, m);
/*     */ 
/*     */ 
/*     */       
/*  82 */       if (j == m && i == n) {
/*     */         break;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  89 */       j = m;
/*  90 */       i = n;
/*     */     } 
/*  92 */     int k = allocateSpace(j);
/*     */     
/*  94 */     allocateSpace(i);
/*  95 */     simpleCreateBlocks();
/*  96 */     return k;
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
/*     */   public int allocateSpace(int paramInt) {
/* 108 */     int i = this._entries.size();
/*     */     
/* 110 */     if (paramInt > 0) {
/*     */       
/* 112 */       int j = paramInt - 1;
/* 113 */       int k = i + 1;
/*     */       
/* 115 */       for (byte b = 0; b < j; b++)
/*     */       {
/* 117 */         this._entries.add(k++);
/*     */       }
/* 119 */       this._entries.add(-2);
/*     */     } 
/* 121 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getStartBlock() {
/* 131 */     return this._start_block;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void simpleCreateBlocks() {
/* 139 */     this._blocks = BATBlock.createBATBlocks(this._bigBlockSize, this._entries.toArray());
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
/* 154 */     for (byte b = 0; b < this._blocks.length; b++)
/*     */     {
/* 156 */       this._blocks[b].writeBlocks(paramOutputStream);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void writeBlock(BATBlock paramBATBlock, ByteBuffer paramByteBuffer) throws IOException {
/* 166 */     paramBATBlock.writeData(paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int countBlocks() {
/* 176 */     return this._blocks.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStartBlock(int paramInt) {
/* 184 */     this._start_block = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\storage\BlockAllocationTableWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */