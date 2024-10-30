/*     */ package org.apache.poi.hssf.record.pivottable;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ public final class ViewFieldsRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 177;
/*     */   private static final int STRING_NOT_PRESENT_LEN = 65535;
/*     */   private static final int BASE_SIZE = 10;
/*     */   private int _sxaxis;
/*     */   private int _cSub;
/*     */   private int _grbitSub;
/*     */   private int _cItm;
/*     */   private String _name;
/*     */   
/*     */   private static final class Axis
/*     */   {
/*     */     public static final int NO_AXIS = 0;
/*     */     public static final int ROW = 1;
/*     */     public static final int COLUMN = 2;
/*     */     public static final int PAGE = 4;
/*     */     public static final int DATA = 8;
/*     */   }
/*     */   
/*     */   public ViewFieldsRecord(RecordInputStream paramRecordInputStream) {
/*  58 */     this._sxaxis = paramRecordInputStream.readShort();
/*  59 */     this._cSub = paramRecordInputStream.readShort();
/*  60 */     this._grbitSub = paramRecordInputStream.readShort();
/*  61 */     this._cItm = paramRecordInputStream.readShort();
/*     */     
/*  63 */     int i = paramRecordInputStream.readUShort();
/*  64 */     if (i != 65535) {
/*  65 */       byte b = paramRecordInputStream.readByte();
/*  66 */       if ((b & 0x1) != 0) {
/*  67 */         this._name = paramRecordInputStream.readUnicodeLEString(i);
/*     */       } else {
/*  69 */         this._name = paramRecordInputStream.readCompressedUnicode(i);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  77 */     paramLittleEndianOutput.writeShort(this._sxaxis);
/*  78 */     paramLittleEndianOutput.writeShort(this._cSub);
/*  79 */     paramLittleEndianOutput.writeShort(this._grbitSub);
/*  80 */     paramLittleEndianOutput.writeShort(this._cItm);
/*     */     
/*  82 */     if (this._name != null) {
/*  83 */       StringUtil.writeUnicodeString(paramLittleEndianOutput, this._name);
/*     */     } else {
/*  85 */       paramLittleEndianOutput.writeShort(65535);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getDataSize() {
/*  91 */     if (this._name == null) {
/*  92 */       return 10;
/*     */     }
/*  94 */     return 11 + this._name.length() * (StringUtil.hasMultibyte(this._name) ? 2 : 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 101 */     return 177;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 106 */     StringBuffer stringBuffer = new StringBuffer();
/* 107 */     stringBuffer.append("[SXVD]\n");
/* 108 */     stringBuffer.append("    .sxaxis    = ").append(HexDump.shortToHex(this._sxaxis)).append('\n');
/* 109 */     stringBuffer.append("    .cSub      = ").append(HexDump.shortToHex(this._cSub)).append('\n');
/* 110 */     stringBuffer.append("    .grbitSub  = ").append(HexDump.shortToHex(this._grbitSub)).append('\n');
/* 111 */     stringBuffer.append("    .cItm      = ").append(HexDump.shortToHex(this._cItm)).append('\n');
/* 112 */     stringBuffer.append("    .name      = ").append(this._name).append('\n');
/*     */     
/* 114 */     stringBuffer.append("[/SXVD]\n");
/* 115 */     return stringBuffer.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\pivottable\ViewFieldsRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */