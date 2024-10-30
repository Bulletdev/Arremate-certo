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
/*    */ public final class DeltaRecord
/*    */   extends StandardRecord
/*    */   implements Cloneable
/*    */ {
/*    */   public static final short sid = 16;
/*    */   public static final double DEFAULT_VALUE = 0.001D;
/*    */   private double field_1_max_change;
/*    */   
/*    */   public DeltaRecord(double paramDouble) {
/* 36 */     this.field_1_max_change = paramDouble;
/*    */   }
/*    */   
/*    */   public DeltaRecord(RecordInputStream paramRecordInputStream) {
/* 40 */     this.field_1_max_change = paramRecordInputStream.readDouble();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public double getMaxChange() {
/* 48 */     return this.field_1_max_change;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 52 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 54 */     stringBuffer.append("[DELTA]\n");
/* 55 */     stringBuffer.append("    .maxchange = ").append(getMaxChange()).append("\n");
/* 56 */     stringBuffer.append("[/DELTA]\n");
/* 57 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 61 */     paramLittleEndianOutput.writeDouble(getMaxChange());
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 65 */     return 8;
/*    */   }
/*    */   
/*    */   public short getSid() {
/* 69 */     return 16;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public DeltaRecord clone() {
/* 75 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\DeltaRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */