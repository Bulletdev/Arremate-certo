/*    */ package org.apache.poi.hssf.record;
/*    */ 
/*    */ import org.apache.poi.util.HexDump;
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
/*    */ public final class LabelSSTRecord
/*    */   extends CellRecord
/*    */   implements Cloneable
/*    */ {
/*    */   public static final short sid = 253;
/*    */   private int field_4_sst_index;
/*    */   
/*    */   public LabelSSTRecord() {}
/*    */   
/*    */   public LabelSSTRecord(RecordInputStream paramRecordInputStream) {
/* 37 */     super(paramRecordInputStream);
/* 38 */     this.field_4_sst_index = paramRecordInputStream.readInt();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setSSTIndex(int paramInt) {
/* 48 */     this.field_4_sst_index = paramInt;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getSSTIndex() {
/* 59 */     return this.field_4_sst_index;
/*    */   }
/*    */ 
/*    */   
/*    */   protected String getRecordName() {
/* 64 */     return "LABELSST";
/*    */   }
/*    */ 
/*    */   
/*    */   protected void appendValueText(StringBuilder paramStringBuilder) {
/* 69 */     paramStringBuilder.append("  .sstIndex = ");
/* 70 */     paramStringBuilder.append(HexDump.shortToHex(getSSTIndex()));
/*    */   }
/*    */   
/*    */   protected void serializeValue(LittleEndianOutput paramLittleEndianOutput) {
/* 74 */     paramLittleEndianOutput.writeInt(getSSTIndex());
/*    */   }
/*    */ 
/*    */   
/*    */   protected int getValueDataSize() {
/* 79 */     return 4;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 84 */     return 253;
/*    */   }
/*    */ 
/*    */   
/*    */   public LabelSSTRecord clone() {
/* 89 */     LabelSSTRecord labelSSTRecord = new LabelSSTRecord();
/* 90 */     copyBaseFields(labelSSTRecord);
/* 91 */     labelSSTRecord.field_4_sst_index = this.field_4_sst_index;
/* 92 */     return labelSSTRecord;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\LabelSSTRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */