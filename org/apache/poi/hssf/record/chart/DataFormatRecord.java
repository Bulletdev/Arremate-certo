/*     */ package org.apache.poi.hssf.record.chart;
/*     */ 
/*     */ import org.apache.poi.hssf.record.RecordInputStream;
/*     */ import org.apache.poi.hssf.record.StandardRecord;
/*     */ import org.apache.poi.util.BitField;
/*     */ import org.apache.poi.util.BitFieldFactory;
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
/*     */ public final class DataFormatRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 4102;
/*  33 */   private static final BitField useExcel4Colors = BitFieldFactory.getInstance(1);
/*     */   
/*     */   private short field_1_pointNumber;
/*     */   
/*     */   private short field_2_seriesIndex;
/*     */   
/*     */   private short field_3_seriesNumber;
/*     */   
/*     */   private short field_4_formatFlags;
/*     */ 
/*     */   
/*     */   public DataFormatRecord() {}
/*     */ 
/*     */   
/*     */   public DataFormatRecord(RecordInputStream paramRecordInputStream) {
/*  48 */     this.field_1_pointNumber = paramRecordInputStream.readShort();
/*  49 */     this.field_2_seriesIndex = paramRecordInputStream.readShort();
/*  50 */     this.field_3_seriesNumber = paramRecordInputStream.readShort();
/*  51 */     this.field_4_formatFlags = paramRecordInputStream.readShort();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  56 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  58 */     stringBuffer.append("[DATAFORMAT]\n");
/*  59 */     stringBuffer.append("    .pointNumber          = ").append("0x").append(HexDump.toHex(getPointNumber())).append(" (").append(getPointNumber()).append(" )");
/*     */ 
/*     */     
/*  62 */     stringBuffer.append(System.getProperty("line.separator"));
/*  63 */     stringBuffer.append("    .seriesIndex          = ").append("0x").append(HexDump.toHex(getSeriesIndex())).append(" (").append(getSeriesIndex()).append(" )");
/*     */ 
/*     */     
/*  66 */     stringBuffer.append(System.getProperty("line.separator"));
/*  67 */     stringBuffer.append("    .seriesNumber         = ").append("0x").append(HexDump.toHex(getSeriesNumber())).append(" (").append(getSeriesNumber()).append(" )");
/*     */ 
/*     */     
/*  70 */     stringBuffer.append(System.getProperty("line.separator"));
/*  71 */     stringBuffer.append("    .formatFlags          = ").append("0x").append(HexDump.toHex(getFormatFlags())).append(" (").append(getFormatFlags()).append(" )");
/*     */ 
/*     */     
/*  74 */     stringBuffer.append(System.getProperty("line.separator"));
/*  75 */     stringBuffer.append("         .useExcel4Colors          = ").append(isUseExcel4Colors()).append('\n');
/*     */     
/*  77 */     stringBuffer.append("[/DATAFORMAT]\n");
/*  78 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  82 */     paramLittleEndianOutput.writeShort(this.field_1_pointNumber);
/*  83 */     paramLittleEndianOutput.writeShort(this.field_2_seriesIndex);
/*  84 */     paramLittleEndianOutput.writeShort(this.field_3_seriesNumber);
/*  85 */     paramLittleEndianOutput.writeShort(this.field_4_formatFlags);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/*  89 */     return 8;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/*  94 */     return 4102;
/*     */   }
/*     */ 
/*     */   
/*     */   public DataFormatRecord clone() {
/*  99 */     DataFormatRecord dataFormatRecord = new DataFormatRecord();
/*     */     
/* 101 */     dataFormatRecord.field_1_pointNumber = this.field_1_pointNumber;
/* 102 */     dataFormatRecord.field_2_seriesIndex = this.field_2_seriesIndex;
/* 103 */     dataFormatRecord.field_3_seriesNumber = this.field_3_seriesNumber;
/* 104 */     dataFormatRecord.field_4_formatFlags = this.field_4_formatFlags;
/* 105 */     return dataFormatRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getPointNumber() {
/* 116 */     return this.field_1_pointNumber;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPointNumber(short paramShort) {
/* 124 */     this.field_1_pointNumber = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getSeriesIndex() {
/* 132 */     return this.field_2_seriesIndex;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSeriesIndex(short paramShort) {
/* 140 */     this.field_2_seriesIndex = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getSeriesNumber() {
/* 148 */     return this.field_3_seriesNumber;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSeriesNumber(short paramShort) {
/* 156 */     this.field_3_seriesNumber = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getFormatFlags() {
/* 164 */     return this.field_4_formatFlags;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFormatFlags(short paramShort) {
/* 172 */     this.field_4_formatFlags = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUseExcel4Colors(boolean paramBoolean) {
/* 181 */     this.field_4_formatFlags = useExcel4Colors.setShortBoolean(this.field_4_formatFlags, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUseExcel4Colors() {
/* 190 */     return useExcel4Colors.isSet(this.field_4_formatFlags);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\DataFormatRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */