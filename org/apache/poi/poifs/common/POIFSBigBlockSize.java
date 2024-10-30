/*    */ package org.apache.poi.poifs.common;
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
/*    */ public final class POIFSBigBlockSize
/*    */ {
/*    */   private int bigBlockSize;
/*    */   private short headerValue;
/*    */   
/*    */   protected POIFSBigBlockSize(int paramInt, short paramShort) {
/* 33 */     this.bigBlockSize = paramInt;
/* 34 */     this.headerValue = paramShort;
/*    */   }
/*    */   
/*    */   public int getBigBlockSize() {
/* 38 */     return this.bigBlockSize;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public short getHeaderValue() {
/* 48 */     return this.headerValue;
/*    */   }
/*    */   
/*    */   public int getPropertiesPerBlock() {
/* 52 */     return this.bigBlockSize / 128;
/*    */   }
/*    */   
/*    */   public int getBATEntriesPerBlock() {
/* 56 */     return this.bigBlockSize / 4;
/*    */   }
/*    */   public int getXBATEntriesPerBlock() {
/* 59 */     return getBATEntriesPerBlock() - 1;
/*    */   }
/*    */   public int getNextXBATChainOffset() {
/* 62 */     return getXBATEntriesPerBlock() * 4;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\common\POIFSBigBlockSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */