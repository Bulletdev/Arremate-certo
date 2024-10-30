/*    */ package org.apache.poi.hssf.record.chart;
/*    */ 
/*    */ import org.apache.poi.hssf.record.RecordInputStream;
/*    */ import org.apache.poi.hssf.record.StandardRecord;
/*    */ import org.apache.poi.util.HexDump;
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
/*    */ public final class FontIndexRecord
/*    */   extends StandardRecord
/*    */   implements Cloneable
/*    */ {
/*    */   public static final short sid = 4134;
/*    */   private short field_1_fontIndex;
/*    */   
/*    */   public FontIndexRecord() {}
/*    */   
/*    */   public FontIndexRecord(RecordInputStream paramRecordInputStream) {
/* 42 */     this.field_1_fontIndex = paramRecordInputStream.readShort();
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 47 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 49 */     stringBuffer.append("[FONTX]\n");
/* 50 */     stringBuffer.append("    .fontIndex            = ").append("0x").append(HexDump.toHex(getFontIndex())).append(" (").append(getFontIndex()).append(" )");
/*    */ 
/*    */     
/* 53 */     stringBuffer.append(System.getProperty("line.separator"));
/*    */     
/* 55 */     stringBuffer.append("[/FONTX]\n");
/* 56 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 60 */     paramLittleEndianOutput.writeShort(this.field_1_fontIndex);
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 64 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 69 */     return 4134;
/*    */   }
/*    */ 
/*    */   
/*    */   public FontIndexRecord clone() {
/* 74 */     FontIndexRecord fontIndexRecord = new FontIndexRecord();
/*    */     
/* 76 */     fontIndexRecord.field_1_fontIndex = this.field_1_fontIndex;
/* 77 */     return fontIndexRecord;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public short getFontIndex() {
/* 88 */     return this.field_1_fontIndex;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setFontIndex(short paramShort) {
/* 96 */     this.field_1_fontIndex = paramShort;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\FontIndexRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */