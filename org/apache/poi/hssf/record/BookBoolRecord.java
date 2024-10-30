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
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class BookBoolRecord
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 218;
/*    */   private short field_1_save_link_values;
/*    */   
/*    */   public BookBoolRecord() {}
/*    */   
/*    */   public BookBoolRecord(RecordInputStream paramRecordInputStream) {
/* 45 */     this.field_1_save_link_values = paramRecordInputStream.readShort();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setSaveLinkValues(short paramShort) {
/* 56 */     this.field_1_save_link_values = paramShort;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public short getSaveLinkValues() {
/* 67 */     return this.field_1_save_link_values;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 72 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 74 */     stringBuffer.append("[BOOKBOOL]\n");
/* 75 */     stringBuffer.append("    .savelinkvalues  = ").append(Integer.toHexString(getSaveLinkValues())).append("\n");
/*    */     
/* 77 */     stringBuffer.append("[/BOOKBOOL]\n");
/* 78 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 82 */     paramLittleEndianOutput.writeShort(this.field_1_save_link_values);
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 86 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 91 */     return 218;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\BookBoolRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */