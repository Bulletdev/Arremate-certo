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
/*    */ public final class ChartStartObjectRecord
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 2132;
/*    */   private short rt;
/*    */   private short grbitFrt;
/*    */   private short iObjectKind;
/*    */   private short iObjectContext;
/*    */   private short iObjectInstance1;
/*    */   private short iObjectInstance2;
/*    */   
/*    */   public ChartStartObjectRecord(RecordInputStream paramRecordInputStream) {
/* 39 */     this.rt = paramRecordInputStream.readShort();
/* 40 */     this.grbitFrt = paramRecordInputStream.readShort();
/* 41 */     this.iObjectKind = paramRecordInputStream.readShort();
/* 42 */     this.iObjectContext = paramRecordInputStream.readShort();
/* 43 */     this.iObjectInstance1 = paramRecordInputStream.readShort();
/* 44 */     this.iObjectInstance2 = paramRecordInputStream.readShort();
/*    */   }
/*    */ 
/*    */   
/*    */   protected int getDataSize() {
/* 49 */     return 12;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 54 */     return 2132;
/*    */   }
/*    */ 
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 59 */     paramLittleEndianOutput.writeShort(this.rt);
/* 60 */     paramLittleEndianOutput.writeShort(this.grbitFrt);
/* 61 */     paramLittleEndianOutput.writeShort(this.iObjectKind);
/* 62 */     paramLittleEndianOutput.writeShort(this.iObjectContext);
/* 63 */     paramLittleEndianOutput.writeShort(this.iObjectInstance1);
/* 64 */     paramLittleEndianOutput.writeShort(this.iObjectInstance2);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 69 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 71 */     stringBuffer.append("[STARTOBJECT]\n");
/* 72 */     stringBuffer.append("    .rt              =").append(HexDump.shortToHex(this.rt)).append('\n');
/* 73 */     stringBuffer.append("    .grbitFrt        =").append(HexDump.shortToHex(this.grbitFrt)).append('\n');
/* 74 */     stringBuffer.append("    .iObjectKind     =").append(HexDump.shortToHex(this.iObjectKind)).append('\n');
/* 75 */     stringBuffer.append("    .iObjectContext  =").append(HexDump.shortToHex(this.iObjectContext)).append('\n');
/* 76 */     stringBuffer.append("    .iObjectInstance1=").append(HexDump.shortToHex(this.iObjectInstance1)).append('\n');
/* 77 */     stringBuffer.append("    .iObjectInstance2=").append(HexDump.shortToHex(this.iObjectInstance2)).append('\n');
/* 78 */     stringBuffer.append("[/STARTOBJECT]\n");
/* 79 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\ChartStartObjectRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */