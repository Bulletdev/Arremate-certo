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
/*    */ public final class LeftMarginRecord
/*    */   extends StandardRecord
/*    */   implements Cloneable, Margin
/*    */ {
/*    */   public static final short sid = 38;
/*    */   private double field_1_margin;
/*    */   
/*    */   public LeftMarginRecord() {}
/*    */   
/*    */   public LeftMarginRecord(RecordInputStream paramRecordInputStream) {
/* 33 */     this.field_1_margin = paramRecordInputStream.readDouble();
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 38 */     StringBuffer stringBuffer = new StringBuffer();
/* 39 */     stringBuffer.append("[LeftMargin]\n");
/* 40 */     stringBuffer.append("    .margin               = ").append(" (").append(getMargin()).append(" )\n");
/* 41 */     stringBuffer.append("[/LeftMargin]\n");
/* 42 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 46 */     paramLittleEndianOutput.writeDouble(this.field_1_margin);
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 50 */     return 8;
/*    */   }
/*    */   
/*    */   public short getSid() {
/* 54 */     return 38;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public double getMargin() {
/* 61 */     return this.field_1_margin;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setMargin(double paramDouble) {
/* 69 */     this.field_1_margin = paramDouble;
/*    */   }
/*    */ 
/*    */   
/*    */   public LeftMarginRecord clone() {
/* 74 */     LeftMarginRecord leftMarginRecord = new LeftMarginRecord();
/* 75 */     leftMarginRecord.field_1_margin = this.field_1_margin;
/* 76 */     return leftMarginRecord;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\LeftMarginRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */