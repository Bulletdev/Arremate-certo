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
/*     */ public final class DefaultRowHeightRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 549;
/*     */   private short field_1_option_flags;
/*     */   private short field_2_row_height;
/*     */   public static final short DEFAULT_ROW_HEIGHT = 255;
/*     */   
/*     */   public DefaultRowHeightRecord() {
/*  46 */     this.field_1_option_flags = 0;
/*  47 */     this.field_2_row_height = 255;
/*     */   }
/*     */ 
/*     */   
/*     */   public DefaultRowHeightRecord(RecordInputStream paramRecordInputStream) {
/*  52 */     this.field_1_option_flags = paramRecordInputStream.readShort();
/*  53 */     this.field_2_row_height = paramRecordInputStream.readShort();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOptionFlags(short paramShort) {
/*  63 */     this.field_1_option_flags = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRowHeight(short paramShort) {
/*  73 */     this.field_2_row_height = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getOptionFlags() {
/*  83 */     return this.field_1_option_flags;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getRowHeight() {
/*  93 */     return this.field_2_row_height;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  98 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 100 */     stringBuffer.append("[DEFAULTROWHEIGHT]\n");
/* 101 */     stringBuffer.append("    .optionflags    = ").append(Integer.toHexString(getOptionFlags())).append("\n");
/*     */     
/* 103 */     stringBuffer.append("    .rowheight      = ").append(Integer.toHexString(getRowHeight())).append("\n");
/*     */     
/* 105 */     stringBuffer.append("[/DEFAULTROWHEIGHT]\n");
/* 106 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 110 */     paramLittleEndianOutput.writeShort(getOptionFlags());
/* 111 */     paramLittleEndianOutput.writeShort(getRowHeight());
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 115 */     return 4;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 120 */     return 549;
/*     */   }
/*     */ 
/*     */   
/*     */   public DefaultRowHeightRecord clone() {
/* 125 */     DefaultRowHeightRecord defaultRowHeightRecord = new DefaultRowHeightRecord();
/* 126 */     defaultRowHeightRecord.field_1_option_flags = this.field_1_option_flags;
/* 127 */     defaultRowHeightRecord.field_2_row_height = this.field_2_row_height;
/* 128 */     return defaultRowHeightRecord;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\DefaultRowHeightRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */