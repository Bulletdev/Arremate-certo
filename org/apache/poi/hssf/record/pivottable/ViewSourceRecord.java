/*    */ package org.apache.poi.hssf.record.pivottable;
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
/*    */ public final class ViewSourceRecord
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 227;
/*    */   private int vs;
/*    */   
/*    */   public ViewSourceRecord(RecordInputStream paramRecordInputStream) {
/* 36 */     this.vs = paramRecordInputStream.readShort();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 41 */     paramLittleEndianOutput.writeShort(this.vs);
/*    */   }
/*    */ 
/*    */   
/*    */   protected int getDataSize() {
/* 46 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 51 */     return 227;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 56 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 58 */     stringBuffer.append("[SXVS]\n");
/* 59 */     stringBuffer.append("    .vs      =").append(HexDump.shortToHex(this.vs)).append('\n');
/*    */     
/* 61 */     stringBuffer.append("[/SXVS]\n");
/* 62 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\pivottable\ViewSourceRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */