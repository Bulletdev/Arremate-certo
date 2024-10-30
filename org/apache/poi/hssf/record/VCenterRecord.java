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
/*    */ public final class VCenterRecord
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 132;
/*    */   private int field_1_vcenter;
/*    */   
/*    */   public VCenterRecord() {}
/*    */   
/*    */   public VCenterRecord(RecordInputStream paramRecordInputStream) {
/* 41 */     this.field_1_vcenter = paramRecordInputStream.readShort();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setVCenter(boolean paramBoolean) {
/* 51 */     this.field_1_vcenter = paramBoolean ? 1 : 0;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean getVCenter() {
/* 61 */     return (this.field_1_vcenter == 1);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 66 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 68 */     stringBuffer.append("[VCENTER]\n");
/* 69 */     stringBuffer.append("    .vcenter        = ").append(getVCenter()).append("\n");
/*    */     
/* 71 */     stringBuffer.append("[/VCENTER]\n");
/* 72 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 76 */     paramLittleEndianOutput.writeShort(this.field_1_vcenter);
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 80 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 85 */     return 132;
/*    */   }
/*    */   
/*    */   public Object clone() {
/* 89 */     VCenterRecord vCenterRecord = new VCenterRecord();
/* 90 */     vCenterRecord.field_1_vcenter = this.field_1_vcenter;
/* 91 */     return vCenterRecord;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\VCenterRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */