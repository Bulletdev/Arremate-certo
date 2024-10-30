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
/*    */ public final class ChartEndObjectRecord
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 2133;
/*    */   private short rt;
/*    */   private short grbitFrt;
/*    */   private short iObjectKind;
/*    */   private byte[] reserved;
/*    */   
/*    */   public ChartEndObjectRecord(RecordInputStream paramRecordInputStream) {
/* 37 */     this.rt = paramRecordInputStream.readShort();
/* 38 */     this.grbitFrt = paramRecordInputStream.readShort();
/* 39 */     this.iObjectKind = paramRecordInputStream.readShort();
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 44 */     this.reserved = new byte[6];
/* 45 */     if (paramRecordInputStream.available() != 0)
/*    */     {
/*    */ 
/*    */       
/* 49 */       paramRecordInputStream.readFully(this.reserved);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   protected int getDataSize() {
/* 55 */     return 12;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 60 */     return 2133;
/*    */   }
/*    */ 
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 65 */     paramLittleEndianOutput.writeShort(this.rt);
/* 66 */     paramLittleEndianOutput.writeShort(this.grbitFrt);
/* 67 */     paramLittleEndianOutput.writeShort(this.iObjectKind);
/*    */     
/* 69 */     paramLittleEndianOutput.write(this.reserved);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 74 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 76 */     stringBuffer.append("[ENDOBJECT]\n");
/* 77 */     stringBuffer.append("    .rt         =").append(HexDump.shortToHex(this.rt)).append('\n');
/* 78 */     stringBuffer.append("    .grbitFrt   =").append(HexDump.shortToHex(this.grbitFrt)).append('\n');
/* 79 */     stringBuffer.append("    .iObjectKind=").append(HexDump.shortToHex(this.iObjectKind)).append('\n');
/* 80 */     stringBuffer.append("    .reserved   =").append(HexDump.toHex(this.reserved)).append('\n');
/* 81 */     stringBuffer.append("[/ENDOBJECT]\n");
/* 82 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\ChartEndObjectRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */