/*     */ package org.apache.poi.poifs.storage;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.poi.poifs.common.POIFSBigBlockSize;
/*     */ import org.apache.poi.poifs.filesystem.BATManaged;
/*     */ import org.apache.poi.poifs.filesystem.OPOIFSDocument;
/*     */ import org.apache.poi.poifs.property.RootProperty;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SmallBlockTableWriter
/*     */   implements BATManaged, BlockWritable
/*     */ {
/*     */   private BlockAllocationTableWriter _sbat;
/*     */   private List<SmallDocumentBlock> _small_blocks;
/*     */   private int _big_block_count;
/*     */   private RootProperty _root;
/*     */   
/*     */   public SmallBlockTableWriter(POIFSBigBlockSize paramPOIFSBigBlockSize, List<OPOIFSDocument> paramList, RootProperty paramRootProperty) {
/*  57 */     this._sbat = new BlockAllocationTableWriter(paramPOIFSBigBlockSize);
/*  58 */     this._small_blocks = new ArrayList<SmallDocumentBlock>();
/*  59 */     this._root = paramRootProperty;
/*     */     
/*  61 */     for (OPOIFSDocument oPOIFSDocument : paramList) {
/*     */       
/*  63 */       SmallDocumentBlock[] arrayOfSmallDocumentBlock = oPOIFSDocument.getSmallBlocks();
/*     */       
/*  65 */       if (arrayOfSmallDocumentBlock.length != 0) {
/*     */         
/*  67 */         oPOIFSDocument.setStartBlock(this._sbat.allocateSpace(arrayOfSmallDocumentBlock.length));
/*  68 */         for (byte b = 0; b < arrayOfSmallDocumentBlock.length; b++)
/*     */         {
/*  70 */           this._small_blocks.add(arrayOfSmallDocumentBlock[b]); } 
/*     */         continue;
/*     */       } 
/*  73 */       oPOIFSDocument.setStartBlock(-2);
/*     */     } 
/*     */     
/*  76 */     this._sbat.simpleCreateBlocks();
/*  77 */     this._root.setSize(this._small_blocks.size());
/*  78 */     this._big_block_count = SmallDocumentBlock.fill(paramPOIFSBigBlockSize, this._small_blocks);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSBATBlockCount() {
/*  89 */     return (this._big_block_count + 15) / 16;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BlockAllocationTableWriter getSBAT() {
/* 100 */     return this._sbat;
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
/*     */   public int countBlocks() {
/* 113 */     return this._big_block_count;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStartBlock(int paramInt) {
/* 124 */     this._root.setStartBlock(paramInt);
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
/*     */   public void writeBlocks(OutputStream paramOutputStream) throws IOException {
/* 143 */     for (BlockWritable blockWritable : this._small_blocks)
/* 144 */       blockWritable.writeBlocks(paramOutputStream); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\storage\SmallBlockTableWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */