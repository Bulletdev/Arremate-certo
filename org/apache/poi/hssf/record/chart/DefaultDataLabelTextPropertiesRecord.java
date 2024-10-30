/*     */ package org.apache.poi.hssf.record.chart;
/*     */ 
/*     */ import org.apache.poi.hssf.record.RecordInputStream;
/*     */ import org.apache.poi.hssf.record.StandardRecord;
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
/*     */ public final class DefaultDataLabelTextPropertiesRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 4132;
/*     */   private short field_1_categoryDataType;
/*     */   public static final short CATEGORY_DATA_TYPE_SHOW_LABELS_CHARACTERISTIC = 0;
/*     */   public static final short CATEGORY_DATA_TYPE_VALUE_AND_PERCENTAGE_CHARACTERISTIC = 1;
/*     */   public static final short CATEGORY_DATA_TYPE_ALL_TEXT_CHARACTERISTIC = 2;
/*     */   
/*     */   public DefaultDataLabelTextPropertiesRecord() {}
/*     */   
/*     */   public DefaultDataLabelTextPropertiesRecord(RecordInputStream paramRecordInputStream) {
/*  43 */     this.field_1_categoryDataType = paramRecordInputStream.readShort();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  48 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  50 */     stringBuffer.append("[DEFAULTTEXT]\n");
/*  51 */     stringBuffer.append("    .categoryDataType     = ").append("0x").append(HexDump.toHex(getCategoryDataType())).append(" (").append(getCategoryDataType()).append(" )");
/*     */ 
/*     */     
/*  54 */     stringBuffer.append(System.getProperty("line.separator"));
/*     */     
/*  56 */     stringBuffer.append("[/DEFAULTTEXT]\n");
/*  57 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  61 */     paramLittleEndianOutput.writeShort(this.field_1_categoryDataType);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/*  65 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/*  70 */     return 4132;
/*     */   }
/*     */ 
/*     */   
/*     */   public DefaultDataLabelTextPropertiesRecord clone() {
/*  75 */     DefaultDataLabelTextPropertiesRecord defaultDataLabelTextPropertiesRecord = new DefaultDataLabelTextPropertiesRecord();
/*     */     
/*  77 */     defaultDataLabelTextPropertiesRecord.field_1_categoryDataType = this.field_1_categoryDataType;
/*  78 */     return defaultDataLabelTextPropertiesRecord;
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
/*     */   public short getCategoryDataType() {
/*  94 */     return this.field_1_categoryDataType;
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
/*     */   public void setCategoryDataType(short paramShort) {
/* 108 */     this.field_1_categoryDataType = paramShort;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\DefaultDataLabelTextPropertiesRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */