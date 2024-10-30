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
/*    */ public final class DataLabelExtensionRecord
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 2154;
/*    */   private int rt;
/*    */   private int grbitFrt;
/* 33 */   private byte[] unused = new byte[8];
/*    */   
/*    */   public DataLabelExtensionRecord(RecordInputStream paramRecordInputStream) {
/* 36 */     this.rt = paramRecordInputStream.readShort();
/* 37 */     this.grbitFrt = paramRecordInputStream.readShort();
/* 38 */     paramRecordInputStream.readFully(this.unused);
/*    */   }
/*    */ 
/*    */   
/*    */   protected int getDataSize() {
/* 43 */     return 12;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 48 */     return 2154;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 53 */     paramLittleEndianOutput.writeShort(this.rt);
/* 54 */     paramLittleEndianOutput.writeShort(this.grbitFrt);
/* 55 */     paramLittleEndianOutput.write(this.unused);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 60 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 62 */     stringBuffer.append("[DATALABEXT]\n");
/* 63 */     stringBuffer.append("    .rt      =").append(HexDump.shortToHex(this.rt)).append('\n');
/* 64 */     stringBuffer.append("    .grbitFrt=").append(HexDump.shortToHex(this.grbitFrt)).append('\n');
/* 65 */     stringBuffer.append("    .unused  =").append(HexDump.toHex(this.unused)).append('\n');
/*    */     
/* 67 */     stringBuffer.append("[/DATALABEXT]\n");
/* 68 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\DataLabelExtensionRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */