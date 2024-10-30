/*     */ package org.apache.poi.poifs.filesystem;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.ByteBuffer;
/*     */ import org.apache.poi.poifs.storage.BATBlock;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class BlockStore
/*     */ {
/*     */   protected abstract int getBlockStoreBlockSize();
/*     */   
/*     */   protected abstract ByteBuffer getBlockAt(int paramInt) throws IOException;
/*     */   
/*     */   protected abstract ByteBuffer createBlockIfNeeded(int paramInt) throws IOException;
/*     */   
/*     */   protected abstract BATBlock.BATBlockAndIndex getBATBlockAndIndex(int paramInt);
/*     */   
/*     */   protected abstract int getNextBlock(int paramInt);
/*     */   
/*     */   protected abstract void setNextBlock(int paramInt1, int paramInt2);
/*     */   
/*     */   protected abstract int getFreeBlock() throws IOException;
/*     */   
/*     */   protected abstract ChainLoopDetector getChainLoopDetector() throws IOException;
/*     */   
/*     */   protected class ChainLoopDetector
/*     */   {
/*     */     private boolean[] used_blocks;
/*     */     
/*     */     protected ChainLoopDetector(long param1Long) {
/*  83 */       int i = BlockStore.this.getBlockStoreBlockSize();
/*  84 */       int j = (int)(param1Long / i);
/*  85 */       if (param1Long % i != 0L) {
/*  86 */         j++;
/*     */       }
/*  88 */       this.used_blocks = new boolean[j];
/*     */     }
/*     */     protected void claim(int param1Int) {
/*  91 */       if (param1Int >= this.used_blocks.length) {
/*     */         return;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  99 */       if (this.used_blocks[param1Int]) {
/* 100 */         throw new IllegalStateException("Potential loop detected - Block " + param1Int + " was already claimed but was just requested again");
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 105 */       this.used_blocks[param1Int] = true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\filesystem\BlockStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */