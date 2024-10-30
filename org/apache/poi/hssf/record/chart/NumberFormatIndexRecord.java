/*    */ package org.apache.poi.hssf.record.chart;
/*    */ 
/*    */ import org.apache.poi.hssf.record.RecordInputStream;
/*    */ import org.apache.poi.hssf.record.StandardRecord;
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
/*    */ 
/*    */ public final class NumberFormatIndexRecord
/*    */   extends StandardRecord
/*    */   implements Cloneable
/*    */ {
/*    */   public static final short sid = 4174;
/*    */   private short field_1_formatIndex;
/*    */   
/*    */   public NumberFormatIndexRecord() {}
/*    */   
/*    */   public NumberFormatIndexRecord(RecordInputStream paramRecordInputStream) {
/* 40 */     this.field_1_formatIndex = paramRecordInputStream.readShort();
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 45 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 47 */     stringBuffer.append("[IFMT]\n");
/* 48 */     stringBuffer.append("    .formatIndex          = ").append("0x").append(HexDump.toHex(getFormatIndex())).append(" (").append(getFormatIndex()).append(" )");
/*    */ 
/*    */     
/* 51 */     stringBuffer.append(System.getProperty("line.separator"));
/*    */     
/* 53 */     stringBuffer.append("[/IFMT]\n");
/* 54 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 58 */     paramLittleEndianOutput.writeShort(this.field_1_formatIndex);
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 62 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 67 */     return 4174;
/*    */   }
/*    */ 
/*    */   
/*    */   public NumberFormatIndexRecord clone() {
/* 72 */     NumberFormatIndexRecord numberFormatIndexRecord = new NumberFormatIndexRecord();
/*    */     
/* 74 */     numberFormatIndexRecord.field_1_formatIndex = this.field_1_formatIndex;
/* 75 */     return numberFormatIndexRecord;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public short getFormatIndex() {
/* 86 */     return this.field_1_formatIndex;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setFormatIndex(short paramShort) {
/* 94 */     this.field_1_formatIndex = paramShort;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\NumberFormatIndexRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */