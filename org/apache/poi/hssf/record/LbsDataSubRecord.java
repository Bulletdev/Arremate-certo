/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.ss.formula.ptg.Ptg;
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.LittleEndianInput;
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
/*     */ public class LbsDataSubRecord
/*     */   extends SubRecord
/*     */ {
/*     */   public static final int sid = 19;
/*     */   private int _cbFContinued;
/*     */   private int _unknownPreFormulaInt;
/*     */   private Ptg _linkPtg;
/*     */   private Byte _unknownPostFormulaByte;
/*     */   private int _cLines;
/*     */   private int _iSel;
/*     */   private int _flags;
/*     */   private int _idEdit;
/*     */   private LbsDropData _dropData;
/*     */   private String[] _rgLines;
/*     */   private boolean[] _bsels;
/*     */   
/*     */   public LbsDataSubRecord(LittleEndianInput paramLittleEndianInput, int paramInt1, int paramInt2) {
/*  97 */     this._cbFContinued = paramInt1;
/*     */     
/*  99 */     int i = paramLittleEndianInput.readUShort();
/* 100 */     if (i > 0) {
/* 101 */       int j = paramLittleEndianInput.readUShort();
/* 102 */       this._unknownPreFormulaInt = paramLittleEndianInput.readInt();
/*     */       
/* 104 */       Ptg[] arrayOfPtg = Ptg.readTokens(j, paramLittleEndianInput);
/* 105 */       if (arrayOfPtg.length != 1) {
/* 106 */         throw new RecordFormatException("Read " + arrayOfPtg.length + " tokens but expected exactly 1");
/*     */       }
/*     */       
/* 109 */       this._linkPtg = arrayOfPtg[0];
/* 110 */       switch (i - j - 6) {
/*     */         case 1:
/* 112 */           this._unknownPostFormulaByte = Byte.valueOf(paramLittleEndianInput.readByte());
/*     */           break;
/*     */         case 0:
/* 115 */           this._unknownPostFormulaByte = null;
/*     */           break;
/*     */         default:
/* 118 */           throw new RecordFormatException("Unexpected leftover bytes");
/*     */       } 
/*     */     
/*     */     } 
/* 122 */     this._cLines = paramLittleEndianInput.readUShort();
/* 123 */     this._iSel = paramLittleEndianInput.readUShort();
/* 124 */     this._flags = paramLittleEndianInput.readUShort();
/* 125 */     this._idEdit = paramLittleEndianInput.readUShort();
/*     */ 
/*     */ 
/*     */     
/* 129 */     if (paramInt2 == 20) {
/* 130 */       this._dropData = new LbsDropData(paramLittleEndianInput);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 135 */     if ((this._flags & 0x2) != 0) {
/* 136 */       this._rgLines = new String[this._cLines];
/* 137 */       for (byte b = 0; b < this._cLines; b++) {
/* 138 */         this._rgLines[b] = StringUtil.readUnicodeString(paramLittleEndianInput);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 147 */     if ((this._flags >> 4 & 0x2) != 0) {
/* 148 */       this._bsels = new boolean[this._cLines];
/* 149 */       for (byte b = 0; b < this._cLines; b++) {
/* 150 */         this._bsels[b] = (paramLittleEndianInput.readByte() == 1);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   LbsDataSubRecord() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static LbsDataSubRecord newAutoFilterInstance() {
/* 166 */     LbsDataSubRecord lbsDataSubRecord = new LbsDataSubRecord();
/* 167 */     lbsDataSubRecord._cbFContinued = 8174;
/* 168 */     lbsDataSubRecord._iSel = 0;
/*     */     
/* 170 */     lbsDataSubRecord._flags = 769;
/* 171 */     lbsDataSubRecord._dropData = new LbsDropData();
/* 172 */     lbsDataSubRecord._dropData._wStyle = 2;
/*     */ 
/*     */     
/* 175 */     lbsDataSubRecord._dropData._cLine = 8;
/* 176 */     return lbsDataSubRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTerminating() {
/* 184 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getDataSize() {
/* 189 */     int i = 2;
/*     */ 
/*     */     
/* 192 */     if (this._linkPtg != null) {
/* 193 */       i += 2;
/* 194 */       i += 4;
/* 195 */       i += this._linkPtg.getSize();
/* 196 */       if (this._unknownPostFormulaByte != null) {
/* 197 */         i++;
/*     */       }
/*     */     } 
/*     */     
/* 201 */     i += 8;
/* 202 */     if (this._dropData != null) {
/* 203 */       i += this._dropData.getDataSize();
/*     */     }
/* 205 */     if (this._rgLines != null) {
/* 206 */       for (String str : this._rgLines) {
/* 207 */         i += StringUtil.getEncodedSize(str);
/*     */       }
/*     */     }
/* 210 */     if (this._bsels != null) {
/* 211 */       i += this._bsels.length;
/*     */     }
/* 213 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 218 */     paramLittleEndianOutput.writeShort(19);
/* 219 */     paramLittleEndianOutput.writeShort(this._cbFContinued);
/*     */     
/* 221 */     if (this._linkPtg == null) {
/* 222 */       paramLittleEndianOutput.writeShort(0);
/*     */     } else {
/* 224 */       int i = this._linkPtg.getSize();
/* 225 */       int j = i + 6;
/* 226 */       if (this._unknownPostFormulaByte != null) {
/* 227 */         j++;
/*     */       }
/* 229 */       paramLittleEndianOutput.writeShort(j);
/* 230 */       paramLittleEndianOutput.writeShort(i);
/* 231 */       paramLittleEndianOutput.writeInt(this._unknownPreFormulaInt);
/* 232 */       this._linkPtg.write(paramLittleEndianOutput);
/* 233 */       if (this._unknownPostFormulaByte != null) {
/* 234 */         paramLittleEndianOutput.writeByte(this._unknownPostFormulaByte.intValue());
/*     */       }
/*     */     } 
/*     */     
/* 238 */     paramLittleEndianOutput.writeShort(this._cLines);
/* 239 */     paramLittleEndianOutput.writeShort(this._iSel);
/* 240 */     paramLittleEndianOutput.writeShort(this._flags);
/* 241 */     paramLittleEndianOutput.writeShort(this._idEdit);
/*     */     
/* 243 */     if (this._dropData != null) {
/* 244 */       this._dropData.serialize(paramLittleEndianOutput);
/*     */     }
/*     */     
/* 247 */     if (this._rgLines != null) {
/* 248 */       for (String str : this._rgLines) {
/* 249 */         StringUtil.writeUnicodeString(paramLittleEndianOutput, str);
/*     */       }
/*     */     }
/*     */     
/* 253 */     if (this._bsels != null) {
/* 254 */       for (boolean bool : this._bsels) {
/* 255 */         paramLittleEndianOutput.writeByte(bool ? 1 : 0);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public LbsDataSubRecord clone() {
/* 263 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 268 */     StringBuffer stringBuffer = new StringBuffer(256);
/*     */     
/* 270 */     stringBuffer.append("[ftLbsData]\n");
/* 271 */     stringBuffer.append("    .unknownShort1 =").append(HexDump.shortToHex(this._cbFContinued)).append("\n");
/* 272 */     stringBuffer.append("    .formula        = ").append('\n');
/* 273 */     if (this._linkPtg != null) {
/* 274 */       stringBuffer.append(this._linkPtg.toString()).append(this._linkPtg.getRVAType()).append('\n');
/*     */     }
/* 276 */     stringBuffer.append("    .nEntryCount   =").append(HexDump.shortToHex(this._cLines)).append("\n");
/* 277 */     stringBuffer.append("    .selEntryIx    =").append(HexDump.shortToHex(this._iSel)).append("\n");
/* 278 */     stringBuffer.append("    .style         =").append(HexDump.shortToHex(this._flags)).append("\n");
/* 279 */     stringBuffer.append("    .unknownShort10=").append(HexDump.shortToHex(this._idEdit)).append("\n");
/* 280 */     if (this._dropData != null) {
/* 281 */       stringBuffer.append('\n').append(this._dropData.toString());
/*     */     }
/* 283 */     stringBuffer.append("[/ftLbsData]\n");
/* 284 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ptg getFormula() {
/* 292 */     return this._linkPtg;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumberOfItems() {
/* 299 */     return this._cLines;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class LbsDropData
/*     */   {
/*     */     public static final int STYLE_COMBO_DROPDOWN = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final int STYLE_COMBO_EDIT_DROPDOWN = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final int STYLE_COMBO_SIMPLE_DROPDOWN = 2;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private int _wStyle;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private int _cLine;
/*     */ 
/*     */ 
/*     */     
/*     */     private int _dxMin;
/*     */ 
/*     */ 
/*     */     
/*     */     private final String _str;
/*     */ 
/*     */ 
/*     */     
/*     */     private Byte _unused;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public LbsDropData() {
/* 346 */       this._str = "";
/* 347 */       this._unused = Byte.valueOf((byte)0);
/*     */     }
/*     */     
/*     */     public LbsDropData(LittleEndianInput param1LittleEndianInput) {
/* 351 */       this._wStyle = param1LittleEndianInput.readUShort();
/* 352 */       this._cLine = param1LittleEndianInput.readUShort();
/* 353 */       this._dxMin = param1LittleEndianInput.readUShort();
/* 354 */       this._str = StringUtil.readUnicodeString(param1LittleEndianInput);
/* 355 */       if (StringUtil.getEncodedSize(this._str) % 2 != 0) {
/* 356 */         this._unused = Byte.valueOf(param1LittleEndianInput.readByte());
/*     */       }
/*     */     }
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
/*     */     public void setStyle(int param1Int) {
/* 373 */       this._wStyle = param1Int;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setNumLines(int param1Int) {
/* 382 */       this._cLine = param1Int;
/*     */     }
/*     */     
/*     */     public void serialize(LittleEndianOutput param1LittleEndianOutput) {
/* 386 */       param1LittleEndianOutput.writeShort(this._wStyle);
/* 387 */       param1LittleEndianOutput.writeShort(this._cLine);
/* 388 */       param1LittleEndianOutput.writeShort(this._dxMin);
/* 389 */       StringUtil.writeUnicodeString(param1LittleEndianOutput, this._str);
/* 390 */       if (this._unused != null) {
/* 391 */         param1LittleEndianOutput.writeByte(this._unused.byteValue());
/*     */       }
/*     */     }
/*     */     
/*     */     public int getDataSize() {
/* 396 */       int i = 6;
/* 397 */       i += StringUtil.getEncodedSize(this._str);
/* 398 */       if (this._unused != null) {
/* 399 */         i++;
/*     */       }
/* 401 */       return i;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 406 */       StringBuffer stringBuffer = new StringBuffer();
/* 407 */       stringBuffer.append("[LbsDropData]\n");
/* 408 */       stringBuffer.append("  ._wStyle:  ").append(this._wStyle).append('\n');
/* 409 */       stringBuffer.append("  ._cLine:  ").append(this._cLine).append('\n');
/* 410 */       stringBuffer.append("  ._dxMin:  ").append(this._dxMin).append('\n');
/* 411 */       stringBuffer.append("  ._str:  ").append(this._str).append('\n');
/* 412 */       if (this._unused != null) {
/* 413 */         stringBuffer.append("  ._unused:  ").append(this._unused).append('\n');
/*     */       }
/* 415 */       stringBuffer.append("[/LbsDropData]\n");
/*     */       
/* 417 */       return stringBuffer.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\LbsDataSubRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */