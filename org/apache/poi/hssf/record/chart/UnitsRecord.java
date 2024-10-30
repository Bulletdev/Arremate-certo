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
/*    */ 
/*    */ public final class UnitsRecord
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 4097;
/*    */   private short field_1_units;
/*    */   
/*    */   public UnitsRecord() {}
/*    */   
/*    */   public UnitsRecord(RecordInputStream paramRecordInputStream) {
/* 40 */     this.field_1_units = paramRecordInputStream.readShort();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 46 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 48 */     stringBuffer.append("[UNITS]\n");
/* 49 */     stringBuffer.append("    .units                = ").append("0x").append(HexDump.toHex(getUnits())).append(" (").append(getUnits()).append(" )");
/*    */ 
/*    */     
/* 52 */     stringBuffer.append(System.getProperty("line.separator"));
/*    */     
/* 54 */     stringBuffer.append("[/UNITS]\n");
/* 55 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 59 */     paramLittleEndianOutput.writeShort(this.field_1_units);
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 63 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 68 */     return 4097;
/*    */   }
/*    */   
/*    */   public Object clone() {
/* 72 */     UnitsRecord unitsRecord = new UnitsRecord();
/*    */     
/* 74 */     unitsRecord.field_1_units = this.field_1_units;
/* 75 */     return unitsRecord;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public short getUnits() {
/* 86 */     return this.field_1_units;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setUnits(short paramShort) {
/* 94 */     this.field_1_units = paramShort;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\UnitsRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */