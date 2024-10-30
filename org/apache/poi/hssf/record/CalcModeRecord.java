/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.util.LittleEndianOutput;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class CalcModeRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 13;
/*     */   public static final short MANUAL = 0;
/*     */   public static final short AUTOMATIC = 1;
/*     */   public static final short AUTOMATIC_EXCEPT_TABLES = -1;
/*     */   private short field_1_calcmode;
/*     */   
/*     */   public CalcModeRecord() {}
/*     */   
/*     */   public CalcModeRecord(RecordInputStream paramRecordInputStream) {
/*  64 */     this.field_1_calcmode = paramRecordInputStream.readShort();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCalcMode(short paramShort) {
/*  79 */     this.field_1_calcmode = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getCalcMode() {
/*  94 */     return this.field_1_calcmode;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  99 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 101 */     stringBuffer.append("[CALCMODE]\n");
/* 102 */     stringBuffer.append("    .calcmode       = ").append(Integer.toHexString(getCalcMode())).append("\n");
/*     */     
/* 104 */     stringBuffer.append("[/CALCMODE]\n");
/* 105 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 109 */     paramLittleEndianOutput.writeShort(getCalcMode());
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 113 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 118 */     return 13;
/*     */   }
/*     */ 
/*     */   
/*     */   public CalcModeRecord clone() {
/* 123 */     CalcModeRecord calcModeRecord = new CalcModeRecord();
/* 124 */     calcModeRecord.field_1_calcmode = this.field_1_calcmode;
/* 125 */     return calcModeRecord;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\CalcModeRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */