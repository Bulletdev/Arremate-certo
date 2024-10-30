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
/*    */ public final class BottomMarginRecord
/*    */   extends StandardRecord
/*    */   implements Cloneable, Margin
/*    */ {
/*    */   public static final short sid = 41;
/*    */   private double field_1_margin;
/*    */   
/*    */   public BottomMarginRecord() {}
/*    */   
/*    */   public BottomMarginRecord(RecordInputStream paramRecordInputStream) {
/* 39 */     this.field_1_margin = paramRecordInputStream.readDouble();
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 44 */     StringBuffer stringBuffer = new StringBuffer();
/* 45 */     stringBuffer.append("[BottomMargin]\n");
/* 46 */     stringBuffer.append("    .margin               = ").append(" (").append(getMargin()).append(" )\n");
/*    */     
/* 48 */     stringBuffer.append("[/BottomMargin]\n");
/* 49 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 53 */     paramLittleEndianOutput.writeDouble(this.field_1_margin);
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 57 */     return 8;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 62 */     return 41;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public double getMargin() {
/* 70 */     return this.field_1_margin;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setMargin(double paramDouble) {
/* 78 */     this.field_1_margin = paramDouble;
/*    */   }
/*    */ 
/*    */   
/*    */   public BottomMarginRecord clone() {
/* 83 */     BottomMarginRecord bottomMarginRecord = new BottomMarginRecord();
/* 84 */     bottomMarginRecord.field_1_margin = this.field_1_margin;
/* 85 */     return bottomMarginRecord;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\BottomMarginRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */