/*    */ package org.apache.poi.poifs.storage;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.OutputStream;
/*    */ import org.apache.poi.poifs.common.POIFSBigBlockSize;
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
/*    */ abstract class BigBlock
/*    */   implements BlockWritable
/*    */ {
/*    */   protected POIFSBigBlockSize bigBlockSize;
/*    */   
/*    */   protected BigBlock(POIFSBigBlockSize paramPOIFSBigBlockSize) {
/* 49 */     this.bigBlockSize = paramPOIFSBigBlockSize;
/*    */   }
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
/*    */   protected void doWriteData(OutputStream paramOutputStream, byte[] paramArrayOfbyte) throws IOException {
/* 67 */     paramOutputStream.write(paramArrayOfbyte);
/*    */   }
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
/*    */   abstract void writeData(OutputStream paramOutputStream) throws IOException;
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
/*    */   public void writeBlocks(OutputStream paramOutputStream) throws IOException {
/* 98 */     writeData(paramOutputStream);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\storage\BigBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */