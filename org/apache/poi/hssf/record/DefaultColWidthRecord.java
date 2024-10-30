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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class DefaultColWidthRecord
/*    */   extends StandardRecord
/*    */   implements Cloneable
/*    */ {
/*    */   public static final short sid = 85;
/*    */   private int field_1_col_width;
/*    */   public static final int DEFAULT_COLUMN_WIDTH = 8;
/*    */   
/*    */   public DefaultColWidthRecord() {
/* 42 */     this.field_1_col_width = 8;
/*    */   }
/*    */ 
/*    */   
/*    */   public DefaultColWidthRecord(RecordInputStream paramRecordInputStream) {
/* 47 */     this.field_1_col_width = paramRecordInputStream.readUShort();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setColWidth(int paramInt) {
/* 57 */     this.field_1_col_width = paramInt;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getColWidth() {
/* 67 */     return this.field_1_col_width;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 72 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 74 */     stringBuffer.append("[DEFAULTCOLWIDTH]\n");
/* 75 */     stringBuffer.append("    .colwidth      = ").append(Integer.toHexString(getColWidth())).append("\n");
/*    */     
/* 77 */     stringBuffer.append("[/DEFAULTCOLWIDTH]\n");
/* 78 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 82 */     paramLittleEndianOutput.writeShort(getColWidth());
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 86 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 91 */     return 85;
/*    */   }
/*    */ 
/*    */   
/*    */   public DefaultColWidthRecord clone() {
/* 96 */     DefaultColWidthRecord defaultColWidthRecord = new DefaultColWidthRecord();
/* 97 */     defaultColWidthRecord.field_1_col_width = this.field_1_col_width;
/* 98 */     return defaultColWidthRecord;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\DefaultColWidthRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */