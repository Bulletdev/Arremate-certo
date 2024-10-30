/*    */ package org.apache.poi.hssf.record;
/*    */ 
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
/*    */ public final class CRNCountRecord
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 89;
/*    */   private static final short DATA_SIZE = 4;
/*    */   private int field_1_number_crn_records;
/*    */   private int field_2_sheet_table_index;
/*    */   
/*    */   public CRNCountRecord() {
/* 38 */     throw new RuntimeException("incomplete code");
/*    */   }
/*    */   
/*    */   public int getNumberOfCRNs() {
/* 42 */     return this.field_1_number_crn_records;
/*    */   }
/*    */ 
/*    */   
/*    */   public CRNCountRecord(RecordInputStream paramRecordInputStream) {
/* 47 */     this.field_1_number_crn_records = paramRecordInputStream.readShort();
/* 48 */     if (this.field_1_number_crn_records < 0)
/*    */     {
/*    */       
/* 51 */       this.field_1_number_crn_records = (short)-this.field_1_number_crn_records;
/*    */     }
/* 53 */     this.field_2_sheet_table_index = paramRecordInputStream.readShort();
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 58 */     StringBuffer stringBuffer = new StringBuffer();
/* 59 */     stringBuffer.append(getClass().getName()).append(" [XCT");
/* 60 */     stringBuffer.append(" nCRNs=").append(this.field_1_number_crn_records);
/* 61 */     stringBuffer.append(" sheetIx=").append(this.field_2_sheet_table_index);
/* 62 */     stringBuffer.append("]");
/* 63 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 67 */     paramLittleEndianOutput.writeShort((short)this.field_1_number_crn_records);
/* 68 */     paramLittleEndianOutput.writeShort((short)this.field_2_sheet_table_index);
/*    */   }
/*    */   protected int getDataSize() {
/* 71 */     return 4;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 78 */     return 89;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\CRNCountRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */