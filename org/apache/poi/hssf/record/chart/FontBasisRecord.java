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
/*     */ public final class FontBasisRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 4192;
/*     */   private short field_1_xBasis;
/*     */   private short field_2_yBasis;
/*     */   private short field_3_heightBasis;
/*     */   private short field_4_scale;
/*     */   private short field_5_indexToFontTable;
/*     */   
/*     */   public FontBasisRecord() {}
/*     */   
/*     */   public FontBasisRecord(RecordInputStream paramRecordInputStream) {
/*  44 */     this.field_1_xBasis = paramRecordInputStream.readShort();
/*  45 */     this.field_2_yBasis = paramRecordInputStream.readShort();
/*  46 */     this.field_3_heightBasis = paramRecordInputStream.readShort();
/*  47 */     this.field_4_scale = paramRecordInputStream.readShort();
/*  48 */     this.field_5_indexToFontTable = paramRecordInputStream.readShort();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  53 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  55 */     stringBuffer.append("[FBI]\n");
/*  56 */     stringBuffer.append("    .xBasis               = ").append("0x").append(HexDump.toHex(getXBasis())).append(" (").append(getXBasis()).append(" )");
/*     */ 
/*     */     
/*  59 */     stringBuffer.append(System.getProperty("line.separator"));
/*  60 */     stringBuffer.append("    .yBasis               = ").append("0x").append(HexDump.toHex(getYBasis())).append(" (").append(getYBasis()).append(" )");
/*     */ 
/*     */     
/*  63 */     stringBuffer.append(System.getProperty("line.separator"));
/*  64 */     stringBuffer.append("    .heightBasis          = ").append("0x").append(HexDump.toHex(getHeightBasis())).append(" (").append(getHeightBasis()).append(" )");
/*     */ 
/*     */     
/*  67 */     stringBuffer.append(System.getProperty("line.separator"));
/*  68 */     stringBuffer.append("    .scale                = ").append("0x").append(HexDump.toHex(getScale())).append(" (").append(getScale()).append(" )");
/*     */ 
/*     */     
/*  71 */     stringBuffer.append(System.getProperty("line.separator"));
/*  72 */     stringBuffer.append("    .indexToFontTable     = ").append("0x").append(HexDump.toHex(getIndexToFontTable())).append(" (").append(getIndexToFontTable()).append(" )");
/*     */ 
/*     */     
/*  75 */     stringBuffer.append(System.getProperty("line.separator"));
/*     */     
/*  77 */     stringBuffer.append("[/FBI]\n");
/*  78 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  82 */     paramLittleEndianOutput.writeShort(this.field_1_xBasis);
/*  83 */     paramLittleEndianOutput.writeShort(this.field_2_yBasis);
/*  84 */     paramLittleEndianOutput.writeShort(this.field_3_heightBasis);
/*  85 */     paramLittleEndianOutput.writeShort(this.field_4_scale);
/*  86 */     paramLittleEndianOutput.writeShort(this.field_5_indexToFontTable);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/*  90 */     return 10;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/*  95 */     return 4192;
/*     */   }
/*     */ 
/*     */   
/*     */   public FontBasisRecord clone() {
/* 100 */     FontBasisRecord fontBasisRecord = new FontBasisRecord();
/*     */     
/* 102 */     fontBasisRecord.field_1_xBasis = this.field_1_xBasis;
/* 103 */     fontBasisRecord.field_2_yBasis = this.field_2_yBasis;
/* 104 */     fontBasisRecord.field_3_heightBasis = this.field_3_heightBasis;
/* 105 */     fontBasisRecord.field_4_scale = this.field_4_scale;
/* 106 */     fontBasisRecord.field_5_indexToFontTable = this.field_5_indexToFontTable;
/* 107 */     return fontBasisRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getXBasis() {
/* 118 */     return this.field_1_xBasis;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setXBasis(short paramShort) {
/* 126 */     this.field_1_xBasis = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getYBasis() {
/* 134 */     return this.field_2_yBasis;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setYBasis(short paramShort) {
/* 142 */     this.field_2_yBasis = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getHeightBasis() {
/* 150 */     return this.field_3_heightBasis;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHeightBasis(short paramShort) {
/* 158 */     this.field_3_heightBasis = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getScale() {
/* 166 */     return this.field_4_scale;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setScale(short paramShort) {
/* 174 */     this.field_4_scale = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getIndexToFontTable() {
/* 182 */     return this.field_5_indexToFontTable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIndexToFontTable(short paramShort) {
/* 190 */     this.field_5_indexToFontTable = paramShort;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\FontBasisRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */