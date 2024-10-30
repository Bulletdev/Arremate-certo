/*     */ package org.apache.poi.hssf.record.chart;
/*     */ 
/*     */ import org.apache.poi.hssf.record.RecordInputStream;
/*     */ import org.apache.poi.hssf.record.StandardRecord;
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.LittleEndianInput;
/*     */ import org.apache.poi.util.LittleEndianOutput;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ChartFRTInfoRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 2128;
/*     */   private short rt;
/*     */   private short grbitFrt;
/*     */   private byte verOriginator;
/*     */   private byte verWriter;
/*     */   private CFRTID[] rgCFRTID;
/*     */   
/*     */   private static final class CFRTID
/*     */   {
/*     */     public static final int ENCODED_SIZE = 4;
/*     */     private int rtFirst;
/*     */     private int rtLast;
/*     */     
/*     */     public CFRTID(LittleEndianInput param1LittleEndianInput) {
/*  44 */       this.rtFirst = param1LittleEndianInput.readShort();
/*  45 */       this.rtLast = param1LittleEndianInput.readShort();
/*     */     }
/*     */     
/*     */     public void serialize(LittleEndianOutput param1LittleEndianOutput) {
/*  49 */       param1LittleEndianOutput.writeShort(this.rtFirst);
/*  50 */       param1LittleEndianOutput.writeShort(this.rtLast);
/*     */     }
/*     */   }
/*     */   
/*     */   public ChartFRTInfoRecord(RecordInputStream paramRecordInputStream) {
/*  55 */     this.rt = paramRecordInputStream.readShort();
/*  56 */     this.grbitFrt = paramRecordInputStream.readShort();
/*  57 */     this.verOriginator = paramRecordInputStream.readByte();
/*  58 */     this.verWriter = paramRecordInputStream.readByte();
/*  59 */     short s = paramRecordInputStream.readShort();
/*     */     
/*  61 */     this.rgCFRTID = new CFRTID[s];
/*  62 */     for (byte b = 0; b < s; b++) {
/*  63 */       this.rgCFRTID[b] = new CFRTID((LittleEndianInput)paramRecordInputStream);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getDataSize() {
/*  69 */     return 8 + this.rgCFRTID.length * 4;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/*  74 */     return 2128;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  80 */     paramLittleEndianOutput.writeShort(this.rt);
/*  81 */     paramLittleEndianOutput.writeShort(this.grbitFrt);
/*  82 */     paramLittleEndianOutput.writeByte(this.verOriginator);
/*  83 */     paramLittleEndianOutput.writeByte(this.verWriter);
/*  84 */     int i = this.rgCFRTID.length;
/*  85 */     paramLittleEndianOutput.writeShort(i);
/*     */     
/*  87 */     for (byte b = 0; b < i; b++) {
/*  88 */       this.rgCFRTID[b].serialize(paramLittleEndianOutput);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  94 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  96 */     stringBuffer.append("[CHARTFRTINFO]\n");
/*  97 */     stringBuffer.append("    .rt           =").append(HexDump.shortToHex(this.rt)).append('\n');
/*  98 */     stringBuffer.append("    .grbitFrt     =").append(HexDump.shortToHex(this.grbitFrt)).append('\n');
/*  99 */     stringBuffer.append("    .verOriginator=").append(HexDump.byteToHex(this.verOriginator)).append('\n');
/* 100 */     stringBuffer.append("    .verWriter    =").append(HexDump.byteToHex(this.verOriginator)).append('\n');
/* 101 */     stringBuffer.append("    .nCFRTIDs     =").append(HexDump.shortToHex(this.rgCFRTID.length)).append('\n');
/* 102 */     stringBuffer.append("[/CHARTFRTINFO]\n");
/* 103 */     return stringBuffer.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\ChartFRTInfoRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */