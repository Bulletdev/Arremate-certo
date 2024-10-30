/*    */ package org.apache.poi.hssf.record.pivottable;
/*    */ 
/*    */ import org.apache.poi.hssf.record.RecordInputStream;
/*    */ import org.apache.poi.hssf.record.StandardRecord;
/*    */ import org.apache.poi.util.HexDump;
/*    */ import org.apache.poi.util.LittleEndianOutput;
/*    */ import org.apache.poi.util.StringUtil;
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
/*    */ public final class DataItemRecord
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 197;
/*    */   private int isxvdData;
/*    */   private int iiftab;
/*    */   private int df;
/*    */   private int isxvd;
/*    */   private int isxvi;
/*    */   private int ifmt;
/*    */   private String name;
/*    */   
/*    */   public DataItemRecord(RecordInputStream paramRecordInputStream) {
/* 43 */     this.isxvdData = paramRecordInputStream.readUShort();
/* 44 */     this.iiftab = paramRecordInputStream.readUShort();
/* 45 */     this.df = paramRecordInputStream.readUShort();
/* 46 */     this.isxvd = paramRecordInputStream.readUShort();
/* 47 */     this.isxvi = paramRecordInputStream.readUShort();
/* 48 */     this.ifmt = paramRecordInputStream.readUShort();
/*    */     
/* 50 */     this.name = paramRecordInputStream.readString();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 56 */     paramLittleEndianOutput.writeShort(this.isxvdData);
/* 57 */     paramLittleEndianOutput.writeShort(this.iiftab);
/* 58 */     paramLittleEndianOutput.writeShort(this.df);
/* 59 */     paramLittleEndianOutput.writeShort(this.isxvd);
/* 60 */     paramLittleEndianOutput.writeShort(this.isxvi);
/* 61 */     paramLittleEndianOutput.writeShort(this.ifmt);
/*    */     
/* 63 */     StringUtil.writeUnicodeString(paramLittleEndianOutput, this.name);
/*    */   }
/*    */ 
/*    */   
/*    */   protected int getDataSize() {
/* 68 */     return 12 + StringUtil.getEncodedSize(this.name);
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 73 */     return 197;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 78 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 80 */     stringBuffer.append("[SXDI]\n");
/* 81 */     stringBuffer.append("  .isxvdData = ").append(HexDump.shortToHex(this.isxvdData)).append("\n");
/* 82 */     stringBuffer.append("  .iiftab = ").append(HexDump.shortToHex(this.iiftab)).append("\n");
/* 83 */     stringBuffer.append("  .df = ").append(HexDump.shortToHex(this.df)).append("\n");
/* 84 */     stringBuffer.append("  .isxvd = ").append(HexDump.shortToHex(this.isxvd)).append("\n");
/* 85 */     stringBuffer.append("  .isxvi = ").append(HexDump.shortToHex(this.isxvi)).append("\n");
/* 86 */     stringBuffer.append("  .ifmt = ").append(HexDump.shortToHex(this.ifmt)).append("\n");
/* 87 */     stringBuffer.append("[/SXDI]\n");
/* 88 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\pivottable\DataItemRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */