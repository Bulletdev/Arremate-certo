/*    */ package org.apache.poi.poifs.storage;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.util.ArrayList;
/*    */ import org.apache.poi.poifs.common.POIFSBigBlockSize;
/*    */ import org.apache.poi.util.Internal;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RawDataBlockList
/*    */   extends BlockListImpl
/*    */ {
/*    */   public RawDataBlockList(InputStream paramInputStream, POIFSBigBlockSize paramPOIFSBigBlockSize) throws IOException {
/*    */     RawDataBlock rawDataBlock;
/* 51 */     ArrayList<RawDataBlock> arrayList = new ArrayList();
/*    */ 
/*    */     
/*    */     do {
/* 55 */       rawDataBlock = new RawDataBlock(paramInputStream, paramPOIFSBigBlockSize.getBigBlockSize());
/*    */ 
/*    */       
/* 58 */       if (!rawDataBlock.hasData())
/* 59 */         continue;  arrayList.add(rawDataBlock);
/*    */ 
/*    */     
/*    */     }
/* 63 */     while (!rawDataBlock.eof());
/*    */ 
/*    */ 
/*    */     
/* 67 */     setBlocks(arrayList.<ListManagedBlock>toArray((ListManagedBlock[])new RawDataBlock[arrayList.size()]));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\storage\RawDataBlockList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */