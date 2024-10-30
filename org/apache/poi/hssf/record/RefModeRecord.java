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
/*     */ public final class RefModeRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 15;
/*     */   public static final short USE_A1_MODE = 1;
/*     */   public static final short USE_R1C1_MODE = 0;
/*     */   private short field_1_mode;
/*     */   
/*     */   public RefModeRecord() {}
/*     */   
/*     */   public RefModeRecord(RecordInputStream paramRecordInputStream) {
/*  47 */     this.field_1_mode = paramRecordInputStream.readShort();
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
/*     */   public void setMode(short paramShort) {
/*  60 */     this.field_1_mode = paramShort;
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
/*     */   public short getMode() {
/*  72 */     return this.field_1_mode;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  77 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  79 */     stringBuffer.append("[REFMODE]\n");
/*  80 */     stringBuffer.append("    .mode           = ").append(Integer.toHexString(getMode())).append("\n");
/*     */     
/*  82 */     stringBuffer.append("[/REFMODE]\n");
/*  83 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  87 */     paramLittleEndianOutput.writeShort(getMode());
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/*  91 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/*  96 */     return 15;
/*     */   }
/*     */   
/*     */   public Object clone() {
/* 100 */     RefModeRecord refModeRecord = new RefModeRecord();
/* 101 */     refModeRecord.field_1_mode = this.field_1_mode;
/* 102 */     return refModeRecord;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\RefModeRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */