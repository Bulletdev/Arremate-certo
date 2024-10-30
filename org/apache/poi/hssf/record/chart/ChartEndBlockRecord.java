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
/*    */ 
/*    */ 
/*    */ public final class ChartEndBlockRecord
/*    */   extends StandardRecord
/*    */   implements Cloneable
/*    */ {
/*    */   public static final short sid = 2131;
/*    */   private short rt;
/*    */   private short grbitFrt;
/*    */   private short iObjectKind;
/*    */   private byte[] unused;
/*    */   
/*    */   public ChartEndBlockRecord() {}
/*    */   
/*    */   public ChartEndBlockRecord(RecordInputStream paramRecordInputStream) {
/* 42 */     this.rt = paramRecordInputStream.readShort();
/* 43 */     this.grbitFrt = paramRecordInputStream.readShort();
/* 44 */     this.iObjectKind = paramRecordInputStream.readShort();
/*    */ 
/*    */     
/* 47 */     if (paramRecordInputStream.available() == 0) {
/* 48 */       this.unused = new byte[0];
/*    */     } else {
/* 50 */       this.unused = new byte[6];
/* 51 */       paramRecordInputStream.readFully(this.unused);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected int getDataSize() {
/* 57 */     return 6 + this.unused.length;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 62 */     return 2131;
/*    */   }
/*    */ 
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 67 */     paramLittleEndianOutput.writeShort(this.rt);
/* 68 */     paramLittleEndianOutput.writeShort(this.grbitFrt);
/* 69 */     paramLittleEndianOutput.writeShort(this.iObjectKind);
/*    */     
/* 71 */     paramLittleEndianOutput.write(this.unused);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 76 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 78 */     stringBuffer.append("[ENDBLOCK]\n");
/* 79 */     stringBuffer.append("    .rt         =").append(HexDump.shortToHex(this.rt)).append('\n');
/* 80 */     stringBuffer.append("    .grbitFrt   =").append(HexDump.shortToHex(this.grbitFrt)).append('\n');
/* 81 */     stringBuffer.append("    .iObjectKind=").append(HexDump.shortToHex(this.iObjectKind)).append('\n');
/* 82 */     stringBuffer.append("    .unused     =").append(HexDump.toHex(this.unused)).append('\n');
/* 83 */     stringBuffer.append("[/ENDBLOCK]\n");
/* 84 */     return stringBuffer.toString();
/*    */   }
/*    */ 
/*    */   
/*    */   public ChartEndBlockRecord clone() {
/* 89 */     ChartEndBlockRecord chartEndBlockRecord = new ChartEndBlockRecord();
/*    */     
/* 91 */     chartEndBlockRecord.rt = this.rt;
/* 92 */     chartEndBlockRecord.grbitFrt = this.grbitFrt;
/* 93 */     chartEndBlockRecord.iObjectKind = this.iObjectKind;
/* 94 */     chartEndBlockRecord.unused = (byte[])this.unused.clone();
/*    */     
/* 96 */     return chartEndBlockRecord;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\ChartEndBlockRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */