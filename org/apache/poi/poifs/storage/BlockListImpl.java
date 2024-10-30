/*     */ package org.apache.poi.poifs.storage;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.apache.poi.util.Internal;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class BlockListImpl
/*     */   implements BlockList
/*     */ {
/*  35 */   private ListManagedBlock[] _blocks = new ListManagedBlock[0];
/*  36 */   private BlockAllocationTableReader _bat = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setBlocks(ListManagedBlock[] paramArrayOfListManagedBlock) {
/*  46 */     this._blocks = (ListManagedBlock[])paramArrayOfListManagedBlock.clone();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void zap(int paramInt) {
/*  57 */     if (paramInt >= 0 && paramInt < this._blocks.length)
/*     */     {
/*  59 */       this._blocks[paramInt] = null;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public ListManagedBlock get(int paramInt) {
/*  69 */     return this._blocks[paramInt];
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
/*     */   public ListManagedBlock remove(int paramInt) throws IOException {
/*  85 */     ListManagedBlock listManagedBlock = null;
/*     */ 
/*     */     
/*     */     try {
/*  89 */       listManagedBlock = this._blocks[paramInt];
/*  90 */       if (listManagedBlock == null)
/*     */       {
/*  92 */         throw new IOException("block[ " + paramInt + " ] already removed - " + "does your POIFS have circular or duplicate block references?");
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*  97 */       this._blocks[paramInt] = null;
/*     */     }
/*  99 */     catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
/*     */       
/* 101 */       throw new IOException("Cannot remove block[ " + paramInt + " ]; out of range[ 0 - " + (this._blocks.length - 1) + " ]");
/*     */     } 
/*     */ 
/*     */     
/* 105 */     return listManagedBlock;
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
/*     */   public ListManagedBlock[] fetchBlocks(int paramInt1, int paramInt2) throws IOException {
/* 121 */     if (this._bat == null)
/*     */     {
/* 123 */       throw new IOException("Improperly initialized list: no block allocation table provided");
/*     */     }
/*     */     
/* 126 */     return this._bat.fetchBlocks(paramInt1, paramInt2, this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBAT(BlockAllocationTableReader paramBlockAllocationTableReader) throws IOException {
/* 137 */     if (this._bat != null)
/*     */     {
/* 139 */       throw new IOException("Attempt to replace existing BlockAllocationTable");
/*     */     }
/*     */     
/* 142 */     this._bat = paramBlockAllocationTableReader;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int blockCount() {
/* 149 */     return this._blocks.length;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected int remainingBlocks() {
/* 155 */     byte b1 = 0;
/* 156 */     for (byte b2 = 0; b2 < this._blocks.length; b2++) {
/* 157 */       if (this._blocks[b2] != null) b1++; 
/*     */     } 
/* 159 */     return b1;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\storage\BlockListImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */