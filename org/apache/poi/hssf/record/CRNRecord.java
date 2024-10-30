/*    */ package org.apache.poi.hssf.record;
/*    */ 
/*    */ import org.apache.poi.ss.formula.constant.ConstantValueParser;
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
/*    */ public final class CRNRecord
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 90;
/*    */   private int field_1_last_column_index;
/*    */   private int field_2_first_column_index;
/*    */   private int field_3_row_index;
/*    */   private Object[] field_4_constant_values;
/*    */   
/*    */   public CRNRecord() {
/* 37 */     throw new RuntimeException("incomplete code");
/*    */   }
/*    */   
/*    */   public int getNumberOfCRNs() {
/* 41 */     return this.field_1_last_column_index;
/*    */   }
/*    */ 
/*    */   
/*    */   public CRNRecord(RecordInputStream paramRecordInputStream) {
/* 46 */     this.field_1_last_column_index = paramRecordInputStream.readUByte();
/* 47 */     this.field_2_first_column_index = paramRecordInputStream.readUByte();
/* 48 */     this.field_3_row_index = paramRecordInputStream.readShort();
/* 49 */     int i = this.field_1_last_column_index - this.field_2_first_column_index + 1;
/* 50 */     this.field_4_constant_values = ConstantValueParser.parse(paramRecordInputStream, i);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 55 */     StringBuffer stringBuffer = new StringBuffer();
/* 56 */     stringBuffer.append(getClass().getName()).append(" [CRN");
/* 57 */     stringBuffer.append(" rowIx=").append(this.field_3_row_index);
/* 58 */     stringBuffer.append(" firstColIx=").append(this.field_2_first_column_index);
/* 59 */     stringBuffer.append(" lastColIx=").append(this.field_1_last_column_index);
/* 60 */     stringBuffer.append("]");
/* 61 */     return stringBuffer.toString();
/*    */   }
/*    */   protected int getDataSize() {
/* 64 */     return 4 + ConstantValueParser.getEncodedSize(this.field_4_constant_values);
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 68 */     paramLittleEndianOutput.writeByte(this.field_1_last_column_index);
/* 69 */     paramLittleEndianOutput.writeByte(this.field_2_first_column_index);
/* 70 */     paramLittleEndianOutput.writeShort(this.field_3_row_index);
/* 71 */     ConstantValueParser.encode(paramLittleEndianOutput, this.field_4_constant_values);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 78 */     return 90;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\CRNRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */