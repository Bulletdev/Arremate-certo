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
/*    */ public final class PrecisionRecord
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 14;
/*    */   public short field_1_precision;
/*    */   
/*    */   public PrecisionRecord() {}
/*    */   
/*    */   public PrecisionRecord(RecordInputStream paramRecordInputStream) {
/* 44 */     this.field_1_precision = paramRecordInputStream.readShort();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setFullPrecision(boolean paramBoolean) {
/* 55 */     if (paramBoolean == true) {
/*    */       
/* 57 */       this.field_1_precision = 1;
/*    */     }
/*    */     else {
/*    */       
/* 61 */       this.field_1_precision = 0;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean getFullPrecision() {
/* 73 */     return (this.field_1_precision == 1);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 78 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 80 */     stringBuffer.append("[PRECISION]\n");
/* 81 */     stringBuffer.append("    .precision       = ").append(getFullPrecision()).append("\n");
/*    */     
/* 83 */     stringBuffer.append("[/PRECISION]\n");
/* 84 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 88 */     paramLittleEndianOutput.writeShort(this.field_1_precision);
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 92 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 97 */     return 14;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\PrecisionRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */