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
/*    */ public final class RightMarginRecord
/*    */   extends StandardRecord
/*    */   implements Margin
/*    */ {
/*    */   public static final short sid = 39;
/*    */   private double field_1_margin;
/*    */   
/*    */   public RightMarginRecord() {}
/*    */   
/*    */   public RightMarginRecord(RecordInputStream paramRecordInputStream) {
/* 33 */     this.field_1_margin = paramRecordInputStream.readDouble();
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 38 */     StringBuffer stringBuffer = new StringBuffer();
/* 39 */     stringBuffer.append("[RightMargin]\n");
/* 40 */     stringBuffer.append("    .margin               = ").append(" (").append(getMargin()).append(" )\n");
/* 41 */     stringBuffer.append("[/RightMargin]\n");
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
/*    */   public short getSid() {
/* 53 */     return 39;
/*    */   }
/*    */ 
/*    */   
/*    */   public double getMargin() {
/* 58 */     return this.field_1_margin;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setMargin(double paramDouble) {
/* 64 */     this.field_1_margin = paramDouble;
/*    */   }
/*    */   
/*    */   public Object clone() {
/* 68 */     RightMarginRecord rightMarginRecord = new RightMarginRecord();
/* 69 */     rightMarginRecord.field_1_margin = this.field_1_margin;
/* 70 */     return rightMarginRecord;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\RightMarginRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */