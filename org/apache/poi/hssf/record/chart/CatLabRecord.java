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
/*    */ public final class CatLabRecord
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 2134;
/*    */   private short rt;
/*    */   private short grbitFrt;
/*    */   private short wOffset;
/*    */   private short at;
/*    */   private short grbit;
/*    */   private Short unused;
/*    */   
/*    */   public CatLabRecord(RecordInputStream paramRecordInputStream) {
/* 41 */     this.rt = paramRecordInputStream.readShort();
/* 42 */     this.grbitFrt = paramRecordInputStream.readShort();
/* 43 */     this.wOffset = paramRecordInputStream.readShort();
/* 44 */     this.at = paramRecordInputStream.readShort();
/* 45 */     this.grbit = paramRecordInputStream.readShort();
/*    */ 
/*    */     
/* 48 */     if (paramRecordInputStream.available() == 0) {
/* 49 */       this.unused = null;
/*    */     } else {
/* 51 */       this.unused = Short.valueOf(paramRecordInputStream.readShort());
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected int getDataSize() {
/* 57 */     return 10 + ((this.unused == null) ? 0 : 2);
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 62 */     return 2134;
/*    */   }
/*    */ 
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 67 */     paramLittleEndianOutput.writeShort(this.rt);
/* 68 */     paramLittleEndianOutput.writeShort(this.grbitFrt);
/* 69 */     paramLittleEndianOutput.writeShort(this.wOffset);
/* 70 */     paramLittleEndianOutput.writeShort(this.at);
/* 71 */     paramLittleEndianOutput.writeShort(this.grbit);
/* 72 */     if (this.unused != null) {
/* 73 */       paramLittleEndianOutput.writeShort(this.unused.shortValue());
/*    */     }
/*    */   }
/*    */   
/*    */   public String toString() {
/* 78 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 80 */     stringBuffer.append("[CATLAB]\n");
/* 81 */     stringBuffer.append("    .rt      =").append(HexDump.shortToHex(this.rt)).append('\n');
/* 82 */     stringBuffer.append("    .grbitFrt=").append(HexDump.shortToHex(this.grbitFrt)).append('\n');
/* 83 */     stringBuffer.append("    .wOffset =").append(HexDump.shortToHex(this.wOffset)).append('\n');
/* 84 */     stringBuffer.append("    .at      =").append(HexDump.shortToHex(this.at)).append('\n');
/* 85 */     stringBuffer.append("    .grbit   =").append(HexDump.shortToHex(this.grbit)).append('\n');
/* 86 */     if (this.unused != null) {
/* 87 */       stringBuffer.append("    .unused  =").append(HexDump.shortToHex(this.unused.shortValue())).append('\n');
/*    */     }
/* 89 */     stringBuffer.append("[/CATLAB]\n");
/* 90 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\CatLabRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */