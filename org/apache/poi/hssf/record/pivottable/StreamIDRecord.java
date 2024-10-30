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
/*    */ public final class StreamIDRecord
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 213;
/*    */   private int idstm;
/*    */   
/*    */   public StreamIDRecord(RecordInputStream paramRecordInputStream) {
/* 36 */     this.idstm = paramRecordInputStream.readShort();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 41 */     paramLittleEndianOutput.writeShort(this.idstm);
/*    */   }
/*    */ 
/*    */   
/*    */   protected int getDataSize() {
/* 46 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 51 */     return 213;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 56 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 58 */     stringBuffer.append("[SXIDSTM]\n");
/* 59 */     stringBuffer.append("    .idstm      =").append(HexDump.shortToHex(this.idstm)).append('\n');
/*    */     
/* 61 */     stringBuffer.append("[/SXIDSTM]\n");
/* 62 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\pivottable\StreamIDRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */