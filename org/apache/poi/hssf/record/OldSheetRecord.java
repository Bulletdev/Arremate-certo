/*    */ package org.apache.poi.hssf.record;
/*    */ 
/*    */ import org.apache.poi.util.HexDump;
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
/*    */ public final class OldSheetRecord
/*    */ {
/*    */   public static final short sid = 133;
/*    */   private int field_1_position_of_BOF;
/*    */   private int field_2_visibility;
/*    */   private int field_3_type;
/*    */   private byte[] field_5_sheetname;
/*    */   private CodepageRecord codepage;
/*    */   
/*    */   public OldSheetRecord(RecordInputStream paramRecordInputStream) {
/* 38 */     this.field_1_position_of_BOF = paramRecordInputStream.readInt();
/* 39 */     this.field_2_visibility = paramRecordInputStream.readUByte();
/* 40 */     this.field_3_type = paramRecordInputStream.readUByte();
/* 41 */     int i = paramRecordInputStream.readUByte();
/* 42 */     this.field_5_sheetname = new byte[i];
/* 43 */     paramRecordInputStream.read(this.field_5_sheetname, 0, i);
/*    */   }
/*    */   
/*    */   public void setCodePage(CodepageRecord paramCodepageRecord) {
/* 47 */     this.codepage = paramCodepageRecord;
/*    */   }
/*    */   
/*    */   public short getSid() {
/* 51 */     return 133;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getPositionOfBof() {
/* 60 */     return this.field_1_position_of_BOF;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getSheetname() {
/* 68 */     return OldStringRecord.getString(this.field_5_sheetname, this.codepage);
/*    */   }
/*    */   
/*    */   public String toString() {
/* 72 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 74 */     stringBuffer.append("[BOUNDSHEET]\n");
/* 75 */     stringBuffer.append("    .bof        = ").append(HexDump.intToHex(getPositionOfBof())).append("\n");
/* 76 */     stringBuffer.append("    .visibility = ").append(HexDump.shortToHex(this.field_2_visibility)).append("\n");
/* 77 */     stringBuffer.append("    .type       = ").append(HexDump.byteToHex(this.field_3_type)).append("\n");
/* 78 */     stringBuffer.append("    .sheetname  = ").append(getSheetname()).append("\n");
/* 79 */     stringBuffer.append("[/BOUNDSHEET]\n");
/* 80 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\OldSheetRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */