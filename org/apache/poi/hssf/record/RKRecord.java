/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.hssf.util.RKUtil;
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
/*     */ public final class RKRecord
/*     */   extends CellRecord
/*     */ {
/*     */   public static final short sid = 638;
/*     */   public static final short RK_IEEE_NUMBER = 0;
/*     */   public static final short RK_IEEE_NUMBER_TIMES_100 = 1;
/*     */   public static final short RK_INTEGER = 2;
/*     */   public static final short RK_INTEGER_TIMES_100 = 3;
/*     */   private int field_4_rk_number;
/*     */   
/*     */   private RKRecord() {}
/*     */   
/*     */   public RKRecord(RecordInputStream paramRecordInputStream) {
/*  49 */     super(paramRecordInputStream);
/*  50 */     this.field_4_rk_number = paramRecordInputStream.readInt();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getRKNumber() {
/*  71 */     return RKUtil.decodeNumber(this.field_4_rk_number);
/*     */   }
/*     */ 
/*     */   
/*     */   protected String getRecordName() {
/*  76 */     return "RK";
/*     */   }
/*     */ 
/*     */   
/*     */   protected void appendValueText(StringBuilder paramStringBuilder) {
/*  81 */     paramStringBuilder.append("  .value= ").append(getRKNumber());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void serializeValue(LittleEndianOutput paramLittleEndianOutput) {
/*  86 */     paramLittleEndianOutput.writeInt(this.field_4_rk_number);
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getValueDataSize() {
/*  91 */     return 4;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/*  96 */     return 638;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object clone() {
/* 101 */     RKRecord rKRecord = new RKRecord();
/* 102 */     copyBaseFields(rKRecord);
/* 103 */     rKRecord.field_4_rk_number = this.field_4_rk_number;
/* 104 */     return rKRecord;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\RKRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */