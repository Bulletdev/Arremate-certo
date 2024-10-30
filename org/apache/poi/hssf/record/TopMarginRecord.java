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
/*    */ public final class TopMarginRecord
/*    */   extends StandardRecord
/*    */   implements Margin
/*    */ {
/*    */   public static final short sid = 40;
/*    */   private double field_1_margin;
/*    */   
/*    */   public TopMarginRecord() {}
/*    */   
/*    */   public TopMarginRecord(RecordInputStream paramRecordInputStream) {
/* 36 */     this.field_1_margin = paramRecordInputStream.readDouble();
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 41 */     StringBuffer stringBuffer = new StringBuffer();
/* 42 */     stringBuffer.append("[TopMargin]\n");
/* 43 */     stringBuffer.append("    .margin               = ").append(" (").append(getMargin()).append(" )\n");
/* 44 */     stringBuffer.append("[/TopMargin]\n");
/* 45 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 49 */     paramLittleEndianOutput.writeDouble(this.field_1_margin);
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 53 */     return 8;
/*    */   }
/*    */   public short getSid() {
/* 56 */     return 40;
/*    */   }
/*    */ 
/*    */   
/*    */   public double getMargin() {
/* 61 */     return this.field_1_margin;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setMargin(double paramDouble) {
/* 67 */     this.field_1_margin = paramDouble;
/*    */   }
/*    */   
/*    */   public Object clone() {
/* 71 */     TopMarginRecord topMarginRecord = new TopMarginRecord();
/* 72 */     topMarginRecord.field_1_margin = this.field_1_margin;
/* 73 */     return topMarginRecord;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\TopMarginRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */