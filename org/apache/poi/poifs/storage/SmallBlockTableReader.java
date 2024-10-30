/*     */ package org.apache.poi.poifs.storage;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.apache.poi.poifs.common.POIFSBigBlockSize;
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
/*     */ public final class SmallBlockTableReader
/*     */ {
/*     */   private static BlockList prepareSmallDocumentBlocks(POIFSBigBlockSize paramPOIFSBigBlockSize, RawDataBlockList paramRawDataBlockList, RootProperty paramRootProperty, int paramInt) throws IOException {
/*  37 */     ListManagedBlock[] arrayOfListManagedBlock = paramRawDataBlockList.fetchBlocks(paramRootProperty.getStartBlock(), -1);
/*     */ 
/*     */ 
/*     */     
/*  41 */     return new SmallDocumentBlockList(SmallDocumentBlock.extract(paramPOIFSBigBlockSize, arrayOfListManagedBlock));
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
/*     */   private static BlockAllocationTableReader prepareReader(POIFSBigBlockSize paramPOIFSBigBlockSize, RawDataBlockList paramRawDataBlockList, BlockList paramBlockList, RootProperty paramRootProperty, int paramInt) throws IOException {
/*  53 */     return new BlockAllocationTableReader(paramPOIFSBigBlockSize, paramRawDataBlockList.fetchBlocks(paramInt, -1), paramBlockList);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BlockAllocationTableReader _getSmallDocumentBlockReader(POIFSBigBlockSize paramPOIFSBigBlockSize, RawDataBlockList paramRawDataBlockList, RootProperty paramRootProperty, int paramInt) throws IOException {
/*  80 */     BlockList blockList = prepareSmallDocumentBlocks(paramPOIFSBigBlockSize, paramRawDataBlockList, paramRootProperty, paramInt);
/*     */     
/*  82 */     return prepareReader(paramPOIFSBigBlockSize, paramRawDataBlockList, blockList, paramRootProperty, paramInt);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static BlockList getSmallDocumentBlocks(POIFSBigBlockSize paramPOIFSBigBlockSize, RawDataBlockList paramRawDataBlockList, RootProperty paramRootProperty, int paramInt) throws IOException {
/* 105 */     BlockList blockList = prepareSmallDocumentBlocks(paramPOIFSBigBlockSize, paramRawDataBlockList, paramRootProperty, paramInt);
/*     */     
/* 107 */     prepareReader(paramPOIFSBigBlockSize, paramRawDataBlockList, blockList, paramRootProperty, paramInt);
/* 108 */     return blockList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\storage\SmallBlockTableReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */