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
/*    */ public final class DateWindow1904Record
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 34;
/*    */   private short field_1_window;
/*    */   
/*    */   public DateWindow1904Record() {}
/*    */   
/*    */   public DateWindow1904Record(RecordInputStream paramRecordInputStream) {
/* 45 */     this.field_1_window = paramRecordInputStream.readShort();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setWindowing(short paramShort) {
/* 55 */     this.field_1_window = paramShort;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public short getWindowing() {
/* 65 */     return this.field_1_window;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 70 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 72 */     stringBuffer.append("[1904]\n");
/* 73 */     stringBuffer.append("    .is1904          = ").append(Integer.toHexString(getWindowing())).append("\n");
/*    */     
/* 75 */     stringBuffer.append("[/1904]\n");
/* 76 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 80 */     paramLittleEndianOutput.writeShort(getWindowing());
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 84 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 89 */     return 34;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\DateWindow1904Record.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */