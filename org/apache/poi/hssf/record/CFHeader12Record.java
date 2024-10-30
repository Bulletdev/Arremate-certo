/*    */ package org.apache.poi.hssf.record;
/*    */ 
/*    */ import org.apache.poi.hssf.record.common.FtrHeader;
/*    */ import org.apache.poi.hssf.record.common.FutureRecord;
/*    */ import org.apache.poi.ss.util.CellRangeAddress;
/*    */ import org.apache.poi.util.LittleEndianOutput;
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
/*    */ public final class CFHeader12Record
/*    */   extends CFHeaderBase
/*    */   implements Cloneable, FutureRecord
/*    */ {
/*    */   public static final short sid = 2169;
/*    */   private FtrHeader futureHeader;
/*    */   
/*    */   public CFHeader12Record() {
/* 36 */     createEmpty();
/* 37 */     this.futureHeader = new FtrHeader();
/* 38 */     this.futureHeader.setRecordType((short)2169);
/*    */   }
/*    */   public CFHeader12Record(CellRangeAddress[] paramArrayOfCellRangeAddress, int paramInt) {
/* 41 */     super(paramArrayOfCellRangeAddress, paramInt);
/* 42 */     this.futureHeader = new FtrHeader();
/* 43 */     this.futureHeader.setRecordType((short)2169);
/*    */   }
/*    */   public CFHeader12Record(RecordInputStream paramRecordInputStream) {
/* 46 */     this.futureHeader = new FtrHeader(paramRecordInputStream);
/* 47 */     read(paramRecordInputStream);
/*    */   }
/*    */ 
/*    */   
/*    */   protected String getRecordName() {
/* 52 */     return "CFHEADER12";
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 56 */     return FtrHeader.getDataSize() + super.getDataSize();
/*    */   }
/*    */ 
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 61 */     this.futureHeader.setAssociatedRange(getEnclosingCellRange());
/*    */     
/* 63 */     this.futureHeader.serialize(paramLittleEndianOutput);
/*    */     
/* 65 */     super.serialize(paramLittleEndianOutput);
/*    */   }
/*    */   
/*    */   public short getSid() {
/* 69 */     return 2169;
/*    */   }
/*    */   
/*    */   public short getFutureRecordType() {
/* 73 */     return this.futureHeader.getRecordType();
/*    */   }
/*    */   public FtrHeader getFutureHeader() {
/* 76 */     return this.futureHeader;
/*    */   }
/*    */   public CellRangeAddress getAssociatedRange() {
/* 79 */     return this.futureHeader.getAssociatedRange();
/*    */   }
/*    */ 
/*    */   
/*    */   public CFHeader12Record clone() {
/* 84 */     CFHeader12Record cFHeader12Record = new CFHeader12Record();
/* 85 */     cFHeader12Record.futureHeader = (FtrHeader)this.futureHeader.clone();
/* 86 */     copyTo(cFHeader12Record);
/* 87 */     return cFHeader12Record;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\CFHeader12Record.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */