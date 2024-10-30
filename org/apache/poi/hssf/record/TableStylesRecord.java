/*    */ package org.apache.poi.hssf.record;
/*    */ 
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
/*    */ public final class TableStylesRecord
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 2190;
/*    */   private int rt;
/*    */   private int grbitFrt;
/* 32 */   private byte[] unused = new byte[8];
/*    */   
/*    */   private int cts;
/*    */   
/*    */   private String rgchDefListStyle;
/*    */   private String rgchDefPivotStyle;
/*    */   
/*    */   public TableStylesRecord(RecordInputStream paramRecordInputStream) {
/* 40 */     this.rt = paramRecordInputStream.readUShort();
/* 41 */     this.grbitFrt = paramRecordInputStream.readUShort();
/* 42 */     paramRecordInputStream.readFully(this.unused);
/* 43 */     this.cts = paramRecordInputStream.readInt();
/* 44 */     int i = paramRecordInputStream.readUShort();
/* 45 */     int j = paramRecordInputStream.readUShort();
/*    */     
/* 47 */     this.rgchDefListStyle = paramRecordInputStream.readUnicodeLEString(i);
/* 48 */     this.rgchDefPivotStyle = paramRecordInputStream.readUnicodeLEString(j);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 53 */     paramLittleEndianOutput.writeShort(this.rt);
/* 54 */     paramLittleEndianOutput.writeShort(this.grbitFrt);
/* 55 */     paramLittleEndianOutput.write(this.unused);
/* 56 */     paramLittleEndianOutput.writeInt(this.cts);
/*    */     
/* 58 */     paramLittleEndianOutput.writeShort(this.rgchDefListStyle.length());
/* 59 */     paramLittleEndianOutput.writeShort(this.rgchDefPivotStyle.length());
/*    */     
/* 61 */     StringUtil.putUnicodeLE(this.rgchDefListStyle, paramLittleEndianOutput);
/* 62 */     StringUtil.putUnicodeLE(this.rgchDefPivotStyle, paramLittleEndianOutput);
/*    */   }
/*    */ 
/*    */   
/*    */   protected int getDataSize() {
/* 67 */     return 20 + 2 * this.rgchDefListStyle.length() + 2 * this.rgchDefPivotStyle.length();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 73 */     return 2190;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 81 */     stringBuffer.append("[TABLESTYLES]\n");
/* 82 */     stringBuffer.append("    .rt      =").append(HexDump.shortToHex(this.rt)).append('\n');
/* 83 */     stringBuffer.append("    .grbitFrt=").append(HexDump.shortToHex(this.grbitFrt)).append('\n');
/* 84 */     stringBuffer.append("    .unused  =").append(HexDump.toHex(this.unused)).append('\n');
/* 85 */     stringBuffer.append("    .cts=").append(HexDump.intToHex(this.cts)).append('\n');
/* 86 */     stringBuffer.append("    .rgchDefListStyle=").append(this.rgchDefListStyle).append('\n');
/* 87 */     stringBuffer.append("    .rgchDefPivotStyle=").append(this.rgchDefPivotStyle).append('\n');
/*    */     
/* 89 */     stringBuffer.append("[/TABLESTYLES]\n");
/* 90 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\TableStylesRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */