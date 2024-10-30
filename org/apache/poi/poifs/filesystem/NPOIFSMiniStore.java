/*     */ package org.apache.poi.poifs.filesystem;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.poi.poifs.property.RootProperty;
/*     */ import org.apache.poi.poifs.storage.BATBlock;
/*     */ import org.apache.poi.poifs.storage.BlockAllocationTableWriter;
/*     */ import org.apache.poi.poifs.storage.HeaderBlock;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NPOIFSMiniStore
/*     */   extends BlockStore
/*     */ {
/*     */   private NPOIFSFileSystem _filesystem;
/*     */   private NPOIFSStream _mini_stream;
/*     */   private List<BATBlock> _sbat_blocks;
/*     */   private HeaderBlock _header;
/*     */   private RootProperty _root;
/*     */   
/*     */   protected NPOIFSMiniStore(NPOIFSFileSystem paramNPOIFSFileSystem, RootProperty paramRootProperty, List<BATBlock> paramList, HeaderBlock paramHeaderBlock) {
/*  49 */     this._filesystem = paramNPOIFSFileSystem;
/*  50 */     this._sbat_blocks = paramList;
/*  51 */     this._header = paramHeaderBlock;
/*  52 */     this._root = paramRootProperty;
/*     */     
/*  54 */     this._mini_stream = new NPOIFSStream(paramNPOIFSFileSystem, paramRootProperty.getStartBlock());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ByteBuffer getBlockAt(int paramInt) throws IOException {
/*  62 */     int i = paramInt * 64;
/*  63 */     int j = i / this._filesystem.getBigBlockSize();
/*  64 */     int k = i % this._filesystem.getBigBlockSize();
/*     */ 
/*     */     
/*  67 */     Iterator<ByteBuffer> iterator = this._mini_stream.getBlockIterator();
/*  68 */     for (byte b = 0; b < j; b++) {
/*  69 */       iterator.next();
/*     */     }
/*  71 */     ByteBuffer byteBuffer1 = iterator.next();
/*  72 */     if (byteBuffer1 == null) {
/*  73 */       throw new IndexOutOfBoundsException("Big block " + j + " outside stream");
/*     */     }
/*     */ 
/*     */     
/*  77 */     byteBuffer1.position(byteBuffer1.position() + k);
/*     */ 
/*     */     
/*  80 */     ByteBuffer byteBuffer2 = byteBuffer1.slice();
/*  81 */     byteBuffer2.limit(64);
/*  82 */     return byteBuffer2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ByteBuffer createBlockIfNeeded(int paramInt) throws IOException {
/*  89 */     boolean bool = false;
/*  90 */     if (this._mini_stream.getStartBlock() == -2) {
/*  91 */       bool = true;
/*     */     }
/*     */ 
/*     */     
/*  95 */     if (!bool) {
/*     */       try {
/*  97 */         return getBlockAt(paramInt);
/*  98 */       } catch (IndexOutOfBoundsException indexOutOfBoundsException) {}
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 106 */     int i = this._filesystem.getFreeBlock();
/* 107 */     this._filesystem.createBlockIfNeeded(i);
/*     */ 
/*     */     
/* 110 */     if (bool) {
/* 111 */       this._filesystem._get_property_table().getRoot().setStartBlock(i);
/* 112 */       this._mini_stream = new NPOIFSStream(this._filesystem, i);
/*     */     } else {
/*     */       
/* 115 */       BlockStore.ChainLoopDetector chainLoopDetector = this._filesystem.getChainLoopDetector();
/* 116 */       int j = this._mini_stream.getStartBlock();
/*     */       while (true) {
/* 118 */         chainLoopDetector.claim(j);
/* 119 */         int k = this._filesystem.getNextBlock(j);
/* 120 */         if (k == -2) {
/*     */           break;
/*     */         }
/* 123 */         j = k;
/*     */       } 
/* 125 */       this._filesystem.setNextBlock(j, i);
/*     */     } 
/*     */ 
/*     */     
/* 129 */     this._filesystem.setNextBlock(i, -2);
/*     */ 
/*     */     
/* 132 */     return createBlockIfNeeded(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected BATBlock.BATBlockAndIndex getBATBlockAndIndex(int paramInt) {
/* 140 */     return BATBlock.getSBATBlockAndIndex(paramInt, this._header, this._sbat_blocks);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getNextBlock(int paramInt) {
/* 149 */     BATBlock.BATBlockAndIndex bATBlockAndIndex = getBATBlockAndIndex(paramInt);
/* 150 */     return bATBlockAndIndex.getBlock().getValueAt(bATBlockAndIndex.getIndex());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setNextBlock(int paramInt1, int paramInt2) {
/* 157 */     BATBlock.BATBlockAndIndex bATBlockAndIndex = getBATBlockAndIndex(paramInt1);
/* 158 */     bATBlockAndIndex.getBlock().setValueAt(bATBlockAndIndex.getIndex(), paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getFreeBlock() throws IOException {
/* 169 */     int i = this._filesystem.getBigBlockSizeDetails().getBATEntriesPerBlock();
/*     */ 
/*     */     
/* 172 */     int j = 0;
/* 173 */     for (byte b = 0; b < this._sbat_blocks.size(); b++) {
/*     */       
/* 175 */       BATBlock bATBlock1 = this._sbat_blocks.get(b);
/* 176 */       if (bATBlock1.hasFreeSectors())
/*     */       {
/* 178 */         for (byte b1 = 0; b1 < i; b1++) {
/* 179 */           int m = bATBlock1.getValueAt(b1);
/* 180 */           if (m == -1)
/*     */           {
/* 182 */             return j + b1;
/*     */           }
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/* 188 */       j += i;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 196 */     BATBlock bATBlock = BATBlock.createEmptyBATBlock(this._filesystem.getBigBlockSizeDetails(), false);
/* 197 */     int k = this._filesystem.getFreeBlock();
/* 198 */     bATBlock.setOurBlockIndex(k);
/*     */ 
/*     */     
/* 201 */     if (this._header.getSBATCount() == 0) {
/*     */       
/* 203 */       this._header.setSBATStart(k);
/* 204 */       this._header.setSBATBlockCount(1);
/*     */     } else {
/*     */       
/* 207 */       BlockStore.ChainLoopDetector chainLoopDetector = this._filesystem.getChainLoopDetector();
/* 208 */       int m = this._header.getSBATStart();
/*     */       while (true) {
/* 210 */         chainLoopDetector.claim(m);
/* 211 */         int n = this._filesystem.getNextBlock(m);
/* 212 */         if (n == -2) {
/*     */           break;
/*     */         }
/* 215 */         m = n;
/*     */       } 
/*     */ 
/*     */       
/* 219 */       this._filesystem.setNextBlock(m, k);
/*     */ 
/*     */       
/* 222 */       this._header.setSBATBlockCount(this._header.getSBATCount() + 1);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 228 */     this._filesystem.setNextBlock(k, -2);
/* 229 */     this._sbat_blocks.add(bATBlock);
/*     */ 
/*     */     
/* 232 */     return j;
/*     */   }
/*     */ 
/*     */   
/*     */   protected BlockStore.ChainLoopDetector getChainLoopDetector() throws IOException {
/* 237 */     return new BlockStore.ChainLoopDetector(this, this._root.getSize());
/*     */   }
/*     */   
/*     */   protected int getBlockStoreBlockSize() {
/* 241 */     return 64;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void syncWithDataSource() throws IOException {
/* 250 */     int i = 0;
/* 251 */     for (BATBlock bATBlock : this._sbat_blocks) {
/* 252 */       ByteBuffer byteBuffer = this._filesystem.getBlockAt(bATBlock.getOurBlockIndex());
/* 253 */       BlockAllocationTableWriter.writeBlock(bATBlock, byteBuffer);
/*     */       
/* 255 */       if (!bATBlock.hasFreeSectors()) {
/* 256 */         i += this._filesystem.getBigBlockSizeDetails().getBATEntriesPerBlock(); continue;
/*     */       } 
/* 258 */       i += bATBlock.getUsedSectors(false);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 263 */     this._filesystem._get_property_table().getRoot().setSize(i);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\filesystem\NPOIFSMiniStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */