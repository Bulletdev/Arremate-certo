/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.util.HexDump;
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
/*     */ public final class SCLRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 160;
/*     */   private short field_1_numerator;
/*     */   private short field_2_denominator;
/*     */   
/*     */   public SCLRecord() {}
/*     */   
/*     */   public SCLRecord(RecordInputStream paramRecordInputStream) {
/*  40 */     this.field_1_numerator = paramRecordInputStream.readShort();
/*  41 */     this.field_2_denominator = paramRecordInputStream.readShort();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  47 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  49 */     stringBuffer.append("[SCL]\n");
/*  50 */     stringBuffer.append("    .numerator            = ").append("0x").append(HexDump.toHex(getNumerator())).append(" (").append(getNumerator()).append(" )");
/*     */ 
/*     */     
/*  53 */     stringBuffer.append(System.getProperty("line.separator"));
/*  54 */     stringBuffer.append("    .denominator          = ").append("0x").append(HexDump.toHex(getDenominator())).append(" (").append(getDenominator()).append(" )");
/*     */ 
/*     */     
/*  57 */     stringBuffer.append(System.getProperty("line.separator"));
/*     */     
/*  59 */     stringBuffer.append("[/SCL]\n");
/*  60 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  65 */     paramLittleEndianOutput.writeShort(this.field_1_numerator);
/*  66 */     paramLittleEndianOutput.writeShort(this.field_2_denominator);
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getDataSize() {
/*  71 */     return 4;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public short getSid() {
/*  77 */     return 160;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object clone() {
/*  82 */     SCLRecord sCLRecord = new SCLRecord();
/*     */     
/*  84 */     sCLRecord.field_1_numerator = this.field_1_numerator;
/*  85 */     sCLRecord.field_2_denominator = this.field_2_denominator;
/*  86 */     return sCLRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getNumerator() {
/*  96 */     return this.field_1_numerator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNumerator(short paramShort) {
/* 106 */     this.field_1_numerator = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getDenominator() {
/* 116 */     return this.field_2_denominator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDenominator(short paramShort) {
/* 126 */     this.field_2_denominator = paramShort;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\SCLRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */