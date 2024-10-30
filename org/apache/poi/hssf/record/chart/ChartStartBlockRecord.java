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
/*    */ public final class ChartStartBlockRecord
/*    */   extends StandardRecord
/*    */   implements Cloneable
/*    */ {
/*    */   public static final short sid = 2130;
/*    */   private short rt;
/*    */   private short grbitFrt;
/*    */   private short iObjectKind;
/*    */   private short iObjectContext;
/*    */   private short iObjectInstance1;
/*    */   private short iObjectInstance2;
/*    */   
/*    */   public ChartStartBlockRecord() {}
/*    */   
/*    */   public ChartStartBlockRecord(RecordInputStream paramRecordInputStream) {
/* 42 */     this.rt = paramRecordInputStream.readShort();
/* 43 */     this.grbitFrt = paramRecordInputStream.readShort();
/* 44 */     this.iObjectKind = paramRecordInputStream.readShort();
/* 45 */     this.iObjectContext = paramRecordInputStream.readShort();
/* 46 */     this.iObjectInstance1 = paramRecordInputStream.readShort();
/* 47 */     this.iObjectInstance2 = paramRecordInputStream.readShort();
/*    */   }
/*    */ 
/*    */   
/*    */   protected int getDataSize() {
/* 52 */     return 12;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 57 */     return 2130;
/*    */   }
/*    */ 
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 62 */     paramLittleEndianOutput.writeShort(this.rt);
/* 63 */     paramLittleEndianOutput.writeShort(this.grbitFrt);
/* 64 */     paramLittleEndianOutput.writeShort(this.iObjectKind);
/* 65 */     paramLittleEndianOutput.writeShort(this.iObjectContext);
/* 66 */     paramLittleEndianOutput.writeShort(this.iObjectInstance1);
/* 67 */     paramLittleEndianOutput.writeShort(this.iObjectInstance2);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 72 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 74 */     stringBuffer.append("[STARTBLOCK]\n");
/* 75 */     stringBuffer.append("    .rt              =").append(HexDump.shortToHex(this.rt)).append('\n');
/* 76 */     stringBuffer.append("    .grbitFrt        =").append(HexDump.shortToHex(this.grbitFrt)).append('\n');
/* 77 */     stringBuffer.append("    .iObjectKind     =").append(HexDump.shortToHex(this.iObjectKind)).append('\n');
/* 78 */     stringBuffer.append("    .iObjectContext  =").append(HexDump.shortToHex(this.iObjectContext)).append('\n');
/* 79 */     stringBuffer.append("    .iObjectInstance1=").append(HexDump.shortToHex(this.iObjectInstance1)).append('\n');
/* 80 */     stringBuffer.append("    .iObjectInstance2=").append(HexDump.shortToHex(this.iObjectInstance2)).append('\n');
/* 81 */     stringBuffer.append("[/STARTBLOCK]\n");
/* 82 */     return stringBuffer.toString();
/*    */   }
/*    */ 
/*    */   
/*    */   public ChartStartBlockRecord clone() {
/* 87 */     ChartStartBlockRecord chartStartBlockRecord = new ChartStartBlockRecord();
/*    */     
/* 89 */     chartStartBlockRecord.rt = this.rt;
/* 90 */     chartStartBlockRecord.grbitFrt = this.grbitFrt;
/* 91 */     chartStartBlockRecord.iObjectKind = this.iObjectKind;
/* 92 */     chartStartBlockRecord.iObjectContext = this.iObjectContext;
/* 93 */     chartStartBlockRecord.iObjectInstance1 = this.iObjectInstance1;
/* 94 */     chartStartBlockRecord.iObjectInstance2 = this.iObjectInstance2;
/*    */     
/* 96 */     return chartStartBlockRecord;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\ChartStartBlockRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */