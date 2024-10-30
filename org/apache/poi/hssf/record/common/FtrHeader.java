/*    */ package org.apache.poi.hssf.record.common;
/*    */ 
/*    */ import org.apache.poi.hssf.record.RecordInputStream;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class FtrHeader
/*    */   implements Cloneable
/*    */ {
/*    */   private short recordType;
/*    */   private short grbitFrt;
/*    */   private CellRangeAddress associatedRange;
/*    */   
/*    */   public FtrHeader() {
/* 40 */     this.associatedRange = new CellRangeAddress(0, 0, 0, 0);
/*    */   }
/*    */   
/*    */   public FtrHeader(RecordInputStream paramRecordInputStream) {
/* 44 */     this.recordType = paramRecordInputStream.readShort();
/* 45 */     this.grbitFrt = paramRecordInputStream.readShort();
/*    */     
/* 47 */     this.associatedRange = new CellRangeAddress(paramRecordInputStream);
/*    */   }
/*    */   
/*    */   public String toString() {
/* 51 */     StringBuffer stringBuffer = new StringBuffer();
/* 52 */     stringBuffer.append(" [FUTURE HEADER]\n");
/* 53 */     stringBuffer.append("   Type " + this.recordType);
/* 54 */     stringBuffer.append("   Flags " + this.grbitFrt);
/* 55 */     stringBuffer.append(" [/FUTURE HEADER]\n");
/* 56 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 60 */     paramLittleEndianOutput.writeShort(this.recordType);
/* 61 */     paramLittleEndianOutput.writeShort(this.grbitFrt);
/* 62 */     this.associatedRange.serialize(paramLittleEndianOutput);
/*    */   }
/*    */   
/*    */   public static int getDataSize() {
/* 66 */     return 12;
/*    */   }
/*    */   
/*    */   public short getRecordType() {
/* 70 */     return this.recordType;
/*    */   }
/*    */   public void setRecordType(short paramShort) {
/* 73 */     this.recordType = paramShort;
/*    */   }
/*    */   
/*    */   public short getGrbitFrt() {
/* 77 */     return this.grbitFrt;
/*    */   }
/*    */   public void setGrbitFrt(short paramShort) {
/* 80 */     this.grbitFrt = paramShort;
/*    */   }
/*    */   
/*    */   public CellRangeAddress getAssociatedRange() {
/* 84 */     return this.associatedRange;
/*    */   }
/*    */   public void setAssociatedRange(CellRangeAddress paramCellRangeAddress) {
/* 87 */     this.associatedRange = paramCellRangeAddress;
/*    */   }
/*    */   
/*    */   public Object clone() {
/* 91 */     FtrHeader ftrHeader = new FtrHeader();
/* 92 */     ftrHeader.recordType = this.recordType;
/* 93 */     ftrHeader.grbitFrt = this.grbitFrt;
/* 94 */     ftrHeader.associatedRange = this.associatedRange.copy();
/* 95 */     return ftrHeader;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\common\FtrHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */