/*     */ package org.apache.poi.hssf.record.pivottable;
/*     */ 
/*     */ import org.apache.poi.hssf.record.RecordFormatException;
/*     */ import org.apache.poi.hssf.record.RecordInputStream;
/*     */ import org.apache.poi.hssf.record.StandardRecord;
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.LittleEndianOutput;
/*     */ import org.apache.poi.util.StringUtil;
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
/*     */ public final class ExtendedPivotTableViewFieldsRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 256;
/*     */   private static final int STRING_NOT_PRESENT_LEN = 65535;
/*     */   private int _grbit1;
/*     */   private int _grbit2;
/*     */   private int _citmShow;
/*     */   private int _isxdiSort;
/*     */   private int _isxdiShow;
/*     */   private int _reserved1;
/*     */   private int _reserved2;
/*     */   private String _subtotalName;
/*     */   
/*     */   public ExtendedPivotTableViewFieldsRecord(RecordInputStream paramRecordInputStream) {
/*  50 */     this._grbit1 = paramRecordInputStream.readInt();
/*  51 */     this._grbit2 = paramRecordInputStream.readUByte();
/*  52 */     this._citmShow = paramRecordInputStream.readUByte();
/*  53 */     this._isxdiSort = paramRecordInputStream.readUShort();
/*  54 */     this._isxdiShow = paramRecordInputStream.readUShort();
/*     */     
/*  56 */     switch (paramRecordInputStream.remaining()) {
/*     */ 
/*     */       
/*     */       case 0:
/*  60 */         this._reserved1 = 0;
/*  61 */         this._reserved2 = 0;
/*  62 */         this._subtotalName = null;
/*     */         return;
/*     */       
/*     */       case 10:
/*     */         break;
/*     */       default:
/*  68 */         throw new RecordFormatException("Unexpected remaining size (" + paramRecordInputStream.remaining() + ")");
/*     */     } 
/*  70 */     int i = paramRecordInputStream.readUShort();
/*  71 */     this._reserved1 = paramRecordInputStream.readInt();
/*  72 */     this._reserved2 = paramRecordInputStream.readInt();
/*  73 */     if (i != 65535) {
/*  74 */       this._subtotalName = paramRecordInputStream.readUnicodeLEString(i);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  81 */     paramLittleEndianOutput.writeInt(this._grbit1);
/*  82 */     paramLittleEndianOutput.writeByte(this._grbit2);
/*  83 */     paramLittleEndianOutput.writeByte(this._citmShow);
/*  84 */     paramLittleEndianOutput.writeShort(this._isxdiSort);
/*  85 */     paramLittleEndianOutput.writeShort(this._isxdiShow);
/*     */     
/*  87 */     if (this._subtotalName == null) {
/*  88 */       paramLittleEndianOutput.writeShort(65535);
/*     */     } else {
/*  90 */       paramLittleEndianOutput.writeShort(this._subtotalName.length());
/*     */     } 
/*     */     
/*  93 */     paramLittleEndianOutput.writeInt(this._reserved1);
/*  94 */     paramLittleEndianOutput.writeInt(this._reserved2);
/*  95 */     if (this._subtotalName != null) {
/*  96 */       StringUtil.putUnicodeLE(this._subtotalName, paramLittleEndianOutput);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getDataSize() {
/* 103 */     return 20 + ((this._subtotalName == null) ? 0 : (2 * this._subtotalName.length()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 109 */     return 256;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 114 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 116 */     stringBuffer.append("[SXVDEX]\n");
/*     */     
/* 118 */     stringBuffer.append("    .grbit1 =").append(HexDump.intToHex(this._grbit1)).append("\n");
/* 119 */     stringBuffer.append("    .grbit2 =").append(HexDump.byteToHex(this._grbit2)).append("\n");
/* 120 */     stringBuffer.append("    .citmShow =").append(HexDump.byteToHex(this._citmShow)).append("\n");
/* 121 */     stringBuffer.append("    .isxdiSort =").append(HexDump.shortToHex(this._isxdiSort)).append("\n");
/* 122 */     stringBuffer.append("    .isxdiShow =").append(HexDump.shortToHex(this._isxdiShow)).append("\n");
/* 123 */     stringBuffer.append("    .subtotalName =").append(this._subtotalName).append("\n");
/* 124 */     stringBuffer.append("[/SXVDEX]\n");
/* 125 */     return stringBuffer.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\pivottable\ExtendedPivotTableViewFieldsRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */