/*    */ package org.apache.poi.hssf.record;
/*    */ 
/*    */ import org.apache.poi.ss.util.NumberToTextConverter;
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
/*    */ 
/*    */ public final class NumberRecord
/*    */   extends CellRecord
/*    */   implements Cloneable
/*    */ {
/*    */   public static final short sid = 515;
/*    */   private double field_4_value;
/*    */   
/*    */   public NumberRecord() {}
/*    */   
/*    */   public NumberRecord(RecordInputStream paramRecordInputStream) {
/* 42 */     super(paramRecordInputStream);
/* 43 */     this.field_4_value = paramRecordInputStream.readDouble();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setValue(double paramDouble) {
/* 52 */     this.field_4_value = paramDouble;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public double getValue() {
/* 61 */     return this.field_4_value;
/*    */   }
/*    */ 
/*    */   
/*    */   protected String getRecordName() {
/* 66 */     return "NUMBER";
/*    */   }
/*    */ 
/*    */   
/*    */   protected void appendValueText(StringBuilder paramStringBuilder) {
/* 71 */     paramStringBuilder.append("  .value= ").append(NumberToTextConverter.toText(this.field_4_value));
/*    */   }
/*    */ 
/*    */   
/*    */   protected void serializeValue(LittleEndianOutput paramLittleEndianOutput) {
/* 76 */     paramLittleEndianOutput.writeDouble(getValue());
/*    */   }
/*    */ 
/*    */   
/*    */   protected int getValueDataSize() {
/* 81 */     return 8;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 86 */     return 515;
/*    */   }
/*    */ 
/*    */   
/*    */   public NumberRecord clone() {
/* 91 */     NumberRecord numberRecord = new NumberRecord();
/* 92 */     copyBaseFields(numberRecord);
/* 93 */     numberRecord.field_4_value = this.field_4_value;
/* 94 */     return numberRecord;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\NumberRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */