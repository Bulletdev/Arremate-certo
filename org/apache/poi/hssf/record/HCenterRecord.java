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
/*    */ public final class HCenterRecord
/*    */   extends StandardRecord
/*    */   implements Cloneable
/*    */ {
/*    */   public static final short sid = 131;
/*    */   private short field_1_hcenter;
/*    */   
/*    */   public HCenterRecord() {}
/*    */   
/*    */   public HCenterRecord(RecordInputStream paramRecordInputStream) {
/* 40 */     this.field_1_hcenter = paramRecordInputStream.readShort();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setHCenter(boolean paramBoolean) {
/* 50 */     if (paramBoolean == true) {
/*    */       
/* 52 */       this.field_1_hcenter = 1;
/*    */     }
/*    */     else {
/*    */       
/* 56 */       this.field_1_hcenter = 0;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean getHCenter() {
/* 67 */     return (this.field_1_hcenter == 1);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 72 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 74 */     stringBuffer.append("[HCENTER]\n");
/* 75 */     stringBuffer.append("    .hcenter        = ").append(getHCenter()).append("\n");
/*    */     
/* 77 */     stringBuffer.append("[/HCENTER]\n");
/* 78 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 82 */     paramLittleEndianOutput.writeShort(this.field_1_hcenter);
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 86 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 91 */     return 131;
/*    */   }
/*    */ 
/*    */   
/*    */   public HCenterRecord clone() {
/* 96 */     HCenterRecord hCenterRecord = new HCenterRecord();
/* 97 */     hCenterRecord.field_1_hcenter = this.field_1_hcenter;
/* 98 */     return hCenterRecord;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\HCenterRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */