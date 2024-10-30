/*     */ package org.apache.poi.hssf.record;
/*     */ 
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
/*     */ public final class FtCfSubRecord
/*     */   extends SubRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 7;
/*     */   public static final short length = 2;
/*     */   public static final short METAFILE_BIT = 2;
/*     */   public static final short BITMAP_BIT = 9;
/*     */   public static final short UNSPECIFIED_BIT = -1;
/*  48 */   private short flags = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FtCfSubRecord(LittleEndianInput paramLittleEndianInput, int paramInt) {
/*  58 */     if (paramInt != 2) {
/*  59 */       throw new RecordFormatException("Unexpected size (" + paramInt + ")");
/*     */     }
/*  61 */     this.flags = paramLittleEndianInput.readShort();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  69 */     StringBuffer stringBuffer = new StringBuffer();
/*  70 */     stringBuffer.append("[FtCf ]\n");
/*  71 */     stringBuffer.append("  size     = ").append(2).append("\n");
/*  72 */     stringBuffer.append("  flags    = ").append(HexDump.toHex(this.flags)).append("\n");
/*  73 */     stringBuffer.append("[/FtCf ]\n");
/*  74 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  83 */     paramLittleEndianOutput.writeShort(7);
/*  84 */     paramLittleEndianOutput.writeShort(2);
/*  85 */     paramLittleEndianOutput.writeShort(this.flags);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/*  89 */     return 2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getSid() {
/*  97 */     return 7;
/*     */   }
/*     */ 
/*     */   
/*     */   public FtCfSubRecord clone() {
/* 102 */     FtCfSubRecord ftCfSubRecord = new FtCfSubRecord();
/* 103 */     ftCfSubRecord.flags = this.flags;
/* 104 */     return ftCfSubRecord;
/*     */   }
/*     */   
/*     */   public short getFlags() {
/* 108 */     return this.flags;
/*     */   }
/*     */   
/*     */   public void setFlags(short paramShort) {
/* 112 */     this.flags = paramShort;
/*     */   }
/*     */   
/*     */   public FtCfSubRecord() {}
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\FtCfSubRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */