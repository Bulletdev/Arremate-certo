/*    */ package org.apache.poi.hssf.record;
/*    */ 
/*    */ import org.apache.poi.ss.util.CellRangeAddress;
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
/*    */ public final class CFHeaderRecord
/*    */   extends CFHeaderBase
/*    */   implements Cloneable
/*    */ {
/*    */   public static final short sid = 432;
/*    */   
/*    */   public CFHeaderRecord() {
/* 32 */     createEmpty();
/*    */   }
/*    */   public CFHeaderRecord(CellRangeAddress[] paramArrayOfCellRangeAddress, int paramInt) {
/* 35 */     super(paramArrayOfCellRangeAddress, paramInt);
/*    */   }
/*    */   
/*    */   public CFHeaderRecord(RecordInputStream paramRecordInputStream) {
/* 39 */     read(paramRecordInputStream);
/*    */   }
/*    */   
/*    */   protected String getRecordName() {
/* 43 */     return "CFHEADER";
/*    */   }
/*    */   
/*    */   public short getSid() {
/* 47 */     return 432;
/*    */   }
/*    */ 
/*    */   
/*    */   public CFHeaderRecord clone() {
/* 52 */     CFHeaderRecord cFHeaderRecord = new CFHeaderRecord();
/* 53 */     copyTo(cFHeaderRecord);
/* 54 */     return cFHeaderRecord;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\CFHeaderRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */