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
/*     */ public final class FtPioGrbitSubRecord
/*     */   extends SubRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 8;
/*     */   public static final short length = 2;
/*     */   public static final int AUTO_PICT_BIT = 1;
/*     */   public static final int DDE_BIT = 2;
/*     */   public static final int PRINT_CALC_BIT = 4;
/*     */   public static final int ICON_BIT = 8;
/*     */   public static final int CTL_BIT = 16;
/*     */   public static final int PRSTM_BIT = 32;
/*     */   public static final int CAMERA_BIT = 128;
/*     */   public static final int DEFAULT_SIZE_BIT = 256;
/*     */   public static final int AUTO_LOAD_BIT = 512;
/*  85 */   private short flags = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FtPioGrbitSubRecord(LittleEndianInput paramLittleEndianInput, int paramInt) {
/*  95 */     if (paramInt != 2) {
/*  96 */       throw new RecordFormatException("Unexpected size (" + paramInt + ")");
/*     */     }
/*  98 */     this.flags = paramLittleEndianInput.readShort();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFlagByBit(int paramInt, boolean paramBoolean) {
/* 107 */     if (paramBoolean) {
/* 108 */       this.flags = (short)(this.flags | paramInt);
/*     */     } else {
/* 110 */       this.flags = (short)(this.flags & (0xFFFF ^ paramInt));
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean getFlagByBit(int paramInt) {
/* 115 */     return ((this.flags & paramInt) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 123 */     StringBuffer stringBuffer = new StringBuffer();
/* 124 */     stringBuffer.append("[FtPioGrbit ]\n");
/* 125 */     stringBuffer.append("  size     = ").append(2).append("\n");
/* 126 */     stringBuffer.append("  flags    = ").append(HexDump.toHex(this.flags)).append("\n");
/* 127 */     stringBuffer.append("[/FtPioGrbit ]\n");
/* 128 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 137 */     paramLittleEndianOutput.writeShort(8);
/* 138 */     paramLittleEndianOutput.writeShort(2);
/* 139 */     paramLittleEndianOutput.writeShort(this.flags);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 143 */     return 2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 151 */     return 8;
/*     */   }
/*     */ 
/*     */   
/*     */   public FtPioGrbitSubRecord clone() {
/* 156 */     FtPioGrbitSubRecord ftPioGrbitSubRecord = new FtPioGrbitSubRecord();
/* 157 */     ftPioGrbitSubRecord.flags = this.flags;
/* 158 */     return ftPioGrbitSubRecord;
/*     */   }
/*     */   
/*     */   public short getFlags() {
/* 162 */     return this.flags;
/*     */   }
/*     */   
/*     */   public void setFlags(short paramShort) {
/* 166 */     this.flags = paramShort;
/*     */   }
/*     */   
/*     */   public FtPioGrbitSubRecord() {}
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\FtPioGrbitSubRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */