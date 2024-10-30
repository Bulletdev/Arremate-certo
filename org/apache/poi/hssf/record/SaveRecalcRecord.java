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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class SaveRecalcRecord
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 95;
/*    */   private short field_1_recalc;
/*    */   
/*    */   public SaveRecalcRecord() {}
/*    */   
/*    */   public SaveRecalcRecord(RecordInputStream paramRecordInputStream) {
/* 45 */     this.field_1_recalc = paramRecordInputStream.readShort();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setRecalc(boolean paramBoolean) {
/* 55 */     this.field_1_recalc = (short)((paramBoolean == true) ? 1 : 0);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean getRecalc() {
/* 66 */     return (this.field_1_recalc == 1);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 71 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 73 */     stringBuffer.append("[SAVERECALC]\n");
/* 74 */     stringBuffer.append("    .recalc         = ").append(getRecalc()).append("\n");
/*    */     
/* 76 */     stringBuffer.append("[/SAVERECALC]\n");
/* 77 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 81 */     paramLittleEndianOutput.writeShort(this.field_1_recalc);
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 85 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 90 */     return 95;
/*    */   }
/*    */   
/*    */   public Object clone() {
/* 94 */     SaveRecalcRecord saveRecalcRecord = new SaveRecalcRecord();
/* 95 */     saveRecalcRecord.field_1_recalc = this.field_1_recalc;
/* 96 */     return saveRecalcRecord;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\SaveRecalcRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */